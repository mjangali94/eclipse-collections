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
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.FloatBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatBooleanEmptyMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanEmptyMapTest.stg.
 */
public class ImmutableFloatBooleanEmptyMapTest extends AbstractImmutableFloatBooleanMapTestCase {

    @Override
    protected ImmutableFloatBooleanMap classUnderTest() {
        return FloatBooleanMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(0.0f, true);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0f, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0f, true));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(true));
        Assert.assertFalse(this.classUnderTest().containsValue(false));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(true));
        Assert.assertFalse(this.classUnderTest().contains(false));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0f, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31.0f, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(32.0f, false));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.classUnderTest().asLazy().toList());
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(0.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32.0f));
    }

    @Override
    @Test
    public void get() {
        Assert.assertFalse(this.classUnderTest().get(0.0f));
        Assert.assertFalse(this.classUnderTest().get(31.0f));
        Assert.assertFalse(this.classUnderTest().get(32.0f));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(true, false));
        Assert.assertFalse(this.classUnderTest().containsAll(false));
        Assert.assertFalse(this.classUnderTest().containsAll(true));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.classUnderTest().containsKey(0.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(31.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void containsAllIterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((key, value) -> true));
    }

    @Override
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((key, value) -> false));
    }

    @Override
    public void select_value() {
        Assert.assertEquals(BooleanBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    public void reject_value() {
        Assert.assertEquals(BooleanBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(value -> true));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatBooleanEmptyMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatBooleanEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanEmptyMapTest> isEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = ImmutableFloatBooleanEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableFloatBooleanEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableFloatBooleanEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableFloatBooleanEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableFloatBooleanEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableFloatBooleanEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableFloatBooleanEmptyMapTest::forEachKeyValue;
            this.payloads.makeString = ImmutableFloatBooleanEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableFloatBooleanEmptyMapTest::appendString;
            this.payloads.select = ImmutableFloatBooleanEmptyMapTest::select;
            this.payloads.reject = ImmutableFloatBooleanEmptyMapTest::reject;
            this.payloads.select_value = ImmutableFloatBooleanEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableFloatBooleanEmptyMapTest::reject_value;
            this.payloads.collect = ImmutableFloatBooleanEmptyMapTest::collect;
            this.payloads.count = ImmutableFloatBooleanEmptyMapTest::count;
            this.payloads.detectIfNone_value = ImmutableFloatBooleanEmptyMapTest::detectIfNone_value;
            this.payloads.toList = ImmutableFloatBooleanEmptyMapTest::toList;
            this.payloads.toSet = ImmutableFloatBooleanEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableFloatBooleanEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableFloatBooleanEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableFloatBooleanEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableFloatBooleanEmptyMapTest::toImmutable;
            this.payloads.testEquals = ImmutableFloatBooleanEmptyMapTest::testEquals;
            this.payloads.newWithKeyValue = ImmutableFloatBooleanEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableFloatBooleanEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableFloatBooleanEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableFloatBooleanEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableFloatBooleanEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableFloatBooleanEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableFloatBooleanEmptyMapTest::asLazy;
            this.payloads.booleanIterator = ImmutableFloatBooleanEmptyMapTest::booleanIterator;
            this.payloads.getOrThrow = ImmutableFloatBooleanEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableFloatBooleanEmptyMapTest::get;
            this.payloads.containsAll = ImmutableFloatBooleanEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableFloatBooleanEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableFloatBooleanEmptyMapTest::keysView;
            this.payloads.notEmpty = ImmutableFloatBooleanEmptyMapTest::notEmpty;
            this.payloads.containsAllIterable = ImmutableFloatBooleanEmptyMapTest::containsAllIterable;
            this.payloads.allSatisfy = ImmutableFloatBooleanEmptyMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableFloatBooleanEmptyMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableFloatBooleanEmptyMapTest::noneSatisfy;
            this.payloads.isEmpty = ImmutableFloatBooleanEmptyMapTest::isEmpty;
        }
    }
}
