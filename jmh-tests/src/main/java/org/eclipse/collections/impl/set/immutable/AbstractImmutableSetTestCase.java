/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import java.util.Collections;
import java.util.List;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.set.ImmutableSetMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.UnsortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.immutable.AbstractImmutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableSetTestCase extends AbstractImmutableCollectionTestCase {

    @Override
    protected abstract ImmutableSet<Integer> classUnderTest();

    @Override
    protected <T> MutableSet<T> newMutable() {
        return UnifiedSet.newSet();
    }

    @Test
    public void equalsAndHashCode() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        MutableSet<Integer> mutable = UnifiedSet.newSet(immutable);
        Verify.assertEqualsAndHashCode(immutable, mutable);
        Verify.assertPostSerializedEqualsAndHashCode(immutable);
        Assert.assertNotEquals(immutable, FastList.newList(mutable));
    }

    @Test
    public void newWith() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Assert.assertSame(immutable, immutable.newWith(immutable.size()));
        Verify.assertSize(immutable.size() + 1, immutable.newWith(immutable.size() + 1).castToSet());
    }

    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(Math.max(0, immutable.size() - 1), immutable.newWithout(immutable.size()).castToSet());
        Verify.assertSize(immutable.size(), immutable.newWithout(immutable.size() + 1).castToSet());
    }

    @Test
    public void newWithAll() {
        ImmutableSet<Integer> set = this.classUnderTest();
        ImmutableSet<Integer> withAll = set.newWithAll(UnifiedSet.newSetWith(0));
        Assert.assertNotEquals(set, withAll);
        Assert.assertEquals(UnifiedSet.newSet(set).with(0), withAll);
    }

    @Test
    public void newWithoutAll() {
        ImmutableSet<Integer> set = this.classUnderTest();
        ImmutableSet<Integer> withoutAll = set.newWithoutAll(UnifiedSet.newSet(this.classUnderTest()));
        Assert.assertEquals(Sets.immutable.<Integer>of(), withoutAll);
        ImmutableSet<Integer> largeWithoutAll = set.newWithoutAll(Interval.fromTo(101, 150));
        Assert.assertEquals(set, largeWithoutAll);
        ImmutableSet<Integer> largeWithoutAll2 = set.newWithoutAll(UnifiedSet.newSet(Interval.fromTo(151, 199)));
        Assert.assertEquals(set, largeWithoutAll2);
        ImmutableSet<Integer> largeWithoutAll3 = set.newWithoutAll(FastList.newList(Interval.fromTo(151, 199)));
        Assert.assertEquals(set, largeWithoutAll3);
    }

    @Test
    public void contains() {
        ImmutableSet<Integer> set = this.classUnderTest();
        for (int i = 1; i <= set.size(); i++) {
            Assert.assertTrue(set.contains(i));
        }
        Assert.assertFalse(set.contains(set.size() + 1));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAllArguments(this.classUnderTest().toArray()));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(this.classUnderTest()));
    }

    @Test
    public void forEach() {
        MutableSet<Integer> result = UnifiedSet.newSet();
        ImmutableSet<Integer> collection = this.classUnderTest();
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(collection, result);
    }

    @Test
    public void forEachWith() {
        MutableCollection<Integer> result = UnifiedSet.newSet();
        this.classUnderTest().forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Assert.assertEquals(this.classUnderTest(), result);
    }

    @Test
    public void forEachWithIndex() {
        MutableCollection<Integer> result = UnifiedSet.newSet();
        this.classUnderTest().forEachWithIndex((object, index) -> result.add(object));
        Assert.assertEquals(this.classUnderTest(), result);
    }

    @Test
    public void select_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.select(Predicates.lessThan(integers.size() + 1), UnifiedSet.newSet()));
        Verify.assertEmpty(integers.select(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Test
    public void reject_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Verify.assertEmpty(integers.reject(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Assert.assertEquals(integers, integers.reject(Predicates.greaterThan(integers.size()), UnifiedSet.newSet()));
    }

    @Test
    public void flatCollectWithTarget() {
        MutableCollection<String> actual = this.classUnderTest().flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)), UnifiedSet.newSet());
        ImmutableCollection<String> expected = this.classUnderTest().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zip() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(immutableCollection.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableCollection.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(immutableCollection.size() - 1, null);
        ImmutableCollection<Pair<Integer, Object>> pairs = immutableCollection.zip(nulls);
        Assert.assertEquals(immutableCollection, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableCollection<Pair<Integer, Object>> pairsPlusOne = immutableCollection.zip(nullsPlusOne);
        Assert.assertEquals(immutableCollection, pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableCollection<Pair<Integer, Object>> pairsMinusOne = immutableCollection.zip(nullsMinusOne);
        Assert.assertEquals(immutableCollection.size() - 1, pairsMinusOne.size());
        Assert.assertTrue(immutableCollection.containsAllIterable(pairsMinusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne)));
        Assert.assertEquals(immutableCollection.zip(nulls), immutableCollection.zip(nulls, UnifiedSet.newSet()));
    }

    @Test
    public void zipWithIndex() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        ImmutableCollection<Pair<Integer, Integer>> pairs = immutableCollection.zipWithIndex();
        Assert.assertEquals(immutableCollection, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(Interval.zeroTo(immutableCollection.size() - 1).toSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableCollection.zipWithIndex(), immutableCollection.zipWithIndex(UnifiedSet.newSet()));
    }

    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().chunk(10).getFirst());
        Verify.assertInstanceOf(ImmutableSet.class, this.classUnderTest().chunk(10).getFirst());
    }

    @Test
    public void collectIfWithTarget() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru(), UnifiedSet.newSet()));
    }

    @Test
    public void toList() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableList<Integer> list = integers.toList();
        Verify.assertEqualsAndHashCode(FastList.newList(integers), list);
    }

    @Test
    public void toSortedListBy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        MutableList<Integer> list = integers.toSortedListBy(String::valueOf);
        Assert.assertEquals(this.classUnderTest().toList(), list);
    }

    @Test
    public void groupBy() {
        ImmutableSet<Integer> undertest = this.classUnderTest();
        ImmutableSetMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru());
        UnifiedSetMultimap<Integer, Integer> expected = UnifiedSet.newSet(undertest).groupBy(Functions.getPassThru());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByEach() {
        ImmutableSet<Integer> undertest = this.classUnderTest();
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        ImmutableSetMultimap<Integer, Integer> actual = undertest.groupByEach(function);
        UnifiedSetMultimap<Integer, Integer> expected = UnifiedSet.newSet(undertest).groupByEach(function);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByWithTarget() {
        ImmutableSet<Integer> undertest = this.classUnderTest();
        UnifiedSetMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru(), UnifiedSetMultimap.newMultimap());
        UnifiedSetMultimap<Integer, Integer> expected = UnifiedSet.newSet(undertest).groupBy(Functions.getPassThru());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByEachWithTarget() {
        ImmutableSet<Integer> undertest = this.classUnderTest();
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        UnifiedSetMultimap<Integer, Integer> actual = undertest.groupByEach(function, UnifiedSetMultimap.newMultimap());
        UnifiedSetMultimap<Integer, Integer> expected = UnifiedSet.newSet(undertest).groupByEach(function);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void union() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        ImmutableSet<String> union = set.union(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.union(UnifiedSet.newSetWith("1")));
    }

    @Test
    public void unionInto() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        MutableSet<String> union = set.unionInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.unionInto(UnifiedSet.newSetWith("1"), UnifiedSet.newSet()));
    }

    @Test
    public void intersect() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        ImmutableSet<String> intersect = set.intersect(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertIterableEmpty(set.intersect(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void intersectInto() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        MutableSet<String> intersect = set.intersectInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersectInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void difference() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        ImmutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void differenceInto() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void symmetricDifference() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        ImmutableSet<String> difference = set.symmetricDifference(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"));
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void symmetricDifferenceInto() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
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
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        Assert.assertTrue(set.isSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
    }

    @Test
    public void isProperSubsetOf() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        Assert.assertTrue(set.isProperSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
        Assert.assertFalse(set.isProperSubsetOf(set));
    }

    @Test
    public void powerSet() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        ImmutableSet<UnsortedSetIterable<String>> powerSet = set.powerSet();
        Verify.assertSize((int) StrictMath.pow(2, set.size()), powerSet);
        Verify.assertContains(UnifiedSet.<String>newSet(), powerSet);
        Verify.assertContains(set, powerSet);
        Verify.assertInstanceOf(ImmutableSet.class, powerSet.getFirst());
        Verify.assertInstanceOf(ImmutableSet.class, powerSet.getLast());
    }

    @Test
    public void cartesianProduct() {
        ImmutableSet<String> set = this.classUnderTest().collect(String::valueOf);
        LazyIterable<Pair<String, String>> cartesianProduct = set.cartesianProduct(UnifiedSet.newSetWith("One", "Two"));
        Verify.assertIterableSize(set.size() * 2, cartesianProduct);
        Assert.assertEquals(set, cartesianProduct.select(Predicates.attributeEqual((Function<Pair<?, String>, String>) Pair::getTwo, "One")).collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
    }

    @Test
    public void toImmutable() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        ImmutableSet<Integer> actual = integers.toImmutable();
        Assert.assertEquals(integers, actual);
        Assert.assertSame(integers, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSetTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = AbstractImmutableSetTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableSetTestCase::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = AbstractImmutableSetTestCase::countBy;
            this.payloads.countByWith = AbstractImmutableSetTestCase::countByWith;
            this.payloads.countByEach = AbstractImmutableSetTestCase::countByEach;
            this.payloads.selectWith = AbstractImmutableSetTestCase::selectWith;
            this.payloads.selectWith_target = AbstractImmutableSetTestCase::selectWith_target;
            this.payloads.rejectWith = AbstractImmutableSetTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractImmutableSetTestCase::rejectWith_target;
            this.payloads.partition = AbstractImmutableSetTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableSetTestCase::partitionWith;
            this.payloads.collectWith = AbstractImmutableSetTestCase::collectWith;
            this.payloads.collect_target = AbstractImmutableSetTestCase::collect_target;
            this.payloads.collectWith_target = AbstractImmutableSetTestCase::collectWith_target;
            this.payloads.injectInto = AbstractImmutableSetTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractImmutableSetTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractImmutableSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableSetTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractImmutableSetTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractImmutableSetTestCase::sumFloat;
            this.payloads.sumDouble = AbstractImmutableSetTestCase::sumDouble;
            this.payloads.sumInteger = AbstractImmutableSetTestCase::sumInteger;
            this.payloads.sumLong = AbstractImmutableSetTestCase::sumLong;
            this.payloads.sumByInt = AbstractImmutableSetTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableSetTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractImmutableSetTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractImmutableSetTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableSetTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractImmutableSetTestCase::sumByDoubleConsistentRounding;
            this.payloads.makeString = AbstractImmutableSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableSetTestCase::appendString;
            this.payloads.testToString = AbstractImmutableSetTestCase::testToString;
            this.payloads.select = AbstractImmutableSetTestCase::select;
            this.payloads.selectInstancesOf = AbstractImmutableSetTestCase::selectInstancesOf;
            this.payloads.reject = AbstractImmutableSetTestCase::reject;
            this.payloads.collect = AbstractImmutableSetTestCase::collect;
            this.payloads.collectBoolean = AbstractImmutableSetTestCase::collectBoolean;
            this.payloads.collectByte = AbstractImmutableSetTestCase::collectByte;
            this.payloads.collectChar = AbstractImmutableSetTestCase::collectChar;
            this.payloads.collectDouble = AbstractImmutableSetTestCase::collectDouble;
            this.payloads.collectFloat = AbstractImmutableSetTestCase::collectFloat;
            this.payloads.collectInt = AbstractImmutableSetTestCase::collectInt;
            this.payloads.collectLong = AbstractImmutableSetTestCase::collectLong;
            this.payloads.collectShort = AbstractImmutableSetTestCase::collectShort;
            this.payloads.flatCollect = AbstractImmutableSetTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractImmutableSetTestCase::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = AbstractImmutableSetTestCase::detect;
            this.payloads.detectWith = AbstractImmutableSetTestCase::detectWith;
            this.payloads.detectIfNone = AbstractImmutableSetTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableSetTestCase::detectWithIfNone;
            this.payloads.allSatisfy = AbstractImmutableSetTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractImmutableSetTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableSetTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableSetTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractImmutableSetTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractImmutableSetTestCase::anySatisfyWith;
            this.payloads.count = AbstractImmutableSetTestCase::count;
            this.payloads.countWith = AbstractImmutableSetTestCase::countWith;
            this.payloads.collectIf = AbstractImmutableSetTestCase::collectIf;
            this.payloads.getFirst = AbstractImmutableSetTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableSetTestCase::getLast;
            this.payloads.isEmpty = AbstractImmutableSetTestCase::isEmpty;
            this.payloads.iterator = AbstractImmutableSetTestCase::iterator;
            this.payloads.toArray = AbstractImmutableSetTestCase::toArray;
            this.payloads.toSortedList = AbstractImmutableSetTestCase::toSortedList;
            this.payloads.toSortedSet = AbstractImmutableSetTestCase::toSortedSet;
            this.payloads.toSortedSetWithComparator = AbstractImmutableSetTestCase::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = AbstractImmutableSetTestCase::toSortedSetBy;
            this.payloads.forLoop = AbstractImmutableSetTestCase::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractImmutableSetTestCase::min;
            this.payloads.max = AbstractImmutableSetTestCase::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSetTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractImmutableSetTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractImmutableSetTestCase::max_without_comparator;
            this.payloads.minBy = AbstractImmutableSetTestCase::minBy;
            this.payloads.maxBy = AbstractImmutableSetTestCase::maxBy;
            this.payloads.iteratorRemove = AbstractImmutableSetTestCase::iteratorRemove;
            this.payloads.add = AbstractImmutableSetTestCase::add;
            this.payloads.remove = AbstractImmutableSetTestCase::remove;
            this.payloads.clear = AbstractImmutableSetTestCase::clear;
            this.payloads.removeAll = AbstractImmutableSetTestCase::removeAll;
            this.payloads.retainAll = AbstractImmutableSetTestCase::retainAll;
            this.payloads.addAll = AbstractImmutableSetTestCase::addAll;
            this.payloads.aggregateByMutating = AbstractImmutableSetTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractImmutableSetTestCase::aggregateByNonMutating;
            this.payloads.tap = AbstractImmutableSetTestCase::tap;
            this.payloads.equalsAndHashCode = AbstractImmutableSetTestCase::equalsAndHashCode;
            this.payloads.newWith = AbstractImmutableSetTestCase::newWith;
            this.payloads.newWithout = AbstractImmutableSetTestCase::newWithout;
            this.payloads.newWithAll = AbstractImmutableSetTestCase::newWithAll;
            this.payloads.newWithoutAll = AbstractImmutableSetTestCase::newWithoutAll;
            this.payloads.contains = AbstractImmutableSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableSetTestCase::containsAllIterable;
            this.payloads.forEach = AbstractImmutableSetTestCase::forEach;
            this.payloads.forEachWith = AbstractImmutableSetTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableSetTestCase::forEachWithIndex;
            this.payloads.select_target = AbstractImmutableSetTestCase::select_target;
            this.payloads.reject_target = AbstractImmutableSetTestCase::reject_target;
            this.payloads.flatCollectWithTarget = AbstractImmutableSetTestCase::flatCollectWithTarget;
            this.payloads.zip = AbstractImmutableSetTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableSetTestCase::zipWithIndex;
            this.payloads.chunk_large_size = AbstractImmutableSetTestCase::chunk_large_size;
            this.payloads.collectIfWithTarget = AbstractImmutableSetTestCase::collectIfWithTarget;
            this.payloads.toList = AbstractImmutableSetTestCase::toList;
            this.payloads.toSortedListBy = AbstractImmutableSetTestCase::toSortedListBy;
            this.payloads.groupBy = AbstractImmutableSetTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableSetTestCase::groupByEach;
            this.payloads.groupByWithTarget = AbstractImmutableSetTestCase::groupByWithTarget;
            this.payloads.groupByEachWithTarget = AbstractImmutableSetTestCase::groupByEachWithTarget;
            this.payloads.union = AbstractImmutableSetTestCase::union;
            this.payloads.unionInto = AbstractImmutableSetTestCase::unionInto;
            this.payloads.intersect = AbstractImmutableSetTestCase::intersect;
            this.payloads.intersectInto = AbstractImmutableSetTestCase::intersectInto;
            this.payloads.difference = AbstractImmutableSetTestCase::difference;
            this.payloads.differenceInto = AbstractImmutableSetTestCase::differenceInto;
            this.payloads.symmetricDifference = AbstractImmutableSetTestCase::symmetricDifference;
            this.payloads.symmetricDifferenceInto = AbstractImmutableSetTestCase::symmetricDifferenceInto;
            this.payloads.isSubsetOf = AbstractImmutableSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableSetTestCase::isProperSubsetOf;
            this.payloads.powerSet = AbstractImmutableSetTestCase::powerSet;
            this.payloads.cartesianProduct = AbstractImmutableSetTestCase::cartesianProduct;
            this.payloads.toImmutable = AbstractImmutableSetTestCase::toImmutable;
        }
    }
}
