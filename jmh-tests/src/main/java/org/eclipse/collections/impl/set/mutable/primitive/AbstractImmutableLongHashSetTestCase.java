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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableLongHashSetTestCase extends AbstractImmutableLongCollectionTestCase {

    @Override
    protected abstract ImmutableLongSet classUnderTest();

    @Override
    protected abstract ImmutableLongSet newWith(long... elements);

    @Override
    protected MutableLongSet newMutableCollectionWith(long... elements) {
        return LongHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Long> newObjectCollectionWith(Long... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongHashSet set = new LongHashSet();
        for (long i = 32L; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32L)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableLongSet immutableLongSet = this.classUnderTest();
        Assert.assertSame(immutableLongSet, immutableLongSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableLongSet immutableLongSet = this.classUnderTest();
        Assert.assertSame(immutableLongSet, immutableLongSet.toImmutable());
    }

    @Override
    @Test
    public void longIterator() {
        MutableSet<Long> expected = UnifiedSet.newSetWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        MutableSet<Long> actual = UnifiedSet.newSet();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        LongIterator iterator = set.longIterator();
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
    public void longIterator_throws() {
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        LongIterator iterator = set.longIterator();
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
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        set.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableLongHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(LongPredicates.greaterThan(0L)));
        Assert.assertEquals(3L, set.count(LongPredicates.lessThan(32L)));
        Assert.assertEquals(1L, set.count(LongPredicates.greaterThan(32L)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(LongPredicates.lessThan(32L)));
        Verify.assertSize(4, set.select(LongPredicates.greaterThan(0L)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(LongPredicates.greaterThan(0L)));
        Verify.assertSize(2, set.reject(LongPredicates.lessThan(32L)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, set.detectIfNone(LongPredicates.lessThan(1L), 9L));
        Assert.assertEquals(AbstractImmutableLongHashSetTestCase.generateCollisions().get(1), set.detectIfNone(LongPredicates.greaterThan(AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst()), 9L));
        Assert.assertEquals(9L, set.detectIfNone(LongPredicates.greaterThan(AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)), 9L));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1L, 0L, 30L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableLongHashSetTestCase.generateCollisions().get(1) - 1), set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new long[] { 0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableLongSet set1 = this.newWith(1L, 31L, 32L);
        ImmutableLongSet set2 = this.newWith(32L, 31L, 1L);
        ImmutableLongSet set3 = this.newWith(32L, 32L, 31L, 1L);
        ImmutableLongSet set4 = this.newWith(32L, 32L, 31L, 1L, 1L);
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
        ImmutableLongSet set1 = this.newWith(1L, 31L, 32L);
        ImmutableLongSet set2 = this.newWith(32L, 31L, 1L);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.classUnderTest().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L), this.newWith(0L, 1L, 31L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L, 3L, 4L, 5L));
        this.assertUnion(this.newWith(1L, 2L, 3L, 6L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L, 3L, 4L, 5L, 6L));
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L, 6L), this.newWith(1L, 2L, 3L, 4L, 5L, 6L));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith(3L, 4L, 5L));
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertUnion(ImmutableLongSet set1, ImmutableLongSet set2, ImmutableLongSet expected) {
        ImmutableLongSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(3L));
        this.assertIntersect(this.newWith(1L, 2L, 3L, 6L), this.newWith(3L, 4L, 5L), this.newWith(3L));
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L, 6L), this.newWith(3L));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith());
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableLongSet set1, ImmutableLongSet set2, ImmutableLongSet expected) {
        ImmutableLongSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L));
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith());
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertDifference(ImmutableLongSet set1, ImmutableLongSet set2, ImmutableLongSet expected) {
        ImmutableLongSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(2L, 3L, 4L), this.newWith(1L, 4L));
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith(3L, 4L, 5L));
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertSymmetricDifference(ImmutableLongSet set1, ImmutableLongSet set2, ImmutableLongSet expected) {
        ImmutableLongSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1L, 2L), this.newWith(1L, 2L, 3L), true);
        this.assertIsSubsetOf(this.newWith(1L, 4L), this.newWith(1L, 2L, 3L), false);
        this.assertIsSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3L, 4L, 5L), true);
        this.assertIsSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableLongSet set1, ImmutableLongSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1L, 2L), this.newWith(1L, 2L, 3L), true);
        this.assertIsProperSubsetOf(this.newWith(1L, 4L), this.newWith(1L, 2L, 3L), false);
        this.assertIsProperSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3L, 4L, 5L), true);
        this.assertIsProperSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableLongSet set1, ImmutableLongSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(3L, 4L), Sets.immutable.with(PrimitiveTuples.pair(1L, 3L), PrimitiveTuples.pair(1L, 4L), PrimitiveTuples.pair(2L, 3L), PrimitiveTuples.pair(2L, 4L)));
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(1L, 2L), Sets.immutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(1L, 2L), PrimitiveTuples.pair(2L, 1L), PrimitiveTuples.pair(2L, 2L)));
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1L, 2L), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableLongSet set1, ImmutableLongSet set2, ImmutableSet<LongLongPair> expected) {
        ImmutableSet<LongLongPair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableLongHashSetTestCase instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableLongHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableLongHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableLongHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableLongHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableLongHashSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableLongHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableLongHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableLongHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableLongHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableLongHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableLongHashSetTestCase::containsNoneIterable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableLongHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableLongHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableLongHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableLongHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableLongHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableLongHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableLongHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableLongHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableLongHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableLongHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableLongHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableLongHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableLongHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableLongHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableLongHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableLongHashSetTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableLongHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableLongHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableLongHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableLongHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableLongHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableLongHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableLongHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableLongHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableLongHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableLongHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableLongHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableLongHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableLongHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableLongHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableLongHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableLongHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableLongHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableLongHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableLongHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableLongHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableLongHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableLongHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableLongHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableLongHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableLongHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableLongHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableLongHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableLongHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableLongHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableLongHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableLongHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableLongHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableLongHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableLongHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableLongHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableLongHashSetTestCase::toImmutable;
            this.payloads.longIterator = AbstractImmutableLongHashSetTestCase::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongHashSetTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableLongHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableLongHashSetTestCase::count;
            this.payloads.select = AbstractImmutableLongHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableLongHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableLongHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableLongHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableLongHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableLongHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableLongHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableLongHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableLongHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableLongHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableLongHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableLongHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableLongHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableLongHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableLongHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableLongHashSetTestCase::cartesianProduct;
        }
    }
}
