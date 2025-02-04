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

import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectDoubleMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectDoubleHashMap(), ObjectDoubleMaps.mutable.of());
        Assert.assertEquals(ObjectDoubleMaps.mutable.of(), ObjectDoubleMaps.mutable.empty());
        Assert.assertEquals(ObjectDoubleMaps.mutable.of("2", 1.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.of("2", 1.0, "4", 3.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.of("2", 1.0, "4", 3.0, "6", 5.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0, "6", 5.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.of("2", 1.0, "4", 3.0, "6", 5.0, "8", 7.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0, "6", 5.0, "8", 7.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.empty().toImmutable(), ObjectDoubleMaps.immutable.empty());
        Assert.assertEquals(ObjectDoubleMaps.mutable.empty().toImmutable(), ObjectDoubleMaps.immutable.of());
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0).toImmutable(), ObjectDoubleMaps.immutable.of("2", 1.0));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectDoubleMaps.mutable.with(), ObjectDoubleMaps.mutable.empty());
        Assert.assertEquals(ObjectDoubleMaps.mutable.with("2", 1.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.with("2", 1.0, "4", 3.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.with("2", 1.0, "4", 3.0, "6", 5.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0, "6", 5.0));
        Assert.assertEquals(ObjectDoubleMaps.mutable.with("2", 1.0, "4", 3.0, "6", 5.0, "8", 7.0), ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "4", 3.0, "6", 5.0, "8", 7.0));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectDoubleMaps.mutable.empty(), ObjectDoubleMaps.mutable.ofAll(ObjectDoubleMaps.mutable.empty()));
        Assert.assertEquals(ObjectDoubleMaps.mutable.empty().toImmutable(), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleMaps.mutable.empty()));
        Assert.assertSame(ObjectDoubleMaps.immutable.empty(), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleMaps.immutable.empty()));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0), ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("2", 1.0)));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0).toImmutable(), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("2", 1.0)));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "3", 3.0).toImmutable(), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "3", 3.0)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0), ObjectDoubleMaps.mutable.from(iterable, each -> each, Double::valueOf));
        Assert.assertTrue(ObjectDoubleMaps.mutable.from(iterable, each -> each, Double::valueOf) instanceof MutableObjectDoubleMap);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0), ObjectDoubleMaps.immutable.from(iterable, each -> each, Double::valueOf));
        Assert.assertTrue(ObjectDoubleMaps.immutable.from(iterable, each -> each, Double::valueOf) instanceof ImmutableObjectDoubleMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ObjectDoubleMapFactoryTest::of;
            this.payloads.with = ObjectDoubleMapFactoryTest::with;
            this.payloads.ofAll = ObjectDoubleMapFactoryTest::ofAll;
            this.payloads.from = ObjectDoubleMapFactoryTest::from;
        }
    }
}
