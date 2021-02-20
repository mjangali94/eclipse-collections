/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderHashBagAsReadUntouchableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableBag<Integer> getCollection() {
        return MultiReaderHashBag.newBagWith(1, 1).asReadUntouchable();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences() {
        this.getCollection().addOccurrences(1, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences() {
        this.getCollection().removeOccurrences(1, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setOccurrences() {
        this.getCollection().setOccurrences(1, 1);
    }

    @Test
    public void occurrencesOf() {
        Assert.assertEquals(2, this.getCollection().occurrencesOf(1));
        Assert.assertEquals(0, this.getCollection().occurrencesOf(0));
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(1, this.getCollection().sizeDistinct());
    }

    @Test
    public void toMapOfItemToCount() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 2), this.getCollection().toMapOfItemToCount());
    }

    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{1=2}", this.getCollection().toStringOfItemToCount());
    }

    @Test
    public void forEachWithOccurrences() {
        int[] sum = new int[1];
        this.getCollection().forEachWithOccurrences((each, occurrences) -> {
            if (occurrences > 1) {
                sum[0] += each * occurrences;
            }
        });
        Assert.assertEquals(2, sum[0]);
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = MultiReaderHashBag.newBagWith("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5").asReadUntouchable();
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addOccurrences, this.description("addOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeOccurrences, this.description("removeOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::setOccurrences, this.description("setOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occurrencesOf, this.description("occurrencesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sizeDistinct, this.description("sizeDistinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMapOfItemToCount, this.description("toMapOfItemToCount"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toStringOfItemToCount, this.description("toStringOfItemToCount"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        private MultiReaderHashBagAsReadUntouchableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderHashBagAsReadUntouchableTest();
        }

        @java.lang.Override
        public MultiReaderHashBagAsReadUntouchableTest implementation() {
            return this.implementation;
        }
    }
}
