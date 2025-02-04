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
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableShortSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableShortSetFactory;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class ShortSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(ShortSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.ShortSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableShortSetFactory setFactory) {
        Assert.assertEquals(ShortHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.empty());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), setFactory.with((short) 1));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), setFactory.with((short) 1, (short) 2));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), setFactory.with((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), setFactory.withAll(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(ImmutableShortSet.class, setFactory.withAll(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(ShortSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.ShortSets.mutable);
    }

    private void assertMutableSetFactory(MutableShortSetFactory setFactory) {
        Assert.assertEquals(ShortHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.empty());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), setFactory.with((short) 1));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), setFactory.with((short) 1, (short) 2));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), setFactory.with((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), setFactory.withAll(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(MutableShortSet.class, setFactory.withAll(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(ShortSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableShortSet set = ShortSets.immutable.empty();
        Assert.assertEquals(set, ShortSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith((short) 1), ShortSets.immutable.with((short) 1));
        Assert.assertEquals(set = set.newWith((short) 2), ShortSets.immutable.with((short) 1, (short) 2));
        Assert.assertEquals(set = set.newWith((short) 3), ShortSets.immutable.with((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(set = set.newWith((short) 4), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(set = set.newWith((short) 5), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(set = set.newWith((short) 6), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(set = set.newWith((short) 7), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(set = set.newWith((short) 8), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(set = set.newWith((short) 9), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(set = set.newWith((short) 10), ShortSets.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableShortSet set = ShortSets.immutable.empty();
        Assert.assertEquals(set = set.newWith((short) 1), ShortSets.immutable.with(new short[] { (short) 1 }));
        Assert.assertEquals(set = set.newWith((short) 2), ShortSets.immutable.with(new short[] { (short) 1, (short) 2 }));
        Assert.assertEquals(set = set.newWith((short) 3), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3 }));
        Assert.assertEquals(set = set.newWith((short) 4), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        Assert.assertEquals(set = set.newWith((short) 5), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        Assert.assertEquals(set = set.newWith((short) 6), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        Assert.assertEquals(set = set.newWith((short) 7), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        Assert.assertEquals(set = set.newWith((short) 8), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        Assert.assertEquals(set = set.newWith((short) 9), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        Assert.assertEquals(set = set.newWith((short) 10), ShortSets.immutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableShortSet set = ShortSets.mutable.empty();
        Assert.assertEquals(set, ShortSets.mutable.with(null));
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] {}));
        set.add((short) 1);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1 }));
        set.add((short) 2);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2 }));
        set.add((short) 3);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3 }));
        set.add((short) 4);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        set.add((short) 5);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        set.add((short) 6);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        set.add((short) 7);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        set.add((short) 8);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        set.add((short) 9);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        set.add((short) 10);
        Assert.assertEquals(set, ShortSets.mutable.with(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableShortSet set = ShortSets.immutable.empty();
        ShortHashSet hashSet = ShortHashSet.newSetWith((short) 1);
        Assert.assertEquals(set = set.newWith((short) 1), hashSet.toImmutable());
        hashSet.add((short) 2);
        Assert.assertEquals(set = set.newWith((short) 2), hashSet.toImmutable());
        hashSet.add((short) 3);
        Assert.assertEquals(set = set.newWith((short) 3), hashSet.toImmutable());
        hashSet.add((short) 4);
        Assert.assertEquals(set = set.newWith((short) 4), hashSet.toImmutable());
        hashSet.add((short) 5);
        Assert.assertEquals(set = set.newWith((short) 5), hashSet.toImmutable());
        hashSet.add((short) 6);
        Assert.assertEquals(set = set.newWith((short) 6), hashSet.toImmutable());
        hashSet.add((short) 7);
        Assert.assertEquals(set = set.newWith((short) 7), hashSet.toImmutable());
        hashSet.add((short) 8);
        Assert.assertEquals(set = set.newWith((short) 8), hashSet.toImmutable());
        hashSet.add((short) 9);
        Assert.assertEquals(set = set.newWith((short) 9), hashSet.toImmutable());
        hashSet.add((short) 10);
        Assert.assertEquals(set = set.newWith((short) 10), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ShortHashSet(), ShortSets.immutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), ShortSets.immutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), ShortSets.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), ShortSets.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortHashSet(), ShortSets.mutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), ShortSets.mutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), ShortSets.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), ShortSets.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 2, (short) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<ShortShortPair> shortShortPairs1 = ShortSets.cartesianProduct(ShortSets.mutable.with((short) 1, (short) 2), ShortSets.mutable.with((short) 3, (short) 4, (short) 5));
        Set<ShortShortPair> expected1 = Sets.mutable.with(PrimitiveTuples.pair((short) 1, (short) 3), PrimitiveTuples.pair((short) 1, (short) 4), PrimitiveTuples.pair((short) 1, (short) 5), PrimitiveTuples.pair((short) 2, (short) 3), PrimitiveTuples.pair((short) 2, (short) 4), PrimitiveTuples.pair((short) 2, (short) 5));
        Assert.assertEquals(expected1, shortShortPairs1.toSet());
        LazyIterable<ShortShortPair> shortShortPairs2 = ShortSets.cartesianProduct(ShortSets.mutable.with((short) 3, (short) 4, (short) 5), ShortSets.mutable.with((short) 1, (short) 2));
        Set<ShortShortPair> expected2 = Sets.mutable.with(PrimitiveTuples.pair((short) 3, (short) 1), PrimitiveTuples.pair((short) 3, (short) 2), PrimitiveTuples.pair((short) 4, (short) 1), PrimitiveTuples.pair((short) 4, (short) 2), PrimitiveTuples.pair((short) 5, (short) 1), PrimitiveTuples.pair((short) 5, (short) 2));
        Assert.assertEquals(expected2, shortShortPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<ShortShortPair> shortShortPairs = ShortSets.cartesianProduct(ShortSets.mutable.with((short) 1, (short) 2), ShortSets.mutable.with((short) 1, (short) 2));
        Set<ShortShortPair> expected = Sets.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 1, (short) 2), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 2, (short) 1));
        Assert.assertEquals(expected, shortShortPairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortSetsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> newSetWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> newSetWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortSetsTest> cartesianProductSameElements;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortSetsTest::immutables;
            this.payloads.mutables = ShortSetsTest::mutables;
            this.payloads.emptySet = ShortSetsTest::emptySet;
            this.payloads.newSetWith = ShortSetsTest::newSetWith;
            this.payloads.newSetWithArray_immutable = ShortSetsTest::newSetWithArray_immutable;
            this.payloads.newSetWithArray_mutable = ShortSetsTest::newSetWithArray_mutable;
            this.payloads.newSetWithSet = ShortSetsTest::newSetWithSet;
            this.payloads.ofAllIterable = ShortSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = ShortSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = ShortSetsTest::cartesianProduct;
            this.payloads.cartesianProductSameElements = ShortSetsTest::cartesianProductSameElements;
        }
    }
}
