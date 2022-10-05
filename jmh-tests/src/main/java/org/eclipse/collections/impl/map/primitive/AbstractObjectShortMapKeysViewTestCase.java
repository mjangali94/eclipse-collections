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
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.lazy.AbstractLazyIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ObjectShortMap#keysView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeysViewTestCase.stg.
 */
public abstract class AbstractObjectShortMapKeysViewTestCase extends AbstractLazyIterableTestCase {

    public abstract <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3);

    @Override
    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = this.newWithKeysValues("zero", (short) 0, "thirtyOne", (short) 31, "thirtyTwo", (short) 32).keysView().iterator();
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

        private AbstractObjectShortMapKeysViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectShortMapKeysViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapKeysViewTestCase> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = AbstractObjectShortMapKeysViewTestCase::toArray;
            this.payloads.contains = AbstractObjectShortMapKeysViewTestCase::contains;
            this.payloads.containsAllIterable = AbstractObjectShortMapKeysViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractObjectShortMapKeysViewTestCase::containsAllArray;
            this.payloads.select = AbstractObjectShortMapKeysViewTestCase::select;
            this.payloads.selectWith = AbstractObjectShortMapKeysViewTestCase::selectWith;
            this.payloads.selectWithTarget = AbstractObjectShortMapKeysViewTestCase::selectWithTarget;
            this.payloads.reject = AbstractObjectShortMapKeysViewTestCase::reject;
            this.payloads.rejectWith = AbstractObjectShortMapKeysViewTestCase::rejectWith;
            this.payloads.rejectWithTarget = AbstractObjectShortMapKeysViewTestCase::rejectWithTarget;
            this.payloads.partition = AbstractObjectShortMapKeysViewTestCase::partition;
            this.payloads.partitionWith = AbstractObjectShortMapKeysViewTestCase::partitionWith;
            this.payloads.selectInstancesOf = AbstractObjectShortMapKeysViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractObjectShortMapKeysViewTestCase::collect;
            this.payloads.collectBoolean = AbstractObjectShortMapKeysViewTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractObjectShortMapKeysViewTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = AbstractObjectShortMapKeysViewTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractObjectShortMapKeysViewTestCase::collectByteWithTarget;
            this.payloads.collectChar = AbstractObjectShortMapKeysViewTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractObjectShortMapKeysViewTestCase::collectCharWithTarget;
            this.payloads.collectDouble = AbstractObjectShortMapKeysViewTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractObjectShortMapKeysViewTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = AbstractObjectShortMapKeysViewTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractObjectShortMapKeysViewTestCase::collectFloatWithTarget;
            this.payloads.collectInt = AbstractObjectShortMapKeysViewTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractObjectShortMapKeysViewTestCase::collectIntWithTarget;
            this.payloads.collectLong = AbstractObjectShortMapKeysViewTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractObjectShortMapKeysViewTestCase::collectLongWithTarget;
            this.payloads.collectShort = AbstractObjectShortMapKeysViewTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractObjectShortMapKeysViewTestCase::collectShortWithTarget;
            this.payloads.collectWith = AbstractObjectShortMapKeysViewTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractObjectShortMapKeysViewTestCase::collectWithTarget;
            this.payloads.take = AbstractObjectShortMapKeysViewTestCase::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractObjectShortMapKeysViewTestCase::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = AbstractObjectShortMapKeysViewTestCase::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = AbstractObjectShortMapKeysViewTestCase::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = AbstractObjectShortMapKeysViewTestCase::detect;
            this.payloads.detectWith = AbstractObjectShortMapKeysViewTestCase::detectWith;
            this.payloads.detectOptional = AbstractObjectShortMapKeysViewTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractObjectShortMapKeysViewTestCase::detectWithOptional;
            this.payloads.detectWithIfNone = AbstractObjectShortMapKeysViewTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractObjectShortMapKeysViewTestCase::min;
            this.payloads.max = AbstractObjectShortMapKeysViewTestCase::max;
            this.payloads.minBy = AbstractObjectShortMapKeysViewTestCase::minBy;
            this.payloads.maxBy = AbstractObjectShortMapKeysViewTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractObjectShortMapKeysViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractObjectShortMapKeysViewTestCase::max_without_comparator;
            this.payloads.detectIfNone = AbstractObjectShortMapKeysViewTestCase::detectIfNone;
            this.payloads.anySatisfy = AbstractObjectShortMapKeysViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractObjectShortMapKeysViewTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractObjectShortMapKeysViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractObjectShortMapKeysViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractObjectShortMapKeysViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractObjectShortMapKeysViewTestCase::noneSatisfyWith;
            this.payloads.count = AbstractObjectShortMapKeysViewTestCase::count;
            this.payloads.collectIf = AbstractObjectShortMapKeysViewTestCase::collectIf;
            this.payloads.collectIfWithTarget = AbstractObjectShortMapKeysViewTestCase::collectIfWithTarget;
            this.payloads.getFirst = AbstractObjectShortMapKeysViewTestCase::getFirst;
            this.payloads.getLast = AbstractObjectShortMapKeysViewTestCase::getLast;
            this.payloads.getOnly = AbstractObjectShortMapKeysViewTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractObjectShortMapKeysViewTestCase::isEmpty;
            this.payloads.injectInto = AbstractObjectShortMapKeysViewTestCase::injectInto;
            this.payloads.toList = AbstractObjectShortMapKeysViewTestCase::toList;
            this.payloads.toSortedListNaturalOrdering = AbstractObjectShortMapKeysViewTestCase::toSortedListNaturalOrdering;
            this.payloads.toSortedList = AbstractObjectShortMapKeysViewTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractObjectShortMapKeysViewTestCase::toSortedListBy;
            this.payloads.toSortedSet = AbstractObjectShortMapKeysViewTestCase::toSortedSet;
            this.payloads.toSortedSet_with_comparator = AbstractObjectShortMapKeysViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractObjectShortMapKeysViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractObjectShortMapKeysViewTestCase::toSet;
            this.payloads.toMap = AbstractObjectShortMapKeysViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractObjectShortMapKeysViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractObjectShortMapKeysViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractObjectShortMapKeysViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractObjectShortMapKeysViewTestCase::testToString;
            this.payloads.makeString = AbstractObjectShortMapKeysViewTestCase::makeString;
            this.payloads.appendString = AbstractObjectShortMapKeysViewTestCase::appendString;
            this.payloads.groupBy = AbstractObjectShortMapKeysViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractObjectShortMapKeysViewTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractObjectShortMapKeysViewTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractObjectShortMapKeysViewTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractObjectShortMapKeysViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractObjectShortMapKeysViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractObjectShortMapKeysViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapKeysViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractObjectShortMapKeysViewTestCase::chunk_large_size;
            this.payloads.tap = AbstractObjectShortMapKeysViewTestCase::tap;
            this.payloads.asLazy = AbstractObjectShortMapKeysViewTestCase::asLazy;
            this.payloads.flatCollect = AbstractObjectShortMapKeysViewTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractObjectShortMapKeysViewTestCase::flatCollectWith;
            this.payloads.distinct = AbstractObjectShortMapKeysViewTestCase::distinct;
            this.payloads.iterator = AbstractObjectShortMapKeysViewTestCase::iterator;
        }
    }
}
