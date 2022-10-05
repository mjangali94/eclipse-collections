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

        private CharBagsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharBagsTest();
        }

        @java.lang.Override
        public CharBagsTest implementation() {
            return this.implementation;
        }
    }
}
