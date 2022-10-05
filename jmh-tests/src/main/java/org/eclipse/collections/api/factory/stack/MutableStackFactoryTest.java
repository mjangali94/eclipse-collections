/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.stack;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Stacks;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MutableStackFactoryTest {

    private final MutableStackFactory mutableStackFactory = Stacks.mutable;

    @Test
    public void with() {
        MutableStack<Object> stack = this.mutableStackFactory.with();
        Verify.assertNotNull(stack);
        Verify.assertEmpty(stack);
    }

    @Test
    public void of() {
        MutableStack<Integer> stack = this.mutableStackFactory.of();
        Verify.assertNotNull(stack);
        Verify.assertEmpty(stack);
        MutableStack<Integer> intStack = this.mutableStackFactory.of(1, 2, 3);
        Verify.assertSize(3, intStack);
        Verify.assertContainsAll(intStack, 1, 2, 3);
        Assert.assertEquals(3, (long) intStack.pop());
        Assert.assertEquals(2, (long) intStack.pop());
        Assert.assertEquals(1, (long) intStack.pop());
    }

    @Test
    public void ofAll() {
        MutableStack<Integer> intStack = this.mutableStackFactory.ofAll(Lists.mutable.of(4, 5));
        Verify.assertSize(2, intStack);
        Assert.assertEquals(5, (long) intStack.pop());
        Assert.assertEquals(4, (long) intStack.pop());
        Verify.assertEmpty(intStack);
    }

    @Test
    public void ofAllReversed() {
        MutableStack<Integer> intStack = this.mutableStackFactory.ofAllReversed(Lists.mutable.of(4, 5));
        Verify.assertSize(2, intStack);
        Assert.assertEquals(4, (long) intStack.pop());
        Assert.assertEquals(5, (long) intStack.pop());
        Verify.assertEmpty(intStack);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAll, this.description("ofAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllReversed, this.description("ofAllReversed"));
        }

        private MutableStackFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableStackFactoryTest();
        }

        @java.lang.Override
        public MutableStackFactoryTest implementation() {
            return this.implementation;
        }
    }
}
