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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class IntArrayStackTest extends AbstractMutableIntStackTestCase {

    @Override
    protected MutableIntStack classUnderTest() {
        return IntArrayStack.newStackWith(1, 2, 3);
    }

    @Override
    protected MutableIntStack newWith(int... elements) {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements) {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableIntStack newWithTopToBottom(int... elements) {
        return IntArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableIntStack newWithIterableTopToBottom(IntIterable iterable) {
        return IntArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableIntStack newWithIterable(IntIterable iterable) {
        return IntArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Integer> newObjectCollectionWith(Integer... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        IntArrayStack stack = IntArrayStack.newStackFromTopToBottom();
        stack.push(1);
        Assert.assertEquals(1, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1), stack);
        stack.push(2);
        Assert.assertEquals(2, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(2, 1), stack);
        stack.push(3);
        Assert.assertEquals(3, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(3, 2, 1), stack);
        Assert.assertEquals(2, stack.peekAt(1));
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.peek());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.peek());
        Assert.assertEquals(1, stack.pop());
        IntArrayStack stack2 = IntArrayStack.newStackFromTopToBottom(5, 4, 3, 2, 1);
        stack2.pop(2);
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(3, 2, 1), stack2);
        Assert.assertEquals(IntArrayList.newListWith(3, 2), stack2.peek(2));
        IntArrayStack stack8 = IntArrayStack.newStackFromTopToBottom(1, 2, 3, 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 3, 4), stack8);
        Assert.assertEquals(new IntArrayList(), stack8.peek(0));
        IntArrayStack stack9 = IntArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new IntArrayList(), stack9.pop(0));
        Assert.assertEquals(new IntArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableIntStackTestCase._Benchmark {

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

        private IntArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntArrayStackTest();
        }

        @java.lang.Override
        public IntArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
