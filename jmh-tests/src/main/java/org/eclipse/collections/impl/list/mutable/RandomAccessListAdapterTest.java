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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link RandomAccessListAdapter}.
 */
public class RandomAccessListAdapterTest extends AbstractListTestCase {

    @Override
    protected <T> RandomAccessListAdapter<T> newWith(T... littleElements) {
        return new RandomAccessListAdapter<>(Collections.synchronizedList(new ArrayList<>(FastList.newListWith(littleElements))));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Verify.assertInstanceOf(SynchronizedMutableList.class, RandomAccessListAdapter.adapt(Collections.singletonList("1")).asSynchronized());
    }

    @Override
    @Test
    public void testClone() {
        MutableList<Integer> list = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = list.clone();
        Verify.assertListsEqual(list, list2);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableList<Integer> list1 = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = this.newWith(1, 2, 3);
        MutableList<Integer> list3 = this.newWith(2, 3, 4);
        Assert.assertNotEquals(list1, null);
        Verify.assertEqualsAndHashCode(list1, list1);
        Verify.assertEqualsAndHashCode(list1, list2);
        Assert.assertNotEquals(list2, list3);
    }

    @Test
    @Override
    public void subList() {
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
    public void newListWithSize() {
        super.newListWithSize();
        MutableList<Integer> collection = this.newWith(1, 2, 3);
        Verify.assertContainsAll(collection, 1, 2, 3);
        Assert.assertThrows(IllegalArgumentException.class, () -> new RandomAccessListAdapter<>(new LinkedList<>()));
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertContainsAll(deserializedCollection, 1, 2, 3, 4, 5);
        Assert.assertEquals(collection, deserializedCollection);
    }

    @Override
    @Test
    public void forEachFromTo() {
        super.forEachFromTo();
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEach(2, 3, result::add);
        Verify.assertSize(2, result);
        Verify.assertContainsAll(result, 3, 4);
    }

    @Override
    @Test
    public void removeIf() {
        super.removeIf();
        MutableList<Integer> objects = this.newWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIf(Predicates.isNull()));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Override
    @Test
    public void removeIfWith() {
        super.removeIf();
        MutableList<Integer> objects = this.newWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIfWith(Predicates2.isNull(), null));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Test
    public void testRemoveIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.remove(2);
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
    }

    @Override
    @Test
    public void indexOf() {
        super.indexOf();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertEquals(1, objects.indexOf(2));
    }

    @Override
    @Test
    public void lastIndexOf() {
        super.lastIndexOf();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertEquals(1, objects.lastIndexOf(2));
    }

