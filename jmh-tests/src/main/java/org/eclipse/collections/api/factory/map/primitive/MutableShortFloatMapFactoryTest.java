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

import org.eclipse.collections.api.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortFloatHashMap(), ShortFloatMaps.mutable.with());
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f), ShortFloatMaps.mutable.with((short) 1, 2.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f), ShortFloatMaps.mutable.with((short) 1, 2.0f, (short) 3, 4.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f), ShortFloatMaps.mutable.with((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f, (short) 7, 8.0f), ShortFloatMaps.mutable.with((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f, (short) 7, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortFloatHashMap(), ShortFloatMaps.mutable.of());
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f), ShortFloatMaps.mutable.of((short) 1, 2.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f), ShortFloatMaps.mutable.of((short) 1, 2.0f, (short) 3, 4.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f), ShortFloatMaps.mutable.of((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f));
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f, (short) 7, 8.0f), ShortFloatMaps.mutable.of((short) 1, 2.0f, (short) 3, 4.0f, (short) 5, 6.0f, (short) 7, 8.0f));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableShortFloatMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableShortFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortFloatMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortFloatMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableShortFloatMapFactoryTest::with;
            this.payloads.of = MutableShortFloatMapFactoryTest::of;
        }
    }
*/
}
