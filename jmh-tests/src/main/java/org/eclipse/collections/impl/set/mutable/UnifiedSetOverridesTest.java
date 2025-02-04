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

public class UnifiedSetOverridesTest extends UnifiedSetTest {

    public static class UnifiedSetOverriddes<T> extends UnifiedSet<T> {

        public UnifiedSetOverriddes(int size) {
            super(size);
        }

        @Override
        protected int index(Object key) {
            int h = key == null ? 0 : key.hashCode();
            return h & this.table.length - 1;
        }

        @Override
        public UnifiedSetOverriddes<T> newEmpty(int size) {
            return new UnifiedSetOverriddes<>(size);
        }
    }

    @Override
    protected <T> UnifiedSet<T> newWith(T... littleElements) {
        UnifiedSet<T> set = new UnifiedSetOverriddes<>(littleElements.length);
        return set.with(littleElements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetOverridesTest instance;

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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetProperSuperSetOfHashSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetProperSuperSetOfHashSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool);
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
        public void benchmark_constructor_from_UnifiedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructor_from_UnifiedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_copyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.copyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet);
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
        public void benchmark_asParallelNullExecutorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallelNullExecutorService);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallelLessThanOneBatchSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallelLessThanOneBatchSize);
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
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetOverridesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> newSet_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> newSetWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> unifiedSetProperSuperSetOfHashSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> removeFromPool;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> null_behavior;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> constructor_from_UnifiedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> copyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> newSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> setKeyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> withSameIfNotModified;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> asParallelNullExecutorService;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> asParallelLessThanOneBatchSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetOverridesTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnifiedSetOverridesTest::testNewCollection;
            this.payloads.contains = UnifiedSetOverridesTest::contains;
            this.payloads.containsBy = UnifiedSetOverridesTest::containsBy;
            this.payloads.containsAllIterable = UnifiedSetOverridesTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnifiedSetOverridesTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedSetOverridesTest::containsNoneIterable;
            this.payloads.containsAllArray = UnifiedSetOverridesTest::containsAllArray;
            this.payloads.containsAnyCollection = UnifiedSetOverridesTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedSetOverridesTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnifiedSetOverridesTest::containsAllCollection;
            this.payloads.selectWith = UnifiedSetOverridesTest::selectWith;
            this.payloads.selectWith_target = UnifiedSetOverridesTest::selectWith_target;
            this.payloads.rejectWith = UnifiedSetOverridesTest::rejectWith;
            this.payloads.rejectWith_target = UnifiedSetOverridesTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnifiedSetOverridesTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetOverridesTest::collect;
            this.payloads.collectTarget = UnifiedSetOverridesTest::collectTarget;
            this.payloads.collectBoolean = UnifiedSetOverridesTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedSetOverridesTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnifiedSetOverridesTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnifiedSetOverridesTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedSetOverridesTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnifiedSetOverridesTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnifiedSetOverridesTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedSetOverridesTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnifiedSetOverridesTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnifiedSetOverridesTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedSetOverridesTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnifiedSetOverridesTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnifiedSetOverridesTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedSetOverridesTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnifiedSetOverridesTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnifiedSetOverridesTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedSetOverridesTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnifiedSetOverridesTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnifiedSetOverridesTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedSetOverridesTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnifiedSetOverridesTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnifiedSetOverridesTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedSetOverridesTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnifiedSetOverridesTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnifiedSetOverridesTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedSetOverridesTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnifiedSetOverridesTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnifiedSetOverridesTest::flatCollectByte;
            this.payloads.flatCollectShort = UnifiedSetOverridesTest::flatCollectShort;
            this.payloads.flatCollectInt = UnifiedSetOverridesTest::flatCollectInt;
            this.payloads.flatCollectChar = UnifiedSetOverridesTest::flatCollectChar;
            this.payloads.flatCollectLong = UnifiedSetOverridesTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnifiedSetOverridesTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnifiedSetOverridesTest::flatCollectFloat;
            this.payloads.detectOptional = UnifiedSetOverridesTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnifiedSetOverridesTest::min;
            this.payloads.minOptional = UnifiedSetOverridesTest::minOptional;
            this.payloads.max = UnifiedSetOverridesTest::max;
            this.payloads.maxOptional = UnifiedSetOverridesTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnifiedSetOverridesTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetOverridesTest::max_without_comparator;
            this.payloads.min_null_safe = UnifiedSetOverridesTest::min_null_safe;
            this.payloads.max_null_safe = UnifiedSetOverridesTest::max_null_safe;
            this.payloads.minBy = UnifiedSetOverridesTest::minBy;
            this.payloads.minByOptional = UnifiedSetOverridesTest::minByOptional;
            this.payloads.maxBy = UnifiedSetOverridesTest::maxBy;
            this.payloads.maxByOptional = UnifiedSetOverridesTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnifiedSetOverridesTest::detectWith;
            this.payloads.detectWithOptional = UnifiedSetOverridesTest::detectWithOptional;
            this.payloads.detectIfNone = UnifiedSetOverridesTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnifiedSetOverridesTest::detectWithIfNoneBlock;
            this.payloads.count = UnifiedSetOverridesTest::count;
            this.payloads.countWith = UnifiedSetOverridesTest::countWith;
            this.payloads.collectIf = UnifiedSetOverridesTest::collectIf;
            this.payloads.collectWith = UnifiedSetOverridesTest::collectWith;
            this.payloads.collectWith_target = UnifiedSetOverridesTest::collectWith_target;
            this.payloads.getAny = UnifiedSetOverridesTest::getAny;
            this.payloads.getOnly = UnifiedSetOverridesTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = UnifiedSetOverridesTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnifiedSetOverridesTest::injectInto;
            this.payloads.injectIntoInt = UnifiedSetOverridesTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedSetOverridesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnifiedSetOverridesTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnifiedSetOverridesTest::injectIntoFloat;
            this.payloads.sumFloat = UnifiedSetOverridesTest::sumFloat;
            this.payloads.summarizeFloat = UnifiedSetOverridesTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnifiedSetOverridesTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnifiedSetOverridesTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnifiedSetOverridesTest::sumDouble;
            this.payloads.summarizeDouble = UnifiedSetOverridesTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnifiedSetOverridesTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnifiedSetOverridesTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnifiedSetOverridesTest::sumInteger;
            this.payloads.summarizeInt = UnifiedSetOverridesTest::summarizeInt;
            this.payloads.sumLong = UnifiedSetOverridesTest::sumLong;
            this.payloads.summarizeLong = UnifiedSetOverridesTest::summarizeLong;
            this.payloads.sumByInt = UnifiedSetOverridesTest::sumByInt;
            this.payloads.sumByFloat = UnifiedSetOverridesTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnifiedSetOverridesTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnifiedSetOverridesTest::sumByLong;
            this.payloads.sumByDouble = UnifiedSetOverridesTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnifiedSetOverridesTest::sumByDoubleConsistentRounding;
            this.payloads.partition = UnifiedSetOverridesTest::partition;
            this.payloads.partitionWith = UnifiedSetOverridesTest::partitionWith;
            this.payloads.toList = UnifiedSetOverridesTest::toList;
            this.payloads.toImmutableList = UnifiedSetOverridesTest::toImmutableList;
            this.payloads.toCollection = UnifiedSetOverridesTest::toCollection;
            this.payloads.toBag = UnifiedSetOverridesTest::toBag;
            this.payloads.toImmutableBag = UnifiedSetOverridesTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnifiedSetOverridesTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnifiedSetOverridesTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnifiedSetOverridesTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnifiedSetOverridesTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnifiedSetOverridesTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnifiedSetOverridesTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnifiedSetOverridesTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnifiedSetOverridesTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnifiedSetOverridesTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnifiedSetOverridesTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnifiedSetOverridesTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnifiedSetOverridesTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnifiedSetOverridesTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnifiedSetOverridesTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnifiedSetOverridesTest::toSet;
            this.payloads.toImmutableSet = UnifiedSetOverridesTest::toImmutableSet;
            this.payloads.toMap = UnifiedSetOverridesTest::toMap;
            this.payloads.toImmutableMap = UnifiedSetOverridesTest::toImmutableMap;
            this.payloads.toMapTarget = UnifiedSetOverridesTest::toMapTarget;
            this.payloads.toSortedMap = UnifiedSetOverridesTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnifiedSetOverridesTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnifiedSetOverridesTest::toSortedMapBy;
            this.payloads.toBiMap = UnifiedSetOverridesTest::toBiMap;
            this.payloads.toImmutableBiMap = UnifiedSetOverridesTest::toImmutableBiMap;
            this.payloads.testToString = UnifiedSetOverridesTest::testToString;
            this.payloads.makeString = UnifiedSetOverridesTest::makeString;
            this.payloads.makeStringWithSeparator = UnifiedSetOverridesTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnifiedSetOverridesTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnifiedSetOverridesTest::fusedCollectMakeString;
            this.payloads.appendString = UnifiedSetOverridesTest::appendString;
            this.payloads.appendStringWithSeparator = UnifiedSetOverridesTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnifiedSetOverridesTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnifiedSetOverridesTest::appendStringThrows;
            this.payloads.countBy = UnifiedSetOverridesTest::countBy;
            this.payloads.countByWith = UnifiedSetOverridesTest::countByWith;
            this.payloads.countByEach = UnifiedSetOverridesTest::countByEach;
            this.payloads.groupBy = UnifiedSetOverridesTest::groupBy;
            this.payloads.groupByEach = UnifiedSetOverridesTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedSetOverridesTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedSetOverridesTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnifiedSetOverridesTest::zip;
            this.payloads.zipWithIndex = UnifiedSetOverridesTest::zipWithIndex;
            this.payloads.chunk = UnifiedSetOverridesTest::chunk;
            this.payloads.chunk_empty = UnifiedSetOverridesTest::chunk_empty;
            this.payloads.chunk_single = UnifiedSetOverridesTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnifiedSetOverridesTest::chunk_large_size;
            this.payloads.empty = UnifiedSetOverridesTest::empty;
            this.payloads.notEmpty = UnifiedSetOverridesTest::notEmpty;
            this.payloads.aggregateByMutating = UnifiedSetOverridesTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedSetOverridesTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnifiedSetOverridesTest::reduceOptional;
            this.payloads.newEmpty = UnifiedSetOverridesTest::newEmpty;
            this.payloads.toImmutable = UnifiedSetOverridesTest::toImmutable;
            this.payloads.testNewWith = UnifiedSetOverridesTest::testNewWith;
            this.payloads.testNewWithWith = UnifiedSetOverridesTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnifiedSetOverridesTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnifiedSetOverridesTest::testNewWithVarArgs;
            this.payloads.removeAll = UnifiedSetOverridesTest::removeAll;
            this.payloads.removeAllIterable = UnifiedSetOverridesTest::removeAllIterable;
            this.payloads.retainAllIterable = UnifiedSetOverridesTest::retainAllIterable;
            this.payloads.clear = UnifiedSetOverridesTest::clear;
            this.payloads.injectIntoWith = UnifiedSetOverridesTest::injectIntoWith;
            this.payloads.removeObject = UnifiedSetOverridesTest::removeObject;
            this.payloads.selectAndRejectWith = UnifiedSetOverridesTest::selectAndRejectWith;
            this.payloads.removeIfWith = UnifiedSetOverridesTest::removeIfWith;
            this.payloads.withAll = UnifiedSetOverridesTest::withAll;
            this.payloads.without = UnifiedSetOverridesTest::without;
            this.payloads.withoutAll = UnifiedSetOverridesTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = UnifiedSetOverridesTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnifiedSetOverridesTest::asLazy;
            this.payloads.asSynchronized = UnifiedSetOverridesTest::asSynchronized;
            this.payloads.addAll = UnifiedSetOverridesTest::addAll;
            this.payloads.union = UnifiedSetOverridesTest::union;
            this.payloads.unionInto = UnifiedSetOverridesTest::unionInto;
            this.payloads.intersect = UnifiedSetOverridesTest::intersect;
            this.payloads.intersectInto = UnifiedSetOverridesTest::intersectInto;
            this.payloads.difference = UnifiedSetOverridesTest::difference;
            this.payloads.differenceInto = UnifiedSetOverridesTest::differenceInto;
            this.payloads.symmetricDifference = UnifiedSetOverridesTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = UnifiedSetOverridesTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = UnifiedSetOverridesTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnifiedSetOverridesTest::isProperSubsetOf;
            this.payloads.powerSet = UnifiedSetOverridesTest::powerSet;
            this.payloads.cartesianProduct = UnifiedSetOverridesTest::cartesianProduct;
            this.payloads.asUnmodifiable = UnifiedSetOverridesTest::asUnmodifiable;
            this.payloads.select = UnifiedSetOverridesTest::select;
            this.payloads.reject = UnifiedSetOverridesTest::reject;
            this.payloads.unifiedSetKeySetToArrayDest = UnifiedSetOverridesTest::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = UnifiedSetOverridesTest::unifiedSetToString;
            this.payloads.testClone = UnifiedSetOverridesTest::testClone;
            this.payloads.isEmpty = UnifiedSetOverridesTest::isEmpty;
            this.payloads.removeIf = UnifiedSetOverridesTest::removeIf;
            this.payloads.tap = UnifiedSetOverridesTest::tap;
            this.payloads.forEach = UnifiedSetOverridesTest::forEach;
            this.payloads.forEachWith = UnifiedSetOverridesTest::forEachWith;
            this.payloads.forEachWithIndex = UnifiedSetOverridesTest::forEachWithIndex;
            this.payloads.anySatisfy = UnifiedSetOverridesTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetOverridesTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetOverridesTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetOverridesTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetOverridesTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetOverridesTest::noneSatisfyWith;
            this.payloads.detect = UnifiedSetOverridesTest::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toSortedBag_natural_ordering = UnifiedSetOverridesTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnifiedSetOverridesTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnifiedSetOverridesTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnifiedSetOverridesTest::toSortedBagBy;
            this.payloads.frequentCollisions = UnifiedSetOverridesTest::frequentCollisions;
            this.payloads.with = UnifiedSetOverridesTest::with;
            this.payloads.newSet_throws = UnifiedSetOverridesTest::newSet_throws;
            this.payloads.newSetWithIterable = UnifiedSetOverridesTest::newSetWithIterable;
            this.payloads.unifiedSetProperSuperSetOfHashSet = UnifiedSetOverridesTest::unifiedSetProperSuperSetOfHashSet;
            this.payloads.add = UnifiedSetOverridesTest::add;
            this.payloads.addAllIterable = UnifiedSetOverridesTest::addAllIterable;
            this.payloads.get = UnifiedSetOverridesTest::get;
            this.payloads.put = UnifiedSetOverridesTest::put;
            this.payloads.removeFromPool = UnifiedSetOverridesTest::removeFromPool;
            this.payloads.serialization = UnifiedSetOverridesTest::serialization;
            this.payloads.null_behavior = UnifiedSetOverridesTest::null_behavior;
            this.payloads.equalsAndHashCode = UnifiedSetOverridesTest::equalsAndHashCode;
            this.payloads.constructor_from_UnifiedSet = UnifiedSetOverridesTest::constructor_from_UnifiedSet;
            this.payloads.copyConstructor = UnifiedSetOverridesTest::copyConstructor;
            this.payloads.newSet = UnifiedSetOverridesTest::newSet;
            this.payloads.batchForEach = UnifiedSetOverridesTest::batchForEach;
            this.payloads.toArray = UnifiedSetOverridesTest::toArray;
            this.payloads.iterator_remove = UnifiedSetOverridesTest::iterator_remove;
            this.payloads.setKeyPreservation = UnifiedSetOverridesTest::setKeyPreservation;
            this.payloads.withSameIfNotModified = UnifiedSetOverridesTest::withSameIfNotModified;
            this.payloads.retainAll = UnifiedSetOverridesTest::retainAll;
            this.payloads.asParallelNullExecutorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::asParallelNullExecutorService, java.lang.NullPointerException.class);
            this.payloads.asParallelLessThanOneBatchSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetOverridesTest::asParallelLessThanOneBatchSize, java.lang.IllegalArgumentException.class);
            this.payloads.getFirst = UnifiedSetOverridesTest::getFirst;
            this.payloads.getLast = UnifiedSetOverridesTest::getLast;
            this.payloads.trimToSize = UnifiedSetOverridesTest::trimToSize;
        }
    }
}
