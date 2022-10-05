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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class DoubleArrayStackTest extends AbstractMutableDoubleStackTestCase {

    @Override
    protected MutableDoubleStack classUnderTest() {
        return DoubleArrayStack.newStackWith(1.0, 2.0, 3.0);
    }

    @Override
    protected MutableDoubleStack newWith(double... elements) {
        return DoubleArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableDoubleStack newMutableCollectionWith(double... elements) {
        return DoubleArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableDoubleStack newWithTopToBottom(double... elements) {
        return DoubleArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableDoubleStack newWithIterableTopToBottom(DoubleIterable iterable) {
        return DoubleArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableDoubleStack newWithIterable(DoubleIterable iterable) {
        return DoubleArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Double> newObjectCollectionWith(Double... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        DoubleArrayStack stack = DoubleArrayStack.newStackFromTopToBottom();
        stack.push(1.0);
        Assert.assertEquals(1.0, stack.peek(), 0.0);
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0), stack);
        stack.push(2.0);
        Assert.assertEquals(2.0, stack.peek(), 0.0);
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(2.0, 1.0), stack);
        stack.push(3.0);
        Assert.assertEquals(3.0, stack.peek(), 0.0);
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(3.0, 2.0, 1.0), stack);
        Assert.assertEquals(2.0, stack.peekAt(1), 0.0);
        Assert.assertEquals(3.0, stack.pop(), 0.0);
        Assert.assertEquals(2.0, stack.peek(), 0.0);
        Assert.assertEquals(2.0, stack.pop(), 0.0);
        Assert.assertEquals(1.0, stack.peek(), 0.0);
        Assert.assertEquals(1.0, stack.pop(), 0.0);
        DoubleArrayStack stack2 = DoubleArrayStack.newStackFromTopToBottom(5.0, 4.0, 3.0, 2.0, 1.0);
        stack2.pop(2);
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(3.0, 2.0, 1.0), stack2);
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 2.0), stack2.peek(2));
        DoubleArrayStack stack8 = DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0, 3.0, 4.0);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0, 3.0, 4.0), stack8);
        Assert.assertEquals(new DoubleArrayList(), stack8.peek(0));
        DoubleArrayStack stack9 = DoubleArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new DoubleArrayList(), stack9.pop(0));
        Assert.assertEquals(new DoubleArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableDoubleStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testPushPopAndPeek, this.description("testPushPopAndPeek"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private DoubleArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleArrayStackTest();
        }

        @java.lang.Override
        public DoubleArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
