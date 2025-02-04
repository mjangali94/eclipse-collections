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
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DropWhileIterableTest extends AbstractLazyIterableTestCase {

    private DropWhileIterable<Integer> dropWhileIterable;

    private DropWhileIterable<Integer> emptyListDropWhileIterable;

    private DropWhileIterable<Integer> alwaysFalseDropWhileIterable;

    private DropWhileIterable<Integer> mostlyFalseDropWhileIterable;

    private DropWhileIterable<Integer> alwaysTrueDropWhileIterable;

    @Before
    public void setUp() {
        this.dropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), each -> each <= 2);
        this.emptyListDropWhileIterable = new DropWhileIterable<>(FastList.newList(), each -> each <= 2);
        this.alwaysFalseDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), Predicates.alwaysFalse());
        this.mostlyFalseDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), each -> each <= 4);
        this.alwaysTrueDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), Predicates.alwaysTrue());
    }

    @Test
    public void basic() {
        Assert.assertEquals(3, this.dropWhileIterable.size());
        Assert.assertEquals(FastList.newListWith(3, 4, 5), this.dropWhileIterable.toList());
        Assert.assertEquals(0, this.emptyListDropWhileIterable.size());
        Assert.assertEquals(5, this.alwaysFalseDropWhileIterable.size());
        Assert.assertEquals(1, this.mostlyFalseDropWhileIterable.size());
        Assert.assertEquals(0, this.alwaysTrueDropWhileIterable.size());
    }

    @Test
    public void forEach() {
        Sum sum1 = new IntegerSum(0);
        this.dropWhileIterable.forEach(new SumProcedure<>(sum1));
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropWhileIterable.forEach(new SumProcedure<>(sum2));
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.alwaysFalseDropWhileIterable.forEach(new SumProcedure<>(sum3));
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.mostlyFalseDropWhileIterable.forEach(new SumProcedure<>(sum5));
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.alwaysTrueDropWhileIterable.forEach(new SumProcedure<>(sum6));
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        Sum sum = new IntegerSum(0);
        FastList<Integer> indices = FastList.newList(5);
        ObjectIntProcedure<Integer> indexRecordingAndSumProcedure = (each, index) -> {
            indices.add(index);
            sum.add(each);
        };
        this.dropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2), indices);
        Assert.assertEquals(12, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.emptyListDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.alwaysFalseDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
        Assert.assertEquals(15, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.mostlyFalseDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0), indices);
        Assert.assertEquals(5, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.alwaysTrueDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
    }

    @Test
    public void forEachWith() {
        Procedure2<Integer, Sum> sumAdditionProcedure = (each, sum) -> sum.add(each);
        Sum sum1 = new IntegerSum(0);
        this.dropWhileIterable.forEachWith(sumAdditionProcedure, sum1);
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropWhileIterable.forEachWith(sumAdditionProcedure, sum2);
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.alwaysFalseDropWhileIterable.forEachWith(sumAdditionProcedure, sum3);
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.mostlyFalseDropWhileIterable.forEachWith(sumAdditionProcedure, sum5);
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.alwaysTrueDropWhileIterable.forEachWith(sumAdditionProcedure, sum6);
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        Sum sum1 = new IntegerSum(0);
        for (Integer each : this.dropWhileIterable) {
            sum1.add(each);
        }
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        for (Integer each : this.emptyListDropWhileIterable) {
            sum2.add(each);
        }
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        for (Integer each : this.alwaysFalseDropWhileIterable) {
            sum3.add(each);
        }
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        for (Integer each : this.mostlyFalseDropWhileIterable) {
            sum5.add(each);
        }
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        for (Integer each : this.alwaysTrueDropWhileIterable) {
            sum6.add(each);
        }
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.dropWhile(FastList.newListWith(elements), Predicates.alwaysFalse());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        Assert.assertEquals(FastList.newListWith(2, 3, 4, 5), new DropWhileIterable<>(FastList.newListWith(1, 1, 2, 3, 3, 3, 4, 5), each -> each % 2 != 0).distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DropWhileIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> payload) throws java.lang.Throwable {
            this.instance = new DropWhileIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> basic;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DropWhileIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = DropWhileIterableTest::toArray;
            this.payloads.contains = DropWhileIterableTest::contains;
            this.payloads.containsAllIterable = DropWhileIterableTest::containsAllIterable;
            this.payloads.containsAllArray = DropWhileIterableTest::containsAllArray;
            this.payloads.select = DropWhileIterableTest::select;
            this.payloads.selectWith = DropWhileIterableTest::selectWith;
            this.payloads.selectWithTarget = DropWhileIterableTest::selectWithTarget;
            this.payloads.reject = DropWhileIterableTest::reject;
            this.payloads.rejectWith = DropWhileIterableTest::rejectWith;
            this.payloads.rejectWithTarget = DropWhileIterableTest::rejectWithTarget;
            this.payloads.partition = DropWhileIterableTest::partition;
            this.payloads.partitionWith = DropWhileIterableTest::partitionWith;
            this.payloads.selectInstancesOf = DropWhileIterableTest::selectInstancesOf;
            this.payloads.collect = DropWhileIterableTest::collect;
            this.payloads.collectBoolean = DropWhileIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = DropWhileIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = DropWhileIterableTest::collectByte;
            this.payloads.collectByteWithTarget = DropWhileIterableTest::collectByteWithTarget;
            this.payloads.collectChar = DropWhileIterableTest::collectChar;
            this.payloads.collectCharWithTarget = DropWhileIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = DropWhileIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = DropWhileIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = DropWhileIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = DropWhileIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = DropWhileIterableTest::collectInt;
            this.payloads.collectIntWithTarget = DropWhileIterableTest::collectIntWithTarget;
            this.payloads.collectLong = DropWhileIterableTest::collectLong;
            this.payloads.collectLongWithTarget = DropWhileIterableTest::collectLongWithTarget;
            this.payloads.collectShort = DropWhileIterableTest::collectShort;
            this.payloads.collectShortWithTarget = DropWhileIterableTest::collectShortWithTarget;
            this.payloads.collectWith = DropWhileIterableTest::collectWith;
            this.payloads.collectWithTarget = DropWhileIterableTest::collectWithTarget;
            this.payloads.take = DropWhileIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = DropWhileIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = DropWhileIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = DropWhileIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = DropWhileIterableTest::detect;
            this.payloads.detectWith = DropWhileIterableTest::detectWith;
            this.payloads.detectOptional = DropWhileIterableTest::detectOptional;
            this.payloads.detectWithOptional = DropWhileIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = DropWhileIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = DropWhileIterableTest::min;
            this.payloads.max = DropWhileIterableTest::max;
            this.payloads.minBy = DropWhileIterableTest::minBy;
            this.payloads.maxBy = DropWhileIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = DropWhileIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = DropWhileIterableTest::max_without_comparator;
            this.payloads.detectIfNone = DropWhileIterableTest::detectIfNone;
            this.payloads.anySatisfy = DropWhileIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = DropWhileIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = DropWhileIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = DropWhileIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = DropWhileIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = DropWhileIterableTest::noneSatisfyWith;
            this.payloads.count = DropWhileIterableTest::count;
            this.payloads.collectIf = DropWhileIterableTest::collectIf;
            this.payloads.collectIfWithTarget = DropWhileIterableTest::collectIfWithTarget;
            this.payloads.getFirst = DropWhileIterableTest::getFirst;
            this.payloads.getLast = DropWhileIterableTest::getLast;
            this.payloads.getOnly = DropWhileIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = DropWhileIterableTest::isEmpty;
            this.payloads.injectInto = DropWhileIterableTest::injectInto;
            this.payloads.toList = DropWhileIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = DropWhileIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = DropWhileIterableTest::toSortedList;
            this.payloads.toSortedListBy = DropWhileIterableTest::toSortedListBy;
            this.payloads.toSortedSet = DropWhileIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = DropWhileIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = DropWhileIterableTest::toSortedSetBy;
            this.payloads.toSet = DropWhileIterableTest::toSet;
            this.payloads.toMap = DropWhileIterableTest::toMap;
            this.payloads.toSortedMap = DropWhileIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = DropWhileIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = DropWhileIterableTest::toSortedMapBy;
            this.payloads.testToString = DropWhileIterableTest::testToString;
            this.payloads.makeString = DropWhileIterableTest::makeString;
            this.payloads.appendString = DropWhileIterableTest::appendString;
            this.payloads.groupBy = DropWhileIterableTest::groupBy;
            this.payloads.groupByEach = DropWhileIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = DropWhileIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = DropWhileIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = DropWhileIterableTest::zip;
            this.payloads.zipWithIndex = DropWhileIterableTest::zipWithIndex;
            this.payloads.chunk = DropWhileIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DropWhileIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = DropWhileIterableTest::chunk_large_size;
            this.payloads.tap = DropWhileIterableTest::tap;
            this.payloads.asLazy = DropWhileIterableTest::asLazy;
            this.payloads.flatCollect = DropWhileIterableTest::flatCollect;
            this.payloads.flatCollectWith = DropWhileIterableTest::flatCollectWith;
            this.payloads.basic = DropWhileIterableTest::basic;
            this.payloads.forEach = DropWhileIterableTest::forEach;
            this.payloads.forEachWithIndex = DropWhileIterableTest::forEachWithIndex;
            this.payloads.forEachWith = DropWhileIterableTest::forEachWith;
            this.payloads.iterator = DropWhileIterableTest::iterator;
            this.payloads.distinct = DropWhileIterableTest::distinct;
        }
    }
}
