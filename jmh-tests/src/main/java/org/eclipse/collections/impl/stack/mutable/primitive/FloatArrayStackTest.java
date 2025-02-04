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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class FloatArrayStackTest extends AbstractMutableFloatStackTestCase {

    @Override
    protected MutableFloatStack classUnderTest() {
        return FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected MutableFloatStack newWith(float... elements) {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableFloatStack newMutableCollectionWith(float... elements) {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableFloatStack newWithTopToBottom(float... elements) {
        return FloatArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableFloatStack newWithIterableTopToBottom(FloatIterable iterable) {
        return FloatArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableFloatStack newWithIterable(FloatIterable iterable) {
        return FloatArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Float> newObjectCollectionWith(Float... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        FloatArrayStack stack = FloatArrayStack.newStackFromTopToBottom();
        stack.push(1.0f);
        Assert.assertEquals(1.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f), stack);
        stack.push(2.0f);
        Assert.assertEquals(2.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(2.0f, 1.0f), stack);
        stack.push(3.0f);
        Assert.assertEquals(3.0f, stack.peek(), 0.0f);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(3.0f, 2.0f, 1.0f), stack);
        Assert.assertEquals(2.0f, stack.peekAt(1), 0.0f);
        Assert.assertEquals(3.0f, stack.pop(), 0.0f);
        Assert.assertEquals(2.0f, stack.peek(), 0.0f);
        Assert.assertEquals(2.0f, stack.pop(), 0.0f);
        Assert.assertEquals(1.0f, stack.peek(), 0.0f);
        Assert.assertEquals(1.0f, stack.pop(), 0.0f);
        FloatArrayStack stack2 = FloatArrayStack.newStackFromTopToBottom(5.0f, 4.0f, 3.0f, 2.0f, 1.0f);
        stack2.pop(2);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(3.0f, 2.0f, 1.0f), stack2);
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 2.0f), stack2.peek(2));
        FloatArrayStack stack8 = FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f, 4.0f);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f, 4.0f), stack8);
        Assert.assertEquals(new FloatArrayList(), stack8.peek(0));
        FloatArrayStack stack9 = FloatArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new FloatArrayList(), stack9.pop(0));
        Assert.assertEquals(new FloatArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatArrayStackTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekWithCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_stack_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackWithOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackWithOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackIterableOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomIterableOrder);
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
        public void benchmark_pop_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_empty_stack_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_negative_count_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_negative_count_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_count_greater_than_stack_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_count_greater_than_stack_size_throws_exception);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new FloatArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayStackTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FloatArrayStackTest::newCollectionWith;
            this.payloads.newCollection = FloatArrayStackTest::newCollection;
            this.payloads.isEmpty = FloatArrayStackTest::isEmpty;
            this.payloads.notEmpty = FloatArrayStackTest::notEmpty;
            this.payloads.tap = FloatArrayStackTest::tap;
            this.payloads.contains = FloatArrayStackTest::contains;
            this.payloads.contains_NaN = FloatArrayStackTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = FloatArrayStackTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = FloatArrayStackTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = FloatArrayStackTest::contains_zero;
            this.payloads.testEquals_NaN = FloatArrayStackTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = FloatArrayStackTest::contains_different_NaNs;
            this.payloads.containsAllArray = FloatArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = FloatArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = FloatArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = FloatArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = FloatArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = FloatArrayStackTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = FloatArrayStackTest::forEach;
            this.payloads.size = FloatArrayStackTest::size;
            this.payloads.count = FloatArrayStackTest::count;
            this.payloads.anySatisfy = FloatArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = FloatArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = FloatArrayStackTest::noneSatisfy;
            this.payloads.collect = FloatArrayStackTest::collect;
            this.payloads.collectWithTarget = FloatArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FloatArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FloatArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FloatArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FloatArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = FloatArrayStackTest::select;
            this.payloads.selectWithTarget = FloatArrayStackTest::selectWithTarget;
            this.payloads.reject = FloatArrayStackTest::reject;
            this.payloads.rejectWithTarget = FloatArrayStackTest::rejectWithTarget;
            this.payloads.max = FloatArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FloatArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatArrayStackTest::maxIfEmpty;
            this.payloads.sum = FloatArrayStackTest::sum;
            this.payloads.summaryStatistics = FloatArrayStackTest::summaryStatistics;
            this.payloads.sumConsistentRounding = FloatArrayStackTest::sumConsistentRounding;
            this.payloads.average = FloatArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FloatArrayStackTest::averageIfEmpty;
            this.payloads.median = FloatArrayStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FloatArrayStackTest::medianIfEmpty;
            this.payloads.toArray = FloatArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = FloatArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = FloatArrayStackTest::toSortedArray;
            this.payloads.testEquals = FloatArrayStackTest::testEquals;
            this.payloads.testHashCode = FloatArrayStackTest::testHashCode;
            this.payloads.toSortedList = FloatArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = FloatArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FloatArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FloatArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FloatArrayStackTest::toSet;
            this.payloads.toBag = FloatArrayStackTest::toBag;
            this.payloads.asLazy = FloatArrayStackTest::asLazy;
            this.payloads.injectInto = FloatArrayStackTest::injectInto;
            this.payloads.injectIntoBoolean = FloatArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FloatArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = FloatArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = FloatArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = FloatArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = FloatArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = FloatArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = FloatArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FloatArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = FloatArrayStackTest::reduceIfEmpty;
            this.payloads.floatIterator = FloatArrayStackTest::floatIterator;
            this.payloads.peekAtIndex = FloatArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = FloatArrayStackTest::testToString;
            this.payloads.toList = FloatArrayStackTest::toList;
            this.payloads.makeString = FloatArrayStackTest::makeString;
            this.payloads.detectIfNone = FloatArrayStackTest::detectIfNone;
            this.payloads.appendString = FloatArrayStackTest::appendString;
            this.payloads.toImmutable = FloatArrayStackTest::toImmutable;
            this.payloads.selectWithIndex = FloatArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = FloatArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = FloatArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = FloatArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = FloatArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = FloatArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = FloatArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = FloatArrayStackTest::peek;
            this.payloads.peekWithCount = FloatArrayStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = FloatArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = FloatArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = FloatArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = FloatArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = FloatArrayStackTest::push;
            this.payloads.pop = FloatArrayStackTest::pop;
            this.payloads.popWithCount = FloatArrayStackTest::popWithCount;
            this.payloads.clear = FloatArrayStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = FloatArrayStackTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatArrayStackTest::asUnmodifiable;
            this.payloads.newEmpty = FloatArrayStackTest::newEmpty;
            this.payloads.testPushPopAndPeek = FloatArrayStackTest::testPushPopAndPeek;
            this.payloads.classIsNonInstantiable = FloatArrayStackTest::classIsNonInstantiable;
        }
    }
}
