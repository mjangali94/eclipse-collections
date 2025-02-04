/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.fixed;

import java.util.Map;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.FixedSizeMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TripletonMap}.
 */
public class TripletonMapTest extends AbstractMemoryEfficientMutableMapTest {

    @Override
    protected MutableMap<String, String> classUnderTest() {
        return new TripletonMap<>("1", "One", "2", "Two", "3", "Three");
    }

    @Override
    protected MutableMap<String, Integer> mixedTypeClassUnderTest() {
        return new TripletonMap<>("1", 1, "2", 2, "3", 3);
    }

    @Override
    public void flip() {
        super.flip();
        MutableMap<String, Integer> degenerateZero = new TripletonMap<>("A", 1, "B", 2, "C", 3);
        MutableMap<String, Integer> degenerateOne = new TripletonMap<>("A", 1, "B", 1, "C", 3);
        MutableMap<String, Integer> degenerateTwo = new TripletonMap<>("A", 1, "B", 1, "C", 1);
        MutableSetMultimap<Integer, String> flipZero = degenerateZero.flip();
        MutableSetMultimap<Integer, String> flipOne = degenerateOne.flip();
        MutableSetMultimap<Integer, String> flipTwo = degenerateTwo.flip();
        Assert.assertEquals(Multimaps.immutable.set.with(1, "A", 2, "B", 3, "C"), flipZero);
        Assert.assertEquals(Multimaps.immutable.set.with(1, "A", 1, "B", 3, "C"), flipOne);
        Assert.assertEquals(Multimaps.immutable.set.with(1, "A", 1, "B", 1, "C"), flipTwo);
        MutableMap<String, Integer> nullValue = new TripletonMap<>("A", 1, "B", 1, "C", null);
        MutableSetMultimap<Integer, String> flipNull = nullValue.flip();
        Assert.assertEquals(Multimaps.immutable.set.with(1, "A", 1, "B", null, "C"), flipNull);
        MutableMap<String, Integer> nullValueAllNull = new TripletonMap<>("A", null, "B", null, "C", null);
        MutableSetMultimap<Integer, String> flipNullAllNull = nullValueAllNull.flip();
        Assert.assertEquals(Multimaps.immutable.set.with(null, "A", null, "B", null, "C"), flipNullAllNull);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue("One"));
    }

    @Override
    @Test
    public void forEachKeyValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        map.forEachKeyValue((key, value) -> collection.add(key + value));
        Assert.assertEquals(FastList.newListWith("1One", "2Two", "3Three"), collection);
    }

    @Test
    public void flipUniqueValues() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        MutableMap<String, Integer> flip = map.flipUniqueValues();
        Verify.assertInstanceOf(TripletonMap.class, flip);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2, "Three", 3), flip);
        Assert.assertThrows(IllegalStateException.class, () -> new TripletonMap<>(1, "One", 2, "One", 3, "Three").flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> new TripletonMap<>(1, "One", 2, "Three", 3, "Three").flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> new TripletonMap<>(1, "One", 2, "Two", 3, "One").flipUniqueValues());
    }

    @Override
    @Test
    public void nonUniqueWithKeyValue() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("2", "2");
        Twin<String> twin3 = Tuples.twin("3", "3");
        TripletonMap<Twin<String>, Twin<String>> map = new TripletonMap<>(twin1, twin1, twin2, twin2, twin3, twin3);
        Twin<String> twin4 = Tuples.twin("1", "1");
        map.withKeyValue(twin4, twin4);
        Twin<String> twin5 = Tuples.twin("2", "2");
        map.withKeyValue(twin5, twin5);
        Twin<String> twin6 = Tuples.twin("3", "3");
        map.withKeyValue(twin6, twin6);
        Assert.assertSame(map.getKey1(), twin1);
        Assert.assertSame(map.getKey2(), twin2);
        Assert.assertSame(map.getKey3(), twin3);
        Assert.assertSame(map.get(twin1), twin4);
        Assert.assertSame(map.get(twin2), twin5);
        Assert.assertSame(map.get(twin3), twin6);
    }

    @Override
    public void withKeyValue() {
        MutableMap<Integer, String> map1 = new TripletonMap<>(1, "A", 2, "B", 3, "C").withKeyValue(4, "D");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A", 2, "B", 3, "C", 4, "D"), map1);
        Verify.assertInstanceOf(UnifiedMap.class, map1);
        MutableMap<Integer, String> map2 = new TripletonMap<>(1, "A", 2, "B", 3, "C");
        MutableMap<Integer, String> map2with = map2.withKeyValue(1, "AA");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B", 3, "C"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    public void withAllKeyValueArguments() {
        MutableMap<Integer, String> map1 = new TripletonMap<>(1, "A", 2, "B", 3, "C").withAllKeyValueArguments(Tuples.pair(1, "AA"), Tuples.pair(4, "D"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B", 3, "C", 4, "D"), map1);
        Verify.assertInstanceOf(UnifiedMap.class, map1);
        MutableMap<Integer, String> map2 = new TripletonMap<>(1, "A", 2, "B", 3, "C");
        MutableMap<Integer, String> map2with = map2.withAllKeyValueArguments(Tuples.pair(1, "AA"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B", 3, "C"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    public void withoutKey() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "A", 2, "B", 3, "C");
        MutableMap<Integer, String> mapWithout1 = map.withoutKey(4);
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutKey(1);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(2, "B", 3, "C"), mapWithout2);
        Verify.assertInstanceOf(DoubletonMap.class, mapWithout2);
    }

    @Override
    public void withoutAllKeys() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "A", 2, "B", 3, "C");
        MutableMap<Integer, String> mapWithout1 = map.withoutAllKeys(FastList.newListWith(4, 5));
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutAllKeys(FastList.newListWith(3, 4));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A", 2, "B"), mapWithout2);
        Verify.assertInstanceOf(DoubletonMap.class, mapWithout2);
    }

    @Override
    @Test
    public void forEachValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        map.forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), collection);
    }

    @Override
    @Test
    public void forEach() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        map.forEach(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        MutableList<Integer> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        map.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1, 2, 3), collection);
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("1", map.getIfAbsentPut(1, new PassThruFunction0<>("1")));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWith(4, String::valueOf, 4));
        Assert.assertEquals("1", map.getIfAbsentPutWith(1, String::valueOf, 1));
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getOrDefault() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getOrDefault(1, "4"));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsent() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsentValue(1, "4"));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void ifPresentApply() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
        Assert.assertEquals("2", map.ifPresentApply(2, Functions.getPassThru()));
        Assert.assertEquals("3", map.ifPresentApply(3, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(new TripletonMap<>(1, "1", 2, "2", 3, "3").notEmpty());
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, Integer> map = new TripletonMap<>(1, 1, 2, 2, 3, 3);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11, 12, 13), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0", "Two", "1", "Three", "2"), result);
    }

    @Override
    @Test
    public void entrySet() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three"), result);
    }

    @Override
    @Test
    public void values() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (String value : map.values()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three"), result);
    }

    @Override
    @Test
    public void keySet() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (Integer key : map.keySet()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1, 2, 3), result);
    }

    @Override
    @Test
    public void testToString() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        Assert.assertEquals("{1=One, 2=Two, 3=Three}", map.toString());
    }

    @Override
    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three"), this.classUnderTest());
    }

    @Override
    @Test
    public void testClone() {
        MutableMap<Integer, String> map = new TripletonMap<>(1, "One", 2, "Two", 3, "Three");
        try {
            Verify.assertShallowClone(map);
        } catch (Exception e) {
            // Suppress if a Java 9 specific exception related to reflection is thrown.
            if (!e.getClass().getCanonicalName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
        }
    }

    @Override
    @Test
    public void select() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.select((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(TripletonMap.class, full);
        Assert.assertEquals(map, full);
        MutableMap<String, String> one = map.select((argument1, argument2) -> "1".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, one);
        Assert.assertEquals(new SingletonMap<>("1", "One"), one);
        MutableMap<String, String> two = map.select((argument1, argument2) -> "2".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, two);
        Assert.assertEquals(new SingletonMap<>("2", "Two"), two);
        MutableMap<String, String> three = map.select((argument1, argument2) -> "3".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, three);
        Assert.assertEquals(new SingletonMap<>("3", "Three"), three);
        MutableMap<String, String> oneAndThree = map.select((argument1, argument2) -> "1".equals(argument1) || "3".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, oneAndThree);
        Assert.assertEquals(new DoubletonMap<>("1", "One", "3", "Three"), oneAndThree);
        MutableMap<String, String> oneAndTwo = map.select((argument1, argument2) -> "1".equals(argument1) || "2".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new DoubletonMap<>("1", "One", "2", "Two"), oneAndTwo);
        MutableMap<String, String> twoAndThree = map.select((argument1, argument2) -> "2".equals(argument1) || "3".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, twoAndThree);
        Assert.assertEquals(new DoubletonMap<>("2", "Two", "3", "Three"), twoAndThree);
    }

    @Override
    @Test
    public void reject() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(TripletonMap.class, full);
        Assert.assertEquals(map, full);
        MutableMap<String, String> one = map.reject((argument1, argument2) -> "2".equals(argument1) || "3".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, one);
        Assert.assertEquals(new SingletonMap<>("1", "One"), one);
        MutableMap<String, String> two = map.reject((argument1, argument2) -> "1".equals(argument1) || "3".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, two);
        Assert.assertEquals(new SingletonMap<>("2", "Two"), two);
        MutableMap<String, String> three = map.reject((argument1, argument2) -> "1".equals(argument1) || "2".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, three);
        Assert.assertEquals(new SingletonMap<>("3", "Three"), three);
        MutableMap<String, String> oneAndThree = map.reject((argument1, argument2) -> "2".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, oneAndThree);
        Assert.assertEquals(new DoubletonMap<>("1", "One", "3", "Three"), oneAndThree);
        MutableMap<String, String> oneAndTwo = map.reject((argument1, argument2) -> "3".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new DoubletonMap<>("1", "One", "2", "Two"), oneAndTwo);
        MutableMap<String, String> twoAndThree = map.reject((argument1, argument2) -> "1".equals(argument1));
        Verify.assertInstanceOf(DoubletonMap.class, twoAndThree);
        Assert.assertEquals(new DoubletonMap<>("2", "Two", "3", "Three"), twoAndThree);
    }

    @Override
    @Test
    public void detect() {
        MutableMap<String, String> map = this.classUnderTest();
        Pair<String, String> one = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair("1", "One"), one);
        Pair<String, String> two = map.detect((argument1, argument2) -> "2".equals(argument1));
        Assert.assertEquals(Tuples.pair("2", "Two"), two);
        Pair<String, String> three = map.detect((argument1, argument2) -> "3".equals(argument1));
        Assert.assertEquals(Tuples.pair("3", "Three"), three);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new TripletonMap<>(key1, value1, key2, value2, null, null);
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new TripletonMap<>(key1, value1, key2, value2, key3, value3);
    }

    @Override
    @Test
    public void iterator() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new TripletonMap<>(1, "1", 2, "2", 3, "3");
        for (String eachValue : map) {
            collection.add(eachValue);
        }
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), collection);
    }

    @Override
    @Test
    public void asLazyKeys() {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void asLazyValues() {
        Assert.assertEquals(Bags.mutable.of("One", "Two", "Three"), this.classUnderTest().valuesView().toBag());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TripletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues_throws);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new TripletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> put_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> putAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> removeKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> removeAllKeys_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collectKeysAndValues_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> testPostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> nonUniqueWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.put_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::put_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::putAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::removeKey_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllKeys_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::removeAllKeys_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.collectKeysAndValues_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::collectKeysAndValues_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = TripletonMapTest::asUnmodifiable;
            this.payloads.asSynchronized = TripletonMapTest::asSynchronized;
            this.payloads.newEmpty = TripletonMapTest::newEmpty;
            this.payloads.toImmutable = TripletonMapTest::toImmutable;
            this.payloads.testPostSerializedEqualsAndHashCode = TripletonMapTest::testPostSerializedEqualsAndHashCode;
            this.payloads.collectValues = TripletonMapTest::collectValues;
            this.payloads.collect = TripletonMapTest::collect;
            this.payloads.allSatisfy = TripletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = TripletonMapTest::noneSatisfy;
            this.payloads.anySatisfy = TripletonMapTest::anySatisfy;
            this.payloads.appendString = TripletonMapTest::appendString;
            this.payloads.toBag = TripletonMapTest::toBag;
            this.payloads.flip = TripletonMapTest::flip;
            this.payloads.asLazy = TripletonMapTest::asLazy;
            this.payloads.toList = TripletonMapTest::toList;
            this.payloads.toMap = TripletonMapTest::toMap;
            this.payloads.toSet = TripletonMapTest::toSet;
            this.payloads.toSortedList = TripletonMapTest::toSortedList;
            this.payloads.toSortedListBy = TripletonMapTest::toSortedListBy;
            this.payloads.chunk = TripletonMapTest::chunk;
            this.payloads.collect_value = TripletonMapTest::collect_value;
            this.payloads.collectIf = TripletonMapTest::collectIf;
            this.payloads.collectWith = TripletonMapTest::collectWith;
            this.payloads.contains = TripletonMapTest::contains;
            this.payloads.getFirst = TripletonMapTest::getFirst;
            this.payloads.getLast = TripletonMapTest::getLast;
            this.payloads.containsAllIterable = TripletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = TripletonMapTest::containsAllArguments;
            this.payloads.count = TripletonMapTest::count;
            this.payloads.detect_value = TripletonMapTest::detect_value;
            this.payloads.detectIfNone_value = TripletonMapTest::detectIfNone_value;
            this.payloads.flatten_value = TripletonMapTest::flatten_value;
            this.payloads.groupBy = TripletonMapTest::groupBy;
            this.payloads.groupByEach = TripletonMapTest::groupByEach;
            this.payloads.injectInto = TripletonMapTest::injectInto;
            this.payloads.makeString = TripletonMapTest::makeString;
            this.payloads.min = TripletonMapTest::min;
            this.payloads.max = TripletonMapTest::max;
            this.payloads.minBy = TripletonMapTest::minBy;
            this.payloads.maxBy = TripletonMapTest::maxBy;
            this.payloads.reject_value = TripletonMapTest::reject_value;
            this.payloads.rejectWith_value = TripletonMapTest::rejectWith_value;
            this.payloads.select_value = TripletonMapTest::select_value;
            this.payloads.selectWith_value = TripletonMapTest::selectWith_value;
            this.payloads.partition_value = TripletonMapTest::partition_value;
            this.payloads.partitionWith_value = TripletonMapTest::partitionWith_value;
            this.payloads.toArray = TripletonMapTest::toArray;
            this.payloads.zip = TripletonMapTest::zip;
            this.payloads.zipWithIndex = TripletonMapTest::zipWithIndex;
            this.payloads.withKeyValue = TripletonMapTest::withKeyValue;
            this.payloads.withAllKeyValueArguments = TripletonMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = TripletonMapTest::withoutKey;
            this.payloads.withoutAllKeys = TripletonMapTest::withoutAllKeys;
            this.payloads.tap = TripletonMapTest::tap;
            this.payloads.containsValue = TripletonMapTest::containsValue;
            this.payloads.forEachKeyValue = TripletonMapTest::forEachKeyValue;
            this.payloads.flipUniqueValues = TripletonMapTest::flipUniqueValues;
            this.payloads.nonUniqueWithKeyValue = TripletonMapTest::nonUniqueWithKeyValue;
            this.payloads.forEachValue = TripletonMapTest::forEachValue;
            this.payloads.forEach = TripletonMapTest::forEach;
            this.payloads.forEachKey = TripletonMapTest::forEachKey;
            this.payloads.getIfAbsentPut = TripletonMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutWith = TripletonMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsent_function = TripletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = TripletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = TripletonMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = TripletonMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = TripletonMapTest::ifPresentApply;
            this.payloads.notEmpty = TripletonMapTest::notEmpty;
            this.payloads.forEachWith = TripletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = TripletonMapTest::forEachWithIndex;
            this.payloads.entrySet = TripletonMapTest::entrySet;
            this.payloads.values = TripletonMapTest::values;
            this.payloads.keySet = TripletonMapTest::keySet;
            this.payloads.testToString = TripletonMapTest::testToString;
            this.payloads.testEqualsAndHashCode = TripletonMapTest::testEqualsAndHashCode;
            this.payloads.testClone = TripletonMapTest::testClone;
            this.payloads.select = TripletonMapTest::select;
            this.payloads.reject = TripletonMapTest::reject;
            this.payloads.detect = TripletonMapTest::detect;
            this.payloads.iterator = TripletonMapTest::iterator;
            this.payloads.asLazyKeys = TripletonMapTest::asLazyKeys;
            this.payloads.asLazyValues = TripletonMapTest::asLazyValues;
            this.payloads.getOnly = TripletonMapTest::getOnly;
        }
    }
}
