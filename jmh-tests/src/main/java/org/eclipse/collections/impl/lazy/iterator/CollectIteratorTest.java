/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class CollectIteratorTest {

    @Test
    public void iterator() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorWithFunctionName() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorWithFunctionNameAndIterator() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE).iterator(), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        new CollectIterator<>(Lists.mutable.<Boolean>of(), String::valueOf).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        new CollectIterator<>(Lists.mutable.<Boolean>of(), String::valueOf).remove();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectIteratorTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWithFunctionName() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorWithFunctionName);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWithFunctionNameAndIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorWithFunctionNameAndIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSuchElementException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new CollectIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> iteratorWithFunctionName;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> iteratorWithFunctionNameAndIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> noSuchElementException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIteratorTest> remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = CollectIteratorTest::iterator;
            this.payloads.iteratorWithFunctionName = CollectIteratorTest::iteratorWithFunctionName;
            this.payloads.iteratorWithFunctionNameAndIterator = CollectIteratorTest::iteratorWithFunctionNameAndIterator;
            this.payloads.noSuchElementException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIteratorTest::noSuchElementException, java.util.NoSuchElementException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIteratorTest::remove, java.lang.UnsupportedOperationException.class);
        }
    }
}
