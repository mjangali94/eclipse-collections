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

import org.eclipse.collections.api.factory.stack.primitive.ImmutableDoubleStackFactory;
import org.eclipse.collections.api.factory.stack.primitive.MutableDoubleStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleStacks}
 * This file was automatically generated from template file primitiveStacksTest.stg
 */
public class DoubleStacksTest {

    @Test
    public void immutables() {
        this.assertImmutableStackFactory(DoubleStacks.immutable);
        this.assertImmutableStackFactory(org.eclipse.collections.api.factory.primitive.DoubleStacks.immutable);
    }

    private void assertImmutableStackFactory(ImmutableDoubleStackFactory stackFactory) {
        Assert.assertEquals(DoubleArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of());
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), stackFactory.of(1.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), stackFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0), stackFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0), stackFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(3.0, 2.0, 1.0), stackFactory.ofAll(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleStack.class, stackFactory.ofAll(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void mutables() {
        this.assertMutableStackFactory(DoubleStacks.mutable);
        this.assertMutableStackFactory(org.eclipse.collections.api.factory.primitive.DoubleStacks.mutable);
    }

    private void assertMutableStackFactory(MutableDoubleStackFactory stackFactory) {
        Assert.assertEquals(DoubleArrayStack.newStackWith(), stackFactory.of());
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of());
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), stackFactory.of(1.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), stackFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0), stackFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0), stackFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleArrayStack.newStackWith(3.0, 2.0, 1.0), stackFactory.ofAll(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(MutableDoubleStack.class, stackFactory.ofAll(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void empty() {
        Assert.assertTrue(DoubleStacks.immutable.of().isEmpty());
        Assert.assertTrue(DoubleStacks.mutable.of().isEmpty());
    }

    @Test
    public void newStackWith_immutable() {
        ImmutableDoubleStack stack = DoubleStacks.immutable.of();
        Assert.assertEquals(stack, DoubleStacks.immutable.of(stack.toArray()));
        Assert.assertEquals(stack = stack.push(1.0), DoubleStacks.immutable.of(1.0));
        Assert.assertEquals(stack = stack.push(2.0), DoubleStacks.immutable.of(1.0, 2.0));
        Assert.assertEquals(stack = stack.push(3.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0));
        Assert.assertEquals(stack = stack.push(4.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(stack = stack.push(5.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(stack = stack.push(6.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(stack = stack.push(7.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(stack = stack.push(8.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(stack = stack.push(9.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(stack = stack.push(10.0), DoubleStacks.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @Test
    public void newStackWith_mutable() {
        MutableDoubleStack stack = DoubleStacks.mutable.of();
        Assert.assertEquals(stack, DoubleStacks.mutable.of(stack.toArray()));
        stack.push(1.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0));
        stack.push(2.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0));
        stack.push(3.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0));
        stack.push(4.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0));
        stack.push(5.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        stack.push(6.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        stack.push(7.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        stack.push(8.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        stack.push(9.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        stack.push(10.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_immutable() {
        ImmutableDoubleStack stack = DoubleStacks.immutable.of();
        Assert.assertEquals(stack = stack.push(1.0), DoubleStacks.immutable.of(new double[] { 1.0 }));
        Assert.assertEquals(stack = stack.push(2.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0 }));
        Assert.assertEquals(stack = stack.push(3.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0 }));
        Assert.assertEquals(stack = stack.push(4.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        Assert.assertEquals(stack = stack.push(5.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        Assert.assertEquals(stack = stack.push(6.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        Assert.assertEquals(stack = stack.push(7.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        Assert.assertEquals(stack = stack.push(8.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        Assert.assertEquals(stack = stack.push(9.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        Assert.assertEquals(stack = stack.push(10.0), DoubleStacks.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newStackWithArray_mutable() {
        MutableDoubleStack stack = DoubleStacks.mutable.of();
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] {}));
        stack.push(1.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0 }));
        stack.push(2.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0 }));
        stack.push(3.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0 }));
        stack.push(4.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        stack.push(5.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        stack.push(6.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        stack.push(7.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        stack.push(8.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        stack.push(9.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        stack.push(10.0);
        Assert.assertEquals(stack, DoubleStacks.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @Test
    public void ofAllDoubleIterable() {
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.immutable.ofAll(DoubleLists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), DoubleStacks.immutable.ofAll(DoubleLists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), DoubleStacks.immutable.ofAll(DoubleLists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 2.0, 3.0), DoubleStacks.immutable.ofAll(DoubleLists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.mutable.ofAll(DoubleLists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), DoubleStacks.mutable.ofAll(DoubleLists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), DoubleStacks.mutable.ofAll(DoubleLists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 2.0, 3.0), DoubleStacks.mutable.ofAll(DoubleLists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.immutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), DoubleStacks.immutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), DoubleStacks.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 2.0, 3.0), DoubleStacks.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.mutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0), DoubleStacks.mutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0), DoubleStacks.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 2.0, 3.0), DoubleStacks.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
    }

    @Test
    public void ofAllReversed() {
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.immutable.ofAllReversed(DoubleLists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0), DoubleStacks.immutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0), DoubleStacks.immutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0, 2.0, 3.0), DoubleStacks.immutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleArrayStack(), DoubleStacks.mutable.ofAllReversed(DoubleLists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0), DoubleStacks.mutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0), DoubleStacks.mutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0, 2.0, 3.0), DoubleStacks.mutable.ofAllReversed(DoubleLists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleStacks.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleStacksTest instance;

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
        public void benchmark_ofAllDoubleIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllDoubleIterable);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleStacksTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> newStackWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> newStackWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> newStackWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> newStackWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> ofAllDoubleIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> ofAllReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleStacksTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = DoubleStacksTest::immutables;
            this.payloads.mutables = DoubleStacksTest::mutables;
            this.payloads.empty = DoubleStacksTest::empty;
            this.payloads.newStackWith_immutable = DoubleStacksTest::newStackWith_immutable;
            this.payloads.newStackWith_mutable = DoubleStacksTest::newStackWith_mutable;
            this.payloads.newStackWithArray_immutable = DoubleStacksTest::newStackWithArray_immutable;
            this.payloads.newStackWithArray_mutable = DoubleStacksTest::newStackWithArray_mutable;
            this.payloads.ofAllDoubleIterable = DoubleStacksTest::ofAllDoubleIterable;
            this.payloads.ofAllIterable = DoubleStacksTest::ofAllIterable;
            this.payloads.ofAllReversed = DoubleStacksTest::ofAllReversed;
            this.payloads.classIsNonInstantiable = DoubleStacksTest::classIsNonInstantiable;
        }
    }
*/
}
