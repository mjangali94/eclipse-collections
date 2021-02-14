/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable;

import org.eclipse.collections.api.stack.MutableStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedStack}.
 */
public class SynchronizedStackTest extends MutableStackTestCase {

    @Override
    protected <T> MutableStack<T> newStackWith(T... elements) {
        return new SynchronizedStack<>(ArrayStack.newStackWith(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements) {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements) {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStack(Iterable<T> elements) {
        return new SynchronizedStack<>(ArrayStack.newStack(elements));
    }

    @Test
    public void testNullStack() {
        Assert.assertThrows(IllegalArgumentException.class, () -> SynchronizedStack.of(null));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNullStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNullStack, this.description("testNullStack"));
        }

        private SynchronizedStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedStackTest();
        }

        @java.lang.Override
        public SynchronizedStackTest implementation() {
            return this.implementation;
        }
    }
}
