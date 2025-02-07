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

public class ImmutableOctupletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableOctupletonList<>(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableOctupletonListTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableOctupletonListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableOctupletonListTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableOctupletonListTest::stream;
            this.payloads.parallelStream = ImmutableOctupletonListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableOctupletonListTest::countBy;
            this.payloads.countByWith = ImmutableOctupletonListTest::countByWith;
            this.payloads.countByEach = ImmutableOctupletonListTest::countByEach;
            this.payloads.selectWith = ImmutableOctupletonListTest::selectWith;
            this.payloads.selectWith_target = ImmutableOctupletonListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableOctupletonListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableOctupletonListTest::rejectWith_target;
            this.payloads.partition = ImmutableOctupletonListTest::partition;
            this.payloads.partitionWith = ImmutableOctupletonListTest::partitionWith;
            this.payloads.collectWith = ImmutableOctupletonListTest::collectWith;
            this.payloads.collect_target = ImmutableOctupletonListTest::collect_target;
            this.payloads.collectWith_target = ImmutableOctupletonListTest::collectWith_target;
            this.payloads.injectInto = ImmutableOctupletonListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableOctupletonListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableOctupletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableOctupletonListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableOctupletonListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableOctupletonListTest::sumFloat;
            this.payloads.sumDouble = ImmutableOctupletonListTest::sumDouble;
            this.payloads.sumInteger = ImmutableOctupletonListTest::sumInteger;
            this.payloads.sumLong = ImmutableOctupletonListTest::sumLong;
            this.payloads.sumByInt = ImmutableOctupletonListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableOctupletonListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableOctupletonListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableOctupletonListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableOctupletonListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableOctupletonListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableOctupletonListTest::makeString;
            this.payloads.appendString = ImmutableOctupletonListTest::appendString;
            this.payloads.testToString = ImmutableOctupletonListTest::testToString;
            this.payloads.select = ImmutableOctupletonListTest::select;
            this.payloads.selectInstancesOf = ImmutableOctupletonListTest::selectInstancesOf;
            this.payloads.reject = ImmutableOctupletonListTest::reject;
            this.payloads.collect = ImmutableOctupletonListTest::collect;
            this.payloads.collectByte = ImmutableOctupletonListTest::collectByte;
            this.payloads.collectChar = ImmutableOctupletonListTest::collectChar;
            this.payloads.collectDouble = ImmutableOctupletonListTest::collectDouble;
            this.payloads.collectFloat = ImmutableOctupletonListTest::collectFloat;
            this.payloads.collectInt = ImmutableOctupletonListTest::collectInt;
            this.payloads.collectLong = ImmutableOctupletonListTest::collectLong;
            this.payloads.collectShort = ImmutableOctupletonListTest::collectShort;
            this.payloads.flatCollect = ImmutableOctupletonListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableOctupletonListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableOctupletonListTest::detect;
            this.payloads.detectWith = ImmutableOctupletonListTest::detectWith;
            this.payloads.detectIfNone = ImmutableOctupletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableOctupletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableOctupletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableOctupletonListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableOctupletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableOctupletonListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableOctupletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableOctupletonListTest::anySatisfyWith;
            this.payloads.count = ImmutableOctupletonListTest::count;
            this.payloads.countWith = ImmutableOctupletonListTest::countWith;
            this.payloads.collectIf = ImmutableOctupletonListTest::collectIf;
            this.payloads.getFirst = ImmutableOctupletonListTest::getFirst;
            this.payloads.getLast = ImmutableOctupletonListTest::getLast;
            this.payloads.isEmpty = ImmutableOctupletonListTest::isEmpty;
            this.payloads.iterator = ImmutableOctupletonListTest::iterator;
            this.payloads.toArray = ImmutableOctupletonListTest::toArray;
            this.payloads.toSortedList = ImmutableOctupletonListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableOctupletonListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableOctupletonListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableOctupletonListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableOctupletonListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableOctupletonListTest::min;
            this.payloads.max = ImmutableOctupletonListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableOctupletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableOctupletonListTest::max_without_comparator;
            this.payloads.minBy = ImmutableOctupletonListTest::minBy;
            this.payloads.maxBy = ImmutableOctupletonListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableOctupletonListTest::iteratorRemove;
            this.payloads.add = ImmutableOctupletonListTest::add;
            this.payloads.remove = ImmutableOctupletonListTest::remove;
            this.payloads.clear = ImmutableOctupletonListTest::clear;
            this.payloads.removeAll = ImmutableOctupletonListTest::removeAll;
            this.payloads.retainAll = ImmutableOctupletonListTest::retainAll;
            this.payloads.addAll = ImmutableOctupletonListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableOctupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableOctupletonListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableOctupletonListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableOctupletonListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableOctupletonListTest::contains;
            this.payloads.containsAll = ImmutableOctupletonListTest::containsAll;
            this.payloads.containsAllArray = ImmutableOctupletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableOctupletonListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableOctupletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableOctupletonListTest::lastIndexOf;
            this.payloads.get = ImmutableOctupletonListTest::get;
            this.payloads.forEach = ImmutableOctupletonListTest::forEach;
            this.payloads.each = ImmutableOctupletonListTest::each;
            this.payloads.reverseForEach = ImmutableOctupletonListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableOctupletonListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableOctupletonListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableOctupletonListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableOctupletonListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableOctupletonListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableOctupletonListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableOctupletonListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableOctupletonListTest::detectLastIndex;
            this.payloads.select_target = ImmutableOctupletonListTest::select_target;
            this.payloads.reject_target = ImmutableOctupletonListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableOctupletonListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableOctupletonListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableOctupletonListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableOctupletonListTest::distinctBy;
            this.payloads.zip = ImmutableOctupletonListTest::zip;
            this.payloads.zipWithIndex = ImmutableOctupletonListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableOctupletonListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableOctupletonListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableOctupletonListTest::toList;
            this.payloads.toSortedListBy = ImmutableOctupletonListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableOctupletonListTest::removeAtIndex;
            this.payloads.set = ImmutableOctupletonListTest::set;
            this.payloads.addAtIndex = ImmutableOctupletonListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableOctupletonListTest::addAllAtIndex;
            this.payloads.sort = ImmutableOctupletonListTest::sort;
            this.payloads.replaceAll = ImmutableOctupletonListTest::replaceAll;
            this.payloads.subList = ImmutableOctupletonListTest::subList;
            this.payloads.subListFromNegative = ImmutableOctupletonListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableOctupletonListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableOctupletonListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableOctupletonListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableOctupletonListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableOctupletonListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableOctupletonListTest::toStack;
            this.payloads.take = ImmutableOctupletonListTest::take;
            this.payloads.take_throws = ImmutableOctupletonListTest::take_throws;
            this.payloads.takeWhile = ImmutableOctupletonListTest::takeWhile;
            this.payloads.drop = ImmutableOctupletonListTest::drop;
            this.payloads.drop_throws = ImmutableOctupletonListTest::drop_throws;
            this.payloads.dropWhile = ImmutableOctupletonListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableOctupletonListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableOctupletonListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableOctupletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableOctupletonListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableOctupletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableOctupletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableOctupletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableOctupletonListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableOctupletonListTest::groupBy;
            this.payloads.groupByEach = ImmutableOctupletonListTest::groupByEach;
            this.payloads.asReversed = ImmutableOctupletonListTest::asReversed;
            this.payloads.toReversed = ImmutableOctupletonListTest::toReversed;
            this.payloads.toImmutable = ImmutableOctupletonListTest::toImmutable;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableOctupletonListTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
