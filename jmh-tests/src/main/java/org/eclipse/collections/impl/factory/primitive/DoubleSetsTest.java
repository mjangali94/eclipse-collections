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
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableDoubleSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableDoubleSetFactory;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class DoubleSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(DoubleSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.DoubleSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableDoubleSetFactory setFactory) {
        Assert.assertEquals(DoubleHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.empty());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), setFactory.with(1.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0), setFactory.with(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), setFactory.with(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0), setFactory.with(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), setFactory.withAll(DoubleHashSet.newSetWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleSet.class, setFactory.withAll(DoubleHashSet.newSetWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(DoubleSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.DoubleSets.mutable);
    }

    private void assertMutableSetFactory(MutableDoubleSetFactory setFactory) {
        Assert.assertEquals(DoubleHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.empty());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), setFactory.with(1.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0), setFactory.with(1.0, 2.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), setFactory.with(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0), setFactory.with(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), setFactory.withAll(DoubleHashSet.newSetWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(MutableDoubleSet.class, setFactory.withAll(DoubleHashSet.newSetWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(DoubleSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableDoubleSet set = DoubleSets.immutable.empty();
        Assert.assertEquals(set, DoubleSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith(1.0), DoubleSets.immutable.with(1.0));
        Assert.assertEquals(set = set.newWith(2.0), DoubleSets.immutable.with(1.0, 2.0));
        Assert.assertEquals(set = set.newWith(3.0), DoubleSets.immutable.with(1.0, 2.0, 3.0));
        Assert.assertEquals(set = set.newWith(4.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(set = set.newWith(5.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(set = set.newWith(6.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(set = set.newWith(7.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(set = set.newWith(8.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(set = set.newWith(9.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(set = set.newWith(10.0), DoubleSets.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableDoubleSet set = DoubleSets.immutable.empty();
        Assert.assertEquals(set = set.newWith(1.0), DoubleSets.immutable.with(new double[] { 1.0 }));
        Assert.assertEquals(set = set.newWith(2.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0 }));
        Assert.assertEquals(set = set.newWith(3.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0 }));
        Assert.assertEquals(set = set.newWith(4.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        Assert.assertEquals(set = set.newWith(5.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        Assert.assertEquals(set = set.newWith(6.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        Assert.assertEquals(set = set.newWith(7.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        Assert.assertEquals(set = set.newWith(8.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        Assert.assertEquals(set = set.newWith(9.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        Assert.assertEquals(set = set.newWith(10.0), DoubleSets.immutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableDoubleSet set = DoubleSets.mutable.empty();
        Assert.assertEquals(set, DoubleSets.mutable.with(null));
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] {}));
        set.add(1.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0 }));
        set.add(2.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0 }));
        set.add(3.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0 }));
        set.add(4.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        set.add(5.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        set.add(6.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        set.add(7.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        set.add(8.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        set.add(9.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        set.add(10.0);
        Assert.assertEquals(set, DoubleSets.mutable.with(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableDoubleSet set = DoubleSets.immutable.empty();
        DoubleHashSet hashSet = DoubleHashSet.newSetWith(1.0);
        Assert.assertEquals(set = set.newWith(1.0), hashSet.toImmutable());
        hashSet.add(2.0);
        Assert.assertEquals(set = set.newWith(2.0), hashSet.toImmutable());
        hashSet.add(3.0);
        Assert.assertEquals(set = set.newWith(3.0), hashSet.toImmutable());
        hashSet.add(4.0);
        Assert.assertEquals(set = set.newWith(4.0), hashSet.toImmutable());
        hashSet.add(5.0);
        Assert.assertEquals(set = set.newWith(5.0), hashSet.toImmutable());
        hashSet.add(6.0);
        Assert.assertEquals(set = set.newWith(6.0), hashSet.toImmutable());
        hashSet.add(7.0);
        Assert.assertEquals(set = set.newWith(7.0), hashSet.toImmutable());
        hashSet.add(8.0);
        Assert.assertEquals(set = set.newWith(8.0), hashSet.toImmutable());
        hashSet.add(9.0);
        Assert.assertEquals(set = set.newWith(9.0), hashSet.toImmutable());
        hashSet.add(10.0);
        Assert.assertEquals(set = set.newWith(10.0), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new DoubleHashSet(), DoubleSets.immutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), DoubleSets.immutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0), DoubleSets.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), DoubleSets.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleHashSet(), DoubleSets.mutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), DoubleSets.mutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0), DoubleSets.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), DoubleSets.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<DoubleDoublePair> doubleDoublePairs1 = DoubleSets.cartesianProduct(DoubleSets.mutable.with(1.0, 2.0), DoubleSets.mutable.with(3.0, 4.0, 5.0));
        Set<DoubleDoublePair> expected1 = Sets.mutable.with(PrimitiveTuples.pair(1.0, 3.0), PrimitiveTuples.pair(1.0, 4.0), PrimitiveTuples.pair(1.0, 5.0), PrimitiveTuples.pair(2.0, 3.0), PrimitiveTuples.pair(2.0, 4.0), PrimitiveTuples.pair(2.0, 5.0));
        Assert.assertEquals(expected1, doubleDoublePairs1.toSet());
        LazyIterable<DoubleDoublePair> doubleDoublePairs2 = DoubleSets.cartesianProduct(DoubleSets.mutable.with(3.0, 4.0, 5.0), DoubleSets.mutable.with(1.0, 2.0));
        Set<DoubleDoublePair> expected2 = Sets.mutable.with(PrimitiveTuples.pair(3.0, 1.0), PrimitiveTuples.pair(3.0, 2.0), PrimitiveTuples.pair(4.0, 1.0), PrimitiveTuples.pair(4.0, 2.0), PrimitiveTuples.pair(5.0, 1.0), PrimitiveTuples.pair(5.0, 2.0));
        Assert.assertEquals(expected2, doubleDoublePairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<DoubleDoublePair> doubleDoublePairs = DoubleSets.cartesianProduct(DoubleSets.mutable.with(1.0, 2.0), DoubleSets.mutable.with(1.0, 2.0));
        Set<DoubleDoublePair> expected = Sets.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(1.0, 2.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(2.0, 1.0));
        Assert.assertEquals(expected, doubleDoublePairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleSetsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithArray_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithArray_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProductSameElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProductSameElements);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> newSetWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> newSetWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleSetsTest> cartesianProductSameElements;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = DoubleSetsTest::immutables;
            this.payloads.mutables = DoubleSetsTest::mutables;
            this.payloads.emptySet = DoubleSetsTest::emptySet;
            this.payloads.newSetWith = DoubleSetsTest::newSetWith;
            this.payloads.newSetWithArray_immutable = DoubleSetsTest::newSetWithArray_immutable;
            this.payloads.newSetWithArray_mutable = DoubleSetsTest::newSetWithArray_mutable;
            this.payloads.newSetWithSet = DoubleSetsTest::newSetWithSet;
            this.payloads.ofAllIterable = DoubleSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = DoubleSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = DoubleSetsTest::cartesianProduct;
            this.payloads.cartesianProductSameElements = DoubleSetsTest::cartesianProductSameElements;
        }
    }
}
