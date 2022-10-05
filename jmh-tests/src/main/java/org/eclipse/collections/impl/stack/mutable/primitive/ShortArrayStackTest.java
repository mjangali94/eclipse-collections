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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class ShortArrayStackTest extends AbstractMutableShortStackTestCase {

    @Override
    protected MutableShortStack classUnderTest() {
        return ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected MutableShortStack newWith(short... elements) {
        return ShortArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableShortStack newMutableCollectionWith(short... elements) {
        return ShortArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableShortStack newWithTopToBottom(short... elements) {
        return ShortArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableShortStack newWithIterableTopToBottom(ShortIterable iterable) {
        return ShortArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableShortStack newWithIterable(ShortIterable iterable) {
        return ShortArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Short> newObjectCollectionWith(Short... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        ShortArrayStack stack = ShortArrayStack.newStackFromTopToBottom();
        stack.push((short) 1);
        Assert.assertEquals((short) 1, stack.peek());
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1), stack);
        stack.push((short) 2);
        Assert.assertEquals((short) 2, stack.peek());
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 2, (short) 1), stack);
        stack.push((short) 3);
        Assert.assertEquals((short) 3, stack.peek());
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 3, (short) 2, (short) 1), stack);
        Assert.assertEquals((short) 2, stack.peekAt(1));
        Assert.assertEquals((short) 3, stack.pop());
        Assert.assertEquals((short) 2, stack.peek());
        Assert.assertEquals((short) 2, stack.pop());
        Assert.assertEquals((short) 1, stack.peek());
        Assert.assertEquals((short) 1, stack.pop());
        ShortArrayStack stack2 = ShortArrayStack.newStackFromTopToBottom((short) 5, (short) 4, (short) 3, (short) 2, (short) 1);
        stack2.pop(2);
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 3, (short) 2, (short) 1), stack2);
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 2), stack2.peek(2));
        ShortArrayStack stack8 = ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 3, (short) 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 3, (short) 4), stack8);
        Assert.assertEquals(new ShortArrayList(), stack8.peek(0));
        ShortArrayStack stack9 = ShortArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new ShortArrayList(), stack9.pop(0));
        Assert.assertEquals(new ShortArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableShortStackTestCase._Benchmark {

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

        private ShortArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortArrayStackTest();
        }

        @java.lang.Override
        public ShortArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
