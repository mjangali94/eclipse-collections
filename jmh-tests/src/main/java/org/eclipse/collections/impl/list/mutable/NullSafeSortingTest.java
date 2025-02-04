/*
 * Copyright (c) 2021 Goldman Sachs.
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
    public static class _Benchmark {

        private _Payloads payloads;

        private NullSafeSortingTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyFastList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyFastList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListWithOneElement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fastListWithOneElement);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListWithThreeElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fastListWithThreeElements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayIterate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.arrayIterate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyArrayListAdapter() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyArrayListAdapter);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayListAdapterWithOneElement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.arrayListAdapterWithOneElement);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_arrayListAdapterWithThreeElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.arrayListAdapterWithThreeElements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptedSingletonList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptedSingletonList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptedCustomList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptedCustomList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_singletonList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.singletonList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubletonList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubletonList);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> payload) throws java.lang.Throwable {
            this.instance = new NullSafeSortingTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> emptyFastList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> fastListWithOneElement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> fastListWithThreeElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> arrayIterate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> emptyArrayListAdapter;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> arrayListAdapterWithOneElement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> arrayListAdapterWithThreeElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> adaptedSingletonList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> adaptedCustomList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> singletonList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NullSafeSortingTest> doubletonList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.emptyFastList = NullSafeSortingTest::emptyFastList;
            this.payloads.fastListWithOneElement = NullSafeSortingTest::fastListWithOneElement;
            this.payloads.fastListWithThreeElements = NullSafeSortingTest::fastListWithThreeElements;
            this.payloads.arrayIterate = NullSafeSortingTest::arrayIterate;
            this.payloads.emptyArrayListAdapter = NullSafeSortingTest::emptyArrayListAdapter;
            this.payloads.arrayListAdapterWithOneElement = NullSafeSortingTest::arrayListAdapterWithOneElement;
            this.payloads.arrayListAdapterWithThreeElements = NullSafeSortingTest::arrayListAdapterWithThreeElements;
            this.payloads.adaptedSingletonList = NullSafeSortingTest::adaptedSingletonList;
            this.payloads.adaptedCustomList = NullSafeSortingTest::adaptedCustomList;
            this.payloads.emptyList = NullSafeSortingTest::emptyList;
            this.payloads.singletonList = NullSafeSortingTest::singletonList;
            this.payloads.doubletonList = NullSafeSortingTest::doubletonList;
        }
    }
}
