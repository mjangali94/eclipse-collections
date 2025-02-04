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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableEmptySetTestCase extends AbstractImmutableSetTestCase {

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().castToSet().containsAll(new HashSet<>()));
        Assert.assertFalse(this.classUnderTest().castToSet().containsAll(UnifiedSet.newSetWith(1)));
    }

    @Override
    @Test
    public void newWith() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(1, immutable.newWith(1).castToSet());
    }

    @Override
    @Test
    public void detect() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detect(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(1)));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void anySatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void allSatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    public void noneSatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void noneSatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void getFirst() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getFirst());
    }

    @Override
    @Test
    public void getLast() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @Override
    @Test
    public void isEmpty() {
        ImmutableSet<Integer> list = this.classUnderTest();
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
    @Test
    public void zip() {
        ImmutableSet<Integer> immutableSet = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(immutableSet.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableSet.size() + 1, null);
        ImmutableSet<Pair<Integer, Object>> pairs = immutableSet.zip(nulls);
        Assert.assertEquals(immutableSet, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableSet<Pair<Integer, Object>> pairsPlusOne = immutableSet.zip(nullsPlusOne);
        Assert.assertEquals(immutableSet, pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        Assert.assertEquals(immutableSet.zip(nulls), immutableSet.zip(nulls, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        ImmutableSet<Integer> immutableSet = this.classUnderTest();
        ImmutableSet<Pair<Integer, Integer>> pairs = immutableSet.zipWithIndex();
        Assert.assertEquals(immutableSet, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableSet.zipWithIndex(), immutableSet.zipWithIndex(UnifiedSet.newSet()));
    }

    @Test
    public void chunk() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void union() {
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), this.classUnderTest().union(UnifiedSet.newSetWith(1, 2, 3)));
    }

    @Override
    @Test
    public void unionInto() {
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), this.classUnderTest().unionInto(UnifiedSet.newSetWith(1, 2, 3), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void intersect() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersect(UnifiedSet.newSetWith(1, 2, 3)));
    }

    @Override
    @Test
    public void intersectInto() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersectInto(UnifiedSet.newSetWith(1, 2, 3), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void difference() {
        ImmutableSet<Integer> set = this.classUnderTest();
        ImmutableSet<Integer> difference = set.difference(UnifiedSet.newSetWith(1, 2, 3, 999));
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith(999)));
    }

    @Override
    @Test
    public void differenceInto() {
        ImmutableSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> difference = set.differenceInto(UnifiedSet.newSetWith(1, 2, 3, 999), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith(99), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void symmetricDifference() {
        Assert.assertEquals(UnifiedSet.newSetWith(999), this.classUnderTest().symmetricDifference(UnifiedSet.newSetWith(999)));
    }

    @Override
    @Test
    public void symmetricDifferenceInto() {
        Assert.assertEquals(UnifiedSet.newSetWith(999), this.classUnderTest().symmetricDifferenceInto(UnifiedSet.newSetWith(999), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        ImmutableBooleanSet actual = integers.collectBoolean(PrimitiveFunctions.integerIsPositive());
        Verify.assertEmpty(actual);
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableEmptySetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableEmptySetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableEmptySetTestCase> collectWith_target;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = AbstractImmutableEmptySetTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableEmptySetTestCase::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = AbstractImmutableEmptySetTestCase::countBy;
            this.payloads.countByWith = AbstractImmutableEmptySetTestCase::countByWith;
            this.payloads.countByEach = AbstractImmutableEmptySetTestCase::countByEach;
            this.payloads.selectWith = AbstractImmutableEmptySetTestCase::selectWith;
            this.payloads.selectWith_target = AbstractImmutableEmptySetTestCase::selectWith_target;
            this.payloads.rejectWith = AbstractImmutableEmptySetTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractImmutableEmptySetTestCase::rejectWith_target;
            this.payloads.partition = AbstractImmutableEmptySetTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableEmptySetTestCase::partitionWith;
            this.payloads.collectWith = AbstractImmutableEmptySetTestCase::collectWith;
            this.payloads.injectInto = AbstractImmutableEmptySetTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractImmutableEmptySetTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractImmutableEmptySetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableEmptySetTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractImmutableEmptySetTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractImmutableEmptySetTestCase::sumFloat;
            this.payloads.sumDouble = AbstractImmutableEmptySetTestCase::sumDouble;
            this.payloads.sumInteger = AbstractImmutableEmptySetTestCase::sumInteger;
            this.payloads.sumLong = AbstractImmutableEmptySetTestCase::sumLong;
            this.payloads.sumByInt = AbstractImmutableEmptySetTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableEmptySetTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractImmutableEmptySetTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractImmutableEmptySetTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableEmptySetTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractImmutableEmptySetTestCase::sumByDoubleConsistentRounding;
            this.payloads.makeString = AbstractImmutableEmptySetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableEmptySetTestCase::appendString;
            this.payloads.testToString = AbstractImmutableEmptySetTestCase::testToString;
            this.payloads.select = AbstractImmutableEmptySetTestCase::select;
            this.payloads.selectInstancesOf = AbstractImmutableEmptySetTestCase::selectInstancesOf;
            this.payloads.reject = AbstractImmutableEmptySetTestCase::reject;
            this.payloads.collect = AbstractImmutableEmptySetTestCase::collect;
            this.payloads.collectByte = AbstractImmutableEmptySetTestCase::collectByte;
            this.payloads.collectChar = AbstractImmutableEmptySetTestCase::collectChar;
            this.payloads.collectDouble = AbstractImmutableEmptySetTestCase::collectDouble;
            this.payloads.collectFloat = AbstractImmutableEmptySetTestCase::collectFloat;
            this.payloads.collectInt = AbstractImmutableEmptySetTestCase::collectInt;
            this.payloads.collectLong = AbstractImmutableEmptySetTestCase::collectLong;
            this.payloads.collectShort = AbstractImmutableEmptySetTestCase::collectShort;
            this.payloads.flatCollect = AbstractImmutableEmptySetTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractImmutableEmptySetTestCase::flatCollectWith;
            this.payloads.detectIfNone = AbstractImmutableEmptySetTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableEmptySetTestCase::detectWithIfNone;
            this.payloads.allSatisfyWith = AbstractImmutableEmptySetTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableEmptySetTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableEmptySetTestCase::noneSatisfyWith;
            this.payloads.anySatisfyWith = AbstractImmutableEmptySetTestCase::anySatisfyWith;
            this.payloads.count = AbstractImmutableEmptySetTestCase::count;
            this.payloads.countWith = AbstractImmutableEmptySetTestCase::countWith;
            this.payloads.collectIf = AbstractImmutableEmptySetTestCase::collectIf;
            this.payloads.iterator = AbstractImmutableEmptySetTestCase::iterator;
            this.payloads.toArray = AbstractImmutableEmptySetTestCase::toArray;
            this.payloads.toSortedList = AbstractImmutableEmptySetTestCase::toSortedList;
            this.payloads.toSortedSet = AbstractImmutableEmptySetTestCase::toSortedSet;
            this.payloads.toSortedSetWithComparator = AbstractImmutableEmptySetTestCase::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = AbstractImmutableEmptySetTestCase::toSortedSetBy;
            this.payloads.forLoop = AbstractImmutableEmptySetTestCase::forLoop;
            this.payloads.iteratorRemove = AbstractImmutableEmptySetTestCase::iteratorRemove;
            this.payloads.add = AbstractImmutableEmptySetTestCase::add;
            this.payloads.remove = AbstractImmutableEmptySetTestCase::remove;
            this.payloads.clear = AbstractImmutableEmptySetTestCase::clear;
            this.payloads.removeAll = AbstractImmutableEmptySetTestCase::removeAll;
            this.payloads.retainAll = AbstractImmutableEmptySetTestCase::retainAll;
            this.payloads.addAll = AbstractImmutableEmptySetTestCase::addAll;
            this.payloads.aggregateByMutating = AbstractImmutableEmptySetTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractImmutableEmptySetTestCase::aggregateByNonMutating;
            this.payloads.tap = AbstractImmutableEmptySetTestCase::tap;
            this.payloads.equalsAndHashCode = AbstractImmutableEmptySetTestCase::equalsAndHashCode;
            this.payloads.newWithout = AbstractImmutableEmptySetTestCase::newWithout;
            this.payloads.newWithAll = AbstractImmutableEmptySetTestCase::newWithAll;
            this.payloads.newWithoutAll = AbstractImmutableEmptySetTestCase::newWithoutAll;
            this.payloads.contains = AbstractImmutableEmptySetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableEmptySetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableEmptySetTestCase::containsAllIterable;
            this.payloads.forEach = AbstractImmutableEmptySetTestCase::forEach;
            this.payloads.forEachWith = AbstractImmutableEmptySetTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableEmptySetTestCase::forEachWithIndex;
            this.payloads.select_target = AbstractImmutableEmptySetTestCase::select_target;
            this.payloads.reject_target = AbstractImmutableEmptySetTestCase::reject_target;
            this.payloads.flatCollectWithTarget = AbstractImmutableEmptySetTestCase::flatCollectWithTarget;
            this.payloads.collectIfWithTarget = AbstractImmutableEmptySetTestCase::collectIfWithTarget;
            this.payloads.toList = AbstractImmutableEmptySetTestCase::toList;
            this.payloads.toSortedListBy = AbstractImmutableEmptySetTestCase::toSortedListBy;
            this.payloads.groupBy = AbstractImmutableEmptySetTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableEmptySetTestCase::groupByEach;
            this.payloads.groupByWithTarget = AbstractImmutableEmptySetTestCase::groupByWithTarget;
            this.payloads.groupByEachWithTarget = AbstractImmutableEmptySetTestCase::groupByEachWithTarget;
            this.payloads.isSubsetOf = AbstractImmutableEmptySetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableEmptySetTestCase::isProperSubsetOf;
            this.payloads.powerSet = AbstractImmutableEmptySetTestCase::powerSet;
            this.payloads.cartesianProduct = AbstractImmutableEmptySetTestCase::cartesianProduct;
            this.payloads.toImmutable = AbstractImmutableEmptySetTestCase::toImmutable;
            this.payloads.containsAll = AbstractImmutableEmptySetTestCase::containsAll;
            this.payloads.newWith = AbstractImmutableEmptySetTestCase::newWith;
            this.payloads.detect = AbstractImmutableEmptySetTestCase::detect;
            this.payloads.detectWith = AbstractImmutableEmptySetTestCase::detectWith;
            this.payloads.anySatisfy = AbstractImmutableEmptySetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableEmptySetTestCase::allSatisfy;
            this.payloads.getFirst = AbstractImmutableEmptySetTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableEmptySetTestCase::getLast;
            this.payloads.getOnly = AbstractImmutableEmptySetTestCase::getOnly;
            this.payloads.isEmpty = AbstractImmutableEmptySetTestCase::isEmpty;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::max, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = AbstractImmutableEmptySetTestCase::min_null_throws;
            this.payloads.max_null_throws = AbstractImmutableEmptySetTestCase::max_null_throws;
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = AbstractImmutableEmptySetTestCase::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = AbstractImmutableEmptySetTestCase::max_null_throws_without_comparator;
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::maxBy, java.util.NoSuchElementException.class);
            this.payloads.zip = AbstractImmutableEmptySetTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableEmptySetTestCase::zipWithIndex;
            this.payloads.chunk = AbstractImmutableEmptySetTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableEmptySetTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractImmutableEmptySetTestCase::chunk_large_size;
            this.payloads.union = AbstractImmutableEmptySetTestCase::union;
            this.payloads.unionInto = AbstractImmutableEmptySetTestCase::unionInto;
            this.payloads.intersect = AbstractImmutableEmptySetTestCase::intersect;
            this.payloads.intersectInto = AbstractImmutableEmptySetTestCase::intersectInto;
            this.payloads.difference = AbstractImmutableEmptySetTestCase::difference;
            this.payloads.differenceInto = AbstractImmutableEmptySetTestCase::differenceInto;
            this.payloads.symmetricDifference = AbstractImmutableEmptySetTestCase::symmetricDifference;
            this.payloads.symmetricDifferenceInto = AbstractImmutableEmptySetTestCase::symmetricDifferenceInto;
            this.payloads.collectBoolean = AbstractImmutableEmptySetTestCase::collectBoolean;
            this.payloads.collect_target = AbstractImmutableEmptySetTestCase::collect_target;
            this.payloads.collectWith_target = AbstractImmutableEmptySetTestCase::collectWith_target;
        }
    }
}
