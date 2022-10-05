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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableShortStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableShortStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class ShortStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(ShortStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.ShortStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableShortStackFactory stackFactory) {
        Assert.assertEquals(ShortArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of());
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), stackFactory.of((short) 1));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), stackFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3), stackFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 3, (short) 2, (short) 1), stackFactory.ofAll(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(ImmutableShortStack.class, stackFactory.ofAll(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(ShortStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.ShortStacks.mutable);
    }

    private void assertMutableStackFactory(MutableShortStackFactory stackFactory) {
        Assert.assertEquals(ShortArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of());
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), stackFactory.of((short) 1));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), stackFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3), stackFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 3, (short) 2, (short) 1), stackFactory.ofAll(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(MutableShortStack.class, stackFactory.ofAll(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(ShortStacks.immutable.of().isEmpty());
        Assert.assertTrue(ShortStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableShortStack stack = ShortStacks.immutable.of();
        Assert.assertEquals(stack, ShortStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push((short) 1), ShortStacks.immutable.of((short) 1));
        Assert.assertEquals(stack = stack.push((short) 2), ShortStacks.immutable.of((short) 1, (short) 2));
        Assert.assertEquals(stack = stack.push((short) 3), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(stack = stack.push((short) 4), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(stack = stack.push((short) 5), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(stack = stack.push((short) 6), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(stack = stack.push((short) 7), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(stack = stack.push((short) 8), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(stack = stack.push((short) 9), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(stack = stack.push((short) 10), ShortStacks.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @Test
    public void newStackWith_mutable() {
        MutableShortStack stack = ShortStacks.mutable.of();
        Assert.assertEquals(stack, ShortStacks.mutable.of(stack.toArray()));
        stack.push((short) 1);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1));
        stack.push((short) 2);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2));
        stack.push((short) 3);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3));
        stack.push((short) 4);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        stack.push((short) 5);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        stack.push((short) 6);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        stack.push((short) 7);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        stack.push((short) 8);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        stack.push((short) 9);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        stack.push((short) 10);
        Assert.assertEquals(stack, ShortStacks.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableShortStack stack = ShortStacks.immutable.of();
        Assert.assertEquals(stack = stack.push((short) 1), ShortStacks.immutable.of(new short[] { (short) 1 }));
        Assert.assertEquals(stack = stack.push((short) 2), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2 }));
        Assert.assertEquals(stack = stack.push((short) 3), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        Assert.assertEquals(stack = stack.push((short) 4), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        Assert.assertEquals(stack = stack.push((short) 5), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        Assert.assertEquals(stack = stack.push((short) 6), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        Assert.assertEquals(stack = stack.push((short) 7), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        Assert.assertEquals(stack = stack.push((short) 8), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        Assert.assertEquals(stack = stack.push((short) 9), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        Assert.assertEquals(stack = stack.push((short) 10), ShortStacks.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableShortStack stack = ShortStacks.mutable.of();
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] {}));
        stack.push((short) 1);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1 }));
        stack.push((short) 2);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2 }));
        stack.push((short) 3);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        stack.push((short) 4);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        stack.push((short) 5);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        stack.push((short) 6);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        stack.push((short) 7);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        stack.push((short) 8);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        stack.push((short) 9);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        stack.push((short) 10);
        Assert.assertEquals(stack, ShortStacks.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @Test
    public void ofAllShortIterable() {
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.immutable.ofAll(ShortLists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), ShortStacks.immutable.ofAll(ShortLists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), ShortStacks.immutable.ofAll(ShortLists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.immutable.ofAll(ShortLists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.mutable.ofAll(ShortLists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), ShortStacks.mutable.ofAll(ShortLists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), ShortStacks.mutable.ofAll(ShortLists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.mutable.ofAll(ShortLists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.immutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), ShortStacks.immutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), ShortStacks.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.mutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1), ShortStacks.mutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2), ShortStacks.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.immutable.ofAllReversed(ShortLists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1), ShortStacks.immutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2), ShortStacks.immutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.immutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortArrayStack(), ShortStacks.mutable.ofAllReversed(ShortLists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1), ShortStacks.mutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2), ShortStacks.mutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 2, (short) 3), ShortStacks.mutable.ofAllReversed(ShortLists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortStacksTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWith_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWith_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWithArray_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWithArray_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllShortIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllShortIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> payload) throws java.lang.Throwable {
            this.instance = new ShortStacksTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> newStackWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> newStackWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> newStackWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> newStackWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> ofAllShortIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> ofAllReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortStacksTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortStacksTest::immutables;
            this.payloads.mutables = ShortStacksTest::mutables;
            this.payloads.empty = ShortStacksTest::empty;
            this.payloads.newStackWith_immutable = ShortStacksTest::newStackWith_immutable;
            this.payloads.newStackWith_mutable = ShortStacksTest::newStackWith_mutable;
            this.payloads.newStackWithArray_immutable = ShortStacksTest::newStackWithArray_immutable;
            this.payloads.newStackWithArray_mutable = ShortStacksTest::newStackWithArray_mutable;
            this.payloads.ofAllShortIterable = ShortStacksTest::ofAllShortIterable;
            this.payloads.ofAllIterable = ShortStacksTest::ofAllIterable;
            this.payloads.ofAllReversed = ShortStacksTest::ofAllReversed;
            this.payloads.classIsNonInstantiable = ShortStacksTest::classIsNonInstantiable;
        }
    }
}
