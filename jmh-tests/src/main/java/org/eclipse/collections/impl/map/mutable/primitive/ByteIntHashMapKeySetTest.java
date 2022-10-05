/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractByteSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteIntHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitivePrimitiveHashMapKeySetTest.stg.
 */
public class ByteIntHashMapKeySetTest extends AbstractByteSetTestCase {

    @Override
    protected MutableByteSet classUnderTest() {
        return ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3).keySet();
    }

    @Override
    protected MutableByteSet newWith(byte... elements) {
        ByteIntHashMap map = new ByteIntHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((byte) 0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new ByteArrayList());
    }

    @Override
    public void testEquals() {
        MutableByteSet set1 = this.newWith((byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set3 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set4 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1, (byte) 1);
        MutableByteSet set5 = this.newWith((byte) 32, (byte) 1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
        Assert.assertNotEquals(set1, set5);
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1, (byte) 2).noneSatisfy(BytePredicates.equal((byte) 0)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 2).sum());
    }

    @Override
    public void testHashCode() {
        MutableByteSet set1 = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1, (byte) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).hashCode(), set1.hashCode());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteIntHashMapKeySetTest instance;

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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
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
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ByteIntHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> isCartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIntHashMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteIntHashMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ByteIntHashMapKeySetTest::newCollection;
            this.payloads.tap = ByteIntHashMapKeySetTest::tap;
            this.payloads.containsAllArray = ByteIntHashMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ByteIntHashMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteIntHashMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteIntHashMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteIntHashMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteIntHashMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = ByteIntHashMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ByteIntHashMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = ByteIntHashMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteIntHashMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteIntHashMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteIntHashMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteIntHashMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ByteIntHashMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ByteIntHashMapKeySetTest::rejectWithTarget;
            this.payloads.max = ByteIntHashMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteIntHashMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteIntHashMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteIntHashMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = ByteIntHashMapKeySetTest::summaryStatistics;
            this.payloads.average = ByteIntHashMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteIntHashMapKeySetTest::averageIfEmpty;
            this.payloads.median = ByteIntHashMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteIntHashMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ByteIntHashMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteIntHashMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ByteIntHashMapKeySetTest::testToString;
            this.payloads.makeString = ByteIntHashMapKeySetTest::makeString;
            this.payloads.appendString = ByteIntHashMapKeySetTest::appendString;
            this.payloads.toList = ByteIntHashMapKeySetTest::toList;
            this.payloads.toSortedList = ByteIntHashMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteIntHashMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteIntHashMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteIntHashMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteIntHashMapKeySetTest::toSet;
            this.payloads.injectInto = ByteIntHashMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ByteIntHashMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteIntHashMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteIntHashMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteIntHashMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteIntHashMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteIntHashMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteIntHashMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteIntHashMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteIntHashMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ByteIntHashMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ByteIntHashMapKeySetTest::chunk;
            this.payloads.contains = ByteIntHashMapKeySetTest::contains;
            this.payloads.removeIf = ByteIntHashMapKeySetTest::removeIf;
            this.payloads.retainAll = ByteIntHashMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = ByteIntHashMapKeySetTest::retainAll_iterable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = ByteIntHashMapKeySetTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = ByteIntHashMapKeySetTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ByteIntHashMapKeySetTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteIntHashMapKeySetTest::newEmpty;
            this.payloads.size = ByteIntHashMapKeySetTest::size;
            this.payloads.isEmpty = ByteIntHashMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ByteIntHashMapKeySetTest::notEmpty;
            this.payloads.clear = ByteIntHashMapKeySetTest::clear;
            this.payloads.remove = ByteIntHashMapKeySetTest::remove;
            this.payloads.removeAll = ByteIntHashMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = ByteIntHashMapKeySetTest::removeAll_iterable;
            this.payloads.byteIterator = ByteIntHashMapKeySetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteIntHashMapKeySetTest::forEach;
            this.payloads.count = ByteIntHashMapKeySetTest::count;
            this.payloads.select = ByteIntHashMapKeySetTest::select;
            this.payloads.reject = ByteIntHashMapKeySetTest::reject;
            this.payloads.detectIfNone = ByteIntHashMapKeySetTest::detectIfNone;
            this.payloads.collect = ByteIntHashMapKeySetTest::collect;
            this.payloads.toSortedArray = ByteIntHashMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ByteIntHashMapKeySetTest::testEquals;
            this.payloads.testHashCode = ByteIntHashMapKeySetTest::testHashCode;
            this.payloads.toBag = ByteIntHashMapKeySetTest::toBag;
            this.payloads.asLazy = ByteIntHashMapKeySetTest::asLazy;
            this.payloads.asSynchronized = ByteIntHashMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteIntHashMapKeySetTest::asUnmodifiable;
            this.payloads.classIsNonInstantiable = ByteIntHashMapKeySetTest::classIsNonInstantiable;
            this.payloads.union = ByteIntHashMapKeySetTest::union;
            this.payloads.intersect = ByteIntHashMapKeySetTest::intersect;
            this.payloads.difference = ByteIntHashMapKeySetTest::difference;
            this.payloads.symmetricDifference = ByteIntHashMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ByteIntHashMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ByteIntHashMapKeySetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = ByteIntHashMapKeySetTest::isCartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteIntHashMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = ByteIntHashMapKeySetTest::noneSatisfy;
            this.payloads.sum = ByteIntHashMapKeySetTest::sum;
        }
    }
}
