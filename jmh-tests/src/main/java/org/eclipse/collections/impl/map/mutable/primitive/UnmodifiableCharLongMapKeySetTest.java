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
 * JUnit test for {@link UnmodifiableCharLongMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableCharLongMapKeySetTest extends AbstractCharSetTestCase {

    @Override
    protected MutableCharSet classUnderTest() {
        return new UnmodifiableCharLongMap(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L)).keySet();
    }

    @Override
    protected MutableCharSet newWith(char... elements) {
        CharLongHashMap map = new CharLongHashMap();
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

        private UnmodifiableCharLongMapKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableCharLongMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharLongMapKeySetTest> sum;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableCharLongMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableCharLongMapKeySetTest::newCollection;
            this.payloads.tap = UnmodifiableCharLongMapKeySetTest::tap;
            this.payloads.containsAllArray = UnmodifiableCharLongMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableCharLongMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableCharLongMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableCharLongMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableCharLongMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableCharLongMapKeySetTest::containsNoneIterable;
            this.payloads.anySatisfy = UnmodifiableCharLongMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableCharLongMapKeySetTest::allSatisfy;
            this.payloads.collectWithTarget = UnmodifiableCharLongMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableCharLongMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableCharLongMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableCharLongMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableCharLongMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableCharLongMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableCharLongMapKeySetTest::rejectWithTarget;
            this.payloads.max = UnmodifiableCharLongMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableCharLongMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableCharLongMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableCharLongMapKeySetTest::maxIfEmpty;
            this.payloads.summaryStatistics = UnmodifiableCharLongMapKeySetTest::summaryStatistics;
            this.payloads.average = UnmodifiableCharLongMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableCharLongMapKeySetTest::averageIfEmpty;
            this.payloads.median = UnmodifiableCharLongMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableCharLongMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableCharLongMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableCharLongMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = UnmodifiableCharLongMapKeySetTest::testToString;
            this.payloads.makeString = UnmodifiableCharLongMapKeySetTest::makeString;
            this.payloads.appendString = UnmodifiableCharLongMapKeySetTest::appendString;
            this.payloads.toList = UnmodifiableCharLongMapKeySetTest::toList;
            this.payloads.toSortedList = UnmodifiableCharLongMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableCharLongMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableCharLongMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableCharLongMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableCharLongMapKeySetTest::toSet;
            this.payloads.injectIntoBoolean = UnmodifiableCharLongMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableCharLongMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableCharLongMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableCharLongMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableCharLongMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableCharLongMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableCharLongMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableCharLongMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableCharLongMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableCharLongMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = UnmodifiableCharLongMapKeySetTest::chunk;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = UnmodifiableCharLongMapKeySetTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = UnmodifiableCharLongMapKeySetTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = UnmodifiableCharLongMapKeySetTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = UnmodifiableCharLongMapKeySetTest::newEmpty;
            this.payloads.size = UnmodifiableCharLongMapKeySetTest::size;
            this.payloads.isEmpty = UnmodifiableCharLongMapKeySetTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableCharLongMapKeySetTest::notEmpty;
            this.payloads.testOfAllFactory = UnmodifiableCharLongMapKeySetTest::testOfAllFactory;
            this.payloads.charIterator = UnmodifiableCharLongMapKeySetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableCharLongMapKeySetTest::injectInto;
            this.payloads.forEach = UnmodifiableCharLongMapKeySetTest::forEach;
            this.payloads.count = UnmodifiableCharLongMapKeySetTest::count;
            this.payloads.select = UnmodifiableCharLongMapKeySetTest::select;
            this.payloads.reject = UnmodifiableCharLongMapKeySetTest::reject;
            this.payloads.detectIfNone = UnmodifiableCharLongMapKeySetTest::detectIfNone;
            this.payloads.collect = UnmodifiableCharLongMapKeySetTest::collect;
            this.payloads.toSortedArray = UnmodifiableCharLongMapKeySetTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableCharLongMapKeySetTest::testEquals;
            this.payloads.testHashCode = UnmodifiableCharLongMapKeySetTest::testHashCode;
            this.payloads.toBag = UnmodifiableCharLongMapKeySetTest::toBag;
            this.payloads.asLazy = UnmodifiableCharLongMapKeySetTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableCharLongMapKeySetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableCharLongMapKeySetTest::asUnmodifiable;
            this.payloads.union = UnmodifiableCharLongMapKeySetTest::union;
            this.payloads.intersect = UnmodifiableCharLongMapKeySetTest::intersect;
            this.payloads.difference = UnmodifiableCharLongMapKeySetTest::difference;
            this.payloads.symmetricDifference = UnmodifiableCharLongMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = UnmodifiableCharLongMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableCharLongMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = UnmodifiableCharLongMapKeySetTest::cartesianProduct;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharLongMapKeySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableCharLongMapKeySetTest::contains;
            this.payloads.noneSatisfy = UnmodifiableCharLongMapKeySetTest::noneSatisfy;
            this.payloads.sum = UnmodifiableCharLongMapKeySetTest::sum;
        }
    }
}
