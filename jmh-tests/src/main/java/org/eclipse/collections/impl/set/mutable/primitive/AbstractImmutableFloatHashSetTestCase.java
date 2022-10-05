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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase._Benchmark {

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::floatIterator_throws, this.description("floatIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractImmutableFloatHashSetTestCase implementation();
    }
}
