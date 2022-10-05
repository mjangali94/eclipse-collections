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
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.lazy.AbstractLazyIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ObjectIntMap#keysView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeysViewTestCase.stg.
 */
public abstract class AbstractObjectIntMapKeysViewTestCase extends AbstractLazyIterableTestCase {

    public abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3);

    @Override
    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = this.newWithKeysValues("zero", 0, "thirtyOne", 31, "thirtyTwo", 32).keysView().iterator();
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

        private AbstractObjectIntMapKeysViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectIntMapKeysViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeysViewTestCase> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = AbstractObjectIntMapKeysViewTestCase::toArray;
            this.payloads.contains = AbstractObjectIntMapKeysViewTestCase::contains;
            this.payloads.containsAllIterable = AbstractObjectIntMapKeysViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractObjectIntMapKeysViewTestCase::containsAllArray;
            this.payloads.select = AbstractObjectIntMapKeysViewTestCase::select;
            this.payloads.selectWith = AbstractObjectIntMapKeysViewTestCase::selectWith;
            this.payloads.selectWithTarget = AbstractObjectIntMapKeysViewTestCase::selectWithTarget;
            this.payloads.reject = AbstractObjectIntMapKeysViewTestCase::reject;
            this.payloads.rejectWith = AbstractObjectIntMapKeysViewTestCase::rejectWith;
            this.payloads.rejectWithTarget = AbstractObjectIntMapKeysViewTestCase::rejectWithTarget;
            this.payloads.partition = AbstractObjectIntMapKeysViewTestCase::partition;
            this.payloads.partitionWith = AbstractObjectIntMapKeysViewTestCase::partitionWith;
            this.payloads.selectInstancesOf = AbstractObjectIntMapKeysViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractObjectIntMapKeysViewTestCase::collect;
            this.payloads.collectBoolean = AbstractObjectIntMapKeysViewTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractObjectIntMapKeysViewTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = AbstractObjectIntMapKeysViewTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractObjectIntMapKeysViewTestCase::collectByteWithTarget;
            this.payloads.collectChar = AbstractObjectIntMapKeysViewTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractObjectIntMapKeysViewTestCase::collectCharWithTarget;
            this.payloads.collectDouble = AbstractObjectIntMapKeysViewTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractObjectIntMapKeysViewTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = AbstractObjectIntMapKeysViewTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractObjectIntMapKeysViewTestCase::collectFloatWithTarget;
            this.payloads.collectInt = AbstractObjectIntMapKeysViewTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractObjectIntMapKeysViewTestCase::collectIntWithTarget;
            this.payloads.collectLong = AbstractObjectIntMapKeysViewTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractObjectIntMapKeysViewTestCase::collectLongWithTarget;
            this.payloads.collectShort = AbstractObjectIntMapKeysViewTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractObjectIntMapKeysViewTestCase::collectShortWithTarget;
            this.payloads.collectWith = AbstractObjectIntMapKeysViewTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractObjectIntMapKeysViewTestCase::collectWithTarget;
            this.payloads.take = AbstractObjectIntMapKeysViewTestCase::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractObjectIntMapKeysViewTestCase::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = AbstractObjectIntMapKeysViewTestCase::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = AbstractObjectIntMapKeysViewTestCase::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = AbstractObjectIntMapKeysViewTestCase::detect;
            this.payloads.detectWith = AbstractObjectIntMapKeysViewTestCase::detectWith;
            this.payloads.detectOptional = AbstractObjectIntMapKeysViewTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractObjectIntMapKeysViewTestCase::detectWithOptional;
            this.payloads.detectWithIfNone = AbstractObjectIntMapKeysViewTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractObjectIntMapKeysViewTestCase::min;
            this.payloads.max = AbstractObjectIntMapKeysViewTestCase::max;
            this.payloads.minBy = AbstractObjectIntMapKeysViewTestCase::minBy;
            this.payloads.maxBy = AbstractObjectIntMapKeysViewTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractObjectIntMapKeysViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractObjectIntMapKeysViewTestCase::max_without_comparator;
            this.payloads.detectIfNone = AbstractObjectIntMapKeysViewTestCase::detectIfNone;
            this.payloads.anySatisfy = AbstractObjectIntMapKeysViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractObjectIntMapKeysViewTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractObjectIntMapKeysViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractObjectIntMapKeysViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractObjectIntMapKeysViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractObjectIntMapKeysViewTestCase::noneSatisfyWith;
            this.payloads.count = AbstractObjectIntMapKeysViewTestCase::count;
            this.payloads.collectIf = AbstractObjectIntMapKeysViewTestCase::collectIf;
            this.payloads.collectIfWithTarget = AbstractObjectIntMapKeysViewTestCase::collectIfWithTarget;
            this.payloads.getFirst = AbstractObjectIntMapKeysViewTestCase::getFirst;
            this.payloads.getLast = AbstractObjectIntMapKeysViewTestCase::getLast;
            this.payloads.getOnly = AbstractObjectIntMapKeysViewTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractObjectIntMapKeysViewTestCase::isEmpty;
            this.payloads.injectInto = AbstractObjectIntMapKeysViewTestCase::injectInto;
            this.payloads.toList = AbstractObjectIntMapKeysViewTestCase::toList;
            this.payloads.toSortedListNaturalOrdering = AbstractObjectIntMapKeysViewTestCase::toSortedListNaturalOrdering;
            this.payloads.toSortedList = AbstractObjectIntMapKeysViewTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractObjectIntMapKeysViewTestCase::toSortedListBy;
            this.payloads.toSortedSet = AbstractObjectIntMapKeysViewTestCase::toSortedSet;
            this.payloads.toSortedSet_with_comparator = AbstractObjectIntMapKeysViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractObjectIntMapKeysViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractObjectIntMapKeysViewTestCase::toSet;
            this.payloads.toMap = AbstractObjectIntMapKeysViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractObjectIntMapKeysViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractObjectIntMapKeysViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractObjectIntMapKeysViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractObjectIntMapKeysViewTestCase::testToString;
            this.payloads.makeString = AbstractObjectIntMapKeysViewTestCase::makeString;
            this.payloads.appendString = AbstractObjectIntMapKeysViewTestCase::appendString;
            this.payloads.groupBy = AbstractObjectIntMapKeysViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractObjectIntMapKeysViewTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractObjectIntMapKeysViewTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractObjectIntMapKeysViewTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractObjectIntMapKeysViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractObjectIntMapKeysViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractObjectIntMapKeysViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeysViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractObjectIntMapKeysViewTestCase::chunk_large_size;
            this.payloads.tap = AbstractObjectIntMapKeysViewTestCase::tap;
            this.payloads.asLazy = AbstractObjectIntMapKeysViewTestCase::asLazy;
            this.payloads.flatCollect = AbstractObjectIntMapKeysViewTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractObjectIntMapKeysViewTestCase::flatCollectWith;
            this.payloads.distinct = AbstractObjectIntMapKeysViewTestCase::distinct;
            this.payloads.iterator = AbstractObjectIntMapKeysViewTestCase::iterator;
        }
    }
}
