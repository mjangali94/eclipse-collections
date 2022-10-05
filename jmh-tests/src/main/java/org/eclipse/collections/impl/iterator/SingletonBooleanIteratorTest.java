/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.iterator;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.junit.Assert;
import org.junit.Test;

public class SingletonBooleanIteratorTest {

    @Test
    public void hasNext() {
        BooleanIterator iterator = new SingletonBooleanIterator(false);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void next() {
        SingletonBooleanIterator iterator = new SingletonBooleanIterator(false);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(false, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        try {
            iterator.next();
            Assert.fail("NoSuchElementException should have been thrown");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasNext() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasNext, this.description("hasNext"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::next, this.description("next"));
        }

        private SingletonBooleanIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SingletonBooleanIteratorTest();
        }

        @java.lang.Override
        public SingletonBooleanIteratorTest implementation() {
            return this.implementation;
        }
    }
}
