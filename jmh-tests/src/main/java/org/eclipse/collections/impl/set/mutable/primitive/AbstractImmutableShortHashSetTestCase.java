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
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableShortCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableShortHashSetTestCase extends AbstractImmutableShortCollectionTestCase {

    @Override
    protected abstract ImmutableShortSet classUnderTest();

    @Override
    protected abstract ImmutableShortSet newWith(short... elements);

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements) {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((short) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableShortSet immutableShortSet = this.classUnderTest();
        Assert.assertSame(immutableShortSet, immutableShortSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableShortSet immutableShortSet = this.classUnderTest();
        Assert.assertSame(immutableShortSet, immutableShortSet.toImmutable());
    }

    @Override
    @Test
    public void shortIterator() {
        MutableSet<Short> expected = UnifiedSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        MutableSet<Short> actual = UnifiedSet.newSet();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        ShortIterator iterator = set.shortIterator();
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
    public void shortIterator_throws() {
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        ShortIterator iterator = set.shortIterator();
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
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        set.forEach((short each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableShortHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(3L, set.count(ShortPredicates.lessThan((short) 32)));
        Assert.assertEquals(1L, set.count(ShortPredicates.greaterThan((short) 32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(ShortPredicates.lessThan((short) 32)));
        Verify.assertSize(4, set.select(ShortPredicates.greaterThan((short) 0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertSize(2, set.reject(ShortPredicates.lessThan((short) 32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals((short) 0, set.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 9));
        Assert.assertEquals(AbstractImmutableShortHashSetTestCase.generateCollisions().get(1), set.detectIfNone(ShortPredicates.greaterThan(AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst()), (short) 9));
        Assert.assertEquals((short) 9, set.detectIfNone(ShortPredicates.greaterThan(AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)), (short) 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((short) -1, (short) 0, (short) 30, (short) (AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst() - 1), (short) (AbstractImmutableShortHashSetTestCase.generateCollisions().get(1) - 1)), set.collect(byteParameter -> (short) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new short[] { (short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        ImmutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        ImmutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        ImmutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
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
        ImmutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        ImmutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 1, (short) 31).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3, (short) 6), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5, (short) 6), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3, (short) 4, (short) 5));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertUnion(ImmutableShortSet set1, ImmutableShortSet set2, ImmutableShortSet expected) {
        ImmutableShortSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3));
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3, (short) 6), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3));
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5, (short) 6), this.newWith((short) 3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith());
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableShortSet set1, ImmutableShortSet set2, ImmutableShortSet expected) {
        ImmutableShortSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2));
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith());
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertDifference(ImmutableShortSet set1, ImmutableShortSet set2, ImmutableShortSet expected) {
        ImmutableShortSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 2, (short) 3, (short) 4), this.newWith((short) 1, (short) 4));
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3, (short) 4, (short) 5));
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertSymmetricDifference(ImmutableShortSet set1, ImmutableShortSet set2, ImmutableShortSet expected) {
        ImmutableShortSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 4), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), true);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableShortSet set1, ImmutableShortSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 4), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), true);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableShortSet set1, ImmutableShortSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith((short) 3, (short) 4), Sets.immutable.with(PrimitiveTuples.pair((short) 1, (short) 3), PrimitiveTuples.pair((short) 1, (short) 4), PrimitiveTuples.pair((short) 2, (short) 3), PrimitiveTuples.pair((short) 2, (short) 4)));
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2), Sets.immutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 1, (short) 2), PrimitiveTuples.pair((short) 2, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)));
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith((short) 1, (short) 2), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableShortSet set1, ImmutableShortSet set2, ImmutableSet<ShortShortPair> expected) {
        ImmutableSet<ShortShortPair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableShortHashSetTestCase instance;

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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableShortHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableShortHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableShortHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableShortHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableShortHashSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableShortHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableShortHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableShortHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableShortHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableShortHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableShortHashSetTestCase::containsNoneIterable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableShortHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableShortHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableShortHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableShortHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableShortHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableShortHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableShortHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableShortHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableShortHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableShortHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableShortHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableShortHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableShortHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableShortHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableShortHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableShortHashSetTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableShortHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableShortHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableShortHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableShortHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableShortHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableShortHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableShortHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableShortHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableShortHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableShortHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableShortHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableShortHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableShortHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableShortHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableShortHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableShortHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableShortHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableShortHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableShortHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableShortHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableShortHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableShortHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableShortHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableShortHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableShortHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableShortHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableShortHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableShortHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableShortHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableShortHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableShortHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableShortHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableShortHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableShortHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableShortHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableShortHashSetTestCase::toImmutable;
            this.payloads.shortIterator = AbstractImmutableShortHashSetTestCase::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortHashSetTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableShortHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableShortHashSetTestCase::count;
            this.payloads.select = AbstractImmutableShortHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableShortHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableShortHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableShortHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableShortHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableShortHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableShortHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableShortHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableShortHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableShortHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableShortHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableShortHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableShortHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableShortHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableShortHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableShortHashSetTestCase::cartesianProduct;
        }
    }
}
