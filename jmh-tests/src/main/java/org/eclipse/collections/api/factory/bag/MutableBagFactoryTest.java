/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.bag;

import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class MutableBagFactoryTest {

    private final MutableBagFactory mutableBagFactory = Bags.mutable;

    @Test
    public void with() {
        Verify.assertEmpty(this.mutableBagFactory.with());
    }

    @Test
    public void of() {
        Verify.assertEmpty(this.mutableBagFactory.of());
    }


    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MutableBagFactoryTest instance;

          @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableBagFactoryTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableBagFactoryTest::with;
            this.payloads.of = MutableBagFactoryTest::of;
        }
    }

}
