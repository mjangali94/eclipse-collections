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
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class ImmutableDecapletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableDecapletonList<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Override
    @Test
    public void toSortedSetBy() {
        MutableList<Integer> expected = TreeSortedSet.newSetWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").collect(Integer::valueOf);
        MutableList<Integer> sortedList = this.classUnderTest().toSortedSetBy(String::valueOf).toList();
        Verify.assertListsEqual(expected, sortedList);
    }

    @Test
    public void selectInstanceOf() {
        ImmutableList<Number> numbers = new ImmutableDecapletonList<>(1, 2.0, 3, 4.0, 5, 6.0, 7, 8.0, 9, 10.0);
        Assert.assertEquals(iList(1, 3, 5, 7, 9), numbers.selectInstancesOf(Integer.class));
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableDecapletonListTest instance;

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
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstanceOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstanceOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDecapletonListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> selectInstanceOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDecapletonListTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableDecapletonListTest::stream;
            this.payloads.parallelStream = ImmutableDecapletonListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableDecapletonListTest::countBy;
            this.payloads.countByWith = ImmutableDecapletonListTest::countByWith;
            this.payloads.countByEach = ImmutableDecapletonListTest::countByEach;
            this.payloads.selectWith = ImmutableDecapletonListTest::selectWith;
            this.payloads.selectWith_target = ImmutableDecapletonListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableDecapletonListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableDecapletonListTest::rejectWith_target;
            this.payloads.partition = ImmutableDecapletonListTest::partition;
            this.payloads.partitionWith = ImmutableDecapletonListTest::partitionWith;
            this.payloads.collectWith = ImmutableDecapletonListTest::collectWith;
            this.payloads.collect_target = ImmutableDecapletonListTest::collect_target;
            this.payloads.collectWith_target = ImmutableDecapletonListTest::collectWith_target;
            this.payloads.injectInto = ImmutableDecapletonListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableDecapletonListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableDecapletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDecapletonListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableDecapletonListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableDecapletonListTest::sumFloat;
            this.payloads.sumDouble = ImmutableDecapletonListTest::sumDouble;
            this.payloads.sumInteger = ImmutableDecapletonListTest::sumInteger;
            this.payloads.sumLong = ImmutableDecapletonListTest::sumLong;
            this.payloads.sumByInt = ImmutableDecapletonListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableDecapletonListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableDecapletonListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableDecapletonListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableDecapletonListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableDecapletonListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableDecapletonListTest::makeString;
            this.payloads.appendString = ImmutableDecapletonListTest::appendString;
            this.payloads.testToString = ImmutableDecapletonListTest::testToString;
            this.payloads.select = ImmutableDecapletonListTest::select;
            this.payloads.selectInstancesOf = ImmutableDecapletonListTest::selectInstancesOf;
            this.payloads.reject = ImmutableDecapletonListTest::reject;
            this.payloads.collect = ImmutableDecapletonListTest::collect;
            this.payloads.collectByte = ImmutableDecapletonListTest::collectByte;
            this.payloads.collectChar = ImmutableDecapletonListTest::collectChar;
            this.payloads.collectDouble = ImmutableDecapletonListTest::collectDouble;
            this.payloads.collectFloat = ImmutableDecapletonListTest::collectFloat;
            this.payloads.collectInt = ImmutableDecapletonListTest::collectInt;
            this.payloads.collectLong = ImmutableDecapletonListTest::collectLong;
            this.payloads.collectShort = ImmutableDecapletonListTest::collectShort;
            this.payloads.flatCollect = ImmutableDecapletonListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableDecapletonListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableDecapletonListTest::detect;
            this.payloads.detectWith = ImmutableDecapletonListTest::detectWith;
            this.payloads.detectIfNone = ImmutableDecapletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableDecapletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableDecapletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableDecapletonListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableDecapletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableDecapletonListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableDecapletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableDecapletonListTest::anySatisfyWith;
            this.payloads.count = ImmutableDecapletonListTest::count;
            this.payloads.countWith = ImmutableDecapletonListTest::countWith;
            this.payloads.collectIf = ImmutableDecapletonListTest::collectIf;
            this.payloads.getFirst = ImmutableDecapletonListTest::getFirst;
            this.payloads.getLast = ImmutableDecapletonListTest::getLast;
            this.payloads.isEmpty = ImmutableDecapletonListTest::isEmpty;
            this.payloads.iterator = ImmutableDecapletonListTest::iterator;
            this.payloads.toArray = ImmutableDecapletonListTest::toArray;
            this.payloads.toSortedList = ImmutableDecapletonListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableDecapletonListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableDecapletonListTest::toSortedSetWithComparator;
            this.payloads.forLoop = ImmutableDecapletonListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableDecapletonListTest::min;
            this.payloads.max = ImmutableDecapletonListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableDecapletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableDecapletonListTest::max_without_comparator;
            this.payloads.minBy = ImmutableDecapletonListTest::minBy;
            this.payloads.maxBy = ImmutableDecapletonListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableDecapletonListTest::iteratorRemove;
            this.payloads.add = ImmutableDecapletonListTest::add;
            this.payloads.remove = ImmutableDecapletonListTest::remove;
            this.payloads.clear = ImmutableDecapletonListTest::clear;
            this.payloads.removeAll = ImmutableDecapletonListTest::removeAll;
            this.payloads.retainAll = ImmutableDecapletonListTest::retainAll;
            this.payloads.addAll = ImmutableDecapletonListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableDecapletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableDecapletonListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableDecapletonListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableDecapletonListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableDecapletonListTest::contains;
            this.payloads.containsAll = ImmutableDecapletonListTest::containsAll;
            this.payloads.containsAllArray = ImmutableDecapletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDecapletonListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableDecapletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableDecapletonListTest::lastIndexOf;
            this.payloads.get = ImmutableDecapletonListTest::get;
            this.payloads.forEach = ImmutableDecapletonListTest::forEach;
            this.payloads.each = ImmutableDecapletonListTest::each;
            this.payloads.reverseForEach = ImmutableDecapletonListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableDecapletonListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableDecapletonListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableDecapletonListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableDecapletonListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableDecapletonListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableDecapletonListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableDecapletonListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableDecapletonListTest::detectLastIndex;
            this.payloads.select_target = ImmutableDecapletonListTest::select_target;
            this.payloads.reject_target = ImmutableDecapletonListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableDecapletonListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableDecapletonListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableDecapletonListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableDecapletonListTest::distinctBy;
            this.payloads.zip = ImmutableDecapletonListTest::zip;
            this.payloads.zipWithIndex = ImmutableDecapletonListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableDecapletonListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableDecapletonListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableDecapletonListTest::toList;
            this.payloads.toSortedListBy = ImmutableDecapletonListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableDecapletonListTest::removeAtIndex;
            this.payloads.set = ImmutableDecapletonListTest::set;
            this.payloads.addAtIndex = ImmutableDecapletonListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableDecapletonListTest::addAllAtIndex;
            this.payloads.sort = ImmutableDecapletonListTest::sort;
            this.payloads.replaceAll = ImmutableDecapletonListTest::replaceAll;
            this.payloads.subList = ImmutableDecapletonListTest::subList;
            this.payloads.subListFromNegative = ImmutableDecapletonListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableDecapletonListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableDecapletonListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableDecapletonListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableDecapletonListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableDecapletonListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableDecapletonListTest::toStack;
            this.payloads.take = ImmutableDecapletonListTest::take;
            this.payloads.take_throws = ImmutableDecapletonListTest::take_throws;
            this.payloads.takeWhile = ImmutableDecapletonListTest::takeWhile;
            this.payloads.drop = ImmutableDecapletonListTest::drop;
            this.payloads.drop_throws = ImmutableDecapletonListTest::drop_throws;
            this.payloads.dropWhile = ImmutableDecapletonListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableDecapletonListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableDecapletonListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableDecapletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableDecapletonListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableDecapletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableDecapletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableDecapletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableDecapletonListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableDecapletonListTest::groupBy;
            this.payloads.groupByEach = ImmutableDecapletonListTest::groupByEach;
            this.payloads.asReversed = ImmutableDecapletonListTest::asReversed;
            this.payloads.toReversed = ImmutableDecapletonListTest::toReversed;
            this.payloads.toImmutable = ImmutableDecapletonListTest::toImmutable;
            this.payloads.toSortedSetBy = ImmutableDecapletonListTest::toSortedSetBy;
            this.payloads.selectInstanceOf = ImmutableDecapletonListTest::selectInstanceOf;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDecapletonListTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
