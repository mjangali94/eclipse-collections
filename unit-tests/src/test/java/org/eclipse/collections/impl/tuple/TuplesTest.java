/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.tuple;

import java.util.Map;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Triple;
import org.eclipse.collections.api.tuple.Triplet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class TuplesTest {

    @Test
    public void pairFrom() {
        Pair<String, String> pair = Tuples.pair("1", "2");
        Map.Entry<String, String> entry = pair.toEntry();
        Pair<String, String> pair2 = Tuples.pairFrom(entry);
        Assert.assertEquals(pair, pair2);
    }

    @Test
    public void pair() {
        Pair<String, String> pair = Tuples.pair("1", "2");
        Assert.assertEquals("1", pair.getOne());
        Assert.assertEquals("2", pair.getTwo());
    }

    @Test
    public void twin() {
        Twin<String> twin = Tuples.twin("1", "2");
        Assert.assertEquals("1", twin.getOne());
        Assert.assertEquals("2", twin.getTwo());
    }

    @Test
    public void identicalTwin() {
        Twin<String> twin = Tuples.identicalTwin("1");
        Assert.assertEquals("1", twin.getOne());
        Assert.assertEquals("1", twin.getTwo());
        Assert.assertEquals(twin.getOne(), twin.getTwo());
    }

    @Test
    public void triple() {
        Triple<String, String, String> triple = Tuples.triple("1", "2", "3");
        Assert.assertEquals("1", triple.getOne());
        Assert.assertEquals("2", triple.getTwo());
        Assert.assertEquals("3", triple.getThree());
    }

    @Test
    public void triplet() {
        Triplet<String> triplet = Tuples.triplet("1", "2", "3");
        Assert.assertEquals("1", triplet.getOne());
        Assert.assertEquals("2", triplet.getTwo());
        Assert.assertEquals("3", triplet.getThree());
    }

    @Test
    public void identicalTriplet() {
        Triplet<String> triplet = Tuples.identicalTriplet("1");
        Assert.assertEquals("1", triplet.getOne());
        Assert.assertEquals("1", triplet.getTwo());
        Assert.assertEquals("1", triplet.getThree());
        Assert.assertEquals(triplet.getOne(), triplet.getTwo());
        Assert.assertEquals(triplet.getTwo(), triplet.getThree());
        Assert.assertEquals(triplet.getThree(), triplet.getOne());
    }

    @Test
    public void equalsHashCode() {
        Twin<String> pair1 = Tuples.twin("1", "1");
        Pair<String, String> pair1a = Tuples.pair("1", "1");
        Pair<String, String> pair2 = Tuples.pair("2", "2");
        Twin<String> pair3 = Tuples.identicalTwin("1");
        Verify.assertEqualsAndHashCode(pair1, pair1);
        Verify.assertEqualsAndHashCode(pair1, pair1a);
        Verify.assertEqualsAndHashCode(pair3, pair3);
        Verify.assertEqualsAndHashCode(pair1, pair3);
        Assert.assertNotEquals(pair1, pair2);
        Assert.assertNotEquals(pair1, new Object());
    }

    @Test
    public void equalsHashCodeTriple() {
        Triplet<String> triple1 = Tuples.triplet("1", "1", "1");
        Triple<String, String, String> triple1a = Tuples.triple("1", "1", "1");
        Triple<String, String, String> triple2 = Tuples.triple("2", "2", "2");
        Triplet<String> triple3 = Tuples.identicalTriplet("1");
        Verify.assertEqualsAndHashCode(triple1, triple1);
        Verify.assertEqualsAndHashCode(triple1, triple1a);
        Verify.assertEqualsAndHashCode(triple3, triple3);
        Verify.assertEqualsAndHashCode(triple1, triple3);
        Assert.assertNotEquals(triple1, triple2);
        Assert.assertNotEquals(triple1, new Object());
    }

    @Test
    public void putToMap() {
        Pair<String, Integer> pair = Tuples.pair("1", 2);
        MutableMap<String, Integer> map = UnifiedMap.newMap();
        pair.put(map);
        Verify.assertContainsAllKeyValues(map, "1", 2);
        Verify.assertSize(1, map);
    }

    @Test
    public void testToString() {
        Pair<String, String> pair1 = Tuples.pair("1", "1");
        Assert.assertEquals("1:1", pair1.toString());
        Triple<String, String, String> triple = Tuples.triple("1", "2", "3");
        Assert.assertEquals("1:2:3", triple.toString());
        Twin<String> identicalTwin = Tuples.identicalTwin("1");
        Assert.assertEquals("1:1", identicalTwin.toString());
        Triplet<String> identicalTriplet = Tuples.identicalTriplet("1");
        Assert.assertEquals("1:1:1", identicalTriplet.toString());
    }

    @Test
    public void pairFunctions() {
        Integer two = 2;
        Pair<String, Integer> pair = Tuples.pair("One", two);
        Assert.assertEquals("One", ((Function<Pair<String, ?>, String>) Pair::getOne).valueOf(pair));
        Assert.assertSame(two, ((Function<Pair<?, Integer>, Integer>) Pair::getTwo).valueOf(pair));
    }

    @Test
    public void swap() {
        Pair<String, Integer> pair = Tuples.pair("One", 1);
        Pair<Integer, String> swappedPair = pair.swap();
        Pair<Integer, String> expectedPair = Tuples.pair(1, "One");
        Assert.assertEquals(Integer.valueOf(1), swappedPair.getOne());
        Assert.assertEquals("One", swappedPair.getTwo());
        Assert.assertEquals(expectedPair, swappedPair);
        Twin<String> twin = Tuples.twin("One", "1");
        Twin<String> swappedTwin = twin.swap();
        Twin<String> expectedTwin = Tuples.twin("1", "One");
        Assert.assertEquals("1", swappedTwin.getOne());
        Assert.assertEquals("One", swappedTwin.getTwo());
        Assert.assertEquals(expectedTwin, swappedTwin);
        Twin<String> identicalTwin = Tuples.identicalTwin("1");
        Twin<String> swappedIdenticalTwin = identicalTwin.swap();
        Twin<String> expectedIdenticalTwin = Tuples.identicalTwin("1");
        Assert.assertEquals("1", swappedIdenticalTwin.getOne());
        Assert.assertEquals("1", swappedIdenticalTwin.getTwo());
        Assert.assertEquals(expectedIdenticalTwin, swappedIdenticalTwin);
    }

    @Test
    public void reverse() {
        Triple<String, Integer, Boolean> triple = Tuples.triple("One", 2, true);
        Triple<Boolean, Integer, String> reversedTriple = triple.reverse();
        Triple<Boolean, Integer, String> expectedTriple = Tuples.triple(true, 2, "One");
        Assert.assertEquals(true, reversedTriple.getOne());
        Assert.assertEquals(Integer.valueOf(2), reversedTriple.getTwo());
        Assert.assertEquals("One", reversedTriple.getThree());
        Assert.assertEquals(expectedTriple, reversedTriple);
        Triplet<String> triplet = Tuples.triplet("One", "2", "true");
        Triplet<String> reversedTriplet = triplet.reverse();
        Triplet<String> expectedTriplet = Tuples.triplet("true", "2", "One");
        Assert.assertEquals("true", reversedTriplet.getOne());
        Assert.assertEquals("2", reversedTriplet.getTwo());
        Assert.assertEquals("One", reversedTriplet.getThree());
        Assert.assertEquals(expectedTriplet, reversedTriplet);
        Triplet<String> identicalTriplet = Tuples.identicalTriplet("One");
        Triplet<String> reversedIdenticalTriplet = identicalTriplet.reverse();
        Triplet<String> expectedIdenticalTriplet = Tuples.identicalTriplet("One");
        Assert.assertEquals("One", reversedIdenticalTriplet.getOne());
        Assert.assertEquals("One", reversedIdenticalTriplet.getTwo());
        Assert.assertEquals("One", reversedIdenticalTriplet.getThree());
        Assert.assertEquals(expectedIdenticalTriplet, reversedIdenticalTriplet);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pairFrom() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::pairFrom, this.description("pairFrom"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::pair, this.description("pair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twin() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::twin, this.description("twin"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_identicalTwin() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::identicalTwin, this.description("identicalTwin"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_triple() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::triple, this.description("triple"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_triplet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::triplet, this.description("triplet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_identicalTriplet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::identicalTriplet, this.description("identicalTriplet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsHashCode, this.description("equalsHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsHashCodeTriple() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsHashCodeTriple, this.description("equalsHashCodeTriple"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putToMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putToMap, this.description("putToMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pairFunctions() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::pairFunctions, this.description("pairFunctions"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_swap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::swap, this.description("swap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverse() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverse, this.description("reverse"));
        }

        private TuplesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TuplesTest();
        }

        @java.lang.Override
        public TuplesTest implementation() {
            return this.implementation;
        }
    }
}
