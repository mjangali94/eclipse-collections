/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class DistinctIteratorTest {

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.newDistinctIterator().remove();
    }

    private DistinctIterator<Integer> newDistinctIterator() {
        return new DistinctIterator<>(Lists.mutable.of(4, 1, 4, 10, 1, 100));
    }

    @Test
    public void iterator() {
        List<Integer> result = Lists.mutable.empty();
        DistinctIterator<Integer> iterator = this.newDistinctIterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Assert.assertEquals(Lists.mutable.of(4, 1, 10, 100), result);
    }

    @Test(expected = NoSuchElementException.class)
    public void nextException() {
        Iterator<Integer> iterator = new DistinctIterator<>(Lists.mutable.empty());
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DistinctIteratorTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nextException);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new DistinctIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIteratorTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIteratorTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIteratorTest> nextException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIteratorTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iterator = DistinctIteratorTest::iterator;
            this.payloads.nextException = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIteratorTest::nextException, java.util.NoSuchElementException.class);
        }
    }
*/
}
