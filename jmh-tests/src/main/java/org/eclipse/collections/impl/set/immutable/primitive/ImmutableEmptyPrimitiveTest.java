/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

/**
 * JUnit test for empty() methods of primitive classes
 */
public class ImmutableEmptyPrimitiveTest {

    @Test
    public void isEmptyImmutable() {
        Verify.assertEmpty(BooleanSets.immutable.empty());
        Verify.assertEmpty(BooleanSets.immutable.of());
        Verify.assertEmpty(BooleanSets.immutable.with());
        Verify.assertEmpty(ByteSets.immutable.empty());
        Verify.assertEmpty(ByteSets.immutable.of());
        Verify.assertEmpty(ByteSets.immutable.with());
        Verify.assertEmpty(CharSets.immutable.empty());
        Verify.assertEmpty(CharSets.immutable.of());
        Verify.assertEmpty(CharSets.immutable.with());
        Verify.assertEmpty(DoubleSets.immutable.empty());
        Verify.assertEmpty(DoubleSets.immutable.of());
        Verify.assertEmpty(DoubleSets.immutable.with());
        Verify.assertEmpty(FloatSets.immutable.empty());
        Verify.assertEmpty(FloatSets.immutable.of());
        Verify.assertEmpty(FloatSets.immutable.with());
        Verify.assertEmpty(IntSets.immutable.empty());
        Verify.assertEmpty(IntSets.immutable.of());
        Verify.assertEmpty(IntSets.immutable.with());
        Verify.assertEmpty(LongSets.immutable.empty());
        Verify.assertEmpty(LongSets.immutable.of());
        Verify.assertEmpty(LongSets.immutable.with());
        Verify.assertEmpty(ShortSets.immutable.empty());
        Verify.assertEmpty(ShortSets.immutable.of());
        Verify.assertEmpty(ShortSets.immutable.with());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptyPrimitiveTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmptyImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmptyImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyPrimitiveTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptyPrimitiveTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyPrimitiveTest> isEmptyImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmptyImmutable = ImmutableEmptyPrimitiveTest::isEmptyImmutable;
        }
    }
}
