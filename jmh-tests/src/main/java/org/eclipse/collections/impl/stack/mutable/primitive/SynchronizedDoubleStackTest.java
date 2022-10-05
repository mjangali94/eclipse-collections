/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedDoubleStackTest extends AbstractMutableDoubleStackTestCase {

    @Override
    protected MutableDoubleStack classUnderTest() {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0));
    }

    @Override
    protected MutableDoubleStack newWith(double... elements) {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableDoubleStack newWithTopToBottom(double... elements) {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableDoubleStack newMutableCollectionWith(double... elements) {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableDoubleStack newWithIterableTopToBottom(DoubleIterable iterable) {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableDoubleStack newWithIterable(DoubleIterable iterable) {
        return new SynchronizedDoubleStack(DoubleArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableDoubleStack stack1 = new SynchronizedDoubleStack(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableDoubleStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedDoubleStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleStackTest();
        }

        @java.lang.Override
        public SynchronizedDoubleStackTest implementation() {
            return this.implementation;
        }
    }
}
