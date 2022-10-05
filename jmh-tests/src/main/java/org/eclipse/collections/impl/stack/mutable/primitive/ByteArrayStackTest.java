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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.factory.primitive.ByteStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class ByteArrayStackTest extends AbstractMutableByteStackTestCase {

    @Override
    protected MutableByteStack classUnderTest() {
        return ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected MutableByteStack newWith(byte... elements) {
        return ByteArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableByteStack newMutableCollectionWith(byte... elements) {
        return ByteArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableByteStack newWithTopToBottom(byte... elements) {
        return ByteArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableByteStack newWithIterableTopToBottom(ByteIterable iterable) {
        return ByteArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableByteStack newWithIterable(ByteIterable iterable) {
        return ByteArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Byte> newObjectCollectionWith(Byte... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        ByteArrayStack stack = ByteArrayStack.newStackFromTopToBottom();
        stack.push((byte) 1);
        Assert.assertEquals((byte) 1, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1), stack);
        stack.push((byte) 2);
        Assert.assertEquals((byte) 2, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 2, (byte) 1), stack);
        stack.push((byte) 3);
        Assert.assertEquals((byte) 3, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 3, (byte) 2, (byte) 1), stack);
        Assert.assertEquals((byte) 2, stack.peekAt(1));
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.peek());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.peek());
        Assert.assertEquals((byte) 1, stack.pop());
        ByteArrayStack stack2 = ByteArrayStack.newStackFromTopToBottom((byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1);
        stack2.pop(2);
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 3, (byte) 2, (byte) 1), stack2);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 2), stack2.peek(2));
        ByteArrayStack stack8 = ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3, (byte) 4), stack8);
        Assert.assertEquals(new ByteArrayList(), stack8.peek(0));
        ByteArrayStack stack9 = ByteArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new ByteArrayList(), stack9.pop(0));
        Assert.assertEquals(new ByteArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableByteStackTestCase._Benchmark {

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

        private ByteArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteArrayStackTest();
        }

        @java.lang.Override
        public ByteArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
