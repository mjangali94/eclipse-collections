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

public class TakeIterableTest extends AbstractLazyIterableTestCase {

    private TakeIterable<Integer> takeIterable;

    private TakeIterable<Integer> emptyListTakeIterable;

    private TakeIterable<Integer> zeroCountTakeIterable;

    private TakeIterable<Integer> sameCountTakeIterable;

    private TakeIterable<Integer> higherCountTakeIterable;

    @Before
    public void setUp() {
        this.takeIterable = new TakeIterable<>(Interval.oneTo(5), 2);
        this.emptyListTakeIterable = new TakeIterable<>(FastList.newList(), 2);
        this.zeroCountTakeIterable = new TakeIterable<>(Interval.oneTo(5), 0);
        this.sameCountTakeIterable = new TakeIterable<>(Interval.oneTo(5), 5);
        this.higherCountTakeIterable = new TakeIterable<>(Interval.oneTo(5), 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_throws() {
        new TakeIterable<>(Interval.oneTo(5), -1);
    }

    @Test
    public void basic() {
        Assert.assertEquals(2, this.takeIterable.size());
        Assert.assertEquals(FastList.newListWith(1, 2), this.takeIterable.toList());
        Assert.assertEquals(0, this.emptyListTakeIterable.size());
        Assert.assertEquals(0, this.zeroCountTakeIterable.size());
        Assert.assertEquals(5, this.higherCountTakeIterable.size());
        Assert.assertEquals(5, this.sameCountTakeIterable.size());
    }

    @Test
    public void forEach() {
        CountProcedure<Integer> cb1 = new CountProcedure<>();
        this.takeIterable.forEach(cb1);
        Assert.assertEquals(2, cb1.getCount());
        CountProcedure<Integer> cb2 = new CountProcedure<>();
        this.emptyListTakeIterable.forEach(cb2);
        Assert.assertEquals(0, cb2.getCount());
        CountProcedure<Integer> cb3 = new CountProcedure<>();
        this.zeroCountTakeIterable.forEach(cb3);
        Assert.assertEquals(0, cb3.getCount());
        CountProcedure<Integer> cb5 = new CountProcedure<>();
        this.sameCountTakeIterable.forEach(cb5);
        Assert.assertEquals(5, cb5.getCount());
        CountProcedure<Integer> cb6 = new CountProcedure<>();
        this.higherCountTakeIterable.forEach(cb6);
        Assert.assertEquals(5, cb6.getCount());
    }

    @Test
    public void forEachWithIndex() {
        FastList<Integer> indices = FastList.newList(5);
        ObjectIntProcedure<Integer> indexRecordingProcedure = (each, index) -> indices.add(index);
        this.takeIterable.forEachWithIndex(indexRecordingProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1), indices);
        indices.clear();
        this.emptyListTakeIterable.forEachWithIndex(indexRecordingProcedure);
        Verify.assertSize(0, indices);
        indices.clear();
        this.zeroCountTakeIterable.forEachWithIndex(indexRecordingProcedure);
        Verify.assertSize(0, indices);
        indices.clear();
        this.sameCountTakeIterable.forEachWithIndex(indexRecordingProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
        indices.clear();
        this.higherCountTakeIterable.forEachWithIndex(indexRecordingProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
    }

    @Test
    public void forEachWith() {
        Procedure2<Integer, Sum> sumAdditionProcedure = (each, sum) -> sum.add(each);
        Sum sum1 = new IntegerSum(0);
        this.takeIterable.forEachWith(sumAdditionProcedure, sum1);
        Assert.assertEquals(3, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListTakeIterable.forEachWith(sumAdditionProcedure, sum2);
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.zeroCountTakeIterable.forEachWith(sumAdditionProcedure, sum3);
        Assert.assertEquals(0, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.sameCountTakeIterable.forEachWith(sumAdditionProcedure, sum5);
        Assert.assertEquals(15, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.higherCountTakeIterable.forEachWith(sumAdditionProcedure, sum6);
        Assert.assertEquals(15, sum6.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        Sum sum1 = new IntegerSum(0);
        for (Integer each : this.takeIterable) {
            sum1.add(each);
        }
        Assert.assertEquals(3, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        for (Integer each : this.emptyListTakeIterable) {
            sum2.add(each);
        }
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        for (Integer each : this.zeroCountTakeIterable) {
            sum3.add(each);
        }
        Assert.assertEquals(0, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        for (Integer each : this.sameCountTakeIterable) {
            sum5.add(each);
        }
        Assert.assertEquals(15, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        for (Integer each : this.higherCountTakeIterable) {
            sum6.add(each);
        }
        Assert.assertEquals(15, sum6.getValue().intValue());
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.take(FastList.newListWith(elements), elements.length);
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1), new TakeIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), 7).distinct().toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TakeIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile_null_throws);
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
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListNaturalOrdering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListNaturalOrdering);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
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
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basic() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basic);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TakeIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> basic;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TakeIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = TakeIterableTest::toArray;
            this.payloads.contains = TakeIterableTest::contains;
            this.payloads.containsAllIterable = TakeIterableTest::containsAllIterable;
            this.payloads.containsAllArray = TakeIterableTest::containsAllArray;
            this.payloads.select = TakeIterableTest::select;
            this.payloads.selectWith = TakeIterableTest::selectWith;
            this.payloads.selectWithTarget = TakeIterableTest::selectWithTarget;
            this.payloads.reject = TakeIterableTest::reject;
            this.payloads.rejectWith = TakeIterableTest::rejectWith;
            this.payloads.rejectWithTarget = TakeIterableTest::rejectWithTarget;
            this.payloads.partition = TakeIterableTest::partition;
            this.payloads.partitionWith = TakeIterableTest::partitionWith;
            this.payloads.selectInstancesOf = TakeIterableTest::selectInstancesOf;
            this.payloads.collect = TakeIterableTest::collect;
            this.payloads.collectBoolean = TakeIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = TakeIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = TakeIterableTest::collectByte;
            this.payloads.collectByteWithTarget = TakeIterableTest::collectByteWithTarget;
            this.payloads.collectChar = TakeIterableTest::collectChar;
            this.payloads.collectCharWithTarget = TakeIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = TakeIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = TakeIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = TakeIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = TakeIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = TakeIterableTest::collectInt;
            this.payloads.collectIntWithTarget = TakeIterableTest::collectIntWithTarget;
            this.payloads.collectLong = TakeIterableTest::collectLong;
            this.payloads.collectLongWithTarget = TakeIterableTest::collectLongWithTarget;
            this.payloads.collectShort = TakeIterableTest::collectShort;
            this.payloads.collectShortWithTarget = TakeIterableTest::collectShortWithTarget;
            this.payloads.collectWith = TakeIterableTest::collectWith;
            this.payloads.collectWithTarget = TakeIterableTest::collectWithTarget;
            this.payloads.take = TakeIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TakeIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = TakeIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = TakeIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = TakeIterableTest::detect;
            this.payloads.detectWith = TakeIterableTest::detectWith;
            this.payloads.detectOptional = TakeIterableTest::detectOptional;
            this.payloads.detectWithOptional = TakeIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = TakeIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = TakeIterableTest::min;
            this.payloads.max = TakeIterableTest::max;
            this.payloads.minBy = TakeIterableTest::minBy;
            this.payloads.maxBy = TakeIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = TakeIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = TakeIterableTest::max_without_comparator;
            this.payloads.detectIfNone = TakeIterableTest::detectIfNone;
            this.payloads.anySatisfy = TakeIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = TakeIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = TakeIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = TakeIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = TakeIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TakeIterableTest::noneSatisfyWith;
            this.payloads.count = TakeIterableTest::count;
            this.payloads.collectIf = TakeIterableTest::collectIf;
            this.payloads.collectIfWithTarget = TakeIterableTest::collectIfWithTarget;
            this.payloads.getFirst = TakeIterableTest::getFirst;
            this.payloads.getLast = TakeIterableTest::getLast;
            this.payloads.getOnly = TakeIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = TakeIterableTest::isEmpty;
            this.payloads.injectInto = TakeIterableTest::injectInto;
            this.payloads.toList = TakeIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = TakeIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = TakeIterableTest::toSortedList;
            this.payloads.toSortedListBy = TakeIterableTest::toSortedListBy;
            this.payloads.toSortedSet = TakeIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = TakeIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = TakeIterableTest::toSortedSetBy;
            this.payloads.toSet = TakeIterableTest::toSet;
            this.payloads.toMap = TakeIterableTest::toMap;
            this.payloads.toSortedMap = TakeIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = TakeIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = TakeIterableTest::toSortedMapBy;
            this.payloads.testToString = TakeIterableTest::testToString;
            this.payloads.makeString = TakeIterableTest::makeString;
            this.payloads.appendString = TakeIterableTest::appendString;
            this.payloads.groupBy = TakeIterableTest::groupBy;
            this.payloads.groupByEach = TakeIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = TakeIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TakeIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = TakeIterableTest::zip;
            this.payloads.zipWithIndex = TakeIterableTest::zipWithIndex;
            this.payloads.chunk = TakeIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TakeIterableTest::chunk_large_size;
            this.payloads.tap = TakeIterableTest::tap;
            this.payloads.asLazy = TakeIterableTest::asLazy;
            this.payloads.flatCollect = TakeIterableTest::flatCollect;
            this.payloads.flatCollectWith = TakeIterableTest::flatCollectWith;
            this.payloads.negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TakeIterableTest::negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.basic = TakeIterableTest::basic;
            this.payloads.forEach = TakeIterableTest::forEach;
            this.payloads.forEachWithIndex = TakeIterableTest::forEachWithIndex;
            this.payloads.forEachWith = TakeIterableTest::forEachWith;
            this.payloads.iterator = TakeIterableTest::iterator;
            this.payloads.distinct = TakeIterableTest::distinct;
        }
    }
*/
}
