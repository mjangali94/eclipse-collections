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
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectIntToObjectIterableTest {

    private LazyIterable<Integer> newPrimitiveWith(int... elements) {
        return new FlatCollectIntToObjectIterable<>(IntArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach() {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = FastList.newList();
        for (int each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((int) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2, 3, 4, 5, 6, 6), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), this.newPrimitiveWith(1, 2, 3, 4, 5).selectInstancesOf(Integer.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1, 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1, 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(2), this.newPrimitiveWith(1, 2, 3).detect(Predicates.equal(2)));
        Assert.assertNull(this.newPrimitiveWith(1, 2, 3).detect(Predicates.equal(4)));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Integer.valueOf(2), this.newPrimitiveWith(1, 2, 3).detectOptional(Predicates.equal(2)).get());
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).detectOptional(Predicates.equal(4)).isPresent());
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).anySatisfy(Predicates.equal(2)));
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).anySatisfy(Predicates.equal(4)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).anySatisfyWith(Predicates2.equal(), 2));
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).anySatisfyWith(Predicates2.equal(), 4));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).allSatisfy(Predicates.equal(2)));
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).allSatisfy(Predicates.greaterThan(0)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).allSatisfyWith(Predicates2.equal(), 2));
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).allSatisfyWith(Predicates2.greaterThan(), 0));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).noneSatisfy(Predicates.equal(2)));
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).noneSatisfy(Predicates.lessThan(0)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith(1, 2, 3).noneSatisfyWith(Predicates2.equal(), 2));
        Assert.assertTrue(this.newPrimitiveWith(1, 2, 3).noneSatisfyWith(Predicates2.lessThan(), 0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectIntToObjectIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeEmptyNotEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeEmptyNotEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectIntToObjectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> sizeEmptyNotEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> removeThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIntToObjectIterableTest> noneSatisfyWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = FlatCollectIntToObjectIterableTest::forEach;
            this.payloads.forEachWithIndex = FlatCollectIntToObjectIterableTest::forEachWithIndex;
            this.payloads.iterator = FlatCollectIntToObjectIterableTest::iterator;
            this.payloads.forEachWith = FlatCollectIntToObjectIterableTest::forEachWith;
            this.payloads.selectInstancesOf = FlatCollectIntToObjectIterableTest::selectInstancesOf;
            this.payloads.sizeEmptyNotEmpty = FlatCollectIntToObjectIterableTest::sizeEmptyNotEmpty;
            this.payloads.removeThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIntToObjectIterableTest::removeThrows, java.lang.UnsupportedOperationException.class);
            this.payloads.detect = FlatCollectIntToObjectIterableTest::detect;
            this.payloads.detectOptional = FlatCollectIntToObjectIterableTest::detectOptional;
            this.payloads.anySatisfy = FlatCollectIntToObjectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = FlatCollectIntToObjectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = FlatCollectIntToObjectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = FlatCollectIntToObjectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = FlatCollectIntToObjectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = FlatCollectIntToObjectIterableTest::noneSatisfyWith;
        }
    }
}
