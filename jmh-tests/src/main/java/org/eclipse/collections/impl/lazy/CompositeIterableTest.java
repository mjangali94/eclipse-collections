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

import java.util.List;
import java.util.Optional;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CompositeIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return CompositeIterable.with(FastList.newListWith(elements));
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = Interval.oneTo(3).asLazy().concatenate(Interval.fromTo(4, 5));
        StringBuilder builder = new StringBuilder();
        for (Integer each : select) {
            builder.append(each);
        }
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void emptyIterator() {
        LazyIterable<String> list = new CompositeIterable<>();
        Assert.assertFalse(list.iterator().hasNext());
    }

    @Test
    public void iteratorAll() {
        LazyIterable<Integer> iterables = CompositeIterable.with(Interval.oneTo(5), Interval.fromTo(6, 10));
        Verify.assertAllSatisfy(iterables, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
    }

    @Test
    public void iteratorAny() {
        LazyIterable<Integer> iterables = CompositeIterable.with(Interval.oneTo(5), Interval.fromTo(6, 10));
        Verify.assertAnySatisfy(iterables, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
    }

    @Test
    public void forEach() {
        MutableList<Integer> list = Lists.mutable.of();
        LazyIterable<Integer> iterables = CompositeIterable.with(Interval.oneTo(5), Interval.fromTo(6, 10));
        iterables.forEach(CollectionAddProcedure.on(list));
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> list = Lists.mutable.of();
        LazyIterable<Integer> iterables = CompositeIterable.with(Interval.fromTo(6, 10), Interval.oneTo(5));
        iterables.forEachWithIndex((each, index) -> list.add(index, each));
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
        Verify.assertStartsWith(list, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> list = Lists.mutable.of();
        LazyIterable<Integer> iterables = CompositeIterable.with(Interval.fromTo(6, 10), Interval.oneTo(5));
        iterables.forEachWith((each, parameter) -> list.add(parameter.intValue(), each), 0);
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
        Verify.assertStartsWith(list, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6);
    }

    @Test
    public void ensureLazy() {
        CompositeIterable<Integer> iterables = new CompositeIterable<>();
        List<Integer> expected = Interval.oneTo(5);
        iterables.add(expected);
        iterables.add(() -> {
            throw new RuntimeException("Iterator should not be invoked eagerly");
        });
        Assert.assertEquals(expected, iterables.take(expected.size()).toList());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        CompositeIterable<Integer> composite = new CompositeIterable<>();
        MutableList<Integer> expected = FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5);
        composite.add(expected);
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1, 5), composite.distinct().toList());
    }

    @Override
    public void detect() {
        CompositeIterable<Integer> composite = CompositeIterable.with(FastList.newListWith(1, 2), FastList.newList(), FastList.newListWith(3, 4, 5, 6));
        Assert.assertEquals(Integer.valueOf(3), composite.detect(Integer.valueOf(3)::equals));
        Assert.assertNull(composite.detect(Integer.valueOf(8)::equals));
    }

    @Override
    public void detectWith() {
        CompositeIterable<Integer> composite = CompositeIterable.with(FastList.newListWith(1, 2), FastList.newList(), FastList.newListWith(3, 4, 5, 6));
        Assert.assertEquals(Integer.valueOf(3), composite.detectWith(Object::equals, Integer.valueOf(3)));
        Assert.assertNull(composite.detectWith(Object::equals, Integer.valueOf(8)));
    }

    @Override
    public void detectOptional() {
        CompositeIterable<Integer> composite = CompositeIterable.with(FastList.newListWith(1, 2), FastList.newList(), FastList.newListWith(3, 4, 5, 6));
        Assert.assertEquals(Optional.of(Integer.valueOf(3)), composite.detectOptional(Integer.valueOf(3)::equals));
        Assert.assertEquals(Optional.empty(), composite.detectOptional(Integer.valueOf(8)::equals));
    }

    @Override
    public void detectWithOptional() {
        CompositeIterable<Integer> composite = CompositeIterable.with(FastList.newListWith(1, 2), FastList.newList(), FastList.newListWith(3, 4, 5, 6));
        Assert.assertEquals(Optional.of(Integer.valueOf(3)), composite.detectWithOptional(Object::equals, Integer.valueOf(3)));
        Assert.assertEquals(Optional.empty(), composite.detectWithOptional(Object::equals, Integer.valueOf(8)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CompositeIterableTest instance;

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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorAny);
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
        public void benchmark_ensureLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ensureLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CompositeIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> emptyIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> iteratorAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> iteratorAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> ensureLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeIterableTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = CompositeIterableTest::toArray;
            this.payloads.contains = CompositeIterableTest::contains;
            this.payloads.containsAllIterable = CompositeIterableTest::containsAllIterable;
            this.payloads.containsAllArray = CompositeIterableTest::containsAllArray;
            this.payloads.select = CompositeIterableTest::select;
            this.payloads.selectWith = CompositeIterableTest::selectWith;
            this.payloads.selectWithTarget = CompositeIterableTest::selectWithTarget;
            this.payloads.reject = CompositeIterableTest::reject;
            this.payloads.rejectWith = CompositeIterableTest::rejectWith;
            this.payloads.rejectWithTarget = CompositeIterableTest::rejectWithTarget;
            this.payloads.partition = CompositeIterableTest::partition;
            this.payloads.partitionWith = CompositeIterableTest::partitionWith;
            this.payloads.selectInstancesOf = CompositeIterableTest::selectInstancesOf;
            this.payloads.collect = CompositeIterableTest::collect;
            this.payloads.collectBoolean = CompositeIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = CompositeIterableTest::collectBooleanWithTarget;
            this.payloads.collectByte = CompositeIterableTest::collectByte;
            this.payloads.collectByteWithTarget = CompositeIterableTest::collectByteWithTarget;
            this.payloads.collectChar = CompositeIterableTest::collectChar;
            this.payloads.collectCharWithTarget = CompositeIterableTest::collectCharWithTarget;
            this.payloads.collectDouble = CompositeIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = CompositeIterableTest::collectDoubleWithTarget;
            this.payloads.collectFloat = CompositeIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = CompositeIterableTest::collectFloatWithTarget;
            this.payloads.collectInt = CompositeIterableTest::collectInt;
            this.payloads.collectIntWithTarget = CompositeIterableTest::collectIntWithTarget;
            this.payloads.collectLong = CompositeIterableTest::collectLong;
            this.payloads.collectLongWithTarget = CompositeIterableTest::collectLongWithTarget;
            this.payloads.collectShort = CompositeIterableTest::collectShort;
            this.payloads.collectShortWithTarget = CompositeIterableTest::collectShortWithTarget;
            this.payloads.collectWith = CompositeIterableTest::collectWith;
            this.payloads.collectWithTarget = CompositeIterableTest::collectWithTarget;
            this.payloads.take = CompositeIterableTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = CompositeIterableTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = CompositeIterableTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = CompositeIterableTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = CompositeIterableTest::detect;
            this.payloads.detectWith = CompositeIterableTest::detectWith;
            this.payloads.detectOptional = CompositeIterableTest::detectOptional;
            this.payloads.detectWithOptional = CompositeIterableTest::detectWithOptional;
            this.payloads.detectWithIfNone = CompositeIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = CompositeIterableTest::min;
            this.payloads.max = CompositeIterableTest::max;
            this.payloads.minBy = CompositeIterableTest::minBy;
            this.payloads.maxBy = CompositeIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = CompositeIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = CompositeIterableTest::max_without_comparator;
            this.payloads.detectIfNone = CompositeIterableTest::detectIfNone;
            this.payloads.anySatisfy = CompositeIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = CompositeIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = CompositeIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = CompositeIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = CompositeIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = CompositeIterableTest::noneSatisfyWith;
            this.payloads.count = CompositeIterableTest::count;
            this.payloads.collectIf = CompositeIterableTest::collectIf;
            this.payloads.collectIfWithTarget = CompositeIterableTest::collectIfWithTarget;
            this.payloads.getFirst = CompositeIterableTest::getFirst;
            this.payloads.getLast = CompositeIterableTest::getLast;
            this.payloads.getOnly = CompositeIterableTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = CompositeIterableTest::isEmpty;
            this.payloads.injectInto = CompositeIterableTest::injectInto;
            this.payloads.toList = CompositeIterableTest::toList;
            this.payloads.toSortedListNaturalOrdering = CompositeIterableTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = CompositeIterableTest::toSortedList;
            this.payloads.toSortedListBy = CompositeIterableTest::toSortedListBy;
            this.payloads.toSortedSet = CompositeIterableTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = CompositeIterableTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = CompositeIterableTest::toSortedSetBy;
            this.payloads.toSet = CompositeIterableTest::toSet;
            this.payloads.toMap = CompositeIterableTest::toMap;
            this.payloads.toSortedMap = CompositeIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = CompositeIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = CompositeIterableTest::toSortedMapBy;
            this.payloads.testToString = CompositeIterableTest::testToString;
            this.payloads.makeString = CompositeIterableTest::makeString;
            this.payloads.appendString = CompositeIterableTest::appendString;
            this.payloads.groupBy = CompositeIterableTest::groupBy;
            this.payloads.groupByEach = CompositeIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = CompositeIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = CompositeIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = CompositeIterableTest::zip;
            this.payloads.zipWithIndex = CompositeIterableTest::zipWithIndex;
            this.payloads.chunk = CompositeIterableTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = CompositeIterableTest::chunk_large_size;
            this.payloads.tap = CompositeIterableTest::tap;
            this.payloads.asLazy = CompositeIterableTest::asLazy;
            this.payloads.flatCollect = CompositeIterableTest::flatCollect;
            this.payloads.flatCollectWith = CompositeIterableTest::flatCollectWith;
            this.payloads.iterator = CompositeIterableTest::iterator;
            this.payloads.emptyIterator = CompositeIterableTest::emptyIterator;
            this.payloads.iteratorAll = CompositeIterableTest::iteratorAll;
            this.payloads.iteratorAny = CompositeIterableTest::iteratorAny;
            this.payloads.forEach = CompositeIterableTest::forEach;
            this.payloads.forEachWithIndex = CompositeIterableTest::forEachWithIndex;
            this.payloads.forEachWith = CompositeIterableTest::forEachWith;
            this.payloads.ensureLazy = CompositeIterableTest::ensureLazy;
            this.payloads.distinct = CompositeIterableTest::distinct;
        }
    }
}
