/*
 * Copyright (c) 2020 The Bank of New York Mellon and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.factory.Bags;
import org.junit.Assert;
import org.junit.Test;

public class BagAddOccurrencesProcedureTest {

    @Test
    public void basicCase() {
        MutableBag<String> targetCollection = Bags.mutable.empty();
        BagAddOccurrencesProcedure<String> procedure = new BagAddOccurrencesProcedure<>(targetCollection);
        procedure.value("fred", 1);
        procedure.value("fred", 1);
        procedure.value("mary", 3);
        Assert.assertEquals(2, procedure.getResult().occurrencesOf("fred"));
        Assert.assertEquals(3, procedure.getResult().occurrencesOf("mary"));
        Assert.assertEquals(0, procedure.getResult().occurrencesOf("other"));
    }

    @Test
    public void basicCaseUsingFactoryMethod() {
        MutableBag<String> targetCollection = Bags.mutable.empty();
        BagAddOccurrencesProcedure<String> procedure = BagAddOccurrencesProcedure.on(targetCollection);
        procedure.value("fred", 1);
        procedure.value("fred", 1);
        procedure.value("mary", 3);
        Assert.assertEquals(2, procedure.getResult().occurrencesOf("fred"));
        Assert.assertEquals(3, procedure.getResult().occurrencesOf("mary"));
        Assert.assertEquals(0, procedure.getResult().occurrencesOf("other"));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCaseUsingFactoryMethod() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCaseUsingFactoryMethod, this.description("basicCaseUsingFactoryMethod"));
        }

        private BagAddOccurrencesProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BagAddOccurrencesProcedureTest();
        }

        @java.lang.Override
        public BagAddOccurrencesProcedureTest implementation() {
            return this.implementation;
        }
    }
}
