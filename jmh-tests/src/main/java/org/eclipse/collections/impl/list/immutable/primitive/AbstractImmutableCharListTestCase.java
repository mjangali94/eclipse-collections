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

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableCharListTestCase extends AbstractImmutableCharCollectionTestCase {

    @Override
    protected abstract ImmutableCharList classUnderTest();

    @Override
    protected ImmutableCharList newWith(char... elements) {
        return CharLists.immutable.of(elements);
    }

    @Override
    protected MutableCharList newMutableCollectionWith(char... elements) {
        return CharArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Character> newObjectCollectionWith(Character... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableCharList list = this.classUnderTest();
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
        ImmutableCharList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast());
    }

    @Test
    public void indexOf() {
        ImmutableCharList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf((char) (i + 1)));
        }
        Assert.assertEquals(-1L, list.indexOf((char) (list.size() + 1)));
        ImmutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(0L, arrayList.indexOf((char) 1));
        Assert.assertEquals(1L, arrayList.indexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((char) 9));
    }

    @Test
    public void lastIndexOf() {
        ImmutableCharList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf((char) (i + 1)));
        }
        Assert.assertEquals(-1L, list.lastIndexOf((char) (list.size() + 1)));
        ImmutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((char) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((char) 9));
    }

    @Override
    @Test
    public void charIterator() {
        CharIterator iterator = this.classUnderTest().charIterator();
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
        ImmutableCharList list = this.classUnderTest();
        char[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i]);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableCharList iterable = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        ImmutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0), (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 14), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        ImmutableCharList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(CharLists.immutable.with((char) 3, (char) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList selected = list.selectWithIndex((value, i) -> i % 2 == 0, CharLists.mutable.empty());
        Assert.assertEquals(CharLists.immutable.with((char) 3, (char) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        ImmutableCharList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(CharLists.immutable.with((char) 1, (char) 7), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, CharLists.mutable.empty());
        Assert.assertEquals(CharLists.immutable.with((char) 1, (char) 7), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(CharSets.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 4, (char) 4, (char) 4, (char) 4).distinct();
        ImmutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableCharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7), this.newWith((char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        ImmutableCharList list1 = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8), this.newWith((char) 8, (char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        ImmutableCharList list2 = this.newWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        ImmutableCharList list2 = this.newWith((char) 4, (char) 3, (char) 2, (char) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableCharList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
            expectedString1.append((char) (each + (char) 1));
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
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
            expectedString1.append((char) (each + (char) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableCharList list = this.classUnderTest();
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
        ImmutableCharList immutableList = this.classUnderTest();
        MutableCharList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipChar() {
        ImmutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        ImmutableCharList list2 = this.newWith((char) 1);
        ImmutableList<CharCharPair> zipSame = list1.zipChar(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2), PrimitiveTuples.pair((char) 3, (char) 3)), zipSame);
        ImmutableList<CharCharPair> zipSameLazy = list1.zipChar(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2), PrimitiveTuples.pair((char) 3, (char) 3)), zipSameLazy);
        ImmutableList<CharCharPair> zipLess = list1.zipChar(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1)), zipLess);
        ImmutableList<CharCharPair> zipLessLazy = list1.zipChar(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1)), zipLessLazy);
        ImmutableList<CharCharPair> zipMore = list2.zipChar(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1)), zipMore);
        ImmutableList<CharCharPair> zipMoreLazy = list2.zipChar(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1)), zipMoreLazy);
        ImmutableList<CharCharPair> zipEmpty1 = list1.zipChar(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<CharCharPair> zipEmpty2 = this.newWith().zipChar(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        ImmutableCharList list2 = this.newWith((char) 1);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<CharObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2"), PrimitiveTuples.pair((char) 3, "3")), zipSame);
        ImmutableList<CharObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2"), PrimitiveTuples.pair((char) 3, "3")), zipSameLazy);
        ImmutableList<CharObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1")), zipLess);
        ImmutableList<CharObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1")), zipLessLazy);
        ImmutableList<CharObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1")), zipMore);
        ImmutableList<CharObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair((char) 1, "1")), zipMoreLazy);
        ImmutableList<CharObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<CharObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase._Benchmark {

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator, this.description("charIterator"));
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
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipChar, this.description("zipChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableCharListTestCase implementation();
    }
}
