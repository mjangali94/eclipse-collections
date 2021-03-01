/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.junit.Assert;
import org.junit.Test;

public class CollectBooleanProcedureTest {

    @Test
    public void basicCase() {
        BooleanFunction<String> stringIsEmptyFunction = String::isEmpty;
        MutableBooleanList targetList = BooleanLists.mutable.empty();
        CollectBooleanProcedure<String> procedure = new CollectBooleanProcedure(stringIsEmptyFunction, targetList);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        ImmutableBooleanList expected = BooleanLists.immutable.with(true, false, false);
        Assert.assertEquals(expected, targetList);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        private CollectBooleanProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectBooleanProcedureTest();
        }

        @java.lang.Override
        public CollectBooleanProcedureTest implementation() {
            return this.implementation;
        }
    }
}
