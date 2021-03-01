/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

/**
 * JUnit test for empty() methods of primitive classes
 */
public class ImmutableEmptyPrimitiveTest {

    @Test
    public void isEmptyImmutable() {
        Verify.assertEmpty(BooleanLists.immutable.empty());
        Verify.assertEmpty(BooleanLists.immutable.of());
        Verify.assertEmpty(BooleanLists.immutable.with());
        Verify.assertEmpty(ByteLists.immutable.empty());
        Verify.assertEmpty(ByteLists.immutable.of());
        Verify.assertEmpty(ByteLists.immutable.with());
        Verify.assertEmpty(CharLists.immutable.empty());
        Verify.assertEmpty(CharLists.immutable.of());
        Verify.assertEmpty(CharLists.immutable.with());
        Verify.assertEmpty(DoubleLists.immutable.empty());
        Verify.assertEmpty(DoubleLists.immutable.of());
        Verify.assertEmpty(DoubleLists.immutable.with());
        Verify.assertEmpty(FloatLists.immutable.empty());
        Verify.assertEmpty(FloatLists.immutable.of());
        Verify.assertEmpty(FloatLists.immutable.with());
        Verify.assertEmpty(IntLists.immutable.empty());
        Verify.assertEmpty(IntLists.immutable.of());
        Verify.assertEmpty(IntLists.immutable.with());
        Verify.assertEmpty(LongLists.immutable.empty());
        Verify.assertEmpty(LongLists.immutable.of());
        Verify.assertEmpty(LongLists.immutable.with());
        Verify.assertEmpty(ShortLists.immutable.empty());
        Verify.assertEmpty(ShortLists.immutable.of());
        Verify.assertEmpty(ShortLists.immutable.with());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmptyImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmptyImmutable, this.description("isEmptyImmutable"));
        }

        private ImmutableEmptyPrimitiveTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableEmptyPrimitiveTest();
        }

        @java.lang.Override
        public ImmutableEmptyPrimitiveTest implementation() {
            return this.implementation;
        }
    }
}
