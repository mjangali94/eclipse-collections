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

import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableIntBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableIntBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link IntBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class IntBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(IntBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.IntBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableIntBagFactory bagFactory) {
        Assert.assertEquals(IntHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of());
        Assert.assertEquals(IntHashBag.newBagWith(1), bagFactory.of(1));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), bagFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), bagFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), bagFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5), bagFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6), bagFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7), bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), bagFactory.ofAll(IntHashBag.newBagWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableIntBag.class, bagFactory.ofAll(IntHashBag.newBagWith(1, 2, 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(IntBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.IntBags.mutable);
    }

    private void assertMutableBagFactory(MutableIntBagFactory bagFactory) {
        Assert.assertEquals(IntHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of());
        Assert.assertEquals(IntHashBag.newBagWith(1), bagFactory.of(1));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), bagFactory.of(1, 2));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), bagFactory.of(1, 2, 3));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), bagFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5), bagFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6), bagFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7), bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), bagFactory.ofAll(IntHashBag.newBagWith(1, 2, 3)));
        Verify.assertInstanceOf(MutableIntBag.class, bagFactory.ofAll(IntHashBag.newBagWith(1, 2, 3)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(IntBags.immutable.of().isEmpty());
        Assert.assertTrue(IntBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableIntBag bag = IntBags.immutable.of();
        Assert.assertEquals(bag, IntBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1), IntBags.immutable.of(1));
        Assert.assertEquals(bag = bag.newWith(2), IntBags.immutable.of(1, 2));
        Assert.assertEquals(bag = bag.newWith(3), IntBags.immutable.of(1, 2, 3));
        Assert.assertEquals(bag = bag.newWith(4), IntBags.immutable.of(1, 2, 3, 4));
        Assert.assertEquals(bag = bag.newWith(5), IntBags.immutable.of(1, 2, 3, 4, 5));
        Assert.assertEquals(bag = bag.newWith(6), IntBags.immutable.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(bag = bag.newWith(7), IntBags.immutable.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(bag = bag.newWith(8), IntBags.immutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(bag = bag.newWith(9), IntBags.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(bag = bag.newWith(10), IntBags.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void newBagWith_mutable() {
        MutableIntBag bag = IntBags.mutable.of();
        Assert.assertEquals(bag, IntBags.mutable.of(bag.toArray()));
        bag.add(1);
        Assert.assertEquals(bag, IntBags.mutable.of(1));
        bag.add(2);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2));
        bag.add(3);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3));
        bag.add(4);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4));
        bag.add(5);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5));
        bag.add(6);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5, 6));
        bag.add(7);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5, 6, 7));
        bag.add(8);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        bag.add(9);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        bag.add(10);
        Assert.assertEquals(bag, IntBags.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableIntBag bag = IntBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1), IntBags.immutable.of(new int[] { 1 }));
        Assert.assertEquals(bag = bag.newWith(2), IntBags.immutable.of(new int[] { 1, 2 }));
        Assert.assertEquals(bag = bag.newWith(3), IntBags.immutable.of(new int[] { 1, 2, 3 }));
        Assert.assertEquals(bag = bag.newWith(4), IntBags.immutable.of(new int[] { 1, 2, 3, 4 }));
        Assert.assertEquals(bag = bag.newWith(5), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(bag = bag.newWith(6), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        Assert.assertEquals(bag = bag.newWith(7), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        Assert.assertEquals(bag = bag.newWith(8), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        Assert.assertEquals(bag = bag.newWith(9), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        Assert.assertEquals(bag = bag.newWith(10), IntBags.immutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableIntBag bag = IntBags.mutable.of();
        Assert.assertEquals(bag, IntBags.mutable.of(null));
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] {}));
        bag.add(1);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1 }));
        bag.add(2);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2 }));
        bag.add(3);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3 }));
        bag.add(4);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4 }));
        bag.add(5);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5 }));
        bag.add(6);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5, 6 }));
        bag.add(7);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        bag.add(8);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        bag.add(9);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        bag.add(10);
        Assert.assertEquals(bag, IntBags.mutable.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableIntBag bag = IntBags.immutable.of();
        IntHashBag hashBag = IntHashBag.newBagWith(1);
        Assert.assertEquals(bag = bag.newWith(1), hashBag.toImmutable());
        hashBag.add(2);
        Assert.assertEquals(bag = bag.newWith(2), hashBag.toImmutable());
        hashBag.add(3);
        Assert.assertEquals(bag = bag.newWith(3), hashBag.toImmutable());
        hashBag.add(4);
        Assert.assertEquals(bag = bag.newWith(4), hashBag.toImmutable());
        hashBag.add(5);
        Assert.assertEquals(bag = bag.newWith(5), hashBag.toImmutable());
        hashBag.add(6);
        Assert.assertEquals(bag = bag.newWith(6), hashBag.toImmutable());
        hashBag.add(7);
        Assert.assertEquals(bag = bag.newWith(7), hashBag.toImmutable());
        hashBag.add(8);
        Assert.assertEquals(bag = bag.newWith(8), hashBag.toImmutable());
        hashBag.add(9);
        Assert.assertEquals(bag = bag.newWith(9), hashBag.toImmutable());
        hashBag.add(10);
        Assert.assertEquals(bag = bag.newWith(10), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new IntHashBag(), IntBags.immutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntHashBag.newBagWith(1), IntBags.immutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), IntBags.immutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3), IntBags.immutable.ofAll(Lists.mutable.<Integer>with(1, 2, 2, 3)));
        Assert.assertEquals(new IntHashBag(), IntBags.mutable.ofAll(Lists.mutable.<Integer>empty()));
        Assert.assertEquals(IntHashBag.newBagWith(1), IntBags.mutable.ofAll(Lists.mutable.<Integer>with(1)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), IntBags.mutable.ofAll(Lists.mutable.<Integer>with(1, 2)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3), IntBags.mutable.ofAll(Lists.mutable.<Integer>with(1, 2, 2, 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntBagsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> payload) throws java.lang.Throwable {
            this.instance = new IntBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = IntBagsTest::immutables;
            this.payloads.mutables = IntBagsTest::mutables;
            this.payloads.emptyBag = IntBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = IntBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = IntBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = IntBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = IntBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = IntBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = IntBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = IntBagsTest::classIsNonInstantiable;
        }
    }
}
