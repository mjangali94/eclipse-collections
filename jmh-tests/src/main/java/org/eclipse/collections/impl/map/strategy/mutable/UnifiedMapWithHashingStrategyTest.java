/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.mutable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMapTestCase;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Assert;
import org.junit.Test;

public class UnifiedMapWithHashingStrategyTest extends UnifiedMapTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);

    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    @Override
    public <K, V> MutableMap<K, V> newMap() {
        return UnifiedMapWithHashingStrategy.newMap(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key, value);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Test
    public void constructorOfPairs() {
        Assert.assertEquals(UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, "one", 2, "two", 3, "three"), UnifiedMapWithHashingStrategy.newMapWith(INTEGER_HASHING_STRATEGY, Tuples.pair(1, "one"), Tuples.pair(2, "two"), Tuples.pair(3, "three")));
    }

    @Test
    public void constructorOfIterableOfPairs() {
        Pair<Integer, String> pair1 = Tuples.pair(1, "One");
        Pair<Integer, String> pair2 = Tuples.pair(2, "Two");
        Pair<Integer, String> pair3 = Tuples.pair(3, "Three");
        Pair<Integer, String> pair4 = Tuples.pair(4, "Four");
        UnifiedMapWithHashingStrategy<Integer, String> expected = UnifiedMapWithHashingStrategy.newMapWith(INTEGER_HASHING_STRATEGY, pair1, pair2, pair3, pair4);
        UnifiedMapWithHashingStrategy<Integer, String> actual1 = UnifiedMapWithHashingStrategy.newMapWith(INTEGER_HASHING_STRATEGY, FastList.newListWith(pair1, pair2, pair3, pair4));
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected.hashingStrategy(), actual1.hashingStrategy());
        UnifiedMapWithHashingStrategy<Integer, String> actual2 = UnifiedMapWithHashingStrategy.newMapWith(INTEGER_HASHING_STRATEGY, UnifiedSet.newSetWith(pair1, pair2, pair3, pair4));
        Assert.assertEquals(expected, actual2);
        Assert.assertEquals(expected.hashingStrategy(), actual2.hashingStrategy());
    }

    @Test
    public void newMap_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMapWithHashingStrategy<Integer, Integer>(INTEGER_HASHING_STRATEGY, -1, 0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMapWithHashingStrategy<Integer, Integer>(INTEGER_HASHING_STRATEGY, 1, -0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedMapWithHashingStrategy<Integer, Integer>(INTEGER_HASHING_STRATEGY, 1, 1.5f));
    }

    @Override
    @Test
    public void selectMap() {
        super.selectMap();
        UnifiedMapWithHashingStrategy<Person, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(JOHNDOE, 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void rejectMap() {
        super.rejectMap();
        UnifiedMapWithHashingStrategy<Person, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(JOHNDOE, 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collectMap() {
        super.collectMap();
        UnifiedMapWithHashingStrategy<Person, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JOHNSMITH, 2, JANEDOE, 3, JANESMITH, 4);
        Function2<Person, Integer, Pair<Integer, Person>> function = (Person argument1, Integer argument2) -> Tuples.pair(argument2, argument1);
        MutableMap<Integer, Person> collect = map.collect(function);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(3, 4), collect.keySet());
        Verify.assertContainsAll(collect.values(), JOHNDOE, JOHNSMITH);
    }

    @Test
    public void contains_with_hashing_strategy() {
        UnifiedMapWithHashingStrategy<Person, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue(2));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue(4));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue(1));
        Assert.assertFalse(map.containsValue(3));
    }

    @Test
    public void remove_with_hashing_strategy() {
        UnifiedMapWithHashingStrategy<Person, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        // Testing removing people
        Assert.assertEquals(2, map.remove(JANEDOE).intValue());
        Assert.assertEquals(4, map.remove(JOHNSMITH).intValue());
        Verify.assertEmpty(map);
        // Testing removing from a chain
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4);
        Assert.assertEquals(4, map2.remove(COLLISION_4).intValue());
        Assert.assertEquals(1, map2.remove(COLLISION_1).intValue());
        Verify.assertSize(2, map2);
        // Testing removing null from a chain
        UnifiedMapWithHashingStrategy<Integer, Integer> map3 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, null, 2, 3, 3, 4, null);
        Assert.assertEquals(2, map3.remove(null).intValue());
        Verify.assertSize(3, map3);
        Assert.assertNull(map3.remove(4));
        Verify.assertSize(2, map3);
    }

    @Test
    public void keySet_isEmpty() {
        Set<Integer> keySet = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2).keySet();
        Assert.assertFalse(keySet.isEmpty());
        keySet.clear();
        Verify.assertEmpty(keySet);
    }

    @Test
    public void keySet_with_hashing_strategy() {
        Set<Person> people = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4).keySet();
        Verify.assertSize(2, people);
        Verify.assertContains(JANEDOE, people);
        Verify.assertContains(JOHNDOE, people);
        Verify.assertContains(JANESMITH, people);
        Verify.assertContains(JOHNSMITH, people);
    }

    @Test
    public void keySet_Iterator_removeFromNonChain() {
        Set<Integer> keys = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2, 3, 3, 4, 4).keySet();
        Iterator<Integer> keysIterator = keys.iterator();
        keysIterator.next();
        keysIterator.remove();
        Verify.assertSetsEqual(UnifiedSet.newSetWith(2, 3, 4), keys);
    }

    @Test
    public void weakEntryToString() {
        Iterator<Map.Entry<Integer, Integer>> iterator = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1).entrySet().iterator();
        Map.Entry<Integer, Integer> element = iterator.next();
        Assert.assertEquals("1=1", element.toString());
    }

    @Override
    @Test
    public void valuesCollection_Iterator_remove() {
        // a map with a chain, remove one
        UnifiedMapWithHashingStrategy<Integer, Integer> map = this.mapWithCollisionsOfSize(3);
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.remove();
        Verify.assertSize(2, map);
        // remove all values in chain
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        Verify.assertEmpty(map);
    }

    @Test
    public void entry_equals_with_hashingStrategy() {
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2, 3, 3, 4, 4);
        Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = entryIterator.next();
        ImmutableEntry<Integer, Integer> immutableEntry = ImmutableEntry.of(entry.getKey(), entry.getValue());
        Verify.assertEqualsAndHashCode(immutableEntry, entry);
    }

    @Test
    public void entrySet_with_hashing_strategy() {
        Set<Map.Entry<Person, Integer>> entries = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4).entrySet();
        Verify.assertSize(2, entries);
        Verify.assertContains(ImmutableEntry.of(JOHNDOE, 2), entries);
        Verify.assertContains(ImmutableEntry.of(JANEDOE, 2), entries);
        Verify.assertContains(ImmutableEntry.of(JOHNSMITH, 4), entries);
        Verify.assertContains(ImmutableEntry.of(JANESMITH, 4), entries);
        Verify.assertNotContains(ImmutableEntry.of(JOHNDOE, 1), entries);
        Verify.assertNotContains(ImmutableEntry.of(JANESMITH, 3), entries);
        Assert.assertTrue(entries.remove(ImmutableEntry.of(JANESMITH, 4)));
        Verify.assertNotContains(ImmutableEntry.of(JOHNSMITH, 4), entries);
        Assert.assertTrue(entries.remove(ImmutableEntry.of(JOHNDOE, 2)));
        Verify.assertEmpty(entries);
    }

    @Test
    public void valuesCollection_containsAll() {
        Collection<Integer> values = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4).values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, 3, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, 3, 4, 5)));
    }

    @Test
    public void batchForEach() {
        UnifiedMapWithHashingStrategy<String, Integer> map = UnifiedMapWithHashingStrategy.<String, Integer>newMap(STRING_HASHING_STRATEGY, 5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        this.batchForEachTestCases(map, 10);
        UnifiedMapWithHashingStrategy<Integer, Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6);
        this.batchForEachChains(collisions, 21);
        UnifiedMapWithHashingStrategy<Integer, Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null);
        this.batchForEachNullHandling(nulls, 36);
        this.batchForEachEmptyBatchIterable(UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY));
    }

    @Test
    public void batchForEachKey() {
        Set<Integer> keys = UnifiedMapWithHashingStrategy.<Integer, String>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(1, "1", 2, "2", 3, "3", 4, "4").keySet();
        this.batchForEachTestCases((BatchIterable<Integer>) keys, 10);
        Set<Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).keySet();
        this.batchForEachChains((BatchIterable<Integer>) collisions, 57);
        Set<Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).keySet();
        this.batchForEachNullHandling((BatchIterable<Integer>) nulls, 16);
        this.batchForEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY).keySet());
    }

    @Test
    public void batchForEachValue() {
        Collection<Integer> values = UnifiedMapWithHashingStrategy.<String, Integer>newMap(STRING_HASHING_STRATEGY, 5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4).values();
        this.batchForEachTestCases((BatchIterable<Integer>) values, 10);
        Collection<Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).values();
        this.batchForEachChains((BatchIterable<Integer>) collisions, 21);
        Collection<Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).values();
        this.batchForEachNullHandling((BatchIterable<Integer>) nulls, 36);
        this.batchForEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY).values());
    }

    @Test
    public void batchForEachEntry() {
        // Testing batch size of 1 to 16 with no chains
        BatchIterable<Map.Entry<Integer, Integer>> entries = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2, 3, 3, 4, 4).entrySet();
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
        BatchIterable<Map.Entry<Integer, Integer>> collisions = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).entrySet();
        // Testing 1 batch with chains
        Sum sum2 = new IntegerSum(0);
        // testing getBatchCount returns 1
        int batchCount = collisions.getBatchCount(100000);
        for (int i = 0; i < batchCount; ++i) {
            collisions.batchForEach(new EntrySumProcedure(sum2), i, batchCount);
        }
        Assert.assertEquals(1, batchCount);
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
        BatchIterable<Map.Entry<Integer, Integer>> nulls = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).entrySet();
        int numBatches = nulls.getBatchCount(7);
        for (int i = 0; i < numBatches; ++i) {
            nulls.batchForEach(each -> {
                sum4.add(each.getKey() == null ? 1 : each.getKey());
                sum4.add(each.getValue() == null ? 1 : each.getValue());
            }, i, numBatches);
        }
        Assert.assertEquals(52, sum4.getValue());
    }

    @Test
    public void batchForEachEntry_emptySet() {
        // Test batchForEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum5 = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> empty = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY).entrySet();
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
        UnifiedMapWithHashingStrategy<String, Integer> map = UnifiedMapWithHashingStrategy.<String, Integer>newMap(STRING_HASHING_STRATEGY, 5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        this.batchIterable_forEach(map, 10);
        UnifiedMapWithHashingStrategy<Integer, Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6);
        this.batchIterable_forEach(collisions, 21);
        UnifiedMapWithHashingStrategy<Integer, Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null);
        this.batchIterable_forEachNullHandling(nulls, 33);
        this.batchIterable_forEachEmptyBatchIterable(UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY));
    }

    @Test
    public void batchIterable_forEachKey() {
        Set<Integer> keys = UnifiedMapWithHashingStrategy.<Integer, String>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(1, "1", 2, "2", 3, "3", 4, "4").keySet();
        this.batchIterable_forEach((BatchIterable<Integer>) keys, 10);
        Set<Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).keySet();
        this.batchIterable_forEach((BatchIterable<Integer>) collisions, 57);
        Set<Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).keySet();
        this.batchIterable_forEachNullHandling((BatchIterable<Integer>) nulls, 15);
        this.batchIterable_forEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY).keySet());
    }

    @Test
    public void batchIterable_forEachValue() {
        Collection<Integer> values = UnifiedMapWithHashingStrategy.<String, Integer>newMap(STRING_HASHING_STRATEGY, 5).withKeysValues("1", 1, "2", 2, "3", 3, "4", 4).values();
        this.batchIterable_forEach((BatchIterable<Integer>) values, 10);
        Collection<Integer> collisions = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).values();
        this.batchIterable_forEach((BatchIterable<Integer>) collisions, 21);
        Collection<Integer> nulls = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).values();
        this.batchIterable_forEachNullHandling((BatchIterable<Integer>) nulls, 33);
        this.batchIterable_forEachEmptyBatchIterable((BatchIterable<Integer>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY).values());
    }

    @Test
    public void batchIterable_forEachEntry() {
        BatchIterable<Map.Entry<Integer, Integer>> entries = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2, 3, 3, 4, 4).entrySet();
        Sum sum = new IntegerSum(0);
        entries.forEach(new EntrySumProcedure(sum));
        Assert.assertEquals(20, sum.getValue());
    }

    @Test
    public void batchIterable_forEachEntry_chains() {
        BatchIterable<Map.Entry<Integer, Integer>> collisions = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 5).withKeysValues(COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4).withKeysValues(2, 5, 3, 6).entrySet();
        Sum sum = new IntegerSum(0);
        collisions.forEach(new EntrySumProcedure(sum));
        Assert.assertEquals(78, sum.getValue());
    }

    @Test
    public void batchIterable_forEachEntry_null_handling() {
        // Testing batchForEach handling null keys and null values
        Sum sum = new IntegerSum(0);
        BatchIterable<Map.Entry<Integer, Integer>> nulls = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 100).withKeysValues(null, 10, 1, null, 2, 11, 3, 12).withKeysValues(4, null, 5, null).entrySet();
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
        BatchIterable<Map.Entry<Integer, Integer>> empty = (BatchIterable<Map.Entry<Integer, Integer>>) UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY).entrySet();
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

    @Override
    @Test
    public void forEachKeyValue() {
        super.forEachKeyValue();
        // Testing full chain
        UnifiedSet<Integer> keys = UnifiedSet.newSet();
        UnifiedSet<Integer> values = UnifiedSet.newSet();
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4).withKeysValues(1, 5);
        map.forEachKeyValue((argument1, argument2) -> {
            keys.add(argument1);
            values.add(argument2);
        });
        Verify.assertSetsEqual(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, 1), keys);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3, 4, 5), values);
        // Testing when chain contains null
        UnifiedSet<Integer> keys2 = UnifiedSet.newSet();
        UnifiedSet<Integer> values2 = UnifiedSet.newSet();
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, 1, 4);
        map2.forEachKeyValue((argument1, argument2) -> {
            keys2.add(argument1);
            values2.add(argument2);
        });
        Verify.assertSetsEqual(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, 1), keys2);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3, 4), values2);
    }

    @Test
    public void getMapMemoryUsedInWords() {
        UnifiedMapWithHashingStrategy<String, String> map = UnifiedMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
        Assert.assertEquals(34, map.getMapMemoryUsedInWords());
        map.put("1", "1");
        Assert.assertEquals(34, map.getMapMemoryUsedInWords());
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = this.mapWithCollisionsOfSize(2);
        Assert.assertEquals(16, map2.getMapMemoryUsedInWords());
    }

    @Test
    public void getHashingStrategy() {
        UnifiedMapWithHashingStrategy<Integer, Object> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY);
        Assert.assertSame(INTEGER_HASHING_STRATEGY, map.hashingStrategy());
    }

    @Test
    public void getCollidingBuckets() {
        UnifiedMapWithHashingStrategy<Object, Object> map = UnifiedMapWithHashingStrategy.newMap(HashingStrategies.defaultStrategy());
        Assert.assertEquals(0, map.getCollidingBuckets());
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = this.mapWithCollisionsOfSize(2);
        Assert.assertEquals(1, map2.getCollidingBuckets());
        map2.put(42, 42);
        Assert.assertEquals(1, map2.getCollidingBuckets());
        UnifiedMapWithHashingStrategy<String, String> map3 = UnifiedMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "Six", "6", "Bar", "-", "Three", "3", "Five", "5");
        Assert.assertEquals(2, map3.getCollidingBuckets());
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        super.getIfAbsentPut();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY, 2, 0.75f);
        MORE_COLLISIONS.forEach(Procedures.cast(each -> map.getIfAbsentPut(each, new PassThruFunction0<>(each))));
        Assert.assertEquals(this.mapWithCollisionsOfSize(9), map);
        // Testing getting element present in chain
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4);
        Assert.assertEquals(2, map2.getIfAbsentPut(COLLISION_2, () -> {
            Assert.fail();
            return null;
        }).intValue());
        // Testing rehashing while creating a new chained key
        UnifiedMapWithHashingStrategy<Integer, Integer> map3 = UnifiedMapWithHashingStrategy.<Integer, Integer>newMap(INTEGER_HASHING_STRATEGY, 2, 0.75f).withKeysValues(COLLISION_1, 1, 2, 2, 3, 3);
        Assert.assertEquals(4, map3.getIfAbsentPut(COLLISION_2, new PassThruFunction0<>(4)).intValue());
    }

    @Override
    @Test
    public void getIfAbsentPutValue() {
        super.getIfAbsentPutValue();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY, 2, 0.75f);
        MORE_COLLISIONS.forEach(Procedures.cast(each -> map.getIfAbsentPut(each, each)));
        Assert.assertEquals(this.mapWithCollisionsOfSize(9), map);
        // Testing getting element present in chain
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4);
        Assert.assertEquals(Integer.valueOf(2), map2.getIfAbsentPut(COLLISION_2, Integer.valueOf(5)));
        Assert.assertEquals(Integer.valueOf(5), map2.getIfAbsentPut(5, Integer.valueOf(5)));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        super.getIfAbsentPutWith();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY, 2, 0.75f);
        MORE_COLLISIONS.forEach(Procedures.cast(each -> map.getIfAbsentPutWith(each, Functions.getIntegerPassThru(), each)));
        Assert.assertEquals(this.mapWithCollisionsOfSize(9), map);
        // Testing getting element present in chain
        UnifiedMapWithHashingStrategy<Integer, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, COLLISION_1, 1, COLLISION_2, 2, COLLISION_3, 3, COLLISION_4, 4);
        Assert.assertEquals(Integer.valueOf(2), map2.getIfAbsentPutWith(COLLISION_2, Functions.getIntegerPassThru(), Integer.valueOf(5)));
        Assert.assertEquals(Integer.valueOf(5), map2.getIfAbsentPutWith(5, Functions.getIntegerPassThru(), Integer.valueOf(5)));
    }

    @Test
    public void equals_with_hashing_strategy() {
        UnifiedMapWithHashingStrategy<Person, Integer> map1 = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        UnifiedMapWithHashingStrategy<Person, Integer> map2 = UnifiedMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        UnifiedMapWithHashingStrategy<Person, Integer> map3 = UnifiedMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        UnifiedMapWithHashingStrategy<Person, Integer> map4 = UnifiedMapWithHashingStrategy.newMap(map3);
        Map<Person, Integer> hashMap = new HashMap<>(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        UnifiedMap<Person, Integer> unifiedMap = UnifiedMap.newWithKeysValues(JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        UnifiedMapWithHashingStrategy<Person, Integer> map5 = UnifiedMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, unifiedMap);
        Assert.assertNotEquals(map5, unifiedMap);
    }

    @Override
    @Test
    public void put() {
        super.put();
        // this map is deliberately small to force a rehash to occur from the put method, in a map with a chained bucket
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY, 2, 0.75f);
        COLLISIONS.forEach(0, 4, each -> Assert.assertNull(map.put(each, each)));
        Assert.assertEquals(this.mapWithCollisionsOfSize(5), map);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY);
        // Testing putting values in non chains
        Assert.assertNull(map.put(1, 1));
        Assert.assertNull(map.put(2, 2));
        Assert.assertNull(map.put(3, 3));
        Assert.assertNull(map.put(4, 4));
        Assert.assertNull(map.put(5, null));
        // Testing getting values from no chains
        Assert.assertEquals(1, map.get(1).intValue());
        Assert.assertEquals(2, map.get(2).intValue());
        Assert.assertNull(map.get(5));
        // Testing putting and getting elements in a chain
        Assert.assertNull(map.put(COLLISION_1, 1));
        Assert.assertNull(map.get(COLLISION_2));
        Assert.assertNull(map.put(COLLISION_2, 2));
        Assert.assertNull(map.get(COLLISION_3));
        Assert.assertNull(map.put(COLLISION_3, null));
        Assert.assertNull(map.put(COLLISION_4, 4));
        Assert.assertNull(map.put(COLLISION_5, 5));
        Assert.assertEquals(1, map.get(COLLISION_1).intValue());
        Assert.assertEquals(5, map.get(COLLISION_5).intValue());
        Assert.assertNull(map.get(COLLISION_3));
        map.remove(COLLISION_2);
        Assert.assertNull(map.get(COLLISION_2));
        // Testing for casting exceptions
        HashingStrategy<Person> lastName = new HashingStrategy<Person>() {

            public int computeHashCode(Person object) {
                return object.getLastName().hashCode();
            }

            public boolean equals(Person object1, Person object2) {
                return object1.equals(object2);
            }
        };
        UnifiedMapWithHashingStrategy<Person, Integer> map2 = UnifiedMapWithHashingStrategy.newMap(lastName);
        Assert.assertNull(map2.put(new Person("abe", "smith"), 1));
        Assert.assertNull(map2.put(new Person("brad", "smith"), 2));
        Assert.assertNull(map2.put(new Person("charlie", "smith"), 3));
    }

    @Test
    public void hashingStrategy() {
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 2, 2);
        Assert.assertSame(INTEGER_HASHING_STRATEGY, map.hashingStrategy());
    }

    @Test
    public void trimToSize() {
        UnifiedMapWithHashingStrategy<String, String> map = UnifiedMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
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
    protected UnifiedMapWithHashingStrategy<Integer, Integer> mapWithCollisionsOfSize(int size) {
        UnifiedMapWithHashingStrategy<Integer, Integer> map = UnifiedMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY, size);
        return this.populateMapWithCollisionsOfSize(size, map);
    }

    private static final class EntrySumProcedure implements Procedure<Map.Entry<Integer, Integer>> {

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

        private UnifiedMapWithHashingStrategyTest instance;

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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
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
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
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
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
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
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
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
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_WithEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_WithEmptyTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withPreSizedTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_clear);
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
        public void benchmark_noInstanceOfEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noInstanceOfEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_hashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_hashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_copyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_copyKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withEmptyTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withPreSizedTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_PostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_key_and_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_key_and_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValueWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValueWithCollisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithWithCollisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeBeforeIncrement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeBeforeIncrement);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_many_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_many_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_Iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_equals);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfIterableOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfIterableOfPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap_throws);
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
        public void benchmark_contains_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeFromNonChain() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeFromNonChain);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_weakEntryToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.weakEntryToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_Iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_Iterator_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equals_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equals_with_hashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_chains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_null_handling);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_emptySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_chains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_null_handling);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_emptySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getMapMemoryUsedInWords() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getMapMemoryUsedInWords);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getHashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollidingBuckets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollidingBuckets);
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
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_get_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_get_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_toArray_WithEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> noInstanceOfEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_hashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_copyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_toArray_withEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_PostSerializedEquality;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_PostSerializedEquality_chainedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> contains_key_and_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutValueWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutWithWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_Iterator_removeBeforeIncrement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> iterator_many_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valueCollection_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valueCollection_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> frequentCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> constructorOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> constructorOfIterableOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> keySet_Iterator_removeFromNonChain;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> weakEntryToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_Iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entry_equals_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> entrySet_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> valuesCollection_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchForEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> batchIterable_forEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getMapMemoryUsedInWords;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getCollidingBuckets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> put_get_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnifiedMapWithHashingStrategyTest::stream;
            this.payloads.parallelStream = UnifiedMapWithHashingStrategyTest::parallelStream;
            this.payloads.serialization = UnifiedMapWithHashingStrategyTest::serialization;
            this.payloads.isEmpty = UnifiedMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = UnifiedMapWithHashingStrategyTest::notEmpty;
            this.payloads.ifPresentApply = UnifiedMapWithHashingStrategyTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnifiedMapWithHashingStrategyTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnifiedMapWithHashingStrategyTest::getOrDefault;
            this.payloads.getIfAbsent = UnifiedMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnifiedMapWithHashingStrategyTest::getIfAbsentWith;
            this.payloads.tap = UnifiedMapWithHashingStrategyTest::tap;
            this.payloads.forEach = UnifiedMapWithHashingStrategyTest::forEach;
            this.payloads.injectIntoKeyValue = UnifiedMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnifiedMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.collectBoolean = UnifiedMapWithHashingStrategyTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedMapWithHashingStrategyTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnifiedMapWithHashingStrategyTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedMapWithHashingStrategyTest::collectByteWithTarget;
            this.payloads.collectChar = UnifiedMapWithHashingStrategyTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedMapWithHashingStrategyTest::collectCharWithTarget;
            this.payloads.collectDouble = UnifiedMapWithHashingStrategyTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedMapWithHashingStrategyTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnifiedMapWithHashingStrategyTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedMapWithHashingStrategyTest::collectFloatWithTarget;
            this.payloads.collectInt = UnifiedMapWithHashingStrategyTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedMapWithHashingStrategyTest::collectIntWithTarget;
            this.payloads.collectLong = UnifiedMapWithHashingStrategyTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedMapWithHashingStrategyTest::collectLongWithTarget;
            this.payloads.collectShort = UnifiedMapWithHashingStrategyTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedMapWithHashingStrategyTest::collectShortWithTarget;
            this.payloads.collectValues = UnifiedMapWithHashingStrategyTest::collectValues;
            this.payloads.select = UnifiedMapWithHashingStrategyTest::select;
            this.payloads.selectWith = UnifiedMapWithHashingStrategyTest::selectWith;
            this.payloads.reject = UnifiedMapWithHashingStrategyTest::reject;
            this.payloads.rejectWith = UnifiedMapWithHashingStrategyTest::rejectWith;
            this.payloads.collect = UnifiedMapWithHashingStrategyTest::collect;
            this.payloads.flatCollect = UnifiedMapWithHashingStrategyTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedMapWithHashingStrategyTest::flatCollectWith;
            this.payloads.flip = UnifiedMapWithHashingStrategyTest::flip;
            this.payloads.detect = UnifiedMapWithHashingStrategyTest::detect;
            this.payloads.detectOptional = UnifiedMapWithHashingStrategyTest::detectOptional;
            this.payloads.anySatisfy = UnifiedMapWithHashingStrategyTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedMapWithHashingStrategyTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedMapWithHashingStrategyTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedMapWithHashingStrategyTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedMapWithHashingStrategyTest::noneSatisfyWith;
            this.payloads.appendString = UnifiedMapWithHashingStrategyTest::appendString;
            this.payloads.toBag = UnifiedMapWithHashingStrategyTest::toBag;
            this.payloads.toSortedBag = UnifiedMapWithHashingStrategyTest::toSortedBag;
            this.payloads.toSortedBagBy = UnifiedMapWithHashingStrategyTest::toSortedBagBy;
            this.payloads.asLazy = UnifiedMapWithHashingStrategyTest::asLazy;
            this.payloads.toList = UnifiedMapWithHashingStrategyTest::toList;
            this.payloads.toMap = UnifiedMapWithHashingStrategyTest::toMap;
            this.payloads.toSet = UnifiedMapWithHashingStrategyTest::toSet;
            this.payloads.toSortedList = UnifiedMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSortedListBy = UnifiedMapWithHashingStrategyTest::toSortedListBy;
            this.payloads.toSortedSet = UnifiedMapWithHashingStrategyTest::toSortedSet;
            this.payloads.toSortedSetBy = UnifiedMapWithHashingStrategyTest::toSortedSetBy;
            this.payloads.toSortedMap = UnifiedMapWithHashingStrategyTest::toSortedMap;
            this.payloads.chunk = UnifiedMapWithHashingStrategyTest::chunk;
            this.payloads.collect_value = UnifiedMapWithHashingStrategyTest::collect_value;
            this.payloads.collectIf = UnifiedMapWithHashingStrategyTest::collectIf;
            this.payloads.collectWith = UnifiedMapWithHashingStrategyTest::collectWith;
            this.payloads.collectWithToTarget = UnifiedMapWithHashingStrategyTest::collectWithToTarget;
            this.payloads.contains = UnifiedMapWithHashingStrategyTest::contains;
            this.payloads.containsAnyIterable = UnifiedMapWithHashingStrategyTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedMapWithHashingStrategyTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnifiedMapWithHashingStrategyTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedMapWithHashingStrategyTest::containsNoneCollection;
            this.payloads.containsAll = UnifiedMapWithHashingStrategyTest::containsAll;
            this.payloads.containsKey = UnifiedMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = UnifiedMapWithHashingStrategyTest::containsValue;
            this.payloads.getFirst = UnifiedMapWithHashingStrategyTest::getFirst;
            this.payloads.getLast = UnifiedMapWithHashingStrategyTest::getLast;
            this.payloads.getOnly = UnifiedMapWithHashingStrategyTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnifiedMapWithHashingStrategyTest::containsAllIterable;
            this.payloads.containsAllArguments = UnifiedMapWithHashingStrategyTest::containsAllArguments;
            this.payloads.count = UnifiedMapWithHashingStrategyTest::count;
            this.payloads.countWith = UnifiedMapWithHashingStrategyTest::countWith;
            this.payloads.detect_value = UnifiedMapWithHashingStrategyTest::detect_value;
            this.payloads.detectOptional_value = UnifiedMapWithHashingStrategyTest::detectOptional_value;
            this.payloads.detectWith = UnifiedMapWithHashingStrategyTest::detectWith;
            this.payloads.detectWithOptional = UnifiedMapWithHashingStrategyTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnifiedMapWithHashingStrategyTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnifiedMapWithHashingStrategyTest::detectWithIfNone;
            this.payloads.flatten_value = UnifiedMapWithHashingStrategyTest::flatten_value;
            this.payloads.countBy = UnifiedMapWithHashingStrategyTest::countBy;
            this.payloads.countByWith = UnifiedMapWithHashingStrategyTest::countByWith;
            this.payloads.countByEach = UnifiedMapWithHashingStrategyTest::countByEach;
            this.payloads.groupBy = UnifiedMapWithHashingStrategyTest::groupBy;
            this.payloads.groupByEach = UnifiedMapWithHashingStrategyTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedMapWithHashingStrategyTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedMapWithHashingStrategyTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnifiedMapWithHashingStrategyTest::injectInto;
            this.payloads.injectIntoInt = UnifiedMapWithHashingStrategyTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedMapWithHashingStrategyTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnifiedMapWithHashingStrategyTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnifiedMapWithHashingStrategyTest::injectIntoDouble;
            this.payloads.sumOfInt = UnifiedMapWithHashingStrategyTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedMapWithHashingStrategyTest::sumOfLong;
            this.payloads.testAggregateBy = UnifiedMapWithHashingStrategyTest::testAggregateBy;
            this.payloads.sumOfFloat = UnifiedMapWithHashingStrategyTest::sumOfFloat;
            this.payloads.sumOfDouble = UnifiedMapWithHashingStrategyTest::sumOfDouble;
            this.payloads.sumByInt = UnifiedMapWithHashingStrategyTest::sumByInt;
            this.payloads.sumByFloat = UnifiedMapWithHashingStrategyTest::sumByFloat;
            this.payloads.sumByLong = UnifiedMapWithHashingStrategyTest::sumByLong;
            this.payloads.sumByDouble = UnifiedMapWithHashingStrategyTest::sumByDouble;
            this.payloads.makeString = UnifiedMapWithHashingStrategyTest::makeString;
            this.payloads.min = UnifiedMapWithHashingStrategyTest::min;
            this.payloads.max = UnifiedMapWithHashingStrategyTest::max;
            this.payloads.minBy = UnifiedMapWithHashingStrategyTest::minBy;
            this.payloads.maxBy = UnifiedMapWithHashingStrategyTest::maxBy;
            this.payloads.reject_value = UnifiedMapWithHashingStrategyTest::reject_value;
            this.payloads.rejectWith_value = UnifiedMapWithHashingStrategyTest::rejectWith_value;
            this.payloads.select_value = UnifiedMapWithHashingStrategyTest::select_value;
            this.payloads.selectWith_value = UnifiedMapWithHashingStrategyTest::selectWith_value;
            this.payloads.partition_value = UnifiedMapWithHashingStrategyTest::partition_value;
            this.payloads.partitionWith_value = UnifiedMapWithHashingStrategyTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnifiedMapWithHashingStrategyTest::selectInstancesOf_value;
            this.payloads.toArray = UnifiedMapWithHashingStrategyTest::toArray;
            this.payloads.zip = UnifiedMapWithHashingStrategyTest::zip;
            this.payloads.zipWithIndex = UnifiedMapWithHashingStrategyTest::zipWithIndex;
            this.payloads.aggregateByMutating = UnifiedMapWithHashingStrategyTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedMapWithHashingStrategyTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnifiedMapWithHashingStrategyTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnifiedMapWithHashingStrategyTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = UnifiedMapWithHashingStrategyTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnifiedMapWithHashingStrategyTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnifiedMapWithHashingStrategyTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnifiedMapWithHashingStrategyTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnifiedMapWithHashingStrategyTest::newMapWithWithWithWith;
            this.payloads.iterator = UnifiedMapWithHashingStrategyTest::iterator;
            this.payloads.keysView = UnifiedMapWithHashingStrategyTest::keysView;
            this.payloads.valuesView = UnifiedMapWithHashingStrategyTest::valuesView;
            this.payloads.test_toString = UnifiedMapWithHashingStrategyTest::test_toString;
            this.payloads.toImmutable = UnifiedMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = UnifiedMapWithHashingStrategyTest::clear;
            this.payloads.removeObject = UnifiedMapWithHashingStrategyTest::removeObject;
            this.payloads.removeAllFromEntrySet = UnifiedMapWithHashingStrategyTest::removeAllFromEntrySet;
            this.payloads.clearEntrySet = UnifiedMapWithHashingStrategyTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = UnifiedMapWithHashingStrategyTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = UnifiedMapWithHashingStrategyTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnifiedMapWithHashingStrategyTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = UnifiedMapWithHashingStrategyTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = UnifiedMapWithHashingStrategyTest::retainAllFromKeySet;
            this.payloads.clearKeySet = UnifiedMapWithHashingStrategyTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = UnifiedMapWithHashingStrategyTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnifiedMapWithHashingStrategyTest::keySetToArray;
            this.payloads.removeFromValues = UnifiedMapWithHashingStrategyTest::removeFromValues;
            this.payloads.removeNullFromValues = UnifiedMapWithHashingStrategyTest::removeNullFromValues;
            this.payloads.removeAllFromValues = UnifiedMapWithHashingStrategyTest::removeAllFromValues;
            this.payloads.retainAllFromValues = UnifiedMapWithHashingStrategyTest::retainAllFromValues;
            this.payloads.putAll = UnifiedMapWithHashingStrategyTest::putAll;
            this.payloads.removeKey = UnifiedMapWithHashingStrategyTest::removeKey;
            this.payloads.removeAllKeys = UnifiedMapWithHashingStrategyTest::removeAllKeys;
            this.payloads.removeIf = UnifiedMapWithHashingStrategyTest::removeIf;
            this.payloads.getIfAbsentPutWithKey = UnifiedMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPut_block_throws = UnifiedMapWithHashingStrategyTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = UnifiedMapWithHashingStrategyTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = UnifiedMapWithHashingStrategyTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnifiedMapWithHashingStrategyTest::newEmpty;
            this.payloads.keysAndValues_toString = UnifiedMapWithHashingStrategyTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnifiedMapWithHashingStrategyTest::keyPreservation;
            this.payloads.asUnmodifiable = UnifiedMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = UnifiedMapWithHashingStrategyTest::asSynchronized;
            this.payloads.add = UnifiedMapWithHashingStrategyTest::add;
            this.payloads.putPair = UnifiedMapWithHashingStrategyTest::putPair;
            this.payloads.withKeyValue = UnifiedMapWithHashingStrategyTest::withKeyValue;
            this.payloads.withMap = UnifiedMapWithHashingStrategyTest::withMap;
            this.payloads.withMapEmpty = UnifiedMapWithHashingStrategyTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnifiedMapWithHashingStrategyTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnifiedMapWithHashingStrategyTest::withMapNull;
            this.payloads.withMapIterable = UnifiedMapWithHashingStrategyTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnifiedMapWithHashingStrategyTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnifiedMapWithHashingStrategyTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnifiedMapWithHashingStrategyTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnifiedMapWithHashingStrategyTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnifiedMapWithHashingStrategyTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnifiedMapWithHashingStrategyTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnifiedMapWithHashingStrategyTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = UnifiedMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = UnifiedMapWithHashingStrategyTest::withAllKeyValueArguments;
            this.payloads.withoutKey = UnifiedMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = UnifiedMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedMapWithHashingStrategyTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedMapWithHashingStrategyTest::rehash_null_collision;
            this.payloads.updateValue = UnifiedMapWithHashingStrategyTest::updateValue;
            this.payloads.updateValue_collisions = UnifiedMapWithHashingStrategyTest::updateValue_collisions;
            this.payloads.updateValueWith = UnifiedMapWithHashingStrategyTest::updateValueWith;
            this.payloads.updateValueWith_collisions = UnifiedMapWithHashingStrategyTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = UnifiedMapWithHashingStrategyTest::collectKeysAndValues;
            this.payloads.testClone = UnifiedMapWithHashingStrategyTest::testClone;
            this.payloads.valuesCollection_toArray = UnifiedMapWithHashingStrategyTest::valuesCollection_toArray;
            this.payloads.valuesCollection_toArray_WithEmptyTarget = UnifiedMapWithHashingStrategyTest::valuesCollection_toArray_WithEmptyTarget;
            this.payloads.valuesCollection_toArray_withPreSizedTarget = UnifiedMapWithHashingStrategyTest::valuesCollection_toArray_withPreSizedTarget;
            this.payloads.valuesCollection_toArray_withLargeTarget = UnifiedMapWithHashingStrategyTest::valuesCollection_toArray_withLargeTarget;
            this.payloads.entrySet_clear = UnifiedMapWithHashingStrategyTest::entrySet_clear;
            this.payloads.valuesCollection_clear = UnifiedMapWithHashingStrategyTest::valuesCollection_clear;
            this.payloads.keySet_toArray_withSmallTarget = UnifiedMapWithHashingStrategyTest::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = UnifiedMapWithHashingStrategyTest::keySet_ToArray_withLargeTarget;
            this.payloads.noInstanceOfEquals = UnifiedMapWithHashingStrategyTest::noInstanceOfEquals;
            this.payloads.keySet_hashCode = UnifiedMapWithHashingStrategyTest::keySet_hashCode;
            this.payloads.keySet_copyKeys = UnifiedMapWithHashingStrategyTest::keySet_copyKeys;
            this.payloads.entrySet_toArray = UnifiedMapWithHashingStrategyTest::entrySet_toArray;
            this.payloads.entrySet_toArray_withEmptyTarget = UnifiedMapWithHashingStrategyTest::entrySet_toArray_withEmptyTarget;
            this.payloads.entrySet_toArray_withPreSizedTarget = UnifiedMapWithHashingStrategyTest::entrySet_toArray_withPreSizedTarget;
            this.payloads.entrySet_toArray_withLargeTarget = UnifiedMapWithHashingStrategyTest::entrySet_toArray_withLargeTarget;
            this.payloads.entrySet_PostSerializedEqualsAndHashCode = UnifiedMapWithHashingStrategyTest::entrySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode = UnifiedMapWithHashingStrategyTest::keySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot = UnifiedMapWithHashingStrategyTest::keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;
            this.payloads.valuesCollection_PostSerializedEquality = UnifiedMapWithHashingStrategyTest::valuesCollection_PostSerializedEquality;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMap = UnifiedMapWithHashingStrategyTest::valuesCollection_PostSerializedEquality_chainedMap;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot = UnifiedMapWithHashingStrategyTest::valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;
            this.payloads.contains_key_and_value = UnifiedMapWithHashingStrategyTest::contains_key_and_value;
            this.payloads.remove = UnifiedMapWithHashingStrategyTest::remove;
            this.payloads.getIfAbsentPutValueWithCollisions = UnifiedMapWithHashingStrategyTest::getIfAbsentPutValueWithCollisions;
            this.payloads.getIfAbsentPutWithWithCollisions = UnifiedMapWithHashingStrategyTest::getIfAbsentPutWithWithCollisions;
            this.payloads.removeFromEntrySet = UnifiedMapWithHashingStrategyTest::removeFromEntrySet;
            this.payloads.retainAllFromEntrySet = UnifiedMapWithHashingStrategyTest::retainAllFromEntrySet;
            this.payloads.forEachWith = UnifiedMapWithHashingStrategyTest::forEachWith;
            this.payloads.keySet_retainAll = UnifiedMapWithHashingStrategyTest::keySet_retainAll;
            this.payloads.keySet_containsAll = UnifiedMapWithHashingStrategyTest::keySet_containsAll;
            this.payloads.keySet_equals = UnifiedMapWithHashingStrategyTest::keySet_equals;
            this.payloads.keySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::keySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::keySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::keySet_Iterator, java.util.NoSuchElementException.class);
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.keySet_Iterator_removeBeforeIncrement = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::keySet_Iterator_removeBeforeIncrement, java.lang.IllegalStateException.class);
            this.payloads.iterator_many_collisions = UnifiedMapWithHashingStrategyTest::iterator_many_collisions;
            this.payloads.entry_setValue = UnifiedMapWithHashingStrategyTest::entry_setValue;
            this.payloads.entry_hashCodeForNullKeyAndValue = UnifiedMapWithHashingStrategyTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equalsWithNonEntry = UnifiedMapWithHashingStrategyTest::entry_equalsWithNonEntry;
            this.payloads.entrySet_remove = UnifiedMapWithHashingStrategyTest::entrySet_remove;
            this.payloads.entrySet_contains = UnifiedMapWithHashingStrategyTest::entrySet_contains;
            this.payloads.entrySet_containsAll = UnifiedMapWithHashingStrategyTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = UnifiedMapWithHashingStrategyTest::entrySet_equals;
            this.payloads.valuesCollection_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::valuesCollection_add, java.lang.UnsupportedOperationException.class);
            this.payloads.valuesCollection_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::valuesCollection_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.valueCollection_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyTest::valueCollection_Iterator, java.util.NoSuchElementException.class);
            this.payloads.valueCollection_equals = UnifiedMapWithHashingStrategyTest::valueCollection_equals;
            this.payloads.forEachWithIndex = UnifiedMapWithHashingStrategyTest::forEachWithIndex;
            this.payloads.forEachKey = UnifiedMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachValue = UnifiedMapWithHashingStrategyTest::forEachValue;
            this.payloads.equalsAndHashCode = UnifiedMapWithHashingStrategyTest::equalsAndHashCode;
            this.payloads.frequentCollision = UnifiedMapWithHashingStrategyTest::frequentCollision;
            this.payloads.constructorOfPairs = UnifiedMapWithHashingStrategyTest::constructorOfPairs;
            this.payloads.constructorOfIterableOfPairs = UnifiedMapWithHashingStrategyTest::constructorOfIterableOfPairs;
            this.payloads.newMap_throws = UnifiedMapWithHashingStrategyTest::newMap_throws;
            this.payloads.selectMap = UnifiedMapWithHashingStrategyTest::selectMap;
            this.payloads.rejectMap = UnifiedMapWithHashingStrategyTest::rejectMap;
            this.payloads.collectMap = UnifiedMapWithHashingStrategyTest::collectMap;
            this.payloads.contains_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.keySet_isEmpty = UnifiedMapWithHashingStrategyTest::keySet_isEmpty;
            this.payloads.keySet_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::keySet_with_hashing_strategy;
            this.payloads.keySet_Iterator_removeFromNonChain = UnifiedMapWithHashingStrategyTest::keySet_Iterator_removeFromNonChain;
            this.payloads.weakEntryToString = UnifiedMapWithHashingStrategyTest::weakEntryToString;
            this.payloads.valuesCollection_Iterator_remove = UnifiedMapWithHashingStrategyTest::valuesCollection_Iterator_remove;
            this.payloads.entry_equals_with_hashingStrategy = UnifiedMapWithHashingStrategyTest::entry_equals_with_hashingStrategy;
            this.payloads.entrySet_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::entrySet_with_hashing_strategy;
            this.payloads.valuesCollection_containsAll = UnifiedMapWithHashingStrategyTest::valuesCollection_containsAll;
            this.payloads.batchForEach = UnifiedMapWithHashingStrategyTest::batchForEach;
            this.payloads.batchForEachKey = UnifiedMapWithHashingStrategyTest::batchForEachKey;
            this.payloads.batchForEachValue = UnifiedMapWithHashingStrategyTest::batchForEachValue;
            this.payloads.batchForEachEntry = UnifiedMapWithHashingStrategyTest::batchForEachEntry;
            this.payloads.batchForEachEntry_chains = UnifiedMapWithHashingStrategyTest::batchForEachEntry_chains;
            this.payloads.batchForEachEntry_null_handling = UnifiedMapWithHashingStrategyTest::batchForEachEntry_null_handling;
            this.payloads.batchForEachEntry_emptySet = UnifiedMapWithHashingStrategyTest::batchForEachEntry_emptySet;
            this.payloads.batchIterable_forEach = UnifiedMapWithHashingStrategyTest::batchIterable_forEach;
            this.payloads.batchIterable_forEachKey = UnifiedMapWithHashingStrategyTest::batchIterable_forEachKey;
            this.payloads.batchIterable_forEachValue = UnifiedMapWithHashingStrategyTest::batchIterable_forEachValue;
            this.payloads.batchIterable_forEachEntry = UnifiedMapWithHashingStrategyTest::batchIterable_forEachEntry;
            this.payloads.batchIterable_forEachEntry_chains = UnifiedMapWithHashingStrategyTest::batchIterable_forEachEntry_chains;
            this.payloads.batchIterable_forEachEntry_null_handling = UnifiedMapWithHashingStrategyTest::batchIterable_forEachEntry_null_handling;
            this.payloads.batchIterable_forEachEntry_emptySet = UnifiedMapWithHashingStrategyTest::batchIterable_forEachEntry_emptySet;
            this.payloads.forEachKeyValue = UnifiedMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.getMapMemoryUsedInWords = UnifiedMapWithHashingStrategyTest::getMapMemoryUsedInWords;
            this.payloads.getHashingStrategy = UnifiedMapWithHashingStrategyTest::getHashingStrategy;
            this.payloads.getCollidingBuckets = UnifiedMapWithHashingStrategyTest::getCollidingBuckets;
            this.payloads.getIfAbsentPut = UnifiedMapWithHashingStrategyTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = UnifiedMapWithHashingStrategyTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWith = UnifiedMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.equals_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put = UnifiedMapWithHashingStrategyTest::put;
            this.payloads.put_get_with_hashing_strategy = UnifiedMapWithHashingStrategyTest::put_get_with_hashing_strategy;
            this.payloads.hashingStrategy = UnifiedMapWithHashingStrategyTest::hashingStrategy;
            this.payloads.trimToSize = UnifiedMapWithHashingStrategyTest::trimToSize;
        }
    }
}
