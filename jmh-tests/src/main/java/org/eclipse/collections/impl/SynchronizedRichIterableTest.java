/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.lazy.LazyIterableAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class SynchronizedRichIterableTest extends AbstractRichIterableTestCase {

    @Override
    protected <T> RichIterable<T> newWith(T... littleElements) {
        return SynchronizedRichIterable.of(Lists.mutable.of(littleElements));
    }

    @Override
    @Test
    public void chunk_large_size() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Verify.assertIterablesEqual(collection, collection.chunk(10).getOnly());
    }

    @Override
    @Test
    public void partition() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partitionWith(Predicates2.in(), FastList.newListWith(-2, 0, 2, 4, 6, 8));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    public void equalsAndHashCode() {
        Assert.assertNotEquals(this.newWith(), this.newWith());
    }

    @Override
    @Test
    public void groupBy() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Multimap<Boolean, Integer> multimap = list.groupBy(object -> IntegerPredicates.isOdd().accept(object));
        Assert.assertEquals(FastList.newListWith(1, 3, 5, 7), multimap.get(Boolean.TRUE));
        Assert.assertEquals(FastList.newListWith(2, 4, 6), multimap.get(Boolean.FALSE));
    }

    @Test
    public void groupByWithTarget() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        MutableMultimap<Boolean, Integer> multimap = new FastListMultimap<>();
        list.groupBy(object -> IntegerPredicates.isOdd().accept(object), multimap);
        Assert.assertEquals(FastList.newListWith(1, 3, 5, 7), multimap.get(Boolean.TRUE));
        Assert.assertEquals(FastList.newListWith(2, 4, 6), multimap.get(Boolean.FALSE));
    }

    @Test
    public void asLazy() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9).asLazy();
        Verify.assertInstanceOf(LazyIterableAdapter.class, integers);
        PartitionIterable<Integer> result = integers.partitionWith(Predicates2.in(), FastList.newListWith(-2, 0, 2, 4, 6, 8));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCheck() {
        SynchronizedRichIterable.of(null, null);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedRichIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
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
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
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
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
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
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
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
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
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
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCheck() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCheck);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedRichIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedRichIterableTest> nullCheck;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedRichIterableTest::testNewCollection;
            this.payloads.equalsAndHashCode = SynchronizedRichIterableTest::equalsAndHashCode;
            this.payloads.contains = SynchronizedRichIterableTest::contains;
            this.payloads.containsBy = SynchronizedRichIterableTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedRichIterableTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedRichIterableTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedRichIterableTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedRichIterableTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedRichIterableTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedRichIterableTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedRichIterableTest::containsAllCollection;
            this.payloads.tap = SynchronizedRichIterableTest::tap;
            this.payloads.forEach = SynchronizedRichIterableTest::forEach;
            this.payloads.forEachWith = SynchronizedRichIterableTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedRichIterableTest::forEachWithIndex;
            this.payloads.select = SynchronizedRichIterableTest::select;
            this.payloads.selectWith = SynchronizedRichIterableTest::selectWith;
            this.payloads.selectWith_target = SynchronizedRichIterableTest::selectWith_target;
            this.payloads.reject = SynchronizedRichIterableTest::reject;
            this.payloads.rejectWith = SynchronizedRichIterableTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedRichIterableTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedRichIterableTest::selectInstancesOf;
            this.payloads.collect = SynchronizedRichIterableTest::collect;
            this.payloads.collectTarget = SynchronizedRichIterableTest::collectTarget;
            this.payloads.collectBoolean = SynchronizedRichIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedRichIterableTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedRichIterableTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedRichIterableTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedRichIterableTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedRichIterableTest::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedRichIterableTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedRichIterableTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedRichIterableTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedRichIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedRichIterableTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedRichIterableTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedRichIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedRichIterableTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedRichIterableTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedRichIterableTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedRichIterableTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedRichIterableTest::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedRichIterableTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedRichIterableTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedRichIterableTest::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedRichIterableTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedRichIterableTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedRichIterableTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedRichIterableTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedRichIterableTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedRichIterableTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedRichIterableTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedRichIterableTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedRichIterableTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedRichIterableTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedRichIterableTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedRichIterableTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedRichIterableTest::flatCollectFloat;
            this.payloads.detect = SynchronizedRichIterableTest::detect;
            this.payloads.detectOptional = SynchronizedRichIterableTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedRichIterableTest::min;
            this.payloads.minOptional = SynchronizedRichIterableTest::minOptional;
            this.payloads.max = SynchronizedRichIterableTest::max;
            this.payloads.maxOptional = SynchronizedRichIterableTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedRichIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedRichIterableTest::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedRichIterableTest::min_null_safe;
            this.payloads.max_null_safe = SynchronizedRichIterableTest::max_null_safe;
            this.payloads.minBy = SynchronizedRichIterableTest::minBy;
            this.payloads.minByOptional = SynchronizedRichIterableTest::minByOptional;
            this.payloads.maxBy = SynchronizedRichIterableTest::maxBy;
            this.payloads.maxByOptional = SynchronizedRichIterableTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedRichIterableTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedRichIterableTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedRichIterableTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedRichIterableTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedRichIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedRichIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedRichIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedRichIterableTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedRichIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedRichIterableTest::anySatisfyWith;
            this.payloads.count = SynchronizedRichIterableTest::count;
            this.payloads.countWith = SynchronizedRichIterableTest::countWith;
            this.payloads.collectIf = SynchronizedRichIterableTest::collectIf;
            this.payloads.collectWith = SynchronizedRichIterableTest::collectWith;
            this.payloads.collectWith_target = SynchronizedRichIterableTest::collectWith_target;
            this.payloads.getAny = SynchronizedRichIterableTest::getAny;
            this.payloads.getFirst = SynchronizedRichIterableTest::getFirst;
            this.payloads.getLast = SynchronizedRichIterableTest::getLast;
            this.payloads.getOnly = SynchronizedRichIterableTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedRichIterableTest::isEmpty;
            this.payloads.iterator = SynchronizedRichIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedRichIterableTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedRichIterableTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedRichIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedRichIterableTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedRichIterableTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedRichIterableTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedRichIterableTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedRichIterableTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedRichIterableTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedRichIterableTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedRichIterableTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedRichIterableTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedRichIterableTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedRichIterableTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedRichIterableTest::summarizeInt;
            this.payloads.sumLong = SynchronizedRichIterableTest::sumLong;
            this.payloads.summarizeLong = SynchronizedRichIterableTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedRichIterableTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedRichIterableTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedRichIterableTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedRichIterableTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedRichIterableTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedRichIterableTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedRichIterableTest::toArray;
            this.payloads.toList = SynchronizedRichIterableTest::toList;
            this.payloads.toImmutableList = SynchronizedRichIterableTest::toImmutableList;
            this.payloads.toCollection = SynchronizedRichIterableTest::toCollection;
            this.payloads.toBag = SynchronizedRichIterableTest::toBag;
            this.payloads.toImmutableBag = SynchronizedRichIterableTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedRichIterableTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedRichIterableTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedRichIterableTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedRichIterableTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = SynchronizedRichIterableTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedRichIterableTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedRichIterableTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedRichIterableTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedRichIterableTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = SynchronizedRichIterableTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedRichIterableTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedRichIterableTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedRichIterableTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedRichIterableTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedRichIterableTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedRichIterableTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedRichIterableTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedRichIterableTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedRichIterableTest::toSet;
            this.payloads.toImmutableSet = SynchronizedRichIterableTest::toImmutableSet;
            this.payloads.toMap = SynchronizedRichIterableTest::toMap;
            this.payloads.toImmutableMap = SynchronizedRichIterableTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedRichIterableTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedRichIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedRichIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedRichIterableTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedRichIterableTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedRichIterableTest::toImmutableBiMap;
            this.payloads.testToString = SynchronizedRichIterableTest::testToString;
            this.payloads.makeString = SynchronizedRichIterableTest::makeString;
            this.payloads.makeStringWithSeparator = SynchronizedRichIterableTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedRichIterableTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedRichIterableTest::fusedCollectMakeString;
            this.payloads.appendString = SynchronizedRichIterableTest::appendString;
            this.payloads.appendStringWithSeparator = SynchronizedRichIterableTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedRichIterableTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedRichIterableTest::appendStringThrows;
            this.payloads.countBy = SynchronizedRichIterableTest::countBy;
            this.payloads.countByWith = SynchronizedRichIterableTest::countByWith;
            this.payloads.countByEach = SynchronizedRichIterableTest::countByEach;
            this.payloads.groupByEach = SynchronizedRichIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedRichIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedRichIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedRichIterableTest::zip;
            this.payloads.zipWithIndex = SynchronizedRichIterableTest::zipWithIndex;
            this.payloads.chunk = SynchronizedRichIterableTest::chunk;
            this.payloads.chunk_empty = SynchronizedRichIterableTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedRichIterableTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = SynchronizedRichIterableTest::empty;
            this.payloads.notEmpty = SynchronizedRichIterableTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedRichIterableTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedRichIterableTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedRichIterableTest::reduceOptional;
            this.payloads.chunk_large_size = SynchronizedRichIterableTest::chunk_large_size;
            this.payloads.partition = SynchronizedRichIterableTest::partition;
            this.payloads.partitionWith = SynchronizedRichIterableTest::partitionWith;
            this.payloads.groupBy = SynchronizedRichIterableTest::groupBy;
            this.payloads.groupByWithTarget = SynchronizedRichIterableTest::groupByWithTarget;
            this.payloads.asLazy = SynchronizedRichIterableTest::asLazy;
            this.payloads.nullCheck = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedRichIterableTest::nullCheck, java.lang.IllegalArgumentException.class);
        }
    }
}
