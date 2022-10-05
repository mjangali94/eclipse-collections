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

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableShortCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableShortListTestCase extends AbstractImmutableShortCollectionTestCase {

    @Override
    protected abstract ImmutableShortList classUnderTest();

    @Override
    protected ImmutableShortList newWith(short... elements) {
        return ShortLists.immutable.of(elements);
    }

    @Override
    protected MutableShortList newMutableCollectionWith(short... elements) {
        return ShortArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Short> newObjectCollectionWith(Short... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableShortList list = this.classUnderTest();
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
        ImmutableShortList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast());
    }

    @Test
    public void indexOf() {
        ImmutableShortList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf((short) (i + 1)));
        }
        Assert.assertEquals(-1L, list.indexOf((short) (list.size() + 1)));
        ImmutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(0L, arrayList.indexOf((short) 1));
        Assert.assertEquals(1L, arrayList.indexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((short) 9));
    }

    @Test
    public void lastIndexOf() {
        ImmutableShortList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf((short) (i + 1)));
        }
        Assert.assertEquals(-1L, list.lastIndexOf((short) (list.size() + 1)));
        ImmutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((short) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((short) 9));
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
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
        ImmutableShortList list = this.classUnderTest();
        short[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i]);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableShortList iterable = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        ImmutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = list1.injectIntoWithIndex(new MutableShort((short) 0), (MutableShort object, short value, int index) -> object.add((short) (value * list2.get(index))));
        Assert.assertEquals(new MutableShort((short) 14), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        ImmutableShortList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortLists.immutable.with((short) 3, (short) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = list.selectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.immutable.with((short) 3, (short) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        ImmutableShortList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortLists.immutable.with((short) 1, (short) 7), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.immutable.with((short) 1, (short) 7), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3, (short) 4, (short) 4, (short) 4, (short) 4).distinct();
        ImmutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7), this.newWith((short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        ImmutableShortList list1 = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8), this.newWith((short) 8, (short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        ImmutableShortList list2 = this.newWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((short each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        ImmutableShortList list2 = this.newWith((short) 4, (short) 3, (short) 2, (short) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (short each = 0; each < size; each++) {
            expectedString.append((short) (each + (short) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableShortList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (short each = 0; each < size; each++) {
            expectedString.append((short) (each + (short) 1));
            expectedString1.append((short) (each + (short) 1));
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
        for (short each = 0; each < size; each++) {
            expectedString.append((short) (each + (short) 1));
            expectedString1.append((short) (each + (short) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableShortList list = this.classUnderTest();
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
        ImmutableShortList immutableList = this.classUnderTest();
        MutableShortList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipShort() {
        ImmutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        ImmutableShortList list2 = this.newWith((short) 1);
        ImmutableList<ShortShortPair> zipSame = list1.zipShort(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 3, (short) 3)), zipSame);
        ImmutableList<ShortShortPair> zipSameLazy = list1.zipShort(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 3, (short) 3)), zipSameLazy);
        ImmutableList<ShortShortPair> zipLess = list1.zipShort(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1)), zipLess);
        ImmutableList<ShortShortPair> zipLessLazy = list1.zipShort(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1)), zipLessLazy);
        ImmutableList<ShortShortPair> zipMore = list2.zipShort(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1)), zipMore);
        ImmutableList<ShortShortPair> zipMoreLazy = list2.zipShort(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1)), zipMoreLazy);
        ImmutableList<ShortShortPair> zipEmpty1 = list1.zipShort(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<ShortShortPair> zipEmpty2 = this.newWith().zipShort(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        ImmutableShortList list2 = this.newWith((short) 1);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<ShortObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2"), PrimitiveTuples.pair((short) 3, "3")), zipSame);
        ImmutableList<ShortObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2"), PrimitiveTuples.pair((short) 3, "3")), zipSameLazy);
        ImmutableList<ShortObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1")), zipLess);
        ImmutableList<ShortObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1")), zipLessLazy);
        ImmutableList<ShortObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1")), zipMore);
        ImmutableList<ShortObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((short) 1, "1")), zipMoreLazy);
        ImmutableList<ShortObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<ShortObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableShortCollectionTestCase._Benchmark {

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator, this.description("shortIterator"));
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
        public void benchmark_zipShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipShort, this.description("zipShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableShortListTestCase implementation();
    }
}
