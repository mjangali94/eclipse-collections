/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectIntSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectIntSingletonMapTest extends AbstractImmutableObjectIntMapTestCase {

    @Override
    protected ImmutableObjectIntMap<String> classUnderTest() {
        return ObjectIntHashMap.newWithKeysValues("1", 1).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected = ObjectIntHashMap.newWithKeysValues("1", 1, "3", 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.newWithKeysValues("1", 1);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectIntMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.newWithKeysValues("1", 1);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectIntMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertTrue(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(0));
        Assert.assertTrue(this.classUnderTest().containsValue(1));
        Assert.assertFalse(this.classUnderTest().containsValue(2));
    }

    @Override
    @Test
    public void detectIfNone() {
        int detect = this.classUnderTest().detectIfNone((int value) -> true, 5);
        Assert.assertEquals(1, detect);
        int detect1 = this.classUnderTest().detectIfNone((int value) -> false, 5);
        Assert.assertEquals(5, detect1);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("0", 1));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("1", 2));
        Assert.assertEquals(3, this.classUnderTest().getIfAbsent("2", 3));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("5", 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent("5", 0));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent(null, 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent(null, 0));
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(1, this.classUnderTest().maxIfEmpty(9));
    }

    @Override
    @Test
    public void median() {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy((int value) -> false));
        Assert.assertTrue(this.classUnderTest().allSatisfy((int value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, int value) -> false));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, int value) -> true));
        Assert.assertEquals(new IntHashBag(), this.classUnderTest().reject((int value) -> true).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().reject((int value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, int value) -> true));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, int value) -> false));
        Assert.assertEquals(new IntHashBag(), this.classUnderTest().select((int value) -> false).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().select((int value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void intIterator() {
        IntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(0));
        Assert.assertTrue(this.classUnderTest().contains(1));
        Assert.assertFalse(this.classUnderTest().contains(2));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(1, this.classUnderTest().getOrThrow("1"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0, this.classUnderTest().get("0"));
        Assert.assertEquals(1, this.classUnderTest().get("1"));
        Assert.assertEquals(0, this.classUnderTest().get(null));
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(1L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count((int value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((int value) -> false));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(1), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 2));
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 5));
        Assert.assertTrue(this.classUnderTest().containsAll(1));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(this.classUnderTest().containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1, this.classUnderTest().minIfEmpty(6));
    }

    @Override
    @Test
    public void testEquals() {
        ObjectIntMap<String> map1 = this.newWithKeysValues("1", 1);
        ObjectIntMap<String> map2 = this.newWithKeysValues("0", 0);
        ObjectIntMap<String> map3 = this.newWithKeysValues("0", 0, "1", 1);
        Assert.assertNotEquals(this.classUnderTest(), map3);
        Assert.assertNotEquals(this.classUnderTest(), map2);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map1);
        Verify.assertPostSerializedEqualsAndHashCode(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertNotEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy((int value) -> true));
        Assert.assertTrue(this.classUnderTest().noneSatisfy((int value) -> false));
    }

    @Test
    public void injectInto() {
        ImmutableObjectIntSingletonMap<String> iterable = new ImmutableObjectIntSingletonMap<>("1", 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(1), (MutableInteger object, int value) -> object.add(value));
        Assert.assertEquals(new MutableInteger(2), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectIntSingletonMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectIntSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectIntSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectIntSingletonMapTest::values;
            this.payloads.size = ImmutableObjectIntSingletonMapTest::size;
            this.payloads.asLazy = ImmutableObjectIntSingletonMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectIntSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectIntSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableObjectIntSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectIntSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectIntSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectIntSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectIntSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectIntSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableObjectIntSingletonMapTest::appendString;
            this.payloads.tap = ImmutableObjectIntSingletonMapTest::tap;
            this.payloads.anySatisfy = ImmutableObjectIntSingletonMapTest::anySatisfy;
            this.payloads.collect = ImmutableObjectIntSingletonMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectIntSingletonMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectIntSingletonMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableObjectIntSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectIntSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectIntSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectIntSingletonMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectIntSingletonMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectIntSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectIntSingletonMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectIntSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectIntSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectIntSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectIntSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectIntSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectIntSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectIntSingletonMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectIntSingletonMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectIntSingletonMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectIntSingletonMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectIntSingletonMapTest::maxIfEmpty;
            this.payloads.median = ImmutableObjectIntSingletonMapTest::median;
            this.payloads.allSatisfy = ImmutableObjectIntSingletonMapTest::allSatisfy;
            this.payloads.reject = ImmutableObjectIntSingletonMapTest::reject;
            this.payloads.select = ImmutableObjectIntSingletonMapTest::select;
            this.payloads.keysView = ImmutableObjectIntSingletonMapTest::keysView;
            this.payloads.intIterator = ImmutableObjectIntSingletonMapTest::intIterator;
            this.payloads.contains = ImmutableObjectIntSingletonMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectIntSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectIntSingletonMapTest::get;
            this.payloads.max = ImmutableObjectIntSingletonMapTest::max;
            this.payloads.min = ImmutableObjectIntSingletonMapTest::min;
            this.payloads.sum = ImmutableObjectIntSingletonMapTest::sum;
            this.payloads.count = ImmutableObjectIntSingletonMapTest::count;
            this.payloads.toBag = ImmutableObjectIntSingletonMapTest::toBag;
            this.payloads.toSet = ImmutableObjectIntSingletonMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectIntSingletonMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectIntSingletonMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectIntSingletonMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectIntSingletonMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectIntSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectIntSingletonMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectIntSingletonMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectIntSingletonMapTest::injectInto;
        }
    }
}
