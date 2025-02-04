/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.immutable;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableEmptySortedMap}.
 */
public class ImmutableEmptySortedMapTest extends ImmutableSortedMapTestCase {

    @Override
    protected ImmutableSortedMap<Integer, String> classUnderTest() {
        return SortedMaps.immutable.of();
    }

    @Override
    protected ImmutableSortedMap<Integer, String> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedMaps.immutable.of(comparator);
    }

    @Override
    protected <K, V> MapIterable<K, V> newMap() {
        return SortedMaps.immutable.of();
    }

    @Override
    protected <K, V> MapIterable<K, V> newMapWithKeyValue(K key1, V value1) {
        return SortedMaps.immutable.of(key1, value1);
    }

    @Override
    protected <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return SortedMaps.immutable.of(key1, value1, key2, value2);
    }

    @Override
    protected <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return SortedMaps.immutable.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return SortedMaps.immutable.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected int size() {
        return 0;
    }

    @Override
    public void flipUniqueValues() {
        Verify.assertEmpty(this.classUnderTest().flipUniqueValues());
    }

    @Override
    @Test
    public void testToString() {
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        Assert.assertEquals("{}", map.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void firstKey() {
        new ImmutableEmptySortedMap<>().firstKey();
    }

    @Test(expected = NoSuchElementException.class)
    public void lastKey() {
        new ImmutableEmptySortedMap<>().lastKey();
    }

    @Override
    @Test
    public void get() {
        // Cannot call super.get() as map is empty and present key behavior does not exist.
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Integer absentKey = this.size() + 1;
        Assert.assertNull(classUnderTest.get(absentKey));
        String absentValue = String.valueOf(absentKey);
        Assert.assertFalse(classUnderTest.containsValue(absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getOrDefault(absentKey, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsent(absentKey, new PassThruFunction0<>(absentValue)));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        super.getIfAbsentWith();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentWith(absentKey, String::valueOf, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void ifPresentApply() {
        super.ifPresentApply();
        Integer absentKey = this.size() + 1;
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertNull(classUnderTest.ifPresentApply(absentKey, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        // Cannot call super.notEmpty() as map is empty.
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        ImmutableSortedMap<String, String> map = new ImmutableEmptySortedMap<>();
        Assert.assertTrue(map.allSatisfy(String.class::isInstance));
        Assert.assertTrue(map.allSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        ImmutableSortedMap<String, String> map = new ImmutableEmptySortedMap<>();
        Assert.assertTrue(map.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        ImmutableSortedMap<String, String> map = new ImmutableEmptySortedMap<>();
        Assert.assertFalse(map.anySatisfy(String.class::isInstance));
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        super.max();
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        super.maxBy();
        this.classUnderTest().maxBy(Functions.getStringPassThru());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        super.min();
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        super.minBy();
        this.classUnderTest().minBy(Functions.getStringPassThru());
    }

    @Override
    @Test
    public void selectMap() {
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> actual = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptySortedMap.class, actual);
        Assert.assertSame(ImmutableEmptySortedMap.INSTANCE, actual);
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedMap<Integer, String> revActual = revMap.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptySortedMap.class, revActual);
        Assert.assertSame(revMap.comparator(), revActual.comparator());
    }

    @Override
    @Test
    public void rejectMap() {
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> actual = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptySortedMap.class, actual);
        Assert.assertSame(ImmutableEmptySortedMap.INSTANCE, actual);
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedMap<Integer, String> revActual = revMap.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptySortedMap.class, revActual);
        Assert.assertSame(revMap.comparator(), revActual.comparator());
    }

    @Override
    @Test
    public void collectMap() {
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(Comparators.reverseNaturalOrder());
        Function2<Integer, String, Pair<Integer, String>> alwaysTrueFunction = Tuples::pair;
        ImmutableMap<Integer, String> collect = map.collect(alwaysTrueFunction);
        ImmutableMap<Integer, String> revCollect = revMap.collect(alwaysTrueFunction);
        Verify.assertEmpty(collect);
        Assert.assertSame(collect, revCollect);
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndex() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.empty(), integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.empty(), integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Override
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.empty(), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Override
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.empty(), integers.rejectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.detect((ignored1, ignored2) -> true));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertFalse(map.containsKey(0));
        Assert.assertFalse(revMap.containsKey(1));
    }

    @Test
    public void values() {
        SortedMap<Integer, String> map = (ImmutableEmptySortedMap<Integer, String>) this.classUnderTest();
        SortedMap<Integer, String> revMap = (ImmutableEmptySortedMap<Integer, String>) this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertEmpty(map.values());
        Assert.assertSame(Lists.immutable.of(), map.values());
        Verify.assertEmpty(revMap.values());
        Assert.assertSame(Lists.immutable.of(), revMap.values());
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> deserialized = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertSame(ImmutableEmptySortedMap.INSTANCE, map);
        Assert.assertSame(map, deserialized);
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedMap<Integer, String> revDeserialized = SerializeTestHelper.serializeDeserialize(revMap);
        Verify.assertInstanceOf(ImmutableSortedMap.class, revDeserialized);
        Assert.assertNotNull(revDeserialized.comparator());
    }

    @Override
    @Test
    public void keyValuesView() {
        super.keyValuesView();
        Assert.assertTrue(this.classUnderTest().keyValuesView().isEmpty());
    }

    @Override
    @Test
    public void take() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().take(2));
    }

    @Override
    @Test
    public void drop() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().drop(2));
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptySortedMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
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
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValuePairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValuePairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptySortedMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> castToSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getIfAbsentValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableEmptySortedMapTest::stream;
            this.payloads.parallelStream = ImmutableEmptySortedMapTest::parallelStream;
            this.payloads.isEmpty = ImmutableEmptySortedMapTest::isEmpty;
            this.payloads.getIfAbsent_function = ImmutableEmptySortedMapTest::getIfAbsent_function;
            this.payloads.injectIntoKeyValue = ImmutableEmptySortedMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableEmptySortedMapTest::flipUniqueValues;
            this.payloads.collectBoolean = ImmutableEmptySortedMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableEmptySortedMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableEmptySortedMapTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableEmptySortedMapTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableEmptySortedMapTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableEmptySortedMapTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableEmptySortedMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableEmptySortedMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableEmptySortedMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableEmptySortedMapTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableEmptySortedMapTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableEmptySortedMapTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableEmptySortedMapTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableEmptySortedMapTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableEmptySortedMapTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableEmptySortedMapTest::collectShortWithTarget;
            this.payloads.select = ImmutableEmptySortedMapTest::select;
            this.payloads.selectWith = ImmutableEmptySortedMapTest::selectWith;
            this.payloads.reject = ImmutableEmptySortedMapTest::reject;
            this.payloads.rejectWith = ImmutableEmptySortedMapTest::rejectWith;
            this.payloads.collect = ImmutableEmptySortedMapTest::collect;
            this.payloads.flatCollect = ImmutableEmptySortedMapTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableEmptySortedMapTest::flatCollectWith;
            this.payloads.flip = ImmutableEmptySortedMapTest::flip;
            this.payloads.detectOptional = ImmutableEmptySortedMapTest::detectOptional;
            this.payloads.anySatisfyWith = ImmutableEmptySortedMapTest::anySatisfyWith;
            this.payloads.allSatisfyWith = ImmutableEmptySortedMapTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableEmptySortedMapTest::noneSatisfyWith;
            this.payloads.appendString = ImmutableEmptySortedMapTest::appendString;
            this.payloads.toBag = ImmutableEmptySortedMapTest::toBag;
            this.payloads.toSortedBag = ImmutableEmptySortedMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableEmptySortedMapTest::toSortedBagBy;
            this.payloads.asLazy = ImmutableEmptySortedMapTest::asLazy;
            this.payloads.toList = ImmutableEmptySortedMapTest::toList;
            this.payloads.toMap = ImmutableEmptySortedMapTest::toMap;
            this.payloads.toSet = ImmutableEmptySortedMapTest::toSet;
            this.payloads.toSortedList = ImmutableEmptySortedMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptySortedMapTest::toSortedListBy;
            this.payloads.toSortedSet = ImmutableEmptySortedMapTest::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableEmptySortedMapTest::toSortedSetBy;
            this.payloads.chunk = ImmutableEmptySortedMapTest::chunk;
            this.payloads.collect_value = ImmutableEmptySortedMapTest::collect_value;
            this.payloads.collectIf = ImmutableEmptySortedMapTest::collectIf;
            this.payloads.collectWith = ImmutableEmptySortedMapTest::collectWith;
            this.payloads.collectWithToTarget = ImmutableEmptySortedMapTest::collectWithToTarget;
            this.payloads.contains = ImmutableEmptySortedMapTest::contains;
            this.payloads.containsAnyIterable = ImmutableEmptySortedMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableEmptySortedMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableEmptySortedMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableEmptySortedMapTest::containsNoneCollection;
            this.payloads.containsAll = ImmutableEmptySortedMapTest::containsAll;
            this.payloads.containsValue = ImmutableEmptySortedMapTest::containsValue;
            this.payloads.getFirst = ImmutableEmptySortedMapTest::getFirst;
            this.payloads.getLast = ImmutableEmptySortedMapTest::getLast;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableEmptySortedMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableEmptySortedMapTest::containsAllArguments;
            this.payloads.count = ImmutableEmptySortedMapTest::count;
            this.payloads.countWith = ImmutableEmptySortedMapTest::countWith;
            this.payloads.detect_value = ImmutableEmptySortedMapTest::detect_value;
            this.payloads.detectOptional_value = ImmutableEmptySortedMapTest::detectOptional_value;
            this.payloads.detectWith = ImmutableEmptySortedMapTest::detectWith;
            this.payloads.detectWithOptional = ImmutableEmptySortedMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableEmptySortedMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableEmptySortedMapTest::detectWithIfNone;
            this.payloads.flatten_value = ImmutableEmptySortedMapTest::flatten_value;
            this.payloads.countBy = ImmutableEmptySortedMapTest::countBy;
            this.payloads.countByWith = ImmutableEmptySortedMapTest::countByWith;
            this.payloads.countByEach = ImmutableEmptySortedMapTest::countByEach;
            this.payloads.groupBy = ImmutableEmptySortedMapTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptySortedMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableEmptySortedMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableEmptySortedMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableEmptySortedMapTest::injectInto;
            this.payloads.injectIntoInt = ImmutableEmptySortedMapTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableEmptySortedMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableEmptySortedMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableEmptySortedMapTest::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableEmptySortedMapTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableEmptySortedMapTest::sumOfLong;
            this.payloads.testAggregateBy = ImmutableEmptySortedMapTest::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableEmptySortedMapTest::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableEmptySortedMapTest::sumOfDouble;
            this.payloads.sumByInt = ImmutableEmptySortedMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableEmptySortedMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableEmptySortedMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableEmptySortedMapTest::sumByDouble;
            this.payloads.makeString = ImmutableEmptySortedMapTest::makeString;
            this.payloads.reject_value = ImmutableEmptySortedMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableEmptySortedMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableEmptySortedMapTest::select_value;
            this.payloads.selectWith_value = ImmutableEmptySortedMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableEmptySortedMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableEmptySortedMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableEmptySortedMapTest::selectInstancesOf_value;
            this.payloads.toArray = ImmutableEmptySortedMapTest::toArray;
            this.payloads.zip = ImmutableEmptySortedMapTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptySortedMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableEmptySortedMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableEmptySortedMapTest::aggregateByNonMutating;
            this.payloads.nullCollisionWithCastInEquals = ImmutableEmptySortedMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableEmptySortedMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableEmptySortedMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableEmptySortedMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableEmptySortedMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableEmptySortedMapTest::newMapWithWithWithWith;
            this.payloads.test_toString = ImmutableEmptySortedMapTest::test_toString;
            this.payloads.castToSortedMap = ImmutableEmptySortedMapTest::castToSortedMap;
            this.payloads.toSortedMap = ImmutableEmptySortedMapTest::toSortedMap;
            this.payloads.equalsAndHashCode = ImmutableEmptySortedMapTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableEmptySortedMapTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableEmptySortedMapTest::forEachValue;
            this.payloads.tap = ImmutableEmptySortedMapTest::tap;
            this.payloads.forEach = ImmutableEmptySortedMapTest::forEach;
            this.payloads.iterator = ImmutableEmptySortedMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableEmptySortedMapTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableEmptySortedMapTest::forEachKey;
            this.payloads.getIfAbsentValue = ImmutableEmptySortedMapTest::getIfAbsentValue;
            this.payloads.forEachWith = ImmutableEmptySortedMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptySortedMapTest::forEachWithIndex;
            this.payloads.valuesView = ImmutableEmptySortedMapTest::valuesView;
            this.payloads.keysView = ImmutableEmptySortedMapTest::keysView;
            this.payloads.putAll = ImmutableEmptySortedMapTest::putAll;
            this.payloads.clear = ImmutableEmptySortedMapTest::clear;
            this.payloads.entrySet = ImmutableEmptySortedMapTest::entrySet;
            this.payloads.collectValues = ImmutableEmptySortedMapTest::collectValues;
            this.payloads.newWithKeyValue = ImmutableEmptySortedMapTest::newWithKeyValue;
            this.payloads.newWithAllKeyValuePairs = ImmutableEmptySortedMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableEmptySortedMapTest::newWithAllKeyValues;
            this.payloads.newWithMap = ImmutableEmptySortedMapTest::newWithMap;
            this.payloads.newWithMapIterable = ImmutableEmptySortedMapTest::newWithMapIterable;
            this.payloads.newWithoutKey = ImmutableEmptySortedMapTest::newWithoutKey;
            this.payloads.newWithoutAllKeys = ImmutableEmptySortedMapTest::newWithoutAllKeys;
            this.payloads.toImmutable = ImmutableEmptySortedMapTest::toImmutable;
            this.payloads.put = ImmutableEmptySortedMapTest::put;
            this.payloads.remove = ImmutableEmptySortedMapTest::remove;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableEmptySortedMapTest::testToString;
            this.payloads.firstKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::firstKey, java.util.NoSuchElementException.class);
            this.payloads.lastKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::lastKey, java.util.NoSuchElementException.class);
            this.payloads.get = ImmutableEmptySortedMapTest::get;
            this.payloads.getOrDefault = ImmutableEmptySortedMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableEmptySortedMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableEmptySortedMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableEmptySortedMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableEmptySortedMapTest::notEmpty;
            this.payloads.allSatisfy = ImmutableEmptySortedMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableEmptySortedMapTest::noneSatisfy;
            this.payloads.anySatisfy = ImmutableEmptySortedMapTest::anySatisfy;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::max, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::min, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedMapTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.selectMap = ImmutableEmptySortedMapTest::selectMap;
            this.payloads.rejectMap = ImmutableEmptySortedMapTest::rejectMap;
            this.payloads.collectMap = ImmutableEmptySortedMapTest::collectMap;
            this.payloads.collectWithIndex = ImmutableEmptySortedMapTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableEmptySortedMapTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableEmptySortedMapTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableEmptySortedMapTest::rejectWithIndexWithTarget;
            this.payloads.detect = ImmutableEmptySortedMapTest::detect;
            this.payloads.containsKey = ImmutableEmptySortedMapTest::containsKey;
            this.payloads.values = ImmutableEmptySortedMapTest::values;
            this.payloads.serialization = ImmutableEmptySortedMapTest::serialization;
            this.payloads.keyValuesView = ImmutableEmptySortedMapTest::keyValuesView;
            this.payloads.take = ImmutableEmptySortedMapTest::take;
            this.payloads.drop = ImmutableEmptySortedMapTest::drop;
            this.payloads.getOnly = ImmutableEmptySortedMapTest::getOnly;
        }
    }
}
