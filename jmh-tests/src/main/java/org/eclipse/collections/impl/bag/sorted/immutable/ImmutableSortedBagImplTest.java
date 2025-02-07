/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.immutable;

import java.util.Collections;
import java.util.Comparator;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSortedBagImplTest extends AbstractImmutableSortedBagTestCase {

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest() {
        return SortedBags.immutable.with(1, 1, 1, 2);
    }

    @Override
    protected <T> MutableCollection<T> newMutable() {
        return SortedBags.mutable.empty();
    }

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedBags.immutable.with(comparator, 1, 1, 1, 2);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(T... elements) {
        return SortedBags.immutable.with(elements);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return SortedBags.immutable.with(comparator, elements);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = this.classUnderTest(comparator);
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.with(comparator, 2);
        ImmutableSortedSet<Integer> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.comparator(), actual.comparator());
    }

    @Override
    @Test
    public void distinctView() {
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = this.classUnderTest(comparator);
        RichIterable<Integer> expected = bag.toSortedSet(comparator);
        RichIterable<Integer> actual = bag.distinctView();
        // this assertion is a reminder to get rid of this test override once distinctView returns a set
        Assert.assertNotEquals(expected, actual);
        // test sorting
        Verify.assertIterablesEqual(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableSortedBagImplTest instance;

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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
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
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_noSupportForNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSupportForNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithTest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
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
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
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
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_collectIfToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfToTarget);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
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
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
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
        public void benchmark_collectBoolean_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
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
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSortedBagImplTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> newWithTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectBoolean_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectByte_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectChar_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectDouble_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectFloat_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectInt_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectLong_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> collectShort_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSortedBagImplTest::stream;
            this.payloads.parallelStream = ImmutableSortedBagImplTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableSortedBagImplTest::countBy;
            this.payloads.countByWith = ImmutableSortedBagImplTest::countByWith;
            this.payloads.countByEach = ImmutableSortedBagImplTest::countByEach;
            this.payloads.selectWith_target = ImmutableSortedBagImplTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableSortedBagImplTest::rejectWith_target;
            this.payloads.collect_target = ImmutableSortedBagImplTest::collect_target;
            this.payloads.collectWith_target = ImmutableSortedBagImplTest::collectWith_target;
            this.payloads.injectIntoInt = ImmutableSortedBagImplTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSortedBagImplTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSortedBagImplTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSortedBagImplTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSortedBagImplTest::sumFloat;
            this.payloads.sumDouble = ImmutableSortedBagImplTest::sumDouble;
            this.payloads.sumInteger = ImmutableSortedBagImplTest::sumInteger;
            this.payloads.sumLong = ImmutableSortedBagImplTest::sumLong;
            this.payloads.sumByInt = ImmutableSortedBagImplTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSortedBagImplTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSortedBagImplTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSortedBagImplTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSortedBagImplTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSortedBagImplTest::sumByDoubleConsistentRounding;
            this.payloads.flatCollectWith = ImmutableSortedBagImplTest::flatCollectWith;
            this.payloads.allSatisfyWith = ImmutableSortedBagImplTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSortedBagImplTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSortedBagImplTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableSortedBagImplTest::anySatisfyWith;
            this.payloads.countWith = ImmutableSortedBagImplTest::countWith;
            this.payloads.toSortedSetBy = ImmutableSortedBagImplTest::toSortedSetBy;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iteratorRemove = ImmutableSortedBagImplTest::iteratorRemove;
            this.payloads.add = ImmutableSortedBagImplTest::add;
            this.payloads.remove = ImmutableSortedBagImplTest::remove;
            this.payloads.clear = ImmutableSortedBagImplTest::clear;
            this.payloads.removeAll = ImmutableSortedBagImplTest::removeAll;
            this.payloads.retainAll = ImmutableSortedBagImplTest::retainAll;
            this.payloads.addAll = ImmutableSortedBagImplTest::addAll;
            this.payloads.aggregateByMutating = ImmutableSortedBagImplTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSortedBagImplTest::aggregateByNonMutating;
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.equalsAndHashCode = ImmutableSortedBagImplTest::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableSortedBagImplTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableSortedBagImplTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableSortedBagImplTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableSortedBagImplTest::detectWithOccurrences;
            this.payloads.compareTo = ImmutableSortedBagImplTest::compareTo;
            this.payloads.selectByOccurrences = ImmutableSortedBagImplTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableSortedBagImplTest::selectDuplicates;
            this.payloads.newWithTest = ImmutableSortedBagImplTest::newWithTest;
            this.payloads.newWithout = ImmutableSortedBagImplTest::newWithout;
            this.payloads.newWithAll = ImmutableSortedBagImplTest::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableSortedBagImplTest::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableSortedBagImplTest::newWithoutAll;
            this.payloads.size = ImmutableSortedBagImplTest::size;
            this.payloads.contains = ImmutableSortedBagImplTest::contains;
            this.payloads.containsAllArray = ImmutableSortedBagImplTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableSortedBagImplTest::containsAllIterable;
            this.payloads.containsAll = ImmutableSortedBagImplTest::containsAll;
            this.payloads.tap = ImmutableSortedBagImplTest::tap;
            this.payloads.forEach = ImmutableSortedBagImplTest::forEach;
            this.payloads.forEachWith = ImmutableSortedBagImplTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSortedBagImplTest::forEachWithIndex;
            this.payloads.toSortedSet = ImmutableSortedBagImplTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableSortedBagImplTest::toSortedSetWithComparator;
            this.payloads.select = ImmutableSortedBagImplTest::select;
            this.payloads.selectWith = ImmutableSortedBagImplTest::selectWith;
            this.payloads.selectToTarget = ImmutableSortedBagImplTest::selectToTarget;
            this.payloads.reject = ImmutableSortedBagImplTest::reject;
            this.payloads.rejectWith = ImmutableSortedBagImplTest::rejectWith;
            this.payloads.rejectToTarget = ImmutableSortedBagImplTest::rejectToTarget;
            this.payloads.selectInstancesOf = ImmutableSortedBagImplTest::selectInstancesOf;
            this.payloads.partition = ImmutableSortedBagImplTest::partition;
            this.payloads.partitionWith = ImmutableSortedBagImplTest::partitionWith;
            this.payloads.partitionWhile = ImmutableSortedBagImplTest::partitionWhile;
            this.payloads.takeWhile = ImmutableSortedBagImplTest::takeWhile;
            this.payloads.dropWhile = ImmutableSortedBagImplTest::dropWhile;
            this.payloads.collect = ImmutableSortedBagImplTest::collect;
            this.payloads.collectWithIndex = ImmutableSortedBagImplTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableSortedBagImplTest::collectWithIndexWithTarget;
            this.payloads.collectWith = ImmutableSortedBagImplTest::collectWith;
            this.payloads.collectToTarget = ImmutableSortedBagImplTest::collectToTarget;
            this.payloads.flatCollect = ImmutableSortedBagImplTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableSortedBagImplTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableSortedBagImplTest::zip;
            this.payloads.zipWithIndex = ImmutableSortedBagImplTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableSortedBagImplTest::chunk_large_size;
            this.payloads.detect = ImmutableSortedBagImplTest::detect;
            this.payloads.detectWith = ImmutableSortedBagImplTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableSortedBagImplTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableSortedBagImplTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableSortedBagImplTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableSortedBagImplTest::anySatisfy;
            this.payloads.count = ImmutableSortedBagImplTest::count;
            this.payloads.collectIf = ImmutableSortedBagImplTest::collectIf;
            this.payloads.collectIfToTarget = ImmutableSortedBagImplTest::collectIfToTarget;
            this.payloads.getFirst = ImmutableSortedBagImplTest::getFirst;
            this.payloads.getLast = ImmutableSortedBagImplTest::getLast;
            this.payloads.isEmpty = ImmutableSortedBagImplTest::isEmpty;
            this.payloads.iterator = ImmutableSortedBagImplTest::iterator;
            this.payloads.injectInto = ImmutableSortedBagImplTest::injectInto;
            this.payloads.toArray = ImmutableSortedBagImplTest::toArray;
            this.payloads.testToString = ImmutableSortedBagImplTest::testToString;
            this.payloads.makeString = ImmutableSortedBagImplTest::makeString;
            this.payloads.appendString = ImmutableSortedBagImplTest::appendString;
            this.payloads.toList = ImmutableSortedBagImplTest::toList;
            this.payloads.toSortedList = ImmutableSortedBagImplTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableSortedBagImplTest::toSortedListBy;
            this.payloads.toSortedBag = ImmutableSortedBagImplTest::toSortedBag;
            this.payloads.toSortedBagWithComparator = ImmutableSortedBagImplTest::toSortedBagWithComparator;
            this.payloads.toSortedBagBy = ImmutableSortedBagImplTest::toSortedBagBy;
            this.payloads.toSortedMap = ImmutableSortedBagImplTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableSortedBagImplTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableSortedBagImplTest::toSortedMapBy;
            this.payloads.forLoop = ImmutableSortedBagImplTest::forLoop;
            this.payloads.toMapOfItemToCount = ImmutableSortedBagImplTest::toMapOfItemToCount;
            this.payloads.min = ImmutableSortedBagImplTest::min;
            this.payloads.max = ImmutableSortedBagImplTest::max;
            this.payloads.min_without_comparator = ImmutableSortedBagImplTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSortedBagImplTest::max_without_comparator;
            this.payloads.minBy = ImmutableSortedBagImplTest::minBy;
            this.payloads.maxBy = ImmutableSortedBagImplTest::maxBy;
            this.payloads.groupBy = ImmutableSortedBagImplTest::groupBy;
            this.payloads.groupByEach = ImmutableSortedBagImplTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableSortedBagImplTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableSortedBagImplTest::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = ImmutableSortedBagImplTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableSortedBagImplTest::groupByUniqueKey_target;
            this.payloads.distinct = ImmutableSortedBagImplTest::distinct;
            this.payloads.toStack = ImmutableSortedBagImplTest::toStack;
            this.payloads.collectBoolean = ImmutableSortedBagImplTest::collectBoolean;
            this.payloads.collectByte = ImmutableSortedBagImplTest::collectByte;
            this.payloads.collectChar = ImmutableSortedBagImplTest::collectChar;
            this.payloads.collectDouble = ImmutableSortedBagImplTest::collectDouble;
            this.payloads.collectFloat = ImmutableSortedBagImplTest::collectFloat;
            this.payloads.collectInt = ImmutableSortedBagImplTest::collectInt;
            this.payloads.collectLong = ImmutableSortedBagImplTest::collectLong;
            this.payloads.collectShort = ImmutableSortedBagImplTest::collectShort;
            this.payloads.collectBoolean_target = ImmutableSortedBagImplTest::collectBoolean_target;
            this.payloads.collectByte_target = ImmutableSortedBagImplTest::collectByte_target;
            this.payloads.collectChar_target = ImmutableSortedBagImplTest::collectChar_target;
            this.payloads.collectDouble_target = ImmutableSortedBagImplTest::collectDouble_target;
            this.payloads.collectFloat_target = ImmutableSortedBagImplTest::collectFloat_target;
            this.payloads.collectInt_target = ImmutableSortedBagImplTest::collectInt_target;
            this.payloads.collectLong_target = ImmutableSortedBagImplTest::collectLong_target;
            this.payloads.collectShort_target = ImmutableSortedBagImplTest::collectShort_target;
            this.payloads.occurrencesOf = ImmutableSortedBagImplTest::occurrencesOf;
            this.payloads.toImmutable = ImmutableSortedBagImplTest::toImmutable;
            this.payloads.forEachFromTo = ImmutableSortedBagImplTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = ImmutableSortedBagImplTest::forEachWithIndexWithFromTo;
            this.payloads.topOccurrences = ImmutableSortedBagImplTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableSortedBagImplTest::bottomOccurrences;
            this.payloads.corresponds = ImmutableSortedBagImplTest::corresponds;
            this.payloads.detectIndex = ImmutableSortedBagImplTest::detectIndex;
            this.payloads.indexOf = ImmutableSortedBagImplTest::indexOf;
            this.payloads.take = ImmutableSortedBagImplTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableSortedBagImplTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = ImmutableSortedBagImplTest::selectUnique;
            this.payloads.distinctView = ImmutableSortedBagImplTest::distinctView;
        }
    }
}
