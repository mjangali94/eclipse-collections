/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.stack.primitive.MutableBooleanStack;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanStackTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedBooleanStack}.
 */
public class SynchronizedBooleanStackTest extends AbstractMutableBooleanStackTestCase {

    @Override
    protected SynchronizedBooleanStack classUnderTest() {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStackWith(true, false, true, false));
    }

    @Override
    protected SynchronizedBooleanStack newWith(boolean... elements) {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStackWith(elements));
    }

    @Override
    protected SynchronizedBooleanStack newMutableCollectionWith(boolean... elements) {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStackWith(elements));
    }

    @Override
    protected SynchronizedBooleanStack newWithTopToBottom(boolean... elements) {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected SynchronizedBooleanStack newWithIterableTopToBottom(BooleanIterable iterable) {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected SynchronizedBooleanStack newWithIterable(BooleanIterable iterable) {
        return new SynchronizedBooleanStack(BooleanArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableBooleanStack stack1 = new SynchronizedBooleanStack(BooleanArrayStack.newStackWith(true, false, true), new Object());
        Assert.assertSame(stack1, stack1.asSynchronized());
        Assert.assertEquals(stack1, stack1.asSynchronized());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedBooleanStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedBooleanStackTest();
        }

        @java.lang.Override
        public SynchronizedBooleanStackTest implementation() {
            return this.implementation;
        }
    }
}
