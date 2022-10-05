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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class FloatArrayStackTest extends AbstractMutableFloatStackTestCase {

    @Override
    protected MutableFloatStack classUnderTest() {
        return FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected MutableFloatStack newWith(float... elements) {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableFloatStack newMutableCollectionWith(float... elements) {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableFloatStack newWithTopToBottom(float... elements) {
        return FloatArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableFloatStack newWithIterableTopToBottom(FloatIterable iterable) {
        return FloatArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableFloatStack newWithIterable(FloatIterable iterable) {
        return FloatArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Float> newObjectCollectionWith(Float... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        FloatArrayStack stack = FloatArrayStack.newStackFromTopToBottom();
        stack.push(1.0f);
        Assert.assertEquals(1.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f), stack);
        stack.push(2.0f);
        Assert.assertEquals(2.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(2.0f, 1.0f), stack);
        stack.push(3.0f);
        Assert.assertEquals(3.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(3.0f, 2.0f, 1.0f), stack);
        Assert.assertEquals(2.0f, stack.peekAt(1), 0.0f);
        Assert.assertEquals(3.0f, stack.pop(), 0.0f);
        Assert.assertEquals(2.0f, stack.peek(), 0.0f);
        Assert.assertEquals(2.0f, stack.pop(), 0.0f);
        Assert.assertEquals(1.0f, stack.peek(), 0.0f);
        Assert.assertEquals(1.0f, stack.pop(), 0.0f);
        FloatArrayStack stack2 = FloatArrayStack.newStackFromTopToBottom(5.0f, 4.0f, 3.0f, 2.0f, 1.0f);
        stack2.pop(2);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(3.0f, 2.0f, 1.0f), stack2);
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 2.0f), stack2.peek(2));
        FloatArrayStack stack8 = FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f, 4.0f);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f, 4.0f), stack8);
        Assert.assertEquals(new FloatArrayList(), stack8.peek(0));
        FloatArrayStack stack9 = FloatArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new FloatArrayList(), stack9.pop(0));
        Assert.assertEquals(new FloatArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableFloatStackTestCase._Benchmark {

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

        private FloatArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatArrayStackTest();
        }

        @java.lang.Override
        public FloatArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
