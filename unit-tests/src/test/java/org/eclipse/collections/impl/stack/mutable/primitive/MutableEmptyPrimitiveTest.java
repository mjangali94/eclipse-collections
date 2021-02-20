/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.impl.factory.primitive.BooleanStacks;
import org.eclipse.collections.impl.factory.primitive.ByteStacks;
import org.eclipse.collections.impl.factory.primitive.CharStacks;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

/**
 * JUnit test for empty() methods of primitive classes
 */
public class MutableEmptyPrimitiveTest {

    @Test
    public void isEmptyMutable() {
        Verify.assertEmpty(BooleanStacks.mutable.empty());
        Verify.assertEmpty(BooleanStacks.mutable.of());
        Verify.assertEmpty(BooleanStacks.mutable.with());
        Verify.assertEmpty(ByteStacks.mutable.empty());
        Verify.assertEmpty(ByteStacks.mutable.of());
        Verify.assertEmpty(ByteStacks.mutable.with());
        Verify.assertEmpty(CharStacks.mutable.empty());
        Verify.assertEmpty(CharStacks.mutable.of());
        Verify.assertEmpty(CharStacks.mutable.with());
        Verify.assertEmpty(DoubleStacks.mutable.empty());
        Verify.assertEmpty(DoubleStacks.mutable.of());
        Verify.assertEmpty(DoubleStacks.mutable.with());
        Verify.assertEmpty(FloatStacks.mutable.empty());
        Verify.assertEmpty(FloatStacks.mutable.of());
        Verify.assertEmpty(FloatStacks.mutable.with());
        Verify.assertEmpty(IntStacks.mutable.empty());
        Verify.assertEmpty(IntStacks.mutable.of());
        Verify.assertEmpty(IntStacks.mutable.with());
        Verify.assertEmpty(LongStacks.mutable.empty());
        Verify.assertEmpty(LongStacks.mutable.of());
        Verify.assertEmpty(LongStacks.mutable.with());
        Verify.assertEmpty(ShortStacks.mutable.empty());
        Verify.assertEmpty(ShortStacks.mutable.of());
        Verify.assertEmpty(ShortStacks.mutable.with());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmptyMutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmptyMutable, this.description("isEmptyMutable"));
        }

        private MutableEmptyPrimitiveTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableEmptyPrimitiveTest();
        }

        @java.lang.Override
        public MutableEmptyPrimitiveTest implementation() {
            return this.implementation;
        }
    }
}
