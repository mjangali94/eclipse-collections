/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.list.mutable.ArrayListAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.list.mutable.RandomAccessListAdapter;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.SetAdapter;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

/**
 * JUnit test for {@link CollectionAdapter}.
 */
public class CollectionAdapterTest extends AbstractCollectionTestCase {

    @Override
    protected <T> CollectionAdapter<T> newWith(T... littleElements) {
        return new CollectionAdapter<>(new ArrayList<>(FastList.newListWith(littleElements)));
    }

    private <T> CollectionAdapter<T> newSet() {
        return new CollectionAdapter<>(UnifiedSet.newSet());
    }

    private <T> CollectionAdapter<T> newList() {
        return new CollectionAdapter<>(FastList.newList());
    }

    @Test(expected = NullPointerException.class)
    public void null_throws() {
        new CollectionAdapter<>(null);
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableCollection<String> collection = CollectionAdapter.adapt(Maps.mutable.of("1", "1").values());
        MutableCollection<String> asSynchronized = collection.asSynchronized();
        Verify.assertInstanceOf(AbstractSynchronizedMutableCollection.class, asSynchronized);
        Verify.assertInstanceOf(SynchronizedMutableCollection.class, asSynchronized);
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableCollection.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        Verify.assertInstanceOf(ImmutableList.class, new CollectionAdapter<>(Collections.singletonList("1")).toImmutable());
        Verify.assertInstanceOf(ImmutableSet.class, new CollectionAdapter<>(Collections.singleton("1")).toImmutable());
    }

