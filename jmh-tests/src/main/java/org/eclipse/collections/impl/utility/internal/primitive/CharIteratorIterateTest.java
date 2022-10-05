/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class CharIteratorIterateTest {

    private final CharIterable iterable = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);

    @Test
    public void select_target() {
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(2)));
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(3)));
        Verify.assertEmpty(CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.lessThan((char) 0), new CharArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(1)));
        Verify.assertEmpty(CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 0), new CharArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, CharIteratorIterate.collect(this.iterable.charIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, CharIteratorIterate.sum(this.iterable.charIterator()));
        Assert.assertEquals(0L, CharIteratorIterate.sum(new CharArrayList().charIterator()));
    }

    @Test
    public void min() {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.min(new CharArrayList().charIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.max(new CharArrayList().charIterator()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select_target, this.description("select_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject_target, this.description("reject_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        private CharIteratorIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharIteratorIterateTest();
        }

        @java.lang.Override
        public CharIteratorIterateTest implementation() {
            return this.implementation;
        }
    }
}
