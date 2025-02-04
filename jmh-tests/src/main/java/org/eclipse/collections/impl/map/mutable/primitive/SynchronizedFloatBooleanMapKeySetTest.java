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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractFloatSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatBooleanMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapKeySetTest.stg.
 */
public class SynchronizedFloatBooleanMapKeySetTest extends AbstractFloatSetTestCase {

    @Override
    protected MutableFloatSet classUnderTest() {
        return new SynchronizedFloatBooleanMap(FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false, 3.0f, true)).keySet();
    }

    @Override
    protected MutableFloatSet newWith(float... elements) {
        FloatBooleanHashMap map = new FloatBooleanHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (i & 1) == 0);
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

    @Test(expected = UnsupportedOperationException.class)
    public void freeze() {
        this.classUnderTest().freeze();
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
    @Test
    public void testHashCode() {
        MutableFloatSet set1 = this.newWith(0.0f, 1.0f, 31.0f, 32.0f);
        MutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f, 0.0f);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 31.0f, 32.0f).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void chunk() {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(FloatSets.mutable.with(1.0f), FloatSets.mutable.with(2.0f), FloatSets.mutable.with(3.0f)).toSet(), iterable.chunk(1).toSet());
        MutableSet<FloatIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(FloatSets.mutable.with(1.0f, 2.0f), FloatSets.mutable.with(3.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatSets.mutable.with(2.0f, 3.0f), FloatSets.mutable.with(1.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatSets.mutable.with(1.0f, 3.0f), FloatSets.mutable.with(2.0f)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(FloatSets.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatSets.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedFloatBooleanMapKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatBooleanMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBooleanMapKeySetTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedFloatBooleanMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedFloatBooleanMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedFloatBooleanMapKeySetTest::tap;
            this.payloads.contains_NaN = SynchronizedFloatBooleanMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedFloatBooleanMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedFloatBooleanMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedFloatBooleanMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedFloatBooleanMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedFloatBooleanMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedFloatBooleanMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedFloatBooleanMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedFloatBooleanMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedFloatBooleanMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedFloatBooleanMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedFloatBooleanMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedFloatBooleanMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatBooleanMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedFloatBooleanMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedFloatBooleanMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedFloatBooleanMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedFloatBooleanMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedFloatBooleanMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedFloatBooleanMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedFloatBooleanMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedFloatBooleanMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedFloatBooleanMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatBooleanMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatBooleanMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedFloatBooleanMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedFloatBooleanMapKeySetTest::sumConsistentRounding;
            this.payloads.average = SynchronizedFloatBooleanMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedFloatBooleanMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedFloatBooleanMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedFloatBooleanMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedFloatBooleanMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedFloatBooleanMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedFloatBooleanMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedFloatBooleanMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedFloatBooleanMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedFloatBooleanMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedFloatBooleanMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedFloatBooleanMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedFloatBooleanMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedFloatBooleanMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedFloatBooleanMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedFloatBooleanMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedFloatBooleanMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedFloatBooleanMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedFloatBooleanMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedFloatBooleanMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedFloatBooleanMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedFloatBooleanMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedFloatBooleanMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedFloatBooleanMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedFloatBooleanMapKeySetTest::reduceIfEmpty;
            this.payloads.contains = SynchronizedFloatBooleanMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedFloatBooleanMapKeySetTest::removeIf;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = SynchronizedFloatBooleanMapKeySetTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = SynchronizedFloatBooleanMapKeySetTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = SynchronizedFloatBooleanMapKeySetTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedFloatBooleanMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedFloatBooleanMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedFloatBooleanMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatBooleanMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedFloatBooleanMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedFloatBooleanMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedFloatBooleanMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedFloatBooleanMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedFloatBooleanMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedFloatBooleanMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedFloatBooleanMapKeySetTest::retainAll_iterable;
            this.payloads.floatIterator = SynchronizedFloatBooleanMapKeySetTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedFloatBooleanMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedFloatBooleanMapKeySetTest::forEach;
            this.payloads.count = SynchronizedFloatBooleanMapKeySetTest::count;
            this.payloads.select = SynchronizedFloatBooleanMapKeySetTest::select;
            this.payloads.reject = SynchronizedFloatBooleanMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedFloatBooleanMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedFloatBooleanMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedFloatBooleanMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedFloatBooleanMapKeySetTest::testEquals;
            this.payloads.toBag = SynchronizedFloatBooleanMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedFloatBooleanMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedFloatBooleanMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedFloatBooleanMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedFloatBooleanMapKeySetTest::union;
            this.payloads.intersect = SynchronizedFloatBooleanMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedFloatBooleanMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedFloatBooleanMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedFloatBooleanMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedFloatBooleanMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedFloatBooleanMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NaN = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::add_NaN, java.lang.UnsupportedOperationException.class);
            this.payloads.add_POSITIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::add_POSITIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NEGATIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::add_NEGATIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedFloatBooleanMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedFloatBooleanMapKeySetTest::withoutAll;
            this.payloads.freeze = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBooleanMapKeySetTest::freeze, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = SynchronizedFloatBooleanMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedFloatBooleanMapKeySetTest::sum;
            this.payloads.testHashCode = SynchronizedFloatBooleanMapKeySetTest::testHashCode;
            this.payloads.chunk = SynchronizedFloatBooleanMapKeySetTest::chunk;
        }
    }
}
