/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.sorted.mutable;

import java.util.Collections;
import java.util.TreeSet;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.collection.mutable.AbstractSynchronizedCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedSortedSet}.
 */
public class SynchronizedSortedSetTest extends AbstractSynchronizedCollectionTestCase {

    @Override
    protected <T> MutableSortedSet<T> newWith(T... littleElements) {
        return new SynchronizedSortedSet<>(SortedSetAdapter.adapt(new TreeSet<>(FastList.newListWith(littleElements))));
    }

    @Override
    @Test
    public void newEmpty() {
        super.newEmpty();
        Verify.assertInstanceOf(SynchronizedSortedSet.class, this.newWith().newEmpty());
    }

    @Override
    @Test
    public void removeIf() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(objects.removeIf(Predicates.equal(2)));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 3, 4);
    }

    @Test
    public void removeWithIf() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(objects.removeIfWith(Predicates2.equal(), 2));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 3, 4);
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        MutableSortedSet<Number> mutableSortedSet = SortedSetAdapter.adapt(new TreeSet<>((o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue())));
        MutableSortedSet<Number> synchronizedSortedSet = new SynchronizedSortedSet<>(mutableSortedSet).withAll(FastList.newListWith(1, 2.0, 3, 4.0, 5));
        MutableSortedSet<Integer> integers = synchronizedSortedSet.selectInstancesOf(Integer.class);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 3, 5), integers);
        Assert.assertEquals(FastList.newListWith(1, 3, 5), integers.toList());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableSortedSet<Integer> integers = TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3).asSynchronized();
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith(1, 2, 3));
        Verify.assertPostSerializedEqualsAndHashCode(integers);
        Verify.assertInstanceOf(SynchronizedSortedSet.class, SerializeTestHelper.serializeDeserialize(integers));
        Verify.assertInstanceOf(SynchronizedSortedSet.class, SerializeTestHelper.serializeDeserialize(this.newWith(1, 2, 3)));
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(1, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 5), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test
    public void toImmutableSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(3, 4, null, 1, 2).toSortedBag();
    }

    @Override
    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void min_null_safe() {
        super.min_null_safe();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_safe() {
        super.max_null_safe();
    }

    @Test
    public void getFirstOptional() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2).getFirstOptional().get());
        Assert.assertTrue(this.newWith(1, 2).getFirstOptional().isPresent());
        Assert.assertFalse(this.newWith().getFirstOptional().isPresent());
    }

    @Test
    public void getLastOptional() {
        Assert.assertEquals(Integer.valueOf(2), this.newWith(1, 2).getLastOptional().get());
        Assert.assertTrue(this.newWith(1, 2).getLastOptional().isPresent());
        Assert.assertFalse(this.newWith().getLastOptional().isPresent());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SynchronizedSortedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
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
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedSortedSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> removeWithIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSetTest> getLastOptional;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedSortedSetTest::testNewCollection;
            this.payloads.contains = SynchronizedSortedSetTest::contains;
            this.payloads.containsBy = SynchronizedSortedSetTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedSortedSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedSortedSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedSortedSetTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedSortedSetTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedSortedSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedSortedSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedSortedSetTest::containsAllCollection;
            this.payloads.tap = SynchronizedSortedSetTest::tap;
            this.payloads.forEach = SynchronizedSortedSetTest::forEach;
            this.payloads.forEachWith = SynchronizedSortedSetTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedSortedSetTest::forEachWithIndex;
            this.payloads.select = SynchronizedSortedSetTest::select;
            this.payloads.selectWith = SynchronizedSortedSetTest::selectWith;
            this.payloads.selectWith_target = SynchronizedSortedSetTest::selectWith_target;
            this.payloads.reject = SynchronizedSortedSetTest::reject;
            this.payloads.rejectWith = SynchronizedSortedSetTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedSortedSetTest::rejectWith_target;
            this.payloads.collect = SynchronizedSortedSetTest::collect;
            this.payloads.collectTarget = SynchronizedSortedSetTest::collectTarget;
            this.payloads.collectBoolean = SynchronizedSortedSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedSortedSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedSortedSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedSortedSetTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedSortedSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedSortedSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedSortedSetTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedSortedSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedSortedSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedSortedSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedSortedSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedSortedSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedSortedSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedSortedSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedSortedSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedSortedSetTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedSortedSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedSortedSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedSortedSetTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedSortedSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedSortedSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedSortedSetTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedSortedSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedSortedSetTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedSortedSetTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedSortedSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedSortedSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedSortedSetTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedSortedSetTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedSortedSetTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedSortedSetTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedSortedSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedSortedSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedSortedSetTest::flatCollectFloat;
            this.payloads.detect = SynchronizedSortedSetTest::detect;
            this.payloads.detectOptional = SynchronizedSortedSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedSortedSetTest::min;
            this.payloads.minOptional = SynchronizedSortedSetTest::minOptional;
            this.payloads.max = SynchronizedSortedSetTest::max;
            this.payloads.maxOptional = SynchronizedSortedSetTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedSortedSetTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedSortedSetTest::max_without_comparator;
            this.payloads.minBy = SynchronizedSortedSetTest::minBy;
            this.payloads.minByOptional = SynchronizedSortedSetTest::minByOptional;
            this.payloads.maxBy = SynchronizedSortedSetTest::maxBy;
            this.payloads.maxByOptional = SynchronizedSortedSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedSortedSetTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedSortedSetTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedSortedSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedSortedSetTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedSortedSetTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedSortedSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedSortedSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedSortedSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedSortedSetTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedSortedSetTest::anySatisfyWith;
            this.payloads.count = SynchronizedSortedSetTest::count;
            this.payloads.countWith = SynchronizedSortedSetTest::countWith;
            this.payloads.collectIf = SynchronizedSortedSetTest::collectIf;
            this.payloads.collectWith = SynchronizedSortedSetTest::collectWith;
            this.payloads.collectWith_target = SynchronizedSortedSetTest::collectWith_target;
            this.payloads.getAny = SynchronizedSortedSetTest::getAny;
            this.payloads.getFirst = SynchronizedSortedSetTest::getFirst;
            this.payloads.getLast = SynchronizedSortedSetTest::getLast;
            this.payloads.getOnly = SynchronizedSortedSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedSortedSetTest::isEmpty;
            this.payloads.iterator = SynchronizedSortedSetTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedSortedSetTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedSortedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedSortedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedSortedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedSortedSetTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedSortedSetTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedSortedSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedSortedSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedSortedSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedSortedSetTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedSortedSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedSortedSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedSortedSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedSortedSetTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedSortedSetTest::summarizeInt;
            this.payloads.sumLong = SynchronizedSortedSetTest::sumLong;
            this.payloads.summarizeLong = SynchronizedSortedSetTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedSortedSetTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedSortedSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedSortedSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedSortedSetTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedSortedSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedSortedSetTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedSortedSetTest::toArray;
            this.payloads.partition = SynchronizedSortedSetTest::partition;
            this.payloads.partitionWith = SynchronizedSortedSetTest::partitionWith;
            this.payloads.toList = SynchronizedSortedSetTest::toList;
            this.payloads.toImmutableList = SynchronizedSortedSetTest::toImmutableList;
            this.payloads.toCollection = SynchronizedSortedSetTest::toCollection;
            this.payloads.toBag = SynchronizedSortedSetTest::toBag;
            this.payloads.toImmutableBag = SynchronizedSortedSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedSortedSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedSortedSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedSortedSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedSortedSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedSortedSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = SynchronizedSortedSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedSortedSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedSortedSetTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedSortedSetTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedSortedSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedSortedSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedSortedSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedSortedSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedSortedSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedSortedSetTest::toSet;
            this.payloads.toImmutableSet = SynchronizedSortedSetTest::toImmutableSet;
            this.payloads.toMap = SynchronizedSortedSetTest::toMap;
            this.payloads.toImmutableMap = SynchronizedSortedSetTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedSortedSetTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedSortedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedSortedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedSortedSetTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedSortedSetTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedSortedSetTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedSortedSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedSortedSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedSortedSetTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedSortedSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedSortedSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedSortedSetTest::appendStringThrows;
            this.payloads.countBy = SynchronizedSortedSetTest::countBy;
            this.payloads.countByWith = SynchronizedSortedSetTest::countByWith;
            this.payloads.countByEach = SynchronizedSortedSetTest::countByEach;
            this.payloads.groupBy = SynchronizedSortedSetTest::groupBy;
            this.payloads.groupByEach = SynchronizedSortedSetTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedSortedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedSortedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedSortedSetTest::zip;
            this.payloads.zipWithIndex = SynchronizedSortedSetTest::zipWithIndex;
            this.payloads.chunk = SynchronizedSortedSetTest::chunk;
            this.payloads.chunk_empty = SynchronizedSortedSetTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedSortedSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedSortedSetTest::chunk_large_size;
            this.payloads.empty = SynchronizedSortedSetTest::empty;
            this.payloads.notEmpty = SynchronizedSortedSetTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedSortedSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedSortedSetTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedSortedSetTest::reduceOptional;
            this.payloads.toImmutable = SynchronizedSortedSetTest::toImmutable;
            this.payloads.testNewWith = SynchronizedSortedSetTest::testNewWith;
            this.payloads.testNewWithWith = SynchronizedSortedSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedSortedSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedSortedSetTest::testNewWithVarArgs;
            this.payloads.addAll = SynchronizedSortedSetTest::addAll;
            this.payloads.addAllIterable = SynchronizedSortedSetTest::addAllIterable;
            this.payloads.removeAll = SynchronizedSortedSetTest::removeAll;
            this.payloads.removeAllIterable = SynchronizedSortedSetTest::removeAllIterable;
            this.payloads.retainAll = SynchronizedSortedSetTest::retainAll;
            this.payloads.retainAllIterable = SynchronizedSortedSetTest::retainAllIterable;
            this.payloads.clear = SynchronizedSortedSetTest::clear;
            this.payloads.injectIntoWith = SynchronizedSortedSetTest::injectIntoWith;
            this.payloads.removeObject = SynchronizedSortedSetTest::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedSortedSetTest::selectAndRejectWith;
            this.payloads.removeIfWith = SynchronizedSortedSetTest::removeIfWith;
            this.payloads.with = SynchronizedSortedSetTest::with;
            this.payloads.withAll = SynchronizedSortedSetTest::withAll;
            this.payloads.without = SynchronizedSortedSetTest::without;
            this.payloads.withoutAll = SynchronizedSortedSetTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedSortedSetTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedSortedSetTest::asLazy;
            this.payloads.testToString = SynchronizedSortedSetTest::testToString;
            this.payloads.makeString = SynchronizedSortedSetTest::makeString;
            this.payloads.appendString = SynchronizedSortedSetTest::appendString;
            this.payloads.asSynchronized = SynchronizedSortedSetTest::asSynchronized;
            this.payloads.newEmpty = SynchronizedSortedSetTest::newEmpty;
            this.payloads.removeIf = SynchronizedSortedSetTest::removeIf;
            this.payloads.removeWithIf = SynchronizedSortedSetTest::removeWithIf;
            this.payloads.asUnmodifiable = SynchronizedSortedSetTest::asUnmodifiable;
            this.payloads.selectInstancesOf = SynchronizedSortedSetTest::selectInstancesOf;
            this.payloads.equalsAndHashCode = SynchronizedSortedSetTest::equalsAndHashCode;
            this.payloads.toSortedBag_natural_ordering = SynchronizedSortedSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedSortedSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedSortedSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedSortedSetTest::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSetTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.getFirstOptional = SynchronizedSortedSetTest::getFirstOptional;
            this.payloads.getLastOptional = SynchronizedSortedSetTest::getLastOptional;
        }
    }
}
