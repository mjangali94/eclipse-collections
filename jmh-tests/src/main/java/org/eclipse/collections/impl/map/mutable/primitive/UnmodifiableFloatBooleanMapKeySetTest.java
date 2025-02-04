/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
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
 * JUnit test for {@link UnmodifiableFloatBooleanMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapKeySetTest.stg.
 */
public class UnmodifiableFloatBooleanMapKeySetTest extends AbstractFloatSetTestCase {

    @Override
    protected MutableFloatSet classUnderTest() {
        return new UnmodifiableFloatBooleanMap(FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false, 3.0f, true)).keySet();
    }

    @Override
    protected MutableFloatSet newWith(float... elements) {
        FloatBooleanHashMap map = new FloatBooleanHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.asUnmodifiable().keySet();
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
    public void without() {
        this.classUnderTest().without(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void freeze() {
        this.classUnderTest().freeze();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(FloatPredicates.equal(1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().retainAll();
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
    public void floatIterator_with_remove() {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_remove_before_next() {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
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

        private UnmodifiableFloatBooleanMapKeySetTest instance;

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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
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
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableFloatBooleanMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatBooleanMapKeySetTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableFloatBooleanMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableFloatBooleanMapKeySetTest::newCollection;
            this.payloads.tap = UnmodifiableFloatBooleanMapKeySetTest::tap;
            this.payloads.contains_NaN = UnmodifiableFloatBooleanMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = UnmodifiableFloatBooleanMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = UnmodifiableFloatBooleanMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = UnmodifiableFloatBooleanMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = UnmodifiableFloatBooleanMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = UnmodifiableFloatBooleanMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = UnmodifiableFloatBooleanMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableFloatBooleanMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableFloatBooleanMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableFloatBooleanMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableFloatBooleanMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableFloatBooleanMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = UnmodifiableFloatBooleanMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableFloatBooleanMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = UnmodifiableFloatBooleanMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableFloatBooleanMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableFloatBooleanMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableFloatBooleanMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableFloatBooleanMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableFloatBooleanMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableFloatBooleanMapKeySetTest::rejectWithTarget;
            this.payloads.max = UnmodifiableFloatBooleanMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableFloatBooleanMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableFloatBooleanMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableFloatBooleanMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = UnmodifiableFloatBooleanMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = UnmodifiableFloatBooleanMapKeySetTest::sumConsistentRounding;
            this.payloads.average = UnmodifiableFloatBooleanMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableFloatBooleanMapKeySetTest::averageIfEmpty;
            this.payloads.median = UnmodifiableFloatBooleanMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableFloatBooleanMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableFloatBooleanMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableFloatBooleanMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = UnmodifiableFloatBooleanMapKeySetTest::testToString;
            this.payloads.makeString = UnmodifiableFloatBooleanMapKeySetTest::makeString;
            this.payloads.appendString = UnmodifiableFloatBooleanMapKeySetTest::appendString;
            this.payloads.toList = UnmodifiableFloatBooleanMapKeySetTest::toList;
            this.payloads.toSortedList = UnmodifiableFloatBooleanMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableFloatBooleanMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableFloatBooleanMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableFloatBooleanMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableFloatBooleanMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = UnmodifiableFloatBooleanMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableFloatBooleanMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableFloatBooleanMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableFloatBooleanMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableFloatBooleanMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableFloatBooleanMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableFloatBooleanMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableFloatBooleanMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableFloatBooleanMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableFloatBooleanMapKeySetTest::reduceIfEmpty;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.newEmpty = UnmodifiableFloatBooleanMapKeySetTest::newEmpty;
            this.payloads.size = UnmodifiableFloatBooleanMapKeySetTest::size;
            this.payloads.isEmpty = UnmodifiableFloatBooleanMapKeySetTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableFloatBooleanMapKeySetTest::notEmpty;
            this.payloads.testOfAllFactory = UnmodifiableFloatBooleanMapKeySetTest::testOfAllFactory;
            this.payloads.floatIterator = UnmodifiableFloatBooleanMapKeySetTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableFloatBooleanMapKeySetTest::injectInto;
            this.payloads.forEach = UnmodifiableFloatBooleanMapKeySetTest::forEach;
            this.payloads.count = UnmodifiableFloatBooleanMapKeySetTest::count;
            this.payloads.select = UnmodifiableFloatBooleanMapKeySetTest::select;
            this.payloads.reject = UnmodifiableFloatBooleanMapKeySetTest::reject;
            this.payloads.detectIfNone = UnmodifiableFloatBooleanMapKeySetTest::detectIfNone;
            this.payloads.collect = UnmodifiableFloatBooleanMapKeySetTest::collect;
            this.payloads.toSortedArray = UnmodifiableFloatBooleanMapKeySetTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableFloatBooleanMapKeySetTest::testEquals;
            this.payloads.toBag = UnmodifiableFloatBooleanMapKeySetTest::toBag;
            this.payloads.asLazy = UnmodifiableFloatBooleanMapKeySetTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableFloatBooleanMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableFloatBooleanMapKeySetTest::asUnmodifiable;
            this.payloads.union = UnmodifiableFloatBooleanMapKeySetTest::union;
            this.payloads.intersect = UnmodifiableFloatBooleanMapKeySetTest::intersect;
            this.payloads.difference = UnmodifiableFloatBooleanMapKeySetTest::difference;
            this.payloads.symmetricDifference = UnmodifiableFloatBooleanMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = UnmodifiableFloatBooleanMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableFloatBooleanMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = UnmodifiableFloatBooleanMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NaN = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::add_NaN, java.lang.UnsupportedOperationException.class);
            this.payloads.add_POSITIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::add_POSITIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.add_NEGATIVE_INFINITY = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::add_NEGATIVE_INFINITY, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.freeze = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::freeze, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableFloatBooleanMapKeySetTest::contains;
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatBooleanMapKeySetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.noneSatisfy = UnmodifiableFloatBooleanMapKeySetTest::noneSatisfy;
            this.payloads.sum = UnmodifiableFloatBooleanMapKeySetTest::sum;
            this.payloads.testHashCode = UnmodifiableFloatBooleanMapKeySetTest::testHashCode;
            this.payloads.floatIterator_with_remove = UnmodifiableFloatBooleanMapKeySetTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = UnmodifiableFloatBooleanMapKeySetTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = UnmodifiableFloatBooleanMapKeySetTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.chunk = UnmodifiableFloatBooleanMapKeySetTest::chunk;
        }
    }
}
