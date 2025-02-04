/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnmodifiableMapTest {

    private static final String ROCK_OUT = "Bands that Rock";

    private static final String NAP_TIME = "Bands than Don't";

    private static final MutableList<String> MASTERS_OF_ROCK = Lists.mutable.of("Nine Inch Nails", "Soundgarden", "White Zombie", "Radiohead");

    private MutableMap<String, List<String>> mutableMap;

    private UnmodifiableMap<String, List<String>> unmodifiableMap;

    @Before
    public void setUp() {
        this.mutableMap = Maps.mutable.of(ROCK_OUT, MASTERS_OF_ROCK, NAP_TIME, Lists.mutable.of("Metallica", "Bon Jovi", "Europe", "Scorpions"));
        this.unmodifiableMap = new UnmodifiableMap<>(this.mutableMap);
    }

    @Test
    public void testNullConstructorArgument() {
        Assert.assertThrows(NullPointerException.class, () -> new UnmodifiableMap<>(null));
    }

    @Test
    public void testSize() {
        Verify.assertSize(this.mutableMap.size(), this.unmodifiableMap);
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(this.mutableMap.isEmpty(), this.unmodifiableMap.isEmpty());
    }

    @Test
    public void testContainsKey() {
        Assert.assertTrue(this.unmodifiableMap.containsKey(ROCK_OUT));
    }

    @Test
    public void testContainsValue() {
        Assert.assertTrue(this.unmodifiableMap.containsValue(MASTERS_OF_ROCK));
    }

    @Test
    public void testGet() {
        Assert.assertEquals(MASTERS_OF_ROCK, this.unmodifiableMap.get(ROCK_OUT));
    }

    @Test
    public void testPut() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.put("foo", Lists.mutable.of()));
    }

    @Test
    public void testRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.remove(ROCK_OUT));
    }

    @Test
    public void testPutAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.putAll(Maps.mutable.of()));
    }

    @Test
    public void testClear() {
        Assert.assertThrows(UnsupportedOperationException.class, this.unmodifiableMap::clear);
    }

    @Test
    public void testKeySet() {
        Assert.assertEquals(this.mutableMap.keySet(), this.unmodifiableMap.keySet());
    }

    @Test
    public void testValues() {
        Verify.assertContainsAll(this.mutableMap.values(), this.unmodifiableMap.values().toArray());
    }

    @Test
    public void testEntrySet() {
        Assert.assertEquals(this.mutableMap.entrySet(), this.unmodifiableMap.entrySet());
    }

    @Test
    public void testToString() {
        Assert.assertEquals(this.mutableMap.toString(), this.unmodifiableMap.toString());
    }

    @Test
    public void testMutableTransparency() {
        this.mutableMap.remove(NAP_TIME);
        Verify.assertSize(this.mutableMap.size(), this.unmodifiableMap);
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.mutableMap, this.unmodifiableMap);
    }

    @Test(expected = NullPointerException.class)
    public void notNull() {
        new UnmodifiableMap<>(null);
    }

    @Test
    public void entrySetsEqual() {
        Verify.assertEqualsAndHashCode(this.mutableMap.entrySet(), this.unmodifiableMap.entrySet());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNullConstructorArgument() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNullConstructorArgument);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMutableTransparency() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMutableTransparency);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetsEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetsEqual);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMapTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testNullConstructorArgument;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testIsEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testContainsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testContainsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> testMutableTransparency;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> notNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapTest> entrySetsEqual;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNullConstructorArgument = UnmodifiableMapTest::testNullConstructorArgument;
            this.payloads.testSize = UnmodifiableMapTest::testSize;
            this.payloads.testIsEmpty = UnmodifiableMapTest::testIsEmpty;
            this.payloads.testContainsKey = UnmodifiableMapTest::testContainsKey;
            this.payloads.testContainsValue = UnmodifiableMapTest::testContainsValue;
            this.payloads.testGet = UnmodifiableMapTest::testGet;
            this.payloads.testPut = UnmodifiableMapTest::testPut;
            this.payloads.testRemove = UnmodifiableMapTest::testRemove;
            this.payloads.testPutAll = UnmodifiableMapTest::testPutAll;
            this.payloads.testClear = UnmodifiableMapTest::testClear;
            this.payloads.testKeySet = UnmodifiableMapTest::testKeySet;
            this.payloads.testValues = UnmodifiableMapTest::testValues;
            this.payloads.testEntrySet = UnmodifiableMapTest::testEntrySet;
            this.payloads.testToString = UnmodifiableMapTest::testToString;
            this.payloads.testMutableTransparency = UnmodifiableMapTest::testMutableTransparency;
            this.payloads.equalsAndHashCode = UnmodifiableMapTest::equalsAndHashCode;
            this.payloads.notNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapTest::notNull, java.lang.NullPointerException.class);
            this.payloads.entrySetsEqual = UnmodifiableMapTest::entrySetsEqual;
        }
    }
*/
}
