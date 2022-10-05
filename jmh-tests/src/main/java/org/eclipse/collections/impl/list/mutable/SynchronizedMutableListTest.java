/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedMutableList}.
 */
public class SynchronizedMutableListTest extends AbstractListTestCase {

    @Override
    protected <T> MutableList<T> newWith(T... littleElements) {
        return new SynchronizedMutableList<>(FastList.newListWith(littleElements));
    }

    @Override
    @Test
    public void newEmpty() {
        super.newEmpty();
        Verify.assertInstanceOf(SynchronizedMutableList.class, this.newWith().newEmpty());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith(1, 2, 3));
        Verify.assertInstanceOf(SynchronizedMutableList.class, this.newWith(1, 2, 3));
    }

    @Override
    @Test
    public void testToString() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        Assert.assertEquals("[1, 2, 3]", list.toString());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.newWith(1, 2, 3).makeString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        this.newWith(1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 2, 3", builder.toString());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedMutableListTest instance;

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
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
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
        public void benchmark_randomAccess_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.randomAccess_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
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
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
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
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSizeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSizeException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanToException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanToException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithArrayIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooSmall() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooSmall);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooBig() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooBig);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
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
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnDifferentListSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnDifferentListSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnNullList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnNullList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedMutableListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableListTest> appendString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedMutableListTest::testNewCollection;
            this.payloads.contains = SynchronizedMutableListTest::contains;
            this.payloads.containsBy = SynchronizedMutableListTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedMutableListTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedMutableListTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedMutableListTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedMutableListTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedMutableListTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedMutableListTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedMutableListTest::containsAllCollection;
            this.payloads.tap = SynchronizedMutableListTest::tap;
            this.payloads.forEach = SynchronizedMutableListTest::forEach;
            this.payloads.forEachWith = SynchronizedMutableListTest::forEachWith;
            this.payloads.select = SynchronizedMutableListTest::select;
            this.payloads.selectWith = SynchronizedMutableListTest::selectWith;
            this.payloads.selectWith_target = SynchronizedMutableListTest::selectWith_target;
            this.payloads.reject = SynchronizedMutableListTest::reject;
            this.payloads.rejectWith = SynchronizedMutableListTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedMutableListTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedMutableListTest::selectInstancesOf;
            this.payloads.collect = SynchronizedMutableListTest::collect;
            this.payloads.collectTarget = SynchronizedMutableListTest::collectTarget;
            this.payloads.collectBoolean = SynchronizedMutableListTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedMutableListTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedMutableListTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedMutableListTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedMutableListTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedMutableListTest::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedMutableListTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedMutableListTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedMutableListTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedMutableListTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedMutableListTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedMutableListTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedMutableListTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedMutableListTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedMutableListTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedMutableListTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedMutableListTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedMutableListTest::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedMutableListTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedMutableListTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedMutableListTest::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedMutableListTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedMutableListTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedMutableListTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedMutableListTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedMutableListTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedMutableListTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedMutableListTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedMutableListTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedMutableListTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedMutableListTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedMutableListTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedMutableListTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedMutableListTest::flatCollectFloat;
            this.payloads.detect = SynchronizedMutableListTest::detect;
            this.payloads.detectOptional = SynchronizedMutableListTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedMutableListTest::min;
            this.payloads.minOptional = SynchronizedMutableListTest::minOptional;
            this.payloads.max = SynchronizedMutableListTest::max;
            this.payloads.maxOptional = SynchronizedMutableListTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedMutableListTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedMutableListTest::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedMutableListTest::min_null_safe;
            this.payloads.max_null_safe = SynchronizedMutableListTest::max_null_safe;
            this.payloads.minBy = SynchronizedMutableListTest::minBy;
            this.payloads.minByOptional = SynchronizedMutableListTest::minByOptional;
            this.payloads.maxBy = SynchronizedMutableListTest::maxBy;
            this.payloads.maxByOptional = SynchronizedMutableListTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedMutableListTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedMutableListTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedMutableListTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedMutableListTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedMutableListTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedMutableListTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedMutableListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedMutableListTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedMutableListTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedMutableListTest::anySatisfyWith;
            this.payloads.count = SynchronizedMutableListTest::count;
            this.payloads.countWith = SynchronizedMutableListTest::countWith;
            this.payloads.collectIf = SynchronizedMutableListTest::collectIf;
            this.payloads.collectWith = SynchronizedMutableListTest::collectWith;
            this.payloads.collectWith_target = SynchronizedMutableListTest::collectWith_target;
            this.payloads.getAny = SynchronizedMutableListTest::getAny;
            this.payloads.getFirst = SynchronizedMutableListTest::getFirst;
            this.payloads.getLast = SynchronizedMutableListTest::getLast;
            this.payloads.getOnly = SynchronizedMutableListTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedMutableListTest::isEmpty;
            this.payloads.iterator = SynchronizedMutableListTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedMutableListTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedMutableListTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedMutableListTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedMutableListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedMutableListTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedMutableListTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedMutableListTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedMutableListTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedMutableListTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedMutableListTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedMutableListTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedMutableListTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedMutableListTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedMutableListTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedMutableListTest::summarizeInt;
            this.payloads.sumLong = SynchronizedMutableListTest::sumLong;
            this.payloads.summarizeLong = SynchronizedMutableListTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedMutableListTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedMutableListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedMutableListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedMutableListTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedMutableListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedMutableListTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedMutableListTest::toArray;
            this.payloads.partition = SynchronizedMutableListTest::partition;
            this.payloads.partitionWith = SynchronizedMutableListTest::partitionWith;
            this.payloads.toList = SynchronizedMutableListTest::toList;
            this.payloads.toImmutableList = SynchronizedMutableListTest::toImmutableList;
            this.payloads.toCollection = SynchronizedMutableListTest::toCollection;
            this.payloads.toBag = SynchronizedMutableListTest::toBag;
            this.payloads.toImmutableBag = SynchronizedMutableListTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedMutableListTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedMutableListTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedMutableListTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedMutableListTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = SynchronizedMutableListTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedMutableListTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedMutableListTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedMutableListTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedMutableListTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = SynchronizedMutableListTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedMutableListTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedMutableListTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedMutableListTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedMutableListTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedMutableListTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedMutableListTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedMutableListTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedMutableListTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedMutableListTest::toSet;
            this.payloads.toImmutableSet = SynchronizedMutableListTest::toImmutableSet;
            this.payloads.toMap = SynchronizedMutableListTest::toMap;
            this.payloads.toImmutableMap = SynchronizedMutableListTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedMutableListTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedMutableListTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedMutableListTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedMutableListTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedMutableListTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedMutableListTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = SynchronizedMutableListTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = SynchronizedMutableListTest::appendStringThrows;
            this.payloads.countBy = SynchronizedMutableListTest::countBy;
            this.payloads.countByWith = SynchronizedMutableListTest::countByWith;
            this.payloads.countByEach = SynchronizedMutableListTest::countByEach;
            this.payloads.groupBy = SynchronizedMutableListTest::groupBy;
            this.payloads.groupByEach = SynchronizedMutableListTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedMutableListTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedMutableListTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedMutableListTest::zip;
            this.payloads.zipWithIndex = SynchronizedMutableListTest::zipWithIndex;
            this.payloads.chunk_empty = SynchronizedMutableListTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedMutableListTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedMutableListTest::chunk_large_size;
            this.payloads.empty = SynchronizedMutableListTest::empty;
            this.payloads.notEmpty = SynchronizedMutableListTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedMutableListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedMutableListTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedMutableListTest::reduceOptional;
            this.payloads.testNewWith = SynchronizedMutableListTest::testNewWith;
            this.payloads.testNewWithWith = SynchronizedMutableListTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedMutableListTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedMutableListTest::testNewWithVarArgs;
            this.payloads.addAll = SynchronizedMutableListTest::addAll;
            this.payloads.addAllIterable = SynchronizedMutableListTest::addAllIterable;
            this.payloads.removeAll = SynchronizedMutableListTest::removeAll;
            this.payloads.removeAllIterable = SynchronizedMutableListTest::removeAllIterable;
            this.payloads.retainAll = SynchronizedMutableListTest::retainAll;
            this.payloads.retainAllIterable = SynchronizedMutableListTest::retainAllIterable;
            this.payloads.clear = SynchronizedMutableListTest::clear;
            this.payloads.injectIntoWith = SynchronizedMutableListTest::injectIntoWith;
            this.payloads.removeObject = SynchronizedMutableListTest::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedMutableListTest::selectAndRejectWith;
            this.payloads.removeIfWith = SynchronizedMutableListTest::removeIfWith;
            this.payloads.with = SynchronizedMutableListTest::with;
            this.payloads.withAll = SynchronizedMutableListTest::withAll;
            this.payloads.without = SynchronizedMutableListTest::without;
            this.payloads.withoutAll = SynchronizedMutableListTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedMutableListTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedMutableListTest::asLazy;
            this.payloads.randomAccess_throws = SynchronizedMutableListTest::randomAccess_throws;
            this.payloads.getFirstOptional = SynchronizedMutableListTest::getFirstOptional;
            this.payloads.getLastOptional = SynchronizedMutableListTest::getLastOptional;
            this.payloads.detectIndex = SynchronizedMutableListTest::detectIndex;
            this.payloads.detectLastIndex = SynchronizedMutableListTest::detectLastIndex;
            this.payloads.collectWithIndex = SynchronizedMutableListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedMutableListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = SynchronizedMutableListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = SynchronizedMutableListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = SynchronizedMutableListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = SynchronizedMutableListTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = SynchronizedMutableListTest::asSynchronized;
            this.payloads.toImmutable = SynchronizedMutableListTest::toImmutable;
            this.payloads.asUnmodifiable = SynchronizedMutableListTest::asUnmodifiable;
            this.payloads.testClone = SynchronizedMutableListTest::testClone;
            this.payloads.newListWithSize = SynchronizedMutableListTest::newListWithSize;
            this.payloads.serialization = SynchronizedMutableListTest::serialization;
            this.payloads.corresponds = SynchronizedMutableListTest::corresponds;
            this.payloads.forEachFromTo = SynchronizedMutableListTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = SynchronizedMutableListTest::forEachFromToInReverse;
            this.payloads.reverseForEach = SynchronizedMutableListTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = SynchronizedMutableListTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = SynchronizedMutableListTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = SynchronizedMutableListTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = SynchronizedMutableListTest::reverseThis;
            this.payloads.toReversed = SynchronizedMutableListTest::toReversed;
            this.payloads.distinct = SynchronizedMutableListTest::distinct;
            this.payloads.distinctWithHashingStrategy = SynchronizedMutableListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = SynchronizedMutableListTest::distinctBy;
            this.payloads.removeIf = SynchronizedMutableListTest::removeIf;
            this.payloads.removeIndex = SynchronizedMutableListTest::removeIndex;
            this.payloads.indexOf = SynchronizedMutableListTest::indexOf;
            this.payloads.lastIndexOf = SynchronizedMutableListTest::lastIndexOf;
            this.payloads.set = SynchronizedMutableListTest::set;
            this.payloads.addAtIndex = SynchronizedMutableListTest::addAtIndex;
            this.payloads.addAllAtIndex = SynchronizedMutableListTest::addAllAtIndex;
            this.payloads.withMethods = SynchronizedMutableListTest::withMethods;
            this.payloads.sortThis_with_null = SynchronizedMutableListTest::sortThis_with_null;
            this.payloads.sortThis_small = SynchronizedMutableListTest::sortThis_small;
            this.payloads.sortThis = SynchronizedMutableListTest::sortThis;
            this.payloads.sortThis_large = SynchronizedMutableListTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = SynchronizedMutableListTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = SynchronizedMutableListTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = SynchronizedMutableListTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = SynchronizedMutableListTest::sortThisBy;
            this.payloads.sortThisByBoolean = SynchronizedMutableListTest::sortThisByBoolean;
            this.payloads.sortThisByInt = SynchronizedMutableListTest::sortThisByInt;
            this.payloads.sortThisByChar = SynchronizedMutableListTest::sortThisByChar;
            this.payloads.sortThisByByte = SynchronizedMutableListTest::sortThisByByte;
            this.payloads.sortThisByShort = SynchronizedMutableListTest::sortThisByShort;
            this.payloads.sortThisByFloat = SynchronizedMutableListTest::sortThisByFloat;
            this.payloads.sortThisByLong = SynchronizedMutableListTest::sortThisByLong;
            this.payloads.sortThisByDouble = SynchronizedMutableListTest::sortThisByDouble;
            this.payloads.makeStringWithSeparator = SynchronizedMutableListTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedMutableListTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringWithSeparator = SynchronizedMutableListTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedMutableListTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = SynchronizedMutableListTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = SynchronizedMutableListTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = SynchronizedMutableListTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = SynchronizedMutableListTest::forEachWithIndexOnRange;
            this.payloads.subList = SynchronizedMutableListTest::subList;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = SynchronizedMutableListTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = SynchronizedMutableListTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = SynchronizedMutableListTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = SynchronizedMutableListTest::chunk;
            this.payloads.toStack = SynchronizedMutableListTest::toStack;
            this.payloads.take = SynchronizedMutableListTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = SynchronizedMutableListTest::takeWhile;
            this.payloads.drop = SynchronizedMutableListTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = SynchronizedMutableListTest::dropWhile;
            this.payloads.partitionWhile = SynchronizedMutableListTest::partitionWhile;
            this.payloads.asReversed = SynchronizedMutableListTest::asReversed;
            this.payloads.binarySearch = SynchronizedMutableListTest::binarySearch;
            this.payloads.binarySearchWithComparator = SynchronizedMutableListTest::binarySearchWithComparator;
            this.payloads.forEachWithIndex = SynchronizedMutableListTest::forEachWithIndex;
            this.payloads.forEachInBoth = SynchronizedMutableListTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableListTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = SynchronizedMutableListTest::replaceAll;
            this.payloads.sort = SynchronizedMutableListTest::sort;
            this.payloads.newEmpty = SynchronizedMutableListTest::newEmpty;
            this.payloads.equalsAndHashCode = SynchronizedMutableListTest::equalsAndHashCode;
            this.payloads.testToString = SynchronizedMutableListTest::testToString;
            this.payloads.makeString = SynchronizedMutableListTest::makeString;
            this.payloads.appendString = SynchronizedMutableListTest::appendString;
        }
    }
}
