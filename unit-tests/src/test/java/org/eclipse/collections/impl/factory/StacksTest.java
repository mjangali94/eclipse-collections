/*
 * Copyright (c) 2019 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import java.util.stream.Stream;
import org.eclipse.collections.api.factory.stack.ImmutableStackFactory;
import org.eclipse.collections.api.factory.stack.MutableStackFactory;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class StacksTest {

    @Test
    public void immutables() {
        ImmutableStackFactory stackFactory = Stacks.immutable;
        Assert.assertEquals(ArrayStack.newStack(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of());
        Assert.assertEquals(ArrayStack.newStackWith(1), stackFactory.of(1));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2), stackFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3), stackFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4), stackFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5), stackFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6), stackFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7), stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(ArrayStack.newStackWith(3, 2, 1), stackFactory.ofAll(ArrayStack.newStackWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.ofAll(ArrayStack.newStackWith(1, 2, 3)));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3), stackFactory.fromStream(Stream.of(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableStack.class, stackFactory.fromStream(Stream.of(1, 2, 3)));
    }

    @Test
    public void mutables() {
        MutableStackFactory stackFactory = Stacks.mutable;
        Assert.assertEquals(ArrayStack.newStack(), stackFactory.of());
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of());
        Assert.assertEquals(ArrayStack.newStackWith(1), stackFactory.of(1));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2), stackFactory.of(1, 2));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3), stackFactory.of(1, 2, 3));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4), stackFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5), stackFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6), stackFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7), stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(ArrayStack.newStackWith(3, 2, 1), stackFactory.ofAll(ArrayStack.newStackWith(1, 2, 3)));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.ofAll(ArrayStack.newStackWith(1, 2, 3)));
        Assert.assertEquals(ArrayStack.newStackWith(1, 2, 3), stackFactory.fromStream(Stream.of(1, 2, 3)));
        Verify.assertInstanceOf(MutableStack.class, stackFactory.fromStream(Stream.of(1, 2, 3)));
    }

    @Test
    public void emptyStack() {
        Assert.assertTrue(Stacks.immutable.of().isEmpty());
    }

    @Test
    public void newStackWith() {
        ImmutableStack<String> stack = Stacks.immutable.of();
        Assert.assertEquals(stack, Stacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push("1"), Stacks.immutable.of("1"));
        Assert.assertEquals(stack = stack.push("2"), Stacks.immutable.of("1", "2"));
        Assert.assertEquals(stack = stack.push("3"), Stacks.immutable.of("1", "2", "3"));
        Assert.assertEquals(stack = stack.push("4"), Stacks.immutable.of("1", "2", "3", "4"));
        Assert.assertEquals(stack = stack.push("5"), Stacks.immutable.of("1", "2", "3", "4", "5"));
        Assert.assertEquals(stack = stack.push("6"), Stacks.immutable.of("1", "2", "3", "4", "5", "6"));
        Assert.assertEquals(stack = stack.push("7"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7"));
        Assert.assertEquals(stack = stack.push("8"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8"));
        Assert.assertEquals(stack = stack.push("9"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Assert.assertEquals(stack = stack.push("10"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        Assert.assertEquals(stack = stack.push("11"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"));
        Assert.assertEquals(stack = stack.push("12"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray() {
        ImmutableStack<String> stack = Stacks.immutable.of();
        Assert.assertEquals(stack = stack.push("1"), Stacks.immutable.of(new String[] { "1" }));
        Assert.assertEquals(stack = stack.push("2"), Stacks.immutable.of(new String[] { "1", "2" }));
        Assert.assertEquals(stack = stack.push("3"), Stacks.immutable.of(new String[] { "1", "2", "3" }));
        Assert.assertEquals(stack = stack.push("4"), Stacks.immutable.of(new String[] { "1", "2", "3", "4" }));
        Assert.assertEquals(stack = stack.push("5"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5" }));
        Assert.assertEquals(stack = stack.push("6"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5", "6" }));
        Assert.assertEquals(stack = stack.push("7"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        Assert.assertEquals(stack = stack.push("8"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        Assert.assertEquals(stack = stack.push("9"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        Assert.assertEquals(stack = stack.push("10"), Stacks.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        Assert.assertEquals(stack = stack.push("11"), Stacks.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"));
    }

    @Test
    public void newStackWithStack() {
        ImmutableStack<String> stack = Stacks.immutable.of();
        ArrayStack<String> arrayStack = ArrayStack.newStackWith("1");
        Assert.assertEquals(stack = stack.push("1"), arrayStack.toImmutable());
        arrayStack.push("2");
        Assert.assertEquals(stack = stack.push("2"), arrayStack.toImmutable());
        arrayStack.push("3");
        Assert.assertEquals(stack = stack.push("3"), arrayStack.toImmutable());
        arrayStack.push("4");
        Assert.assertEquals(stack = stack.push("4"), arrayStack.toImmutable());
        arrayStack.push("5");
        Assert.assertEquals(stack = stack.push("5"), arrayStack.toImmutable());
        arrayStack.push("6");
        Assert.assertEquals(stack = stack.push("6"), arrayStack.toImmutable());
        arrayStack.push("7");
        Assert.assertEquals(stack = stack.push("7"), arrayStack.toImmutable());
        arrayStack.push("8");
        Assert.assertEquals(stack = stack.push("8"), arrayStack.toImmutable());
        arrayStack.push("9");
        Assert.assertEquals(stack = stack.push("9"), arrayStack.toImmutable());
        arrayStack.push("10");
        Assert.assertEquals(stack = stack.push("10"), arrayStack.toImmutable());
        arrayStack.push("11");
        Assert.assertEquals(stack = stack.push("11"), arrayStack.toImmutable());
    }

    @Test
    public void newStackWithWithStack() {
        ArrayStack<Object> expected = ArrayStack.newStack();
        Assert.assertEquals(expected, Stacks.mutable.ofAll(ArrayStack.newStack()));
        expected.push(1);
        Assert.assertEquals(ArrayStack.newStackWith(1), Stacks.mutable.ofAll(expected));
        expected.push(2);
        Assert.assertEquals(ArrayStack.newStackWith(2, 1), Stacks.mutable.ofAll(expected));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Stacks.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyStack, this.description("emptyStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWith, this.description("newStackWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWithArray, this.description("newStackWithArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWithStack, this.description("newStackWithStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithWithStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWithWithStack, this.description("newStackWithWithStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private StacksTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new StacksTest();
        }

        @java.lang.Override
        public StacksTest implementation() {
            return this.implementation;
        }
    }
}
