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
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableCharSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableCharSetFactory;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class CharSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(CharSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.CharSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableCharSetFactory setFactory) {
        Assert.assertEquals(CharHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.empty());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), setFactory.with((char) 1));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), setFactory.with((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.with((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(CharSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.CharSets.mutable);
    }

    private void assertMutableSetFactory(MutableCharSetFactory setFactory) {
        Assert.assertEquals(CharHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.empty());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), setFactory.with((char) 1));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), setFactory.with((char) 1, (char) 2));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.with((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(MutableCharSet.class, setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptySet() {
        Assert.assertTrue(CharSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith() {
        ImmutableCharSet set = CharSets.immutable.empty();
        Assert.assertEquals(set, CharSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith((char) 1), CharSets.immutable.with((char) 1));
        Assert.assertEquals(set = set.newWith((char) 2), CharSets.immutable.with((char) 1, (char) 2));
        Assert.assertEquals(set = set.newWith((char) 3), CharSets.immutable.with((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(set = set.newWith((char) 4), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(set = set.newWith((char) 5), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(set = set.newWith((char) 6), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(set = set.newWith((char) 7), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(set = set.newWith((char) 8), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(set = set.newWith((char) 9), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(set = set.newWith((char) 10), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_immutable() {
        ImmutableCharSet set = CharSets.immutable.empty();
        Assert.assertEquals(set = set.newWith((char) 1), CharSets.immutable.with(new char[] { (char) 1 }));
        Assert.assertEquals(set = set.newWith((char) 2), CharSets.immutable.with(new char[] { (char) 1, (char) 2 }));
        Assert.assertEquals(set = set.newWith((char) 3), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3 }));
        Assert.assertEquals(set = set.newWith((char) 4), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        Assert.assertEquals(set = set.newWith((char) 5), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        Assert.assertEquals(set = set.newWith((char) 6), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        Assert.assertEquals(set = set.newWith((char) 7), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        Assert.assertEquals(set = set.newWith((char) 8), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        Assert.assertEquals(set = set.newWith((char) 9), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        Assert.assertEquals(set = set.newWith((char) 10), CharSets.immutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray_mutable() {
        MutableCharSet set = CharSets.mutable.empty();
        Assert.assertEquals(set, CharSets.mutable.with(null));
        Assert.assertEquals(set, CharSets.mutable.with(new char[] {}));
        set.add((char) 1);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1 }));
        set.add((char) 2);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2 }));
        set.add((char) 3);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3 }));
        set.add((char) 4);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }));
        set.add((char) 5);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5 }));
        set.add((char) 6);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6 }));
        set.add((char) 7);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7 }));
        set.add((char) 8);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8 }));
        set.add((char) 9);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9 }));
        set.add((char) 10);
        Assert.assertEquals(set, CharSets.mutable.with(new char[] { (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10 }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableCharSet set = CharSets.immutable.empty();
        CharHashSet hashSet = CharHashSet.newSetWith((char) 1);
        Assert.assertEquals(set = set.newWith((char) 1), hashSet.toImmutable());
        hashSet.add((char) 2);
        Assert.assertEquals(set = set.newWith((char) 2), hashSet.toImmutable());
        hashSet.add((char) 3);
        Assert.assertEquals(set = set.newWith((char) 3), hashSet.toImmutable());
        hashSet.add((char) 4);
        Assert.assertEquals(set = set.newWith((char) 4), hashSet.toImmutable());
        hashSet.add((char) 5);
        Assert.assertEquals(set = set.newWith((char) 5), hashSet.toImmutable());
        hashSet.add((char) 6);
        Assert.assertEquals(set = set.newWith((char) 6), hashSet.toImmutable());
        hashSet.add((char) 7);
        Assert.assertEquals(set = set.newWith((char) 7), hashSet.toImmutable());
        hashSet.add((char) 8);
        Assert.assertEquals(set = set.newWith((char) 8), hashSet.toImmutable());
        hashSet.add((char) 9);
        Assert.assertEquals(set = set.newWith((char) 9), hashSet.toImmutable());
        hashSet.add((char) 10);
        Assert.assertEquals(set = set.newWith((char) 10), hashSet.toImmutable());
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new CharHashSet(), CharSets.immutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), CharSets.immutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), CharSets.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), CharSets.immutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
        Assert.assertEquals(new CharHashSet(), CharSets.mutable.ofAll(Lists.mutable.<Character>empty()));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), CharSets.mutable.ofAll(Lists.mutable.<Character>with((char) 1)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), CharSets.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), CharSets.mutable.ofAll(Lists.mutable.<Character>with((char) 1, (char) 2, (char) 2, (char) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<CharCharPair> charCharPairs1 = CharSets.cartesianProduct(CharSets.mutable.with((char) 1, (char) 2), CharSets.mutable.with((char) 3, (char) 4, (char) 5));
        Set<CharCharPair> expected1 = Sets.mutable.with(PrimitiveTuples.pair((char) 1, (char) 3), PrimitiveTuples.pair((char) 1, (char) 4), PrimitiveTuples.pair((char) 1, (char) 5), PrimitiveTuples.pair((char) 2, (char) 3), PrimitiveTuples.pair((char) 2, (char) 4), PrimitiveTuples.pair((char) 2, (char) 5));
        Assert.assertEquals(expected1, charCharPairs1.toSet());
        LazyIterable<CharCharPair> charCharPairs2 = CharSets.cartesianProduct(CharSets.mutable.with((char) 3, (char) 4, (char) 5), CharSets.mutable.with((char) 1, (char) 2));
        Set<CharCharPair> expected2 = Sets.mutable.with(PrimitiveTuples.pair((char) 3, (char) 1), PrimitiveTuples.pair((char) 3, (char) 2), PrimitiveTuples.pair((char) 4, (char) 1), PrimitiveTuples.pair((char) 4, (char) 2), PrimitiveTuples.pair((char) 5, (char) 1), PrimitiveTuples.pair((char) 5, (char) 2));
        Assert.assertEquals(expected2, charCharPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements() {
        LazyIterable<CharCharPair> charCharPairs = CharSets.cartesianProduct(CharSets.mutable.with((char) 1, (char) 2), CharSets.mutable.with((char) 1, (char) 2));
        Set<CharCharPair> expected = Sets.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 1, (char) 2), PrimitiveTuples.pair((char) 2, (char) 2), PrimitiveTuples.pair((char) 2, (char) 1));
        Assert.assertEquals(expected, charCharPairs.toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharSetsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> payload) throws java.lang.Throwable {
            this.instance = new CharSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> newSetWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> newSetWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharSetsTest> cartesianProductSameElements;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharSetsTest::immutables;
            this.payloads.mutables = CharSetsTest::mutables;
            this.payloads.emptySet = CharSetsTest::emptySet;
            this.payloads.newSetWith = CharSetsTest::newSetWith;
            this.payloads.newSetWithArray_immutable = CharSetsTest::newSetWithArray_immutable;
            this.payloads.newSetWithArray_mutable = CharSetsTest::newSetWithArray_mutable;
            this.payloads.newSetWithSet = CharSetsTest::newSetWithSet;
            this.payloads.ofAllIterable = CharSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = CharSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = CharSetsTest::cartesianProduct;
            this.payloads.cartesianProductSameElements = CharSetsTest::cartesianProductSameElements;
        }
    }
}
