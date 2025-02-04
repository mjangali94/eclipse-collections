/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.ThrowingAppendable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public class IntervalTest {

    @Test
    public void into() {
        int sum = Interval.oneTo(5).select(Predicates.lessThan(5)).into(FastList.newList()).injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(10, sum);
    }

    @Test
    public void fromToExclusive() {
        // Positive forward
        Verify.assertEqualsAndHashCode(Interval.from(1), Interval.fromToExclusive(1, 2));
        Verify.assertEqualsAndHashCode(Interval.fromTo(1, 10), Interval.fromToExclusive(1, 11));
        // Positive reverse
        Verify.assertEqualsAndHashCode(Interval.from(2), Interval.fromToExclusive(2, 1));
        Verify.assertEqualsAndHashCode(Interval.fromTo(10, 2), Interval.fromToExclusive(10, 1));
        // Negative forward
        Verify.assertEqualsAndHashCode(Interval.from(-1), Interval.fromToExclusive(-1, 0));
        Verify.assertEqualsAndHashCode(Interval.fromTo(-10, -1), Interval.fromToExclusive(-10, 0));
        // Negative reverse
        Verify.assertEqualsAndHashCode(Interval.from(-1), Interval.fromToExclusive(-1, 0));
        Verify.assertEqualsAndHashCode(Interval.fromTo(-1, -10), Interval.fromToExclusive(-1, -11));
        // MIN Value should throw an error
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromToExclusive(Integer.MIN_VALUE, Integer.MIN_VALUE));
        Verify.assertSize(Integer.MAX_VALUE, Interval.fromToExclusive(Integer.MIN_VALUE, -1));
        Verify.assertSize(Integer.MAX_VALUE, Interval.fromToExclusive(0, Integer.MAX_VALUE));
        Verify.assertSize(10, Interval.fromToExclusive(0, 10));
        Verify.assertSize(10, Interval.fromToExclusive(-10, 0));
        Verify.assertSize(20, Interval.fromToExclusive(-10, 10));
        this.compareRangeAndInterval(0, 10);
        this.compareRangeAndInterval(-1, 1);
        this.compareRangeAndInterval(-10, 10);
    }

    private void compareRangeAndInterval(int start, int end) {
        ImmutableList<Integer> rangeList = Lists.immutable.fromStream(IntStream.range(start, end).boxed());
        ImmutableList<Integer> intervalList = Lists.immutable.fromStream(Interval.fromToExclusive(start, end).stream());
        Verify.assertEqualsAndHashCode(rangeList, intervalList);
    }

    @Test
    public void fromAndToAndBy() {
        Interval interval = Interval.from(1);
        Interval interval2 = interval.to(10);
        Interval interval3 = interval2.by(2);
        Verify.assertEqualsAndHashCode(interval, Interval.fromTo(1, 1));
        Verify.assertEqualsAndHashCode(interval2, Interval.fromTo(1, 10));
        Verify.assertEqualsAndHashCode(interval3, Interval.fromToBy(1, 10, 2));
        Verify.assertSize(Integer.MAX_VALUE, Interval.fromTo(Integer.MIN_VALUE + 1, -1));
        Verify.assertSize(Integer.MAX_VALUE, Interval.fromTo(1, Integer.MAX_VALUE));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromTo(Integer.MIN_VALUE, Integer.MAX_VALUE));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromTo(-1, Integer.MAX_VALUE));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromToBy(Integer.MIN_VALUE, Integer.MAX_VALUE, 2));
        Verify.assertSize(Interval.fromTo(Integer.MIN_VALUE + 1, -1).size(), Interval.oneTo(Integer.MAX_VALUE));
        Assert.assertEquals(Lists.mutable.with(0), Interval.fromToBy(0, 2, 3));
        Assert.assertEquals(Lists.mutable.with(0), Interval.fromToBy(0, -2, -3));
        Assert.assertEquals(Lists.mutable.with(1_000_000_000), Interval.fromToBy(1_000_000_000, 2_000_000_000, 1_500_000_000));
        Assert.assertEquals(Lists.mutable.with(-1_000_000_000), Interval.fromToBy(-1_000_000_000, -2_000_000_000, -1_500_000_000));
        Assert.assertEquals(Lists.mutable.with(Integer.MIN_VALUE), Interval.fromToBy(Integer.MIN_VALUE, Integer.MIN_VALUE + 10, 20));
        Assert.assertEquals(Lists.mutable.with(Integer.MAX_VALUE), Interval.fromToBy(Integer.MAX_VALUE, Integer.MAX_VALUE - 10, -20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromToBy_throws_step_size_zero() {
        Interval.fromToBy(0, 0, 0);
    }

    @Test
    public void fromToBy_with_same_start_and_end_with_negative_step() {
        MutableList<Integer> integers = Interval.fromToBy(2, 2, -2).toList();
        Verify.assertSize(1, integers);
        Verify.assertContains(2, integers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneToBy_throws_step_size_zero() {
        Interval.oneToBy(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroToBy_throws_step_size_zero() {
        Interval.zeroToBy(0, 0);
    }

    @Test
    public void equalsAndHashCode() {
        Interval interval1 = Interval.oneTo(5);
        Interval interval2 = Interval.oneTo(5);
        Interval interval3 = Interval.zeroTo(5);
        Verify.assertPostSerializedEqualsAndHashCode(interval1);
        Verify.assertEqualsAndHashCode(interval1, interval2);
        Assert.assertNotEquals(interval1, interval3);
        Assert.assertNotEquals(interval3, interval1);
        Verify.assertEqualsAndHashCode(Interval.fromToBy(1, 5, 2), Interval.fromToBy(1, 6, 2));
        Verify.assertEqualsAndHashCode(FastList.newListWith(1, 2, 3), Interval.fromTo(1, 3));
        Verify.assertEqualsAndHashCode(FastList.newListWith(3, 2, 1), Interval.fromTo(3, 1));
        Assert.assertNotEquals(FastList.newListWith(1, 2, 3, 4), Interval.fromTo(1, 3));
        Assert.assertNotEquals(FastList.newListWith(1, 2, 4), Interval.fromTo(1, 3));
        Assert.assertNotEquals(FastList.newListWith(3, 2, 0), Interval.fromTo(3, 1));
        Verify.assertEqualsAndHashCode(FastList.newListWith(-1, -2, -3), Interval.fromTo(-1, -3));
        Verify.assertEqualsAndHashCode(FastList.newListWith(1, 2), Interval.fromToExclusive(1, 3));
        Verify.assertEqualsAndHashCode(FastList.newListWith(3, 2, 1), Interval.fromToExclusive(3, 0));
        Assert.assertNotEquals(FastList.newListWith(1, 2, 3, 4), Interval.fromToExclusive(1, 4));
        Assert.assertNotEquals(FastList.newListWith(1, 2, 4), Interval.fromToExclusive(1, 2));
        Assert.assertNotEquals(FastList.newListWith(3, 2, 0), Interval.fromToExclusive(3, 1));
    }

    @Test
    public void forEachOnFromToInterval() {
        MutableList<Integer> result = Lists.mutable.of();
        Interval interval = Interval.oneTo(5);
        interval.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), result);
    }

    @Test
    public void forEachWithExecutor() {
        MutableList<Integer> result = Lists.mutable.of();
        Interval interval = Interval.oneTo(5);
        interval.forEach(CollectionAddProcedure.on(result), Executors.newSingleThreadExecutor());
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), result);
    }

    @Test
    public void forEachWithExecutorInReverse() {
        MutableList<Integer> result = Lists.mutable.of();
        Interval interval = Interval.fromToBy(5, 1, -1);
        interval.forEach(CollectionAddProcedure.on(result), Executors.newSingleThreadExecutor());
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), result);
    }

    @Test
    public void runWithExecutor() throws InterruptedException {
        MutableList<String> result = Lists.mutable.of();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Interval.oneTo(3).run(() -> result.add(null), service);
        service.shutdown();
        service.awaitTermination(20, TimeUnit.SECONDS);
        Assert.assertEquals(FastList.<String>newListWith(null, null, null), result);
    }

    @Test
    public void runWithExecutorInReverse() throws InterruptedException {
        MutableList<String> result = Lists.mutable.of();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Interval.fromTo(3, 1).run(() -> result.add(null), service);
        service.shutdown();
        service.awaitTermination(20, TimeUnit.SECONDS);
        Assert.assertEquals(FastList.<String>newListWith(null, null, null), result);
    }

    @Test
    public void reverseForEachOnFromToInterval() {
        List<Integer> result = new ArrayList<>();
        Interval interval = Interval.oneTo(5);
        interval.reverseForEach(result::add);
        Verify.assertSize(5, result);
        Verify.assertContains(1, result);
        Verify.assertContains(5, result);
        Assert.assertEquals(Integer.valueOf(5), Iterate.getFirst(result));
        Assert.assertEquals(Integer.valueOf(1), Iterate.getLast(result));
        result.clear();
        interval.reverseThis().reverseForEach(result::add);
        Verify.assertSize(5, result);
        Verify.assertContains(1, result);
        Verify.assertContains(5, result);
        Assert.assertEquals(Integer.valueOf(1), Iterate.getFirst(result));
        Assert.assertEquals(Integer.valueOf(5), Iterate.getLast(result));
    }

    @Test
    public void forEachOnFromToByInterval() {
        List<Integer> result = new ArrayList<>();
        Interval interval = Interval.fromToBy(1, 5, 2);
        interval.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContains(1, result);
        Verify.assertNotContains(2, result);
        Verify.assertContains(5, result);
    }

    @Test
    public void forEachOnFromToByInterval2() {
        List<Integer> result = new ArrayList<>();
        Interval interval = Interval.fromToBy(5, 1, -2);
        interval.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContains(1, result);
        Verify.assertNotContains(2, result);
        Verify.assertContains(5, result);
    }

    @Test
    public void injectIntoOnFromToByInterval() {
        Interval interval = Interval.oneTo(5);
        Assert.assertEquals(Integer.valueOf(20), interval.injectInto(5, AddFunction.INTEGER));
        Assert.assertEquals(Integer.valueOf(20), interval.reverseThis().injectInto(5, AddFunction.INTEGER));
    }

    @Test
    public void injectIntoOnFromToBySameStartEndNegativeStepInterval() {
        Interval interval = Interval.fromToBy(2, 2, -2);
        Assert.assertEquals(Integer.valueOf(0), interval.injectInto(-2, AddFunction.INTEGER));
        Assert.assertEquals(Integer.valueOf(0), interval.reverseThis().injectInto(-2, AddFunction.INTEGER));
    }

    @Test
    public void sumInterval() {
        int sum = Interval.oneTo(5).injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(15, sum);
    }

    @Test
    public void maxInterval() {
        Integer value = Interval.oneTo(5).injectInto(0, Integer::max);
        Assert.assertEquals(5, value.intValue());
    }

    @Test
    public void reverseInjectIntoOnFromToByInterval() {
        Interval interval = Interval.oneTo(5);
        Assert.assertEquals(Integer.valueOf(20), interval.reverseInjectInto(5, AddFunction.INTEGER));
        Assert.assertEquals(Integer.valueOf(20), interval.reverseThis().reverseInjectInto(5, AddFunction.INTEGER));
    }

    @Test
    public void collectOnFromToByInterval() {
        Interval interval = Interval.oneToBy(5, 2);
        LazyIterable<String> result = interval.collect(String::valueOf);
        Verify.assertIterableSize(3, result);
        Verify.assertContainsAll(result, "1", "5");
        Verify.assertNotContains("2", result);
    }

    @Test
    public void collectOnFromToInterval() {
        Interval interval = Interval.oneTo(5);
        LazyIterable<String> result = interval.collect(String::valueOf);
        Verify.assertIterableSize(5, result);
        Verify.assertContainsAll(result, "1", "5");
    }

    @Test
    public void selectOnFromToInterval() {
        Interval interval = Interval.oneTo(5);
        Assert.assertEquals(FastList.newListWith(2, 4), interval.select(IntegerPredicates.isEven()).toList());
        Assert.assertEquals(FastList.newListWith(4, 2), interval.reverseThis().select(IntegerPredicates.isEven()).toList());
    }

    @Test
    public void rejectOnFromToInterval() {
        Interval interval = Interval.oneTo(5);
        Assert.assertEquals(FastList.newListWith(1, 3, 5), interval.reject(IntegerPredicates.isEven()).toList());
        Assert.assertEquals(FastList.newListWith(5, 3, 1), interval.reverseThis().reject(IntegerPredicates.isEven()).toList());
    }

    @Test
    public void reverseThis() {
        Interval interval = Interval.fromToBy(5, 1, -1);
        Interval interval2 = interval.reverseThis();
        List<Integer> result = new ArrayList<>();
        interval2.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), result);
    }

    @Test
    public void intervalAsArray() {
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, Interval.toArray(1, 5));
    }

    @Test
    public void intervalAsIntArray() {
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, Interval.fromTo(1, 5).toIntArray());
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, Interval.fromToExclusive(1, 5).toIntArray());
        Assert.assertArrayEquals(new int[] { 5, 4, 3, 2 }, Interval.fromToExclusive(5, 1).toIntArray());
        Assert.assertArrayEquals(new int[] { -1, -2, -3, -4 }, Interval.fromToExclusive(-1, -5).toIntArray());
        Assert.assertArrayEquals(new int[] { -5, -4, -3, -2 }, Interval.fromToExclusive(-5, -1).toIntArray());
    }

    @Test
    public void intervalAsReverseArray() {
        Integer[] array = Interval.toReverseArray(1, 5);
        Verify.assertSize(5, array);
        Assert.assertTrue(ArrayIterate.contains(array, 1));
        Assert.assertTrue(ArrayIterate.contains(array, 5));
        Assert.assertEquals(ArrayIterate.getFirst(array), Integer.valueOf(5));
        Assert.assertEquals(ArrayIterate.getLast(array), Integer.valueOf(1));
    }

    @Test
    public void intervalToList() {
        MutableList<Integer> list = Interval.fromTo(1, 5).toList();
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, 1, 2, 3, 4, 5);
    }

    @Test
    public void intervalAsReverseList() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Verify.assertSize(5, list);
        Verify.assertStartsWith(list, 5, 4, 3, 2, 1);
    }

    @Test
    public void intervalToSet() {
        MutableSet<Integer> set = Interval.toSet(1, 5);
        Verify.assertSize(5, set);
        Verify.assertContainsAll(set, 1, 2, 3, 4, 5);
    }

    @Test
    public void invalidIntervals() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromToBy(5, 1, 2));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromToBy(5, 1, 0));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromToBy(-5, 1, -1));
    }

    @Test
    public void toList() {
        Interval interval = Interval.evensFromTo(0, 10);
        MutableList<Integer> toList = interval.toList();
        Verify.assertStartsWith(toList, 0, 2, 4, 6, 8, 10);
        Verify.assertSize(6, toList);
    }

    @Test
    public void toSet() {
        Interval interval = Interval.evensFromTo(0, 10);
        MutableSet<Integer> set = interval.toSet();
        Verify.assertContainsAll(set, 0, 2, 4, 6, 8, 10);
        Verify.assertSize(6, set);
    }

    @Test
    public void testToString() {
        Interval interval = Interval.evensFromTo(0, 10);
        Assert.assertEquals("Interval from: 0 to: 10 step: 2 size: 6", interval.toString());
    }

    @Test
    public void evens() {
        Interval interval = Interval.evensFromTo(0, 10);
        int[] evens = { 0, 2, 4, 6, 8, 10 };
        int[] odds = { 1, 3, 5, 7, 9 };
        this.assertIntervalContainsAll(interval, evens);
        this.denyIntervalContainsAny(interval, odds);
        Verify.assertSize(6, interval);
        Interval reverseInterval = Interval.evensFromTo(10, 0);
        this.assertIntervalContainsAll(reverseInterval, evens);
        this.denyIntervalContainsAny(reverseInterval, odds);
        Verify.assertSize(6, reverseInterval);
        Interval negativeInterval = Interval.evensFromTo(-5, 5);
        int[] negativeEvens = { -4, -2, 0, 2, 4 };
        int[] negativeOdds = { -3, -1, 1, 3 };
        this.assertIntervalContainsAll(negativeInterval, negativeEvens);
        this.denyIntervalContainsAny(negativeInterval, negativeOdds);
        Verify.assertSize(5, negativeInterval);
        Interval reverseNegativeInterval = Interval.evensFromTo(5, -5);
        this.assertIntervalContainsAll(reverseNegativeInterval, negativeEvens);
        this.denyIntervalContainsAny(reverseNegativeInterval, negativeOdds);
        Verify.assertSize(5, reverseNegativeInterval);
    }

    private void assertIntervalContainsAll(Interval interval, int[] expectedValues) {
        for (int value : expectedValues) {
            Verify.assertContains(value, interval);
        }
    }

    private void denyIntervalContainsAny(Interval interval, int[] expectedValues) {
        for (int value : expectedValues) {
            Verify.assertNotContains(value, interval);
        }
    }

    @Test
    public void odds() {
        Interval interval1 = Interval.oddsFromTo(0, 10);
        Assert.assertTrue(interval1.containsAll(1, 3, 5, 7, 9));
        Assert.assertTrue(interval1.containsNone(2, 4, 6, 8));
        Verify.assertSize(5, interval1);
        Interval reverseInterval1 = Interval.oddsFromTo(10, 0);
        Assert.assertTrue(reverseInterval1.containsAll(1, 3, 5, 7, 9));
        Assert.assertTrue(reverseInterval1.containsNone(0, 2, 4, 6, 8, 10));
        Verify.assertSize(5, reverseInterval1);
        Interval interval2 = Interval.oddsFromTo(-5, 5);
        Assert.assertTrue(interval2.containsAll(-5, -3, -1, 1, 3, 5));
        Assert.assertTrue(interval2.containsNone(-4, -2, 0, 2, 4));
        Verify.assertSize(6, interval2);
        Interval reverseInterval2 = Interval.oddsFromTo(5, -5);
        Assert.assertTrue(reverseInterval2.containsAll(-5, -3, -1, 1, 3, 5));
        Assert.assertTrue(reverseInterval2.containsNone(-4, -2, 0, 2, 4));
        Verify.assertSize(6, reverseInterval2);
    }

    @Test
    public void size() {
        Verify.assertSize(100, Interval.fromTo(1, 100));
        Verify.assertSize(100, Interval.fromToExclusive(1, 101));
        Verify.assertSize(50, Interval.fromToBy(1, 100, 2));
        Verify.assertSize(34, Interval.fromToBy(1, 100, 3));
        Verify.assertSize(25, Interval.fromToBy(1, 100, 4));
        Verify.assertSize(20, Interval.fromToBy(1, 100, 5));
        Verify.assertSize(17, Interval.fromToBy(1, 100, 6));
        Verify.assertSize(15, Interval.fromToBy(1, 100, 7));
        Verify.assertSize(13, Interval.fromToBy(1, 100, 8));
        Verify.assertSize(12, Interval.fromToBy(1, 100, 9));
        Verify.assertSize(10, Interval.fromToBy(1, 100, 10));
        Verify.assertSize(11, Interval.fromTo(0, 10));
        Verify.assertSize(11, Interval.fromToExclusive(0, 11));
        Verify.assertSize(1, Interval.zero());
        Verify.assertSize(11, Interval.fromTo(0, -10));
        Verify.assertSize(9, Interval.fromToExclusive(0, -9));
        Verify.assertSize(3, Interval.evensFromTo(2, -2));
        Verify.assertSize(2, Interval.oddsFromTo(2, -2));
        // Positive Ranges
        Verify.assertSize(10, Interval.zeroTo(9));
        Verify.assertSize(2_000_000_000, Interval.oneTo(2_000_000_000));
        Verify.assertSize(200_000_000, Interval.oneTo(2_000_000_000).by(10));
        Verify.assertSize(2_000_000_000, Interval.fromTo(2_000_000_000, 1).by(-1));
        Verify.assertSize(2_000_000_000, Interval.fromToExclusive(2_000_000_000, 0).by(-1));
        Verify.assertSize(500_000_000, Interval.oneTo(2_000_000_000).by(4));
        Verify.assertSize(222_222_223, Interval.oneTo(2_000_000_000).by(9));
        // Negative Ranges
        Verify.assertSize(10, Interval.fromTo(0, -9));
        Verify.assertSize(2_000_000_000, Interval.fromTo(-1, -2_000_000_000));
        Verify.assertSize(200_000_000, Interval.fromTo(-1, -2_000_000_000).by(-10));
        Verify.assertSize(2_000_000_000, Interval.fromTo(-2_000_000_000, -1).by(1));
        Verify.assertSize(500_000_000, Interval.fromTo(-1, -2_000_000_000).by(-4));
        Verify.assertSize(222_222_223, Interval.fromTo(-1, -2_000_000_000).by(-9));
        Verify.assertSize(10, Interval.fromToExclusive(0, -10));
        Verify.assertSize(2_000_000_000, Interval.fromToExclusive(-1, -2_000_000_001));
        Verify.assertSize(200_000_000, Interval.fromToExclusive(-1, -2_000_000_000).by(-10));
        Verify.assertSize(2_000_000_000, Interval.fromToExclusive(-2_000_000_000, 0).by(1));
        Verify.assertSize(500_000_000, Interval.fromToExclusive(-1, -2_000_000_000).by(-4));
        Verify.assertSize(222_222_223, Interval.fromToExclusive(-1, -2_000_000_000).by(-9));
        // Overlapping Ranges
        Verify.assertSize(21, Interval.fromTo(10, -10));
        Verify.assertSize(5, Interval.fromTo(10, -10).by(-5));
        Verify.assertSize(5, Interval.fromTo(-10, 10).by(5));
        Verify.assertSize(2_000_000_001, Interval.fromTo(1_000_000_000, -1_000_000_000));
        Verify.assertSize(200_000_001, Interval.fromTo(1_000_000_000, -1_000_000_000).by(-10));
        Verify.assertSize(21, Interval.fromToExclusive(10, -11));
        Verify.assertSize(5, Interval.fromToExclusive(10, -11).by(-5));
        Verify.assertSize(5, Interval.fromToExclusive(-10, 11).by(5));
        Verify.assertSize(2_000_000_001, Interval.fromToExclusive(1_000_000_000, -1_000_000_001));
        Verify.assertSize(200_000_001, Interval.fromToExclusive(1_000_000_000, -1_000_000_001).by(-10));
        Verify.assertSize(1, Interval.fromToBy(1_000_000_000, 2_000_000_000, 1_500_000_000));
        Verify.assertSize(1, Interval.fromToBy(-1_000_000_000, -2_000_000_000, -1_500_000_000));
    }

    @Test
    public void contains() {
        Verify.assertContains(0, Interval.zero());
        Assert.assertTrue(Interval.oneTo(5).containsAll(1, 5));
        Assert.assertTrue(Interval.oneTo(5).containsNone(6, 7));
        Assert.assertFalse(Interval.oneTo(5).containsAll(1, 6));
        Assert.assertFalse(Interval.oneTo(5).containsNone(1, 6));
        Verify.assertNotContains(0, Interval.oneTo(5));
        Assert.assertTrue(Interval.fromTo(-1, -5).containsAll(-1, -5));
        Assert.assertTrue(Interval.fromToExclusive(-1, -5).containsAll(-1, -4));
        Verify.assertNotContains(-5, Interval.fromToExclusive(-1, -5));
        Verify.assertNotContains(0, Interval.fromToExclusive(-1, -5));
        Verify.assertNotContains(1, Interval.fromTo(-1, -5));
        Verify.assertContains(Integer.valueOf(0), Interval.zero());
        Verify.assertNotContains(Integer.valueOf(0), Interval.oneTo(5));
        Verify.assertNotContains(Integer.valueOf(1), Interval.fromTo(-1, -5));
        Verify.assertNotContains(Integer.valueOf(1), Interval.fromToExclusive(-1, -5));
        Verify.assertNotContains(new Object(), Interval.zeroTo(5));
        Interval bigInterval = Interval.fromToBy(Integer.MIN_VALUE, Integer.MAX_VALUE, 1_000_000);
        Assert.assertTrue(bigInterval.contains(Integer.MIN_VALUE + 1_000_000));
        Assert.assertFalse(bigInterval.contains(Integer.MIN_VALUE + 1_000_001));
        Assert.assertTrue(bigInterval.contains(Integer.MIN_VALUE + (1_000_000 * 10)));
        Assert.assertFalse(bigInterval.contains(Integer.MIN_VALUE + (1_000_001 * 10)));
        Assert.assertTrue(bigInterval.contains(Integer.MIN_VALUE + (1_000_000 * 100)));
        Assert.assertFalse(bigInterval.contains(Integer.MIN_VALUE + (1_000_001 * 100)));
        Assert.assertTrue(Interval.fromToBy(1_000_000_000, 2_000_000_000, 1_500_000_000).contains(1_000_000_000));
        Assert.assertTrue(Interval.fromToBy(-1_000_000_000, -2_000_000_000, -1_500_000_000).contains(-1_000_000_000));
        int minValue = -1_000_000_000;
        int maxValue = 1_000_000_000;
        Interval largeInterval = Interval.fromToBy(minValue, maxValue, 10);
        Assert.assertTrue(largeInterval.containsAll(maxValue - 10, maxValue - 100, maxValue - 1000, maxValue - 10000));
        Assert.assertTrue(largeInterval.contains(minValue + 10));
    }

    @Test
    public void largeReverseUnderflowTest() {
        Interval reverse = Interval.fromToBy(Integer.MAX_VALUE, Integer.MIN_VALUE + 10, -10);
        Assert.assertFalse(reverse.contains(Integer.MIN_VALUE + 10));
        Assert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), reverse.getFirst());
        Integer expectedLast = Integer.valueOf(-2_147_483_633);
        Assert.assertEquals(expectedLast, reverse.getLast());
        Assert.assertTrue(reverse.contains(Integer.MAX_VALUE));
        Assert.assertTrue(reverse.contains(7));
        Assert.assertTrue(reverse.contains(-3));
        Assert.assertTrue(reverse.contains(expectedLast));
        Assert.assertTrue(reverse.contains(expectedLast + 1000));
        Assert.assertEquals(214_748_364, reverse.indexOf(Integer.valueOf(7)));
        Assert.assertEquals(214_748_365, reverse.indexOf(Integer.valueOf(-3)));
        Assert.assertEquals(429_496_728, reverse.indexOf(expectedLast));
        Assert.assertEquals(429_496_728, reverse.lastIndexOf(expectedLast));
        Integer expectedAtIndex300Million = Integer.valueOf(-852_516_353);
        Assert.assertTrue(reverse.contains(expectedAtIndex300Million));
        Assert.assertEquals(300_000_000, reverse.indexOf(expectedAtIndex300Million));
        Assert.assertEquals(300_000_000, reverse.lastIndexOf(expectedAtIndex300Million));
        Integer expectedAtIndex400Million = Integer.valueOf(-1_852_516_353);
        Assert.assertTrue(reverse.contains(expectedAtIndex400Million));
        Assert.assertEquals(400_000_000, reverse.indexOf(expectedAtIndex400Million));
        Assert.assertEquals(400_000_000, reverse.lastIndexOf(expectedAtIndex400Million));
    }

    @Test
    public void forwardOverflowTest() {
        Integer from = Integer.valueOf(Integer.MAX_VALUE - 10);
        Integer second = Integer.valueOf(Integer.MAX_VALUE - 2);
        long expected = from.longValue() + second.longValue();
        Interval interval = Interval.fromToBy(from, Integer.MAX_VALUE, 8);
        Verify.assertSize(2, interval);
        Assert.assertEquals(Lists.mutable.with(from, second), interval);
        Assert.assertEquals(1, interval.countWith(Objects::equals, second));
        Assert.assertEquals(expected, interval.sumOfLong(Integer::longValue));
        MutableLong result = new MutableLong();
        interval.each(each -> result.add(each.longValue()));
        Assert.assertEquals(expected, result.longValue());
        result.clear();
        Assert.assertEquals(expected, interval.injectInto(new MutableLong(), MutableLong::add).longValue());
        Assert.assertEquals(2, interval.injectInto(0, (int value, Integer each) -> value + 1));
        Assert.assertEquals(2L, interval.injectInto(0L, (long value, Integer each) -> value + 1));
        Assert.assertEquals(2.0, interval.injectInto(0.0, (double value, Integer each) -> value + 1.0), 0.0);
        Assert.assertEquals(2.0f, interval.injectInto(0.0f, (float value, Integer each) -> value + 1.0f), 0.0f);
    }

    @Test
    public void reverseOverflowTest() {
        Integer from = Integer.valueOf(Integer.MIN_VALUE + 10);
        Integer second = Integer.valueOf(Integer.MIN_VALUE + 2);
        long expected = (long) from + (long) second;
        Interval interval = Interval.fromToBy(from, Integer.MIN_VALUE, -8);
        Assert.assertEquals(2, interval.size());
        Assert.assertEquals(Lists.mutable.with(from, second), interval);
        Assert.assertEquals(1, interval.countWith(Objects::equals, second));
        MutableLong result = new MutableLong();
        interval.each(each -> result.add(each.longValue()));
        Assert.assertEquals(expected, result.longValue());
        Assert.assertEquals(expected, interval.injectInto(new MutableLong(), MutableLong::add).longValue());
        Assert.assertEquals(2, interval.injectInto(0, (int value, Integer each) -> value + 1));
        Assert.assertEquals(2L, interval.injectInto(0L, (long value, Integer each) -> value + 1));
        Assert.assertEquals(2.0, interval.injectInto(0.0, (double value, Integer each) -> value + 1.0), 0.0);
        Assert.assertEquals(2.0f, interval.injectInto(0.0f, (float value, Integer each) -> value + 1.0f), 0.0f);
    }

    @Test
    public void factorial() {
        Assert.assertThrows(IllegalStateException.class, () -> Interval.fromTo(-1, -5).factorial());
        Assert.assertEquals(1, Interval.zero().factorial().intValue());
        Assert.assertEquals(1, Interval.oneTo(1).factorial().intValue());
        Assert.assertEquals(6, Interval.oneTo(3).factorial().intValue());
        Assert.assertEquals(2432902008176640000L, Interval.oneTo(20).factorial().longValue());
        Assert.assertEquals(new BigInteger("51090942171709440000"), Interval.oneTo(21).factorial());
        Assert.assertEquals(new BigInteger("1405006117752879898543142606244511569936384000000000"), Interval.oneTo(42).factorial());
    }

    @Test
    public void product() {
        Assert.assertEquals(0, Interval.zero().product().intValue());
        Assert.assertEquals(0, Interval.fromTo(-1, 1).product().intValue());
        Assert.assertEquals(2, Interval.fromTo(-2, -1).product().intValue());
        Assert.assertEquals(-6, Interval.fromTo(-3, -1).product().intValue());
        Assert.assertEquals(0, Interval.fromToExclusive(-1, 1).product().intValue());
        Assert.assertEquals(-2, Interval.fromToExclusive(-2, -1).product().intValue());
        Assert.assertEquals(6, Interval.fromToExclusive(-3, -1).product().intValue());
        Assert.assertEquals(200, Interval.fromToBy(10, 20, 10).product().intValue());
        Assert.assertEquals(200, Interval.fromToBy(-10, -20, -10).product().intValue());
        Assert.assertEquals(-6000, Interval.fromToBy(-10, -30, -10).product().intValue());
        Assert.assertEquals(6000, Interval.fromToBy(30, 10, -10).product().intValue());
        Assert.assertEquals(6000, Interval.fromToBy(30, 10, -10).reverseThis().product().intValue());
    }

    @Test
    public void iterator() {
        Interval zero = Interval.zero();
        Iterator<Integer> zeroIterator = zero.iterator();
        Assert.assertTrue(zeroIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(0), zeroIterator.next());
        Assert.assertFalse(zeroIterator.hasNext());
        Interval oneToFive = Interval.oneTo(5);
        Iterator<Integer> oneToFiveIterator = oneToFive.iterator();
        for (int i = 1; i < 6; i++) {
            Assert.assertTrue(oneToFiveIterator.hasNext());
            Assert.assertEquals(Integer.valueOf(i), oneToFiveIterator.next());
        }
        Assert.assertThrows(NoSuchElementException.class, oneToFiveIterator::next);
        Interval threeToNegativeThree = Interval.fromTo(3, -3);
        Iterator<Integer> threeToNegativeThreeIterator = threeToNegativeThree.iterator();
        for (int i = 3; i > -4; i--) {
            Assert.assertTrue(threeToNegativeThreeIterator.hasNext());
            Assert.assertEquals(Integer.valueOf(i), threeToNegativeThreeIterator.next());
        }
        Assert.assertThrows(NoSuchElementException.class, threeToNegativeThreeIterator::next);
        Assert.assertThrows(UnsupportedOperationException.class, () -> Interval.zeroTo(10).iterator().remove());
    }

    @Test
    public void forEachWithIndex() {
        IntegerSum sum = new IntegerSum(0);
        Interval.oneTo(5).forEachWithIndex((ObjectIntProcedure<Integer>) (each, index) -> sum.add(each + index));
        Assert.assertEquals(25, sum.getIntSum());
        IntegerSum zeroSum = new IntegerSum(0);
        Interval.fromTo(0, -4).forEachWithIndex((ObjectIntProcedure<Integer>) (each, index) -> zeroSum.add(each + index));
        Assert.assertEquals(0, zeroSum.getIntSum());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> Interval.zeroTo(10).forEachWithIndex(null, -1, 10));
    }

    @Test
    public void run() {
        IntegerSum sum = new IntegerSum(0);
        Interval.oneTo(5).run(() -> sum.add(1));
        Assert.assertEquals(5, sum.getIntSum());
        IntegerSum sum2 = new IntegerSum(0);
        Interval.fromTo(5, 1).run(() -> sum2.add(1));
        Assert.assertEquals(5, sum2.getIntSum());
    }

    @Test
    public void forEachWith() {
        IntegerSum sum = new IntegerSum(0);
        Interval.oneTo(5).forEachWith((Integer each, Integer parameter) -> sum.add(each + parameter), 0);
        Assert.assertEquals(15, sum.getIntSum());
        IntegerSum sum2 = new IntegerSum(0);
        Interval.fromTo(5, 1).forEachWith((Integer each, Integer parameter) -> sum2.add(each + parameter), 0);
        Assert.assertEquals(15, sum2.getIntSum());
    }

    @Test
    public void select() {
        Interval interval = Interval.fromTo(10, -10).by(-5);
        MutableList<Integer> expected = FastList.newListWith(10, 0, -10);
        Assert.assertEquals(expected, interval.select(IntegerPredicates.isEven()).toList());
        Assert.assertEquals(expected, interval.select(IntegerPredicates.isEven(), FastList.newList()));
    }

    @Test
    public void reject() {
        Interval interval = Interval.fromTo(10, -10).by(-5);
        MutableList<Integer> expected = FastList.newListWith(5, -5);
        Assert.assertEquals(expected, interval.reject(IntegerPredicates.isEven(), FastList.newList()));
    }

    @Test
    public void collect() {
        Interval interval = Interval.fromTo(10, -10).by(-5);
        MutableList<String> expected = FastList.newListWith("10", "5", "0", "-5", "-10");
        Assert.assertEquals(expected, interval.collect(String::valueOf).toList());
        Assert.assertEquals(expected, interval.collect(String::valueOf, FastList.newList()));
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(Integer.valueOf(10), Interval.fromTo(10, -10).by(-5).getFirst());
        Assert.assertEquals(Integer.valueOf(-10), Interval.fromTo(-10, 10).by(5).getFirst());
        Assert.assertEquals(Integer.valueOf(0), Interval.zero().getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals(Integer.valueOf(-10), Interval.fromTo(10, -10).by(-5).getLast());
        Assert.assertEquals(Integer.valueOf(-10), Interval.fromTo(10, -12).by(-5).getLast());
        Assert.assertEquals(Integer.valueOf(10), Interval.fromTo(-10, 10).by(5).getLast());
        Assert.assertEquals(Integer.valueOf(10), Interval.fromTo(-10, 12).by(5).getLast());
        Assert.assertEquals(Integer.valueOf(0), Interval.zero().getLast());
    }

    @Test
    public void forEach_with_start_end() {
        Interval interval = Interval.fromTo(-10, 12).by(5);
        MutableList<Integer> forwardResult = Lists.mutable.of();
        interval.forEach(CollectionAddProcedure.on(forwardResult), 1, 3);
        Assert.assertEquals(FastList.newListWith(-5, 0, 5), forwardResult);
        MutableList<Integer> backwardsResult = Lists.mutable.of();
        interval.forEach(CollectionAddProcedure.on(backwardsResult), 3, 1);
        Assert.assertEquals(FastList.newListWith(5, 0, -5), backwardsResult);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> interval.forEach(null, -1, 3));
    }

    @Test
    public void forEachWith_with_start_end() {
        Interval interval = Interval.fromTo(-10, 12).by(5);
        MutableList<Integer> forwardResult = Lists.mutable.of();
        interval.forEachWithIndex(new AddParametersProcedure(forwardResult), 1, 3);
        Assert.assertEquals(FastList.newListWith(-4, 2, 8), forwardResult);
        MutableList<Integer> backwardsResult = Lists.mutable.of();
        interval.forEachWithIndex(new AddParametersProcedure(backwardsResult), 3, 1);
        Assert.assertEquals(FastList.newListWith(8, 2, -4), backwardsResult);
    }

    @Test
    public void forEach_with_same_start_and_end_with_negative_step() {
        Interval interval = Interval.fromToBy(2, 2, -2);
        MutableInteger counter = new MutableInteger(0);
        interval.forEach((Procedure<Integer>) each -> counter.add(1));
        Assert.assertEquals(1, counter.toInteger().intValue());
    }

    @Test
    public void indexOf() {
        Interval interval = Interval.fromTo(-10, 12).by(5);
        Assert.assertEquals(0, interval.indexOf(-10));
        Assert.assertEquals(1, interval.indexOf(-5));
        Assert.assertEquals(2, interval.indexOf(0));
        Assert.assertEquals(3, interval.indexOf(5));
        Assert.assertEquals(4, interval.indexOf(10));
        Assert.assertEquals(-1, interval.indexOf(-15));
        Assert.assertEquals(-1, interval.indexOf(-11));
        Assert.assertEquals(-1, interval.indexOf(-9));
        Assert.assertEquals(-1, interval.indexOf(11));
        Assert.assertEquals(-1, interval.indexOf(15));
        Interval backwardsInterval = Interval.fromTo(10, -12).by(-5);
        Assert.assertEquals(0, backwardsInterval.indexOf(10));
        Assert.assertEquals(1, backwardsInterval.indexOf(5));
        Assert.assertEquals(2, backwardsInterval.indexOf(0));
        Assert.assertEquals(3, backwardsInterval.indexOf(-5));
        Assert.assertEquals(4, backwardsInterval.indexOf(-10));
        Assert.assertEquals(-1, backwardsInterval.indexOf(15));
        Assert.assertEquals(-1, backwardsInterval.indexOf(11));
        Assert.assertEquals(-1, backwardsInterval.indexOf(9));
        Assert.assertEquals(-1, backwardsInterval.indexOf(-11));
        Assert.assertEquals(-1, backwardsInterval.indexOf(-15));
    }

    @Test
    public void lastIndexOf() {
        Interval interval = Interval.fromTo(-10, 12).by(5);
        Assert.assertEquals(0, interval.lastIndexOf(-10));
        Assert.assertEquals(1, interval.lastIndexOf(-5));
        Assert.assertEquals(2, interval.lastIndexOf(0));
        Assert.assertEquals(3, interval.lastIndexOf(5));
        Assert.assertEquals(4, interval.lastIndexOf(10));
        Assert.assertEquals(-1, interval.lastIndexOf(-15));
        Assert.assertEquals(-1, interval.lastIndexOf(-11));
        Assert.assertEquals(-1, interval.lastIndexOf(-9));
        Assert.assertEquals(-1, interval.lastIndexOf(11));
        Assert.assertEquals(-1, interval.lastIndexOf(15));
        Assert.assertEquals(-1, interval.lastIndexOf(new Object()));
        Interval backwardsInterval = Interval.fromTo(10, -12).by(-5);
        Assert.assertEquals(0, backwardsInterval.lastIndexOf(10));
        Assert.assertEquals(1, backwardsInterval.lastIndexOf(5));
        Assert.assertEquals(2, backwardsInterval.lastIndexOf(0));
        Assert.assertEquals(3, backwardsInterval.lastIndexOf(-5));
        Assert.assertEquals(4, backwardsInterval.lastIndexOf(-10));
        Assert.assertEquals(-1, backwardsInterval.lastIndexOf(15));
        Assert.assertEquals(-1, backwardsInterval.lastIndexOf(11));
        Assert.assertEquals(-1, backwardsInterval.lastIndexOf(9));
        Assert.assertEquals(-1, backwardsInterval.lastIndexOf(-11));
        Assert.assertEquals(-1, backwardsInterval.lastIndexOf(-15));
    }

    @Test
    public void get() {
        Interval interval = Interval.fromTo(-10, 12).by(5);
        Verify.assertItemAtIndex(Integer.valueOf(-10), 0, interval);
        Verify.assertItemAtIndex(Integer.valueOf(-5), 1, interval);
        Verify.assertItemAtIndex(Integer.valueOf(0), 2, interval);
        Verify.assertItemAtIndex(Integer.valueOf(5), 3, interval);
        Verify.assertItemAtIndex(Integer.valueOf(10), 4, interval);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> interval.get(-1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> interval.get(5));
    }

    @Test
    public void subList() {
        Interval interval = Interval.fromTo(1, 5);
        Assert.assertEquals(FastList.newListWith(2, 3), interval.subList(1, 3));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(Interval.fromTo(1, 3).containsAll(FastList.newListWith(1, 2, 3)));
        Assert.assertFalse(Interval.fromTo(1, 3).containsAll(FastList.newListWith(1, 2, 4)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        Interval.fromTo(1, 3).add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add_at_index() {
        Interval.fromTo(1, 3).add(0, 4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        Interval.fromTo(1, 3).remove(Integer.valueOf(4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove_at_index() {
        Interval.fromTo(1, 3).remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        Interval.fromTo(1, 3).addAll(FastList.newListWith(4, 5, 6));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll_at_index() {
        Interval.fromTo(1, 3).addAll(0, FastList.newListWith(4, 5, 6));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        Interval.fromTo(1, 3).removeAll(FastList.newListWith(4, 5, 6));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        Interval.fromTo(1, 3).retainAll(FastList.newListWith(4, 5, 6));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        Interval.fromTo(1, 3).clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        Interval.fromTo(1, 3).set(0, 0);
    }

    @Test
    public void take() {
        Verify.assertIterableEmpty(Interval.fromTo(1, 3).take(0));
        Assert.assertEquals(FastList.newListWith(1, 2), Interval.fromTo(1, 3).take(2));
        Assert.assertEquals(FastList.newListWith(1, 2), Interval.fromTo(1, 2).take(3));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromTo(1, 3).take(-1));
    }

    @Test
    public void drop() {
        Assert.assertEquals(FastList.newListWith(3, 4), Interval.fromTo(1, 4).drop(2));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), Interval.fromTo(1, 4).drop(0));
        Verify.assertIterableEmpty(Interval.fromTo(1, 2).drop(3));
        Assert.assertThrows(IllegalArgumentException.class, () -> Interval.fromTo(1, 3).drop(-1));
    }

    @Test
    public void takeWhile() {
        Verify.assertIterableEmpty(Interval.fromTo(1, 3).takeWhile(Predicates.alwaysFalse()).toList());
        Assert.assertEquals(FastList.newListWith(1, 2), Interval.fromTo(1, 3).takeWhile(each -> each <= 2).toList());
        Assert.assertEquals(FastList.newListWith(1, 2), Interval.fromTo(1, 2).takeWhile(Predicates.alwaysTrue()).toList());
        Assert.assertThrows(IllegalStateException.class, () -> Interval.fromTo(1, 3).takeWhile(null));
    }

    @Test
    public void dropWhile() {
        Assert.assertEquals(FastList.newListWith(3, 4), Interval.fromTo(1, 4).dropWhile(each -> each <= 2).toList());
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), Interval.fromTo(1, 4).dropWhile(Predicates.alwaysFalse()).toList());
        Verify.assertIterableEmpty(Interval.fromTo(1, 2).dropWhile(Predicates.alwaysTrue()).toList());
        Assert.assertThrows(IllegalStateException.class, () -> Interval.fromTo(1, 3).dropWhile(null));
    }

    @Test
    public void distinct() {
        LazyIterable<Integer> integers = Interval.oneTo(1000000000);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), integers.distinct().take(5).toList());
        LazyIterable<Integer> lazyInterval = Interval.oneTo(1000000).flatCollect(Interval::oneTo);
        LazyIterable<Integer> distinct = lazyInterval.distinct();
        LazyIterable<Integer> take = distinct.take(5);
        Assert.assertEquals(Lists.immutable.of(1, 2, 3, 4, 5), take.toList());
    }

    private static final class AddParametersProcedure implements ObjectIntProcedure<Integer> {

        private final MutableList<Integer> forwardResult;

        private AddParametersProcedure(MutableList<Integer> forwardResult) {
            this.forwardResult = forwardResult;
        }

        @Override
        public void value(Integer each, int index) {
            this.forwardResult.add(each + index);
        }
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        Interval interval = Interval.fromTo(10, -10).by(-5);
        LazyIterable<Integer> lazyTapIterable = interval.tap(tapResult::add);
        lazyTapIterable.each(x -> {
        });
        // force evaluation
        Assert.assertEquals(interval, tapResult);
    }

    @Test
    public void appendStringThrows() {
        Assert.assertThrows(RuntimeException.class, () -> Interval.oneTo(5).appendString(new ThrowingAppendable()));
        Assert.assertThrows(RuntimeException.class, () -> Interval.oneTo(5).appendString(new ThrowingAppendable(), ", "));
        Assert.assertThrows(RuntimeException.class, () -> Interval.oneTo(5).appendString(new ThrowingAppendable(), "[", ", ", "]"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntervalTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_into() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.into);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromToExclusive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fromToExclusive);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromAndToAndBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fromAndToAndBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromToBy_throws_step_size_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fromToBy_throws_step_size_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromToBy_with_same_start_and_end_with_negative_step() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fromToBy_with_same_start_and_end_with_negative_step);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_oneToBy_throws_step_size_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.oneToBy_throws_step_size_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroToBy_throws_step_size_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zeroToBy_throws_step_size_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnFromToInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnFromToInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithExecutor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithExecutor);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithExecutorInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithExecutorInReverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_runWithExecutor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.runWithExecutor);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_runWithExecutorInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.runWithExecutorInReverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachOnFromToInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachOnFromToInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnFromToByInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnFromToByInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnFromToByInterval2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnFromToByInterval2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoOnFromToByInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoOnFromToByInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoOnFromToBySameStartEndNegativeStepInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoOnFromToBySameStartEndNegativeStepInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseInjectIntoOnFromToByInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseInjectIntoOnFromToByInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectOnFromToByInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectOnFromToByInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectOnFromToInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectOnFromToInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectOnFromToInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectOnFromToInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectOnFromToInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectOnFromToInterval);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalAsArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalAsArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalAsIntArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalAsIntArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalAsReverseArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalAsReverseArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalToList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalToList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalAsReverseList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalAsReverseList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intervalToSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intervalToSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_invalidIntervals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.invalidIntervals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_evens() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.evens);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_odds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.odds);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeReverseUnderflowTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeReverseUnderflowTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forwardOverflowTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forwardOverflowTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseOverflowTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseOverflowTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_factorial() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.factorial);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_product() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.product);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_run() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.run);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_with_start_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_with_start_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith_with_start_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith_with_start_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_with_same_start_and_end_with_negative_step() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_with_same_start_and_end_with_negative_step);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_at_index() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_at_index);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_at_index() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_at_index);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_at_index() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_at_index);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
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
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> payload) throws java.lang.Throwable {
            this.instance = new IntervalTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> into;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> fromToExclusive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> fromAndToAndBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> fromToBy_throws_step_size_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> fromToBy_with_same_start_and_end_with_negative_step;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> oneToBy_throws_step_size_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> zeroToBy_throws_step_size_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachOnFromToInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachWithExecutor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachWithExecutorInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> runWithExecutor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> runWithExecutorInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> reverseForEachOnFromToInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachOnFromToByInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachOnFromToByInterval2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> injectIntoOnFromToByInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> injectIntoOnFromToBySameStartEndNegativeStepInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> sumInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> maxInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> reverseInjectIntoOnFromToByInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> collectOnFromToByInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> collectOnFromToInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> selectOnFromToInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> rejectOnFromToInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalAsArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalAsIntArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalAsReverseArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalToList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalAsReverseList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> intervalToSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> invalidIntervals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> evens;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> odds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> largeReverseUnderflowTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forwardOverflowTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> reverseOverflowTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> factorial;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> product;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> run;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEach_with_start_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEachWith_with_start_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> forEach_with_same_start_and_end_with_negative_step;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> add_at_index;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> remove_at_index;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> addAll_at_index;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntervalTest> appendStringThrows;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.into = IntervalTest::into;
            this.payloads.fromToExclusive = IntervalTest::fromToExclusive;
            this.payloads.fromAndToAndBy = IntervalTest::fromAndToAndBy;
            this.payloads.fromToBy_throws_step_size_zero = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::fromToBy_throws_step_size_zero, java.lang.IllegalArgumentException.class);
            this.payloads.fromToBy_with_same_start_and_end_with_negative_step = IntervalTest::fromToBy_with_same_start_and_end_with_negative_step;
            this.payloads.oneToBy_throws_step_size_zero = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::oneToBy_throws_step_size_zero, java.lang.IllegalArgumentException.class);
            this.payloads.zeroToBy_throws_step_size_zero = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::zeroToBy_throws_step_size_zero, java.lang.IllegalArgumentException.class);
            this.payloads.equalsAndHashCode = IntervalTest::equalsAndHashCode;
            this.payloads.forEachOnFromToInterval = IntervalTest::forEachOnFromToInterval;
            this.payloads.forEachWithExecutor = IntervalTest::forEachWithExecutor;
            this.payloads.forEachWithExecutorInReverse = IntervalTest::forEachWithExecutorInReverse;
            this.payloads.runWithExecutor = IntervalTest::runWithExecutor;
            this.payloads.runWithExecutorInReverse = IntervalTest::runWithExecutorInReverse;
            this.payloads.reverseForEachOnFromToInterval = IntervalTest::reverseForEachOnFromToInterval;
            this.payloads.forEachOnFromToByInterval = IntervalTest::forEachOnFromToByInterval;
            this.payloads.forEachOnFromToByInterval2 = IntervalTest::forEachOnFromToByInterval2;
            this.payloads.injectIntoOnFromToByInterval = IntervalTest::injectIntoOnFromToByInterval;
            this.payloads.injectIntoOnFromToBySameStartEndNegativeStepInterval = IntervalTest::injectIntoOnFromToBySameStartEndNegativeStepInterval;
            this.payloads.sumInterval = IntervalTest::sumInterval;
            this.payloads.maxInterval = IntervalTest::maxInterval;
            this.payloads.reverseInjectIntoOnFromToByInterval = IntervalTest::reverseInjectIntoOnFromToByInterval;
            this.payloads.collectOnFromToByInterval = IntervalTest::collectOnFromToByInterval;
            this.payloads.collectOnFromToInterval = IntervalTest::collectOnFromToInterval;
            this.payloads.selectOnFromToInterval = IntervalTest::selectOnFromToInterval;
            this.payloads.rejectOnFromToInterval = IntervalTest::rejectOnFromToInterval;
            this.payloads.reverseThis = IntervalTest::reverseThis;
            this.payloads.intervalAsArray = IntervalTest::intervalAsArray;
            this.payloads.intervalAsIntArray = IntervalTest::intervalAsIntArray;
            this.payloads.intervalAsReverseArray = IntervalTest::intervalAsReverseArray;
            this.payloads.intervalToList = IntervalTest::intervalToList;
            this.payloads.intervalAsReverseList = IntervalTest::intervalAsReverseList;
            this.payloads.intervalToSet = IntervalTest::intervalToSet;
            this.payloads.invalidIntervals = IntervalTest::invalidIntervals;
            this.payloads.toList = IntervalTest::toList;
            this.payloads.toSet = IntervalTest::toSet;
            this.payloads.testToString = IntervalTest::testToString;
            this.payloads.evens = IntervalTest::evens;
            this.payloads.odds = IntervalTest::odds;
            this.payloads.size = IntervalTest::size;
            this.payloads.contains = IntervalTest::contains;
            this.payloads.largeReverseUnderflowTest = IntervalTest::largeReverseUnderflowTest;
            this.payloads.forwardOverflowTest = IntervalTest::forwardOverflowTest;
            this.payloads.reverseOverflowTest = IntervalTest::reverseOverflowTest;
            this.payloads.factorial = IntervalTest::factorial;
            this.payloads.product = IntervalTest::product;
            this.payloads.iterator = IntervalTest::iterator;
            this.payloads.forEachWithIndex = IntervalTest::forEachWithIndex;
            this.payloads.run = IntervalTest::run;
            this.payloads.forEachWith = IntervalTest::forEachWith;
            this.payloads.select = IntervalTest::select;
            this.payloads.reject = IntervalTest::reject;
            this.payloads.collect = IntervalTest::collect;
            this.payloads.getFirst = IntervalTest::getFirst;
            this.payloads.getLast = IntervalTest::getLast;
            this.payloads.forEach_with_start_end = IntervalTest::forEach_with_start_end;
            this.payloads.forEachWith_with_start_end = IntervalTest::forEachWith_with_start_end;
            this.payloads.forEach_with_same_start_and_end_with_negative_step = IntervalTest::forEach_with_same_start_and_end_with_negative_step;
            this.payloads.indexOf = IntervalTest::indexOf;
            this.payloads.lastIndexOf = IntervalTest::lastIndexOf;
            this.payloads.get = IntervalTest::get;
            this.payloads.subList = IntervalTest::subList;
            this.payloads.containsAll = IntervalTest::containsAll;
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.add_at_index = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::add_at_index, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.remove_at_index = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::remove_at_index, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_at_index = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::addAll_at_index, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.set = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntervalTest::set, java.lang.UnsupportedOperationException.class);
            this.payloads.take = IntervalTest::take;
            this.payloads.drop = IntervalTest::drop;
            this.payloads.takeWhile = IntervalTest::takeWhile;
            this.payloads.dropWhile = IntervalTest::dropWhile;
            this.payloads.distinct = IntervalTest::distinct;
            this.payloads.tap = IntervalTest::tap;
            this.payloads.appendStringThrows = IntervalTest::appendStringThrows;
        }
    }
}
