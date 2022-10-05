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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableCharStack;
import org.eclipse.collections.impl.factory.primitive.CharStacks;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class CharArrayStackTest extends AbstractMutableCharStackTestCase {

    @Override
    protected MutableCharStack classUnderTest() {
        return CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected MutableCharStack newWith(char... elements) {
        return CharArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableCharStack newMutableCollectionWith(char... elements) {
        return CharArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableCharStack newWithTopToBottom(char... elements) {
        return CharArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableCharStack newWithIterableTopToBottom(CharIterable iterable) {
        return CharArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableCharStack newWithIterable(CharIterable iterable) {
        return CharArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Character> newObjectCollectionWith(Character... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        CharArrayStack stack = CharArrayStack.newStackFromTopToBottom();
        stack.push((char) 1);
        Assert.assertEquals((char) 1, stack.peek());
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1), stack);
        stack.push((char) 2);
        Assert.assertEquals((char) 2, stack.peek());
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 2, (char) 1), stack);
        stack.push((char) 3);
        Assert.assertEquals((char) 3, stack.peek());
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 3, (char) 2, (char) 1), stack);
        Assert.assertEquals((char) 2, stack.peekAt(1));
        Assert.assertEquals((char) 3, stack.pop());
        Assert.assertEquals((char) 2, stack.peek());
        Assert.assertEquals((char) 2, stack.pop());
        Assert.assertEquals((char) 1, stack.peek());
        Assert.assertEquals((char) 1, stack.pop());
        CharArrayStack stack2 = CharArrayStack.newStackFromTopToBottom((char) 5, (char) 4, (char) 3, (char) 2, (char) 1);
        stack2.pop(2);
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 3, (char) 2, (char) 1), stack2);
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 2), stack2.peek(2));
        CharArrayStack stack8 = CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 3, (char) 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 3, (char) 4), stack8);
        Assert.assertEquals(new CharArrayList(), stack8.peek(0));
        CharArrayStack stack9 = CharArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new CharArrayList(), stack9.pop(0));
        Assert.assertEquals(new CharArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.mutable.primitive.AbstractMutableCharStackTestCase._Benchmark {

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

        private CharArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharArrayStackTest();
        }

        @java.lang.Override
        public CharArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
