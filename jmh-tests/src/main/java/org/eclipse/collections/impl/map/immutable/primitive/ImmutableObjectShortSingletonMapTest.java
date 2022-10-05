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
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectShortSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectShortSingletonMapTest extends AbstractImmutableObjectShortMapTestCase {

    @Override
    protected ImmutableObjectShortMap<String> classUnderTest() {
        return ObjectShortHashMap.newWithKeysValues("1", (short) 1).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected = ObjectShortHashMap.newWithKeysValues("1", (short) 1, "3", (short) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (short) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (short) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.newWithKeysValues("1", (short) 1);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectShortMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.newWithKeysValues("1", (short) 1);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectShortMap<String> expected2 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue((short) 0));
        Assert.assertTrue(this.classUnderTest().containsValue((short) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((short) 2));
    }

    @Override
    @Test
    public void detectIfNone() {
        short detect = this.classUnderTest().detectIfNone((short value) -> true, (short) 5);
        Assert.assertEquals((short) 1, detect);
        short detect1 = this.classUnderTest().detectIfNone((short value) -> false, (short) 5);
        Assert.assertEquals((short) 5, detect1);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("0", (short) 1));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("1", (short) 2));
        Assert.assertEquals((short) 3, this.classUnderTest().getIfAbsent("2", (short) 3));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("5", (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent("5", (short) 0));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent(null, (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent(null, (short) 0));
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 1, this.classUnderTest().maxIfEmpty((short) 9));
    }

    @Override
    @Test
    public void median() {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy((short value) -> false));
        Assert.assertTrue(this.classUnderTest().allSatisfy((short value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, short value) -> false));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, short value) -> true));
        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().reject((short value) -> true).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.classUnderTest().reject((short value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, short value) -> true));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, short value) -> false));
        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().select((short value) -> false).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.classUnderTest().select((short value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains((short) 0));
        Assert.assertTrue(this.classUnderTest().contains((short) 1));
        Assert.assertFalse(this.classUnderTest().contains((short) 2));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals((short) 1, this.classUnderTest().getOrThrow("1"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals((short) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((short) 1, this.classUnderTest().get("1"));
        Assert.assertEquals((short) 0, this.classUnderTest().get(null));
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals((short) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals((short) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(1L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count((short value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((short value) -> false));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 5));
        Assert.assertTrue(this.classUnderTest().containsAll((short) 1));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 1, this.classUnderTest().minIfEmpty((short) 6));
    }

    @Override
    @Test
    public void testEquals() {
        ObjectShortMap<String> map1 = this.newWithKeysValues("1", (short) 1);
        ObjectShortMap<String> map2 = this.newWithKeysValues("0", (short) 0);
        ObjectShortMap<String> map3 = this.newWithKeysValues("0", (short) 0, "1", (short) 1);
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
        Assert.assertFalse(this.classUnderTest().noneSatisfy((short value) -> true));
        Assert.assertTrue(this.classUnderTest().noneSatisfy((short value) -> false));
    }

    @Test
    public void injectInto() {
        ImmutableObjectShortSingletonMap<String> iterable = new ImmutableObjectShortSingletonMap<>("1", (short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 1), (MutableShort object, short value) -> object.add(value));
        Assert.assertEquals(new MutableShort((short) 2), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectShortSingletonMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectShortSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectShortSingletonMapTest::values;
            this.payloads.size = ImmutableObjectShortSingletonMapTest::size;
            this.payloads.asLazy = ImmutableObjectShortSingletonMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectShortSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectShortSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableObjectShortSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectShortSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectShortSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectShortSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectShortSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectShortSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableObjectShortSingletonMapTest::appendString;
            this.payloads.tap = ImmutableObjectShortSingletonMapTest::tap;
            this.payloads.anySatisfy = ImmutableObjectShortSingletonMapTest::anySatisfy;
            this.payloads.collect = ImmutableObjectShortSingletonMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortSingletonMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortSingletonMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableObjectShortSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectShortSingletonMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectShortSingletonMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectShortSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectShortSingletonMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectShortSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectShortSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectShortSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectShortSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectShortSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectShortSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectShortSingletonMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectShortSingletonMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectShortSingletonMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectShortSingletonMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectShortSingletonMapTest::maxIfEmpty;
            this.payloads.median = ImmutableObjectShortSingletonMapTest::median;
            this.payloads.allSatisfy = ImmutableObjectShortSingletonMapTest::allSatisfy;
            this.payloads.reject = ImmutableObjectShortSingletonMapTest::reject;
            this.payloads.select = ImmutableObjectShortSingletonMapTest::select;
            this.payloads.keysView = ImmutableObjectShortSingletonMapTest::keysView;
            this.payloads.shortIterator = ImmutableObjectShortSingletonMapTest::shortIterator;
            this.payloads.contains = ImmutableObjectShortSingletonMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectShortSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectShortSingletonMapTest::get;
            this.payloads.max = ImmutableObjectShortSingletonMapTest::max;
            this.payloads.min = ImmutableObjectShortSingletonMapTest::min;
            this.payloads.sum = ImmutableObjectShortSingletonMapTest::sum;
            this.payloads.count = ImmutableObjectShortSingletonMapTest::count;
            this.payloads.toBag = ImmutableObjectShortSingletonMapTest::toBag;
            this.payloads.toSet = ImmutableObjectShortSingletonMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectShortSingletonMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectShortSingletonMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectShortSingletonMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectShortSingletonMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectShortSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectShortSingletonMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectShortSingletonMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectShortSingletonMapTest::injectInto;
        }
    }
}
