/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.iterator;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file singletonPrimitiveIterator.stg.
 */
public final class SingletonDoubleIteratorTest {

    @Test
    public void hasNext() {
        SingletonDoubleIterator iterator = new SingletonDoubleIterator(5.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void next() {
        SingletonDoubleIterator iterator = new SingletonDoubleIterator(5.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(5.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        try {
            iterator.next();
            Assert.fail("NoSuchElementException should have been thrown");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SingletonDoubleIteratorTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasNext() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hasNext);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.next);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonDoubleIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new SingletonDoubleIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonDoubleIteratorTest> hasNext;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonDoubleIteratorTest> next;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.hasNext = SingletonDoubleIteratorTest::hasNext;
            this.payloads.next = SingletonDoubleIteratorTest::next;
        }
    }
}
