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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit test for {@link ArrayListAdapter}.
 */
public class ArrayListAdapterTest extends AbstractListTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListAdapterTest.class);

    @Override
    protected <T> ArrayListAdapter<T> newWith(T... littleElements) {
        return ArrayListAdapter.<T>newList().with(littleElements);
    }

    @Override
    @Test
    public void testClone() {
        super.testClone();
        MutableList<Integer> list = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = list.clone();
        Verify.assertListsEqual(list, list2);
    }

    @Override
    @Test
    public void newListWithSize() {
        super.newListWithSize();
        MutableList<Integer> objects = ArrayListAdapter.<Integer>newList(4).with(1, 2, 3);
        Assert.assertEquals(1, objects.indexOf(2));
    }

    @Override
    @Test
    public void removeIf() {
        super.removeIf();
        MutableList<Integer> objects = this.newWith(1, 2, 3, null);
        objects.removeIf(Predicates.isNull());
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Test
    public void testBAOSSize() {
        MutableList<Integer> mutableArrayList = ArrayListAdapter.newList();
        ByteArrayOutputStream stream1 = SerializeTestHelper.getByteArrayOutputStream(mutableArrayList);
        LOGGER.info("ArrayListAdapter size: {}", stream1.size());
        LOGGER.info("{}", stream1);
        Assert.assertTrue(stream1.size() > 0);
        List<Integer> arrayList = new ArrayList<>();
        ByteArrayOutputStream stream2 = SerializeTestHelper.getByteArrayOutputStream(arrayList);
        LOGGER.info("ArrayList size: {}", stream2.size());
        LOGGER.info("{}", stream2);
        Assert.assertTrue(stream2.size() > 0);
    }

    @Test
    public void testWithMethods() {
        Verify.assertContainsAll(ArrayListAdapter.newList().with(1), 1);
        Verify.assertContainsAll(ArrayListAdapter.newList().with(1, 2), 1, 2);
        Verify.assertContainsAll(ArrayListAdapter.newList().with(1, 2, 3), 1, 2, 3);
        Verify.assertContainsAll(ArrayListAdapter.newList().with(1, 2, 3, 4), 1, 2, 3, 4);
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(ArrayListAdapter.class, ArrayListAdapter.newList().newEmpty());
    }

    @Test
    public void testForEachWithFromToWithCommandoPatternOptimization() {
        MutableList<Integer> result2 = Lists.mutable.of();
        // Requires list of 100+ elements to engage commando pattern optimization
        ArrayListAdapter.adapt(new ArrayList<>(Interval.oneTo(200))).forEach(99, 199, CollectionAddProcedure.on(result2));
        Verify.assertSize(101, result2);
    }

    @Test
    public void testForEachWithIndexWithFromToWithCommandoPatternOptimization() {
        MutableList<Integer> result2 = Lists.mutable.of();
        // Requires list of 100+ elements to engage commando pattern optimization
        ArrayListAdapter.adapt(new ArrayList<>(Interval.oneTo(200))).forEachWithIndex(99, 199, new AddToList(result2));
        Verify.assertSize(101, result2);
    }

    @Test
    @Override
    public void subList() {
        // Not serializable
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
        Assert.assertFalse(sublist.remove("X"));
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
    }

    @Test
    public void adapt_null() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListAdapter.adapt(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ArrayListAdapterTest instance;

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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testBAOSSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testBAOSSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testWithMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testWithMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithFromToWithCommandoPatternOptimization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithFromToWithCommandoPatternOptimization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithIndexWithFromToWithCommandoPatternOptimization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithIndexWithFromToWithCommandoPatternOptimization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt_null);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new ArrayListAdapterTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testBAOSSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testWithMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testForEachWithFromToWithCommandoPatternOptimization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> testForEachWithIndexWithFromToWithCommandoPatternOptimization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterTest> adapt_null;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ArrayListAdapterTest::testNewCollection;
            this.payloads.contains = ArrayListAdapterTest::contains;
            this.payloads.containsBy = ArrayListAdapterTest::containsBy;
            this.payloads.containsAllIterable = ArrayListAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = ArrayListAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ArrayListAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = ArrayListAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = ArrayListAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ArrayListAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = ArrayListAdapterTest::containsAllCollection;
            this.payloads.tap = ArrayListAdapterTest::tap;
            this.payloads.forEach = ArrayListAdapterTest::forEach;
            this.payloads.forEachWith = ArrayListAdapterTest::forEachWith;
            this.payloads.select = ArrayListAdapterTest::select;
            this.payloads.selectWith = ArrayListAdapterTest::selectWith;
            this.payloads.selectWith_target = ArrayListAdapterTest::selectWith_target;
            this.payloads.reject = ArrayListAdapterTest::reject;
            this.payloads.rejectWith = ArrayListAdapterTest::rejectWith;
            this.payloads.rejectWith_target = ArrayListAdapterTest::rejectWith_target;
            this.payloads.selectInstancesOf = ArrayListAdapterTest::selectInstancesOf;
            this.payloads.collect = ArrayListAdapterTest::collect;
            this.payloads.collectTarget = ArrayListAdapterTest::collectTarget;
            this.payloads.collectBoolean = ArrayListAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ArrayListAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = ArrayListAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = ArrayListAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = ArrayListAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = ArrayListAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = ArrayListAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = ArrayListAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = ArrayListAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = ArrayListAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ArrayListAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = ArrayListAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = ArrayListAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = ArrayListAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = ArrayListAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = ArrayListAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = ArrayListAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = ArrayListAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = ArrayListAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = ArrayListAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = ArrayListAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = ArrayListAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = ArrayListAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = ArrayListAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollect = ArrayListAdapterTest::flatCollect;
            this.payloads.flatCollectWith = ArrayListAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ArrayListAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ArrayListAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = ArrayListAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = ArrayListAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = ArrayListAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = ArrayListAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = ArrayListAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ArrayListAdapterTest::flatCollectFloat;
            this.payloads.detect = ArrayListAdapterTest::detect;
            this.payloads.detectOptional = ArrayListAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ArrayListAdapterTest::min;
            this.payloads.minOptional = ArrayListAdapterTest::minOptional;
            this.payloads.max = ArrayListAdapterTest::max;
            this.payloads.maxOptional = ArrayListAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ArrayListAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = ArrayListAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = ArrayListAdapterTest::min_null_safe;
            this.payloads.max_null_safe = ArrayListAdapterTest::max_null_safe;
            this.payloads.minBy = ArrayListAdapterTest::minBy;
            this.payloads.minByOptional = ArrayListAdapterTest::minByOptional;
            this.payloads.maxBy = ArrayListAdapterTest::maxBy;
            this.payloads.maxByOptional = ArrayListAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = ArrayListAdapterTest::detectWith;
            this.payloads.detectWithOptional = ArrayListAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = ArrayListAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ArrayListAdapterTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ArrayListAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = ArrayListAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = ArrayListAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ArrayListAdapterTest::noneSatisfyWith;
            this.payloads.anySatisfy = ArrayListAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = ArrayListAdapterTest::anySatisfyWith;
            this.payloads.count = ArrayListAdapterTest::count;
            this.payloads.countWith = ArrayListAdapterTest::countWith;
            this.payloads.collectIf = ArrayListAdapterTest::collectIf;
            this.payloads.collectWith = ArrayListAdapterTest::collectWith;
            this.payloads.collectWith_target = ArrayListAdapterTest::collectWith_target;
            this.payloads.getAny = ArrayListAdapterTest::getAny;
            this.payloads.getFirst = ArrayListAdapterTest::getFirst;
            this.payloads.getLast = ArrayListAdapterTest::getLast;
            this.payloads.getOnly = ArrayListAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ArrayListAdapterTest::isEmpty;
            this.payloads.iterator = ArrayListAdapterTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ArrayListAdapterTest::injectInto;
            this.payloads.injectIntoInt = ArrayListAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = ArrayListAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = ArrayListAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ArrayListAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = ArrayListAdapterTest::sumFloat;
            this.payloads.summarizeFloat = ArrayListAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ArrayListAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ArrayListAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ArrayListAdapterTest::sumDouble;
            this.payloads.summarizeDouble = ArrayListAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ArrayListAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ArrayListAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ArrayListAdapterTest::sumInteger;
            this.payloads.summarizeInt = ArrayListAdapterTest::summarizeInt;
            this.payloads.sumLong = ArrayListAdapterTest::sumLong;
            this.payloads.summarizeLong = ArrayListAdapterTest::summarizeLong;
            this.payloads.sumByInt = ArrayListAdapterTest::sumByInt;
            this.payloads.sumByFloat = ArrayListAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ArrayListAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ArrayListAdapterTest::sumByLong;
            this.payloads.sumByDouble = ArrayListAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ArrayListAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = ArrayListAdapterTest::toArray;
            this.payloads.partition = ArrayListAdapterTest::partition;
            this.payloads.partitionWith = ArrayListAdapterTest::partitionWith;
            this.payloads.toList = ArrayListAdapterTest::toList;
            this.payloads.toImmutableList = ArrayListAdapterTest::toImmutableList;
            this.payloads.toCollection = ArrayListAdapterTest::toCollection;
            this.payloads.toBag = ArrayListAdapterTest::toBag;
            this.payloads.toImmutableBag = ArrayListAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ArrayListAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ArrayListAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ArrayListAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ArrayListAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ArrayListAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ArrayListAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ArrayListAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ArrayListAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = ArrayListAdapterTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = ArrayListAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = ArrayListAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = ArrayListAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ArrayListAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ArrayListAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ArrayListAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ArrayListAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ArrayListAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ArrayListAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = ArrayListAdapterTest::toSet;
            this.payloads.toImmutableSet = ArrayListAdapterTest::toImmutableSet;
            this.payloads.toMap = ArrayListAdapterTest::toMap;
            this.payloads.toImmutableMap = ArrayListAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = ArrayListAdapterTest::toMapTarget;
            this.payloads.toSortedMap = ArrayListAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ArrayListAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ArrayListAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = ArrayListAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = ArrayListAdapterTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = ArrayListAdapterTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = ArrayListAdapterTest::appendStringThrows;
            this.payloads.countBy = ArrayListAdapterTest::countBy;
            this.payloads.countByWith = ArrayListAdapterTest::countByWith;
            this.payloads.countByEach = ArrayListAdapterTest::countByEach;
            this.payloads.groupBy = ArrayListAdapterTest::groupBy;
            this.payloads.groupByEach = ArrayListAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = ArrayListAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ArrayListAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = ArrayListAdapterTest::zip;
            this.payloads.zipWithIndex = ArrayListAdapterTest::zipWithIndex;
            this.payloads.chunk_empty = ArrayListAdapterTest::chunk_empty;
            this.payloads.chunk_single = ArrayListAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ArrayListAdapterTest::chunk_large_size;
            this.payloads.empty = ArrayListAdapterTest::empty;
            this.payloads.notEmpty = ArrayListAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = ArrayListAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ArrayListAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ArrayListAdapterTest::reduceOptional;
            this.payloads.testNewWith = ArrayListAdapterTest::testNewWith;
            this.payloads.testNewWithWith = ArrayListAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = ArrayListAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = ArrayListAdapterTest::testNewWithVarArgs;
            this.payloads.addAll = ArrayListAdapterTest::addAll;
            this.payloads.addAllIterable = ArrayListAdapterTest::addAllIterable;
            this.payloads.removeAll = ArrayListAdapterTest::removeAll;
            this.payloads.removeAllIterable = ArrayListAdapterTest::removeAllIterable;
            this.payloads.retainAll = ArrayListAdapterTest::retainAll;
            this.payloads.retainAllIterable = ArrayListAdapterTest::retainAllIterable;
            this.payloads.clear = ArrayListAdapterTest::clear;
            this.payloads.injectIntoWith = ArrayListAdapterTest::injectIntoWith;
            this.payloads.removeObject = ArrayListAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = ArrayListAdapterTest::selectAndRejectWith;
            this.payloads.removeIfWith = ArrayListAdapterTest::removeIfWith;
            this.payloads.with = ArrayListAdapterTest::with;
            this.payloads.withAll = ArrayListAdapterTest::withAll;
            this.payloads.without = ArrayListAdapterTest::without;
            this.payloads.withoutAll = ArrayListAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = ArrayListAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = ArrayListAdapterTest::asLazy;
            this.payloads.randomAccess_throws = ArrayListAdapterTest::randomAccess_throws;
            this.payloads.getFirstOptional = ArrayListAdapterTest::getFirstOptional;
            this.payloads.getLastOptional = ArrayListAdapterTest::getLastOptional;
            this.payloads.detectIndex = ArrayListAdapterTest::detectIndex;
            this.payloads.detectLastIndex = ArrayListAdapterTest::detectLastIndex;
            this.payloads.collectWithIndex = ArrayListAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ArrayListAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ArrayListAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ArrayListAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ArrayListAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ArrayListAdapterTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = ArrayListAdapterTest::asSynchronized;
            this.payloads.toImmutable = ArrayListAdapterTest::toImmutable;
            this.payloads.asUnmodifiable = ArrayListAdapterTest::asUnmodifiable;
            this.payloads.equalsAndHashCode = ArrayListAdapterTest::equalsAndHashCode;
            this.payloads.serialization = ArrayListAdapterTest::serialization;
            this.payloads.corresponds = ArrayListAdapterTest::corresponds;
            this.payloads.forEachFromTo = ArrayListAdapterTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = ArrayListAdapterTest::forEachFromToInReverse;
            this.payloads.reverseForEach = ArrayListAdapterTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = ArrayListAdapterTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = ArrayListAdapterTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = ArrayListAdapterTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = ArrayListAdapterTest::reverseThis;
            this.payloads.toReversed = ArrayListAdapterTest::toReversed;
            this.payloads.distinct = ArrayListAdapterTest::distinct;
            this.payloads.distinctWithHashingStrategy = ArrayListAdapterTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ArrayListAdapterTest::distinctBy;
            this.payloads.removeIndex = ArrayListAdapterTest::removeIndex;
            this.payloads.indexOf = ArrayListAdapterTest::indexOf;
            this.payloads.lastIndexOf = ArrayListAdapterTest::lastIndexOf;
            this.payloads.set = ArrayListAdapterTest::set;
            this.payloads.addAtIndex = ArrayListAdapterTest::addAtIndex;
            this.payloads.addAllAtIndex = ArrayListAdapterTest::addAllAtIndex;
            this.payloads.withMethods = ArrayListAdapterTest::withMethods;
            this.payloads.sortThis_with_null = ArrayListAdapterTest::sortThis_with_null;
            this.payloads.sortThis_small = ArrayListAdapterTest::sortThis_small;
            this.payloads.sortThis = ArrayListAdapterTest::sortThis;
            this.payloads.sortThis_large = ArrayListAdapterTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = ArrayListAdapterTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = ArrayListAdapterTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = ArrayListAdapterTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = ArrayListAdapterTest::sortThisBy;
            this.payloads.sortThisByBoolean = ArrayListAdapterTest::sortThisByBoolean;
            this.payloads.sortThisByInt = ArrayListAdapterTest::sortThisByInt;
            this.payloads.sortThisByChar = ArrayListAdapterTest::sortThisByChar;
            this.payloads.sortThisByByte = ArrayListAdapterTest::sortThisByByte;
            this.payloads.sortThisByShort = ArrayListAdapterTest::sortThisByShort;
            this.payloads.sortThisByFloat = ArrayListAdapterTest::sortThisByFloat;
            this.payloads.sortThisByLong = ArrayListAdapterTest::sortThisByLong;
            this.payloads.sortThisByDouble = ArrayListAdapterTest::sortThisByDouble;
            this.payloads.testToString = ArrayListAdapterTest::testToString;
            this.payloads.makeString = ArrayListAdapterTest::makeString;
            this.payloads.makeStringWithSeparator = ArrayListAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ArrayListAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ArrayListAdapterTest::appendString;
            this.payloads.appendStringWithSeparator = ArrayListAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ArrayListAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = ArrayListAdapterTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = ArrayListAdapterTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = ArrayListAdapterTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = ArrayListAdapterTest::forEachWithIndexOnRange;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = ArrayListAdapterTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = ArrayListAdapterTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = ArrayListAdapterTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = ArrayListAdapterTest::chunk;
            this.payloads.toStack = ArrayListAdapterTest::toStack;
            this.payloads.take = ArrayListAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ArrayListAdapterTest::takeWhile;
            this.payloads.drop = ArrayListAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = ArrayListAdapterTest::dropWhile;
            this.payloads.partitionWhile = ArrayListAdapterTest::partitionWhile;
            this.payloads.asReversed = ArrayListAdapterTest::asReversed;
            this.payloads.binarySearch = ArrayListAdapterTest::binarySearch;
            this.payloads.binarySearchWithComparator = ArrayListAdapterTest::binarySearchWithComparator;
            this.payloads.forEachWithIndex = ArrayListAdapterTest::forEachWithIndex;
            this.payloads.forEachInBoth = ArrayListAdapterTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = ArrayListAdapterTest::replaceAll;
            this.payloads.sort = ArrayListAdapterTest::sort;
            this.payloads.testClone = ArrayListAdapterTest::testClone;
            this.payloads.newListWithSize = ArrayListAdapterTest::newListWithSize;
            this.payloads.removeIf = ArrayListAdapterTest::removeIf;
            this.payloads.testBAOSSize = ArrayListAdapterTest::testBAOSSize;
            this.payloads.testWithMethods = ArrayListAdapterTest::testWithMethods;
            this.payloads.newEmpty = ArrayListAdapterTest::newEmpty;
            this.payloads.testForEachWithFromToWithCommandoPatternOptimization = ArrayListAdapterTest::testForEachWithFromToWithCommandoPatternOptimization;
            this.payloads.testForEachWithIndexWithFromToWithCommandoPatternOptimization = ArrayListAdapterTest::testForEachWithIndexWithFromToWithCommandoPatternOptimization;
            this.payloads.subList = ArrayListAdapterTest::subList;
            this.payloads.adapt_null = ArrayListAdapterTest::adapt_null;
        }
    }
}
