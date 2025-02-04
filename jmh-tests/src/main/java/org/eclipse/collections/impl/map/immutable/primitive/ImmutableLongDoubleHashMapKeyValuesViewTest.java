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

import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableLongDoubleHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableLongDoubleHashMapKeyValuesViewTest extends AbstractLongDoubleMapKeyValuesViewTestCase {

    @Override
    public ImmutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableLongDoubleMap newWithKeysValues(long key1, double value1) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableLongDoubleMap newEmpty() {
        return new LongDoubleHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongDoubleHashMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongDoubleHashMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongDoubleHashMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ImmutableLongDoubleHashMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ImmutableLongDoubleHashMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ImmutableLongDoubleHashMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ImmutableLongDoubleHashMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableLongDoubleHashMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ImmutableLongDoubleHashMapKeyValuesViewTest::select;
            this.payloads.selectWith = ImmutableLongDoubleHashMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ImmutableLongDoubleHashMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ImmutableLongDoubleHashMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = ImmutableLongDoubleHashMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableLongDoubleHashMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ImmutableLongDoubleHashMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ImmutableLongDoubleHashMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ImmutableLongDoubleHashMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ImmutableLongDoubleHashMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ImmutableLongDoubleHashMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ImmutableLongDoubleHashMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ImmutableLongDoubleHashMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ImmutableLongDoubleHashMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ImmutableLongDoubleHashMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ImmutableLongDoubleHashMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ImmutableLongDoubleHashMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = ImmutableLongDoubleHashMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongDoubleHashMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongDoubleHashMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongDoubleHashMapKeyValuesViewTest::min;
            this.payloads.max = ImmutableLongDoubleHashMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ImmutableLongDoubleHashMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = ImmutableLongDoubleHashMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ImmutableLongDoubleHashMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ImmutableLongDoubleHashMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ImmutableLongDoubleHashMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ImmutableLongDoubleHashMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableLongDoubleHashMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableLongDoubleHashMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableLongDoubleHashMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableLongDoubleHashMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableLongDoubleHashMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ImmutableLongDoubleHashMapKeyValuesViewTest::count;
            this.payloads.countWith = ImmutableLongDoubleHashMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = ImmutableLongDoubleHashMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ImmutableLongDoubleHashMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ImmutableLongDoubleHashMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ImmutableLongDoubleHashMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = ImmutableLongDoubleHashMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ImmutableLongDoubleHashMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ImmutableLongDoubleHashMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = ImmutableLongDoubleHashMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongDoubleHashMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongDoubleHashMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = ImmutableLongDoubleHashMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ImmutableLongDoubleHashMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableLongDoubleHashMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongDoubleHashMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableLongDoubleHashMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableLongDoubleHashMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ImmutableLongDoubleHashMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ImmutableLongDoubleHashMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ImmutableLongDoubleHashMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = ImmutableLongDoubleHashMapKeyValuesViewTest::toArray;
            this.payloads.partition = ImmutableLongDoubleHashMapKeyValuesViewTest::partition;
            this.payloads.toList = ImmutableLongDoubleHashMapKeyValuesViewTest::toList;
            this.payloads.toBag = ImmutableLongDoubleHashMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ImmutableLongDoubleHashMapKeyValuesViewTest::toSet;
            this.payloads.toMap = ImmutableLongDoubleHashMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableLongDoubleHashMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ImmutableLongDoubleHashMapKeyValuesViewTest::testToString;
            this.payloads.makeString = ImmutableLongDoubleHashMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ImmutableLongDoubleHashMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableLongDoubleHashMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ImmutableLongDoubleHashMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ImmutableLongDoubleHashMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableLongDoubleHashMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ImmutableLongDoubleHashMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ImmutableLongDoubleHashMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = ImmutableLongDoubleHashMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ImmutableLongDoubleHashMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ImmutableLongDoubleHashMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongDoubleHashMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableLongDoubleHashMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ImmutableLongDoubleHashMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = ImmutableLongDoubleHashMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableLongDoubleHashMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableLongDoubleHashMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
