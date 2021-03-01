/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.Arrays;
import java.util.LinkedList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ListAdapter}.
 */
public class ListAdapterTest extends AbstractListTestCase {

    @Override
    protected <T> ListAdapter<T> newWith(T... littleElements) {
        return new ListAdapter<>(new LinkedList<>(FastList.newListWith(littleElements)));
    }

    @Test(expected = NullPointerException.class)
    public void null_throws() {
        new ListAdapter<>(null);
    }

    @Override
    @Test
    public void testClone() {
        MutableList<Integer> list = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = list.clone();
        Verify.assertListsEqual(list, list2);
    }

    @Test
    public void adapt() {
        Assert.assertEquals(ListAdapter.adapt(Arrays.asList(1, 2, 3)), Lists.adapt(Arrays.asList(1, 2, 3)));
    }

    @Test
    @Override
    public void subList() {
        // Not serializable
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertEqualsAndHashCode(sublist, sublist);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
        sublist.add("X");
        Verify.assertSize(3, sublist);
        Verify.assertContainsAll(sublist, "B", "C", "X");
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, "A", "B", "C", "X", "D");
        sublist.remove("X");
        Verify.assertContainsAll(sublist, "B", "C");
        Verify.assertContainsAll(list, "A", "B", "C", "D");
        Assert.assertEquals("C", sublist.set(1, "R"));
        Verify.assertContainsAll(sublist, "B", "R");
        Verify.assertContainsAll(list, "A", "B", "R", "D");
        sublist.addAll(Arrays.asList("W", "G"));
        Verify.assertContainsAll(sublist, "B", "R", "W", "G");
        Verify.assertContainsAll(list, "A", "B", "R", "W", "G", "D");
        sublist.clear();
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
    }

    @Override
    @Test
    public void withMethods() {
        super.withMethods();
        Verify.assertContainsAll(this.newWith(1).with(2, 3), 1, 2, 3);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4), 1, 2, 3, 4);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4, 5), 1, 2, 3, 4, 5);
    }

    @Override
    @Test
    public void getWithArrayIndexOutOfBoundsException() {
        Object item = new Object();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.newWith(item).get(-1));
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new ListAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> ListAdapter.adapt(null));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::null_throws, this.description("null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::adapt, this.description("adapt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subList, this.description("subList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMethods, this.description("withMethods"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getWithArrayIndexOutOfBoundsException, this.description("getWithArrayIndexOutOfBoundsException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::adaptNull, this.description("adaptNull"));
        }

        private ListAdapterTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ListAdapterTest();
        }

        @java.lang.Override
        public ListAdapterTest implementation() {
            return this.implementation;
        }
    }
}
