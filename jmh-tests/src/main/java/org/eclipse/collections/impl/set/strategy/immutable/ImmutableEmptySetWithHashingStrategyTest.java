/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.HashingStrategySets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.immutable.AbstractImmutableEmptySetTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableEmptySetWithHashingStrategyTest extends AbstractImmutableEmptySetTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableEmptySetWithHashingStrategy<>(HASHING_STRATEGY);
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertEquals(HashingStrategySets.immutable.of(HASHING_STRATEGY), HashingStrategySets.immutable.of(HASHING_STRATEGY).newWithout(1));
        Assert.assertEquals(HashingStrategySets.immutable.of(HASHING_STRATEGY), HashingStrategySets.immutable.of(HASHING_STRATEGY).newWithoutAll(Interval.oneTo(3)));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        MutableSet<Integer> mutable = UnifiedSet.newSet(immutable);
        Verify.assertEqualsAndHashCode(mutable, immutable);
        Verify.assertPostSerializedEqualsAndHashCode(immutable);
        Assert.assertNotEquals(FastList.newList(mutable), immutable);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableEmptySetWithHashingStrategyTest instance;

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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
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
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
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
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptySetWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySetWithHashingStrategyTest> equalsAndHashCode;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableEmptySetWithHashingStrategyTest::stream;
            this.payloads.parallelStream = ImmutableEmptySetWithHashingStrategyTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableEmptySetWithHashingStrategyTest::countBy;
            this.payloads.countByWith = ImmutableEmptySetWithHashingStrategyTest::countByWith;
            this.payloads.countByEach = ImmutableEmptySetWithHashingStrategyTest::countByEach;
            this.payloads.selectWith = ImmutableEmptySetWithHashingStrategyTest::selectWith;
            this.payloads.selectWith_target = ImmutableEmptySetWithHashingStrategyTest::selectWith_target;
            this.payloads.rejectWith = ImmutableEmptySetWithHashingStrategyTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableEmptySetWithHashingStrategyTest::rejectWith_target;
            this.payloads.partition = ImmutableEmptySetWithHashingStrategyTest::partition;
            this.payloads.partitionWith = ImmutableEmptySetWithHashingStrategyTest::partitionWith;
            this.payloads.collectWith = ImmutableEmptySetWithHashingStrategyTest::collectWith;
            this.payloads.injectInto = ImmutableEmptySetWithHashingStrategyTest::injectInto;
            this.payloads.injectIntoInt = ImmutableEmptySetWithHashingStrategyTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableEmptySetWithHashingStrategyTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableEmptySetWithHashingStrategyTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableEmptySetWithHashingStrategyTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableEmptySetWithHashingStrategyTest::sumFloat;
            this.payloads.sumDouble = ImmutableEmptySetWithHashingStrategyTest::sumDouble;
            this.payloads.sumInteger = ImmutableEmptySetWithHashingStrategyTest::sumInteger;
            this.payloads.sumLong = ImmutableEmptySetWithHashingStrategyTest::sumLong;
            this.payloads.sumByInt = ImmutableEmptySetWithHashingStrategyTest::sumByInt;
            this.payloads.sumByFloat = ImmutableEmptySetWithHashingStrategyTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableEmptySetWithHashingStrategyTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableEmptySetWithHashingStrategyTest::sumByLong;
            this.payloads.sumByDouble = ImmutableEmptySetWithHashingStrategyTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableEmptySetWithHashingStrategyTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableEmptySetWithHashingStrategyTest::makeString;
            this.payloads.appendString = ImmutableEmptySetWithHashingStrategyTest::appendString;
            this.payloads.testToString = ImmutableEmptySetWithHashingStrategyTest::testToString;
            this.payloads.select = ImmutableEmptySetWithHashingStrategyTest::select;
            this.payloads.selectInstancesOf = ImmutableEmptySetWithHashingStrategyTest::selectInstancesOf;
            this.payloads.reject = ImmutableEmptySetWithHashingStrategyTest::reject;
            this.payloads.collect = ImmutableEmptySetWithHashingStrategyTest::collect;
            this.payloads.collectByte = ImmutableEmptySetWithHashingStrategyTest::collectByte;
            this.payloads.collectChar = ImmutableEmptySetWithHashingStrategyTest::collectChar;
            this.payloads.collectDouble = ImmutableEmptySetWithHashingStrategyTest::collectDouble;
            this.payloads.collectFloat = ImmutableEmptySetWithHashingStrategyTest::collectFloat;
            this.payloads.collectInt = ImmutableEmptySetWithHashingStrategyTest::collectInt;
            this.payloads.collectLong = ImmutableEmptySetWithHashingStrategyTest::collectLong;
            this.payloads.collectShort = ImmutableEmptySetWithHashingStrategyTest::collectShort;
            this.payloads.flatCollect = ImmutableEmptySetWithHashingStrategyTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableEmptySetWithHashingStrategyTest::flatCollectWith;
            this.payloads.detectIfNone = ImmutableEmptySetWithHashingStrategyTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableEmptySetWithHashingStrategyTest::detectWithIfNone;
            this.payloads.allSatisfyWith = ImmutableEmptySetWithHashingStrategyTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableEmptySetWithHashingStrategyTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableEmptySetWithHashingStrategyTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableEmptySetWithHashingStrategyTest::anySatisfyWith;
            this.payloads.count = ImmutableEmptySetWithHashingStrategyTest::count;
            this.payloads.countWith = ImmutableEmptySetWithHashingStrategyTest::countWith;
            this.payloads.collectIf = ImmutableEmptySetWithHashingStrategyTest::collectIf;
            this.payloads.iterator = ImmutableEmptySetWithHashingStrategyTest::iterator;
            this.payloads.toArray = ImmutableEmptySetWithHashingStrategyTest::toArray;
            this.payloads.toSortedList = ImmutableEmptySetWithHashingStrategyTest::toSortedList;
            this.payloads.toSortedSet = ImmutableEmptySetWithHashingStrategyTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableEmptySetWithHashingStrategyTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableEmptySetWithHashingStrategyTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableEmptySetWithHashingStrategyTest::forLoop;
            this.payloads.iteratorRemove = ImmutableEmptySetWithHashingStrategyTest::iteratorRemove;
            this.payloads.add = ImmutableEmptySetWithHashingStrategyTest::add;
            this.payloads.remove = ImmutableEmptySetWithHashingStrategyTest::remove;
            this.payloads.clear = ImmutableEmptySetWithHashingStrategyTest::clear;
            this.payloads.removeAll = ImmutableEmptySetWithHashingStrategyTest::removeAll;
            this.payloads.retainAll = ImmutableEmptySetWithHashingStrategyTest::retainAll;
            this.payloads.addAll = ImmutableEmptySetWithHashingStrategyTest::addAll;
            this.payloads.aggregateByMutating = ImmutableEmptySetWithHashingStrategyTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableEmptySetWithHashingStrategyTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableEmptySetWithHashingStrategyTest::tap;
            this.payloads.newWithAll = ImmutableEmptySetWithHashingStrategyTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableEmptySetWithHashingStrategyTest::newWithoutAll;
            this.payloads.contains = ImmutableEmptySetWithHashingStrategyTest::contains;
            this.payloads.containsAllArray = ImmutableEmptySetWithHashingStrategyTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableEmptySetWithHashingStrategyTest::containsAllIterable;
            this.payloads.forEach = ImmutableEmptySetWithHashingStrategyTest::forEach;
            this.payloads.forEachWith = ImmutableEmptySetWithHashingStrategyTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptySetWithHashingStrategyTest::forEachWithIndex;
            this.payloads.select_target = ImmutableEmptySetWithHashingStrategyTest::select_target;
            this.payloads.reject_target = ImmutableEmptySetWithHashingStrategyTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableEmptySetWithHashingStrategyTest::flatCollectWithTarget;
            this.payloads.collectIfWithTarget = ImmutableEmptySetWithHashingStrategyTest::collectIfWithTarget;
            this.payloads.toList = ImmutableEmptySetWithHashingStrategyTest::toList;
            this.payloads.toSortedListBy = ImmutableEmptySetWithHashingStrategyTest::toSortedListBy;
            this.payloads.groupBy = ImmutableEmptySetWithHashingStrategyTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptySetWithHashingStrategyTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableEmptySetWithHashingStrategyTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableEmptySetWithHashingStrategyTest::groupByEachWithTarget;
            this.payloads.isSubsetOf = ImmutableEmptySetWithHashingStrategyTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableEmptySetWithHashingStrategyTest::isProperSubsetOf;
            this.payloads.powerSet = ImmutableEmptySetWithHashingStrategyTest::powerSet;
            this.payloads.cartesianProduct = ImmutableEmptySetWithHashingStrategyTest::cartesianProduct;
            this.payloads.toImmutable = ImmutableEmptySetWithHashingStrategyTest::toImmutable;
            this.payloads.containsAll = ImmutableEmptySetWithHashingStrategyTest::containsAll;
            this.payloads.newWith = ImmutableEmptySetWithHashingStrategyTest::newWith;
            this.payloads.detect = ImmutableEmptySetWithHashingStrategyTest::detect;
            this.payloads.detectWith = ImmutableEmptySetWithHashingStrategyTest::detectWith;
            this.payloads.anySatisfy = ImmutableEmptySetWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableEmptySetWithHashingStrategyTest::allSatisfy;
            this.payloads.getFirst = ImmutableEmptySetWithHashingStrategyTest::getFirst;
            this.payloads.getLast = ImmutableEmptySetWithHashingStrategyTest::getLast;
            this.payloads.getOnly = ImmutableEmptySetWithHashingStrategyTest::getOnly;
            this.payloads.isEmpty = ImmutableEmptySetWithHashingStrategyTest::isEmpty;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::max, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = ImmutableEmptySetWithHashingStrategyTest::min_null_throws;
            this.payloads.max_null_throws = ImmutableEmptySetWithHashingStrategyTest::max_null_throws;
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = ImmutableEmptySetWithHashingStrategyTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = ImmutableEmptySetWithHashingStrategyTest::max_null_throws_without_comparator;
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.zip = ImmutableEmptySetWithHashingStrategyTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptySetWithHashingStrategyTest::zipWithIndex;
            this.payloads.chunk = ImmutableEmptySetWithHashingStrategyTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySetWithHashingStrategyTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableEmptySetWithHashingStrategyTest::chunk_large_size;
            this.payloads.union = ImmutableEmptySetWithHashingStrategyTest::union;
            this.payloads.unionInto = ImmutableEmptySetWithHashingStrategyTest::unionInto;
            this.payloads.intersect = ImmutableEmptySetWithHashingStrategyTest::intersect;
            this.payloads.intersectInto = ImmutableEmptySetWithHashingStrategyTest::intersectInto;
            this.payloads.difference = ImmutableEmptySetWithHashingStrategyTest::difference;
            this.payloads.differenceInto = ImmutableEmptySetWithHashingStrategyTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableEmptySetWithHashingStrategyTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableEmptySetWithHashingStrategyTest::symmetricDifferenceInto;
            this.payloads.collectBoolean = ImmutableEmptySetWithHashingStrategyTest::collectBoolean;
            this.payloads.collect_target = ImmutableEmptySetWithHashingStrategyTest::collect_target;
            this.payloads.collectWith_target = ImmutableEmptySetWithHashingStrategyTest::collectWith_target;
            this.payloads.newWithout = ImmutableEmptySetWithHashingStrategyTest::newWithout;
            this.payloads.equalsAndHashCode = ImmutableEmptySetWithHashingStrategyTest::equalsAndHashCode;
        }
    }
}
