/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.SynchronizedMutableList;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

/**
 * JUnit test for {@link SynchronizedMutableCollection}.
 */
public class SynchronizedMutableCollectionTest extends AbstractSynchronizedCollectionTestCase {

    @Override
    protected <T> MutableCollection<T> newWith(T... littleElements) {
        return new SynchronizedMutableCollection<>(FastList.newListWith(littleElements));
    }

    @Override
    @Test
    public void newEmpty() {
        super.newEmpty();
        Verify.assertInstanceOf(SynchronizedMutableList.class, this.newWith().newEmpty());
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

    @Override
    @Test
    public void groupByEach() {
        RichIterable<Integer> underTest = this.newWith(1, 2, 3, 4, 5, 6, 7);
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        for (int i = 1; i < 8; i++) {
            expected.putAll(-i, Interval.fromTo(i, 7));
        }
        Multimap<Integer, Integer> actual = underTest.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = underTest.groupByEach(new NegativeIntervalFunction(), FastListMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableCollection.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableCollection.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void partition() {
        MutableCollection<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionMutableCollection<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        MutableCollection<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionMutableCollection<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    @Test
    public void with() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.with(4);
        Assert.assertSame(coll, collWith);
        Assert.assertEquals(this.newWith(1, 2, 3, 4).toList(), collWith.toList());
    }

    @Override
    @Test
    public void withAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.withAll(FastList.newListWith(4, 5));
        Assert.assertSame(coll, collWith);
        Assert.assertEquals(this.newWith(1, 2, 3, 4, 5).toList(), collWith.toList());
    }

    @Override
    @Test
    public void without() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWithout = coll.without(2);
        Assert.assertSame(coll, collWithout);
        MutableCollection<Integer> expectedSet = this.newWith(1, 3);
        Assert.assertEquals(expectedSet.toList(), collWithout.toList());
        Assert.assertEquals(expectedSet.toList(), collWithout.without(4).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3, 4, 5);
        MutableCollection<Integer> collWithout = coll.withoutAll(FastList.newListWith(2, 4));
        Assert.assertSame(coll, collWithout);
        MutableCollection<Integer> expectedSet = this.newWith(1, 3, 5);
        Assert.assertEquals(expectedSet.toList(), collWithout.toList());
        Assert.assertEquals(expectedSet.toList(), collWithout.withoutAll(FastList.newListWith(2, 4)).toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedMutableCollectionTest instance;

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
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedMutableCollectionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableCollectionTest> withoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedMutableCollectionTest::testNewCollection;
            this.payloads.equalsAndHashCode = SynchronizedMutableCollectionTest::equalsAndHashCode;
            this.payloads.contains = SynchronizedMutableCollectionTest::contains;
            this.payloads.containsBy = SynchronizedMutableCollectionTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedMutableCollectionTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedMutableCollectionTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedMutableCollectionTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedMutableCollectionTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedMutableCollectionTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedMutableCollectionTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedMutableCollectionTest::containsAllCollection;
            this.payloads.tap = SynchronizedMutableCollectionTest::tap;
            this.payloads.forEach = SynchronizedMutableCollectionTest::forEach;
            this.payloads.forEachWith = SynchronizedMutableCollectionTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedMutableCollectionTest::forEachWithIndex;
            this.payloads.select = SynchronizedMutableCollectionTest::select;
            this.payloads.selectWith = SynchronizedMutableCollectionTest::selectWith;
            this.payloads.selectWith_target = SynchronizedMutableCollectionTest::selectWith_target;
            this.payloads.reject = SynchronizedMutableCollectionTest::reject;
            this.payloads.rejectWith = SynchronizedMutableCollectionTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedMutableCollectionTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedMutableCollectionTest::selectInstancesOf;
            this.payloads.collect = SynchronizedMutableCollectionTest::collect;
            this.payloads.collectTarget = SynchronizedMutableCollectionTest::collectTarget;
            this.payloads.collectBoolean = SynchronizedMutableCollectionTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedMutableCollectionTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedMutableCollectionTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedMutableCollectionTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedMutableCollectionTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedMutableCollectionTest::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedMutableCollectionTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedMutableCollectionTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedMutableCollectionTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedMutableCollectionTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedMutableCollectionTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedMutableCollectionTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedMutableCollectionTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedMutableCollectionTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedMutableCollectionTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedMutableCollectionTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedMutableCollectionTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedMutableCollectionTest::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedMutableCollectionTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedMutableCollectionTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedMutableCollectionTest::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedMutableCollectionTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedMutableCollectionTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedMutableCollectionTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedMutableCollectionTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedMutableCollectionTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedMutableCollectionTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedMutableCollectionTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedMutableCollectionTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedMutableCollectionTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedMutableCollectionTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedMutableCollectionTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedMutableCollectionTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedMutableCollectionTest::flatCollectFloat;
            this.payloads.detect = SynchronizedMutableCollectionTest::detect;
            this.payloads.detectOptional = SynchronizedMutableCollectionTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedMutableCollectionTest::min;
            this.payloads.minOptional = SynchronizedMutableCollectionTest::minOptional;
            this.payloads.max = SynchronizedMutableCollectionTest::max;
            this.payloads.maxOptional = SynchronizedMutableCollectionTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedMutableCollectionTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedMutableCollectionTest::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedMutableCollectionTest::min_null_safe;
            this.payloads.max_null_safe = SynchronizedMutableCollectionTest::max_null_safe;
            this.payloads.minBy = SynchronizedMutableCollectionTest::minBy;
            this.payloads.minByOptional = SynchronizedMutableCollectionTest::minByOptional;
            this.payloads.maxBy = SynchronizedMutableCollectionTest::maxBy;
            this.payloads.maxByOptional = SynchronizedMutableCollectionTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedMutableCollectionTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedMutableCollectionTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedMutableCollectionTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedMutableCollectionTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedMutableCollectionTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedMutableCollectionTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedMutableCollectionTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedMutableCollectionTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedMutableCollectionTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedMutableCollectionTest::anySatisfyWith;
            this.payloads.count = SynchronizedMutableCollectionTest::count;
            this.payloads.countWith = SynchronizedMutableCollectionTest::countWith;
            this.payloads.collectIf = SynchronizedMutableCollectionTest::collectIf;
            this.payloads.collectWith = SynchronizedMutableCollectionTest::collectWith;
            this.payloads.collectWith_target = SynchronizedMutableCollectionTest::collectWith_target;
            this.payloads.getAny = SynchronizedMutableCollectionTest::getAny;
            this.payloads.getFirst = SynchronizedMutableCollectionTest::getFirst;
            this.payloads.getLast = SynchronizedMutableCollectionTest::getLast;
            this.payloads.getOnly = SynchronizedMutableCollectionTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedMutableCollectionTest::isEmpty;
            this.payloads.iterator = SynchronizedMutableCollectionTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedMutableCollectionTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedMutableCollectionTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedMutableCollectionTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedMutableCollectionTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedMutableCollectionTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedMutableCollectionTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedMutableCollectionTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedMutableCollectionTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedMutableCollectionTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedMutableCollectionTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedMutableCollectionTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedMutableCollectionTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedMutableCollectionTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedMutableCollectionTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedMutableCollectionTest::summarizeInt;
            this.payloads.sumLong = SynchronizedMutableCollectionTest::sumLong;
            this.payloads.summarizeLong = SynchronizedMutableCollectionTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedMutableCollectionTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedMutableCollectionTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedMutableCollectionTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedMutableCollectionTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedMutableCollectionTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedMutableCollectionTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedMutableCollectionTest::toArray;
            this.payloads.toList = SynchronizedMutableCollectionTest::toList;
            this.payloads.toImmutableList = SynchronizedMutableCollectionTest::toImmutableList;
            this.payloads.toCollection = SynchronizedMutableCollectionTest::toCollection;
            this.payloads.toBag = SynchronizedMutableCollectionTest::toBag;
            this.payloads.toImmutableBag = SynchronizedMutableCollectionTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedMutableCollectionTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedMutableCollectionTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedMutableCollectionTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedMutableCollectionTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = SynchronizedMutableCollectionTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedMutableCollectionTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedMutableCollectionTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedMutableCollectionTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedMutableCollectionTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = SynchronizedMutableCollectionTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedMutableCollectionTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedMutableCollectionTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedMutableCollectionTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedMutableCollectionTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedMutableCollectionTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedMutableCollectionTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedMutableCollectionTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedMutableCollectionTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedMutableCollectionTest::toSet;
            this.payloads.toImmutableSet = SynchronizedMutableCollectionTest::toImmutableSet;
            this.payloads.toMap = SynchronizedMutableCollectionTest::toMap;
            this.payloads.toImmutableMap = SynchronizedMutableCollectionTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedMutableCollectionTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedMutableCollectionTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedMutableCollectionTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedMutableCollectionTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedMutableCollectionTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedMutableCollectionTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedMutableCollectionTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedMutableCollectionTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedMutableCollectionTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedMutableCollectionTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedMutableCollectionTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedMutableCollectionTest::appendStringThrows;
            this.payloads.countBy = SynchronizedMutableCollectionTest::countBy;
            this.payloads.countByWith = SynchronizedMutableCollectionTest::countByWith;
            this.payloads.countByEach = SynchronizedMutableCollectionTest::countByEach;
            this.payloads.groupByUniqueKey = SynchronizedMutableCollectionTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedMutableCollectionTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedMutableCollectionTest::zip;
            this.payloads.zipWithIndex = SynchronizedMutableCollectionTest::zipWithIndex;
            this.payloads.chunk = SynchronizedMutableCollectionTest::chunk;
            this.payloads.chunk_empty = SynchronizedMutableCollectionTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedMutableCollectionTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableCollectionTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedMutableCollectionTest::chunk_large_size;
            this.payloads.empty = SynchronizedMutableCollectionTest::empty;
            this.payloads.notEmpty = SynchronizedMutableCollectionTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedMutableCollectionTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedMutableCollectionTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedMutableCollectionTest::reduceOptional;
            this.payloads.toImmutable = SynchronizedMutableCollectionTest::toImmutable;
            this.payloads.testNewWith = SynchronizedMutableCollectionTest::testNewWith;
            this.payloads.testNewWithWith = SynchronizedMutableCollectionTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedMutableCollectionTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedMutableCollectionTest::testNewWithVarArgs;
            this.payloads.addAll = SynchronizedMutableCollectionTest::addAll;
            this.payloads.addAllIterable = SynchronizedMutableCollectionTest::addAllIterable;
            this.payloads.removeAll = SynchronizedMutableCollectionTest::removeAll;
            this.payloads.removeAllIterable = SynchronizedMutableCollectionTest::removeAllIterable;
            this.payloads.retainAll = SynchronizedMutableCollectionTest::retainAll;
            this.payloads.retainAllIterable = SynchronizedMutableCollectionTest::retainAllIterable;
            this.payloads.clear = SynchronizedMutableCollectionTest::clear;
            this.payloads.injectIntoWith = SynchronizedMutableCollectionTest::injectIntoWith;
            this.payloads.removeObject = SynchronizedMutableCollectionTest::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedMutableCollectionTest::selectAndRejectWith;
            this.payloads.removeIf = SynchronizedMutableCollectionTest::removeIf;
            this.payloads.removeIfWith = SynchronizedMutableCollectionTest::removeIfWith;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedMutableCollectionTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedMutableCollectionTest::asLazy;
            this.payloads.testToString = SynchronizedMutableCollectionTest::testToString;
            this.payloads.makeString = SynchronizedMutableCollectionTest::makeString;
            this.payloads.appendString = SynchronizedMutableCollectionTest::appendString;
            this.payloads.newEmpty = SynchronizedMutableCollectionTest::newEmpty;
            this.payloads.groupBy = SynchronizedMutableCollectionTest::groupBy;
            this.payloads.groupByEach = SynchronizedMutableCollectionTest::groupByEach;
            this.payloads.asSynchronized = SynchronizedMutableCollectionTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedMutableCollectionTest::asUnmodifiable;
            this.payloads.partition = SynchronizedMutableCollectionTest::partition;
            this.payloads.partitionWith = SynchronizedMutableCollectionTest::partitionWith;
            this.payloads.with = SynchronizedMutableCollectionTest::with;
            this.payloads.withAll = SynchronizedMutableCollectionTest::withAll;
            this.payloads.without = SynchronizedMutableCollectionTest::without;
            this.payloads.withoutAll = SynchronizedMutableCollectionTest::withoutAll;
        }
    }
}
