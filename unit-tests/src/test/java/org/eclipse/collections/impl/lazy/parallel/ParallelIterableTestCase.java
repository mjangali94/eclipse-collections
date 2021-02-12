/*
 * Copyright (c) 2016 Goldman Sachs.
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
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray_array() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray_array, this.description("toArray_array"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_empty_throws, this.description("min_empty_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_empty_throws, this.description("max_empty_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minBy, this.description("minBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxBy, this.description("maxBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_empty_throws_without_comparator, this.description("min_empty_throws_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_empty_throws_without_comparator, this.description("max_empty_throws_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countWith, this.description("countWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList_comparator, this.description("toSortedList_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListBy, this.description("toSortedListBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet, this.description("toSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet_comparator, this.description("toSortedSet_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetBy, this.description("toSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag, this.description("toSortedBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_comparator, this.description("toSortedBag_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap, this.description("toSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap_comparator, this.description("toSortedMap_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_separator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString_separator, this.description("makeString_separator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_start_separator_end() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString_start_separator_end, this.description("makeString_start_separator_end"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_separator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString_separator, this.description("appendString_separator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_start_separator_end() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString_start_separator_end, this.description("appendString_start_separator_end"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString_throws, this.description("appendString_throws"));
        }



        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateBy, this.description("aggregateBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateInPlaceBy, this.description("aggregateInPlaceBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfInt, this.description("sumOfInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfLong, this.description("sumOfLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfFloat, this.description("sumOfFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfFloatConsistentRounding, this.description("sumOfFloatConsistentRounding"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfDouble, this.description("sumOfDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfDoubleConsistentRounding, this.description("sumOfDoubleConsistentRounding"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnique, this.description("asUnique"));
        }



        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_executionException, this.description("collect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_executionException, this.description("anySatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_executionException, this.description("allSatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_executionException, this.description("detect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_interruptedException, this.description("forEach_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_interruptedException, this.description("anySatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_interruptedException, this.description("allSatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_interruptedException, this.description("detect_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toString_interruptedException, this.description("toString_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minWithEmptyBatch() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minWithEmptyBatch, this.description("minWithEmptyBatch"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxWithEmptyBatch() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxWithEmptyBatch, this.description("maxWithEmptyBatch"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_null_throws, this.description("min_null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_null_throws, this.description("max_null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minBy_null_throws, this.description("minBy_null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxBy_null_throws, this.description("maxBy_null_throws"), java.lang.NullPointerException.class);
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        @java.lang.Override
        public void after() throws java.lang.Throwable {
            this.implementation().tearDown();
            super.after();
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract ParallelIterableTestCase implementation();
    }
}
