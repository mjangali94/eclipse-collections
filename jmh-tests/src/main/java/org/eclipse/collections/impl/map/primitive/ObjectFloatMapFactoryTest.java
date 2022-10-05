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

import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectFloatMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectFloatHashMap(), ObjectFloatMaps.mutable.of());
        Assert.assertEquals(ObjectFloatMaps.mutable.of(), ObjectFloatMaps.mutable.empty());
        Assert.assertEquals(ObjectFloatMaps.mutable.of("2", 1.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.of("2", 1.0f, "4", 3.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.of("2", 1.0f, "4", 3.0f, "6", 5.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f, "6", 5.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.of("2", 1.0f, "4", 3.0f, "6", 5.0f, "8", 7.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f, "6", 5.0f, "8", 7.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.empty().toImmutable(), ObjectFloatMaps.immutable.empty());
        Assert.assertEquals(ObjectFloatMaps.mutable.empty().toImmutable(), ObjectFloatMaps.immutable.of());
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f).toImmutable(), ObjectFloatMaps.immutable.of("2", 1.0f));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectFloatMaps.mutable.with(), ObjectFloatMaps.mutable.empty());
        Assert.assertEquals(ObjectFloatMaps.mutable.with("2", 1.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.with("2", 1.0f, "4", 3.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.with("2", 1.0f, "4", 3.0f, "6", 5.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f, "6", 5.0f));
        Assert.assertEquals(ObjectFloatMaps.mutable.with("2", 1.0f, "4", 3.0f, "6", 5.0f, "8", 7.0f), ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "4", 3.0f, "6", 5.0f, "8", 7.0f));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectFloatMaps.mutable.empty(), ObjectFloatMaps.mutable.ofAll(ObjectFloatMaps.mutable.empty()));
        Assert.assertEquals(ObjectFloatMaps.mutable.empty().toImmutable(), ObjectFloatMaps.immutable.ofAll(ObjectFloatMaps.mutable.empty()));
        Assert.assertSame(ObjectFloatMaps.immutable.empty(), ObjectFloatMaps.immutable.ofAll(ObjectFloatMaps.immutable.empty()));
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f), ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newWithKeysValues("2", 1.0f)));
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f).toImmutable(), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("2", 1.0f)));
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "3", 3.0f).toImmutable(), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "3", 3.0f)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f), ObjectFloatMaps.mutable.from(iterable, each -> each, Float::valueOf));
        Assert.assertTrue(ObjectFloatMaps.mutable.from(iterable, each -> each, Float::valueOf) instanceof MutableObjectFloatMap);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f), ObjectFloatMaps.immutable.from(iterable, each -> each, Float::valueOf));
        Assert.assertTrue(ObjectFloatMaps.immutable.from(iterable, each -> each, Float::valueOf) instanceof ImmutableObjectFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatMapFactoryTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ObjectFloatMapFactoryTest::of;
            this.payloads.with = ObjectFloatMapFactoryTest::with;
            this.payloads.ofAll = ObjectFloatMapFactoryTest::ofAll;
            this.payloads.from = ObjectFloatMapFactoryTest::from;
        }
    }
}
