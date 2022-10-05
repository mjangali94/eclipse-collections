/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableByteEmptyListTest extends AbstractImmutableByteListTestCase {

    @Override
    protected ImmutableByteList classUnderTest() {
        return ImmutableByteEmptyList.INSTANCE;
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        this.classUnderTest().get(1);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableByteCollection emptyCollection = this.classUnderTest();
        ImmutableByteCollection newCollection = emptyCollection.newWithout((byte) 9);
        Assert.assertEquals(this.newMutableCollectionWith(), newCollection);
        Assert.assertSame(emptyCollection, newCollection);
        Assert.assertEquals(this.newMutableCollectionWith(), emptyCollection);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast() {
        this.classUnderTest().getLast();
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void select() {
        super.select();
        ByteIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(BytePredicates.lessThan((byte) 4)));
        ByteIterable byteIterable = iterable.select(BytePredicates.greaterThan((byte) 4));
        Verify.assertEmpty(byteIterable);
        Assert.assertSame(iterable, byteIterable);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ByteIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(BytePredicates.lessThan((byte) 4)));
        ByteIterable byteIterable = iterable.reject(BytePredicates.greaterThan((byte) 4));
        Verify.assertEmpty(byteIterable);
        Assert.assertSame(iterable, byteIterable);
    }

    @Override
    @Test
    public void testEquals() {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((byte) 1));
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average() {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void averageIfEmpty() {
        Assert.assertEquals(1.2, this.classUnderTest().averageIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median() {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void medianIfEmpty() {
        Assert.assertEquals(1.2, this.classUnderTest().medianIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min();
    }

    @Test
    public void dotProduct() {
        ImmutableByteEmptyList list1 = new ImmutableByteEmptyList();
        ImmutableByteEmptyList list2 = new ImmutableByteEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableByteEmptyList list1 = new ImmutableByteEmptyList();
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableByteEmptyList iterable = new ImmutableByteEmptyList();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex() {
        ImmutableByteList list1 = this.newWith();
        ImmutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = list1.injectIntoWithIndex(new MutableByte((byte) 0), (MutableByte object, byte value, int index) -> object.add((byte) (value * list2.get(index))));
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }

    @Override
    @Test
    public void toReversed() {
        Assert.assertEquals(ByteLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((byte each, int index) -> sum[0] += each + index);
        Assert.assertEquals(0, sum[0], (byte) 0);
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) -1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteEmptyListTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
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
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct_throwsOnListsOfDifferentSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteEmptyListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteEmptyListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableByteEmptyListTest::newCollectionWith;
            this.payloads.newCollection = ImmutableByteEmptyListTest::newCollection;
            this.payloads.tap = ImmutableByteEmptyListTest::tap;
            this.payloads.contains = ImmutableByteEmptyListTest::contains;
            this.payloads.containsAllArray = ImmutableByteEmptyListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteEmptyListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableByteEmptyListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableByteEmptyListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableByteEmptyListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableByteEmptyListTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableByteEmptyListTest::forEach;
            this.payloads.size = ImmutableByteEmptyListTest::size;
            this.payloads.count = ImmutableByteEmptyListTest::count;
            this.payloads.anySatisfy = ImmutableByteEmptyListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteEmptyListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteEmptyListTest::noneSatisfy;
            this.payloads.collect = ImmutableByteEmptyListTest::collect;
            this.payloads.collectWithTarget = ImmutableByteEmptyListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableByteEmptyListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableByteEmptyListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableByteEmptyListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableByteEmptyListTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableByteEmptyListTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableByteEmptyListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableByteEmptyListTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteEmptyListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteEmptyListTest::maxIfEmpty;
            this.payloads.sum = ImmutableByteEmptyListTest::sum;
            this.payloads.summaryStatistics = ImmutableByteEmptyListTest::summaryStatistics;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArrayWithTargetArray = ImmutableByteEmptyListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableByteEmptyListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableByteEmptyListTest::testHashCode;
            this.payloads.toSortedList = ImmutableByteEmptyListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableByteEmptyListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableByteEmptyListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableByteEmptyListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableByteEmptyListTest::toSet;
            this.payloads.toBag = ImmutableByteEmptyListTest::toBag;
            this.payloads.asLazy = ImmutableByteEmptyListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableByteEmptyListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableByteEmptyListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableByteEmptyListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableByteEmptyListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableByteEmptyListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableByteEmptyListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableByteEmptyListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableByteEmptyListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableByteEmptyListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableByteEmptyListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableByteEmptyListTest::chunk;
            this.payloads.testNewWith = ImmutableByteEmptyListTest::testNewWith;
            this.payloads.newWithAll = ImmutableByteEmptyListTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableByteEmptyListTest::newWithoutAll;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = ImmutableByteEmptyListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableByteEmptyListTest::lastIndexOf;
            this.payloads.byteIterator = ImmutableByteEmptyListTest::byteIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableByteEmptyListTest::toArray;
            this.payloads.selectWithIndex = ImmutableByteEmptyListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableByteEmptyListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableByteEmptyListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableByteEmptyListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableByteEmptyListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableByteEmptyListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableByteEmptyListTest::distinct;
            this.payloads.testToString = ImmutableByteEmptyListTest::testToString;
            this.payloads.makeString = ImmutableByteEmptyListTest::makeString;
            this.payloads.appendString = ImmutableByteEmptyListTest::appendString;
            this.payloads.toList = ImmutableByteEmptyListTest::toList;
            this.payloads.zipByte = ImmutableByteEmptyListTest::zipByte;
            this.payloads.zip = ImmutableByteEmptyListTest::zip;
            this.payloads.get = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::get, java.lang.IndexOutOfBoundsException.class);
            this.payloads.newWithout = ImmutableByteEmptyListTest::newWithout;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::getFirst, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::getLast, java.lang.IndexOutOfBoundsException.class);
            this.payloads.isEmpty = ImmutableByteEmptyListTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteEmptyListTest::notEmpty;
            this.payloads.select = ImmutableByteEmptyListTest::select;
            this.payloads.reject = ImmutableByteEmptyListTest::reject;
            this.payloads.testEquals = ImmutableByteEmptyListTest::testEquals;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::average, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableByteEmptyListTest::averageIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::median, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableByteEmptyListTest::medianIfEmpty;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::min, java.util.NoSuchElementException.class);
            this.payloads.dotProduct = ImmutableByteEmptyListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteEmptyListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.injectInto = ImmutableByteEmptyListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableByteEmptyListTest::injectIntoWithIndex;
            this.payloads.toReversed = ImmutableByteEmptyListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableByteEmptyListTest::forEachWithIndex;
            this.payloads.binarySearch = ImmutableByteEmptyListTest::binarySearch;
        }
    }
}
