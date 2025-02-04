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
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedStack}.
 */
public class SynchronizedStackTest extends MutableStackTestCase {

    @Override
    protected <T> MutableStack<T> newStackWith(T... elements) {
        return new SynchronizedStack<>(ArrayStack.newStackWith(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements) {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements) {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStack(Iterable<T> elements) {
        return new SynchronizedStack<>(ArrayStack.newStack(elements));
    }

    @Test
    public void testNullStack() {
        Assert.assertThrows(IllegalArgumentException.class, () -> SynchronizedStack.of(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedStackTest instance;

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
        public void benchmark_testNullStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNullStack);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_target_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_target_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_target_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_targetStack_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_targetStack_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> pop_targetStack_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedStackTest> testNullStack;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedStackTest::testNewCollection;
            this.payloads.equalsAndHashCode = SynchronizedStackTest::equalsAndHashCode;
            this.payloads.contains = SynchronizedStackTest::contains;
            this.payloads.containsBy = SynchronizedStackTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedStackTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedStackTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedStackTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedStackTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedStackTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedStackTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedStackTest::containsAllCollection;
            this.payloads.selectWith_target = SynchronizedStackTest::selectWith_target;
            this.payloads.rejectWith_target = SynchronizedStackTest::rejectWith_target;
            this.payloads.collectTarget = SynchronizedStackTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedStackTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedStackTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedStackTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedStackTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedStackTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedStackTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedStackTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedStackTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = SynchronizedStackTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedStackTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedStackTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedStackTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedStackTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedStackTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedStackTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedStackTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedStackTest::flatCollectFloat;
            this.payloads.detectOptional = SynchronizedStackTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = SynchronizedStackTest::minOptional;
            this.payloads.maxOptional = SynchronizedStackTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedStackTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedStackTest::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedStackTest::min_null_safe;
            this.payloads.max_null_safe = SynchronizedStackTest::max_null_safe;
            this.payloads.minByOptional = SynchronizedStackTest::minByOptional;
            this.payloads.maxByOptional = SynchronizedStackTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = SynchronizedStackTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = SynchronizedStackTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = SynchronizedStackTest::collectWith_target;
            this.payloads.getAny = SynchronizedStackTest::getAny;
            this.payloads.getOnly = SynchronizedStackTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedStackTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = SynchronizedStackTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedStackTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedStackTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedStackTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedStackTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedStackTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedStackTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedStackTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedStackTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedStackTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedStackTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedStackTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedStackTest::summarizeInt;
            this.payloads.sumLong = SynchronizedStackTest::sumLong;
            this.payloads.summarizeLong = SynchronizedStackTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedStackTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedStackTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedStackTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedStackTest::sumByDouble;
            this.payloads.toImmutableList = SynchronizedStackTest::toImmutableList;
            this.payloads.toCollection = SynchronizedStackTest::toCollection;
            this.payloads.toImmutableBag = SynchronizedStackTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedStackTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedStackTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedStackTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedStackTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = SynchronizedStackTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedStackTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedStackTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedStackTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = SynchronizedStackTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = SynchronizedStackTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedStackTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedStackTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedStackTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedStackTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = SynchronizedStackTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = SynchronizedStackTest::toImmutableSet;
            this.payloads.toImmutableMap = SynchronizedStackTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedStackTest::toMapTarget;
            this.payloads.toSortedMap_with_comparator = SynchronizedStackTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedStackTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedStackTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedStackTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedStackTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedStackTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedStackTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedStackTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedStackTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedStackTest::appendStringThrows;
            this.payloads.countBy = SynchronizedStackTest::countBy;
            this.payloads.countByWith = SynchronizedStackTest::countByWith;
            this.payloads.countByEach = SynchronizedStackTest::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = SynchronizedStackTest::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = SynchronizedStackTest::empty;
            this.payloads.notEmpty = SynchronizedStackTest::notEmpty;
            this.payloads.reduceOptional = SynchronizedStackTest::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = SynchronizedStackTest::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = SynchronizedStackTest::peek_illegal_arguments;
            this.payloads.peek = SynchronizedStackTest::peek;
            this.payloads.peekAt = SynchronizedStackTest::peekAt;
            this.payloads.peekAt_illegal_arguments = SynchronizedStackTest::peekAt_illegal_arguments;
            this.payloads.size = SynchronizedStackTest::size;
            this.payloads.getFirst = SynchronizedStackTest::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = SynchronizedStackTest::containsAll;
            this.payloads.containsAllArguments = SynchronizedStackTest::containsAllArguments;
            this.payloads.collect = SynchronizedStackTest::collect;
            this.payloads.collectWithIndex = SynchronizedStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedStackTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = SynchronizedStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = SynchronizedStackTest::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = SynchronizedStackTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedStackTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedStackTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedStackTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedStackTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedStackTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedStackTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedStackTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedStackTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedStackTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedStackTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedStackTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedStackTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedStackTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedStackTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedStackTest::collectShortWithTarget;
            this.payloads.collectIf = SynchronizedStackTest::collectIf;
            this.payloads.collectWith = SynchronizedStackTest::collectWith;
            this.payloads.collectWithTarget = SynchronizedStackTest::collectWithTarget;
            this.payloads.flatCollect = SynchronizedStackTest::flatCollect;
            this.payloads.select = SynchronizedStackTest::select;
            this.payloads.selectInstancesOf = SynchronizedStackTest::selectInstancesOf;
            this.payloads.selectWith = SynchronizedStackTest::selectWith;
            this.payloads.selectWithTarget = SynchronizedStackTest::selectWithTarget;
            this.payloads.reject = SynchronizedStackTest::reject;
            this.payloads.rejectWith = SynchronizedStackTest::rejectWith;
            this.payloads.rejectWithTarget = SynchronizedStackTest::rejectWithTarget;
            this.payloads.detect = SynchronizedStackTest::detect;
            this.payloads.detectWith = SynchronizedStackTest::detectWith;
            this.payloads.detectIfNone = SynchronizedStackTest::detectIfNone;
            this.payloads.detectWithIfNone = SynchronizedStackTest::detectWithIfNone;
            this.payloads.partition = SynchronizedStackTest::partition;
            this.payloads.partitionWith = SynchronizedStackTest::partitionWith;
            this.payloads.zip = SynchronizedStackTest::zip;
            this.payloads.zipWithIndex = SynchronizedStackTest::zipWithIndex;
            this.payloads.count = SynchronizedStackTest::count;
            this.payloads.countWith = SynchronizedStackTest::countWith;
            this.payloads.anySatisfy = SynchronizedStackTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedStackTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedStackTest::noneSatisfy;
            this.payloads.anySatisfyWith = SynchronizedStackTest::anySatisfyWith;
            this.payloads.allSatisfyWith = SynchronizedStackTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = SynchronizedStackTest::noneSatisfyWith;
            this.payloads.injectInto = SynchronizedStackTest::injectInto;
            this.payloads.sumOf = SynchronizedStackTest::sumOf;
            this.payloads.sumOfFloatConsistentRounding = SynchronizedStackTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = SynchronizedStackTest::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = SynchronizedStackTest::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedStackTest::sumByDoubleConsistentRounding;
            this.payloads.max = SynchronizedStackTest::max;
            this.payloads.maxBy = SynchronizedStackTest::maxBy;
            this.payloads.min = SynchronizedStackTest::min;
            this.payloads.minBy = SynchronizedStackTest::minBy;
            this.payloads.testToString = SynchronizedStackTest::testToString;
            this.payloads.makeString = SynchronizedStackTest::makeString;
            this.payloads.appendString = SynchronizedStackTest::appendString;
            this.payloads.groupBy = SynchronizedStackTest::groupBy;
            this.payloads.groupByEach = SynchronizedStackTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedStackTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedStackTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = SynchronizedStackTest::chunk;
            this.payloads.chunk_single = SynchronizedStackTest::chunk_single;
            this.payloads.chunk_large_size = SynchronizedStackTest::chunk_large_size;
            this.payloads.tap = SynchronizedStackTest::tap;
            this.payloads.forEach = SynchronizedStackTest::forEach;
            this.payloads.forEachWith = SynchronizedStackTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedStackTest::forEachWithIndex;
            this.payloads.toList = SynchronizedStackTest::toList;
            this.payloads.toStack = SynchronizedStackTest::toStack;
            this.payloads.toSortedList = SynchronizedStackTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedStackTest::toSortedListBy;
            this.payloads.toSet = SynchronizedStackTest::toSet;
            this.payloads.toSortedSet = SynchronizedStackTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedStackTest::toSortedSetBy;
            this.payloads.toBag = SynchronizedStackTest::toBag;
            this.payloads.toSortedBag = SynchronizedStackTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedStackTest::toSortedBagBy;
            this.payloads.toMap = SynchronizedStackTest::toMap;
            this.payloads.toSortedMap = SynchronizedStackTest::toSortedMap;
            this.payloads.asLazy = SynchronizedStackTest::asLazy;
            this.payloads.toArray = SynchronizedStackTest::toArray;
            this.payloads.iterator = SynchronizedStackTest::iterator;
            this.payloads.testEquals = SynchronizedStackTest::testEquals;
            this.payloads.testHashCode = SynchronizedStackTest::testHashCode;
            this.payloads.aggregateByMutating = SynchronizedStackTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedStackTest::aggregateByNonMutating;
            this.payloads.testPushPopAndPeek = SynchronizedStackTest::testPushPopAndPeek;
            this.payloads.clear = SynchronizedStackTest::clear;
            this.payloads.testNewStackWithOrder = SynchronizedStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = SynchronizedStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = SynchronizedStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = SynchronizedStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.pop_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_target_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_target_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_target_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_target_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_targetStack_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_targetStack_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_targetStack_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedStackTest::pop_targetStack_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.asUnmodifiable = SynchronizedStackTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedStackTest::asSynchronized;
            this.payloads.testNullStack = SynchronizedStackTest::testNullStack;
        }
    }
}
