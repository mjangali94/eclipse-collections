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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedLongStackTest extends AbstractMutableLongStackTestCase {

    @Override
    protected MutableLongStack classUnderTest() {
        return new SynchronizedLongStack(LongArrayStack.newStackWith(1L, 2L, 3L));
    }

    @Override
    protected MutableLongStack newWith(long... elements) {
        return new SynchronizedLongStack(LongArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableLongStack newWithTopToBottom(long... elements) {
        return new SynchronizedLongStack(LongArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableLongStack newMutableCollectionWith(long... elements) {
        return new SynchronizedLongStack(LongArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableLongStack newWithIterableTopToBottom(LongIterable iterable) {
        return new SynchronizedLongStack(LongArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableLongStack newWithIterable(LongIterable iterable) {
        return new SynchronizedLongStack(LongArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableLongStack stack1 = new SynchronizedLongStack(LongArrayStack.newStackWith(1L, 2L, 3L), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableLongStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongStackTest();
        }

        @java.lang.Override
        public SynchronizedLongStackTest implementation() {
            return this.implementation;
        }
    }
}
