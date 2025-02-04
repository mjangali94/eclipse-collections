/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.bimap.BiMap;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.IntegerWithCast;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.map.mutable.MutableMapIterableTestCase;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractMutableBiMapTestCase extends MutableMapIterableTestCase {

    public abstract MutableBiMap<Integer, Character> classUnderTest();

    public abstract MutableBiMap<Integer, Character> getEmptyMap();

    @Override
    protected abstract <K, V> MutableBiMap<K, V> newMap();

    @Override
    protected abstract <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    public static void assertBiMapsEqual(BiMap<?, ?> expected, BiMap<?, ?> actual) {
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.inverse(), actual.inverse());
    }

    @Test
    @Override
    public void flip() {
        Verify.assertEmpty(this.newMap().flip());
        MutableSetMultimap<Integer, String> expected = UnifiedSetMultimap.newMultimap();
        expected.put(1, "One");
        expected.put(2, "Two");
        expected.put(3, "Three");
        expected.put(4, "Four");
        Assert.assertEquals(expected, this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, "Four", 4).flip());
    }

    @Test
    public void size() {
        Verify.assertSize(3, this.classUnderTest());
        Verify.assertSize(0, this.getEmptyMap());
    }

    @Test
    public void forcePut() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertNull(biMap.forcePut(4, 'd'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertNull(biMap.forcePut(1, null));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertNull(biMap.forcePut(1, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'e', null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertNull(biMap.forcePut(5, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(5, 'e', null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertEquals(Character.valueOf('d'), biMap.forcePut(4, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(4, 'e', null, 'b', 3, 'c'), biMap);
        HashBiMap<Integer, Character> actual = HashBiMap.newMap();
        actual.forcePut(1, null);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null), actual);
    }

    @Override
    @Test
    public void put() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertNull(biMap.put(4, 'd'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertNull(biMap.put(1, null));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertNull(biMap.put(1, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'e', null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertThrows(IllegalArgumentException.class, () -> biMap.put(5, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'e', null, 'b', 3, 'c', 4, 'd'), biMap);
        Assert.assertThrows(IllegalArgumentException.class, () -> biMap.put(4, 'e'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'e', null, 'b', 3, 'c', 4, 'd'), biMap);
        HashBiMap<Integer, Character> actual = HashBiMap.newMap();
        actual.put(1, null);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null), actual);
    }

    @Override
    @Test
    public void flipUniqueValues() {
        MutableBiMap<Integer, Character> map = this.classUnderTest();
        MutableBiMap<Character, Integer> result = map.flipUniqueValues();
        Assert.assertEquals(map.inverse(), result);
        Assert.assertNotSame(map.inverse(), result);
        result.put('d', 4);
        Assert.assertEquals(this.classUnderTest(), map);
    }

    @Test
    public void get() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertNull(biMap.get(1));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertNull(biMap.get(4));
        Assert.assertNull(biMap.put(4, 'd'));
        Assert.assertNull(biMap.get(1));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertEquals(Character.valueOf('d'), biMap.get(4));
        Assert.assertNull(biMap.put(1, null));
        Assert.assertNull(biMap.get(1));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertEquals(Character.valueOf('d'), biMap.get(4));
        Assert.assertNull(biMap.forcePut(1, 'e'));
        Assert.assertEquals(Character.valueOf('e'), biMap.get(1));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertEquals(Character.valueOf('d'), biMap.get(4));
        Assert.assertNull(biMap.forcePut(5, 'e'));
        Assert.assertNull(biMap.get(1));
        Assert.assertEquals(Character.valueOf('e'), biMap.get(5));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertEquals(Character.valueOf('d'), biMap.get(4));
        Assert.assertEquals(Character.valueOf('d'), biMap.forcePut(4, 'e'));
        Assert.assertNull(biMap.get(1));
        Assert.assertNull(biMap.get(5));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertEquals(Character.valueOf('e'), biMap.get(4));
        HashBiMap<Integer, Character> actual = HashBiMap.newMap();
        Assert.assertNull(actual.get(1));
        actual.put(1, null);
        Assert.assertNull(actual.get(1));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertTrue(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertFalse(biMap.containsKey(4));
        Assert.assertNull(biMap.put(4, 'd'));
        Assert.assertTrue(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertTrue(biMap.containsKey(4));
        Assert.assertNull(biMap.put(1, null));
        Assert.assertTrue(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertTrue(biMap.containsKey(4));
        Assert.assertNull(biMap.forcePut(1, 'e'));
        Assert.assertTrue(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertTrue(biMap.containsKey(4));
        Assert.assertNull(biMap.forcePut(5, 'e'));
        Assert.assertFalse(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(5));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertTrue(biMap.containsKey(4));
        Assert.assertEquals(Character.valueOf('d'), biMap.forcePut(4, 'e'));
        Assert.assertFalse(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertTrue(biMap.containsKey(4));
        Assert.assertFalse(biMap.containsKey(5));
        HashBiMap<Integer, Character> actual = HashBiMap.newMap();
        actual.put(1, null);
        Assert.assertTrue(actual.containsKey(1));
        Assert.assertFalse(actual.containsKey(0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertTrue(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertFalse(biMap.containsValue('d'));
        Assert.assertNull(biMap.put(4, 'd'));
        Assert.assertTrue(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertTrue(biMap.containsValue('d'));
        Assert.assertNull(biMap.put(1, null));
        Assert.assertTrue(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertTrue(biMap.containsValue('d'));
        Assert.assertNull(biMap.forcePut(1, 'e'));
        Assert.assertTrue(biMap.containsValue('e'));
        Assert.assertFalse(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertTrue(biMap.containsValue('d'));
        Assert.assertNull(biMap.forcePut(5, 'e'));
        Assert.assertFalse(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('e'));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertTrue(biMap.containsValue('d'));
        Assert.assertEquals(Character.valueOf('d'), biMap.forcePut(4, 'e'));
        Assert.assertFalse(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('e'));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertFalse(biMap.containsValue('d'));
        HashBiMap<Integer, Character> actual = HashBiMap.newMap();
        actual.put(1, null);
        Assert.assertTrue(actual.containsValue(null));
        Assert.assertFalse(actual.containsValue('\0'));
    }

    @Override
    @Test
    public void putAll() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        biMap.putAll(UnifiedMap.newMap());
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c'), biMap);
        biMap.putAll(UnifiedMap.newWithKeysValues(1, null, null, 'b', 3, 'c'));
        HashBiMap<Integer, Character> expected = HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c');
        Assert.assertEquals(expected, biMap);
        biMap.putAll(UnifiedMap.newWithKeysValues(4, 'd', 5, 'e', 6, 'f'));
        expected.put(4, 'd');
        expected.put(5, 'e');
        expected.put(6, 'f');
        Assert.assertEquals(expected, biMap);
    }

    @Test
    public void remove() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertNull(biMap.remove(4));
        Verify.assertSize(3, biMap);
        Assert.assertNull(biMap.remove(1));
        Assert.assertNull(biMap.get(1));
        Assert.assertNull(biMap.inverse().get(null));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(null, 'b', 3, 'c'), biMap);
        Assert.assertEquals(Character.valueOf('b'), biMap.remove(null));
        Assert.assertNull(biMap.get(null));
        Assert.assertNull(biMap.inverse().get('b'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(3, 'c'), biMap);
        Assert.assertEquals(Character.valueOf('c'), biMap.remove(3));
        Assert.assertNull(biMap.get(3));
        Assert.assertNull(biMap.inverse().get('c'));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newMap(), biMap);
        Verify.assertEmpty(biMap);
        Assert.assertNull(HashBiMap.newMap().remove(1));
    }

    @Override
    @Test
    public void clear() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        biMap.clear();
        Verify.assertEmpty(biMap);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newMap(), biMap);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        String actualString = HashBiMap.newWithKeysValues(1, null, 2, 'b').toString();
        Assert.assertTrue("{1=null, 2=b}".equals(actualString) || "{2=b, 1=null}".equals(actualString));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableBiMap<Integer, Character> emptyMap = this.getEmptyMap();
        Verify.assertEqualsAndHashCode(UnifiedMap.newMap(), emptyMap);
        Assert.assertEquals(emptyMap, emptyMap);
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues(1, null, null, 'b', 3, 'c'), this.classUnderTest());
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues(null, 'b', 1, null, 3, 'c'), this.classUnderTest());
        Assert.assertNotEquals(HashBiMap.newWithKeysValues(null, 1, 'b', null, 'c', 3), this.classUnderTest());
        Verify.assertEqualsAndHashCode(HashBiMap.newWithKeysValues(null, 1, 'b', null, 'c', 3), this.classUnderTest().inverse());
    }

    @Override
    @Test
    public void nullCollisionWithCastInEquals() {
        MutableBiMap<IntegerWithCast, String> mutableMap = this.newMap();
        mutableMap.put(new IntegerWithCast(0), "Test 2");
        mutableMap.forcePut(new IntegerWithCast(0), "Test 3");
        mutableMap.put(null, "Test 1");
        Assert.assertEquals(this.newMapWithKeysValues(new IntegerWithCast(0), "Test 3", null, "Test 1"), mutableMap);
        Assert.assertEquals("Test 3", mutableMap.get(new IntegerWithCast(0)));
        Assert.assertEquals("Test 1", mutableMap.get(null));
    }

    @Override
    @Test
    public void iterator() {
        MutableSet<Character> expected = UnifiedSet.newSetWith(null, 'b', 'c');
        MutableSet<Character> actual = UnifiedSet.newSet();
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Iterator<Character> iterator = biMap.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
        Verify.assertSize(3, biMap);
        Verify.assertSize(3, biMap.inverse());
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Iterator<Character> iteratorRemove = biMap.iterator();
        Assert.assertTrue(iteratorRemove.hasNext());
        Character first = iteratorRemove.next();
        iteratorRemove.remove();
        MutableBiMap<Integer, Character> expectedMap = this.classUnderTest();
        expectedMap.inverse().remove(first);
        Assert.assertEquals(expectedMap, biMap);
        Assert.assertEquals(expectedMap.inverse(), biMap.inverse());
        Verify.assertSize(2, biMap);
        Verify.assertSize(2, biMap.inverse());
        Assert.assertTrue(iteratorRemove.hasNext());
        Character second = iteratorRemove.next();
        iteratorRemove.remove();
        expectedMap.inverse().remove(second);
        Assert.assertEquals(expectedMap, biMap);
        Assert.assertEquals(expectedMap.inverse(), biMap.inverse());
        Verify.assertSize(1, biMap);
        Verify.assertSize(1, biMap.inverse());
        Assert.assertTrue(iteratorRemove.hasNext());
        Character third = iteratorRemove.next();
        iteratorRemove.remove();
        expectedMap.inverse().remove(third);
        Assert.assertEquals(expectedMap, biMap);
        Assert.assertEquals(expectedMap.inverse(), biMap.inverse());
        Verify.assertEmpty(biMap);
        Verify.assertEmpty(biMap.inverse());
        Assert.assertFalse(iteratorRemove.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iteratorRemove::next);
    }

    @Override
    @Test
    public void withMapNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.newMap().withMap(null));
    }

    @Override
    @Test
    public void updateValueWith() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Function2<Character, Boolean, Character> toUpperOrLowerCase = (character, parameter) -> parameter ? Character.toUpperCase(character) : Character.toLowerCase(character);
        Assert.assertEquals(Character.valueOf('D'), biMap.updateValueWith(4, () -> 'd', toUpperOrLowerCase, true));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'D'), biMap);
        Assert.assertEquals(Character.valueOf('B'), biMap.updateValueWith(null, () -> 'd', toUpperOrLowerCase, true));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'B', 3, 'c', 4, 'D'), biMap);
        Assert.assertEquals(Character.valueOf('d'), biMap.updateValueWith(4, () -> 'x', toUpperOrLowerCase, false));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'B', 3, 'c', 4, 'd'), biMap);
    }

    @Override
    @Test
    public void updateValue() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertEquals(Character.valueOf('D'), biMap.updateValue(4, () -> 'd', Character::toUpperCase));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'b', 3, 'c', 4, 'D'), biMap);
        Assert.assertEquals(Character.valueOf('B'), biMap.updateValue(null, () -> 'd', Character::toUpperCase));
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, null, null, 'B', 3, 'c', 4, 'D'), biMap);
    }

    @Override
    @Test
    public void updateValue_collisions() {
        // testing collisions not applicable here
    }

    @Override
    @Test
    public void updateValueWith_collisions() {
        // testing collisions not applicable here
    }

    @Override
    public void toImmutable() {
        ImmutableBiMap<Integer, Character> expectedImmutableBiMap = BiMaps.immutable.of(null, 'b', 1, null, 3, 'c');
        ImmutableBiMap<Integer, Character> characters = this.classUnderTest().toImmutable();
        Assert.assertEquals(expectedImmutableBiMap, characters);
    }

    @Test
    public void testClone() {
        MutableBiMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        MutableBiMap<Integer, String> clone = map.clone();
        Assert.assertNotSame(map, clone);
        Verify.assertEqualsAndHashCode(map, clone);
    }

    @Test
    public void into() {
        MutableBiMap<Integer, Character> map = this.newMapWithKeysValues(1, 'a', 2, 'b');
        MutableSet<Character> target = Sets.mutable.of('c');
        map.into(target);
        Verify.assertSetsEqual(Sets.mutable.of('a', 'b', 'c'), target);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableBiMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
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
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
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
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
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
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
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
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
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
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
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
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forcePut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forcePut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_into() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.into);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableBiMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBiMapTestCase> into;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = AbstractMutableBiMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableBiMapTestCase::parallelStream;
            this.payloads.serialization = AbstractMutableBiMapTestCase::serialization;
            this.payloads.isEmpty = AbstractMutableBiMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableBiMapTestCase::notEmpty;
            this.payloads.ifPresentApply = AbstractMutableBiMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = AbstractMutableBiMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = AbstractMutableBiMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = AbstractMutableBiMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = AbstractMutableBiMapTestCase::getIfAbsentWith;
            this.payloads.tap = AbstractMutableBiMapTestCase::tap;
            this.payloads.forEach = AbstractMutableBiMapTestCase::forEach;
            this.payloads.forEachWith = AbstractMutableBiMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractMutableBiMapTestCase::forEachWithIndex;
            this.payloads.forEachKey = AbstractMutableBiMapTestCase::forEachKey;
            this.payloads.forEachValue = AbstractMutableBiMapTestCase::forEachValue;
            this.payloads.forEachKeyValue = AbstractMutableBiMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableBiMapTestCase::injectIntoKeyValue;
            this.payloads.collectMap = AbstractMutableBiMapTestCase::collectMap;
            this.payloads.collectBoolean = AbstractMutableBiMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractMutableBiMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = AbstractMutableBiMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractMutableBiMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = AbstractMutableBiMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractMutableBiMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = AbstractMutableBiMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractMutableBiMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = AbstractMutableBiMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractMutableBiMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = AbstractMutableBiMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractMutableBiMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = AbstractMutableBiMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractMutableBiMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = AbstractMutableBiMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractMutableBiMapTestCase::collectShortWithTarget;
            this.payloads.collectValues = AbstractMutableBiMapTestCase::collectValues;
            this.payloads.select = AbstractMutableBiMapTestCase::select;
            this.payloads.selectWith = AbstractMutableBiMapTestCase::selectWith;
            this.payloads.reject = AbstractMutableBiMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableBiMapTestCase::rejectWith;
            this.payloads.collect = AbstractMutableBiMapTestCase::collect;
            this.payloads.flatCollect = AbstractMutableBiMapTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractMutableBiMapTestCase::flatCollectWith;
            this.payloads.selectMap = AbstractMutableBiMapTestCase::selectMap;
            this.payloads.rejectMap = AbstractMutableBiMapTestCase::rejectMap;
            this.payloads.detect = AbstractMutableBiMapTestCase::detect;
            this.payloads.detectOptional = AbstractMutableBiMapTestCase::detectOptional;
            this.payloads.anySatisfy = AbstractMutableBiMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableBiMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableBiMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableBiMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableBiMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableBiMapTestCase::noneSatisfyWith;
            this.payloads.appendString = AbstractMutableBiMapTestCase::appendString;
            this.payloads.toBag = AbstractMutableBiMapTestCase::toBag;
            this.payloads.toSortedBag = AbstractMutableBiMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableBiMapTestCase::toSortedBagBy;
            this.payloads.asLazy = AbstractMutableBiMapTestCase::asLazy;
            this.payloads.toList = AbstractMutableBiMapTestCase::toList;
            this.payloads.toMap = AbstractMutableBiMapTestCase::toMap;
            this.payloads.toSet = AbstractMutableBiMapTestCase::toSet;
            this.payloads.toSortedList = AbstractMutableBiMapTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractMutableBiMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = AbstractMutableBiMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = AbstractMutableBiMapTestCase::toSortedSetBy;
            this.payloads.toSortedMap = AbstractMutableBiMapTestCase::toSortedMap;
            this.payloads.chunk = AbstractMutableBiMapTestCase::chunk;
            this.payloads.collect_value = AbstractMutableBiMapTestCase::collect_value;
            this.payloads.collectIf = AbstractMutableBiMapTestCase::collectIf;
            this.payloads.collectWith = AbstractMutableBiMapTestCase::collectWith;
            this.payloads.collectWithToTarget = AbstractMutableBiMapTestCase::collectWithToTarget;
            this.payloads.contains = AbstractMutableBiMapTestCase::contains;
            this.payloads.containsAnyIterable = AbstractMutableBiMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractMutableBiMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = AbstractMutableBiMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractMutableBiMapTestCase::containsNoneCollection;
            this.payloads.containsAll = AbstractMutableBiMapTestCase::containsAll;
            this.payloads.getFirst = AbstractMutableBiMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableBiMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableBiMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBiMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBiMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableBiMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = AbstractMutableBiMapTestCase::containsAllArguments;
            this.payloads.count = AbstractMutableBiMapTestCase::count;
            this.payloads.countWith = AbstractMutableBiMapTestCase::countWith;
            this.payloads.detect_value = AbstractMutableBiMapTestCase::detect_value;
            this.payloads.detectOptional_value = AbstractMutableBiMapTestCase::detectOptional_value;
            this.payloads.detectWith = AbstractMutableBiMapTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractMutableBiMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = AbstractMutableBiMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = AbstractMutableBiMapTestCase::detectWithIfNone;
            this.payloads.flatten_value = AbstractMutableBiMapTestCase::flatten_value;
            this.payloads.countBy = AbstractMutableBiMapTestCase::countBy;
            this.payloads.countByWith = AbstractMutableBiMapTestCase::countByWith;
            this.payloads.countByEach = AbstractMutableBiMapTestCase::countByEach;
            this.payloads.groupBy = AbstractMutableBiMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableBiMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableBiMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBiMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableBiMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBiMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = AbstractMutableBiMapTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractMutableBiMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractMutableBiMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = AbstractMutableBiMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = AbstractMutableBiMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = AbstractMutableBiMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableBiMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = AbstractMutableBiMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = AbstractMutableBiMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = AbstractMutableBiMapTestCase::sumOfDouble;
            this.payloads.sumByInt = AbstractMutableBiMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableBiMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableBiMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableBiMapTestCase::sumByDouble;
            this.payloads.makeString = AbstractMutableBiMapTestCase::makeString;
            this.payloads.min = AbstractMutableBiMapTestCase::min;
            this.payloads.max = AbstractMutableBiMapTestCase::max;
            this.payloads.minBy = AbstractMutableBiMapTestCase::minBy;
            this.payloads.maxBy = AbstractMutableBiMapTestCase::maxBy;
            this.payloads.reject_value = AbstractMutableBiMapTestCase::reject_value;
            this.payloads.rejectWith_value = AbstractMutableBiMapTestCase::rejectWith_value;
            this.payloads.select_value = AbstractMutableBiMapTestCase::select_value;
            this.payloads.selectWith_value = AbstractMutableBiMapTestCase::selectWith_value;
            this.payloads.partition_value = AbstractMutableBiMapTestCase::partition_value;
            this.payloads.partitionWith_value = AbstractMutableBiMapTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = AbstractMutableBiMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = AbstractMutableBiMapTestCase::toArray;
            this.payloads.zip = AbstractMutableBiMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableBiMapTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = AbstractMutableBiMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractMutableBiMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = AbstractMutableBiMapTestCase::keyValuesView;
            this.payloads.testNewMap = AbstractMutableBiMapTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = AbstractMutableBiMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = AbstractMutableBiMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = AbstractMutableBiMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = AbstractMutableBiMapTestCase::newMapWithWithWithWith;
            this.payloads.keysView = AbstractMutableBiMapTestCase::keysView;
            this.payloads.valuesView = AbstractMutableBiMapTestCase::valuesView;
            this.payloads.test_toString = AbstractMutableBiMapTestCase::test_toString;
            this.payloads.toImmutable = AbstractMutableBiMapTestCase::toImmutable;
            this.payloads.removeObject = AbstractMutableBiMapTestCase::removeObject;
            this.payloads.removeFromEntrySet = AbstractMutableBiMapTestCase::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = AbstractMutableBiMapTestCase::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = AbstractMutableBiMapTestCase::retainAllFromEntrySet;
            this.payloads.clearEntrySet = AbstractMutableBiMapTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = AbstractMutableBiMapTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = AbstractMutableBiMapTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = AbstractMutableBiMapTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = AbstractMutableBiMapTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = AbstractMutableBiMapTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = AbstractMutableBiMapTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = AbstractMutableBiMapTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = AbstractMutableBiMapTestCase::keySetToArray;
            this.payloads.removeFromValues = AbstractMutableBiMapTestCase::removeFromValues;
            this.payloads.removeNullFromValues = AbstractMutableBiMapTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = AbstractMutableBiMapTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = AbstractMutableBiMapTestCase::retainAllFromValues;
            this.payloads.removeKey = AbstractMutableBiMapTestCase::removeKey;
            this.payloads.removeAllKeys = AbstractMutableBiMapTestCase::removeAllKeys;
            this.payloads.removeIf = AbstractMutableBiMapTestCase::removeIf;
            this.payloads.getIfAbsentPut = AbstractMutableBiMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = AbstractMutableBiMapTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableBiMapTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = AbstractMutableBiMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = AbstractMutableBiMapTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = AbstractMutableBiMapTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = AbstractMutableBiMapTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = AbstractMutableBiMapTestCase::newEmpty;
            this.payloads.keysAndValues_toString = AbstractMutableBiMapTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = AbstractMutableBiMapTestCase::keyPreservation;
            this.payloads.asUnmodifiable = AbstractMutableBiMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableBiMapTestCase::asSynchronized;
            this.payloads.add = AbstractMutableBiMapTestCase::add;
            this.payloads.putPair = AbstractMutableBiMapTestCase::putPair;
            this.payloads.withKeyValue = AbstractMutableBiMapTestCase::withKeyValue;
            this.payloads.withMap = AbstractMutableBiMapTestCase::withMap;
            this.payloads.withMapEmpty = AbstractMutableBiMapTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = AbstractMutableBiMapTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = AbstractMutableBiMapTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = AbstractMutableBiMapTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = AbstractMutableBiMapTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = AbstractMutableBiMapTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = AbstractMutableBiMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = AbstractMutableBiMapTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = AbstractMutableBiMapTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = AbstractMutableBiMapTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = AbstractMutableBiMapTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = AbstractMutableBiMapTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = AbstractMutableBiMapTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = AbstractMutableBiMapTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = AbstractMutableBiMapTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = AbstractMutableBiMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableBiMapTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = AbstractMutableBiMapTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = AbstractMutableBiMapTestCase::rehash_null_collision;
            this.payloads.flip = AbstractMutableBiMapTestCase::flip;
            this.payloads.size = AbstractMutableBiMapTestCase::size;
            this.payloads.forcePut = AbstractMutableBiMapTestCase::forcePut;
            this.payloads.put = AbstractMutableBiMapTestCase::put;
            this.payloads.flipUniqueValues = AbstractMutableBiMapTestCase::flipUniqueValues;
            this.payloads.get = AbstractMutableBiMapTestCase::get;
            this.payloads.containsKey = AbstractMutableBiMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableBiMapTestCase::containsValue;
            this.payloads.putAll = AbstractMutableBiMapTestCase::putAll;
            this.payloads.remove = AbstractMutableBiMapTestCase::remove;
            this.payloads.clear = AbstractMutableBiMapTestCase::clear;
            this.payloads.testToString = AbstractMutableBiMapTestCase::testToString;
            this.payloads.equalsAndHashCode = AbstractMutableBiMapTestCase::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = AbstractMutableBiMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.iterator = AbstractMutableBiMapTestCase::iterator;
            this.payloads.withMapNull = AbstractMutableBiMapTestCase::withMapNull;
            this.payloads.updateValueWith = AbstractMutableBiMapTestCase::updateValueWith;
            this.payloads.updateValue = AbstractMutableBiMapTestCase::updateValue;
            this.payloads.updateValue_collisions = AbstractMutableBiMapTestCase::updateValue_collisions;
            this.payloads.updateValueWith_collisions = AbstractMutableBiMapTestCase::updateValueWith_collisions;
            this.payloads.testClone = AbstractMutableBiMapTestCase::testClone;
            this.payloads.into = AbstractMutableBiMapTestCase::into;
        }
    }
}
