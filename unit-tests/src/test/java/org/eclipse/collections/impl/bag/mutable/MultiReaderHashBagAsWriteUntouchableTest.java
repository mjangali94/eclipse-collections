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
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderHashBagAsWriteUntouchableTest extends AbstractCollectionTestCase {

    @Override
    protected <T> MutableBag<T> newWith(T... littleElements) {
        return MultiReaderHashBag.newBagWith(littleElements).asWriteUntouchable();
    }

    @Override
    public void asSynchronized() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asSynchronized());
    }

    @Override
    public void asUnmodifiable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asUnmodifiable());
    }

    @Test
    public void addOccurrences() {
        MutableBag<Integer> bag = this.newWith(1, 1);
        Assert.assertEquals(4, bag.addOccurrences(1, 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1), bag);
        Assert.assertEquals(0, bag.addOccurrences(2, 0));
        Assert.assertEquals(2, bag.addOccurrences(2, 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1, 2, 2), bag);
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        MultiReaderHashBag.newBagWith(1, 1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 1, 2, 3", builder.toString());
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = this.newWith("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5");
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
            this.runBenchmark(this.implementation()::addOccurrences, this.description("addOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        private MultiReaderHashBagAsWriteUntouchableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderHashBagAsWriteUntouchableTest();
        }

        @java.lang.Override
        public MultiReaderHashBagAsWriteUntouchableTest implementation() {
            return this.implementation;
        }
    }
}
