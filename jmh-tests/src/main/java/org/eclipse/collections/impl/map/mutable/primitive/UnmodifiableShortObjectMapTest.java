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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableShortObjectMapTest extends AbstractMutableShortObjectMapTestCase {

    private final UnmodifiableShortObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableShortObjectMap<String> classUnderTest() {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1) {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2) {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2, short key3, T value3) {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> getEmptyMap() {
        return new UnmodifiableShortObjectMap<>(new ShortObjectHashMap<>());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey((short) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove((short) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put((short) 0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair((short) 0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll() {
        ShortObjectHashMap<String> hashMap = ShortObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue((short) 1, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey((short) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair((short) 1, "one")));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals("zero", this.map.get((short) 0));
        Assert.assertEquals("thirtyOne", this.map.get((short) 31));
        Assert.assertEquals("thirtyTwo", this.map.get((short) 32));
        Assert.assertNull(this.map.get((short) 1));
        Assert.assertNull(this.map.get((short) 33));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.getIfAbsent((short) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent((short) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent((short) 32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((short) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((short) 33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws() {
        this.map.getIfAbsentPut((short) 1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws() {
        this.map.getIfAbsentPut((short) 1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((short) 0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith((short) 1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        ShortToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((short) 0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        ShortToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey((short) 1, toString);
    }

    @Override
    @Test
    public void freeze() {
        MutableShortObjectMap<String> mutableShortObjectMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortObjectMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValue((short) 0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        this.<Integer>getEmptyMap().updateValueWith((short) 0, zeroFactory, incrementFunction, 1);
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
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertTrue(this.map.containsKey((short) 31));
        Assert.assertTrue(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.containsKey((short) 5));
        Assert.assertFalse(this.map.containsKey((short) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, "one").size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 1, "one", (short) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, "zero", (short) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, "one", (short) 0, "zero", (short) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, "six", (short) 5, "five").size());
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
        Iterator<String> iterator = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo").withKeyValue((short) 1, "one").asUnmodifiable().iterator();
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
        UnmodifiableShortObjectMap<String> map1 = this.newWithKeysValues((short) 0, "zero", (short) 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
        iterator1.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator1::remove);
    }

    @Override
    @Test
    public void flipUniqueValues() {
        super.flipUniqueValues();
        Verify.assertInstanceOf(UnmodifiableObjectShortMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableShortObjectMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKeyThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKeyThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableShortObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPut_Value_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPut_Function_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortObjectMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableShortObjectMapTest::keySet;
            this.payloads.values = UnmodifiableShortObjectMapTest::values;
            this.payloads.select = UnmodifiableShortObjectMapTest::select;
            this.payloads.selectWith = UnmodifiableShortObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = UnmodifiableShortObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = UnmodifiableShortObjectMapTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableShortObjectMapTest::collect;
            this.payloads.collectBoolean = UnmodifiableShortObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = UnmodifiableShortObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = UnmodifiableShortObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = UnmodifiableShortObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = UnmodifiableShortObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = UnmodifiableShortObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = UnmodifiableShortObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = UnmodifiableShortObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = UnmodifiableShortObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = UnmodifiableShortObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = UnmodifiableShortObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = UnmodifiableShortObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = UnmodifiableShortObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = UnmodifiableShortObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = UnmodifiableShortObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = UnmodifiableShortObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = UnmodifiableShortObjectMapTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableShortObjectMapTest::collectWithTarget;
            this.payloads.collectIf = UnmodifiableShortObjectMapTest::collectIf;
            this.payloads.flatCollect = UnmodifiableShortObjectMapTest::flatCollect;
            this.payloads.detect = UnmodifiableShortObjectMapTest::detect;
            this.payloads.detectWith = UnmodifiableShortObjectMapTest::detectWith;
            this.payloads.detectOptional = UnmodifiableShortObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableShortObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableShortObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = UnmodifiableShortObjectMapTest::detectWithIfNone;
            this.payloads.count = UnmodifiableShortObjectMapTest::count;
            this.payloads.countWith = UnmodifiableShortObjectMapTest::countWith;
            this.payloads.anySatisfy = UnmodifiableShortObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableShortObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableShortObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableShortObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableShortObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableShortObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = UnmodifiableShortObjectMapTest::injectInto;
            this.payloads.intInjectInto = UnmodifiableShortObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = UnmodifiableShortObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = UnmodifiableShortObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = UnmodifiableShortObjectMapTest::doubleInjectInto;
            this.payloads.toList = UnmodifiableShortObjectMapTest::toList;
            this.payloads.toSortedList = UnmodifiableShortObjectMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableShortObjectMapTest::toSet;
            this.payloads.toSortedSet = UnmodifiableShortObjectMapTest::toSortedSet;
            this.payloads.toBag = UnmodifiableShortObjectMapTest::toBag;
            this.payloads.toMap = UnmodifiableShortObjectMapTest::toMap;
            this.payloads.toMapTarget = UnmodifiableShortObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableShortObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = UnmodifiableShortObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = UnmodifiableShortObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = UnmodifiableShortObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = UnmodifiableShortObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = UnmodifiableShortObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = UnmodifiableShortObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = UnmodifiableShortObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = UnmodifiableShortObjectMapTest::toArray;
            this.payloads.min = UnmodifiableShortObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = UnmodifiableShortObjectMapTest::maxBy;
            this.payloads.max = UnmodifiableShortObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = UnmodifiableShortObjectMapTest::minBy;
            this.payloads.sumOfInt = UnmodifiableShortObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableShortObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = UnmodifiableShortObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = UnmodifiableShortObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = UnmodifiableShortObjectMapTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableShortObjectMapTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableShortObjectMapTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableShortObjectMapTest::sumByDouble;
            this.payloads.keysView = UnmodifiableShortObjectMapTest::keysView;
            this.payloads.reject = UnmodifiableShortObjectMapTest::reject;
            this.payloads.rejectWith = UnmodifiableShortObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = UnmodifiableShortObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = UnmodifiableShortObjectMapTest::partition;
            this.payloads.partitionWith = UnmodifiableShortObjectMapTest::partitionWith;
            this.payloads.forEachValue = UnmodifiableShortObjectMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableShortObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableShortObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableShortObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = UnmodifiableShortObjectMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableShortObjectMapTest::notEmpty;
            this.payloads.getFirst = UnmodifiableShortObjectMapTest::getFirst;
            this.payloads.getLast = UnmodifiableShortObjectMapTest::getLast;
            this.payloads.getOnly = UnmodifiableShortObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnmodifiableShortObjectMapTest::containsAllIterable;
            this.payloads.containsAll = UnmodifiableShortObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = UnmodifiableShortObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = UnmodifiableShortObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = UnmodifiableShortObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = UnmodifiableShortObjectMapTest::containsNone;
            this.payloads.containsAllArguments = UnmodifiableShortObjectMapTest::containsAllArguments;
            this.payloads.testEquals = UnmodifiableShortObjectMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableShortObjectMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableShortObjectMapTest::testToString;
            this.payloads.zip = UnmodifiableShortObjectMapTest::zip;
            this.payloads.zipWithIndex = UnmodifiableShortObjectMapTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableShortObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = UnmodifiableShortObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = UnmodifiableShortObjectMapTest::aggregateBy;
            this.payloads.groupBy = UnmodifiableShortObjectMapTest::groupBy;
            this.payloads.groupByEach = UnmodifiableShortObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableShortObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableShortObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = UnmodifiableShortObjectMapTest::makeString;
            this.payloads.appendString = UnmodifiableShortObjectMapTest::appendString;
            this.payloads.tap = UnmodifiableShortObjectMapTest::tap;
            this.payloads.forEach = UnmodifiableShortObjectMapTest::forEach;
            this.payloads.forEachWithIndex = UnmodifiableShortObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = UnmodifiableShortObjectMapTest::forEachWith;
            this.payloads.toImmutable = UnmodifiableShortObjectMapTest::toImmutable;
            this.payloads.toSortedBag = UnmodifiableShortObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableShortObjectMapTest::toSortedBagBy;
            this.payloads.stream = UnmodifiableShortObjectMapTest::stream;
            this.payloads.parallelStream = UnmodifiableShortObjectMapTest::parallelStream;
            this.payloads.asSynchronized = UnmodifiableShortObjectMapTest::asSynchronized;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::putAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableShortObjectMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableShortObjectMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = UnmodifiableShortObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Value_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getIfAbsentPut_Value_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableShortObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_Function_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getIfAbsentPut_Function_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableShortObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableShortObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.freeze = UnmodifiableShortObjectMapTest::freeze;
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortObjectMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableShortObjectMapTest::contains;
            this.payloads.containsKey = UnmodifiableShortObjectMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableShortObjectMapTest::containsValue;
            this.payloads.size = UnmodifiableShortObjectMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableShortObjectMapTest::asUnmodifiable;
            this.payloads.iterator = UnmodifiableShortObjectMapTest::iterator;
            this.payloads.flipUniqueValues = UnmodifiableShortObjectMapTest::flipUniqueValues;
        }
    }
}
