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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableLongStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableLongStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class LongStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(LongStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.LongStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableLongStackFactory stackFactory) {
        Assert.assertEquals(LongArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of());
        Assert.assertEquals(LongArrayStack.newStackWith(1L), stackFactory.of(1L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), stackFactory.of(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L), stackFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L), stackFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L), stackFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongArrayStack.newStackWith(3L, 2L, 1L), stackFactory.ofAll(LongArrayStack.newStackWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongStack.class, stackFactory.ofAll(LongArrayStack.newStackWith(1L, 2L, 3L)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(LongStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.LongStacks.mutable);
    }

    private void assertMutableStackFactory(MutableLongStackFactory stackFactory) {
        Assert.assertEquals(LongArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of());
        Assert.assertEquals(LongArrayStack.newStackWith(1L), stackFactory.of(1L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), stackFactory.of(1L, 2L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L), stackFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L), stackFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L), stackFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongArrayStack.newStackWith(3L, 2L, 1L), stackFactory.ofAll(LongArrayStack.newStackWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(MutableLongStack.class, stackFactory.ofAll(LongArrayStack.newStackWith(1L, 2L, 3L)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(LongStacks.immutable.of().isEmpty());
        Assert.assertTrue(LongStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableLongStack stack = LongStacks.immutable.of();
        Assert.assertEquals(stack, LongStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push(1L), LongStacks.immutable.of(1L));
        Assert.assertEquals(stack = stack.push(2L), LongStacks.immutable.of(1L, 2L));
        Assert.assertEquals(stack = stack.push(3L), LongStacks.immutable.of(1L, 2L, 3L));
        Assert.assertEquals(stack = stack.push(4L), LongStacks.immutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(stack = stack.push(5L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(stack = stack.push(6L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(stack = stack.push(7L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(stack = stack.push(8L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(stack = stack.push(9L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(stack = stack.push(10L), LongStacks.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @Test
    public void newStackWith_mutable() {
        MutableLongStack stack = LongStacks.mutable.of();
        Assert.assertEquals(stack, LongStacks.mutable.of(stack.toArray()));
        stack.push(1L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L));
        stack.push(2L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L));
        stack.push(3L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L));
        stack.push(4L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L));
        stack.push(5L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L));
        stack.push(6L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        stack.push(7L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        stack.push(8L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        stack.push(9L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        stack.push(10L);
        Assert.assertEquals(stack, LongStacks.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableLongStack stack = LongStacks.immutable.of();
        Assert.assertEquals(stack = stack.push(1L), LongStacks.immutable.of(new long[] { 1L }));
        Assert.assertEquals(stack = stack.push(2L), LongStacks.immutable.of(new long[] { 1L, 2L }));
        Assert.assertEquals(stack = stack.push(3L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L }));
        Assert.assertEquals(stack = stack.push(4L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L }));
        Assert.assertEquals(stack = stack.push(5L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        Assert.assertEquals(stack = stack.push(6L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        Assert.assertEquals(stack = stack.push(7L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        Assert.assertEquals(stack = stack.push(8L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        Assert.assertEquals(stack = stack.push(9L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        Assert.assertEquals(stack = stack.push(10L), LongStacks.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableLongStack stack = LongStacks.mutable.of();
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] {}));
        stack.push(1L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L }));
        stack.push(2L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L }));
        stack.push(3L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L }));
        stack.push(4L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L }));
        stack.push(5L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        stack.push(6L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        stack.push(7L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        stack.push(8L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        stack.push(9L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        stack.push(10L);
        Assert.assertEquals(stack, LongStacks.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @Test
    public void ofAllLongIterable() {
        Assert.assertEquals(new LongArrayStack(), LongStacks.immutable.ofAll(LongLists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackWith(1L), LongStacks.immutable.ofAll(LongLists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), LongStacks.immutable.ofAll(LongLists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 2L, 3L), LongStacks.immutable.ofAll(LongLists.mutable.<Long>with(1L, 2L, 2L, 3L)));
        Assert.assertEquals(new LongArrayStack(), LongStacks.mutable.ofAll(LongLists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackWith(1L), LongStacks.mutable.ofAll(LongLists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), LongStacks.mutable.ofAll(LongLists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 2L, 3L), LongStacks.mutable.ofAll(LongLists.mutable.<Long>with(1L, 2L, 2L, 3L)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new LongArrayStack(), LongStacks.immutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackWith(1L), LongStacks.immutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), LongStacks.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 2L, 3L), LongStacks.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
        Assert.assertEquals(new LongArrayStack(), LongStacks.mutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackWith(1L), LongStacks.mutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L), LongStacks.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 2L, 3L), LongStacks.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new LongArrayStack(), LongStacks.immutable.ofAllReversed(LongLists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L), LongStacks.immutable.ofAllReversed(LongLists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L), LongStacks.immutable.ofAllReversed(LongLists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 2L, 3L), LongStacks.immutable.ofAllReversed(LongLists.mutable.<Long>with(1L, 2L, 2L, 3L)));
        Assert.assertEquals(new LongArrayStack(), LongStacks.mutable.ofAllReversed(LongLists.mutable.<Long>empty()));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L), LongStacks.mutable.ofAllReversed(LongLists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L), LongStacks.mutable.ofAllReversed(LongLists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 2L, 3L), LongStacks.mutable.ofAllReversed(LongLists.mutable.<Long>with(1L, 2L, 2L, 3L)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongStacks.class);
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
        public void benchmark_ofAllLongIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllLongIterable, this.description("ofAllLongIterable"));
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

        private LongStacksTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongStacksTest();
        }

        @java.lang.Override
        public LongStacksTest implementation() {
            return this.implementation;
        }
    }
}
