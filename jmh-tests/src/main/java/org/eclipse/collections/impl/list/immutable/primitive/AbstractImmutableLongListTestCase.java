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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::get_throws_index_greater_than_size, this.description("get_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::get_throws_index_negative, this.description("get_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lastIndexOf, this.description("lastIndexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::subList, this.description("subList"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWithIndex, this.description("injectIntoWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithIndex, this.description("selectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithIndexWithTarget, this.description("selectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithIndex, this.description("rejectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithIndexWithTarget, this.description("rejectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndex, this.description("collectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndexWithTarget, this.description("collectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toReversed, this.description("toReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipLong, this.description("zipLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::stream, this.description("stream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::parallelStream, this.description("parallelStream"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableLongListTestCase implementation();
    }
}
