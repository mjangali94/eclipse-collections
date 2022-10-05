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

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableByteCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableByteListTestCase extends AbstractImmutableByteCollectionTestCase {

    @Override
    protected abstract ImmutableByteList classUnderTest();

    @Override
    protected ImmutableByteList newWith(byte... elements) {
        return ByteLists.immutable.of(elements);
    }

    @Override
    protected MutableByteList newMutableCollectionWith(byte... elements) {
        return ByteArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Byte> newObjectCollectionWith(Byte... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableByteList list = this.classUnderTest();
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
        ImmutableByteList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast());
    }

    @Test
    public void indexOf() {
        ImmutableByteList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf((byte) (i + 1)));
        }
        Assert.assertEquals(-1L, list.indexOf((byte) (list.size() + 1)));
        ImmutableByteList arrayList = this.newWith((byte) 1, (byte) 2, (byte) 1);
        Assert.assertEquals(0L, arrayList.indexOf((byte) 1));
        Assert.assertEquals(1L, arrayList.indexOf((byte) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((byte) 9));
    }

    @Test
    public void lastIndexOf() {
        ImmutableByteList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf((byte) (i + 1)));
        }
        Assert.assertEquals(-1L, list.lastIndexOf((byte) (list.size() + 1)));
        ImmutableByteList arrayList = this.newWith((byte) 1, (byte) 2, (byte) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((byte) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((byte) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((byte) 9));
    }

    @Override
    @Test
    public void byteIterator() {
        ByteIterator iterator = this.classUnderTest().byteIterator();
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
        ImmutableByteList list = this.classUnderTest();
        byte[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i]);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableByteList iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = list1.injectIntoWithIndex(new MutableByte((byte) 0), (MutableByte object, byte value, int index) -> object.add((byte) (value * list2.get(index))));
        Assert.assertEquals(new MutableByte((byte) 14), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        ImmutableByteList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ByteLists.immutable.with((byte) 3, (byte) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList selected = list.selectWithIndex((value, i) -> i % 2 == 0, ByteLists.mutable.empty());
        Assert.assertEquals(ByteLists.immutable.with((byte) 3, (byte) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        ImmutableByteList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ByteLists.immutable.with((byte) 1, (byte) 7), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, ByteLists.mutable.empty());
        Assert.assertEquals(ByteLists.immutable.with((byte) 1, (byte) 7), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<ByteIntPair> pairs = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<ByteIntPair> pairs = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(ByteSets.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 4, (byte) 4).distinct();
        ImmutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7), this.newWith((byte) 7, (byte) 9, (byte) 1, (byte) 3).toReversed());
        ImmutableByteList list1 = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7, (byte) 8), this.newWith((byte) 8, (byte) 7, (byte) 9, (byte) 1, (byte) 3).toReversed());
        ImmutableByteList list2 = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7, (byte) 8);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((byte each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ImmutableByteList list2 = this.newWith((byte) 4, (byte) 3, (byte) 2, (byte) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (byte each = 0; each < size; each++) {
            expectedString.append((byte) (each + (byte) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableByteList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (byte each = 0; each < size; each++) {
            expectedString.append((byte) (each + (byte) 1));
            expectedString1.append((byte) (each + (byte) 1));
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
        for (byte each = 0; each < size; each++) {
            expectedString.append((byte) (each + (byte) 1));
            expectedString1.append((byte) (each + (byte) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableByteList list = this.classUnderTest();
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
        ImmutableByteList immutableList = this.classUnderTest();
        MutableByteList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipByte() {
        ImmutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteList list2 = this.newWith((byte) 1);
        ImmutableList<ByteBytePair> zipSame = list1.zipByte(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 3)), zipSame);
        ImmutableList<ByteBytePair> zipSameLazy = list1.zipByte(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 3)), zipSameLazy);
        ImmutableList<ByteBytePair> zipLess = list1.zipByte(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1)), zipLess);
        ImmutableList<ByteBytePair> zipLessLazy = list1.zipByte(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1)), zipLessLazy);
        ImmutableList<ByteBytePair> zipMore = list2.zipByte(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1)), zipMore);
        ImmutableList<ByteBytePair> zipMoreLazy = list2.zipByte(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1)), zipMoreLazy);
        ImmutableList<ByteBytePair> zipEmpty1 = list1.zipByte(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<ByteBytePair> zipEmpty2 = this.newWith().zipByte(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteList list2 = this.newWith((byte) 1);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<ByteObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2"), PrimitiveTuples.pair((byte) 3, "3")), zipSame);
        ImmutableList<ByteObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2"), PrimitiveTuples.pair((byte) 3, "3")), zipSameLazy);
        ImmutableList<ByteObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1")), zipLess);
        ImmutableList<ByteObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1")), zipLessLazy);
        ImmutableList<ByteObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1")), zipMore);
        ImmutableList<ByteObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((byte) 1, "1")), zipMoreLazy);
        ImmutableList<ByteObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<ByteObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableByteListTestCase instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableByteListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteListTestCase> zip;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableByteListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableByteListTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableByteListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableByteListTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableByteListTestCase::tap;
            this.payloads.contains = AbstractImmutableByteListTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableByteListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableByteListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableByteListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableByteListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableByteListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableByteListTestCase::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableByteListTestCase::forEach;
            this.payloads.size = AbstractImmutableByteListTestCase::size;
            this.payloads.count = AbstractImmutableByteListTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableByteListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableByteListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableByteListTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableByteListTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableByteListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableByteListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableByteListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableByteListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableByteListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableByteListTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableByteListTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableByteListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableByteListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableByteListTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableByteListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableByteListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableByteListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableByteListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableByteListTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableByteListTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableByteListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableByteListTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableByteListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableByteListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractImmutableByteListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableByteListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractImmutableByteListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractImmutableByteListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableByteListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableByteListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableByteListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableByteListTestCase::toSet;
            this.payloads.toBag = AbstractImmutableByteListTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableByteListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractImmutableByteListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableByteListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableByteListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableByteListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableByteListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableByteListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableByteListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableByteListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableByteListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableByteListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableByteListTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableByteListTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableByteListTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableByteListTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableByteListTestCase::newWithoutAll;
            this.payloads.get = AbstractImmutableByteListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractImmutableByteListTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableByteListTestCase::getLast;
            this.payloads.indexOf = AbstractImmutableByteListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractImmutableByteListTestCase::lastIndexOf;
            this.payloads.byteIterator = AbstractImmutableByteListTestCase::byteIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableByteListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = AbstractImmutableByteListTestCase::toArray;
            this.payloads.injectInto = AbstractImmutableByteListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractImmutableByteListTestCase::injectIntoWithIndex;
            this.payloads.selectWithIndex = AbstractImmutableByteListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableByteListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableByteListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableByteListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractImmutableByteListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableByteListTestCase::collectWithIndexWithTarget;
            this.payloads.distinct = AbstractImmutableByteListTestCase::distinct;
            this.payloads.toReversed = AbstractImmutableByteListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractImmutableByteListTestCase::forEachWithIndex;
            this.payloads.testEquals = AbstractImmutableByteListTestCase::testEquals;
            this.payloads.testToString = AbstractImmutableByteListTestCase::testToString;
            this.payloads.makeString = AbstractImmutableByteListTestCase::makeString;
            this.payloads.appendString = AbstractImmutableByteListTestCase::appendString;
            this.payloads.toList = AbstractImmutableByteListTestCase::toList;
            this.payloads.zipByte = AbstractImmutableByteListTestCase::zipByte;
            this.payloads.zip = AbstractImmutableByteListTestCase::zip;
        }
    }
}
