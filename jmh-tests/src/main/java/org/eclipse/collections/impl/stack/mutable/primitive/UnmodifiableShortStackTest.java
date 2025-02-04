/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.eclipse.collections.impl.stack.primitive.AbstractShortStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableShortStackTest extends AbstractShortStackTestCase {

    @Override
    protected MutableShortStack classUnderTest() {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected MutableShortStack newWith(short... elements) {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newMutableCollectionWith(short... elements) {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newWithTopToBottom(short... elements) {
        return new UnmodifiableShortStack(ShortArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push() {
        this.classUnderTest().push((short) 5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void pop() {
        this.classUnderTest().pop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popWithCount() {
        this.classUnderTest().pop(2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Test
    public void asUnmodifiable() {
        MutableShortStack stack1 = new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableShortStack stack1 = new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(SynchronizedShortStack.class, stack1.asSynchronized());
    }

    @Test
    public void shortIterator_with_remove() {
        UnmodifiableShortStack shortIterable = (UnmodifiableShortStack) this.classUnderTest();
        MutableShortIterator iterator = (MutableShortIterator) shortIterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void shortIterator_throws_for_remove_before_next() {
        UnmodifiableShortStack shortIterable = (UnmodifiableShortStack) this.classUnderTest();
        MutableShortIterator iterator = (MutableShortIterator) shortIterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableShortStackTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popWithCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableShortStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortStackTest> shortIterator_throws_for_remove_before_next;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableShortStackTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableShortStackTest::newCollection;
            this.payloads.isEmpty = UnmodifiableShortStackTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableShortStackTest::notEmpty;
            this.payloads.tap = UnmodifiableShortStackTest::tap;
            this.payloads.contains = UnmodifiableShortStackTest::contains;
            this.payloads.containsAllArray = UnmodifiableShortStackTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableShortStackTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableShortStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableShortStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableShortStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableShortStackTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableShortStackTest::forEach;
            this.payloads.size = UnmodifiableShortStackTest::size;
            this.payloads.count = UnmodifiableShortStackTest::count;
            this.payloads.anySatisfy = UnmodifiableShortStackTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableShortStackTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableShortStackTest::noneSatisfy;
            this.payloads.collect = UnmodifiableShortStackTest::collect;
            this.payloads.collectWithTarget = UnmodifiableShortStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableShortStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableShortStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableShortStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableShortStackTest::collectPrimitivesToSets;
            this.payloads.select = UnmodifiableShortStackTest::select;
            this.payloads.selectWithTarget = UnmodifiableShortStackTest::selectWithTarget;
            this.payloads.reject = UnmodifiableShortStackTest::reject;
            this.payloads.rejectWithTarget = UnmodifiableShortStackTest::rejectWithTarget;
            this.payloads.max = UnmodifiableShortStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableShortStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableShortStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableShortStackTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableShortStackTest::sum;
            this.payloads.summaryStatistics = UnmodifiableShortStackTest::summaryStatistics;
            this.payloads.average = UnmodifiableShortStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableShortStackTest::averageIfEmpty;
            this.payloads.median = UnmodifiableShortStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableShortStackTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableShortStackTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableShortStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableShortStackTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableShortStackTest::testEquals;
            this.payloads.testHashCode = UnmodifiableShortStackTest::testHashCode;
            this.payloads.toSortedList = UnmodifiableShortStackTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableShortStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableShortStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableShortStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableShortStackTest::toSet;
            this.payloads.toBag = UnmodifiableShortStackTest::toBag;
            this.payloads.asLazy = UnmodifiableShortStackTest::asLazy;
            this.payloads.injectInto = UnmodifiableShortStackTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableShortStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableShortStackTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableShortStackTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableShortStackTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableShortStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableShortStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableShortStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableShortStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableShortStackTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableShortStackTest::reduceIfEmpty;
            this.payloads.shortIterator = UnmodifiableShortStackTest::shortIterator;
            this.payloads.peek = UnmodifiableShortStackTest::peek;
            this.payloads.peekAtIndex = UnmodifiableShortStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = UnmodifiableShortStackTest::testToString;
            this.payloads.toList = UnmodifiableShortStackTest::toList;
            this.payloads.makeString = UnmodifiableShortStackTest::makeString;
            this.payloads.detectIfNone = UnmodifiableShortStackTest::detectIfNone;
            this.payloads.appendString = UnmodifiableShortStackTest::appendString;
            this.payloads.toImmutable = UnmodifiableShortStackTest::toImmutable;
            this.payloads.selectWithIndex = UnmodifiableShortStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = UnmodifiableShortStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = UnmodifiableShortStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableShortStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = UnmodifiableShortStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableShortStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = UnmodifiableShortStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::push, java.lang.UnsupportedOperationException.class);
            this.payloads.pop = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::pop, java.lang.UnsupportedOperationException.class);
            this.payloads.popWithCount = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::popWithCount, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortStackTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableShortStackTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableShortStackTest::asSynchronized;
            this.payloads.shortIterator_with_remove = UnmodifiableShortStackTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = UnmodifiableShortStackTest::shortIterator_throws_for_remove_before_next;
        }
    }
}
