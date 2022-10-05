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
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectLongToObjectIterableTest {

    private LazyIterable<Long> newPrimitiveWith(long... elements) {
        return new FlatCollectLongToObjectIterable<>(LongArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach() {
        InternalIterable<Long> collect = this.newPrimitiveWith(1L, 2L, 3L, 4L, 5L, 5L);
        MutableList<Long> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1L, 2L, 3L, 4L, 5L, 5L), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Long> collect = this.newPrimitiveWith(1L, 2L, 3L, 4L, 5L, 5L);
        MutableList<Long> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1L, 2L, 3L, 4L, 5L, 5L), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Long> collect = this.newPrimitiveWith(1L, 2L, 3L, 4L, 5L, 5L);
        MutableList<Long> result = FastList.newList();
        for (long each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1L, 2L, 3L, 4L, 5L, 5L), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Long> collect = this.newPrimitiveWith(1L, 2L, 3L, 4L, 5L, 5L);
        MutableList<Long> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((long) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2L, 3L, 4L, 5L, 6L, 6L), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith(1L, 2L, 3L, 4L, 5L), this.newPrimitiveWith(1L, 2L, 3L, 4L, 5L).selectInstancesOf(Long.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1L, 2L));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect() {
        Assert.assertEquals(Long.valueOf(2L), this.newPrimitiveWith(1L, 2L, 3L).detect(Predicates.equal(2L)));
        Assert.assertNull(this.newPrimitiveWith(1L, 2L, 3L).detect(Predicates.equal(4L)));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Long.valueOf(2L), this.newPrimitiveWith(1L, 2L, 3L).detectOptional(Predicates.equal(2L)).get());
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).detectOptional(Predicates.equal(4L)).isPresent());
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).anySatisfy(Predicates.equal(2L)));
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).anySatisfy(Predicates.equal(4L)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).anySatisfyWith(Predicates2.equal(), 2L));
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).anySatisfyWith(Predicates2.equal(), 4L));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).allSatisfy(Predicates.equal(2L)));
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).allSatisfy(Predicates.greaterThan(0L)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).allSatisfyWith(Predicates2.equal(), 2L));
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).allSatisfyWith(Predicates2.greaterThan(), 0L));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).noneSatisfy(Predicates.equal(2L)));
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).noneSatisfy(Predicates.lessThan(0L)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith(1L, 2L, 3L).noneSatisfyWith(Predicates2.equal(), 2L));
        Assert.assertTrue(this.newPrimitiveWith(1L, 2L, 3L).noneSatisfyWith(Predicates2.lessThan(), 0L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeEmptyNotEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sizeEmptyNotEmpty, this.description("sizeEmptyNotEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeThrows() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeThrows, this.description("removeThrows"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptional, this.description("detectOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        private FlatCollectLongToObjectIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FlatCollectLongToObjectIterableTest();
        }

        @java.lang.Override
        public FlatCollectLongToObjectIterableTest implementation() {
            return this.implementation;
        }
    }
}
