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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectIterableTest extends AbstractLazyIterableTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectIterableTest.class);

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.select(FastList.newListWith(elements), ignored -> true);
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new SelectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new SelectIterable<>(Interval.oneTo(5), Predicates.lessThan(2).or(Predicates.greaterThan(3)));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
            LOGGER.info("value={} index={}", object, index);
        });
        Assert.assertEquals(13, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new SelectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new SelectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> iterable = new SelectIterable<>(FastList.newListWith(5, 3, 2, 2, 4, 1, 3, 1, 5), Predicates.lessThan(5));
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1), iterable.distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = SelectIterableTest::toArray;
            this.payloads.contains = SelectIterableTest::contains;
            this.payloads.containsAllIterable = SelectIterableTest::containsAllIterable;
            this.payloads.containsAllArray = SelectIterableTest::containsAllArray;
            this.payloads.select = SelectIterableTest::select;
            this.payloads.selectWith = SelectIterableTest::selectWith;
            this.payloads.selectWithTarget = SelectIterableTest::selectWithTarget;
            this.payloads.reject = SelectIterableTest::reject;
            this.payloads.rejectWith = SelectIterableTest::rejectWith;
            this.payloads.rejectWithTarget = SelectIterableTest::rejectWithTarget;
            this.payloads.partition = SelectIterableTest::partition;
            this.payloads.partitionWith = SelectIterableTest::partitionWith;
            this.payloads.selectInstancesOf = SelectIterableTest::selectInstancesOf;
            this.payloads.collect = SelectIterableTest::collect;
            this.payloads.collectBoolean = SelectIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SelectIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = SelectIterableTest::collectByte;
            this.payloads.collectByteWithTarget = SelectIterableTest::collectByteWithTarget;
            this.payloads.collectChar = SelectIterableTest::collectChar;
            this.payloads.collectCharWithTarget = SelectIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = SelectIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SelectIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SelectIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = SelectIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = SelectIterableTest::collectInt;
            this.payloads.collectIntWithTarget = SelectIterableTest::collectIntWithTarget;
            this.payloads.collectLong = SelectIterableTest::collectLong;
            this.payloads.collectLongWithTarget = SelectIterableTest::collectLongWithTarget;
            this.payloads.collectShort = SelectIterableTest::collectShort;
            this.payloads.collectShortWithTarget = SelectIterableTest::collectShortWithTarget;
            this.payloads.collectWith = SelectIterableTest::collectWith;
            this.payloads.collectWithTarget = SelectIterableTest::collectWithTarget;
            this.payloads.take = SelectIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SelectIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = SelectIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = SelectIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = SelectIterableTest::detect;
            this.payloads.detectWith = SelectIterableTest::detectWith;
            this.payloads.detectOptional = SelectIterableTest::detectOptional;
            this.payloads.detectWithOptional = SelectIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = SelectIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SelectIterableTest::min;
            this.payloads.max = SelectIterableTest::max;
            this.payloads.minBy = SelectIterableTest::minBy;
            this.payloads.maxBy = SelectIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SelectIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = SelectIterableTest::max_without_comparator;
            this.payloads.detectIfNone = SelectIterableTest::detectIfNone;
            this.payloads.anySatisfy = SelectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = SelectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = SelectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = SelectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = SelectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SelectIterableTest::noneSatisfyWith;
            this.payloads.count = SelectIterableTest::count;
            this.payloads.collectIf = SelectIterableTest::collectIf;
            this.payloads.collectIfWithTarget = SelectIterableTest::collectIfWithTarget;
            this.payloads.getFirst = SelectIterableTest::getFirst;
            this.payloads.getLast = SelectIterableTest::getLast;
            this.payloads.getOnly = SelectIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SelectIterableTest::isEmpty;
            this.payloads.injectInto = SelectIterableTest::injectInto;
            this.payloads.toList = SelectIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = SelectIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = SelectIterableTest::toSortedList;
            this.payloads.toSortedListBy = SelectIterableTest::toSortedListBy;
            this.payloads.toSortedSet = SelectIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = SelectIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SelectIterableTest::toSortedSetBy;
            this.payloads.toSet = SelectIterableTest::toSet;
            this.payloads.toMap = SelectIterableTest::toMap;
            this.payloads.toSortedMap = SelectIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SelectIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SelectIterableTest::toSortedMapBy;
            this.payloads.testToString = SelectIterableTest::testToString;
            this.payloads.makeString = SelectIterableTest::makeString;
            this.payloads.appendString = SelectIterableTest::appendString;
            this.payloads.groupBy = SelectIterableTest::groupBy;
            this.payloads.groupByEach = SelectIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = SelectIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SelectIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = SelectIterableTest::zip;
            this.payloads.zipWithIndex = SelectIterableTest::zipWithIndex;
            this.payloads.chunk = SelectIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SelectIterableTest::chunk_large_size;
            this.payloads.tap = SelectIterableTest::tap;
            this.payloads.asLazy = SelectIterableTest::asLazy;
            this.payloads.flatCollect = SelectIterableTest::flatCollect;
            this.payloads.flatCollectWith = SelectIterableTest::flatCollectWith;
            this.payloads.forEach = SelectIterableTest::forEach;
            this.payloads.forEachWithIndex = SelectIterableTest::forEachWithIndex;
            this.payloads.iterator = SelectIterableTest::iterator;
            this.payloads.forEachWith = SelectIterableTest::forEachWith;
            this.payloads.distinct = SelectIterableTest::distinct;
        }
    }
}
