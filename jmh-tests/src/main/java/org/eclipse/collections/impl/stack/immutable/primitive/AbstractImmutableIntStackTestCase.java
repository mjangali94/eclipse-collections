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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.stack.primitive.AbstractIntStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntStack}.
 * This file was automatically generated from template file abstractImmutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractImmutableIntStackTestCase extends AbstractIntStackTestCase {

    @Override
    protected abstract ImmutableIntStack classUnderTest();

    @Override
    protected ImmutableIntStack newWith(int... elements) {
        return IntStacks.immutable.of(elements);
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements) {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Integer> newObjectCollectionWith(Integer... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Override
    protected ImmutableIntStack newWithTopToBottom(int... elements) {
        return ImmutableIntArrayStack.newStackFromTopToBottom(elements);
    }

    protected ImmutableIntStack newWithIterableTopToBottom(IntIterable iterable) {
        return ImmutableIntArrayStack.newStackFromTopToBottom(iterable);
    }

    protected ImmutableIntStack newWithIterable(IntIterable iterable) {
        return ImmutableIntArrayStack.newStack(iterable);
    }

    @Test
    public void push() {
        ImmutableIntStack stack = this.classUnderTest();
        int size = stack.size();
        ImmutableIntStack modified = stack.push(5);
        Assert.assertEquals(5, modified.peek());
        Verify.assertSize(size + 1, modified);
        Verify.assertSize(size, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Test
    public void pop() {
        ImmutableIntStack stack = this.classUnderTest();
        int size = stack.size();
        ImmutableIntStack modified = stack.pop();
        Assert.assertEquals(size - 1, modified.peek());
        Verify.assertSize(size - 1, modified);
        Verify.assertSize(size, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Test
    public void popWithCount() {
        ImmutableIntStack stack = this.classUnderTest();
        ImmutableIntStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        int size = stack.size();
        ImmutableIntStack modified = stack.pop(2);
        Assert.assertEquals(size - 2, modified.peek());
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
        IntArrayList expected = IntArrayList.newListWith();
        this.classUnderTest().forEach(expected::add);
        Assert.assertEquals(expected, this.classUnderTest().toList());
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        IntStacks.immutable.of().median();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableIntStack expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableIntStackTestCase instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableIntStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntStackTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableIntStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableIntStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableIntStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableIntStackTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableIntStackTestCase::tap;
            this.payloads.contains = AbstractImmutableIntStackTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableIntStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableIntStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableIntStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableIntStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableIntStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableIntStackTestCase::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableIntStackTestCase::forEach;
            this.payloads.size = AbstractImmutableIntStackTestCase::size;
            this.payloads.count = AbstractImmutableIntStackTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableIntStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableIntStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableIntStackTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableIntStackTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableIntStackTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableIntStackTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableIntStackTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableIntStackTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableIntStackTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableIntStackTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableIntStackTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableIntStackTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableIntStackTestCase::rejectWithTarget;
            this.payloads.max = AbstractImmutableIntStackTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableIntStackTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableIntStackTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableIntStackTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableIntStackTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableIntStackTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableIntStackTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableIntStackTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableIntStackTestCase::median;
            this.payloads.medianIfEmpty = AbstractImmutableIntStackTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableIntStackTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableIntStackTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableIntStackTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableIntStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableIntStackTestCase::testHashCode;
            this.payloads.toSortedList = AbstractImmutableIntStackTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableIntStackTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableIntStackTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableIntStackTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableIntStackTestCase::toSet;
            this.payloads.toBag = AbstractImmutableIntStackTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableIntStackTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableIntStackTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableIntStackTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableIntStackTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableIntStackTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableIntStackTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableIntStackTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableIntStackTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableIntStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableIntStackTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableIntStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableIntStackTestCase::reduceIfEmpty;
            this.payloads.intIterator = AbstractImmutableIntStackTestCase::intIterator;
            this.payloads.peek = AbstractImmutableIntStackTestCase::peek;
            this.payloads.peekAtIndex = AbstractImmutableIntStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.detectIfNone = AbstractImmutableIntStackTestCase::detectIfNone;
            this.payloads.selectWithIndex = AbstractImmutableIntStackTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableIntStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableIntStackTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableIntStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractImmutableIntStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableIntStackTestCase::collectWithIndexWithTarget;
            this.payloads.chunk = AbstractImmutableIntStackTestCase::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = AbstractImmutableIntStackTestCase::push;
            this.payloads.pop = AbstractImmutableIntStackTestCase::pop;
            this.payloads.popWithCount = AbstractImmutableIntStackTestCase::popWithCount;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractImmutableIntStackTestCase::testToString;
            this.payloads.makeString = AbstractImmutableIntStackTestCase::makeString;
            this.payloads.appendString = AbstractImmutableIntStackTestCase::appendString;
            this.payloads.toList = AbstractImmutableIntStackTestCase::toList;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntStackTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toImmutable = AbstractImmutableIntStackTestCase::toImmutable;
        }
    }
}
