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

public class FlatCollectIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.flatCollect(FastList.newListWith(elements), FastList::newListWith);
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new FlatCollectIterable<>(Interval.oneTo(5), Interval::oneTo);
        Appendable builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("112123123412345", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new FlatCollectIterable<>(Interval.oneTo(5), Interval::oneTo);
        StringBuilder builder = new StringBuilder();
        select.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("10112213243516273849110211312413514", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new FlatCollectIterable<>(Interval.oneTo(5), Interval::oneTo);
        StringBuilder builder = new StringBuilder();
        for (Integer each : select) {
            builder.append(each);
        }
        Assert.assertEquals("112123123412345", builder.toString());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new FlatCollectIterable<>(Interval.oneTo(5), Interval::oneTo);
        StringBuilder builder = new StringBuilder();
        select.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("112123123412345", builder.toString());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> iterable = new FlatCollectIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), Interval::oneTo);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), iterable.distinct().toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectIterableTest instance;

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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = FlatCollectIterableTest::toArray;
            this.payloads.contains = FlatCollectIterableTest::contains;
            this.payloads.containsAllIterable = FlatCollectIterableTest::containsAllIterable;
            this.payloads.containsAllArray = FlatCollectIterableTest::containsAllArray;
            this.payloads.select = FlatCollectIterableTest::select;
            this.payloads.selectWith = FlatCollectIterableTest::selectWith;
            this.payloads.selectWithTarget = FlatCollectIterableTest::selectWithTarget;
            this.payloads.reject = FlatCollectIterableTest::reject;
            this.payloads.rejectWith = FlatCollectIterableTest::rejectWith;
            this.payloads.rejectWithTarget = FlatCollectIterableTest::rejectWithTarget;
            this.payloads.partition = FlatCollectIterableTest::partition;
            this.payloads.partitionWith = FlatCollectIterableTest::partitionWith;
            this.payloads.selectInstancesOf = FlatCollectIterableTest::selectInstancesOf;
            this.payloads.collect = FlatCollectIterableTest::collect;
            this.payloads.collectBoolean = FlatCollectIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = FlatCollectIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = FlatCollectIterableTest::collectByte;
            this.payloads.collectByteWithTarget = FlatCollectIterableTest::collectByteWithTarget;
            this.payloads.collectChar = FlatCollectIterableTest::collectChar;
            this.payloads.collectCharWithTarget = FlatCollectIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = FlatCollectIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = FlatCollectIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = FlatCollectIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = FlatCollectIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = FlatCollectIterableTest::collectInt;
            this.payloads.collectIntWithTarget = FlatCollectIterableTest::collectIntWithTarget;
            this.payloads.collectLong = FlatCollectIterableTest::collectLong;
            this.payloads.collectLongWithTarget = FlatCollectIterableTest::collectLongWithTarget;
            this.payloads.collectShort = FlatCollectIterableTest::collectShort;
            this.payloads.collectShortWithTarget = FlatCollectIterableTest::collectShortWithTarget;
            this.payloads.collectWith = FlatCollectIterableTest::collectWith;
            this.payloads.collectWithTarget = FlatCollectIterableTest::collectWithTarget;
            this.payloads.take = FlatCollectIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = FlatCollectIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = FlatCollectIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = FlatCollectIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = FlatCollectIterableTest::detect;
            this.payloads.detectWith = FlatCollectIterableTest::detectWith;
            this.payloads.detectOptional = FlatCollectIterableTest::detectOptional;
            this.payloads.detectWithOptional = FlatCollectIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = FlatCollectIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = FlatCollectIterableTest::min;
            this.payloads.max = FlatCollectIterableTest::max;
            this.payloads.minBy = FlatCollectIterableTest::minBy;
            this.payloads.maxBy = FlatCollectIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = FlatCollectIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = FlatCollectIterableTest::max_without_comparator;
            this.payloads.detectIfNone = FlatCollectIterableTest::detectIfNone;
            this.payloads.anySatisfy = FlatCollectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = FlatCollectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = FlatCollectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = FlatCollectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = FlatCollectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = FlatCollectIterableTest::noneSatisfyWith;
            this.payloads.count = FlatCollectIterableTest::count;
            this.payloads.collectIf = FlatCollectIterableTest::collectIf;
            this.payloads.collectIfWithTarget = FlatCollectIterableTest::collectIfWithTarget;
            this.payloads.getFirst = FlatCollectIterableTest::getFirst;
            this.payloads.getLast = FlatCollectIterableTest::getLast;
            this.payloads.getOnly = FlatCollectIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = FlatCollectIterableTest::isEmpty;
            this.payloads.injectInto = FlatCollectIterableTest::injectInto;
            this.payloads.toList = FlatCollectIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = FlatCollectIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = FlatCollectIterableTest::toSortedList;
            this.payloads.toSortedListBy = FlatCollectIterableTest::toSortedListBy;
            this.payloads.toSortedSet = FlatCollectIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = FlatCollectIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = FlatCollectIterableTest::toSortedSetBy;
            this.payloads.toSet = FlatCollectIterableTest::toSet;
            this.payloads.toMap = FlatCollectIterableTest::toMap;
            this.payloads.toSortedMap = FlatCollectIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = FlatCollectIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = FlatCollectIterableTest::toSortedMapBy;
            this.payloads.testToString = FlatCollectIterableTest::testToString;
            this.payloads.makeString = FlatCollectIterableTest::makeString;
            this.payloads.appendString = FlatCollectIterableTest::appendString;
            this.payloads.groupBy = FlatCollectIterableTest::groupBy;
            this.payloads.groupByEach = FlatCollectIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = FlatCollectIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = FlatCollectIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = FlatCollectIterableTest::zip;
            this.payloads.zipWithIndex = FlatCollectIterableTest::zipWithIndex;
            this.payloads.chunk = FlatCollectIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FlatCollectIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = FlatCollectIterableTest::chunk_large_size;
            this.payloads.tap = FlatCollectIterableTest::tap;
            this.payloads.asLazy = FlatCollectIterableTest::asLazy;
            this.payloads.flatCollect = FlatCollectIterableTest::flatCollect;
            this.payloads.flatCollectWith = FlatCollectIterableTest::flatCollectWith;
            this.payloads.forEach = FlatCollectIterableTest::forEach;
            this.payloads.forEachWithIndex = FlatCollectIterableTest::forEachWithIndex;
            this.payloads.iterator = FlatCollectIterableTest::iterator;
            this.payloads.forEachWith = FlatCollectIterableTest::forEachWith;
            this.payloads.distinct = FlatCollectIterableTest::distinct;
        }
    }
*/
}
