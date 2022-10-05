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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class LongArrayStackTest extends AbstractMutableLongStackTestCase {

    @Override
    protected MutableLongStack classUnderTest() {
        return LongArrayStack.newStackWith(1L, 2L, 3L);
    }

    @Override
    protected MutableLongStack newWith(long... elements) {
        return LongArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableLongStack newMutableCollectionWith(long... elements) {
        return LongArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableLongStack newWithTopToBottom(long... elements) {
        return LongArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableLongStack newWithIterableTopToBottom(LongIterable iterable) {
        return LongArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableLongStack newWithIterable(LongIterable iterable) {
        return LongArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Long> newObjectCollectionWith(Long... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        LongArrayStack stack = LongArrayStack.newStackFromTopToBottom();
        stack.push(1L);
        Assert.assertEquals(1L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L), stack);
        stack.push(2L);
        Assert.assertEquals(2L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(2L, 1L), stack);
        stack.push(3L);
        Assert.assertEquals(3L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(3L, 2L, 1L), stack);
        Assert.assertEquals(2L, stack.peekAt(1));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.peek());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.peek());
        Assert.assertEquals(1L, stack.pop());
        LongArrayStack stack2 = LongArrayStack.newStackFromTopToBottom(5L, 4L, 3L, 2L, 1L);
        stack2.pop(2);
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(3L, 2L, 1L), stack2);
        Assert.assertEquals(LongArrayList.newListWith(3L, 2L), stack2.peek(2));
        LongArrayStack stack8 = LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L, 4L);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L, 4L), stack8);
        Assert.assertEquals(new LongArrayList(), stack8.peek(0));
        LongArrayStack stack9 = LongArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new LongArrayList(), stack9.pop(0));
        Assert.assertEquals(new LongArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableLongStackTestCase._Benchmark {

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

        private LongArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongArrayStackTest();
        }

        @java.lang.Override
        public LongArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
