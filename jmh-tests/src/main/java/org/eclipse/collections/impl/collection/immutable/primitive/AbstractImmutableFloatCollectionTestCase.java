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

import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableFloatCollectionTestCase extends AbstractFloatIterableTestCase {

    @Override
    protected abstract ImmutableFloatCollection classUnderTest();

    @Override
    protected abstract ImmutableFloatCollection newWith(float... elements);

    @Override
    protected abstract MutableFloatCollection newMutableCollectionWith(float... elements);

    protected void assertSizeAndContains(ImmutableFloatCollection collection, float... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (float i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableFloatCollection immutableCollection = this.newWith();
        ImmutableFloatCollection collection = immutableCollection.newWith(1.0f);
        ImmutableFloatCollection collection0 = immutableCollection.newWith(1.0f).newWith(2.0f);
        ImmutableFloatCollection collection1 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f);
        ImmutableFloatCollection collection2 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f).newWith(4.0f);
        ImmutableFloatCollection collection3 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f).newWith(4.0f).newWith(5.0f);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
        this.assertSizeAndContains(collection3, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
    }

    @Test
    public void newWithAll() {
        ImmutableFloatCollection immutableCollection = this.newWith();
        ImmutableFloatCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f));
        ImmutableFloatCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2.0f));
        ImmutableFloatCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3.0f));
        ImmutableFloatCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f));
        ImmutableFloatCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
        this.assertSizeAndContains(collection3, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
    }

    @Test
    public void newWithout() {
        ImmutableFloatCollection collection3 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        ImmutableFloatCollection collection2 = collection3.newWithout(5.0f);
        ImmutableFloatCollection collection1 = collection2.newWithout(4.0f);
        ImmutableFloatCollection collection0 = collection1.newWithout(3.0f);
        ImmutableFloatCollection collection4 = collection0.newWithout(2.0f);
        ImmutableFloatCollection collection5 = collection4.newWithout(1.0f);
        ImmutableFloatCollection collection6 = collection5.newWithout(0.0f);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
    }

    @Test
    public void newWithoutAll() {
        ImmutableFloatCollection collection3 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        ImmutableFloatCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5.0f));
        ImmutableFloatCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4.0f));
        ImmutableFloatCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3.0f));
        ImmutableFloatCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2.0f));
        ImmutableFloatCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1.0f));
        ImmutableFloatCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0.0f));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatCollectionTestCase implementation();
    }
}
