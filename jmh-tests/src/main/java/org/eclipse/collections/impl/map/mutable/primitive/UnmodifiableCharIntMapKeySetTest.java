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

import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractCharSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharIntMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableCharIntMapKeySetTest extends AbstractCharSetTestCase {

    @Override
    protected MutableCharSet classUnderTest() {
        return new UnmodifiableCharIntMap(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3)).keySet();
    }

    @Override
    protected MutableCharSet newWith(char... elements) {
        CharIntHashMap map = new CharIntHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asUnmodifiable().keySet();
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
    public void without() {
        this.classUnderTest().without((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(CharPredicates.equal((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(new CharArrayList());
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
        Assert.assertTrue(this.classUnderTest().contains((char) 1));
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

    @Override
    public void charIterator_with_remove() {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void charIterator_throws_for_remove_before_next() {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void charIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableCharIntMapKeySetTest instance;

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
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableCharIntMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableCharIntMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableCharIntMapKeySetTest::newCollection;
            this.payloads.tap = UnmodifiableCharIntMapKeySetTest::tap;
            this.payloads.containsAllArray = UnmodifiableCharIntMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableCharIntMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableCharIntMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableCharIntMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableCharIntMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableCharIntMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = UnmodifiableCharIntMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableCharIntMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = UnmodifiableCharIntMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableCharIntMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableCharIntMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableCharIntMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableCharIntMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableCharIntMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableCharIntMapKeySetTest::rejectWithTarget;
            this.payloads.max = UnmodifiableCharIntMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableCharIntMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableCharIntMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableCharIntMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = UnmodifiableCharIntMapKeySetTest::summaryStatistics;
            this.payloads.average = UnmodifiableCharIntMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableCharIntMapKeySetTest::averageIfEmpty;
            this.payloads.median = UnmodifiableCharIntMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableCharIntMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableCharIntMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableCharIntMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = UnmodifiableCharIntMapKeySetTest::testToString;
            this.payloads.makeString = UnmodifiableCharIntMapKeySetTest::makeString;
            this.payloads.appendString = UnmodifiableCharIntMapKeySetTest::appendString;
            this.payloads.toList = UnmodifiableCharIntMapKeySetTest::toList;
            this.payloads.toSortedList = UnmodifiableCharIntMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableCharIntMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableCharIntMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableCharIntMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableCharIntMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = UnmodifiableCharIntMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableCharIntMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableCharIntMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableCharIntMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableCharIntMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableCharIntMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableCharIntMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableCharIntMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableCharIntMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableCharIntMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = UnmodifiableCharIntMapKeySetTest::chunk;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = UnmodifiableCharIntMapKeySetTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = UnmodifiableCharIntMapKeySetTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = UnmodifiableCharIntMapKeySetTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = UnmodifiableCharIntMapKeySetTest::newEmpty;
            this.payloads.size = UnmodifiableCharIntMapKeySetTest::size;
            this.payloads.isEmpty = UnmodifiableCharIntMapKeySetTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableCharIntMapKeySetTest::notEmpty;
            this.payloads.testOfAllFactory = UnmodifiableCharIntMapKeySetTest::testOfAllFactory;
            this.payloads.charIterator = UnmodifiableCharIntMapKeySetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableCharIntMapKeySetTest::injectInto;
            this.payloads.forEach = UnmodifiableCharIntMapKeySetTest::forEach;
            this.payloads.count = UnmodifiableCharIntMapKeySetTest::count;
            this.payloads.select = UnmodifiableCharIntMapKeySetTest::select;
            this.payloads.reject = UnmodifiableCharIntMapKeySetTest::reject;
            this.payloads.detectIfNone = UnmodifiableCharIntMapKeySetTest::detectIfNone;
            this.payloads.collect = UnmodifiableCharIntMapKeySetTest::collect;
            this.payloads.toSortedArray = UnmodifiableCharIntMapKeySetTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableCharIntMapKeySetTest::testEquals;
            this.payloads.testHashCode = UnmodifiableCharIntMapKeySetTest::testHashCode;
            this.payloads.toBag = UnmodifiableCharIntMapKeySetTest::toBag;
            this.payloads.asLazy = UnmodifiableCharIntMapKeySetTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableCharIntMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableCharIntMapKeySetTest::asUnmodifiable;
            this.payloads.union = UnmodifiableCharIntMapKeySetTest::union;
            this.payloads.intersect = UnmodifiableCharIntMapKeySetTest::intersect;
            this.payloads.difference = UnmodifiableCharIntMapKeySetTest::difference;
            this.payloads.symmetricDifference = UnmodifiableCharIntMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = UnmodifiableCharIntMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableCharIntMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = UnmodifiableCharIntMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapKeySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableCharIntMapKeySetTest::contains;
            this.payloads.noneSatisfy = UnmodifiableCharIntMapKeySetTest::noneSatisfy;
            this.payloads.sum = UnmodifiableCharIntMapKeySetTest::sum;
        }
    }
}
