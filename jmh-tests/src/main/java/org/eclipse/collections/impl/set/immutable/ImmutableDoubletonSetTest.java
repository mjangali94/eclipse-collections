/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableDoubletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableDoubletonSet<>(1, 2);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(1, immutable.newWithout(2).castToSet());
        Verify.assertSize(1, immutable.newWithout(1).castToSet());
        Verify.assertSize(2, immutable.newWithout(0).castToSet());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubletonSetTest instance;

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
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
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
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubletonSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableDoubletonSetTest::stream;
            this.payloads.parallelStream = ImmutableDoubletonSetTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableDoubletonSetTest::countBy;
            this.payloads.countByWith = ImmutableDoubletonSetTest::countByWith;
            this.payloads.countByEach = ImmutableDoubletonSetTest::countByEach;
            this.payloads.selectWith = ImmutableDoubletonSetTest::selectWith;
            this.payloads.selectWith_target = ImmutableDoubletonSetTest::selectWith_target;
            this.payloads.rejectWith = ImmutableDoubletonSetTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableDoubletonSetTest::rejectWith_target;
            this.payloads.partition = ImmutableDoubletonSetTest::partition;
            this.payloads.partitionWith = ImmutableDoubletonSetTest::partitionWith;
            this.payloads.collectWith = ImmutableDoubletonSetTest::collectWith;
            this.payloads.collect_target = ImmutableDoubletonSetTest::collect_target;
            this.payloads.collectWith_target = ImmutableDoubletonSetTest::collectWith_target;
            this.payloads.injectInto = ImmutableDoubletonSetTest::injectInto;
            this.payloads.injectIntoInt = ImmutableDoubletonSetTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableDoubletonSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDoubletonSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableDoubletonSetTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableDoubletonSetTest::sumFloat;
            this.payloads.sumDouble = ImmutableDoubletonSetTest::sumDouble;
            this.payloads.sumInteger = ImmutableDoubletonSetTest::sumInteger;
            this.payloads.sumLong = ImmutableDoubletonSetTest::sumLong;
            this.payloads.sumByInt = ImmutableDoubletonSetTest::sumByInt;
            this.payloads.sumByFloat = ImmutableDoubletonSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableDoubletonSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableDoubletonSetTest::sumByLong;
            this.payloads.sumByDouble = ImmutableDoubletonSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableDoubletonSetTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableDoubletonSetTest::makeString;
            this.payloads.appendString = ImmutableDoubletonSetTest::appendString;
            this.payloads.testToString = ImmutableDoubletonSetTest::testToString;
            this.payloads.select = ImmutableDoubletonSetTest::select;
            this.payloads.selectInstancesOf = ImmutableDoubletonSetTest::selectInstancesOf;
            this.payloads.reject = ImmutableDoubletonSetTest::reject;
            this.payloads.collect = ImmutableDoubletonSetTest::collect;
            this.payloads.collectBoolean = ImmutableDoubletonSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableDoubletonSetTest::collectByte;
            this.payloads.collectChar = ImmutableDoubletonSetTest::collectChar;
            this.payloads.collectDouble = ImmutableDoubletonSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableDoubletonSetTest::collectFloat;
            this.payloads.collectInt = ImmutableDoubletonSetTest::collectInt;
            this.payloads.collectLong = ImmutableDoubletonSetTest::collectLong;
            this.payloads.collectShort = ImmutableDoubletonSetTest::collectShort;
            this.payloads.flatCollect = ImmutableDoubletonSetTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableDoubletonSetTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableDoubletonSetTest::detect;
            this.payloads.detectWith = ImmutableDoubletonSetTest::detectWith;
            this.payloads.detectIfNone = ImmutableDoubletonSetTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableDoubletonSetTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableDoubletonSetTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableDoubletonSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableDoubletonSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableDoubletonSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableDoubletonSetTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableDoubletonSetTest::anySatisfyWith;
            this.payloads.count = ImmutableDoubletonSetTest::count;
            this.payloads.countWith = ImmutableDoubletonSetTest::countWith;
            this.payloads.collectIf = ImmutableDoubletonSetTest::collectIf;
            this.payloads.getFirst = ImmutableDoubletonSetTest::getFirst;
            this.payloads.getLast = ImmutableDoubletonSetTest::getLast;
            this.payloads.isEmpty = ImmutableDoubletonSetTest::isEmpty;
            this.payloads.iterator = ImmutableDoubletonSetTest::iterator;
            this.payloads.toArray = ImmutableDoubletonSetTest::toArray;
            this.payloads.toSortedList = ImmutableDoubletonSetTest::toSortedList;
            this.payloads.toSortedSet = ImmutableDoubletonSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableDoubletonSetTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableDoubletonSetTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableDoubletonSetTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableDoubletonSetTest::min;
            this.payloads.max = ImmutableDoubletonSetTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubletonSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableDoubletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableDoubletonSetTest::max_without_comparator;
            this.payloads.minBy = ImmutableDoubletonSetTest::minBy;
            this.payloads.maxBy = ImmutableDoubletonSetTest::maxBy;
            this.payloads.iteratorRemove = ImmutableDoubletonSetTest::iteratorRemove;
            this.payloads.add = ImmutableDoubletonSetTest::add;
            this.payloads.remove = ImmutableDoubletonSetTest::remove;
            this.payloads.clear = ImmutableDoubletonSetTest::clear;
            this.payloads.removeAll = ImmutableDoubletonSetTest::removeAll;
            this.payloads.retainAll = ImmutableDoubletonSetTest::retainAll;
            this.payloads.addAll = ImmutableDoubletonSetTest::addAll;
            this.payloads.aggregateByMutating = ImmutableDoubletonSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableDoubletonSetTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableDoubletonSetTest::tap;
            this.payloads.equalsAndHashCode = ImmutableDoubletonSetTest::equalsAndHashCode;
            this.payloads.newWith = ImmutableDoubletonSetTest::newWith;
            this.payloads.newWithAll = ImmutableDoubletonSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableDoubletonSetTest::newWithoutAll;
            this.payloads.contains = ImmutableDoubletonSetTest::contains;
            this.payloads.containsAllArray = ImmutableDoubletonSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDoubletonSetTest::containsAllIterable;
            this.payloads.forEach = ImmutableDoubletonSetTest::forEach;
            this.payloads.forEachWith = ImmutableDoubletonSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableDoubletonSetTest::forEachWithIndex;
            this.payloads.select_target = ImmutableDoubletonSetTest::select_target;
            this.payloads.reject_target = ImmutableDoubletonSetTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableDoubletonSetTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableDoubletonSetTest::zip;
            this.payloads.zipWithIndex = ImmutableDoubletonSetTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableDoubletonSetTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableDoubletonSetTest::collectIfWithTarget;
            this.payloads.toList = ImmutableDoubletonSetTest::toList;
            this.payloads.toSortedListBy = ImmutableDoubletonSetTest::toSortedListBy;
            this.payloads.groupBy = ImmutableDoubletonSetTest::groupBy;
            this.payloads.groupByEach = ImmutableDoubletonSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableDoubletonSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableDoubletonSetTest::groupByEachWithTarget;
            this.payloads.union = ImmutableDoubletonSetTest::union;
            this.payloads.unionInto = ImmutableDoubletonSetTest::unionInto;
            this.payloads.intersect = ImmutableDoubletonSetTest::intersect;
            this.payloads.intersectInto = ImmutableDoubletonSetTest::intersectInto;
            this.payloads.difference = ImmutableDoubletonSetTest::difference;
            this.payloads.differenceInto = ImmutableDoubletonSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableDoubletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableDoubletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = ImmutableDoubletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableDoubletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = ImmutableDoubletonSetTest::powerSet;
            this.payloads.cartesianProduct = ImmutableDoubletonSetTest::cartesianProduct;
            this.payloads.toImmutable = ImmutableDoubletonSetTest::toImmutable;
            this.payloads.newWithout = ImmutableDoubletonSetTest::newWithout;
            this.payloads.getOnly = ImmutableDoubletonSetTest::getOnly;
        }
    }
}
