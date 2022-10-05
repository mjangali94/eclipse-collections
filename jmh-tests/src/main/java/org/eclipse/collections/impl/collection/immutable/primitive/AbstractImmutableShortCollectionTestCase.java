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

import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractShortIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableShortCollectionTestCase extends AbstractShortIterableTestCase {

    @Override
    protected abstract ImmutableShortCollection classUnderTest();

    @Override
    protected abstract ImmutableShortCollection newWith(short... elements);

    @Override
    protected abstract MutableShortCollection newMutableCollectionWith(short... elements);

    protected void assertSizeAndContains(ImmutableShortCollection collection, short... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (short i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableShortCollection immutableCollection = this.newWith();
        ImmutableShortCollection collection = immutableCollection.newWith((short) 1);
        ImmutableShortCollection collection0 = immutableCollection.newWith((short) 1).newWith((short) 2);
        ImmutableShortCollection collection1 = immutableCollection.newWith((short) 1).newWith((short) 2).newWith((short) 3);
        ImmutableShortCollection collection2 = immutableCollection.newWith((short) 1).newWith((short) 2).newWith((short) 3).newWith((short) 4);
        ImmutableShortCollection collection3 = immutableCollection.newWith((short) 1).newWith((short) 2).newWith((short) 3).newWith((short) 4).newWith((short) 5);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (short) 1);
        this.assertSizeAndContains(collection0, (short) 1, (short) 2);
        this.assertSizeAndContains(collection1, (short) 1, (short) 2, (short) 3);
        this.assertSizeAndContains(collection2, (short) 1, (short) 2, (short) 3, (short) 4);
        this.assertSizeAndContains(collection3, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
    }

    @Test
    public void newWithAll() {
        ImmutableShortCollection immutableCollection = this.newWith();
        ImmutableShortCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith((short) 1));
        ImmutableShortCollection collection0 = collection.newWithAll(this.newMutableCollectionWith((short) 2));
        ImmutableShortCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith((short) 3));
        ImmutableShortCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4));
        ImmutableShortCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (short) 1);
        this.assertSizeAndContains(collection0, (short) 1, (short) 2);
        this.assertSizeAndContains(collection1, (short) 1, (short) 2, (short) 3);
        this.assertSizeAndContains(collection2, (short) 1, (short) 2, (short) 3, (short) 4);
        this.assertSizeAndContains(collection3, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
    }

    @Test
    public void newWithout() {
        ImmutableShortCollection collection3 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        ImmutableShortCollection collection2 = collection3.newWithout((short) 5);
        ImmutableShortCollection collection1 = collection2.newWithout((short) 4);
        ImmutableShortCollection collection0 = collection1.newWithout((short) 3);
        ImmutableShortCollection collection4 = collection0.newWithout((short) 2);
        ImmutableShortCollection collection5 = collection4.newWithout((short) 1);
        ImmutableShortCollection collection6 = collection5.newWithout((short) 0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (short) 1);
        this.assertSizeAndContains(collection0, (short) 1, (short) 2);
        this.assertSizeAndContains(collection1, (short) 1, (short) 2, (short) 3);
        this.assertSizeAndContains(collection2, (short) 1, (short) 2, (short) 3, (short) 4);
    }

    @Test
    public void newWithoutAll() {
        ImmutableShortCollection collection3 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        ImmutableShortCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith((short) 5));
        ImmutableShortCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith((short) 4));
        ImmutableShortCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith((short) 3));
        ImmutableShortCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith((short) 2));
        ImmutableShortCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith((short) 1));
        ImmutableShortCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith((short) 0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (short) 1);
        this.assertSizeAndContains(collection0, (short) 1, (short) 2);
        this.assertSizeAndContains(collection1, (short) 1, (short) 2, (short) 3);
        this.assertSizeAndContains(collection2, (short) 1, (short) 2, (short) 3, (short) 4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractShortIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableShortCollectionTestCase implementation();
    }
}
