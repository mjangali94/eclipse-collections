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
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public class ImmutableQuadrupletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableQuadrupletonSet<>(1, 2, 3, 4);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(3, immutable.newWithout(4).castToSet());
        Verify.assertSize(3, immutable.newWithout(3).castToSet());
        Verify.assertSize(3, immutable.newWithout(2).castToSet());
        Verify.assertSize(3, immutable.newWithout(1).castToSet());
        Verify.assertSize(4, immutable.newWithout(0).castToSet());
    }

    @Test
    public void selectInstanceOf() {
        ImmutableSet<Number> numbers = new ImmutableQuadrupletonSet<>(1, 2.0, 3, 4.0);
        Assert.assertEquals(iSet(1, 3), numbers.selectInstancesOf(Integer.class));
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableQuadrupletonSetTest instance;

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
        public void benchmark_selectInstanceOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstanceOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableQuadrupletonSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> selectInstanceOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableQuadrupletonSetTest::stream;
            this.payloads.parallelStream = ImmutableQuadrupletonSetTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableQuadrupletonSetTest::countBy;
            this.payloads.countByWith = ImmutableQuadrupletonSetTest::countByWith;
            this.payloads.countByEach = ImmutableQuadrupletonSetTest::countByEach;
            this.payloads.selectWith = ImmutableQuadrupletonSetTest::selectWith;
            this.payloads.selectWith_target = ImmutableQuadrupletonSetTest::selectWith_target;
            this.payloads.rejectWith = ImmutableQuadrupletonSetTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableQuadrupletonSetTest::rejectWith_target;
            this.payloads.partition = ImmutableQuadrupletonSetTest::partition;
            this.payloads.partitionWith = ImmutableQuadrupletonSetTest::partitionWith;
            this.payloads.collectWith = ImmutableQuadrupletonSetTest::collectWith;
            this.payloads.collect_target = ImmutableQuadrupletonSetTest::collect_target;
            this.payloads.collectWith_target = ImmutableQuadrupletonSetTest::collectWith_target;
            this.payloads.injectInto = ImmutableQuadrupletonSetTest::injectInto;
            this.payloads.injectIntoInt = ImmutableQuadrupletonSetTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableQuadrupletonSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableQuadrupletonSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableQuadrupletonSetTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableQuadrupletonSetTest::sumFloat;
            this.payloads.sumDouble = ImmutableQuadrupletonSetTest::sumDouble;
            this.payloads.sumInteger = ImmutableQuadrupletonSetTest::sumInteger;
            this.payloads.sumLong = ImmutableQuadrupletonSetTest::sumLong;
            this.payloads.sumByInt = ImmutableQuadrupletonSetTest::sumByInt;
            this.payloads.sumByFloat = ImmutableQuadrupletonSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableQuadrupletonSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableQuadrupletonSetTest::sumByLong;
            this.payloads.sumByDouble = ImmutableQuadrupletonSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableQuadrupletonSetTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableQuadrupletonSetTest::makeString;
            this.payloads.appendString = ImmutableQuadrupletonSetTest::appendString;
            this.payloads.testToString = ImmutableQuadrupletonSetTest::testToString;
            this.payloads.select = ImmutableQuadrupletonSetTest::select;
            this.payloads.selectInstancesOf = ImmutableQuadrupletonSetTest::selectInstancesOf;
            this.payloads.reject = ImmutableQuadrupletonSetTest::reject;
            this.payloads.collect = ImmutableQuadrupletonSetTest::collect;
            this.payloads.collectBoolean = ImmutableQuadrupletonSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableQuadrupletonSetTest::collectByte;
            this.payloads.collectChar = ImmutableQuadrupletonSetTest::collectChar;
            this.payloads.collectDouble = ImmutableQuadrupletonSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableQuadrupletonSetTest::collectFloat;
            this.payloads.collectInt = ImmutableQuadrupletonSetTest::collectInt;
            this.payloads.collectLong = ImmutableQuadrupletonSetTest::collectLong;
            this.payloads.collectShort = ImmutableQuadrupletonSetTest::collectShort;
            this.payloads.flatCollect = ImmutableQuadrupletonSetTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableQuadrupletonSetTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableQuadrupletonSetTest::detect;
            this.payloads.detectWith = ImmutableQuadrupletonSetTest::detectWith;
            this.payloads.detectIfNone = ImmutableQuadrupletonSetTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableQuadrupletonSetTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableQuadrupletonSetTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableQuadrupletonSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableQuadrupletonSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableQuadrupletonSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableQuadrupletonSetTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableQuadrupletonSetTest::anySatisfyWith;
            this.payloads.count = ImmutableQuadrupletonSetTest::count;
            this.payloads.countWith = ImmutableQuadrupletonSetTest::countWith;
            this.payloads.collectIf = ImmutableQuadrupletonSetTest::collectIf;
            this.payloads.getFirst = ImmutableQuadrupletonSetTest::getFirst;
            this.payloads.getLast = ImmutableQuadrupletonSetTest::getLast;
            this.payloads.isEmpty = ImmutableQuadrupletonSetTest::isEmpty;
            this.payloads.iterator = ImmutableQuadrupletonSetTest::iterator;
            this.payloads.toArray = ImmutableQuadrupletonSetTest::toArray;
            this.payloads.toSortedList = ImmutableQuadrupletonSetTest::toSortedList;
            this.payloads.toSortedSet = ImmutableQuadrupletonSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableQuadrupletonSetTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableQuadrupletonSetTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableQuadrupletonSetTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableQuadrupletonSetTest::min;
            this.payloads.max = ImmutableQuadrupletonSetTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableQuadrupletonSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableQuadrupletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableQuadrupletonSetTest::max_without_comparator;
            this.payloads.minBy = ImmutableQuadrupletonSetTest::minBy;
            this.payloads.maxBy = ImmutableQuadrupletonSetTest::maxBy;
            this.payloads.iteratorRemove = ImmutableQuadrupletonSetTest::iteratorRemove;
            this.payloads.add = ImmutableQuadrupletonSetTest::add;
            this.payloads.remove = ImmutableQuadrupletonSetTest::remove;
            this.payloads.clear = ImmutableQuadrupletonSetTest::clear;
            this.payloads.removeAll = ImmutableQuadrupletonSetTest::removeAll;
            this.payloads.retainAll = ImmutableQuadrupletonSetTest::retainAll;
            this.payloads.addAll = ImmutableQuadrupletonSetTest::addAll;
            this.payloads.aggregateByMutating = ImmutableQuadrupletonSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableQuadrupletonSetTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableQuadrupletonSetTest::tap;
            this.payloads.equalsAndHashCode = ImmutableQuadrupletonSetTest::equalsAndHashCode;
            this.payloads.newWith = ImmutableQuadrupletonSetTest::newWith;
            this.payloads.newWithAll = ImmutableQuadrupletonSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableQuadrupletonSetTest::newWithoutAll;
            this.payloads.contains = ImmutableQuadrupletonSetTest::contains;
            this.payloads.containsAllArray = ImmutableQuadrupletonSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableQuadrupletonSetTest::containsAllIterable;
            this.payloads.forEach = ImmutableQuadrupletonSetTest::forEach;
            this.payloads.forEachWith = ImmutableQuadrupletonSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableQuadrupletonSetTest::forEachWithIndex;
            this.payloads.select_target = ImmutableQuadrupletonSetTest::select_target;
            this.payloads.reject_target = ImmutableQuadrupletonSetTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableQuadrupletonSetTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableQuadrupletonSetTest::zip;
            this.payloads.zipWithIndex = ImmutableQuadrupletonSetTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableQuadrupletonSetTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableQuadrupletonSetTest::collectIfWithTarget;
            this.payloads.toList = ImmutableQuadrupletonSetTest::toList;
            this.payloads.toSortedListBy = ImmutableQuadrupletonSetTest::toSortedListBy;
            this.payloads.groupBy = ImmutableQuadrupletonSetTest::groupBy;
            this.payloads.groupByEach = ImmutableQuadrupletonSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableQuadrupletonSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableQuadrupletonSetTest::groupByEachWithTarget;
            this.payloads.union = ImmutableQuadrupletonSetTest::union;
            this.payloads.unionInto = ImmutableQuadrupletonSetTest::unionInto;
            this.payloads.intersect = ImmutableQuadrupletonSetTest::intersect;
            this.payloads.intersectInto = ImmutableQuadrupletonSetTest::intersectInto;
            this.payloads.difference = ImmutableQuadrupletonSetTest::difference;
            this.payloads.differenceInto = ImmutableQuadrupletonSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableQuadrupletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableQuadrupletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = ImmutableQuadrupletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableQuadrupletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = ImmutableQuadrupletonSetTest::powerSet;
            this.payloads.cartesianProduct = ImmutableQuadrupletonSetTest::cartesianProduct;
            this.payloads.toImmutable = ImmutableQuadrupletonSetTest::toImmutable;
            this.payloads.newWithout = ImmutableQuadrupletonSetTest::newWithout;
            this.payloads.selectInstanceOf = ImmutableQuadrupletonSetTest::selectInstanceOf;
            this.payloads.getOnly = ImmutableQuadrupletonSetTest::getOnly;
        }
    }
}
