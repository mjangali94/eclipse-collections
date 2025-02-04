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

import java.io.Serializable;
import java.util.Arrays;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderFastListAsWriteUntouchableTest extends AbstractListTestCase {

    @Override
    protected <T> MutableList<T> newWith(T... littleElements) {
        return MultiReaderFastList.newListWith(littleElements).asWriteUntouchable();
    }

    @Override
    @Test
    public void serialization() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        Assert.assertFalse(collection instanceof Serializable);
    }

    @Override
    @Test
    public void asSynchronized() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.newWith(1, 2, 3).toString());
    }

    @Override
    public void subList() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
        sublist.add("X");
        Verify.assertSize(3, sublist);
        Verify.assertContainsAll(sublist, "B", "C", "X");
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, "A", "B", "C", "X", "D");
        sublist.remove("X");
        Verify.assertContainsAll(sublist, "B", "C");
        Verify.assertContainsAll(list, "A", "B", "C", "D");
        Assert.assertEquals("C", sublist.set(1, "R"));
        Verify.assertContainsAll(sublist, "B", "R");
        Verify.assertContainsAll(list, "A", "B", "R", "D");
        sublist.addAll(Arrays.asList("W", "G"));
        Verify.assertContainsAll(sublist, "B", "R", "W", "G");
        Verify.assertContainsAll(list, "A", "B", "R", "W", "G", "D");
        sublist.clear();
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
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

        private MultiReaderFastListAsWriteUntouchableTest instance;

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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderFastListAsWriteUntouchableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsWriteUntouchableTest> appendString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderFastListAsWriteUntouchableTest::testNewCollection;
            this.payloads.contains = MultiReaderFastListAsWriteUntouchableTest::contains;
            this.payloads.containsBy = MultiReaderFastListAsWriteUntouchableTest::containsBy;
            this.payloads.containsAllIterable = MultiReaderFastListAsWriteUntouchableTest::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderFastListAsWriteUntouchableTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderFastListAsWriteUntouchableTest::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderFastListAsWriteUntouchableTest::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderFastListAsWriteUntouchableTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderFastListAsWriteUntouchableTest::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderFastListAsWriteUntouchableTest::containsAllCollection;
            this.payloads.tap = MultiReaderFastListAsWriteUntouchableTest::tap;
            this.payloads.forEach = MultiReaderFastListAsWriteUntouchableTest::forEach;
            this.payloads.forEachWith = MultiReaderFastListAsWriteUntouchableTest::forEachWith;
            this.payloads.select = MultiReaderFastListAsWriteUntouchableTest::select;
            this.payloads.selectWith = MultiReaderFastListAsWriteUntouchableTest::selectWith;
            this.payloads.selectWith_target = MultiReaderFastListAsWriteUntouchableTest::selectWith_target;
            this.payloads.reject = MultiReaderFastListAsWriteUntouchableTest::reject;
            this.payloads.rejectWith = MultiReaderFastListAsWriteUntouchableTest::rejectWith;
            this.payloads.rejectWith_target = MultiReaderFastListAsWriteUntouchableTest::rejectWith_target;
            this.payloads.selectInstancesOf = MultiReaderFastListAsWriteUntouchableTest::selectInstancesOf;
            this.payloads.collect = MultiReaderFastListAsWriteUntouchableTest::collect;
            this.payloads.collectTarget = MultiReaderFastListAsWriteUntouchableTest::collectTarget;
            this.payloads.collectBoolean = MultiReaderFastListAsWriteUntouchableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderFastListAsWriteUntouchableTest::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderFastListAsWriteUntouchableTest::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderFastListAsWriteUntouchableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderFastListAsWriteUntouchableTest::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderFastListAsWriteUntouchableTest::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderFastListAsWriteUntouchableTest::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderFastListAsWriteUntouchableTest::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderFastListAsWriteUntouchableTest::collectShortWithBagTarget;
            this.payloads.flatCollect = MultiReaderFastListAsWriteUntouchableTest::flatCollect;
            this.payloads.flatCollectWith = MultiReaderFastListAsWriteUntouchableTest::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderFastListAsWriteUntouchableTest::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderFastListAsWriteUntouchableTest::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderFastListAsWriteUntouchableTest::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderFastListAsWriteUntouchableTest::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderFastListAsWriteUntouchableTest::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderFastListAsWriteUntouchableTest::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderFastListAsWriteUntouchableTest::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderFastListAsWriteUntouchableTest::flatCollectFloat;
            this.payloads.detect = MultiReaderFastListAsWriteUntouchableTest::detect;
            this.payloads.detectOptional = MultiReaderFastListAsWriteUntouchableTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderFastListAsWriteUntouchableTest::min;
            this.payloads.minOptional = MultiReaderFastListAsWriteUntouchableTest::minOptional;
            this.payloads.max = MultiReaderFastListAsWriteUntouchableTest::max;
            this.payloads.maxOptional = MultiReaderFastListAsWriteUntouchableTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderFastListAsWriteUntouchableTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderFastListAsWriteUntouchableTest::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderFastListAsWriteUntouchableTest::min_null_safe;
            this.payloads.max_null_safe = MultiReaderFastListAsWriteUntouchableTest::max_null_safe;
            this.payloads.minBy = MultiReaderFastListAsWriteUntouchableTest::minBy;
            this.payloads.minByOptional = MultiReaderFastListAsWriteUntouchableTest::minByOptional;
            this.payloads.maxBy = MultiReaderFastListAsWriteUntouchableTest::maxBy;
            this.payloads.maxByOptional = MultiReaderFastListAsWriteUntouchableTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MultiReaderFastListAsWriteUntouchableTest::detectWith;
            this.payloads.detectWithOptional = MultiReaderFastListAsWriteUntouchableTest::detectWithOptional;
            this.payloads.detectIfNone = MultiReaderFastListAsWriteUntouchableTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MultiReaderFastListAsWriteUntouchableTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MultiReaderFastListAsWriteUntouchableTest::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderFastListAsWriteUntouchableTest::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderFastListAsWriteUntouchableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderFastListAsWriteUntouchableTest::noneSatisfyWith;
            this.payloads.anySatisfy = MultiReaderFastListAsWriteUntouchableTest::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderFastListAsWriteUntouchableTest::anySatisfyWith;
            this.payloads.count = MultiReaderFastListAsWriteUntouchableTest::count;
            this.payloads.countWith = MultiReaderFastListAsWriteUntouchableTest::countWith;
            this.payloads.collectIf = MultiReaderFastListAsWriteUntouchableTest::collectIf;
            this.payloads.collectWith = MultiReaderFastListAsWriteUntouchableTest::collectWith;
            this.payloads.collectWith_target = MultiReaderFastListAsWriteUntouchableTest::collectWith_target;
            this.payloads.getAny = MultiReaderFastListAsWriteUntouchableTest::getAny;
            this.payloads.getFirst = MultiReaderFastListAsWriteUntouchableTest::getFirst;
            this.payloads.getLast = MultiReaderFastListAsWriteUntouchableTest::getLast;
            this.payloads.getOnly = MultiReaderFastListAsWriteUntouchableTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = MultiReaderFastListAsWriteUntouchableTest::isEmpty;
            this.payloads.iterator = MultiReaderFastListAsWriteUntouchableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = MultiReaderFastListAsWriteUntouchableTest::injectInto;
            this.payloads.injectIntoInt = MultiReaderFastListAsWriteUntouchableTest::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderFastListAsWriteUntouchableTest::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderFastListAsWriteUntouchableTest::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderFastListAsWriteUntouchableTest::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderFastListAsWriteUntouchableTest::sumFloat;
            this.payloads.summarizeFloat = MultiReaderFastListAsWriteUntouchableTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderFastListAsWriteUntouchableTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderFastListAsWriteUntouchableTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderFastListAsWriteUntouchableTest::sumDouble;
            this.payloads.summarizeDouble = MultiReaderFastListAsWriteUntouchableTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderFastListAsWriteUntouchableTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderFastListAsWriteUntouchableTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderFastListAsWriteUntouchableTest::sumInteger;
            this.payloads.summarizeInt = MultiReaderFastListAsWriteUntouchableTest::summarizeInt;
            this.payloads.sumLong = MultiReaderFastListAsWriteUntouchableTest::sumLong;
            this.payloads.summarizeLong = MultiReaderFastListAsWriteUntouchableTest::summarizeLong;
            this.payloads.sumByInt = MultiReaderFastListAsWriteUntouchableTest::sumByInt;
            this.payloads.sumByFloat = MultiReaderFastListAsWriteUntouchableTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderFastListAsWriteUntouchableTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderFastListAsWriteUntouchableTest::sumByLong;
            this.payloads.sumByDouble = MultiReaderFastListAsWriteUntouchableTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderFastListAsWriteUntouchableTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = MultiReaderFastListAsWriteUntouchableTest::toArray;
            this.payloads.partition = MultiReaderFastListAsWriteUntouchableTest::partition;
            this.payloads.partitionWith = MultiReaderFastListAsWriteUntouchableTest::partitionWith;
            this.payloads.toList = MultiReaderFastListAsWriteUntouchableTest::toList;
            this.payloads.toImmutableList = MultiReaderFastListAsWriteUntouchableTest::toImmutableList;
            this.payloads.toCollection = MultiReaderFastListAsWriteUntouchableTest::toCollection;
            this.payloads.toBag = MultiReaderFastListAsWriteUntouchableTest::toBag;
            this.payloads.toImmutableBag = MultiReaderFastListAsWriteUntouchableTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderFastListAsWriteUntouchableTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderFastListAsWriteUntouchableTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderFastListAsWriteUntouchableTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderFastListAsWriteUntouchableTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = MultiReaderFastListAsWriteUntouchableTest::toSet;
            this.payloads.toImmutableSet = MultiReaderFastListAsWriteUntouchableTest::toImmutableSet;
            this.payloads.toMap = MultiReaderFastListAsWriteUntouchableTest::toMap;
            this.payloads.toImmutableMap = MultiReaderFastListAsWriteUntouchableTest::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderFastListAsWriteUntouchableTest::toMapTarget;
            this.payloads.toSortedMap = MultiReaderFastListAsWriteUntouchableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderFastListAsWriteUntouchableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderFastListAsWriteUntouchableTest::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderFastListAsWriteUntouchableTest::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderFastListAsWriteUntouchableTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = MultiReaderFastListAsWriteUntouchableTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = MultiReaderFastListAsWriteUntouchableTest::appendStringThrows;
            this.payloads.countBy = MultiReaderFastListAsWriteUntouchableTest::countBy;
            this.payloads.countByWith = MultiReaderFastListAsWriteUntouchableTest::countByWith;
            this.payloads.countByEach = MultiReaderFastListAsWriteUntouchableTest::countByEach;
            this.payloads.groupBy = MultiReaderFastListAsWriteUntouchableTest::groupBy;
            this.payloads.groupByEach = MultiReaderFastListAsWriteUntouchableTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderFastListAsWriteUntouchableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderFastListAsWriteUntouchableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderFastListAsWriteUntouchableTest::zip;
            this.payloads.zipWithIndex = MultiReaderFastListAsWriteUntouchableTest::zipWithIndex;
            this.payloads.chunk_empty = MultiReaderFastListAsWriteUntouchableTest::chunk_empty;
            this.payloads.chunk_single = MultiReaderFastListAsWriteUntouchableTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderFastListAsWriteUntouchableTest::chunk_large_size;
            this.payloads.empty = MultiReaderFastListAsWriteUntouchableTest::empty;
            this.payloads.notEmpty = MultiReaderFastListAsWriteUntouchableTest::notEmpty;
            this.payloads.aggregateByMutating = MultiReaderFastListAsWriteUntouchableTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderFastListAsWriteUntouchableTest::aggregateByNonMutating;
            this.payloads.reduceOptional = MultiReaderFastListAsWriteUntouchableTest::reduceOptional;
            this.payloads.testNewWith = MultiReaderFastListAsWriteUntouchableTest::testNewWith;
            this.payloads.testNewWithWith = MultiReaderFastListAsWriteUntouchableTest::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderFastListAsWriteUntouchableTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderFastListAsWriteUntouchableTest::testNewWithVarArgs;
            this.payloads.addAll = MultiReaderFastListAsWriteUntouchableTest::addAll;
            this.payloads.addAllIterable = MultiReaderFastListAsWriteUntouchableTest::addAllIterable;
            this.payloads.removeAll = MultiReaderFastListAsWriteUntouchableTest::removeAll;
            this.payloads.removeAllIterable = MultiReaderFastListAsWriteUntouchableTest::removeAllIterable;
            this.payloads.retainAll = MultiReaderFastListAsWriteUntouchableTest::retainAll;
            this.payloads.retainAllIterable = MultiReaderFastListAsWriteUntouchableTest::retainAllIterable;
            this.payloads.clear = MultiReaderFastListAsWriteUntouchableTest::clear;
            this.payloads.injectIntoWith = MultiReaderFastListAsWriteUntouchableTest::injectIntoWith;
            this.payloads.removeObject = MultiReaderFastListAsWriteUntouchableTest::removeObject;
            this.payloads.selectAndRejectWith = MultiReaderFastListAsWriteUntouchableTest::selectAndRejectWith;
            this.payloads.removeIfWith = MultiReaderFastListAsWriteUntouchableTest::removeIfWith;
            this.payloads.with = MultiReaderFastListAsWriteUntouchableTest::with;
            this.payloads.withAll = MultiReaderFastListAsWriteUntouchableTest::withAll;
            this.payloads.without = MultiReaderFastListAsWriteUntouchableTest::without;
            this.payloads.withoutAll = MultiReaderFastListAsWriteUntouchableTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = MultiReaderFastListAsWriteUntouchableTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = MultiReaderFastListAsWriteUntouchableTest::asLazy;
            this.payloads.randomAccess_throws = MultiReaderFastListAsWriteUntouchableTest::randomAccess_throws;
            this.payloads.getFirstOptional = MultiReaderFastListAsWriteUntouchableTest::getFirstOptional;
            this.payloads.getLastOptional = MultiReaderFastListAsWriteUntouchableTest::getLastOptional;
            this.payloads.detectIndex = MultiReaderFastListAsWriteUntouchableTest::detectIndex;
            this.payloads.detectLastIndex = MultiReaderFastListAsWriteUntouchableTest::detectLastIndex;
            this.payloads.collectWithIndex = MultiReaderFastListAsWriteUntouchableTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = MultiReaderFastListAsWriteUntouchableTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = MultiReaderFastListAsWriteUntouchableTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = MultiReaderFastListAsWriteUntouchableTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = MultiReaderFastListAsWriteUntouchableTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = MultiReaderFastListAsWriteUntouchableTest::rejectWithIndexWithTarget;
            this.payloads.toImmutable = MultiReaderFastListAsWriteUntouchableTest::toImmutable;
            this.payloads.testClone = MultiReaderFastListAsWriteUntouchableTest::testClone;
            this.payloads.equalsAndHashCode = MultiReaderFastListAsWriteUntouchableTest::equalsAndHashCode;
            this.payloads.newListWithSize = MultiReaderFastListAsWriteUntouchableTest::newListWithSize;
            this.payloads.corresponds = MultiReaderFastListAsWriteUntouchableTest::corresponds;
            this.payloads.forEachFromTo = MultiReaderFastListAsWriteUntouchableTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = MultiReaderFastListAsWriteUntouchableTest::forEachFromToInReverse;
            this.payloads.reverseForEach = MultiReaderFastListAsWriteUntouchableTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = MultiReaderFastListAsWriteUntouchableTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = MultiReaderFastListAsWriteUntouchableTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = MultiReaderFastListAsWriteUntouchableTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = MultiReaderFastListAsWriteUntouchableTest::reverseThis;
            this.payloads.toReversed = MultiReaderFastListAsWriteUntouchableTest::toReversed;
            this.payloads.distinct = MultiReaderFastListAsWriteUntouchableTest::distinct;
            this.payloads.distinctWithHashingStrategy = MultiReaderFastListAsWriteUntouchableTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = MultiReaderFastListAsWriteUntouchableTest::distinctBy;
            this.payloads.removeIf = MultiReaderFastListAsWriteUntouchableTest::removeIf;
            this.payloads.removeIndex = MultiReaderFastListAsWriteUntouchableTest::removeIndex;
            this.payloads.indexOf = MultiReaderFastListAsWriteUntouchableTest::indexOf;
            this.payloads.lastIndexOf = MultiReaderFastListAsWriteUntouchableTest::lastIndexOf;
            this.payloads.set = MultiReaderFastListAsWriteUntouchableTest::set;
            this.payloads.addAtIndex = MultiReaderFastListAsWriteUntouchableTest::addAtIndex;
            this.payloads.addAllAtIndex = MultiReaderFastListAsWriteUntouchableTest::addAllAtIndex;
            this.payloads.withMethods = MultiReaderFastListAsWriteUntouchableTest::withMethods;
            this.payloads.sortThis_with_null = MultiReaderFastListAsWriteUntouchableTest::sortThis_with_null;
            this.payloads.sortThis_small = MultiReaderFastListAsWriteUntouchableTest::sortThis_small;
            this.payloads.sortThis = MultiReaderFastListAsWriteUntouchableTest::sortThis;
            this.payloads.sortThis_large = MultiReaderFastListAsWriteUntouchableTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = MultiReaderFastListAsWriteUntouchableTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = MultiReaderFastListAsWriteUntouchableTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = MultiReaderFastListAsWriteUntouchableTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = MultiReaderFastListAsWriteUntouchableTest::sortThisBy;
            this.payloads.sortThisByBoolean = MultiReaderFastListAsWriteUntouchableTest::sortThisByBoolean;
            this.payloads.sortThisByInt = MultiReaderFastListAsWriteUntouchableTest::sortThisByInt;
            this.payloads.sortThisByChar = MultiReaderFastListAsWriteUntouchableTest::sortThisByChar;
            this.payloads.sortThisByByte = MultiReaderFastListAsWriteUntouchableTest::sortThisByByte;
            this.payloads.sortThisByShort = MultiReaderFastListAsWriteUntouchableTest::sortThisByShort;
            this.payloads.sortThisByFloat = MultiReaderFastListAsWriteUntouchableTest::sortThisByFloat;
            this.payloads.sortThisByLong = MultiReaderFastListAsWriteUntouchableTest::sortThisByLong;
            this.payloads.sortThisByDouble = MultiReaderFastListAsWriteUntouchableTest::sortThisByDouble;
            this.payloads.newEmpty = MultiReaderFastListAsWriteUntouchableTest::newEmpty;
            this.payloads.makeStringWithSeparator = MultiReaderFastListAsWriteUntouchableTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderFastListAsWriteUntouchableTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringWithSeparator = MultiReaderFastListAsWriteUntouchableTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderFastListAsWriteUntouchableTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = MultiReaderFastListAsWriteUntouchableTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = MultiReaderFastListAsWriteUntouchableTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = MultiReaderFastListAsWriteUntouchableTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = MultiReaderFastListAsWriteUntouchableTest::forEachWithIndexOnRange;
            this.payloads.subList = MultiReaderFastListAsWriteUntouchableTest::subList;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = MultiReaderFastListAsWriteUntouchableTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = MultiReaderFastListAsWriteUntouchableTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = MultiReaderFastListAsWriteUntouchableTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = MultiReaderFastListAsWriteUntouchableTest::chunk;
            this.payloads.toStack = MultiReaderFastListAsWriteUntouchableTest::toStack;
            this.payloads.take = MultiReaderFastListAsWriteUntouchableTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = MultiReaderFastListAsWriteUntouchableTest::takeWhile;
            this.payloads.drop = MultiReaderFastListAsWriteUntouchableTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = MultiReaderFastListAsWriteUntouchableTest::dropWhile;
            this.payloads.partitionWhile = MultiReaderFastListAsWriteUntouchableTest::partitionWhile;
            this.payloads.asReversed = MultiReaderFastListAsWriteUntouchableTest::asReversed;
            this.payloads.binarySearch = MultiReaderFastListAsWriteUntouchableTest::binarySearch;
            this.payloads.binarySearchWithComparator = MultiReaderFastListAsWriteUntouchableTest::binarySearchWithComparator;
            this.payloads.forEachWithIndex = MultiReaderFastListAsWriteUntouchableTest::forEachWithIndex;
            this.payloads.forEachInBoth = MultiReaderFastListAsWriteUntouchableTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsWriteUntouchableTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = MultiReaderFastListAsWriteUntouchableTest::replaceAll;
            this.payloads.sort = MultiReaderFastListAsWriteUntouchableTest::sort;
            this.payloads.serialization = MultiReaderFastListAsWriteUntouchableTest::serialization;
            this.payloads.asSynchronized = MultiReaderFastListAsWriteUntouchableTest::asSynchronized;
            this.payloads.asUnmodifiable = MultiReaderFastListAsWriteUntouchableTest::asUnmodifiable;
            this.payloads.testToString = MultiReaderFastListAsWriteUntouchableTest::testToString;
            this.payloads.makeString = MultiReaderFastListAsWriteUntouchableTest::makeString;
            this.payloads.appendString = MultiReaderFastListAsWriteUntouchableTest::appendString;
        }
    }
}
