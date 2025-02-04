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

import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableShortBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableShortBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class ShortBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(ShortBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.ShortBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableShortBagFactory bagFactory) {
        Assert.assertEquals(ShortHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), bagFactory.of((short) 1));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), bagFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(ShortBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.ShortBags.mutable);
    }

    private void assertMutableBagFactory(MutableShortBagFactory bagFactory) {
        Assert.assertEquals(ShortHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), bagFactory.of((short) 1));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), bagFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(MutableShortBag.class, bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(ShortBags.immutable.of().isEmpty());
        Assert.assertTrue(ShortBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableShortBag bag = ShortBags.immutable.of();
        Assert.assertEquals(bag, ShortBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((short) 1), ShortBags.immutable.of((short) 1));
        Assert.assertEquals(bag = bag.newWith((short) 2), ShortBags.immutable.of((short) 1, (short) 2));
        Assert.assertEquals(bag = bag.newWith((short) 3), ShortBags.immutable.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(bag = bag.newWith((short) 4), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(bag = bag.newWith((short) 5), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(bag = bag.newWith((short) 6), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(bag = bag.newWith((short) 7), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(bag = bag.newWith((short) 8), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(bag = bag.newWith((short) 9), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(bag = bag.newWith((short) 10), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @Test
    public void newBagWith_mutable() {
        MutableShortBag bag = ShortBags.mutable.of();
        Assert.assertEquals(bag, ShortBags.mutable.of(bag.toArray()));
        bag.add((short) 1);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1));
        bag.add((short) 2);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2));
        bag.add((short) 3);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3));
        bag.add((short) 4);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        bag.add((short) 5);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        bag.add((short) 6);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        bag.add((short) 7);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        bag.add((short) 8);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        bag.add((short) 9);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        bag.add((short) 10);
        Assert.assertEquals(bag, ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableShortBag bag = ShortBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((short) 1), ShortBags.immutable.of(new short[] { (short) 1 }));
        Assert.assertEquals(bag = bag.newWith((short) 2), ShortBags.immutable.of(new short[] { (short) 1, (short) 2 }));
        Assert.assertEquals(bag = bag.newWith((short) 3), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        Assert.assertEquals(bag = bag.newWith((short) 4), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        Assert.assertEquals(bag = bag.newWith((short) 5), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        Assert.assertEquals(bag = bag.newWith((short) 6), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        Assert.assertEquals(bag = bag.newWith((short) 7), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        Assert.assertEquals(bag = bag.newWith((short) 8), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        Assert.assertEquals(bag = bag.newWith((short) 9), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        Assert.assertEquals(bag = bag.newWith((short) 10), ShortBags.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableShortBag bag = ShortBags.mutable.of();
        Assert.assertEquals(bag, ShortBags.mutable.of(null));
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] {}));
        bag.add((short) 1);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1 }));
        bag.add((short) 2);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2 }));
        bag.add((short) 3);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        bag.add((short) 4);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        bag.add((short) 5);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        bag.add((short) 6);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        bag.add((short) 7);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        bag.add((short) 8);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        bag.add((short) 9);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        bag.add((short) 10);
        Assert.assertEquals(bag, ShortBags.mutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableShortBag bag = ShortBags.immutable.of();
        ShortHashBag hashBag = ShortHashBag.newBagWith((short) 1);
        Assert.assertEquals(bag = bag.newWith((short) 1), hashBag.toImmutable());
        hashBag.add((short) 2);
        Assert.assertEquals(bag = bag.newWith((short) 2), hashBag.toImmutable());
        hashBag.add((short) 3);
        Assert.assertEquals(bag = bag.newWith((short) 3), hashBag.toImmutable());
        hashBag.add((short) 4);
        Assert.assertEquals(bag = bag.newWith((short) 4), hashBag.toImmutable());
        hashBag.add((short) 5);
        Assert.assertEquals(bag = bag.newWith((short) 5), hashBag.toImmutable());
        hashBag.add((short) 6);
        Assert.assertEquals(bag = bag.newWith((short) 6), hashBag.toImmutable());
        hashBag.add((short) 7);
        Assert.assertEquals(bag = bag.newWith((short) 7), hashBag.toImmutable());
        hashBag.add((short) 8);
        Assert.assertEquals(bag = bag.newWith((short) 8), hashBag.toImmutable());
        hashBag.add((short) 9);
        Assert.assertEquals(bag = bag.newWith((short) 9), hashBag.toImmutable());
        hashBag.add((short) 10);
        Assert.assertEquals(bag = bag.newWith((short) 10), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ShortHashBag(), ShortBags.immutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), ShortBags.immutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), ShortBags.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3), ShortBags.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortHashBag(), ShortBags.mutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), ShortBags.mutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), ShortBags.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3), ShortBags.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortBagsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWith_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWith_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithArray_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithArray_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWithBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortBagsTest::immutables;
            this.payloads.mutables = ShortBagsTest::mutables;
            this.payloads.emptyBag = ShortBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = ShortBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = ShortBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = ShortBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = ShortBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = ShortBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = ShortBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = ShortBagsTest::classIsNonInstantiable;
        }
    }
}
