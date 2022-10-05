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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableFloatStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableFloatStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class FloatStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(FloatStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.FloatStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableFloatStackFactory stackFactory) {
        Assert.assertEquals(FloatArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of());
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), stackFactory.of(1.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), stackFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f), stackFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(3.0f, 2.0f, 1.0f), stackFactory.ofAll(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatStack.class, stackFactory.ofAll(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(FloatStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.FloatStacks.mutable);
    }

    private void assertMutableStackFactory(MutableFloatStackFactory stackFactory) {
        Assert.assertEquals(FloatArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of());
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), stackFactory.of(1.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), stackFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f), stackFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatArrayStack.newStackWith(3.0f, 2.0f, 1.0f), stackFactory.ofAll(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(MutableFloatStack.class, stackFactory.ofAll(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(FloatStacks.immutable.of().isEmpty());
        Assert.assertTrue(FloatStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableFloatStack stack = FloatStacks.immutable.of();
        Assert.assertEquals(stack, FloatStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push(1.0f), FloatStacks.immutable.of(1.0f));
        Assert.assertEquals(stack = stack.push(2.0f), FloatStacks.immutable.of(1.0f, 2.0f));
        Assert.assertEquals(stack = stack.push(3.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(stack = stack.push(4.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(stack = stack.push(5.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(stack = stack.push(6.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(stack = stack.push(7.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(stack = stack.push(8.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(stack = stack.push(9.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(stack = stack.push(10.0f), FloatStacks.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @Test
    public void newStackWith_mutable() {
        MutableFloatStack stack = FloatStacks.mutable.of();
        Assert.assertEquals(stack, FloatStacks.mutable.of(stack.toArray()));
        stack.push(1.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f));
        stack.push(2.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f));
        stack.push(3.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f));
        stack.push(4.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        stack.push(5.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        stack.push(6.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        stack.push(7.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        stack.push(8.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        stack.push(9.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        stack.push(10.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableFloatStack stack = FloatStacks.immutable.of();
        Assert.assertEquals(stack = stack.push(1.0f), FloatStacks.immutable.of(new float[] { 1.0f }));
        Assert.assertEquals(stack = stack.push(2.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f }));
        Assert.assertEquals(stack = stack.push(3.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        Assert.assertEquals(stack = stack.push(4.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        Assert.assertEquals(stack = stack.push(5.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        Assert.assertEquals(stack = stack.push(6.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        Assert.assertEquals(stack = stack.push(7.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        Assert.assertEquals(stack = stack.push(8.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        Assert.assertEquals(stack = stack.push(9.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        Assert.assertEquals(stack = stack.push(10.0f), FloatStacks.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableFloatStack stack = FloatStacks.mutable.of();
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] {}));
        stack.push(1.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f }));
        stack.push(2.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f }));
        stack.push(3.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        stack.push(4.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        stack.push(5.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        stack.push(6.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        stack.push(7.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        stack.push(8.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        stack.push(9.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        stack.push(10.0f);
        Assert.assertEquals(stack, FloatStacks.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @Test
    public void ofAllFloatIterable() {
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.immutable.ofAll(FloatLists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), FloatStacks.immutable.ofAll(FloatLists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), FloatStacks.immutable.ofAll(FloatLists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.immutable.ofAll(FloatLists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.mutable.ofAll(FloatLists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), FloatStacks.mutable.ofAll(FloatLists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), FloatStacks.mutable.ofAll(FloatLists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.mutable.ofAll(FloatLists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.immutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), FloatStacks.immutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), FloatStacks.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.mutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f), FloatStacks.mutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f), FloatStacks.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.immutable.ofAllReversed(FloatLists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f), FloatStacks.immutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f), FloatStacks.immutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.immutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatArrayStack(), FloatStacks.mutable.ofAllReversed(FloatLists.mutable.<Float>empty()));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f), FloatStacks.mutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f), FloatStacks.mutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 2.0f, 3.0f), FloatStacks.mutable.ofAllReversed(FloatLists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatStacks.class);
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
        public void benchmark_ofAllFloatIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllFloatIterable, this.description("ofAllFloatIterable"));
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

        private FloatStacksTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatStacksTest();
        }

        @java.lang.Override
        public FloatStacksTest implementation() {
            return this.implementation;
        }
    }
}
