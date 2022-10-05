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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedShortStackTest extends AbstractMutableShortStackTestCase {

    @Override
    protected MutableShortStack classUnderTest() {
        return new SynchronizedShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected MutableShortStack newWith(short... elements) {
        return new SynchronizedShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newWithTopToBottom(short... elements) {
        return new SynchronizedShortStack(ShortArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableShortStack newMutableCollectionWith(short... elements) {
        return new SynchronizedShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newWithIterableTopToBottom(ShortIterable iterable) {
        return new SynchronizedShortStack(ShortArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableShortStack newWithIterable(ShortIterable iterable) {
        return new SynchronizedShortStack(ShortArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableShortStack stack1 = new SynchronizedShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableShortStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedShortStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortStackTest();
        }

        @java.lang.Override
        public SynchronizedShortStackTest implementation() {
            return this.implementation;
        }
    }
}