    @Override
    @Test
    public void select() {
        super.select();
        Verify.assertContainsAll(this.<Integer>newSet().with(1, 2, 3, 4, 5).select(Predicates.lessThan(3)), 1, 2);
        Verify.assertContainsAll(this.<Integer>newSet().with(-1, 2, 3, 4, 5).select(Predicates.lessThan(3), FastList.newList()), -1, 2);
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(FastList.class, CollectionAdapter.adapt(new LinkedList<>()).newEmpty());
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        Verify.assertContainsAll(this.<Integer>newSet().with(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(this.<Integer>newSet().with(1, 2, 3, 4).reject(Predicates.lessThan(3), FastList.newList()), 3, 4);
    }

    @Override
    @Test
    public void selectInstancesOf() {
        super.selectInstancesOf();
        MutableCollection<Number> numbers = this.<Number>newSet().with(1, 2.0, 3, 4.0, 5);
        MutableCollection<Integer> integers = numbers.selectInstancesOf(Integer.class);
        Assert.assertEquals(HashBag.newBagWith(1, 3, 5), integers.toBag());
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2", "3", "4"), this.newSet().with(1, 2, 3, 4).collect(String::valueOf));
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2", "3", "4"), this.newSet().with(1, 2, 3, 4).collect(String::valueOf, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void flatCollect() {
        super.flatCollect();
        Function<Integer, Iterable<Integer>> function = Interval::oneTo;
        Assert.assertEquals(FastList.newListWith(1, 1, 2, 1, 2, 3, 1, 2, 3, 4), this.<Integer>newList().with(1, 2, 3, 4).flatCollect(function));
        Assert.assertEquals(FastList.newListWith(1, 1, 2, 1, 2, 3, 1, 2, 3, 4), this.<Integer>newList().with(1, 2, 3, 4).flatCollect(function));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableCollection<Integer> list1 = this.<Integer>newList().with(1, 2, 3);
        MutableCollection<Integer> list2 = this.<Integer>newList().with(1, 2, 3);
        MutableCollection<Integer> list3 = this.<Integer>newList().with(2, 3, 4);
        Verify.assertEqualsAndHashCode(list1, list2);
        Assert.assertNotEquals(list1, null);
        Assert.assertNotEquals(list2, list3);
    }

    @Test
    public void newListWithSize() {
        Collection<Integer> collection = this.<Integer>newList().with(1, 2, 3);
        Verify.assertContainsAll(collection, 1, 2, 3);
    }

    @Test
    public void serialization() {
        MutableCollection<Integer> collection = this.<Integer>newList().with(1, 2, 3, 4, 5);
        MutableCollection<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertContainsAll(deserializedCollection, 1, 2, 3, 4, 5);
        Assert.assertEquals(collection, deserializedCollection);
    }

    @Test
    public void adapt() {
        Verify.assertInstanceOf(FastList.class, CollectionAdapter.adapt(FastList.newList()));
        Verify.assertInstanceOf(ArrayListAdapter.class, CollectionAdapter.adapt(new ArrayList<>()));
        Verify.assertInstanceOf(SetAdapter.class, CollectionAdapter.adapt(new HashSet<>()));
        Verify.assertInstanceOf(UnifiedSet.class, CollectionAdapter.adapt(UnifiedSet.newSet()));
        Verify.assertInstanceOf(RandomAccessListAdapter.class, CollectionAdapter.adapt(Collections.emptyList()));
        Verify.assertInstanceOf(ListAdapter.class, CollectionAdapter.adapt(new LinkedList<>()));
        Verify.assertInstanceOf(ArrayAdapter.class, CollectionAdapter.adapt(ArrayAdapter.newArray()));
    }

    @Override
    @Test
    public void groupBy() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Multimap<Boolean, Integer> multimap = list.groupBy(object -> IntegerPredicates.isOdd().accept(object));
        MutableMap<Boolean, RichIterable<Integer>> expected = UnifiedMap.newWithKeysValues(Boolean.TRUE, FastList.newListWith(1, 3, 5, 7), Boolean.FALSE, FastList.newListWith(2, 4, 6));
        Assert.assertEquals(expected, multimap.toMap());
    }

    @Override
    @Test
    public void groupByEach() {
        RichIterable<Integer> underTest = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Function<Integer, Iterable<Integer>> intervalFunction = new NegativeIntervalFunction();
        MutableMultimap<Integer, Integer> expected = this.<Integer>newWith().groupByEach(intervalFunction);
        for (int i = 1; i < 8; i++) {
            expected.putAll(-i, Interval.fromTo(i, 7));
        }
        Multimap<Integer, Integer> actual = underTest.groupByEach(intervalFunction);
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = underTest.groupByEach(intervalFunction, this.<Integer>newWith().groupByEach(intervalFunction));
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Test
    public void wrapSet() {
        Verify.assertInstanceOf(SetAdapter.class, CollectionAdapter.wrapSet(new HashSet<>()));
        Verify.assertInstanceOf(UnifiedSet.class, CollectionAdapter.wrapSet(new FastList<>()));
    }

    @Test
    public void wrapList() {
        Verify.assertInstanceOf(ArrayListAdapter.class, CollectionAdapter.wrapList(new ArrayList<>()));
        Verify.assertInstanceOf(FastList.class, CollectionAdapter.wrapList(new HashSet<>()));
        Verify.assertInstanceOf(FastList.class, CollectionAdapter.wrapList(FastList.newList()));
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(new CollectionAdapter<>(FastList.newList()), new CollectionAdapter<>(FastList.newList()));
        Assert.assertNotEquals(new CollectionAdapter<>(FastList.newList()), new CollectionAdapter<>(FastList.newListWith(1)));
        Assert.assertEquals(new CollectionAdapter<>(FastList.newListWith(1)), new CollectionAdapter<>(FastList.newListWith(1)));
        Assert.assertNotEquals(new CollectionAdapter<>(FastList.newListWith(1)), new CollectionAdapter<>(FastList.newListWith(2)));
    }

    @Test
    public void testNewEmpty() {
        Verify.assertInstanceOf(UnifiedSet.class, new CollectionAdapter<>(new HashSet<>()).newEmpty());
        Verify.assertInstanceOf(FastList.class, new CollectionAdapter<>(new ArrayList<>()).newEmpty());
    }

    @Override
    @Test
    public void chunk_large_size() {
        MutableCollection<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Assert.assertEquals(collection.toList(), collection.chunk(10).getOnly());
    }

    @Override
    @Test
    public void partition() {
        MutableCollection<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionMutableCollection<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        MutableCollection<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionMutableCollection<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public CollectionAdapterTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
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
        public void benchmark_wrapSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new CollectionAdapterTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> wrapSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> wrapList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterTest> partitionWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = CollectionAdapterTest::testNewCollection;
            this.payloads.contains = CollectionAdapterTest::contains;
            this.payloads.containsBy = CollectionAdapterTest::containsBy;
            this.payloads.containsAllIterable = CollectionAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = CollectionAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = CollectionAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = CollectionAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = CollectionAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = CollectionAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = CollectionAdapterTest::containsAllCollection;
            this.payloads.tap = CollectionAdapterTest::tap;
            this.payloads.forEach = CollectionAdapterTest::forEach;
            this.payloads.forEachWith = CollectionAdapterTest::forEachWith;
            this.payloads.forEachWithIndex = CollectionAdapterTest::forEachWithIndex;
            this.payloads.selectWith = CollectionAdapterTest::selectWith;
            this.payloads.selectWith_target = CollectionAdapterTest::selectWith_target;
            this.payloads.rejectWith = CollectionAdapterTest::rejectWith;
            this.payloads.rejectWith_target = CollectionAdapterTest::rejectWith_target;
            this.payloads.collectTarget = CollectionAdapterTest::collectTarget;
            this.payloads.collectBoolean = CollectionAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = CollectionAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = CollectionAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = CollectionAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = CollectionAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = CollectionAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = CollectionAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = CollectionAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = CollectionAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = CollectionAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = CollectionAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = CollectionAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = CollectionAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = CollectionAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = CollectionAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = CollectionAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = CollectionAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = CollectionAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = CollectionAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = CollectionAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = CollectionAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = CollectionAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = CollectionAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = CollectionAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = CollectionAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = CollectionAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = CollectionAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = CollectionAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = CollectionAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = CollectionAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = CollectionAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = CollectionAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = CollectionAdapterTest::flatCollectFloat;
            this.payloads.detect = CollectionAdapterTest::detect;
            this.payloads.detectOptional = CollectionAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = CollectionAdapterTest::min;
            this.payloads.minOptional = CollectionAdapterTest::minOptional;
            this.payloads.max = CollectionAdapterTest::max;
            this.payloads.maxOptional = CollectionAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = CollectionAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = CollectionAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = CollectionAdapterTest::min_null_safe;
            this.payloads.max_null_safe = CollectionAdapterTest::max_null_safe;
            this.payloads.minBy = CollectionAdapterTest::minBy;
            this.payloads.minByOptional = CollectionAdapterTest::minByOptional;
            this.payloads.maxBy = CollectionAdapterTest::maxBy;
            this.payloads.maxByOptional = CollectionAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = CollectionAdapterTest::detectWith;
            this.payloads.detectWithOptional = CollectionAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = CollectionAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = CollectionAdapterTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = CollectionAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = CollectionAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = CollectionAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = CollectionAdapterTest::noneSatisfyWith;
            this.payloads.anySatisfy = CollectionAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = CollectionAdapterTest::anySatisfyWith;
            this.payloads.count = CollectionAdapterTest::count;
            this.payloads.countWith = CollectionAdapterTest::countWith;
            this.payloads.collectIf = CollectionAdapterTest::collectIf;
            this.payloads.collectWith = CollectionAdapterTest::collectWith;
            this.payloads.collectWith_target = CollectionAdapterTest::collectWith_target;
            this.payloads.getAny = CollectionAdapterTest::getAny;
            this.payloads.getFirst = CollectionAdapterTest::getFirst;
            this.payloads.getLast = CollectionAdapterTest::getLast;
            this.payloads.getOnly = CollectionAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = CollectionAdapterTest::isEmpty;
            this.payloads.iterator = CollectionAdapterTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = CollectionAdapterTest::injectInto;
            this.payloads.injectIntoInt = CollectionAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = CollectionAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = CollectionAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = CollectionAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = CollectionAdapterTest::sumFloat;
            this.payloads.summarizeFloat = CollectionAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = CollectionAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = CollectionAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = CollectionAdapterTest::sumDouble;
            this.payloads.summarizeDouble = CollectionAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = CollectionAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = CollectionAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = CollectionAdapterTest::sumInteger;
            this.payloads.summarizeInt = CollectionAdapterTest::summarizeInt;
            this.payloads.sumLong = CollectionAdapterTest::sumLong;
            this.payloads.summarizeLong = CollectionAdapterTest::summarizeLong;
            this.payloads.sumByInt = CollectionAdapterTest::sumByInt;
            this.payloads.sumByFloat = CollectionAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = CollectionAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = CollectionAdapterTest::sumByLong;
            this.payloads.sumByDouble = CollectionAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = CollectionAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = CollectionAdapterTest::toArray;
            this.payloads.toList = CollectionAdapterTest::toList;
            this.payloads.toImmutableList = CollectionAdapterTest::toImmutableList;
            this.payloads.toCollection = CollectionAdapterTest::toCollection;
            this.payloads.toBag = CollectionAdapterTest::toBag;
            this.payloads.toImmutableBag = CollectionAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = CollectionAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = CollectionAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = CollectionAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = CollectionAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = CollectionAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = CollectionAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = CollectionAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = CollectionAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = CollectionAdapterTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = CollectionAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = CollectionAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = CollectionAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = CollectionAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = CollectionAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = CollectionAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = CollectionAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = CollectionAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = CollectionAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = CollectionAdapterTest::toSet;
            this.payloads.toImmutableSet = CollectionAdapterTest::toImmutableSet;
            this.payloads.toMap = CollectionAdapterTest::toMap;
            this.payloads.toImmutableMap = CollectionAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = CollectionAdapterTest::toMapTarget;
            this.payloads.toSortedMap = CollectionAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = CollectionAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = CollectionAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = CollectionAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = CollectionAdapterTest::toImmutableBiMap;
            this.payloads.testToString = CollectionAdapterTest::testToString;
            this.payloads.makeString = CollectionAdapterTest::makeString;
            this.payloads.makeStringWithSeparator = CollectionAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = CollectionAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = CollectionAdapterTest::fusedCollectMakeString;
            this.payloads.appendString = CollectionAdapterTest::appendString;
            this.payloads.appendStringWithSeparator = CollectionAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = CollectionAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = CollectionAdapterTest::appendStringThrows;
            this.payloads.countBy = CollectionAdapterTest::countBy;
            this.payloads.countByWith = CollectionAdapterTest::countByWith;
            this.payloads.countByEach = CollectionAdapterTest::countByEach;
            this.payloads.groupByUniqueKey = CollectionAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = CollectionAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = CollectionAdapterTest::zip;
            this.payloads.zipWithIndex = CollectionAdapterTest::zipWithIndex;
            this.payloads.chunk = CollectionAdapterTest::chunk;
            this.payloads.chunk_empty = CollectionAdapterTest::chunk_empty;
            this.payloads.chunk_single = CollectionAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = CollectionAdapterTest::empty;
            this.payloads.notEmpty = CollectionAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = CollectionAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = CollectionAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = CollectionAdapterTest::reduceOptional;
            this.payloads.testNewWith = CollectionAdapterTest::testNewWith;
            this.payloads.testNewWithWith = CollectionAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = CollectionAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = CollectionAdapterTest::testNewWithVarArgs;
            this.payloads.addAll = CollectionAdapterTest::addAll;
            this.payloads.addAllIterable = CollectionAdapterTest::addAllIterable;
            this.payloads.removeAll = CollectionAdapterTest::removeAll;
            this.payloads.removeAllIterable = CollectionAdapterTest::removeAllIterable;
            this.payloads.retainAll = CollectionAdapterTest::retainAll;
            this.payloads.retainAllIterable = CollectionAdapterTest::retainAllIterable;
            this.payloads.clear = CollectionAdapterTest::clear;
            this.payloads.injectIntoWith = CollectionAdapterTest::injectIntoWith;
            this.payloads.removeObject = CollectionAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = CollectionAdapterTest::selectAndRejectWith;
            this.payloads.removeIf = CollectionAdapterTest::removeIf;
            this.payloads.removeIfWith = CollectionAdapterTest::removeIfWith;
            this.payloads.with = CollectionAdapterTest::with;
            this.payloads.withAll = CollectionAdapterTest::withAll;
            this.payloads.without = CollectionAdapterTest::without;
            this.payloads.withoutAll = CollectionAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = CollectionAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = CollectionAdapterTest::asLazy;
            this.payloads.null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterTest::null_throws, java.lang.NullPointerException.class);
            this.payloads.asSynchronized = CollectionAdapterTest::asSynchronized;
            this.payloads.asUnmodifiable = CollectionAdapterTest::asUnmodifiable;
            this.payloads.toImmutable = CollectionAdapterTest::toImmutable;
            this.payloads.select = CollectionAdapterTest::select;
            this.payloads.newEmpty = CollectionAdapterTest::newEmpty;
            this.payloads.reject = CollectionAdapterTest::reject;
            this.payloads.selectInstancesOf = CollectionAdapterTest::selectInstancesOf;
            this.payloads.collect = CollectionAdapterTest::collect;
            this.payloads.flatCollect = CollectionAdapterTest::flatCollect;
            this.payloads.equalsAndHashCode = CollectionAdapterTest::equalsAndHashCode;
            this.payloads.newListWithSize = CollectionAdapterTest::newListWithSize;
            this.payloads.serialization = CollectionAdapterTest::serialization;
            this.payloads.adapt = CollectionAdapterTest::adapt;
            this.payloads.groupBy = CollectionAdapterTest::groupBy;
            this.payloads.groupByEach = CollectionAdapterTest::groupByEach;
            this.payloads.wrapSet = CollectionAdapterTest::wrapSet;
            this.payloads.wrapList = CollectionAdapterTest::wrapList;
            this.payloads.testEquals = CollectionAdapterTest::testEquals;
            this.payloads.testNewEmpty = CollectionAdapterTest::testNewEmpty;
            this.payloads.chunk_large_size = CollectionAdapterTest::chunk_large_size;
            this.payloads.partition = CollectionAdapterTest::partition;
            this.payloads.partitionWith = CollectionAdapterTest::partitionWith;
        }
    }
}
