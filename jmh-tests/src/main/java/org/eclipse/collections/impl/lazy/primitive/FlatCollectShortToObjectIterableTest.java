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
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectShortToObjectIterableTest {

    private LazyIterable<Short> newPrimitiveWith(short... elements) {
        return new FlatCollectShortToObjectIterable<>(ShortArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach() {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), result);
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator() {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = FastList.newList();
        for (short each : collect) {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), result);
    }

    @Test
    public void forEachWith() {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = Lists.mutable.of();
        collect.forEachWith((argument1, argument2) -> result.add((short) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith((short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 6), result);
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).selectInstancesOf(Short.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith((short) 1, (short) 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect() {
        Assert.assertEquals(Short.valueOf((short) 2), this.newPrimitiveWith((short) 1, (short) 2, (short) 3).detect(Predicates.equal((short) 2)));
        Assert.assertNull(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).detect(Predicates.equal((short) 4)));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Short.valueOf((short) 2), this.newPrimitiveWith((short) 1, (short) 2, (short) 3).detectOptional(Predicates.equal((short) 2)).get());
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).detectOptional(Predicates.equal((short) 4)).isPresent());
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).anySatisfy(Predicates.equal((short) 2)));
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).anySatisfy(Predicates.equal((short) 4)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).anySatisfyWith(Predicates2.equal(), (short) 2));
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).anySatisfyWith(Predicates2.equal(), (short) 4));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).allSatisfy(Predicates.equal((short) 2)));
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).allSatisfy(Predicates.greaterThan((short) 0)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).allSatisfyWith(Predicates2.equal(), (short) 2));
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).allSatisfyWith(Predicates2.greaterThan(), (short) 0));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).noneSatisfy(Predicates.equal((short) 2)));
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).noneSatisfy(Predicates.lessThan((short) 0)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).noneSatisfyWith(Predicates2.equal(), (short) 2));
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2, (short) 3).noneSatisfyWith(Predicates2.lessThan(), (short) 0));
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

        private FlatCollectShortToObjectIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FlatCollectShortToObjectIterableTest();
        }

        @java.lang.Override
        public FlatCollectShortToObjectIterableTest implementation() {
            return this.implementation;
        }
    }
}
