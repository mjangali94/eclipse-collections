/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MaxSizeFunction}.
 */
public class MaxSizeFunctionTest {

    @Test
    public void maxSizeCollection() {
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.COLLECTION.value(2, FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.COLLECTION.value(3, FastList.newListWith(1, 2)));
    }

    @Test
    public void maxSizeMap() {
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.MAP.value(2, Maps.mutable.of(1, 1, 2, 2, 3, 3)));
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.MAP.value(3, Maps.mutable.of(1, 1, 2, 2)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MaxSizeFunctionTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxSizeCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxSizeCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxSizeMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxSizeMap);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MaxSizeFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new MaxSizeFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MaxSizeFunctionTest> maxSizeCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MaxSizeFunctionTest> maxSizeMap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.maxSizeCollection = MaxSizeFunctionTest::maxSizeCollection;
            this.payloads.maxSizeMap = MaxSizeFunctionTest::maxSizeMap;
        }
    }
}
