/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable;

import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.impl.stack.StackIterableTestCase;
import org.junit.Assert;

public abstract class ImmutableStackTestCase extends StackIterableTestCase {

    @Override
    protected abstract <T> ImmutableStack<T> newStackWith(T... elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStackFromTopToBottom(T... elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStackFromTopToBottom(Iterable<T> elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStack(Iterable<T> elements);

    public void sumByInt() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectLongMap<Integer> result = values.sumByInt(i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    public void sumByFloat() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectDoubleMap<Integer> result = values.sumByFloat(f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    public void sumByDouble() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectDoubleMap<Integer> result = values.sumByDouble(d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

    public void sumByLong() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectLongMap<Integer> result = values.sumByLong(l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract ImmutableStackTestCase implementation();
    }
}
