/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable;

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.factory.Stacks;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ArrayStack}.
 */
public class ArrayStackTest extends MutableStackTestCase {

    @Override
    protected <T> MutableStack<T> newStackWith(T... elements) {
        return Stacks.mutable.of(elements);
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements) {
        return Stacks.mutable.ofReversed(elements);
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements) {
        return Stacks.mutable.ofAllReversed(elements);
    }

    @Override
    protected <T> MutableStack<T> newStack(Iterable<T> elements) {
        return Stacks.mutable.ofAll(elements);
    }

    @Test
    public void takeWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.takeWhile(null));
    }

    @Test
    public void dropWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.dropWhile(null));
    }

    @Test
    public void partitionWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.partitionWhile(null));
    }

    @Test
    public void distinct() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, arrayStack::distinct);
    }

    @Test
    public void indexOf() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.indexOf(null));
    }

    @Test
    public void corresponds() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.corresponds(null, null));
    }

    @Test
    public void hasSameElements() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.hasSameElements(null));
    }

    @Test
    public void forEach_exception() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.forEach(0, 1, null));
    }

    @Test
    public void forEachWithIndex_exception() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.forEachWithIndex(0, 1, null));
    }

    @Test
    public void detectIndex() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.detectIndex(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeWhile, this.description("takeWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropWhile, this.description("dropWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWhile, this.description("partitionWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::corresponds, this.description("corresponds"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasSameElements() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasSameElements, this.description("hasSameElements"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_exception() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_exception, this.description("forEach_exception"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex_exception() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex_exception, this.description("forEachWithIndex_exception"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndex, this.description("detectIndex"));
        }

        private ArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ArrayStackTest();
        }

        @java.lang.Override
        public ArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
