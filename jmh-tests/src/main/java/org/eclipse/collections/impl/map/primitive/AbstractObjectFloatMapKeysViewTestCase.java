/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.lazy.AbstractLazyIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ObjectFloatMap#keysView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeysViewTestCase.stg.
 */
public abstract class AbstractObjectFloatMapKeysViewTestCase extends AbstractLazyIterableTestCase {

    public abstract <T> ObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3);

    @Override
    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = this.newWithKeysValues("zero", 0.0f, "thirtyOne", 31.0f, "thirtyTwo", 32.0f).keysView().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectFloatMapKeysViewTestCase instance;

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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectFloatMapKeysViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectFloatMapKeysViewTestCase> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = AbstractObjectFloatMapKeysViewTestCase::toArray;
            this.payloads.contains = AbstractObjectFloatMapKeysViewTestCase::contains;
            this.payloads.containsAllIterable = AbstractObjectFloatMapKeysViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractObjectFloatMapKeysViewTestCase::containsAllArray;
            this.payloads.select = AbstractObjectFloatMapKeysViewTestCase::select;
            this.payloads.selectWith = AbstractObjectFloatMapKeysViewTestCase::selectWith;
            this.payloads.selectWithTarget = AbstractObjectFloatMapKeysViewTestCase::selectWithTarget;
            this.payloads.reject = AbstractObjectFloatMapKeysViewTestCase::reject;
            this.payloads.rejectWith = AbstractObjectFloatMapKeysViewTestCase::rejectWith;
            this.payloads.rejectWithTarget = AbstractObjectFloatMapKeysViewTestCase::rejectWithTarget;
            this.payloads.partition = AbstractObjectFloatMapKeysViewTestCase::partition;
            this.payloads.partitionWith = AbstractObjectFloatMapKeysViewTestCase::partitionWith;
            this.payloads.selectInstancesOf = AbstractObjectFloatMapKeysViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractObjectFloatMapKeysViewTestCase::collect;
            this.payloads.collectBoolean = AbstractObjectFloatMapKeysViewTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = AbstractObjectFloatMapKeysViewTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectByteWithTarget;
            this.payloads.collectChar = AbstractObjectFloatMapKeysViewTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectCharWithTarget;
            this.payloads.collectDouble = AbstractObjectFloatMapKeysViewTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = AbstractObjectFloatMapKeysViewTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectFloatWithTarget;
            this.payloads.collectInt = AbstractObjectFloatMapKeysViewTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectIntWithTarget;
            this.payloads.collectLong = AbstractObjectFloatMapKeysViewTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectLongWithTarget;
            this.payloads.collectShort = AbstractObjectFloatMapKeysViewTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectShortWithTarget;
            this.payloads.collectWith = AbstractObjectFloatMapKeysViewTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectWithTarget;
            this.payloads.take = AbstractObjectFloatMapKeysViewTestCase::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractObjectFloatMapKeysViewTestCase::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = AbstractObjectFloatMapKeysViewTestCase::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = AbstractObjectFloatMapKeysViewTestCase::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = AbstractObjectFloatMapKeysViewTestCase::detect;
            this.payloads.detectWith = AbstractObjectFloatMapKeysViewTestCase::detectWith;
            this.payloads.detectOptional = AbstractObjectFloatMapKeysViewTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractObjectFloatMapKeysViewTestCase::detectWithOptional;
            this.payloads.detectWithIfNone = AbstractObjectFloatMapKeysViewTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractObjectFloatMapKeysViewTestCase::min;
            this.payloads.max = AbstractObjectFloatMapKeysViewTestCase::max;
            this.payloads.minBy = AbstractObjectFloatMapKeysViewTestCase::minBy;
            this.payloads.maxBy = AbstractObjectFloatMapKeysViewTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractObjectFloatMapKeysViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractObjectFloatMapKeysViewTestCase::max_without_comparator;
            this.payloads.detectIfNone = AbstractObjectFloatMapKeysViewTestCase::detectIfNone;
            this.payloads.anySatisfy = AbstractObjectFloatMapKeysViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractObjectFloatMapKeysViewTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractObjectFloatMapKeysViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractObjectFloatMapKeysViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractObjectFloatMapKeysViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractObjectFloatMapKeysViewTestCase::noneSatisfyWith;
            this.payloads.count = AbstractObjectFloatMapKeysViewTestCase::count;
            this.payloads.collectIf = AbstractObjectFloatMapKeysViewTestCase::collectIf;
            this.payloads.collectIfWithTarget = AbstractObjectFloatMapKeysViewTestCase::collectIfWithTarget;
            this.payloads.getFirst = AbstractObjectFloatMapKeysViewTestCase::getFirst;
            this.payloads.getLast = AbstractObjectFloatMapKeysViewTestCase::getLast;
            this.payloads.getOnly = AbstractObjectFloatMapKeysViewTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractObjectFloatMapKeysViewTestCase::isEmpty;
            this.payloads.injectInto = AbstractObjectFloatMapKeysViewTestCase::injectInto;
            this.payloads.toList = AbstractObjectFloatMapKeysViewTestCase::toList;
            this.payloads.toSortedListNaturalOrdering = AbstractObjectFloatMapKeysViewTestCase::toSortedListNaturalOrdering;
            this.payloads.toSortedList = AbstractObjectFloatMapKeysViewTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractObjectFloatMapKeysViewTestCase::toSortedListBy;
            this.payloads.toSortedSet = AbstractObjectFloatMapKeysViewTestCase::toSortedSet;
            this.payloads.toSortedSet_with_comparator = AbstractObjectFloatMapKeysViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractObjectFloatMapKeysViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractObjectFloatMapKeysViewTestCase::toSet;
            this.payloads.toMap = AbstractObjectFloatMapKeysViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractObjectFloatMapKeysViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractObjectFloatMapKeysViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractObjectFloatMapKeysViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractObjectFloatMapKeysViewTestCase::testToString;
            this.payloads.makeString = AbstractObjectFloatMapKeysViewTestCase::makeString;
            this.payloads.appendString = AbstractObjectFloatMapKeysViewTestCase::appendString;
            this.payloads.groupBy = AbstractObjectFloatMapKeysViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractObjectFloatMapKeysViewTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractObjectFloatMapKeysViewTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractObjectFloatMapKeysViewTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractObjectFloatMapKeysViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractObjectFloatMapKeysViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractObjectFloatMapKeysViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectFloatMapKeysViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractObjectFloatMapKeysViewTestCase::chunk_large_size;
            this.payloads.tap = AbstractObjectFloatMapKeysViewTestCase::tap;
            this.payloads.asLazy = AbstractObjectFloatMapKeysViewTestCase::asLazy;
            this.payloads.flatCollect = AbstractObjectFloatMapKeysViewTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractObjectFloatMapKeysViewTestCase::flatCollectWith;
            this.payloads.distinct = AbstractObjectFloatMapKeysViewTestCase::distinct;
            this.payloads.iterator = AbstractObjectFloatMapKeysViewTestCase::iterator;
        }
    }
}
