/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.ClassComparer;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Assert;
import org.junit.Test;

public class UnifiedMapTest extends UnifiedMapTestCase {

    @Override
    public <K, V> MutableMap<K, V> newMap() {
        return UnifiedMap.newMap();
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return UnifiedMap.newWithKeysValues(key, value);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return UnifiedMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Test
    public void newMap_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMap<Integer, Integer>(-1, 0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMap<Integer, Integer>(1, 0.0f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMap<Integer, Integer>(1, -0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMap<Integer, Integer>(1, 1.5f));
    }

    @Test
    public void newMapTest() {
        for (int i = 1; i < 17; i++) {
            this.assertPresizedMap(i, 0.75f);
        }
        this.assertPresizedMap(31, 0.75f);
        this.assertPresizedMap(32, 0.75f);
        this.assertPresizedMap(34, 0.75f);
        this.assertPresizedMap(60, 0.75f);
        this.assertPresizedMap(64, 0.70f);
        this.assertPresizedMap(68, 0.70f);
        this.assertPresizedMap(60, 0.70f);
        this.assertPresizedMap(1025, 0.80f);
        this.assertPresizedMap(1024, 0.80f);
        this.assertPresizedMap(1025, 0.80f);
        this.assertPresizedMap(1024, 0.805f);
    }

    private void assertPresizedMap(int initialCapacity, float loadFactor) {
        try {
            Field tableField = UnifiedMap.class.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(UnifiedMap.newMap(initialCapacity, loadFactor));
            int size = (int) Math.ceil(initialCapacity / loadFactor);
            int capacity = 1;
            while (capacity < size) {
                capacity <<= 1;
            }
            capacity <<= 1;
            Assert.assertEquals(capacity, table.length);
        } catch (SecurityException ignored) {
            Assert.fail("Unable to modify the visibility of the table on UnifiedMap");
        } catch (NoSuchFieldException ignored) {
            Assert.fail("No field named table UnifiedMap");
        } catch (IllegalAccessException ignored) {
            Assert.fail("No access the field table in UnifiedMap");
        }
    }

    @Test
    public void constructorOfPairs() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "one", 2, "two", 3, "three"), UnifiedMap.newMapWith(Tuples.pair(1, "one"), Tuples.pair(2, "two"), Tuples.pair(3, "three")));
    }

    @Test
    public void constructorOfIterableOfPairs() {
        Pair<Integer, String> pair1 = Tuples.pair(1, "One");
        Pair<Integer, String> pair2 = Tuples.pair(2, "Two");
        Pair<Integer, String> pair3 = Tuples.pair(3, "Three");
        Pair<Integer, String> pair4 = Tuples.pair(4, "Four");
        Assert.assertEquals(UnifiedMap.newMapWith(pair1, pair2, pair3, pair4), UnifiedMap.newMapWith(FastList.newListWith(pair1, pair2, pair3, pair4)));
        Assert.assertEquals(UnifiedMap.newMapWith(pair1, pair2, pair3, pair4), UnifiedMap.newMapWith(UnifiedSet.newSetWith(pair1, pair2, pair3, pair4)));
    }

    @Test
    public void unifiedMapProperSuperSetOfHashMap() {
        Assert.assertTrue(ClassComparer.isProperSupersetOf(UnifiedMap.class, HashMap.class));
    }

    @Test
    public void batchForEach() {
        UnifiedMap<String, Integer> map = UnifiedMap.<String, Integer>newMap(5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        this.batchForEachTestCases(map, 10);
        UnifiedMap<Integer, Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6);
        this.batchForEachChains(collisions, 21);
        UnifiedMap<Integer, Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null);
        this.batchForEachNullHandling(nulls, 36);
        this.batchForEachEmptyBatchIterable(UnifiedMap.<Integer, Integer>newMap());
    }

    @Test
    public void batchForEachKey() {
        Set<Integer> keys = UnifiedMap.<Integer, String>newMap(5).withKeysValues(1, "1", 2, "2", 3, "3", 4, "4").keySet();
        this.batchForEachTestCases((BatchIterable<Integer>) keys, 10);
        Set<Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).keySet();
        this.batchForEachChains((BatchIterable<Integer>) collisions, 57);
        Set<Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).keySet();
        this.batchForEachNullHandling((BatchIterable<Integer>) nulls, 16);
        this.batchForEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMap.<Integer, Integer>newMap().keySet());
    }

    @Test
    public void batchForEachValue() {
        Collection<Integer> values = UnifiedMap.<String, Integer>newMap(5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4).values();
        this.batchForEachTestCases((BatchIterable<Integer>) values, 10);
        Collection<Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).values();
        this.batchForEachChains((BatchIterable<Integer>) collisions, 21);
        Collection<Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).values();
        this.batchForEachNullHandling((BatchIterable<Integer>) nulls, 36);
        this.batchForEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMap.<Integer, Integer>newMap().values());
    }

    @Test
    public void batchForEachEntry() {
        // Testing batch size of 1 to 16 with no chains
        BatchIterable<Map.Entry<Integer, Integer>> entries = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4).entrySet();
        for (int sectionCount = 1; sectionCount <= 16; ++sectionCount) {
            Sum sum = new IntegerSum(0);
            for (int sectionIndex = 0; sectionIndex < sectionCount; ++sectionIndex) {
                entries.batchForEach(new EntrySumProcedure(sum), sectionIndex, sectionCount);
            }
            Assert.assertEquals(20, sum.getValue());
        }
    }

    @Test
    public void batchForEachEntry_chains() {
        BatchIterable<Map.Entry<Integer, Integer>> collisions = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).entrySet();
        // Testing 1 batch with chains
        Sum sum2 = new IntegerSum(0);
        // testing getBatchCount returns 1
        int numBatches = collisions.getBatchCount(100000);
        for (int i = 0; i < numBatches; ++i) {
            collisions.batchForEach(new EntrySumProcedure(sum2), i, numBatches);
        }
        Assert.assertEquals(1, numBatches);
        Assert.assertEquals(78, sum2.getValue());
        // Testing 3 batches with chains and uneven last batch
        Sum sum3 = new IntegerSum(0);
        for (int i = 0; i < 5; ++i) {
            collisions.batchForEach(new EntrySumProcedure(sum3), i, 5);
        }
        Assert.assertEquals(78, sum3.getValue());
    }

    @Test
    public void batchForEachEntry_null_handling() {
        // Testing batchForEach handling null keys and null values
        Sum sum4 = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> nulls = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).entrySet();
        for (int i = 0; i < nulls.getBatchCount(7); ++i) {
            nulls.batchForEach(each -> {
                sum4.add(each.getKey() == null ? 1 : each.getKey());
                sum4.add(each.getValue() == null ? 1 : each.getValue());
            }, i, nulls.getBatchCount(7));
        }
        Assert.assertEquals(52, sum4.getValue());
    }

    @Test
    public void batchForEachEntry_emptySet() {
        // Test batchForEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum5 = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> empty = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.newMap().entrySet();
        empty.batchForEach(new EntrySumProcedure(sum5), 0, empty.getBatchCount(1));
        Assert.assertEquals(0, sum5.getValue());
    }

    private void batchForEachTestCases(BatchIterable<Integer> batchIterable, int expectedValue) {
        // Testing batch size of 1 to 16 with no chains
        for (int sectionCount = 1; sectionCount <= 16; ++sectionCount) {
            Sum sum = new IntegerSum(0);
            for (int sectionIndex = 0; sectionIndex < sectionCount; ++sectionIndex) {
                batchIterable.batchForEach(new SumProcedure<>(sum), sectionIndex, sectionCount);
            }
            Assert.assertEquals(expectedValue, sum.getValue());
        }
    }

    private void batchForEachChains(BatchIterable<Integer> batchIterable, int expectedValue) {
        // Testing 1 batch with chains
        Sum sum = new IntegerSum(0);
        // testing getBatchCount returns 1
        int numBatches = batchIterable.getBatchCount(100000);
        for (int i = 0; i < numBatches; ++i) {
            batchIterable.batchForEach(new SumProcedure<>(sum), i, numBatches);
        }
        Assert.assertEquals(1, numBatches);
        Assert.assertEquals(expectedValue, sum.getValue());
        // Testing 3 batches with chains and uneven last batch
        Sum sum2 = new IntegerSum(0);
        for (int i = 0; i < 5; ++i) {
            batchIterable.batchForEach(new SumProcedure<>(sum2), i, 5);
        }
        Assert.assertEquals(expectedValue, sum2.getValue());
    }

    private void batchForEachNullHandling(BatchIterable<Integer> batchIterable, int expectedValue) {
        // Testing batchForEach handling null keys and null values
        Sum sum = new IntegerSum(0);
        for (int i = 0; i < batchIterable.getBatchCount(7); ++i) {
            batchIterable.batchForEach(each -> sum.add(each == null ? 1 : each), i, batchIterable.getBatchCount(7));
        }
        Assert.assertEquals(expectedValue, sum.getValue());
    }

    private void batchForEachEmptyBatchIterable(BatchIterable<Integer> batchIterable) {
        // Test batchForEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum = new IntegerSum(0);
        batchIterable.batchForEach(new SumProcedure<>(sum), 0, batchIterable.getBatchCount(1));
        Assert.assertEquals(0, sum.getValue());
    }

    @Test
    public void batchIterable_forEach() {
        UnifiedMap<String, Integer> map = UnifiedMap.<String, Integer>newMap(5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        this.batchIterable_forEach(map, 10);
        UnifiedMap<Integer, Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6);
        this.batchIterable_forEach(collisions, 21);
        UnifiedMap<Integer, Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null);
        this.batchIterable_forEachNullHandling(nulls, 33);
        this.batchIterable_forEachEmptyBatchIterable(UnifiedMap.<Integer, Integer>newMap());
    }

    @Test
    public void batchIterable_forEachKey() {
        Set<Integer> keys = UnifiedMap.<Integer, String>newMap(5).withKeysValues(1, "1", 2, "2", 3, "3", 4, "4").keySet();
        this.batchIterable_forEach((BatchIterable<Integer>) keys, 10);
        Set<Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).keySet();
        this.batchIterable_forEach((BatchIterable<Integer>) collisions, 57);
        Set<Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).keySet();
        this.batchIterable_forEachNullHandling((BatchIterable<Integer>) nulls, 15);
        this.batchIterable_forEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMap.<Integer, Integer>newMap().keySet());
    }

    @Test
    public void batchIterable_forEachValue() {
        Collection<Integer> values = UnifiedMap.<String, Integer>newMap(5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4).values();
        this.batchIterable_forEach((BatchIterable<Integer>) values, 10);
        Collection<Integer> collisions = UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).values();
        this.batchIterable_forEach((BatchIterable<Integer>) collisions, 21);
        Collection<Integer> nulls = UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).values();
        this.batchIterable_forEachNullHandling((BatchIterable<Integer>) nulls, 33);
        this.batchIterable_forEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMap.<Integer, Integer>newMap().values());
    }

    @Test
    public void batchIterable_forEachEntry() {
        BatchIterable<Map.Entry<Integer, Integer>> entries = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4).entrySet();
        Sum sum = new IntegerSum(0);
        entries.forEach(new EntrySumProcedure(sum));
        Assert.assertEquals(20, sum.getValue());
    }

    @Test
    public void batchIterable_forEachEntry_chains() {
        BatchIterable<Map.Entry<Integer, Integer>> collisions = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.<Integer, Integer>newMap(5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).entrySet();
        Sum sum = new IntegerSum(0);
        collisions.forEach(new EntrySumProcedure(sum));
        Assert.assertEquals(78, sum.getValue());
    }

    @Test
    public void batchIterable_forEachEntry_null_handling() {
        // Testing batchForEach handling null keys and null values
        Sum sum = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> nulls = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.<Integer, Integer>newMap(100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).entrySet();
        nulls.forEach(each -> {
            sum.add(each.getKey() == null ? 0 : each.getKey());
            sum.add(each.getValue() == null ? 0 : each.getValue());
        });
        Assert.assertEquals(48, sum.getValue());
    }

    @Test
    public void batchIterable_forEachEntry_emptySet() {
        // Test forEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> empty = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMap.newMap().entrySet();
        empty.forEach(new EntrySumProcedure(sum));
        Assert.assertEquals(0, sum.getValue());
    }

    private void batchIterable_forEach(BatchIterable<Integer> batchIterable, int expectedValue) {
        IntegerSum sum = new IntegerSum(0);
        batchIterable.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(expectedValue, sum.getValue());
    }

    private void batchIterable_forEachNullHandling(BatchIterable<Integer> batchIterable, int expectedValue) {
        // Testing forEach handling null keys and null values
        Sum sum = new IntegerSum(0);
        batchIterable.forEach(each -> sum.add(each == null ? 0 : each));
        Assert.assertEquals(expectedValue, sum.getValue());
    }

    private void batchIterable_forEachEmptyBatchIterable(BatchIterable<Integer> batchIterable) {
        // Test forEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum = new IntegerSum(0);
        batchIterable.batchForEach(new SumProcedure<>(sum), 0, batchIterable.getBatchCount(1));
        Assert.assertEquals(0, sum.getValue());
    }

    @Test
    public void getMapMemoryUsedInWords() {
        UnifiedMap<String, String> map = UnifiedMap.newMap();
        Assert.assertEquals(34, map.getMapMemoryUsedInWords());
        map.put("1", "1");
        Assert.assertEquals(34, map.getMapMemoryUsedInWords());
        UnifiedMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(2);
        Assert.assertEquals(16, map2.getMapMemoryUsedInWords());
    }

    @Test
    public void getCollidingBuckets() {
        UnifiedMap<Object, Object> map = UnifiedMap.newMap();
        Assert.assertEquals(0, map.getCollidingBuckets());
        UnifiedMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(2);
        Assert.assertEquals(1, map2.getCollidingBuckets());
        map2.put(42, 42);
        Assert.assertEquals(1, map2.getCollidingBuckets());
        UnifiedMap<String, String> map3 = UnifiedMap.newWithKeysValues("Six", "6", "Bar", "-", "Three", "3", "Five", "5");
        Assert.assertEquals(2, map3.getCollidingBuckets());
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        super.getIfAbsentPut();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMap<Integer, Integer> map = UnifiedMap.newMap(2, 0.75f);
        COLLISIONS.subList(0, 5).forEach(Procedures.cast(each -> map.getIfAbsentPut(each, new PassThruFunction0<>(each))));
        Assert.assertEquals(this.mapWithCollisionsOfSize(5), map);
        // Test getting element present in chain
        UnifiedMap<Integer, Integer> map2 = UnifiedMap.newWithKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4);
        Assert.assertEquals(Integer.valueOf(3), map2.getIfAbsentPut(COLLISION_3, () -> {
            Assert.fail();
            return null;
        }));
        // Test rehashing while creating a new chained key
        UnifiedMap<Integer, Integer> map3 = UnifiedMap.<Integer, Integer>newMap(2, 0.75f).withKeysValues(1, COLLISION_1, 2, COLLISION_2, 3, COLLISION_3);
        Assert.assertEquals(COLLISION_4, map3.getIfAbsentPut(4, new PassThruFunction0<>(COLLISION_4)));
        Assert.assertNull(map3.getIfAbsentPut(5, new PassThruFunction0<>(null)));
    }

    @Override
    @Test
    public void getIfAbsentPut_block_throws() {
        super.getIfAbsentPut_block_throws();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMap<Integer, Integer> map = UnifiedMap.newMap(2, 0.75f);
        COLLISIONS.subList(0, 5).forEach(Procedures.cast(each -> {
            Assert.assertThrows(RuntimeException.class, () -> map.getIfAbsentPut(each, () -> {
                throw new RuntimeException();
            }));
            map.put(each, each);
        }));
        Assert.assertEquals(this.mapWithCollisionsOfSize(5), map);
    }

    @Override
    @Test
    public void put() {
        super.put();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMap<Integer, Integer> map = UnifiedMap.newMap(2, 0.75f);
        COLLISIONS.subList(0, 5).forEach(Procedures.cast(each -> Assert.assertNull(map.put(each, each))));
        Assert.assertEquals(this.mapWithCollisionsOfSize(5), map);
    }

    @Override
    @Test
    public void collectValues() {
        super.collectValues();
        UnifiedMap<String, Integer> map = UnifiedMap.<String, Integer>newMap().withKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(UnifiedMap.<String, String>newMap(5).withKeysValues("1", "11", "2", "22", "3", "33", "4", "44"), map.collectValues((key, value) -> key + value));
        UnifiedMap<Integer, Integer> collisions = UnifiedMap.<Integer, Integer>newMap().withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4);
        Assert.assertEquals(UnifiedMap.<Integer, Integer>newMap().withKeysValues(COLLISION_1, COLLISION_1 + 1, COLLISION_2, COLLISION_2 + 2, COLLISION_3, COLLISION_3 + 3, 1, 5), collisions.collectValues((key, value) -> key + value));
        UnifiedMap<Integer, Integer> nulls = UnifiedMap.<Integer, Integer>newMap().withKeysValues(null, 10, 1, null, 2, 11, 3, 12);
        Assert.assertEquals(UnifiedMap.<Integer, Boolean>newMap().withKeysValues(null, true, 1, true, 2, false, 3, false), nulls.collectValues((key, value) -> key == null || value == null));
        UnifiedMap<Integer, Integer> empty = UnifiedMap.newMap();
        Verify.assertEmpty(empty.collectValues((key, value) -> key + value));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertNull(collisions.detect((key, value) -> COLLISION_4.equals(key) && "four".equals(value)));
        Assert.assertEquals(Tuples.pair(COLLISION_1, "one"), collisions.detect((key, value) -> COLLISION_1.equals(key) && "one".equals(value)));
    }

    @Override
    @Test
    public void detectOptional() {
        super.detectOptional();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertFalse(collisions.detectOptional((key, value) -> COLLISION_4.equals(key) && "four".equals(value)).isPresent());
        Assert.assertEquals(Tuples.pair(COLLISION_1, "one"), collisions.detectOptional((key, value) -> COLLISION_1.equals(key) && "one".equals(value)).get());
    }

    @Override
    @Test
    public void detect_value() {
        super.detect_value();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertNull(collisions.detect("four"::equals));
        Assert.assertEquals("one", collisions.detect("one"::equals));
    }

    @Override
    @Test
    public void detectOptional_value() {
        super.detectOptional_value();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertFalse(collisions.detectOptional("four"::equals).isPresent());
        Assert.assertEquals("one", collisions.detectOptional("one"::equals).get());
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertNull(collisions.detectWith((String value, String parameter) -> "value is four".equals(parameter + value), "value is "));
        Assert.assertEquals("one", collisions.detectWith((String value, String parameter) -> "value is one".equals(parameter + value), "value is "));
    }

    @Override
    @Test
    public void detectWithOptional() {
        super.detectWithOptional();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertFalse(collisions.detectWithOptional((String value, String parameter) -> "value is four".equals(parameter + value), "value is ").isPresent());
        Assert.assertEquals("one", collisions.detectWithOptional((String value, String parameter) -> "value is one".equals(parameter + value), "value is ").get());
    }

    @Override
    @Test
    public void detectIfNone_value() {
        super.detectIfNone_value();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertEquals("if none string", collisions.detectIfNone("four"::equals, () -> "if none string"));
        Assert.assertEquals("one", collisions.detectIfNone("one"::equals, () -> "if none string"));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        super.detectWithIfNone();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertEquals("if none string", collisions.detectWithIfNone((String value, String parameter) -> "value is four".equals(parameter + value), "value is ", () -> "if none string"));
        Assert.assertEquals("one", collisions.detectWithIfNone((String value, String parameter) -> "value is one".equals(parameter + value), "value is ", () -> "if none string"));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertFalse(collisions.anySatisfy("four"::equals));
        Assert.assertTrue(collisions.anySatisfy("one"::equals));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        super.anySatisfyWith();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertTrue(collisions.anySatisfyWith((value, parameter) -> "value is one".equals(parameter + value), "value is "));
        Assert.assertFalse(collisions.anySatisfyWith((value, parameter) -> "value is four".equals(parameter + value), "value is "));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertTrue(collisions.allSatisfy(value -> !value.isEmpty()));
        Assert.assertFalse(collisions.allSatisfy(value -> value.length() > 3));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        super.allSatisfyWith();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertTrue(collisions.allSatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(collisions.allSatisfyWith(String::equals, "one"));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.allSatisfy();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertTrue(collisions.noneSatisfy("four"::equals));
        Assert.assertFalse(collisions.noneSatisfy("one"::equals));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        super.allSatisfyWith();
        UnifiedMap<Integer, String> collisions = UnifiedMap.<Integer, String>newMap().withKeysValues(COLLISION_1, "one", COLLISION_2, "two", COLLISION_3, "three");
        Assert.assertTrue(collisions.noneSatisfyWith(String::equals, "monkey"));
        Assert.assertFalse(collisions.allSatisfyWith(String::equals, "one"));
    }

    @Test
    public void trimToSize() {
        UnifiedMap<String, String> map = UnifiedMap.newMap();
        MutableMap<String, String> expected = Maps.mutable.empty();
        Interval integers = Interval.fromTo(0, 250);
        integers.each(each -> {
            map.put(each.toString(), each.toString());
            expected.put(each.toString(), each.toString());
        });
        ArrayIterate.forEach(FREQUENT_COLLISIONS, each -> {
            map.put(each, each);
            expected.put(each, each);
        });
        Assert.assertEquals(expected, map);
        Assert.assertEquals(261, map.size());
        MutableList<Integer> toRemove = Lists.mutable.withAll(Interval.evensFromTo(0, 20));
        toRemove.addAll(Interval.oddsFromTo(35, 55));
        toRemove.each(each -> {
            map.remove(each.toString());
            expected.remove(each.toString());
        });
        // First assertion to verify that trim does not happen since, the table is already at the smallest required power of 2.
        Assert.assertFalse(map.trimToSize());
        Assert.assertEquals(expected, map);
        Assert.assertEquals(239, map.size());
        Interval.evensFromTo(0, 250).each(each -> {
            map.remove(each.toString());
            expected.remove(each.toString());
        });
        // Second assertion to verify that trim happens since, the table length is less than smallest required power of 2.
        Assert.assertTrue(map.trimToSize());
        Assert.assertFalse(map.trimToSize());
        Assert.assertEquals(expected, map);
        Assert.assertEquals(124, map.size());
        expected.forEachKey(each -> Assert.assertEquals(each, map.get(each)));
        integers.each(each -> {
            map.remove(each.toString());
            expected.remove(each.toString());
        });
        Assert.assertTrue(map.trimToSize());
        Assert.assertFalse(map.trimToSize());
        Assert.assertEquals(expected, map);
        expected.forEachKey(each -> Assert.assertEquals(each, map.get(each)));
        map.clear();
        expected.clear();
        Assert.assertTrue(map.trimToSize());
        Interval.zeroTo(20).each(each -> {
            map.put(each.toString(), each.toString());
            expected.put(each.toString(), each.toString());
        });
        Assert.assertFalse(map.trimToSize());
        Interval.fromTo(9, 18).each(each -> {
            map.remove(each.toString());
            expected.remove(each.toString());
        });
        Assert.assertTrue(map.trimToSize());
        Assert.assertFalse(map.trimToSize());
        Assert.assertEquals(expected, map);
        expected.forEachKey(each -> Assert.assertEquals(each, map.get(each)));
        map.clear();
        Assert.assertTrue(map.trimToSize());
        Assert.assertTrue(map.isEmpty());
        Interval.zeroTo(6).each(each -> map.put(each.toString(), each.toString()));
        // Assert that trim does not happen as long as table.size is already as smaller than required
        Assert.assertFalse(map.trimToSize());
        map.put("7", "7");
        map.removeKey("2");
        map.removeKey("3");
        // Assert that trim does not happen as long as table.size is as small as required
        Assert.assertFalse(map.trimToSize());
        map.removeKey("5");
        map.removeKey("7");
        Assert.assertTrue(map.trimToSize());
        // Inflate the map so that table.length increases to next power of 2 and check that trim does not happen
        map.put("2", "2");
        map.put("5", "5");
        map.put("7", "7");
        // Assert that the resized table due to put is the required size and no need to trim that.
        Assert.assertFalse(map.trimToSize());
        Interval.zeroTo(4).each(each -> map.put(each.toString(), each.toString()));
        Interval.oneTo(3).each(each -> map.removeKey(each.toString()));
        Assert.assertTrue(map.trimToSize());
        Assert.assertEquals(5, map.size());
    }

    @Override
    protected UnifiedMap<Integer, Integer> mapWithCollisionsOfSize(int size) {
        UnifiedMap<Integer, Integer> map = UnifiedMap.newMap(size);
        return this.populateMapWithCollisionsOfSize(size, map);
    }

    private static final class EntrySumProcedure implements Procedure<Map.Entry<Integer, Integer>> {

        private static final long serialVersionUID = 1L;

        private final Sum sum;

        private EntrySumProcedure(Sum sum) {
            this.sum = sum;
        }

        @Override
        public void value(Map.Entry<Integer, Integer> each) {
            this.sum.add(each.getKey());
            this.sum.add(each.getValue());
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
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
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
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
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
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
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
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
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_WithEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_WithEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_toArray_withSmallTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_toArray_withSmallTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_ToArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_ToArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noInstanceOfEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noInstanceOfEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_hashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_hashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_copyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_copyKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_key_and_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_key_and_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValueWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValueWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeBeforeIncrement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeBeforeIncrement);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_Iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_Iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_many_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_many_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapTest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfIterableOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfIterableOfPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedMapProperSuperSetOfHashMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedMapProperSuperSetOfHashMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_chains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_null_handling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_emptySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_chains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_null_handling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_emptySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getMapMemoryUsedInWords() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getMapMemoryUsedInWords);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollidingBuckets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollidingBuckets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_toArray_WithEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> noInstanceOfEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_hashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_copyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_toArray_withEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_PostSerializedEquality;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_PostSerializedEquality_chainedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> contains_key_and_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutValueWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPutWithWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> keySet_Iterator_removeBeforeIncrement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_Iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> iterator_many_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valuesCollection_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valueCollection_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> valueCollection_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> frequentCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> newMapTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> constructorOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> constructorOfIterableOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> unifiedMapProperSuperSetOfHashMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchForEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> batchIterable_forEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getMapMemoryUsedInWords;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getCollidingBuckets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnifiedMapTest::stream;
            this.payloads.parallelStream = UnifiedMapTest::parallelStream;
            this.payloads.serialization = UnifiedMapTest::serialization;
            this.payloads.isEmpty = UnifiedMapTest::isEmpty;
            this.payloads.notEmpty = UnifiedMapTest::notEmpty;
            this.payloads.ifPresentApply = UnifiedMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnifiedMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnifiedMapTest::getOrDefault;
            this.payloads.getIfAbsent = UnifiedMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnifiedMapTest::getIfAbsentWith;
            this.payloads.tap = UnifiedMapTest::tap;
            this.payloads.forEach = UnifiedMapTest::forEach;
            this.payloads.forEachKeyValue = UnifiedMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnifiedMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnifiedMapTest::flipUniqueValues;
            this.payloads.collectMap = UnifiedMapTest::collectMap;
            this.payloads.collectBoolean = UnifiedMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnifiedMapTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedMapTest::collectByteWithTarget;
            this.payloads.collectChar = UnifiedMapTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedMapTest::collectCharWithTarget;
            this.payloads.collectDouble = UnifiedMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnifiedMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedMapTest::collectFloatWithTarget;
            this.payloads.collectInt = UnifiedMapTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedMapTest::collectIntWithTarget;
            this.payloads.collectLong = UnifiedMapTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedMapTest::collectLongWithTarget;
            this.payloads.collectShort = UnifiedMapTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedMapTest::collectShortWithTarget;
            this.payloads.select = UnifiedMapTest::select;
            this.payloads.selectWith = UnifiedMapTest::selectWith;
            this.payloads.reject = UnifiedMapTest::reject;
            this.payloads.rejectWith = UnifiedMapTest::rejectWith;
            this.payloads.collect = UnifiedMapTest::collect;
            this.payloads.flatCollect = UnifiedMapTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedMapTest::flatCollectWith;
            this.payloads.selectMap = UnifiedMapTest::selectMap;
            this.payloads.rejectMap = UnifiedMapTest::rejectMap;
            this.payloads.flip = UnifiedMapTest::flip;
            this.payloads.appendString = UnifiedMapTest::appendString;
            this.payloads.toBag = UnifiedMapTest::toBag;
            this.payloads.toSortedBag = UnifiedMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnifiedMapTest::toSortedBagBy;
            this.payloads.asLazy = UnifiedMapTest::asLazy;
            this.payloads.toList = UnifiedMapTest::toList;
            this.payloads.toMap = UnifiedMapTest::toMap;
            this.payloads.toSet = UnifiedMapTest::toSet;
            this.payloads.toSortedList = UnifiedMapTest::toSortedList;
            this.payloads.toSortedListBy = UnifiedMapTest::toSortedListBy;
            this.payloads.toSortedSet = UnifiedMapTest::toSortedSet;
            this.payloads.toSortedSetBy = UnifiedMapTest::toSortedSetBy;
            this.payloads.toSortedMap = UnifiedMapTest::toSortedMap;
            this.payloads.chunk = UnifiedMapTest::chunk;
            this.payloads.collect_value = UnifiedMapTest::collect_value;
            this.payloads.collectIf = UnifiedMapTest::collectIf;
            this.payloads.collectWith = UnifiedMapTest::collectWith;
            this.payloads.collectWithToTarget = UnifiedMapTest::collectWithToTarget;
            this.payloads.contains = UnifiedMapTest::contains;
            this.payloads.containsAnyIterable = UnifiedMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnifiedMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedMapTest::containsNoneCollection;
            this.payloads.containsAll = UnifiedMapTest::containsAll;
            this.payloads.containsKey = UnifiedMapTest::containsKey;
            this.payloads.containsValue = UnifiedMapTest::containsValue;
            this.payloads.getFirst = UnifiedMapTest::getFirst;
            this.payloads.getLast = UnifiedMapTest::getLast;
            this.payloads.getOnly = UnifiedMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnifiedMapTest::containsAllIterable;
            this.payloads.containsAllArguments = UnifiedMapTest::containsAllArguments;
            this.payloads.count = UnifiedMapTest::count;
            this.payloads.countWith = UnifiedMapTest::countWith;
            this.payloads.flatten_value = UnifiedMapTest::flatten_value;
            this.payloads.countBy = UnifiedMapTest::countBy;
            this.payloads.countByWith = UnifiedMapTest::countByWith;
            this.payloads.countByEach = UnifiedMapTest::countByEach;
            this.payloads.groupBy = UnifiedMapTest::groupBy;
            this.payloads.groupByEach = UnifiedMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnifiedMapTest::injectInto;
            this.payloads.injectIntoInt = UnifiedMapTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnifiedMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnifiedMapTest::injectIntoDouble;
            this.payloads.sumOfInt = UnifiedMapTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedMapTest::sumOfLong;
            this.payloads.testAggregateBy = UnifiedMapTest::testAggregateBy;
            this.payloads.sumOfFloat = UnifiedMapTest::sumOfFloat;
            this.payloads.sumOfDouble = UnifiedMapTest::sumOfDouble;
            this.payloads.sumByInt = UnifiedMapTest::sumByInt;
            this.payloads.sumByFloat = UnifiedMapTest::sumByFloat;
            this.payloads.sumByLong = UnifiedMapTest::sumByLong;
            this.payloads.sumByDouble = UnifiedMapTest::sumByDouble;
            this.payloads.makeString = UnifiedMapTest::makeString;
            this.payloads.min = UnifiedMapTest::min;
            this.payloads.max = UnifiedMapTest::max;
            this.payloads.minBy = UnifiedMapTest::minBy;
            this.payloads.maxBy = UnifiedMapTest::maxBy;
            this.payloads.reject_value = UnifiedMapTest::reject_value;
            this.payloads.rejectWith_value = UnifiedMapTest::rejectWith_value;
            this.payloads.select_value = UnifiedMapTest::select_value;
            this.payloads.selectWith_value = UnifiedMapTest::selectWith_value;
            this.payloads.partition_value = UnifiedMapTest::partition_value;
            this.payloads.partitionWith_value = UnifiedMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnifiedMapTest::selectInstancesOf_value;
            this.payloads.toArray = UnifiedMapTest::toArray;
            this.payloads.zip = UnifiedMapTest::zip;
            this.payloads.zipWithIndex = UnifiedMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = UnifiedMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnifiedMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnifiedMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = UnifiedMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnifiedMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnifiedMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnifiedMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnifiedMapTest::newMapWithWithWithWith;
            this.payloads.iterator = UnifiedMapTest::iterator;
            this.payloads.keysView = UnifiedMapTest::keysView;
            this.payloads.valuesView = UnifiedMapTest::valuesView;
            this.payloads.test_toString = UnifiedMapTest::test_toString;
            this.payloads.toImmutable = UnifiedMapTest::toImmutable;
            this.payloads.clear = UnifiedMapTest::clear;
            this.payloads.removeObject = UnifiedMapTest::removeObject;
            this.payloads.removeAllFromEntrySet = UnifiedMapTest::removeAllFromEntrySet;
            this.payloads.clearEntrySet = UnifiedMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = UnifiedMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = UnifiedMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnifiedMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = UnifiedMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = UnifiedMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = UnifiedMapTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = UnifiedMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnifiedMapTest::keySetToArray;
            this.payloads.removeFromValues = UnifiedMapTest::removeFromValues;
            this.payloads.removeNullFromValues = UnifiedMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = UnifiedMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = UnifiedMapTest::retainAllFromValues;
            this.payloads.putAll = UnifiedMapTest::putAll;
            this.payloads.removeKey = UnifiedMapTest::removeKey;
            this.payloads.removeAllKeys = UnifiedMapTest::removeAllKeys;
            this.payloads.removeIf = UnifiedMapTest::removeIf;
            this.payloads.getIfAbsentPutValue = UnifiedMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = UnifiedMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = UnifiedMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWith_block_throws = UnifiedMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = UnifiedMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnifiedMapTest::newEmpty;
            this.payloads.keysAndValues_toString = UnifiedMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnifiedMapTest::keyPreservation;
            this.payloads.asUnmodifiable = UnifiedMapTest::asUnmodifiable;
            this.payloads.asSynchronized = UnifiedMapTest::asSynchronized;
            this.payloads.add = UnifiedMapTest::add;
            this.payloads.putPair = UnifiedMapTest::putPair;
            this.payloads.withKeyValue = UnifiedMapTest::withKeyValue;
            this.payloads.withMap = UnifiedMapTest::withMap;
            this.payloads.withMapEmpty = UnifiedMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnifiedMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnifiedMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnifiedMapTest::withMapNull;
            this.payloads.withMapIterable = UnifiedMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnifiedMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnifiedMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnifiedMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnifiedMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnifiedMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnifiedMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnifiedMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnifiedMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnifiedMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = UnifiedMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = UnifiedMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = UnifiedMapTest::withoutKey;
            this.payloads.withoutAllKeys = UnifiedMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedMapTest::rehash_null_collision;
            this.payloads.updateValue = UnifiedMapTest::updateValue;
            this.payloads.updateValue_collisions = UnifiedMapTest::updateValue_collisions;
            this.payloads.updateValueWith = UnifiedMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = UnifiedMapTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = UnifiedMapTest::collectKeysAndValues;
            this.payloads.testClone = UnifiedMapTest::testClone;
            this.payloads.valuesCollection_toArray = UnifiedMapTest::valuesCollection_toArray;
            this.payloads.valuesCollection_toArray_WithEmptyTarget = UnifiedMapTest::valuesCollection_toArray_WithEmptyTarget;
            this.payloads.valuesCollection_toArray_withPreSizedTarget = UnifiedMapTest::valuesCollection_toArray_withPreSizedTarget;
            this.payloads.valuesCollection_toArray_withLargeTarget = UnifiedMapTest::valuesCollection_toArray_withLargeTarget;
            this.payloads.entrySet_clear = UnifiedMapTest::entrySet_clear;
            this.payloads.valuesCollection_clear = UnifiedMapTest::valuesCollection_clear;
            this.payloads.keySet_toArray_withSmallTarget = UnifiedMapTest::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = UnifiedMapTest::keySet_ToArray_withLargeTarget;
            this.payloads.noInstanceOfEquals = UnifiedMapTest::noInstanceOfEquals;
            this.payloads.keySet_hashCode = UnifiedMapTest::keySet_hashCode;
            this.payloads.keySet_copyKeys = UnifiedMapTest::keySet_copyKeys;
            this.payloads.entrySet_toArray = UnifiedMapTest::entrySet_toArray;
            this.payloads.entrySet_toArray_withEmptyTarget = UnifiedMapTest::entrySet_toArray_withEmptyTarget;
            this.payloads.entrySet_toArray_withPreSizedTarget = UnifiedMapTest::entrySet_toArray_withPreSizedTarget;
            this.payloads.entrySet_toArray_withLargeTarget = UnifiedMapTest::entrySet_toArray_withLargeTarget;
            this.payloads.entrySet_PostSerializedEqualsAndHashCode = UnifiedMapTest::entrySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode = UnifiedMapTest::keySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot = UnifiedMapTest::keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;
            this.payloads.valuesCollection_PostSerializedEquality = UnifiedMapTest::valuesCollection_PostSerializedEquality;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMap = UnifiedMapTest::valuesCollection_PostSerializedEquality_chainedMap;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot = UnifiedMapTest::valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;
            this.payloads.contains_key_and_value = UnifiedMapTest::contains_key_and_value;
            this.payloads.remove = UnifiedMapTest::remove;
            this.payloads.getIfAbsentPutValueWithCollisions = UnifiedMapTest::getIfAbsentPutValueWithCollisions;
            this.payloads.getIfAbsentPutWithWithCollisions = UnifiedMapTest::getIfAbsentPutWithWithCollisions;
            this.payloads.removeFromEntrySet = UnifiedMapTest::removeFromEntrySet;
            this.payloads.retainAllFromEntrySet = UnifiedMapTest::retainAllFromEntrySet;
            this.payloads.forEachWith = UnifiedMapTest::forEachWith;
            this.payloads.keySet_retainAll = UnifiedMapTest::keySet_retainAll;
            this.payloads.keySet_containsAll = UnifiedMapTest::keySet_containsAll;
            this.payloads.keySet_equals = UnifiedMapTest::keySet_equals;
            this.payloads.keySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::keySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::keySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::keySet_Iterator, java.util.NoSuchElementException.class);
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.keySet_Iterator_removeBeforeIncrement = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::keySet_Iterator_removeBeforeIncrement, java.lang.IllegalStateException.class);
            this.payloads.valuesCollection_Iterator_remove = UnifiedMapTest::valuesCollection_Iterator_remove;
            this.payloads.iterator_many_collisions = UnifiedMapTest::iterator_many_collisions;
            this.payloads.entry_setValue = UnifiedMapTest::entry_setValue;
            this.payloads.entry_hashCodeForNullKeyAndValue = UnifiedMapTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equalsWithNonEntry = UnifiedMapTest::entry_equalsWithNonEntry;
            this.payloads.entrySet_remove = UnifiedMapTest::entrySet_remove;
            this.payloads.entrySet_contains = UnifiedMapTest::entrySet_contains;
            this.payloads.entrySet_containsAll = UnifiedMapTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = UnifiedMapTest::entrySet_equals;
            this.payloads.valuesCollection_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::valuesCollection_add, java.lang.UnsupportedOperationException.class);
            this.payloads.valuesCollection_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::valuesCollection_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.valueCollection_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTest::valueCollection_Iterator, java.util.NoSuchElementException.class);
            this.payloads.valueCollection_equals = UnifiedMapTest::valueCollection_equals;
            this.payloads.forEachWithIndex = UnifiedMapTest::forEachWithIndex;
            this.payloads.forEachKey = UnifiedMapTest::forEachKey;
            this.payloads.forEachValue = UnifiedMapTest::forEachValue;
            this.payloads.equalsAndHashCode = UnifiedMapTest::equalsAndHashCode;
            this.payloads.frequentCollision = UnifiedMapTest::frequentCollision;
            this.payloads.newMap_throws = UnifiedMapTest::newMap_throws;
            this.payloads.newMapTest = UnifiedMapTest::newMapTest;
            this.payloads.constructorOfPairs = UnifiedMapTest::constructorOfPairs;
            this.payloads.constructorOfIterableOfPairs = UnifiedMapTest::constructorOfIterableOfPairs;
            this.payloads.unifiedMapProperSuperSetOfHashMap = UnifiedMapTest::unifiedMapProperSuperSetOfHashMap;
            this.payloads.batchForEach = UnifiedMapTest::batchForEach;
            this.payloads.batchForEachKey = UnifiedMapTest::batchForEachKey;
            this.payloads.batchForEachValue = UnifiedMapTest::batchForEachValue;
            this.payloads.batchForEachEntry = UnifiedMapTest::batchForEachEntry;
            this.payloads.batchForEachEntry_chains = UnifiedMapTest::batchForEachEntry_chains;
            this.payloads.batchForEachEntry_null_handling = UnifiedMapTest::batchForEachEntry_null_handling;
            this.payloads.batchForEachEntry_emptySet = UnifiedMapTest::batchForEachEntry_emptySet;
            this.payloads.batchIterable_forEach = UnifiedMapTest::batchIterable_forEach;
            this.payloads.batchIterable_forEachKey = UnifiedMapTest::batchIterable_forEachKey;
            this.payloads.batchIterable_forEachValue = UnifiedMapTest::batchIterable_forEachValue;
            this.payloads.batchIterable_forEachEntry = UnifiedMapTest::batchIterable_forEachEntry;
            this.payloads.batchIterable_forEachEntry_chains = UnifiedMapTest::batchIterable_forEachEntry_chains;
            this.payloads.batchIterable_forEachEntry_null_handling = UnifiedMapTest::batchIterable_forEachEntry_null_handling;
            this.payloads.batchIterable_forEachEntry_emptySet = UnifiedMapTest::batchIterable_forEachEntry_emptySet;
            this.payloads.getMapMemoryUsedInWords = UnifiedMapTest::getMapMemoryUsedInWords;
            this.payloads.getCollidingBuckets = UnifiedMapTest::getCollidingBuckets;
            this.payloads.getIfAbsentPut = UnifiedMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_block_throws = UnifiedMapTest::getIfAbsentPut_block_throws;
            this.payloads.put = UnifiedMapTest::put;
            this.payloads.collectValues = UnifiedMapTest::collectValues;
            this.payloads.detect = UnifiedMapTest::detect;
            this.payloads.detectOptional = UnifiedMapTest::detectOptional;
            this.payloads.detect_value = UnifiedMapTest::detect_value;
            this.payloads.detectOptional_value = UnifiedMapTest::detectOptional_value;
            this.payloads.detectWith = UnifiedMapTest::detectWith;
            this.payloads.detectWithOptional = UnifiedMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnifiedMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnifiedMapTest::detectWithIfNone;
            this.payloads.anySatisfy = UnifiedMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedMapTest::noneSatisfyWith;
            this.payloads.trimToSize = UnifiedMapTest::trimToSize;
        }
    }
}
