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

import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractIntIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableIntCollectionTestCase extends AbstractIntIterableTestCase {

    @Override
    protected abstract ImmutableIntCollection classUnderTest();

    @Override
    protected abstract ImmutableIntCollection newWith(int... elements);

    @Override
    protected abstract MutableIntCollection newMutableCollectionWith(int... elements);

    protected void assertSizeAndContains(ImmutableIntCollection collection, int... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (int i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableIntCollection immutableCollection = this.newWith();
        ImmutableIntCollection collection = immutableCollection.newWith(1);
        ImmutableIntCollection collection0 = immutableCollection.newWith(1).newWith(2);
        ImmutableIntCollection collection1 = immutableCollection.newWith(1).newWith(2).newWith(3);
        ImmutableIntCollection collection2 = immutableCollection.newWith(1).newWith(2).newWith(3).newWith(4);
        ImmutableIntCollection collection3 = immutableCollection.newWith(1).newWith(2).newWith(3).newWith(4).newWith(5);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1);
        this.assertSizeAndContains(collection0, 1, 2);
        this.assertSizeAndContains(collection1, 1, 2, 3);
        this.assertSizeAndContains(collection2, 1, 2, 3, 4);
        this.assertSizeAndContains(collection3, 1, 2, 3, 4, 5);
    }

    @Test
    public void newWithAll() {
        ImmutableIntCollection immutableCollection = this.newWith();
        ImmutableIntCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1));
        ImmutableIntCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2));
        ImmutableIntCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3));
        ImmutableIntCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1, 2, 3, 4));
        ImmutableIntCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1, 2, 3, 4, 5));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1);
        this.assertSizeAndContains(collection0, 1, 2);
        this.assertSizeAndContains(collection1, 1, 2, 3);
        this.assertSizeAndContains(collection2, 1, 2, 3, 4);
        this.assertSizeAndContains(collection3, 1, 2, 3, 4, 5);
    }

    @Test
    public void newWithout() {
        ImmutableIntCollection collection3 = this.newWith(1, 2, 3, 4, 5);
        ImmutableIntCollection collection2 = collection3.newWithout(5);
        ImmutableIntCollection collection1 = collection2.newWithout(4);
        ImmutableIntCollection collection0 = collection1.newWithout(3);
        ImmutableIntCollection collection4 = collection0.newWithout(2);
        ImmutableIntCollection collection5 = collection4.newWithout(1);
        ImmutableIntCollection collection6 = collection5.newWithout(0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1);
        this.assertSizeAndContains(collection0, 1, 2);
        this.assertSizeAndContains(collection1, 1, 2, 3);
        this.assertSizeAndContains(collection2, 1, 2, 3, 4);
    }

    @Test
    public void newWithoutAll() {
        ImmutableIntCollection collection3 = this.newWith(1, 2, 3, 4, 5);
        ImmutableIntCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5));
        ImmutableIntCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4));
        ImmutableIntCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3));
        ImmutableIntCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2));
        ImmutableIntCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1));
        ImmutableIntCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1);
        this.assertSizeAndContains(collection0, 1, 2);
        this.assertSizeAndContains(collection1, 1, 2, 3);
        this.assertSizeAndContains(collection2, 1, 2, 3, 4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractIntIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableIntCollectionTestCase implementation();
    }
}
