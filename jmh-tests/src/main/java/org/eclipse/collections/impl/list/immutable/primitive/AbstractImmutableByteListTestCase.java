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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableByteCollectionTestCase._Benchmark {

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator, this.description("byteIterator"));
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipByte, this.description("zipByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableByteListTestCase implementation();
    }
}
