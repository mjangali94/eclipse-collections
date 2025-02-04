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
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectLongEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectLongEmptyMapTest extends AbstractImmutableObjectLongMapTestCase {

    @Override
    protected ImmutableObjectLongMap<String> classUnderTest() {
        return (ImmutableObjectLongMap<String>) ImmutableObjectLongEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected = ObjectLongHashMap.newWithKeysValues("3", 3L).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3L));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertFalse(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(0L));
        Assert.assertFalse(this.classUnderTest().containsValue(1L));
        Assert.assertFalse(this.classUnderTest().containsValue(2L));
    }

    @Override
    @Test
    public void detectIfNone() {
        long detect = this.classUnderTest().detectIfNone((long value) -> true, 5L);
        Assert.assertEquals(5L, detect);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent("0", 1L));
        Assert.assertEquals(2L, this.classUnderTest().getIfAbsent("1", 2L));
        Assert.assertEquals(3L, this.classUnderTest().getIfAbsent("2", 3L));
        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent("5", 1L));
        Assert.assertEquals(0L, this.classUnderTest().getIfAbsent("5", 0L));
        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent(null, 1L));
        Assert.assertEquals(0L, this.classUnderTest().getIfAbsent(null, 0L));
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(9L, this.getEmptyMap().maxIfEmpty(9L));
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median() {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy((long value) -> false));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy((long value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, long value) -> false));
        Assert.assertEquals(new LongHashBag(), this.classUnderTest().reject((long value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, long value) -> true));
        Assert.assertEquals(new LongHashBag(), this.classUnderTest().select((long value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void longIterator() {
        LongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average() {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(0L));
        Assert.assertFalse(this.classUnderTest().contains(1L));
        Assert.assertFalse(this.classUnderTest().contains(2L));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.classUnderTest().get("0"));
        Assert.assertEquals(0L, this.classUnderTest().get("1"));
        Assert.assertEquals(0L, this.classUnderTest().get(null));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0L, this.classUnderTest().count((long value) -> true));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(0L, 1L, 2L));
        Assert.assertFalse(this.classUnderTest().containsAll(0L, 1L, 5L));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(0L, 1L, 2L)));
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(0L, 1L, 5L)));
        Assert.assertTrue(this.classUnderTest().containsAll(new LongArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5L));
        Assert.assertEquals(6L, this.getEmptyMap().minIfEmpty(6L));
    }

    @Override
    @Test
    public void testEquals() {
        ObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L, null, 2L);
        ObjectLongMap<String> map2 = this.getEmptyMap();
        Assert.assertNotEquals(this.classUnderTest(), map1);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map2);
        Verify.assertPostSerializedIdentity(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy((long value) -> true));
    }

    @Test
    public void injectInto() {
        ImmutableObjectLongEmptyMap<Object> iterable = new ImmutableObjectLongEmptyMap<>();
        MutableLong result = iterable.injectInto(new MutableLong(0L), (MutableLong object, long value) -> object.add(value));
        Assert.assertEquals(new MutableLong(0L), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectLongEmptyMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectLongEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectLongEmptyMapTest::values;
            this.payloads.size = ImmutableObjectLongEmptyMapTest::size;
            this.payloads.asLazy = ImmutableObjectLongEmptyMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectLongEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectLongEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableObjectLongEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectLongEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectLongEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectLongEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectLongEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectLongEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableObjectLongEmptyMapTest::appendString;
            this.payloads.tap = ImmutableObjectLongEmptyMapTest::tap;
            this.payloads.collect = ImmutableObjectLongEmptyMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectLongEmptyMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectLongEmptyMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectLongEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectLongEmptyMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectLongEmptyMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectLongEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectLongEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectLongEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectLongEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectLongEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectLongEmptyMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectLongEmptyMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectLongEmptyMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectLongEmptyMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectLongEmptyMapTest::maxIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::median, java.lang.ArithmeticException.class);
            this.payloads.allSatisfy = ImmutableObjectLongEmptyMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableObjectLongEmptyMapTest::anySatisfy;
            this.payloads.reject = ImmutableObjectLongEmptyMapTest::reject;
            this.payloads.select = ImmutableObjectLongEmptyMapTest::select;
            this.payloads.keysView = ImmutableObjectLongEmptyMapTest::keysView;
            this.payloads.longIterator = ImmutableObjectLongEmptyMapTest::longIterator;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::average, java.lang.ArithmeticException.class);
            this.payloads.contains = ImmutableObjectLongEmptyMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectLongEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectLongEmptyMapTest::get;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongEmptyMapTest::min, java.util.NoSuchElementException.class);
            this.payloads.sum = ImmutableObjectLongEmptyMapTest::sum;
            this.payloads.count = ImmutableObjectLongEmptyMapTest::count;
            this.payloads.toBag = ImmutableObjectLongEmptyMapTest::toBag;
            this.payloads.toSet = ImmutableObjectLongEmptyMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectLongEmptyMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectLongEmptyMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectLongEmptyMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectLongEmptyMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectLongEmptyMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectLongEmptyMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectLongEmptyMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectLongEmptyMapTest::injectInto;
        }
    }
}
