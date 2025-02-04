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

import java.util.ListIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSubListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return Lists.immutable.of(0, 1, 2, 3, 4, 5, 6, 7).subList(1, 5);
    }

    @Test
    public void testSubListListIterator() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertTrue(iterator.hasPrevious());
        Assert.assertEquals(Integer.valueOf(3), iterator.previous());
        Assert.assertEquals(Integer.valueOf(2), iterator.previous());
        Assert.assertEquals(Integer.valueOf(1), iterator.previous());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorSet_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.set(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorRemove_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListListIteratorAdd_throws() {
        ImmutableList<Integer> subList = this.classUnderTest();
        ListIterator<Integer> iterator = subList.listIterator();
        iterator.add(4);
    }

    @Test
    public void getOnly() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 2);
        Assert.assertEquals(Integer.valueOf(2), list.getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_empty() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 1);
        list.getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_multiple_items() {
        ImmutableList<Integer> list = Lists.immutable.of(1, 2, 3, 4, 5).subList(1, 3);
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableSubListTest instance;

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
        public void benchmark_testSubListListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorSet_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIteratorSet_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorRemove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIteratorRemove_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIteratorAdd_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIteratorAdd_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_exception_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_multiple_items() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_exception_when_multiple_items);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSubListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> testSubListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> testSubListListIteratorSet_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> testSubListListIteratorRemove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> testSubListListIteratorAdd_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> getOnly_exception_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSubListTest> getOnly_exception_when_multiple_items;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSubListTest::stream;
            this.payloads.parallelStream = ImmutableSubListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableSubListTest::countBy;
            this.payloads.countByWith = ImmutableSubListTest::countByWith;
            this.payloads.countByEach = ImmutableSubListTest::countByEach;
            this.payloads.selectWith = ImmutableSubListTest::selectWith;
            this.payloads.selectWith_target = ImmutableSubListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableSubListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableSubListTest::rejectWith_target;
            this.payloads.partition = ImmutableSubListTest::partition;
            this.payloads.partitionWith = ImmutableSubListTest::partitionWith;
            this.payloads.collectWith = ImmutableSubListTest::collectWith;
            this.payloads.collect_target = ImmutableSubListTest::collect_target;
            this.payloads.collectWith_target = ImmutableSubListTest::collectWith_target;
            this.payloads.injectInto = ImmutableSubListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableSubListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSubListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSubListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSubListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSubListTest::sumFloat;
            this.payloads.sumDouble = ImmutableSubListTest::sumDouble;
            this.payloads.sumInteger = ImmutableSubListTest::sumInteger;
            this.payloads.sumLong = ImmutableSubListTest::sumLong;
            this.payloads.sumByInt = ImmutableSubListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSubListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSubListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSubListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSubListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSubListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableSubListTest::makeString;
            this.payloads.appendString = ImmutableSubListTest::appendString;
            this.payloads.testToString = ImmutableSubListTest::testToString;
            this.payloads.select = ImmutableSubListTest::select;
            this.payloads.selectInstancesOf = ImmutableSubListTest::selectInstancesOf;
            this.payloads.reject = ImmutableSubListTest::reject;
            this.payloads.collect = ImmutableSubListTest::collect;
            this.payloads.collectByte = ImmutableSubListTest::collectByte;
            this.payloads.collectChar = ImmutableSubListTest::collectChar;
            this.payloads.collectDouble = ImmutableSubListTest::collectDouble;
            this.payloads.collectFloat = ImmutableSubListTest::collectFloat;
            this.payloads.collectInt = ImmutableSubListTest::collectInt;
            this.payloads.collectLong = ImmutableSubListTest::collectLong;
            this.payloads.collectShort = ImmutableSubListTest::collectShort;
            this.payloads.flatCollect = ImmutableSubListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableSubListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableSubListTest::detect;
            this.payloads.detectWith = ImmutableSubListTest::detectWith;
            this.payloads.detectIfNone = ImmutableSubListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableSubListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableSubListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableSubListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSubListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSubListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableSubListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableSubListTest::anySatisfyWith;
            this.payloads.count = ImmutableSubListTest::count;
            this.payloads.countWith = ImmutableSubListTest::countWith;
            this.payloads.collectIf = ImmutableSubListTest::collectIf;
            this.payloads.getFirst = ImmutableSubListTest::getFirst;
            this.payloads.getLast = ImmutableSubListTest::getLast;
            this.payloads.isEmpty = ImmutableSubListTest::isEmpty;
            this.payloads.iterator = ImmutableSubListTest::iterator;
            this.payloads.toArray = ImmutableSubListTest::toArray;
            this.payloads.toSortedList = ImmutableSubListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableSubListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableSubListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableSubListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableSubListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableSubListTest::min;
            this.payloads.max = ImmutableSubListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableSubListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSubListTest::max_without_comparator;
            this.payloads.minBy = ImmutableSubListTest::minBy;
            this.payloads.maxBy = ImmutableSubListTest::maxBy;
            this.payloads.iteratorRemove = ImmutableSubListTest::iteratorRemove;
            this.payloads.add = ImmutableSubListTest::add;
            this.payloads.remove = ImmutableSubListTest::remove;
            this.payloads.clear = ImmutableSubListTest::clear;
            this.payloads.removeAll = ImmutableSubListTest::removeAll;
            this.payloads.retainAll = ImmutableSubListTest::retainAll;
            this.payloads.addAll = ImmutableSubListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableSubListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSubListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableSubListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableSubListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableSubListTest::contains;
            this.payloads.containsAll = ImmutableSubListTest::containsAll;
            this.payloads.containsAllArray = ImmutableSubListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableSubListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableSubListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableSubListTest::lastIndexOf;
            this.payloads.get = ImmutableSubListTest::get;
            this.payloads.forEach = ImmutableSubListTest::forEach;
            this.payloads.each = ImmutableSubListTest::each;
            this.payloads.reverseForEach = ImmutableSubListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableSubListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableSubListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableSubListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableSubListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableSubListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSubListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableSubListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableSubListTest::detectLastIndex;
            this.payloads.select_target = ImmutableSubListTest::select_target;
            this.payloads.reject_target = ImmutableSubListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableSubListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableSubListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableSubListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableSubListTest::distinctBy;
            this.payloads.zip = ImmutableSubListTest::zip;
            this.payloads.zipWithIndex = ImmutableSubListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableSubListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableSubListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableSubListTest::toList;
            this.payloads.toSortedListBy = ImmutableSubListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableSubListTest::removeAtIndex;
            this.payloads.set = ImmutableSubListTest::set;
            this.payloads.addAtIndex = ImmutableSubListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableSubListTest::addAllAtIndex;
            this.payloads.sort = ImmutableSubListTest::sort;
            this.payloads.replaceAll = ImmutableSubListTest::replaceAll;
            this.payloads.subList = ImmutableSubListTest::subList;
            this.payloads.subListFromNegative = ImmutableSubListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableSubListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableSubListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableSubListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableSubListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableSubListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableSubListTest::toStack;
            this.payloads.take = ImmutableSubListTest::take;
            this.payloads.take_throws = ImmutableSubListTest::take_throws;
            this.payloads.takeWhile = ImmutableSubListTest::takeWhile;
            this.payloads.drop = ImmutableSubListTest::drop;
            this.payloads.drop_throws = ImmutableSubListTest::drop_throws;
            this.payloads.dropWhile = ImmutableSubListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableSubListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableSubListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableSubListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableSubListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableSubListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableSubListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableSubListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableSubListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableSubListTest::groupBy;
            this.payloads.groupByEach = ImmutableSubListTest::groupByEach;
            this.payloads.asReversed = ImmutableSubListTest::asReversed;
            this.payloads.toReversed = ImmutableSubListTest::toReversed;
            this.payloads.toImmutable = ImmutableSubListTest::toImmutable;
            this.payloads.testSubListListIterator = ImmutableSubListTest::testSubListListIterator;
            this.payloads.testSubListListIteratorSet_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::testSubListListIteratorSet_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.testSubListListIteratorRemove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::testSubListListIteratorRemove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.testSubListListIteratorAdd_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::testSubListListIteratorAdd_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getOnly = ImmutableSubListTest::getOnly;
            this.payloads.getOnly_exception_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::getOnly_exception_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_exception_when_multiple_items = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSubListTest::getOnly_exception_when_multiple_items, java.lang.IllegalStateException.class);
        }
    }
}
