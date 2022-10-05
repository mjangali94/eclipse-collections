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
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class RejectIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.reject(FastList.newListWith(elements), ignored -> false);
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(2).or(Predicates.greaterThan(3)));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
        });
        Assert.assertEquals(6, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> iterable = new RejectIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), Predicates.lessThan(2));
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 5), iterable.distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private RejectIterableTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new RejectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RejectIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = RejectIterableTest::toArray;
            this.payloads.contains = RejectIterableTest::contains;
            this.payloads.containsAllIterable = RejectIterableTest::containsAllIterable;
            this.payloads.containsAllArray = RejectIterableTest::containsAllArray;
            this.payloads.select = RejectIterableTest::select;
            this.payloads.selectWith = RejectIterableTest::selectWith;
            this.payloads.selectWithTarget = RejectIterableTest::selectWithTarget;
            this.payloads.reject = RejectIterableTest::reject;
            this.payloads.rejectWith = RejectIterableTest::rejectWith;
            this.payloads.rejectWithTarget = RejectIterableTest::rejectWithTarget;
            this.payloads.partition = RejectIterableTest::partition;
            this.payloads.partitionWith = RejectIterableTest::partitionWith;
            this.payloads.selectInstancesOf = RejectIterableTest::selectInstancesOf;
            this.payloads.collect = RejectIterableTest::collect;
            this.payloads.collectBoolean = RejectIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = RejectIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = RejectIterableTest::collectByte;
            this.payloads.collectByteWithTarget = RejectIterableTest::collectByteWithTarget;
            this.payloads.collectChar = RejectIterableTest::collectChar;
            this.payloads.collectCharWithTarget = RejectIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = RejectIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = RejectIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = RejectIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = RejectIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = RejectIterableTest::collectInt;
            this.payloads.collectIntWithTarget = RejectIterableTest::collectIntWithTarget;
            this.payloads.collectLong = RejectIterableTest::collectLong;
            this.payloads.collectLongWithTarget = RejectIterableTest::collectLongWithTarget;
            this.payloads.collectShort = RejectIterableTest::collectShort;
            this.payloads.collectShortWithTarget = RejectIterableTest::collectShortWithTarget;
            this.payloads.collectWith = RejectIterableTest::collectWith;
            this.payloads.collectWithTarget = RejectIterableTest::collectWithTarget;
            this.payloads.take = RejectIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = RejectIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = RejectIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = RejectIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = RejectIterableTest::detect;
            this.payloads.detectWith = RejectIterableTest::detectWith;
            this.payloads.detectOptional = RejectIterableTest::detectOptional;
            this.payloads.detectWithOptional = RejectIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = RejectIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = RejectIterableTest::min;
            this.payloads.max = RejectIterableTest::max;
            this.payloads.minBy = RejectIterableTest::minBy;
            this.payloads.maxBy = RejectIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = RejectIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = RejectIterableTest::max_without_comparator;
            this.payloads.detectIfNone = RejectIterableTest::detectIfNone;
            this.payloads.anySatisfy = RejectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = RejectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = RejectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = RejectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = RejectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = RejectIterableTest::noneSatisfyWith;
            this.payloads.count = RejectIterableTest::count;
            this.payloads.collectIf = RejectIterableTest::collectIf;
            this.payloads.collectIfWithTarget = RejectIterableTest::collectIfWithTarget;
            this.payloads.getFirst = RejectIterableTest::getFirst;
            this.payloads.getLast = RejectIterableTest::getLast;
            this.payloads.getOnly = RejectIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = RejectIterableTest::isEmpty;
            this.payloads.injectInto = RejectIterableTest::injectInto;
            this.payloads.toList = RejectIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = RejectIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = RejectIterableTest::toSortedList;
            this.payloads.toSortedListBy = RejectIterableTest::toSortedListBy;
            this.payloads.toSortedSet = RejectIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = RejectIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = RejectIterableTest::toSortedSetBy;
            this.payloads.toSet = RejectIterableTest::toSet;
            this.payloads.toMap = RejectIterableTest::toMap;
            this.payloads.toSortedMap = RejectIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = RejectIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = RejectIterableTest::toSortedMapBy;
            this.payloads.testToString = RejectIterableTest::testToString;
            this.payloads.makeString = RejectIterableTest::makeString;
            this.payloads.appendString = RejectIterableTest::appendString;
            this.payloads.groupBy = RejectIterableTest::groupBy;
            this.payloads.groupByEach = RejectIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = RejectIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = RejectIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = RejectIterableTest::zip;
            this.payloads.zipWithIndex = RejectIterableTest::zipWithIndex;
            this.payloads.chunk = RejectIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RejectIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = RejectIterableTest::chunk_large_size;
            this.payloads.tap = RejectIterableTest::tap;
            this.payloads.asLazy = RejectIterableTest::asLazy;
            this.payloads.flatCollect = RejectIterableTest::flatCollect;
            this.payloads.flatCollectWith = RejectIterableTest::flatCollectWith;
            this.payloads.forEach = RejectIterableTest::forEach;
            this.payloads.forEachWithIndex = RejectIterableTest::forEachWithIndex;
            this.payloads.iterator = RejectIterableTest::iterator;
            this.payloads.forEachWith = RejectIterableTest::forEachWith;
            this.payloads.distinct = RejectIterableTest::distinct;
        }
    }
}
