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

import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableCharBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableCharBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class CharBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(CharBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.CharBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableCharBagFactory bagFactory) {
        Assert.assertEquals(CharHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), bagFactory.of((char) 1));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), bagFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(CharBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.CharBags.mutable);
    }

    private void assertMutableBagFactory(MutableCharBagFactory bagFactory) {
        Assert.assertEquals(CharHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), bagFactory.of((char) 1));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), bagFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(MutableCharBag.class, bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(CharBags.immutable.of().isEmpty());
        Assert.assertTrue(CharBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableCharBag bag = CharBags.immutable.of();
        Assert.assertEquals(bag, CharBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((char) 1), CharBags.immutable.of((char) 1));
        Assert.assertEquals(bag = bag.newWith((char) 2), CharBags.immutable.of((char) 1, (char) 2));
        Assert.assertEquals(bag = bag.newWith((char) 3), CharBags.immutable.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(bag = bag.newWith((char) 4), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(bag = bag.newWith((char) 5), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(bag = bag.newWith((char) 6), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(bag = bag.newWith((char) 7), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(bag = bag.newWith((char) 8), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(bag = bag.newWith((char) 9), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(bag = bag.newWith((char) 10), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @Test
    public void newBagWith_mutable() {
        MutableCharBag bag = CharBags.mutable.of();
        Assert.assertEquals(bag, CharBags.mutable.of(bag.toArray()));
        bag.add((char) 1);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1));
        bag.add((char) 2);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2));
        bag.add((char) 3);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3));
        bag.add((char) 4);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        bag.add((char) 5);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        bag.add((char) 6);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        bag.add((char) 7);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        bag.add((char) 8);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        bag.add((char) 9);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        bag.add((char) 10);
        Assert.assertEquals(bag, CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableCharBag bag = CharBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((char) 1), CharBags.immutable.of(new char[] { (char) 1 }));
        Assert.assertEquals(bag = bag.newWith((char) 2), CharBags.immutable.of(new char[] { (char) 1, (char) 2 }));
        Assert.assertEquals(bag = bag.newWith((char) 3), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        Assert.assertEquals(bag = bag.newWith((char) 4), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        Assert.assertEquals(bag = bag.newWith((char) 5), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        Assert.assertEquals(bag = bag.newWith((char) 6), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        Assert.assertEquals(bag = bag.newWith((char) 7), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        Assert.assertEquals(bag = bag.newWith((char) 8), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        Assert.assertEquals(bag = bag.newWith((char) 9), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        Assert.assertEquals(bag = bag.newWith((char) 10), CharBags.immutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableCharBag bag = CharBags.mutable.of();
        Assert.assertEquals(bag, CharBags.mutable.of(null));
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] {}));
        bag.add((char) 1);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1 }));
        bag.add((char) 2);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2 }));
        bag.add((char) 3);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3 }));
        bag.add((char) 4);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        bag.add((char) 5);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        bag.add((char) 6);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        bag.add((char) 7);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        bag.add((char) 8);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        bag.add((char) 9);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        bag.add((char) 10);
        Assert.assertEquals(bag, CharBags.mutable.of(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableCharBag bag = CharBags.immutable.of();
        CharHashBag hashBag = CharHashBag.newBagWith((char) 1);
        Assert.assertEquals(bag = bag.newWith((char) 1), hashBag.toImmutable());
        hashBag.add((char) 2);
        Assert.assertEquals(bag = bag.newWith((char) 2), hashBag.toImmutable());
        hashBag.add((char) 3);
        Assert.assertEquals(bag = bag.newWith((char) 3), hashBag.toImmutable());
        hashBag.add((char) 4);
        Assert.assertEquals(bag = bag.newWith((char) 4), hashBag.toImmutable());
        hashBag.add((char) 5);
        Assert.assertEquals(bag = bag.newWith((char) 5), hashBag.toImmutable());
        hashBag.add((char) 6);
        Assert.assertEquals(bag = bag.newWith((char) 6), hashBag.toImmutable());
        hashBag.add((char) 7);
        Assert.assertEquals(bag = bag.newWith((char) 7), hashBag.toImmutable());
        hashBag.add((char) 8);
        Assert.assertEquals(bag = bag.newWith((char) 8), hashBag.toImmutable());
        hashBag.add((char) 9);
        Assert.assertEquals(bag = bag.newWith((char) 9), hashBag.toImmutable());
        hashBag.add((char) 10);
        Assert.assertEquals(bag = bag.newWith((char) 10), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new CharHashBag(), CharBags.immutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), CharBags.immutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), CharBags.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 2, (char) 3), CharBags.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
        Assert.assertEquals(new CharHashBag(), CharBags.mutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), CharBags.mutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), CharBags.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 2, (char) 3), CharBags.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharBagsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> payload) throws java.lang.Throwable {
            this.instance = new CharBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharBagsTest::immutables;
            this.payloads.mutables = CharBagsTest::mutables;
            this.payloads.emptyBag = CharBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = CharBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = CharBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = CharBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = CharBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = CharBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = CharBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = CharBagsTest::classIsNonInstantiable;
        }
    }
}
