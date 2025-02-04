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
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectInstancesOfIterableTest extends AbstractLazyIterableTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectInstancesOfIterableTest.class);

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return (LazyIterable<T>) LazyIterate.selectInstancesOf(FastList.newListWith(elements), Object.class);
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new SelectInstancesOfIterable<>(FastList.newListWith(1, 2.0, 3, 4.0, 5), Integer.class);
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(9, sum.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new SelectInstancesOfIterable<>(FastList.newListWith(1, 2.0, 3, 4.0, 5), Integer.class);
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
            LOGGER.info("value={} index={}", object, index);
        });
        Assert.assertEquals(12, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new SelectInstancesOfIterable<>(FastList.newListWith(1, 2.0, 3, 4.0, 5), Integer.class);
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(9, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new SelectInstancesOfIterable<>(FastList.newListWith(1, 2.0, 3, 4.0, 5), Integer.class);
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(9, sum.getValue().intValue());
    }

    @Override
    @Test
    public void min_null_throws() {
        // Impossible for SelectInstancesOfIterable to contain null
        super.min_null_throws();
    }

    @Override
    @Test
    public void max_null_throws() {
        // Impossible for SelectInstancesOfIterable to contain null
        super.max_null_throws();
    }

    @Override
    @Test
    public void min_null_throws_without_comparator() {
        // Impossible for SelectInstancesOfIterable to contain null
        super.min_null_throws_without_comparator();
    }

    @Override
    @Test
    public void max_null_throws_without_comparator() {
        // Impossible for SelectInstancesOfIterable to contain null
        super.max_null_throws_without_comparator();
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Double> iterable = new SelectInstancesOfIterable<>(FastList.newListWith(3.0, 2.0, 3, 2.0, 4.0, 5, 1.0, 3.0, 1.0, 5.0), Double.class);
        Assert.assertEquals(FastList.newListWith(3.0, 2.0, 4.0, 1.0, 5.0), iterable.distinct().toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectInstancesOfIterableTest instance;

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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectInstancesOfIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = SelectInstancesOfIterableTest::toArray;
            this.payloads.contains = SelectInstancesOfIterableTest::contains;
            this.payloads.containsAllIterable = SelectInstancesOfIterableTest::containsAllIterable;
            this.payloads.containsAllArray = SelectInstancesOfIterableTest::containsAllArray;
            this.payloads.select = SelectInstancesOfIterableTest::select;
            this.payloads.selectWith = SelectInstancesOfIterableTest::selectWith;
            this.payloads.selectWithTarget = SelectInstancesOfIterableTest::selectWithTarget;
            this.payloads.reject = SelectInstancesOfIterableTest::reject;
            this.payloads.rejectWith = SelectInstancesOfIterableTest::rejectWith;
            this.payloads.rejectWithTarget = SelectInstancesOfIterableTest::rejectWithTarget;
            this.payloads.partition = SelectInstancesOfIterableTest::partition;
            this.payloads.partitionWith = SelectInstancesOfIterableTest::partitionWith;
            this.payloads.selectInstancesOf = SelectInstancesOfIterableTest::selectInstancesOf;
            this.payloads.collect = SelectInstancesOfIterableTest::collect;
            this.payloads.collectBoolean = SelectInstancesOfIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SelectInstancesOfIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = SelectInstancesOfIterableTest::collectByte;
            this.payloads.collectByteWithTarget = SelectInstancesOfIterableTest::collectByteWithTarget;
            this.payloads.collectChar = SelectInstancesOfIterableTest::collectChar;
            this.payloads.collectCharWithTarget = SelectInstancesOfIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = SelectInstancesOfIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SelectInstancesOfIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SelectInstancesOfIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = SelectInstancesOfIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = SelectInstancesOfIterableTest::collectInt;
            this.payloads.collectIntWithTarget = SelectInstancesOfIterableTest::collectIntWithTarget;
            this.payloads.collectLong = SelectInstancesOfIterableTest::collectLong;
            this.payloads.collectLongWithTarget = SelectInstancesOfIterableTest::collectLongWithTarget;
            this.payloads.collectShort = SelectInstancesOfIterableTest::collectShort;
            this.payloads.collectShortWithTarget = SelectInstancesOfIterableTest::collectShortWithTarget;
            this.payloads.collectWith = SelectInstancesOfIterableTest::collectWith;
            this.payloads.collectWithTarget = SelectInstancesOfIterableTest::collectWithTarget;
            this.payloads.take = SelectInstancesOfIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SelectInstancesOfIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = SelectInstancesOfIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = SelectInstancesOfIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = SelectInstancesOfIterableTest::detect;
            this.payloads.detectWith = SelectInstancesOfIterableTest::detectWith;
            this.payloads.detectOptional = SelectInstancesOfIterableTest::detectOptional;
            this.payloads.detectWithOptional = SelectInstancesOfIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = SelectInstancesOfIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = SelectInstancesOfIterableTest::min;
            this.payloads.max = SelectInstancesOfIterableTest::max;
            this.payloads.minBy = SelectInstancesOfIterableTest::minBy;
            this.payloads.maxBy = SelectInstancesOfIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = SelectInstancesOfIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = SelectInstancesOfIterableTest::max_without_comparator;
            this.payloads.detectIfNone = SelectInstancesOfIterableTest::detectIfNone;
            this.payloads.anySatisfy = SelectInstancesOfIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = SelectInstancesOfIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = SelectInstancesOfIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = SelectInstancesOfIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = SelectInstancesOfIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SelectInstancesOfIterableTest::noneSatisfyWith;
            this.payloads.count = SelectInstancesOfIterableTest::count;
            this.payloads.collectIf = SelectInstancesOfIterableTest::collectIf;
            this.payloads.collectIfWithTarget = SelectInstancesOfIterableTest::collectIfWithTarget;
            this.payloads.getFirst = SelectInstancesOfIterableTest::getFirst;
            this.payloads.getLast = SelectInstancesOfIterableTest::getLast;
            this.payloads.getOnly = SelectInstancesOfIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SelectInstancesOfIterableTest::isEmpty;
            this.payloads.injectInto = SelectInstancesOfIterableTest::injectInto;
            this.payloads.toList = SelectInstancesOfIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = SelectInstancesOfIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = SelectInstancesOfIterableTest::toSortedList;
            this.payloads.toSortedListBy = SelectInstancesOfIterableTest::toSortedListBy;
            this.payloads.toSortedSet = SelectInstancesOfIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = SelectInstancesOfIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SelectInstancesOfIterableTest::toSortedSetBy;
            this.payloads.toSet = SelectInstancesOfIterableTest::toSet;
            this.payloads.toMap = SelectInstancesOfIterableTest::toMap;
            this.payloads.toSortedMap = SelectInstancesOfIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SelectInstancesOfIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SelectInstancesOfIterableTest::toSortedMapBy;
            this.payloads.testToString = SelectInstancesOfIterableTest::testToString;
            this.payloads.makeString = SelectInstancesOfIterableTest::makeString;
            this.payloads.appendString = SelectInstancesOfIterableTest::appendString;
            this.payloads.groupBy = SelectInstancesOfIterableTest::groupBy;
            this.payloads.groupByEach = SelectInstancesOfIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = SelectInstancesOfIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SelectInstancesOfIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = SelectInstancesOfIterableTest::zip;
            this.payloads.zipWithIndex = SelectInstancesOfIterableTest::zipWithIndex;
            this.payloads.chunk = SelectInstancesOfIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectInstancesOfIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SelectInstancesOfIterableTest::chunk_large_size;
            this.payloads.tap = SelectInstancesOfIterableTest::tap;
            this.payloads.asLazy = SelectInstancesOfIterableTest::asLazy;
            this.payloads.flatCollect = SelectInstancesOfIterableTest::flatCollect;
            this.payloads.flatCollectWith = SelectInstancesOfIterableTest::flatCollectWith;
            this.payloads.forEach = SelectInstancesOfIterableTest::forEach;
            this.payloads.forEachWithIndex = SelectInstancesOfIterableTest::forEachWithIndex;
            this.payloads.iterator = SelectInstancesOfIterableTest::iterator;
            this.payloads.forEachWith = SelectInstancesOfIterableTest::forEachWith;
            this.payloads.min_null_throws = SelectInstancesOfIterableTest::min_null_throws;
            this.payloads.max_null_throws = SelectInstancesOfIterableTest::max_null_throws;
            this.payloads.min_null_throws_without_comparator = SelectInstancesOfIterableTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = SelectInstancesOfIterableTest::max_null_throws_without_comparator;
            this.payloads.distinct = SelectInstancesOfIterableTest::distinct;
        }
    }
*/
}
