/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable;

import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.impl.stack.StackIterableTestCase;
import org.junit.Assert;

public abstract class ImmutableStackTestCase extends StackIterableTestCase {

    @Override
    protected abstract <T> ImmutableStack<T> newStackWith(T... elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStackFromTopToBottom(T... elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStackFromTopToBottom(Iterable<T> elements);

    @Override
    protected abstract <T> ImmutableStack<T> newStack(Iterable<T> elements);

    public void sumByInt() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectLongMap<Integer> result = values.sumByInt(i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    public void sumByFloat() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectDoubleMap<Integer> result = values.sumByFloat(f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    public void sumByDouble() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectDoubleMap<Integer> result = values.sumByDouble(d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

    public void sumByLong() {
        ImmutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableObjectLongMap<Integer> result = values.sumByLong(l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableStackTestCase instance;

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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableStackTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableStackTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = ImmutableStackTestCase::equalsAndHashCode;
            this.payloads.contains = ImmutableStackTestCase::contains;
            this.payloads.containsBy = ImmutableStackTestCase::containsBy;
            this.payloads.containsAllIterable = ImmutableStackTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = ImmutableStackTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableStackTestCase::containsNoneIterable;
            this.payloads.containsAllArray = ImmutableStackTestCase::containsAllArray;
            this.payloads.containsAnyCollection = ImmutableStackTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableStackTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableStackTestCase::containsAllCollection;
            this.payloads.selectWith_target = ImmutableStackTestCase::selectWith_target;
            this.payloads.rejectWith_target = ImmutableStackTestCase::rejectWith_target;
            this.payloads.collectTarget = ImmutableStackTestCase::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableStackTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableStackTestCase::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableStackTestCase::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableStackTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableStackTestCase::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableStackTestCase::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableStackTestCase::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableStackTestCase::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableStackTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableStackTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableStackTestCase::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableStackTestCase::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableStackTestCase::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableStackTestCase::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableStackTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableStackTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableStackTestCase::flatCollectFloat;
            this.payloads.detectOptional = ImmutableStackTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = ImmutableStackTestCase::minOptional;
            this.payloads.maxOptional = ImmutableStackTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableStackTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableStackTestCase::max_without_comparator;
            this.payloads.min_null_safe = ImmutableStackTestCase::min_null_safe;
            this.payloads.max_null_safe = ImmutableStackTestCase::max_null_safe;
            this.payloads.minByOptional = ImmutableStackTestCase::minByOptional;
            this.payloads.maxByOptional = ImmutableStackTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableStackTestCase::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableStackTestCase::detectWithIfNoneBlock;
            this.payloads.collectWith_target = ImmutableStackTestCase::collectWith_target;
            this.payloads.getAny = ImmutableStackTestCase::getAny;
            this.payloads.getOnly = ImmutableStackTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableStackTestCase::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = ImmutableStackTestCase::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableStackTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableStackTestCase::injectIntoFloat;
            this.payloads.sumFloat = ImmutableStackTestCase::sumFloat;
            this.payloads.summarizeFloat = ImmutableStackTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableStackTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableStackTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ImmutableStackTestCase::sumDouble;
            this.payloads.summarizeDouble = ImmutableStackTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableStackTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableStackTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ImmutableStackTestCase::sumInteger;
            this.payloads.summarizeInt = ImmutableStackTestCase::summarizeInt;
            this.payloads.sumLong = ImmutableStackTestCase::sumLong;
            this.payloads.summarizeLong = ImmutableStackTestCase::summarizeLong;
            this.payloads.sumByInt = ImmutableStackTestCase::sumByInt;
            this.payloads.sumByFloat = ImmutableStackTestCase::sumByFloat;
            this.payloads.sumByLong = ImmutableStackTestCase::sumByLong;
            this.payloads.sumByDouble = ImmutableStackTestCase::sumByDouble;
            this.payloads.toImmutableList = ImmutableStackTestCase::toImmutableList;
            this.payloads.toCollection = ImmutableStackTestCase::toCollection;
            this.payloads.toImmutableBag = ImmutableStackTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableStackTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableStackTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableStackTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableStackTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableStackTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableStackTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableStackTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableStackTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableStackTestCase::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableStackTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableStackTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableStackTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableStackTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableStackTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = ImmutableStackTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableStackTestCase::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableStackTestCase::toImmutableMap;
            this.payloads.toMapTarget = ImmutableStackTestCase::toMapTarget;
            this.payloads.toSortedMap_with_comparator = ImmutableStackTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableStackTestCase::toSortedMapBy;
            this.payloads.toBiMap = ImmutableStackTestCase::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableStackTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableStackTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableStackTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableStackTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableStackTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableStackTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableStackTestCase::appendStringThrows;
            this.payloads.countBy = ImmutableStackTestCase::countBy;
            this.payloads.countByWith = ImmutableStackTestCase::countByWith;
            this.payloads.countByEach = ImmutableStackTestCase::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = ImmutableStackTestCase::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = ImmutableStackTestCase::empty;
            this.payloads.notEmpty = ImmutableStackTestCase::notEmpty;
            this.payloads.reduceOptional = ImmutableStackTestCase::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = ImmutableStackTestCase::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = ImmutableStackTestCase::peek_illegal_arguments;
            this.payloads.peek = ImmutableStackTestCase::peek;
            this.payloads.peekAt = ImmutableStackTestCase::peekAt;
            this.payloads.peekAt_illegal_arguments = ImmutableStackTestCase::peekAt_illegal_arguments;
            this.payloads.size = ImmutableStackTestCase::size;
            this.payloads.getFirst = ImmutableStackTestCase::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ImmutableStackTestCase::containsAll;
            this.payloads.containsAllArguments = ImmutableStackTestCase::containsAllArguments;
            this.payloads.collect = ImmutableStackTestCase::collect;
            this.payloads.collectWithIndex = ImmutableStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableStackTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = ImmutableStackTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableStackTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableStackTestCase::collectByte;
            this.payloads.collectByteWithTarget = ImmutableStackTestCase::collectByteWithTarget;
            this.payloads.collectChar = ImmutableStackTestCase::collectChar;
            this.payloads.collectCharWithTarget = ImmutableStackTestCase::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableStackTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableStackTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableStackTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableStackTestCase::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableStackTestCase::collectInt;
            this.payloads.collectIntWithTarget = ImmutableStackTestCase::collectIntWithTarget;
            this.payloads.collectLong = ImmutableStackTestCase::collectLong;
            this.payloads.collectLongWithTarget = ImmutableStackTestCase::collectLongWithTarget;
            this.payloads.collectShort = ImmutableStackTestCase::collectShort;
            this.payloads.collectShortWithTarget = ImmutableStackTestCase::collectShortWithTarget;
            this.payloads.collectIf = ImmutableStackTestCase::collectIf;
            this.payloads.collectWith = ImmutableStackTestCase::collectWith;
            this.payloads.collectWithTarget = ImmutableStackTestCase::collectWithTarget;
            this.payloads.flatCollect = ImmutableStackTestCase::flatCollect;
            this.payloads.select = ImmutableStackTestCase::select;
            this.payloads.selectInstancesOf = ImmutableStackTestCase::selectInstancesOf;
            this.payloads.selectWith = ImmutableStackTestCase::selectWith;
            this.payloads.selectWithTarget = ImmutableStackTestCase::selectWithTarget;
            this.payloads.reject = ImmutableStackTestCase::reject;
            this.payloads.rejectWith = ImmutableStackTestCase::rejectWith;
            this.payloads.rejectWithTarget = ImmutableStackTestCase::rejectWithTarget;
            this.payloads.detect = ImmutableStackTestCase::detect;
            this.payloads.detectWith = ImmutableStackTestCase::detectWith;
            this.payloads.detectIfNone = ImmutableStackTestCase::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableStackTestCase::detectWithIfNone;
            this.payloads.partition = ImmutableStackTestCase::partition;
            this.payloads.partitionWith = ImmutableStackTestCase::partitionWith;
            this.payloads.zip = ImmutableStackTestCase::zip;
            this.payloads.zipWithIndex = ImmutableStackTestCase::zipWithIndex;
            this.payloads.count = ImmutableStackTestCase::count;
            this.payloads.countWith = ImmutableStackTestCase::countWith;
            this.payloads.anySatisfy = ImmutableStackTestCase::anySatisfy;
            this.payloads.allSatisfy = ImmutableStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = ImmutableStackTestCase::noneSatisfy;
            this.payloads.anySatisfyWith = ImmutableStackTestCase::anySatisfyWith;
            this.payloads.allSatisfyWith = ImmutableStackTestCase::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableStackTestCase::noneSatisfyWith;
            this.payloads.injectInto = ImmutableStackTestCase::injectInto;
            this.payloads.sumOf = ImmutableStackTestCase::sumOf;
            this.payloads.sumOfFloatConsistentRounding = ImmutableStackTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableStackTestCase::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = ImmutableStackTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = ImmutableStackTestCase::sumByDoubleConsistentRounding;
            this.payloads.max = ImmutableStackTestCase::max;
            this.payloads.maxBy = ImmutableStackTestCase::maxBy;
            this.payloads.min = ImmutableStackTestCase::min;
            this.payloads.minBy = ImmutableStackTestCase::minBy;
            this.payloads.testToString = ImmutableStackTestCase::testToString;
            this.payloads.makeString = ImmutableStackTestCase::makeString;
            this.payloads.appendString = ImmutableStackTestCase::appendString;
            this.payloads.groupBy = ImmutableStackTestCase::groupBy;
            this.payloads.groupByEach = ImmutableStackTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableStackTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableStackTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableStackTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableStackTestCase::chunk;
            this.payloads.chunk_single = ImmutableStackTestCase::chunk_single;
            this.payloads.chunk_large_size = ImmutableStackTestCase::chunk_large_size;
            this.payloads.tap = ImmutableStackTestCase::tap;
            this.payloads.forEach = ImmutableStackTestCase::forEach;
            this.payloads.forEachWith = ImmutableStackTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableStackTestCase::forEachWithIndex;
            this.payloads.toList = ImmutableStackTestCase::toList;
            this.payloads.toStack = ImmutableStackTestCase::toStack;
            this.payloads.toSortedList = ImmutableStackTestCase::toSortedList;
            this.payloads.toSortedListBy = ImmutableStackTestCase::toSortedListBy;
            this.payloads.toSet = ImmutableStackTestCase::toSet;
            this.payloads.toSortedSet = ImmutableStackTestCase::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableStackTestCase::toSortedSetBy;
            this.payloads.toBag = ImmutableStackTestCase::toBag;
            this.payloads.toSortedBag = ImmutableStackTestCase::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableStackTestCase::toSortedBagBy;
            this.payloads.toMap = ImmutableStackTestCase::toMap;
            this.payloads.toSortedMap = ImmutableStackTestCase::toSortedMap;
            this.payloads.asLazy = ImmutableStackTestCase::asLazy;
            this.payloads.toArray = ImmutableStackTestCase::toArray;
            this.payloads.iterator = ImmutableStackTestCase::iterator;
            this.payloads.testEquals = ImmutableStackTestCase::testEquals;
            this.payloads.testHashCode = ImmutableStackTestCase::testHashCode;
            this.payloads.aggregateByMutating = ImmutableStackTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableStackTestCase::aggregateByNonMutating;
        }
    }
}
