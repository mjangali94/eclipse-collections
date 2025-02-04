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

import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractCharSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedCharObjectMap#keySet()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeySetTest.stg.
 */
public class SynchronizedCharObjectMapKeySetTest extends AbstractCharSetTestCase {

    @Override
    protected MutableCharSet classUnderTest() {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3)).keySet();
    }

    @Override
    protected MutableCharSet newWith(char... elements) {
        CharObjectHashMap<Integer> map = new CharObjectHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asSynchronized().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((char) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new CharArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableCharSet set = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharSet setWithout = set.without((char) 2);
        Assert.assertSame(set, setWithout);
        MutableCharSet expectedSet = this.newWith((char) 1, (char) 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
        Assert.assertEquals(expectedSet.toList(), setWithout.without((char) 4).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableCharSet set = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharSet setWithout = set.withoutAll(new CharArrayList((char) 2, (char) 4));
        Assert.assertSame(set, setWithout);
        MutableCharSet expectedSet = this.newWith((char) 1, (char) 3);
        Assert.assertEquals(expectedSet.toList(), setWithout.toList());
    }

    @Override
    public void testEquals() {
        MutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        MutableCharSet set3 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1);
        MutableCharSet set4 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1, (char) 1);
        MutableCharSet set5 = this.newWith((char) 32, (char) 1);
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
        Assert.assertFalse(this.newWith((char) 0, (char) 1, (char) 2).noneSatisfy(CharPredicates.equal((char) 0)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 2).sum());
    }

    @Override
    public void testHashCode() {
        MutableCharSet set1 = this.newWith((char) 0, (char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1, (char) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 31, (char) 32).hashCode(), set1.hashCode());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedCharObjectMapKeySetTest instance;

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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharObjectMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedCharObjectMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedCharObjectMapKeySetTest::newCollection;
            this.payloads.tap = SynchronizedCharObjectMapKeySetTest::tap;
            this.payloads.containsAllArray = SynchronizedCharObjectMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedCharObjectMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedCharObjectMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedCharObjectMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedCharObjectMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedCharObjectMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedCharObjectMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharObjectMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = SynchronizedCharObjectMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedCharObjectMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedCharObjectMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedCharObjectMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedCharObjectMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedCharObjectMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedCharObjectMapKeySetTest::rejectWithTarget;
            this.payloads.max = SynchronizedCharObjectMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedCharObjectMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharObjectMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharObjectMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedCharObjectMapKeySetTest::summaryStatistics;
            this.payloads.average = SynchronizedCharObjectMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedCharObjectMapKeySetTest::averageIfEmpty;
            this.payloads.median = SynchronizedCharObjectMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedCharObjectMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedCharObjectMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedCharObjectMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedCharObjectMapKeySetTest::testToString;
            this.payloads.makeString = SynchronizedCharObjectMapKeySetTest::makeString;
            this.payloads.appendString = SynchronizedCharObjectMapKeySetTest::appendString;
            this.payloads.toList = SynchronizedCharObjectMapKeySetTest::toList;
            this.payloads.toSortedList = SynchronizedCharObjectMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedCharObjectMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedCharObjectMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedCharObjectMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedCharObjectMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = SynchronizedCharObjectMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedCharObjectMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedCharObjectMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedCharObjectMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedCharObjectMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedCharObjectMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedCharObjectMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedCharObjectMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedCharObjectMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedCharObjectMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedCharObjectMapKeySetTest::chunk;
            this.payloads.contains = SynchronizedCharObjectMapKeySetTest::contains;
            this.payloads.removeIf = SynchronizedCharObjectMapKeySetTest::removeIf;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = SynchronizedCharObjectMapKeySetTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = SynchronizedCharObjectMapKeySetTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = SynchronizedCharObjectMapKeySetTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedCharObjectMapKeySetTest::newEmpty;
            this.payloads.size = SynchronizedCharObjectMapKeySetTest::size;
            this.payloads.isEmpty = SynchronizedCharObjectMapKeySetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharObjectMapKeySetTest::notEmpty;
            this.payloads.clear = SynchronizedCharObjectMapKeySetTest::clear;
            this.payloads.testOfAllFactory = SynchronizedCharObjectMapKeySetTest::testOfAllFactory;
            this.payloads.remove = SynchronizedCharObjectMapKeySetTest::remove;
            this.payloads.removeAll = SynchronizedCharObjectMapKeySetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedCharObjectMapKeySetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedCharObjectMapKeySetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedCharObjectMapKeySetTest::retainAll_iterable;
            this.payloads.charIterator = SynchronizedCharObjectMapKeySetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedCharObjectMapKeySetTest::injectInto;
            this.payloads.forEach = SynchronizedCharObjectMapKeySetTest::forEach;
            this.payloads.count = SynchronizedCharObjectMapKeySetTest::count;
            this.payloads.select = SynchronizedCharObjectMapKeySetTest::select;
            this.payloads.reject = SynchronizedCharObjectMapKeySetTest::reject;
            this.payloads.detectIfNone = SynchronizedCharObjectMapKeySetTest::detectIfNone;
            this.payloads.collect = SynchronizedCharObjectMapKeySetTest::collect;
            this.payloads.toSortedArray = SynchronizedCharObjectMapKeySetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedCharObjectMapKeySetTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharObjectMapKeySetTest::testHashCode;
            this.payloads.toBag = SynchronizedCharObjectMapKeySetTest::toBag;
            this.payloads.asLazy = SynchronizedCharObjectMapKeySetTest::asLazy;
            this.payloads.asSynchronized = SynchronizedCharObjectMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedCharObjectMapKeySetTest::asUnmodifiable;
            this.payloads.union = SynchronizedCharObjectMapKeySetTest::union;
            this.payloads.intersect = SynchronizedCharObjectMapKeySetTest::intersect;
            this.payloads.difference = SynchronizedCharObjectMapKeySetTest::difference;
            this.payloads.symmetricDifference = SynchronizedCharObjectMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedCharObjectMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedCharObjectMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedCharObjectMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedCharObjectMapKeySetTest::without;
            this.payloads.withoutAll = SynchronizedCharObjectMapKeySetTest::withoutAll;
            this.payloads.noneSatisfy = SynchronizedCharObjectMapKeySetTest::noneSatisfy;
            this.payloads.sum = SynchronizedCharObjectMapKeySetTest::sum;
        }
    }
}
