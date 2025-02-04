/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable;

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.stack.StackIterableTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnmodifiableStackTest extends StackIterableTestCase {

    private MutableStack<Integer> mutableStack;

    private MutableStack<Integer> unmodifiableStack;

    private MutableStack<String> unmodifiableStackString;

    @Before
    public void setUp() {
        this.mutableStack = ArrayStack.newStackFromTopToBottom(1, 2, 3);
        this.unmodifiableStack = new UnmodifiableStack<>(this.mutableStack);
        this.unmodifiableStackString = new UnmodifiableStack<>(ArrayStack.newStackFromTopToBottom("1", "2", "3"));
    }

    @Override
    protected <T> MutableStack<T> newStackWith(T... elements) {
        return ArrayStack.newStackWith(elements).asUnmodifiable();
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements) {
        return ArrayStack.newStackFromTopToBottom(elements).asUnmodifiable();
    }

    @Override
    protected <T> StackIterable<T> newStackFromTopToBottom(Iterable<T> elements) {
        return ArrayStack.newStackFromTopToBottom(elements).asUnmodifiable();
    }

    @Override
    protected <T> StackIterable<T> newStack(Iterable<T> elements) {
        return ArrayStack.newStack(elements).asUnmodifiable();
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackWith(1, 2, 3).iterator().remove());
    }

    @Test
    public void testNullStack() {
        Assert.assertThrows(IllegalArgumentException.class, () -> UnmodifiableStack.of(null));
    }

    @Test
    public void testPop() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2, 3).pop());
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2).pop(3));
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2, 3).pop(3));
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2, 3).pop(3, FastList.newList()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2, 3).pop(3, ArrayStack.newStack()));
    }

    @Test
    public void testPush() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newStackFromTopToBottom(1, 2, 3).push(4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testClear() {
        this.newStackFromTopToBottom(1, 2, 3).clear();
    }

    @Test
    public void testSelect() {
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(2, 3), this.unmodifiableStack.select(Predicates.greaterThan(1)));
        Verify.assertSize(3, this.unmodifiableStackString.select(ignored -> true, FastList.newList()));
    }

    @Test
    public void testSelectWith() {
        Verify.assertSize(1, this.unmodifiableStackString.selectWith(Object::equals, "2", FastList.newList()));
    }

    @Test
    public void testReject() {
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom("2", "3"), this.unmodifiableStackString.reject(StringPredicates.contains("1")));
        Assert.assertEquals(FastList.newListWith("2", "3"), this.unmodifiableStackString.reject(StringPredicates.contains("1"), FastList.newList()));
    }

    @Test
    public void testRejectWith() {
        Verify.assertSize(3, this.unmodifiableStackString.rejectWith(Object::equals, 3, FastList.newList()));
    }

    @Test
    public void testCollect() {
        Assert.assertEquals(this.mutableStack, this.unmodifiableStackString.collect(Integer::valueOf));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(this.mutableStack.size(), this.unmodifiableStack.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(this.mutableStack.isEmpty(), this.unmodifiableStack.isEmpty());
    }

    @Test
    public void testGetFirst() {
        Assert.assertEquals(this.mutableStack.getFirst(), this.unmodifiableStack.getFirst());
    }

    @Test
    public void testCount() {
        Assert.assertEquals(this.mutableStack.count(ignored1 -> true), this.unmodifiableStack.count(ignored -> true));
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedStack.class, this.unmodifiableStack.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableStack.class, this.unmodifiableStack.asUnmodifiable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableStackTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottom);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_count_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_neg_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_illegal_arguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt_illegal_arguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
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
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNullStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNullStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPush() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPush);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSelect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSelect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSelectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSelectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testReject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testReject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableStackTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testNullStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testPop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testPush;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testSelect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testSelectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testReject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testIsEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testGetFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> testCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableStackTest> asUnmodifiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnmodifiableStackTest::testNewCollection;
            this.payloads.equalsAndHashCode = UnmodifiableStackTest::equalsAndHashCode;
            this.payloads.contains = UnmodifiableStackTest::contains;
            this.payloads.containsBy = UnmodifiableStackTest::containsBy;
            this.payloads.containsAllIterable = UnmodifiableStackTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnmodifiableStackTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableStackTest::containsNoneIterable;
            this.payloads.containsAllArray = UnmodifiableStackTest::containsAllArray;
            this.payloads.containsAnyCollection = UnmodifiableStackTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableStackTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnmodifiableStackTest::containsAllCollection;
            this.payloads.selectWith_target = UnmodifiableStackTest::selectWith_target;
            this.payloads.rejectWith_target = UnmodifiableStackTest::rejectWith_target;
            this.payloads.collectTarget = UnmodifiableStackTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = UnmodifiableStackTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = UnmodifiableStackTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = UnmodifiableStackTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = UnmodifiableStackTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = UnmodifiableStackTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = UnmodifiableStackTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = UnmodifiableStackTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = UnmodifiableStackTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = UnmodifiableStackTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnmodifiableStackTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnmodifiableStackTest::flatCollectByte;
            this.payloads.flatCollectShort = UnmodifiableStackTest::flatCollectShort;
            this.payloads.flatCollectInt = UnmodifiableStackTest::flatCollectInt;
            this.payloads.flatCollectChar = UnmodifiableStackTest::flatCollectChar;
            this.payloads.flatCollectLong = UnmodifiableStackTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnmodifiableStackTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnmodifiableStackTest::flatCollectFloat;
            this.payloads.detectOptional = UnmodifiableStackTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = UnmodifiableStackTest::minOptional;
            this.payloads.maxOptional = UnmodifiableStackTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableStackTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableStackTest::max_without_comparator;
            this.payloads.min_null_safe = UnmodifiableStackTest::min_null_safe;
            this.payloads.max_null_safe = UnmodifiableStackTest::max_null_safe;
            this.payloads.minByOptional = UnmodifiableStackTest::minByOptional;
            this.payloads.maxByOptional = UnmodifiableStackTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = UnmodifiableStackTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = UnmodifiableStackTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = UnmodifiableStackTest::collectWith_target;
            this.payloads.getAny = UnmodifiableStackTest::getAny;
            this.payloads.getOnly = UnmodifiableStackTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableStackTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = UnmodifiableStackTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableStackTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableStackTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableStackTest::sumFloat;
            this.payloads.summarizeFloat = UnmodifiableStackTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnmodifiableStackTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnmodifiableStackTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnmodifiableStackTest::sumDouble;
            this.payloads.summarizeDouble = UnmodifiableStackTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnmodifiableStackTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnmodifiableStackTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnmodifiableStackTest::sumInteger;
            this.payloads.summarizeInt = UnmodifiableStackTest::summarizeInt;
            this.payloads.sumLong = UnmodifiableStackTest::sumLong;
            this.payloads.summarizeLong = UnmodifiableStackTest::summarizeLong;
            this.payloads.sumByInt = UnmodifiableStackTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableStackTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableStackTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableStackTest::sumByDouble;
            this.payloads.toImmutableList = UnmodifiableStackTest::toImmutableList;
            this.payloads.toCollection = UnmodifiableStackTest::toCollection;
            this.payloads.toImmutableBag = UnmodifiableStackTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableStackTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnmodifiableStackTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableStackTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnmodifiableStackTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = UnmodifiableStackTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = UnmodifiableStackTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableStackTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnmodifiableStackTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = UnmodifiableStackTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = UnmodifiableStackTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableStackTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnmodifiableStackTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableStackTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnmodifiableStackTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = UnmodifiableStackTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = UnmodifiableStackTest::toImmutableSet;
            this.payloads.toImmutableMap = UnmodifiableStackTest::toImmutableMap;
            this.payloads.toMapTarget = UnmodifiableStackTest::toMapTarget;
            this.payloads.toSortedMap_with_comparator = UnmodifiableStackTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableStackTest::toSortedMapBy;
            this.payloads.toBiMap = UnmodifiableStackTest::toBiMap;
            this.payloads.toImmutableBiMap = UnmodifiableStackTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = UnmodifiableStackTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableStackTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnmodifiableStackTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = UnmodifiableStackTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableStackTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnmodifiableStackTest::appendStringThrows;
            this.payloads.countBy = UnmodifiableStackTest::countBy;
            this.payloads.countByWith = UnmodifiableStackTest::countByWith;
            this.payloads.countByEach = UnmodifiableStackTest::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = UnmodifiableStackTest::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = UnmodifiableStackTest::empty;
            this.payloads.notEmpty = UnmodifiableStackTest::notEmpty;
            this.payloads.reduceOptional = UnmodifiableStackTest::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = UnmodifiableStackTest::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = UnmodifiableStackTest::peek_illegal_arguments;
            this.payloads.peek = UnmodifiableStackTest::peek;
            this.payloads.peekAt = UnmodifiableStackTest::peekAt;
            this.payloads.peekAt_illegal_arguments = UnmodifiableStackTest::peekAt_illegal_arguments;
            this.payloads.size = UnmodifiableStackTest::size;
            this.payloads.getFirst = UnmodifiableStackTest::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = UnmodifiableStackTest::containsAll;
            this.payloads.containsAllArguments = UnmodifiableStackTest::containsAllArguments;
            this.payloads.collect = UnmodifiableStackTest::collect;
            this.payloads.collectWithIndex = UnmodifiableStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableStackTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = UnmodifiableStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableStackTest::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = UnmodifiableStackTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableStackTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableStackTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableStackTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableStackTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableStackTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableStackTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableStackTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableStackTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableStackTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableStackTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableStackTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableStackTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableStackTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableStackTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableStackTest::collectShortWithTarget;
            this.payloads.collectIf = UnmodifiableStackTest::collectIf;
            this.payloads.collectWith = UnmodifiableStackTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableStackTest::collectWithTarget;
            this.payloads.flatCollect = UnmodifiableStackTest::flatCollect;
            this.payloads.select = UnmodifiableStackTest::select;
            this.payloads.selectInstancesOf = UnmodifiableStackTest::selectInstancesOf;
            this.payloads.selectWith = UnmodifiableStackTest::selectWith;
            this.payloads.selectWithTarget = UnmodifiableStackTest::selectWithTarget;
            this.payloads.reject = UnmodifiableStackTest::reject;
            this.payloads.rejectWith = UnmodifiableStackTest::rejectWith;
            this.payloads.rejectWithTarget = UnmodifiableStackTest::rejectWithTarget;
            this.payloads.detect = UnmodifiableStackTest::detect;
            this.payloads.detectWith = UnmodifiableStackTest::detectWith;
            this.payloads.detectIfNone = UnmodifiableStackTest::detectIfNone;
            this.payloads.detectWithIfNone = UnmodifiableStackTest::detectWithIfNone;
            this.payloads.partition = UnmodifiableStackTest::partition;
            this.payloads.partitionWith = UnmodifiableStackTest::partitionWith;
            this.payloads.zip = UnmodifiableStackTest::zip;
            this.payloads.zipWithIndex = UnmodifiableStackTest::zipWithIndex;
            this.payloads.count = UnmodifiableStackTest::count;
            this.payloads.countWith = UnmodifiableStackTest::countWith;
            this.payloads.anySatisfy = UnmodifiableStackTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableStackTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableStackTest::noneSatisfy;
            this.payloads.anySatisfyWith = UnmodifiableStackTest::anySatisfyWith;
            this.payloads.allSatisfyWith = UnmodifiableStackTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = UnmodifiableStackTest::noneSatisfyWith;
            this.payloads.injectInto = UnmodifiableStackTest::injectInto;
            this.payloads.sumOf = UnmodifiableStackTest::sumOf;
            this.payloads.sumOfFloatConsistentRounding = UnmodifiableStackTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = UnmodifiableStackTest::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = UnmodifiableStackTest::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = UnmodifiableStackTest::sumByDoubleConsistentRounding;
            this.payloads.max = UnmodifiableStackTest::max;
            this.payloads.maxBy = UnmodifiableStackTest::maxBy;
            this.payloads.min = UnmodifiableStackTest::min;
            this.payloads.minBy = UnmodifiableStackTest::minBy;
            this.payloads.testToString = UnmodifiableStackTest::testToString;
            this.payloads.makeString = UnmodifiableStackTest::makeString;
            this.payloads.appendString = UnmodifiableStackTest::appendString;
            this.payloads.groupBy = UnmodifiableStackTest::groupBy;
            this.payloads.groupByEach = UnmodifiableStackTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableStackTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableStackTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = UnmodifiableStackTest::chunk;
            this.payloads.chunk_single = UnmodifiableStackTest::chunk_single;
            this.payloads.chunk_large_size = UnmodifiableStackTest::chunk_large_size;
            this.payloads.tap = UnmodifiableStackTest::tap;
            this.payloads.forEach = UnmodifiableStackTest::forEach;
            this.payloads.forEachWith = UnmodifiableStackTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableStackTest::forEachWithIndex;
            this.payloads.toList = UnmodifiableStackTest::toList;
            this.payloads.toStack = UnmodifiableStackTest::toStack;
            this.payloads.toSortedList = UnmodifiableStackTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableStackTest::toSortedListBy;
            this.payloads.toSet = UnmodifiableStackTest::toSet;
            this.payloads.toSortedSet = UnmodifiableStackTest::toSortedSet;
            this.payloads.toSortedSetBy = UnmodifiableStackTest::toSortedSetBy;
            this.payloads.toBag = UnmodifiableStackTest::toBag;
            this.payloads.toSortedBag = UnmodifiableStackTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableStackTest::toSortedBagBy;
            this.payloads.toMap = UnmodifiableStackTest::toMap;
            this.payloads.toSortedMap = UnmodifiableStackTest::toSortedMap;
            this.payloads.asLazy = UnmodifiableStackTest::asLazy;
            this.payloads.toArray = UnmodifiableStackTest::toArray;
            this.payloads.testEquals = UnmodifiableStackTest::testEquals;
            this.payloads.testHashCode = UnmodifiableStackTest::testHashCode;
            this.payloads.aggregateByMutating = UnmodifiableStackTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableStackTest::aggregateByNonMutating;
            this.payloads.iterator = UnmodifiableStackTest::iterator;
            this.payloads.testNullStack = UnmodifiableStackTest::testNullStack;
            this.payloads.testPop = UnmodifiableStackTest::testPop;
            this.payloads.testPush = UnmodifiableStackTest::testPush;
            this.payloads.testClear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableStackTest::testClear, java.lang.UnsupportedOperationException.class);
            this.payloads.testSelect = UnmodifiableStackTest::testSelect;
            this.payloads.testSelectWith = UnmodifiableStackTest::testSelectWith;
            this.payloads.testReject = UnmodifiableStackTest::testReject;
            this.payloads.testRejectWith = UnmodifiableStackTest::testRejectWith;
            this.payloads.testCollect = UnmodifiableStackTest::testCollect;
            this.payloads.testSize = UnmodifiableStackTest::testSize;
            this.payloads.testIsEmpty = UnmodifiableStackTest::testIsEmpty;
            this.payloads.testGetFirst = UnmodifiableStackTest::testGetFirst;
            this.payloads.testCount = UnmodifiableStackTest::testCount;
            this.payloads.asSynchronized = UnmodifiableStackTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableStackTest::asUnmodifiable;
        }
    }
}
