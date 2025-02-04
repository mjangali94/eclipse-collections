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
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableLongSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableLongSetFactory;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class LongSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(LongSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.LongSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableLongSetFactory setFactory) {
        Assert.assertEquals(LongHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.empty());
        Assert.assertEquals(LongHashSet.newSetWith(1L), setFactory.with(1L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), setFactory.with(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), setFactory.with(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L), setFactory.with(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L), setFactory.with(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), setFactory.withAll(LongHashSet.newSetWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongSet.class, setFactory.withAll(LongHashSet.newSetWith(1L, 2L, 3L)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(LongSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.LongSets.mutable);
    }

    private void assertMutableSetFactory(MutableLongSetFactory setFactory) {
        Assert.assertEquals(LongHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.empty());
        Assert.assertEquals(LongHashSet.newSetWith(1L), setFactory.with(1L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), setFactory.with(1L, 2L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), setFactory.with(1L, 2L, 3L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L), setFactory.with(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L), setFactory.with(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), setFactory.withAll(LongHashSet.newSetWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(MutableLongSet.class, setFactory.withAll(LongHashSet.newSetWith(1L, 2L, 3L)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(LongSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableLongSet set = LongSets.immutable.empty();
        Assert.assertEquals(set, LongSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith(1L), LongSets.immutable.with(1L));
        Assert.assertEquals(set = set.newWith(2L), LongSets.immutable.with(1L, 2L));
        Assert.assertEquals(set = set.newWith(3L), LongSets.immutable.with(1L, 2L, 3L));
        Assert.assertEquals(set = set.newWith(4L), LongSets.immutable.with(1L, 2L, 3L, 4L));
        Assert.assertEquals(set = set.newWith(5L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(set = set.newWith(6L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(set = set.newWith(7L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(set = set.newWith(8L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(set = set.newWith(9L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(set = set.newWith(10L), LongSets.immutable.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableLongSet set = LongSets.immutable.empty();
        Assert.assertEquals(set = set.newWith(1L), LongSets.immutable.with(new long[] { 1L }));
        Assert.assertEquals(set = set.newWith(2L), LongSets.immutable.with(new long[] { 1L, 2L }));
        Assert.assertEquals(set = set.newWith(3L), LongSets.immutable.with(new long[] { 1L, 2L, 3L }));
        Assert.assertEquals(set = set.newWith(4L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L }));
        Assert.assertEquals(set = set.newWith(5L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L }));
        Assert.assertEquals(set = set.newWith(6L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        Assert.assertEquals(set = set.newWith(7L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        Assert.assertEquals(set = set.newWith(8L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        Assert.assertEquals(set = set.newWith(9L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        Assert.assertEquals(set = set.newWith(10L), LongSets.immutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableLongSet set = LongSets.mutable.empty();
        Assert.assertEquals(set, LongSets.mutable.with(null));
        Assert.assertEquals(set, LongSets.mutable.with(new long[] {}));
        set.add(1L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L }));
        set.add(2L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L }));
        set.add(3L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L }));
        set.add(4L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L }));
        set.add(5L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L }));
        set.add(6L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        set.add(7L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        set.add(8L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        set.add(9L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        set.add(10L);
        Assert.assertEquals(set, LongSets.mutable.with(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableLongSet set = LongSets.immutable.empty();
        LongHashSet hashSet = LongHashSet.newSetWith(1L);
        Assert.assertEquals(set = set.newWith(1L), hashSet.toImmutable());
        hashSet.add(2L);
        Assert.assertEquals(set = set.newWith(2L), hashSet.toImmutable());
        hashSet.add(3L);
        Assert.assertEquals(set = set.newWith(3L), hashSet.toImmutable());
        hashSet.add(4L);
        Assert.assertEquals(set = set.newWith(4L), hashSet.toImmutable());
        hashSet.add(5L);
        Assert.assertEquals(set = set.newWith(5L), hashSet.toImmutable());
        hashSet.add(6L);
        Assert.assertEquals(set = set.newWith(6L), hashSet.toImmutable());
        hashSet.add(7L);
        Assert.assertEquals(set = set.newWith(7L), hashSet.toImmutable());
        hashSet.add(8L);
        Assert.assertEquals(set = set.newWith(8L), hashSet.toImmutable());
        hashSet.add(9L);
        Assert.assertEquals(set = set.newWith(9L), hashSet.toImmutable());
        hashSet.add(10L);
        Assert.assertEquals(set = set.newWith(10L), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new LongHashSet(), LongSets.immutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongHashSet.newSetWith(1L), LongSets.immutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), LongSets.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), LongSets.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
        Assert.assertEquals(new LongHashSet(), LongSets.mutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongHashSet.newSetWith(1L), LongSets.mutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), LongSets.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), LongSets.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<LongLongPair> longLongPairs1 = LongSets.cartesianProduct(LongSets.mutable.with(1L, 2L), LongSets.mutable.with(3L, 4L, 5L));
        Set<LongLongPair> expected1 = Sets.mutable.with(PrimitiveTuples.pair(1L, 3L), PrimitiveTuples.pair(1L, 4L), PrimitiveTuples.pair(1L, 5L), PrimitiveTuples.pair(2L, 3L), PrimitiveTuples.pair(2L, 4L), PrimitiveTuples.pair(2L, 5L));
        Assert.assertEquals(expected1, longLongPairs1.toSet());
        LazyIterable<LongLongPair> longLongPairs2 = LongSets.cartesianProduct(LongSets.mutable.with(3L, 4L, 5L), LongSets.mutable.with(1L, 2L));
        Set<LongLongPair> expected2 = Sets.mutable.with(PrimitiveTuples.pair(3L, 1L), PrimitiveTuples.pair(3L, 2L), PrimitiveTuples.pair(4L, 1L), PrimitiveTuples.pair(4L, 2L), PrimitiveTuples.pair(5L, 1L), PrimitiveTuples.pair(5L, 2L));
        Assert.assertEquals(expected2, longLongPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<LongLongPair> longLongPairs = LongSets.cartesianProduct(LongSets.mutable.with(1L, 2L), LongSets.mutable.with(1L, 2L));
        Set<LongLongPair> expected = Sets.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(1L, 2L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(2L, 1L));
        Assert.assertEquals(expected, longLongPairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongSetsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithArray_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithArray_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProductSameElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProductSameElements);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> payload) throws java.lang.Throwable {
            this.instance = new LongSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> newSetWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> newSetWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongSetsTest> cartesianProductSameElements;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = LongSetsTest::immutables;
            this.payloads.mutables = LongSetsTest::mutables;
            this.payloads.emptySet = LongSetsTest::emptySet;
            this.payloads.newSetWith = LongSetsTest::newSetWith;
            this.payloads.newSetWithArray_immutable = LongSetsTest::newSetWithArray_immutable;
            this.payloads.newSetWithArray_mutable = LongSetsTest::newSetWithArray_mutable;
            this.payloads.newSetWithSet = LongSetsTest::newSetWithSet;
            this.payloads.ofAllIterable = LongSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = LongSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = LongSetsTest::cartesianProduct;
            this.payloads.cartesianProductSameElements = LongSetsTest::cartesianProductSameElements;
        }
    }
}
