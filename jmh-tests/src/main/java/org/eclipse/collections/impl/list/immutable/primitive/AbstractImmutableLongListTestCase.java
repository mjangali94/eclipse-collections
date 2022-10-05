/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;

/**
 * Abstract JUnit test for {@link ImmutableLongList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableLongListTestCase extends AbstractImmutableLongCollectionTestCase {

    @Override
    protected abstract ImmutableLongList classUnderTest();

    @Override
    protected ImmutableLongList newWith(long... elements) {
        return LongLists.immutable.of(elements);
    }

    @Override
    protected MutableLongList newMutableCollectionWith(long... elements) {
        return LongArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Long> newObjectCollectionWith(Long... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableLongList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i + 1, list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size() {
        this.classUnderTest().get(this.classUnderTest().size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative() {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test
    public void getLast() {
        ImmutableLongList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast());
    }

    @Test
    public void indexOf() {
        ImmutableLongList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.indexOf(list.size() + 1));
        ImmutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(0L, arrayList.indexOf(1L));
        Assert.assertEquals(1L, arrayList.indexOf(2L));
        Assert.assertEquals(-1L, arrayList.indexOf(9L));
    }

    @Test
    public void lastIndexOf() {
        ImmutableLongList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.lastIndexOf(list.size() + 1));
        ImmutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1L));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2L));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9L));
    }

    @Override
    @Test
    public void longIterator() {
        LongIterator iterator = this.classUnderTest().longIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Assert.assertEquals(i + 1, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        ImmutableLongList list = this.classUnderTest();
        long[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i]);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableLongList iterable = this.newWith(1L, 2L, 3L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableLongList list1 = this.newWith(1L, 2L, 3L);
        ImmutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L), (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(14L), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        ImmutableLongList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(LongLists.immutable.with(3L, 9L), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList selected = list.selectWithIndex((value, i) -> i % 2 == 0, LongLists.mutable.empty());
        Assert.assertEquals(LongLists.immutable.with(3L, 9L), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        ImmutableLongList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(LongLists.immutable.with(1L, 7L), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, LongLists.mutable.empty());
        Assert.assertEquals(LongLists.immutable.with(1L, 7L), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(LongLists.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(LongLists.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(LongSets.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableLongList list1 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L, 4L, 4L, 4L, 4L).distinct();
        ImmutableLongList list2 = this.newWith(1L, 2L, 3L, 4L);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableLongArrayList.newListWith(3L, 1L, 9L, 7L), this.newWith(7L, 9L, 1L, 3L).toReversed());
        ImmutableLongList list1 = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L, 8L), this.newWith(8L, 7L, 9L, 1L, 3L).toReversed());
        ImmutableLongList list2 = this.newWith(3L, 1L, 9L, 7L, 8L);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableLongList list1 = this.newWith(1L, 2L, 3L, 4L);
        ImmutableLongList list2 = this.newWith(4L, 3L, 2L, 1L);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (long each = 0; each < size; each++) {
            expectedString.append((long) (each + 1L));
            expectedString.append(each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableLongList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (long each = 0; each < size; each++) {
            expectedString.append((long) (each + 1L));
            expectedString1.append((long) (each + 1L));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        Assert.assertEquals(expectedString.toString(), list.makeString());
        Assert.assertEquals(expectedString1.toString(), list.makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (long each = 0; each < size; each++) {
            expectedString.append((long) (each + 1L));
            expectedString1.append((long) (each + 1L));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableLongList list = this.classUnderTest();
        StringBuilder appendable2 = new StringBuilder();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        ImmutableLongList immutableList = this.classUnderTest();
        MutableLongList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipLong() {
        ImmutableLongList list1 = this.newWith(1L, 2L, 3L);
        ImmutableLongList list2 = this.newWith(1L);
        ImmutableList<LongLongPair> zipSame = list1.zipLong(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(3L, 3L)), zipSame);
        ImmutableList<LongLongPair> zipSameLazy = list1.zipLong(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(3L, 3L)), zipSameLazy);
        ImmutableList<LongLongPair> zipLess = list1.zipLong(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L)), zipLess);
        ImmutableList<LongLongPair> zipLessLazy = list1.zipLong(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L)), zipLessLazy);
        ImmutableList<LongLongPair> zipMore = list2.zipLong(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L)), zipMore);
        ImmutableList<LongLongPair> zipMoreLazy = list2.zipLong(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, 1L)), zipMoreLazy);
        ImmutableList<LongLongPair> zipEmpty1 = list1.zipLong(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<LongLongPair> zipEmpty2 = this.newWith().zipLong(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableLongList list1 = this.newWith(1L, 2L, 3L);
        ImmutableLongList list2 = this.newWith(1L);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<LongObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2"), PrimitiveTuples.pair(3L, "3")), zipSame);
        ImmutableList<LongObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2"), PrimitiveTuples.pair(3L, "3")), zipSameLazy);
        ImmutableList<LongObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1")), zipLess);
        ImmutableList<LongObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1")), zipLessLazy);
        ImmutableList<LongObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1")), zipMore);
        ImmutableList<LongObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1L, "1")), zipMoreLazy);
        ImmutableList<LongObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<LongObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void stream() {
        Assert.assertEquals(Collections.emptyList(), LongLists.immutable.empty().primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Collections.singletonList(1L), this.newWith(1L).primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), ImmutableLongArrayList.newListWith(1L, 2L, 3L).primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void parallelStream() {
        Assert.assertEquals(Collections.emptyList(), LongLists.immutable.empty().primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Collections.singletonList(1L), this.newWith(1L).primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), ImmutableLongArrayList.newListWith(1L, 2L, 3L).primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableLongListTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
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
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableLongListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> zipLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongListTestCase> parallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableLongListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableLongListTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableLongListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableLongListTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableLongListTestCase::tap;
            this.payloads.contains = AbstractImmutableLongListTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableLongListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableLongListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableLongListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableLongListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableLongListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableLongListTestCase::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableLongListTestCase::forEach;
            this.payloads.size = AbstractImmutableLongListTestCase::size;
            this.payloads.count = AbstractImmutableLongListTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableLongListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableLongListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableLongListTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableLongListTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableLongListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableLongListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableLongListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableLongListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableLongListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableLongListTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableLongListTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableLongListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableLongListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableLongListTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableLongListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableLongListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableLongListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableLongListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableLongListTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableLongListTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableLongListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableLongListTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableLongListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableLongListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractImmutableLongListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableLongListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractImmutableLongListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractImmutableLongListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableLongListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableLongListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableLongListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableLongListTestCase::toSet;
            this.payloads.toBag = AbstractImmutableLongListTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableLongListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractImmutableLongListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableLongListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableLongListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableLongListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableLongListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableLongListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableLongListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableLongListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableLongListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableLongListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableLongListTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableLongListTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableLongListTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableLongListTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableLongListTestCase::newWithoutAll;
            this.payloads.get = AbstractImmutableLongListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractImmutableLongListTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableLongListTestCase::getLast;
            this.payloads.indexOf = AbstractImmutableLongListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractImmutableLongListTestCase::lastIndexOf;
            this.payloads.longIterator = AbstractImmutableLongListTestCase::longIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = AbstractImmutableLongListTestCase::toArray;
            this.payloads.injectInto = AbstractImmutableLongListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractImmutableLongListTestCase::injectIntoWithIndex;
            this.payloads.selectWithIndex = AbstractImmutableLongListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableLongListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableLongListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableLongListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractImmutableLongListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableLongListTestCase::collectWithIndexWithTarget;
            this.payloads.distinct = AbstractImmutableLongListTestCase::distinct;
            this.payloads.toReversed = AbstractImmutableLongListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractImmutableLongListTestCase::forEachWithIndex;
            this.payloads.testEquals = AbstractImmutableLongListTestCase::testEquals;
            this.payloads.testToString = AbstractImmutableLongListTestCase::testToString;
            this.payloads.makeString = AbstractImmutableLongListTestCase::makeString;
            this.payloads.appendString = AbstractImmutableLongListTestCase::appendString;
            this.payloads.toList = AbstractImmutableLongListTestCase::toList;
            this.payloads.zipLong = AbstractImmutableLongListTestCase::zipLong;
            this.payloads.zip = AbstractImmutableLongListTestCase::zip;
            this.payloads.stream = AbstractImmutableLongListTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableLongListTestCase::parallelStream;
        }
    }
}
