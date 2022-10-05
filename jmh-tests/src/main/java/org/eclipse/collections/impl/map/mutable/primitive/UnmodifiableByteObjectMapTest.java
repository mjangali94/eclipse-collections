/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableByteObjectMapTest extends AbstractMutableByteObjectMapTestCase {

    private final UnmodifiableByteObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableByteObjectMap<String> classUnderTest() {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2, byte key3, T value3) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> getEmptyMap() {
        return new UnmodifiableByteObjectMap<>(new ByteObjectHashMap<>());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey((byte) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove((byte) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put((byte) 0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll() {
        ByteObjectHashMap<String> hashMap = ByteObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue((byte) 1, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey((byte) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair((byte) 1, "one")));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals("zero", this.map.get((byte) 0));
        Assert.assertEquals("thirtyOne", this.map.get((byte) 31));
        Assert.assertEquals("thirtyTwo", this.map.get((byte) 32));
        Assert.assertNull(this.map.get((byte) 1));
        Assert.assertNull(this.map.get((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.getIfAbsent((byte) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent((byte) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent((byte) 32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((byte) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((byte) 33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws() {
        this.map.getIfAbsentPut((byte) 1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws() {
        this.map.getIfAbsentPut((byte) 1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((byte) 0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith((byte) 1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        ByteToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((byte) 0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        ByteToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey((byte) 1, toString);
    }

    @Override
    @Test
    public void freeze() {
        MutableByteObjectMap<String> mutableByteObjectMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteObjectMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValue((byte) 0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValueWith((byte) 0, zeroFactory, incrementFunction, 1);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains(null));
        Assert.assertTrue(this.map.contains("zero"));
        Assert.assertTrue(this.map.contains("thirtyOne"));
        Assert.assertTrue(this.map.contains("thirtyTwo"));
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey((byte) 0));
        Assert.assertTrue(this.map.containsKey((byte) 31));
        Assert.assertTrue(this.map.containsKey((byte) 32));
        Assert.assertFalse(this.map.containsKey((byte) 1));
        Assert.assertFalse(this.map.containsKey((byte) 5));
        Assert.assertFalse(this.map.containsKey((byte) 35));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertTrue(this.map.containsValue("zero"));
        Assert.assertTrue(this.map.containsValue("thirtyOne"));
        Assert.assertTrue(this.map.containsValue("thirtyTwo"));
    }

    @Override
    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, "one").size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, "one", (byte) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, "zero", (byte) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, "one", (byte) 0, "zero", (byte) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, "six", (byte) 5, "five").size());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Assert.assertSame(this.map, this.map.asUnmodifiable());
    }

    @Override
    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "one", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo").withKeyValue((byte) 1, "one").asUnmodifiable().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        UnmodifiableByteObjectMap<String> map1 = this.newWithKeysValues((byte) 0, "zero", (byte) 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
        iterator1.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
    }

    @Override
    @Test
    public void flipUniqueValues() {
        super.flipUniqueValues();
        Verify.assertInstanceOf(UnmodifiableObjectByteMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableByteObjectMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
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
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
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
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
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
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
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
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKeyThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKeyThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableByteObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPut_Value_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPut_Function_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableByteObjectMapTest::keySet;
            this.payloads.values = UnmodifiableByteObjectMapTest::values;
            this.payloads.select = UnmodifiableByteObjectMapTest::select;
            this.payloads.selectWith = UnmodifiableByteObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = UnmodifiableByteObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = UnmodifiableByteObjectMapTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableByteObjectMapTest::collect;
            this.payloads.collectBoolean = UnmodifiableByteObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = UnmodifiableByteObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = UnmodifiableByteObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = UnmodifiableByteObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = UnmodifiableByteObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = UnmodifiableByteObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = UnmodifiableByteObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = UnmodifiableByteObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = UnmodifiableByteObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = UnmodifiableByteObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = UnmodifiableByteObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = UnmodifiableByteObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = UnmodifiableByteObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = UnmodifiableByteObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = UnmodifiableByteObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = UnmodifiableByteObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = UnmodifiableByteObjectMapTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableByteObjectMapTest::collectWithTarget;
            this.payloads.collectIf = UnmodifiableByteObjectMapTest::collectIf;
            this.payloads.flatCollect = UnmodifiableByteObjectMapTest::flatCollect;
            this.payloads.detect = UnmodifiableByteObjectMapTest::detect;
            this.payloads.detectWith = UnmodifiableByteObjectMapTest::detectWith;
            this.payloads.detectOptional = UnmodifiableByteObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableByteObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableByteObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = UnmodifiableByteObjectMapTest::detectWithIfNone;
            this.payloads.count = UnmodifiableByteObjectMapTest::count;
            this.payloads.countWith = UnmodifiableByteObjectMapTest::countWith;
            this.payloads.anySatisfy = UnmodifiableByteObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableByteObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableByteObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableByteObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableByteObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableByteObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = UnmodifiableByteObjectMapTest::injectInto;
            this.payloads.intInjectInto = UnmodifiableByteObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = UnmodifiableByteObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = UnmodifiableByteObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = UnmodifiableByteObjectMapTest::doubleInjectInto;
            this.payloads.toList = UnmodifiableByteObjectMapTest::toList;
            this.payloads.toSortedList = UnmodifiableByteObjectMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableByteObjectMapTest::toSet;
            this.payloads.toSortedSet = UnmodifiableByteObjectMapTest::toSortedSet;
            this.payloads.toBag = UnmodifiableByteObjectMapTest::toBag;
            this.payloads.toMap = UnmodifiableByteObjectMapTest::toMap;
            this.payloads.toMapTarget = UnmodifiableByteObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableByteObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = UnmodifiableByteObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = UnmodifiableByteObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = UnmodifiableByteObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = UnmodifiableByteObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = UnmodifiableByteObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = UnmodifiableByteObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = UnmodifiableByteObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = UnmodifiableByteObjectMapTest::toArray;
            this.payloads.min = UnmodifiableByteObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = UnmodifiableByteObjectMapTest::maxBy;
            this.payloads.max = UnmodifiableByteObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = UnmodifiableByteObjectMapTest::minBy;
            this.payloads.sumOfInt = UnmodifiableByteObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableByteObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = UnmodifiableByteObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = UnmodifiableByteObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = UnmodifiableByteObjectMapTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableByteObjectMapTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableByteObjectMapTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableByteObjectMapTest::sumByDouble;
            this.payloads.keysView = UnmodifiableByteObjectMapTest::keysView;
            this.payloads.reject = UnmodifiableByteObjectMapTest::reject;
            this.payloads.rejectWith = UnmodifiableByteObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = UnmodifiableByteObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = UnmodifiableByteObjectMapTest::partition;
            this.payloads.partitionWith = UnmodifiableByteObjectMapTest::partitionWith;
            this.payloads.forEachValue = UnmodifiableByteObjectMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableByteObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableByteObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableByteObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = UnmodifiableByteObjectMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableByteObjectMapTest::notEmpty;
            this.payloads.getFirst = UnmodifiableByteObjectMapTest::getFirst;
            this.payloads.getLast = UnmodifiableByteObjectMapTest::getLast;
            this.payloads.getOnly = UnmodifiableByteObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnmodifiableByteObjectMapTest::containsAllIterable;
            this.payloads.containsAll = UnmodifiableByteObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = UnmodifiableByteObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = UnmodifiableByteObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = UnmodifiableByteObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = UnmodifiableByteObjectMapTest::containsNone;
            this.payloads.containsAllArguments = UnmodifiableByteObjectMapTest::containsAllArguments;
            this.payloads.testEquals = UnmodifiableByteObjectMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableByteObjectMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableByteObjectMapTest::testToString;
            this.payloads.zip = UnmodifiableByteObjectMapTest::zip;
            this.payloads.zipWithIndex = UnmodifiableByteObjectMapTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableByteObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = UnmodifiableByteObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = UnmodifiableByteObjectMapTest::aggregateBy;
            this.payloads.groupBy = UnmodifiableByteObjectMapTest::groupBy;
            this.payloads.groupByEach = UnmodifiableByteObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableByteObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableByteObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = UnmodifiableByteObjectMapTest::makeString;
            this.payloads.appendString = UnmodifiableByteObjectMapTest::appendString;
            this.payloads.tap = UnmodifiableByteObjectMapTest::tap;
            this.payloads.forEach = UnmodifiableByteObjectMapTest::forEach;
            this.payloads.forEachWithIndex = UnmodifiableByteObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = UnmodifiableByteObjectMapTest::forEachWith;
            this.payloads.toImmutable = UnmodifiableByteObjectMapTest::toImmutable;
            this.payloads.toSortedBag = UnmodifiableByteObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableByteObjectMapTest::toSortedBagBy;
            this.payloads.stream = UnmodifiableByteObjectMapTest::stream;
            this.payloads.parallelStream = UnmodifiableByteObjectMapTest::parallelStream;
            this.payloads.asSynchronized = UnmodifiableByteObjectMapTest::asSynchronized;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::putAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableByteObjectMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableByteObjectMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = UnmodifiableByteObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Value_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getIfAbsentPut_Value_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableByteObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_Function_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getIfAbsentPut_Function_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableByteObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableByteObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.freeze = UnmodifiableByteObjectMapTest::freeze;
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableByteObjectMapTest::contains;
            this.payloads.containsKey = UnmodifiableByteObjectMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableByteObjectMapTest::containsValue;
            this.payloads.size = UnmodifiableByteObjectMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableByteObjectMapTest::asUnmodifiable;
            this.payloads.iterator = UnmodifiableByteObjectMapTest::iterator;
            this.payloads.flipUniqueValues = UnmodifiableByteObjectMapTest::flipUniqueValues;
        }
    }
}
