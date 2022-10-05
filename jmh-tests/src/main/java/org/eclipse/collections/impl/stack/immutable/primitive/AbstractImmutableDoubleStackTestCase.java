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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.stack.primitive.AbstractDoubleStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleStack}.
 * This file was automatically generated from template file abstractImmutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractImmutableDoubleStackTestCase extends AbstractDoubleStackTestCase {

    @Override
    protected abstract ImmutableDoubleStack classUnderTest();

    @Override
    protected ImmutableDoubleStack newWith(double... elements) {
        return DoubleStacks.immutable.of(elements);
    }

    @Override
    protected MutableDoubleStack newMutableCollectionWith(double... elements) {
        return DoubleArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Double> newObjectCollectionWith(Double... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Override
    protected ImmutableDoubleStack newWithTopToBottom(double... elements) {
        return ImmutableDoubleArrayStack.newStackFromTopToBottom(elements);
    }

    protected ImmutableDoubleStack newWithIterableTopToBottom(DoubleIterable iterable) {
        return ImmutableDoubleArrayStack.newStackFromTopToBottom(iterable);
    }

    protected ImmutableDoubleStack newWithIterable(DoubleIterable iterable) {
        return ImmutableDoubleArrayStack.newStack(iterable);
    }

    @Test
    public void push() {
        ImmutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        ImmutableDoubleStack modified = stack.push(5.0);
        Assert.assertEquals(5.0, modified.peek(), 0.0);
        Verify.assertSize(size + 1, modified);
        Verify.assertSize(size, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Test
    public void pop() {
        ImmutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        ImmutableDoubleStack modified = stack.pop();
        Assert.assertEquals(size - 1, modified.peek(), 0.0);
        Verify.assertSize(size - 1, modified);
        Verify.assertSize(size, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Test
    public void popWithCount() {
        ImmutableDoubleStack stack = this.classUnderTest();
        ImmutableDoubleStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        int size = stack.size();
        ImmutableDoubleStack modified = stack.pop(2);
        Assert.assertEquals(size - 2, modified.peek(), 0.0);
        Verify.assertSize(size - 2, modified);
        Verify.assertSize(size, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_negative_count_throws_exception() {
        this.classUnderTest().pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception() {
        this.classUnderTest().pop(this.classUnderTest().size() + 1);
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals(this.createExpectedString("[", ", ", "]"), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals(this.createExpectedString("", ", ", ""), this.classUnderTest().makeString());
        Assert.assertEquals(this.createExpectedString("", "|", ""), this.classUnderTest().makeString("|"));
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), this.classUnderTest().makeString("{", "|", "}"));
    }

    @Override
    @Test
    public void appendString() {
        StringBuilder appendable1 = new StringBuilder();
        this.classUnderTest().appendString(appendable1);
        Assert.assertEquals(this.createExpectedString("", ", ", ""), appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2, "|");
        Assert.assertEquals(this.createExpectedString("", "|", ""), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "{", "|", "}");
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), appendable3.toString());
    }

    @Override
    @Test
    public void toList() {
        DoubleArrayList expected = DoubleArrayList.newListWith();
        this.classUnderTest().forEach(expected::add);
        Assert.assertEquals(expected, this.classUnderTest().toList());
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        DoubleStacks.immutable.of().median();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableDoubleStack expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableDoubleStackTestCase instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableDoubleStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleStackTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableDoubleStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableDoubleStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableDoubleStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableDoubleStackTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableDoubleStackTestCase::tap;
            this.payloads.contains = AbstractImmutableDoubleStackTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableDoubleStackTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableDoubleStackTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableDoubleStackTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableDoubleStackTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableDoubleStackTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableDoubleStackTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableDoubleStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableDoubleStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableDoubleStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableDoubleStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableDoubleStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableDoubleStackTestCase::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableDoubleStackTestCase::forEach;
            this.payloads.size = AbstractImmutableDoubleStackTestCase::size;
            this.payloads.count = AbstractImmutableDoubleStackTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableDoubleStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableDoubleStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableDoubleStackTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableDoubleStackTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableDoubleStackTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableDoubleStackTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableDoubleStackTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableDoubleStackTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableDoubleStackTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableDoubleStackTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableDoubleStackTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableDoubleStackTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableDoubleStackTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableDoubleStackTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableDoubleStackTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableDoubleStackTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableDoubleStackTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableDoubleStackTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableDoubleStackTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableDoubleStackTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableDoubleStackTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableDoubleStackTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableDoubleStackTestCase::median;
            this.payloads.medianIfEmpty = AbstractImmutableDoubleStackTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableDoubleStackTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableDoubleStackTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableDoubleStackTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableDoubleStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableDoubleStackTestCase::testHashCode;
            this.payloads.toSortedList = AbstractImmutableDoubleStackTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableDoubleStackTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableDoubleStackTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableDoubleStackTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableDoubleStackTestCase::toSet;
            this.payloads.toBag = AbstractImmutableDoubleStackTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableDoubleStackTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableDoubleStackTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableDoubleStackTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableDoubleStackTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableDoubleStackTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableDoubleStackTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableDoubleStackTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableDoubleStackTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableDoubleStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableDoubleStackTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableDoubleStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableDoubleStackTestCase::reduceIfEmpty;
            this.payloads.doubleIterator = AbstractImmutableDoubleStackTestCase::doubleIterator;
            this.payloads.peek = AbstractImmutableDoubleStackTestCase::peek;
            this.payloads.peekAtIndex = AbstractImmutableDoubleStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.detectIfNone = AbstractImmutableDoubleStackTestCase::detectIfNone;
            this.payloads.selectWithIndex = AbstractImmutableDoubleStackTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableDoubleStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableDoubleStackTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableDoubleStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractImmutableDoubleStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableDoubleStackTestCase::collectWithIndexWithTarget;
            this.payloads.chunk = AbstractImmutableDoubleStackTestCase::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = AbstractImmutableDoubleStackTestCase::push;
            this.payloads.pop = AbstractImmutableDoubleStackTestCase::pop;
            this.payloads.popWithCount = AbstractImmutableDoubleStackTestCase::popWithCount;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractImmutableDoubleStackTestCase::testToString;
            this.payloads.makeString = AbstractImmutableDoubleStackTestCase::makeString;
            this.payloads.appendString = AbstractImmutableDoubleStackTestCase::appendString;
            this.payloads.toList = AbstractImmutableDoubleStackTestCase::toList;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleStackTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toImmutable = AbstractImmutableDoubleStackTestCase::toImmutable;
        }
    }
}
