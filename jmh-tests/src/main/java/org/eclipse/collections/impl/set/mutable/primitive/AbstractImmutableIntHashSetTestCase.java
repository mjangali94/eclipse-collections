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
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableIntCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableIntHashSetTestCase extends AbstractImmutableIntCollectionTestCase {

    @Override
    protected abstract ImmutableIntSet classUnderTest();

    @Override
    protected abstract ImmutableIntSet newWith(int... elements);

    @Override
    protected MutableIntSet newMutableCollectionWith(int... elements) {
        return IntHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Integer> newObjectCollectionWith(Integer... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntHashSet set = new IntHashSet();
        for (int i = 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableIntSet immutableIntSet = this.classUnderTest();
        Assert.assertSame(immutableIntSet, immutableIntSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableIntSet immutableIntSet = this.classUnderTest();
        Assert.assertSame(immutableIntSet, immutableIntSet.toImmutable());
    }

    @Override
    @Test
    public void intIterator() {
        MutableSet<Integer> expected = UnifiedSet.newSetWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        MutableSet<Integer> actual = UnifiedSet.newSet();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        IntIterator iterator = set.intIterator();
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
    public void intIterator_throws() {
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        IntIterator iterator = set.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        set.forEach((int each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableIntHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(IntPredicates.greaterThan(0)));
        Assert.assertEquals(3L, set.count(IntPredicates.lessThan(32)));
        Assert.assertEquals(1L, set.count(IntPredicates.greaterThan(32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(IntPredicates.lessThan(32)));
        Verify.assertSize(4, set.select(IntPredicates.greaterThan(0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(IntPredicates.greaterThan(0)));
        Verify.assertSize(2, set.reject(IntPredicates.lessThan(32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0, set.detectIfNone(IntPredicates.lessThan(1), 9));
        Assert.assertEquals(AbstractImmutableIntHashSetTestCase.generateCollisions().get(1), set.detectIfNone(IntPredicates.greaterThan(AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst()), 9));
        Assert.assertEquals(9, set.detectIfNone(IntPredicates.greaterThan(AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)), 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1, 0, 30, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableIntHashSetTestCase.generateCollisions().get(1) - 1), set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new int[] { 0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableIntSet set1 = this.newWith(1, 31, 32);
        ImmutableIntSet set2 = this.newWith(32, 31, 1);
        ImmutableIntSet set3 = this.newWith(32, 32, 31, 1);
        ImmutableIntSet set4 = this.newWith(32, 32, 31, 1, 1);
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
        ImmutableIntSet set1 = this.newWith(1, 31, 32);
        ImmutableIntSet set2 = this.newWith(32, 31, 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.classUnderTest().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31), this.newWith(0, 1, 31).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(1, 2, 3, 4, 5));
        this.assertUnion(this.newWith(1, 2, 3, 6), this.newWith(3, 4, 5), this.newWith(1, 2, 3, 4, 5, 6));
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(3, 4, 5, 6), this.newWith(1, 2, 3, 4, 5, 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3, 4, 5), this.newWith(3, 4, 5));
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertUnion(ImmutableIntSet set1, ImmutableIntSet set2, ImmutableIntSet expected) {
        ImmutableIntSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(3));
        this.assertIntersect(this.newWith(1, 2, 3, 6), this.newWith(3, 4, 5), this.newWith(3));
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(3, 4, 5, 6), this.newWith(3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3, 4, 5), this.newWith());
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableIntSet set1, ImmutableIntSet set2, ImmutableIntSet expected) {
        ImmutableIntSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(1, 2));
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(1, 2, 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3, 4, 5), this.newWith());
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertDifference(ImmutableIntSet set1, ImmutableIntSet set2, ImmutableIntSet expected) {
        ImmutableIntSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(2, 3, 4), this.newWith(1, 4));
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(1, 2, 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3, 4, 5), this.newWith(3, 4, 5));
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertSymmetricDifference(ImmutableIntSet set1, ImmutableIntSet set2, ImmutableIntSet expected) {
        ImmutableIntSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1, 2), this.newWith(1, 2, 3), true);
        this.assertIsSubsetOf(this.newWith(1, 4), this.newWith(1, 2, 3), false);
        this.assertIsSubsetOf(this.newWith(1, 2, 3), this.newWith(1, 2, 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3, 4, 5), true);
        this.assertIsSubsetOf(this.newWith(1, 2, 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableIntSet set1, ImmutableIntSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1, 2), this.newWith(1, 2, 3), true);
        this.assertIsProperSubsetOf(this.newWith(1, 4), this.newWith(1, 2, 3), false);
        this.assertIsProperSubsetOf(this.newWith(1, 2, 3), this.newWith(1, 2, 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3, 4, 5), true);
        this.assertIsProperSubsetOf(this.newWith(1, 2, 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableIntSet set1, ImmutableIntSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(3, 4), Sets.immutable.with(PrimitiveTuples.pair(1, 3), PrimitiveTuples.pair(1, 4), PrimitiveTuples.pair(2, 3), PrimitiveTuples.pair(2, 4)));
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(1, 2), Sets.immutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(1, 2), PrimitiveTuples.pair(2, 1), PrimitiveTuples.pair(2, 2)));
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1, 2), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableIntSet set1, ImmutableIntSet set2, ImmutableSet<IntIntPair> expected) {
        ImmutableSet<IntIntPair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableIntHashSetTestCase instance;

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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableIntHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableIntHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableIntHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableIntHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableIntHashSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableIntHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableIntHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableIntHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableIntHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableIntHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableIntHashSetTestCase::containsNoneIterable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableIntHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableIntHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableIntHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableIntHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableIntHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableIntHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableIntHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableIntHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableIntHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableIntHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableIntHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableIntHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableIntHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableIntHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableIntHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableIntHashSetTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableIntHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableIntHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableIntHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableIntHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableIntHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableIntHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableIntHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableIntHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableIntHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableIntHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableIntHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableIntHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableIntHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableIntHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableIntHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableIntHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableIntHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableIntHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableIntHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableIntHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableIntHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableIntHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableIntHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableIntHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableIntHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableIntHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableIntHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableIntHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableIntHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableIntHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableIntHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableIntHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableIntHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableIntHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableIntHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableIntHashSetTestCase::toImmutable;
            this.payloads.intIterator = AbstractImmutableIntHashSetTestCase::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntHashSetTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableIntHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableIntHashSetTestCase::count;
            this.payloads.select = AbstractImmutableIntHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableIntHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableIntHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableIntHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableIntHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableIntHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableIntHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableIntHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableIntHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableIntHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableIntHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableIntHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableIntHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableIntHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableIntHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableIntHashSetTestCase::cartesianProduct;
        }
    }
}
