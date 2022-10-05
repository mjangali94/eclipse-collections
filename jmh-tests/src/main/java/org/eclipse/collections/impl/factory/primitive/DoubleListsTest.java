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

import org.eclipse.collections.api.factory.list.primitive.ImmutableDoubleListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableDoubleListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class DoubleListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(DoubleLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.DoubleLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableDoubleListFactory listFactory) {
        Assert.assertEquals(new DoubleArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), listFactory.of(1.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), listFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0), listFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(DoubleLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.DoubleLists.mutable);
    }

    private void assertMutableListFactory(MutableDoubleListFactory listFactory) {
        Assert.assertEquals(new DoubleArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), listFactory.of(1.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), listFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0), listFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(MutableDoubleList.class, listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(DoubleLists.immutable.of());
        Assert.assertSame(DoubleLists.immutable.of(), DoubleLists.immutable.of());
        Verify.assertPostSerializedIdentity(DoubleLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        Assert.assertEquals(list, DoubleLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1.0), DoubleLists.immutable.of(1.0));
        Assert.assertEquals(list = list.newWith(2.0), DoubleLists.immutable.of(1.0, 2.0));
        Assert.assertEquals(list = list.newWith(3.0), DoubleLists.immutable.of(1.0, 2.0, 3.0));
        Assert.assertEquals(list = list.newWith(4.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(list = list.newWith(5.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(list = list.newWith(6.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(list = list.newWith(7.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(list = list.newWith(8.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(list = list.newWith(9.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(list = list.newWith(10.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(list = list.newWith(11.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0));
        Assert.assertEquals(list = list.newWith(12.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1.0), DoubleLists.immutable.of(new double[] { 1 }));
        Assert.assertEquals(list = list.newWith(2.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0 }));
        Assert.assertEquals(list = list.newWith(3.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0 }));
        Assert.assertEquals(list = list.newWith(4.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        Assert.assertEquals(list = list.newWith(5.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        Assert.assertEquals(list = list.newWith(6.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        Assert.assertEquals(list = list.newWith(7.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        Assert.assertEquals(list = list.newWith(8.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        Assert.assertEquals(list = list.newWith(9.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        Assert.assertEquals(list = list.newWith(10.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
        Assert.assertEquals(list = list.newWith(11.0), DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableDoubleList list = DoubleLists.mutable.of();
        Assert.assertEquals(list, DoubleLists.mutable.of(null));
        Assert.assertEquals(list, DoubleLists.mutable.of(new double[] {}));
        list.add(1.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1 }));
        list.add(2.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0 }));
        list.add(3.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0 }));
        list.add(4.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        list.add(5.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        list.add(6.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        list.add(7.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        list.add(8.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        list.add(9.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        list.add(10.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
        list.add(11.0);
        Assert.assertEquals(list, DoubleLists.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0 }));
    }

    @Test
    public void wrapCopy() {
        double[] array = { 0.0, 1.0 };
        MutableDoubleList actual = DoubleLists.mutable.wrapCopy(array);
        MutableDoubleList expected = DoubleArrayList.newListWith(0.0, 1.0);
        array[0] = 1.0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        DoubleArrayList doubleArrayList = DoubleArrayList.newListWith(1.0);
        Assert.assertEquals(list = list.newWith(1.0), doubleArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2.0), doubleArrayList.with(2.0).toImmutable());
        Assert.assertEquals(list = list.newWith(3.0), doubleArrayList.with(3.0).toImmutable());
        Assert.assertEquals(list = list.newWith(4.0), doubleArrayList.with(4.0).toImmutable());
        Assert.assertEquals(list = list.newWith(5.0), doubleArrayList.with(5.0).toImmutable());
        Assert.assertEquals(list = list.newWith(6.0), doubleArrayList.with(6.0).toImmutable());
        Assert.assertEquals(list = list.newWith(7.0), doubleArrayList.with(7.0).toImmutable());
        Assert.assertEquals(list = list.newWith(8.0), doubleArrayList.with(8.0).toImmutable());
        Assert.assertEquals(list = list.newWith(9.0), doubleArrayList.with(9.0).toImmutable());
        Assert.assertEquals(list = list.newWith(10.0), doubleArrayList.with(10.0).toImmutable());
        Assert.assertEquals(list = list.newWith(11.0), doubleArrayList.with(11.0).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new DoubleArrayList(), DoubleLists.immutable.ofAll(new DoubleArrayList()));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new DoubleArrayList(), DoubleLists.immutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), DoubleLists.immutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), DoubleLists.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleLists.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleArrayList(), DoubleLists.mutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), DoubleLists.mutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), DoubleLists.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleLists.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 3.0)));
    }

    @Test
    public void primitiveStream() {
        Assert.assertEquals(false, DoubleLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveStream().isParallel());
    }

    @Test
    public void primitiveParallelStream() {
        Assert.assertEquals(true, DoubleLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).primitiveParallelStream().isParallel());
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

        private DoubleListsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleListsTest();
        }

        @java.lang.Override
        public DoubleListsTest implementation() {
            return this.implementation;
        }
    }
}
