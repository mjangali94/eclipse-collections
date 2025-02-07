/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.immutable;

import java.util.Comparator;
import java.util.Iterator;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.SortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.factory.SortedBags;
import org.junit.Test;

public class ImmutableSortedBagImplNoIteratorTest extends ImmutableSortedBagImplTest {

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest() {
        return new ImmutableSortedBagImplNoIterator<>(SortedBags.immutable.with(1, 1, 1, 2));
    }

    @Override
    protected <T> MutableCollection<T> newMutable() {
        return SortedBags.mutable.empty();
    }

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return new ImmutableSortedBagImplNoIterator<>(SortedBags.immutable.with(comparator, 1, 1, 1, 2));
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(T... elements) {
        ImmutableSortedBag<T> bag = SortedBags.immutable.with(elements);
        if (bag.isEmpty()) {
            return new ImmutableEmptySortedBagImplNoIterator<>(bag.comparator());
        }
        return new ImmutableSortedBagImplNoIterator<>(bag);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return new ImmutableSortedBagImplNoIterator<>(SortedBags.immutable.with(comparator, elements));
    }

    @Override
    @Test
    public void forLoop() {
        // not applicable
    }

    @Override
    public void iteratorRemove() {
        // not applicable
    }

    @Override
    public void stream() {
        // not applicable
    }

    @Override
    public void parallelStream() {
        // not applicable
    }

    private static final class ImmutableSortedBagImplNoIterator<T> extends ImmutableSortedBagImpl<T> {

        ImmutableSortedBagImplNoIterator(SortedBag<T> sortedBag) {
            super(sortedBag);
        }

        @Override
        public Iterator<T> iterator() {
            throw new AssertionError("No methods should delegate to iterator");
        }
    }

    private static final class ImmutableEmptySortedBagImplNoIterator<T> extends ImmutableEmptySortedBag<T> {

