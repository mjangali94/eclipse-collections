/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;
import org.eclipse.collections.impl.factory.primitive.CharStacks;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableCharArrayStackTest extends AbstractImmutableCharStackTestCase {

    @Override
    protected ImmutableCharStack classUnderTest() {
        return ImmutableCharArrayStack.newStackWith((char) 1, (char) 2, (char) 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws() {
        ImmutableCharArrayStack.newStack(CharStacks.mutable.with((char) 1));
    }

    @Test
    public void newWithIterable() {
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3), this.newWithIterable(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void newWithTopToBottom() {
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 3), this.newWithTopToBottom((char) 1, (char) 2, (char) 3));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableCharArrayStack iterable = ImmutableCharArrayStack.newStackWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharArrayStackTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_negative_count_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_negative_count_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_count_greater_than_stack_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_count_greater_than_stack_size_throws_exception);
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
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStack_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStack_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithTopToBottom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> testNewStack_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> newWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> newWithTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharArrayStackTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableCharArrayStackTest::newCollectionWith;
            this.payloads.newCollection = ImmutableCharArrayStackTest::newCollection;
            this.payloads.isEmpty = ImmutableCharArrayStackTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharArrayStackTest::notEmpty;
            this.payloads.tap = ImmutableCharArrayStackTest::tap;
            this.payloads.contains = ImmutableCharArrayStackTest::contains;
            this.payloads.containsAllArray = ImmutableCharArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableCharArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableCharArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableCharArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableCharArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableCharArrayStackTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableCharArrayStackTest::forEach;
            this.payloads.size = ImmutableCharArrayStackTest::size;
            this.payloads.count = ImmutableCharArrayStackTest::count;
            this.payloads.anySatisfy = ImmutableCharArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharArrayStackTest::noneSatisfy;
            this.payloads.collect = ImmutableCharArrayStackTest::collect;
            this.payloads.collectWithTarget = ImmutableCharArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableCharArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableCharArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableCharArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableCharArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableCharArrayStackTest::select;
            this.payloads.selectWithTarget = ImmutableCharArrayStackTest::selectWithTarget;
            this.payloads.reject = ImmutableCharArrayStackTest::reject;
            this.payloads.rejectWithTarget = ImmutableCharArrayStackTest::rejectWithTarget;
            this.payloads.max = ImmutableCharArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableCharArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharArrayStackTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharArrayStackTest::sum;
            this.payloads.summaryStatistics = ImmutableCharArrayStackTest::summaryStatistics;
            this.payloads.average = ImmutableCharArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableCharArrayStackTest::averageIfEmpty;
            this.payloads.median = ImmutableCharArrayStackTest::median;
            this.payloads.medianIfEmpty = ImmutableCharArrayStackTest::medianIfEmpty;
            this.payloads.toArray = ImmutableCharArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableCharArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableCharArrayStackTest::toSortedArray;
            this.payloads.testEquals = ImmutableCharArrayStackTest::testEquals;
            this.payloads.testHashCode = ImmutableCharArrayStackTest::testHashCode;
            this.payloads.toSortedList = ImmutableCharArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableCharArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableCharArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableCharArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableCharArrayStackTest::toSet;
            this.payloads.toBag = ImmutableCharArrayStackTest::toBag;
            this.payloads.asLazy = ImmutableCharArrayStackTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableCharArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableCharArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableCharArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableCharArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableCharArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableCharArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableCharArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableCharArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableCharArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableCharArrayStackTest::reduceIfEmpty;
            this.payloads.charIterator = ImmutableCharArrayStackTest::charIterator;
            this.payloads.peek = ImmutableCharArrayStackTest::peek;
            this.payloads.peekAtIndex = ImmutableCharArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.detectIfNone = ImmutableCharArrayStackTest::detectIfNone;
            this.payloads.selectWithIndex = ImmutableCharArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableCharArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableCharArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableCharArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableCharArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableCharArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = ImmutableCharArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = ImmutableCharArrayStackTest::push;
            this.payloads.pop = ImmutableCharArrayStackTest::pop;
            this.payloads.popWithCount = ImmutableCharArrayStackTest::popWithCount;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableCharArrayStackTest::testToString;
            this.payloads.makeString = ImmutableCharArrayStackTest::makeString;
            this.payloads.appendString = ImmutableCharArrayStackTest::appendString;
            this.payloads.toList = ImmutableCharArrayStackTest::toList;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toImmutable = ImmutableCharArrayStackTest::toImmutable;
            this.payloads.testNewStack_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharArrayStackTest::testNewStack_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newWithIterable = ImmutableCharArrayStackTest::newWithIterable;
            this.payloads.newWithTopToBottom = ImmutableCharArrayStackTest::newWithTopToBottom;
            this.payloads.injectInto = ImmutableCharArrayStackTest::injectInto;
        }
    }
}
