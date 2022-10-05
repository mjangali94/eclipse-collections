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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase._Benchmark {

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator, this.description("charIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::charIterator_throws, this.description("charIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractImmutableCharHashSetTestCase implementation();
    }
}
