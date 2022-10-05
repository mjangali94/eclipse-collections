/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.stack.primitive.ImmutableIntStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableIntStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link IntStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class IntStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(IntStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.IntStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableIntStackFactory stackFactory) {
        Assert.assertEquals(IntArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of());
        Assert.assertEquals(IntArrayStack.newStackWith(1), stackFactory.of(1));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), stackFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3), stackFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4), stackFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5), stackFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6), stackFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7), stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntArrayStack.newStackWith(3, 2, 1), stackFactory.ofAll(IntArrayStack.newStackWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableIntStack.class, stackFactory.ofAll(IntArrayStack.newStackWith(1, 2, 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(IntStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.IntStacks.mutable);
    }

    private void assertMutableStackFactory(MutableIntStackFactory stackFactory) {
        Assert.assertEquals(IntArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of());
        Assert.assertEquals(IntArrayStack.newStackWith(1), stackFactory.of(1));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), stackFactory.of(1, 2));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3), stackFactory.of(1, 2, 3));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4), stackFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5), stackFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6), stackFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7), stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntArrayStack.newStackWith(3, 2, 1), stackFactory.ofAll(IntArrayStack.newStackWith(1, 2, 3)));
        Verify.assertInstanceOf(MutableIntStack.class, stackFactory.ofAll(IntArrayStack.newStackWith(1, 2, 3)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(IntStacks.immutable.of().isEmpty());
        Assert.assertTrue(IntStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableIntStack stack = IntStacks.immutable.of();
        Assert.assertEquals(stack, IntStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push(1), IntStacks.immutable.of(1));
        Assert.assertEquals(stack = stack.push(2), IntStacks.immutable.of(1, 2));
        Assert.assertEquals(stack = stack.push(3), IntStacks.immutable.of(1, 2, 3));
        Assert.assertEquals(stack = stack.push(4), IntStacks.immutable.of(1, 2, 3, 4));
        Assert.assertEquals(stack = stack.push(5), IntStacks.immutable.of(1, 2, 3, 4, 5));
        Assert.assertEquals(stack = stack.push(6), IntStacks.immutable.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(stack = stack.push(7), IntStacks.immutable.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(stack = stack.push(8), IntStacks.immutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(stack = stack.push(9), IntStacks.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(stack = stack.push(10), IntStacks.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void newStackWith_mutable() {
        MutableIntStack stack = IntStacks.mutable.of();
        Assert.assertEquals(stack, IntStacks.mutable.of(stack.toArray()));
        stack.push(1);
        Assert.assertEquals(stack, IntStacks.mutable.of(1));
        stack.push(2);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2));
        stack.push(3);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3));
        stack.push(4);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4));
        stack.push(5);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5));
        stack.push(6);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5, 6));
        stack.push(7);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5, 6, 7));
        stack.push(8);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        stack.push(9);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        stack.push(10);
        Assert.assertEquals(stack, IntStacks.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableIntStack stack = IntStacks.immutable.of();
        Assert.assertEquals(stack = stack.push(1), IntStacks.immutable.of(new int[] { 1 }));
        Assert.assertEquals(stack = stack.push(2), IntStacks.immutable.of(new int[] { 1, 2 }));
        Assert.assertEquals(stack = stack.push(3), IntStacks.immutable.of(new int[] { 1, 2, 3 }));
        Assert.assertEquals(stack = stack.push(4), IntStacks.immutable.of(new int[] { 1, 2, 3, 4 }));
        Assert.assertEquals(stack = stack.push(5), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(stack = stack.push(6), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        Assert.assertEquals(stack = stack.push(7), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        Assert.assertEquals(stack = stack.push(8), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        Assert.assertEquals(stack = stack.push(9), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        Assert.assertEquals(stack = stack.push(10), IntStacks.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableIntStack stack = IntStacks.mutable.of();
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] {}));
        stack.push(1);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1 }));
        stack.push(2);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2 }));
        stack.push(3);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3 }));
        stack.push(4);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4 }));
        stack.push(5);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5 }));
        stack.push(6);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        stack.push(7);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        stack.push(8);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        stack.push(9);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        stack.push(10);
        Assert.assertEquals(stack, IntStacks.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    @Test
    public void ofAllIntIterable() {
        Assert.assertEquals(new IntArrayStack(), IntStacks.immutable.ofAll(IntLists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackWith(1), IntStacks.immutable.ofAll(IntLists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), IntStacks.immutable.ofAll(IntLists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 2, 3), IntStacks.immutable.ofAll(IntLists.mutable.<Integer>with(1, 2, 2, 3)));
        Assert.assertEquals(new IntArrayStack(), IntStacks.mutable.ofAll(IntLists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackWith(1), IntStacks.mutable.ofAll(IntLists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), IntStacks.mutable.ofAll(IntLists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 2, 3), IntStacks.mutable.ofAll(IntLists.mutable.<Integer>with(1, 2, 2, 3)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new IntArrayStack(), IntStacks.immutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackWith(1), IntStacks.immutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), IntStacks.immutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 2, 3), IntStacks.immutable.ofAll(Lists.mutable.<Integer>with(1, 2, 2, 3)));
        Assert.assertEquals(new IntArrayStack(), IntStacks.mutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackWith(1), IntStacks.mutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2), IntStacks.mutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 2, 3), IntStacks.mutable.ofAll(Lists.mutable.<Integer>with(1, 2, 2, 3)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new IntArrayStack(), IntStacks.immutable.ofAllReversed(IntLists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1), IntStacks.immutable.ofAllReversed(IntLists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2), IntStacks.immutable.ofAllReversed(IntLists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 2, 3), IntStacks.immutable.ofAllReversed(IntLists.mutable.<Integer>with(1, 2, 2, 3)));
        Assert.assertEquals(new IntArrayStack(), IntStacks.mutable.ofAllReversed(IntLists.mutable.<Integer>empty()));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1), IntStacks.mutable.ofAllReversed(IntLists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2), IntStacks.mutable.ofAllReversed(IntLists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 2, 3), IntStacks.mutable.ofAllReversed(IntLists.mutable.<Integer>with(1, 2, 2, 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWith_immutable, this.description("newStackWith_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWith_mutable, this.description("newStackWith_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWithArray_immutable, this.description("newStackWithArray_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newStackWithArray_mutable, this.description("newStackWithArray_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIntIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllIntIterable, this.description("ofAllIntIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllIterable, this.description("ofAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllReversed, this.description("ofAllReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private IntStacksTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntStacksTest();
        }

        @java.lang.Override
        public IntStacksTest implementation() {
            return this.implementation;
        }
    }
}
