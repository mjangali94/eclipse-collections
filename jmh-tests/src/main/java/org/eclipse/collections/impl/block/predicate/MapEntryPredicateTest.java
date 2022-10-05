/*
 * Copyright (c) 2021 Gaurav Khurana.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.predicate;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class MapEntryPredicateTest {

    private final Map.Entry<String, Integer> entry = new Map.Entry<String, Integer>() {

        @Override
        public String getKey() {
            return "1";
        }

        @Override
        public Integer getValue() {
            return 1;
        }

        @Override
        public Integer setValue(Integer value) {
            return null;
        }
    };

    @Test
    public void accept() {
        MapEntryPredicate<String, Integer> mapEntryPredicate = new MapEntryPredicate<String, Integer>() {

            @Override
            public boolean accept(String argument1, Integer argument2) {
                return String.valueOf(argument2).equals(argument1);
            }
        };
        Assert.assertTrue(mapEntryPredicate.accept(this.entry));
    }

    @Test
    public void negate() {
        MapEntryPredicate<String, Integer> mapEntryPredicate = new MapEntryPredicate<String, Integer>() {

            @Override
            public boolean accept(String argument1, Integer argument2) {
                return String.valueOf(argument2).equals(argument1);
            }
        };
        Assert.assertFalse(mapEntryPredicate.negate().accept(this.entry));
        Assert.assertFalse(mapEntryPredicate.negate().accept("1", 1));
        Assert.assertTrue(mapEntryPredicate.negate().accept(new Map.Entry<String, Integer>() {

            @Override
            public String getKey() {
                return "1";
            }

            @Override
            public Integer getValue() {
                return 2;
            }

            @Override
            public Integer setValue(Integer value) {
                return null;
            }
        }));
        Assert.assertTrue(mapEntryPredicate.negate().accept("1", 2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MapEntryPredicateTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_accept() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.accept);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_negate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.negate);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MapEntryPredicateTest> payload) throws java.lang.Throwable {
            this.instance = new MapEntryPredicateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapEntryPredicateTest> accept;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapEntryPredicateTest> negate;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.accept = MapEntryPredicateTest::accept;
            this.payloads.negate = MapEntryPredicateTest::negate;
        }
    }
}
