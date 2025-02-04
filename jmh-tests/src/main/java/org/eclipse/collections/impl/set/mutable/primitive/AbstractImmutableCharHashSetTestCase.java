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
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableCharHashSetTestCase extends AbstractImmutableCharCollectionTestCase {

    @Override
    protected abstract ImmutableCharSet classUnderTest();

    @Override
    protected abstract ImmutableCharSet newWith(char... elements);

    @Override
    protected MutableCharSet newMutableCollectionWith(char... elements) {
        return CharHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Character> newObjectCollectionWith(Character... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharHashSet set = new CharHashSet();
        for (char i = (char) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((char) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze() {
        ImmutableCharSet immutableCharSet = this.classUnderTest();
        Assert.assertSame(immutableCharSet, immutableCharSet.freeze());
    }

    @Test
    public void toImmutable() {
        ImmutableCharSet immutableCharSet = this.classUnderTest();
        Assert.assertSame(immutableCharSet, immutableCharSet.toImmutable());
    }

    @Override
    @Test
    public void charIterator() {
        MutableSet<Character> expected = UnifiedSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        MutableSet<Character> actual = UnifiedSet.newSet();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        CharIterator iterator = set.charIterator();
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
    public void charIterator_throws() {
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        CharIterator iterator = set.charIterator();
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
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        set.forEach((char each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableCharHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(CharPredicates.greaterThan((char) 0)));
        Assert.assertEquals(3L, set.count(CharPredicates.lessThan((char) 32)));
        Assert.assertEquals(1L, set.count(CharPredicates.greaterThan((char) 32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(CharPredicates.lessThan((char) 32)));
        Verify.assertSize(4, set.select(CharPredicates.greaterThan((char) 0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(CharPredicates.greaterThan((char) 0)));
        Verify.assertSize(2, set.reject(CharPredicates.lessThan((char) 32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, set.detectIfNone(CharPredicates.lessThan((char) 1), (char) 9));
        Assert.assertEquals(AbstractImmutableCharHashSetTestCase.generateCollisions().get(1), set.detectIfNone(CharPredicates.greaterThan(AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst()), (char) 9));
        Assert.assertEquals((char) 9, set.detectIfNone(CharPredicates.greaterThan(AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)), (char) 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((char) -1, (char) 0, (char) 30, (char) (AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst() - 1), (char) (AbstractImmutableCharHashSetTestCase.generateCollisions().get(1) - 1)), set.collect(byteParameter -> (char) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new char[] { (char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        ImmutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        ImmutableCharSet set3 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1);
        ImmutableCharSet set4 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1, (char) 1);
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
        ImmutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        ImmutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31), this.newWith((char) 0, (char) 1, (char) 31).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, set.asLazy());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3, (char) 6), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5, (char) 6), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3, (char) 4, (char) 5));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertUnion(ImmutableCharSet set1, ImmutableCharSet set2, ImmutableCharSet expected) {
        ImmutableCharSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3));
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3, (char) 6), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3));
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5, (char) 6), this.newWith((char) 3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith());
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(ImmutableCharSet set1, ImmutableCharSet set2, ImmutableCharSet expected) {
        ImmutableCharSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2));
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith());
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertDifference(ImmutableCharSet set1, ImmutableCharSet set2, ImmutableCharSet expected) {
        ImmutableCharSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 2, (char) 3, (char) 4), this.newWith((char) 1, (char) 4));
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3, (char) 4, (char) 5));
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertSymmetricDifference(ImmutableCharSet set1, ImmutableCharSet set2, ImmutableCharSet expected) {
        ImmutableCharSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 4), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), true);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(ImmutableCharSet set1, ImmutableCharSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 4), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), true);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(ImmutableCharSet set1, ImmutableCharSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith((char) 3, (char) 4), Sets.immutable.with(PrimitiveTuples.pair((char) 1, (char) 3), PrimitiveTuples.pair((char) 1, (char) 4), PrimitiveTuples.pair((char) 2, (char) 3), PrimitiveTuples.pair((char) 2, (char) 4)));
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2), Sets.immutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 1, (char) 2), PrimitiveTuples.pair((char) 2, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)));
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith(), Sets.immutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith((char) 1, (char) 2), Sets.immutable.empty());
    }

    private void assertCartesianProduct(ImmutableCharSet set1, ImmutableCharSet set2, ImmutableSet<CharCharPair> expected) {
        ImmutableSet<CharCharPair> actual = set1.cartesianProduct(set2).toSet().toImmutable();
        Assert.assertEquals(expected, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableCharHashSetTestCase instance;

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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableCharHashSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharHashSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableCharHashSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableCharHashSetTestCase::newCollection;
            this.payloads.tap = AbstractImmutableCharHashSetTestCase::tap;
            this.payloads.contains = AbstractImmutableCharHashSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableCharHashSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableCharHashSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableCharHashSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableCharHashSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableCharHashSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableCharHashSetTestCase::containsNoneIterable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = AbstractImmutableCharHashSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableCharHashSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableCharHashSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractImmutableCharHashSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableCharHashSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableCharHashSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableCharHashSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableCharHashSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractImmutableCharHashSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractImmutableCharHashSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableCharHashSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableCharHashSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableCharHashSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableCharHashSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableCharHashSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableCharHashSetTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableCharHashSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableCharHashSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableCharHashSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableCharHashSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableCharHashSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableCharHashSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractImmutableCharHashSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableCharHashSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableCharHashSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableCharHashSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableCharHashSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableCharHashSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableCharHashSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableCharHashSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableCharHashSetTestCase::toSet;
            this.payloads.injectInto = AbstractImmutableCharHashSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableCharHashSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableCharHashSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableCharHashSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableCharHashSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableCharHashSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableCharHashSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableCharHashSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableCharHashSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableCharHashSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableCharHashSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableCharHashSetTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableCharHashSetTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableCharHashSetTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableCharHashSetTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableCharHashSetTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableCharHashSetTestCase::size;
            this.payloads.isEmpty = AbstractImmutableCharHashSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableCharHashSetTestCase::notEmpty;
            this.payloads.freeze = AbstractImmutableCharHashSetTestCase::freeze;
            this.payloads.toImmutable = AbstractImmutableCharHashSetTestCase::toImmutable;
            this.payloads.charIterator = AbstractImmutableCharHashSetTestCase::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharHashSetTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableCharHashSetTestCase::forEach;
            this.payloads.count = AbstractImmutableCharHashSetTestCase::count;
            this.payloads.select = AbstractImmutableCharHashSetTestCase::select;
            this.payloads.reject = AbstractImmutableCharHashSetTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableCharHashSetTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableCharHashSetTestCase::collect;
            this.payloads.toSortedArray = AbstractImmutableCharHashSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableCharHashSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableCharHashSetTestCase::testHashCode;
            this.payloads.toBag = AbstractImmutableCharHashSetTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableCharHashSetTestCase::asLazy;
            this.payloads.union = AbstractImmutableCharHashSetTestCase::union;
            this.payloads.intersect = AbstractImmutableCharHashSetTestCase::intersect;
            this.payloads.difference = AbstractImmutableCharHashSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractImmutableCharHashSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractImmutableCharHashSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableCharHashSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractImmutableCharHashSetTestCase::cartesianProduct;
        }
    }
*/
}
