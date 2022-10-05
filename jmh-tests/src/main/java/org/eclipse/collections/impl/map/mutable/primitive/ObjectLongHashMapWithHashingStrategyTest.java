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
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectLongHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectLongHashMapWithHashingStrategyTest extends ObjectLongHashMapTestCase {

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

    private final ObjectLongHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectLongHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectLongHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", 0L, "1", 1L, "2", 2L);
    }

    @Override
    protected <T> ObjectLongHashMapWithHashingStrategy<T> newWithKeysValues(T key1, long value1) {
        return ObjectLongHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectLongHashMapWithHashingStrategy<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return ObjectLongHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectLongHashMapWithHashingStrategy<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectLongHashMapWithHashingStrategy<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4) {
        return ObjectLongHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectLongHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectLongHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectLongMap newMapWithInitialCapacity(int size) {
        return new ObjectLongHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectLongHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectLongHashMapWithHashingStrategy<Person> map = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(JOHNDOE, 2L), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectLongHashMapWithHashingStrategy<Person> map = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(JOHNDOE, 2L), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectLongHashMapWithHashingStrategy<Person> map = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        LongToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectLongHashMapWithHashingStrategy<Person> map = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue(2L));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue(4L));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue(1L));
        Assert.assertFalse(map.containsValue(3L));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectLongHashMapWithHashingStrategy<Person> map = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4L), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectLongHashMapWithHashingStrategy<String> map2 = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0L, collidingKeys.get(1), 1L, collidingKeys.get(2), 2L, collidingKeys.get(3), 3L);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectLongHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0L, collidingKeys.get(1), 1L, collidingKeys.get(2), 2L), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectLongHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), 1L, collidingKeys.get(2), 2L), map2);
        Verify.assertSize(2, map2);
        ObjectLongHashMapWithHashingStrategy<Integer> map3 = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1L, null, 2L, 3, 3L);
        map3.remove(null);
        Assert.assertEquals(ObjectLongHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1L, 3, 3L), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectLongHashMapWithHashingStrategy<Person> map1 = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 1L, JOHNSMITH, 1L, JANESMITH, 1L);
        ObjectLongHashMapWithHashingStrategy<Person> map2 = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 1L, JOHNSMITH, 1L, JANESMITH, 1L);
        ObjectLongHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, 1L, JANEDOE, 1L, JOHNSMITH, 1L, JANESMITH, 1L);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectLongHashMapWithHashingStrategy<Person> map3 = ObjectLongHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        ObjectLongHashMapWithHashingStrategy<Person> map4 = ObjectLongHashMapWithHashingStrategy.newMap(map3);
        ObjectLongMap hashMap = ObjectLongMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectLongHashMap<Person> objectMap = ObjectLongHashMap.newWithKeysValues(JOHNDOE, 1L, JANEDOE, 2L, JOHNSMITH, 3L, JANESMITH, 4L);
        ObjectLongHashMapWithHashingStrategy<Person> map5 = ObjectLongHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectLongHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, 5L);
        // Testing getting values from no chains
        Assert.assertEquals(1L, map.get("1"));
        Assert.assertEquals(2L, map.get("2"));
        Assert.assertEquals(5L, map.get(null));
        ObjectLongHashMapWithHashingStrategy<Person> map2 = ObjectLongHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, 1L);
        Assert.assertEquals(1L, map2.get(JOHNSMITH));
        map2.put(JANESMITH, 2L);
        Assert.assertEquals(2L, map2.get(JOHNSMITH));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectLongHashMapWithHashingStrategyTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectLongHashMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapWithHashingStrategyTest> put_get_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectLongHashMapWithHashingStrategyTest::keySet;
            this.payloads.values = ObjectLongHashMapWithHashingStrategyTest::values;
            this.payloads.isEmpty = ObjectLongHashMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = ObjectLongHashMapWithHashingStrategyTest::notEmpty;
            this.payloads.asLazy = ObjectLongHashMapWithHashingStrategyTest::asLazy;
            this.payloads.testEquals = ObjectLongHashMapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = ObjectLongHashMapWithHashingStrategyTest::testHashCode;
            this.payloads.testToString = ObjectLongHashMapWithHashingStrategyTest::testToString;
            this.payloads.longIterator = ObjectLongHashMapWithHashingStrategyTest::longIterator;
            this.payloads.forEach = ObjectLongHashMapWithHashingStrategyTest::forEach;
            this.payloads.forEachValue = ObjectLongHashMapWithHashingStrategyTest::forEachValue;
            this.payloads.forEachKey = ObjectLongHashMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectLongHashMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectLongHashMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectLongHashMapWithHashingStrategyTest::makeString;
            this.payloads.appendString = ObjectLongHashMapWithHashingStrategyTest::appendString;
            this.payloads.tap = ObjectLongHashMapWithHashingStrategyTest::tap;
            this.payloads.count = ObjectLongHashMapWithHashingStrategyTest::count;
            this.payloads.anySatisfy = ObjectLongHashMapWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ObjectLongHashMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectLongHashMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectLongHashMapWithHashingStrategyTest::detectIfNone;
            this.payloads.sum = ObjectLongHashMapWithHashingStrategyTest::sum;
            this.payloads.max = ObjectLongHashMapWithHashingStrategyTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapWithHashingStrategyTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectLongHashMapWithHashingStrategyTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapWithHashingStrategyTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectLongHashMapWithHashingStrategyTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectLongHashMapWithHashingStrategyTest::minIfEmpty;
            this.payloads.average = ObjectLongHashMapWithHashingStrategyTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapWithHashingStrategyTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectLongHashMapWithHashingStrategyTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapWithHashingStrategyTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectLongHashMapWithHashingStrategyTest::toArray;
            this.payloads.toSortedArray = ObjectLongHashMapWithHashingStrategyTest::toSortedArray;
            this.payloads.containsAll = ObjectLongHashMapWithHashingStrategyTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectLongHashMapWithHashingStrategyTest::containsAll_Iterable;
            this.payloads.toList = ObjectLongHashMapWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ObjectLongHashMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSet = ObjectLongHashMapWithHashingStrategyTest::toSet;
            this.payloads.toBag = ObjectLongHashMapWithHashingStrategyTest::toBag;
            this.payloads.toImmutable = ObjectLongHashMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = ObjectLongHashMapWithHashingStrategyTest::clear;
            this.payloads.removeKey = ObjectLongHashMapWithHashingStrategyTest::removeKey;
            this.payloads.remove = ObjectLongHashMapWithHashingStrategyTest::remove;
            this.payloads.put = ObjectLongHashMapWithHashingStrategyTest::put;
            this.payloads.updateValues = ObjectLongHashMapWithHashingStrategyTest::updateValues;
            this.payloads.putPair = ObjectLongHashMapWithHashingStrategyTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectLongHashMapWithHashingStrategyTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectLongHashMapWithHashingStrategyTest::get;
            this.payloads.getOrThrow = ObjectLongHashMapWithHashingStrategyTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectLongHashMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectLongHashMapWithHashingStrategyTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectLongHashMapWithHashingStrategyTest::updateValue;
            this.payloads.addToValue = ObjectLongHashMapWithHashingStrategyTest::addToValue;
            this.payloads.containsKey = ObjectLongHashMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = ObjectLongHashMapWithHashingStrategyTest::containsValue;
            this.payloads.size = ObjectLongHashMapWithHashingStrategyTest::size;
            this.payloads.withKeysValues = ObjectLongHashMapWithHashingStrategyTest::withKeysValues;
            this.payloads.withoutKey = ObjectLongHashMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectLongHashMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectLongHashMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.contains = ObjectLongHashMapWithHashingStrategyTest::contains;
            this.payloads.asUnmodifiable = ObjectLongHashMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectLongHashMapWithHashingStrategyTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectLongHashMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectLongHashMapWithHashingStrategyTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectLongHashMapWithHashingStrategyTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapWithHashingStrategyTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectLongHashMapWithHashingStrategyTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectLongHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectLongHashMapWithHashingStrategyTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectLongHashMapWithHashingStrategyTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectLongHashMapWithHashingStrategyTest::putWithRehash;
            this.payloads.testPutAll = ObjectLongHashMapWithHashingStrategyTest::testPutAll;
            this.payloads.injectInto = ObjectLongHashMapWithHashingStrategyTest::injectInto;
            this.payloads.put_every_slot = ObjectLongHashMapWithHashingStrategyTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectLongHashMapWithHashingStrategyTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectLongHashMapWithHashingStrategyTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectLongHashMapWithHashingStrategyTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectLongHashMapWithHashingStrategyTest::classIsNonInstantiable;
            this.payloads.select = ObjectLongHashMapWithHashingStrategyTest::select;
            this.payloads.reject = ObjectLongHashMapWithHashingStrategyTest::reject;
            this.payloads.collect = ObjectLongHashMapWithHashingStrategyTest::collect;
            this.payloads.contains_with_hashing_strategy = ObjectLongHashMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = ObjectLongHashMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = ObjectLongHashMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put_get_with_hashing_strategy = ObjectLongHashMapWithHashingStrategyTest::put_get_with_hashing_strategy;
        }
    }
}
