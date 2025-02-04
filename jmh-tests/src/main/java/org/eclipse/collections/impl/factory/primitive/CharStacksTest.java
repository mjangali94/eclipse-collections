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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableCharStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableCharStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;
import org.eclipse.collections.api.stack.primitive.MutableCharStack;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class CharStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(CharStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.CharStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableCharStackFactory stackFactory) {
        Assert.assertEquals(CharArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of());
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), stackFactory.of((char) 1));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), stackFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3), stackFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 3, (char) 2, (char) 1), stackFactory.ofAll(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharStack.class, stackFactory.ofAll(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(CharStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.CharStacks.mutable);
    }

    private void assertMutableStackFactory(MutableCharStackFactory stackFactory) {
        Assert.assertEquals(CharArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of());
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), stackFactory.of((char) 1));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), stackFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3), stackFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 3, (char) 2, (char) 1), stackFactory.ofAll(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(MutableCharStack.class, stackFactory.ofAll(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(CharStacks.immutable.of().isEmpty());
        Assert.assertTrue(CharStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableCharStack stack = CharStacks.immutable.of();
        Assert.assertEquals(stack, CharStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push((char) 1), CharStacks.immutable.of((char) 1));
        Assert.assertEquals(stack = stack.push((char) 2), CharStacks.immutable.of((char) 1, (char) 2));
        Assert.assertEquals(stack = stack.push((char) 3), CharStacks.immutable.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(stack = stack.push((char) 4), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(stack = stack.push((char) 5), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(stack = stack.push((char) 6), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(stack = stack.push((char) 7), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(stack = stack.push((char) 8), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(stack = stack.push((char) 9), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(stack = stack.push((char) 10), CharStacks.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @Test
    public void newStackWith_mutable() {
        MutableCharStack stack = CharStacks.mutable.of();
        Assert.assertEquals(stack, CharStacks.mutable.of(stack.toArray()));
        stack.push((char) 1);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1));
        stack.push((char) 2);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2));
        stack.push((char) 3);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3));
        stack.push((char) 4);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        stack.push((char) 5);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        stack.push((char) 6);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        stack.push((char) 7);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        stack.push((char) 8);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        stack.push((char) 9);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        stack.push((char) 10);
        Assert.assertEquals(stack, CharStacks.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableCharStack stack = CharStacks.immutable.of();
        Assert.assertEquals(stack = stack.push((char) 1), CharStacks.immutable.of(new char[] { (char) 1 }));
        Assert.assertEquals(stack = stack.push((char) 2), CharStacks.immutable.of(new char[] { (char) 1, (char) 2 }));
        Assert.assertEquals(stack = stack.push((char) 3), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        Assert.assertEquals(stack = stack.push((char) 4), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        Assert.assertEquals(stack = stack.push((char) 5), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        Assert.assertEquals(stack = stack.push((char) 6), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        Assert.assertEquals(stack = stack.push((char) 7), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        Assert.assertEquals(stack = stack.push((char) 8), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        Assert.assertEquals(stack = stack.push((char) 9), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        Assert.assertEquals(stack = stack.push((char) 10), CharStacks.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableCharStack stack = CharStacks.mutable.of();
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] {}));
        stack.push((char) 1);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1 }));
        stack.push((char) 2);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2 }));
        stack.push((char) 3);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        stack.push((char) 4);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        stack.push((char) 5);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        stack.push((char) 6);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        stack.push((char) 7);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        stack.push((char) 8);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        stack.push((char) 9);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        stack.push((char) 10);
        Assert.assertEquals(stack, CharStacks.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @Test
    public void ofAllCharIterable() {
        Assert.assertEquals(new CharArrayStack(), CharStacks.immutable.ofAll(CharLists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), CharStacks.immutable.ofAll(CharLists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), CharStacks.immutable.ofAll(CharLists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.immutable.ofAll(CharLists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
        Assert.assertEquals(new CharArrayStack(), CharStacks.mutable.ofAll(CharLists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), CharStacks.mutable.ofAll(CharLists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), CharStacks.mutable.ofAll(CharLists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.mutable.ofAll(CharLists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new CharArrayStack(), CharStacks.immutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), CharStacks.immutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), CharStacks.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
        Assert.assertEquals(new CharArrayStack(), CharStacks.mutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1), CharStacks.mutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2), CharStacks.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new CharArrayStack(), CharStacks.immutable.ofAllReversed(CharLists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1), CharStacks.immutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2), CharStacks.immutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.immutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
        Assert.assertEquals(new CharArrayStack(), CharStacks.mutable.ofAllReversed(CharLists.mutable.<Character>empty()));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1), CharStacks.mutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2), CharStacks.mutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 2, (char) 3), CharStacks.mutable.ofAllReversed(CharLists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharStacksTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWith_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWith_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWithArray_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newStackWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newStackWithArray_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllCharIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllCharIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> payload) throws java.lang.Throwable {
            this.instance = new CharStacksTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> newStackWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> newStackWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> newStackWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> newStackWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> ofAllCharIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> ofAllReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharStacksTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharStacksTest::immutables;
            this.payloads.mutables = CharStacksTest::mutables;
            this.payloads.empty = CharStacksTest::empty;
            this.payloads.newStackWith_immutable = CharStacksTest::newStackWith_immutable;
            this.payloads.newStackWith_mutable = CharStacksTest::newStackWith_mutable;
            this.payloads.newStackWithArray_immutable = CharStacksTest::newStackWithArray_immutable;
            this.payloads.newStackWithArray_mutable = CharStacksTest::newStackWithArray_mutable;
            this.payloads.ofAllCharIterable = CharStacksTest::ofAllCharIterable;
            this.payloads.ofAllIterable = CharStacksTest::ofAllIterable;
            this.payloads.ofAllReversed = CharStacksTest::ofAllReversed;
            this.payloads.classIsNonInstantiable = CharStacksTest::classIsNonInstantiable;
        }
    }
}
