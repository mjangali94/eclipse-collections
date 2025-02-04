/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.eclipse.collections.api.ParallelIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.api.set.ParallelSetIterable;
import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.function.checked.CheckedFunction;
import org.eclipse.collections.impl.block.predicate.checked.CheckedPredicate;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.block.procedure.checked.CheckedProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class ParallelIterableTestCase {

    private static final ImmutableList<Integer> BATCH_SIZES = Lists.immutable.with(2, 5, 10, 100, 1000, 10000, 50000);

    protected ExecutorService executorService;

    protected int batchSize = 2;

    @Before
    public void setUp() {
        this.executorService = Executors.newFixedThreadPool(10);
        this.batchSize = 2;
        Assert.assertFalse(Thread.interrupted());
    }

    @After
    public void tearDown() {
        this.executorService.shutdownNow();
        Thread.interrupted();
    }

    // 1, 2, 2, 3, 3, 3, 4, 4, 4, 4
    protected abstract ParallelIterable<Integer> classUnderTest();

    protected abstract ParallelIterable<Integer> newWith(Integer... littleElements);

    // 1, 2, 2, 3, 3, 3, 4, 4, 4, 4
    protected abstract RichIterable<Integer> getExpected();

    protected abstract RichIterable<Integer> getExpectedWith(Integer... littleElements);

    protected RichIterable<Integer> getExpectedCollect() {
        return this.getExpected();
    }

    protected final <T> RichIterable<T> getActual(ParallelIterable<T> actual) {
        if (actual instanceof ParallelListIterable<?>) {
            return actual.toList();
        }
        if (actual instanceof ParallelSortedSetIterable<?>) {
            return actual.toSortedSet(((ParallelSortedSetIterable<T>) actual).comparator());
        }
        if (actual instanceof ParallelSetIterable<?>) {
            return actual.toSet();
        }
        return actual.toBag();
    }

    protected abstract boolean isOrdered();

    protected abstract boolean isUnique();

    @Test
    public void toArray() {
        Assert.assertEquals(HashBag.newBagWith(this.getExpected().toArray()), HashBag.newBagWith(this.classUnderTest().toArray()));
    }

    @Test
    public void toArray_array() {
        Assert.assertEquals(HashBag.newBagWith(this.getExpected().toArray(new Object[10])), HashBag.newBagWith(this.classUnderTest().toArray(new Object[10])));
    }

    @Test
    public void forEach() {
        MutableCollection<Integer> actual = HashBag.<Integer>newBag().asSynchronized();
        this.classUnderTest().forEach(CollectionAddProcedure.on(actual));
        Assert.assertEquals(this.getExpected().toBag(), actual);
    }

    @Test
    public void forEachWith() {
        MutableCollection<Integer> actual = HashBag.<Integer>newBag().asSynchronized();
        this.classUnderTest().forEachWith(Procedures2.addToCollection(), actual);
        Assert.assertEquals(this.getExpected().toBag(), actual);
    }

    @Test
    public void select() {
        Predicate<Integer> predicate = Predicates.greaterThan(1).and(Predicates.lessThan(4));
        Assert.assertEquals(this.getExpected().select(predicate), this.getActual(this.classUnderTest().select(predicate)));
        Assert.assertEquals(this.getExpected().select(predicate).toList().toBag(), this.classUnderTest().select(predicate).toList().toBag());
        Assert.assertEquals(this.getExpected().select(predicate).toBag(), this.classUnderTest().select(predicate).toBag());
    }

    @Test
    public void selectWith() {
        Assert.assertEquals(this.getExpected().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4), this.getActual(this.classUnderTest().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4)));
        Assert.assertEquals(this.getExpected().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4).toList().toBag(), this.classUnderTest().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4).toList().toBag());
        Assert.assertEquals(this.getExpected().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4).toBag(), this.classUnderTest().selectWith(Predicates2.greaterThan(), 1).selectWith(Predicates2.lessThan(), 4).toBag());
    }

    @Test
    public void reject() {
        Predicate<Integer> predicate = Predicates.lessThanOrEqualTo(1).and(Predicates.greaterThanOrEqualTo(4));
        Assert.assertEquals(this.getExpected().reject(predicate), this.getActual(this.classUnderTest().reject(predicate)));
        Assert.assertEquals(this.getExpected().reject(predicate).toList().toBag(), this.classUnderTest().reject(predicate).toList().toBag());
        Assert.assertEquals(this.getExpected().reject(predicate).toBag(), this.classUnderTest().reject(predicate).toBag());
    }

    @Test
    public void rejectWith() {
        Assert.assertEquals(this.getExpected().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4), this.getActual(this.classUnderTest().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4)));
        Assert.assertEquals(this.getExpected().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4).toList().toBag(), this.classUnderTest().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4).toList().toBag());
        Assert.assertEquals(this.getExpected().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4).toBag(), this.classUnderTest().rejectWith(Predicates2.lessThanOrEqualTo(), 1).rejectWith(Predicates2.greaterThanOrEqualTo(), 4).toBag());
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(this.getExpected().selectInstancesOf(Integer.class), this.getActual(this.classUnderTest().selectInstancesOf(Integer.class)));
        Assert.assertEquals(this.getExpected().selectInstancesOf(String.class), this.getActual(this.classUnderTest().selectInstancesOf(String.class)));
        Assert.assertEquals(this.getExpected().selectInstancesOf(Integer.class).toList().toBag(), this.classUnderTest().selectInstancesOf(Integer.class).toList().toBag());
        Assert.assertEquals(this.getExpected().selectInstancesOf(Integer.class).toBag(), this.classUnderTest().selectInstancesOf(Integer.class).toBag());
        Function<Integer, Number> numberFunction = integer -> {
            if (IntegerPredicates.isEven().accept(integer)) {
                return Double.valueOf(integer.doubleValue());
            }
            return integer;
        };
        Assert.assertEquals(this.getExpectedCollect().collect(numberFunction).selectInstancesOf(Integer.class), this.getActual(this.classUnderTest().collect(numberFunction).selectInstancesOf(Integer.class)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(this.getExpectedCollect().collect(String::valueOf), this.getActual(this.classUnderTest().collect(String::valueOf)));
        Assert.assertEquals(this.getExpectedCollect().collect(String::valueOf, HashBag.newBag()), this.classUnderTest().collect(String::valueOf).toList().toBag());
        Assert.assertEquals(this.getExpectedCollect().collect(String::valueOf).toBag(), this.classUnderTest().collect(String::valueOf).toBag());
        Object constant = new Object();
        Assert.assertEquals(this.getExpectedCollect().collect(ignored -> constant, HashBag.newBag()), this.classUnderTest().collect(ignored -> constant).toList().toBag());
    }

    @Test
    public void collectWith() {
        Function2<Integer, String, String> appendFunction = (argument1, argument2) -> argument1 + argument2;
        Assert.assertEquals(this.getExpectedCollect().collectWith(appendFunction, "!"), this.getActual(this.classUnderTest().collectWith(appendFunction, "!")));
        Assert.assertEquals(this.getExpectedCollect().collectWith(appendFunction, "!", HashBag.newBag()), this.classUnderTest().collectWith(appendFunction, "!").toList().toBag());
        Assert.assertEquals(this.getExpectedCollect().collectWith(appendFunction, "!").toBag(), this.classUnderTest().collectWith(appendFunction, "!").toBag());
        Object constant = new Object();
        Assert.assertEquals(this.getExpectedCollect().collectWith((ignored1, ignored2) -> constant, "!", HashBag.newBag()), this.classUnderTest().collectWith((ignored1, ignored2) -> constant, "!").toList().toBag());
    }

    @Test
    public void collectIf() {
        Predicate<Integer> predicate = Predicates.greaterThan(1).and(Predicates.lessThan(4));
        Assert.assertEquals(this.getExpectedCollect().collectIf(predicate, String::valueOf), this.getActual(this.classUnderTest().collectIf(predicate, String::valueOf)));
        Assert.assertEquals(this.getExpectedCollect().collectIf(predicate, String::valueOf, HashBag.newBag()), this.classUnderTest().collectIf(predicate, String::valueOf).toList().toBag());
        Assert.assertEquals(this.getExpectedCollect().collectIf(predicate, String::valueOf).toBag(), this.classUnderTest().collectIf(predicate, String::valueOf).toBag());
        Object constant = new Object();
        Assert.assertEquals(this.getExpectedCollect().collectIf(predicate, ignored -> constant, HashBag.newBag()), this.classUnderTest().collectIf(predicate, ignored -> constant).toList().toBag());
    }

    @Test
    public void flatCollect() {
        Function<Integer, Iterable<Integer>> intervalFunction = Interval::oneTo;
        Assert.assertEquals(this.getExpectedCollect().flatCollect(intervalFunction), this.getActual(this.classUnderTest().flatCollect(intervalFunction)));
        Assert.assertEquals(this.getExpectedCollect().flatCollect(intervalFunction, HashBag.newBag()), this.classUnderTest().flatCollect(intervalFunction).toList().toBag());
        Assert.assertEquals(this.getExpectedCollect().flatCollect(intervalFunction, HashBag.newBag()), this.classUnderTest().flatCollect(intervalFunction).toBag());
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().detect(Integer.valueOf(3)::equals));
        Assert.assertNull(this.classUnderTest().detect(Integer.valueOf(8)::equals));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().detectIfNone(Integer.valueOf(3)::equals, () -> 8));
        Assert.assertEquals(Integer.valueOf(8), this.classUnderTest().detectIfNone(Integer.valueOf(6)::equals, () -> 8));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().detectWith(Object::equals, Integer.valueOf(3)));
        Assert.assertNull(this.classUnderTest().detectWith(Object::equals, Integer.valueOf(8)));
    }

    @Test
    public void detectWithIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(Integer.valueOf(1000));
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().detectWithIfNone(Object::equals, Integer.valueOf(3), function));
        Assert.assertEquals(Integer.valueOf(1000), this.classUnderTest().detectWithIfNone(Object::equals, Integer.valueOf(8), function));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws() {
        this.classUnderTest().select(ignored -> false).min(Integer::compareTo);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws() {
        this.classUnderTest().select(ignored -> false).max(Integer::compareTo);
    }

    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min(Integer::compareTo));
    }

    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(4), this.classUnderTest().max(Integer::compareTo));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(4), this.classUnderTest().maxBy(String::valueOf));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws_without_comparator() {
        this.classUnderTest().select(ignored -> false).min();
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws_without_comparator() {
        this.classUnderTest().select(ignored -> false).max();
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(4), this.classUnderTest().max());
    }

    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.lessThan(0)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.lessThan(1)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.lessThan(2)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.lessThan(3)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.lessThan(4)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.lessThan(5)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.greaterThan(0)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.greaterThan(1)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.greaterThan(2)));
        Assert.assertTrue(this.classUnderTest().anySatisfy(Predicates.greaterThan(3)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.greaterThan(4)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.greaterThan(5)));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 1));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 2));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 3));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 5));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 0));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 1));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 2));
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 3));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 4));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.greaterThan(), 5));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.lessThan(0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.lessThan(1)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.lessThan(2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.lessThan(3)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.lessThan(4)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(Predicates.lessThan(5)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(Predicates.greaterThan(0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.greaterThan(1)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.greaterThan(2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.greaterThan(3)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.greaterThan(4)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.greaterThan(5)));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 1));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 2));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 3));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 5));
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 0));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 1));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 2));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 3));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 4));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Predicates2.greaterThan(), 5));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.lessThan(0)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.lessThan(1)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.lessThan(2)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.lessThan(3)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.lessThan(4)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.lessThan(5)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.greaterThan(0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.greaterThan(1)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.greaterThan(2)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(Predicates.greaterThan(3)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.greaterThan(4)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.greaterThan(5)));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 1));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 2));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 3));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 5));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 0));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 1));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 2));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 3));
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 4));
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThan(), 5));
    }

    @Test
    public void count() {
        Assert.assertEquals(this.getExpected().count(IntegerPredicates.isEven()), this.classUnderTest().count(IntegerPredicates.isEven()));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(this.getExpected().countWith(Predicates2.greaterThan(), 2), this.classUnderTest().countWith(Predicates2.greaterThan(), 2));
    }

    @Test
    public void toList() {
        if (this.isOrdered()) {
            Assert.assertEquals(this.getExpected().toList(), this.classUnderTest().toList());
        } else {
            Assert.assertEquals(this.getExpected().toList().toBag(), this.classUnderTest().toList().toBag());
        }
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(this.getExpected().toSortedList(), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSortedList_comparator() {
        Assert.assertEquals(this.getExpected().toSortedList(Comparators.reverseNaturalOrder()), this.classUnderTest().toSortedList(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void toSortedListBy() {
        Assert.assertEquals(this.getExpected().toSortedListBy(String::valueOf), this.classUnderTest().toSortedListBy(String::valueOf));
    }

    @Test
    public void toSet() {
        Assert.assertEquals(this.getExpected().toSet(), this.classUnderTest().toSet());
    }

    @Test
    public void toSortedSet() {
        Verify.assertSortedSetsEqual(this.getExpected().toSortedSet(), this.classUnderTest().toSortedSet());
    }

    @Test
    public void toSortedSet_comparator() {
        Verify.assertSortedSetsEqual(this.getExpected().toSortedSet(Comparators.reverseNaturalOrder()), this.classUnderTest().toSortedSet(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void toSortedSetBy() {
        Verify.assertSortedSetsEqual(this.getExpected().toSortedSetBy(String::valueOf), this.classUnderTest().toSortedSetBy(String::valueOf));
    }

    @Test
    public void toSortedBag() {
        Assert.assertEquals(this.getExpected().toSortedBag(), this.classUnderTest().toSortedBag());
    }

    @Test
    public void toSortedBag_comparator() {
        Assert.assertEquals(this.getExpected().toSortedBag(Comparators.reverseNaturalOrder()), this.classUnderTest().toSortedBag(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void toSortedBagBy() {
        Assert.assertEquals(this.getExpected().toSortedBagBy(String::valueOf), this.classUnderTest().toSortedBagBy(String::valueOf));
    }

    @Test
    public void toMap() {
        Assert.assertEquals(this.getExpected().toMap(String::valueOf, String::valueOf), this.classUnderTest().toMap(String::valueOf, String::valueOf));
    }

    @Test
    public void toSortedMap() {
        Verify.assertSortedMapsEqual(this.getExpected().toSortedMap(id -> id, String::valueOf), this.classUnderTest().toSortedMap(id -> id, String::valueOf));
        Verify.assertListsEqual(this.getExpected().toSortedMap(id -> id, String::valueOf).keySet().toList(), this.classUnderTest().toSortedMap(id -> id, String::valueOf).keySet().toList());
    }

    @Test
    public void toSortedMap_comparator() {
        Verify.assertSortedMapsEqual(this.getExpected().toSortedMap(Comparators.reverseNaturalOrder(), id -> id, String::valueOf), this.classUnderTest().toSortedMap(Comparators.reverseNaturalOrder(), id -> id, String::valueOf));
        Verify.assertListsEqual(this.getExpected().toSortedMap(Comparators.reverseNaturalOrder(), id -> id, String::valueOf).keySet().toList(), this.classUnderTest().toSortedMap(Comparators.reverseNaturalOrder(), id -> id, String::valueOf).keySet().toList());
    }

    @Test
    public void testToString() {
        String expectedString = this.getExpected().toString();
        String actualString = this.classUnderTest().toString();
        this.assertStringsEqual("\\[\\d(, \\d)*\\]", expectedString, actualString);
    }

    @Test
    public void makeString() {
        String expectedString = this.getExpected().makeString();
        String actualString = this.classUnderTest().makeString();
        this.assertStringsEqual("\\d(, \\d)*", expectedString, actualString);
    }

    @Test
    public void makeString_separator() {
        String expectedString = this.getExpected().makeString("~");
        String actualString = this.classUnderTest().makeString("~");
        this.assertStringsEqual("\\d(~\\d)*", expectedString, actualString);
    }

    @Test
    public void makeString_start_separator_end() {
        String expectedString = this.getExpected().makeString("<", "~", ">");
        String actualString = this.classUnderTest().makeString("<", "~", ">");
        this.assertStringsEqual("<\\d(~\\d)*>", expectedString, actualString);
    }

    @Test
    public void appendString() {
        StringBuilder expected = new StringBuilder();
        this.getExpected().appendString(expected);
        String expectedString = expected.toString();
        StringBuilder actual = new StringBuilder();
        this.classUnderTest().appendString(actual);
        String actualString = actual.toString();
        this.assertStringsEqual("\\d(, \\d)*", expectedString, actualString);
    }

    @Test
    public void appendString_separator() {
        StringBuilder expected = new StringBuilder();
        this.getExpected().appendString(expected, "~");
        String expectedString = expected.toString();
        StringBuilder actual = new StringBuilder();
        this.classUnderTest().appendString(actual, "~");
        String actualString = actual.toString();
        this.assertStringsEqual("\\d(~\\d)*", expectedString, actualString);
    }

    @Test
    public void appendString_start_separator_end() {
        StringBuilder expected = new StringBuilder();
        this.getExpected().appendString(expected, "<", "~", ">");
        String expectedString = expected.toString();
        StringBuilder actual = new StringBuilder();
        this.classUnderTest().appendString(actual, "<", "~", ">");
        String actualString = actual.toString();
        this.assertStringsEqual("<\\d(~\\d)*>", expectedString, actualString);
    }

    @Test
    public void appendString_throws() {
        try {
            this.classUnderTest().appendString(new Appendable() {

                public Appendable append(CharSequence csq) throws IOException {
                    throw new IOException("Test exception");
                }

                public Appendable append(CharSequence csq, int start, int end) throws IOException {
                    throw new IOException("Test exception");
                }

                public Appendable append(char c) throws IOException {
                    throw new IOException("Test exception");
                }
            });
            Assert.fail();
        } catch (RuntimeException e) {
            IOException cause = (IOException) e.getCause();
            Assert.assertEquals("Test exception", cause.getMessage());
        }
    }

    protected void assertStringsEqual(String regex, String expectedString, String actualString) {
        if (this.isOrdered()) {
            Assert.assertEquals(expectedString, actualString);
        } else {
            Assert.assertEquals(CharHashBag.newBagWith(expectedString.toCharArray()), CharHashBag.newBagWith(actualString.toCharArray()));
            Assert.assertTrue(Pattern.matches(regex, actualString));
        }
    }

    @Test
    public void groupBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().groupBy(isOddFunction), this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    public void groupByEach() {
        Assert.assertEquals(this.getExpected().groupByEach(new NegativeIntervalFunction()), this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }

    @Test
    public void groupByUniqueKey() {
        if (this.isUnique()) {
            Assert.assertEquals(this.getExpected().groupByUniqueKey(id -> id), this.classUnderTest().groupByUniqueKey(id -> id));
        } else {
            // IllegalStateException in serial, RuntimeException with IllegalStateException cause in parallel
            try {
                this.classUnderTest().groupByUniqueKey(id -> id);
            } catch (RuntimeException ignored) {
                return;
            }
            Assert.fail();
        }
    }

    @Test
    public void aggregateBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().aggregateBy(isOddFunction, () -> 0, (integer11, integer21) -> integer11 + integer21), this.classUnderTest().aggregateBy(isOddFunction, () -> 0, (integer1, integer2) -> integer1 + integer2));
    }

    @Test
    public void aggregateInPlaceBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Function2<Boolean, AtomicInteger, Pair<Boolean, Integer>> atomicIntToInt = (argument1, argument2) -> Tuples.pair(argument1, argument2.get());
        Assert.assertEquals(this.getExpected().aggregateInPlaceBy(isOddFunction, AtomicInteger::new, AtomicInteger::addAndGet).collect(atomicIntToInt), this.classUnderTest().aggregateInPlaceBy(isOddFunction, AtomicInteger::new, AtomicInteger::addAndGet).collect(atomicIntToInt));
    }

    @Test
    public void sumOfInt() {
        Assert.assertEquals(this.getExpected().sumOfInt(Integer::intValue), this.classUnderTest().sumOfInt(Integer::intValue));
    }

    @Test
    public void sumOfLong() {
        Assert.assertEquals(this.getExpected().sumOfLong(Integer::longValue), this.classUnderTest().sumOfLong(Integer::longValue));
    }

    @Test
    public void sumOfFloat() {
        Assert.assertEquals(this.getExpected().sumOfFloat(Integer::floatValue), this.classUnderTest().sumOfFloat(Integer::floatValue), 0.0);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        FloatFunction<Integer> roundingSensitiveElementFunction = i -> (i <= 99995) ? 1.0e-18f : 1.0f;
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        double baseline = this.getExpectedWith(list.toArray(new Integer[] {})).sumOfFloat(roundingSensitiveElementFunction);
        for (Integer batchSize : BATCH_SIZES) {
            this.batchSize = batchSize;
            ParallelIterable<Integer> testCollection = this.newWith(list.toArray(new Integer[] {}));
            Assert.assertEquals("Batch size: " + this.batchSize, baseline, testCollection.sumOfFloat(roundingSensitiveElementFunction), 1.0e-15d);
        }
    }

    @Test
    public void sumOfDouble() {
        Assert.assertEquals(this.getExpected().sumOfDouble(Integer::doubleValue), this.classUnderTest().sumOfDouble(Integer::doubleValue), 0.0);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        DoubleFunction<Integer> roundingSensitiveElementFunction = i -> (i <= 99995) ? 1.0e-18d : 1.0d;
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        double baseline = this.getExpectedWith(list.toArray(new Integer[] {})).sumOfDouble(roundingSensitiveElementFunction);
        for (Integer batchSize : BATCH_SIZES) {
            this.batchSize = batchSize;
            ParallelIterable<Integer> testCollection = this.newWith(list.toArray(new Integer[] {}));
            Assert.assertEquals("Batch size: " + this.batchSize, baseline, testCollection.sumOfDouble(roundingSensitiveElementFunction), 1.0e-15d);
        }
    }

    @Test
    public void asUnique() {
        Assert.assertEquals(this.getExpected().toSet(), this.classUnderTest().asUnique().toSet());
        Assert.assertEquals(this.getExpected().toList().toSet(), this.classUnderTest().asUnique().toList().toSet());
        Assert.assertEquals(this.getExpected().collect(each -> "!").toSet().toList(), this.classUnderTest().collect(each -> "!").asUnique().toList());
    }

    @Test
    public void forEach_executionException() {
        try {
            this.classUnderTest().forEach(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            ExecutionException executionException = (ExecutionException) e.getCause();
            RuntimeException runtimeException = (RuntimeException) executionException.getCause();
            Assert.assertEquals("Execution exception", runtimeException.getMessage());
        }
    }

    @Test
    public void collect_executionException() {
        try {
            this.classUnderTest().collect(each -> {
                throw new RuntimeException("Execution exception");
            }).toString();
        } catch (RuntimeException e) {
            ExecutionException executionException = (ExecutionException) e.getCause();
            RuntimeException runtimeException = (RuntimeException) executionException.getCause();
            Assert.assertEquals("Execution exception", runtimeException.getMessage());
        }
    }

    @Test
    public void anySatisfy_executionException() {
        try {
            this.classUnderTest().anySatisfy(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            ExecutionException executionException = (ExecutionException) e.getCause();
            RuntimeException runtimeException = (RuntimeException) executionException.getCause();
            Assert.assertEquals("Execution exception", runtimeException.getMessage());
        }
    }

    @Test
    public void allSatisfy_executionException() {
        try {
            this.classUnderTest().allSatisfy(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            ExecutionException executionException = (ExecutionException) e.getCause();
            RuntimeException runtimeException = (RuntimeException) executionException.getCause();
            Assert.assertEquals("Execution exception", runtimeException.getMessage());
        }
    }

    @Test
    public void detect_executionException() {
        try {
            this.classUnderTest().detect(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            ExecutionException executionException = (ExecutionException) e.getCause();
            RuntimeException runtimeException = (RuntimeException) executionException.getCause();
            Assert.assertEquals("Execution exception", runtimeException.getMessage());
        }
    }

    @Test
    public void forEach_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().forEach(new CheckedProcedure<Integer>() {

            @Override
            public void safeValue(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                throw new AssertionError();
            }
        }));
        Assert.assertTrue(Thread.interrupted());
        Assert.assertFalse(Thread.interrupted());
    }

    @Test
    public void anySatisfy_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().anySatisfy(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                throw new AssertionError();
            }
        }));
        Assert.assertTrue(Thread.interrupted());
        Assert.assertFalse(Thread.interrupted());
    }

    @Test
    public void allSatisfy_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().allSatisfy(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                throw new AssertionError();
            }
        }));
        Assert.assertTrue(Thread.interrupted());
        Assert.assertFalse(Thread.interrupted());
    }

    @Test
    public void detect_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().detect(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                throw new AssertionError();
            }
        }));
        Assert.assertTrue(Thread.interrupted());
        Assert.assertFalse(Thread.interrupted());
    }

    @Test
    public void toString_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().collect(new CheckedFunction<Integer, String>() {

            @Override
            public String safeValueOf(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                throw new AssertionError();
            }
        }).toString());
        Assert.assertTrue(Thread.interrupted());
        Assert.assertFalse(Thread.interrupted());
    }

    @Test
    public void minWithEmptyBatch() {
        // there will be a batch contains [4, 4] that will return empty before computing min of the batch
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().select(Predicates.lessThan(4)).min());
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().reject(Predicates.greaterThan(3)).min());
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().asUnique().min());
    }

    @Test
    public void maxWithEmptyBatch() {
        // there will be a batch contains [4, 4] that will return empty before computing min of the batch
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().select(Predicates.lessThan(4)).max());
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().reject(Predicates.greaterThan(3)).max());
        Assert.assertEquals(Integer.valueOf(4), this.classUnderTest().asUnique().max());
    }

    @Test(expected = NullPointerException.class)
    public void min_null_throws() {
        this.newWith(1, null, 2).min(Integer::compareTo);
    }

    @Test(expected = NullPointerException.class)
    public void max_null_throws() {
        this.newWith(1, null, 2).max(Integer::compareTo);
    }

    @Test(expected = NullPointerException.class)
    public void minBy_null_throws() {
        this.newWith(1, null, 2).minBy(Integer::valueOf);
    }

    @Test(expected = NullPointerException.class)
    public void maxBy_null_throws() {
        this.newWith(1, null, 2).maxBy(Integer::valueOf);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray_array() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray_array);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
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
        public void benchmark_toSortedList_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_comparator);
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
        public void benchmark_makeString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_separator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_start_separator_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_separator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_start_separator_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minWithEmptyBatch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxWithEmptyBatch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new ParallelIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelIterableTestCase> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelIterableTestCase::toArray;
            this.payloads.toArray_array = ParallelIterableTestCase::toArray_array;
            this.payloads.forEach = ParallelIterableTestCase::forEach;
            this.payloads.forEachWith = ParallelIterableTestCase::forEachWith;
            this.payloads.select = ParallelIterableTestCase::select;
            this.payloads.selectWith = ParallelIterableTestCase::selectWith;
            this.payloads.reject = ParallelIterableTestCase::reject;
            this.payloads.rejectWith = ParallelIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = ParallelIterableTestCase::selectInstancesOf;
            this.payloads.collect = ParallelIterableTestCase::collect;
            this.payloads.collectWith = ParallelIterableTestCase::collectWith;
            this.payloads.collectIf = ParallelIterableTestCase::collectIf;
            this.payloads.flatCollect = ParallelIterableTestCase::flatCollect;
            this.payloads.detect = ParallelIterableTestCase::detect;
            this.payloads.detectIfNone = ParallelIterableTestCase::detectIfNone;
            this.payloads.detectWith = ParallelIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = ParallelIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelIterableTestCase::min;
            this.payloads.max = ParallelIterableTestCase::max;
            this.payloads.minBy = ParallelIterableTestCase::minBy;
            this.payloads.maxBy = ParallelIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ParallelIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = ParallelIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ParallelIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ParallelIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ParallelIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelIterableTestCase::noneSatisfyWith;
            this.payloads.count = ParallelIterableTestCase::count;
            this.payloads.countWith = ParallelIterableTestCase::countWith;
            this.payloads.toList = ParallelIterableTestCase::toList;
            this.payloads.toSortedList = ParallelIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = ParallelIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelIterableTestCase::toSortedListBy;
            this.payloads.toSet = ParallelIterableTestCase::toSet;
            this.payloads.toSortedSet = ParallelIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = ParallelIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelIterableTestCase::toSortedBagBy;
            this.payloads.toMap = ParallelIterableTestCase::toMap;
            this.payloads.toSortedMap = ParallelIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = ParallelIterableTestCase::testToString;
            this.payloads.makeString = ParallelIterableTestCase::makeString;
            this.payloads.makeString_separator = ParallelIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = ParallelIterableTestCase::appendString;
            this.payloads.appendString_separator = ParallelIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelIterableTestCase::appendString_throws;
            this.payloads.groupBy = ParallelIterableTestCase::groupBy;
            this.payloads.groupByEach = ParallelIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ParallelIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = ParallelIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = ParallelIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelIterableTestCase::asUnique;
            this.payloads.forEach_executionException = ParallelIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = ParallelIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelIterableTestCase::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
