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

import org.eclipse.collections.api.factory.list.primitive.ImmutableIntListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableIntListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class IntListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(IntLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.IntLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableIntListFactory listFactory) {
        Assert.assertEquals(new IntArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of());
        Assert.assertEquals(IntArrayList.newListWith(1), listFactory.of(1));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), listFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4), listFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), listFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6), listFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7), listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(IntLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.IntLists.mutable);
    }

    private void assertMutableListFactory(MutableIntListFactory listFactory) {
        Assert.assertEquals(new IntArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of());
        Assert.assertEquals(IntArrayList.newListWith(1), listFactory.of(1));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), listFactory.of(1, 2));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.of(1, 2, 3));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4), listFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), listFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6), listFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7), listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
        Verify.assertInstanceOf(MutableIntList.class, listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(IntLists.immutable.of());
        Assert.assertSame(IntLists.immutable.of(), IntLists.immutable.of());
        Verify.assertPostSerializedIdentity(IntLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableIntList list = IntLists.immutable.of();
        Assert.assertEquals(list, IntLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1), IntLists.immutable.of(1));
        Assert.assertEquals(list = list.newWith(2), IntLists.immutable.of(1, 2));
        Assert.assertEquals(list = list.newWith(3), IntLists.immutable.of(1, 2, 3));
        Assert.assertEquals(list = list.newWith(4), IntLists.immutable.of(1, 2, 3, 4));
        Assert.assertEquals(list = list.newWith(5), IntLists.immutable.of(1, 2, 3, 4, 5));
        Assert.assertEquals(list = list.newWith(6), IntLists.immutable.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(list = list.newWith(7), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(list = list.newWith(8), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(list = list.newWith(9), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(list = list.newWith(10), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(list = list.newWith(11), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Assert.assertEquals(list = list.newWith(12), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableIntList list = IntLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1), IntLists.immutable.of(new int[] { 1 }));
        Assert.assertEquals(list = list.newWith(2), IntLists.immutable.of(new int[] { 1, 2 }));
        Assert.assertEquals(list = list.newWith(3), IntLists.immutable.of(new int[] { 1, 2, 3 }));
        Assert.assertEquals(list = list.newWith(4), IntLists.immutable.of(new int[] { 1, 2, 3, 4 }));
        Assert.assertEquals(list = list.newWith(5), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(list = list.newWith(6), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        Assert.assertEquals(list = list.newWith(7), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        Assert.assertEquals(list = list.newWith(8), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        Assert.assertEquals(list = list.newWith(9), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        Assert.assertEquals(list = list.newWith(10), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
        Assert.assertEquals(list = list.newWith(11), IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableIntList list = IntLists.mutable.of();
        Assert.assertEquals(list, IntLists.mutable.of(null));
        Assert.assertEquals(list, IntLists.mutable.of(new int[] {}));
        list.add(1);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1 }));
        list.add(2);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2 }));
        list.add(3);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3 }));
        list.add(4);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4 }));
        list.add(5);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5 }));
        list.add(6);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        list.add(7);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        list.add(8);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        list.add(9);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        list.add(10);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
        list.add(11);
        Assert.assertEquals(list, IntLists.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }));
    }

    @Test
    public void wrapCopy() {
        int[] array = { 0, 1 };
        MutableIntList actual = IntLists.mutable.wrapCopy(array);
        MutableIntList expected = IntArrayList.newListWith(0, 1);
        array[0] = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableIntList list = IntLists.immutable.of();
        IntArrayList intArrayList = IntArrayList.newListWith(1);
        Assert.assertEquals(list = list.newWith(1), intArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2), intArrayList.with(2).toImmutable());
        Assert.assertEquals(list = list.newWith(3), intArrayList.with(3).toImmutable());
        Assert.assertEquals(list = list.newWith(4), intArrayList.with(4).toImmutable());
        Assert.assertEquals(list = list.newWith(5), intArrayList.with(5).toImmutable());
        Assert.assertEquals(list = list.newWith(6), intArrayList.with(6).toImmutable());
        Assert.assertEquals(list = list.newWith(7), intArrayList.with(7).toImmutable());
        Assert.assertEquals(list = list.newWith(8), intArrayList.with(8).toImmutable());
        Assert.assertEquals(list = list.newWith(9), intArrayList.with(9).toImmutable());
        Assert.assertEquals(list = list.newWith(10), intArrayList.with(10).toImmutable());
        Assert.assertEquals(list = list.newWith(11), intArrayList.with(11).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new IntArrayList(), IntLists.immutable.ofAll(new IntArrayList()));
        Assert.assertEquals(IntArrayList.newListWith(1), IntLists.immutable.ofAll(IntArrayList.newListWith(1)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), IntLists.immutable.ofAll(IntArrayList.newListWith(1, 2)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntLists.immutable.ofAll(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new IntArrayList(), IntLists.immutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayList.newListWith(1), IntLists.immutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), IntLists.immutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntLists.immutable.ofAll(Lists.mutable.<Integer>with(1, 2, 3)));
        Assert.assertEquals(new IntArrayList(), IntLists.mutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayList.newListWith(1), IntLists.mutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), IntLists.mutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntLists.mutable.ofAll(Lists.mutable.<Integer>with(1, 2, 3)));
    }

    @Test
    public void primitiveStream() {
        Assert.assertEquals(false, IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveStream().isParallel());
    }

    @Test
    public void primitiveParallelStream() {
        Assert.assertEquals(true, IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveParallelStream().isParallel());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntListsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithWithList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveParallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveParallelStream);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> payload) throws java.lang.Throwable {
            this.instance = new IntListsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> newListWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> newListWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> newListWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> newListWithWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> primitiveStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntListsTest> primitiveParallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = IntListsTest::immutables;
            this.payloads.mutables = IntListsTest::mutables;
            this.payloads.emptyList = IntListsTest::emptyList;
            this.payloads.newListWith = IntListsTest::newListWith;
            this.payloads.newListWithArray_immutable = IntListsTest::newListWithArray_immutable;
            this.payloads.newListWithArray_mutable = IntListsTest::newListWithArray_mutable;
            this.payloads.wrapCopy = IntListsTest::wrapCopy;
            this.payloads.newListWithList = IntListsTest::newListWithList;
            this.payloads.newListWithWithList = IntListsTest::newListWithWithList;
            this.payloads.classIsNonInstantiable = IntListsTest::classIsNonInstantiable;
            this.payloads.ofAllIterable = IntListsTest::ofAllIterable;
            this.payloads.primitiveStream = IntListsTest::primitiveStream;
            this.payloads.primitiveParallelStream = IntListsTest::primitiveParallelStream;
        }
    }
*/
}
