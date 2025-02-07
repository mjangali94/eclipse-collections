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

import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSingletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableSingletonSet<>(1);
    }

    @Test
    @Override
    public void min_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws_without_comparator();
    }

    @Test
    public void getOnly() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableSingletonSetTest instance;

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
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSingletonSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSingletonSetTest::stream;
            this.payloads.parallelStream = ImmutableSingletonSetTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonSetTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableSingletonSetTest::countBy;
            this.payloads.countByWith = ImmutableSingletonSetTest::countByWith;
            this.payloads.countByEach = ImmutableSingletonSetTest::countByEach;
            this.payloads.selectWith = ImmutableSingletonSetTest::selectWith;
            this.payloads.selectWith_target = ImmutableSingletonSetTest::selectWith_target;
            this.payloads.rejectWith = ImmutableSingletonSetTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableSingletonSetTest::rejectWith_target;
            this.payloads.partition = ImmutableSingletonSetTest::partition;
            this.payloads.partitionWith = ImmutableSingletonSetTest::partitionWith;
            this.payloads.collectWith = ImmutableSingletonSetTest::collectWith;
            this.payloads.collect_target = ImmutableSingletonSetTest::collect_target;
            this.payloads.collectWith_target = ImmutableSingletonSetTest::collectWith_target;
            this.payloads.injectInto = ImmutableSingletonSetTest::injectInto;
            this.payloads.injectIntoInt = ImmutableSingletonSetTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSingletonSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSingletonSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSingletonSetTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSingletonSetTest::sumFloat;
            this.payloads.sumDouble = ImmutableSingletonSetTest::sumDouble;
            this.payloads.sumInteger = ImmutableSingletonSetTest::sumInteger;
            this.payloads.sumLong = ImmutableSingletonSetTest::sumLong;
            this.payloads.sumByInt = ImmutableSingletonSetTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSingletonSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSingletonSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSingletonSetTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSingletonSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSingletonSetTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableSingletonSetTest::makeString;
            this.payloads.appendString = ImmutableSingletonSetTest::appendString;
            this.payloads.testToString = ImmutableSingletonSetTest::testToString;
            this.payloads.select = ImmutableSingletonSetTest::select;
            this.payloads.selectInstancesOf = ImmutableSingletonSetTest::selectInstancesOf;
            this.payloads.reject = ImmutableSingletonSetTest::reject;
            this.payloads.collect = ImmutableSingletonSetTest::collect;
            this.payloads.collectBoolean = ImmutableSingletonSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableSingletonSetTest::collectByte;
            this.payloads.collectChar = ImmutableSingletonSetTest::collectChar;
            this.payloads.collectDouble = ImmutableSingletonSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableSingletonSetTest::collectFloat;
            this.payloads.collectInt = ImmutableSingletonSetTest::collectInt;
            this.payloads.collectLong = ImmutableSingletonSetTest::collectLong;
            this.payloads.collectShort = ImmutableSingletonSetTest::collectShort;
            this.payloads.flatCollect = ImmutableSingletonSetTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableSingletonSetTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableSingletonSetTest::detect;
            this.payloads.detectWith = ImmutableSingletonSetTest::detectWith;
            this.payloads.detectIfNone = ImmutableSingletonSetTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableSingletonSetTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableSingletonSetTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableSingletonSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSingletonSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSingletonSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableSingletonSetTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableSingletonSetTest::anySatisfyWith;
            this.payloads.count = ImmutableSingletonSetTest::count;
            this.payloads.countWith = ImmutableSingletonSetTest::countWith;
            this.payloads.collectIf = ImmutableSingletonSetTest::collectIf;
            this.payloads.getFirst = ImmutableSingletonSetTest::getFirst;
            this.payloads.getLast = ImmutableSingletonSetTest::getLast;
            this.payloads.isEmpty = ImmutableSingletonSetTest::isEmpty;
            this.payloads.iterator = ImmutableSingletonSetTest::iterator;
            this.payloads.toArray = ImmutableSingletonSetTest::toArray;
            this.payloads.toSortedList = ImmutableSingletonSetTest::toSortedList;
            this.payloads.toSortedSet = ImmutableSingletonSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableSingletonSetTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableSingletonSetTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableSingletonSetTest::forLoop;
            this.payloads.min = ImmutableSingletonSetTest::min;
            this.payloads.max = ImmutableSingletonSetTest::max;
            this.payloads.min_without_comparator = ImmutableSingletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSingletonSetTest::max_without_comparator;
            this.payloads.minBy = ImmutableSingletonSetTest::minBy;
            this.payloads.maxBy = ImmutableSingletonSetTest::maxBy;
            this.payloads.iteratorRemove = ImmutableSingletonSetTest::iteratorRemove;
            this.payloads.add = ImmutableSingletonSetTest::add;
            this.payloads.remove = ImmutableSingletonSetTest::remove;
            this.payloads.clear = ImmutableSingletonSetTest::clear;
            this.payloads.removeAll = ImmutableSingletonSetTest::removeAll;
            this.payloads.retainAll = ImmutableSingletonSetTest::retainAll;
            this.payloads.addAll = ImmutableSingletonSetTest::addAll;
            this.payloads.aggregateByMutating = ImmutableSingletonSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSingletonSetTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableSingletonSetTest::tap;
            this.payloads.equalsAndHashCode = ImmutableSingletonSetTest::equalsAndHashCode;
            this.payloads.newWith = ImmutableSingletonSetTest::newWith;
            this.payloads.newWithout = ImmutableSingletonSetTest::newWithout;
            this.payloads.newWithAll = ImmutableSingletonSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableSingletonSetTest::newWithoutAll;
            this.payloads.contains = ImmutableSingletonSetTest::contains;
            this.payloads.containsAllArray = ImmutableSingletonSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableSingletonSetTest::containsAllIterable;
            this.payloads.forEach = ImmutableSingletonSetTest::forEach;
            this.payloads.forEachWith = ImmutableSingletonSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSingletonSetTest::forEachWithIndex;
            this.payloads.select_target = ImmutableSingletonSetTest::select_target;
            this.payloads.reject_target = ImmutableSingletonSetTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableSingletonSetTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableSingletonSetTest::zip;
            this.payloads.zipWithIndex = ImmutableSingletonSetTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableSingletonSetTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableSingletonSetTest::collectIfWithTarget;
            this.payloads.toList = ImmutableSingletonSetTest::toList;
            this.payloads.toSortedListBy = ImmutableSingletonSetTest::toSortedListBy;
            this.payloads.groupBy = ImmutableSingletonSetTest::groupBy;
            this.payloads.groupByEach = ImmutableSingletonSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableSingletonSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableSingletonSetTest::groupByEachWithTarget;
            this.payloads.union = ImmutableSingletonSetTest::union;
            this.payloads.unionInto = ImmutableSingletonSetTest::unionInto;
            this.payloads.intersect = ImmutableSingletonSetTest::intersect;
            this.payloads.intersectInto = ImmutableSingletonSetTest::intersectInto;
            this.payloads.difference = ImmutableSingletonSetTest::difference;
            this.payloads.differenceInto = ImmutableSingletonSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableSingletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableSingletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = ImmutableSingletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableSingletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = ImmutableSingletonSetTest::powerSet;
            this.payloads.cartesianProduct = ImmutableSingletonSetTest::cartesianProduct;
            this.payloads.toImmutable = ImmutableSingletonSetTest::toImmutable;
            this.payloads.min_null_throws = ImmutableSingletonSetTest::min_null_throws;
            this.payloads.max_null_throws = ImmutableSingletonSetTest::max_null_throws;
            this.payloads.min_null_throws_without_comparator = ImmutableSingletonSetTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = ImmutableSingletonSetTest::max_null_throws_without_comparator;
            this.payloads.getOnly = ImmutableSingletonSetTest::getOnly;
        }
    }
}
