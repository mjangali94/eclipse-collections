/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal;

import java.util.Set;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class SetIterateTest {

    @Test
    public void removeAllIterableOne() {
        Set<Integer> set = this.newSet();
        Assert.assertTrue(SetIterate.removeAllIterable(set, Sets.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        Assert.assertEquals(Sets.mutable.of(25), set);
    }

    @Test
    public void removeAllIterableTwo() {
        Set<Integer> set = this.newSet();
        Assert.assertFalse(SetIterate.removeAllIterable(set, Sets.mutable.of(31, 32, 33, 34, 35, 36, 37)));
        Assert.assertEquals(this.newSet(), set);
    }

    private MutableSet<Integer> newSet() {
        return Sets.mutable.of(5, 9, 25);
    }

    @Test
    public void removeAllIterableThree() {
        Set<Integer> set = this.newSet();
        Assert.assertTrue(SetIterate.removeAllIterable(set, Sets.mutable.of(25)));
        Assert.assertEquals(Sets.mutable.of(5, 9), set);
    }

    @Test
    public void removeAllIterableFour() {
        Set<Integer> set = this.newSet();
        Assert.assertFalse(SetIterate.removeAllIterable(set, Sets.mutable.of(250)));
        Assert.assertEquals(this.newSet(), set);
    }

    @Test
    public void removeAllIterableFive() {
        Set<Integer> set = this.newSet();
        Assert.assertTrue(SetIterate.removeAllIterable(set, Lists.mutable.of(5, 5, 5, 9, 9, 100, 200, 300)));
        Assert.assertEquals(Sets.mutable.of(25), set);
    }

    @Test
    public void removeAllIterableSix() {
        Set<Integer> set = this.newSet();
        Assert.assertFalse(SetIterate.removeAllIterable(set, Lists.mutable.of(90)));
        Assert.assertEquals(this.newSet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SetIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableOne);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableTwo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableTwo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableThree() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableThree);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableFour() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableFour);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableFive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableFive);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterableSix() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterableSix);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> payload) throws java.lang.Throwable {
            this.instance = new SetIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableThree;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableFour;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableFive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetIterateTest> removeAllIterableSix;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeAllIterableOne = SetIterateTest::removeAllIterableOne;
            this.payloads.removeAllIterableTwo = SetIterateTest::removeAllIterableTwo;
            this.payloads.removeAllIterableThree = SetIterateTest::removeAllIterableThree;
            this.payloads.removeAllIterableFour = SetIterateTest::removeAllIterableFour;
            this.payloads.removeAllIterableFive = SetIterateTest::removeAllIterableFive;
            this.payloads.removeAllIterableSix = SetIterateTest::removeAllIterableSix;
        }
    }
*/
}
