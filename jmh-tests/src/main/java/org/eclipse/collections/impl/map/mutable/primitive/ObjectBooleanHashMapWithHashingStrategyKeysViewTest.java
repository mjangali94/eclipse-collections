/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.lazy.AbstractLazyIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;

/**
 * JUnit test for {@link ObjectBooleanHashMapWithHashingStrategy#keysView()}.
 */
public class ObjectBooleanHashMapWithHashingStrategyKeysViewTest extends AbstractLazyIterableTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectBooleanHashMapWithHashingStrategy<T> map = new ObjectBooleanHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.keysView();
    }

    @Override
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "zero", true, "thirtyOne", false, "thirtyTwo", true).keysView().iterator();
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

        private ObjectBooleanHashMapWithHashingStrategyKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectBooleanHashMapWithHashingStrategyKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeysViewTest> distinct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::iterator;
            this.payloads.toArray = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toArray;
            this.payloads.contains = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::containsAllArray;
            this.payloads.select = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::select;
            this.payloads.selectWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::reject;
            this.payloads.rejectWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::partition;
            this.payloads.partitionWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detect;
            this.payloads.detectWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min;
            this.payloads.max = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max;
            this.payloads.minBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::minBy;
            this.payloads.maxBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::count;
            this.payloads.collectIf = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::getFirst;
            this.payloads.getLast = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::getLast;
            this.payloads.getOnly = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::injectInto;
            this.payloads.toList = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSet;
            this.payloads.toMap = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::testToString;
            this.payloads.makeString = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::makeString;
            this.payloads.appendString = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::appendString;
            this.payloads.groupBy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::tap;
            this.payloads.asLazy = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectBooleanHashMapWithHashingStrategyKeysViewTest::distinct;
        }
    }
}
