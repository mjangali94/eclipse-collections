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
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableByteSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableByteSetFactory;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class ByteSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(ByteSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.ByteSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableByteSetFactory setFactory) {
        Assert.assertEquals(ByteHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.empty());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), setFactory.with((byte) 1));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), setFactory.with((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), setFactory.with((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), setFactory.withAll(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteSet.class, setFactory.withAll(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(ByteSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.ByteSets.mutable);
    }

    private void assertMutableSetFactory(MutableByteSetFactory setFactory) {
        Assert.assertEquals(ByteHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.empty());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), setFactory.with((byte) 1));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), setFactory.with((byte) 1, (byte) 2));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), setFactory.with((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), setFactory.withAll(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(MutableByteSet.class, setFactory.withAll(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(ByteSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableByteSet set = ByteSets.immutable.empty();
        Assert.assertEquals(set, ByteSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith((byte) 1), ByteSets.immutable.with((byte) 1));
        Assert.assertEquals(set = set.newWith((byte) 2), ByteSets.immutable.with((byte) 1, (byte) 2));
        Assert.assertEquals(set = set.newWith((byte) 3), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(set = set.newWith((byte) 4), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(set = set.newWith((byte) 5), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(set = set.newWith((byte) 6), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(set = set.newWith((byte) 7), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(set = set.newWith((byte) 8), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(set = set.newWith((byte) 9), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(set = set.newWith((byte) 10), ByteSets.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableByteSet set = ByteSets.immutable.empty();
        Assert.assertEquals(set = set.newWith((byte) 1), ByteSets.immutable.with(new byte[] { (byte) 1 }));
        Assert.assertEquals(set = set.newWith((byte) 2), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2 }));
        Assert.assertEquals(set = set.newWith((byte) 3), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        Assert.assertEquals(set = set.newWith((byte) 4), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        Assert.assertEquals(set = set.newWith((byte) 5), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        Assert.assertEquals(set = set.newWith((byte) 6), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        Assert.assertEquals(set = set.newWith((byte) 7), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        Assert.assertEquals(set = set.newWith((byte) 8), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        Assert.assertEquals(set = set.newWith((byte) 9), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        Assert.assertEquals(set = set.newWith((byte) 10), ByteSets.immutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableByteSet set = ByteSets.mutable.empty();
        Assert.assertEquals(set, ByteSets.mutable.with(null));
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] {}));
        set.add((byte) 1);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1 }));
        set.add((byte) 2);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2 }));
        set.add((byte) 3);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        set.add((byte) 4);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        set.add((byte) 5);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        set.add((byte) 6);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        set.add((byte) 7);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        set.add((byte) 8);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        set.add((byte) 9);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        set.add((byte) 10);
        Assert.assertEquals(set, ByteSets.mutable.with(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableByteSet set = ByteSets.immutable.empty();
        ByteHashSet hashSet = ByteHashSet.newSetWith((byte) 1);
        Assert.assertEquals(set = set.newWith((byte) 1), hashSet.toImmutable());
        hashSet.add((byte) 2);
        Assert.assertEquals(set = set.newWith((byte) 2), hashSet.toImmutable());
        hashSet.add((byte) 3);
        Assert.assertEquals(set = set.newWith((byte) 3), hashSet.toImmutable());
        hashSet.add((byte) 4);
        Assert.assertEquals(set = set.newWith((byte) 4), hashSet.toImmutable());
        hashSet.add((byte) 5);
        Assert.assertEquals(set = set.newWith((byte) 5), hashSet.toImmutable());
        hashSet.add((byte) 6);
        Assert.assertEquals(set = set.newWith((byte) 6), hashSet.toImmutable());
        hashSet.add((byte) 7);
        Assert.assertEquals(set = set.newWith((byte) 7), hashSet.toImmutable());
        hashSet.add((byte) 8);
        Assert.assertEquals(set = set.newWith((byte) 8), hashSet.toImmutable());
        hashSet.add((byte) 9);
        Assert.assertEquals(set = set.newWith((byte) 9), hashSet.toImmutable());
        hashSet.add((byte) 10);
        Assert.assertEquals(set = set.newWith((byte) 10), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ByteHashSet(), ByteSets.immutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), ByteSets.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), ByteSets.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), ByteSets.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteHashSet(), ByteSets.mutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), ByteSets.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), ByteSets.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), ByteSets.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 2, (byte) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<ByteBytePair> byteBytePairs1 = ByteSets.cartesianProduct(ByteSets.mutable.with((byte) 1, (byte) 2), ByteSets.mutable.with((byte) 3, (byte) 4, (byte) 5));
        Set<ByteBytePair> expected1 = Sets.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 3), PrimitiveTuples.pair((byte) 1, (byte) 4), PrimitiveTuples.pair((byte) 1, (byte) 5), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 2, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 5));
        Assert.assertEquals(expected1, byteBytePairs1.toSet());
        LazyIterable<ByteBytePair> byteBytePairs2 = ByteSets.cartesianProduct(ByteSets.mutable.with((byte) 3, (byte) 4, (byte) 5), ByteSets.mutable.with((byte) 1, (byte) 2));
        Set<ByteBytePair> expected2 = Sets.mutable.with(PrimitiveTuples.pair((byte) 3, (byte) 1), PrimitiveTuples.pair((byte) 3, (byte) 2), PrimitiveTuples.pair((byte) 4, (byte) 1), PrimitiveTuples.pair((byte) 4, (byte) 2), PrimitiveTuples.pair((byte) 5, (byte) 1), PrimitiveTuples.pair((byte) 5, (byte) 2));
        Assert.assertEquals(expected2, byteBytePairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<ByteBytePair> byteBytePairs = ByteSets.cartesianProduct(ByteSets.mutable.with((byte) 1, (byte) 2), ByteSets.mutable.with((byte) 1, (byte) 2));
        Set<ByteBytePair> expected = Sets.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 1));
        Assert.assertEquals(expected, byteBytePairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteSetsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> newSetWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> newSetWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteSetsTest> cartesianProductSameElements;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteSetsTest::immutables;
            this.payloads.mutables = ByteSetsTest::mutables;
            this.payloads.emptySet = ByteSetsTest::emptySet;
            this.payloads.newSetWith = ByteSetsTest::newSetWith;
            this.payloads.newSetWithArray_immutable = ByteSetsTest::newSetWithArray_immutable;
            this.payloads.newSetWithArray_mutable = ByteSetsTest::newSetWithArray_mutable;
            this.payloads.newSetWithSet = ByteSetsTest::newSetWithSet;
            this.payloads.ofAllIterable = ByteSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = ByteSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = ByteSetsTest::cartesianProduct;
            this.payloads.cartesianProductSameElements = ByteSetsTest::cartesianProductSameElements;
        }
    }
}
