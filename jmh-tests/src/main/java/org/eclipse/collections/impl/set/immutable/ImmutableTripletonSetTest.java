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

public class ImmutableTripletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableTripletonSet<>(1, 2, 3);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(2, immutable.newWithout(3).castToSet());
        Verify.assertSize(2, immutable.newWithout(2).castToSet());
        Verify.assertSize(2, immutable.newWithout(1).castToSet());
        Verify.assertSize(3, immutable.newWithout(0).castToSet());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableTripletonSetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTripletonSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableTripletonSetTest::stream;
            this.payloads.parallelStream = ImmutableTripletonSetTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableTripletonSetTest::countBy;
            this.payloads.countByWith = ImmutableTripletonSetTest::countByWith;
            this.payloads.countByEach = ImmutableTripletonSetTest::countByEach;
            this.payloads.selectWith = ImmutableTripletonSetTest::selectWith;
            this.payloads.selectWith_target = ImmutableTripletonSetTest::selectWith_target;
            this.payloads.rejectWith = ImmutableTripletonSetTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableTripletonSetTest::rejectWith_target;
            this.payloads.partition = ImmutableTripletonSetTest::partition;
            this.payloads.partitionWith = ImmutableTripletonSetTest::partitionWith;
            this.payloads.collectWith = ImmutableTripletonSetTest::collectWith;
            this.payloads.collect_target = ImmutableTripletonSetTest::collect_target;
            this.payloads.collectWith_target = ImmutableTripletonSetTest::collectWith_target;
            this.payloads.injectInto = ImmutableTripletonSetTest::injectInto;
            this.payloads.injectIntoInt = ImmutableTripletonSetTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableTripletonSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableTripletonSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableTripletonSetTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableTripletonSetTest::sumFloat;
            this.payloads.sumDouble = ImmutableTripletonSetTest::sumDouble;
            this.payloads.sumInteger = ImmutableTripletonSetTest::sumInteger;
            this.payloads.sumLong = ImmutableTripletonSetTest::sumLong;
            this.payloads.sumByInt = ImmutableTripletonSetTest::sumByInt;
            this.payloads.sumByFloat = ImmutableTripletonSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableTripletonSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableTripletonSetTest::sumByLong;
            this.payloads.sumByDouble = ImmutableTripletonSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableTripletonSetTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableTripletonSetTest::makeString;
            this.payloads.appendString = ImmutableTripletonSetTest::appendString;
            this.payloads.testToString = ImmutableTripletonSetTest::testToString;
            this.payloads.select = ImmutableTripletonSetTest::select;
            this.payloads.selectInstancesOf = ImmutableTripletonSetTest::selectInstancesOf;
            this.payloads.reject = ImmutableTripletonSetTest::reject;
            this.payloads.collect = ImmutableTripletonSetTest::collect;
            this.payloads.collectBoolean = ImmutableTripletonSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableTripletonSetTest::collectByte;
            this.payloads.collectChar = ImmutableTripletonSetTest::collectChar;
            this.payloads.collectDouble = ImmutableTripletonSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableTripletonSetTest::collectFloat;
            this.payloads.collectInt = ImmutableTripletonSetTest::collectInt;
            this.payloads.collectLong = ImmutableTripletonSetTest::collectLong;
            this.payloads.collectShort = ImmutableTripletonSetTest::collectShort;
            this.payloads.flatCollect = ImmutableTripletonSetTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableTripletonSetTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableTripletonSetTest::detect;
            this.payloads.detectWith = ImmutableTripletonSetTest::detectWith;
            this.payloads.detectIfNone = ImmutableTripletonSetTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableTripletonSetTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableTripletonSetTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableTripletonSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableTripletonSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableTripletonSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableTripletonSetTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableTripletonSetTest::anySatisfyWith;
            this.payloads.count = ImmutableTripletonSetTest::count;
            this.payloads.countWith = ImmutableTripletonSetTest::countWith;
            this.payloads.collectIf = ImmutableTripletonSetTest::collectIf;
            this.payloads.getFirst = ImmutableTripletonSetTest::getFirst;
            this.payloads.getLast = ImmutableTripletonSetTest::getLast;
            this.payloads.isEmpty = ImmutableTripletonSetTest::isEmpty;
            this.payloads.iterator = ImmutableTripletonSetTest::iterator;
            this.payloads.toArray = ImmutableTripletonSetTest::toArray;
            this.payloads.toSortedList = ImmutableTripletonSetTest::toSortedList;
            this.payloads.toSortedSet = ImmutableTripletonSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableTripletonSetTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableTripletonSetTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableTripletonSetTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableTripletonSetTest::min;
            this.payloads.max = ImmutableTripletonSetTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTripletonSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableTripletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableTripletonSetTest::max_without_comparator;
            this.payloads.minBy = ImmutableTripletonSetTest::minBy;
            this.payloads.maxBy = ImmutableTripletonSetTest::maxBy;
            this.payloads.iteratorRemove = ImmutableTripletonSetTest::iteratorRemove;
            this.payloads.add = ImmutableTripletonSetTest::add;
            this.payloads.remove = ImmutableTripletonSetTest::remove;
            this.payloads.clear = ImmutableTripletonSetTest::clear;
            this.payloads.removeAll = ImmutableTripletonSetTest::removeAll;
            this.payloads.retainAll = ImmutableTripletonSetTest::retainAll;
            this.payloads.addAll = ImmutableTripletonSetTest::addAll;
            this.payloads.aggregateByMutating = ImmutableTripletonSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableTripletonSetTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableTripletonSetTest::tap;
            this.payloads.equalsAndHashCode = ImmutableTripletonSetTest::equalsAndHashCode;
            this.payloads.newWith = ImmutableTripletonSetTest::newWith;
            this.payloads.newWithAll = ImmutableTripletonSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableTripletonSetTest::newWithoutAll;
            this.payloads.contains = ImmutableTripletonSetTest::contains;
            this.payloads.containsAllArray = ImmutableTripletonSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableTripletonSetTest::containsAllIterable;
            this.payloads.forEach = ImmutableTripletonSetTest::forEach;
            this.payloads.forEachWith = ImmutableTripletonSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableTripletonSetTest::forEachWithIndex;
            this.payloads.select_target = ImmutableTripletonSetTest::select_target;
            this.payloads.reject_target = ImmutableTripletonSetTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableTripletonSetTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableTripletonSetTest::zip;
            this.payloads.zipWithIndex = ImmutableTripletonSetTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableTripletonSetTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableTripletonSetTest::collectIfWithTarget;
            this.payloads.toList = ImmutableTripletonSetTest::toList;
            this.payloads.toSortedListBy = ImmutableTripletonSetTest::toSortedListBy;
            this.payloads.groupBy = ImmutableTripletonSetTest::groupBy;
            this.payloads.groupByEach = ImmutableTripletonSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableTripletonSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableTripletonSetTest::groupByEachWithTarget;
            this.payloads.union = ImmutableTripletonSetTest::union;
            this.payloads.unionInto = ImmutableTripletonSetTest::unionInto;
            this.payloads.intersect = ImmutableTripletonSetTest::intersect;
            this.payloads.intersectInto = ImmutableTripletonSetTest::intersectInto;
            this.payloads.difference = ImmutableTripletonSetTest::difference;
            this.payloads.differenceInto = ImmutableTripletonSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableTripletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableTripletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = ImmutableTripletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableTripletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = ImmutableTripletonSetTest::powerSet;
            this.payloads.cartesianProduct = ImmutableTripletonSetTest::cartesianProduct;
            this.payloads.toImmutable = ImmutableTripletonSetTest::toImmutable;
            this.payloads.newWithout = ImmutableTripletonSetTest::newWithout;
            this.payloads.getOnly = ImmutableTripletonSetTest::getOnly;
        }
    }
}
