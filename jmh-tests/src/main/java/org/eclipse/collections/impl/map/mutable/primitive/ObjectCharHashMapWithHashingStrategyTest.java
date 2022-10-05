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
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyTest extends ObjectCharHashMapTestCase {

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

    private final ObjectCharHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectCharHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", (char) 0, "1", (char) 1, "2", (char) 2);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectCharHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectCharMap newMapWithInitialCapacity(int size) {
        return new ObjectCharHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectCharHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        CharToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue((char) 2));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue((char) 4));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue((char) 1));
        Assert.assertFalse(map.containsValue((char) 3));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (char) 4), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectCharHashMapWithHashingStrategy<String> map2 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (char) 0, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2, collidingKeys.get(3), (char) 3);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (char) 0, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2), map2);
        Verify.assertSize(2, map2);
        ObjectCharHashMapWithHashingStrategy<Integer> map3 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (char) 1, null, (char) 2, 3, (char) 3);
        map3.remove(null);
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (char) 1, 3, (char) 3), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectCharHashMapWithHashingStrategy<Person> map1 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);
        ObjectCharHashMapWithHashingStrategy<Person> map2 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);
        ObjectCharHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectCharHashMapWithHashingStrategy<Person> map3 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        ObjectCharHashMapWithHashingStrategy<Person> map4 = ObjectCharHashMapWithHashingStrategy.newMap(map3);
        ObjectCharMap hashMap = ObjectCharMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectCharHashMap<Person> objectMap = ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        ObjectCharHashMapWithHashingStrategy<Person> map5 = ObjectCharHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectCharHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, (char) 5);
        // Testing getting values from no chains
        Assert.assertEquals((char) 1, map.get("1"));
        Assert.assertEquals((char) 2, map.get("2"));
        Assert.assertEquals((char) 5, map.get(null));
        ObjectCharHashMapWithHashingStrategy<Person> map2 = ObjectCharHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, (char) 1);
        Assert.assertEquals((char) 1, map2.get(JOHNSMITH));
        map2.put(JANESMITH, (char) 2);
        Assert.assertEquals((char) 2, map2.get(JOHNSMITH));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharHashMapWithHashingStrategyTest instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharHashMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyTest> put_get_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectCharHashMapWithHashingStrategyTest::keySet;
            this.payloads.values = ObjectCharHashMapWithHashingStrategyTest::values;
            this.payloads.isEmpty = ObjectCharHashMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = ObjectCharHashMapWithHashingStrategyTest::notEmpty;
            this.payloads.asLazy = ObjectCharHashMapWithHashingStrategyTest::asLazy;
            this.payloads.testEquals = ObjectCharHashMapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = ObjectCharHashMapWithHashingStrategyTest::testHashCode;
            this.payloads.testToString = ObjectCharHashMapWithHashingStrategyTest::testToString;
            this.payloads.charIterator = ObjectCharHashMapWithHashingStrategyTest::charIterator;
            this.payloads.forEach = ObjectCharHashMapWithHashingStrategyTest::forEach;
            this.payloads.forEachValue = ObjectCharHashMapWithHashingStrategyTest::forEachValue;
            this.payloads.forEachKey = ObjectCharHashMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectCharHashMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectCharHashMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectCharHashMapWithHashingStrategyTest::makeString;
            this.payloads.appendString = ObjectCharHashMapWithHashingStrategyTest::appendString;
            this.payloads.tap = ObjectCharHashMapWithHashingStrategyTest::tap;
            this.payloads.count = ObjectCharHashMapWithHashingStrategyTest::count;
            this.payloads.anySatisfy = ObjectCharHashMapWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ObjectCharHashMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectCharHashMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectCharHashMapWithHashingStrategyTest::detectIfNone;
            this.payloads.sum = ObjectCharHashMapWithHashingStrategyTest::sum;
            this.payloads.max = ObjectCharHashMapWithHashingStrategyTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectCharHashMapWithHashingStrategyTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectCharHashMapWithHashingStrategyTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectCharHashMapWithHashingStrategyTest::minIfEmpty;
            this.payloads.average = ObjectCharHashMapWithHashingStrategyTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectCharHashMapWithHashingStrategyTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectCharHashMapWithHashingStrategyTest::toArray;
            this.payloads.toSortedArray = ObjectCharHashMapWithHashingStrategyTest::toSortedArray;
            this.payloads.containsAll = ObjectCharHashMapWithHashingStrategyTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectCharHashMapWithHashingStrategyTest::containsAll_Iterable;
            this.payloads.toList = ObjectCharHashMapWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ObjectCharHashMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSet = ObjectCharHashMapWithHashingStrategyTest::toSet;
            this.payloads.toBag = ObjectCharHashMapWithHashingStrategyTest::toBag;
            this.payloads.toImmutable = ObjectCharHashMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = ObjectCharHashMapWithHashingStrategyTest::clear;
            this.payloads.removeKey = ObjectCharHashMapWithHashingStrategyTest::removeKey;
            this.payloads.remove = ObjectCharHashMapWithHashingStrategyTest::remove;
            this.payloads.put = ObjectCharHashMapWithHashingStrategyTest::put;
            this.payloads.updateValues = ObjectCharHashMapWithHashingStrategyTest::updateValues;
            this.payloads.putPair = ObjectCharHashMapWithHashingStrategyTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectCharHashMapWithHashingStrategyTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectCharHashMapWithHashingStrategyTest::get;
            this.payloads.getOrThrow = ObjectCharHashMapWithHashingStrategyTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectCharHashMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectCharHashMapWithHashingStrategyTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectCharHashMapWithHashingStrategyTest::updateValue;
            this.payloads.addToValue = ObjectCharHashMapWithHashingStrategyTest::addToValue;
            this.payloads.containsKey = ObjectCharHashMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = ObjectCharHashMapWithHashingStrategyTest::containsValue;
            this.payloads.size = ObjectCharHashMapWithHashingStrategyTest::size;
            this.payloads.withKeysValues = ObjectCharHashMapWithHashingStrategyTest::withKeysValues;
            this.payloads.withoutKey = ObjectCharHashMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectCharHashMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectCharHashMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.contains = ObjectCharHashMapWithHashingStrategyTest::contains;
            this.payloads.asUnmodifiable = ObjectCharHashMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectCharHashMapWithHashingStrategyTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectCharHashMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectCharHashMapWithHashingStrategyTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectCharHashMapWithHashingStrategyTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectCharHashMapWithHashingStrategyTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectCharHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectCharHashMapWithHashingStrategyTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectCharHashMapWithHashingStrategyTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectCharHashMapWithHashingStrategyTest::putWithRehash;
            this.payloads.testPutAll = ObjectCharHashMapWithHashingStrategyTest::testPutAll;
            this.payloads.injectInto = ObjectCharHashMapWithHashingStrategyTest::injectInto;
            this.payloads.put_every_slot = ObjectCharHashMapWithHashingStrategyTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectCharHashMapWithHashingStrategyTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectCharHashMapWithHashingStrategyTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectCharHashMapWithHashingStrategyTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectCharHashMapWithHashingStrategyTest::classIsNonInstantiable;
            this.payloads.select = ObjectCharHashMapWithHashingStrategyTest::select;
            this.payloads.reject = ObjectCharHashMapWithHashingStrategyTest::reject;
            this.payloads.collect = ObjectCharHashMapWithHashingStrategyTest::collect;
            this.payloads.contains_with_hashing_strategy = ObjectCharHashMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = ObjectCharHashMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = ObjectCharHashMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put_get_with_hashing_strategy = ObjectCharHashMapWithHashingStrategyTest::put_get_with_hashing_strategy;
        }
    }
}
