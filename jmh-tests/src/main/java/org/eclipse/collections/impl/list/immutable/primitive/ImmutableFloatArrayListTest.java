/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableFloatArrayListTest extends AbstractImmutableFloatListTestCase {

    @Override
    protected ImmutableFloatList classUnderTest() {
        return ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), ImmutableFloatArrayList.newList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty() {
        ImmutableFloatArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single() {
        ImmutableFloatArrayList.newListWith(42.0f);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, FloatLists.immutable.ofAll(ImmutableFloatArrayList.newList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f))));
    }

    @Test
    public void dotProduct() {
        ImmutableFloatArrayList list1 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatArrayList list2 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableFloatArrayList list1 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatArrayList list2 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch() {
        ImmutableFloatArrayList list = ImmutableFloatArrayList.newListWith(2.0f, 3.0f, 5.0f, 6.0f, 9.0f);
        Assert.assertEquals(-1, list.binarySearch(1.0f));
        Assert.assertEquals(0, list.binarySearch(2.0f));
        Assert.assertEquals(1, list.binarySearch(3.0f));
        Assert.assertEquals(-3, list.binarySearch(4.0f));
        Assert.assertEquals(2, list.binarySearch(5.0f));
        Assert.assertEquals(3, list.binarySearch(6.0f));
        Assert.assertEquals(-5, list.binarySearch(7.0f));
        Assert.assertEquals(-5, list.binarySearch(8.0f));
        Assert.assertEquals(4, list.binarySearch(9.0f));
        Assert.assertEquals(-6, list.binarySearch(10.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.list.immutable.primitive.AbstractImmutableFloatListTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newCollection, this.description("newCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newCollection_throws_empty, this.description("newCollection_throws_empty"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_single() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newCollection_throws_single, this.description("newCollection_throws_single"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dotProduct, this.description("dotProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::dotProduct_throwsOnListsOfDifferentSizes, this.description("dotProduct_throwsOnListsOfDifferentSizes"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::binarySearch, this.description("binarySearch"));
        }

        private ImmutableFloatArrayListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableFloatArrayListTest();
        }

        @java.lang.Override
        public ImmutableFloatArrayListTest implementation() {
            return this.implementation;
        }
    }
}
