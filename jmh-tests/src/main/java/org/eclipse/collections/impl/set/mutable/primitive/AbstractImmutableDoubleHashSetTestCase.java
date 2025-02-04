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
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableDoubleHashSetTestCase extends AbstractImmutableDoubleCollectionTestCase {

    @Override
    protected abstract ImmutableDoubleSet classUnderTest();

    @Override
    protected abstract ImmutableDoubleSet newWith(double... elements);

    @Override
    protected MutableDoubleSet newMutableCollectionWith(double... elements) {
        return DoubleHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Double> newObjectCollectionWith(Double... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleHashSet set = new DoubleHashSet();
        for (double i = 32.0; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableDoubleSet immutableDoubleSet = this.classUnderTest();
        Assert.assertSame(immutableDoubleSet, immutableDoubleSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableDoubleSet immutableDoubleSet = this.classUnderTest();
        Assert.assertSame(immutableDoubleSet, immutableDoubleSet.toImmutable());
    }

    @Override
    @Test
    public void doubleIterator() {
        MutableSet<Double> expected = UnifiedSet.newSetWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        MutableSet<Double> actual = UnifiedSet.newSet();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        DoubleIterator iterator = set.doubleIterator();
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
    public void doubleIterator_throws() {
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        DoubleIterator iterator = set.doubleIterator();
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
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        set.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1), sum[0], 0.0);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, set.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, set.count(DoublePredicates.greaterThan(32.0)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, set.select(DoublePredicates.greaterThan(0.0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, set.reject(DoublePredicates.lessThan(32.0)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, set.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1), set.detectIfNone(DoublePredicates.greaterThan(AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, set.detectIfNone(DoublePredicates.greaterThan(AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)), 9.0), 0.0);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0, 0.0, 30.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1) - 1), set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new double[] { 0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray(), 0.0);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        ImmutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        ImmutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        ImmutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
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
        ImmutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        ImmutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.classUnderTest().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0), this.newWith(0.0, 1.0, 31.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0, 6.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0, 6.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0, 4.0, 5.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertUnion(ImmutableDoubleSet set1, ImmutableDoubleSet set2, ImmutableDoubleSet expected) {
        ImmutableDoubleSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0, 6.0), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0, 6.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith());
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableDoubleSet set1, ImmutableDoubleSet set2, ImmutableDoubleSet expected) {
        ImmutableDoubleSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0));
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith());
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertDifference(ImmutableDoubleSet set1, ImmutableDoubleSet set2, ImmutableDoubleSet expected) {
        ImmutableDoubleSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(2.0, 3.0, 4.0), this.newWith(1.0, 4.0));
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0, 4.0, 5.0));
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertSymmetricDifference(ImmutableDoubleSet set1, ImmutableDoubleSet set2, ImmutableDoubleSet expected) {
        ImmutableDoubleSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsSubsetOf(this.newWith(1.0, 4.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3.0, 4.0, 5.0), true);
        this.assertIsSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableDoubleSet set1, ImmutableDoubleSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsProperSubsetOf(this.newWith(1.0, 4.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3.0, 4.0, 5.0), true);
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableDoubleSet set1, ImmutableDoubleSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(3.0, 4.0), Sets.immutable.with(PrimitiveTuples.pair(1.0, 3.0), PrimitiveTuples.pair(1.0, 4.0), PrimitiveTuples.pair(2.0, 3.0), PrimitiveTuples.pair(2.0, 4.0)));
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0), Sets.immutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(1.0, 2.0), PrimitiveTuples.pair(2.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)));
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1.0, 2.0), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableDoubleSet set1, ImmutableDoubleSet set2, ImmutableSet<DoubleDoublePair> expected) {
        ImmutableSet<DoubleDoublePair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableDoubleHashSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableDoubleHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableDoubleHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableDoubleHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableDoubleHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableDoubleHashSetTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableDoubleHashSetTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableDoubleHashSetTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableDoubleHashSetTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableDoubleHashSetTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableDoubleHashSetTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableDoubleHashSetTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableDoubleHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableDoubleHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableDoubleHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableDoubleHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableDoubleHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableDoubleHashSetTestCase::containsNoneIterable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableDoubleHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableDoubleHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableDoubleHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableDoubleHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableDoubleHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableDoubleHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableDoubleHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableDoubleHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableDoubleHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableDoubleHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableDoubleHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableDoubleHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableDoubleHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableDoubleHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableDoubleHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableDoubleHashSetTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableDoubleHashSetTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableDoubleHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableDoubleHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableDoubleHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableDoubleHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableDoubleHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableDoubleHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableDoubleHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableDoubleHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableDoubleHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableDoubleHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableDoubleHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableDoubleHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableDoubleHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableDoubleHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableDoubleHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableDoubleHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableDoubleHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableDoubleHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableDoubleHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableDoubleHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableDoubleHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableDoubleHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableDoubleHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableDoubleHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableDoubleHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableDoubleHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableDoubleHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableDoubleHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableDoubleHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableDoubleHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableDoubleHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableDoubleHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableDoubleHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableDoubleHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableDoubleHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableDoubleHashSetTestCase::toImmutable;
            this.payloads.doubleIterator = AbstractImmutableDoubleHashSetTestCase::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleHashSetTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableDoubleHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableDoubleHashSetTestCase::count;
            this.payloads.select = AbstractImmutableDoubleHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableDoubleHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableDoubleHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableDoubleHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableDoubleHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableDoubleHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableDoubleHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableDoubleHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableDoubleHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableDoubleHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableDoubleHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableDoubleHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableDoubleHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableDoubleHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableDoubleHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableDoubleHashSetTestCase::cartesianProduct;
        }
    }
*/
}
