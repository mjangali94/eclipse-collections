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

import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableByteBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableByteBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class ByteBagsTest {

    @Test
    public void immutables() {
        this.assertImmutableBagFactory(ByteBags.immutable);
        this.assertImmutableBagFactory(org.eclipse.collections.api.factory.primitive.ByteBags.immutable);
    }

    private void assertImmutableBagFactory(ImmutableByteBagFactory bagFactory) {
        Assert.assertEquals(ByteHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), bagFactory.of((byte) 1));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), bagFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableBagFactory(ByteBags.mutable);
        this.assertMutableBagFactory(org.eclipse.collections.api.factory.primitive.ByteBags.mutable);
    }

    private void assertMutableBagFactory(MutableByteBagFactory bagFactory) {
        Assert.assertEquals(ByteHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), bagFactory.of((byte) 1));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), bagFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(MutableByteBag.class, bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(ByteBags.immutable.of().isEmpty());
        Assert.assertTrue(ByteBags.mutable.of().isEmpty());
    }

    @Test
    public void newBagWith_immutable() {
        ImmutableByteBag bag = ByteBags.immutable.of();
        Assert.assertEquals(bag, ByteBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((byte) 1), ByteBags.immutable.of((byte) 1));
        Assert.assertEquals(bag = bag.newWith((byte) 2), ByteBags.immutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(bag = bag.newWith((byte) 3), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(bag = bag.newWith((byte) 4), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(bag = bag.newWith((byte) 5), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(bag = bag.newWith((byte) 6), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(bag = bag.newWith((byte) 7), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(bag = bag.newWith((byte) 8), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(bag = bag.newWith((byte) 9), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(bag = bag.newWith((byte) 10), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @Test
    public void newBagWith_mutable() {
        MutableByteBag bag = ByteBags.mutable.of();
        Assert.assertEquals(bag, ByteBags.mutable.of(bag.toArray()));
        bag.add((byte) 1);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1));
        bag.add((byte) 2);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2));
        bag.add((byte) 3);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3));
        bag.add((byte) 4);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        bag.add((byte) 5);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        bag.add((byte) 6);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        bag.add((byte) 7);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        bag.add((byte) 8);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        bag.add((byte) 9);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        bag.add((byte) 10);
        Assert.assertEquals(bag, ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_immutable() {
        ImmutableByteBag bag = ByteBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((byte) 1), ByteBags.immutable.of(new byte[] { (byte) 1 }));
        Assert.assertEquals(bag = bag.newWith((byte) 2), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2 }));
        Assert.assertEquals(bag = bag.newWith((byte) 3), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        Assert.assertEquals(bag = bag.newWith((byte) 4), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        Assert.assertEquals(bag = bag.newWith((byte) 5), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        Assert.assertEquals(bag = bag.newWith((byte) 6), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        Assert.assertEquals(bag = bag.newWith((byte) 7), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        Assert.assertEquals(bag = bag.newWith((byte) 8), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        Assert.assertEquals(bag = bag.newWith((byte) 9), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        Assert.assertEquals(bag = bag.newWith((byte) 10), ByteBags.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray_mutable() {
        MutableByteBag bag = ByteBags.mutable.of();
        Assert.assertEquals(bag, ByteBags.mutable.of(null));
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] {}));
        bag.add((byte) 1);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1 }));
        bag.add((byte) 2);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2 }));
        bag.add((byte) 3);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        bag.add((byte) 4);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        bag.add((byte) 5);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        bag.add((byte) 6);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        bag.add((byte) 7);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        bag.add((byte) 8);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        bag.add((byte) 9);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        bag.add((byte) 10);
        Assert.assertEquals(bag, ByteBags.mutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @Test
    public void newBagWithBag() {
        ImmutableByteBag bag = ByteBags.immutable.of();
        ByteHashBag hashBag = ByteHashBag.newBagWith((byte) 1);
        Assert.assertEquals(bag = bag.newWith((byte) 1), hashBag.toImmutable());
        hashBag.add((byte) 2);
        Assert.assertEquals(bag = bag.newWith((byte) 2), hashBag.toImmutable());
        hashBag.add((byte) 3);
        Assert.assertEquals(bag = bag.newWith((byte) 3), hashBag.toImmutable());
        hashBag.add((byte) 4);
        Assert.assertEquals(bag = bag.newWith((byte) 4), hashBag.toImmutable());
        hashBag.add((byte) 5);
        Assert.assertEquals(bag = bag.newWith((byte) 5), hashBag.toImmutable());
        hashBag.add((byte) 6);
        Assert.assertEquals(bag = bag.newWith((byte) 6), hashBag.toImmutable());
        hashBag.add((byte) 7);
        Assert.assertEquals(bag = bag.newWith((byte) 7), hashBag.toImmutable());
        hashBag.add((byte) 8);
        Assert.assertEquals(bag = bag.newWith((byte) 8), hashBag.toImmutable());
        hashBag.add((byte) 9);
        Assert.assertEquals(bag = bag.newWith((byte) 9), hashBag.toImmutable());
        hashBag.add((byte) 10);
        Assert.assertEquals(bag = bag.newWith((byte) 10), hashBag.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ByteHashBag(), ByteBags.immutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), ByteBags.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), ByteBags.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteBags.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteHashBag(), ByteBags.mutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), ByteBags.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), ByteBags.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3), ByteBags.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteBags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteBagsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteBagsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> emptyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> newBagWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> newBagWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> newBagWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> newBagWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> newBagWithBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBagsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteBagsTest::immutables;
            this.payloads.mutables = ByteBagsTest::mutables;
            this.payloads.emptyBag = ByteBagsTest::emptyBag;
            this.payloads.newBagWith_immutable = ByteBagsTest::newBagWith_immutable;
            this.payloads.newBagWith_mutable = ByteBagsTest::newBagWith_mutable;
            this.payloads.newBagWithArray_immutable = ByteBagsTest::newBagWithArray_immutable;
            this.payloads.newBagWithArray_mutable = ByteBagsTest::newBagWithArray_mutable;
            this.payloads.newBagWithBag = ByteBagsTest::newBagWithBag;
            this.payloads.ofAllIterable = ByteBagsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = ByteBagsTest::classIsNonInstantiable;
        }
    }
}
