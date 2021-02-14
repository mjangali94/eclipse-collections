/*
 * Copyright (c) 2015 Goldman Sachs.
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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CollectBooleanToObjectIterableTest {

    private LazyIterable<Boolean> newPrimitiveWith(boolean... elements) {
        return new CollectBooleanToObjectIterable<>(BooleanArrayList.newListWith(elements), Boolean::valueOf);
    }

    @Test
    public void forEach() {
        InternalIterable<Boolean> select = this.newPrimitiveWith(true, false, true, false, true);
        Appendable builder = new StringBuilder();
        Procedure<Boolean> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("truefalsetruefalsetrue", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Boolean> select = this.newPrimitiveWith(true, false, true, false, true);
        StringBuilder builder = new StringBuilder();
        select.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("true0false1true2false3true4", builder.toString());
    }

    @Test
    public void iterator() {
        InternalIterable<Boolean> select = this.newPrimitiveWith(true, false, true, false, true);
        StringBuilder builder = new StringBuilder();
        for (Boolean each : select) {
            builder.append(each);
        }
        Assert.assertEquals("truefalsetruefalsetrue", builder.toString());
    }

    @Test
    public void forEachWith() {
        InternalIterable<Boolean> select = this.newPrimitiveWith(true, false, true, false, true);
        StringBuilder builder = new StringBuilder();
        select.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("truefalsetruefalsetrue", builder.toString());
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(FastList.newListWith(true, false, true, false, true), this.newPrimitiveWith(true, false, true, false, true).selectInstancesOf(Boolean.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty() {
        Verify.assertIterableSize(2, this.newPrimitiveWith(true, false));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(true, false).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows() {
        this.newPrimitiveWith().iterator().remove();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
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

        private CollectBooleanToObjectIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectBooleanToObjectIterableTest();
        }

        @java.lang.Override
        public CollectBooleanToObjectIterableTest implementation() {
            return this.implementation;
        }
    }
}
