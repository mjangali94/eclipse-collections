/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectByteToObjectIterableTest {

    private LazyIterable<Byte> newPrimitiveWith(byte... elements) {
        return new FlatCollectByteToObjectIterable<>(ByteArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach() {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = FastList.newList();
        for (byte each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((byte) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith((byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 6), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).selectInstancesOf(Byte.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith((byte) 1, (byte) 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect() {
        Assert.assertEquals(Byte.valueOf((byte) 2), this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detect(Predicates.equal((byte) 2)));
        Assert.assertNull(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detect(Predicates.equal((byte) 4)));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Byte.valueOf((byte) 2), this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detectOptional(Predicates.equal((byte) 2)).get());
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detectOptional(Predicates.equal((byte) 4)).isPresent());
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfy(Predicates.equal((byte) 2)));
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfy(Predicates.equal((byte) 4)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfyWith(Predicates2.equal(), (byte) 4));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfy(Predicates.equal((byte) 2)));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfy(Predicates.greaterThan((byte) 0)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfyWith(Predicates2.greaterThan(), (byte) 0));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfy(Predicates.equal((byte) 2)));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfy(Predicates.lessThan((byte) 0)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfyWith(Predicates2.lessThan(), (byte) 0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectByteToObjectIterableTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectByteToObjectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> sizeEmptyNotEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> removeThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectByteToObjectIterableTest> noneSatisfyWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = FlatCollectByteToObjectIterableTest::forEach;
            this.payloads.forEachWithIndex = FlatCollectByteToObjectIterableTest::forEachWithIndex;
            this.payloads.iterator = FlatCollectByteToObjectIterableTest::iterator;
            this.payloads.forEachWith = FlatCollectByteToObjectIterableTest::forEachWith;
            this.payloads.selectInstancesOf = FlatCollectByteToObjectIterableTest::selectInstancesOf;
            this.payloads.sizeEmptyNotEmpty = FlatCollectByteToObjectIterableTest::sizeEmptyNotEmpty;
            this.payloads.removeThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectByteToObjectIterableTest::removeThrows, java.lang.UnsupportedOperationException.class);
            this.payloads.detect = FlatCollectByteToObjectIterableTest::detect;
            this.payloads.detectOptional = FlatCollectByteToObjectIterableTest::detectOptional;
            this.payloads.anySatisfy = FlatCollectByteToObjectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = FlatCollectByteToObjectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = FlatCollectByteToObjectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = FlatCollectByteToObjectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = FlatCollectByteToObjectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = FlatCollectByteToObjectIterableTest::noneSatisfyWith;
        }
    }
}
