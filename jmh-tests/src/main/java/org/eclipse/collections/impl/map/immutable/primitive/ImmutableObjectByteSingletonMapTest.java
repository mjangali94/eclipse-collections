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
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.ObjectByteMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectByteSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectByteSingletonMapTest extends AbstractImmutableObjectByteMapTestCase {

    @Override
    protected ImmutableObjectByteMap<String> classUnderTest() {
        return ObjectByteHashMap.newWithKeysValues("1", (byte) 1).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected = ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "3", (byte) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected1 = this.newWithKeysValues("1", (byte) 1);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectByteMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected1 = this.newWithKeysValues("1", (byte) 1);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectByteMap<String> expected2 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue((byte) 0));
        Assert.assertTrue(this.classUnderTest().containsValue((byte) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((byte) 2));
    }

    @Override
    @Test
    public void detectIfNone() {
        byte detect = this.classUnderTest().detectIfNone((byte value) -> true, (byte) 5);
        Assert.assertEquals((byte) 1, detect);
        byte detect1 = this.classUnderTest().detectIfNone((byte value) -> false, (byte) 5);
        Assert.assertEquals((byte) 5, detect1);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent("0", (byte) 1));
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent("1", (byte) 2));
        Assert.assertEquals((byte) 3, this.classUnderTest().getIfAbsent("2", (byte) 3));
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent("5", (byte) 1));
        Assert.assertEquals((byte) 0, this.classUnderTest().getIfAbsent("5", (byte) 0));
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent(null, (byte) 1));
        Assert.assertEquals((byte) 0, this.classUnderTest().getIfAbsent(null, (byte) 0));
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((byte) 1, this.classUnderTest().maxIfEmpty((byte) 9));
    }

    @Override
    @Test
    public void median() {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy((byte value) -> false));
        Assert.assertTrue(this.classUnderTest().allSatisfy((byte value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, byte value) -> false));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, byte value) -> true));
        Assert.assertEquals(new ByteHashBag(), this.classUnderTest().reject((byte value) -> true).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.classUnderTest().reject((byte value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, byte value) -> true));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, byte value) -> false));
        Assert.assertEquals(new ByteHashBag(), this.classUnderTest().select((byte value) -> false).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.classUnderTest().select((byte value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void byteIterator() {
        ByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains((byte) 0));
        Assert.assertTrue(this.classUnderTest().contains((byte) 1));
        Assert.assertFalse(this.classUnderTest().contains((byte) 2));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals((byte) 1, this.classUnderTest().getOrThrow("1"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals((byte) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((byte) 1, this.classUnderTest().get("1"));
        Assert.assertEquals((byte) 0, this.classUnderTest().get(null));
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals((byte) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals((byte) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(1L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count((byte value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((byte value) -> false));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 0, (byte) 1, (byte) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 0, (byte) 1, (byte) 5));
        Assert.assertTrue(this.classUnderTest().containsAll((byte) 1));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(new ByteArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals((byte) 1, this.classUnderTest().minIfEmpty((byte) 6));
    }

    @Override
    @Test
    public void testEquals() {
        ObjectByteMap<String> map1 = this.newWithKeysValues("1", (byte) 1);
        ObjectByteMap<String> map2 = this.newWithKeysValues("0", (byte) 0);
        ObjectByteMap<String> map3 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
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
        Assert.assertFalse(this.classUnderTest().noneSatisfy((byte value) -> true));
        Assert.assertTrue(this.classUnderTest().noneSatisfy((byte value) -> false));
    }

    @Test
    public void injectInto() {
        ImmutableObjectByteSingletonMap<String> iterable = new ImmutableObjectByteSingletonMap<>("1", (byte) 1);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 1), (MutableByte object, byte value) -> object.add(value));
        Assert.assertEquals(new MutableByte((byte) 2), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectByteSingletonMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectByteSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectByteSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectByteSingletonMapTest::values;
            this.payloads.size = ImmutableObjectByteSingletonMapTest::size;
            this.payloads.asLazy = ImmutableObjectByteSingletonMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectByteSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectByteSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableObjectByteSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectByteSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectByteSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectByteSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectByteSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectByteSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableObjectByteSingletonMapTest::appendString;
            this.payloads.tap = ImmutableObjectByteSingletonMapTest::tap;
            this.payloads.anySatisfy = ImmutableObjectByteSingletonMapTest::anySatisfy;
            this.payloads.collect = ImmutableObjectByteSingletonMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectByteSingletonMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectByteSingletonMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableObjectByteSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectByteSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectByteSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectByteSingletonMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectByteSingletonMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectByteSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectByteSingletonMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectByteSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectByteSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectByteSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectByteSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectByteSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectByteSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectByteSingletonMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectByteSingletonMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectByteSingletonMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectByteSingletonMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectByteSingletonMapTest::maxIfEmpty;
            this.payloads.median = ImmutableObjectByteSingletonMapTest::median;
            this.payloads.allSatisfy = ImmutableObjectByteSingletonMapTest::allSatisfy;
            this.payloads.reject = ImmutableObjectByteSingletonMapTest::reject;
            this.payloads.select = ImmutableObjectByteSingletonMapTest::select;
            this.payloads.keysView = ImmutableObjectByteSingletonMapTest::keysView;
            this.payloads.byteIterator = ImmutableObjectByteSingletonMapTest::byteIterator;
            this.payloads.contains = ImmutableObjectByteSingletonMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectByteSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectByteSingletonMapTest::get;
            this.payloads.max = ImmutableObjectByteSingletonMapTest::max;
            this.payloads.min = ImmutableObjectByteSingletonMapTest::min;
            this.payloads.sum = ImmutableObjectByteSingletonMapTest::sum;
            this.payloads.count = ImmutableObjectByteSingletonMapTest::count;
            this.payloads.toBag = ImmutableObjectByteSingletonMapTest::toBag;
            this.payloads.toSet = ImmutableObjectByteSingletonMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectByteSingletonMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectByteSingletonMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectByteSingletonMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectByteSingletonMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectByteSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectByteSingletonMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectByteSingletonMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectByteSingletonMapTest::injectInto;
        }
    }
}
