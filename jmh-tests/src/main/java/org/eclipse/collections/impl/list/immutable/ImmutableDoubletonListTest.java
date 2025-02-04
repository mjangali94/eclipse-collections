/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import org.eclipse.collections.api.list.ImmutableList;
import org.junit.Test;

public class ImmutableDoubletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableDoubletonList<>(1, 2);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubletonListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_each() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.each);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
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
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromNegative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanTO() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanTO);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsNegative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsGreaterThanSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubletonListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonListTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableDoubletonListTest::stream;
            this.payloads.parallelStream = ImmutableDoubletonListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableDoubletonListTest::countBy;
            this.payloads.countByWith = ImmutableDoubletonListTest::countByWith;
            this.payloads.countByEach = ImmutableDoubletonListTest::countByEach;
            this.payloads.selectWith = ImmutableDoubletonListTest::selectWith;
            this.payloads.selectWith_target = ImmutableDoubletonListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableDoubletonListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableDoubletonListTest::rejectWith_target;
            this.payloads.partition = ImmutableDoubletonListTest::partition;
            this.payloads.partitionWith = ImmutableDoubletonListTest::partitionWith;
            this.payloads.collectWith = ImmutableDoubletonListTest::collectWith;
            this.payloads.collect_target = ImmutableDoubletonListTest::collect_target;
            this.payloads.collectWith_target = ImmutableDoubletonListTest::collectWith_target;
            this.payloads.injectInto = ImmutableDoubletonListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableDoubletonListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableDoubletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDoubletonListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableDoubletonListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableDoubletonListTest::sumFloat;
            this.payloads.sumDouble = ImmutableDoubletonListTest::sumDouble;
            this.payloads.sumInteger = ImmutableDoubletonListTest::sumInteger;
            this.payloads.sumLong = ImmutableDoubletonListTest::sumLong;
            this.payloads.sumByInt = ImmutableDoubletonListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableDoubletonListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableDoubletonListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableDoubletonListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableDoubletonListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableDoubletonListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableDoubletonListTest::makeString;
            this.payloads.appendString = ImmutableDoubletonListTest::appendString;
            this.payloads.testToString = ImmutableDoubletonListTest::testToString;
            this.payloads.select = ImmutableDoubletonListTest::select;
            this.payloads.selectInstancesOf = ImmutableDoubletonListTest::selectInstancesOf;
            this.payloads.reject = ImmutableDoubletonListTest::reject;
            this.payloads.collect = ImmutableDoubletonListTest::collect;
            this.payloads.collectByte = ImmutableDoubletonListTest::collectByte;
            this.payloads.collectChar = ImmutableDoubletonListTest::collectChar;
            this.payloads.collectDouble = ImmutableDoubletonListTest::collectDouble;
            this.payloads.collectFloat = ImmutableDoubletonListTest::collectFloat;
            this.payloads.collectInt = ImmutableDoubletonListTest::collectInt;
            this.payloads.collectLong = ImmutableDoubletonListTest::collectLong;
            this.payloads.collectShort = ImmutableDoubletonListTest::collectShort;
            this.payloads.flatCollect = ImmutableDoubletonListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableDoubletonListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableDoubletonListTest::detect;
            this.payloads.detectWith = ImmutableDoubletonListTest::detectWith;
            this.payloads.detectIfNone = ImmutableDoubletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableDoubletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableDoubletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableDoubletonListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableDoubletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableDoubletonListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableDoubletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableDoubletonListTest::anySatisfyWith;
            this.payloads.count = ImmutableDoubletonListTest::count;
            this.payloads.countWith = ImmutableDoubletonListTest::countWith;
            this.payloads.collectIf = ImmutableDoubletonListTest::collectIf;
            this.payloads.getFirst = ImmutableDoubletonListTest::getFirst;
            this.payloads.getLast = ImmutableDoubletonListTest::getLast;
            this.payloads.isEmpty = ImmutableDoubletonListTest::isEmpty;
            this.payloads.iterator = ImmutableDoubletonListTest::iterator;
            this.payloads.toArray = ImmutableDoubletonListTest::toArray;
            this.payloads.toSortedList = ImmutableDoubletonListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableDoubletonListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableDoubletonListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableDoubletonListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableDoubletonListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableDoubletonListTest::min;
            this.payloads.max = ImmutableDoubletonListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableDoubletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableDoubletonListTest::max_without_comparator;
            this.payloads.minBy = ImmutableDoubletonListTest::minBy;
            this.payloads.maxBy = ImmutableDoubletonListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableDoubletonListTest::iteratorRemove;
            this.payloads.add = ImmutableDoubletonListTest::add;
            this.payloads.remove = ImmutableDoubletonListTest::remove;
            this.payloads.clear = ImmutableDoubletonListTest::clear;
            this.payloads.removeAll = ImmutableDoubletonListTest::removeAll;
            this.payloads.retainAll = ImmutableDoubletonListTest::retainAll;
            this.payloads.addAll = ImmutableDoubletonListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableDoubletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableDoubletonListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableDoubletonListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableDoubletonListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableDoubletonListTest::contains;
            this.payloads.containsAll = ImmutableDoubletonListTest::containsAll;
            this.payloads.containsAllArray = ImmutableDoubletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDoubletonListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableDoubletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableDoubletonListTest::lastIndexOf;
            this.payloads.get = ImmutableDoubletonListTest::get;
            this.payloads.forEach = ImmutableDoubletonListTest::forEach;
            this.payloads.each = ImmutableDoubletonListTest::each;
            this.payloads.reverseForEach = ImmutableDoubletonListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableDoubletonListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableDoubletonListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableDoubletonListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableDoubletonListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableDoubletonListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableDoubletonListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableDoubletonListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableDoubletonListTest::detectLastIndex;
            this.payloads.select_target = ImmutableDoubletonListTest::select_target;
            this.payloads.reject_target = ImmutableDoubletonListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableDoubletonListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableDoubletonListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableDoubletonListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableDoubletonListTest::distinctBy;
            this.payloads.zip = ImmutableDoubletonListTest::zip;
            this.payloads.zipWithIndex = ImmutableDoubletonListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableDoubletonListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableDoubletonListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableDoubletonListTest::toList;
            this.payloads.toSortedListBy = ImmutableDoubletonListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableDoubletonListTest::removeAtIndex;
            this.payloads.set = ImmutableDoubletonListTest::set;
            this.payloads.addAtIndex = ImmutableDoubletonListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableDoubletonListTest::addAllAtIndex;
            this.payloads.sort = ImmutableDoubletonListTest::sort;
            this.payloads.replaceAll = ImmutableDoubletonListTest::replaceAll;
            this.payloads.subList = ImmutableDoubletonListTest::subList;
            this.payloads.subListFromNegative = ImmutableDoubletonListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableDoubletonListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableDoubletonListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableDoubletonListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableDoubletonListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableDoubletonListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableDoubletonListTest::toStack;
            this.payloads.take = ImmutableDoubletonListTest::take;
            this.payloads.take_throws = ImmutableDoubletonListTest::take_throws;
            this.payloads.takeWhile = ImmutableDoubletonListTest::takeWhile;
            this.payloads.drop = ImmutableDoubletonListTest::drop;
            this.payloads.drop_throws = ImmutableDoubletonListTest::drop_throws;
            this.payloads.dropWhile = ImmutableDoubletonListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableDoubletonListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableDoubletonListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableDoubletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableDoubletonListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableDoubletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableDoubletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableDoubletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableDoubletonListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableDoubletonListTest::groupBy;
            this.payloads.groupByEach = ImmutableDoubletonListTest::groupByEach;
            this.payloads.asReversed = ImmutableDoubletonListTest::asReversed;
            this.payloads.toReversed = ImmutableDoubletonListTest::toReversed;
            this.payloads.toImmutable = ImmutableDoubletonListTest::toImmutable;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonListTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
