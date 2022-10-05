/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableShortArrayStackTest extends AbstractImmutableShortStackTestCase {

    @Override
    protected ImmutableShortStack classUnderTest() {
        return ImmutableShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws() {
        ImmutableShortArrayStack.newStack(ShortStacks.mutable.with((short) 1));
    }

    @Test
    public void newWithIterable() {
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3), this.newWithIterable(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void newWithTopToBottom() {
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 3), this.newWithTopToBottom((short) 1, (short) 2, (short) 3));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableShortArrayStack iterable = ImmutableShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.stack.immutable.primitive.AbstractImmutableShortStackTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStack_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::testNewStack_throws, this.description("testNewStack_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithIterable, this.description("newWithIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithTopToBottom() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithTopToBottom, this.description("newWithTopToBottom"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private ImmutableShortArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortArrayStackTest();
        }

        @java.lang.Override
        public ImmutableShortArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
