/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectCharMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectCharHashMap(), ObjectCharMaps.mutable.of());
        Assert.assertEquals(ObjectCharMaps.mutable.of(), ObjectCharMaps.mutable.empty());
        Assert.assertEquals(ObjectCharMaps.mutable.of("2", (char) 1), ObjectCharHashMap.newWithKeysValues("2", (char) 1));
        Assert.assertEquals(ObjectCharMaps.mutable.of("2", (char) 1, "4", (char) 3), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3));
        Assert.assertEquals(ObjectCharMaps.mutable.of("2", (char) 1, "4", (char) 3, "6", (char) 5), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3, "6", (char) 5));
        Assert.assertEquals(ObjectCharMaps.mutable.of("2", (char) 1, "4", (char) 3, "6", (char) 5, "8", (char) 7), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3, "6", (char) 5, "8", (char) 7));
        Assert.assertEquals(ObjectCharMaps.mutable.empty().toImmutable(), ObjectCharMaps.immutable.empty());
        Assert.assertEquals(ObjectCharMaps.mutable.empty().toImmutable(), ObjectCharMaps.immutable.of());
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1).toImmutable(), ObjectCharMaps.immutable.of("2", (char) 1));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectCharMaps.mutable.with(), ObjectCharMaps.mutable.empty());
        Assert.assertEquals(ObjectCharMaps.mutable.with("2", (char) 1), ObjectCharHashMap.newWithKeysValues("2", (char) 1));
        Assert.assertEquals(ObjectCharMaps.mutable.with("2", (char) 1, "4", (char) 3), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3));
        Assert.assertEquals(ObjectCharMaps.mutable.with("2", (char) 1, "4", (char) 3, "6", (char) 5), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3, "6", (char) 5));
        Assert.assertEquals(ObjectCharMaps.mutable.with("2", (char) 1, "4", (char) 3, "6", (char) 5, "8", (char) 7), ObjectCharHashMap.newWithKeysValues("2", (char) 1, "4", (char) 3, "6", (char) 5, "8", (char) 7));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectCharMaps.mutable.empty(), ObjectCharMaps.mutable.ofAll(ObjectCharMaps.mutable.empty()));
        Assert.assertEquals(ObjectCharMaps.mutable.empty().toImmutable(), ObjectCharMaps.immutable.ofAll(ObjectCharMaps.mutable.empty()));
        Assert.assertSame(ObjectCharMaps.immutable.empty(), ObjectCharMaps.immutable.ofAll(ObjectCharMaps.immutable.empty()));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1), ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newWithKeysValues("2", (char) 1)));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1).toImmutable(), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("2", (char) 1)));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1, "3", (char) 3).toImmutable(), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("2", (char) 1, "3", (char) 3)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", '1', "2", '2', "3", '3'), ObjectCharMaps.mutable.from(iterable, each -> each, each -> each.charAt(0)));
        Assert.assertTrue(ObjectCharMaps.mutable.from(iterable, each -> each, each -> each.charAt(0)) instanceof MutableObjectCharMap);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", '1', "2", '2', "3", '3'), ObjectCharMaps.immutable.from(iterable, each -> each, each -> each.charAt(0)));
        Assert.assertTrue(ObjectCharMaps.immutable.from(iterable, each -> each, each -> each.charAt(0)) instanceof ImmutableObjectCharMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharMapFactoryTest instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ObjectCharMapFactoryTest::of;
            this.payloads.with = ObjectCharMapFactoryTest::with;
            this.payloads.ofAll = ObjectCharMapFactoryTest::ofAll;
            this.payloads.from = ObjectCharMapFactoryTest::from;
        }
    }
*/
}
