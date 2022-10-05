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

import org.eclipse.collections.api.factory.list.primitive.ImmutableFloatListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableFloatListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class FloatListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(FloatLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.FloatLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableFloatListFactory listFactory) {
        Assert.assertEquals(new FloatArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), listFactory.of(1.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), listFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(FloatLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.FloatLists.mutable);
    }

    private void assertMutableListFactory(MutableFloatListFactory listFactory) {
        Assert.assertEquals(new FloatArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), listFactory.of(1.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), listFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(MutableFloatList.class, listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(FloatLists.immutable.of());
        Assert.assertSame(FloatLists.immutable.of(), FloatLists.immutable.of());
        Verify.assertPostSerializedIdentity(FloatLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableFloatList list = FloatLists.immutable.of();
        Assert.assertEquals(list, FloatLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1.0f), FloatLists.immutable.of(1.0f));
        Assert.assertEquals(list = list.newWith(2.0f), FloatLists.immutable.of(1.0f, 2.0f));
        Assert.assertEquals(list = list.newWith(3.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(list = list.newWith(4.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(list = list.newWith(5.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(list = list.newWith(6.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(list = list.newWith(7.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(list = list.newWith(8.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(list = list.newWith(9.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(list = list.newWith(10.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(list = list.newWith(11.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f));
        Assert.assertEquals(list = list.newWith(12.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableFloatList list = FloatLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1.0f), FloatLists.immutable.of(new float[] { 1 }));
        Assert.assertEquals(list = list.newWith(2.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f }));
        Assert.assertEquals(list = list.newWith(3.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        Assert.assertEquals(list = list.newWith(4.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        Assert.assertEquals(list = list.newWith(5.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        Assert.assertEquals(list = list.newWith(6.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        Assert.assertEquals(list = list.newWith(7.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        Assert.assertEquals(list = list.newWith(8.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        Assert.assertEquals(list = list.newWith(9.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        Assert.assertEquals(list = list.newWith(10.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
        Assert.assertEquals(list = list.newWith(11.0f), FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableFloatList list = FloatLists.mutable.of();
        Assert.assertEquals(list, FloatLists.mutable.of(null));
        Assert.assertEquals(list, FloatLists.mutable.of(new float[] {}));
        list.add(1.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1 }));
        list.add(2.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f }));
        list.add(3.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        list.add(4.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        list.add(5.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        list.add(6.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        list.add(7.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        list.add(8.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        list.add(9.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        list.add(10.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
        list.add(11.0f);
        Assert.assertEquals(list, FloatLists.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f }));
    }

    @Test
    public void wrapCopy() {
        float[] array = { 0.0f, 1.0f };
        MutableFloatList actual = FloatLists.mutable.wrapCopy(array);
        MutableFloatList expected = FloatArrayList.newListWith(0.0f, 1.0f);
        array[0] = 1.0f;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableFloatList list = FloatLists.immutable.of();
        FloatArrayList floatArrayList = FloatArrayList.newListWith(1.0f);
        Assert.assertEquals(list = list.newWith(1.0f), floatArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2.0f), floatArrayList.with(2.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(3.0f), floatArrayList.with(3.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(4.0f), floatArrayList.with(4.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(5.0f), floatArrayList.with(5.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(6.0f), floatArrayList.with(6.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(7.0f), floatArrayList.with(7.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(8.0f), floatArrayList.with(8.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(9.0f), floatArrayList.with(9.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(10.0f), floatArrayList.with(10.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(11.0f), floatArrayList.with(11.0f).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new FloatArrayList(), FloatLists.immutable.ofAll(new FloatArrayList()));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new FloatArrayList(), FloatLists.immutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), FloatLists.immutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), FloatLists.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatLists.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatArrayList(), FloatLists.mutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), FloatLists.mutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), FloatLists.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatLists.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 3.0f)));
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

        private FloatListsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatListsTest();
        }

        @java.lang.Override
        public FloatListsTest implementation() {
            return this.implementation;
        }
    }
}
