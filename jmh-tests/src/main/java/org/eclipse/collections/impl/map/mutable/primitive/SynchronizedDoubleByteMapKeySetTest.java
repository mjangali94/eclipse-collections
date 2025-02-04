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
 * JUnit test for {@link SynchronizedDoubleByteMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeySetTest.stg.
 */
public class SynchronizedDoubleByteMapKeySetTest extends AbstractDoubleSetTestCase {

    @Override
    protected MutableDoubleSet classUnderTest() {
        return new SynchronizedDoubleByteMap(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3)).keySet();
    }

    @Override
    protected MutableDoubleSet newWith(double... elements) {
        DoubleByteHashMap map = new DoubleByteHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (byte) i);
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

        private SynchronizedDoubleByteMapKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleByteMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleByteMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedDoubleByteMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedDoubleByteMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedDoubleByteMapKeySetTest::tap;
            this.payloads.contains_NaN = SynchronizedDoubleByteMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedDoubleByteMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedDoubleByteMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedDoubleByteMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedDoubleByteMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedDoubleByteMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedDoubleByteMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedDoubleByteMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedDoubleByteMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedDoubleByteMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedDoubleByteMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedDoubleByteMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedDoubleByteMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedDoubleByteMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedDoubleByteMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedDoubleByteMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedDoubleByteMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedDoubleByteMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedDoubleByteMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedDoubleByteMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedDoubleByteMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedDoubleByteMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedDoubleByteMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedDoubleByteMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedDoubleByteMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedDoubleByteMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedDoubleByteMapKeySetTest::sumConsistentRounding;
            this.payloads.average = SynchronizedDoubleByteMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedDoubleByteMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedDoubleByteMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedDoubleByteMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedDoubleByteMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedDoubleByteMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedDoubleByteMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedDoubleByteMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedDoubleByteMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedDoubleByteMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedDoubleByteMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedDoubleByteMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedDoubleByteMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedDoubleByteMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedDoubleByteMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedDoubleByteMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedDoubleByteMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedDoubleByteMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedDoubleByteMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedDoubleByteMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedDoubleByteMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedDoubleByteMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedDoubleByteMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedDoubleByteMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedDoubleByteMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedDoubleByteMapKeySetTest::chunk;
            this.payloads.contains = SynchronizedDoubleByteMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedDoubleByteMapKeySetTest::removeIf;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = SynchronizedDoubleByteMapKeySetTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = SynchronizedDoubleByteMapKeySetTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = SynchronizedDoubleByteMapKeySetTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedDoubleByteMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedDoubleByteMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedDoubleByteMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedDoubleByteMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedDoubleByteMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedDoubleByteMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedDoubleByteMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedDoubleByteMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedDoubleByteMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedDoubleByteMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedDoubleByteMapKeySetTest::retainAll_iterable;
            this.payloads.doubleIterator = SynchronizedDoubleByteMapKeySetTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedDoubleByteMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedDoubleByteMapKeySetTest::forEach;
            this.payloads.count = SynchronizedDoubleByteMapKeySetTest::count;
            this.payloads.select = SynchronizedDoubleByteMapKeySetTest::select;
            this.payloads.reject = SynchronizedDoubleByteMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedDoubleByteMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedDoubleByteMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedDoubleByteMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedDoubleByteMapKeySetTest::testEquals;
            this.payloads.testHashCode = SynchronizedDoubleByteMapKeySetTest::testHashCode;
            this.payloads.toBag = SynchronizedDoubleByteMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedDoubleByteMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedDoubleByteMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedDoubleByteMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedDoubleByteMapKeySetTest::union;
            this.payloads.intersect = SynchronizedDoubleByteMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedDoubleByteMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedDoubleByteMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedDoubleByteMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedDoubleByteMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedDoubleByteMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NaN = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::add_NaN, java.lang.UnsupportedOperationException.class);
            this.payloads.add_POSITIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::add_POSITIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NEGATIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::add_NEGATIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleByteMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedDoubleByteMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedDoubleByteMapKeySetTest::withoutAll;
            this.payloads.noneSatisfy = SynchronizedDoubleByteMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedDoubleByteMapKeySetTest::sum;
        }
    }
}
