/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class TapIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        Appendable builder = new StringBuilder();
        Procedure<T> appendProcedure = Procedures.append(builder);
        return LazyIterate.tap(FastList.newListWith(elements), appendProcedure);
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        LazyIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        Procedure<Integer> appendDouble = each -> builder.append(each * 2);
        tap.forEach(appendDouble);
        Assert.assertEquals("12243648510", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        LazyIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        tap.forEachWithIndex((each, index) -> {
            builder.append(each * 2);
            builder.append(index);
        });
        Assert.assertEquals("1202413624835104", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        LazyIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        for (Integer each : tap) {
            builder.append(each + 1);
        }
        Assert.assertEquals("1223344556", builder.toString());
    }

    @Test
    public void forEachWith() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        LazyIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        tap.forEachWith((each, aBuilder) -> aBuilder.append(each - 1), builder);
        Assert.assertEquals("1021324354", builder.toString());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile_null_throws);
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
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListNaturalOrdering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListNaturalOrdering);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
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
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapIterableTest> forEachWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = TapIterableTest::toArray;
            this.payloads.contains = TapIterableTest::contains;
            this.payloads.containsAllIterable = TapIterableTest::containsAllIterable;
            this.payloads.containsAllArray = TapIterableTest::containsAllArray;
            this.payloads.select = TapIterableTest::select;
            this.payloads.selectWith = TapIterableTest::selectWith;
            this.payloads.selectWithTarget = TapIterableTest::selectWithTarget;
            this.payloads.reject = TapIterableTest::reject;
            this.payloads.rejectWith = TapIterableTest::rejectWith;
            this.payloads.rejectWithTarget = TapIterableTest::rejectWithTarget;
            this.payloads.partition = TapIterableTest::partition;
            this.payloads.partitionWith = TapIterableTest::partitionWith;
            this.payloads.selectInstancesOf = TapIterableTest::selectInstancesOf;
            this.payloads.collect = TapIterableTest::collect;
            this.payloads.collectBoolean = TapIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = TapIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = TapIterableTest::collectByte;
            this.payloads.collectByteWithTarget = TapIterableTest::collectByteWithTarget;
            this.payloads.collectChar = TapIterableTest::collectChar;
            this.payloads.collectCharWithTarget = TapIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = TapIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = TapIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = TapIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = TapIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = TapIterableTest::collectInt;
            this.payloads.collectIntWithTarget = TapIterableTest::collectIntWithTarget;
            this.payloads.collectLong = TapIterableTest::collectLong;
            this.payloads.collectLongWithTarget = TapIterableTest::collectLongWithTarget;
            this.payloads.collectShort = TapIterableTest::collectShort;
            this.payloads.collectShortWithTarget = TapIterableTest::collectShortWithTarget;
            this.payloads.collectWith = TapIterableTest::collectWith;
            this.payloads.collectWithTarget = TapIterableTest::collectWithTarget;
            this.payloads.take = TapIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TapIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = TapIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = TapIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = TapIterableTest::detect;
            this.payloads.detectWith = TapIterableTest::detectWith;
            this.payloads.detectOptional = TapIterableTest::detectOptional;
            this.payloads.detectWithOptional = TapIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = TapIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = TapIterableTest::min;
            this.payloads.max = TapIterableTest::max;
            this.payloads.minBy = TapIterableTest::minBy;
            this.payloads.maxBy = TapIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = TapIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = TapIterableTest::max_without_comparator;
            this.payloads.detectIfNone = TapIterableTest::detectIfNone;
            this.payloads.anySatisfy = TapIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = TapIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = TapIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = TapIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = TapIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TapIterableTest::noneSatisfyWith;
            this.payloads.count = TapIterableTest::count;
            this.payloads.collectIf = TapIterableTest::collectIf;
            this.payloads.collectIfWithTarget = TapIterableTest::collectIfWithTarget;
            this.payloads.getFirst = TapIterableTest::getFirst;
            this.payloads.getLast = TapIterableTest::getLast;
            this.payloads.getOnly = TapIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = TapIterableTest::isEmpty;
            this.payloads.injectInto = TapIterableTest::injectInto;
            this.payloads.toList = TapIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = TapIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = TapIterableTest::toSortedList;
            this.payloads.toSortedListBy = TapIterableTest::toSortedListBy;
            this.payloads.toSortedSet = TapIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = TapIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = TapIterableTest::toSortedSetBy;
            this.payloads.toSet = TapIterableTest::toSet;
            this.payloads.toMap = TapIterableTest::toMap;
            this.payloads.toSortedMap = TapIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = TapIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = TapIterableTest::toSortedMapBy;
            this.payloads.testToString = TapIterableTest::testToString;
            this.payloads.makeString = TapIterableTest::makeString;
            this.payloads.appendString = TapIterableTest::appendString;
            this.payloads.groupBy = TapIterableTest::groupBy;
            this.payloads.groupByEach = TapIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = TapIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TapIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = TapIterableTest::zip;
            this.payloads.zipWithIndex = TapIterableTest::zipWithIndex;
            this.payloads.chunk = TapIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TapIterableTest::chunk_large_size;
            this.payloads.tap = TapIterableTest::tap;
            this.payloads.asLazy = TapIterableTest::asLazy;
            this.payloads.flatCollect = TapIterableTest::flatCollect;
            this.payloads.flatCollectWith = TapIterableTest::flatCollectWith;
            this.payloads.distinct = TapIterableTest::distinct;
            this.payloads.forEach = TapIterableTest::forEach;
            this.payloads.forEachWithIndex = TapIterableTest::forEachWithIndex;
            this.payloads.iterator = TapIterableTest::iterator;
            this.payloads.forEachWith = TapIterableTest::forEachWith;
        }
    }
}
