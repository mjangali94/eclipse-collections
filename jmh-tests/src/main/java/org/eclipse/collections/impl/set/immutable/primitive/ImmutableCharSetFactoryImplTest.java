/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableCharSetFactoryImplTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharSets.immutable.of());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1).toImmutable(), CharSets.immutable.of((char) 1));
    }

    @Test
    public void with() {
        Verify.assertEmpty(CharSets.immutable.with(null));
    }

    @Test
    public void ofAll() {
        ImmutableCharSet set = CharSets.immutable.of((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(CharHashSet.newSet(set).toImmutable(), CharSets.immutable.ofAll(set));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharSetFactoryImplTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharSetFactoryImplTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharSetFactoryImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharSetFactoryImplTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharSetFactoryImplTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharSetFactoryImplTest> ofAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ImmutableCharSetFactoryImplTest::of;
            this.payloads.with = ImmutableCharSetFactoryImplTest::with;
            this.payloads.ofAll = ImmutableCharSetFactoryImplTest::ofAll;
        }
    }
}
