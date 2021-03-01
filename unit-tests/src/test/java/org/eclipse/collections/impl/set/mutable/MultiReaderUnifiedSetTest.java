/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.UnsortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderUnifiedSetTest extends MultiReaderMutableCollectionTestCase {

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        return MultiReaderUnifiedSet.newSetWith(littleElements);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void largeCollectionStreamToBagMultimap() {
        super.largeCollectionStreamToBagMultimap();
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableSet.class, MultiReaderUnifiedSet.newSet().asSynchronized());
    }

    @Override
    @Test
    public void select() {
        super.select();
        Verify.assertContainsAll(MultiReaderUnifiedSet.newSetWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3)), 1, 2);
        Verify.assertContainsAll(MultiReaderUnifiedSet.newSetWith(-1, 2, 3, 4, 5).select(Predicates.lessThan(3), FastList.newList()), -1, 2);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        Verify.assertContainsAll(MultiReaderUnifiedSet.newSetWith(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(MultiReaderUnifiedSet.newSetWith(1, 2, 3, 4).reject(Predicates.lessThan(3), FastList.newList()), 3, 4);
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test
    public void iterator() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> MultiReaderUnifiedSet.newSet().iterator());
    }

    @Test
    public void unifiedSetToString() {
        MutableSet<Integer> set = MultiReaderUnifiedSet.newSetWith(1, 2);
        String s = set.toString();
        Assert.assertTrue("[1, 2]".equals(s) || "[2, 1]".equals(s));
    }

    @Override
    @Test
    public void isEmpty() {
        MultiReaderUnifiedSet<String> set = MultiReaderUnifiedSet.newSet();
        this.assertIsEmpty(true, set);
        set.add("stuff");
        this.assertIsEmpty(false, set);
        set.remove("stuff");
        this.assertIsEmpty(true, set);
        set.add("Bon");
        set.add("Jovi");
        this.assertIsEmpty(false, set);
        set.remove("Jovi");
        this.assertIsEmpty(false, set);
        set.clear();
        this.assertIsEmpty(true, set);
    }

    private void assertIsEmpty(boolean isEmpty, MultiReaderUnifiedSet<?> set) {
        Assert.assertEquals(isEmpty, set.isEmpty());
        Assert.assertEquals(!isEmpty, set.notEmpty());
    }

    @Override
    @Test
    public void testToString() {
        MutableCollection<Object> collection = this.newWith(1, 2);
        Assert.assertTrue("[1, 2]".equals(collection.toString()) || "[2, 1]".equals(collection.toString()));
    }

    @Override
    @Test
    public void makeString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Override
    @Test
    public void appendString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableSet.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void union() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> union = set.union(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.union(UnifiedSet.newSetWith("1")));
    }

    @Test
    public void unionInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> union = set.unionInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.unionInto(UnifiedSet.newSetWith("1"), UnifiedSet.newSet()));
    }

    @Test
    public void intersect() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> intersect = set.intersect(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersect(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void intersectInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> intersect = set.intersectInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersectInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void difference() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void differenceInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void symmetricDifference() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> difference = set.symmetricDifference(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"));
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void symmetricDifferenceInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<String> difference = set.symmetricDifferenceInto(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"), UnifiedSet.newSet());
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void isSubsetOf() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        Assert.assertTrue(set.isSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
    }

    @Test
    public void isProperSubsetOf() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        Assert.assertTrue(set.isProperSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
        Assert.assertFalse(set.isProperSubsetOf(set));
    }

    @Test
    public void powerSet() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        MutableSet<UnsortedSetIterable<String>> powerSet = set.powerSet();
        Verify.assertSize((int) StrictMath.pow(2, set.size()), powerSet);
        Verify.assertContains(UnifiedSet.<String>newSet(), powerSet);
        Verify.assertContains(set, powerSet);
    }

    @Test
    public void cartesianProduct() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4");
        LazyIterable<Pair<String, String>> cartesianProduct = set.cartesianProduct(UnifiedSet.newSetWith("One", "Two"));
        Verify.assertIterableSize(set.size() * 2, cartesianProduct);
        Assert.assertEquals(set, cartesianProduct.select(Predicates.attributeEqual((Function<Pair<?, String>, String>) Pair::getTwo, "One")).collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
    }

    @Override
    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = AtomicInteger::new;
        MutableCollection<Integer> collection = this.newWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, AtomicInteger::addAndGet);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Override
    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = () -> 0;
        Function2<Integer, Integer, Integer> sumAggregator = (integer1, integer2) -> integer1 + integer2;
        MutableCollection<Integer> collection = this.newWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void withReadLockAndDelegate() {
        MultiReaderUnifiedSet<Integer> set = MultiReaderUnifiedSet.newSetWith(1);
        Object[] result = new Object[1];
        set.withReadLockAndDelegate(delegate -> {
            result[0] = delegate.getFirst();
            this.verifyDelegateIsUnmodifiable(delegate);
        });
        Assert.assertNotNull(result[0]);
    }

    @Test
    public void withWriteLockAndDelegate() {
        MultiReaderUnifiedSet<Integer> set = MultiReaderUnifiedSet.newSetWith(2);
        AtomicReference<MutableSet<?>> delegateList = new AtomicReference<>();
        AtomicReference<Iterator<?>> iterator = new AtomicReference<>();
        set.withWriteLockAndDelegate(delegate -> {
            delegate.add(1);
            delegate.add(2);
            delegate.add(3);
            delegate.add(4);
            delegateList.set(delegate);
            iterator.set(delegate.iterator());
        });
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), set);
        Assert.assertThrows(NullPointerException.class, () -> iterator.get().hasNext());
        Assert.assertThrows(NullPointerException.class, () -> delegateList.get().iterator());
    }

    private void verifyDelegateIsUnmodifiable(MutableSet<Integer> delegate) {
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.add(2));
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.remove(0));
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(1, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 5), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(3, 4, null, 1, 2).toSortedBag();
    }

    @Override
    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::largeCollectionStreamToBagMultimap, this.description("largeCollectionStreamToBagMultimap"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unifiedSetToString, this.description("unifiedSetToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::union, this.description("union"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unionInto, this.description("unionInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersect, this.description("intersect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersectInto, this.description("intersectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::difference, this.description("difference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::differenceInto, this.description("differenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifference, this.description("symmetricDifference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifferenceInto, this.description("symmetricDifferenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isSubsetOf, this.description("isSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isProperSubsetOf, this.description("isProperSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::powerSet, this.description("powerSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProduct, this.description("cartesianProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByMutating, this.description("aggregateByMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByNonMutating, this.description("aggregateByNonMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withReadLockAndDelegate() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withReadLockAndDelegate, this.description("withReadLockAndDelegate"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withWriteLockAndDelegate() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withWriteLockAndDelegate, this.description("withWriteLockAndDelegate"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_natural_ordering, this.description("toSortedBag_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_with_comparator, this.description("toSortedBag_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::toSortedBag_with_null, this.description("toSortedBag_with_null"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        private MultiReaderUnifiedSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderUnifiedSetTest();
        }

        @java.lang.Override
        public MultiReaderUnifiedSetTest implementation() {
            return this.implementation;
        }
    }
}
