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

import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableFloatBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableFloatBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class FloatBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(FloatBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.FloatBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableFloatBagFactory bagFactory) {
        Assert.assertEquals(FloatHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), bagFactory.of(1.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), bagFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(FloatBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.FloatBags.mutable);
    }

    private void assertMutableBagFactory(MutableFloatBagFactory bagFactory) {
        Assert.assertEquals(FloatHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), bagFactory.of(1.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), bagFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(MutableFloatBag.class, bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(FloatBags.immutable.of().isEmpty());
        Assert.assertTrue(FloatBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        Assert.assertEquals(bag, FloatBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1.0f), FloatBags.immutable.of(1.0f));
        Assert.assertEquals(bag = bag.newWith(2.0f), FloatBags.immutable.of(1.0f, 2.0f));
        Assert.assertEquals(bag = bag.newWith(3.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(bag = bag.newWith(4.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(bag = bag.newWith(5.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(bag = bag.newWith(6.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(bag = bag.newWith(7.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(bag = bag.newWith(8.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(bag = bag.newWith(9.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(bag = bag.newWith(10.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @Test
    public void newBagWith_mutable() {
        MutableFloatBag bag = FloatBags.mutable.of();
        Assert.assertEquals(bag, FloatBags.mutable.of(bag.toArray()));
        bag.add(1.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f));
        bag.add(2.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f));
        bag.add(3.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f));
        bag.add(4.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        bag.add(5.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        bag.add(6.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        bag.add(7.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        bag.add(8.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        bag.add(9.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        bag.add(10.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1.0f), FloatBags.immutable.of(new float[] { 1.0f }));
        Assert.assertEquals(bag = bag.newWith(2.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f }));
        Assert.assertEquals(bag = bag.newWith(3.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        Assert.assertEquals(bag = bag.newWith(4.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        Assert.assertEquals(bag = bag.newWith(5.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        Assert.assertEquals(bag = bag.newWith(6.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        Assert.assertEquals(bag = bag.newWith(7.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        Assert.assertEquals(bag = bag.newWith(8.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        Assert.assertEquals(bag = bag.newWith(9.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        Assert.assertEquals(bag = bag.newWith(10.0f), FloatBags.immutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableFloatBag bag = FloatBags.mutable.of();
        Assert.assertEquals(bag, FloatBags.mutable.of(null));
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] {}));
        bag.add(1.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f }));
        bag.add(2.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f }));
        bag.add(3.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f }));
        bag.add(4.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }));
        bag.add(5.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f }));
        bag.add(6.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f }));
        bag.add(7.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f }));
        bag.add(8.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f }));
        bag.add(9.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f }));
        bag.add(10.0f);
        Assert.assertEquals(bag, FloatBags.mutable.of(new float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        FloatHashBag hashBag = FloatHashBag.newBagWith(1.0f);
        Assert.assertEquals(bag = bag.newWith(1.0f), hashBag.toImmutable());
        hashBag.add(2.0f);
        Assert.assertEquals(bag = bag.newWith(2.0f), hashBag.toImmutable());
        hashBag.add(3.0f);
        Assert.assertEquals(bag = bag.newWith(3.0f), hashBag.toImmutable());
        hashBag.add(4.0f);
        Assert.assertEquals(bag = bag.newWith(4.0f), hashBag.toImmutable());
        hashBag.add(5.0f);
        Assert.assertEquals(bag = bag.newWith(5.0f), hashBag.toImmutable());
        hashBag.add(6.0f);
        Assert.assertEquals(bag = bag.newWith(6.0f), hashBag.toImmutable());
        hashBag.add(7.0f);
        Assert.assertEquals(bag = bag.newWith(7.0f), hashBag.toImmutable());
        hashBag.add(8.0f);
        Assert.assertEquals(bag = bag.newWith(8.0f), hashBag.toImmutable());
        hashBag.add(9.0f);
        Assert.assertEquals(bag = bag.newWith(9.0f), hashBag.toImmutable());
        hashBag.add(10.0f);
        Assert.assertEquals(bag = bag.newWith(10.0f), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new FloatHashBag(), FloatBags.immutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), FloatBags.immutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), FloatBags.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f), FloatBags.immutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
        Assert.assertEquals(new FloatHashBag(), FloatBags.mutable.ofAll(Lists.mutable.<Float>empty()));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), FloatBags.mutable.ofAll(Lists.mutable.<Float>with(1.0f)));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), FloatBags.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f)));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f), FloatBags.mutable.ofAll(Lists.mutable.<Float>with(1.0f, 2.0f, 2.0f, 3.0f)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatBags.class);
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
        public void benchmark_emptyBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyBag, this.description("emptyBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWith_immutable, this.description("newBagWith_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWith_mutable, this.description("newBagWith_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWithArray_immutable, this.description("newBagWithArray_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWithArray_mutable, this.description("newBagWithArray_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWithBag, this.description("newBagWithBag"));
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

        private FloatBagsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatBagsTest();
        }

        @java.lang.Override
        public FloatBagsTest implementation() {
            return this.implementation;
        }
    }
}
