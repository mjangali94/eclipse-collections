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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractIntSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntObjectHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitiveObjectHashMapKeySetTest.stg.
 */
public class IntObjectHashMapKeySetTest extends AbstractIntSetTestCase {

    @Override
    protected MutableIntSet classUnderTest() {
        return IntObjectHashMap.newWithKeysValues(1, 1, 2, 2, 3, 3).keySet();
    }

    @Override
    protected MutableIntSet newWith(int... elements) {
        IntObjectHashMap<Integer> map = new IntObjectHashMap<>();
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

    @Override
    @Test
    public void chunk() {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(IntSets.mutable.with(1), IntSets.mutable.with(2), IntSets.mutable.with(3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<IntIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(IntSets.mutable.with(1, 2), IntSets.mutable.with(3)).toSet().equals(chunked) || Lists.mutable.with(IntSets.mutable.with(2, 3), IntSets.mutable.with(1)).toSet().equals(chunked) || Lists.mutable.with(IntSets.mutable.with(1, 3), IntSets.mutable.with(2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(IntSets.mutable.with(1, 2, 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(IntSets.mutable.with(1, 2, 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntObjectHashMapKeySetTest instance;

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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new IntObjectHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectHashMapKeySetTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntObjectHashMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = IntObjectHashMapKeySetTest::newCollection;
            this.payloads.tap = IntObjectHashMapKeySetTest::tap;
            this.payloads.containsAllArray = IntObjectHashMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = IntObjectHashMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = IntObjectHashMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntObjectHashMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntObjectHashMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntObjectHashMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = IntObjectHashMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = IntObjectHashMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = IntObjectHashMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntObjectHashMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntObjectHashMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntObjectHashMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntObjectHashMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = IntObjectHashMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = IntObjectHashMapKeySetTest::rejectWithTarget;
            this.payloads.max = IntObjectHashMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntObjectHashMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntObjectHashMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntObjectHashMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = IntObjectHashMapKeySetTest::summaryStatistics;
            this.payloads.average = IntObjectHashMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntObjectHashMapKeySetTest::averageIfEmpty;
            this.payloads.median = IntObjectHashMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntObjectHashMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = IntObjectHashMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = IntObjectHashMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = IntObjectHashMapKeySetTest::testToString;
            this.payloads.makeString = IntObjectHashMapKeySetTest::makeString;
            this.payloads.appendString = IntObjectHashMapKeySetTest::appendString;
            this.payloads.toList = IntObjectHashMapKeySetTest::toList;
            this.payloads.toSortedList = IntObjectHashMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = IntObjectHashMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntObjectHashMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntObjectHashMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntObjectHashMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = IntObjectHashMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntObjectHashMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = IntObjectHashMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = IntObjectHashMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = IntObjectHashMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntObjectHashMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntObjectHashMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntObjectHashMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntObjectHashMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = IntObjectHashMapKeySetTest::reduceIfEmpty;
            this.payloads.contains = IntObjectHashMapKeySetTest::contains;
            this.payloads.removeIf = IntObjectHashMapKeySetTest::removeIf;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = IntObjectHashMapKeySetTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = IntObjectHashMapKeySetTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = IntObjectHashMapKeySetTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntObjectHashMapKeySetTest::newEmpty;
            this.payloads.size = IntObjectHashMapKeySetTest::size;
            this.payloads.isEmpty = IntObjectHashMapKeySetTest::isEmpty;
            this.payloads.notEmpty = IntObjectHashMapKeySetTest::notEmpty;
            this.payloads.clear = IntObjectHashMapKeySetTest::clear;
            this.payloads.testOfAllFactory = IntObjectHashMapKeySetTest::testOfAllFactory;
            this.payloads.remove = IntObjectHashMapKeySetTest::remove;
            this.payloads.removeAll = IntObjectHashMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = IntObjectHashMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = IntObjectHashMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = IntObjectHashMapKeySetTest::retainAll_iterable;
            this.payloads.intIterator = IntObjectHashMapKeySetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = IntObjectHashMapKeySetTest::injectInto;
            this.payloads.forEach = IntObjectHashMapKeySetTest::forEach;
            this.payloads.count = IntObjectHashMapKeySetTest::count;
            this.payloads.select = IntObjectHashMapKeySetTest::select;
            this.payloads.reject = IntObjectHashMapKeySetTest::reject;
            this.payloads.detectIfNone = IntObjectHashMapKeySetTest::detectIfNone;
            this.payloads.collect = IntObjectHashMapKeySetTest::collect;
            this.payloads.toSortedArray = IntObjectHashMapKeySetTest::toSortedArray;
            this.payloads.testEquals = IntObjectHashMapKeySetTest::testEquals;
            this.payloads.testHashCode = IntObjectHashMapKeySetTest::testHashCode;
            this.payloads.toBag = IntObjectHashMapKeySetTest::toBag;
            this.payloads.asLazy = IntObjectHashMapKeySetTest::asLazy;
            this.payloads.asSynchronized = IntObjectHashMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = IntObjectHashMapKeySetTest::asUnmodifiable;
            this.payloads.union = IntObjectHashMapKeySetTest::union;
            this.payloads.intersect = IntObjectHashMapKeySetTest::intersect;
            this.payloads.difference = IntObjectHashMapKeySetTest::difference;
            this.payloads.symmetricDifference = IntObjectHashMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = IntObjectHashMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = IntObjectHashMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = IntObjectHashMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntObjectHashMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = IntObjectHashMapKeySetTest::noneSatisfy;
            this.payloads.sum = IntObjectHashMapKeySetTest::sum;
            this.payloads.chunk = IntObjectHashMapKeySetTest::chunk;
        }
    }
}
