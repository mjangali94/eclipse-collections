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

import org.eclipse.collections.api.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleCharMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleCharMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleCharHashMap(), DoubleCharMaps.mutable.with());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2), DoubleCharMaps.mutable.with(1.0, (char) 2));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4), DoubleCharMaps.mutable.with(1.0, (char) 2, 3.0, (char) 4));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6), DoubleCharMaps.mutable.with(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6, 7.0, (char) 8), DoubleCharMaps.mutable.with(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6, 7.0, (char) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleCharHashMap(), DoubleCharMaps.mutable.of());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2), DoubleCharMaps.mutable.of(1.0, (char) 2));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4), DoubleCharMaps.mutable.of(1.0, (char) 2, 3.0, (char) 4));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6), DoubleCharMaps.mutable.of(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6, 7.0, (char) 8), DoubleCharMaps.mutable.of(1.0, (char) 2, 3.0, (char) 4, 5.0, (char) 6, 7.0, (char) 8));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableDoubleCharMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableDoubleCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableDoubleCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableDoubleCharMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableDoubleCharMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableDoubleCharMapFactoryTest::with;
            this.payloads.of = MutableDoubleCharMapFactoryTest::of;
        }
    }
*/
}
