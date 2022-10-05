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

import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableByteSetFactoryImplTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteSets.immutable.of());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1).toImmutable(), ByteSets.immutable.of((byte) 1));
    }

    @Test
    public void with() {
        Verify.assertEmpty(ByteSets.immutable.with(null));
    }

    @Test
    public void ofAll() {
        ImmutableByteSet set = ByteSets.immutable.of((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(ByteHashSet.newSet(set).toImmutable(), ByteSets.immutable.ofAll(set));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteSetFactoryImplTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSetFactoryImplTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteSetFactoryImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSetFactoryImplTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSetFactoryImplTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSetFactoryImplTest> ofAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ImmutableByteSetFactoryImplTest::of;
            this.payloads.with = ImmutableByteSetFactoryImplTest::with;
            this.payloads.ofAll = ImmutableByteSetFactoryImplTest::ofAll;
        }
    }
}