        ImmutableEmptySortedBagImplNoIterator(Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        public Iterator<T> iterator() {
            throw new AssertionError("No methods should delegate to iterator");
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableSortedBagImplNoIteratorTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSortedBagImplNoIteratorTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> newWithTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectBoolean_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectByte_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectChar_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectDouble_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectFloat_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectInt_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectLong_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> collectShort_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedBagImplNoIteratorTest> forLoop;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSortedBagImplNoIteratorTest::stream;
            this.payloads.parallelStream = ImmutableSortedBagImplNoIteratorTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableSortedBagImplNoIteratorTest::countBy;
            this.payloads.countByWith = ImmutableSortedBagImplNoIteratorTest::countByWith;
            this.payloads.countByEach = ImmutableSortedBagImplNoIteratorTest::countByEach;
            this.payloads.selectWith_target = ImmutableSortedBagImplNoIteratorTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableSortedBagImplNoIteratorTest::rejectWith_target;
            this.payloads.collect_target = ImmutableSortedBagImplNoIteratorTest::collect_target;
            this.payloads.collectWith_target = ImmutableSortedBagImplNoIteratorTest::collectWith_target;
            this.payloads.injectIntoInt = ImmutableSortedBagImplNoIteratorTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSortedBagImplNoIteratorTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSortedBagImplNoIteratorTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSortedBagImplNoIteratorTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSortedBagImplNoIteratorTest::sumFloat;
            this.payloads.sumDouble = ImmutableSortedBagImplNoIteratorTest::sumDouble;
            this.payloads.sumInteger = ImmutableSortedBagImplNoIteratorTest::sumInteger;
            this.payloads.sumLong = ImmutableSortedBagImplNoIteratorTest::sumLong;
            this.payloads.sumByInt = ImmutableSortedBagImplNoIteratorTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSortedBagImplNoIteratorTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSortedBagImplNoIteratorTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSortedBagImplNoIteratorTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSortedBagImplNoIteratorTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSortedBagImplNoIteratorTest::sumByDoubleConsistentRounding;
            this.payloads.flatCollectWith = ImmutableSortedBagImplNoIteratorTest::flatCollectWith;
            this.payloads.allSatisfyWith = ImmutableSortedBagImplNoIteratorTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSortedBagImplNoIteratorTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSortedBagImplNoIteratorTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableSortedBagImplNoIteratorTest::anySatisfyWith;
            this.payloads.countWith = ImmutableSortedBagImplNoIteratorTest::countWith;
            this.payloads.toSortedSetBy = ImmutableSortedBagImplNoIteratorTest::toSortedSetBy;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iteratorRemove = ImmutableSortedBagImplNoIteratorTest::iteratorRemove;
            this.payloads.add = ImmutableSortedBagImplNoIteratorTest::add;
            this.payloads.remove = ImmutableSortedBagImplNoIteratorTest::remove;
            this.payloads.clear = ImmutableSortedBagImplNoIteratorTest::clear;
            this.payloads.removeAll = ImmutableSortedBagImplNoIteratorTest::removeAll;
            this.payloads.retainAll = ImmutableSortedBagImplNoIteratorTest::retainAll;
            this.payloads.addAll = ImmutableSortedBagImplNoIteratorTest::addAll;
            this.payloads.aggregateByMutating = ImmutableSortedBagImplNoIteratorTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSortedBagImplNoIteratorTest::aggregateByNonMutating;
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.equalsAndHashCode = ImmutableSortedBagImplNoIteratorTest::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableSortedBagImplNoIteratorTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableSortedBagImplNoIteratorTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableSortedBagImplNoIteratorTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableSortedBagImplNoIteratorTest::detectWithOccurrences;
            this.payloads.compareTo = ImmutableSortedBagImplNoIteratorTest::compareTo;
            this.payloads.selectByOccurrences = ImmutableSortedBagImplNoIteratorTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableSortedBagImplNoIteratorTest::selectDuplicates;
            this.payloads.newWithTest = ImmutableSortedBagImplNoIteratorTest::newWithTest;
            this.payloads.newWithout = ImmutableSortedBagImplNoIteratorTest::newWithout;
            this.payloads.newWithAll = ImmutableSortedBagImplNoIteratorTest::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableSortedBagImplNoIteratorTest::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableSortedBagImplNoIteratorTest::newWithoutAll;
            this.payloads.size = ImmutableSortedBagImplNoIteratorTest::size;
            this.payloads.contains = ImmutableSortedBagImplNoIteratorTest::contains;
            this.payloads.containsAllArray = ImmutableSortedBagImplNoIteratorTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableSortedBagImplNoIteratorTest::containsAllIterable;
            this.payloads.containsAll = ImmutableSortedBagImplNoIteratorTest::containsAll;
            this.payloads.tap = ImmutableSortedBagImplNoIteratorTest::tap;
            this.payloads.forEach = ImmutableSortedBagImplNoIteratorTest::forEach;
            this.payloads.forEachWith = ImmutableSortedBagImplNoIteratorTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSortedBagImplNoIteratorTest::forEachWithIndex;
            this.payloads.toSortedSet = ImmutableSortedBagImplNoIteratorTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableSortedBagImplNoIteratorTest::toSortedSetWithComparator;
            this.payloads.select = ImmutableSortedBagImplNoIteratorTest::select;
            this.payloads.selectWith = ImmutableSortedBagImplNoIteratorTest::selectWith;
            this.payloads.selectToTarget = ImmutableSortedBagImplNoIteratorTest::selectToTarget;
            this.payloads.reject = ImmutableSortedBagImplNoIteratorTest::reject;
            this.payloads.rejectWith = ImmutableSortedBagImplNoIteratorTest::rejectWith;
            this.payloads.rejectToTarget = ImmutableSortedBagImplNoIteratorTest::rejectToTarget;
            this.payloads.selectInstancesOf = ImmutableSortedBagImplNoIteratorTest::selectInstancesOf;
            this.payloads.partition = ImmutableSortedBagImplNoIteratorTest::partition;
            this.payloads.partitionWith = ImmutableSortedBagImplNoIteratorTest::partitionWith;
            this.payloads.partitionWhile = ImmutableSortedBagImplNoIteratorTest::partitionWhile;
            this.payloads.takeWhile = ImmutableSortedBagImplNoIteratorTest::takeWhile;
            this.payloads.dropWhile = ImmutableSortedBagImplNoIteratorTest::dropWhile;
            this.payloads.collect = ImmutableSortedBagImplNoIteratorTest::collect;
            this.payloads.collectWithIndex = ImmutableSortedBagImplNoIteratorTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableSortedBagImplNoIteratorTest::collectWithIndexWithTarget;
            this.payloads.collectWith = ImmutableSortedBagImplNoIteratorTest::collectWith;
            this.payloads.collectToTarget = ImmutableSortedBagImplNoIteratorTest::collectToTarget;
            this.payloads.flatCollect = ImmutableSortedBagImplNoIteratorTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableSortedBagImplNoIteratorTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableSortedBagImplNoIteratorTest::zip;
            this.payloads.zipWithIndex = ImmutableSortedBagImplNoIteratorTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableSortedBagImplNoIteratorTest::chunk_large_size;
            this.payloads.detect = ImmutableSortedBagImplNoIteratorTest::detect;
            this.payloads.detectWith = ImmutableSortedBagImplNoIteratorTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableSortedBagImplNoIteratorTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableSortedBagImplNoIteratorTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableSortedBagImplNoIteratorTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableSortedBagImplNoIteratorTest::anySatisfy;
            this.payloads.count = ImmutableSortedBagImplNoIteratorTest::count;
            this.payloads.collectIf = ImmutableSortedBagImplNoIteratorTest::collectIf;
            this.payloads.collectIfToTarget = ImmutableSortedBagImplNoIteratorTest::collectIfToTarget;
            this.payloads.getFirst = ImmutableSortedBagImplNoIteratorTest::getFirst;
            this.payloads.getLast = ImmutableSortedBagImplNoIteratorTest::getLast;
            this.payloads.isEmpty = ImmutableSortedBagImplNoIteratorTest::isEmpty;
            this.payloads.iterator = ImmutableSortedBagImplNoIteratorTest::iterator;
            this.payloads.injectInto = ImmutableSortedBagImplNoIteratorTest::injectInto;
            this.payloads.toArray = ImmutableSortedBagImplNoIteratorTest::toArray;
            this.payloads.testToString = ImmutableSortedBagImplNoIteratorTest::testToString;
            this.payloads.makeString = ImmutableSortedBagImplNoIteratorTest::makeString;
            this.payloads.appendString = ImmutableSortedBagImplNoIteratorTest::appendString;
            this.payloads.toList = ImmutableSortedBagImplNoIteratorTest::toList;
            this.payloads.toSortedList = ImmutableSortedBagImplNoIteratorTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableSortedBagImplNoIteratorTest::toSortedListBy;
            this.payloads.toSortedBag = ImmutableSortedBagImplNoIteratorTest::toSortedBag;
            this.payloads.toSortedBagWithComparator = ImmutableSortedBagImplNoIteratorTest::toSortedBagWithComparator;
            this.payloads.toSortedBagBy = ImmutableSortedBagImplNoIteratorTest::toSortedBagBy;
            this.payloads.toSortedMap = ImmutableSortedBagImplNoIteratorTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableSortedBagImplNoIteratorTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableSortedBagImplNoIteratorTest::toSortedMapBy;
            this.payloads.toMapOfItemToCount = ImmutableSortedBagImplNoIteratorTest::toMapOfItemToCount;
            this.payloads.min = ImmutableSortedBagImplNoIteratorTest::min;
            this.payloads.max = ImmutableSortedBagImplNoIteratorTest::max;
            this.payloads.min_without_comparator = ImmutableSortedBagImplNoIteratorTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSortedBagImplNoIteratorTest::max_without_comparator;
            this.payloads.minBy = ImmutableSortedBagImplNoIteratorTest::minBy;
            this.payloads.maxBy = ImmutableSortedBagImplNoIteratorTest::maxBy;
            this.payloads.groupBy = ImmutableSortedBagImplNoIteratorTest::groupBy;
            this.payloads.groupByEach = ImmutableSortedBagImplNoIteratorTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableSortedBagImplNoIteratorTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableSortedBagImplNoIteratorTest::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = ImmutableSortedBagImplNoIteratorTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableSortedBagImplNoIteratorTest::groupByUniqueKey_target;
            this.payloads.distinct = ImmutableSortedBagImplNoIteratorTest::distinct;
            this.payloads.toStack = ImmutableSortedBagImplNoIteratorTest::toStack;
            this.payloads.collectBoolean = ImmutableSortedBagImplNoIteratorTest::collectBoolean;
            this.payloads.collectByte = ImmutableSortedBagImplNoIteratorTest::collectByte;
            this.payloads.collectChar = ImmutableSortedBagImplNoIteratorTest::collectChar;
            this.payloads.collectDouble = ImmutableSortedBagImplNoIteratorTest::collectDouble;
            this.payloads.collectFloat = ImmutableSortedBagImplNoIteratorTest::collectFloat;
            this.payloads.collectInt = ImmutableSortedBagImplNoIteratorTest::collectInt;
            this.payloads.collectLong = ImmutableSortedBagImplNoIteratorTest::collectLong;
            this.payloads.collectShort = ImmutableSortedBagImplNoIteratorTest::collectShort;
            this.payloads.collectBoolean_target = ImmutableSortedBagImplNoIteratorTest::collectBoolean_target;
            this.payloads.collectByte_target = ImmutableSortedBagImplNoIteratorTest::collectByte_target;
            this.payloads.collectChar_target = ImmutableSortedBagImplNoIteratorTest::collectChar_target;
            this.payloads.collectDouble_target = ImmutableSortedBagImplNoIteratorTest::collectDouble_target;
            this.payloads.collectFloat_target = ImmutableSortedBagImplNoIteratorTest::collectFloat_target;
            this.payloads.collectInt_target = ImmutableSortedBagImplNoIteratorTest::collectInt_target;
            this.payloads.collectLong_target = ImmutableSortedBagImplNoIteratorTest::collectLong_target;
            this.payloads.collectShort_target = ImmutableSortedBagImplNoIteratorTest::collectShort_target;
            this.payloads.occurrencesOf = ImmutableSortedBagImplNoIteratorTest::occurrencesOf;
            this.payloads.toImmutable = ImmutableSortedBagImplNoIteratorTest::toImmutable;
            this.payloads.forEachFromTo = ImmutableSortedBagImplNoIteratorTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = ImmutableSortedBagImplNoIteratorTest::forEachWithIndexWithFromTo;
            this.payloads.topOccurrences = ImmutableSortedBagImplNoIteratorTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableSortedBagImplNoIteratorTest::bottomOccurrences;
            this.payloads.corresponds = ImmutableSortedBagImplNoIteratorTest::corresponds;
            this.payloads.detectIndex = ImmutableSortedBagImplNoIteratorTest::detectIndex;
            this.payloads.indexOf = ImmutableSortedBagImplNoIteratorTest::indexOf;
            this.payloads.take = ImmutableSortedBagImplNoIteratorTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableSortedBagImplNoIteratorTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedBagImplNoIteratorTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = ImmutableSortedBagImplNoIteratorTest::selectUnique;
            this.payloads.distinctView = ImmutableSortedBagImplNoIteratorTest::distinctView;
            this.payloads.forLoop = ImmutableSortedBagImplNoIteratorTest::forLoop;
        }
    }
}
