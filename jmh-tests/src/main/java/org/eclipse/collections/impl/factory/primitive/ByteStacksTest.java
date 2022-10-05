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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableByteStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableByteStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableByteStack;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ByteArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class ByteStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(ByteStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.ByteStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableByteStackFactory stackFactory) {
        Assert.assertEquals(ByteArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of());
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), stackFactory.of((byte) 1));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), stackFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3), stackFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 3, (byte) 2, (byte) 1), stackFactory.ofAll(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteStack.class, stackFactory.ofAll(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(ByteStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.ByteStacks.mutable);
    }

    private void assertMutableStackFactory(MutableByteStackFactory stackFactory) {
        Assert.assertEquals(ByteArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of());
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), stackFactory.of((byte) 1));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), stackFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3), stackFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 3, (byte) 2, (byte) 1), stackFactory.ofAll(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(MutableByteStack.class, stackFactory.ofAll(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(ByteStacks.immutable.of().isEmpty());
        Assert.assertTrue(ByteStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableByteStack stack = ByteStacks.immutable.of();
        Assert.assertEquals(stack, ByteStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push((byte) 1), ByteStacks.immutable.of((byte) 1));
        Assert.assertEquals(stack = stack.push((byte) 2), ByteStacks.immutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(stack = stack.push((byte) 3), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(stack = stack.push((byte) 4), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(stack = stack.push((byte) 5), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(stack = stack.push((byte) 6), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(stack = stack.push((byte) 7), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(stack = stack.push((byte) 8), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(stack = stack.push((byte) 9), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(stack = stack.push((byte) 10), ByteStacks.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @Test
    public void newStackWith_mutable() {
        MutableByteStack stack = ByteStacks.mutable.of();
        Assert.assertEquals(stack, ByteStacks.mutable.of(stack.toArray()));
        stack.push((byte) 1);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1));
        stack.push((byte) 2);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2));
        stack.push((byte) 3);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3));
        stack.push((byte) 4);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        stack.push((byte) 5);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        stack.push((byte) 6);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        stack.push((byte) 7);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        stack.push((byte) 8);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        stack.push((byte) 9);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        stack.push((byte) 10);
        Assert.assertEquals(stack, ByteStacks.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableByteStack stack = ByteStacks.immutable.of();
        Assert.assertEquals(stack = stack.push((byte) 1), ByteStacks.immutable.of(new byte[] { (byte) 1 }));
        Assert.assertEquals(stack = stack.push((byte) 2), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2 }));
        Assert.assertEquals(stack = stack.push((byte) 3), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        Assert.assertEquals(stack = stack.push((byte) 4), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        Assert.assertEquals(stack = stack.push((byte) 5), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        Assert.assertEquals(stack = stack.push((byte) 6), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        Assert.assertEquals(stack = stack.push((byte) 7), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        Assert.assertEquals(stack = stack.push((byte) 8), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        Assert.assertEquals(stack = stack.push((byte) 9), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        Assert.assertEquals(stack = stack.push((byte) 10), ByteStacks.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableByteStack stack = ByteStacks.mutable.of();
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] {}));
        stack.push((byte) 1);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1 }));
        stack.push((byte) 2);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2 }));
        stack.push((byte) 3);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        stack.push((byte) 4);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        stack.push((byte) 5);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        stack.push((byte) 6);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        stack.push((byte) 7);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        stack.push((byte) 8);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        stack.push((byte) 9);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        stack.push((byte) 10);
        Assert.assertEquals(stack, ByteStacks.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @Test
    public void ofAllByteIterable() {
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.immutable.ofAll(ByteLists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), ByteStacks.immutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), ByteStacks.immutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.immutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.mutable.ofAll(ByteLists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), ByteStacks.mutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), ByteStacks.mutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.mutable.ofAll(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.immutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), ByteStacks.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), ByteStacks.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.mutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1), ByteStacks.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2), ByteStacks.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.immutable.ofAllReversed(ByteLists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1), ByteStacks.immutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2), ByteStacks.immutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.immutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteArrayStack(), ByteStacks.mutable.ofAllReversed(ByteLists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1), ByteStacks.mutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2), ByteStacks.mutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteStacks.mutable.ofAllReversed(ByteLists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteStacksTest instance;

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
        public void benchmark_ofAllByteIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllByteIterable);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> payload) throws java.lang.Throwable {
            this.instance = new ByteStacksTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> newStackWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> newStackWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> newStackWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> newStackWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> ofAllByteIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> ofAllReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteStacksTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteStacksTest::immutables;
            this.payloads.mutables = ByteStacksTest::mutables;
            this.payloads.empty = ByteStacksTest::empty;
            this.payloads.newStackWith_immutable = ByteStacksTest::newStackWith_immutable;
            this.payloads.newStackWith_mutable = ByteStacksTest::newStackWith_mutable;
            this.payloads.newStackWithArray_immutable = ByteStacksTest::newStackWithArray_immutable;
            this.payloads.newStackWithArray_mutable = ByteStacksTest::newStackWithArray_mutable;
            this.payloads.ofAllByteIterable = ByteStacksTest::ofAllByteIterable;
            this.payloads.ofAllIterable = ByteStacksTest::ofAllIterable;
            this.payloads.ofAllReversed = ByteStacksTest::ofAllReversed;
            this.payloads.classIsNonInstantiable = ByteStacksTest::classIsNonInstantiable;
        }
    }
}
