/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Test;

public class NullSafeSortingTest {

    @Test
    public void emptyFastList() {
        Lists.mutable.of().sortThis(null);
    }

    @Test
    public void fastListWithOneElement() {
        FastList.newListWith(1).sortThis(null);
    }

    @Test
    public void fastListWithThreeElements() {
        FastList.newListWith(1, 2, 3).sortThis(null);
    }

    @Test
    public void arrayIterate() {
        Object[] array0 = {};
        ArrayIterate.sort(array0, 0, null);
        Object[] array1 = { 1 };
        ArrayIterate.sort(array1, 1, null);
        Object[] array2 = { 1, 2 };
        ArrayIterate.sort(array2, 2, null);
    }

    @Test
    public void emptyArrayListAdapter() {
        ListAdapter.adapt(new ArrayList<>()).sortThis(null);
    }

    @Test
    public void arrayListAdapterWithOneElement() {
        MutableList<Integer> list = ListAdapter.adapt(new ArrayList<>());
        list.add(1);
        list.sortThis(null);
    }

    @Test
    public void arrayListAdapterWithThreeElements() {
        MutableList<Integer> list = ListAdapter.adapt(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        list.sortThis(null);
    }

    @Test
    public void adaptedSingletonList() {
        ListAdapter.adapt(Collections.singletonList(1)).sortThis(null);
    }

    @Test
    public void adaptedCustomList() {
        MutableList<Integer> adapt = ListAdapter.adapt(new CustomList<>(1, 2));
        adapt.sortThis(null);
    }

    @Test
    public void emptyList() {
        Lists.fixedSize.of().sortThis(null);
    }

    @Test
    public void singletonList() {
        Lists.fixedSize.of(1).sortThis(null);
    }

    @Test
    public void doubletonList() {
        Lists.fixedSize.of(1, 2).sortThis(null);
    }

    private static final class CustomList<E> extends AbstractList<E> implements RandomAccess, Serializable {

        private static final long serialVersionUID = 1L;

        private final List<E> delegate;

        private CustomList(E obj1, E obj2) {
            this.delegate = Lists.fixedSize.of(obj1, obj2);
        }

        @Override
        public int size() {
            return this.delegate.size();
        }

        @Override
        public E get(int index) {
            return this.delegate.get(index);
        }

        @Override
        public E set(int index, E element) {
            return this.delegate.set(index, element);
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyFastList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyFastList, this.description("emptyFastList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListWithOneElement() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::fastListWithOneElement, this.description("fastListWithOneElement"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListWithThreeElements() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::fastListWithThreeElements, this.description("fastListWithThreeElements"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayIterate() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::arrayIterate, this.description("arrayIterate"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyArrayListAdapter() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyArrayListAdapter, this.description("emptyArrayListAdapter"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayListAdapterWithOneElement() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::arrayListAdapterWithOneElement, this.description("arrayListAdapterWithOneElement"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayListAdapterWithThreeElements() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::arrayListAdapterWithThreeElements, this.description("arrayListAdapterWithThreeElements"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptedSingletonList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::adaptedSingletonList, this.description("adaptedSingletonList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptedCustomList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::adaptedCustomList, this.description("adaptedCustomList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyList, this.description("emptyList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_singletonList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::singletonList, this.description("singletonList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubletonList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubletonList, this.description("doubletonList"));
        }

        private NullSafeSortingTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new NullSafeSortingTest();
        }

        @java.lang.Override
        public NullSafeSortingTest implementation() {
            return this.implementation;
        }
    }
}
