/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.list.primitive.ImmutableCharListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableCharListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class CharListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(CharLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.CharLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableCharListFactory listFactory) {
        Assert.assertEquals(new CharArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), listFactory.of((char) 1));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), listFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(CharLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.CharLists.mutable);
    }

    private void assertMutableListFactory(MutableCharListFactory listFactory) {
        Assert.assertEquals(new CharArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), listFactory.of((char) 1));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), listFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(MutableCharList.class, listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(CharLists.immutable.of());
        Assert.assertSame(CharLists.immutable.of(), CharLists.immutable.of());
        Verify.assertPostSerializedIdentity(CharLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableCharList list = CharLists.immutable.of();
        Assert.assertEquals(list, CharLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith((char) 1), CharLists.immutable.of((char) 1));
        Assert.assertEquals(list = list.newWith((char) 2), CharLists.immutable.of((char) 1, (char) 2));
        Assert.assertEquals(list = list.newWith((char) 3), CharLists.immutable.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(list = list.newWith((char) 4), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(list = list.newWith((char) 5), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(list = list.newWith((char) 6), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(list = list.newWith((char) 7), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(list = list.newWith((char) 8), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(list = list.newWith((char) 9), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(list = list.newWith((char) 10), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(list = list.newWith((char) 11), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11));
        Assert.assertEquals(list = list.newWith((char) 12), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11, (char) 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableCharList list = CharLists.immutable.of();
        Assert.assertEquals(list = list.newWith((char) 1), CharLists.immutable.of(new char[] { 1 }));
        Assert.assertEquals(list = list.newWith((char) 2), CharLists.immutable.of(new char[] { (char) 1, (char) 2 }));
        Assert.assertEquals(list = list.newWith((char) 3), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        Assert.assertEquals(list = list.newWith((char) 4), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        Assert.assertEquals(list = list.newWith((char) 5), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        Assert.assertEquals(list = list.newWith((char) 6), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        Assert.assertEquals(list = list.newWith((char) 7), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        Assert.assertEquals(list = list.newWith((char) 8), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        Assert.assertEquals(list = list.newWith((char) 9), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        Assert.assertEquals(list = list.newWith((char) 10), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
        Assert.assertEquals(list = list.newWith((char) 11), CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableCharList list = CharLists.mutable.of();
        Assert.assertEquals(list, CharLists.mutable.of(null));
        Assert.assertEquals(list, CharLists.mutable.of(new char[] {}));
        list.add((char) 1);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { 1 }));
        list.add((char) 2);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2 }));
        list.add((char) 3);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        list.add((char) 4);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        list.add((char) 5);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        list.add((char) 6);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        list.add((char) 7);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        list.add((char) 8);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        list.add((char) 9);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        list.add((char) 10);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
        list.add((char) 11);
        Assert.assertEquals(list, CharLists.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11 }));
    }

    @Test
    public void wrapCopy() {
        char[] array = { (char) 0, (char) 1 };
        MutableCharList actual = CharLists.mutable.wrapCopy(array);
        MutableCharList expected = CharArrayList.newListWith((char) 0, (char) 1);
        array[0] = (char) 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableCharList list = CharLists.immutable.of();
        CharArrayList charArrayList = CharArrayList.newListWith((char) 1);
        Assert.assertEquals(list = list.newWith((char) 1), charArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith((char) 2), charArrayList.with((char) 2).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 3), charArrayList.with((char) 3).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 4), charArrayList.with((char) 4).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 5), charArrayList.with((char) 5).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 6), charArrayList.with((char) 6).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 7), charArrayList.with((char) 7).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 8), charArrayList.with((char) 8).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 9), charArrayList.with((char) 9).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 10), charArrayList.with((char) 10).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 11), charArrayList.with((char) 11).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new CharArrayList(), CharLists.immutable.ofAll(new CharArrayList()));
        Assert.assertEquals(CharArrayList.newListWith((char) 1), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new CharArrayList(), CharLists.immutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayList.newListWith((char) 1), CharLists.immutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), CharLists.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharLists.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 3)));
        Assert.assertEquals(new CharArrayList(), CharLists.mutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayList.newListWith((char) 1), CharLists.mutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), CharLists.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharLists.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 3)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharListsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithWithList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> payload) throws java.lang.Throwable {
            this.instance = new CharListsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> newListWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> newListWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> newListWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> newListWithWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharListsTest> ofAllIterable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharListsTest::immutables;
            this.payloads.mutables = CharListsTest::mutables;
            this.payloads.emptyList = CharListsTest::emptyList;
            this.payloads.newListWith = CharListsTest::newListWith;
            this.payloads.newListWithArray_immutable = CharListsTest::newListWithArray_immutable;
            this.payloads.newListWithArray_mutable = CharListsTest::newListWithArray_mutable;
            this.payloads.wrapCopy = CharListsTest::wrapCopy;
            this.payloads.newListWithList = CharListsTest::newListWithList;
            this.payloads.newListWithWithList = CharListsTest::newListWithWithList;
            this.payloads.classIsNonInstantiable = CharListsTest::classIsNonInstantiable;
            this.payloads.ofAllIterable = CharListsTest::ofAllIterable;
        }
    }
}
