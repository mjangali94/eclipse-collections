/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableLongShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableLongShortHashMapKeyValuesViewTest extends AbstractLongShortMapKeyValuesViewTestCase {

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3) {
        return LongShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2) {
        return LongShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1) {
        return LongShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newEmpty() {
        return new LongShortHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongShortHashMapKeyValuesViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongShortHashMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongShortHashMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ImmutableLongShortHashMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ImmutableLongShortHashMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ImmutableLongShortHashMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ImmutableLongShortHashMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableLongShortHashMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ImmutableLongShortHashMapKeyValuesViewTest::select;
            this.payloads.selectWith = ImmutableLongShortHashMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ImmutableLongShortHashMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ImmutableLongShortHashMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = ImmutableLongShortHashMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableLongShortHashMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ImmutableLongShortHashMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ImmutableLongShortHashMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ImmutableLongShortHashMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ImmutableLongShortHashMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ImmutableLongShortHashMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ImmutableLongShortHashMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ImmutableLongShortHashMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ImmutableLongShortHashMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ImmutableLongShortHashMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ImmutableLongShortHashMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ImmutableLongShortHashMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = ImmutableLongShortHashMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongShortHashMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongShortHashMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongShortHashMapKeyValuesViewTest::min;
            this.payloads.max = ImmutableLongShortHashMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ImmutableLongShortHashMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableLongShortHashMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ImmutableLongShortHashMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = ImmutableLongShortHashMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ImmutableLongShortHashMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ImmutableLongShortHashMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ImmutableLongShortHashMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ImmutableLongShortHashMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableLongShortHashMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableLongShortHashMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableLongShortHashMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableLongShortHashMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableLongShortHashMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ImmutableLongShortHashMapKeyValuesViewTest::count;
            this.payloads.countWith = ImmutableLongShortHashMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = ImmutableLongShortHashMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ImmutableLongShortHashMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ImmutableLongShortHashMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ImmutableLongShortHashMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = ImmutableLongShortHashMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ImmutableLongShortHashMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ImmutableLongShortHashMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = ImmutableLongShortHashMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongShortHashMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongShortHashMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = ImmutableLongShortHashMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ImmutableLongShortHashMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableLongShortHashMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongShortHashMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableLongShortHashMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableLongShortHashMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ImmutableLongShortHashMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ImmutableLongShortHashMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ImmutableLongShortHashMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = ImmutableLongShortHashMapKeyValuesViewTest::toArray;
            this.payloads.partition = ImmutableLongShortHashMapKeyValuesViewTest::partition;
            this.payloads.toList = ImmutableLongShortHashMapKeyValuesViewTest::toList;
            this.payloads.toBag = ImmutableLongShortHashMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ImmutableLongShortHashMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableLongShortHashMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ImmutableLongShortHashMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ImmutableLongShortHashMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableLongShortHashMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ImmutableLongShortHashMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableLongShortHashMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableLongShortHashMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableLongShortHashMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ImmutableLongShortHashMapKeyValuesViewTest::toSet;
            this.payloads.toMap = ImmutableLongShortHashMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ImmutableLongShortHashMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableLongShortHashMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableLongShortHashMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ImmutableLongShortHashMapKeyValuesViewTest::testToString;
            this.payloads.makeString = ImmutableLongShortHashMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ImmutableLongShortHashMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableLongShortHashMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ImmutableLongShortHashMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ImmutableLongShortHashMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableLongShortHashMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ImmutableLongShortHashMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ImmutableLongShortHashMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = ImmutableLongShortHashMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ImmutableLongShortHashMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ImmutableLongShortHashMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongShortHashMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableLongShortHashMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ImmutableLongShortHashMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = ImmutableLongShortHashMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableLongShortHashMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableLongShortHashMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
