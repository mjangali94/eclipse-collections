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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.stack.primitive.MutableCharStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedCharStackTest extends AbstractMutableCharStackTestCase {

    @Override
    protected MutableCharStack classUnderTest() {
        return new SynchronizedCharStack(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected MutableCharStack newWith(char... elements) {
        return new SynchronizedCharStack(CharArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableCharStack newWithTopToBottom(char... elements) {
        return new SynchronizedCharStack(CharArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableCharStack newMutableCollectionWith(char... elements) {
        return new SynchronizedCharStack(CharArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableCharStack newWithIterableTopToBottom(CharIterable iterable) {
        return new SynchronizedCharStack(CharArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableCharStack newWithIterable(CharIterable iterable) {
        return new SynchronizedCharStack(CharArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableCharStack stack1 = new SynchronizedCharStack(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableCharStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedCharStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharStackTest();
        }

        @java.lang.Override
        public SynchronizedCharStackTest implementation() {
            return this.implementation;
        }
    }
}
