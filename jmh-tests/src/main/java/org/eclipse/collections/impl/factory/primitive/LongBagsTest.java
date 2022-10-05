/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableLongBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableLongBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class LongBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(LongBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.LongBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableLongBagFactory bagFactory) {
        Assert.assertEquals(LongHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of());
        Assert.assertEquals(LongHashBag.newBagWith(1L), bagFactory.of(1L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), bagFactory.of(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L), bagFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(LongBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.LongBags.mutable);
    }

    private void assertMutableBagFactory(MutableLongBagFactory bagFactory) {
        Assert.assertEquals(LongHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of());
        Assert.assertEquals(LongHashBag.newBagWith(1L), bagFactory.of(1L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), bagFactory.of(1L, 2L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L), bagFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(MutableLongBag.class, bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(LongBags.immutable.of().isEmpty());
        Assert.assertTrue(LongBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableLongBag bag = LongBags.immutable.of();
        Assert.assertEquals(bag, LongBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1L), LongBags.immutable.of(1L));
        Assert.assertEquals(bag = bag.newWith(2L), LongBags.immutable.of(1L, 2L));
        Assert.assertEquals(bag = bag.newWith(3L), LongBags.immutable.of(1L, 2L, 3L));
        Assert.assertEquals(bag = bag.newWith(4L), LongBags.immutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(bag = bag.newWith(5L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(bag = bag.newWith(6L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(bag = bag.newWith(7L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(bag = bag.newWith(8L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(bag = bag.newWith(9L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(bag = bag.newWith(10L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @Test
    public void newBagWith_mutable() {
        MutableLongBag bag = LongBags.mutable.of();
        Assert.assertEquals(bag, LongBags.mutable.of(bag.toArray()));
        bag.add(1L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L));
        bag.add(2L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L));
        bag.add(3L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L));
        bag.add(4L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L));
        bag.add(5L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L));
        bag.add(6L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        bag.add(7L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        bag.add(8L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        bag.add(9L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        bag.add(10L);
        Assert.assertEquals(bag, LongBags.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableLongBag bag = LongBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1L), LongBags.immutable.of(new long[] { 1L }));
        Assert.assertEquals(bag = bag.newWith(2L), LongBags.immutable.of(new long[] { 1L, 2L }));
        Assert.assertEquals(bag = bag.newWith(3L), LongBags.immutable.of(new long[] { 1L, 2L, 3L }));
        Assert.assertEquals(bag = bag.newWith(4L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L }));
        Assert.assertEquals(bag = bag.newWith(5L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        Assert.assertEquals(bag = bag.newWith(6L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        Assert.assertEquals(bag = bag.newWith(7L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        Assert.assertEquals(bag = bag.newWith(8L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        Assert.assertEquals(bag = bag.newWith(9L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        Assert.assertEquals(bag = bag.newWith(10L), LongBags.immutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableLongBag bag = LongBags.mutable.of();
        Assert.assertEquals(bag, LongBags.mutable.of(null));
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] {}));
        bag.add(1L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L }));
        bag.add(2L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L }));
        bag.add(3L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L }));
        bag.add(4L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L }));
        bag.add(5L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L }));
        bag.add(6L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L }));
        bag.add(7L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L }));
        bag.add(8L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L }));
        bag.add(9L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L }));
        bag.add(10L);
        Assert.assertEquals(bag, LongBags.mutable.of(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableLongBag bag = LongBags.immutable.of();
        LongHashBag hashBag = LongHashBag.newBagWith(1L);
        Assert.assertEquals(bag = bag.newWith(1L), hashBag.toImmutable());
        hashBag.add(2L);
        Assert.assertEquals(bag = bag.newWith(2L), hashBag.toImmutable());
        hashBag.add(3L);
        Assert.assertEquals(bag = bag.newWith(3L), hashBag.toImmutable());
        hashBag.add(4L);
        Assert.assertEquals(bag = bag.newWith(4L), hashBag.toImmutable());
        hashBag.add(5L);
        Assert.assertEquals(bag = bag.newWith(5L), hashBag.toImmutable());
        hashBag.add(6L);
        Assert.assertEquals(bag = bag.newWith(6L), hashBag.toImmutable());
        hashBag.add(7L);
        Assert.assertEquals(bag = bag.newWith(7L), hashBag.toImmutable());
        hashBag.add(8L);
        Assert.assertEquals(bag = bag.newWith(8L), hashBag.toImmutable());
        hashBag.add(9L);
        Assert.assertEquals(bag = bag.newWith(9L), hashBag.toImmutable());
        hashBag.add(10L);
        Assert.assertEquals(bag = bag.newWith(10L), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new LongHashBag(), LongBags.immutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongHashBag.newBagWith(1L), LongBags.immutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), LongBags.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L), LongBags.immutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
        Assert.assertEquals(new LongHashBag(), LongBags.mutable.ofAll(Lists.mutable.<Long>empty()));
        Assert.assertEquals(LongHashBag.newBagWith(1L), LongBags.mutable.ofAll(Lists.mutable.<Long>with(1L)));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), LongBags.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L)));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L), LongBags.mutable.ofAll(Lists.mutable.<Long>with(1L, 2L, 2L, 3L)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongBagsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWith_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWith_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithArray_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithArray_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> payload) throws java.lang.Throwable {
            this.instance = new LongBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = LongBagsTest::immutables;
            this.payloads.mutables = LongBagsTest::mutables;
            this.payloads.emptyBag = LongBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = LongBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = LongBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = LongBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = LongBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = LongBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = LongBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = LongBagsTest::classIsNonInstantiable;
        }
    }
}
