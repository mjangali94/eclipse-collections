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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableFloatListTestCase extends AbstractImmutableFloatCollectionTestCase {

    @Override
    protected abstract ImmutableFloatList classUnderTest();

    @Override
    protected ImmutableFloatList newWith(float... elements) {
        return FloatLists.immutable.of(elements);
    }

    @Override
    protected MutableFloatList newMutableCollectionWith(float... elements) {
        return FloatArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Float> newObjectCollectionWith(Float... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableFloatList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i + 1, list.get(i), 0.0);
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
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test
    public void getLast() {
        ImmutableFloatList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast(), 0.0);
    }

    @Test
    public void indexOf() {
        ImmutableFloatList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.indexOf(list.size() + 1), 0.0);
        ImmutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(0L, arrayList.indexOf(1.0f));
        Assert.assertEquals(1L, arrayList.indexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0f));
    }

    @Test
    public void lastIndexOf() {
        ImmutableFloatList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.lastIndexOf(list.size() + 1), 0.0);
        ImmutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0f));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0f));
    }

    @Override
    @Test
    public void floatIterator() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Assert.assertEquals(i + 1, iterator.next(), 0.0);
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
        ImmutableFloatList list = this.classUnderTest();
        float[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i], 0.0);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableFloatList iterable = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = list1.injectIntoWithIndex(new MutableFloat(0.0f), (MutableFloat object, float value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableFloat(14.0f), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        ImmutableFloatList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatLists.immutable.with(3.0f, 9.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = list.selectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.immutable.with(3.0f, 9.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        ImmutableFloatList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatLists.immutable.with(1.0f, 7.0f), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.immutable.with(1.0f, 7.0f), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableFloatList list1 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 4.0f, 4.0f, 4.0f, 4.0f).distinct();
        ImmutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableFloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f), this.newWith(7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        ImmutableFloatList list1 = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f), this.newWith(8.0f, 7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        ImmutableFloatList list2 = this.newWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((float each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        ImmutableFloatList list2 = this.newWith(4.0f, 3.0f, 2.0f, 1.0f);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (float each = 0; each < size; each++) {
            expectedString.append((float) (each + 1.0f));
            expectedString.append((int) each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableFloatList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (float each = 0; each < size; each++) {
            expectedString.append((float) (each + 1.0f));
            expectedString1.append((float) (each + 1.0f));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
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
        for (float each = 0; each < size; each++) {
            expectedString.append((float) (each + 1.0f));
            expectedString1.append((float) (each + 1.0f));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
        }
        ImmutableFloatList list = this.classUnderTest();
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
        ImmutableFloatList immutableList = this.classUnderTest();
        MutableFloatList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipFloat() {
        ImmutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatList list2 = this.newWith(1.0f);
        ImmutableList<FloatFloatPair> zipSame = list1.zipFloat(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(3.0f, 3.0f)), zipSame);
        ImmutableList<FloatFloatPair> zipSameLazy = list1.zipFloat(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(3.0f, 3.0f)), zipSameLazy);
        ImmutableList<FloatFloatPair> zipLess = list1.zipFloat(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f)), zipLess);
        ImmutableList<FloatFloatPair> zipLessLazy = list1.zipFloat(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f)), zipLessLazy);
        ImmutableList<FloatFloatPair> zipMore = list2.zipFloat(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f)), zipMore);
        ImmutableList<FloatFloatPair> zipMoreLazy = list2.zipFloat(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f)), zipMoreLazy);
        ImmutableList<FloatFloatPair> zipEmpty1 = list1.zipFloat(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<FloatFloatPair> zipEmpty2 = this.newWith().zipFloat(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatList list2 = this.newWith(1.0f);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<FloatObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2"), PrimitiveTuples.pair(3.0f, "3")), zipSame);
        ImmutableList<FloatObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2"), PrimitiveTuples.pair(3.0f, "3")), zipSameLazy);
        ImmutableList<FloatObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1")), zipLess);
        ImmutableList<FloatObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1")), zipLessLazy);
        ImmutableList<FloatObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1")), zipMore);
        ImmutableList<FloatObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0f, "1")), zipMoreLazy);
        ImmutableList<FloatObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<FloatObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase._Benchmark {

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipFloat, this.description("zipFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableFloatListTestCase implementation();
    }
}
