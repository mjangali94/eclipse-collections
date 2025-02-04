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
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class FlatCollectIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything() {
        new FlatCollectIterator<>(Lists.immutable.of(), object -> null).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported() {
        new FlatCollectIterator<>(Lists.immutable.of().iterator(), object -> null).remove();
    }

    @Test
    public void nextAfterEmptyIterable() {
        Object expected = new Object();
        Iterator<Object> flattenIterator = new FlatCollectIterator<>(Lists.fixedSize.of(Lists.fixedSize.of(), Lists.fixedSize.of(expected)), Functions.getPassThru());
        Assert.assertSame(expected, flattenIterator.next());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectIteratorTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIteratorTest> nextIfDoesntHaveAnything;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIteratorTest> removeIsUnsupported;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIteratorTest> nextAfterEmptyIterable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.nextIfDoesntHaveAnything = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIteratorTest::nextIfDoesntHaveAnything, java.util.NoSuchElementException.class);
            this.payloads.removeIsUnsupported = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIteratorTest::removeIsUnsupported, java.lang.UnsupportedOperationException.class);
            this.payloads.nextAfterEmptyIterable = FlatCollectIteratorTest::nextAfterEmptyIterable;
        }
    }
*/
}
