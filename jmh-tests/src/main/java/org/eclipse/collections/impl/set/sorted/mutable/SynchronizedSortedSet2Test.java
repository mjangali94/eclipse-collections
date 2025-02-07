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

import java.util.Comparator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedSortedSet}.
 */
public class SynchronizedSortedSet2Test extends AbstractSortedSetTestCase {

    @Override
    protected <T> MutableSortedSet<T> newWith(T... elements) {
        return new SynchronizedSortedSet<>(TreeSortedSet.newSetWith(elements));
    }

    @Override
    protected <T> MutableSortedSet<T> newWith(Comparator<? super T> comparator, T... elements) {
        return new SynchronizedSortedSet<>(TreeSortedSet.newSetWith(comparator, elements));
    }

    @Override
    public void asSynchronized() {
        MutableSortedSet<Object> synchronizedSet = this.newWith();
        Assert.assertSame(synchronizedSet, synchronizedSet.asSynchronized());
    }

    @Override
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws_without_comparator() {
        this.newWith().min();
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws_without_comparator() {
        this.newWith().max();
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

        public SynchronizedSortedSet2Test instance;

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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedSortedSet2Test();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectWithIndexAllRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> rejectWithIndexNoneRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> firstLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedSet2Test> toReversed;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedSortedSet2Test::testNewCollection;
            this.payloads.contains = SynchronizedSortedSet2Test::contains;
            this.payloads.containsBy = SynchronizedSortedSet2Test::containsBy;
            this.payloads.containsAllIterable = SynchronizedSortedSet2Test::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedSortedSet2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedSortedSet2Test::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedSortedSet2Test::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedSortedSet2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedSortedSet2Test::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedSortedSet2Test::containsAllCollection;
            this.payloads.forEach = SynchronizedSortedSet2Test::forEach;
            this.payloads.forEachWith = SynchronizedSortedSet2Test::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedSortedSet2Test::forEachWithIndex;
            this.payloads.selectInstancesOf = SynchronizedSortedSet2Test::selectInstancesOf;
            this.payloads.collectTarget = SynchronizedSortedSet2Test::collectTarget;
            this.payloads.collectBoolean = SynchronizedSortedSet2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedSortedSet2Test::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedSortedSet2Test::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedSortedSet2Test::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedSortedSet2Test::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedSortedSet2Test::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedSortedSet2Test::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedSortedSet2Test::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedSortedSet2Test::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedSortedSet2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedSortedSet2Test::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedSortedSet2Test::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedSortedSet2Test::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedSortedSet2Test::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedSortedSet2Test::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedSortedSet2Test::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedSortedSet2Test::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedSortedSet2Test::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedSortedSet2Test::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedSortedSet2Test::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedSortedSet2Test::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedSortedSet2Test::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedSortedSet2Test::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedSortedSet2Test::collectShortWithBagTarget;
            this.payloads.flatCollectWith = SynchronizedSortedSet2Test::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedSortedSet2Test::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedSortedSet2Test::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedSortedSet2Test::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedSortedSet2Test::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedSortedSet2Test::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedSortedSet2Test::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedSortedSet2Test::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedSortedSet2Test::flatCollectFloat;
            this.payloads.detect = SynchronizedSortedSet2Test::detect;
            this.payloads.detectOptional = SynchronizedSortedSet2Test::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedSortedSet2Test::min;
            this.payloads.minOptional = SynchronizedSortedSet2Test::minOptional;
            this.payloads.max = SynchronizedSortedSet2Test::max;
            this.payloads.maxOptional = SynchronizedSortedSet2Test::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedSortedSet2Test::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedSortedSet2Test::max_without_comparator;
            this.payloads.minBy = SynchronizedSortedSet2Test::minBy;
            this.payloads.minByOptional = SynchronizedSortedSet2Test::minByOptional;
            this.payloads.maxBy = SynchronizedSortedSet2Test::maxBy;
            this.payloads.maxByOptional = SynchronizedSortedSet2Test::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedSortedSet2Test::detectWith;
            this.payloads.detectWithOptional = SynchronizedSortedSet2Test::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedSortedSet2Test::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedSortedSet2Test::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedSortedSet2Test::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedSortedSet2Test::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedSortedSet2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedSortedSet2Test::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedSortedSet2Test::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedSortedSet2Test::anySatisfyWith;
            this.payloads.count = SynchronizedSortedSet2Test::count;
            this.payloads.countWith = SynchronizedSortedSet2Test::countWith;
            this.payloads.collectIf = SynchronizedSortedSet2Test::collectIf;
            this.payloads.getAny = SynchronizedSortedSet2Test::getAny;
            this.payloads.getFirst = SynchronizedSortedSet2Test::getFirst;
            this.payloads.getLast = SynchronizedSortedSet2Test::getLast;
            this.payloads.getOnly = SynchronizedSortedSet2Test::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedSortedSet2Test::isEmpty;
            this.payloads.iterator = SynchronizedSortedSet2Test::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedSortedSet2Test::injectInto;
            this.payloads.injectIntoInt = SynchronizedSortedSet2Test::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedSortedSet2Test::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedSortedSet2Test::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedSortedSet2Test::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedSortedSet2Test::sumFloat;
            this.payloads.summarizeFloat = SynchronizedSortedSet2Test::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedSortedSet2Test::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedSortedSet2Test::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedSortedSet2Test::sumDouble;
            this.payloads.summarizeDouble = SynchronizedSortedSet2Test::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedSortedSet2Test::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedSortedSet2Test::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedSortedSet2Test::sumInteger;
            this.payloads.summarizeInt = SynchronizedSortedSet2Test::summarizeInt;
            this.payloads.sumLong = SynchronizedSortedSet2Test::sumLong;
            this.payloads.summarizeLong = SynchronizedSortedSet2Test::summarizeLong;
            this.payloads.sumByInt = SynchronizedSortedSet2Test::sumByInt;
            this.payloads.sumByFloat = SynchronizedSortedSet2Test::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedSortedSet2Test::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedSortedSet2Test::sumByLong;
            this.payloads.sumByDouble = SynchronizedSortedSet2Test::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedSortedSet2Test::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedSortedSet2Test::toArray;
            this.payloads.toList = SynchronizedSortedSet2Test::toList;
            this.payloads.toImmutableList = SynchronizedSortedSet2Test::toImmutableList;
            this.payloads.toCollection = SynchronizedSortedSet2Test::toCollection;
            this.payloads.toBag = SynchronizedSortedSet2Test::toBag;
            this.payloads.toImmutableBag = SynchronizedSortedSet2Test::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedSortedSet2Test::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedSortedSet2Test::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedSortedSet2Test::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedSortedSet2Test::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedSortedSet2Test::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = SynchronizedSortedSet2Test::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedSortedSet2Test::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedSortedSet2Test::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedSortedSet2Test::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedSortedSet2Test::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedSortedSet2Test::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedSortedSet2Test::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedSortedSet2Test::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedSortedSet2Test::toSet;
            this.payloads.toImmutableSet = SynchronizedSortedSet2Test::toImmutableSet;
            this.payloads.toMap = SynchronizedSortedSet2Test::toMap;
            this.payloads.toImmutableMap = SynchronizedSortedSet2Test::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedSortedSet2Test::toMapTarget;
            this.payloads.toSortedMap = SynchronizedSortedSet2Test::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedSortedSet2Test::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedSortedSet2Test::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedSortedSet2Test::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedSortedSet2Test::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedSortedSet2Test::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedSortedSet2Test::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedSortedSet2Test::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedSortedSet2Test::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedSortedSet2Test::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedSortedSet2Test::appendStringThrows;
            this.payloads.countBy = SynchronizedSortedSet2Test::countBy;
            this.payloads.countByWith = SynchronizedSortedSet2Test::countByWith;
            this.payloads.countByEach = SynchronizedSortedSet2Test::countByEach;
            this.payloads.groupByUniqueKey = SynchronizedSortedSet2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedSortedSet2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = SynchronizedSortedSet2Test::chunk;
            this.payloads.chunk_empty = SynchronizedSortedSet2Test::chunk_empty;
            this.payloads.chunk_single = SynchronizedSortedSet2Test::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedSortedSet2Test::chunk_large_size;
            this.payloads.empty = SynchronizedSortedSet2Test::empty;
            this.payloads.notEmpty = SynchronizedSortedSet2Test::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedSortedSet2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedSortedSet2Test::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedSortedSet2Test::reduceOptional;
            this.payloads.newEmpty = SynchronizedSortedSet2Test::newEmpty;
            this.payloads.testNewWith = SynchronizedSortedSet2Test::testNewWith;
            this.payloads.testNewWithWith = SynchronizedSortedSet2Test::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedSortedSet2Test::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedSortedSet2Test::testNewWithVarArgs;
            this.payloads.removeAll = SynchronizedSortedSet2Test::removeAll;
            this.payloads.removeAllIterable = SynchronizedSortedSet2Test::removeAllIterable;
            this.payloads.retainAll = SynchronizedSortedSet2Test::retainAll;
            this.payloads.retainAllIterable = SynchronizedSortedSet2Test::retainAllIterable;
            this.payloads.clear = SynchronizedSortedSet2Test::clear;
            this.payloads.injectIntoWith = SynchronizedSortedSet2Test::injectIntoWith;
            this.payloads.removeObject = SynchronizedSortedSet2Test::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedSortedSet2Test::selectAndRejectWith;
            this.payloads.removeIfWith = SynchronizedSortedSet2Test::removeIfWith;
            this.payloads.with = SynchronizedSortedSet2Test::with;
            this.payloads.withAll = SynchronizedSortedSet2Test::withAll;
            this.payloads.without = SynchronizedSortedSet2Test::without;
            this.payloads.withoutAll = SynchronizedSortedSet2Test::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedSortedSet2Test::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedSortedSet2Test::asLazy;
            this.payloads.asSynchronized = SynchronizedSortedSet2Test::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedSortedSet2Test::asUnmodifiable;
            this.payloads.toImmutable = SynchronizedSortedSet2Test::toImmutable;
            this.payloads.addAll = SynchronizedSortedSet2Test::addAll;
            this.payloads.addAllIterable = SynchronizedSortedSet2Test::addAllIterable;
            this.payloads.testToString = SynchronizedSortedSet2Test::testToString;
            this.payloads.makeString = SynchronizedSortedSet2Test::makeString;
            this.payloads.appendString = SynchronizedSortedSet2Test::appendString;
            this.payloads.removeIf = SynchronizedSortedSet2Test::removeIf;
            this.payloads.equalsAndHashCode = SynchronizedSortedSet2Test::equalsAndHashCode;
            this.payloads.tap = SynchronizedSortedSet2Test::tap;
            this.payloads.corresponds = SynchronizedSortedSet2Test::corresponds;
            this.payloads.select = SynchronizedSortedSet2Test::select;
            this.payloads.selectWith = SynchronizedSortedSet2Test::selectWith;
            this.payloads.selectWith_target = SynchronizedSortedSet2Test::selectWith_target;
            this.payloads.reject = SynchronizedSortedSet2Test::reject;
            this.payloads.rejectWith = SynchronizedSortedSet2Test::rejectWith;
            this.payloads.rejectWith_target = SynchronizedSortedSet2Test::rejectWith_target;
            this.payloads.partition = SynchronizedSortedSet2Test::partition;
            this.payloads.partitionWith = SynchronizedSortedSet2Test::partitionWith;
            this.payloads.partitionWhile = SynchronizedSortedSet2Test::partitionWhile;
            this.payloads.takeWhile = SynchronizedSortedSet2Test::takeWhile;
            this.payloads.dropWhile = SynchronizedSortedSet2Test::dropWhile;
            this.payloads.distinct = SynchronizedSortedSet2Test::distinct;
            this.payloads.collect = SynchronizedSortedSet2Test::collect;
            this.payloads.collectWithIndex = SynchronizedSortedSet2Test::collectWithIndex;
            this.payloads.selectWithIndex = SynchronizedSortedSet2Test::selectWithIndex;
            this.payloads.selectWithIndexAllRejected = SynchronizedSortedSet2Test::selectWithIndexAllRejected;
            this.payloads.rejectWithIndexNoneRejected = SynchronizedSortedSet2Test::rejectWithIndexNoneRejected;
            this.payloads.rejectWithIndex = SynchronizedSortedSet2Test::rejectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedSortedSet2Test::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = SynchronizedSortedSet2Test::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = SynchronizedSortedSet2Test::rejectWithIndexWithTarget;
            this.payloads.collectWith = SynchronizedSortedSet2Test::collectWith;
            this.payloads.collectWith_target = SynchronizedSortedSet2Test::collectWith_target;
            this.payloads.flatCollect = SynchronizedSortedSet2Test::flatCollect;
            this.payloads.groupBy = SynchronizedSortedSet2Test::groupBy;
            this.payloads.groupByEach = SynchronizedSortedSet2Test::groupByEach;
            this.payloads.zip = SynchronizedSortedSet2Test::zip;
            this.payloads.zipWithIndex = SynchronizedSortedSet2Test::zipWithIndex;
            this.payloads.union = SynchronizedSortedSet2Test::union;
            this.payloads.unionInto = SynchronizedSortedSet2Test::unionInto;
            this.payloads.intersect = SynchronizedSortedSet2Test::intersect;
            this.payloads.intersectInto = SynchronizedSortedSet2Test::intersectInto;
            this.payloads.difference = SynchronizedSortedSet2Test::difference;
            this.payloads.differenceInto = SynchronizedSortedSet2Test::differenceInto;
            this.payloads.symmetricDifference = SynchronizedSortedSet2Test::symmetricDifference;
            this.payloads.symmetricDifferenceInto = SynchronizedSortedSet2Test::symmetricDifferenceInto;
            this.payloads.isSubsetOf = SynchronizedSortedSet2Test::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedSortedSet2Test::isProperSubsetOf;
            this.payloads.powerSet = SynchronizedSortedSet2Test::powerSet;
            this.payloads.cartesianProduct = SynchronizedSortedSet2Test::cartesianProduct;
            this.payloads.firstLast = SynchronizedSortedSet2Test::firstLast;
            this.payloads.testClone = SynchronizedSortedSet2Test::testClone;
            this.payloads.toSortedSet_natural_ordering = SynchronizedSortedSet2Test::toSortedSet_natural_ordering;
            this.payloads.subSet = SynchronizedSortedSet2Test::subSet;
            this.payloads.headSet = SynchronizedSortedSet2Test::headSet;
            this.payloads.tailSet = SynchronizedSortedSet2Test::tailSet;
            this.payloads.toStack = SynchronizedSortedSet2Test::toStack;
            this.payloads.toSortedBag_natural_ordering = SynchronizedSortedSet2Test::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedSortedSet2Test::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedSortedSet2Test::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedSortedSet2Test::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.forEachWithIndexWithFromTo = SynchronizedSortedSet2Test::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexOnRange = SynchronizedSortedSet2Test::forEachWithIndexOnRange;
            this.payloads.indexOf = SynchronizedSortedSet2Test::indexOf;
            this.payloads.detectIndex = SynchronizedSortedSet2Test::detectIndex;
            this.payloads.take = SynchronizedSortedSet2Test::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SynchronizedSortedSet2Test::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.getFirstOptional = SynchronizedSortedSet2Test::getFirstOptional;
            this.payloads.getLastOptional = SynchronizedSortedSet2Test::getLastOptional;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.detectLastIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::detectLastIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEach = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::reverseForEach, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::reverseForEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.toReversed = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedSet2Test::toReversed, java.lang.UnsupportedOperationException.class);
        }
    }
}
