/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.parallel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.block.procedure.DoNothingProcedure;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectIntProcedureFJTaskRunnerTest {

    private ObjectIntProcedureFJTaskRunner<Integer, ObjectIntProcedure<Integer>> undertest;

    @Before
    public void setUp() {
        this.undertest = new ObjectIntProcedureFJTaskRunner<>(new DoNothingWithFalseCombineOneCombiner(), 1, null, new MockLatch());
    }

    @Test
    public void taskCompletedUsingNonCombineOne() {
        Assert.assertThrows(CountDownCalledException.class, () -> this.undertest.taskCompleted(null));
    }

    @Test
    public void joinUsingNonCombineOne() {
        Assert.assertThrows(AwaitDownCalledException.class, () -> this.undertest.executeAndCombine(new DoNothingExecutor(), new PassThroughObjectIntProcedureFactory(), FastList.newList()));
    }

    private static class DoNothingWithFalseCombineOneCombiner implements Combiner<ObjectIntProcedure<Integer>> {

        private static final long serialVersionUID = 1L;

        @Override
        public void combineAll(Iterable<ObjectIntProcedure<Integer>> thingsToCombine) {
        }

        @Override
        public void combineOne(ObjectIntProcedure<Integer> thingToCombine) {
        }

        @Override
        public boolean useCombineOne() {
            return false;
        }
    }

    private static class CountDownCalledException extends RuntimeException {

        private static final long serialVersionUID = 1L;
    }

    private static class AwaitDownCalledException extends RuntimeException {

        private static final long serialVersionUID = 1L;
    }

    private static final class MockLatch extends CountDownLatch {

        private MockLatch() {
            super(1);
        }

        @Override
        public void countDown() {
            throw new CountDownCalledException();
        }

        @Override
        public void await() {
            throw new AwaitDownCalledException();
        }
    }

    private static class DoNothingExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
        }
    }

    private static class PassThroughObjectIntProcedureFactory implements ObjectIntProcedureFactory<ObjectIntProcedure<Integer>> {

        @Override
        public ObjectIntProcedure<Integer> create() {
            return this.getPassThroughObjectIntProcedure();
        }

        private ObjectIntProcedure<Integer> getPassThroughObjectIntProcedure() {
            return ObjectIntProcedures.fromProcedure(DoNothingProcedure.DO_NOTHING);
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_taskCompletedUsingNonCombineOne() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::taskCompletedUsingNonCombineOne, this.description("taskCompletedUsingNonCombineOne"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_joinUsingNonCombineOne() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::joinUsingNonCombineOne, this.description("joinUsingNonCombineOne"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private ObjectIntProcedureFJTaskRunnerTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntProcedureFJTaskRunnerTest();
        }

        @java.lang.Override
        public ObjectIntProcedureFJTaskRunnerTest implementation() {
            return this.implementation;
        }
    }
}
