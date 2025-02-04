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
 * JUnit test for {@link ByteCharHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitivePrimitiveHashMapKeySetTest.stg.
 */
public class ByteCharHashMapKeySetTest extends AbstractByteSetTestCase {

    @Override
    protected MutableByteSet classUnderTest() {
        return ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3).keySet();
    }

    @Override
    protected MutableByteSet newWith(byte... elements) {
        ByteCharHashMap map = new ByteCharHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (char) i);
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

        private ByteCharHashMapKeySetTest instance;

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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
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
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ByteCharHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> isCartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteCharHashMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ByteCharHashMapKeySetTest::newCollection;
            this.payloads.tap = ByteCharHashMapKeySetTest::tap;
            this.payloads.containsAllArray = ByteCharHashMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ByteCharHashMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteCharHashMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteCharHashMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteCharHashMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteCharHashMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = ByteCharHashMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ByteCharHashMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = ByteCharHashMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteCharHashMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteCharHashMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteCharHashMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteCharHashMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ByteCharHashMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ByteCharHashMapKeySetTest::rejectWithTarget;
            this.payloads.max = ByteCharHashMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteCharHashMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteCharHashMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteCharHashMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = ByteCharHashMapKeySetTest::summaryStatistics;
            this.payloads.average = ByteCharHashMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteCharHashMapKeySetTest::averageIfEmpty;
            this.payloads.median = ByteCharHashMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteCharHashMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ByteCharHashMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteCharHashMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ByteCharHashMapKeySetTest::testToString;
            this.payloads.makeString = ByteCharHashMapKeySetTest::makeString;
            this.payloads.appendString = ByteCharHashMapKeySetTest::appendString;
            this.payloads.toList = ByteCharHashMapKeySetTest::toList;
            this.payloads.toSortedList = ByteCharHashMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteCharHashMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteCharHashMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteCharHashMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteCharHashMapKeySetTest::toSet;
            this.payloads.injectInto = ByteCharHashMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ByteCharHashMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteCharHashMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteCharHashMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteCharHashMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteCharHashMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteCharHashMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteCharHashMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteCharHashMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteCharHashMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ByteCharHashMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ByteCharHashMapKeySetTest::chunk;
            this.payloads.contains = ByteCharHashMapKeySetTest::contains;
            this.payloads.removeIf = ByteCharHashMapKeySetTest::removeIf;
            this.payloads.retainAll = ByteCharHashMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = ByteCharHashMapKeySetTest::retainAll_iterable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = ByteCharHashMapKeySetTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = ByteCharHashMapKeySetTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ByteCharHashMapKeySetTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteCharHashMapKeySetTest::newEmpty;
            this.payloads.size = ByteCharHashMapKeySetTest::size;
            this.payloads.isEmpty = ByteCharHashMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ByteCharHashMapKeySetTest::notEmpty;
            this.payloads.clear = ByteCharHashMapKeySetTest::clear;
            this.payloads.remove = ByteCharHashMapKeySetTest::remove;
            this.payloads.removeAll = ByteCharHashMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = ByteCharHashMapKeySetTest::removeAll_iterable;
            this.payloads.byteIterator = ByteCharHashMapKeySetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteCharHashMapKeySetTest::forEach;
            this.payloads.count = ByteCharHashMapKeySetTest::count;
            this.payloads.select = ByteCharHashMapKeySetTest::select;
            this.payloads.reject = ByteCharHashMapKeySetTest::reject;
            this.payloads.detectIfNone = ByteCharHashMapKeySetTest::detectIfNone;
            this.payloads.collect = ByteCharHashMapKeySetTest::collect;
            this.payloads.toSortedArray = ByteCharHashMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ByteCharHashMapKeySetTest::testEquals;
            this.payloads.testHashCode = ByteCharHashMapKeySetTest::testHashCode;
            this.payloads.toBag = ByteCharHashMapKeySetTest::toBag;
            this.payloads.asLazy = ByteCharHashMapKeySetTest::asLazy;
            this.payloads.asSynchronized = ByteCharHashMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteCharHashMapKeySetTest::asUnmodifiable;
            this.payloads.classIsNonInstantiable = ByteCharHashMapKeySetTest::classIsNonInstantiable;
            this.payloads.union = ByteCharHashMapKeySetTest::union;
            this.payloads.intersect = ByteCharHashMapKeySetTest::intersect;
            this.payloads.difference = ByteCharHashMapKeySetTest::difference;
            this.payloads.symmetricDifference = ByteCharHashMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ByteCharHashMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ByteCharHashMapKeySetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = ByteCharHashMapKeySetTest::isCartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = ByteCharHashMapKeySetTest::noneSatisfy;
            this.payloads.sum = ByteCharHashMapKeySetTest::sum;
        }
    }
}
