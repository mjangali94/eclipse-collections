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

import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractShortSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortCharMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeySetTest.stg.
 */
public class SynchronizedShortCharMapKeySetTest extends AbstractShortSetTestCase {

    @Override
    protected MutableShortSet classUnderTest() {
        return new SynchronizedShortCharMap(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3)).keySet();
    }

    @Override
    protected MutableShortSet newWith(short... elements) {
        ShortCharHashMap map = new ShortCharHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (char) i);
        }
        return map.asSynchronized().keySet();
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
    public void withAll() {
        this.classUnderTest().withAll(new ShortArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableShortSet set = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortSet setWithout = set.without((short) 2);
        Assert.assertSame(set, setWithout);
        MutableShortSet expectedSet = this.newWith((short) 1, (short) 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
        Assert.assertEquals(expectedSet.toList(), setWithout.without((short) 4).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableShortSet set = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortSet setWithout = set.withoutAll(new ShortArrayList((short) 2, (short) 4));
        Assert.assertSame(set, setWithout);
        MutableShortSet expectedSet = this.newWith((short) 1, (short) 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedShortCharMapKeySetTest instance;

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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortCharMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedShortCharMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedShortCharMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedShortCharMapKeySetTest::tap;
            this.payloads.containsAllArray = SynchronizedShortCharMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedShortCharMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedShortCharMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedShortCharMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedShortCharMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedShortCharMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedShortCharMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortCharMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedShortCharMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedShortCharMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedShortCharMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedShortCharMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedShortCharMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedShortCharMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedShortCharMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedShortCharMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedShortCharMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortCharMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortCharMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedShortCharMapKeySetTest::summaryStatistics;
            this.payloads.average = SynchronizedShortCharMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedShortCharMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedShortCharMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedShortCharMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedShortCharMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedShortCharMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedShortCharMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedShortCharMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedShortCharMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedShortCharMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedShortCharMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedShortCharMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedShortCharMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedShortCharMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedShortCharMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedShortCharMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedShortCharMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedShortCharMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedShortCharMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedShortCharMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedShortCharMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedShortCharMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedShortCharMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedShortCharMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedShortCharMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedShortCharMapKeySetTest::chunk;
            this.payloads.contains = SynchronizedShortCharMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedShortCharMapKeySetTest::removeIf;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = SynchronizedShortCharMapKeySetTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = SynchronizedShortCharMapKeySetTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = SynchronizedShortCharMapKeySetTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedShortCharMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedShortCharMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedShortCharMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortCharMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedShortCharMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedShortCharMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedShortCharMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedShortCharMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedShortCharMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedShortCharMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedShortCharMapKeySetTest::retainAll_iterable;
            this.payloads.shortIterator = SynchronizedShortCharMapKeySetTest::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedShortCharMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedShortCharMapKeySetTest::forEach;
            this.payloads.count = SynchronizedShortCharMapKeySetTest::count;
            this.payloads.select = SynchronizedShortCharMapKeySetTest::select;
            this.payloads.reject = SynchronizedShortCharMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedShortCharMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedShortCharMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedShortCharMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedShortCharMapKeySetTest::testEquals;
            this.payloads.testHashCode = SynchronizedShortCharMapKeySetTest::testHashCode;
            this.payloads.toBag = SynchronizedShortCharMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedShortCharMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedShortCharMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedShortCharMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedShortCharMapKeySetTest::union;
            this.payloads.intersect = SynchronizedShortCharMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedShortCharMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedShortCharMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedShortCharMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedShortCharMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedShortCharMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedShortCharMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedShortCharMapKeySetTest::withoutAll;
            this.payloads.noneSatisfy = SynchronizedShortCharMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedShortCharMapKeySetTest::sum;
        }
    }
}
