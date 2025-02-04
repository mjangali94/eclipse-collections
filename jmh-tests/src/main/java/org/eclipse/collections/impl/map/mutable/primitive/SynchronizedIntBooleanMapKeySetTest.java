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
 * JUnit test for {@link SynchronizedIntBooleanMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapKeySetTest.stg.
 */
public class SynchronizedIntBooleanMapKeySetTest extends AbstractIntSetTestCase {

    @Override
    protected MutableIntSet classUnderTest() {
        return new SynchronizedIntBooleanMap(IntBooleanHashMap.newWithKeysValues(1, true, 2, false, 3, true)).keySet();
    }

    @Override
    protected MutableIntSet newWith(int... elements) {
        IntBooleanHashMap map = new IntBooleanHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.asSynchronized().keySet();
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
    public void withAll() {
        this.classUnderTest().withAll(new IntArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableIntSet set = this.newWith(1, 2, 3);
        MutableIntSet setWithout = set.without(2);
        Assert.assertSame(set, setWithout);
        MutableIntSet expectedSet = this.newWith(1, 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
        Assert.assertEquals(expectedSet.toList(), setWithout.without(4).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableIntSet set = this.newWith(1, 2, 3);
        MutableIntSet setWithout = set.withoutAll(new IntArrayList(2, 4));
        Assert.assertSame(set, setWithout);
        MutableIntSet expectedSet = this.newWith(1, 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void freeze() {
        this.classUnderTest().freeze();
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
    @Test
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

        private SynchronizedIntBooleanMapKeySetTest instance;

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
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntBooleanMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntBooleanMapKeySetTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedIntBooleanMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedIntBooleanMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedIntBooleanMapKeySetTest::tap;
            this.payloads.containsAllArray = SynchronizedIntBooleanMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedIntBooleanMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedIntBooleanMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedIntBooleanMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedIntBooleanMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedIntBooleanMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedIntBooleanMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntBooleanMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedIntBooleanMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedIntBooleanMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedIntBooleanMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedIntBooleanMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedIntBooleanMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedIntBooleanMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedIntBooleanMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedIntBooleanMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedIntBooleanMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedIntBooleanMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntBooleanMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedIntBooleanMapKeySetTest::summaryStatistics;
            this.payloads.average = SynchronizedIntBooleanMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedIntBooleanMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedIntBooleanMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedIntBooleanMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedIntBooleanMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedIntBooleanMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedIntBooleanMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedIntBooleanMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedIntBooleanMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedIntBooleanMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedIntBooleanMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedIntBooleanMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedIntBooleanMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedIntBooleanMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedIntBooleanMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedIntBooleanMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedIntBooleanMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedIntBooleanMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedIntBooleanMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedIntBooleanMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedIntBooleanMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedIntBooleanMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedIntBooleanMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedIntBooleanMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedIntBooleanMapKeySetTest::reduceIfEmpty;
            this.payloads.contains = SynchronizedIntBooleanMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedIntBooleanMapKeySetTest::removeIf;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = SynchronizedIntBooleanMapKeySetTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = SynchronizedIntBooleanMapKeySetTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = SynchronizedIntBooleanMapKeySetTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedIntBooleanMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedIntBooleanMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedIntBooleanMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntBooleanMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedIntBooleanMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedIntBooleanMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedIntBooleanMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedIntBooleanMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedIntBooleanMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedIntBooleanMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedIntBooleanMapKeySetTest::retainAll_iterable;
            this.payloads.intIterator = SynchronizedIntBooleanMapKeySetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedIntBooleanMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedIntBooleanMapKeySetTest::forEach;
            this.payloads.count = SynchronizedIntBooleanMapKeySetTest::count;
            this.payloads.select = SynchronizedIntBooleanMapKeySetTest::select;
            this.payloads.reject = SynchronizedIntBooleanMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedIntBooleanMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedIntBooleanMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedIntBooleanMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedIntBooleanMapKeySetTest::testEquals;
            this.payloads.toBag = SynchronizedIntBooleanMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedIntBooleanMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedIntBooleanMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedIntBooleanMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedIntBooleanMapKeySetTest::union;
            this.payloads.intersect = SynchronizedIntBooleanMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedIntBooleanMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedIntBooleanMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedIntBooleanMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedIntBooleanMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedIntBooleanMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedIntBooleanMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedIntBooleanMapKeySetTest::withoutAll;
            this.payloads.freeze = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntBooleanMapKeySetTest::freeze, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = SynchronizedIntBooleanMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedIntBooleanMapKeySetTest::sum;
            this.payloads.testHashCode = SynchronizedIntBooleanMapKeySetTest::testHashCode;
            this.payloads.chunk = SynchronizedIntBooleanMapKeySetTest::chunk;
        }
    }
}
