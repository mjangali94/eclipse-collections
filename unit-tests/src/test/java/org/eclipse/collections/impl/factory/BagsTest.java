/*
 * Copyright (c) 2019 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import java.util.stream.Stream;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MultiReaderBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.factory.bag.ImmutableBagFactory;
import org.eclipse.collections.api.factory.bag.MultiReaderBagFactory;
import org.eclipse.collections.api.factory.bag.MutableBagFactory;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MultiReaderHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BagsTest {

    @Test
    public void mutables() {
        MutableBagFactory bagFactory = Bags.mutable;
        Verify.assertBagsEqual(HashBag.newBag(), bagFactory.of());
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of());
        Verify.assertBagsEqual(HashBag.newBagWith(1), bagFactory.of(1));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of(1));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2), bagFactory.of(1, 2));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of(1, 2));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 3), bagFactory.of(1, 2, 3));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of(1, 2, 3));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 3, 4), bagFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of(1, 2, 3, 4));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 3, 4, 5), bagFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.of(1, 2, 3, 4, 5));
        Bag<Integer> bag = HashBag.newBagWith(1, 2, 2, 3, 3, 3);
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 2, 3, 3, 3), bagFactory.ofAll(bag));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofAll(bag));
        Assert.assertNotSame(bagFactory.ofAll(bag), bag);
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 2, 3, 3, 3), bagFactory.ofAll(FastList.newListWith(1, 2, 2, 3, 3, 3)));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofAll(FastList.newListWith(1, 2, 2, 3, 3, 3)));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 3, 4, 5), bagFactory.ofAll(UnifiedSet.newSetWith(1, 2, 3, 4, 5)));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofAll(UnifiedSet.newSetWith(1, 2, 3, 4, 5)));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 2, 3, 3, 3), bagFactory.fromStream(Stream.of(1, 2, 2, 3, 3, 3)));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.fromStream(Stream.of(1, 2, 2, 3, 3, 3)));
        Verify.assertBagsEqual(HashBag.newBagWith(1), bagFactory.ofOccurrences(1, 1));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofOccurrences(1, 1));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 2), bagFactory.ofOccurrences(1, 1, 2, 2));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2));
        Verify.assertBagsEqual(HashBag.newBagWith(1, 2, 2, 3, 3, 3), bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3));
        Verify.assertInstanceOf(MutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3, 4, 4));
    }

    @Test
    public void immutables() {
        ImmutableBagFactory bagFactory = Bags.immutable;
        Assert.assertEquals(HashBag.newBag(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of());
        Assert.assertEquals(HashBag.newBagWith(1), bagFactory.of(1));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1));
        Assert.assertEquals(HashBag.newBagWith(1, 2), bagFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3), bagFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4), bagFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5), bagFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5, 6), bagFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5, 6, 7), bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(HashBag.newBagWith(3, 2, 1), bagFactory.ofAll(HashBag.newBagWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.ofAll(HashBag.newBagWith(1, 2, 3)));
        Assert.assertEquals(HashBag.newBagWith(3, 2, 1), bagFactory.fromStream(Stream.of(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.fromStream(Stream.of(1, 2, 3)));
        Assert.assertEquals(HashBag.newBagWith(1), bagFactory.ofOccurrences(1, 1));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.ofOccurrences(1, 1));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 2), bagFactory.ofOccurrences(1, 1, 2, 2));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 2, 3, 3, 3), bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4), bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3, 4, 4));
        Verify.assertInstanceOf(ImmutableBag.class, bagFactory.ofOccurrences(1, 1, 2, 2, 3, 3, 4, 4));
    }

    @Test
    public void emptyBag() {
        Assert.assertTrue(Bags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith() {
        ImmutableBag<String> bag = Bags.immutable.of();
        Assert.assertEquals(bag, Bags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith("1"), Bags.immutable.of("1"));
        Assert.assertEquals(bag = bag.newWith("2"), Bags.immutable.of("1", "2"));
        Assert.assertEquals(bag = bag.newWith("3"), Bags.immutable.of("1", "2", "3"));
        Assert.assertEquals(bag = bag.newWith("4"), Bags.immutable.of("1", "2", "3", "4"));
        Assert.assertEquals(bag = bag.newWith("5"), Bags.immutable.of("1", "2", "3", "4", "5"));
        Assert.assertEquals(bag = bag.newWith("6"), Bags.immutable.of("1", "2", "3", "4", "5", "6"));
        Assert.assertEquals(bag = bag.newWith("7"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7"));
        Assert.assertEquals(bag = bag.newWith("8"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8"));
        Assert.assertEquals(bag = bag.newWith("9"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Assert.assertEquals(bag = bag.newWith("10"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        Assert.assertEquals(bag = bag.newWith("11"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"));
        Assert.assertEquals(bag = bag.newWith("12"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray() {
        ImmutableBag<String> bag = Bags.immutable.of();
        Assert.assertEquals(bag = bag.newWith("1"), Bags.immutable.of(new String[] { "1" }));
        Assert.assertEquals(bag = bag.newWith("2"), Bags.immutable.of(new String[] { "1", "2" }));
        Assert.assertEquals(bag = bag.newWith("3"), Bags.immutable.of(new String[] { "1", "2", "3" }));
        Assert.assertEquals(bag = bag.newWith("4"), Bags.immutable.of(new String[] { "1", "2", "3", "4" }));
        Assert.assertEquals(bag = bag.newWith("5"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5" }));
        Assert.assertEquals(bag = bag.newWith("6"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5", "6" }));
        Assert.assertEquals(bag = bag.newWith("7"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        Assert.assertEquals(bag = bag.newWith("8"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        Assert.assertEquals(bag = bag.newWith("9"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        Assert.assertEquals(bag = bag.newWith("10"), Bags.immutable.of(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        Assert.assertEquals(bag = bag.newWith("11"), Bags.immutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"));
    }

    @Test
    public void newBagWithBag() {
        ImmutableBag<String> bag = Bags.immutable.of();
        HashBag<String> hashBag = HashBag.newBagWith("1");
        Assert.assertEquals(bag = bag.newWith("1"), hashBag.toImmutable());
        hashBag.add("2");
        Assert.assertEquals(bag = bag.newWith("2"), hashBag.toImmutable());
        hashBag.add("3");
        Assert.assertEquals(bag = bag.newWith("3"), hashBag.toImmutable());
        hashBag.add("4");
        Assert.assertEquals(bag = bag.newWith("4"), hashBag.toImmutable());
        hashBag.add("5");
        Assert.assertEquals(bag = bag.newWith("5"), hashBag.toImmutable());
        hashBag.add("6");
        Assert.assertEquals(bag = bag.newWith("6"), hashBag.toImmutable());
        hashBag.add("7");
        Assert.assertEquals(bag = bag.newWith("7"), hashBag.toImmutable());
        hashBag.add("8");
        Assert.assertEquals(bag = bag.newWith("8"), hashBag.toImmutable());
        hashBag.add("9");
        Assert.assertEquals(bag = bag.newWith("9"), hashBag.toImmutable());
        hashBag.add("10");
        Assert.assertEquals(bag = bag.newWith("10"), hashBag.toImmutable());
        hashBag.add("11");
        Assert.assertEquals(bag = bag.newWith("11"), hashBag.toImmutable());
    }

    @Test
    public void multiReader() {
        MultiReaderBagFactory bagFactory = Bags.multiReader;
        Assert.assertEquals(MultiReaderHashBag.newBag(), bagFactory.of());
        Verify.assertInstanceOf(MultiReaderBag.class, bagFactory.of());
        Assert.assertEquals(MultiReaderHashBag.newBag(), bagFactory.with());
        Verify.assertInstanceOf(MultiReaderBag.class, bagFactory.with());
        Assert.assertEquals(MultiReaderHashBag.newBagWith(1), bagFactory.of(1));
        Verify.assertInstanceOf(MultiReaderBag.class, bagFactory.of(1));
        Assert.assertEquals(MultiReaderHashBag.newBagWith(1, 2, 3), bagFactory.ofAll(UnifiedSet.newSetWith(1, 2, 3)));
        Verify.assertInstanceOf(MultiReaderBag.class, bagFactory.ofAll(UnifiedSet.newSetWith(1, 2, 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Bags.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyBag, this.description("emptyBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWith, this.description("newBagWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWithArray, this.description("newBagWithArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWithBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newBagWithBag, this.description("newBagWithBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_multiReader() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::multiReader, this.description("multiReader"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private BagsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BagsTest();
        }

        @java.lang.Override
        public BagsTest implementation() {
            return this.implementation;
        }
    }
}
