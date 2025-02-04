/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyIteratorTest {

    private EmptyIterator<Object> emptyIterator;

    @Before
    public void setUp() {
        this.emptyIterator = EmptyIterator.getInstance();
    }

    @Test
    public void hasPrevious() {
        Assert.assertFalse(this.emptyIterator.hasPrevious());
    }

    @Test
    public void previous() {
        Assert.assertThrows(NoSuchElementException.class, this.emptyIterator::previous);
    }

    @Test
    public void previousIndex() {
        Assert.assertEquals(-1, this.emptyIterator.previousIndex());
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.set(1));
    }

    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.add(1));
    }

    @Test
    public void nextIndex() {
        Assert.assertEquals(0, (long) this.emptyIterator.nextIndex());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private EmptyIteratorTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasPrevious() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hasPrevious);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_previous() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.previous);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_previousIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.previousIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nextIndex);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new EmptyIteratorTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> hasPrevious;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> previous;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> previousIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyIteratorTest> nextIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.hasPrevious = EmptyIteratorTest::hasPrevious;
            this.payloads.previous = EmptyIteratorTest::previous;
            this.payloads.previousIndex = EmptyIteratorTest::previousIndex;
            this.payloads.set = EmptyIteratorTest::set;
            this.payloads.add = EmptyIteratorTest::add;
            this.payloads.nextIndex = EmptyIteratorTest::nextIndex;
        }
    }
}
