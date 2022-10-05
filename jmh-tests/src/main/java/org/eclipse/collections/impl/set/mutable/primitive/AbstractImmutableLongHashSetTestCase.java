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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::freeze, this.description("freeze"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::longIterator_throws, this.description("longIterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testHashCode, this.description("testHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::union, this.description("union"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersect, this.description("intersect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::difference, this.description("difference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifference, this.description("symmetricDifference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isSubsetOf, this.description("isSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isProperSubsetOf, this.description("isProperSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProduct, this.description("cartesianProduct"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableLongHashSetTestCase implementation();
    }
}