    @Test
    public void testSet() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(2), objects.set(1, 4));
        Verify.assertItemAtIndex(4, 1, objects);
    }

    @Test
    public void testAddAtIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.add(0, 0);
        Verify.assertSize(4, objects);
        Verify.assertItemAtIndex(0, 0, objects);
    }

    @Test
    public void testAddAllAtIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.addAll(0, Lists.fixedSize.of(0));
        Verify.assertSize(4, objects);
        Verify.assertItemAtIndex(0, 0, objects);
    }

    @Test
    public void testWithMethods() {
        Verify.assertContainsAll(this.newWith(1), 1);
        Verify.assertContainsAll(this.newWith(1).with(2), 1, 2);
        Verify.assertContainsAll(this.newWith(1).with(2, 3), 1, 2, 3);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4), 1, 2, 3, 4);
        Verify.assertContainsAll(this.newWith(1).with(2, 3, 4, 5), 1, 2, 3, 4, 5);
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(MutableList.class, this.newWith().newEmpty());
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new RandomAccessListAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> RandomAccessListAdapter.adapt(null));
    }

    @Test
    public void adapt() {
        Verify.assertInstanceOf(ArrayListAdapter.class, RandomAccessListAdapter.adapt(new ArrayList<>()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private RandomAccessListAdapterTest instance;

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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemoveIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemoveIndex);
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
        public void benchmark_testSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAllAtIndex);
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
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new RandomAccessListAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testRemoveIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testAddAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> testWithMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> adaptNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterTest> adapt;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = RandomAccessListAdapterTest::testNewCollection;
            this.payloads.contains = RandomAccessListAdapterTest::contains;
            this.payloads.containsBy = RandomAccessListAdapterTest::containsBy;
            this.payloads.containsAllIterable = RandomAccessListAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = RandomAccessListAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = RandomAccessListAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = RandomAccessListAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = RandomAccessListAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = RandomAccessListAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = RandomAccessListAdapterTest::containsAllCollection;
            this.payloads.tap = RandomAccessListAdapterTest::tap;
            this.payloads.forEach = RandomAccessListAdapterTest::forEach;
            this.payloads.forEachWith = RandomAccessListAdapterTest::forEachWith;
            this.payloads.select = RandomAccessListAdapterTest::select;
            this.payloads.selectWith = RandomAccessListAdapterTest::selectWith;
            this.payloads.selectWith_target = RandomAccessListAdapterTest::selectWith_target;
            this.payloads.reject = RandomAccessListAdapterTest::reject;
            this.payloads.rejectWith = RandomAccessListAdapterTest::rejectWith;
            this.payloads.rejectWith_target = RandomAccessListAdapterTest::rejectWith_target;
            this.payloads.selectInstancesOf = RandomAccessListAdapterTest::selectInstancesOf;
            this.payloads.collect = RandomAccessListAdapterTest::collect;
            this.payloads.collectTarget = RandomAccessListAdapterTest::collectTarget;
            this.payloads.collectBoolean = RandomAccessListAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = RandomAccessListAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = RandomAccessListAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = RandomAccessListAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = RandomAccessListAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = RandomAccessListAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = RandomAccessListAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = RandomAccessListAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = RandomAccessListAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = RandomAccessListAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = RandomAccessListAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = RandomAccessListAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = RandomAccessListAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = RandomAccessListAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = RandomAccessListAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = RandomAccessListAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = RandomAccessListAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = RandomAccessListAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = RandomAccessListAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = RandomAccessListAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = RandomAccessListAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = RandomAccessListAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = RandomAccessListAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = RandomAccessListAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollect = RandomAccessListAdapterTest::flatCollect;
            this.payloads.flatCollectWith = RandomAccessListAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = RandomAccessListAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = RandomAccessListAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = RandomAccessListAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = RandomAccessListAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = RandomAccessListAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = RandomAccessListAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = RandomAccessListAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = RandomAccessListAdapterTest::flatCollectFloat;
            this.payloads.detect = RandomAccessListAdapterTest::detect;
            this.payloads.detectOptional = RandomAccessListAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = RandomAccessListAdapterTest::min;
            this.payloads.minOptional = RandomAccessListAdapterTest::minOptional;
            this.payloads.max = RandomAccessListAdapterTest::max;
            this.payloads.maxOptional = RandomAccessListAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = RandomAccessListAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = RandomAccessListAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = RandomAccessListAdapterTest::min_null_safe;
            this.payloads.max_null_safe = RandomAccessListAdapterTest::max_null_safe;
            this.payloads.minBy = RandomAccessListAdapterTest::minBy;
            this.payloads.minByOptional = RandomAccessListAdapterTest::minByOptional;
            this.payloads.maxBy = RandomAccessListAdapterTest::maxBy;
            this.payloads.maxByOptional = RandomAccessListAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = RandomAccessListAdapterTest::detectWith;
            this.payloads.detectWithOptional = RandomAccessListAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = RandomAccessListAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = RandomAccessListAdapterTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = RandomAccessListAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = RandomAccessListAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = RandomAccessListAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = RandomAccessListAdapterTest::noneSatisfyWith;
            this.payloads.anySatisfy = RandomAccessListAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = RandomAccessListAdapterTest::anySatisfyWith;
            this.payloads.count = RandomAccessListAdapterTest::count;
            this.payloads.countWith = RandomAccessListAdapterTest::countWith;
            this.payloads.collectIf = RandomAccessListAdapterTest::collectIf;
            this.payloads.collectWith = RandomAccessListAdapterTest::collectWith;
            this.payloads.collectWith_target = RandomAccessListAdapterTest::collectWith_target;
            this.payloads.getAny = RandomAccessListAdapterTest::getAny;
            this.payloads.getFirst = RandomAccessListAdapterTest::getFirst;
            this.payloads.getLast = RandomAccessListAdapterTest::getLast;
            this.payloads.getOnly = RandomAccessListAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = RandomAccessListAdapterTest::isEmpty;
            this.payloads.iterator = RandomAccessListAdapterTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = RandomAccessListAdapterTest::injectInto;
            this.payloads.injectIntoInt = RandomAccessListAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = RandomAccessListAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = RandomAccessListAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = RandomAccessListAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = RandomAccessListAdapterTest::sumFloat;
            this.payloads.summarizeFloat = RandomAccessListAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = RandomAccessListAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = RandomAccessListAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = RandomAccessListAdapterTest::sumDouble;
            this.payloads.summarizeDouble = RandomAccessListAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = RandomAccessListAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = RandomAccessListAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = RandomAccessListAdapterTest::sumInteger;
            this.payloads.summarizeInt = RandomAccessListAdapterTest::summarizeInt;
            this.payloads.sumLong = RandomAccessListAdapterTest::sumLong;
            this.payloads.summarizeLong = RandomAccessListAdapterTest::summarizeLong;
            this.payloads.sumByInt = RandomAccessListAdapterTest::sumByInt;
            this.payloads.sumByFloat = RandomAccessListAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = RandomAccessListAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = RandomAccessListAdapterTest::sumByLong;
            this.payloads.sumByDouble = RandomAccessListAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = RandomAccessListAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = RandomAccessListAdapterTest::toArray;
            this.payloads.partition = RandomAccessListAdapterTest::partition;
            this.payloads.partitionWith = RandomAccessListAdapterTest::partitionWith;
            this.payloads.toList = RandomAccessListAdapterTest::toList;
            this.payloads.toImmutableList = RandomAccessListAdapterTest::toImmutableList;
            this.payloads.toCollection = RandomAccessListAdapterTest::toCollection;
            this.payloads.toBag = RandomAccessListAdapterTest::toBag;
            this.payloads.toImmutableBag = RandomAccessListAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = RandomAccessListAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = RandomAccessListAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = RandomAccessListAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = RandomAccessListAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = RandomAccessListAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = RandomAccessListAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = RandomAccessListAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = RandomAccessListAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = RandomAccessListAdapterTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = RandomAccessListAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = RandomAccessListAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = RandomAccessListAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = RandomAccessListAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = RandomAccessListAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = RandomAccessListAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = RandomAccessListAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = RandomAccessListAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = RandomAccessListAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = RandomAccessListAdapterTest::toSet;
            this.payloads.toImmutableSet = RandomAccessListAdapterTest::toImmutableSet;
            this.payloads.toMap = RandomAccessListAdapterTest::toMap;
            this.payloads.toImmutableMap = RandomAccessListAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = RandomAccessListAdapterTest::toMapTarget;
            this.payloads.toSortedMap = RandomAccessListAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = RandomAccessListAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = RandomAccessListAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = RandomAccessListAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = RandomAccessListAdapterTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = RandomAccessListAdapterTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = RandomAccessListAdapterTest::appendStringThrows;
            this.payloads.countBy = RandomAccessListAdapterTest::countBy;
            this.payloads.countByWith = RandomAccessListAdapterTest::countByWith;
            this.payloads.countByEach = RandomAccessListAdapterTest::countByEach;
            this.payloads.groupBy = RandomAccessListAdapterTest::groupBy;
            this.payloads.groupByEach = RandomAccessListAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = RandomAccessListAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = RandomAccessListAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = RandomAccessListAdapterTest::zip;
            this.payloads.zipWithIndex = RandomAccessListAdapterTest::zipWithIndex;
            this.payloads.chunk_empty = RandomAccessListAdapterTest::chunk_empty;
            this.payloads.chunk_single = RandomAccessListAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = RandomAccessListAdapterTest::chunk_large_size;
            this.payloads.empty = RandomAccessListAdapterTest::empty;
            this.payloads.notEmpty = RandomAccessListAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = RandomAccessListAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = RandomAccessListAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = RandomAccessListAdapterTest::reduceOptional;
            this.payloads.testNewWith = RandomAccessListAdapterTest::testNewWith;
            this.payloads.testNewWithWith = RandomAccessListAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = RandomAccessListAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = RandomAccessListAdapterTest::testNewWithVarArgs;
            this.payloads.addAll = RandomAccessListAdapterTest::addAll;
            this.payloads.addAllIterable = RandomAccessListAdapterTest::addAllIterable;
            this.payloads.removeAll = RandomAccessListAdapterTest::removeAll;
            this.payloads.removeAllIterable = RandomAccessListAdapterTest::removeAllIterable;
            this.payloads.retainAll = RandomAccessListAdapterTest::retainAll;
            this.payloads.retainAllIterable = RandomAccessListAdapterTest::retainAllIterable;
            this.payloads.clear = RandomAccessListAdapterTest::clear;
            this.payloads.injectIntoWith = RandomAccessListAdapterTest::injectIntoWith;
            this.payloads.removeObject = RandomAccessListAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = RandomAccessListAdapterTest::selectAndRejectWith;
            this.payloads.with = RandomAccessListAdapterTest::with;
            this.payloads.withAll = RandomAccessListAdapterTest::withAll;
            this.payloads.without = RandomAccessListAdapterTest::without;
            this.payloads.withoutAll = RandomAccessListAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = RandomAccessListAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = RandomAccessListAdapterTest::asLazy;
            this.payloads.randomAccess_throws = RandomAccessListAdapterTest::randomAccess_throws;
            this.payloads.getFirstOptional = RandomAccessListAdapterTest::getFirstOptional;
            this.payloads.getLastOptional = RandomAccessListAdapterTest::getLastOptional;
            this.payloads.detectIndex = RandomAccessListAdapterTest::detectIndex;
            this.payloads.detectLastIndex = RandomAccessListAdapterTest::detectLastIndex;
            this.payloads.collectWithIndex = RandomAccessListAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = RandomAccessListAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = RandomAccessListAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = RandomAccessListAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = RandomAccessListAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = RandomAccessListAdapterTest::rejectWithIndexWithTarget;
            this.payloads.toImmutable = RandomAccessListAdapterTest::toImmutable;
            this.payloads.asUnmodifiable = RandomAccessListAdapterTest::asUnmodifiable;
            this.payloads.corresponds = RandomAccessListAdapterTest::corresponds;
            this.payloads.forEachFromToInReverse = RandomAccessListAdapterTest::forEachFromToInReverse;
            this.payloads.reverseForEach = RandomAccessListAdapterTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = RandomAccessListAdapterTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = RandomAccessListAdapterTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = RandomAccessListAdapterTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = RandomAccessListAdapterTest::reverseThis;
            this.payloads.toReversed = RandomAccessListAdapterTest::toReversed;
            this.payloads.distinct = RandomAccessListAdapterTest::distinct;
            this.payloads.distinctWithHashingStrategy = RandomAccessListAdapterTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = RandomAccessListAdapterTest::distinctBy;
            this.payloads.removeIndex = RandomAccessListAdapterTest::removeIndex;
            this.payloads.set = RandomAccessListAdapterTest::set;
            this.payloads.addAtIndex = RandomAccessListAdapterTest::addAtIndex;
            this.payloads.addAllAtIndex = RandomAccessListAdapterTest::addAllAtIndex;
            this.payloads.withMethods = RandomAccessListAdapterTest::withMethods;
            this.payloads.sortThis_with_null = RandomAccessListAdapterTest::sortThis_with_null;
            this.payloads.sortThis_small = RandomAccessListAdapterTest::sortThis_small;
            this.payloads.sortThis = RandomAccessListAdapterTest::sortThis;
            this.payloads.sortThis_large = RandomAccessListAdapterTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = RandomAccessListAdapterTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = RandomAccessListAdapterTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = RandomAccessListAdapterTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = RandomAccessListAdapterTest::sortThisBy;
            this.payloads.sortThisByBoolean = RandomAccessListAdapterTest::sortThisByBoolean;
            this.payloads.sortThisByInt = RandomAccessListAdapterTest::sortThisByInt;
            this.payloads.sortThisByChar = RandomAccessListAdapterTest::sortThisByChar;
            this.payloads.sortThisByByte = RandomAccessListAdapterTest::sortThisByByte;
            this.payloads.sortThisByShort = RandomAccessListAdapterTest::sortThisByShort;
            this.payloads.sortThisByFloat = RandomAccessListAdapterTest::sortThisByFloat;
            this.payloads.sortThisByLong = RandomAccessListAdapterTest::sortThisByLong;
            this.payloads.sortThisByDouble = RandomAccessListAdapterTest::sortThisByDouble;
            this.payloads.testToString = RandomAccessListAdapterTest::testToString;
            this.payloads.makeString = RandomAccessListAdapterTest::makeString;
            this.payloads.makeStringWithSeparator = RandomAccessListAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = RandomAccessListAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = RandomAccessListAdapterTest::appendString;
            this.payloads.appendStringWithSeparator = RandomAccessListAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = RandomAccessListAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = RandomAccessListAdapterTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = RandomAccessListAdapterTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = RandomAccessListAdapterTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = RandomAccessListAdapterTest::forEachWithIndexOnRange;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = RandomAccessListAdapterTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = RandomAccessListAdapterTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = RandomAccessListAdapterTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = RandomAccessListAdapterTest::chunk;
            this.payloads.toStack = RandomAccessListAdapterTest::toStack;
            this.payloads.take = RandomAccessListAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = RandomAccessListAdapterTest::takeWhile;
            this.payloads.drop = RandomAccessListAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = RandomAccessListAdapterTest::dropWhile;
            this.payloads.partitionWhile = RandomAccessListAdapterTest::partitionWhile;
            this.payloads.asReversed = RandomAccessListAdapterTest::asReversed;
            this.payloads.binarySearch = RandomAccessListAdapterTest::binarySearch;
            this.payloads.binarySearchWithComparator = RandomAccessListAdapterTest::binarySearchWithComparator;
            this.payloads.forEachWithIndex = RandomAccessListAdapterTest::forEachWithIndex;
            this.payloads.forEachInBoth = RandomAccessListAdapterTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = RandomAccessListAdapterTest::replaceAll;
            this.payloads.sort = RandomAccessListAdapterTest::sort;
            this.payloads.asSynchronized = RandomAccessListAdapterTest::asSynchronized;
            this.payloads.testClone = RandomAccessListAdapterTest::testClone;
            this.payloads.equalsAndHashCode = RandomAccessListAdapterTest::equalsAndHashCode;
            this.payloads.subList = RandomAccessListAdapterTest::subList;
            this.payloads.newListWithSize = RandomAccessListAdapterTest::newListWithSize;
            this.payloads.serialization = RandomAccessListAdapterTest::serialization;
            this.payloads.forEachFromTo = RandomAccessListAdapterTest::forEachFromTo;
            this.payloads.removeIf = RandomAccessListAdapterTest::removeIf;
            this.payloads.removeIfWith = RandomAccessListAdapterTest::removeIfWith;
            this.payloads.testRemoveIndex = RandomAccessListAdapterTest::testRemoveIndex;
            this.payloads.indexOf = RandomAccessListAdapterTest::indexOf;
            this.payloads.lastIndexOf = RandomAccessListAdapterTest::lastIndexOf;
            this.payloads.testSet = RandomAccessListAdapterTest::testSet;
            this.payloads.testAddAtIndex = RandomAccessListAdapterTest::testAddAtIndex;
            this.payloads.testAddAllAtIndex = RandomAccessListAdapterTest::testAddAllAtIndex;
            this.payloads.testWithMethods = RandomAccessListAdapterTest::testWithMethods;
            this.payloads.newEmpty = RandomAccessListAdapterTest::newEmpty;
            this.payloads.adaptNull = RandomAccessListAdapterTest::adaptNull;
            this.payloads.adapt = RandomAccessListAdapterTest::adapt;
        }
    }
}
