/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LazyIterableAdapterTest extends AbstractLazyIterableTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LazyIterableAdapterTest.class);

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return new LazyIterableAdapter<>(FastList.newListWith(elements));
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Test
    public void into() {
        int sum = new LazyIterableAdapter<>(Interval.oneTo(5)).into(FastList.newList()).injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(15, sum);
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
            LOGGER.info("value={} index={}", object, index);
        });
        Assert.assertEquals(25, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> iterable = new LazyIterableAdapter<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5));
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1, 5), iterable.distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyIterableAdapterTest instance;

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
        public void benchmark_into() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.into);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> into;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterableAdapterTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = LazyIterableAdapterTest::toArray;
            this.payloads.contains = LazyIterableAdapterTest::contains;
            this.payloads.containsAllIterable = LazyIterableAdapterTest::containsAllIterable;
            this.payloads.containsAllArray = LazyIterableAdapterTest::containsAllArray;
            this.payloads.select = LazyIterableAdapterTest::select;
            this.payloads.selectWith = LazyIterableAdapterTest::selectWith;
            this.payloads.selectWithTarget = LazyIterableAdapterTest::selectWithTarget;
            this.payloads.reject = LazyIterableAdapterTest::reject;
            this.payloads.rejectWith = LazyIterableAdapterTest::rejectWith;
            this.payloads.rejectWithTarget = LazyIterableAdapterTest::rejectWithTarget;
            this.payloads.partition = LazyIterableAdapterTest::partition;
            this.payloads.partitionWith = LazyIterableAdapterTest::partitionWith;
            this.payloads.selectInstancesOf = LazyIterableAdapterTest::selectInstancesOf;
            this.payloads.collect = LazyIterableAdapterTest::collect;
            this.payloads.collectBoolean = LazyIterableAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = LazyIterableAdapterTest::collectBooleanWithTarget;
            this.payloads.collectByte = LazyIterableAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = LazyIterableAdapterTest::collectByteWithTarget;
            this.payloads.collectChar = LazyIterableAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = LazyIterableAdapterTest::collectCharWithTarget;
            this.payloads.collectDouble = LazyIterableAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = LazyIterableAdapterTest::collectDoubleWithTarget;
            this.payloads.collectFloat = LazyIterableAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = LazyIterableAdapterTest::collectFloatWithTarget;
            this.payloads.collectInt = LazyIterableAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = LazyIterableAdapterTest::collectIntWithTarget;
            this.payloads.collectLong = LazyIterableAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = LazyIterableAdapterTest::collectLongWithTarget;
            this.payloads.collectShort = LazyIterableAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = LazyIterableAdapterTest::collectShortWithTarget;
            this.payloads.collectWith = LazyIterableAdapterTest::collectWith;
            this.payloads.collectWithTarget = LazyIterableAdapterTest::collectWithTarget;
            this.payloads.take = LazyIterableAdapterTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = LazyIterableAdapterTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = LazyIterableAdapterTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = LazyIterableAdapterTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = LazyIterableAdapterTest::detect;
            this.payloads.detectWith = LazyIterableAdapterTest::detectWith;
            this.payloads.detectOptional = LazyIterableAdapterTest::detectOptional;
            this.payloads.detectWithOptional = LazyIterableAdapterTest::detectWithOptional;
            this.payloads.detectWithIfNone = LazyIterableAdapterTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = LazyIterableAdapterTest::min;
            this.payloads.max = LazyIterableAdapterTest::max;
            this.payloads.minBy = LazyIterableAdapterTest::minBy;
            this.payloads.maxBy = LazyIterableAdapterTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = LazyIterableAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = LazyIterableAdapterTest::max_without_comparator;
            this.payloads.detectIfNone = LazyIterableAdapterTest::detectIfNone;
            this.payloads.anySatisfy = LazyIterableAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = LazyIterableAdapterTest::anySatisfyWith;
            this.payloads.allSatisfy = LazyIterableAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = LazyIterableAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = LazyIterableAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = LazyIterableAdapterTest::noneSatisfyWith;
            this.payloads.count = LazyIterableAdapterTest::count;
            this.payloads.collectIf = LazyIterableAdapterTest::collectIf;
            this.payloads.collectIfWithTarget = LazyIterableAdapterTest::collectIfWithTarget;
            this.payloads.getFirst = LazyIterableAdapterTest::getFirst;
            this.payloads.getLast = LazyIterableAdapterTest::getLast;
            this.payloads.getOnly = LazyIterableAdapterTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = LazyIterableAdapterTest::isEmpty;
            this.payloads.injectInto = LazyIterableAdapterTest::injectInto;
            this.payloads.toList = LazyIterableAdapterTest::toList;
            this.payloads.toSortedListNaturalOrdering = LazyIterableAdapterTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = LazyIterableAdapterTest::toSortedList;
            this.payloads.toSortedListBy = LazyIterableAdapterTest::toSortedListBy;
            this.payloads.toSortedSet = LazyIterableAdapterTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = LazyIterableAdapterTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = LazyIterableAdapterTest::toSortedSetBy;
            this.payloads.toSet = LazyIterableAdapterTest::toSet;
            this.payloads.toMap = LazyIterableAdapterTest::toMap;
            this.payloads.toSortedMap = LazyIterableAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = LazyIterableAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = LazyIterableAdapterTest::toSortedMapBy;
            this.payloads.testToString = LazyIterableAdapterTest::testToString;
            this.payloads.makeString = LazyIterableAdapterTest::makeString;
            this.payloads.appendString = LazyIterableAdapterTest::appendString;
            this.payloads.groupBy = LazyIterableAdapterTest::groupBy;
            this.payloads.groupByEach = LazyIterableAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = LazyIterableAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = LazyIterableAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = LazyIterableAdapterTest::zip;
            this.payloads.zipWithIndex = LazyIterableAdapterTest::zipWithIndex;
            this.payloads.chunk = LazyIterableAdapterTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIterableAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = LazyIterableAdapterTest::chunk_large_size;
            this.payloads.tap = LazyIterableAdapterTest::tap;
            this.payloads.asLazy = LazyIterableAdapterTest::asLazy;
            this.payloads.flatCollect = LazyIterableAdapterTest::flatCollect;
            this.payloads.flatCollectWith = LazyIterableAdapterTest::flatCollectWith;
            this.payloads.forEach = LazyIterableAdapterTest::forEach;
            this.payloads.into = LazyIterableAdapterTest::into;
            this.payloads.forEachWithIndex = LazyIterableAdapterTest::forEachWithIndex;
            this.payloads.iterator = LazyIterableAdapterTest::iterator;
            this.payloads.forEachWith = LazyIterableAdapterTest::forEachWith;
            this.payloads.distinct = LazyIterableAdapterTest::distinct;
        }
    }
}
