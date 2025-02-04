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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractLongSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongObjectHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitiveObjectHashMapKeySetTest.stg.
 */
public class LongObjectHashMapKeySetTest extends AbstractLongSetTestCase {

    @Override
    protected MutableLongSet classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3).keySet();
    }

    @Override
    protected MutableLongSet newWith(long... elements) {
        LongObjectHashMap<Integer> map = new LongObjectHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new LongArrayList());
    }

    @Override
    public void testEquals() {
        MutableLongSet set1 = this.newWith(1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L);
        MutableLongSet set3 = this.newWith(32L, 32L, 31L, 1L);
        MutableLongSet set4 = this.newWith(32L, 32L, 31L, 1L, 1L);
        MutableLongSet set5 = this.newWith(32L, 1L);
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
        Assert.assertFalse(this.newWith(0L, 1L, 2L).noneSatisfy(LongPredicates.equal(0L)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3L, this.newWith(0L, 1L, 2L).sum());
    }

    @Override
    public void testHashCode() {
        MutableLongSet set1 = this.newWith(0L, 1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L, 0L);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 31L, 32L).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void chunk() {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(LongSets.mutable.with(1L), LongSets.mutable.with(2L), LongSets.mutable.with(3L)).toSet(), iterable.chunk(1).toSet());
        MutableSet<LongIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(LongSets.mutable.with(1L, 2L), LongSets.mutable.with(3L)).toSet().equals(chunked) || Lists.mutable.with(LongSets.mutable.with(2L, 3L), LongSets.mutable.with(1L)).toSet().equals(chunked) || Lists.mutable.with(LongSets.mutable.with(1L, 3L), LongSets.mutable.with(2L)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(LongSets.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(LongSets.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongObjectHashMapKeySetTest instance;

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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new LongObjectHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeySetTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = LongObjectHashMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = LongObjectHashMapKeySetTest::newCollection;
            this.payloads.tap = LongObjectHashMapKeySetTest::tap;
            this.payloads.containsAllArray = LongObjectHashMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = LongObjectHashMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = LongObjectHashMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = LongObjectHashMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = LongObjectHashMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = LongObjectHashMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = LongObjectHashMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = LongObjectHashMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = LongObjectHashMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = LongObjectHashMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = LongObjectHashMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = LongObjectHashMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = LongObjectHashMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = LongObjectHashMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = LongObjectHashMapKeySetTest::rejectWithTarget;
            this.payloads.max = LongObjectHashMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = LongObjectHashMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongObjectHashMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongObjectHashMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = LongObjectHashMapKeySetTest::summaryStatistics;
            this.payloads.average = LongObjectHashMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = LongObjectHashMapKeySetTest::averageIfEmpty;
            this.payloads.median = LongObjectHashMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = LongObjectHashMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = LongObjectHashMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = LongObjectHashMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = LongObjectHashMapKeySetTest::testToString;
            this.payloads.makeString = LongObjectHashMapKeySetTest::makeString;
            this.payloads.appendString = LongObjectHashMapKeySetTest::appendString;
            this.payloads.toList = LongObjectHashMapKeySetTest::toList;
            this.payloads.toSortedList = LongObjectHashMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = LongObjectHashMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = LongObjectHashMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = LongObjectHashMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = LongObjectHashMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = LongObjectHashMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = LongObjectHashMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = LongObjectHashMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = LongObjectHashMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = LongObjectHashMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = LongObjectHashMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = LongObjectHashMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = LongObjectHashMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = LongObjectHashMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = LongObjectHashMapKeySetTest::reduceIfEmpty;
            this.payloads.contains = LongObjectHashMapKeySetTest::contains;
            this.payloads.removeIf = LongObjectHashMapKeySetTest::removeIf;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = LongObjectHashMapKeySetTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = LongObjectHashMapKeySetTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = LongObjectHashMapKeySetTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = LongObjectHashMapKeySetTest::newEmpty;
            this.payloads.size = LongObjectHashMapKeySetTest::size;
            this.payloads.isEmpty = LongObjectHashMapKeySetTest::isEmpty;
            this.payloads.notEmpty = LongObjectHashMapKeySetTest::notEmpty;
            this.payloads.clear = LongObjectHashMapKeySetTest::clear;
            this.payloads.testOfAllFactory = LongObjectHashMapKeySetTest::testOfAllFactory;
            this.payloads.remove = LongObjectHashMapKeySetTest::remove;
            this.payloads.removeAll = LongObjectHashMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = LongObjectHashMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = LongObjectHashMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = LongObjectHashMapKeySetTest::retainAll_iterable;
            this.payloads.longIterator = LongObjectHashMapKeySetTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = LongObjectHashMapKeySetTest::injectInto;
            this.payloads.forEach = LongObjectHashMapKeySetTest::forEach;
            this.payloads.count = LongObjectHashMapKeySetTest::count;
            this.payloads.select = LongObjectHashMapKeySetTest::select;
            this.payloads.reject = LongObjectHashMapKeySetTest::reject;
            this.payloads.detectIfNone = LongObjectHashMapKeySetTest::detectIfNone;
            this.payloads.collect = LongObjectHashMapKeySetTest::collect;
            this.payloads.toSortedArray = LongObjectHashMapKeySetTest::toSortedArray;
            this.payloads.testEquals = LongObjectHashMapKeySetTest::testEquals;
            this.payloads.testHashCode = LongObjectHashMapKeySetTest::testHashCode;
            this.payloads.toBag = LongObjectHashMapKeySetTest::toBag;
            this.payloads.asLazy = LongObjectHashMapKeySetTest::asLazy;
            this.payloads.asSynchronized = LongObjectHashMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = LongObjectHashMapKeySetTest::asUnmodifiable;
            this.payloads.union = LongObjectHashMapKeySetTest::union;
            this.payloads.intersect = LongObjectHashMapKeySetTest::intersect;
            this.payloads.difference = LongObjectHashMapKeySetTest::difference;
            this.payloads.symmetricDifference = LongObjectHashMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = LongObjectHashMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = LongObjectHashMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = LongObjectHashMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = LongObjectHashMapKeySetTest::noneSatisfy;
            this.payloads.sum = LongObjectHashMapKeySetTest::sum;
            this.payloads.chunk = LongObjectHashMapKeySetTest::chunk;
        }
    }
}
