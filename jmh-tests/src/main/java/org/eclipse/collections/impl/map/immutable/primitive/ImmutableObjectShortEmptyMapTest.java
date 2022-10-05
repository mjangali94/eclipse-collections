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
 * JUnit test for {@link ImmutableObjectShortEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectShortEmptyMapTest extends AbstractImmutableObjectShortMapTestCase {

    @Override
    protected ImmutableObjectShortMap<String> classUnderTest() {
        return (ImmutableObjectShortMap<String>) ImmutableObjectShortEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected = ObjectShortHashMap.newWithKeysValues("3", (short) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (short) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (short) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue((short) 0));
        Assert.assertFalse(this.classUnderTest().containsValue((short) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((short) 2));
    }

    @Override
    @Test
    public void detectIfNone() {
        short detect = this.classUnderTest().detectIfNone((short value) -> true, (short) 5);
        Assert.assertEquals((short) 5, detect);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("0", (short) 1));
        Assert.assertEquals((short) 2, this.classUnderTest().getIfAbsent("1", (short) 2));
        Assert.assertEquals((short) 3, this.classUnderTest().getIfAbsent("2", (short) 3));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("5", (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent("5", (short) 0));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent(null, (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent(null, (short) 0));
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 9, this.getEmptyMap().maxIfEmpty((short) 9));
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median() {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy((short value) -> false));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy((short value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, short value) -> false));
        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().reject((short value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, short value) -> true));
        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().select((short value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
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
        Assert.assertFalse(this.classUnderTest().contains((short) 0));
        Assert.assertFalse(this.classUnderTest().contains((short) 1));
        Assert.assertFalse(this.classUnderTest().contains((short) 2));
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
        Assert.assertEquals((short) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((short) 0, this.classUnderTest().get("1"));
        Assert.assertEquals((short) 0, this.classUnderTest().get(null));
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
        Assert.assertEquals(0L, this.classUnderTest().count((short value) -> true));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 5));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 5, this.getEmptyMap().minIfEmpty((short) 5));
        Assert.assertEquals((short) 6, this.getEmptyMap().minIfEmpty((short) 6));
    }

    @Override
    @Test
    public void testEquals() {
        ObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 0, "1", (short) 1, null, (short) 2);
        ObjectShortMap<String> map2 = this.getEmptyMap();
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
        Assert.assertTrue(this.classUnderTest().noneSatisfy((short value) -> true));
    }

    @Test
    public void injectInto() {
        ImmutableObjectShortEmptyMap<Object> iterable = new ImmutableObjectShortEmptyMap<>();
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), (MutableShort object, short value) -> object.add(value));
        Assert.assertEquals(new MutableShort((short) 0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectShortEmptyMapTest instance;

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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectShortEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectShortEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectShortEmptyMapTest::values;
            this.payloads.size = ImmutableObjectShortEmptyMapTest::size;
            this.payloads.asLazy = ImmutableObjectShortEmptyMapTest::asLazy;
            this.payloads.testHashCode = ImmutableObjectShortEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectShortEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableObjectShortEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectShortEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectShortEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectShortEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectShortEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectShortEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableObjectShortEmptyMapTest::appendString;
            this.payloads.tap = ImmutableObjectShortEmptyMapTest::tap;
            this.payloads.collect = ImmutableObjectShortEmptyMapTest::collect;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectShortEmptyMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectShortEmptyMapTest::toSortedArray;
            this.payloads.toList = ImmutableObjectShortEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectShortEmptyMapTest::toSortedList;
            this.payloads.toImmutable = ImmutableObjectShortEmptyMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectShortEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectShortEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectShortEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectShortEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectShortEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsKey = ImmutableObjectShortEmptyMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectShortEmptyMapTest::containsValue;
            this.payloads.detectIfNone = ImmutableObjectShortEmptyMapTest::detectIfNone;
            this.payloads.getIfAbsent = ImmutableObjectShortEmptyMapTest::getIfAbsent;
            this.payloads.maxIfEmpty = ImmutableObjectShortEmptyMapTest::maxIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::median, java.lang.ArithmeticException.class);
            this.payloads.allSatisfy = ImmutableObjectShortEmptyMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableObjectShortEmptyMapTest::anySatisfy;
            this.payloads.reject = ImmutableObjectShortEmptyMapTest::reject;
            this.payloads.select = ImmutableObjectShortEmptyMapTest::select;
            this.payloads.keysView = ImmutableObjectShortEmptyMapTest::keysView;
            this.payloads.shortIterator = ImmutableObjectShortEmptyMapTest::shortIterator;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::average, java.lang.ArithmeticException.class);
            this.payloads.contains = ImmutableObjectShortEmptyMapTest::contains;
            this.payloads.getOrThrow = ImmutableObjectShortEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableObjectShortEmptyMapTest::get;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectShortEmptyMapTest::min, java.util.NoSuchElementException.class);
            this.payloads.sum = ImmutableObjectShortEmptyMapTest::sum;
            this.payloads.count = ImmutableObjectShortEmptyMapTest::count;
            this.payloads.toBag = ImmutableObjectShortEmptyMapTest::toBag;
            this.payloads.toSet = ImmutableObjectShortEmptyMapTest::toSet;
            this.payloads.containsAll = ImmutableObjectShortEmptyMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectShortEmptyMapTest::containsAll_Iterable;
            this.payloads.minIfEmpty = ImmutableObjectShortEmptyMapTest::minIfEmpty;
            this.payloads.testEquals = ImmutableObjectShortEmptyMapTest::testEquals;
            this.payloads.isEmpty = ImmutableObjectShortEmptyMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectShortEmptyMapTest::notEmpty;
            this.payloads.noneSatisfy = ImmutableObjectShortEmptyMapTest::noneSatisfy;
            this.payloads.injectInto = ImmutableObjectShortEmptyMapTest::injectInto;
        }
    }
}
