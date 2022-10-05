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
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectFloatSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectFloatSingletonMapTest extends AbstractImmutableObjectFloatMapTestCase {

    @Override
    protected ImmutableObjectFloatMap<String> classUnderTest() {
        return ObjectFloatHashMap.newWithKeysValues("1", 1.0f).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "3", 3.0f).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected1 = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectFloatMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected1 = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectFloatMap<String> expected2 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue(0.0f));
        Assert.assertTrue(this.classUnderTest().containsValue(1.0f));
        Assert.assertFalse(this.classUnderTest().containsValue(2.0f));
    }

    @Override
    @Test
    public void detectIfNone() {
        float detect = this.classUnderTest().detectIfNone((float value) -> true, 5.0f);
        Assert.assertEquals(1.0f, detect, 0.0f);
        float detect1 = this.classUnderTest().detectIfNone((float value) -> false, 5.0f);
        Assert.assertEquals(5.0f, detect1, 0.0f);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("0", 1.0f), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("1", 2.0f), 0.0f);
        Assert.assertEquals(3.0f, this.classUnderTest().getIfAbsent("2", 3.0f), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("5", 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().getIfAbsent("5", 0.0f), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent(null, 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().getIfAbsent(null, 0.0f), 0.0f);
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(1.0f, this.classUnderTest().maxIfEmpty(9.0f), 0.0f);
    }

    @Override
    @Test
    public void median() {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy((float value) -> false));
        Assert.assertTrue(this.classUnderTest().allSatisfy((float value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, float value) -> false));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, float value) -> true));
        Assert.assertEquals(new FloatHashBag(), this.classUnderTest().reject((float value) -> true).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().reject((float value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, float value) -> true));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, float value) -> false));
        Assert.assertEquals(new FloatHashBag(), this.classUnderTest().select((float value) -> false).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().select((float value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void floatIterator() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(0.0f));
        Assert.assertTrue(this.classUnderTest().contains(1.0f));
        Assert.assertFalse(this.classUnderTest().contains(2.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(1.0f, this.classUnderTest().getOrThrow("1"), 0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0.0f, this.classUnderTest().get("0"), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().get("1"), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().get(null), 0.0f);
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(1.0f, this.classUnderTest().max(), 0.0f);
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(1.0f, this.classUnderTest().max(), 0.0f);
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(1.0, this.classUnderTest().sum(), 0.0);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count((float value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((float value) -> false));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(0.0f, 1.0f, 2.0f));
        Assert.assertFalse(this.classUnderTest().containsAll(0.0f, 1.0f, 5.0f));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0f));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 5.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(new FloatArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1.0f, this.classUnderTest().minIfEmpty(6.0f), 0.0f);
    }

    @Override
    @Test
    public void testEquals() {
        ObjectFloatMap<String> map1 = this.newWithKeysValues("1", 1.0f);
        ObjectFloatMap<String> map2 = this.newWithKeysValues("0", 0.0f);
        ObjectFloatMap<String> map3 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
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
        Assert.assertFalse(this.classUnderTest().noneSatisfy((float value) -> true));
        Assert.assertTrue(this.classUnderTest().noneSatisfy((float value) -> false));
    }

    @Test
    public void injectInto() {
        ImmutableObjectFloatSingletonMap<String> iterable = new ImmutableObjectFloatSingletonMap<>("1", 1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(1.0f), (MutableFloat object, float value) -> object.add(value));
        Assert.assertEquals(new MutableFloat(2.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectFloatSingletonMapTest instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectFloatSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectFloatSingletonMapTest::values;
            this.payloads.size = ImmutableObjectFloatSingletonMapTest::size;
            this.payloads.asLazy = ImmutableObjectFloatSingletonMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectFloatSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectFloatSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableObjectFloatSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectFloatSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectFloatSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectFloatSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectFloatSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectFloatSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableObjectFloatSingletonMapTest::appendString;
            this.payloads.tap = ImmutableObjectFloatSingletonMapTest::tap;
            this.payloads.anySatisfy = ImmutableObjectFloatSingletonMapTest::anySatisfy;
            this.payloads.collect = ImmutableObjectFloatSingletonMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatSingletonMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatSingletonMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableObjectFloatSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectFloatSingletonMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectFloatSingletonMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectFloatSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectFloatSingletonMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectFloatSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectFloatSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectFloatSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectFloatSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectFloatSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectFloatSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectFloatSingletonMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectFloatSingletonMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectFloatSingletonMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectFloatSingletonMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectFloatSingletonMapTest::maxIfEmpty;
            this.payloads.median = ImmutableObjectFloatSingletonMapTest::median;
            this.payloads.allSatisfy = ImmutableObjectFloatSingletonMapTest::allSatisfy;
            this.payloads.reject = ImmutableObjectFloatSingletonMapTest::reject;
            this.payloads.select = ImmutableObjectFloatSingletonMapTest::select;
            this.payloads.keysView = ImmutableObjectFloatSingletonMapTest::keysView;
            this.payloads.floatIterator = ImmutableObjectFloatSingletonMapTest::floatIterator;
            this.payloads.contains = ImmutableObjectFloatSingletonMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectFloatSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectFloatSingletonMapTest::get;
            this.payloads.max = ImmutableObjectFloatSingletonMapTest::max;
            this.payloads.min = ImmutableObjectFloatSingletonMapTest::min;
            this.payloads.sum = ImmutableObjectFloatSingletonMapTest::sum;
            this.payloads.count = ImmutableObjectFloatSingletonMapTest::count;
            this.payloads.toBag = ImmutableObjectFloatSingletonMapTest::toBag;
            this.payloads.toSet = ImmutableObjectFloatSingletonMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectFloatSingletonMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectFloatSingletonMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectFloatSingletonMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectFloatSingletonMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectFloatSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectFloatSingletonMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectFloatSingletonMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectFloatSingletonMapTest::injectInto;
        }
    }
}
