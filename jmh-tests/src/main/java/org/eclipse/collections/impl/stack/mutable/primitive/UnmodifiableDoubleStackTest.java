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

import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.impl.stack.primitive.AbstractDoubleStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableDoubleStackTest extends AbstractDoubleStackTestCase {

    @Override
    protected MutableDoubleStack classUnderTest() {
        return new UnmodifiableDoubleStack(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0));
    }

    @Override
    protected MutableDoubleStack newWith(double... elements) {
        return new UnmodifiableDoubleStack(DoubleArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableDoubleStack newMutableCollectionWith(double... elements) {
        return new UnmodifiableDoubleStack(DoubleArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableDoubleStack newWithTopToBottom(double... elements) {
        return new UnmodifiableDoubleStack(DoubleArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push() {
        this.classUnderTest().push(5.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void pop() {
        this.classUnderTest().pop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popWithCount() {
        this.classUnderTest().pop(2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Test
    public void asUnmodifiable() {
        MutableDoubleStack stack1 = new UnmodifiableDoubleStack(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableDoubleStack stack1 = new UnmodifiableDoubleStack(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(SynchronizedDoubleStack.class, stack1.asSynchronized());
    }

    @Test
    public void doubleIterator_with_remove() {
        UnmodifiableDoubleStack doubleIterable = (UnmodifiableDoubleStack) this.classUnderTest();
        MutableDoubleIterator iterator = (MutableDoubleIterator) doubleIterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void doubleIterator_throws_for_remove_before_next() {
        UnmodifiableDoubleStack doubleIterable = (UnmodifiableDoubleStack) this.classUnderTest();
        MutableDoubleIterator iterator = (MutableDoubleIterator) doubleIterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.primitive.AbstractDoubleStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::push, this.description("push"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::pop, this.description("pop"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::popWithCount, this.description("popWithCount"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::clear, this.description("clear"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_with_remove, this.description("doubleIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_throws_for_remove_before_next, this.description("doubleIterator_throws_for_remove_before_next"));
        }

        private UnmodifiableDoubleStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableDoubleStackTest();
        }

        @java.lang.Override
        public UnmodifiableDoubleStackTest implementation() {
            return this.implementation;
        }
    }
}
