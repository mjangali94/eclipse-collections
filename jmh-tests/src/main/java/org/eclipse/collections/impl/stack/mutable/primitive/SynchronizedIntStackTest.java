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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedIntStackTest extends AbstractMutableIntStackTestCase {

    @Override
    protected MutableIntStack classUnderTest() {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(1, 2, 3));
    }

    @Override
    protected MutableIntStack newWith(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newWithTopToBottom(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newWithIterableTopToBottom(IntIterable iterable) {
        return new SynchronizedIntStack(IntArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableIntStack newWithIterable(IntIterable iterable) {
        return new SynchronizedIntStack(IntArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableIntStack stack1 = new SynchronizedIntStack(IntArrayStack.newStackWith(1, 2, 3), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableIntStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedIntStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedIntStackTest();
        }

        @java.lang.Override
        public SynchronizedIntStackTest implementation() {
            return this.implementation;
        }
    }
}
