/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import java.util.EmptyStackException;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractLongStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableLongStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableLongStackTestCase extends AbstractLongStackTestCase {

    @Override
    protected abstract MutableLongStack classUnderTest();

    @Override
    protected abstract MutableLongStack newWith(long... elements);

    @Override
    protected abstract MutableLongStack newMutableCollectionWith(long... elements);

    @Override
    protected abstract MutableLongStack newWithTopToBottom(long... elements);

    protected abstract MutableLongStack newWithIterableTopToBottom(LongIterable iterable);

    protected abstract MutableLongStack newWithIterable(LongIterable iterable);

    @Override
    public void peekAtIndex() {
        super.peekAtIndex();
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek() {
        super.peek();
        MutableLongStack stack = this.classUnderTest();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(size - i, stack.peek());
            stack.pop();
        }
    }

    @Test
    public void peekWithCount() {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(LongArrayList.newListWith(size - 2), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception() {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder() {
        MutableLongStack stack = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder() {
        MutableLongStack stack = this.newWithIterable(LongArrayList.newListWith(1L, 2L, 3L));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder() {
        MutableLongStack stack = this.newWithTopToBottom(3L, 2L, 1L);
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder() {
        MutableLongStack stack = this.newWithIterableTopToBottom(LongArrayList.newListWith(3L, 2L, 1L));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void push() {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(5L);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), stack.peek(2));
    }

    @Test
    public void pop() {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(size - i, stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount() {
        int size = this.classUnderTest().size();
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), this.classUnderTest().pop(2));
    }

    @Test
    public void clear() {
        MutableLongStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableLongStack stack1 = this.newWith();
        Verify.assertSize(0, stack1);
        stack1.clear();
        Verify.assertSize(0, stack1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_empty_stack_throws_exception() {
        this.newWith().pop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_negative_count_throws_exception() {
        this.newWith(1L).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception() {
        this.newWith(1L).pop(2);
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedLongStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongStack.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asUnmodifiable());
    }

    /**
     * @since 9.2.
     */
    @Test
    public void newEmpty() {
        Assert.assertTrue(this.classUnderTest().newEmpty().isEmpty());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().newEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongStackTestCase instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongStackTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableLongStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableLongStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableLongStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongStackTestCase::notEmpty;
            this.payloads.tap = AbstractMutableLongStackTestCase::tap;
            this.payloads.contains = AbstractMutableLongStackTestCase::contains;
            this.payloads.containsAllArray = AbstractMutableLongStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableLongStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableLongStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableLongStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableLongStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableLongStackTestCase::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableLongStackTestCase::forEach;
            this.payloads.size = AbstractMutableLongStackTestCase::size;
            this.payloads.count = AbstractMutableLongStackTestCase::count;
            this.payloads.anySatisfy = AbstractMutableLongStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongStackTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableLongStackTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableLongStackTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableLongStackTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableLongStackTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableLongStackTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableLongStackTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableLongStackTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableLongStackTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableLongStackTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableLongStackTestCase::rejectWithTarget;
            this.payloads.max = AbstractMutableLongStackTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableLongStackTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongStackTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongStackTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongStackTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableLongStackTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableLongStackTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableLongStackTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableLongStackTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableLongStackTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableLongStackTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableLongStackTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableLongStackTestCase::toSortedArray;
            this.payloads.testEquals = AbstractMutableLongStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongStackTestCase::testHashCode;
            this.payloads.toSortedList = AbstractMutableLongStackTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableLongStackTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableLongStackTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableLongStackTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableLongStackTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongStackTestCase::toBag;
            this.payloads.asLazy = AbstractMutableLongStackTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableLongStackTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableLongStackTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableLongStackTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableLongStackTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableLongStackTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableLongStackTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableLongStackTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableLongStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableLongStackTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableLongStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableLongStackTestCase::reduceIfEmpty;
            this.payloads.longIterator = AbstractMutableLongStackTestCase::longIterator;
            this.payloads.peekAtIndex = AbstractMutableLongStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractMutableLongStackTestCase::testToString;
            this.payloads.toList = AbstractMutableLongStackTestCase::toList;
            this.payloads.makeString = AbstractMutableLongStackTestCase::makeString;
            this.payloads.detectIfNone = AbstractMutableLongStackTestCase::detectIfNone;
            this.payloads.appendString = AbstractMutableLongStackTestCase::appendString;
            this.payloads.toImmutable = AbstractMutableLongStackTestCase::toImmutable;
            this.payloads.selectWithIndex = AbstractMutableLongStackTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractMutableLongStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractMutableLongStackTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractMutableLongStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractMutableLongStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractMutableLongStackTestCase::collectWithIndexWithTarget;
            this.payloads.chunk = AbstractMutableLongStackTestCase::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = AbstractMutableLongStackTestCase::peek;
            this.payloads.peekWithCount = AbstractMutableLongStackTestCase::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = AbstractMutableLongStackTestCase::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = AbstractMutableLongStackTestCase::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = AbstractMutableLongStackTestCase::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = AbstractMutableLongStackTestCase::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = AbstractMutableLongStackTestCase::push;
            this.payloads.pop = AbstractMutableLongStackTestCase::pop;
            this.payloads.popWithCount = AbstractMutableLongStackTestCase::popWithCount;
            this.payloads.clear = AbstractMutableLongStackTestCase::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongStackTestCase::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = AbstractMutableLongStackTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongStackTestCase::asUnmodifiable;
            this.payloads.newEmpty = AbstractMutableLongStackTestCase::newEmpty;
        }
    }
}
