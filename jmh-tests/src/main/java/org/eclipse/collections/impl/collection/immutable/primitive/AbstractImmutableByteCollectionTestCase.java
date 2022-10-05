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

import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractByteIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableByteCollectionTestCase extends AbstractByteIterableTestCase {

    @Override
    protected abstract ImmutableByteCollection classUnderTest();

    @Override
    protected abstract ImmutableByteCollection newWith(byte... elements);

    @Override
    protected abstract MutableByteCollection newMutableCollectionWith(byte... elements);

    protected void assertSizeAndContains(ImmutableByteCollection collection, byte... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (byte i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableByteCollection immutableCollection = this.newWith();
        ImmutableByteCollection collection = immutableCollection.newWith((byte) 1);
        ImmutableByteCollection collection0 = immutableCollection.newWith((byte) 1).newWith((byte) 2);
        ImmutableByteCollection collection1 = immutableCollection.newWith((byte) 1).newWith((byte) 2).newWith((byte) 3);
        ImmutableByteCollection collection2 = immutableCollection.newWith((byte) 1).newWith((byte) 2).newWith((byte) 3).newWith((byte) 4);
        ImmutableByteCollection collection3 = immutableCollection.newWith((byte) 1).newWith((byte) 2).newWith((byte) 3).newWith((byte) 4).newWith((byte) 5);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (byte) 1);
        this.assertSizeAndContains(collection0, (byte) 1, (byte) 2);
        this.assertSizeAndContains(collection1, (byte) 1, (byte) 2, (byte) 3);
        this.assertSizeAndContains(collection2, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        this.assertSizeAndContains(collection3, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
    }

    @Test
    public void newWithAll() {
        ImmutableByteCollection immutableCollection = this.newWith();
        ImmutableByteCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith((byte) 1));
        ImmutableByteCollection collection0 = collection.newWithAll(this.newMutableCollectionWith((byte) 2));
        ImmutableByteCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith((byte) 3));
        ImmutableByteCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        ImmutableByteCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, (byte) 1);
        this.assertSizeAndContains(collection0, (byte) 1, (byte) 2);
        this.assertSizeAndContains(collection1, (byte) 1, (byte) 2, (byte) 3);
        this.assertSizeAndContains(collection2, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        this.assertSizeAndContains(collection3, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
    }

    @Test
    public void newWithout() {
        ImmutableByteCollection collection3 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        ImmutableByteCollection collection2 = collection3.newWithout((byte) 5);
        ImmutableByteCollection collection1 = collection2.newWithout((byte) 4);
        ImmutableByteCollection collection0 = collection1.newWithout((byte) 3);
        ImmutableByteCollection collection4 = collection0.newWithout((byte) 2);
        ImmutableByteCollection collection5 = collection4.newWithout((byte) 1);
        ImmutableByteCollection collection6 = collection5.newWithout((byte) 0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (byte) 1);
        this.assertSizeAndContains(collection0, (byte) 1, (byte) 2);
        this.assertSizeAndContains(collection1, (byte) 1, (byte) 2, (byte) 3);
        this.assertSizeAndContains(collection2, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
    }

    @Test
    public void newWithoutAll() {
        ImmutableByteCollection collection3 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        ImmutableByteCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith((byte) 5));
        ImmutableByteCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith((byte) 4));
        ImmutableByteCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith((byte) 3));
        ImmutableByteCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith((byte) 2));
        ImmutableByteCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith((byte) 1));
        ImmutableByteCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith((byte) 0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, (byte) 1);
        this.assertSizeAndContains(collection0, (byte) 1, (byte) 2);
        this.assertSizeAndContains(collection1, (byte) 1, (byte) 2, (byte) 3);
        this.assertSizeAndContains(collection2, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractByteIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableByteCollectionTestCase implementation();
    }
}
