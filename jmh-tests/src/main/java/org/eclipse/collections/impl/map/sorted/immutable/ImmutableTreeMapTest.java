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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableTreeMapTest extends ImmutableSortedMapTestCase {

    @Override
    protected ImmutableSortedMap<Integer, String> classUnderTest() {
        return SortedMaps.immutable.of(1, "1", 2, "2", 3, "3", 4, "4");
    }

    @Override
    protected ImmutableSortedMap<Integer, String> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedMaps.immutable.of(comparator, 1, "1", 2, "2", 3, "3", 4, "4");
    }

    @Override
    protected <K, V> MapIterable<K, V> newMap() {
        return new ImmutableTreeMap<>(SortedMaps.mutable.of());
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
        return 4;
    }

    @Override
    public void entrySet() {
        super.entrySet();
        Interval interval = Interval.oneTo(100);
        LazyIterable<Pair<String, Integer>> pairs = interval.collect(Object::toString).zip(interval);
        MutableSortedMap<String, Integer> mutableSortedMap = new TreeSortedMap<>(pairs.toArray(new Pair[] {}));
        ImmutableSortedMap<String, Integer> immutableSortedMap = mutableSortedMap.toImmutable();
        MutableList<Map.Entry<String, Integer>> entries = FastList.newList(immutableSortedMap.castToSortedMap().entrySet());
        MutableList<Map.Entry<String, Integer>> sortedEntries = entries.toSortedListBy(Map.Entry::getKey);
        Assert.assertEquals(sortedEntries, entries);
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
        Assert.assertEquals("{4=4, 3=3, 2=2, 1=1}", this.classUnderTest(Comparators.reverseNaturalOrder()).toString());
        Assert.assertEquals("{}", new ImmutableTreeMap<>(new TreeSortedMap<>()).toString());
    }

    @Test(expected = NullPointerException.class)
    public void nullConstructor() {
        new ImmutableTreeMap<Integer, Integer>(null);
    }

    @Test
    public void firstKey() {
        Assert.assertEquals(Integer.valueOf(1), new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).firstKey());
    }

    @Test(expected = NoSuchElementException.class)
    public void firstKey_throws() {
        new ImmutableTreeMap<>(new TreeSortedMap<>()).firstKey();
    }

    @Test
    public void lastKey() {
        Assert.assertEquals(Integer.valueOf(4), new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).lastKey());
    }

    @Test(expected = NoSuchElementException.class)
    public void lastKey_throws() {
        new ImmutableTreeMap<>(new TreeSortedMap<>()).lastKey();
    }

    @Test
    public void keySet() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        Verify.assertSetsEqual(Sets.mutable.of(1, 2, 3, 4), immutableSortedMap.keySet());
    }

    @Test
    public void keySetContains() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        Set<Integer> keySet = immutableSortedMap.keySet();
        Assert.assertTrue(keySet.contains(1));
        Assert.assertTrue(keySet.contains(2));
        Assert.assertTrue(keySet.contains(4));
        Assert.assertFalse(keySet.contains(0));
        Assert.assertFalse(keySet.contains(5));
    }

    @Test
    public void keySetContainsAll() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        Set<Integer> keySet = immutableSortedMap.keySet();
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(1, 2, 3, 4)));
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(1, 4)));
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(2, 3)));
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(1, 2, 3)));
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(2, 3, 4)));
        Assert.assertTrue(keySet.containsAll(UnifiedSet.newSetWith(1)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith(1, 4, 1, 3, 4)));
        Assert.assertFalse(keySet.containsAll(UnifiedSet.newSetWith(1, 2, 3, 4, 5)));
        Assert.assertFalse(keySet.containsAll(UnifiedSet.newSetWith(0, 1, 2, 3, 4, 5)));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith(0, 1, 4, 1, 3, 4, 0)));
    }

    @Test
    public void keySetIsEmpty() {
        Assert.assertFalse(new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().isEmpty());
        Assert.assertTrue(new ImmutableTreeMap<Integer, String>(SortedMaps.mutable.of()).keySet().isEmpty());
    }

    @Test
    public void keySetToString() {
        Assert.assertEquals("[1, 2, 3, 4]", new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().toString());
        Assert.assertEquals("[1, 2, 3, 4]", new ImmutableTreeMap<>(SortedMaps.mutable.of(4, "4", 3, "3", 2, "2", 1, "1")).keySet().toString());
        Assert.assertEquals("[4, 3, 2, 1]", new ImmutableTreeMap<>(SortedMaps.mutable.of(Comparators.reverseNaturalOrder(), 4, "4", 3, "3", 2, "2", 1, "1")).keySet().toString());
    }

    @Test
    public void keySetEqualsAndHashCode() {
        SortedMap<Integer, String> map = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3"));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(1, 2, 3), map.keySet());
    }

    @Test
    public void keySetToArray() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        MutableList<Integer> expected = FastList.newListWith(1, 2, 3, 4).toSortedList();
        Set<Integer> keySet = immutableSortedMap.keySet();
        Object[] array = keySet.toArray();
        Assert.assertEquals(expected, FastList.newListWith(keySet.toArray()).toSortedList());
        Assert.assertNotSame(array, keySet.toArray());
        array[3] = 5;
        Assert.assertEquals(expected, FastList.newListWith(keySet.toArray()).toSortedList());
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 5).toSortedList(), FastList.newListWith(array).toSortedList());
        Assert.assertEquals(expected, FastList.newListWith(keySet.toArray(new Integer[keySet.size()])).toSortedList());
    }

    @Test
    public void keySet_toArray_withSmallTarget() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        // deliberately to small to force the method to allocate one of the correct size
        Integer[] destination = new Integer[2];
        Integer[] result = immutableSortedMap.keySet().toArray(destination);
        Arrays.sort(result);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);
    }

    @Test
    public void keySet_ToArray_withLargeTarget() {
        SortedMap<Integer, String> immutableSortedMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        // deliberately large to force the extra to be set to null
        Integer[] target = new Integer[6];
        target[4] = 42;
        target[5] = 42;
        Integer[] result = immutableSortedMap.keySet().toArray(target);
        ArrayIterate.sort(result, result.length, Comparators.safeNullsHigh(Integer::compareTo));
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 42, null }, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addToKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().add(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllToKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().addAll(FastList.newListWith(5, 6, 7));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeFromKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().remove(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAllFromKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().removeAll(FastList.newListWith(1, 2, 3));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAllFromKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().retainAll(FastList.newListWith(1, 2, 3, 4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clearFromKeySet() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).keySet().clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subMap() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).subMap(0, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void headMap() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).headMap(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tailMap() {
        new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")).tailMap(0);
    }

    @Test
    public void ofSortedMap() {
        SortedMap<Integer, String> immutableMap = new ImmutableTreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
        Assert.assertSame(immutableMap, SortedMaps.immutable.ofSortedMap(immutableMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableTreeMapTest instance;

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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
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
        public void benchmark_getIfAbsentValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
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
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
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
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
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
        public void benchmark_nullConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullConstructor);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetContains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetContainsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetContainsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetIsEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetIsEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToString);
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
        public void benchmark_keySet_toArray_withSmallTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_toArray_withSmallTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_ToArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_ToArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllToKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllToKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
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
        public void benchmark_clearFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofSortedMap);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTreeMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> castToSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getIfAbsentValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> nullConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> firstKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> lastKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetContainsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetIsEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> addToKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> addAllToKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> clearFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMapTest> ofSortedMap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableTreeMapTest::stream;
            this.payloads.parallelStream = ImmutableTreeMapTest::parallelStream;
            this.payloads.serialization = ImmutableTreeMapTest::serialization;
            this.payloads.isEmpty = ImmutableTreeMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableTreeMapTest::notEmpty;
            this.payloads.ifPresentApply = ImmutableTreeMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableTreeMapTest::getIfAbsent_function;
            this.payloads.injectIntoKeyValue = ImmutableTreeMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableTreeMapTest::flipUniqueValues;
            this.payloads.collectBoolean = ImmutableTreeMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableTreeMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableTreeMapTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableTreeMapTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableTreeMapTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableTreeMapTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableTreeMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableTreeMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableTreeMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableTreeMapTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableTreeMapTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableTreeMapTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableTreeMapTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableTreeMapTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableTreeMapTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableTreeMapTest::collectShortWithTarget;
            this.payloads.select = ImmutableTreeMapTest::select;
            this.payloads.selectWith = ImmutableTreeMapTest::selectWith;
            this.payloads.reject = ImmutableTreeMapTest::reject;
            this.payloads.rejectWith = ImmutableTreeMapTest::rejectWith;
            this.payloads.collect = ImmutableTreeMapTest::collect;
            this.payloads.flatCollect = ImmutableTreeMapTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableTreeMapTest::flatCollectWith;
            this.payloads.flip = ImmutableTreeMapTest::flip;
            this.payloads.detect = ImmutableTreeMapTest::detect;
            this.payloads.detectOptional = ImmutableTreeMapTest::detectOptional;
            this.payloads.anySatisfy = ImmutableTreeMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableTreeMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableTreeMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableTreeMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableTreeMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableTreeMapTest::noneSatisfyWith;
            this.payloads.appendString = ImmutableTreeMapTest::appendString;
            this.payloads.toBag = ImmutableTreeMapTest::toBag;
            this.payloads.toSortedBag = ImmutableTreeMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableTreeMapTest::toSortedBagBy;
            this.payloads.asLazy = ImmutableTreeMapTest::asLazy;
            this.payloads.toList = ImmutableTreeMapTest::toList;
            this.payloads.toMap = ImmutableTreeMapTest::toMap;
            this.payloads.toSet = ImmutableTreeMapTest::toSet;
            this.payloads.toSortedList = ImmutableTreeMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableTreeMapTest::toSortedListBy;
            this.payloads.toSortedSet = ImmutableTreeMapTest::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableTreeMapTest::toSortedSetBy;
            this.payloads.chunk = ImmutableTreeMapTest::chunk;
            this.payloads.collect_value = ImmutableTreeMapTest::collect_value;
            this.payloads.collectIf = ImmutableTreeMapTest::collectIf;
            this.payloads.collectWith = ImmutableTreeMapTest::collectWith;
            this.payloads.collectWithToTarget = ImmutableTreeMapTest::collectWithToTarget;
            this.payloads.contains = ImmutableTreeMapTest::contains;
            this.payloads.containsAnyIterable = ImmutableTreeMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableTreeMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableTreeMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableTreeMapTest::containsNoneCollection;
            this.payloads.containsAll = ImmutableTreeMapTest::containsAll;
            this.payloads.containsKey = ImmutableTreeMapTest::containsKey;
            this.payloads.containsValue = ImmutableTreeMapTest::containsValue;
            this.payloads.getFirst = ImmutableTreeMapTest::getFirst;
            this.payloads.getLast = ImmutableTreeMapTest::getLast;
            this.payloads.getOnly = ImmutableTreeMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableTreeMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableTreeMapTest::containsAllArguments;
            this.payloads.count = ImmutableTreeMapTest::count;
            this.payloads.countWith = ImmutableTreeMapTest::countWith;
            this.payloads.detect_value = ImmutableTreeMapTest::detect_value;
            this.payloads.detectOptional_value = ImmutableTreeMapTest::detectOptional_value;
            this.payloads.detectWith = ImmutableTreeMapTest::detectWith;
            this.payloads.detectWithOptional = ImmutableTreeMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableTreeMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableTreeMapTest::detectWithIfNone;
            this.payloads.flatten_value = ImmutableTreeMapTest::flatten_value;
            this.payloads.countBy = ImmutableTreeMapTest::countBy;
            this.payloads.countByWith = ImmutableTreeMapTest::countByWith;
            this.payloads.countByEach = ImmutableTreeMapTest::countByEach;
            this.payloads.groupBy = ImmutableTreeMapTest::groupBy;
            this.payloads.groupByEach = ImmutableTreeMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableTreeMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableTreeMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableTreeMapTest::injectInto;
            this.payloads.injectIntoInt = ImmutableTreeMapTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableTreeMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableTreeMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableTreeMapTest::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableTreeMapTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableTreeMapTest::sumOfLong;
            this.payloads.testAggregateBy = ImmutableTreeMapTest::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableTreeMapTest::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableTreeMapTest::sumOfDouble;
            this.payloads.sumByInt = ImmutableTreeMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableTreeMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableTreeMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableTreeMapTest::sumByDouble;
            this.payloads.makeString = ImmutableTreeMapTest::makeString;
            this.payloads.min = ImmutableTreeMapTest::min;
            this.payloads.max = ImmutableTreeMapTest::max;
            this.payloads.minBy = ImmutableTreeMapTest::minBy;
            this.payloads.maxBy = ImmutableTreeMapTest::maxBy;
            this.payloads.reject_value = ImmutableTreeMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableTreeMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableTreeMapTest::select_value;
            this.payloads.selectWith_value = ImmutableTreeMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableTreeMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableTreeMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableTreeMapTest::selectInstancesOf_value;
            this.payloads.toArray = ImmutableTreeMapTest::toArray;
            this.payloads.zip = ImmutableTreeMapTest::zip;
            this.payloads.zipWithIndex = ImmutableTreeMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableTreeMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableTreeMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableTreeMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ImmutableTreeMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableTreeMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableTreeMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableTreeMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableTreeMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableTreeMapTest::newMapWithWithWithWith;
            this.payloads.test_toString = ImmutableTreeMapTest::test_toString;
            this.payloads.castToSortedMap = ImmutableTreeMapTest::castToSortedMap;
            this.payloads.toSortedMap = ImmutableTreeMapTest::toSortedMap;
            this.payloads.equalsAndHashCode = ImmutableTreeMapTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableTreeMapTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableTreeMapTest::forEachValue;
            this.payloads.tap = ImmutableTreeMapTest::tap;
            this.payloads.forEach = ImmutableTreeMapTest::forEach;
            this.payloads.iterator = ImmutableTreeMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableTreeMapTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableTreeMapTest::forEachKey;
            this.payloads.get = ImmutableTreeMapTest::get;
            this.payloads.getOrDefault = ImmutableTreeMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableTreeMapTest::getIfAbsent;
            this.payloads.getIfAbsentValue = ImmutableTreeMapTest::getIfAbsentValue;
            this.payloads.getIfAbsentWith = ImmutableTreeMapTest::getIfAbsentWith;
            this.payloads.forEachWith = ImmutableTreeMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableTreeMapTest::forEachWithIndex;
            this.payloads.valuesView = ImmutableTreeMapTest::valuesView;
            this.payloads.keysView = ImmutableTreeMapTest::keysView;
            this.payloads.putAll = ImmutableTreeMapTest::putAll;
            this.payloads.clear = ImmutableTreeMapTest::clear;
            this.payloads.entrySet = ImmutableTreeMapTest::entrySet;
            this.payloads.selectMap = ImmutableTreeMapTest::selectMap;
            this.payloads.rejectMap = ImmutableTreeMapTest::rejectMap;
            this.payloads.collectMap = ImmutableTreeMapTest::collectMap;
            this.payloads.collectValues = ImmutableTreeMapTest::collectValues;
            this.payloads.collectWithIndex = ImmutableTreeMapTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableTreeMapTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableTreeMapTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableTreeMapTest::rejectWithIndexWithTarget;
            this.payloads.newWithKeyValue = ImmutableTreeMapTest::newWithKeyValue;
            this.payloads.newWithAllKeyValuePairs = ImmutableTreeMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableTreeMapTest::newWithAllKeyValues;
            this.payloads.newWithMap = ImmutableTreeMapTest::newWithMap;
            this.payloads.newWithMapIterable = ImmutableTreeMapTest::newWithMapIterable;
            this.payloads.newWithoutKey = ImmutableTreeMapTest::newWithoutKey;
            this.payloads.newWithoutAllKeys = ImmutableTreeMapTest::newWithoutAllKeys;
            this.payloads.toImmutable = ImmutableTreeMapTest::toImmutable;
            this.payloads.put = ImmutableTreeMapTest::put;
            this.payloads.remove = ImmutableTreeMapTest::remove;
            this.payloads.take = ImmutableTreeMapTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableTreeMapTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableTreeMapTest::testToString;
            this.payloads.nullConstructor = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::nullConstructor, java.lang.NullPointerException.class);
            this.payloads.firstKey = ImmutableTreeMapTest::firstKey;
            this.payloads.firstKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::firstKey_throws, java.util.NoSuchElementException.class);
            this.payloads.lastKey = ImmutableTreeMapTest::lastKey;
            this.payloads.lastKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::lastKey_throws, java.util.NoSuchElementException.class);
            this.payloads.keySet = ImmutableTreeMapTest::keySet;
            this.payloads.keySetContains = ImmutableTreeMapTest::keySetContains;
            this.payloads.keySetContainsAll = ImmutableTreeMapTest::keySetContainsAll;
            this.payloads.keySetIsEmpty = ImmutableTreeMapTest::keySetIsEmpty;
            this.payloads.keySetToString = ImmutableTreeMapTest::keySetToString;
            this.payloads.keySetEqualsAndHashCode = ImmutableTreeMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ImmutableTreeMapTest::keySetToArray;
            this.payloads.keySet_toArray_withSmallTarget = ImmutableTreeMapTest::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = ImmutableTreeMapTest::keySet_ToArray_withLargeTarget;
            this.payloads.addToKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::addToKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllToKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::addAllToKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::removeFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::removeAllFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::retainAllFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.clearFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::clearFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.subMap = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::subMap, java.lang.UnsupportedOperationException.class);
            this.payloads.headMap = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::headMap, java.lang.UnsupportedOperationException.class);
            this.payloads.tailMap = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMapTest::tailMap, java.lang.UnsupportedOperationException.class);
            this.payloads.ofSortedMap = ImmutableTreeMapTest::ofSortedMap;
        }
    }
}
