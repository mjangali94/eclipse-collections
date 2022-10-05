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

import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractDoubleIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableDoubleCollectionTestCase extends AbstractDoubleIterableTestCase {

    @Override
    protected abstract ImmutableDoubleCollection classUnderTest();

    @Override
    protected abstract ImmutableDoubleCollection newWith(double... elements);

    @Override
    protected abstract MutableDoubleCollection newMutableCollectionWith(double... elements);

    protected void assertSizeAndContains(ImmutableDoubleCollection collection, double... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (double i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableDoubleCollection immutableCollection = this.newWith();
        ImmutableDoubleCollection collection = immutableCollection.newWith(1.0);
        ImmutableDoubleCollection collection0 = immutableCollection.newWith(1.0).newWith(2.0);
        ImmutableDoubleCollection collection1 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0);
        ImmutableDoubleCollection collection2 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0).newWith(4.0);
        ImmutableDoubleCollection collection3 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0).newWith(4.0).newWith(5.0);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
        this.assertSizeAndContains(collection3, 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    @Test
    public void newWithAll() {
        ImmutableDoubleCollection immutableCollection = this.newWith();
        ImmutableDoubleCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0));
        ImmutableDoubleCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2.0));
        ImmutableDoubleCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3.0));
        ImmutableDoubleCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0));
        ImmutableDoubleCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
        this.assertSizeAndContains(collection3, 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    @Test
    public void newWithout() {
        ImmutableDoubleCollection collection3 = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        ImmutableDoubleCollection collection2 = collection3.newWithout(5.0);
        ImmutableDoubleCollection collection1 = collection2.newWithout(4.0);
        ImmutableDoubleCollection collection0 = collection1.newWithout(3.0);
        ImmutableDoubleCollection collection4 = collection0.newWithout(2.0);
        ImmutableDoubleCollection collection5 = collection4.newWithout(1.0);
        ImmutableDoubleCollection collection6 = collection5.newWithout(0.0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
    }

    @Test
    public void newWithoutAll() {
        ImmutableDoubleCollection collection3 = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        ImmutableDoubleCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5.0));
        ImmutableDoubleCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4.0));
        ImmutableDoubleCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3.0));
        ImmutableDoubleCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2.0));
        ImmutableDoubleCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1.0));
        ImmutableDoubleCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0.0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractDoubleIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleCollectionTestCase implementation();
    }
}
