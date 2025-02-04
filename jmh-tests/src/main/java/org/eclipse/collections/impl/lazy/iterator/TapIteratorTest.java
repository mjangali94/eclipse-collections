/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.junit.Assert;
import org.junit.Test;

public class TapIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything() {
        new TapIterator<>(Lists.immutable.of(), object -> {
        }).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported() {
        new TapIterator<>(Lists.immutable.of().iterator(), object -> {
        }).remove();
    }

    @Test
    public void nextAfterEmptyIterable() {
        Object expected = new Object();
        Iterator<Object> iterator = new TapIterator<>(Lists.fixedSize.of(expected), object -> {
        });
        Assert.assertSame(expected, iterator.next());
    }

    @Test
    public void iterator() {
        Iterator<AtomicInteger> iterator = new TapIterator<>(Lists.mutable.of(new AtomicInteger(1), new AtomicInteger(2), new AtomicInteger(3)), each -> each.set(each.get() * 10));
        MutableIntList intList = IntLists.mutable.empty();
        while (iterator.hasNext()) {
            intList.add(iterator.next().get());
        }
        Assert.assertEquals(IntLists.mutable.of(10, 20, 30), intList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapIteratorTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextIfDoesntHaveAnything() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nextIfDoesntHaveAnything);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIsUnsupported() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIsUnsupported);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextAfterEmptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nextAfterEmptyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new TapIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIteratorTest> nextIfDoesntHaveAnything;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIteratorTest> removeIsUnsupported;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIteratorTest> nextAfterEmptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIteratorTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.nextIfDoesntHaveAnything = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIteratorTest::nextIfDoesntHaveAnything, java.util.NoSuchElementException.class);
            this.payloads.removeIsUnsupported = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIteratorTest::removeIsUnsupported, java.lang.UnsupportedOperationException.class);
            this.payloads.nextAfterEmptyIterable = TapIteratorTest::nextAfterEmptyIterable;
            this.payloads.iterator = TapIteratorTest::iterator;
        }
    }
}
