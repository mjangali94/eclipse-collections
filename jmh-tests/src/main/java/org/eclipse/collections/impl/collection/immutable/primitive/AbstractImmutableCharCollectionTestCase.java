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

import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractCharIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableCharCollectionTestCase extends AbstractCharIterableTestCase {

    @Override
    protected abstract ImmutableCharCollection classUnderTest();

    @Override
    protected abstract ImmutableCharCollection newWith(char... elements);

    @Override
    protected abstract MutableCharCollection newMutableCollectionWith(char... elements);

    protected void assertSizeAndContains(ImmutableCharCollection collection, char... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (char i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableCharCollection immutableCollection = this.newWith();
        ImmutableCharCollection collection = immutableCollection.newWith((char) 1);
        ImmutableCharCollection collection0 = immutableCollection.newWith((char) 1).newWith((char) 2);
        ImmutableCharCollection collection1 = immutableCollection.newWith((char) 1).newWith((char) 2).newWith((char) 3);
        ImmutableCharCollection collection2 = immutableCollection.newWith((char) 1).newWith((char) 2).newWith((char) 3).newWith((char) 4);
        ImmutableCharCollection collection3 = immutableCollection.newWith((char) 1).newWith((char) 2).newWith((char) 3).newWith((char) 4).newWith((char) 5);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (char) 1);
        this.assertSizeAndContains(collection0, (char) 1, (char) 2);
        this.assertSizeAndContains(collection1, (char) 1, (char) 2, (char) 3);
        this.assertSizeAndContains(collection2, (char) 1, (char) 2, (char) 3, (char) 4);
        this.assertSizeAndContains(collection3, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
    }

    @Test
    public void newWithAll() {
        ImmutableCharCollection immutableCollection = this.newWith();
        ImmutableCharCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith((char) 1));
        ImmutableCharCollection collection0 = collection.newWithAll(this.newMutableCollectionWith((char) 2));
        ImmutableCharCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith((char) 3));
        ImmutableCharCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4));
        ImmutableCharCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (char) 1);
        this.assertSizeAndContains(collection0, (char) 1, (char) 2);
        this.assertSizeAndContains(collection1, (char) 1, (char) 2, (char) 3);
        this.assertSizeAndContains(collection2, (char) 1, (char) 2, (char) 3, (char) 4);
        this.assertSizeAndContains(collection3, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
    }

    @Test
    public void newWithout() {
        ImmutableCharCollection collection3 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        ImmutableCharCollection collection2 = collection3.newWithout((char) 5);
        ImmutableCharCollection collection1 = collection2.newWithout((char) 4);
        ImmutableCharCollection collection0 = collection1.newWithout((char) 3);
        ImmutableCharCollection collection4 = collection0.newWithout((char) 2);
        ImmutableCharCollection collection5 = collection4.newWithout((char) 1);
        ImmutableCharCollection collection6 = collection5.newWithout((char) 0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (char) 1);
        this.assertSizeAndContains(collection0, (char) 1, (char) 2);
        this.assertSizeAndContains(collection1, (char) 1, (char) 2, (char) 3);
        this.assertSizeAndContains(collection2, (char) 1, (char) 2, (char) 3, (char) 4);
    }

    @Test
    public void newWithoutAll() {
        ImmutableCharCollection collection3 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        ImmutableCharCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith((char) 5));
        ImmutableCharCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith((char) 4));
        ImmutableCharCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith((char) 3));
        ImmutableCharCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith((char) 2));
        ImmutableCharCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith((char) 1));
        ImmutableCharCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith((char) 0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (char) 1);
        this.assertSizeAndContains(collection0, (char) 1, (char) 2);
        this.assertSizeAndContains(collection1, (char) 1, (char) 2, (char) 3);
        this.assertSizeAndContains(collection2, (char) 1, (char) 2, (char) 3, (char) 4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractCharIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableCharCollectionTestCase implementation();
    }
}
