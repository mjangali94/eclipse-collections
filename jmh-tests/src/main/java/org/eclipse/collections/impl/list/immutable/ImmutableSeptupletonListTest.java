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

public class ImmutableSeptupletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableSeptupletonList<>(1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableSeptupletonListTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSeptupletonListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSeptupletonListTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSeptupletonListTest::stream;
            this.payloads.parallelStream = ImmutableSeptupletonListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableSeptupletonListTest::countBy;
            this.payloads.countByWith = ImmutableSeptupletonListTest::countByWith;
            this.payloads.countByEach = ImmutableSeptupletonListTest::countByEach;
            this.payloads.selectWith = ImmutableSeptupletonListTest::selectWith;
            this.payloads.selectWith_target = ImmutableSeptupletonListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableSeptupletonListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableSeptupletonListTest::rejectWith_target;
            this.payloads.partition = ImmutableSeptupletonListTest::partition;
            this.payloads.partitionWith = ImmutableSeptupletonListTest::partitionWith;
            this.payloads.collectWith = ImmutableSeptupletonListTest::collectWith;
            this.payloads.collect_target = ImmutableSeptupletonListTest::collect_target;
            this.payloads.collectWith_target = ImmutableSeptupletonListTest::collectWith_target;
            this.payloads.injectInto = ImmutableSeptupletonListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableSeptupletonListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSeptupletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSeptupletonListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSeptupletonListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSeptupletonListTest::sumFloat;
            this.payloads.sumDouble = ImmutableSeptupletonListTest::sumDouble;
            this.payloads.sumInteger = ImmutableSeptupletonListTest::sumInteger;
            this.payloads.sumLong = ImmutableSeptupletonListTest::sumLong;
            this.payloads.sumByInt = ImmutableSeptupletonListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSeptupletonListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSeptupletonListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSeptupletonListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSeptupletonListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSeptupletonListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableSeptupletonListTest::makeString;
            this.payloads.appendString = ImmutableSeptupletonListTest::appendString;
            this.payloads.testToString = ImmutableSeptupletonListTest::testToString;
            this.payloads.select = ImmutableSeptupletonListTest::select;
            this.payloads.selectInstancesOf = ImmutableSeptupletonListTest::selectInstancesOf;
            this.payloads.reject = ImmutableSeptupletonListTest::reject;
            this.payloads.collect = ImmutableSeptupletonListTest::collect;
            this.payloads.collectByte = ImmutableSeptupletonListTest::collectByte;
            this.payloads.collectChar = ImmutableSeptupletonListTest::collectChar;
            this.payloads.collectDouble = ImmutableSeptupletonListTest::collectDouble;
            this.payloads.collectFloat = ImmutableSeptupletonListTest::collectFloat;
            this.payloads.collectInt = ImmutableSeptupletonListTest::collectInt;
            this.payloads.collectLong = ImmutableSeptupletonListTest::collectLong;
            this.payloads.collectShort = ImmutableSeptupletonListTest::collectShort;
            this.payloads.flatCollect = ImmutableSeptupletonListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableSeptupletonListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableSeptupletonListTest::detect;
            this.payloads.detectWith = ImmutableSeptupletonListTest::detectWith;
            this.payloads.detectIfNone = ImmutableSeptupletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableSeptupletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableSeptupletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableSeptupletonListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSeptupletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSeptupletonListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableSeptupletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableSeptupletonListTest::anySatisfyWith;
            this.payloads.count = ImmutableSeptupletonListTest::count;
            this.payloads.countWith = ImmutableSeptupletonListTest::countWith;
            this.payloads.collectIf = ImmutableSeptupletonListTest::collectIf;
            this.payloads.getFirst = ImmutableSeptupletonListTest::getFirst;
            this.payloads.getLast = ImmutableSeptupletonListTest::getLast;
            this.payloads.isEmpty = ImmutableSeptupletonListTest::isEmpty;
            this.payloads.iterator = ImmutableSeptupletonListTest::iterator;
            this.payloads.toArray = ImmutableSeptupletonListTest::toArray;
            this.payloads.toSortedList = ImmutableSeptupletonListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableSeptupletonListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableSeptupletonListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableSeptupletonListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableSeptupletonListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableSeptupletonListTest::min;
            this.payloads.max = ImmutableSeptupletonListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableSeptupletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSeptupletonListTest::max_without_comparator;
            this.payloads.minBy = ImmutableSeptupletonListTest::minBy;
            this.payloads.maxBy = ImmutableSeptupletonListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableSeptupletonListTest::iteratorRemove;
            this.payloads.add = ImmutableSeptupletonListTest::add;
            this.payloads.remove = ImmutableSeptupletonListTest::remove;
            this.payloads.clear = ImmutableSeptupletonListTest::clear;
            this.payloads.removeAll = ImmutableSeptupletonListTest::removeAll;
            this.payloads.retainAll = ImmutableSeptupletonListTest::retainAll;
            this.payloads.addAll = ImmutableSeptupletonListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableSeptupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSeptupletonListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableSeptupletonListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableSeptupletonListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableSeptupletonListTest::contains;
            this.payloads.containsAll = ImmutableSeptupletonListTest::containsAll;
            this.payloads.containsAllArray = ImmutableSeptupletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableSeptupletonListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableSeptupletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableSeptupletonListTest::lastIndexOf;
            this.payloads.get = ImmutableSeptupletonListTest::get;
            this.payloads.forEach = ImmutableSeptupletonListTest::forEach;
            this.payloads.each = ImmutableSeptupletonListTest::each;
            this.payloads.reverseForEach = ImmutableSeptupletonListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableSeptupletonListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableSeptupletonListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableSeptupletonListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableSeptupletonListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableSeptupletonListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSeptupletonListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableSeptupletonListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableSeptupletonListTest::detectLastIndex;
            this.payloads.select_target = ImmutableSeptupletonListTest::select_target;
            this.payloads.reject_target = ImmutableSeptupletonListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableSeptupletonListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableSeptupletonListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableSeptupletonListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableSeptupletonListTest::distinctBy;
            this.payloads.zip = ImmutableSeptupletonListTest::zip;
            this.payloads.zipWithIndex = ImmutableSeptupletonListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableSeptupletonListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableSeptupletonListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableSeptupletonListTest::toList;
            this.payloads.toSortedListBy = ImmutableSeptupletonListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableSeptupletonListTest::removeAtIndex;
            this.payloads.set = ImmutableSeptupletonListTest::set;
            this.payloads.addAtIndex = ImmutableSeptupletonListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableSeptupletonListTest::addAllAtIndex;
            this.payloads.sort = ImmutableSeptupletonListTest::sort;
            this.payloads.replaceAll = ImmutableSeptupletonListTest::replaceAll;
            this.payloads.subList = ImmutableSeptupletonListTest::subList;
            this.payloads.subListFromNegative = ImmutableSeptupletonListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableSeptupletonListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableSeptupletonListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableSeptupletonListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableSeptupletonListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableSeptupletonListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableSeptupletonListTest::toStack;
            this.payloads.take = ImmutableSeptupletonListTest::take;
            this.payloads.take_throws = ImmutableSeptupletonListTest::take_throws;
            this.payloads.takeWhile = ImmutableSeptupletonListTest::takeWhile;
            this.payloads.drop = ImmutableSeptupletonListTest::drop;
            this.payloads.drop_throws = ImmutableSeptupletonListTest::drop_throws;
            this.payloads.dropWhile = ImmutableSeptupletonListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableSeptupletonListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableSeptupletonListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableSeptupletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableSeptupletonListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableSeptupletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableSeptupletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableSeptupletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableSeptupletonListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableSeptupletonListTest::groupBy;
            this.payloads.groupByEach = ImmutableSeptupletonListTest::groupByEach;
            this.payloads.asReversed = ImmutableSeptupletonListTest::asReversed;
            this.payloads.toReversed = ImmutableSeptupletonListTest::toReversed;
            this.payloads.toImmutable = ImmutableSeptupletonListTest::toImmutable;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSeptupletonListTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
