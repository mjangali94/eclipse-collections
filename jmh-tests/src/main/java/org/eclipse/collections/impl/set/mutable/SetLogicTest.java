/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetLogicTest {

    private MutableSet<Integer> setA;

    private MutableSet<Integer> setB;

    @Before
    public void setUp() {
        this.setA = UnifiedSet.newSetWith(1, 2, 3, 4).asUnmodifiable();
        this.setB = UnifiedSet.newSetWith(3, 4, 5, 6).asUnmodifiable();
    }

    @Test
    public void inOnlyInAMutable() {
        MutableSet<Integer> onlyInA = this.setA.reject(Predicates.in(this.setB), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), onlyInA);
    }

    @Test
    public void onlyInAJdkLike() {
        MutableSet<Integer> onlyInA = UnifiedSet.newSet(this.setA);
        onlyInA.removeAll(this.setB);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), onlyInA);
    }

    @Test
    public void inBothAAndBMutable() {
        Assert.assertEquals(UnifiedSet.newSetWith(3, 4), this.setA.select(Predicates.in(this.setB)));
    }

    @Test
    public void inAOrBButNotInBoth() {
        MutableSet<Integer> nonOverlappingSet = UnifiedSet.newSet();
        this.setA.select(Predicates.notIn(this.setB), nonOverlappingSet);
        this.setB.select(Predicates.notIn(this.setA), nonOverlappingSet);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 5, 6), nonOverlappingSet);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SetLogicTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_inOnlyInAMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.inOnlyInAMutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_onlyInAJdkLike() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.onlyInAJdkLike);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_inBothAAndBMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.inBothAAndBMutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_inAOrBButNotInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.inAOrBButNotInBoth);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SetLogicTest> payload) throws java.lang.Throwable {
            this.instance = new SetLogicTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetLogicTest> inOnlyInAMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetLogicTest> onlyInAJdkLike;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetLogicTest> inBothAAndBMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetLogicTest> inAOrBButNotInBoth;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.inOnlyInAMutable = SetLogicTest::inOnlyInAMutable;
            this.payloads.onlyInAJdkLike = SetLogicTest::onlyInAJdkLike;
            this.payloads.inBothAAndBMutable = SetLogicTest::inBothAAndBMutable;
            this.payloads.inAOrBButNotInBoth = SetLogicTest::inAOrBButNotInBoth;
        }
    }
}
