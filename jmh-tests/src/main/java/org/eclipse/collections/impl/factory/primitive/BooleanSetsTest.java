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
import org.eclipse.collections.api.factory.set.primitive.ImmutableBooleanSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableBooleanSetFactory;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.api.tuple.primitive.BooleanBooleanPair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public class BooleanSetsTest {

    @Test
    public void immutables() {
        this.assertImmutableSetFactory(BooleanSets.immutable);
        this.assertImmutableSetFactory(org.eclipse.collections.api.factory.primitive.BooleanSets.immutable);
    }

    private void assertImmutableSetFactory(ImmutableBooleanSetFactory setFactory) {
        Assert.assertEquals(new BooleanHashSet(), setFactory.with());
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with());
        Assert.assertEquals(BooleanHashSet.newSetWith(true), setFactory.with(true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), setFactory.with(true, false));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), setFactory.with(true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false), setFactory.with(true, false, true, false));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true), setFactory.with(true, false, true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false), setFactory.with(true, false, true, false, true, false));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true), setFactory.with(true, false, true, false, true, false, true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true), setFactory.with(true, false, true, false, true, false, true, true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true, true), setFactory.with(true, false, true, false, true, false, true, true, true));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true, true, false), setFactory.with(true, false, true, false, true, false, true, true, true, false));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), setFactory.withAll(BooleanHashSet.newSetWith(true, false, true)));
        Verify.assertInstanceOf(ImmutableBooleanSet.class, setFactory.withAll(BooleanHashSet.newSetWith(true, false, true)));
    }

    @Test
    public void mutables() {
        this.assertMutableSetFactory(BooleanSets.mutable);
        this.assertMutableSetFactory(org.eclipse.collections.api.factory.primitive.BooleanSets.mutable);
    }

    private void assertMutableSetFactory(MutableBooleanSetFactory setFactory) {
        Assert.assertEquals(new BooleanHashSet(), setFactory.with());
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with());
        Assert.assertEquals(BooleanHashSet.newSetWith(true), setFactory.with(true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), setFactory.with(true, false));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), setFactory.with(true, false, true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false), setFactory.with(true, false, true, false));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true), setFactory.with(true, false, true, false, true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false), setFactory.with(true, false, true, false, true, false));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true), setFactory.with(true, false, true, false, true, false, true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true), setFactory.with(true, false, true, false, true, false, true, true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true, true), setFactory.with(true, false, true, false, true, false, true, true, true));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false, true, false, true, true, true, false), setFactory.with(true, false, true, false, true, false, true, true, true, false));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.with(true, false, true, false, true, false, true, true, true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), setFactory.withAll(BooleanHashSet.newSetWith(true, false, true)));
        Verify.assertInstanceOf(MutableBooleanSet.class, setFactory.withAll(BooleanHashSet.newSetWith(true, false, true)));
    }

    @Test
    public void emptySet() {
        Verify.assertEmpty(BooleanSets.immutable.with());
        Assert.assertSame(BooleanSets.immutable.with(), BooleanSets.immutable.with());
        Verify.assertPostSerializedIdentity(BooleanSets.immutable.with());
    }

    @Test
    public void newSetWith() {
        ImmutableBooleanSet set = BooleanSets.immutable.with();
        Assert.assertEquals(set, BooleanSets.immutable.with(set.toArray()));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(true, false));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(true, false, true, false));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true, false, true));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(true, false, true, false, true, false));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true, false, true, false, true));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true, false, true, false, true, true));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true, false, true, false, true, true, true));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(true, false, true, false, true, false, true, true, true, false));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(true, false, true, false, true, false, true, true, true, false, true));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(true, false, true, false, true, false, true, true, true, false, true, false));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray() {
        ImmutableBooleanSet set = BooleanSets.immutable.with();
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true }));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(new boolean[] { true, false }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true }));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(new boolean[] { true, false, true, false }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true }));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false, true }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false, true, true }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false, true, true, true }));
        Assert.assertEquals(set = set.newWith(false), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false, true, true, true, false }));
        Assert.assertEquals(set = set.newWith(true), BooleanSets.immutable.with(new boolean[] { true, false, true, false, true, false, true, true, true, false, true }));
    }

    @Test
    public void newSetWithSet() {
        ImmutableBooleanSet set = BooleanSets.immutable.with();
        BooleanHashSet booleanHashSet = BooleanHashSet.newSetWith(true);
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.toImmutable());
        Assert.assertEquals(set = set.newWith(false), booleanHashSet.with(false).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
        Assert.assertEquals(set = set.newWith(false), booleanHashSet.with(false).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
        Assert.assertEquals(set = set.newWith(false), booleanHashSet.with(false).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
        Assert.assertEquals(set = set.newWith(false), booleanHashSet.with(false).toImmutable());
        Assert.assertEquals(set = set.newWith(true), booleanHashSet.with(true).toImmutable());
    }

    @Test
    public void newSetWithWithSet() {
        Assert.assertEquals(new BooleanHashSet(), BooleanSets.immutable.withAll(new BooleanHashSet()));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), BooleanSets.immutable.withAll(BooleanHashSet.newSetWith(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanSets.immutable.withAll(BooleanHashSet.newSetWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), BooleanSets.immutable.withAll(BooleanHashSet.newSetWith(true, false, true)));
    }

    @Test
    public void ofAllBooleanIterable() {
        Assert.assertEquals(new BooleanHashSet(), BooleanSets.immutable.ofAll(BooleanLists.mutable.empty()));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), BooleanSets.immutable.ofAll(BooleanLists.mutable.with(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanSets.immutable.ofAll(BooleanLists.mutable.with(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), BooleanSets.immutable.ofAll(BooleanLists.mutable.with(true, false, true)));
        Assert.assertEquals(new BooleanHashSet(), BooleanSets.mutable.ofAll(BooleanLists.mutable.empty()));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), BooleanSets.mutable.ofAll(BooleanLists.mutable.with(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanSets.mutable.ofAll(BooleanLists.mutable.with(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), BooleanSets.mutable.ofAll(BooleanLists.mutable.with(true, false, true)));
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new BooleanHashSet(), BooleanSets.immutable.ofAll(Lists.mutable.empty()));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), BooleanSets.immutable.ofAll(Lists.mutable.with(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanSets.immutable.ofAll(Lists.mutable.with(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), BooleanSets.immutable.ofAll(Lists.mutable.with(true, false, true)));
        Assert.assertEquals(new BooleanHashSet(), BooleanSets.mutable.ofAll(Lists.mutable.empty()));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), BooleanSets.mutable.ofAll(Lists.mutable.with(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanSets.mutable.ofAll(Lists.mutable.with(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true), BooleanSets.mutable.ofAll(Lists.mutable.with(true, false, true)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(BooleanSets.class);
    }

    @Test
    public void cartesianProduct() {
        LazyIterable<BooleanBooleanPair> booleanBooleanPairs = BooleanSets.cartesianProduct(BooleanSets.mutable.with(true, false), BooleanSets.mutable.with(true, false));
        Set<BooleanBooleanPair> expected = Sets.mutable.with(PrimitiveTuples.pair(true, false), PrimitiveTuples.pair(true, true), PrimitiveTuples.pair(false, true), PrimitiveTuples.pair(false, false));
        Assert.assertEquals(expected, booleanBooleanPairs.toSet());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanSetsTest instance;

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
        public void benchmark_newSetWithArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithWithSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithWithSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllBooleanIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllBooleanIterable);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanSetsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> newSetWithArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> newSetWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> newSetWithWithSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> ofAllBooleanIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> ofAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanSetsTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = BooleanSetsTest::immutables;
            this.payloads.mutables = BooleanSetsTest::mutables;
            this.payloads.emptySet = BooleanSetsTest::emptySet;
            this.payloads.newSetWith = BooleanSetsTest::newSetWith;
            this.payloads.newSetWithArray = BooleanSetsTest::newSetWithArray;
            this.payloads.newSetWithSet = BooleanSetsTest::newSetWithSet;
            this.payloads.newSetWithWithSet = BooleanSetsTest::newSetWithWithSet;
            this.payloads.ofAllBooleanIterable = BooleanSetsTest::ofAllBooleanIterable;
            this.payloads.ofAllIterable = BooleanSetsTest::ofAllIterable;
            this.payloads.classIsNonInstantiable = BooleanSetsTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = BooleanSetsTest::cartesianProduct;
        }
    }
*/
}
