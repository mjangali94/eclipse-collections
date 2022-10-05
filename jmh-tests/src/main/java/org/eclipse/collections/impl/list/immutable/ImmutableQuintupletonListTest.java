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

public class ImmutableQuintupletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableQuintupletonList<>(1, 2, 3, 4, 5);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableQuintupletonListTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableQuintupletonListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuintupletonListTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableQuintupletonListTest::stream;
            this.payloads.parallelStream = ImmutableQuintupletonListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableQuintupletonListTest::countBy;
            this.payloads.countByWith = ImmutableQuintupletonListTest::countByWith;
            this.payloads.countByEach = ImmutableQuintupletonListTest::countByEach;
            this.payloads.selectWith = ImmutableQuintupletonListTest::selectWith;
            this.payloads.selectWith_target = ImmutableQuintupletonListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableQuintupletonListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableQuintupletonListTest::rejectWith_target;
            this.payloads.partition = ImmutableQuintupletonListTest::partition;
            this.payloads.partitionWith = ImmutableQuintupletonListTest::partitionWith;
            this.payloads.collectWith = ImmutableQuintupletonListTest::collectWith;
            this.payloads.collect_target = ImmutableQuintupletonListTest::collect_target;
            this.payloads.collectWith_target = ImmutableQuintupletonListTest::collectWith_target;
            this.payloads.injectInto = ImmutableQuintupletonListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableQuintupletonListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableQuintupletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableQuintupletonListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableQuintupletonListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableQuintupletonListTest::sumFloat;
            this.payloads.sumDouble = ImmutableQuintupletonListTest::sumDouble;
            this.payloads.sumInteger = ImmutableQuintupletonListTest::sumInteger;
            this.payloads.sumLong = ImmutableQuintupletonListTest::sumLong;
            this.payloads.sumByInt = ImmutableQuintupletonListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableQuintupletonListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableQuintupletonListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableQuintupletonListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableQuintupletonListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableQuintupletonListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableQuintupletonListTest::makeString;
            this.payloads.appendString = ImmutableQuintupletonListTest::appendString;
            this.payloads.testToString = ImmutableQuintupletonListTest::testToString;
            this.payloads.select = ImmutableQuintupletonListTest::select;
            this.payloads.selectInstancesOf = ImmutableQuintupletonListTest::selectInstancesOf;
            this.payloads.reject = ImmutableQuintupletonListTest::reject;
            this.payloads.collect = ImmutableQuintupletonListTest::collect;
            this.payloads.collectByte = ImmutableQuintupletonListTest::collectByte;
            this.payloads.collectChar = ImmutableQuintupletonListTest::collectChar;
            this.payloads.collectDouble = ImmutableQuintupletonListTest::collectDouble;
            this.payloads.collectFloat = ImmutableQuintupletonListTest::collectFloat;
            this.payloads.collectInt = ImmutableQuintupletonListTest::collectInt;
            this.payloads.collectLong = ImmutableQuintupletonListTest::collectLong;
            this.payloads.collectShort = ImmutableQuintupletonListTest::collectShort;
            this.payloads.flatCollect = ImmutableQuintupletonListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableQuintupletonListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableQuintupletonListTest::detect;
            this.payloads.detectWith = ImmutableQuintupletonListTest::detectWith;
            this.payloads.detectIfNone = ImmutableQuintupletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableQuintupletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableQuintupletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableQuintupletonListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableQuintupletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableQuintupletonListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableQuintupletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableQuintupletonListTest::anySatisfyWith;
            this.payloads.count = ImmutableQuintupletonListTest::count;
            this.payloads.countWith = ImmutableQuintupletonListTest::countWith;
            this.payloads.collectIf = ImmutableQuintupletonListTest::collectIf;
            this.payloads.getFirst = ImmutableQuintupletonListTest::getFirst;
            this.payloads.getLast = ImmutableQuintupletonListTest::getLast;
            this.payloads.isEmpty = ImmutableQuintupletonListTest::isEmpty;
            this.payloads.iterator = ImmutableQuintupletonListTest::iterator;
            this.payloads.toArray = ImmutableQuintupletonListTest::toArray;
            this.payloads.toSortedList = ImmutableQuintupletonListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableQuintupletonListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableQuintupletonListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableQuintupletonListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableQuintupletonListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableQuintupletonListTest::min;
            this.payloads.max = ImmutableQuintupletonListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableQuintupletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableQuintupletonListTest::max_without_comparator;
            this.payloads.minBy = ImmutableQuintupletonListTest::minBy;
            this.payloads.maxBy = ImmutableQuintupletonListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableQuintupletonListTest::iteratorRemove;
            this.payloads.add = ImmutableQuintupletonListTest::add;
            this.payloads.remove = ImmutableQuintupletonListTest::remove;
            this.payloads.clear = ImmutableQuintupletonListTest::clear;
            this.payloads.removeAll = ImmutableQuintupletonListTest::removeAll;
            this.payloads.retainAll = ImmutableQuintupletonListTest::retainAll;
            this.payloads.addAll = ImmutableQuintupletonListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableQuintupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableQuintupletonListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableQuintupletonListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableQuintupletonListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableQuintupletonListTest::contains;
            this.payloads.containsAll = ImmutableQuintupletonListTest::containsAll;
            this.payloads.containsAllArray = ImmutableQuintupletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableQuintupletonListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableQuintupletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableQuintupletonListTest::lastIndexOf;
            this.payloads.get = ImmutableQuintupletonListTest::get;
            this.payloads.forEach = ImmutableQuintupletonListTest::forEach;
            this.payloads.each = ImmutableQuintupletonListTest::each;
            this.payloads.reverseForEach = ImmutableQuintupletonListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableQuintupletonListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableQuintupletonListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableQuintupletonListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableQuintupletonListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableQuintupletonListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableQuintupletonListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableQuintupletonListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableQuintupletonListTest::detectLastIndex;
            this.payloads.select_target = ImmutableQuintupletonListTest::select_target;
            this.payloads.reject_target = ImmutableQuintupletonListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableQuintupletonListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableQuintupletonListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableQuintupletonListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableQuintupletonListTest::distinctBy;
            this.payloads.zip = ImmutableQuintupletonListTest::zip;
            this.payloads.zipWithIndex = ImmutableQuintupletonListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableQuintupletonListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableQuintupletonListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableQuintupletonListTest::toList;
            this.payloads.toSortedListBy = ImmutableQuintupletonListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableQuintupletonListTest::removeAtIndex;
            this.payloads.set = ImmutableQuintupletonListTest::set;
            this.payloads.addAtIndex = ImmutableQuintupletonListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableQuintupletonListTest::addAllAtIndex;
            this.payloads.sort = ImmutableQuintupletonListTest::sort;
            this.payloads.replaceAll = ImmutableQuintupletonListTest::replaceAll;
            this.payloads.subList = ImmutableQuintupletonListTest::subList;
            this.payloads.subListFromNegative = ImmutableQuintupletonListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableQuintupletonListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableQuintupletonListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableQuintupletonListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableQuintupletonListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableQuintupletonListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableQuintupletonListTest::toStack;
            this.payloads.take = ImmutableQuintupletonListTest::take;
            this.payloads.take_throws = ImmutableQuintupletonListTest::take_throws;
            this.payloads.takeWhile = ImmutableQuintupletonListTest::takeWhile;
            this.payloads.drop = ImmutableQuintupletonListTest::drop;
            this.payloads.drop_throws = ImmutableQuintupletonListTest::drop_throws;
            this.payloads.dropWhile = ImmutableQuintupletonListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableQuintupletonListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableQuintupletonListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableQuintupletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableQuintupletonListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableQuintupletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableQuintupletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableQuintupletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableQuintupletonListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableQuintupletonListTest::groupBy;
            this.payloads.groupByEach = ImmutableQuintupletonListTest::groupByEach;
            this.payloads.asReversed = ImmutableQuintupletonListTest::asReversed;
            this.payloads.toReversed = ImmutableQuintupletonListTest::toReversed;
            this.payloads.toImmutable = ImmutableQuintupletonListTest::toImmutable;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuintupletonListTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
