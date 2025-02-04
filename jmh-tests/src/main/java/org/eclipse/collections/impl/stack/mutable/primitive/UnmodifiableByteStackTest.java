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

import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.stack.primitive.AbstractByteStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableByteStackTest extends AbstractByteStackTestCase {

    @Override
    protected MutableByteStack classUnderTest() {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected MutableByteStack newWith(byte... elements) {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newMutableCollectionWith(byte... elements) {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newWithTopToBottom(byte... elements) {
        return new UnmodifiableByteStack(ByteArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push() {
        this.classUnderTest().push((byte) 5);
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
        MutableByteStack stack1 = new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableByteStack stack1 = new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(SynchronizedByteStack.class, stack1.asSynchronized());
    }

    @Test
    public void byteIterator_with_remove() {
        UnmodifiableByteStack byteIterable = (UnmodifiableByteStack) this.classUnderTest();
        MutableByteIterator iterator = (MutableByteIterator) byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void byteIterator_throws_for_remove_before_next() {
        UnmodifiableByteStack byteIterable = (UnmodifiableByteStack) this.classUnderTest();
        MutableByteIterator iterator = (MutableByteIterator) byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableByteStackTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableByteStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteStackTest> byteIterator_throws_for_remove_before_next;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableByteStackTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableByteStackTest::newCollection;
            this.payloads.isEmpty = UnmodifiableByteStackTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableByteStackTest::notEmpty;
            this.payloads.tap = UnmodifiableByteStackTest::tap;
            this.payloads.contains = UnmodifiableByteStackTest::contains;
            this.payloads.containsAllArray = UnmodifiableByteStackTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableByteStackTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableByteStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableByteStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableByteStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableByteStackTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableByteStackTest::forEach;
            this.payloads.size = UnmodifiableByteStackTest::size;
            this.payloads.count = UnmodifiableByteStackTest::count;
            this.payloads.anySatisfy = UnmodifiableByteStackTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableByteStackTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableByteStackTest::noneSatisfy;
            this.payloads.collect = UnmodifiableByteStackTest::collect;
            this.payloads.collectWithTarget = UnmodifiableByteStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableByteStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableByteStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableByteStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableByteStackTest::collectPrimitivesToSets;
            this.payloads.select = UnmodifiableByteStackTest::select;
            this.payloads.selectWithTarget = UnmodifiableByteStackTest::selectWithTarget;
            this.payloads.reject = UnmodifiableByteStackTest::reject;
            this.payloads.rejectWithTarget = UnmodifiableByteStackTest::rejectWithTarget;
            this.payloads.max = UnmodifiableByteStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableByteStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableByteStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableByteStackTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableByteStackTest::sum;
            this.payloads.summaryStatistics = UnmodifiableByteStackTest::summaryStatistics;
            this.payloads.average = UnmodifiableByteStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableByteStackTest::averageIfEmpty;
            this.payloads.median = UnmodifiableByteStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableByteStackTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableByteStackTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableByteStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableByteStackTest::toSortedArray;
            this.payloads.testEquals = UnmodifiableByteStackTest::testEquals;
            this.payloads.testHashCode = UnmodifiableByteStackTest::testHashCode;
            this.payloads.toSortedList = UnmodifiableByteStackTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableByteStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableByteStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableByteStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableByteStackTest::toSet;
            this.payloads.toBag = UnmodifiableByteStackTest::toBag;
            this.payloads.asLazy = UnmodifiableByteStackTest::asLazy;
            this.payloads.injectInto = UnmodifiableByteStackTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableByteStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableByteStackTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableByteStackTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableByteStackTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableByteStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableByteStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableByteStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableByteStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableByteStackTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableByteStackTest::reduceIfEmpty;
            this.payloads.byteIterator = UnmodifiableByteStackTest::byteIterator;
            this.payloads.peek = UnmodifiableByteStackTest::peek;
            this.payloads.peekAtIndex = UnmodifiableByteStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = UnmodifiableByteStackTest::testToString;
            this.payloads.toList = UnmodifiableByteStackTest::toList;
            this.payloads.makeString = UnmodifiableByteStackTest::makeString;
            this.payloads.detectIfNone = UnmodifiableByteStackTest::detectIfNone;
            this.payloads.appendString = UnmodifiableByteStackTest::appendString;
            this.payloads.toImmutable = UnmodifiableByteStackTest::toImmutable;
            this.payloads.selectWithIndex = UnmodifiableByteStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = UnmodifiableByteStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = UnmodifiableByteStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableByteStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = UnmodifiableByteStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableByteStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = UnmodifiableByteStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::push, java.lang.UnsupportedOperationException.class);
            this.payloads.pop = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::pop, java.lang.UnsupportedOperationException.class);
            this.payloads.popWithCount = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::popWithCount, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteStackTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableByteStackTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableByteStackTest::asSynchronized;
            this.payloads.byteIterator_with_remove = UnmodifiableByteStackTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = UnmodifiableByteStackTest::byteIterator_throws_for_remove_before_next;
        }
    }
}
