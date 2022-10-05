/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import java.util.Set;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableFloatSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableFloatSetFactory;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class FloatSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(FloatSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.FloatSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableFloatSetFactory setFactory) {
        Assert.assertEquals(FloatHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.empty());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), setFactory.with(1.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), setFactory.with(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), setFactory.with(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), setFactory.withAll(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatSet.class, setFactory.withAll(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(FloatSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.FloatSets.mutable);
    }

    private void assertMutableSetFactory(MutableFloatSetFactory setFactory) {
        Assert.assertEquals(FloatHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.empty());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), setFactory.with(1.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), setFactory.with(1.0f, 2.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), setFactory.with(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), setFactory.withAll(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(MutableFloatSet.class, setFactory.withAll(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(FloatSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableFloatSet set = FloatSets.immutable.empty();
        Assert.assertEquals(set, FloatSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith(1.0f), FloatSets.immutable.with(1.0f));
        Assert.assertEquals(set = set.newWith(2.0f), FloatSets.immutable.with(1.0f, 2.0f));
        Assert.assertEquals(set = set.newWith(3.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(set = set.newWith(4.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(set = set.newWith(5.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(set = set.newWith(6.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(set = set.newWith(7.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(set = set.newWith(8.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(set = set.newWith(9.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(set = set.newWith(10.0f), FloatSets.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableFloatSet set = FloatSets.immutable.empty();
        Assert.assertEquals(set = set.newWith(1.0f), FloatSets.immutable.with(new float[] { 1.0f }));
        Assert.assertEquals(set = set.newWith(2.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f }));
        Assert.assertEquals(set = set.newWith(3.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f }));
        Assert.assertEquals(set = set.newWith(4.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        Assert.assertEquals(set = set.newWith(5.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        Assert.assertEquals(set = set.newWith(6.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        Assert.assertEquals(set = set.newWith(7.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        Assert.assertEquals(set = set.newWith(8.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        Assert.assertEquals(set = set.newWith(9.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        Assert.assertEquals(set = set.newWith(10.0f), FloatSets.immutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableFloatSet set = FloatSets.mutable.empty();
        Assert.assertEquals(set, FloatSets.mutable.with(null));
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] {}));
        set.add(1.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f }));
        set.add(2.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f }));
        set.add(3.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f }));
        set.add(4.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        set.add(5.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        set.add(6.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        set.add(7.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        set.add(8.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        set.add(9.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        set.add(10.0f);
        Assert.assertEquals(set, FloatSets.mutable.with(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableFloatSet set = FloatSets.immutable.empty();
        FloatHashSet hashSet = FloatHashSet.newSetWith(1.0f);
        Assert.assertEquals(set = set.newWith(1.0f), hashSet.toImmutable());
        hashSet.add(2.0f);
        Assert.assertEquals(set = set.newWith(2.0f), hashSet.toImmutable());
        hashSet.add(3.0f);
        Assert.assertEquals(set = set.newWith(3.0f), hashSet.toImmutable());
        hashSet.add(4.0f);
        Assert.assertEquals(set = set.newWith(4.0f), hashSet.toImmutable());
        hashSet.add(5.0f);
        Assert.assertEquals(set = set.newWith(5.0f), hashSet.toImmutable());
        hashSet.add(6.0f);
        Assert.assertEquals(set = set.newWith(6.0f), hashSet.toImmutable());
        hashSet.add(7.0f);
        Assert.assertEquals(set = set.newWith(7.0f), hashSet.toImmutable());
        hashSet.add(8.0f);
        Assert.assertEquals(set = set.newWith(8.0f), hashSet.toImmutable());
        hashSet.add(9.0f);
        Assert.assertEquals(set = set.newWith(9.0f), hashSet.toImmutable());
        hashSet.add(10.0f);
        Assert.assertEquals(set = set.newWith(10.0f), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new FloatHashSet(), FloatSets.immutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), FloatSets.immutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), FloatSets.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), FloatSets.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatHashSet(), FloatSets.mutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), FloatSets.mutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), FloatSets.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), FloatSets.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<FloatFloatPair> floatFloatPairs1 = FloatSets.cartesianProduct(FloatSets.mutable.with(1.0f, 2.0f), FloatSets.mutable.with(3.0f, 4.0f, 5.0f));
        Set<FloatFloatPair> expected1 = Sets.mutable.with(PrimitiveTuples.pair(1.0f, 3.0f), PrimitiveTuples.pair(1.0f, 4.0f), PrimitiveTuples.pair(1.0f, 5.0f), PrimitiveTuples.pair(2.0f, 3.0f), PrimitiveTuples.pair(2.0f, 4.0f), PrimitiveTuples.pair(2.0f, 5.0f));
        Assert.assertEquals(expected1, floatFloatPairs1.toSet());
        LazyIterable<FloatFloatPair> floatFloatPairs2 = FloatSets.cartesianProduct(FloatSets.mutable.with(3.0f, 4.0f, 5.0f), FloatSets.mutable.with(1.0f, 2.0f));
        Set<FloatFloatPair> expected2 = Sets.mutable.with(PrimitiveTuples.pair(3.0f, 1.0f), PrimitiveTuples.pair(3.0f, 2.0f), PrimitiveTuples.pair(4.0f, 1.0f), PrimitiveTuples.pair(4.0f, 2.0f), PrimitiveTuples.pair(5.0f, 1.0f), PrimitiveTuples.pair(5.0f, 2.0f));
        Assert.assertEquals(expected2, floatFloatPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<FloatFloatPair> floatFloatPairs = FloatSets.cartesianProduct(FloatSets.mutable.with(1.0f, 2.0f), FloatSets.mutable.with(1.0f, 2.0f));
        Set<FloatFloatPair> expected = Sets.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(1.0f, 2.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(2.0f, 1.0f));
        Assert.assertEquals(expected, floatFloatPairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptySet, this.description("emptySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newSetWith, this.description("newSetWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newSetWithArray_immutable, this.description("newSetWithArray_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newSetWithArray_mutable, this.description("newSetWithArray_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newSetWithSet, this.description("newSetWithSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAllIterable, this.description("ofAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProduct, this.description("cartesianProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProductSameElements() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProductSameElements, this.description("cartesianProductSameElements"));
        }

        private FloatSetsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatSetsTest();
        }

        @java.lang.Override
        public FloatSetsTest implementation() {
            return this.implementation;
        }
    }
}
