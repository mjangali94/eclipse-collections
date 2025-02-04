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

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Test;

public class ZipIteratorTest {

    private static final ImmutableList<Integer> EMPTY = Lists.immutable.of();

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        new ZipIterator<>(EMPTY, EMPTY).remove();
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ZipIteratorTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ZipIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new ZipIteratorTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ZipIteratorTest> testRemove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ZipIteratorTest::testRemove, java.lang.UnsupportedOperationException.class);
        }
    }
*/
}
