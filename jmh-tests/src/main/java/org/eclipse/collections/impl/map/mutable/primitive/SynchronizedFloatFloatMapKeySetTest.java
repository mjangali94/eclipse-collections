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

import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractFloatSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatFloatMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeySetTest.stg.
 */
public class SynchronizedFloatFloatMapKeySetTest extends AbstractFloatSetTestCase {

    @Override
    protected MutableFloatSet classUnderTest() {
        return new SynchronizedFloatFloatMap(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f)).keySet();
    }

    @Override
    protected MutableFloatSet newWith(float... elements) {
        FloatFloatHashMap map = new FloatFloatHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asSynchronized().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NaN() {
        this.newWith(Float.NaN).add(Float.NaN);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_POSITIVE_INFINITY() {
        this.newWith(Float.POSITIVE_INFINITY).add(Float.POSITIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NEGATIVE_INFINITY() {
        this.newWith(Float.NEGATIVE_INFINITY).add(Float.NEGATIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableFloatSet set = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatSet setWithout = set.without(2.0f);
        Assert.assertSame(set, setWithout);
        MutableFloatSet expectedSet = this.newWith(1.0f, 3.0f);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
        Assert.assertEquals(expectedSet.toList(), setWithout.without(4.0f).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableFloatSet set = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatSet setWithout = set.withoutAll(new FloatArrayList(2.0f, 4.0f));
        Assert.assertSame(set, setWithout);
        MutableFloatSet expectedSet = this.newWith(1.0f, 3.0f);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
    }

    @Override
    public void testEquals() {
        MutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        MutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        MutableFloatSet set3 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f);
        MutableFloatSet set4 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f, 1.0f);
        MutableFloatSet set5 = this.newWith(32.0f, 1.0f);
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
        Assert.assertFalse(this.newWith(0.0f, 1.0f, 2.0f).noneSatisfy(FloatPredicates.equal(0.0f)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3.0, this.newWith(0.0f, 1.0f, 2.0f).sum(), 0.0);
    }

    @Override
    public void testHashCode() {
        MutableFloatSet set1 = this.newWith(0.0f, 1.0f, 31.0f, 32.0f);
        MutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f, 0.0f);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 31.0f, 32.0f).hashCode(), set1.hashCode());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedFloatFloatMapKeySetTest instance;

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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatFloatMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatFloatMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedFloatFloatMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedFloatFloatMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedFloatFloatMapKeySetTest::tap;
            this.payloads.contains_NaN = SynchronizedFloatFloatMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedFloatFloatMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedFloatFloatMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedFloatFloatMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedFloatFloatMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedFloatFloatMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedFloatFloatMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedFloatFloatMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedFloatFloatMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedFloatFloatMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedFloatFloatMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedFloatFloatMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedFloatFloatMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatFloatMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedFloatFloatMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedFloatFloatMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedFloatFloatMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedFloatFloatMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedFloatFloatMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedFloatFloatMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedFloatFloatMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedFloatFloatMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedFloatFloatMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatFloatMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatFloatMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedFloatFloatMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedFloatFloatMapKeySetTest::sumConsistentRounding;
            this.payloads.average = SynchronizedFloatFloatMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedFloatFloatMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedFloatFloatMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedFloatFloatMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedFloatFloatMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedFloatFloatMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedFloatFloatMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedFloatFloatMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedFloatFloatMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedFloatFloatMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedFloatFloatMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedFloatFloatMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedFloatFloatMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedFloatFloatMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedFloatFloatMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedFloatFloatMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedFloatFloatMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedFloatFloatMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedFloatFloatMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedFloatFloatMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedFloatFloatMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedFloatFloatMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedFloatFloatMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedFloatFloatMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedFloatFloatMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedFloatFloatMapKeySetTest::chunk;
            this.payloads.contains = SynchronizedFloatFloatMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedFloatFloatMapKeySetTest::removeIf;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = SynchronizedFloatFloatMapKeySetTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = SynchronizedFloatFloatMapKeySetTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = SynchronizedFloatFloatMapKeySetTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedFloatFloatMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedFloatFloatMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedFloatFloatMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatFloatMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedFloatFloatMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedFloatFloatMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedFloatFloatMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedFloatFloatMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedFloatFloatMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedFloatFloatMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedFloatFloatMapKeySetTest::retainAll_iterable;
            this.payloads.floatIterator = SynchronizedFloatFloatMapKeySetTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedFloatFloatMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedFloatFloatMapKeySetTest::forEach;
            this.payloads.count = SynchronizedFloatFloatMapKeySetTest::count;
            this.payloads.select = SynchronizedFloatFloatMapKeySetTest::select;
            this.payloads.reject = SynchronizedFloatFloatMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedFloatFloatMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedFloatFloatMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedFloatFloatMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedFloatFloatMapKeySetTest::testEquals;
            this.payloads.testHashCode = SynchronizedFloatFloatMapKeySetTest::testHashCode;
            this.payloads.toBag = SynchronizedFloatFloatMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedFloatFloatMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedFloatFloatMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedFloatFloatMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedFloatFloatMapKeySetTest::union;
            this.payloads.intersect = SynchronizedFloatFloatMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedFloatFloatMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedFloatFloatMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedFloatFloatMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedFloatFloatMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedFloatFloatMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NaN = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::add_NaN, java.lang.UnsupportedOperationException.class);
            this.payloads.add_POSITIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::add_POSITIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NEGATIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::add_NEGATIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatFloatMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedFloatFloatMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedFloatFloatMapKeySetTest::withoutAll;
            this.payloads.noneSatisfy = SynchronizedFloatFloatMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedFloatFloatMapKeySetTest::sum;
        }
    }
}
