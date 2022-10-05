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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableCharEmptyListTest extends AbstractImmutableCharListTestCase {

    @Override
    protected ImmutableCharList classUnderTest() {
        return ImmutableCharEmptyList.INSTANCE;
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        this.classUnderTest().get(1);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableCharCollection emptyCollection = this.classUnderTest();
        ImmutableCharCollection newCollection = emptyCollection.newWithout((char) 9);
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
        CharIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(CharPredicates.lessThan((char) 4)));
        CharIterable charIterable = iterable.select(CharPredicates.greaterThan((char) 4));
        Verify.assertEmpty(charIterable);
        Assert.assertSame(iterable, charIterable);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        CharIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(CharPredicates.lessThan((char) 4)));
        CharIterable charIterable = iterable.reject(CharPredicates.greaterThan((char) 4));
        Verify.assertEmpty(charIterable);
        Assert.assertSame(iterable, charIterable);
    }

    @Override
    @Test
    public void testEquals() {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((char) 1, (char) 2, (char) 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((char) 1));
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
        ImmutableCharEmptyList list1 = new ImmutableCharEmptyList();
        ImmutableCharEmptyList list2 = new ImmutableCharEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableCharEmptyList list1 = new ImmutableCharEmptyList();
        ImmutableCharArrayList list2 = ImmutableCharArrayList.newListWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableCharEmptyList iterable = new ImmutableCharEmptyList();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex() {
        ImmutableCharList list1 = this.newWith();
        ImmutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0), (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @Override
    @Test
    public void toReversed() {
        Assert.assertEquals(CharLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);
        Assert.assertEquals(0, sum[0], (char) 0);
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) -1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharEmptyListTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipChar);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharEmptyListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> zipChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableCharEmptyListTest::newCollectionWith;
            this.payloads.newCollection = ImmutableCharEmptyListTest::newCollection;
            this.payloads.tap = ImmutableCharEmptyListTest::tap;
            this.payloads.contains = ImmutableCharEmptyListTest::contains;
            this.payloads.containsAllArray = ImmutableCharEmptyListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableCharEmptyListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableCharEmptyListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableCharEmptyListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableCharEmptyListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableCharEmptyListTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableCharEmptyListTest::forEach;
            this.payloads.size = ImmutableCharEmptyListTest::size;
            this.payloads.count = ImmutableCharEmptyListTest::count;
            this.payloads.anySatisfy = ImmutableCharEmptyListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharEmptyListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharEmptyListTest::noneSatisfy;
            this.payloads.collect = ImmutableCharEmptyListTest::collect;
            this.payloads.collectWithTarget = ImmutableCharEmptyListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableCharEmptyListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableCharEmptyListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableCharEmptyListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableCharEmptyListTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableCharEmptyListTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableCharEmptyListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableCharEmptyListTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharEmptyListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharEmptyListTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharEmptyListTest::sum;
            this.payloads.summaryStatistics = ImmutableCharEmptyListTest::summaryStatistics;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArrayWithTargetArray = ImmutableCharEmptyListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableCharEmptyListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableCharEmptyListTest::testHashCode;
            this.payloads.toSortedList = ImmutableCharEmptyListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableCharEmptyListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableCharEmptyListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableCharEmptyListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableCharEmptyListTest::toSet;
            this.payloads.toBag = ImmutableCharEmptyListTest::toBag;
            this.payloads.asLazy = ImmutableCharEmptyListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableCharEmptyListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableCharEmptyListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableCharEmptyListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableCharEmptyListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableCharEmptyListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableCharEmptyListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableCharEmptyListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableCharEmptyListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableCharEmptyListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableCharEmptyListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableCharEmptyListTest::chunk;
            this.payloads.testNewWith = ImmutableCharEmptyListTest::testNewWith;
            this.payloads.newWithAll = ImmutableCharEmptyListTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableCharEmptyListTest::newWithoutAll;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = ImmutableCharEmptyListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableCharEmptyListTest::lastIndexOf;
            this.payloads.charIterator = ImmutableCharEmptyListTest::charIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableCharEmptyListTest::toArray;
            this.payloads.selectWithIndex = ImmutableCharEmptyListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableCharEmptyListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableCharEmptyListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableCharEmptyListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableCharEmptyListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableCharEmptyListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableCharEmptyListTest::distinct;
            this.payloads.testToString = ImmutableCharEmptyListTest::testToString;
            this.payloads.makeString = ImmutableCharEmptyListTest::makeString;
            this.payloads.appendString = ImmutableCharEmptyListTest::appendString;
            this.payloads.toList = ImmutableCharEmptyListTest::toList;
            this.payloads.zipChar = ImmutableCharEmptyListTest::zipChar;
            this.payloads.zip = ImmutableCharEmptyListTest::zip;
            this.payloads.get = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::get, java.lang.IndexOutOfBoundsException.class);
            this.payloads.newWithout = ImmutableCharEmptyListTest::newWithout;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::getFirst, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::getLast, java.lang.IndexOutOfBoundsException.class);
            this.payloads.isEmpty = ImmutableCharEmptyListTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharEmptyListTest::notEmpty;
            this.payloads.select = ImmutableCharEmptyListTest::select;
            this.payloads.reject = ImmutableCharEmptyListTest::reject;
            this.payloads.testEquals = ImmutableCharEmptyListTest::testEquals;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::average, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableCharEmptyListTest::averageIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::median, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableCharEmptyListTest::medianIfEmpty;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::min, java.util.NoSuchElementException.class);
            this.payloads.dotProduct = ImmutableCharEmptyListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.injectInto = ImmutableCharEmptyListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableCharEmptyListTest::injectIntoWithIndex;
            this.payloads.toReversed = ImmutableCharEmptyListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableCharEmptyListTest::forEachWithIndex;
            this.payloads.binarySearch = ImmutableCharEmptyListTest::binarySearch;
        }
    }
}
