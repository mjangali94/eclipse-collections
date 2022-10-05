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

import org.eclipse.collections.api.factory.list.primitive.ImmutableLongListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableLongListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class LongListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(LongLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.LongLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableLongListFactory listFactory) {
        Assert.assertEquals(new LongArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of());
        Assert.assertEquals(LongArrayList.newListWith(1L), listFactory.of(1L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), listFactory.of(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L), listFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), listFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(LongLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.LongLists.mutable);
    }

    private void assertMutableListFactory(MutableLongListFactory listFactory) {
        Assert.assertEquals(new LongArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of());
        Assert.assertEquals(LongArrayList.newListWith(1L), listFactory.of(1L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), listFactory.of(1L, 2L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L), listFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), listFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(MutableLongList.class, listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(LongLists.immutable.of());
        Assert.assertSame(LongLists.immutable.of(), LongLists.immutable.of());
        Verify.assertPostSerializedIdentity(LongLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableLongList list = LongLists.immutable.of();
        Assert.assertEquals(list, LongLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1L), LongLists.immutable.of(1L));
        Assert.assertEquals(list = list.newWith(2L), LongLists.immutable.of(1L, 2L));
        Assert.assertEquals(list = list.newWith(3L), LongLists.immutable.of(1L, 2L, 3L));
        Assert.assertEquals(list = list.newWith(4L), LongLists.immutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(list = list.newWith(5L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(list = list.newWith(6L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(list = list.newWith(7L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(list = list.newWith(8L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(list = list.newWith(9L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(list = list.newWith(10L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(list = list.newWith(11L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L));
        Assert.assertEquals(list = list.newWith(12L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableLongList list = LongLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1L), LongLists.immutable.of(new long[] { 1 }));
        Assert.assertEquals(list = list.newWith(2L), LongLists.immutable.of(new long[] { 1L, 2L }));
        Assert.assertEquals(list = list.newWith(3L), LongLists.immutable.of(new long[] { 1L, 2L, 3L }));
        Assert.assertEquals(list = list.newWith(4L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L }));
        Assert.assertEquals(list = list.newWith(5L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        Assert.assertEquals(list = list.newWith(6L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        Assert.assertEquals(list = list.newWith(7L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        Assert.assertEquals(list = list.newWith(8L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        Assert.assertEquals(list = list.newWith(9L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        Assert.assertEquals(list = list.newWith(10L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
        Assert.assertEquals(list = list.newWith(11L), LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableLongList list = LongLists.mutable.of();
        Assert.assertEquals(list, LongLists.mutable.of(null));
        Assert.assertEquals(list, LongLists.mutable.of(new long[] {}));
        list.add(1L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1 }));
        list.add(2L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L }));
        list.add(3L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L }));
        list.add(4L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L }));
        list.add(5L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        list.add(6L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        list.add(7L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        list.add(8L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        list.add(9L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        list.add(10L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
        list.add(11L);
        Assert.assertEquals(list, LongLists.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L }));
    }

    @Test
    public void wrapCopy() {
        long[] array = { 0L, 1L };
        MutableLongList actual = LongLists.mutable.wrapCopy(array);
        MutableLongList expected = LongArrayList.newListWith(0L, 1L);
        array[0] = 1L;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableLongList list = LongLists.immutable.of();
        LongArrayList longArrayList = LongArrayList.newListWith(1L);
        Assert.assertEquals(list = list.newWith(1L), longArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2L), longArrayList.with(2L).toImmutable());
        Assert.assertEquals(list = list.newWith(3L), longArrayList.with(3L).toImmutable());
        Assert.assertEquals(list = list.newWith(4L), longArrayList.with(4L).toImmutable());
        Assert.assertEquals(list = list.newWith(5L), longArrayList.with(5L).toImmutable());
        Assert.assertEquals(list = list.newWith(6L), longArrayList.with(6L).toImmutable());
        Assert.assertEquals(list = list.newWith(7L), longArrayList.with(7L).toImmutable());
        Assert.assertEquals(list = list.newWith(8L), longArrayList.with(8L).toImmutable());
        Assert.assertEquals(list = list.newWith(9L), longArrayList.with(9L).toImmutable());
        Assert.assertEquals(list = list.newWith(10L), longArrayList.with(10L).toImmutable());
        Assert.assertEquals(list = list.newWith(11L), longArrayList.with(11L).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new LongArrayList(), LongLists.immutable.ofAll(new LongArrayList()));
        Assert.assertEquals(LongArrayList.newListWith(1L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new LongArrayList(), LongLists.immutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayList.newListWith(1L), LongLists.immutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), LongLists.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongLists.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 3L)));
        Assert.assertEquals(new LongArrayList(), LongLists.mutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayList.newListWith(1L), LongLists.mutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), LongLists.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongLists.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 3L)));
    }

    @Test
    public void primitiveStream() {
        Assert.assertEquals(false, LongLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveStream().isParallel());
    }

    @Test
    public void primitiveParallelStream() {
        Assert.assertEquals(true, LongLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveParallelStream().isParallel());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyList, this.description("emptyList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWith, this.description("newListWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithArray_immutable, this.description("newListWithArray_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithArray_mutable, this.description("newListWithArray_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::wrapCopy, this.description("wrapCopy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithList, this.description("newListWithList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWithList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithWithList, this.description("newListWithWithList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllIterable, this.description("ofAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::primitiveStream, this.description("primitiveStream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveParallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::primitiveParallelStream, this.description("primitiveParallelStream"));
        }

        private LongListsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongListsTest();
        }

        @java.lang.Override
        public LongListsTest implementation() {
            return this.implementation;
        }
    }
}
