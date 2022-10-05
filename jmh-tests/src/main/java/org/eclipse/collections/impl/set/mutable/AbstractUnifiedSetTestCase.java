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

import java.util.SortedSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.IntegerWithCast;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractUnifiedSetTestCase extends AbstractMutableSetTestCase {

    @Test
    public void addOnObjectWithCastInEquals() {
        if (this.newWith() instanceof SortedSet) {
            return;
        }
        MutableSet<IntegerWithCast> mutableSet = this.newWith(new IntegerWithCast(0));
        Assert.assertFalse(mutableSet.add(new IntegerWithCast(0)));
        Assert.assertTrue(mutableSet.add(null));
        Assert.assertFalse(mutableSet.add(null));
    }

    @Test
    public void retainAllFromKeySet_null_collision() {
        IntegerWithCast key = new IntegerWithCast(0);
        MutableSet<IntegerWithCast> mutableSet = this.newWith(null, key);
        Assert.assertFalse(mutableSet.retainAll(FastList.newListWith(key, null)));
        Assert.assertEquals(this.newWith(null, key), mutableSet);
    }

    @Test
    public void rehash_null_collision() {
        MutableSet<IntegerWithCast> mutableMap = this.newWith((IntegerWithCast) null);
        for (int i = 0; i < 1000; i++) {
            mutableMap.add(new IntegerWithCast(i));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractUnifiedSetTestCase instance;

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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
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
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractUnifiedSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> addOnObjectWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractUnifiedSetTestCase> rehash_null_collision;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractUnifiedSetTestCase::testNewCollection;
            this.payloads.contains = AbstractUnifiedSetTestCase::contains;
            this.payloads.containsBy = AbstractUnifiedSetTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractUnifiedSetTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractUnifiedSetTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractUnifiedSetTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractUnifiedSetTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractUnifiedSetTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractUnifiedSetTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractUnifiedSetTestCase::containsAllCollection;
            this.payloads.selectWith = AbstractUnifiedSetTestCase::selectWith;
            this.payloads.selectWith_target = AbstractUnifiedSetTestCase::selectWith_target;
            this.payloads.rejectWith = AbstractUnifiedSetTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractUnifiedSetTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractUnifiedSetTestCase::selectInstancesOf;
            this.payloads.collect = AbstractUnifiedSetTestCase::collect;
            this.payloads.collectTarget = AbstractUnifiedSetTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractUnifiedSetTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractUnifiedSetTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractUnifiedSetTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractUnifiedSetTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractUnifiedSetTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractUnifiedSetTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractUnifiedSetTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractUnifiedSetTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractUnifiedSetTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractUnifiedSetTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractUnifiedSetTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractUnifiedSetTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractUnifiedSetTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractUnifiedSetTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractUnifiedSetTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractUnifiedSetTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractUnifiedSetTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractUnifiedSetTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractUnifiedSetTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractUnifiedSetTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractUnifiedSetTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractUnifiedSetTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractUnifiedSetTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractUnifiedSetTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractUnifiedSetTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractUnifiedSetTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractUnifiedSetTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractUnifiedSetTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractUnifiedSetTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractUnifiedSetTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractUnifiedSetTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractUnifiedSetTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractUnifiedSetTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractUnifiedSetTestCase::flatCollectFloat;
            this.payloads.detectOptional = AbstractUnifiedSetTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractUnifiedSetTestCase::min;
            this.payloads.minOptional = AbstractUnifiedSetTestCase::minOptional;
            this.payloads.max = AbstractUnifiedSetTestCase::max;
            this.payloads.maxOptional = AbstractUnifiedSetTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractUnifiedSetTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractUnifiedSetTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractUnifiedSetTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractUnifiedSetTestCase::max_null_safe;
            this.payloads.minBy = AbstractUnifiedSetTestCase::minBy;
            this.payloads.minByOptional = AbstractUnifiedSetTestCase::minByOptional;
            this.payloads.maxBy = AbstractUnifiedSetTestCase::maxBy;
            this.payloads.maxByOptional = AbstractUnifiedSetTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractUnifiedSetTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractUnifiedSetTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractUnifiedSetTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractUnifiedSetTestCase::detectWithIfNoneBlock;
            this.payloads.count = AbstractUnifiedSetTestCase::count;
            this.payloads.countWith = AbstractUnifiedSetTestCase::countWith;
            this.payloads.collectIf = AbstractUnifiedSetTestCase::collectIf;
            this.payloads.collectWith = AbstractUnifiedSetTestCase::collectWith;
            this.payloads.collectWith_target = AbstractUnifiedSetTestCase::collectWith_target;
            this.payloads.getAny = AbstractUnifiedSetTestCase::getAny;
            this.payloads.getOnly = AbstractUnifiedSetTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = AbstractUnifiedSetTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractUnifiedSetTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractUnifiedSetTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractUnifiedSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractUnifiedSetTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractUnifiedSetTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractUnifiedSetTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractUnifiedSetTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractUnifiedSetTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractUnifiedSetTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractUnifiedSetTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractUnifiedSetTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractUnifiedSetTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractUnifiedSetTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractUnifiedSetTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractUnifiedSetTestCase::summarizeInt;
            this.payloads.sumLong = AbstractUnifiedSetTestCase::sumLong;
            this.payloads.summarizeLong = AbstractUnifiedSetTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractUnifiedSetTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractUnifiedSetTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractUnifiedSetTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractUnifiedSetTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractUnifiedSetTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractUnifiedSetTestCase::sumByDoubleConsistentRounding;
            this.payloads.partition = AbstractUnifiedSetTestCase::partition;
            this.payloads.partitionWith = AbstractUnifiedSetTestCase::partitionWith;
            this.payloads.toList = AbstractUnifiedSetTestCase::toList;
            this.payloads.toImmutableList = AbstractUnifiedSetTestCase::toImmutableList;
            this.payloads.toCollection = AbstractUnifiedSetTestCase::toCollection;
            this.payloads.toBag = AbstractUnifiedSetTestCase::toBag;
            this.payloads.toImmutableBag = AbstractUnifiedSetTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractUnifiedSetTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractUnifiedSetTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractUnifiedSetTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractUnifiedSetTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractUnifiedSetTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = AbstractUnifiedSetTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractUnifiedSetTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractUnifiedSetTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractUnifiedSetTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractUnifiedSetTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractUnifiedSetTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractUnifiedSetTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractUnifiedSetTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractUnifiedSetTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractUnifiedSetTestCase::toSet;
            this.payloads.toImmutableSet = AbstractUnifiedSetTestCase::toImmutableSet;
            this.payloads.toMap = AbstractUnifiedSetTestCase::toMap;
            this.payloads.toImmutableMap = AbstractUnifiedSetTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractUnifiedSetTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractUnifiedSetTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractUnifiedSetTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractUnifiedSetTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractUnifiedSetTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractUnifiedSetTestCase::toImmutableBiMap;
            this.payloads.testToString = AbstractUnifiedSetTestCase::testToString;
            this.payloads.makeString = AbstractUnifiedSetTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractUnifiedSetTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractUnifiedSetTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractUnifiedSetTestCase::fusedCollectMakeString;
            this.payloads.appendString = AbstractUnifiedSetTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractUnifiedSetTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractUnifiedSetTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractUnifiedSetTestCase::appendStringThrows;
            this.payloads.countBy = AbstractUnifiedSetTestCase::countBy;
            this.payloads.countByWith = AbstractUnifiedSetTestCase::countByWith;
            this.payloads.countByEach = AbstractUnifiedSetTestCase::countByEach;
            this.payloads.groupBy = AbstractUnifiedSetTestCase::groupBy;
            this.payloads.groupByEach = AbstractUnifiedSetTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractUnifiedSetTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractUnifiedSetTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractUnifiedSetTestCase::zip;
            this.payloads.zipWithIndex = AbstractUnifiedSetTestCase::zipWithIndex;
            this.payloads.chunk = AbstractUnifiedSetTestCase::chunk;
            this.payloads.chunk_empty = AbstractUnifiedSetTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractUnifiedSetTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractUnifiedSetTestCase::chunk_large_size;
            this.payloads.empty = AbstractUnifiedSetTestCase::empty;
            this.payloads.notEmpty = AbstractUnifiedSetTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractUnifiedSetTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractUnifiedSetTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractUnifiedSetTestCase::reduceOptional;
            this.payloads.newEmpty = AbstractUnifiedSetTestCase::newEmpty;
            this.payloads.toImmutable = AbstractUnifiedSetTestCase::toImmutable;
            this.payloads.testNewWith = AbstractUnifiedSetTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractUnifiedSetTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractUnifiedSetTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractUnifiedSetTestCase::testNewWithVarArgs;
            this.payloads.removeAll = AbstractUnifiedSetTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractUnifiedSetTestCase::removeAllIterable;
            this.payloads.retainAllIterable = AbstractUnifiedSetTestCase::retainAllIterable;
            this.payloads.clear = AbstractUnifiedSetTestCase::clear;
            this.payloads.injectIntoWith = AbstractUnifiedSetTestCase::injectIntoWith;
            this.payloads.removeObject = AbstractUnifiedSetTestCase::removeObject;
            this.payloads.selectAndRejectWith = AbstractUnifiedSetTestCase::selectAndRejectWith;
            this.payloads.removeIfWith = AbstractUnifiedSetTestCase::removeIfWith;
            this.payloads.with = AbstractUnifiedSetTestCase::with;
            this.payloads.withAll = AbstractUnifiedSetTestCase::withAll;
            this.payloads.without = AbstractUnifiedSetTestCase::without;
            this.payloads.withoutAll = AbstractUnifiedSetTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractUnifiedSetTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractUnifiedSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractUnifiedSetTestCase::asSynchronized;
            this.payloads.addAll = AbstractUnifiedSetTestCase::addAll;
            this.payloads.addAllIterable = AbstractUnifiedSetTestCase::addAllIterable;
            this.payloads.union = AbstractUnifiedSetTestCase::union;
            this.payloads.unionInto = AbstractUnifiedSetTestCase::unionInto;
            this.payloads.intersect = AbstractUnifiedSetTestCase::intersect;
            this.payloads.intersectInto = AbstractUnifiedSetTestCase::intersectInto;
            this.payloads.difference = AbstractUnifiedSetTestCase::difference;
            this.payloads.differenceInto = AbstractUnifiedSetTestCase::differenceInto;
            this.payloads.symmetricDifference = AbstractUnifiedSetTestCase::symmetricDifference;
            this.payloads.symmetricDifferenceInto = AbstractUnifiedSetTestCase::symmetricDifferenceInto;
            this.payloads.isSubsetOf = AbstractUnifiedSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractUnifiedSetTestCase::isProperSubsetOf;
            this.payloads.powerSet = AbstractUnifiedSetTestCase::powerSet;
            this.payloads.cartesianProduct = AbstractUnifiedSetTestCase::cartesianProduct;
            this.payloads.asUnmodifiable = AbstractUnifiedSetTestCase::asUnmodifiable;
            this.payloads.select = AbstractUnifiedSetTestCase::select;
            this.payloads.reject = AbstractUnifiedSetTestCase::reject;
            this.payloads.getFirst = AbstractUnifiedSetTestCase::getFirst;
            this.payloads.getLast = AbstractUnifiedSetTestCase::getLast;
            this.payloads.unifiedSetKeySetToArrayDest = AbstractUnifiedSetTestCase::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = AbstractUnifiedSetTestCase::unifiedSetToString;
            this.payloads.testClone = AbstractUnifiedSetTestCase::testClone;
            this.payloads.isEmpty = AbstractUnifiedSetTestCase::isEmpty;
            this.payloads.add = AbstractUnifiedSetTestCase::add;
            this.payloads.removeIf = AbstractUnifiedSetTestCase::removeIf;
            this.payloads.retainAll = AbstractUnifiedSetTestCase::retainAll;
            this.payloads.equalsAndHashCode = AbstractUnifiedSetTestCase::equalsAndHashCode;
            this.payloads.tap = AbstractUnifiedSetTestCase::tap;
            this.payloads.forEach = AbstractUnifiedSetTestCase::forEach;
            this.payloads.forEachWith = AbstractUnifiedSetTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractUnifiedSetTestCase::forEachWithIndex;
            this.payloads.anySatisfy = AbstractUnifiedSetTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractUnifiedSetTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractUnifiedSetTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractUnifiedSetTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractUnifiedSetTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractUnifiedSetTestCase::noneSatisfyWith;
            this.payloads.detect = AbstractUnifiedSetTestCase::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toArray = AbstractUnifiedSetTestCase::toArray;
            this.payloads.toSortedBag_natural_ordering = AbstractUnifiedSetTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractUnifiedSetTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractUnifiedSetTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractUnifiedSetTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractUnifiedSetTestCase::toSortedBagBy;
            this.payloads.frequentCollisions = AbstractUnifiedSetTestCase::frequentCollisions;
            this.payloads.addOnObjectWithCastInEquals = AbstractUnifiedSetTestCase::addOnObjectWithCastInEquals;
            this.payloads.retainAllFromKeySet_null_collision = AbstractUnifiedSetTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = AbstractUnifiedSetTestCase::rehash_null_collision;
        }
    }
}
