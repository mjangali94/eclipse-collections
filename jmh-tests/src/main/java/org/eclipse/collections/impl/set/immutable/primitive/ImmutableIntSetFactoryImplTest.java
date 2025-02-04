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

import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableIntSetFactoryImplTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntSets.immutable.of());
        Assert.assertEquals(IntHashSet.newSetWith(1).toImmutable(), IntSets.immutable.of(1));
    }

    @Test
    public void with() {
        Verify.assertEmpty(IntSets.immutable.with(null));
    }

    @Test
    public void ofAll() {
        ImmutableIntSet set = IntSets.immutable.of(1, 2, 3);
        Assert.assertEquals(IntHashSet.newSet(set).toImmutable(), IntSets.immutable.ofAll(set));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntSetFactoryImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntSetFactoryImplTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntSetFactoryImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntSetFactoryImplTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntSetFactoryImplTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntSetFactoryImplTest> ofAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ImmutableIntSetFactoryImplTest::of;
            this.payloads.with = ImmutableIntSetFactoryImplTest::with;
            this.payloads.ofAll = ImmutableIntSetFactoryImplTest::ofAll;
        }
    }
*/
}
