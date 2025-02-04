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

import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MultiReaderList;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class CollectIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.collect(FastList.newListWith(elements), Functions.identity());
    }

    @Test
    public void forEach() {
        LazyIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        Appendable builder = new StringBuilder();
        Procedure<String> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("1021324354", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        for (String each : select) {
            builder.append(each);
        }
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void forEachWith() {
        LazyIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("12345", builder.toString());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<String> collect = new CollectIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), String::valueOf);
        Assert.assertEquals(FastList.newListWith("3", "2", "4", "1", "5"), collect.distinct().toList());
    }

    @Test
    public void injectIntoInt() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newListWith(1, 2, 3, 4, 5), String::valueOf);
        int sum = collect.injectInto(0, (int value, String each) -> value + Integer.parseInt(each));
        Assert.assertEquals(15, sum);
    }

    @Test
    public void injectIntoLong() {
        CollectIterable<Long, String> collect = new CollectIterable<>(FastList.newListWith(1L, 2L, 3L, 4L, 5L), String::valueOf);
        long sum = collect.injectInto(0L, (long value, String each) -> value + Long.parseLong(each));
        Assert.assertEquals(15L, sum);
    }

    @Test
    public void injectIntoDouble() {
        CollectIterable<Double, String> collect = new CollectIterable<>(FastList.newListWith(1.1d, 1.2d, 1.3d, 1.4d), String::valueOf);
        double sum = collect.injectInto(2.2d, (value, each) -> value + Double.parseDouble(each));
        Assert.assertEquals(7.2, sum, 0.1);
    }

    @Test
    public void injectIntoFloat() {
        CollectIterable<Float, String> collect = new CollectIterable<>(FastList.newListWith(1.1f, 1.2f, 1.3f, 1.4f), String::valueOf);
        float sum = collect.injectInto(2.2f, (float value, String each) -> value + Float.parseFloat(each));
        Assert.assertEquals(7.2, sum, 0.1);
    }

    @Test
    public void getFirstOnEmpty() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newList(), String::valueOf);
        Assert.assertNull(collect.getFirst());
    }

    @Test
    public void getLastOnEmpty() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newList(), String::valueOf);
        Assert.assertNull(collect.getLast());
    }

    @Override
    @Test
    public void toArray() {
        LazyIterable<String> stringNums = Interval.fromTo(0, 3).collect(Functions.getToString());
        stringNums.toArray();
        Assert.assertEquals(Lists.immutable.of("0", "1", "2", "3"), Lists.immutable.ofAll(stringNums));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detect(each -> each.equals(3)).longValue());
        Assert.assertNull(collect.detect(each -> each.equals(100)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectIfNone(each -> each.equals(3), () -> Integer.valueOf(0)).longValue());
        Assert.assertNull(collect.detectIfNone(each -> each.equals(100), () -> null));
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        LazyIterable<Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWith((each, ignore) -> each.equals(3), null).longValue());
        Assert.assertNull(collect.detectWith((each, ignore) -> each.equals(100), null));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        super.detectWithIfNone();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        LazyIterable<Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWithIfNone((each, ignore) -> each.equals(3), null, () -> Integer.valueOf(0)).longValue());
        Assert.assertNull(collect.detectWithIfNone((each, ignore) -> each.equals(100), null, () -> null));
    }

    @Override
    @Test
    public void detectOptional() {
        super.detectOptional();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectOptional(each -> each.equals(3)).get().longValue());
        Assert.assertNull(collect.detectOptional(each -> each.equals(100)).orElse(null));
    }

    @Override
    @Test
    public void detectWithOptional() {
        super.detectWithOptional();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        LazyIterable<Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWithOptional((each, ignore) -> each.equals(3), null).get().longValue());
        Assert.assertNull(collect.detectWithOptional((each, ignore) -> each.equals(100), null).orElse(null));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectIterableTest instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getFirstOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> getLastOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIterableTest> detectWithOptional;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.contains = CollectIterableTest::contains;
            this.payloads.containsAllIterable = CollectIterableTest::containsAllIterable;
            this.payloads.containsAllArray = CollectIterableTest::containsAllArray;
            this.payloads.select = CollectIterableTest::select;
            this.payloads.selectWith = CollectIterableTest::selectWith;
            this.payloads.selectWithTarget = CollectIterableTest::selectWithTarget;
            this.payloads.reject = CollectIterableTest::reject;
            this.payloads.rejectWith = CollectIterableTest::rejectWith;
            this.payloads.rejectWithTarget = CollectIterableTest::rejectWithTarget;
            this.payloads.partition = CollectIterableTest::partition;
            this.payloads.partitionWith = CollectIterableTest::partitionWith;
            this.payloads.selectInstancesOf = CollectIterableTest::selectInstancesOf;
            this.payloads.collect = CollectIterableTest::collect;
            this.payloads.collectBoolean = CollectIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = CollectIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = CollectIterableTest::collectByte;
            this.payloads.collectByteWithTarget = CollectIterableTest::collectByteWithTarget;
            this.payloads.collectChar = CollectIterableTest::collectChar;
            this.payloads.collectCharWithTarget = CollectIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = CollectIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = CollectIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = CollectIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = CollectIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = CollectIterableTest::collectInt;
            this.payloads.collectIntWithTarget = CollectIterableTest::collectIntWithTarget;
            this.payloads.collectLong = CollectIterableTest::collectLong;
            this.payloads.collectLongWithTarget = CollectIterableTest::collectLongWithTarget;
            this.payloads.collectShort = CollectIterableTest::collectShort;
            this.payloads.collectShortWithTarget = CollectIterableTest::collectShortWithTarget;
            this.payloads.collectWith = CollectIterableTest::collectWith;
            this.payloads.collectWithTarget = CollectIterableTest::collectWithTarget;
            this.payloads.take = CollectIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = CollectIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = CollectIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = CollectIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = CollectIterableTest::min;
            this.payloads.max = CollectIterableTest::max;
            this.payloads.minBy = CollectIterableTest::minBy;
            this.payloads.maxBy = CollectIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = CollectIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = CollectIterableTest::max_without_comparator;
            this.payloads.anySatisfy = CollectIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = CollectIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = CollectIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = CollectIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = CollectIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = CollectIterableTest::noneSatisfyWith;
            this.payloads.count = CollectIterableTest::count;
            this.payloads.collectIf = CollectIterableTest::collectIf;
            this.payloads.collectIfWithTarget = CollectIterableTest::collectIfWithTarget;
            this.payloads.getFirst = CollectIterableTest::getFirst;
            this.payloads.getLast = CollectIterableTest::getLast;
            this.payloads.getOnly = CollectIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = CollectIterableTest::isEmpty;
            this.payloads.injectInto = CollectIterableTest::injectInto;
            this.payloads.toList = CollectIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = CollectIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = CollectIterableTest::toSortedList;
            this.payloads.toSortedListBy = CollectIterableTest::toSortedListBy;
            this.payloads.toSortedSet = CollectIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = CollectIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = CollectIterableTest::toSortedSetBy;
            this.payloads.toSet = CollectIterableTest::toSet;
            this.payloads.toMap = CollectIterableTest::toMap;
            this.payloads.toSortedMap = CollectIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = CollectIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = CollectIterableTest::toSortedMapBy;
            this.payloads.testToString = CollectIterableTest::testToString;
            this.payloads.makeString = CollectIterableTest::makeString;
            this.payloads.appendString = CollectIterableTest::appendString;
            this.payloads.groupBy = CollectIterableTest::groupBy;
            this.payloads.groupByEach = CollectIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = CollectIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = CollectIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = CollectIterableTest::zip;
            this.payloads.zipWithIndex = CollectIterableTest::zipWithIndex;
            this.payloads.chunk = CollectIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = CollectIterableTest::chunk_large_size;
            this.payloads.tap = CollectIterableTest::tap;
            this.payloads.asLazy = CollectIterableTest::asLazy;
            this.payloads.flatCollect = CollectIterableTest::flatCollect;
            this.payloads.flatCollectWith = CollectIterableTest::flatCollectWith;
            this.payloads.forEach = CollectIterableTest::forEach;
            this.payloads.forEachWithIndex = CollectIterableTest::forEachWithIndex;
            this.payloads.iterator = CollectIterableTest::iterator;
            this.payloads.forEachWith = CollectIterableTest::forEachWith;
            this.payloads.distinct = CollectIterableTest::distinct;
            this.payloads.injectIntoInt = CollectIterableTest::injectIntoInt;
            this.payloads.injectIntoLong = CollectIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = CollectIterableTest::injectIntoDouble;
            this.payloads.injectIntoFloat = CollectIterableTest::injectIntoFloat;
            this.payloads.getFirstOnEmpty = CollectIterableTest::getFirstOnEmpty;
            this.payloads.getLastOnEmpty = CollectIterableTest::getLastOnEmpty;
            this.payloads.toArray = CollectIterableTest::toArray;
            this.payloads.detect = CollectIterableTest::detect;
            this.payloads.detectIfNone = CollectIterableTest::detectIfNone;
            this.payloads.detectWith = CollectIterableTest::detectWith;
            this.payloads.detectWithIfNone = CollectIterableTest::detectWithIfNone;
            this.payloads.detectOptional = CollectIterableTest::detectOptional;
            this.payloads.detectWithOptional = CollectIterableTest::detectWithOptional;
        }
    }
*/
}
