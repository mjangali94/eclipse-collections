/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.immutable.primitive;

import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractLongIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableLongCollectionTestCase extends AbstractLongIterableTestCase {

    @Override
    protected abstract ImmutableLongCollection classUnderTest();

    @Override
    protected abstract ImmutableLongCollection newWith(long... elements);

    @Override
    protected abstract MutableLongCollection newMutableCollectionWith(long... elements);

    protected void assertSizeAndContains(ImmutableLongCollection collection, long... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (long i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableLongCollection immutableCollection = this.newWith();
        ImmutableLongCollection collection = immutableCollection.newWith(1L);
        ImmutableLongCollection collection0 = immutableCollection.newWith(1L).newWith(2L);
        ImmutableLongCollection collection1 = immutableCollection.newWith(1L).newWith(2L).newWith(3L);
        ImmutableLongCollection collection2 = immutableCollection.newWith(1L).newWith(2L).newWith(3L).newWith(4L);
        ImmutableLongCollection collection3 = immutableCollection.newWith(1L).newWith(2L).newWith(3L).newWith(4L).newWith(5L);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
        this.assertSizeAndContains(collection3, 1L, 2L, 3L, 4L, 5L);
    }

    @Test
    public void newWithAll() {
        ImmutableLongCollection immutableCollection = this.newWith();
        ImmutableLongCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1L));
        ImmutableLongCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2L));
        ImmutableLongCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3L));
        ImmutableLongCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L));
        ImmutableLongCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
        this.assertSizeAndContains(collection3, 1L, 2L, 3L, 4L, 5L);
    }

    @Test
    public void newWithout() {
        ImmutableLongCollection collection3 = this.newWith(1L, 2L, 3L, 4L, 5L);
        ImmutableLongCollection collection2 = collection3.newWithout(5L);
        ImmutableLongCollection collection1 = collection2.newWithout(4L);
        ImmutableLongCollection collection0 = collection1.newWithout(3L);
        ImmutableLongCollection collection4 = collection0.newWithout(2L);
        ImmutableLongCollection collection5 = collection4.newWithout(1L);
        ImmutableLongCollection collection6 = collection5.newWithout(0L);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
    }

    @Test
    public void newWithoutAll() {
        ImmutableLongCollection collection3 = this.newWith(1L, 2L, 3L, 4L, 5L);
        ImmutableLongCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5L));
        ImmutableLongCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4L));
        ImmutableLongCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3L));
        ImmutableLongCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2L));
        ImmutableLongCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1L));
        ImmutableLongCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0L));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractLongIterableTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWith, this.description("testNewWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithAll, this.description("newWithAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithoutAll, this.description("newWithoutAll"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableLongCollectionTestCase implementation();
    }
}
