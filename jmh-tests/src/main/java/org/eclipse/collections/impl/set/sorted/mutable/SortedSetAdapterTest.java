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
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SortedSetAdapter}.
 */
public class SortedSetAdapterTest extends AbstractSortedSetTestCase {

    @Override
    protected <T> SortedSetAdapter<T> newWith(T... elements) {
        return new SortedSetAdapter<>(new TreeSet<>(FastList.newListWith(elements)));
    }

    @Override
    protected <T> SortedSetAdapter<T> newWith(Comparator<? super T> comparator, T... elements) {
        TreeSet<T> set = new TreeSet<>(comparator);
        set.addAll(FastList.newListWith(elements));
        return new SortedSetAdapter<>(set);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedSet.class, SortedSetAdapter.adapt(new TreeSet<>()).asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void testClone() {
        super.testClone();
        MutableSortedSet<Integer> set = this.newWith(Collections.<Integer>reverseOrder()).with(1, 2, 3);
        MutableSortedSet<Integer> list2 = set.clone();
        Verify.assertSortedSetsEqual(set, list2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void detectLastIndex() {
        this.newWith(1, 2, 3).detectLastIndex(each -> each % 2 == 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEach() {
        this.newWith(1, 2, 3).reverseForEach(each -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEachWithIndex() {
        this.newWith(1, 2, 3).reverseForEachWithIndex((each, index) -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void toReversed() {
        this.newWith(1, 2, 3).toReversed();
    }

    @Test
    public void adapt() {
        SortedSet<Integer> integers = new TreeSet<>(FastList.newListWith(1, 2, 3, 4));
        MutableSortedSet<Integer> adapter1 = SortedSets.adapt(integers);
        MutableSortedSet<Integer> adapter2 = new SortedSetAdapter<Integer>(new TreeSet<>()).with(1, 2, 3, 4);
        Verify.assertEqualsAndHashCode(adapter1, adapter2);
        Verify.assertSortedSetsEqual(adapter1, adapter2);
    }

    @Override
    @Test
    public void select() {
        super.select();
        SortedSetAdapter<Integer> integers = this.newWith(1, 2, 3, 4, 5);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2), integers.select(Predicates.lessThan(3)));
        Verify.assertInstanceOf(MutableSortedSet.class, this.<Integer>newWith().select(ignored1 -> true));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(), this.newWith().select(ignored -> true));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        SortedSetAdapter<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2), integers.reject(Predicates.greaterThan(2)));
        Verify.assertInstanceOf(MutableSortedSet.class, this.<Integer>newWith().select(ignored1 -> true));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(), this.newWith().reject(ignored -> true));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        Verify.assertListsEqual(FastList.newListWith("1", "2", "3", "4"), this.newWith(1, 2, 3, 4).collect(String::valueOf));
        Verify.assertListsEqual(FastList.newListWith("1", "2", "3", "4"), this.newWith(1, 2, 3, 4).collect(String::valueOf, FastList.newList()));
        Verify.assertInstanceOf(FastList.class, this.newWith().collect(String::valueOf));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableCollection<Integer> set1 = this.newWith(1, 2, 3);
        SortedSetAdapter<Integer> set2 = this.newWith(Collections.reverseOrder(), 1, 2, 3);
        MutableCollection<Integer> set3 = this.newWith(2, 3, 4);
        MutableSortedSet<Integer> set4 = TreeSortedSet.newSetWith(2, 3, 4);
        Verify.assertEqualsAndHashCode(set1, set1);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), set1);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), set2);
        Assert.assertEquals(set1, set2);
        Assert.assertNotEquals(set2, set3);
        Verify.assertEqualsAndHashCode(set3, set4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 1, 2, 3), set2);
    }

    @Test
    public void serialization() {
        MutableSortedSet<Integer> collection = this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3);
        MutableSortedSet<Integer> deserialized = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertPostSerializedEqualsAndHashCode(collection);
        deserialized.add(4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), deserialized);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<Integer> result = Lists.mutable.of();
        MutableCollection<Integer> collection = this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4);
        collection.forEachWithIndex((object, index) -> result.add(object));
        Verify.assertListsEqual(FastList.newListWith(4, 3, 2, 1), result);
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getFirst());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(Collections.reverseOrder(), 1, 2, 3).getFirst());
        Assert.assertThrows(NoSuchElementException.class, () -> new SortedSetAdapter<>(new TreeSet<>()).getFirst());
    }

    @Override
    @Test
    public void getLast() {
        super.getLast();
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(Collections.reverseOrder(), 1, 2, 3).getLast());
        Assert.assertThrows(NoSuchElementException.class, () -> new SortedSetAdapter<>(new TreeSet<>()).getLast());
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableCollection<Integer> objects = this.newWith(2, 3, 1, 4, 5);
        MutableList<Integer> result = Lists.mutable.of();
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i > 0; i--) {
            Integer integer = iterator.next();
            result.add(integer);
        }
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4, 5), result);
    }

    @Test
    public void withMethods() {
        Verify.assertContainsAll(this.newWith().with(1), 1);
        Verify.assertContainsAll(this.newWith().with(1, 2), 1, 2);
        Verify.assertContainsAll(this.newWith().with(1, 2, 3), 1, 2, 3);
        Verify.assertContainsAll(this.newWith().with(1, 2, 3, 4), 1, 2, 3, 4);
    }

    @Test
    public void returnType() {
        // Type TreeSet is important here because it's not a MutableSet
        SortedSet<Integer> set = new TreeSet<>();
        MutableSortedSet<Integer> integerSetAdapter = SortedSetAdapter.adapt(set);
        Verify.assertInstanceOf(MutableSortedSet.class, integerSetAdapter.select(ignored -> true));
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new SortedSetAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> SortedSetAdapter.adapt(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SortedSetAdapterTest instance;

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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexAllRejected() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexAllRejected);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexNoneRejected() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexNoneRejected);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_firstLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
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
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_returnType() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.returnType);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptNull);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new SortedSetAdapterTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectWithIndexAllRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> rejectWithIndexNoneRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> firstLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> returnType;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterTest> adaptNull;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SortedSetAdapterTest::testNewCollection;
            this.payloads.contains = SortedSetAdapterTest::contains;
            this.payloads.containsBy = SortedSetAdapterTest::containsBy;
            this.payloads.containsAllIterable = SortedSetAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = SortedSetAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SortedSetAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = SortedSetAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = SortedSetAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SortedSetAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = SortedSetAdapterTest::containsAllCollection;
            this.payloads.forEach = SortedSetAdapterTest::forEach;
            this.payloads.forEachWith = SortedSetAdapterTest::forEachWith;
            this.payloads.selectInstancesOf = SortedSetAdapterTest::selectInstancesOf;
            this.payloads.collectTarget = SortedSetAdapterTest::collectTarget;
            this.payloads.collectBoolean = SortedSetAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SortedSetAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SortedSetAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SortedSetAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = SortedSetAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SortedSetAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = SortedSetAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = SortedSetAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SortedSetAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SortedSetAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SortedSetAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SortedSetAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SortedSetAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = SortedSetAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SortedSetAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SortedSetAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = SortedSetAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SortedSetAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = SortedSetAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = SortedSetAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SortedSetAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = SortedSetAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = SortedSetAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SortedSetAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = SortedSetAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SortedSetAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SortedSetAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = SortedSetAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = SortedSetAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = SortedSetAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = SortedSetAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = SortedSetAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SortedSetAdapterTest::flatCollectFloat;
            this.payloads.detect = SortedSetAdapterTest::detect;
            this.payloads.detectOptional = SortedSetAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SortedSetAdapterTest::min;
            this.payloads.minOptional = SortedSetAdapterTest::minOptional;
            this.payloads.max = SortedSetAdapterTest::max;
            this.payloads.maxOptional = SortedSetAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SortedSetAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = SortedSetAdapterTest::max_without_comparator;
            this.payloads.minBy = SortedSetAdapterTest::minBy;
            this.payloads.minByOptional = SortedSetAdapterTest::minByOptional;
            this.payloads.maxBy = SortedSetAdapterTest::maxBy;
            this.payloads.maxByOptional = SortedSetAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SortedSetAdapterTest::detectWith;
            this.payloads.detectWithOptional = SortedSetAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = SortedSetAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SortedSetAdapterTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SortedSetAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = SortedSetAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = SortedSetAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SortedSetAdapterTest::noneSatisfyWith;
            this.payloads.anySatisfy = SortedSetAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = SortedSetAdapterTest::anySatisfyWith;
            this.payloads.count = SortedSetAdapterTest::count;
            this.payloads.countWith = SortedSetAdapterTest::countWith;
            this.payloads.collectIf = SortedSetAdapterTest::collectIf;
            this.payloads.getAny = SortedSetAdapterTest::getAny;
            this.payloads.getOnly = SortedSetAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SortedSetAdapterTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SortedSetAdapterTest::injectInto;
            this.payloads.injectIntoInt = SortedSetAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = SortedSetAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = SortedSetAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SortedSetAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = SortedSetAdapterTest::sumFloat;
            this.payloads.summarizeFloat = SortedSetAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SortedSetAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SortedSetAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SortedSetAdapterTest::sumDouble;
            this.payloads.summarizeDouble = SortedSetAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SortedSetAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SortedSetAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SortedSetAdapterTest::sumInteger;
            this.payloads.summarizeInt = SortedSetAdapterTest::summarizeInt;
            this.payloads.sumLong = SortedSetAdapterTest::sumLong;
            this.payloads.summarizeLong = SortedSetAdapterTest::summarizeLong;
            this.payloads.sumByInt = SortedSetAdapterTest::sumByInt;
            this.payloads.sumByFloat = SortedSetAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SortedSetAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SortedSetAdapterTest::sumByLong;
            this.payloads.sumByDouble = SortedSetAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SortedSetAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SortedSetAdapterTest::toArray;
            this.payloads.toList = SortedSetAdapterTest::toList;
            this.payloads.toImmutableList = SortedSetAdapterTest::toImmutableList;
            this.payloads.toCollection = SortedSetAdapterTest::toCollection;
            this.payloads.toBag = SortedSetAdapterTest::toBag;
            this.payloads.toImmutableBag = SortedSetAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SortedSetAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SortedSetAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SortedSetAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SortedSetAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SortedSetAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = SortedSetAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SortedSetAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SortedSetAdapterTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = SortedSetAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SortedSetAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SortedSetAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SortedSetAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SortedSetAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SortedSetAdapterTest::toSet;
            this.payloads.toImmutableSet = SortedSetAdapterTest::toImmutableSet;
            this.payloads.toMap = SortedSetAdapterTest::toMap;
            this.payloads.toImmutableMap = SortedSetAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = SortedSetAdapterTest::toMapTarget;
            this.payloads.toSortedMap = SortedSetAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SortedSetAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SortedSetAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = SortedSetAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = SortedSetAdapterTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SortedSetAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SortedSetAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SortedSetAdapterTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SortedSetAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SortedSetAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SortedSetAdapterTest::appendStringThrows;
            this.payloads.countBy = SortedSetAdapterTest::countBy;
            this.payloads.countByWith = SortedSetAdapterTest::countByWith;
            this.payloads.countByEach = SortedSetAdapterTest::countByEach;
            this.payloads.groupByUniqueKey = SortedSetAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SortedSetAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = SortedSetAdapterTest::chunk;
            this.payloads.chunk_empty = SortedSetAdapterTest::chunk_empty;
            this.payloads.chunk_single = SortedSetAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SortedSetAdapterTest::chunk_large_size;
            this.payloads.empty = SortedSetAdapterTest::empty;
            this.payloads.notEmpty = SortedSetAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = SortedSetAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SortedSetAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SortedSetAdapterTest::reduceOptional;
            this.payloads.newEmpty = SortedSetAdapterTest::newEmpty;
            this.payloads.testNewWith = SortedSetAdapterTest::testNewWith;
            this.payloads.testNewWithWith = SortedSetAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SortedSetAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SortedSetAdapterTest::testNewWithVarArgs;
            this.payloads.removeAll = SortedSetAdapterTest::removeAll;
            this.payloads.removeAllIterable = SortedSetAdapterTest::removeAllIterable;
            this.payloads.retainAll = SortedSetAdapterTest::retainAll;
            this.payloads.retainAllIterable = SortedSetAdapterTest::retainAllIterable;
            this.payloads.clear = SortedSetAdapterTest::clear;
            this.payloads.injectIntoWith = SortedSetAdapterTest::injectIntoWith;
            this.payloads.removeObject = SortedSetAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = SortedSetAdapterTest::selectAndRejectWith;
            this.payloads.removeIfWith = SortedSetAdapterTest::removeIfWith;
            this.payloads.with = SortedSetAdapterTest::with;
            this.payloads.withAll = SortedSetAdapterTest::withAll;
            this.payloads.without = SortedSetAdapterTest::without;
            this.payloads.withoutAll = SortedSetAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SortedSetAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SortedSetAdapterTest::asLazy;
            this.payloads.toImmutable = SortedSetAdapterTest::toImmutable;
            this.payloads.addAll = SortedSetAdapterTest::addAll;
            this.payloads.addAllIterable = SortedSetAdapterTest::addAllIterable;
            this.payloads.testToString = SortedSetAdapterTest::testToString;
            this.payloads.makeString = SortedSetAdapterTest::makeString;
            this.payloads.appendString = SortedSetAdapterTest::appendString;
            this.payloads.removeIf = SortedSetAdapterTest::removeIf;
            this.payloads.tap = SortedSetAdapterTest::tap;
            this.payloads.corresponds = SortedSetAdapterTest::corresponds;
            this.payloads.selectWith = SortedSetAdapterTest::selectWith;
            this.payloads.selectWith_target = SortedSetAdapterTest::selectWith_target;
            this.payloads.rejectWith = SortedSetAdapterTest::rejectWith;
            this.payloads.rejectWith_target = SortedSetAdapterTest::rejectWith_target;
            this.payloads.partition = SortedSetAdapterTest::partition;
            this.payloads.partitionWith = SortedSetAdapterTest::partitionWith;
            this.payloads.partitionWhile = SortedSetAdapterTest::partitionWhile;
            this.payloads.takeWhile = SortedSetAdapterTest::takeWhile;
            this.payloads.dropWhile = SortedSetAdapterTest::dropWhile;
            this.payloads.distinct = SortedSetAdapterTest::distinct;
            this.payloads.collectWithIndex = SortedSetAdapterTest::collectWithIndex;
            this.payloads.selectWithIndex = SortedSetAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexAllRejected = SortedSetAdapterTest::selectWithIndexAllRejected;
            this.payloads.rejectWithIndexNoneRejected = SortedSetAdapterTest::rejectWithIndexNoneRejected;
            this.payloads.rejectWithIndex = SortedSetAdapterTest::rejectWithIndex;
            this.payloads.collectWithIndexWithTarget = SortedSetAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = SortedSetAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = SortedSetAdapterTest::rejectWithIndexWithTarget;
            this.payloads.collectWith = SortedSetAdapterTest::collectWith;
            this.payloads.collectWith_target = SortedSetAdapterTest::collectWith_target;
            this.payloads.flatCollect = SortedSetAdapterTest::flatCollect;
            this.payloads.groupBy = SortedSetAdapterTest::groupBy;
            this.payloads.groupByEach = SortedSetAdapterTest::groupByEach;
            this.payloads.zip = SortedSetAdapterTest::zip;
            this.payloads.zipWithIndex = SortedSetAdapterTest::zipWithIndex;
            this.payloads.union = SortedSetAdapterTest::union;
            this.payloads.unionInto = SortedSetAdapterTest::unionInto;
            this.payloads.intersect = SortedSetAdapterTest::intersect;
            this.payloads.intersectInto = SortedSetAdapterTest::intersectInto;
            this.payloads.difference = SortedSetAdapterTest::difference;
            this.payloads.differenceInto = SortedSetAdapterTest::differenceInto;
            this.payloads.symmetricDifference = SortedSetAdapterTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = SortedSetAdapterTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = SortedSetAdapterTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SortedSetAdapterTest::isProperSubsetOf;
            this.payloads.powerSet = SortedSetAdapterTest::powerSet;
            this.payloads.cartesianProduct = SortedSetAdapterTest::cartesianProduct;
            this.payloads.firstLast = SortedSetAdapterTest::firstLast;
            this.payloads.toSortedSet_natural_ordering = SortedSetAdapterTest::toSortedSet_natural_ordering;
            this.payloads.subSet = SortedSetAdapterTest::subSet;
            this.payloads.headSet = SortedSetAdapterTest::headSet;
            this.payloads.tailSet = SortedSetAdapterTest::tailSet;
            this.payloads.toStack = SortedSetAdapterTest::toStack;
            this.payloads.toSortedBag_natural_ordering = SortedSetAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SortedSetAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SortedSetAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SortedSetAdapterTest::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.forEachWithIndexWithFromTo = SortedSetAdapterTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexOnRange = SortedSetAdapterTest::forEachWithIndexOnRange;
            this.payloads.indexOf = SortedSetAdapterTest::indexOf;
            this.payloads.detectIndex = SortedSetAdapterTest::detectIndex;
            this.payloads.take = SortedSetAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SortedSetAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.getFirstOptional = SortedSetAdapterTest::getFirstOptional;
            this.payloads.getLastOptional = SortedSetAdapterTest::getLastOptional;
            this.payloads.asSynchronized = SortedSetAdapterTest::asSynchronized;
            this.payloads.asUnmodifiable = SortedSetAdapterTest::asUnmodifiable;
            this.payloads.testClone = SortedSetAdapterTest::testClone;
            this.payloads.detectLastIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::detectLastIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEach = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::reverseForEach, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::reverseForEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.toReversed = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterTest::toReversed, java.lang.UnsupportedOperationException.class);
            this.payloads.adapt = SortedSetAdapterTest::adapt;
            this.payloads.select = SortedSetAdapterTest::select;
            this.payloads.reject = SortedSetAdapterTest::reject;
            this.payloads.collect = SortedSetAdapterTest::collect;
            this.payloads.equalsAndHashCode = SortedSetAdapterTest::equalsAndHashCode;
            this.payloads.serialization = SortedSetAdapterTest::serialization;
            this.payloads.forEachWithIndex = SortedSetAdapterTest::forEachWithIndex;
            this.payloads.getFirst = SortedSetAdapterTest::getFirst;
            this.payloads.getLast = SortedSetAdapterTest::getLast;
            this.payloads.iterator = SortedSetAdapterTest::iterator;
            this.payloads.withMethods = SortedSetAdapterTest::withMethods;
            this.payloads.returnType = SortedSetAdapterTest::returnType;
            this.payloads.adaptNull = SortedSetAdapterTest::adaptNull;
        }
    }
}
