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
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectCharToObjectIterableTest {

    private LazyIterable<Character> newPrimitiveWith(char... elements) {
        return new FlatCollectCharToObjectIterable<>(CharArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach() {
        InternalIterable<Character> collect = this.newPrimitiveWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5);
        MutableList<Character> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Character> collect = this.newPrimitiveWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5);
        MutableList<Character> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Character> collect = this.newPrimitiveWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5);
        MutableList<Character> result = FastList.newList();
        for (char each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Character> collect = this.newPrimitiveWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 5);
        MutableList<Character> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((char) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith((char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 6), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), this.newPrimitiveWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).selectInstancesOf(Character.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith((char) 1, (char) 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect() {
        Assert.assertEquals(Character.valueOf((char) 2), this.newPrimitiveWith((char) 1, (char) 2, (char) 3).detect(Predicates.equal((char) 2)));
        Assert.assertNull(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).detect(Predicates.equal((char) 4)));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Character.valueOf((char) 2), this.newPrimitiveWith((char) 1, (char) 2, (char) 3).detectOptional(Predicates.equal((char) 2)).get());
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).detectOptional(Predicates.equal((char) 4)).isPresent());
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).anySatisfy(Predicates.equal((char) 2)));
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).anySatisfy(Predicates.equal((char) 4)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).anySatisfyWith(Predicates2.equal(), (char) 2));
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).anySatisfyWith(Predicates2.equal(), (char) 4));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).allSatisfy(Predicates.equal((char) 2)));
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).allSatisfy(Predicates.greaterThan((char) 0)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).allSatisfyWith(Predicates2.equal(), (char) 2));
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).allSatisfyWith(Predicates2.greaterThan(), (char) 0));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).noneSatisfy(Predicates.equal((char) 2)));
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).noneSatisfy(Predicates.lessThan((char) 0)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).noneSatisfyWith(Predicates2.equal(), (char) 2));
        Assert.assertTrue(this.newPrimitiveWith((char) 1, (char) 2, (char) 3).noneSatisfyWith(Predicates2.lessThan(), (char) 0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectCharToObjectIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectCharToObjectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> sizeEmptyNotEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> removeThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectCharToObjectIterableTest> noneSatisfyWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = FlatCollectCharToObjectIterableTest::forEach;
            this.payloads.forEachWithIndex = FlatCollectCharToObjectIterableTest::forEachWithIndex;
            this.payloads.iterator = FlatCollectCharToObjectIterableTest::iterator;
            this.payloads.forEachWith = FlatCollectCharToObjectIterableTest::forEachWith;
            this.payloads.selectInstancesOf = FlatCollectCharToObjectIterableTest::selectInstancesOf;
            this.payloads.sizeEmptyNotEmpty = FlatCollectCharToObjectIterableTest::sizeEmptyNotEmpty;
            this.payloads.removeThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectCharToObjectIterableTest::removeThrows, java.lang.UnsupportedOperationException.class);
            this.payloads.detect = FlatCollectCharToObjectIterableTest::detect;
            this.payloads.detectOptional = FlatCollectCharToObjectIterableTest::detectOptional;
            this.payloads.anySatisfy = FlatCollectCharToObjectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = FlatCollectCharToObjectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = FlatCollectCharToObjectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = FlatCollectCharToObjectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = FlatCollectCharToObjectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = FlatCollectCharToObjectIterableTest::noneSatisfyWith;
        }
    }
}
