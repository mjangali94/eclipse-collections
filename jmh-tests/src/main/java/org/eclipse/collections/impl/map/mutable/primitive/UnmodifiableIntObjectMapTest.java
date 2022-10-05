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
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableIntObjectMapTest extends AbstractMutableIntObjectMapTestCase {

    private final UnmodifiableIntObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableIntObjectMap<String> classUnderTest() {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1) {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2) {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3) {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> getEmptyMap() {
        return new UnmodifiableIntObjectMap<>(new IntObjectHashMap<>());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey(5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove(5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put(0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair(0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll() {
        IntObjectHashMap<String> hashMap = IntObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue(1, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey(32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(IntArrayList.newListWith(0, 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair(1, "one")));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals("zero", this.map.get(0));
        Assert.assertEquals("thirtyOne", this.map.get(31));
        Assert.assertEquals("thirtyTwo", this.map.get(32));
        Assert.assertNull(this.map.get(1));
        Assert.assertNull(this.map.get(33));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.getIfAbsent(0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent(31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent(32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws() {
        this.map.getIfAbsentPut(1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws() {
        this.map.getIfAbsentPut(1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith(1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        IntToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        IntToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey(1, toString);
    }

    @Override
    @Test
    public void freeze() {
        MutableIntObjectMap<String> mutableIntObjectMap = this.classUnderTest();
        IntSet frozenSet = mutableIntObjectMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValue(0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValueWith(0, zeroFactory, incrementFunction, 1);
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
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
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
        Assert.assertEquals(1, this.newWithKeysValues(0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues(1, "one").size());
        Assert.assertEquals(2, this.newWithKeysValues(1, "one", 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(0, "zero", 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues(1, "one", 0, "zero", 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(6, "six", 5, "five").size());
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
        Iterator<String> iterator = IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo").withKeyValue(1, "one").asUnmodifiable().iterator();
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
        UnmodifiableIntObjectMap<String> map1 = this.newWithKeysValues(0, "zero", 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
        iterator1.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
    }

    @Override
    @Test
    public void flipUniqueValues() {
        super.flipUniqueValues();
        Verify.assertInstanceOf(UnmodifiableObjectIntMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableIntObjectMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableIntObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPut_Value_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPut_Function_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntObjectMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableIntObjectMapTest::keySet;
            this.payloads.values = UnmodifiableIntObjectMapTest::values;
            this.payloads.select = UnmodifiableIntObjectMapTest::select;
            this.payloads.selectWith = UnmodifiableIntObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = UnmodifiableIntObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = UnmodifiableIntObjectMapTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableIntObjectMapTest::collect;
            this.payloads.collectBoolean = UnmodifiableIntObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = UnmodifiableIntObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = UnmodifiableIntObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = UnmodifiableIntObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = UnmodifiableIntObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = UnmodifiableIntObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = UnmodifiableIntObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = UnmodifiableIntObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = UnmodifiableIntObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = UnmodifiableIntObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = UnmodifiableIntObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = UnmodifiableIntObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = UnmodifiableIntObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = UnmodifiableIntObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = UnmodifiableIntObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = UnmodifiableIntObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = UnmodifiableIntObjectMapTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableIntObjectMapTest::collectWithTarget;
            this.payloads.collectIf = UnmodifiableIntObjectMapTest::collectIf;
            this.payloads.flatCollect = UnmodifiableIntObjectMapTest::flatCollect;
            this.payloads.detect = UnmodifiableIntObjectMapTest::detect;
            this.payloads.detectWith = UnmodifiableIntObjectMapTest::detectWith;
            this.payloads.detectOptional = UnmodifiableIntObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableIntObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableIntObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = UnmodifiableIntObjectMapTest::detectWithIfNone;
            this.payloads.count = UnmodifiableIntObjectMapTest::count;
            this.payloads.countWith = UnmodifiableIntObjectMapTest::countWith;
            this.payloads.anySatisfy = UnmodifiableIntObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableIntObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableIntObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableIntObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableIntObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableIntObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = UnmodifiableIntObjectMapTest::injectInto;
            this.payloads.intInjectInto = UnmodifiableIntObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = UnmodifiableIntObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = UnmodifiableIntObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = UnmodifiableIntObjectMapTest::doubleInjectInto;
            this.payloads.toList = UnmodifiableIntObjectMapTest::toList;
            this.payloads.toSortedList = UnmodifiableIntObjectMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableIntObjectMapTest::toSet;
            this.payloads.toSortedSet = UnmodifiableIntObjectMapTest::toSortedSet;
            this.payloads.toBag = UnmodifiableIntObjectMapTest::toBag;
            this.payloads.toMap = UnmodifiableIntObjectMapTest::toMap;
            this.payloads.toMapTarget = UnmodifiableIntObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableIntObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = UnmodifiableIntObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = UnmodifiableIntObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = UnmodifiableIntObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = UnmodifiableIntObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = UnmodifiableIntObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = UnmodifiableIntObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = UnmodifiableIntObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = UnmodifiableIntObjectMapTest::toArray;
            this.payloads.min = UnmodifiableIntObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = UnmodifiableIntObjectMapTest::maxBy;
            this.payloads.max = UnmodifiableIntObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = UnmodifiableIntObjectMapTest::minBy;
            this.payloads.sumOfInt = UnmodifiableIntObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableIntObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = UnmodifiableIntObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = UnmodifiableIntObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = UnmodifiableIntObjectMapTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableIntObjectMapTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableIntObjectMapTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableIntObjectMapTest::sumByDouble;
            this.payloads.keysView = UnmodifiableIntObjectMapTest::keysView;
            this.payloads.reject = UnmodifiableIntObjectMapTest::reject;
            this.payloads.rejectWith = UnmodifiableIntObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = UnmodifiableIntObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = UnmodifiableIntObjectMapTest::partition;
            this.payloads.partitionWith = UnmodifiableIntObjectMapTest::partitionWith;
            this.payloads.forEachValue = UnmodifiableIntObjectMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableIntObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableIntObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableIntObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = UnmodifiableIntObjectMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableIntObjectMapTest::notEmpty;
            this.payloads.getFirst = UnmodifiableIntObjectMapTest::getFirst;
            this.payloads.getLast = UnmodifiableIntObjectMapTest::getLast;
            this.payloads.getOnly = UnmodifiableIntObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnmodifiableIntObjectMapTest::containsAllIterable;
            this.payloads.containsAll = UnmodifiableIntObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = UnmodifiableIntObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = UnmodifiableIntObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = UnmodifiableIntObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = UnmodifiableIntObjectMapTest::containsNone;
            this.payloads.containsAllArguments = UnmodifiableIntObjectMapTest::containsAllArguments;
            this.payloads.testEquals = UnmodifiableIntObjectMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableIntObjectMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableIntObjectMapTest::testToString;
            this.payloads.zip = UnmodifiableIntObjectMapTest::zip;
            this.payloads.zipWithIndex = UnmodifiableIntObjectMapTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableIntObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = UnmodifiableIntObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = UnmodifiableIntObjectMapTest::aggregateBy;
            this.payloads.groupBy = UnmodifiableIntObjectMapTest::groupBy;
            this.payloads.groupByEach = UnmodifiableIntObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableIntObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableIntObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = UnmodifiableIntObjectMapTest::makeString;
            this.payloads.appendString = UnmodifiableIntObjectMapTest::appendString;
            this.payloads.tap = UnmodifiableIntObjectMapTest::tap;
            this.payloads.forEach = UnmodifiableIntObjectMapTest::forEach;
            this.payloads.forEachWithIndex = UnmodifiableIntObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = UnmodifiableIntObjectMapTest::forEachWith;
            this.payloads.toImmutable = UnmodifiableIntObjectMapTest::toImmutable;
            this.payloads.toSortedBag = UnmodifiableIntObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableIntObjectMapTest::toSortedBagBy;
            this.payloads.stream = UnmodifiableIntObjectMapTest::stream;
            this.payloads.parallelStream = UnmodifiableIntObjectMapTest::parallelStream;
            this.payloads.asSynchronized = UnmodifiableIntObjectMapTest::asSynchronized;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::putAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableIntObjectMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableIntObjectMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = UnmodifiableIntObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Value_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getIfAbsentPut_Value_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableIntObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_Function_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getIfAbsentPut_Function_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableIntObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableIntObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.freeze = UnmodifiableIntObjectMapTest::freeze;
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntObjectMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableIntObjectMapTest::contains;
            this.payloads.containsKey = UnmodifiableIntObjectMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableIntObjectMapTest::containsValue;
            this.payloads.size = UnmodifiableIntObjectMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableIntObjectMapTest::asUnmodifiable;
            this.payloads.iterator = UnmodifiableIntObjectMapTest::iterator;
            this.payloads.flipUniqueValues = UnmodifiableIntObjectMapTest::flipUniqueValues;
        }
    }
}
