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

import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractIntSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntFloatHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitivePrimitiveHashMapKeySetTest.stg.
 */
public class IntFloatHashMapKeySetTest extends AbstractIntSetTestCase {

    @Override
    protected MutableIntSet classUnderTest() {
        return IntFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f).keySet();
    }

    @Override
    protected MutableIntSet newWith(int... elements) {
        IntFloatHashMap map = new IntFloatHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new IntArrayList());
    }

    @Override
    public void testEquals() {
        MutableIntSet set1 = this.newWith(1, 31, 32);
        MutableIntSet set2 = this.newWith(32, 31, 1);
        MutableIntSet set3 = this.newWith(32, 32, 31, 1);
        MutableIntSet set4 = this.newWith(32, 32, 31, 1, 1);
        MutableIntSet set5 = this.newWith(32, 1);
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
        Assert.assertFalse(this.newWith(0, 1, 2).noneSatisfy(IntPredicates.equal(0)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3L, this.newWith(0, 1, 2).sum());
    }

    @Override
    public void testHashCode() {
        MutableIntSet set1 = this.newWith(0, 1, 31, 32);
        MutableIntSet set2 = this.newWith(32, 31, 1, 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 31, 32).hashCode(), set1.hashCode());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntFloatHashMapKeySetTest instance;

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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
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
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new IntFloatHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatHashMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntFloatHashMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = IntFloatHashMapKeySetTest::newCollection;
            this.payloads.tap = IntFloatHashMapKeySetTest::tap;
            this.payloads.containsAllArray = IntFloatHashMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = IntFloatHashMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = IntFloatHashMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntFloatHashMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntFloatHashMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntFloatHashMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = IntFloatHashMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = IntFloatHashMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = IntFloatHashMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntFloatHashMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntFloatHashMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntFloatHashMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntFloatHashMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = IntFloatHashMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = IntFloatHashMapKeySetTest::rejectWithTarget;
            this.payloads.max = IntFloatHashMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntFloatHashMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntFloatHashMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntFloatHashMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = IntFloatHashMapKeySetTest::summaryStatistics;
            this.payloads.average = IntFloatHashMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntFloatHashMapKeySetTest::averageIfEmpty;
            this.payloads.median = IntFloatHashMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntFloatHashMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = IntFloatHashMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = IntFloatHashMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = IntFloatHashMapKeySetTest::testToString;
            this.payloads.makeString = IntFloatHashMapKeySetTest::makeString;
            this.payloads.appendString = IntFloatHashMapKeySetTest::appendString;
            this.payloads.toList = IntFloatHashMapKeySetTest::toList;
            this.payloads.toSortedList = IntFloatHashMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = IntFloatHashMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntFloatHashMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntFloatHashMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntFloatHashMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = IntFloatHashMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntFloatHashMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = IntFloatHashMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = IntFloatHashMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = IntFloatHashMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntFloatHashMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntFloatHashMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntFloatHashMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntFloatHashMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = IntFloatHashMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = IntFloatHashMapKeySetTest::chunk;
            this.payloads.contains = IntFloatHashMapKeySetTest::contains;
            this.payloads.removeIf = IntFloatHashMapKeySetTest::removeIf;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = IntFloatHashMapKeySetTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = IntFloatHashMapKeySetTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = IntFloatHashMapKeySetTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntFloatHashMapKeySetTest::newEmpty;
            this.payloads.size = IntFloatHashMapKeySetTest::size;
            this.payloads.isEmpty = IntFloatHashMapKeySetTest::isEmpty;
            this.payloads.notEmpty = IntFloatHashMapKeySetTest::notEmpty;
            this.payloads.clear = IntFloatHashMapKeySetTest::clear;
            this.payloads.testOfAllFactory = IntFloatHashMapKeySetTest::testOfAllFactory;
            this.payloads.remove = IntFloatHashMapKeySetTest::remove;
            this.payloads.removeAll = IntFloatHashMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = IntFloatHashMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = IntFloatHashMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = IntFloatHashMapKeySetTest::retainAll_iterable;
            this.payloads.intIterator = IntFloatHashMapKeySetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = IntFloatHashMapKeySetTest::injectInto;
            this.payloads.forEach = IntFloatHashMapKeySetTest::forEach;
            this.payloads.count = IntFloatHashMapKeySetTest::count;
            this.payloads.select = IntFloatHashMapKeySetTest::select;
            this.payloads.reject = IntFloatHashMapKeySetTest::reject;
            this.payloads.detectIfNone = IntFloatHashMapKeySetTest::detectIfNone;
            this.payloads.collect = IntFloatHashMapKeySetTest::collect;
            this.payloads.toSortedArray = IntFloatHashMapKeySetTest::toSortedArray;
            this.payloads.testEquals = IntFloatHashMapKeySetTest::testEquals;
            this.payloads.testHashCode = IntFloatHashMapKeySetTest::testHashCode;
            this.payloads.toBag = IntFloatHashMapKeySetTest::toBag;
            this.payloads.asLazy = IntFloatHashMapKeySetTest::asLazy;
            this.payloads.asSynchronized = IntFloatHashMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = IntFloatHashMapKeySetTest::asUnmodifiable;
            this.payloads.union = IntFloatHashMapKeySetTest::union;
            this.payloads.intersect = IntFloatHashMapKeySetTest::intersect;
            this.payloads.difference = IntFloatHashMapKeySetTest::difference;
            this.payloads.symmetricDifference = IntFloatHashMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = IntFloatHashMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = IntFloatHashMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = IntFloatHashMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntFloatHashMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = IntFloatHashMapKeySetTest::noneSatisfy;
            this.payloads.sum = IntFloatHashMapKeySetTest::sum;
        }
    }
}
