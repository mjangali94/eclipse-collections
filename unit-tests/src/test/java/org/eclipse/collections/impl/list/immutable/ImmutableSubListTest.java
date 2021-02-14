/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import java.util.ListIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSubListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return Lists.immutable.of(0, 1, 2, 3, 4, 5, 6, 7).subList(1, 5);
    }

    @Test
    public void testSubListListIterator() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertTrue(iterator.hasPrevious());
        Assert.assertEquals(Integer.valueOf(3), iterator.previous());
        Assert.assertEquals(Integer.valueOf(2), iterator.previous());
        Assert.assertEquals(Integer.valueOf(1), iterator.previous());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorSet_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.set(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorRemove_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorAdd_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.add(4);
    }

    @Test
    public void getOnly() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 2);
        Assert.assertEquals(Integer.valueOf(2), list.getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_empty() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 1);
        list.getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_multiple_items() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 3);
        list.getOnly();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubListListIterator, this.description("testSubListListIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorSet_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::testSubListListIteratorSet_throws, this.description("testSubListListIteratorSet_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorRemove_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::testSubListListIteratorRemove_throws, this.description("testSubListListIteratorRemove_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorAdd_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::testSubListListIteratorAdd_throws, this.description("testSubListListIteratorAdd_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly_exception_when_empty, this.description("getOnly_exception_when_empty"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_multiple_items() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly_exception_when_multiple_items, this.description("getOnly_exception_when_multiple_items"), java.lang.IllegalStateException.class);
        }

        private ImmutableSubListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableSubListTest();
        }

        @java.lang.Override
        public ImmutableSubListTest implementation() {
            return this.implementation;
        }
    }
}
