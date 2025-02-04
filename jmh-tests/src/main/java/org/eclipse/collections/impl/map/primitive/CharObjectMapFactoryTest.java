/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class CharObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(CharObjectMaps.immutable.with(), CharObjectMaps.immutable.empty());
        Assert.assertSame(CharObjectMaps.immutable.of(), CharObjectMaps.immutable.empty());
        Assert.assertEquals(CharObjectMaps.mutable.with(), CharObjectMaps.mutable.empty());
        Assert.assertEquals(CharObjectMaps.mutable.of(), CharObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(CharObjectMaps.mutable.with().toImmutable(), CharObjectMaps.immutable.of());
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "1").toImmutable(), CharObjectMaps.immutable.of((char) 1, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(CharObjectMaps.mutable.of(), CharObjectMaps.immutable.ofAll(CharObjectMaps.immutable.of()));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "1"), CharObjectMaps.immutable.ofAll(CharObjectHashMap.newWithKeysValues((char) 1, "1")));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "1", (char) 2, "2"), CharObjectMaps.immutable.ofAll(CharObjectHashMap.newWithKeysValues((char) 1, "1", (char) 2, "2")));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "1", (char) 2, "2"), CharObjectMaps.immutable.ofAll(CharObjectHashMap.newWithKeysValues((char) 1, "1", (char) 2, "2").toImmutable()));
        Assert.assertEquals(CharObjectMaps.mutable.empty(), CharObjectMaps.mutable.ofAll(CharObjectMaps.immutable.of()));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "1"), CharObjectMaps.mutable.ofAll(CharObjectHashMap.newWithKeysValues((char) 1, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues('1', "1", '2', "2", '3', "3"), CharObjectMaps.mutable.from(iterable, each -> each.charAt(0), each -> each));
        Assert.assertTrue(CharObjectMaps.mutable.from(iterable, each -> each.charAt(0), each -> each) instanceof MutableCharObjectMap);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues('1', "1", '2', "2", '3', "3"), CharObjectMaps.immutable.from(iterable, each -> each.charAt(0), each -> each));
        Assert.assertTrue(CharObjectMaps.immutable.from(iterable, each -> each.charAt(0), each -> each) instanceof ImmutableCharObjectMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharObjectMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new CharObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectMapFactoryTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.empty = CharObjectMapFactoryTest::empty;
            this.payloads.of = CharObjectMapFactoryTest::of;
            this.payloads.ofAll = CharObjectMapFactoryTest::ofAll;
            this.payloads.from = CharObjectMapFactoryTest::from;
        }
    }
*/
}
