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

import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractLongSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongCharMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableLongCharMapKeySetTest extends AbstractLongSetTestCase {

    @Override
    protected MutableLongSet classUnderTest() {
        return new UnmodifiableLongCharMap(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3)).keySet();
    }

    @Override
    protected MutableLongSet newWith(long... elements) {
        LongCharHashMap map = new LongCharHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (char) i);
        }
        return map.asUnmodifiable().keySet();
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
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(LongPredicates.equal(1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1L));
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
    public void longIterator_with_remove() {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void longIterator_throws_for_remove_before_next() {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void longIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableLongCharMapKeySetTest instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableLongCharMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongCharMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableLongCharMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableLongCharMapKeySetTest::newCollection;
            this.payloads.tap = UnmodifiableLongCharMapKeySetTest::tap;
            this.payloads.containsAllArray = UnmodifiableLongCharMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableLongCharMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableLongCharMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableLongCharMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableLongCharMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableLongCharMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = UnmodifiableLongCharMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableLongCharMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = UnmodifiableLongCharMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableLongCharMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableLongCharMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableLongCharMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableLongCharMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableLongCharMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableLongCharMapKeySetTest::rejectWithTarget;
            this.payloads.max = UnmodifiableLongCharMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableLongCharMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableLongCharMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableLongCharMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = UnmodifiableLongCharMapKeySetTest::summaryStatistics;
            this.payloads.average = UnmodifiableLongCharMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableLongCharMapKeySetTest::averageIfEmpty;
            this.payloads.median = UnmodifiableLongCharMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableLongCharMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableLongCharMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableLongCharMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = UnmodifiableLongCharMapKeySetTest::testToString;
            this.payloads.makeString = UnmodifiableLongCharMapKeySetTest::makeString;
            this.payloads.appendString = UnmodifiableLongCharMapKeySetTest::appendString;
            this.payloads.toList = UnmodifiableLongCharMapKeySetTest::toList;
            this.payloads.toSortedList = UnmodifiableLongCharMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableLongCharMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableLongCharMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableLongCharMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableLongCharMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = UnmodifiableLongCharMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableLongCharMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableLongCharMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableLongCharMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableLongCharMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableLongCharMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableLongCharMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableLongCharMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableLongCharMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableLongCharMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = UnmodifiableLongCharMapKeySetTest::chunk;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = UnmodifiableLongCharMapKeySetTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = UnmodifiableLongCharMapKeySetTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = UnmodifiableLongCharMapKeySetTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = UnmodifiableLongCharMapKeySetTest::newEmpty;
            this.payloads.size = UnmodifiableLongCharMapKeySetTest::size;
            this.payloads.isEmpty = UnmodifiableLongCharMapKeySetTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableLongCharMapKeySetTest::notEmpty;
            this.payloads.testOfAllFactory = UnmodifiableLongCharMapKeySetTest::testOfAllFactory;
            this.payloads.longIterator = UnmodifiableLongCharMapKeySetTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableLongCharMapKeySetTest::injectInto;
            this.payloads.forEach = UnmodifiableLongCharMapKeySetTest::forEach;
            this.payloads.count = UnmodifiableLongCharMapKeySetTest::count;
            this.payloads.select = UnmodifiableLongCharMapKeySetTest::select;
            this.payloads.reject = UnmodifiableLongCharMapKeySetTest::reject;
            this.payloads.detectIfNone = UnmodifiableLongCharMapKeySetTest::detectIfNone;
            this.payloads.collect = UnmodifiableLongCharMapKeySetTest::collect;
            this.payloads.toSortedArray = UnmodifiableLongCharMapKeySetTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableLongCharMapKeySetTest::testEquals;
            this.payloads.testHashCode = UnmodifiableLongCharMapKeySetTest::testHashCode;
            this.payloads.toBag = UnmodifiableLongCharMapKeySetTest::toBag;
            this.payloads.asLazy = UnmodifiableLongCharMapKeySetTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableLongCharMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableLongCharMapKeySetTest::asUnmodifiable;
            this.payloads.union = UnmodifiableLongCharMapKeySetTest::union;
            this.payloads.intersect = UnmodifiableLongCharMapKeySetTest::intersect;
            this.payloads.difference = UnmodifiableLongCharMapKeySetTest::difference;
            this.payloads.symmetricDifference = UnmodifiableLongCharMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = UnmodifiableLongCharMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableLongCharMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = UnmodifiableLongCharMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongCharMapKeySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableLongCharMapKeySetTest::contains;
            this.payloads.noneSatisfy = UnmodifiableLongCharMapKeySetTest::noneSatisfy;
            this.payloads.sum = UnmodifiableLongCharMapKeySetTest::sum;
        }
    }
}
