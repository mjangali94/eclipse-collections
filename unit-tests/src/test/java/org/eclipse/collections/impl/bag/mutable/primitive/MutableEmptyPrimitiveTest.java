/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

/**
 * JUnit test for empty() methods of primitive classes
 */
public class MutableEmptyPrimitiveTest {

    @Test
    public void isEmptyMutable() {
        Verify.assertEmpty(BooleanBags.mutable.empty());
        Verify.assertEmpty(BooleanBags.mutable.of());
        Verify.assertEmpty(BooleanBags.mutable.with());
        Verify.assertEmpty(ByteBags.mutable.empty());
        Verify.assertEmpty(ByteBags.mutable.of());
        Verify.assertEmpty(ByteBags.mutable.with());
        Verify.assertEmpty(CharBags.mutable.empty());
        Verify.assertEmpty(CharBags.mutable.of());
        Verify.assertEmpty(CharBags.mutable.with());
        Verify.assertEmpty(DoubleBags.mutable.empty());
        Verify.assertEmpty(DoubleBags.mutable.of());
        Verify.assertEmpty(DoubleBags.mutable.with());
        Verify.assertEmpty(FloatBags.mutable.empty());
        Verify.assertEmpty(FloatBags.mutable.of());
        Verify.assertEmpty(FloatBags.mutable.with());
        Verify.assertEmpty(IntBags.mutable.empty());
        Verify.assertEmpty(IntBags.mutable.of());
        Verify.assertEmpty(IntBags.mutable.with());
        Verify.assertEmpty(LongBags.mutable.empty());
        Verify.assertEmpty(LongBags.mutable.of());
        Verify.assertEmpty(LongBags.mutable.with());
        Verify.assertEmpty(ShortBags.mutable.empty());
        Verify.assertEmpty(ShortBags.mutable.of());
        Verify.assertEmpty(ShortBags.mutable.with());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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
