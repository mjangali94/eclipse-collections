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
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class TreeSortedSetTest extends AbstractSortedSetTestCase {

    @Override
    protected <T> TreeSortedSet<T> newWith(T... elements) {
        return TreeSortedSet.newSetWith(elements);
    }

    @Override
    protected <T> TreeSortedSet<T> newWith(Comparator<? super T> comparator, T... elements) {
        return TreeSortedSet.newSetWith(comparator, elements);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedSet.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void sortedSetIterableConstructor() {
        TreeSortedSet<Integer> sortedSetA = TreeSortedSet.newSet(Collections.reverseOrder());
        TreeSortedSet<Integer> sortedSetB = TreeSortedSet.newSet(sortedSetA.with(1).with(2, 3).with(4, 5, 6));
        Verify.assertSortedSetsEqual(sortedSetA, sortedSetB);
        Assert.assertTrue(sortedSetA.first().equals(sortedSetB.first()) && sortedSetB.first() == 6);
        Verify.assertSortedSetsEqual(sortedSetB, new TreeSortedSet<>(sortedSetB));
    }

    @Test
    public void sortedSetConstructor() {
        SortedSet<String> setA = new TreeSet<>(FastList.newListWith("a", "c", "b", "d"));
        Verify.assertSortedSetsEqual(setA, TreeSortedSet.newSet(setA));
        Verify.assertSortedSetsEqual(setA, new TreeSortedSet<>(setA));
    }

    @Test
    public void iterableConstructor() {
        LazyIterable<Integer> integerLazyIterable = FastList.newListWith(2, 4, 1, 3).asLazy();
        TreeSortedSet<Integer> sortedSet = TreeSortedSet.newSet(integerLazyIterable);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), sortedSet);
    }

    @Test
    public void serialization() {
        MutableSortedSet<Integer> set = this.newWith(1, 2, 3, 4, 5);
        Verify.assertPostSerializedEqualsAndHashCode(set);
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public TreeSortedSetTest instance;

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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_sortedSetIterableConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortedSetIterableConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortedSetConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortedSetConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterableConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterableConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> payload) throws java.lang.Throwable {
            this.instance = new TreeSortedSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectWithIndexAllRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> rejectWithIndexNoneRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> firstLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sortedSetIterableConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> sortedSetConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> iterableConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetTest> toReversed;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = TreeSortedSetTest::testNewCollection;
            this.payloads.contains = TreeSortedSetTest::contains;
            this.payloads.containsBy = TreeSortedSetTest::containsBy;
            this.payloads.containsAllIterable = TreeSortedSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = TreeSortedSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = TreeSortedSetTest::containsNoneIterable;
            this.payloads.containsAllArray = TreeSortedSetTest::containsAllArray;
            this.payloads.containsAnyCollection = TreeSortedSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = TreeSortedSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = TreeSortedSetTest::containsAllCollection;
            this.payloads.forEach = TreeSortedSetTest::forEach;
            this.payloads.forEachWith = TreeSortedSetTest::forEachWith;
            this.payloads.forEachWithIndex = TreeSortedSetTest::forEachWithIndex;
            this.payloads.selectInstancesOf = TreeSortedSetTest::selectInstancesOf;
            this.payloads.collectTarget = TreeSortedSetTest::collectTarget;
            this.payloads.collectBoolean = TreeSortedSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = TreeSortedSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = TreeSortedSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = TreeSortedSetTest::collectByte;
            this.payloads.collectByteWithTarget = TreeSortedSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = TreeSortedSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = TreeSortedSetTest::collectChar;
            this.payloads.collectCharWithTarget = TreeSortedSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = TreeSortedSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = TreeSortedSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = TreeSortedSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = TreeSortedSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = TreeSortedSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = TreeSortedSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = TreeSortedSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = TreeSortedSetTest::collectInt;
            this.payloads.collectIntWithTarget = TreeSortedSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = TreeSortedSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = TreeSortedSetTest::collectLong;
            this.payloads.collectLongWithTarget = TreeSortedSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = TreeSortedSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = TreeSortedSetTest::collectShort;
            this.payloads.collectShortWithTarget = TreeSortedSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = TreeSortedSetTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = TreeSortedSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = TreeSortedSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = TreeSortedSetTest::flatCollectByte;
            this.payloads.flatCollectShort = TreeSortedSetTest::flatCollectShort;
            this.payloads.flatCollectInt = TreeSortedSetTest::flatCollectInt;
            this.payloads.flatCollectChar = TreeSortedSetTest::flatCollectChar;
            this.payloads.flatCollectLong = TreeSortedSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = TreeSortedSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = TreeSortedSetTest::flatCollectFloat;
            this.payloads.detect = TreeSortedSetTest::detect;
            this.payloads.detectOptional = TreeSortedSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = TreeSortedSetTest::min;
            this.payloads.minOptional = TreeSortedSetTest::minOptional;
            this.payloads.max = TreeSortedSetTest::max;
            this.payloads.maxOptional = TreeSortedSetTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = TreeSortedSetTest::min_without_comparator;
            this.payloads.max_without_comparator = TreeSortedSetTest::max_without_comparator;
            this.payloads.minBy = TreeSortedSetTest::minBy;
            this.payloads.minByOptional = TreeSortedSetTest::minByOptional;
            this.payloads.maxBy = TreeSortedSetTest::maxBy;
            this.payloads.maxByOptional = TreeSortedSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = TreeSortedSetTest::detectWith;
            this.payloads.detectWithOptional = TreeSortedSetTest::detectWithOptional;
            this.payloads.detectIfNone = TreeSortedSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = TreeSortedSetTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = TreeSortedSetTest::allSatisfy;
            this.payloads.allSatisfyWith = TreeSortedSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = TreeSortedSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TreeSortedSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = TreeSortedSetTest::anySatisfy;
            this.payloads.anySatisfyWith = TreeSortedSetTest::anySatisfyWith;
            this.payloads.count = TreeSortedSetTest::count;
            this.payloads.countWith = TreeSortedSetTest::countWith;
            this.payloads.collectIf = TreeSortedSetTest::collectIf;
            this.payloads.getAny = TreeSortedSetTest::getAny;
            this.payloads.getFirst = TreeSortedSetTest::getFirst;
            this.payloads.getLast = TreeSortedSetTest::getLast;
            this.payloads.getOnly = TreeSortedSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = TreeSortedSetTest::isEmpty;
            this.payloads.iterator = TreeSortedSetTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = TreeSortedSetTest::injectInto;
            this.payloads.injectIntoInt = TreeSortedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = TreeSortedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = TreeSortedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = TreeSortedSetTest::injectIntoFloat;
            this.payloads.sumFloat = TreeSortedSetTest::sumFloat;
            this.payloads.summarizeFloat = TreeSortedSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = TreeSortedSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = TreeSortedSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = TreeSortedSetTest::sumDouble;
            this.payloads.summarizeDouble = TreeSortedSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = TreeSortedSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = TreeSortedSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = TreeSortedSetTest::sumInteger;
            this.payloads.summarizeInt = TreeSortedSetTest::summarizeInt;
            this.payloads.sumLong = TreeSortedSetTest::sumLong;
            this.payloads.summarizeLong = TreeSortedSetTest::summarizeLong;
            this.payloads.sumByInt = TreeSortedSetTest::sumByInt;
            this.payloads.sumByFloat = TreeSortedSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = TreeSortedSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = TreeSortedSetTest::sumByLong;
            this.payloads.sumByDouble = TreeSortedSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = TreeSortedSetTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = TreeSortedSetTest::toArray;
            this.payloads.toList = TreeSortedSetTest::toList;
            this.payloads.toImmutableList = TreeSortedSetTest::toImmutableList;
            this.payloads.toCollection = TreeSortedSetTest::toCollection;
            this.payloads.toBag = TreeSortedSetTest::toBag;
            this.payloads.toImmutableBag = TreeSortedSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = TreeSortedSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = TreeSortedSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = TreeSortedSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = TreeSortedSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = TreeSortedSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = TreeSortedSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = TreeSortedSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = TreeSortedSetTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = TreeSortedSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = TreeSortedSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = TreeSortedSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = TreeSortedSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = TreeSortedSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = TreeSortedSetTest::toSet;
            this.payloads.toImmutableSet = TreeSortedSetTest::toImmutableSet;
            this.payloads.toMap = TreeSortedSetTest::toMap;
            this.payloads.toImmutableMap = TreeSortedSetTest::toImmutableMap;
            this.payloads.toMapTarget = TreeSortedSetTest::toMapTarget;
            this.payloads.toSortedMap = TreeSortedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = TreeSortedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = TreeSortedSetTest::toSortedMapBy;
            this.payloads.toBiMap = TreeSortedSetTest::toBiMap;
            this.payloads.toImmutableBiMap = TreeSortedSetTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = TreeSortedSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = TreeSortedSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = TreeSortedSetTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = TreeSortedSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = TreeSortedSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = TreeSortedSetTest::appendStringThrows;
            this.payloads.countBy = TreeSortedSetTest::countBy;
            this.payloads.countByWith = TreeSortedSetTest::countByWith;
            this.payloads.countByEach = TreeSortedSetTest::countByEach;
            this.payloads.groupByUniqueKey = TreeSortedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TreeSortedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = TreeSortedSetTest::chunk;
            this.payloads.chunk_empty = TreeSortedSetTest::chunk_empty;
            this.payloads.chunk_single = TreeSortedSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TreeSortedSetTest::chunk_large_size;
            this.payloads.empty = TreeSortedSetTest::empty;
            this.payloads.notEmpty = TreeSortedSetTest::notEmpty;
            this.payloads.aggregateByMutating = TreeSortedSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = TreeSortedSetTest::aggregateByNonMutating;
            this.payloads.reduceOptional = TreeSortedSetTest::reduceOptional;
            this.payloads.newEmpty = TreeSortedSetTest::newEmpty;
            this.payloads.testNewWith = TreeSortedSetTest::testNewWith;
            this.payloads.testNewWithWith = TreeSortedSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = TreeSortedSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = TreeSortedSetTest::testNewWithVarArgs;
            this.payloads.removeAll = TreeSortedSetTest::removeAll;
            this.payloads.removeAllIterable = TreeSortedSetTest::removeAllIterable;
            this.payloads.retainAll = TreeSortedSetTest::retainAll;
            this.payloads.retainAllIterable = TreeSortedSetTest::retainAllIterable;
            this.payloads.clear = TreeSortedSetTest::clear;
            this.payloads.injectIntoWith = TreeSortedSetTest::injectIntoWith;
            this.payloads.removeObject = TreeSortedSetTest::removeObject;
            this.payloads.selectAndRejectWith = TreeSortedSetTest::selectAndRejectWith;
            this.payloads.removeIfWith = TreeSortedSetTest::removeIfWith;
            this.payloads.with = TreeSortedSetTest::with;
            this.payloads.withAll = TreeSortedSetTest::withAll;
            this.payloads.without = TreeSortedSetTest::without;
            this.payloads.withoutAll = TreeSortedSetTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = TreeSortedSetTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = TreeSortedSetTest::asLazy;
            this.payloads.toImmutable = TreeSortedSetTest::toImmutable;
            this.payloads.addAll = TreeSortedSetTest::addAll;
            this.payloads.addAllIterable = TreeSortedSetTest::addAllIterable;
            this.payloads.testToString = TreeSortedSetTest::testToString;
            this.payloads.makeString = TreeSortedSetTest::makeString;
            this.payloads.appendString = TreeSortedSetTest::appendString;
            this.payloads.removeIf = TreeSortedSetTest::removeIf;
            this.payloads.equalsAndHashCode = TreeSortedSetTest::equalsAndHashCode;
            this.payloads.tap = TreeSortedSetTest::tap;
            this.payloads.corresponds = TreeSortedSetTest::corresponds;
            this.payloads.select = TreeSortedSetTest::select;
            this.payloads.selectWith = TreeSortedSetTest::selectWith;
            this.payloads.selectWith_target = TreeSortedSetTest::selectWith_target;
            this.payloads.reject = TreeSortedSetTest::reject;
            this.payloads.rejectWith = TreeSortedSetTest::rejectWith;
            this.payloads.rejectWith_target = TreeSortedSetTest::rejectWith_target;
            this.payloads.partition = TreeSortedSetTest::partition;
            this.payloads.partitionWith = TreeSortedSetTest::partitionWith;
            this.payloads.partitionWhile = TreeSortedSetTest::partitionWhile;
            this.payloads.takeWhile = TreeSortedSetTest::takeWhile;
            this.payloads.dropWhile = TreeSortedSetTest::dropWhile;
            this.payloads.distinct = TreeSortedSetTest::distinct;
            this.payloads.collect = TreeSortedSetTest::collect;
            this.payloads.collectWithIndex = TreeSortedSetTest::collectWithIndex;
            this.payloads.selectWithIndex = TreeSortedSetTest::selectWithIndex;
            this.payloads.selectWithIndexAllRejected = TreeSortedSetTest::selectWithIndexAllRejected;
            this.payloads.rejectWithIndexNoneRejected = TreeSortedSetTest::rejectWithIndexNoneRejected;
            this.payloads.rejectWithIndex = TreeSortedSetTest::rejectWithIndex;
            this.payloads.collectWithIndexWithTarget = TreeSortedSetTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = TreeSortedSetTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = TreeSortedSetTest::rejectWithIndexWithTarget;
            this.payloads.collectWith = TreeSortedSetTest::collectWith;
            this.payloads.collectWith_target = TreeSortedSetTest::collectWith_target;
            this.payloads.flatCollect = TreeSortedSetTest::flatCollect;
            this.payloads.groupBy = TreeSortedSetTest::groupBy;
            this.payloads.groupByEach = TreeSortedSetTest::groupByEach;
            this.payloads.zip = TreeSortedSetTest::zip;
            this.payloads.zipWithIndex = TreeSortedSetTest::zipWithIndex;
            this.payloads.union = TreeSortedSetTest::union;
            this.payloads.unionInto = TreeSortedSetTest::unionInto;
            this.payloads.intersect = TreeSortedSetTest::intersect;
            this.payloads.intersectInto = TreeSortedSetTest::intersectInto;
            this.payloads.difference = TreeSortedSetTest::difference;
            this.payloads.differenceInto = TreeSortedSetTest::differenceInto;
            this.payloads.symmetricDifference = TreeSortedSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = TreeSortedSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = TreeSortedSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = TreeSortedSetTest::isProperSubsetOf;
            this.payloads.powerSet = TreeSortedSetTest::powerSet;
            this.payloads.cartesianProduct = TreeSortedSetTest::cartesianProduct;
            this.payloads.firstLast = TreeSortedSetTest::firstLast;
            this.payloads.testClone = TreeSortedSetTest::testClone;
            this.payloads.toSortedSet_natural_ordering = TreeSortedSetTest::toSortedSet_natural_ordering;
            this.payloads.subSet = TreeSortedSetTest::subSet;
            this.payloads.headSet = TreeSortedSetTest::headSet;
            this.payloads.tailSet = TreeSortedSetTest::tailSet;
            this.payloads.toStack = TreeSortedSetTest::toStack;
            this.payloads.toSortedBag_natural_ordering = TreeSortedSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = TreeSortedSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = TreeSortedSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = TreeSortedSetTest::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.forEachWithIndexWithFromTo = TreeSortedSetTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexOnRange = TreeSortedSetTest::forEachWithIndexOnRange;
            this.payloads.indexOf = TreeSortedSetTest::indexOf;
            this.payloads.detectIndex = TreeSortedSetTest::detectIndex;
            this.payloads.take = TreeSortedSetTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TreeSortedSetTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.getFirstOptional = TreeSortedSetTest::getFirstOptional;
            this.payloads.getLastOptional = TreeSortedSetTest::getLastOptional;
            this.payloads.asSynchronized = TreeSortedSetTest::asSynchronized;
            this.payloads.asUnmodifiable = TreeSortedSetTest::asUnmodifiable;
            this.payloads.sortedSetIterableConstructor = TreeSortedSetTest::sortedSetIterableConstructor;
            this.payloads.sortedSetConstructor = TreeSortedSetTest::sortedSetConstructor;
            this.payloads.iterableConstructor = TreeSortedSetTest::iterableConstructor;
            this.payloads.serialization = TreeSortedSetTest::serialization;
            this.payloads.detectLastIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::detectLastIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEach = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::reverseForEach, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::reverseForEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.toReversed = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetTest::toReversed, java.lang.UnsupportedOperationException.class);
        }
    }
}
