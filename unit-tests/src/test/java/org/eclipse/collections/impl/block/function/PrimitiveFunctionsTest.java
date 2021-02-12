/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link PrimitiveFunctions}.
 */
public class PrimitiveFunctionsTest {

    @Test
    public void unboxNumberToInt() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), UnifiedSet.newSetWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)).collectInt(PrimitiveFunctions.unboxNumberToInt()));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), UnifiedSet.newSetWith(1.1, 2.2, 3.3).collectInt(PrimitiveFunctions.unboxNumberToInt()));
    }

    @Test
    public void unboxNumberToFloat() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), UnifiedSet.newSetWith(1, 2, 3).collectFloat(PrimitiveFunctions.unboxNumberToFloat()));
    }

    @Test
    public void unboxNumberToLong() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), UnifiedSet.newSetWith(1, 2, 3).collectLong(PrimitiveFunctions.unboxNumberToLong()));
    }

    @Test
    public void unboxNumberToDouble() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), UnifiedSet.newSetWith(1, 2, 3).collectDouble(PrimitiveFunctions.unboxNumberToDouble()));
    }

    @Test
    public void unboxDoubleToDouble() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), UnifiedSet.newSetWith(Double.valueOf(1.0), Double.valueOf(2.0), Double.valueOf(3.0)).collectDouble(PrimitiveFunctions.unboxDoubleToDouble()));
    }

    @Test
    public void unboxFloatToFloat() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), UnifiedSet.newSetWith(Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(3.0f)).collectFloat(PrimitiveFunctions.unboxFloatToFloat()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxNumberToInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxNumberToInt, this.description("unboxNumberToInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxNumberToFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxNumberToFloat, this.description("unboxNumberToFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxNumberToLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxNumberToLong, this.description("unboxNumberToLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxNumberToDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxNumberToDouble, this.description("unboxNumberToDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxDoubleToDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxDoubleToDouble, this.description("unboxDoubleToDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unboxFloatToFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unboxFloatToFloat, this.description("unboxFloatToFloat"));
        }

        private PrimitiveFunctionsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PrimitiveFunctionsTest();
        }

        @java.lang.Override
        public PrimitiveFunctionsTest implementation() {
            return this.implementation;
        }
    }
}
