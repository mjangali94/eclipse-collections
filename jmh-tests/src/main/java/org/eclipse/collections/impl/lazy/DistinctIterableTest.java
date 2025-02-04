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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.lazy.iterator.DistinctIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class DistinctIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.distinct(FastList.newListWith(elements));
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 1, 2, 2, 3, 4));
        Appendable builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        distinct.forEach(appendProcedure);
        Assert.assertEquals("3124", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(1, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8, 7, 9));
        StringBuilder builder = new StringBuilder();
        distinct.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("102132435465768798", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 1, 2, 2, 3, 4, 2, 5));
        StringBuilder builder = new StringBuilder();
        for (Integer each : distinct) {
            builder.append(each);
        }
        Assert.assertEquals("31245", builder.toString());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(1, 3, 3, 2, 5, 4, 2, 5, 4));
        StringBuilder builder = new StringBuilder();
        distinct.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("13254", builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        new DistinctIterator<>(Lists.mutable.<Integer>of()).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        new DistinctIterator<>(Lists.mutable.<Integer>of()).remove();
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5));
        LazyIterable<Integer> distinctDistinct = distinct.distinct();
        Assert.assertSame(distinctDistinct, distinct);
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1, 5), distinctDistinct.toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DistinctIterableTest instance;

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
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSuchElementException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> payload) throws java.lang.Throwable {
            this.instance = new DistinctIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> noSuchElementException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DistinctIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = DistinctIterableTest::toArray;
            this.payloads.contains = DistinctIterableTest::contains;
            this.payloads.containsAllIterable = DistinctIterableTest::containsAllIterable;
            this.payloads.containsAllArray = DistinctIterableTest::containsAllArray;
            this.payloads.select = DistinctIterableTest::select;
            this.payloads.selectWith = DistinctIterableTest::selectWith;
            this.payloads.selectWithTarget = DistinctIterableTest::selectWithTarget;
            this.payloads.reject = DistinctIterableTest::reject;
            this.payloads.rejectWith = DistinctIterableTest::rejectWith;
            this.payloads.rejectWithTarget = DistinctIterableTest::rejectWithTarget;
            this.payloads.partition = DistinctIterableTest::partition;
            this.payloads.partitionWith = DistinctIterableTest::partitionWith;
            this.payloads.selectInstancesOf = DistinctIterableTest::selectInstancesOf;
            this.payloads.collect = DistinctIterableTest::collect;
            this.payloads.collectBoolean = DistinctIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = DistinctIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = DistinctIterableTest::collectByte;
            this.payloads.collectByteWithTarget = DistinctIterableTest::collectByteWithTarget;
            this.payloads.collectChar = DistinctIterableTest::collectChar;
            this.payloads.collectCharWithTarget = DistinctIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = DistinctIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = DistinctIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = DistinctIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = DistinctIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = DistinctIterableTest::collectInt;
            this.payloads.collectIntWithTarget = DistinctIterableTest::collectIntWithTarget;
            this.payloads.collectLong = DistinctIterableTest::collectLong;
            this.payloads.collectLongWithTarget = DistinctIterableTest::collectLongWithTarget;
            this.payloads.collectShort = DistinctIterableTest::collectShort;
            this.payloads.collectShortWithTarget = DistinctIterableTest::collectShortWithTarget;
            this.payloads.collectWith = DistinctIterableTest::collectWith;
            this.payloads.collectWithTarget = DistinctIterableTest::collectWithTarget;
            this.payloads.take = DistinctIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = DistinctIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = DistinctIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = DistinctIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = DistinctIterableTest::detect;
            this.payloads.detectWith = DistinctIterableTest::detectWith;
            this.payloads.detectOptional = DistinctIterableTest::detectOptional;
            this.payloads.detectWithOptional = DistinctIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = DistinctIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = DistinctIterableTest::min;
            this.payloads.max = DistinctIterableTest::max;
            this.payloads.minBy = DistinctIterableTest::minBy;
            this.payloads.maxBy = DistinctIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = DistinctIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = DistinctIterableTest::max_without_comparator;
            this.payloads.detectIfNone = DistinctIterableTest::detectIfNone;
            this.payloads.anySatisfy = DistinctIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = DistinctIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = DistinctIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = DistinctIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = DistinctIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = DistinctIterableTest::noneSatisfyWith;
            this.payloads.count = DistinctIterableTest::count;
            this.payloads.collectIf = DistinctIterableTest::collectIf;
            this.payloads.collectIfWithTarget = DistinctIterableTest::collectIfWithTarget;
            this.payloads.getFirst = DistinctIterableTest::getFirst;
            this.payloads.getLast = DistinctIterableTest::getLast;
            this.payloads.getOnly = DistinctIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = DistinctIterableTest::isEmpty;
            this.payloads.injectInto = DistinctIterableTest::injectInto;
            this.payloads.toList = DistinctIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = DistinctIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = DistinctIterableTest::toSortedList;
            this.payloads.toSortedListBy = DistinctIterableTest::toSortedListBy;
            this.payloads.toSortedSet = DistinctIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = DistinctIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = DistinctIterableTest::toSortedSetBy;
            this.payloads.toSet = DistinctIterableTest::toSet;
            this.payloads.toMap = DistinctIterableTest::toMap;
            this.payloads.toSortedMap = DistinctIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = DistinctIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = DistinctIterableTest::toSortedMapBy;
            this.payloads.testToString = DistinctIterableTest::testToString;
            this.payloads.makeString = DistinctIterableTest::makeString;
            this.payloads.appendString = DistinctIterableTest::appendString;
            this.payloads.groupBy = DistinctIterableTest::groupBy;
            this.payloads.groupByEach = DistinctIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = DistinctIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = DistinctIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = DistinctIterableTest::zip;
            this.payloads.zipWithIndex = DistinctIterableTest::zipWithIndex;
            this.payloads.chunk = DistinctIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = DistinctIterableTest::chunk_large_size;
            this.payloads.tap = DistinctIterableTest::tap;
            this.payloads.asLazy = DistinctIterableTest::asLazy;
            this.payloads.flatCollect = DistinctIterableTest::flatCollect;
            this.payloads.flatCollectWith = DistinctIterableTest::flatCollectWith;
            this.payloads.forEach = DistinctIterableTest::forEach;
            this.payloads.forEachWithIndex = DistinctIterableTest::forEachWithIndex;
            this.payloads.iterator = DistinctIterableTest::iterator;
            this.payloads.forEachWith = DistinctIterableTest::forEachWith;
            this.payloads.noSuchElementException = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::noSuchElementException, java.util.NoSuchElementException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(DistinctIterableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.distinct = DistinctIterableTest::distinct;
        }
    }
*/
}
