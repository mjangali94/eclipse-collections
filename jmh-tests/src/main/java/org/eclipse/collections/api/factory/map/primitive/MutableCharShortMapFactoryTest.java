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

import org.eclipse.collections.api.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharShortHashMap(), CharShortMaps.mutable.with());
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2), CharShortMaps.mutable.with((char) 1, (short) 2));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4), CharShortMaps.mutable.with((char) 1, (short) 2, (char) 3, (short) 4));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6), CharShortMaps.mutable.with((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6, (char) 7, (short) 8), CharShortMaps.mutable.with((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6, (char) 7, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharShortHashMap(), CharShortMaps.mutable.of());
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2), CharShortMaps.mutable.of((char) 1, (short) 2));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4), CharShortMaps.mutable.of((char) 1, (short) 2, (char) 3, (short) 4));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6), CharShortMaps.mutable.of((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6, (char) 7, (short) 8), CharShortMaps.mutable.of((char) 1, (short) 2, (char) 3, (short) 4, (char) 5, (short) 6, (char) 7, (short) 8));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableCharShortMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableCharShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharShortMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharShortMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableCharShortMapFactoryTest::with;
            this.payloads.of = MutableCharShortMapFactoryTest::of;
        }
    }
*/
}
