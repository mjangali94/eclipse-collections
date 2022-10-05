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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedByteStackTest extends AbstractMutableByteStackTestCase {

    @Override
    protected MutableByteStack classUnderTest() {
        return new SynchronizedByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected MutableByteStack newWith(byte... elements) {
        return new SynchronizedByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newWithTopToBottom(byte... elements) {
        return new SynchronizedByteStack(ByteArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableByteStack newMutableCollectionWith(byte... elements) {
        return new SynchronizedByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newWithIterableTopToBottom(ByteIterable iterable) {
        return new SynchronizedByteStack(ByteArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableByteStack newWithIterable(ByteIterable iterable) {
        return new SynchronizedByteStack(ByteArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableByteStack stack1 = new SynchronizedByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableByteStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedByteStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedByteStackTest();
        }

        @java.lang.Override
        public SynchronizedByteStackTest implementation() {
            return this.implementation;
        }
    }
}
