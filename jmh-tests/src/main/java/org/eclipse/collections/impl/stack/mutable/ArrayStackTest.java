/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable;

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.factory.Stacks;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ArrayStack}.
 */
public class ArrayStackTest extends MutableStackTestCase {

    @Override
    protected <T> MutableStack<T> newStackWith(T... elements) {
        return Stacks.mutable.of(elements);
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements) {
        return Stacks.mutable.ofReversed(elements);
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements) {
        return Stacks.mutable.ofAllReversed(elements);
    }

    @Override
    protected <T> MutableStack<T> newStack(Iterable<T> elements) {
        return Stacks.mutable.ofAll(elements);
    }

    @Test
    public void takeWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.takeWhile(null));
    }

    @Test
    public void dropWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.dropWhile(null));
    }

    @Test
    public void partitionWhile() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.partitionWhile(null));
    }

    @Test
    public void distinct() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, arrayStack::distinct);
    }

    @Test
    public void indexOf() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.indexOf(null));
    }

    @Test
    public void corresponds() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.corresponds(null, null));
    }

    @Test
    public void hasSameElements() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.hasSameElements(null));
    }

    @Test
    public void forEach_exception() {
        MutableStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.forEach(0, 1, null));
    }

    @Test
    public void forEachWithIndex_exception() {
        MutableStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.forEachWithIndex(0, 1, null));
    }

    @Test
    public void detectIndex() {
        ArrayStack<Object> arrayStack = new ArrayStack<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> arrayStack.detectIndex(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ArrayStackTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_count_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_neg_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_illegal_arguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt_illegal_arguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
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
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
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
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackWithOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackWithOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackIterableOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomIterableOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_count_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_neg_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_count_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_neg_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_count_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_neg_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasSameElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hasSameElements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_target_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_target_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_target_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_targetStack_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_targetStack_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> pop_targetStack_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> hasSameElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> forEach_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> forEachWithIndex_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayStackTest> detectIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ArrayStackTest::testNewCollection;
            this.payloads.equalsAndHashCode = ArrayStackTest::equalsAndHashCode;
            this.payloads.contains = ArrayStackTest::contains;
            this.payloads.containsBy = ArrayStackTest::containsBy;
            this.payloads.containsAllIterable = ArrayStackTest::containsAllIterable;
            this.payloads.containsAnyIterable = ArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ArrayStackTest::containsNoneIterable;
            this.payloads.containsAllArray = ArrayStackTest::containsAllArray;
            this.payloads.containsAnyCollection = ArrayStackTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ArrayStackTest::containsNoneCollection;
            this.payloads.containsAllCollection = ArrayStackTest::containsAllCollection;
            this.payloads.selectWith_target = ArrayStackTest::selectWith_target;
            this.payloads.rejectWith_target = ArrayStackTest::rejectWith_target;
            this.payloads.collectTarget = ArrayStackTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ArrayStackTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ArrayStackTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ArrayStackTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ArrayStackTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ArrayStackTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ArrayStackTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ArrayStackTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ArrayStackTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ArrayStackTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ArrayStackTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ArrayStackTest::flatCollectByte;
            this.payloads.flatCollectShort = ArrayStackTest::flatCollectShort;
            this.payloads.flatCollectInt = ArrayStackTest::flatCollectInt;
            this.payloads.flatCollectChar = ArrayStackTest::flatCollectChar;
            this.payloads.flatCollectLong = ArrayStackTest::flatCollectLong;
            this.payloads.flatCollectDouble = ArrayStackTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ArrayStackTest::flatCollectFloat;
            this.payloads.detectOptional = ArrayStackTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = ArrayStackTest::minOptional;
            this.payloads.maxOptional = ArrayStackTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ArrayStackTest::min_without_comparator;
            this.payloads.max_without_comparator = ArrayStackTest::max_without_comparator;
            this.payloads.min_null_safe = ArrayStackTest::min_null_safe;
            this.payloads.max_null_safe = ArrayStackTest::max_null_safe;
            this.payloads.minByOptional = ArrayStackTest::minByOptional;
            this.payloads.maxByOptional = ArrayStackTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ArrayStackTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ArrayStackTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = ArrayStackTest::collectWith_target;
            this.payloads.getAny = ArrayStackTest::getAny;
            this.payloads.getOnly = ArrayStackTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ArrayStackTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = ArrayStackTest::injectIntoInt;
            this.payloads.injectIntoLong = ArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ArrayStackTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ArrayStackTest::injectIntoFloat;
            this.payloads.sumFloat = ArrayStackTest::sumFloat;
            this.payloads.summarizeFloat = ArrayStackTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ArrayStackTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ArrayStackTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ArrayStackTest::sumDouble;
            this.payloads.summarizeDouble = ArrayStackTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ArrayStackTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ArrayStackTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ArrayStackTest::sumInteger;
            this.payloads.summarizeInt = ArrayStackTest::summarizeInt;
            this.payloads.sumLong = ArrayStackTest::sumLong;
            this.payloads.summarizeLong = ArrayStackTest::summarizeLong;
            this.payloads.sumByInt = ArrayStackTest::sumByInt;
            this.payloads.sumByFloat = ArrayStackTest::sumByFloat;
            this.payloads.sumByLong = ArrayStackTest::sumByLong;
            this.payloads.sumByDouble = ArrayStackTest::sumByDouble;
            this.payloads.toImmutableList = ArrayStackTest::toImmutableList;
            this.payloads.toCollection = ArrayStackTest::toCollection;
            this.payloads.toImmutableBag = ArrayStackTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ArrayStackTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ArrayStackTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ArrayStackTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ArrayStackTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ArrayStackTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ArrayStackTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ArrayStackTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ArrayStackTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ArrayStackTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ArrayStackTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ArrayStackTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ArrayStackTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ArrayStackTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ArrayStackTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = ArrayStackTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ArrayStackTest::toImmutableSet;
            this.payloads.toImmutableMap = ArrayStackTest::toImmutableMap;
            this.payloads.toMapTarget = ArrayStackTest::toMapTarget;
            this.payloads.toSortedMap_with_comparator = ArrayStackTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ArrayStackTest::toSortedMapBy;
            this.payloads.toBiMap = ArrayStackTest::toBiMap;
            this.payloads.toImmutableBiMap = ArrayStackTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ArrayStackTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ArrayStackTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ArrayStackTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ArrayStackTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ArrayStackTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ArrayStackTest::appendStringThrows;
            this.payloads.countBy = ArrayStackTest::countBy;
            this.payloads.countByWith = ArrayStackTest::countByWith;
            this.payloads.countByEach = ArrayStackTest::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = ArrayStackTest::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = ArrayStackTest::empty;
            this.payloads.notEmpty = ArrayStackTest::notEmpty;
            this.payloads.reduceOptional = ArrayStackTest::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = ArrayStackTest::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = ArrayStackTest::peek_illegal_arguments;
            this.payloads.peek = ArrayStackTest::peek;
            this.payloads.peekAt = ArrayStackTest::peekAt;
            this.payloads.peekAt_illegal_arguments = ArrayStackTest::peekAt_illegal_arguments;
            this.payloads.size = ArrayStackTest::size;
            this.payloads.getFirst = ArrayStackTest::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ArrayStackTest::containsAll;
            this.payloads.containsAllArguments = ArrayStackTest::containsAllArguments;
            this.payloads.collect = ArrayStackTest::collect;
            this.payloads.collectWithIndex = ArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ArrayStackTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = ArrayStackTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ArrayStackTest::collectBooleanWithTarget;
            this.payloads.collectByte = ArrayStackTest::collectByte;
            this.payloads.collectByteWithTarget = ArrayStackTest::collectByteWithTarget;
            this.payloads.collectChar = ArrayStackTest::collectChar;
            this.payloads.collectCharWithTarget = ArrayStackTest::collectCharWithTarget;
            this.payloads.collectDouble = ArrayStackTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ArrayStackTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ArrayStackTest::collectFloat;
            this.payloads.collectFloatWithTarget = ArrayStackTest::collectFloatWithTarget;
            this.payloads.collectInt = ArrayStackTest::collectInt;
            this.payloads.collectIntWithTarget = ArrayStackTest::collectIntWithTarget;
            this.payloads.collectLong = ArrayStackTest::collectLong;
            this.payloads.collectLongWithTarget = ArrayStackTest::collectLongWithTarget;
            this.payloads.collectShort = ArrayStackTest::collectShort;
            this.payloads.collectShortWithTarget = ArrayStackTest::collectShortWithTarget;
            this.payloads.collectIf = ArrayStackTest::collectIf;
            this.payloads.collectWith = ArrayStackTest::collectWith;
            this.payloads.collectWithTarget = ArrayStackTest::collectWithTarget;
            this.payloads.flatCollect = ArrayStackTest::flatCollect;
            this.payloads.select = ArrayStackTest::select;
            this.payloads.selectInstancesOf = ArrayStackTest::selectInstancesOf;
            this.payloads.selectWith = ArrayStackTest::selectWith;
            this.payloads.selectWithTarget = ArrayStackTest::selectWithTarget;
            this.payloads.reject = ArrayStackTest::reject;
            this.payloads.rejectWith = ArrayStackTest::rejectWith;
            this.payloads.rejectWithTarget = ArrayStackTest::rejectWithTarget;
            this.payloads.detect = ArrayStackTest::detect;
            this.payloads.detectWith = ArrayStackTest::detectWith;
            this.payloads.detectIfNone = ArrayStackTest::detectIfNone;
            this.payloads.detectWithIfNone = ArrayStackTest::detectWithIfNone;
            this.payloads.partition = ArrayStackTest::partition;
            this.payloads.partitionWith = ArrayStackTest::partitionWith;
            this.payloads.zip = ArrayStackTest::zip;
            this.payloads.zipWithIndex = ArrayStackTest::zipWithIndex;
            this.payloads.count = ArrayStackTest::count;
            this.payloads.countWith = ArrayStackTest::countWith;
            this.payloads.anySatisfy = ArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ArrayStackTest::noneSatisfy;
            this.payloads.anySatisfyWith = ArrayStackTest::anySatisfyWith;
            this.payloads.allSatisfyWith = ArrayStackTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ArrayStackTest::noneSatisfyWith;
            this.payloads.injectInto = ArrayStackTest::injectInto;
            this.payloads.sumOf = ArrayStackTest::sumOf;
            this.payloads.sumOfFloatConsistentRounding = ArrayStackTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = ArrayStackTest::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = ArrayStackTest::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = ArrayStackTest::sumByDoubleConsistentRounding;
            this.payloads.max = ArrayStackTest::max;
            this.payloads.maxBy = ArrayStackTest::maxBy;
            this.payloads.min = ArrayStackTest::min;
            this.payloads.minBy = ArrayStackTest::minBy;
            this.payloads.testToString = ArrayStackTest::testToString;
            this.payloads.makeString = ArrayStackTest::makeString;
            this.payloads.appendString = ArrayStackTest::appendString;
            this.payloads.groupBy = ArrayStackTest::groupBy;
            this.payloads.groupByEach = ArrayStackTest::groupByEach;
            this.payloads.groupByUniqueKey = ArrayStackTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ArrayStackTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = ArrayStackTest::chunk;
            this.payloads.chunk_single = ArrayStackTest::chunk_single;
            this.payloads.chunk_large_size = ArrayStackTest::chunk_large_size;
            this.payloads.tap = ArrayStackTest::tap;
            this.payloads.forEach = ArrayStackTest::forEach;
            this.payloads.forEachWith = ArrayStackTest::forEachWith;
            this.payloads.forEachWithIndex = ArrayStackTest::forEachWithIndex;
            this.payloads.toList = ArrayStackTest::toList;
            this.payloads.toStack = ArrayStackTest::toStack;
            this.payloads.toSortedList = ArrayStackTest::toSortedList;
            this.payloads.toSortedListBy = ArrayStackTest::toSortedListBy;
            this.payloads.toSet = ArrayStackTest::toSet;
            this.payloads.toSortedSet = ArrayStackTest::toSortedSet;
            this.payloads.toSortedSetBy = ArrayStackTest::toSortedSetBy;
            this.payloads.toBag = ArrayStackTest::toBag;
            this.payloads.toSortedBag = ArrayStackTest::toSortedBag;
            this.payloads.toSortedBagBy = ArrayStackTest::toSortedBagBy;
            this.payloads.toMap = ArrayStackTest::toMap;
            this.payloads.toSortedMap = ArrayStackTest::toSortedMap;
            this.payloads.asLazy = ArrayStackTest::asLazy;
            this.payloads.toArray = ArrayStackTest::toArray;
            this.payloads.iterator = ArrayStackTest::iterator;
            this.payloads.testEquals = ArrayStackTest::testEquals;
            this.payloads.testHashCode = ArrayStackTest::testHashCode;
            this.payloads.aggregateByMutating = ArrayStackTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ArrayStackTest::aggregateByNonMutating;
            this.payloads.testPushPopAndPeek = ArrayStackTest::testPushPopAndPeek;
            this.payloads.clear = ArrayStackTest::clear;
            this.payloads.testNewStackWithOrder = ArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = ArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = ArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = ArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.pop_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_target_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_target_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_target_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_target_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_targetStack_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_targetStack_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_targetStack_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayStackTest::pop_targetStack_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.asUnmodifiable = ArrayStackTest::asUnmodifiable;
            this.payloads.asSynchronized = ArrayStackTest::asSynchronized;
            this.payloads.takeWhile = ArrayStackTest::takeWhile;
            this.payloads.dropWhile = ArrayStackTest::dropWhile;
            this.payloads.partitionWhile = ArrayStackTest::partitionWhile;
            this.payloads.distinct = ArrayStackTest::distinct;
            this.payloads.indexOf = ArrayStackTest::indexOf;
            this.payloads.corresponds = ArrayStackTest::corresponds;
            this.payloads.hasSameElements = ArrayStackTest::hasSameElements;
            this.payloads.forEach_exception = ArrayStackTest::forEach_exception;
            this.payloads.forEachWithIndex_exception = ArrayStackTest::forEachWithIndex_exception;
            this.payloads.detectIndex = ArrayStackTest::detectIndex;
        }
    }
}
