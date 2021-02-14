/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ObjectIntProceduresTest {

    @Test
    public void fromObjectIntProcedure() {
        MutableList<Integer> result = FastList.newList();
        ObjectIntProcedure<Integer> objectIntProcedure = ObjectIntProcedures.fromProcedure(result::add);
        objectIntProcedure.value(1, 0);
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectIntProcedures.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromObjectIntProcedure() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::fromObjectIntProcedure, this.description("fromObjectIntProcedure"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private ObjectIntProceduresTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntProceduresTest();
        }

        @java.lang.Override
        public ObjectIntProceduresTest implementation() {
            return this.implementation;
        }
    }
}
