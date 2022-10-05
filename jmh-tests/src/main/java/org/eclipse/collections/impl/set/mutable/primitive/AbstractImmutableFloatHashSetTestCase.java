/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableFloatHashSetTestCase extends AbstractImmutableFloatCollectionTestCase {

    @Override
    protected abstract ImmutableFloatSet classUnderTest();

    @Override
    protected abstract ImmutableFloatSet newWith(float... elements);

    @Override
    protected MutableFloatSet newMutableCollectionWith(float... elements) {
        return FloatHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Float> newObjectCollectionWith(Float... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatHashSet set = new FloatHashSet();
        for (float i = 32.0f; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0f)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableFloatSet immutableFloatSet = this.classUnderTest();
        Assert.assertSame(immutableFloatSet, immutableFloatSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableFloatSet immutableFloatSet = this.classUnderTest();
        Assert.assertSame(immutableFloatSet, immutableFloatSet.toImmutable());
    }

    @Override
    @Test
    public void floatIterator() {
        MutableSet<Float> expected = UnifiedSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        MutableSet<Float> actual = UnifiedSet.newSet();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        FloatIterator iterator = set.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws() {
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        FloatIterator iterator = set.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        double[] sum = new double[1];
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        set.forEach((float each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1), sum[0], 0.0f);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(FloatPredicates.greaterThan(0.0f)));
        Assert.assertEquals(3L, set.count(FloatPredicates.lessThan(32.0f)));
        Assert.assertEquals(1L, set.count(FloatPredicates.greaterThan(32.0f)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(FloatPredicates.lessThan(32.0f)));
        Verify.assertSize(4, set.select(FloatPredicates.greaterThan(0.0f)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(FloatPredicates.greaterThan(0.0f)));
        Verify.assertSize(2, set.reject(FloatPredicates.lessThan(32.0f)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0f, set.detectIfNone(FloatPredicates.lessThan(1.0f), 9.0f), 0.0f);
        Assert.assertEquals(AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1), set.detectIfNone(FloatPredicates.greaterThan(AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst()), 9.0f), 0.0f);
        Assert.assertEquals(9.0f, set.detectIfNone(FloatPredicates.greaterThan(AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)), 9.0f), 0.0f);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0f, 0.0f, 30.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1) - 1), set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new float[] { 0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray(), 0.0f);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        ImmutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        ImmutableFloatSet set3 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f);
        ImmutableFloatSet set4 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f, 1.0f);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        ImmutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        ImmutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f), this.newWith(0.0f, 1.0f, 31.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f, 6.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f, 6.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f, 4.0f, 5.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertUnion(ImmutableFloatSet set1, ImmutableFloatSet set2, ImmutableFloatSet expected) {
        ImmutableFloatSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f, 6.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f, 6.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith());
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableFloatSet set1, ImmutableFloatSet set2, ImmutableFloatSet expected) {
        ImmutableFloatSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f));
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith());
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertDifference(ImmutableFloatSet set1, ImmutableFloatSet set2, ImmutableFloatSet expected) {
        ImmutableFloatSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(2.0f, 3.0f, 4.0f), this.newWith(1.0f, 4.0f));
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f, 4.0f, 5.0f));
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertSymmetricDifference(ImmutableFloatSet set1, ImmutableFloatSet set2, ImmutableFloatSet expected) {
        ImmutableFloatSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsSubsetOf(this.newWith(1.0f, 4.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), true);
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableFloatSet set1, ImmutableFloatSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 4.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), true);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableFloatSet set1, ImmutableFloatSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(3.0f, 4.0f), Sets.immutable.with(PrimitiveTuples.pair(1.0f, 3.0f), PrimitiveTuples.pair(1.0f, 4.0f), PrimitiveTuples.pair(2.0f, 3.0f), PrimitiveTuples.pair(2.0f, 4.0f)));
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f), Sets.immutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(1.0f, 2.0f), PrimitiveTuples.pair(2.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)));
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1.0f, 2.0f), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableFloatSet set1, ImmutableFloatSet set2, ImmutableSet<FloatFloatPair> expected) {
        ImmutableSet<FloatFloatPair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableFloatHashSetTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableFloatHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableFloatHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableFloatHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableFloatHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableFloatHashSetTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableFloatHashSetTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableFloatHashSetTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableFloatHashSetTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableFloatHashSetTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableFloatHashSetTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableFloatHashSetTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableFloatHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableFloatHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableFloatHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableFloatHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableFloatHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableFloatHashSetTestCase::containsNoneIterable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableFloatHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableFloatHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableFloatHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableFloatHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableFloatHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableFloatHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableFloatHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableFloatHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableFloatHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableFloatHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableFloatHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableFloatHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableFloatHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableFloatHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableFloatHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableFloatHashSetTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableFloatHashSetTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableFloatHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableFloatHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableFloatHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableFloatHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableFloatHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableFloatHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableFloatHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableFloatHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableFloatHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableFloatHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableFloatHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableFloatHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableFloatHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableFloatHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableFloatHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableFloatHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableFloatHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableFloatHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableFloatHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableFloatHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableFloatHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableFloatHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableFloatHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableFloatHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableFloatHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableFloatHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableFloatHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableFloatHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableFloatHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableFloatHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableFloatHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableFloatHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableFloatHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableFloatHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableFloatHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableFloatHashSetTestCase::toImmutable;
            this.payloads.floatIterator = AbstractImmutableFloatHashSetTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatHashSetTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableFloatHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableFloatHashSetTestCase::count;
            this.payloads.select = AbstractImmutableFloatHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableFloatHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableFloatHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableFloatHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableFloatHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableFloatHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableFloatHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableFloatHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableFloatHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableFloatHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableFloatHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableFloatHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableFloatHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableFloatHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableFloatHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableFloatHashSetTestCase::cartesianProduct;
        }
    }
}
