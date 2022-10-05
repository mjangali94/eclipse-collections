/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.primitive;

import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBooleanSetFactoryImplTest {

    @Test
    public void of() {
        Verify.assertEmpty(BooleanSets.immutable.of());
        Assert.assertEquals(BooleanHashSet.newSetWith(true).toImmutable(), BooleanSets.immutable.of(true));
    }

    @Test
    public void with() {
        Verify.assertEmpty(BooleanSets.immutable.with(null));
        Assert.assertEquals(BooleanHashSet.newSetWith(false).toImmutable(), BooleanSets.immutable.with(new boolean[] { false }));
    }

    @Test
    public void ofAll() {
        ImmutableBooleanSet set = BooleanSets.immutable.of(true, false);
        Assert.assertEquals(BooleanHashSet.newSet(set).toImmutable(), BooleanSets.immutable.ofAll(set));
        Assert.assertEquals(BooleanHashSet.newSet(BooleanArrayList.newListWith(true, false, true)).toImmutable(), BooleanSets.immutable.ofAll(BooleanArrayList.newListWith(true, false)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableBooleanSetFactoryImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanSetFactoryImplTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBooleanSetFactoryImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanSetFactoryImplTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanSetFactoryImplTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanSetFactoryImplTest> ofAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ImmutableBooleanSetFactoryImplTest::of;
            this.payloads.with = ImmutableBooleanSetFactoryImplTest::with;
            this.payloads.ofAll = ImmutableBooleanSetFactoryImplTest::ofAll;
        }
    }
}
