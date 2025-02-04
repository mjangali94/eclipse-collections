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

import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractDoubleSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedDoubleShortMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeySetTest.stg.
 */
public class SynchronizedDoubleShortMapKeySetTest extends AbstractDoubleSetTestCase {

    @Override
    protected MutableDoubleSet classUnderTest() {
        return new SynchronizedDoubleShortMap(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3)).keySet();
    }

    @Override
    protected MutableDoubleSet newWith(double... elements) {
        DoubleShortHashMap map = new DoubleShortHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (short) i);
        }
        return map.asSynchronized().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NaN() {
        this.newWith(Double.NaN).add(Double.NaN);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_POSITIVE_INFINITY() {
        this.newWith(Double.POSITIVE_INFINITY).add(Double.POSITIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NEGATIVE_INFINITY() {
        this.newWith(Double.NEGATIVE_INFINITY).add(Double.NEGATIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new DoubleArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableDoubleSet set = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleSet setWithout = set.without(2.0);
        Assert.assertSame(set, setWithout);
        MutableDoubleSet expectedSet = this.newWith(1.0, 3.0);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
        Assert.assertEquals(expectedSet.toList(), setWithout.without(4.0).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableDoubleSet set = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleSet setWithout = set.withoutAll(new DoubleArrayList(2.0, 4.0));
        Assert.assertSame(set, setWithout);
        MutableDoubleSet expectedSet = this.newWith(1.0, 3.0);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
    }

    @Override
    public void testEquals() {
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        MutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        MutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
        MutableDoubleSet set5 = this.newWith(32.0, 1.0);
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
        Assert.assertFalse(this.newWith(0.0, 1.0, 2.0).noneSatisfy(DoublePredicates.equal(0.0)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3.0, this.newWith(0.0, 1.0, 2.0).sum(), 0.0);
    }

    @Override
    public void testHashCode() {
        MutableDoubleSet set1 = this.newWith(0.0, 1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0, 0.0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 31.0, 32.0).hashCode(), set1.hashCode());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedDoubleShortMapKeySetTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NEGATIVE_INFINITY);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleShortMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleShortMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedDoubleShortMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedDoubleShortMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedDoubleShortMapKeySetTest::tap;
            this.payloads.contains_NaN = SynchronizedDoubleShortMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedDoubleShortMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedDoubleShortMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedDoubleShortMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedDoubleShortMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedDoubleShortMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedDoubleShortMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedDoubleShortMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedDoubleShortMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedDoubleShortMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedDoubleShortMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedDoubleShortMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedDoubleShortMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedDoubleShortMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedDoubleShortMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedDoubleShortMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedDoubleShortMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedDoubleShortMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedDoubleShortMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedDoubleShortMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedDoubleShortMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedDoubleShortMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedDoubleShortMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedDoubleShortMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedDoubleShortMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedDoubleShortMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedDoubleShortMapKeySetTest::sumConsistentRounding;
            this.payloads.average = SynchronizedDoubleShortMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedDoubleShortMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedDoubleShortMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedDoubleShortMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedDoubleShortMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedDoubleShortMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedDoubleShortMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedDoubleShortMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedDoubleShortMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedDoubleShortMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedDoubleShortMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedDoubleShortMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedDoubleShortMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedDoubleShortMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedDoubleShortMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedDoubleShortMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedDoubleShortMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedDoubleShortMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedDoubleShortMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedDoubleShortMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedDoubleShortMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedDoubleShortMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedDoubleShortMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedDoubleShortMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedDoubleShortMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedDoubleShortMapKeySetTest::chunk;
            this.payloads.contains = SynchronizedDoubleShortMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedDoubleShortMapKeySetTest::removeIf;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = SynchronizedDoubleShortMapKeySetTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = SynchronizedDoubleShortMapKeySetTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = SynchronizedDoubleShortMapKeySetTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedDoubleShortMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedDoubleShortMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedDoubleShortMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedDoubleShortMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedDoubleShortMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedDoubleShortMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedDoubleShortMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedDoubleShortMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedDoubleShortMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedDoubleShortMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedDoubleShortMapKeySetTest::retainAll_iterable;
            this.payloads.doubleIterator = SynchronizedDoubleShortMapKeySetTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedDoubleShortMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedDoubleShortMapKeySetTest::forEach;
            this.payloads.count = SynchronizedDoubleShortMapKeySetTest::count;
            this.payloads.select = SynchronizedDoubleShortMapKeySetTest::select;
            this.payloads.reject = SynchronizedDoubleShortMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedDoubleShortMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedDoubleShortMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedDoubleShortMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedDoubleShortMapKeySetTest::testEquals;
            this.payloads.testHashCode = SynchronizedDoubleShortMapKeySetTest::testHashCode;
            this.payloads.toBag = SynchronizedDoubleShortMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedDoubleShortMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedDoubleShortMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedDoubleShortMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedDoubleShortMapKeySetTest::union;
            this.payloads.intersect = SynchronizedDoubleShortMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedDoubleShortMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedDoubleShortMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedDoubleShortMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedDoubleShortMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedDoubleShortMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NaN = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::add_NaN, java.lang.UnsupportedOperationException.class);
            this.payloads.add_POSITIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::add_POSITIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NEGATIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::add_NEGATIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleShortMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedDoubleShortMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedDoubleShortMapKeySetTest::withoutAll;
            this.payloads.noneSatisfy = SynchronizedDoubleShortMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedDoubleShortMapKeySetTest::sum;
        }
    }
}
