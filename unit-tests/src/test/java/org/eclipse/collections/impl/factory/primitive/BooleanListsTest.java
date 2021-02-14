/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.list.primitive.ImmutableBooleanListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanListsTest {

    @Test
    public void immutables() {
        ImmutableBooleanListFactory listFactory = BooleanLists.immutable;
        Assert.assertEquals(new BooleanArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of());
        Assert.assertEquals(BooleanArrayList.newListWith(true), listFactory.of(true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false), listFactory.of(true, false));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), listFactory.of(true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false), listFactory.of(true, false, true, false));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true), listFactory.of(true, false, true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, false), listFactory.of(true, false, true, false, true, false));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true, false));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, false, true), listFactory.of(true, false, true, false, true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true, false, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, false, true, true), listFactory.of(true, false, true, false, true, false, true, true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true, false, true, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, false, true, true, true), listFactory.of(true, false, true, false, true, false, true, true, true));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true, false, true, true, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, false, true, true, true, false), listFactory.of(true, false, true, false, true, false, true, true, true, false));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.of(true, false, true, false, true, false, true, true, true, false));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), listFactory.ofAll(BooleanArrayList.newListWith(true, false, true)));
        Verify.assertInstanceOf(ImmutableBooleanList.class, listFactory.ofAll(BooleanArrayList.newListWith(true, false, true)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(BooleanLists.immutable.of());
        Assert.assertSame(BooleanLists.immutable.of(), BooleanLists.immutable.of());
        Verify.assertPostSerializedIdentity(BooleanLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableBooleanList list = BooleanLists.immutable.of();
        Assert.assertEquals(list, BooleanLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(true, false));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(true, false, true, false));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true, false, true));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(true, false, true, false, true, false));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true, false, true, false, true));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true, false, true, false, true, true));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true, false, true, false, true, true, true));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(true, false, true, false, true, false, true, true, true, false));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(true, false, true, false, true, false, true, true, true, false, true));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(true, false, true, false, true, false, true, true, true, false, true, false));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray() {
        ImmutableBooleanList list = BooleanLists.immutable.of();
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true }));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(new boolean[] { true, false }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true }));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(new boolean[] { true, false, true, false }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true }));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false, true }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false, true, true }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false, true, true, true }));
        Assert.assertEquals(list = list.newWith(false), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false, true, true, true, false }));
        Assert.assertEquals(list = list.newWith(true), BooleanLists.immutable.of(new boolean[] { true, false, true, false, true, false, true, true, true, false, true }));
    }

    @Test
    public void newListWithList() {
        ImmutableBooleanList list = BooleanLists.immutable.of();
        BooleanArrayList booleanArrayList = BooleanArrayList.newListWith(true);
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(false), booleanArrayList.with(false).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
        Assert.assertEquals(list = list.newWith(false), booleanArrayList.with(false).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
        Assert.assertEquals(list = list.newWith(false), booleanArrayList.with(false).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
        Assert.assertEquals(list = list.newWith(false), booleanArrayList.with(false).toImmutable());
        Assert.assertEquals(list = list.newWith(true), booleanArrayList.with(true).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new BooleanArrayList(), BooleanLists.immutable.ofAll(new BooleanArrayList()));
        Assert.assertEquals(BooleanArrayList.newListWith(true), BooleanLists.immutable.ofAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false), BooleanLists.immutable.ofAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), BooleanLists.immutable.ofAll(BooleanArrayList.newListWith(true, false, true)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(BooleanLists.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
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
        public void benchmark_newListWithArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithArray, this.description("newListWithArray"));
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

        private BooleanListsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanListsTest();
        }

        @java.lang.Override
        public BooleanListsTest implementation() {
            return this.implementation;
        }
    }
}
