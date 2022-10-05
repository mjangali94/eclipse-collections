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

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectIntHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectIntHashMapWithHashingStrategyTest extends ObjectIntHashMapTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);

    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final HashingStrategy<Person> CONSTANT_HASHCODE_STRATEGY = new HashingStrategy<Person>() {

        @Override
        public int computeHashCode(Person object) {
            return 0;
        }

        @Override
        public boolean equals(Person person1, Person person2) {
            return person1.getLastName().equals(person2.getLastName());
        }
    };

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    private final ObjectIntHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectIntHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", 0, "1", 1, "2", 2);
    }

    @Override
    protected <T> ObjectIntHashMapWithHashingStrategy<T> newWithKeysValues(T key1, int value1) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectIntHashMapWithHashingStrategy<T> newWithKeysValues(T key1, int value1, T key2, int value2) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectIntHashMapWithHashingStrategy<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectIntHashMapWithHashingStrategy<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectIntHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectIntHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectIntMap newMapWithInitialCapacity(int size) {
        return new ObjectIntHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectIntHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectIntHashMapWithHashingStrategy<Person> map = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(JOHNDOE, 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectIntHashMapWithHashingStrategy<Person> map = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(JOHNDOE, 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectIntHashMapWithHashingStrategy<Person> map = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        IntToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectIntHashMapWithHashingStrategy<Person> map = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
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
        ObjectIntHashMapWithHashingStrategy<Person> map = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectIntHashMapWithHashingStrategy<String> map2 = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0, collidingKeys.get(1), 1, collidingKeys.get(2), 2, collidingKeys.get(3), 3);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0, collidingKeys.get(1), 1, collidingKeys.get(2), 2), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), 1, collidingKeys.get(2), 2), map2);
        Verify.assertSize(2, map2);
        ObjectIntHashMapWithHashingStrategy<Integer> map3 = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, null, 2, 3, 3);
        map3.remove(null);
        Assert.assertEquals(ObjectIntHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1, 3, 3), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectIntHashMapWithHashingStrategy<Person> map1 = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        ObjectIntHashMapWithHashingStrategy<Person> map2 = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        ObjectIntHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, 1, JANEDOE, 1, JOHNSMITH, 1, JANESMITH, 1);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectIntHashMapWithHashingStrategy<Person> map3 = ObjectIntHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        ObjectIntHashMapWithHashingStrategy<Person> map4 = ObjectIntHashMapWithHashingStrategy.newMap(map3);
        ObjectIntMap hashMap = ObjectIntMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectIntHashMap<Person> objectMap = ObjectIntHashMap.newWithKeysValues(JOHNDOE, 1, JANEDOE, 2, JOHNSMITH, 3, JANESMITH, 4);
        ObjectIntHashMapWithHashingStrategy<Person> map5 = ObjectIntHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectIntHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, 5);
        // Testing getting values from no chains
        Assert.assertEquals(1, map.get("1"));
        Assert.assertEquals(2, map.get("2"));
        Assert.assertEquals(5, map.get(null));
        ObjectIntHashMapWithHashingStrategy<Person> map2 = ObjectIntHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, 1);
        Assert.assertEquals(1, map2.get(JOHNSMITH));
        map2.put(JANESMITH, 2);
        Assert.assertEquals(2, map2.get(JOHNSMITH));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntHashMapWithHashingStrategyTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
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
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
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
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnClear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_get_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_get_with_hashing_strategy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntHashMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyTest> put_get_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectIntHashMapWithHashingStrategyTest::keySet;
            this.payloads.values = ObjectIntHashMapWithHashingStrategyTest::values;
            this.payloads.isEmpty = ObjectIntHashMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = ObjectIntHashMapWithHashingStrategyTest::notEmpty;
            this.payloads.asLazy = ObjectIntHashMapWithHashingStrategyTest::asLazy;
            this.payloads.testEquals = ObjectIntHashMapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = ObjectIntHashMapWithHashingStrategyTest::testHashCode;
            this.payloads.testToString = ObjectIntHashMapWithHashingStrategyTest::testToString;
            this.payloads.intIterator = ObjectIntHashMapWithHashingStrategyTest::intIterator;
            this.payloads.forEach = ObjectIntHashMapWithHashingStrategyTest::forEach;
            this.payloads.forEachValue = ObjectIntHashMapWithHashingStrategyTest::forEachValue;
            this.payloads.forEachKey = ObjectIntHashMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectIntHashMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectIntHashMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectIntHashMapWithHashingStrategyTest::makeString;
            this.payloads.appendString = ObjectIntHashMapWithHashingStrategyTest::appendString;
            this.payloads.tap = ObjectIntHashMapWithHashingStrategyTest::tap;
            this.payloads.count = ObjectIntHashMapWithHashingStrategyTest::count;
            this.payloads.anySatisfy = ObjectIntHashMapWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ObjectIntHashMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectIntHashMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectIntHashMapWithHashingStrategyTest::detectIfNone;
            this.payloads.sum = ObjectIntHashMapWithHashingStrategyTest::sum;
            this.payloads.max = ObjectIntHashMapWithHashingStrategyTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectIntHashMapWithHashingStrategyTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectIntHashMapWithHashingStrategyTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectIntHashMapWithHashingStrategyTest::minIfEmpty;
            this.payloads.average = ObjectIntHashMapWithHashingStrategyTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectIntHashMapWithHashingStrategyTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectIntHashMapWithHashingStrategyTest::toArray;
            this.payloads.toSortedArray = ObjectIntHashMapWithHashingStrategyTest::toSortedArray;
            this.payloads.containsAll = ObjectIntHashMapWithHashingStrategyTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectIntHashMapWithHashingStrategyTest::containsAll_Iterable;
            this.payloads.toList = ObjectIntHashMapWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ObjectIntHashMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSet = ObjectIntHashMapWithHashingStrategyTest::toSet;
            this.payloads.toBag = ObjectIntHashMapWithHashingStrategyTest::toBag;
            this.payloads.toImmutable = ObjectIntHashMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = ObjectIntHashMapWithHashingStrategyTest::clear;
            this.payloads.removeKey = ObjectIntHashMapWithHashingStrategyTest::removeKey;
            this.payloads.remove = ObjectIntHashMapWithHashingStrategyTest::remove;
            this.payloads.put = ObjectIntHashMapWithHashingStrategyTest::put;
            this.payloads.updateValues = ObjectIntHashMapWithHashingStrategyTest::updateValues;
            this.payloads.putPair = ObjectIntHashMapWithHashingStrategyTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectIntHashMapWithHashingStrategyTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectIntHashMapWithHashingStrategyTest::get;
            this.payloads.getOrThrow = ObjectIntHashMapWithHashingStrategyTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectIntHashMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectIntHashMapWithHashingStrategyTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectIntHashMapWithHashingStrategyTest::updateValue;
            this.payloads.addToValue = ObjectIntHashMapWithHashingStrategyTest::addToValue;
            this.payloads.containsKey = ObjectIntHashMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = ObjectIntHashMapWithHashingStrategyTest::containsValue;
            this.payloads.size = ObjectIntHashMapWithHashingStrategyTest::size;
            this.payloads.withKeysValues = ObjectIntHashMapWithHashingStrategyTest::withKeysValues;
            this.payloads.withoutKey = ObjectIntHashMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectIntHashMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectIntHashMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.contains = ObjectIntHashMapWithHashingStrategyTest::contains;
            this.payloads.asUnmodifiable = ObjectIntHashMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectIntHashMapWithHashingStrategyTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectIntHashMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectIntHashMapWithHashingStrategyTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectIntHashMapWithHashingStrategyTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectIntHashMapWithHashingStrategyTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectIntHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectIntHashMapWithHashingStrategyTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectIntHashMapWithHashingStrategyTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectIntHashMapWithHashingStrategyTest::putWithRehash;
            this.payloads.testPutAll = ObjectIntHashMapWithHashingStrategyTest::testPutAll;
            this.payloads.injectInto = ObjectIntHashMapWithHashingStrategyTest::injectInto;
            this.payloads.put_every_slot = ObjectIntHashMapWithHashingStrategyTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectIntHashMapWithHashingStrategyTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectIntHashMapWithHashingStrategyTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectIntHashMapWithHashingStrategyTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectIntHashMapWithHashingStrategyTest::classIsNonInstantiable;
            this.payloads.select = ObjectIntHashMapWithHashingStrategyTest::select;
            this.payloads.reject = ObjectIntHashMapWithHashingStrategyTest::reject;
            this.payloads.collect = ObjectIntHashMapWithHashingStrategyTest::collect;
            this.payloads.contains_with_hashing_strategy = ObjectIntHashMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = ObjectIntHashMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = ObjectIntHashMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put_get_with_hashing_strategy = ObjectIntHashMapWithHashingStrategyTest::put_get_with_hashing_strategy;
        }
    }
}
