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

import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableDoubleBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableDoubleBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class DoubleBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(DoubleBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.DoubleBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableDoubleBagFactory bagFactory) {
        Assert.assertEquals(DoubleHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), bagFactory.of(1.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), bagFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0), bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(DoubleBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.DoubleBags.mutable);
    }

    private void assertMutableBagFactory(MutableDoubleBagFactory bagFactory) {
        Assert.assertEquals(DoubleHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), bagFactory.of(1.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), bagFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0), bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(MutableDoubleBag.class, bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(DoubleBags.immutable.of().isEmpty());
        Assert.assertTrue(DoubleBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        Assert.assertEquals(bag, DoubleBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1.0), DoubleBags.immutable.of(1.0));
        Assert.assertEquals(bag = bag.newWith(2.0), DoubleBags.immutable.of(1.0, 2.0));
        Assert.assertEquals(bag = bag.newWith(3.0), DoubleBags.immutable.of(1.0, 2.0, 3.0));
        Assert.assertEquals(bag = bag.newWith(4.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(bag = bag.newWith(5.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(bag = bag.newWith(6.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(bag = bag.newWith(7.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(bag = bag.newWith(8.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(bag = bag.newWith(9.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(bag = bag.newWith(10.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @Test
    public void newBagWith_mutable() {
        MutableDoubleBag bag = DoubleBags.mutable.of();
        Assert.assertEquals(bag, DoubleBags.mutable.of(bag.toArray()));
        bag.add(1.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0));
        bag.add(2.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0));
        bag.add(3.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0));
        bag.add(4.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0));
        bag.add(5.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        bag.add(6.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        bag.add(7.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        bag.add(8.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        bag.add(9.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        bag.add(10.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1.0), DoubleBags.immutable.of(new double[] { 1.0 }));
        Assert.assertEquals(bag = bag.newWith(2.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0 }));
        Assert.assertEquals(bag = bag.newWith(3.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0 }));
        Assert.assertEquals(bag = bag.newWith(4.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        Assert.assertEquals(bag = bag.newWith(5.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        Assert.assertEquals(bag = bag.newWith(6.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        Assert.assertEquals(bag = bag.newWith(7.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        Assert.assertEquals(bag = bag.newWith(8.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        Assert.assertEquals(bag = bag.newWith(9.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        Assert.assertEquals(bag = bag.newWith(10.0), DoubleBags.immutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableDoubleBag bag = DoubleBags.mutable.of();
        Assert.assertEquals(bag, DoubleBags.mutable.of(null));
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] {}));
        bag.add(1.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0 }));
        bag.add(2.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0 }));
        bag.add(3.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0 }));
        bag.add(4.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0 }));
        bag.add(5.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 }));
        bag.add(6.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }));
        bag.add(7.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 }));
        bag.add(8.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 }));
        bag.add(9.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
        bag.add(10.0);
        Assert.assertEquals(bag, DoubleBags.mutable.of(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        DoubleHashBag hashBag = DoubleHashBag.newBagWith(1.0);
        Assert.assertEquals(bag = bag.newWith(1.0), hashBag.toImmutable());
        hashBag.add(2.0);
        Assert.assertEquals(bag = bag.newWith(2.0), hashBag.toImmutable());
        hashBag.add(3.0);
        Assert.assertEquals(bag = bag.newWith(3.0), hashBag.toImmutable());
        hashBag.add(4.0);
        Assert.assertEquals(bag = bag.newWith(4.0), hashBag.toImmutable());
        hashBag.add(5.0);
        Assert.assertEquals(bag = bag.newWith(5.0), hashBag.toImmutable());
        hashBag.add(6.0);
        Assert.assertEquals(bag = bag.newWith(6.0), hashBag.toImmutable());
        hashBag.add(7.0);
        Assert.assertEquals(bag = bag.newWith(7.0), hashBag.toImmutable());
        hashBag.add(8.0);
        Assert.assertEquals(bag = bag.newWith(8.0), hashBag.toImmutable());
        hashBag.add(9.0);
        Assert.assertEquals(bag = bag.newWith(9.0), hashBag.toImmutable());
        hashBag.add(10.0);
        Assert.assertEquals(bag = bag.newWith(10.0), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new DoubleHashBag(), DoubleBags.immutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), DoubleBags.immutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), DoubleBags.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 2.0, 3.0), DoubleBags.immutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
        Assert.assertEquals(new DoubleHashBag(), DoubleBags.mutable.ofAll(Lists.mutable.<Double>empty()));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), DoubleBags.mutable.ofAll(Lists.mutable.<Double>with(1.0)));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), DoubleBags.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0)));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 2.0, 3.0), DoubleBags.mutable.ofAll(Lists.mutable.<Double>with(1.0, 2.0, 2.0, 3.0)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleBagsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = DoubleBagsTest::immutables;
            this.payloads.mutables = DoubleBagsTest::mutables;
            this.payloads.emptyBag = DoubleBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = DoubleBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = DoubleBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = DoubleBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = DoubleBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = DoubleBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = DoubleBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = DoubleBagsTest::classIsNonInstantiable;
        }
    }
}
