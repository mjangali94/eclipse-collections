/*
 * Copyright (c) 2021 Goldman Sachs and others.
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
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
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
    @Test
    public void toImmutableSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBag(Collections.reverseOrder());
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
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderUnifiedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_spliterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.spliterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withReadLockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withReadLockAndDelegate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withWriteLockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withWriteLockAndDelegate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderUnifiedSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> spliterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> stream_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> parallelStream_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> withReadLockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> withWriteLockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetTest> toSortedBagBy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderUnifiedSetTest::testNewCollection;
            this.payloads.equalsAndHashCode = MultiReaderUnifiedSetTest::equalsAndHashCode;
            this.payloads.contains = MultiReaderUnifiedSetTest::contains;
            this.payloads.containsBy = MultiReaderUnifiedSetTest::containsBy;
            this.payloads.containsAllIterable = MultiReaderUnifiedSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderUnifiedSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderUnifiedSetTest::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderUnifiedSetTest::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderUnifiedSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderUnifiedSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderUnifiedSetTest::containsAllCollection;
            this.payloads.tap = MultiReaderUnifiedSetTest::tap;
            this.payloads.forEach = MultiReaderUnifiedSetTest::forEach;
            this.payloads.forEachWith = MultiReaderUnifiedSetTest::forEachWith;
            this.payloads.forEachWithIndex = MultiReaderUnifiedSetTest::forEachWithIndex;
            this.payloads.selectWith = MultiReaderUnifiedSetTest::selectWith;
            this.payloads.selectWith_target = MultiReaderUnifiedSetTest::selectWith_target;
            this.payloads.rejectWith = MultiReaderUnifiedSetTest::rejectWith;
            this.payloads.rejectWith_target = MultiReaderUnifiedSetTest::rejectWith_target;
            this.payloads.selectInstancesOf = MultiReaderUnifiedSetTest::selectInstancesOf;
            this.payloads.collect = MultiReaderUnifiedSetTest::collect;
            this.payloads.collectTarget = MultiReaderUnifiedSetTest::collectTarget;
            this.payloads.collectBoolean = MultiReaderUnifiedSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderUnifiedSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderUnifiedSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderUnifiedSetTest::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderUnifiedSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderUnifiedSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderUnifiedSetTest::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderUnifiedSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderUnifiedSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderUnifiedSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderUnifiedSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderUnifiedSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderUnifiedSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderUnifiedSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderUnifiedSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderUnifiedSetTest::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderUnifiedSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderUnifiedSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderUnifiedSetTest::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderUnifiedSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderUnifiedSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderUnifiedSetTest::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderUnifiedSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderUnifiedSetTest::collectShortWithBagTarget;
            this.payloads.flatCollect = MultiReaderUnifiedSetTest::flatCollect;
            this.payloads.flatCollectWith = MultiReaderUnifiedSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderUnifiedSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderUnifiedSetTest::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderUnifiedSetTest::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderUnifiedSetTest::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderUnifiedSetTest::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderUnifiedSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderUnifiedSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderUnifiedSetTest::flatCollectFloat;
            this.payloads.detect = MultiReaderUnifiedSetTest::detect;
            this.payloads.detectOptional = MultiReaderUnifiedSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderUnifiedSetTest::min;
            this.payloads.minOptional = MultiReaderUnifiedSetTest::minOptional;
            this.payloads.max = MultiReaderUnifiedSetTest::max;
            this.payloads.maxOptional = MultiReaderUnifiedSetTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderUnifiedSetTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderUnifiedSetTest::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderUnifiedSetTest::min_null_safe;
            this.payloads.max_null_safe = MultiReaderUnifiedSetTest::max_null_safe;
            this.payloads.minBy = MultiReaderUnifiedSetTest::minBy;
            this.payloads.minByOptional = MultiReaderUnifiedSetTest::minByOptional;
            this.payloads.maxBy = MultiReaderUnifiedSetTest::maxBy;
            this.payloads.maxByOptional = MultiReaderUnifiedSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MultiReaderUnifiedSetTest::detectWith;
            this.payloads.detectWithOptional = MultiReaderUnifiedSetTest::detectWithOptional;
            this.payloads.detectIfNone = MultiReaderUnifiedSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MultiReaderUnifiedSetTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MultiReaderUnifiedSetTest::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderUnifiedSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderUnifiedSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderUnifiedSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = MultiReaderUnifiedSetTest::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderUnifiedSetTest::anySatisfyWith;
            this.payloads.count = MultiReaderUnifiedSetTest::count;
            this.payloads.countWith = MultiReaderUnifiedSetTest::countWith;
            this.payloads.collectIf = MultiReaderUnifiedSetTest::collectIf;
            this.payloads.collectWith = MultiReaderUnifiedSetTest::collectWith;
            this.payloads.collectWith_target = MultiReaderUnifiedSetTest::collectWith_target;
            this.payloads.getAny = MultiReaderUnifiedSetTest::getAny;
            this.payloads.getOnly = MultiReaderUnifiedSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MultiReaderUnifiedSetTest::injectInto;
            this.payloads.injectIntoInt = MultiReaderUnifiedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderUnifiedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderUnifiedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderUnifiedSetTest::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderUnifiedSetTest::sumFloat;
            this.payloads.summarizeFloat = MultiReaderUnifiedSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderUnifiedSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderUnifiedSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderUnifiedSetTest::sumDouble;
            this.payloads.summarizeDouble = MultiReaderUnifiedSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderUnifiedSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderUnifiedSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderUnifiedSetTest::sumInteger;
            this.payloads.summarizeInt = MultiReaderUnifiedSetTest::summarizeInt;
            this.payloads.sumLong = MultiReaderUnifiedSetTest::sumLong;
            this.payloads.summarizeLong = MultiReaderUnifiedSetTest::summarizeLong;
            this.payloads.sumByInt = MultiReaderUnifiedSetTest::sumByInt;
            this.payloads.sumByFloat = MultiReaderUnifiedSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderUnifiedSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderUnifiedSetTest::sumByLong;
            this.payloads.sumByDouble = MultiReaderUnifiedSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderUnifiedSetTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = MultiReaderUnifiedSetTest::toArray;
            this.payloads.partition = MultiReaderUnifiedSetTest::partition;
            this.payloads.partitionWith = MultiReaderUnifiedSetTest::partitionWith;
            this.payloads.toList = MultiReaderUnifiedSetTest::toList;
            this.payloads.toImmutableList = MultiReaderUnifiedSetTest::toImmutableList;
            this.payloads.toCollection = MultiReaderUnifiedSetTest::toCollection;
            this.payloads.toBag = MultiReaderUnifiedSetTest::toBag;
            this.payloads.toImmutableBag = MultiReaderUnifiedSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderUnifiedSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderUnifiedSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderUnifiedSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderUnifiedSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderUnifiedSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = MultiReaderUnifiedSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderUnifiedSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderUnifiedSetTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderUnifiedSetTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderUnifiedSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderUnifiedSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderUnifiedSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderUnifiedSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderUnifiedSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = MultiReaderUnifiedSetTest::toSet;
            this.payloads.toImmutableSet = MultiReaderUnifiedSetTest::toImmutableSet;
            this.payloads.toMap = MultiReaderUnifiedSetTest::toMap;
            this.payloads.toImmutableMap = MultiReaderUnifiedSetTest::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderUnifiedSetTest::toMapTarget;
            this.payloads.toSortedMap = MultiReaderUnifiedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderUnifiedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderUnifiedSetTest::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderUnifiedSetTest::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderUnifiedSetTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = MultiReaderUnifiedSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderUnifiedSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MultiReaderUnifiedSetTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = MultiReaderUnifiedSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderUnifiedSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MultiReaderUnifiedSetTest::appendStringThrows;
            this.payloads.countBy = MultiReaderUnifiedSetTest::countBy;
            this.payloads.countByWith = MultiReaderUnifiedSetTest::countByWith;
            this.payloads.countByEach = MultiReaderUnifiedSetTest::countByEach;
            this.payloads.groupBy = MultiReaderUnifiedSetTest::groupBy;
            this.payloads.groupByEach = MultiReaderUnifiedSetTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderUnifiedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderUnifiedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderUnifiedSetTest::zip;
            this.payloads.zipWithIndex = MultiReaderUnifiedSetTest::zipWithIndex;
            this.payloads.chunk = MultiReaderUnifiedSetTest::chunk;
            this.payloads.chunk_empty = MultiReaderUnifiedSetTest::chunk_empty;
            this.payloads.chunk_single = MultiReaderUnifiedSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderUnifiedSetTest::chunk_large_size;
            this.payloads.empty = MultiReaderUnifiedSetTest::empty;
            this.payloads.notEmpty = MultiReaderUnifiedSetTest::notEmpty;
            this.payloads.reduceOptional = MultiReaderUnifiedSetTest::reduceOptional;
            this.payloads.newEmpty = MultiReaderUnifiedSetTest::newEmpty;
            this.payloads.toImmutable = MultiReaderUnifiedSetTest::toImmutable;
            this.payloads.testNewWith = MultiReaderUnifiedSetTest::testNewWith;
            this.payloads.testNewWithWith = MultiReaderUnifiedSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderUnifiedSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderUnifiedSetTest::testNewWithVarArgs;
            this.payloads.addAll = MultiReaderUnifiedSetTest::addAll;
            this.payloads.addAllIterable = MultiReaderUnifiedSetTest::addAllIterable;
            this.payloads.removeAll = MultiReaderUnifiedSetTest::removeAll;
            this.payloads.removeAllIterable = MultiReaderUnifiedSetTest::removeAllIterable;
            this.payloads.retainAll = MultiReaderUnifiedSetTest::retainAll;
            this.payloads.retainAllIterable = MultiReaderUnifiedSetTest::retainAllIterable;
            this.payloads.clear = MultiReaderUnifiedSetTest::clear;
            this.payloads.injectIntoWith = MultiReaderUnifiedSetTest::injectIntoWith;
            this.payloads.removeObject = MultiReaderUnifiedSetTest::removeObject;
            this.payloads.selectAndRejectWith = MultiReaderUnifiedSetTest::selectAndRejectWith;
            this.payloads.removeIf = MultiReaderUnifiedSetTest::removeIf;
            this.payloads.removeIfWith = MultiReaderUnifiedSetTest::removeIfWith;
            this.payloads.with = MultiReaderUnifiedSetTest::with;
            this.payloads.withAll = MultiReaderUnifiedSetTest::withAll;
            this.payloads.without = MultiReaderUnifiedSetTest::without;
            this.payloads.withoutAll = MultiReaderUnifiedSetTest::withoutAll;
            this.payloads.asLazy = MultiReaderUnifiedSetTest::asLazy;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::iterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.spliterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::spliterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.stream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::stream_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.parallelStream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::parallelStream_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.largeCollectionStreamToBagMultimap = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::largeCollectionStreamToBagMultimap, java.lang.UnsupportedOperationException.class);
            this.payloads.asSynchronized = MultiReaderUnifiedSetTest::asSynchronized;
            this.payloads.select = MultiReaderUnifiedSetTest::select;
            this.payloads.reject = MultiReaderUnifiedSetTest::reject;
            this.payloads.getFirst = MultiReaderUnifiedSetTest::getFirst;
            this.payloads.getLast = MultiReaderUnifiedSetTest::getLast;
            this.payloads.iterator = MultiReaderUnifiedSetTest::iterator;
            this.payloads.unifiedSetToString = MultiReaderUnifiedSetTest::unifiedSetToString;
            this.payloads.isEmpty = MultiReaderUnifiedSetTest::isEmpty;
            this.payloads.testToString = MultiReaderUnifiedSetTest::testToString;
            this.payloads.makeString = MultiReaderUnifiedSetTest::makeString;
            this.payloads.appendString = MultiReaderUnifiedSetTest::appendString;
            this.payloads.asUnmodifiable = MultiReaderUnifiedSetTest::asUnmodifiable;
            this.payloads.union = MultiReaderUnifiedSetTest::union;
            this.payloads.unionInto = MultiReaderUnifiedSetTest::unionInto;
            this.payloads.intersect = MultiReaderUnifiedSetTest::intersect;
            this.payloads.intersectInto = MultiReaderUnifiedSetTest::intersectInto;
            this.payloads.difference = MultiReaderUnifiedSetTest::difference;
            this.payloads.differenceInto = MultiReaderUnifiedSetTest::differenceInto;
            this.payloads.symmetricDifference = MultiReaderUnifiedSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = MultiReaderUnifiedSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = MultiReaderUnifiedSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = MultiReaderUnifiedSetTest::isProperSubsetOf;
            this.payloads.powerSet = MultiReaderUnifiedSetTest::powerSet;
            this.payloads.cartesianProduct = MultiReaderUnifiedSetTest::cartesianProduct;
            this.payloads.aggregateByMutating = MultiReaderUnifiedSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderUnifiedSetTest::aggregateByNonMutating;
            this.payloads.withReadLockAndDelegate = MultiReaderUnifiedSetTest::withReadLockAndDelegate;
            this.payloads.withWriteLockAndDelegate = MultiReaderUnifiedSetTest::withWriteLockAndDelegate;
            this.payloads.toSortedBag_natural_ordering = MultiReaderUnifiedSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderUnifiedSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderUnifiedSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderUnifiedSetTest::toSortedBagBy;
        }
    }
}
