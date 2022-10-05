/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveToObjectIterableTest.stg.
 */
public class CollectFloatToObjectIterableTest {

    private LazyIterable<Float> newPrimitiveWith(float... elements) {
        return new CollectFloatToObjectIterable<>(FloatArrayList.newListWith(elements), Float::valueOf);
    }

    @Test
    public void forEach() {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = Lists.mutable.of();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = FastList.newList();
        for (float each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((float) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 6.0f), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).selectInstancesOf(Float.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1.0f, 2.0f));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectFloatToObjectIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeEmptyNotEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeEmptyNotEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeThrows);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectFloatToObjectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> sizeEmptyNotEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatToObjectIterableTest> removeThrows;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = CollectFloatToObjectIterableTest::forEach;
            this.payloads.forEachWithIndex = CollectFloatToObjectIterableTest::forEachWithIndex;
            this.payloads.iterator = CollectFloatToObjectIterableTest::iterator;
            this.payloads.forEachWith = CollectFloatToObjectIterableTest::forEachWith;
            this.payloads.selectInstancesOf = CollectFloatToObjectIterableTest::selectInstancesOf;
            this.payloads.sizeEmptyNotEmpty = CollectFloatToObjectIterableTest::sizeEmptyNotEmpty;
            this.payloads.removeThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectFloatToObjectIterableTest::removeThrows, java.lang.UnsupportedOperationException.class);
        }
    }
}
