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
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.procedure.CountProcedure;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TakeWhileIterableTest extends AbstractLazyIterableTestCase {

    private TakeWhileIterable<Integer> takeWhileIterable;

    private TakeWhileIterable<Integer> emptyListTakeWhileIterable;

    private TakeWhileIterable<Integer> alwaysFalseTakeWhileIterable;

    private TakeWhileIterable<Integer> alwaysTrueTakeWhileIterable;

    @Before
    public void setUp() {
        this.takeWhileIterable = new TakeWhileIterable<>(Interval.oneTo(5), each -> each <= 2);
        this.emptyListTakeWhileIterable = new TakeWhileIterable<>(FastList.newList(), each -> each <= 2);
        this.alwaysFalseTakeWhileIterable = new TakeWhileIterable<>(Interval.oneTo(5), Predicates.alwaysFalse());
        this.alwaysTrueTakeWhileIterable = new TakeWhileIterable<>(Interval.oneTo(5), Predicates.alwaysTrue());
    }

    @Test
    public void basic() {
        Assert.assertEquals(2, this.takeWhileIterable.size());
        Assert.assertEquals(FastList.newListWith(1, 2), this.takeWhileIterable.toList());
        Assert.assertEquals(0, this.emptyListTakeWhileIterable.size());
        Assert.assertEquals(0, this.alwaysFalseTakeWhileIterable.size());
        Assert.assertEquals(5, this.alwaysTrueTakeWhileIterable.size());
    }

    @Test
    public void forEach() {
        CountProcedure<Integer> cb1 = new CountProcedure<>();
        this.takeWhileIterable.forEach(cb1);
        Assert.assertEquals(2, cb1.getCount());
        CountProcedure<Integer> cb2 = new CountProcedure<>();
        this.emptyListTakeWhileIterable.forEach(cb2);
        Assert.assertEquals(0, cb2.getCount());
        CountProcedure<Integer> cb3 = new CountProcedure<>();
        this.alwaysFalseTakeWhileIterable.forEach(cb3);
        Assert.assertEquals(0, cb3.getCount());
        CountProcedure<Integer> cb5 = new CountProcedure<>();
        this.alwaysTrueTakeWhileIterable.forEach(cb5);
        Assert.assertEquals(5, cb5.getCount());
    }

    @Test
    public void forEachWithIndex() {
        FastList<Integer> indices = FastList.newList(5);
        ObjectIntProcedure<Integer> indexRecordingProcedure = (each, index) -> indices.add(index);
        this.takeWhileIterable.forEachWithIndex(indexRecordingProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1), indices);
        indices.clear();
        this.emptyListTakeWhileIterable.forEachWithIndex(indexRecordingProcedure);
        Verify.assertSize(0, indices);
        indices.clear();
        this.alwaysFalseTakeWhileIterable.forEachWithIndex(indexRecordingProcedure);
        Verify.assertSize(0, indices);
        indices.clear();
        this.alwaysTrueTakeWhileIterable.forEachWithIndex(indexRecordingProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
    }

    @Test
    public void forEachWith() {
        Procedure2<Integer, Sum> sumAdditionProcedure = (each, sum) -> sum.add(each);
        Sum sum1 = new IntegerSum(0);
        this.takeWhileIterable.forEachWith(sumAdditionProcedure, sum1);
        Assert.assertEquals(3, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListTakeWhileIterable.forEachWith(sumAdditionProcedure, sum2);
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.alwaysFalseTakeWhileIterable.forEachWith(sumAdditionProcedure, sum3);
        Assert.assertEquals(0, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.alwaysTrueTakeWhileIterable.forEachWith(sumAdditionProcedure, sum5);
        Assert.assertEquals(15, sum5.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        Sum sum1 = new IntegerSum(0);
        for (Integer each : this.takeWhileIterable) {
            sum1.add(each);
        }
        Assert.assertEquals(3, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        for (Integer each : this.emptyListTakeWhileIterable) {
            sum2.add(each);
        }
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        for (Integer each : this.alwaysFalseTakeWhileIterable) {
            sum3.add(each);
        }
        Assert.assertEquals(0, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        for (Integer each : this.alwaysTrueTakeWhileIterable) {
            sum5.add(each);
        }
        Assert.assertEquals(15, sum5.getValue().intValue());
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.takeWhile(FastList.newListWith(elements), Predicates.alwaysTrue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1), new TakeWhileIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), each -> each < 5).distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TakeWhileIterableTest instance;

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
        public void benchmark_basic() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basic);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TakeWhileIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> basic;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeWhileIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = TakeWhileIterableTest::toArray;
            this.payloads.contains = TakeWhileIterableTest::contains;
            this.payloads.containsAllIterable = TakeWhileIterableTest::containsAllIterable;
            this.payloads.containsAllArray = TakeWhileIterableTest::containsAllArray;
            this.payloads.select = TakeWhileIterableTest::select;
            this.payloads.selectWith = TakeWhileIterableTest::selectWith;
            this.payloads.selectWithTarget = TakeWhileIterableTest::selectWithTarget;
            this.payloads.reject = TakeWhileIterableTest::reject;
            this.payloads.rejectWith = TakeWhileIterableTest::rejectWith;
            this.payloads.rejectWithTarget = TakeWhileIterableTest::rejectWithTarget;
            this.payloads.partition = TakeWhileIterableTest::partition;
            this.payloads.partitionWith = TakeWhileIterableTest::partitionWith;
            this.payloads.selectInstancesOf = TakeWhileIterableTest::selectInstancesOf;
            this.payloads.collect = TakeWhileIterableTest::collect;
            this.payloads.collectBoolean = TakeWhileIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = TakeWhileIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = TakeWhileIterableTest::collectByte;
            this.payloads.collectByteWithTarget = TakeWhileIterableTest::collectByteWithTarget;
            this.payloads.collectChar = TakeWhileIterableTest::collectChar;
            this.payloads.collectCharWithTarget = TakeWhileIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = TakeWhileIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = TakeWhileIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = TakeWhileIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = TakeWhileIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = TakeWhileIterableTest::collectInt;
            this.payloads.collectIntWithTarget = TakeWhileIterableTest::collectIntWithTarget;
            this.payloads.collectLong = TakeWhileIterableTest::collectLong;
            this.payloads.collectLongWithTarget = TakeWhileIterableTest::collectLongWithTarget;
            this.payloads.collectShort = TakeWhileIterableTest::collectShort;
            this.payloads.collectShortWithTarget = TakeWhileIterableTest::collectShortWithTarget;
            this.payloads.collectWith = TakeWhileIterableTest::collectWith;
            this.payloads.collectWithTarget = TakeWhileIterableTest::collectWithTarget;
            this.payloads.take = TakeWhileIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TakeWhileIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = TakeWhileIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = TakeWhileIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = TakeWhileIterableTest::detect;
            this.payloads.detectWith = TakeWhileIterableTest::detectWith;
            this.payloads.detectOptional = TakeWhileIterableTest::detectOptional;
            this.payloads.detectWithOptional = TakeWhileIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = TakeWhileIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = TakeWhileIterableTest::min;
            this.payloads.max = TakeWhileIterableTest::max;
            this.payloads.minBy = TakeWhileIterableTest::minBy;
            this.payloads.maxBy = TakeWhileIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = TakeWhileIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = TakeWhileIterableTest::max_without_comparator;
            this.payloads.detectIfNone = TakeWhileIterableTest::detectIfNone;
            this.payloads.anySatisfy = TakeWhileIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = TakeWhileIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = TakeWhileIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = TakeWhileIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = TakeWhileIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TakeWhileIterableTest::noneSatisfyWith;
            this.payloads.count = TakeWhileIterableTest::count;
            this.payloads.collectIf = TakeWhileIterableTest::collectIf;
            this.payloads.collectIfWithTarget = TakeWhileIterableTest::collectIfWithTarget;
            this.payloads.getFirst = TakeWhileIterableTest::getFirst;
            this.payloads.getLast = TakeWhileIterableTest::getLast;
            this.payloads.getOnly = TakeWhileIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = TakeWhileIterableTest::isEmpty;
            this.payloads.injectInto = TakeWhileIterableTest::injectInto;
            this.payloads.toList = TakeWhileIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = TakeWhileIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = TakeWhileIterableTest::toSortedList;
            this.payloads.toSortedListBy = TakeWhileIterableTest::toSortedListBy;
            this.payloads.toSortedSet = TakeWhileIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = TakeWhileIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = TakeWhileIterableTest::toSortedSetBy;
            this.payloads.toSet = TakeWhileIterableTest::toSet;
            this.payloads.toMap = TakeWhileIterableTest::toMap;
            this.payloads.toSortedMap = TakeWhileIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = TakeWhileIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = TakeWhileIterableTest::toSortedMapBy;
            this.payloads.testToString = TakeWhileIterableTest::testToString;
            this.payloads.makeString = TakeWhileIterableTest::makeString;
            this.payloads.appendString = TakeWhileIterableTest::appendString;
            this.payloads.groupBy = TakeWhileIterableTest::groupBy;
            this.payloads.groupByEach = TakeWhileIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = TakeWhileIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TakeWhileIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = TakeWhileIterableTest::zip;
            this.payloads.zipWithIndex = TakeWhileIterableTest::zipWithIndex;
            this.payloads.chunk = TakeWhileIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeWhileIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TakeWhileIterableTest::chunk_large_size;
            this.payloads.tap = TakeWhileIterableTest::tap;
            this.payloads.asLazy = TakeWhileIterableTest::asLazy;
            this.payloads.flatCollect = TakeWhileIterableTest::flatCollect;
            this.payloads.flatCollectWith = TakeWhileIterableTest::flatCollectWith;
            this.payloads.basic = TakeWhileIterableTest::basic;
            this.payloads.forEach = TakeWhileIterableTest::forEach;
            this.payloads.forEachWithIndex = TakeWhileIterableTest::forEachWithIndex;
            this.payloads.forEachWith = TakeWhileIterableTest::forEachWith;
            this.payloads.iterator = TakeWhileIterableTest::iterator;
            this.payloads.distinct = TakeWhileIterableTest::distinct;
        }
    }
}
