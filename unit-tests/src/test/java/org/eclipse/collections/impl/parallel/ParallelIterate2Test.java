/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ParallelIterate}.
 */
public class ParallelIterate2Test {

    /**
     * crude test to check that creation works and that all tasks are executed
     */
    @Test
    public void creationAndExecution() throws InterruptedException {
        int howManyTimes = 200;
        AtomicInteger counter = new AtomicInteger(0);
        Collection<Callable<Integer>> tasks = new ArrayList<>();
        Interval.oneTo(howManyTimes).run(() -> tasks.add(counter::getAndIncrement));
        ExecutorService executorService1 = ParallelIterate.newPooledExecutor(4, "test pool 2 4", true);
        executorService1.invokeAll(tasks);
        Assert.assertEquals(howManyTimes, counter.get());
        counter.set(0);
        ExecutorService executorService2 = ParallelIterate.newPooledExecutor(2, "test pool 2", true);
        executorService2.invokeAll(tasks);
        Assert.assertEquals(howManyTimes, counter.get());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_creationAndExecution() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::creationAndExecution, this.description("creationAndExecution"));
        }

        private ParallelIterate2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ParallelIterate2Test();
        }

        @java.lang.Override
        public ParallelIterate2Test implementation() {
            return this.implementation;
        }
    }
}
