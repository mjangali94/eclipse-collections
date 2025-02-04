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
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DropIterableTest extends AbstractLazyIterableTestCase {

    private DropIterable<Integer> dropIterable;

    private DropIterable<Integer> emptyListDropIterable;

    private DropIterable<Integer> zeroCountDropIterable;

    private DropIterable<Integer> nearCountDropIterable;

    private DropIterable<Integer> sameCountDropIterable;

    private DropIterable<Integer> higherCountDropIterable;

    @Before
    public void setUp() {
        this.dropIterable = new DropIterable<>(Interval.oneTo(5), 2);
        this.emptyListDropIterable = new DropIterable<>(FastList.newList(), 2);
        this.zeroCountDropIterable = new DropIterable<>(Interval.oneTo(5), 0);
        this.nearCountDropIterable = new DropIterable<>(Interval.oneTo(5), 4);
        this.sameCountDropIterable = new DropIterable<>(Interval.oneTo(5), 5);
        this.higherCountDropIterable = new DropIterable<>(Interval.oneTo(5), 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_throws() {
        new DropIterable<>(Interval.oneTo(5), -1);
    }

    @Test
    public void basic() {
        Assert.assertEquals(3, this.dropIterable.size());
        Assert.assertEquals(FastList.newListWith(3, 4, 5), this.dropIterable.toList());
        Assert.assertEquals(0, this.emptyListDropIterable.size());
        Assert.assertEquals(5, this.zeroCountDropIterable.size());
        Assert.assertEquals(1, this.nearCountDropIterable.size());
        Assert.assertEquals(0, this.sameCountDropIterable.size());
        Assert.assertEquals(0, this.higherCountDropIterable.size());
    }

    @Test
    public void forEach() {
        Sum sum1 = new IntegerSum(0);
        this.dropIterable.forEach(new SumProcedure<>(sum1));
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropIterable.forEach(new SumProcedure<>(sum2));
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.zeroCountDropIterable.forEach(new SumProcedure<>(sum3));
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.nearCountDropIterable.forEach(new SumProcedure<>(sum5));
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.sameCountDropIterable.forEach(new SumProcedure<>(sum6));
        Assert.assertEquals(0, sum6.getValue().intValue());
        Sum sum7 = new IntegerSum(0);
        this.higherCountDropIterable.forEach(new SumProcedure<>(sum7));
        Assert.assertEquals(0, sum7.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        Sum sum = new IntegerSum(0);
        FastList<Integer> indices = FastList.newList(5);
        ObjectIntProcedure<Integer> indexRecordingAndSumProcedure = (each, index) -> {
            indices.add(index);
            sum.add(each);
        };
        this.dropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2), indices);
        Assert.assertEquals(12, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.emptyListDropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.zeroCountDropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
        Assert.assertEquals(15, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.nearCountDropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0), indices);
        Assert.assertEquals(5, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.sameCountDropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.higherCountDropIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
    }

    @Test
    public void forEachWith() {
        Procedure2<Integer, Sum> sumAdditionProcedure = (each, sum) -> sum.add(each);
        Sum sum1 = new IntegerSum(0);
        this.dropIterable.forEachWith(sumAdditionProcedure, sum1);
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropIterable.forEachWith(sumAdditionProcedure, sum2);
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.zeroCountDropIterable.forEachWith(sumAdditionProcedure, sum3);
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.nearCountDropIterable.forEachWith(sumAdditionProcedure, sum5);
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.sameCountDropIterable.forEachWith(sumAdditionProcedure, sum6);
        Assert.assertEquals(0, sum6.getValue().intValue());
        Sum sum7 = new IntegerSum(0);
        this.higherCountDropIterable.forEachWith(sumAdditionProcedure, sum7);
        Assert.assertEquals(0, sum7.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        Sum sum1 = new IntegerSum(0);
        for (Integer each : this.dropIterable) {
            sum1.add(each);
        }
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        for (Integer each : this.emptyListDropIterable) {
            sum2.add(each);
        }
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        for (Integer each : this.zeroCountDropIterable) {
            sum3.add(each);
        }
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        for (Integer each : this.nearCountDropIterable) {
            sum5.add(each);
        }
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        for (Integer each : this.sameCountDropIterable) {
            sum6.add(each);
        }
        Assert.assertEquals(0, sum6.getValue().intValue());
        Sum sum7 = new IntegerSum(0);
        for (Integer each : this.higherCountDropIterable) {
            sum7.add(each);
        }
        Assert.assertEquals(0, sum7.getValue().intValue());
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.drop(FastList.newListWith(elements), 0);
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        Assert.assertEquals(FastList.newListWith(2, 3, 4, 5), new DropIterable<>(FastList.newListWith(1, 1, 2, 3, 3, 3, 4, 5), 2).distinct().toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DropIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> payload) throws java.lang.Throwable {
            this.instance = new DropIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> basic;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = DropIterableTest::toArray;
            this.payloads.contains = DropIterableTest::contains;
            this.payloads.containsAllIterable = DropIterableTest::containsAllIterable;
            this.payloads.containsAllArray = DropIterableTest::containsAllArray;
            this.payloads.select = DropIterableTest::select;
            this.payloads.selectWith = DropIterableTest::selectWith;
            this.payloads.selectWithTarget = DropIterableTest::selectWithTarget;
            this.payloads.reject = DropIterableTest::reject;
            this.payloads.rejectWith = DropIterableTest::rejectWith;
            this.payloads.rejectWithTarget = DropIterableTest::rejectWithTarget;
            this.payloads.partition = DropIterableTest::partition;
            this.payloads.partitionWith = DropIterableTest::partitionWith;
            this.payloads.selectInstancesOf = DropIterableTest::selectInstancesOf;
            this.payloads.collect = DropIterableTest::collect;
            this.payloads.collectBoolean = DropIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = DropIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = DropIterableTest::collectByte;
            this.payloads.collectByteWithTarget = DropIterableTest::collectByteWithTarget;
            this.payloads.collectChar = DropIterableTest::collectChar;
            this.payloads.collectCharWithTarget = DropIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = DropIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = DropIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = DropIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = DropIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = DropIterableTest::collectInt;
            this.payloads.collectIntWithTarget = DropIterableTest::collectIntWithTarget;
            this.payloads.collectLong = DropIterableTest::collectLong;
            this.payloads.collectLongWithTarget = DropIterableTest::collectLongWithTarget;
            this.payloads.collectShort = DropIterableTest::collectShort;
            this.payloads.collectShortWithTarget = DropIterableTest::collectShortWithTarget;
            this.payloads.collectWith = DropIterableTest::collectWith;
            this.payloads.collectWithTarget = DropIterableTest::collectWithTarget;
            this.payloads.take = DropIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = DropIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = DropIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = DropIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = DropIterableTest::detect;
            this.payloads.detectWith = DropIterableTest::detectWith;
            this.payloads.detectOptional = DropIterableTest::detectOptional;
            this.payloads.detectWithOptional = DropIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = DropIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = DropIterableTest::min;
            this.payloads.max = DropIterableTest::max;
            this.payloads.minBy = DropIterableTest::minBy;
            this.payloads.maxBy = DropIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = DropIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = DropIterableTest::max_without_comparator;
            this.payloads.detectIfNone = DropIterableTest::detectIfNone;
            this.payloads.anySatisfy = DropIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = DropIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = DropIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = DropIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = DropIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = DropIterableTest::noneSatisfyWith;
            this.payloads.count = DropIterableTest::count;
            this.payloads.collectIf = DropIterableTest::collectIf;
            this.payloads.collectIfWithTarget = DropIterableTest::collectIfWithTarget;
            this.payloads.getFirst = DropIterableTest::getFirst;
            this.payloads.getLast = DropIterableTest::getLast;
            this.payloads.getOnly = DropIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = DropIterableTest::isEmpty;
            this.payloads.injectInto = DropIterableTest::injectInto;
            this.payloads.toList = DropIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = DropIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = DropIterableTest::toSortedList;
            this.payloads.toSortedListBy = DropIterableTest::toSortedListBy;
            this.payloads.toSortedSet = DropIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = DropIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = DropIterableTest::toSortedSetBy;
            this.payloads.toSet = DropIterableTest::toSet;
            this.payloads.toMap = DropIterableTest::toMap;
            this.payloads.toSortedMap = DropIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = DropIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = DropIterableTest::toSortedMapBy;
            this.payloads.testToString = DropIterableTest::testToString;
            this.payloads.makeString = DropIterableTest::makeString;
            this.payloads.appendString = DropIterableTest::appendString;
            this.payloads.groupBy = DropIterableTest::groupBy;
            this.payloads.groupByEach = DropIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = DropIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = DropIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = DropIterableTest::zip;
            this.payloads.zipWithIndex = DropIterableTest::zipWithIndex;
            this.payloads.chunk = DropIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = DropIterableTest::chunk_large_size;
            this.payloads.tap = DropIterableTest::tap;
            this.payloads.asLazy = DropIterableTest::asLazy;
            this.payloads.flatCollect = DropIterableTest::flatCollect;
            this.payloads.flatCollectWith = DropIterableTest::flatCollectWith;
            this.payloads.negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropIterableTest::negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.basic = DropIterableTest::basic;
            this.payloads.forEach = DropIterableTest::forEach;
            this.payloads.forEachWithIndex = DropIterableTest::forEachWithIndex;
            this.payloads.forEachWith = DropIterableTest::forEachWith;
            this.payloads.iterator = DropIterableTest::iterator;
            this.payloads.distinct = DropIterableTest::distinct;
        }
    }
*/
}
