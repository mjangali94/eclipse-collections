/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory;

import org.eclipse.collections.api.block.factory.SerializableComparators;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class SerializableComparatorsTest {

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(SerializableComparators.class);
    }

    @Test
    public void naturalOrder() {
        MutableList<String> list = Lists.mutable.with("1", "4", "2", "3");
        Assert.assertEquals(Lists.mutable.with("1", "2", "3", "4"), list.sortThis(SerializableComparators.naturalOrder()));
        Assert.assertThrows(NullPointerException.class, () -> FastList.newListWith("1", "2", null, "4").sortThis(Comparators.naturalOrder()));
    }

    @Test
    public void reverseNaturalOrder() {
        MutableList<String> list = Lists.mutable.with("1", "4", "2", "3");
        Assert.assertEquals(Lists.mutable.with("4", "3", "2", "1"), list.sortThis(SerializableComparators.reverseNaturalOrder()));
    }

    @Test
    public void reverse() {
        MutableList<String> list = Lists.mutable.with("1", "4", "2", "3");
        Assert.assertEquals(Lists.mutable.with("4", "3", "2", "1"), list.sortThis(SerializableComparators.reverse(String::compareTo)));
        Assert.assertThrows(NullPointerException.class, () -> SerializableComparators.reverse(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SerializableComparatorsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_naturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.naturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverse);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SerializableComparatorsTest> payload) throws java.lang.Throwable {
            this.instance = new SerializableComparatorsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SerializableComparatorsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SerializableComparatorsTest> naturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SerializableComparatorsTest> reverseNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SerializableComparatorsTest> reverse;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.classIsNonInstantiable = SerializableComparatorsTest::classIsNonInstantiable;
            this.payloads.naturalOrder = SerializableComparatorsTest::naturalOrder;
            this.payloads.reverseNaturalOrder = SerializableComparatorsTest::reverseNaturalOrder;
            this.payloads.reverse = SerializableComparatorsTest::reverse;
        }
    }
}
