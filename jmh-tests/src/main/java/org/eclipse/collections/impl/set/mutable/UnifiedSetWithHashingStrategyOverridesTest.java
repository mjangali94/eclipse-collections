/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;

public class UnifiedSetWithHashingStrategyOverridesTest extends UnifiedSetWithHashingStrategyTest {

    public static class UnifiedSetWithHashingStrategyOverrides<T> extends UnifiedSetWithHashingStrategy<T> {

        public UnifiedSetWithHashingStrategyOverrides(HashingStrategy<? super T> hashingStrategy, int initialCapacity) {
            super(hashingStrategy, initialCapacity);
        }

        @Override
        protected int index(T key) {
            int h = this.hashingStrategy.computeHashCode(key);
            return h & this.table.length - 1;
        }

        @Override
        public UnifiedSetWithHashingStrategyOverrides<T> newEmpty() {
            return new UnifiedSetWithHashingStrategyOverrides<>(this.hashingStrategy, 0);
        }

        @Override
        public UnifiedSetWithHashingStrategyOverrides<T> newEmpty(int size) {
            return new UnifiedSetWithHashingStrategyOverrides<>(this.hashingStrategy, size);
        }
    }

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        HashingStrategy<T> nshs = HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy());
        UnifiedSetWithHashingStrategyOverrides<T> set = new UnifiedSetWithHashingStrategyOverrides<>(nshs, littleElements.length);
        return set.with(littleElements);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetWithHashingStrategyOverridesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
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
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
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
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
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
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
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
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
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
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
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
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
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
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
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
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
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
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
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
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_unifiedSetKeySetToArrayDest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetKeySetToArrayDest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_increment_past_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_increment_past_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_without_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_without_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
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
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOnObjectWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOnObjectWithCastInEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyRejectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyRejectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazySelectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazySelectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOrReplace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOrReplace);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addALLIterable_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addALLIterable_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_behavior() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_behavior);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructor_from_UnifiedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructor_from_UnifiedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_copyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.copyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_null_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_null_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setKeyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setKeyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withSameIfNotModified() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withSameIfNotModified);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetWithHashingStrategyOverridesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> addOnObjectWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> newSet_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> lazyCollectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> lazyRejectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> lazySelectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> newSetWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> add_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> addOrReplace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> addALLIterable_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> get_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> put_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> remove_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeFromPool;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> removeFromPool_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> null_behavior;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> equals_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> constructor_from_UnifiedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> copyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> newSet_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> newSet_null_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> setKeyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> withSameIfNotModified;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyOverridesTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnifiedSetWithHashingStrategyOverridesTest::testNewCollection;
            this.payloads.contains = UnifiedSetWithHashingStrategyOverridesTest::contains;
            this.payloads.containsBy = UnifiedSetWithHashingStrategyOverridesTest::containsBy;
            this.payloads.containsAllIterable = UnifiedSetWithHashingStrategyOverridesTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnifiedSetWithHashingStrategyOverridesTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedSetWithHashingStrategyOverridesTest::containsNoneIterable;
            this.payloads.containsAllArray = UnifiedSetWithHashingStrategyOverridesTest::containsAllArray;
            this.payloads.containsAnyCollection = UnifiedSetWithHashingStrategyOverridesTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedSetWithHashingStrategyOverridesTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnifiedSetWithHashingStrategyOverridesTest::containsAllCollection;
            this.payloads.selectWith = UnifiedSetWithHashingStrategyOverridesTest::selectWith;
            this.payloads.selectWith_target = UnifiedSetWithHashingStrategyOverridesTest::selectWith_target;
            this.payloads.rejectWith = UnifiedSetWithHashingStrategyOverridesTest::rejectWith;
            this.payloads.rejectWith_target = UnifiedSetWithHashingStrategyOverridesTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnifiedSetWithHashingStrategyOverridesTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetWithHashingStrategyOverridesTest::collect;
            this.payloads.collectTarget = UnifiedSetWithHashingStrategyOverridesTest::collectTarget;
            this.payloads.collectBoolean = UnifiedSetWithHashingStrategyOverridesTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnifiedSetWithHashingStrategyOverridesTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnifiedSetWithHashingStrategyOverridesTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnifiedSetWithHashingStrategyOverridesTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnifiedSetWithHashingStrategyOverridesTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnifiedSetWithHashingStrategyOverridesTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnifiedSetWithHashingStrategyOverridesTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnifiedSetWithHashingStrategyOverridesTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedSetWithHashingStrategyOverridesTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnifiedSetWithHashingStrategyOverridesTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnifiedSetWithHashingStrategyOverridesTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedSetWithHashingStrategyOverridesTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnifiedSetWithHashingStrategyOverridesTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnifiedSetWithHashingStrategyOverridesTest::flatCollectByte;
            this.payloads.flatCollectShort = UnifiedSetWithHashingStrategyOverridesTest::flatCollectShort;
            this.payloads.flatCollectInt = UnifiedSetWithHashingStrategyOverridesTest::flatCollectInt;
            this.payloads.flatCollectChar = UnifiedSetWithHashingStrategyOverridesTest::flatCollectChar;
            this.payloads.flatCollectLong = UnifiedSetWithHashingStrategyOverridesTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnifiedSetWithHashingStrategyOverridesTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnifiedSetWithHashingStrategyOverridesTest::flatCollectFloat;
            this.payloads.detectOptional = UnifiedSetWithHashingStrategyOverridesTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnifiedSetWithHashingStrategyOverridesTest::min;
            this.payloads.minOptional = UnifiedSetWithHashingStrategyOverridesTest::minOptional;
            this.payloads.max = UnifiedSetWithHashingStrategyOverridesTest::max;
            this.payloads.maxOptional = UnifiedSetWithHashingStrategyOverridesTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnifiedSetWithHashingStrategyOverridesTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetWithHashingStrategyOverridesTest::max_without_comparator;
            this.payloads.min_null_safe = UnifiedSetWithHashingStrategyOverridesTest::min_null_safe;
            this.payloads.max_null_safe = UnifiedSetWithHashingStrategyOverridesTest::max_null_safe;
            this.payloads.minBy = UnifiedSetWithHashingStrategyOverridesTest::minBy;
            this.payloads.minByOptional = UnifiedSetWithHashingStrategyOverridesTest::minByOptional;
            this.payloads.maxBy = UnifiedSetWithHashingStrategyOverridesTest::maxBy;
            this.payloads.maxByOptional = UnifiedSetWithHashingStrategyOverridesTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnifiedSetWithHashingStrategyOverridesTest::detectWith;
            this.payloads.detectWithOptional = UnifiedSetWithHashingStrategyOverridesTest::detectWithOptional;
            this.payloads.detectIfNone = UnifiedSetWithHashingStrategyOverridesTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnifiedSetWithHashingStrategyOverridesTest::detectWithIfNoneBlock;
            this.payloads.count = UnifiedSetWithHashingStrategyOverridesTest::count;
            this.payloads.countWith = UnifiedSetWithHashingStrategyOverridesTest::countWith;
            this.payloads.collectIf = UnifiedSetWithHashingStrategyOverridesTest::collectIf;
            this.payloads.collectWith = UnifiedSetWithHashingStrategyOverridesTest::collectWith;
            this.payloads.collectWith_target = UnifiedSetWithHashingStrategyOverridesTest::collectWith_target;
            this.payloads.getAny = UnifiedSetWithHashingStrategyOverridesTest::getAny;
            this.payloads.getOnly = UnifiedSetWithHashingStrategyOverridesTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = UnifiedSetWithHashingStrategyOverridesTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnifiedSetWithHashingStrategyOverridesTest::injectInto;
            this.payloads.injectIntoInt = UnifiedSetWithHashingStrategyOverridesTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedSetWithHashingStrategyOverridesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnifiedSetWithHashingStrategyOverridesTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnifiedSetWithHashingStrategyOverridesTest::injectIntoFloat;
            this.payloads.sumFloat = UnifiedSetWithHashingStrategyOverridesTest::sumFloat;
            this.payloads.summarizeFloat = UnifiedSetWithHashingStrategyOverridesTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnifiedSetWithHashingStrategyOverridesTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnifiedSetWithHashingStrategyOverridesTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnifiedSetWithHashingStrategyOverridesTest::sumDouble;
            this.payloads.summarizeDouble = UnifiedSetWithHashingStrategyOverridesTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnifiedSetWithHashingStrategyOverridesTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnifiedSetWithHashingStrategyOverridesTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnifiedSetWithHashingStrategyOverridesTest::sumInteger;
            this.payloads.summarizeInt = UnifiedSetWithHashingStrategyOverridesTest::summarizeInt;
            this.payloads.sumLong = UnifiedSetWithHashingStrategyOverridesTest::sumLong;
            this.payloads.summarizeLong = UnifiedSetWithHashingStrategyOverridesTest::summarizeLong;
            this.payloads.sumByInt = UnifiedSetWithHashingStrategyOverridesTest::sumByInt;
            this.payloads.sumByFloat = UnifiedSetWithHashingStrategyOverridesTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnifiedSetWithHashingStrategyOverridesTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnifiedSetWithHashingStrategyOverridesTest::sumByLong;
            this.payloads.sumByDouble = UnifiedSetWithHashingStrategyOverridesTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnifiedSetWithHashingStrategyOverridesTest::sumByDoubleConsistentRounding;
            this.payloads.partition = UnifiedSetWithHashingStrategyOverridesTest::partition;
            this.payloads.partitionWith = UnifiedSetWithHashingStrategyOverridesTest::partitionWith;
            this.payloads.toList = UnifiedSetWithHashingStrategyOverridesTest::toList;
            this.payloads.toImmutableList = UnifiedSetWithHashingStrategyOverridesTest::toImmutableList;
            this.payloads.toCollection = UnifiedSetWithHashingStrategyOverridesTest::toCollection;
            this.payloads.toBag = UnifiedSetWithHashingStrategyOverridesTest::toBag;
            this.payloads.toImmutableBag = UnifiedSetWithHashingStrategyOverridesTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnifiedSetWithHashingStrategyOverridesTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnifiedSetWithHashingStrategyOverridesTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnifiedSetWithHashingStrategyOverridesTest::toSet;
            this.payloads.toImmutableSet = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSet;
            this.payloads.toMap = UnifiedSetWithHashingStrategyOverridesTest::toMap;
            this.payloads.toImmutableMap = UnifiedSetWithHashingStrategyOverridesTest::toImmutableMap;
            this.payloads.toMapTarget = UnifiedSetWithHashingStrategyOverridesTest::toMapTarget;
            this.payloads.toSortedMap = UnifiedSetWithHashingStrategyOverridesTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnifiedSetWithHashingStrategyOverridesTest::toSortedMapBy;
            this.payloads.toBiMap = UnifiedSetWithHashingStrategyOverridesTest::toBiMap;
            this.payloads.toImmutableBiMap = UnifiedSetWithHashingStrategyOverridesTest::toImmutableBiMap;
            this.payloads.testToString = UnifiedSetWithHashingStrategyOverridesTest::testToString;
            this.payloads.makeString = UnifiedSetWithHashingStrategyOverridesTest::makeString;
            this.payloads.makeStringWithSeparator = UnifiedSetWithHashingStrategyOverridesTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnifiedSetWithHashingStrategyOverridesTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnifiedSetWithHashingStrategyOverridesTest::fusedCollectMakeString;
            this.payloads.appendString = UnifiedSetWithHashingStrategyOverridesTest::appendString;
            this.payloads.appendStringWithSeparator = UnifiedSetWithHashingStrategyOverridesTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnifiedSetWithHashingStrategyOverridesTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnifiedSetWithHashingStrategyOverridesTest::appendStringThrows;
            this.payloads.countBy = UnifiedSetWithHashingStrategyOverridesTest::countBy;
            this.payloads.countByWith = UnifiedSetWithHashingStrategyOverridesTest::countByWith;
            this.payloads.countByEach = UnifiedSetWithHashingStrategyOverridesTest::countByEach;
            this.payloads.groupBy = UnifiedSetWithHashingStrategyOverridesTest::groupBy;
            this.payloads.groupByEach = UnifiedSetWithHashingStrategyOverridesTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedSetWithHashingStrategyOverridesTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedSetWithHashingStrategyOverridesTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnifiedSetWithHashingStrategyOverridesTest::zip;
            this.payloads.zipWithIndex = UnifiedSetWithHashingStrategyOverridesTest::zipWithIndex;
            this.payloads.chunk = UnifiedSetWithHashingStrategyOverridesTest::chunk;
            this.payloads.chunk_empty = UnifiedSetWithHashingStrategyOverridesTest::chunk_empty;
            this.payloads.chunk_single = UnifiedSetWithHashingStrategyOverridesTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnifiedSetWithHashingStrategyOverridesTest::chunk_large_size;
            this.payloads.empty = UnifiedSetWithHashingStrategyOverridesTest::empty;
            this.payloads.notEmpty = UnifiedSetWithHashingStrategyOverridesTest::notEmpty;
            this.payloads.aggregateByMutating = UnifiedSetWithHashingStrategyOverridesTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedSetWithHashingStrategyOverridesTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnifiedSetWithHashingStrategyOverridesTest::reduceOptional;
            this.payloads.newEmpty = UnifiedSetWithHashingStrategyOverridesTest::newEmpty;
            this.payloads.toImmutable = UnifiedSetWithHashingStrategyOverridesTest::toImmutable;
            this.payloads.testNewWith = UnifiedSetWithHashingStrategyOverridesTest::testNewWith;
            this.payloads.testNewWithWith = UnifiedSetWithHashingStrategyOverridesTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnifiedSetWithHashingStrategyOverridesTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnifiedSetWithHashingStrategyOverridesTest::testNewWithVarArgs;
            this.payloads.removeAll = UnifiedSetWithHashingStrategyOverridesTest::removeAll;
            this.payloads.removeAllIterable = UnifiedSetWithHashingStrategyOverridesTest::removeAllIterable;
            this.payloads.retainAllIterable = UnifiedSetWithHashingStrategyOverridesTest::retainAllIterable;
            this.payloads.clear = UnifiedSetWithHashingStrategyOverridesTest::clear;
            this.payloads.injectIntoWith = UnifiedSetWithHashingStrategyOverridesTest::injectIntoWith;
            this.payloads.removeObject = UnifiedSetWithHashingStrategyOverridesTest::removeObject;
            this.payloads.selectAndRejectWith = UnifiedSetWithHashingStrategyOverridesTest::selectAndRejectWith;
            this.payloads.removeIfWith = UnifiedSetWithHashingStrategyOverridesTest::removeIfWith;
            this.payloads.withAll = UnifiedSetWithHashingStrategyOverridesTest::withAll;
            this.payloads.without = UnifiedSetWithHashingStrategyOverridesTest::without;
            this.payloads.withoutAll = UnifiedSetWithHashingStrategyOverridesTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = UnifiedSetWithHashingStrategyOverridesTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnifiedSetWithHashingStrategyOverridesTest::asLazy;
            this.payloads.asSynchronized = UnifiedSetWithHashingStrategyOverridesTest::asSynchronized;
            this.payloads.addAll = UnifiedSetWithHashingStrategyOverridesTest::addAll;
            this.payloads.union = UnifiedSetWithHashingStrategyOverridesTest::union;
            this.payloads.unionInto = UnifiedSetWithHashingStrategyOverridesTest::unionInto;
            this.payloads.intersect = UnifiedSetWithHashingStrategyOverridesTest::intersect;
            this.payloads.intersectInto = UnifiedSetWithHashingStrategyOverridesTest::intersectInto;
            this.payloads.difference = UnifiedSetWithHashingStrategyOverridesTest::difference;
            this.payloads.differenceInto = UnifiedSetWithHashingStrategyOverridesTest::differenceInto;
            this.payloads.symmetricDifference = UnifiedSetWithHashingStrategyOverridesTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = UnifiedSetWithHashingStrategyOverridesTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = UnifiedSetWithHashingStrategyOverridesTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnifiedSetWithHashingStrategyOverridesTest::isProperSubsetOf;
            this.payloads.powerSet = UnifiedSetWithHashingStrategyOverridesTest::powerSet;
            this.payloads.cartesianProduct = UnifiedSetWithHashingStrategyOverridesTest::cartesianProduct;
            this.payloads.asUnmodifiable = UnifiedSetWithHashingStrategyOverridesTest::asUnmodifiable;
            this.payloads.getFirst = UnifiedSetWithHashingStrategyOverridesTest::getFirst;
            this.payloads.getLast = UnifiedSetWithHashingStrategyOverridesTest::getLast;
            this.payloads.unifiedSetKeySetToArrayDest = UnifiedSetWithHashingStrategyOverridesTest::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = UnifiedSetWithHashingStrategyOverridesTest::unifiedSetToString;
            this.payloads.testClone = UnifiedSetWithHashingStrategyOverridesTest::testClone;
            this.payloads.isEmpty = UnifiedSetWithHashingStrategyOverridesTest::isEmpty;
            this.payloads.removeIf = UnifiedSetWithHashingStrategyOverridesTest::removeIf;
            this.payloads.forEach = UnifiedSetWithHashingStrategyOverridesTest::forEach;
            this.payloads.forEachWith = UnifiedSetWithHashingStrategyOverridesTest::forEachWith;
            this.payloads.forEachWithIndex = UnifiedSetWithHashingStrategyOverridesTest::forEachWithIndex;
            this.payloads.anySatisfy = UnifiedSetWithHashingStrategyOverridesTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetWithHashingStrategyOverridesTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetWithHashingStrategyOverridesTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetWithHashingStrategyOverridesTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetWithHashingStrategyOverridesTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetWithHashingStrategyOverridesTest::noneSatisfyWith;
            this.payloads.detect = UnifiedSetWithHashingStrategyOverridesTest::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toSortedBag_natural_ordering = UnifiedSetWithHashingStrategyOverridesTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnifiedSetWithHashingStrategyOverridesTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnifiedSetWithHashingStrategyOverridesTest::toSortedBagBy;
            this.payloads.frequentCollisions = UnifiedSetWithHashingStrategyOverridesTest::frequentCollisions;
            this.payloads.addOnObjectWithCastInEquals = UnifiedSetWithHashingStrategyOverridesTest::addOnObjectWithCastInEquals;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedSetWithHashingStrategyOverridesTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedSetWithHashingStrategyOverridesTest::rehash_null_collision;
            this.payloads.newSet_throws = UnifiedSetWithHashingStrategyOverridesTest::newSet_throws;
            this.payloads.tap = UnifiedSetWithHashingStrategyOverridesTest::tap;
            this.payloads.select = UnifiedSetWithHashingStrategyOverridesTest::select;
            this.payloads.reject = UnifiedSetWithHashingStrategyOverridesTest::reject;
            this.payloads.lazyCollectForEach = UnifiedSetWithHashingStrategyOverridesTest::lazyCollectForEach;
            this.payloads.lazyRejectForEach = UnifiedSetWithHashingStrategyOverridesTest::lazyRejectForEach;
            this.payloads.lazySelectForEach = UnifiedSetWithHashingStrategyOverridesTest::lazySelectForEach;
            this.payloads.with = UnifiedSetWithHashingStrategyOverridesTest::with;
            this.payloads.newSetWithIterable = UnifiedSetWithHashingStrategyOverridesTest::newSetWithIterable;
            this.payloads.add = UnifiedSetWithHashingStrategyOverridesTest::add;
            this.payloads.add_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::add_with_hashingStrategy;
            this.payloads.addOrReplace = UnifiedSetWithHashingStrategyOverridesTest::addOrReplace;
            this.payloads.addAllIterable = UnifiedSetWithHashingStrategyOverridesTest::addAllIterable;
            this.payloads.addALLIterable_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::addALLIterable_with_hashingStrategy;
            this.payloads.get = UnifiedSetWithHashingStrategyOverridesTest::get;
            this.payloads.get_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::get_with_hashingStrategy;
            this.payloads.put = UnifiedSetWithHashingStrategyOverridesTest::put;
            this.payloads.put_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::put_with_hashingStrategy;
            this.payloads.remove_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::remove_with_hashingStrategy;
            this.payloads.removeFromPool = UnifiedSetWithHashingStrategyOverridesTest::removeFromPool;
            this.payloads.removeFromPool_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::removeFromPool_with_hashingStrategy;
            this.payloads.serialization = UnifiedSetWithHashingStrategyOverridesTest::serialization;
            this.payloads.null_behavior = UnifiedSetWithHashingStrategyOverridesTest::null_behavior;
            this.payloads.equalsAndHashCode = UnifiedSetWithHashingStrategyOverridesTest::equalsAndHashCode;
            this.payloads.equals_with_hashingStrategy = UnifiedSetWithHashingStrategyOverridesTest::equals_with_hashingStrategy;
            this.payloads.constructor_from_UnifiedSet = UnifiedSetWithHashingStrategyOverridesTest::constructor_from_UnifiedSet;
            this.payloads.copyConstructor = UnifiedSetWithHashingStrategyOverridesTest::copyConstructor;
            this.payloads.newSet_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::newSet_null, java.lang.NullPointerException.class);
            this.payloads.newSet_null_hashingStrategy = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyOverridesTest::newSet_null_hashingStrategy, java.lang.IllegalArgumentException.class);
            this.payloads.batchForEach = UnifiedSetWithHashingStrategyOverridesTest::batchForEach;
            this.payloads.toArray = UnifiedSetWithHashingStrategyOverridesTest::toArray;
            this.payloads.iterator_remove = UnifiedSetWithHashingStrategyOverridesTest::iterator_remove;
            this.payloads.setKeyPreservation = UnifiedSetWithHashingStrategyOverridesTest::setKeyPreservation;
            this.payloads.withSameIfNotModified = UnifiedSetWithHashingStrategyOverridesTest::withSameIfNotModified;
            this.payloads.retainAll = UnifiedSetWithHashingStrategyOverridesTest::retainAll;
            this.payloads.trimToSize = UnifiedSetWithHashingStrategyOverridesTest::trimToSize;
        }
    }
*/
}
