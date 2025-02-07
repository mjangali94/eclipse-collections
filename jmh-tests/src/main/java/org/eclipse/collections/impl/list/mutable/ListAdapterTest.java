/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.Arrays;
import java.util.LinkedList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ListAdapter}.
 */
public class ListAdapterTest extends AbstractListTestCase {

    @Override
    protected <T> ListAdapter<T> newWith(T... littleElements) {
        return new ListAdapter<>(new LinkedList<>(FastList.newListWith(littleElements)));
    }

    @Test(expected = NullPointerException.class)
    public void null_throws() {
        new ListAdapter<>(null);
    }

    @Override
    @Test
    public void testClone() {
        MutableList<Integer> list = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = list.clone();
        Verify.assertListsEqual(list, list2);
    }

    @Test
    public void adapt() {
        Assert.assertEquals(ListAdapter.adapt(Arrays.asList(1, 2, 3)), Lists.adapt(Arrays.asList(1, 2, 3)));
    }

    @Test
    @Override
    public void subList() {
        // Not serializable
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertEqualsAndHashCode(sublist, sublist);
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
    public void withMethods() {
        super.withMethods();
        Verify.assertContainsAll(this.newWith(1).with(2, 3), 1, 2, 3);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4), 1, 2, 3, 4);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4, 5), 1, 2, 3, 4, 5);
    }

    @Override
    @Test
    public void getWithArrayIndexOutOfBoundsException() {
        Object item = new Object();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.newWith(item).get(-1));
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new ListAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> ListAdapter.adapt(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ListAdapterTest instance;

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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithArrayIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptNull);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new ListAdapterTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterTest> adaptNull;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ListAdapterTest::testNewCollection;
            this.payloads.contains = ListAdapterTest::contains;
            this.payloads.containsBy = ListAdapterTest::containsBy;
            this.payloads.containsAllIterable = ListAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = ListAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ListAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = ListAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = ListAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ListAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = ListAdapterTest::containsAllCollection;
            this.payloads.tap = ListAdapterTest::tap;
            this.payloads.forEach = ListAdapterTest::forEach;
            this.payloads.forEachWith = ListAdapterTest::forEachWith;
            this.payloads.select = ListAdapterTest::select;
            this.payloads.selectWith = ListAdapterTest::selectWith;
            this.payloads.selectWith_target = ListAdapterTest::selectWith_target;
            this.payloads.reject = ListAdapterTest::reject;
            this.payloads.rejectWith = ListAdapterTest::rejectWith;
            this.payloads.rejectWith_target = ListAdapterTest::rejectWith_target;
            this.payloads.selectInstancesOf = ListAdapterTest::selectInstancesOf;
            this.payloads.collect = ListAdapterTest::collect;
            this.payloads.collectTarget = ListAdapterTest::collectTarget;
            this.payloads.collectBoolean = ListAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ListAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = ListAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = ListAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = ListAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = ListAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = ListAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = ListAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = ListAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = ListAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ListAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = ListAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = ListAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = ListAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = ListAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = ListAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = ListAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = ListAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = ListAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = ListAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = ListAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = ListAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = ListAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = ListAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollect = ListAdapterTest::flatCollect;
            this.payloads.flatCollectWith = ListAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ListAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ListAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = ListAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = ListAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = ListAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = ListAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = ListAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ListAdapterTest::flatCollectFloat;
            this.payloads.detect = ListAdapterTest::detect;
            this.payloads.detectOptional = ListAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ListAdapterTest::min;
            this.payloads.minOptional = ListAdapterTest::minOptional;
            this.payloads.max = ListAdapterTest::max;
            this.payloads.maxOptional = ListAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ListAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = ListAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = ListAdapterTest::min_null_safe;
            this.payloads.max_null_safe = ListAdapterTest::max_null_safe;
            this.payloads.minBy = ListAdapterTest::minBy;
            this.payloads.minByOptional = ListAdapterTest::minByOptional;
            this.payloads.maxBy = ListAdapterTest::maxBy;
            this.payloads.maxByOptional = ListAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = ListAdapterTest::detectWith;
            this.payloads.detectWithOptional = ListAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = ListAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ListAdapterTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ListAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = ListAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = ListAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ListAdapterTest::noneSatisfyWith;
            this.payloads.anySatisfy = ListAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = ListAdapterTest::anySatisfyWith;
            this.payloads.count = ListAdapterTest::count;
            this.payloads.countWith = ListAdapterTest::countWith;
            this.payloads.collectIf = ListAdapterTest::collectIf;
            this.payloads.collectWith = ListAdapterTest::collectWith;
            this.payloads.collectWith_target = ListAdapterTest::collectWith_target;
            this.payloads.getAny = ListAdapterTest::getAny;
            this.payloads.getFirst = ListAdapterTest::getFirst;
            this.payloads.getLast = ListAdapterTest::getLast;
            this.payloads.getOnly = ListAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ListAdapterTest::isEmpty;
            this.payloads.iterator = ListAdapterTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ListAdapterTest::injectInto;
            this.payloads.injectIntoInt = ListAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = ListAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = ListAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ListAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = ListAdapterTest::sumFloat;
            this.payloads.summarizeFloat = ListAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ListAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ListAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ListAdapterTest::sumDouble;
            this.payloads.summarizeDouble = ListAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ListAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ListAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ListAdapterTest::sumInteger;
            this.payloads.summarizeInt = ListAdapterTest::summarizeInt;
            this.payloads.sumLong = ListAdapterTest::sumLong;
            this.payloads.summarizeLong = ListAdapterTest::summarizeLong;
            this.payloads.sumByInt = ListAdapterTest::sumByInt;
            this.payloads.sumByFloat = ListAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ListAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ListAdapterTest::sumByLong;
            this.payloads.sumByDouble = ListAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ListAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = ListAdapterTest::toArray;
            this.payloads.partition = ListAdapterTest::partition;
            this.payloads.partitionWith = ListAdapterTest::partitionWith;
            this.payloads.toList = ListAdapterTest::toList;
            this.payloads.toImmutableList = ListAdapterTest::toImmutableList;
            this.payloads.toCollection = ListAdapterTest::toCollection;
            this.payloads.toBag = ListAdapterTest::toBag;
            this.payloads.toImmutableBag = ListAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ListAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ListAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ListAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ListAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ListAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ListAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ListAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ListAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = ListAdapterTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = ListAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = ListAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = ListAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ListAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ListAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ListAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ListAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ListAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ListAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = ListAdapterTest::toSet;
            this.payloads.toImmutableSet = ListAdapterTest::toImmutableSet;
            this.payloads.toMap = ListAdapterTest::toMap;
            this.payloads.toImmutableMap = ListAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = ListAdapterTest::toMapTarget;
            this.payloads.toSortedMap = ListAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ListAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ListAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = ListAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = ListAdapterTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = ListAdapterTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = ListAdapterTest::appendStringThrows;
            this.payloads.countBy = ListAdapterTest::countBy;
            this.payloads.countByWith = ListAdapterTest::countByWith;
            this.payloads.countByEach = ListAdapterTest::countByEach;
            this.payloads.groupBy = ListAdapterTest::groupBy;
            this.payloads.groupByEach = ListAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = ListAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ListAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = ListAdapterTest::zip;
            this.payloads.zipWithIndex = ListAdapterTest::zipWithIndex;
            this.payloads.chunk_empty = ListAdapterTest::chunk_empty;
            this.payloads.chunk_single = ListAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ListAdapterTest::chunk_large_size;
            this.payloads.empty = ListAdapterTest::empty;
            this.payloads.notEmpty = ListAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = ListAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ListAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ListAdapterTest::reduceOptional;
            this.payloads.testNewWith = ListAdapterTest::testNewWith;
            this.payloads.testNewWithWith = ListAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = ListAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = ListAdapterTest::testNewWithVarArgs;
            this.payloads.addAll = ListAdapterTest::addAll;
            this.payloads.addAllIterable = ListAdapterTest::addAllIterable;
            this.payloads.removeAll = ListAdapterTest::removeAll;
            this.payloads.removeAllIterable = ListAdapterTest::removeAllIterable;
            this.payloads.retainAll = ListAdapterTest::retainAll;
            this.payloads.retainAllIterable = ListAdapterTest::retainAllIterable;
            this.payloads.clear = ListAdapterTest::clear;
            this.payloads.injectIntoWith = ListAdapterTest::injectIntoWith;
            this.payloads.removeObject = ListAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = ListAdapterTest::selectAndRejectWith;
            this.payloads.removeIfWith = ListAdapterTest::removeIfWith;
            this.payloads.with = ListAdapterTest::with;
            this.payloads.withAll = ListAdapterTest::withAll;
            this.payloads.without = ListAdapterTest::without;
            this.payloads.withoutAll = ListAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = ListAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = ListAdapterTest::asLazy;
            this.payloads.randomAccess_throws = ListAdapterTest::randomAccess_throws;
            this.payloads.getFirstOptional = ListAdapterTest::getFirstOptional;
            this.payloads.getLastOptional = ListAdapterTest::getLastOptional;
            this.payloads.detectIndex = ListAdapterTest::detectIndex;
            this.payloads.detectLastIndex = ListAdapterTest::detectLastIndex;
            this.payloads.collectWithIndex = ListAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ListAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ListAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ListAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ListAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ListAdapterTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = ListAdapterTest::asSynchronized;
            this.payloads.toImmutable = ListAdapterTest::toImmutable;
            this.payloads.asUnmodifiable = ListAdapterTest::asUnmodifiable;
            this.payloads.equalsAndHashCode = ListAdapterTest::equalsAndHashCode;
            this.payloads.newListWithSize = ListAdapterTest::newListWithSize;
            this.payloads.serialization = ListAdapterTest::serialization;
            this.payloads.corresponds = ListAdapterTest::corresponds;
            this.payloads.forEachFromTo = ListAdapterTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = ListAdapterTest::forEachFromToInReverse;
            this.payloads.reverseForEach = ListAdapterTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = ListAdapterTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = ListAdapterTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = ListAdapterTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = ListAdapterTest::reverseThis;
            this.payloads.toReversed = ListAdapterTest::toReversed;
            this.payloads.distinct = ListAdapterTest::distinct;
            this.payloads.distinctWithHashingStrategy = ListAdapterTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ListAdapterTest::distinctBy;
            this.payloads.removeIf = ListAdapterTest::removeIf;
            this.payloads.removeIndex = ListAdapterTest::removeIndex;
            this.payloads.indexOf = ListAdapterTest::indexOf;
            this.payloads.lastIndexOf = ListAdapterTest::lastIndexOf;
            this.payloads.set = ListAdapterTest::set;
            this.payloads.addAtIndex = ListAdapterTest::addAtIndex;
            this.payloads.addAllAtIndex = ListAdapterTest::addAllAtIndex;
            this.payloads.sortThis_with_null = ListAdapterTest::sortThis_with_null;
            this.payloads.sortThis_small = ListAdapterTest::sortThis_small;
            this.payloads.sortThis = ListAdapterTest::sortThis;
            this.payloads.sortThis_large = ListAdapterTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = ListAdapterTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = ListAdapterTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = ListAdapterTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = ListAdapterTest::sortThisBy;
            this.payloads.sortThisByBoolean = ListAdapterTest::sortThisByBoolean;
            this.payloads.sortThisByInt = ListAdapterTest::sortThisByInt;
            this.payloads.sortThisByChar = ListAdapterTest::sortThisByChar;
            this.payloads.sortThisByByte = ListAdapterTest::sortThisByByte;
            this.payloads.sortThisByShort = ListAdapterTest::sortThisByShort;
            this.payloads.sortThisByFloat = ListAdapterTest::sortThisByFloat;
            this.payloads.sortThisByLong = ListAdapterTest::sortThisByLong;
            this.payloads.sortThisByDouble = ListAdapterTest::sortThisByDouble;
            this.payloads.newEmpty = ListAdapterTest::newEmpty;
            this.payloads.testToString = ListAdapterTest::testToString;
            this.payloads.makeString = ListAdapterTest::makeString;
            this.payloads.makeStringWithSeparator = ListAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ListAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ListAdapterTest::appendString;
            this.payloads.appendStringWithSeparator = ListAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ListAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = ListAdapterTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = ListAdapterTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = ListAdapterTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = ListAdapterTest::forEachWithIndexOnRange;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = ListAdapterTest::getWithIndexOutOfBoundsException;
            this.payloads.listIterator = ListAdapterTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = ListAdapterTest::chunk;
            this.payloads.toStack = ListAdapterTest::toStack;
            this.payloads.take = ListAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ListAdapterTest::takeWhile;
            this.payloads.drop = ListAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = ListAdapterTest::dropWhile;
            this.payloads.partitionWhile = ListAdapterTest::partitionWhile;
            this.payloads.asReversed = ListAdapterTest::asReversed;
            this.payloads.binarySearch = ListAdapterTest::binarySearch;
            this.payloads.binarySearchWithComparator = ListAdapterTest::binarySearchWithComparator;
            this.payloads.forEachWithIndex = ListAdapterTest::forEachWithIndex;
            this.payloads.forEachInBoth = ListAdapterTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = ListAdapterTest::replaceAll;
            this.payloads.sort = ListAdapterTest::sort;
            this.payloads.null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterTest::null_throws, java.lang.NullPointerException.class);
            this.payloads.testClone = ListAdapterTest::testClone;
            this.payloads.adapt = ListAdapterTest::adapt;
            this.payloads.subList = ListAdapterTest::subList;
            this.payloads.withMethods = ListAdapterTest::withMethods;
            this.payloads.getWithArrayIndexOutOfBoundsException = ListAdapterTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.adaptNull = ListAdapterTest::adaptNull;
        }
    }
}
