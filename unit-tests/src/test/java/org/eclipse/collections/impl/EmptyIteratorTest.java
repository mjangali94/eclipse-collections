/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyIteratorTest {

    private EmptyIterator<Object> emptyIterator;

    @Before
    public void setUp() {
        this.emptyIterator = EmptyIterator.getInstance();
    }

    @Test
    public void hasPrevious() {
        Assert.assertFalse(this.emptyIterator.hasPrevious());
    }

    @Test
    public void previous() {
        Assert.assertThrows(NoSuchElementException.class, this.emptyIterator::previous);
    }

    @Test
    public void previousIndex() {
        Assert.assertEquals(-1, this.emptyIterator.previousIndex());
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.set(1));
    }

    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.add(1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasPrevious() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasPrevious, this.description("hasPrevious"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_previous() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::previous, this.description("previous"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_previousIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::previousIndex, this.description("previousIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::set, this.description("set"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private EmptyIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new EmptyIteratorTest();
        }

        @java.lang.Override
        public EmptyIteratorTest implementation() {
            return this.implementation;
        }
    }
}
