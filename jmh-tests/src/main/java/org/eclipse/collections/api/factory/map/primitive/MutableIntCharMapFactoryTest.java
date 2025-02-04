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

import org.eclipse.collections.api.factory.primitive.IntCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableIntCharMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableIntCharMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new IntCharHashMap(), IntCharMaps.mutable.with());
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2), IntCharMaps.mutable.with(1, (char) 2));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4), IntCharMaps.mutable.with(1, (char) 2, 3, (char) 4));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4, 5, (char) 6), IntCharMaps.mutable.with(1, (char) 2, 3, (char) 4, 5, (char) 6));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4, 5, (char) 6, 7, (char) 8), IntCharMaps.mutable.with(1, (char) 2, 3, (char) 4, 5, (char) 6, 7, (char) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new IntCharHashMap(), IntCharMaps.mutable.of());
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2), IntCharMaps.mutable.of(1, (char) 2));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4), IntCharMaps.mutable.of(1, (char) 2, 3, (char) 4));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4, 5, (char) 6), IntCharMaps.mutable.of(1, (char) 2, 3, (char) 4, 5, (char) 6));
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 2, 3, (char) 4, 5, (char) 6, 7, (char) 8), IntCharMaps.mutable.of(1, (char) 2, 3, (char) 4, 5, (char) 6, 7, (char) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableIntCharMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableIntCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntCharMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntCharMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableIntCharMapFactoryTest::with;
            this.payloads.of = MutableIntCharMapFactoryTest::of;
        }
    }
}
