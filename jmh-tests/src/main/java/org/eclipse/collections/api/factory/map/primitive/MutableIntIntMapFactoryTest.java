/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.factory.primitive.IntIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableIntIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableIntIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new IntIntHashMap(), IntIntMaps.mutable.with());
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2), IntIntMaps.mutable.with(1, 2));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4), IntIntMaps.mutable.with(1, 2, 3, 4));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4, 5, 6), IntIntMaps.mutable.with(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4, 5, 6, 7, 8), IntIntMaps.mutable.with(1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new IntIntHashMap(), IntIntMaps.mutable.of());
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2), IntIntMaps.mutable.of(1, 2));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4), IntIntMaps.mutable.of(1, 2, 3, 4));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4, 5, 6), IntIntMaps.mutable.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2, 3, 4, 5, 6, 7, 8), IntIntMaps.mutable.of(1, 2, 3, 4, 5, 6, 7, 8));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableIntIntMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntIntMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableIntIntMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntIntMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntIntMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableIntIntMapFactoryTest::with;
            this.payloads.of = MutableIntIntMapFactoryTest::of;
        }
    }
*/
}
