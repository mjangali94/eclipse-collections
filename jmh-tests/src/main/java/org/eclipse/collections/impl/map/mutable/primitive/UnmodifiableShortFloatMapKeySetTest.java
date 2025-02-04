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

import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractShortSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortFloatMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableShortFloatMapKeySetTest extends AbstractShortSetTestCase {

    @Override
    protected MutableShortSet classUnderTest() {
        return new UnmodifiableShortFloatMap(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f)).keySet();
    }

    @Override
    protected MutableShortSet newWith(short... elements) {
        ShortFloatHashMap map = new ShortFloatHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asUnmodifiable().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((short) 0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove((short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(ShortPredicates.equal((short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(new ShortArrayList());
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
        Assert.assertTrue(this.classUnderTest().contains((short) 1));
    }

    @Override
    public void testEquals() {
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        MutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        MutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
        MutableShortSet set5 = this.newWith((short) 32, (short) 1);
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
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 2).noneSatisfy(ShortPredicates.equal((short) 0)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3L, this.newWith((short) 0, (short) 1, (short) 2).sum());
    }

    @Override
    public void testHashCode() {
        MutableShortSet set1 = this.newWith((short) 0, (short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1, (short) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 31, (short) 32).hashCode(), set1.hashCode());
    }

    @Override
    public void shortIterator_with_remove() {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_remove_before_next() {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableShortFloatMapKeySetTest instance;

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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableShortFloatMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortFloatMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableShortFloatMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableShortFloatMapKeySetTest::newCollection;
            this.payloads.tap = UnmodifiableShortFloatMapKeySetTest::tap;
            this.payloads.containsAllArray = UnmodifiableShortFloatMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableShortFloatMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableShortFloatMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableShortFloatMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableShortFloatMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableShortFloatMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = UnmodifiableShortFloatMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableShortFloatMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = UnmodifiableShortFloatMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableShortFloatMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableShortFloatMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableShortFloatMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableShortFloatMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableShortFloatMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableShortFloatMapKeySetTest::rejectWithTarget;
            this.payloads.max = UnmodifiableShortFloatMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableShortFloatMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableShortFloatMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableShortFloatMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = UnmodifiableShortFloatMapKeySetTest::summaryStatistics;
            this.payloads.average = UnmodifiableShortFloatMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableShortFloatMapKeySetTest::averageIfEmpty;
            this.payloads.median = UnmodifiableShortFloatMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableShortFloatMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableShortFloatMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableShortFloatMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = UnmodifiableShortFloatMapKeySetTest::testToString;
            this.payloads.makeString = UnmodifiableShortFloatMapKeySetTest::makeString;
            this.payloads.appendString = UnmodifiableShortFloatMapKeySetTest::appendString;
            this.payloads.toList = UnmodifiableShortFloatMapKeySetTest::toList;
            this.payloads.toSortedList = UnmodifiableShortFloatMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableShortFloatMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableShortFloatMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableShortFloatMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableShortFloatMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = UnmodifiableShortFloatMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableShortFloatMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableShortFloatMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableShortFloatMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableShortFloatMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableShortFloatMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableShortFloatMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableShortFloatMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableShortFloatMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableShortFloatMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = UnmodifiableShortFloatMapKeySetTest::chunk;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = UnmodifiableShortFloatMapKeySetTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = UnmodifiableShortFloatMapKeySetTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = UnmodifiableShortFloatMapKeySetTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = UnmodifiableShortFloatMapKeySetTest::newEmpty;
            this.payloads.size = UnmodifiableShortFloatMapKeySetTest::size;
            this.payloads.isEmpty = UnmodifiableShortFloatMapKeySetTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableShortFloatMapKeySetTest::notEmpty;
            this.payloads.testOfAllFactory = UnmodifiableShortFloatMapKeySetTest::testOfAllFactory;
            this.payloads.shortIterator = UnmodifiableShortFloatMapKeySetTest::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableShortFloatMapKeySetTest::injectInto;
            this.payloads.forEach = UnmodifiableShortFloatMapKeySetTest::forEach;
            this.payloads.count = UnmodifiableShortFloatMapKeySetTest::count;
            this.payloads.select = UnmodifiableShortFloatMapKeySetTest::select;
            this.payloads.reject = UnmodifiableShortFloatMapKeySetTest::reject;
            this.payloads.detectIfNone = UnmodifiableShortFloatMapKeySetTest::detectIfNone;
            this.payloads.collect = UnmodifiableShortFloatMapKeySetTest::collect;
            this.payloads.toSortedArray = UnmodifiableShortFloatMapKeySetTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableShortFloatMapKeySetTest::testEquals;
            this.payloads.testHashCode = UnmodifiableShortFloatMapKeySetTest::testHashCode;
            this.payloads.toBag = UnmodifiableShortFloatMapKeySetTest::toBag;
            this.payloads.asLazy = UnmodifiableShortFloatMapKeySetTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableShortFloatMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableShortFloatMapKeySetTest::asUnmodifiable;
            this.payloads.union = UnmodifiableShortFloatMapKeySetTest::union;
            this.payloads.intersect = UnmodifiableShortFloatMapKeySetTest::intersect;
            this.payloads.difference = UnmodifiableShortFloatMapKeySetTest::difference;
            this.payloads.symmetricDifference = UnmodifiableShortFloatMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = UnmodifiableShortFloatMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableShortFloatMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = UnmodifiableShortFloatMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortFloatMapKeySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableShortFloatMapKeySetTest::contains;
            this.payloads.noneSatisfy = UnmodifiableShortFloatMapKeySetTest::noneSatisfy;
            this.payloads.sum = UnmodifiableShortFloatMapKeySetTest::sum;
        }
    }
}
