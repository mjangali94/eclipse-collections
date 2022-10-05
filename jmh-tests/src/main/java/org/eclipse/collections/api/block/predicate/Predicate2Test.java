/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.block.predicate;

import org.eclipse.collections.impl.block.factory.Predicates2;
import org.junit.Assert;
import org.junit.Test;

public class Predicate2Test {

    @Test
    public void test() {
        Predicate2<Object, Object> alwaysTruePredicate = Predicates2.alwaysTrue();
        Assert.assertTrue(alwaysTruePredicate.test("A", "B"));
        Predicate2<Object, Object> alwaysFalsePredicate = Predicates2.alwaysFalse();
        Assert.assertFalse(alwaysFalsePredicate.test("C", "D"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Predicate2Test instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Predicate2Test> payload) throws java.lang.Throwable {
            this.instance = new Predicate2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Predicate2Test> test;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.test = Predicate2Test::test;
        }
    }
}
