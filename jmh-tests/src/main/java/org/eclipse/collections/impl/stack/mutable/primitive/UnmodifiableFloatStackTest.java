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

import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.stack.primitive.AbstractFloatStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableFloatStackTest extends AbstractFloatStackTestCase {

    @Override
    protected MutableFloatStack classUnderTest() {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected MutableFloatStack newWith(float... elements) {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newMutableCollectionWith(float... elements) {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newWithTopToBottom(float... elements) {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push() {
        this.classUnderTest().push(5.0f);
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
        MutableFloatStack stack1 = new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableFloatStack stack1 = new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(SynchronizedFloatStack.class, stack1.asSynchronized());
    }

    @Test
    public void floatIterator_with_remove() {
        UnmodifiableFloatStack floatIterable = (UnmodifiableFloatStack) this.classUnderTest();
        MutableFloatIterator iterator = (MutableFloatIterator) floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void floatIterator_throws_for_remove_before_next() {
        UnmodifiableFloatStack floatIterable = (UnmodifiableFloatStack) this.classUnderTest();
        MutableFloatIterator iterator = (MutableFloatIterator) floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.primitive.AbstractFloatStackTestCase._Benchmark {

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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_with_remove, this.description("floatIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_throws_for_remove_before_next, this.description("floatIterator_throws_for_remove_before_next"));
        }

        private UnmodifiableFloatStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableFloatStackTest();
        }

        @java.lang.Override
        public UnmodifiableFloatStackTest implementation() {
            return this.implementation;
        }
    }
}
