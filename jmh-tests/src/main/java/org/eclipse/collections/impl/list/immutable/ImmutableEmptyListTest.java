/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.list.PartitionImmutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;

public class ImmutableEmptyListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return Lists.immutable.empty();
    }

    @Override
    @Test
    public void indexOf() {
        Assert.assertEquals(-1, this.classUnderTest().indexOf(1));
        Assert.assertEquals(-1, this.classUnderTest().indexOf(null));
        ImmutableList<Integer> immutableList = this.classUnderTest().newWith(null);
        Assert.assertEquals(immutableList.size() - 1, immutableList.indexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().indexOf(Integer.MAX_VALUE));
    }

    @Override
    @Test
    public void lastIndexOf() {
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(1));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(null));
        ImmutableList<Integer> immutableList = this.classUnderTest().newWith(null);
        Assert.assertEquals(immutableList.size() - 1, immutableList.lastIndexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(Integer.MAX_VALUE));
    }

    @Test
    public void newWithout() {
        Assert.assertSame(Lists.immutable.empty(), Lists.immutable.empty().newWithout(1));
        Assert.assertSame(Lists.immutable.empty(), Lists.immutable.empty().newWithoutAll(Interval.oneTo(3)));
    }

    @Override
    @Test
    public void reverseForEach() {
        ImmutableList<Integer> list = Lists.immutable.empty();
        MutableList<Integer> result = Lists.mutable.empty();
        list.reverseForEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(list, result);
    }

    @Override
    @Test
    public void reverseForEachWithIndex() {
        ImmutableList<Object> list = Lists.immutable.empty();
        list.reverseForEachWithIndex((each, index) -> fail());
    }

    @Override
    @Test
    public void forEachFromTo() {
        MutableList<Integer> result = Lists.mutable.empty();
        MutableList<Integer> reverseResult = Lists.mutable.empty();
        ImmutableList<Integer> list = this.classUnderTest();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.forEach(0, list.size() - 1, CollectionAddProcedure.on(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.forEach(list.size() - 1, 0, CollectionAddProcedure.on(reverseResult)));
    }

    @Override
    @Test
    public void forEachWithIndexFromTo() {
        MutableList<Integer> result = Lists.mutable.empty();
        MutableList<Integer> reverseResult = Lists.mutable.empty();
        ImmutableList<Integer> list = this.classUnderTest();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.forEachWithIndex(0, list.size() - 1, ObjectIntProcedures.fromProcedure(CollectionAddProcedure.on(result))));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.forEachWithIndex(list.size() - 1, 0, ObjectIntProcedures.fromProcedure(CollectionAddProcedure.on(reverseResult))));
    }

    @Override
    @Test
    public void detect() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detect(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(1)));
    }

    @Override
    @Test
    public void distinct() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertNotNull(integers.distinct());
        Assert.assertTrue(integers.isEmpty());
    }

    @Override
    @Test
    public void countWith() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertEquals(0, integers.countWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void corresponds() {
        // Evaluates true for all empty lists and false for all non-empty lists
        Assert.assertTrue(this.classUnderTest().corresponds(Lists.mutable.empty(), Predicates2.alwaysFalse()));
        ImmutableList<Integer> integers = this.classUnderTest().newWith(Integer.valueOf(1));
        Assert.assertFalse(this.classUnderTest().corresponds(integers, Predicates2.alwaysTrue()));
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void allSatisfyWith() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    public void noneSatisfy() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void noneSatisfyWith() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void anySatisfyWith() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void getFirst() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getFirst());
    }

    @Override
    @Test
    public void getLast() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getLast());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @Override
    @Test
    public void isEmpty() {
        ImmutableList<Integer> list = this.classUnderTest();
        Assert.assertTrue(list.isEmpty());
        Assert.assertFalse(list.notEmpty());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max(Integer::compareTo);
    }

    @Test
    @Override
    public void min_null_throws() {
        // Not applicable for empty collections
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws() {
        // Not applicable for empty collections
        super.max_null_throws();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.max_null_throws_without_comparator();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(String::valueOf);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void zip() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(immutableList.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableList.size() + 1, null);
        ImmutableList<Pair<Integer, Object>> pairs = immutableList.zip(nulls);
        Assert.assertEquals(immutableList, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableList<Pair<Integer, Object>> pairsPlusOne = immutableList.zip(nullsPlusOne);
        Assert.assertEquals(immutableList, pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        Assert.assertEquals(immutableList.zip(nulls), immutableList.zip(nulls, FastList.newList()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        ImmutableList<Pair<Integer, Integer>> pairs = immutableList.zipWithIndex();
        Assert.assertEquals(immutableList, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(FastList.<Integer>newList(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableList.zipWithIndex(), immutableList.zipWithIndex(FastList.newList()));
    }

    @Test
    public void chunk() {
        Assert.assertEquals(Lists.mutable.empty(), this.classUnderTest().chunk(2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().chunk(10));
        Verify.assertInstanceOf(ImmutableList.class, this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        ImmutableList<Integer> immutable = this.classUnderTest();
        MutableList<Integer> mutable = FastList.newList(immutable);
        Verify.assertEqualsAndHashCode(immutable, mutable);
        Verify.assertPostSerializedIdentity(immutable);
        Assert.assertNotEquals(immutable, UnifiedSet.newSet(mutable));
    }

    @Override
    @Test
    public void take() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        Assert.assertSame(immutableList, immutableList.take(0));
        Assert.assertSame(immutableList, immutableList.take(10));
        Assert.assertSame(immutableList, immutableList.take(Integer.MAX_VALUE));
    }

    @Override
    @Test
    public void takeWhile() {
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().takeWhile(ignored -> true));
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().takeWhile(ignored -> false));
    }

    @Override
    @Test
    public void drop() {
        super.drop();
        ImmutableList<Integer> immutableList = this.classUnderTest();
        Assert.assertSame(immutableList, immutableList.drop(10));
        Assert.assertSame(immutableList, immutableList.drop(0));
        Assert.assertSame(immutableList, immutableList.drop(Integer.MAX_VALUE));
    }

    @Override
    @Test
    public void dropWhile() {
        super.dropWhile();
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().dropWhile(ignored -> true));
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().dropWhile(ignored -> false));
    }

    @Override
    @Test
    public void partitionWhile() {
        super.partitionWhile();
        PartitionImmutableList<Integer> partition1 = this.classUnderTest().partitionWhile(ignored -> true);
        Assert.assertEquals(Lists.immutable.empty(), partition1.getSelected());
        Assert.assertEquals(Lists.immutable.empty(), partition1.getRejected());
        PartitionImmutableList<Integer> partiton2 = this.classUnderTest().partitionWhile(ignored -> false);
        Assert.assertEquals(Lists.immutable.empty(), partiton2.getSelected());
        Assert.assertEquals(Lists.immutable.empty(), partiton2.getRejected());
    }

    @Override
    @Test
    public void listIterator() {
        ListIterator<Integer> it = this.classUnderTest().listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        Assert.assertThrows(NoSuchElementException.class, it::next);
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
    }

    @Override
    @Test
    public void collect_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.classUnderTest().collect(object -> {
            throw new AssertionError();
        }, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Override
    @Test
    public void collectWith_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.classUnderTest().collectWith((argument1, argument2) -> {
            throw new AssertionError();
        }, 1, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Test
    public void binarySearch() {
        ListIterable<Integer> sortedList = this.classUnderTest();
        Assert.assertEquals(-1, sortedList.binarySearch(1));
    }

    @Test
    public void binarySearchWithComparator() {
        ListIterable<Integer> sortedList = this.classUnderTest();
        Assert.assertEquals(-1, sortedList.binarySearch(1, Integer::compareTo));
    }

    @Override
    @Test
    public void detectIndex() {
        // any predicate will result in -1
        Assert.assertEquals(-1, this.classUnderTest().detectIndex(Predicates.alwaysTrue()));
    }

    @Override
    @Test
    public void detectLastIndex() {
        // any predicate will result in -1
        Assert.assertEquals(-1, this.classUnderTest().detectLastIndex(Predicates.alwaysTrue()));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndex() {
        Verify.assertEmpty(this.classUnderTest().collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndexWithTarget() {
        Verify.assertEmpty(this.classUnderTest().collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    @Test
    public void countByEach() {
        Assert.assertEquals(Bags.immutable.empty(), this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i)));
    }

    @Test
    public void countByEach_target() {
        MutableBag<Integer> target = Bags.mutable.empty();
        Assert.assertEquals(target, this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i), target));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptyListTest instance;

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
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
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
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexFromTo);
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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
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
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
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
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearchWithComparator);
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
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach_target);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptyListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyListTest> countByEach_target;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableEmptyListTest::stream;
            this.payloads.parallelStream = ImmutableEmptyListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableEmptyListTest::countBy;
            this.payloads.countByWith = ImmutableEmptyListTest::countByWith;
            this.payloads.selectWith = ImmutableEmptyListTest::selectWith;
            this.payloads.selectWith_target = ImmutableEmptyListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableEmptyListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableEmptyListTest::rejectWith_target;
            this.payloads.partition = ImmutableEmptyListTest::partition;
            this.payloads.partitionWith = ImmutableEmptyListTest::partitionWith;
            this.payloads.collectWith = ImmutableEmptyListTest::collectWith;
            this.payloads.injectInto = ImmutableEmptyListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableEmptyListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableEmptyListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableEmptyListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableEmptyListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableEmptyListTest::sumFloat;
            this.payloads.sumDouble = ImmutableEmptyListTest::sumDouble;
            this.payloads.sumInteger = ImmutableEmptyListTest::sumInteger;
            this.payloads.sumLong = ImmutableEmptyListTest::sumLong;
            this.payloads.sumByInt = ImmutableEmptyListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableEmptyListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableEmptyListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableEmptyListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableEmptyListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableEmptyListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableEmptyListTest::makeString;
            this.payloads.appendString = ImmutableEmptyListTest::appendString;
            this.payloads.testToString = ImmutableEmptyListTest::testToString;
            this.payloads.select = ImmutableEmptyListTest::select;
            this.payloads.selectInstancesOf = ImmutableEmptyListTest::selectInstancesOf;
            this.payloads.reject = ImmutableEmptyListTest::reject;
            this.payloads.collect = ImmutableEmptyListTest::collect;
            this.payloads.collectByte = ImmutableEmptyListTest::collectByte;
            this.payloads.collectChar = ImmutableEmptyListTest::collectChar;
            this.payloads.collectDouble = ImmutableEmptyListTest::collectDouble;
            this.payloads.collectFloat = ImmutableEmptyListTest::collectFloat;
            this.payloads.collectInt = ImmutableEmptyListTest::collectInt;
            this.payloads.collectLong = ImmutableEmptyListTest::collectLong;
            this.payloads.collectShort = ImmutableEmptyListTest::collectShort;
            this.payloads.flatCollect = ImmutableEmptyListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableEmptyListTest::flatCollectWith;
            this.payloads.detectIfNone = ImmutableEmptyListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableEmptyListTest::detectWithIfNone;
            this.payloads.allSatisfyWith = ImmutableEmptyListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableEmptyListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableEmptyListTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableEmptyListTest::anySatisfyWith;
            this.payloads.count = ImmutableEmptyListTest::count;
            this.payloads.collectIf = ImmutableEmptyListTest::collectIf;
            this.payloads.iterator = ImmutableEmptyListTest::iterator;
            this.payloads.toArray = ImmutableEmptyListTest::toArray;
            this.payloads.toSortedList = ImmutableEmptyListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableEmptyListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableEmptyListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableEmptyListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableEmptyListTest::forLoop;
            this.payloads.iteratorRemove = ImmutableEmptyListTest::iteratorRemove;
            this.payloads.add = ImmutableEmptyListTest::add;
            this.payloads.remove = ImmutableEmptyListTest::remove;
            this.payloads.clear = ImmutableEmptyListTest::clear;
            this.payloads.removeAll = ImmutableEmptyListTest::removeAll;
            this.payloads.retainAll = ImmutableEmptyListTest::retainAll;
            this.payloads.addAll = ImmutableEmptyListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableEmptyListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableEmptyListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableEmptyListTest::tap;
            this.payloads.contains = ImmutableEmptyListTest::contains;
            this.payloads.containsAll = ImmutableEmptyListTest::containsAll;
            this.payloads.containsAllArray = ImmutableEmptyListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableEmptyListTest::containsAllIterable;
            this.payloads.get = ImmutableEmptyListTest::get;
            this.payloads.forEach = ImmutableEmptyListTest::forEach;
            this.payloads.each = ImmutableEmptyListTest::each;
            this.payloads.forEachWith = ImmutableEmptyListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptyListTest::forEachWithIndex;
            this.payloads.select_target = ImmutableEmptyListTest::select_target;
            this.payloads.reject_target = ImmutableEmptyListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableEmptyListTest::flatCollectWithTarget;
            this.payloads.distinctWithHashingStrategy = ImmutableEmptyListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableEmptyListTest::distinctBy;
            this.payloads.collectIfWithTarget = ImmutableEmptyListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableEmptyListTest::toList;
            this.payloads.toSortedListBy = ImmutableEmptyListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableEmptyListTest::removeAtIndex;
            this.payloads.set = ImmutableEmptyListTest::set;
            this.payloads.addAtIndex = ImmutableEmptyListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableEmptyListTest::addAllAtIndex;
            this.payloads.sort = ImmutableEmptyListTest::sort;
            this.payloads.replaceAll = ImmutableEmptyListTest::replaceAll;
            this.payloads.subListFromNegative = ImmutableEmptyListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableEmptyListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableEmptyListTest::subListToGreaterThanSize;
            this.payloads.listIterator_throwsNegative = ImmutableEmptyListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableEmptyListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableEmptyListTest::toStack;
            this.payloads.take_throws = ImmutableEmptyListTest::take_throws;
            this.payloads.drop_throws = ImmutableEmptyListTest::drop_throws;
            this.payloads.collectBoolean = ImmutableEmptyListTest::collectBoolean;
            this.payloads.selectWithIndex = ImmutableEmptyListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableEmptyListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableEmptyListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableEmptyListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableEmptyListTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptyListTest::groupByEach;
            this.payloads.asReversed = ImmutableEmptyListTest::asReversed;
            this.payloads.toReversed = ImmutableEmptyListTest::toReversed;
            this.payloads.toImmutable = ImmutableEmptyListTest::toImmutable;
            this.payloads.indexOf = ImmutableEmptyListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableEmptyListTest::lastIndexOf;
            this.payloads.newWithout = ImmutableEmptyListTest::newWithout;
            this.payloads.reverseForEach = ImmutableEmptyListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableEmptyListTest::reverseForEachWithIndex;
            this.payloads.forEachFromTo = ImmutableEmptyListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableEmptyListTest::forEachWithIndexFromTo;
            this.payloads.detect = ImmutableEmptyListTest::detect;
            this.payloads.detectWith = ImmutableEmptyListTest::detectWith;
            this.payloads.distinct = ImmutableEmptyListTest::distinct;
            this.payloads.countWith = ImmutableEmptyListTest::countWith;
            this.payloads.corresponds = ImmutableEmptyListTest::corresponds;
            this.payloads.allSatisfy = ImmutableEmptyListTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableEmptyListTest::anySatisfy;
            this.payloads.getFirst = ImmutableEmptyListTest::getFirst;
            this.payloads.getLast = ImmutableEmptyListTest::getLast;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::getOnly, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableEmptyListTest::isEmpty;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::max, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = ImmutableEmptyListTest::min_null_throws;
            this.payloads.max_null_throws = ImmutableEmptyListTest::max_null_throws;
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = ImmutableEmptyListTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = ImmutableEmptyListTest::max_null_throws_without_comparator;
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::subList, java.lang.IndexOutOfBoundsException.class);
            this.payloads.zip = ImmutableEmptyListTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptyListTest::zipWithIndex;
            this.payloads.chunk = ImmutableEmptyListTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableEmptyListTest::chunk_large_size;
            this.payloads.equalsAndHashCode = ImmutableEmptyListTest::equalsAndHashCode;
            this.payloads.take = ImmutableEmptyListTest::take;
            this.payloads.takeWhile = ImmutableEmptyListTest::takeWhile;
            this.payloads.drop = ImmutableEmptyListTest::drop;
            this.payloads.dropWhile = ImmutableEmptyListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableEmptyListTest::partitionWhile;
            this.payloads.listIterator = ImmutableEmptyListTest::listIterator;
            this.payloads.collect_target = ImmutableEmptyListTest::collect_target;
            this.payloads.collectWith_target = ImmutableEmptyListTest::collectWith_target;
            this.payloads.binarySearch = ImmutableEmptyListTest::binarySearch;
            this.payloads.binarySearchWithComparator = ImmutableEmptyListTest::binarySearchWithComparator;
            this.payloads.detectIndex = ImmutableEmptyListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableEmptyListTest::detectLastIndex;
            this.payloads.collectWithIndex = ImmutableEmptyListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableEmptyListTest::collectWithIndexWithTarget;
            this.payloads.countByEach = ImmutableEmptyListTest::countByEach;
            this.payloads.countByEach_target = ImmutableEmptyListTest::countByEach_target;
        }
    }
}
