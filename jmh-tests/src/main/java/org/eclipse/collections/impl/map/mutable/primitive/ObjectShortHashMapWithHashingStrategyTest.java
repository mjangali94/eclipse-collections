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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectShortMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectShortHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectShortHashMapWithHashingStrategyTest extends ObjectShortHashMapTestCase {

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

    private final ObjectShortHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectShortHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", (short) 0, "1", (short) 1, "2", (short) 2);
    }

    @Override
    protected <T> ObjectShortHashMapWithHashingStrategy<T> newWithKeysValues(T key1, short value1) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectShortHashMapWithHashingStrategy<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectShortHashMapWithHashingStrategy<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectShortHashMapWithHashingStrategy<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectShortHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectShortHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectShortMap newMapWithInitialCapacity(int size) {
        return new ObjectShortHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectShortHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectShortHashMapWithHashingStrategy<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(JOHNDOE, (short) 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectShortHashMapWithHashingStrategy<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(JOHNDOE, (short) 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectShortHashMapWithHashingStrategy<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        ShortToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectShortHashMapWithHashingStrategy<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue((short) 2));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue((short) 4));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue((short) 1));
        Assert.assertFalse(map.containsValue((short) 3));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectShortHashMapWithHashingStrategy<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (short) 4), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectShortHashMapWithHashingStrategy<String> map2 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (short) 0, collidingKeys.get(1), (short) 1, collidingKeys.get(2), (short) 2, collidingKeys.get(3), (short) 3);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (short) 0, collidingKeys.get(1), (short) 1, collidingKeys.get(2), (short) 2), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), (short) 1, collidingKeys.get(2), (short) 2), map2);
        Verify.assertSize(2, map2);
        ObjectShortHashMapWithHashingStrategy<Integer> map3 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (short) 1, null, (short) 2, 3, (short) 3);
        map3.remove(null);
        Assert.assertEquals(ObjectShortHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (short) 1, 3, (short) 3), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectShortHashMapWithHashingStrategy<Person> map1 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 1, JOHNSMITH, (short) 1, JANESMITH, (short) 1);
        ObjectShortHashMapWithHashingStrategy<Person> map2 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 1, JOHNSMITH, (short) 1, JANESMITH, (short) 1);
        ObjectShortHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 1, JOHNSMITH, (short) 1, JANESMITH, (short) 1);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectShortHashMapWithHashingStrategy<Person> map3 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        ObjectShortHashMapWithHashingStrategy<Person> map4 = ObjectShortHashMapWithHashingStrategy.newMap(map3);
        ObjectShortMap hashMap = ObjectShortMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectShortHashMap<Person> objectMap = ObjectShortHashMap.newWithKeysValues(JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        ObjectShortHashMapWithHashingStrategy<Person> map5 = ObjectShortHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectShortHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, (short) 5);
        // Testing getting values from no chains
        Assert.assertEquals((short) 1, map.get("1"));
        Assert.assertEquals((short) 2, map.get("2"));
        Assert.assertEquals((short) 5, map.get(null));
        ObjectShortHashMapWithHashingStrategy<Person> map2 = ObjectShortHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, (short) 1);
        Assert.assertEquals((short) 1, map2.get(JOHNSMITH));
        map2.put(JANESMITH, (short) 2);
        Assert.assertEquals((short) 2, map2.get(JOHNSMITH));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapWithHashingStrategyTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyTest> put_get_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectShortHashMapWithHashingStrategyTest::keySet;
            this.payloads.values = ObjectShortHashMapWithHashingStrategyTest::values;
            this.payloads.isEmpty = ObjectShortHashMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = ObjectShortHashMapWithHashingStrategyTest::notEmpty;
            this.payloads.asLazy = ObjectShortHashMapWithHashingStrategyTest::asLazy;
            this.payloads.testEquals = ObjectShortHashMapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = ObjectShortHashMapWithHashingStrategyTest::testHashCode;
            this.payloads.testToString = ObjectShortHashMapWithHashingStrategyTest::testToString;
            this.payloads.shortIterator = ObjectShortHashMapWithHashingStrategyTest::shortIterator;
            this.payloads.forEach = ObjectShortHashMapWithHashingStrategyTest::forEach;
            this.payloads.forEachValue = ObjectShortHashMapWithHashingStrategyTest::forEachValue;
            this.payloads.forEachKey = ObjectShortHashMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectShortHashMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectShortHashMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectShortHashMapWithHashingStrategyTest::makeString;
            this.payloads.appendString = ObjectShortHashMapWithHashingStrategyTest::appendString;
            this.payloads.tap = ObjectShortHashMapWithHashingStrategyTest::tap;
            this.payloads.count = ObjectShortHashMapWithHashingStrategyTest::count;
            this.payloads.anySatisfy = ObjectShortHashMapWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ObjectShortHashMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectShortHashMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectShortHashMapWithHashingStrategyTest::detectIfNone;
            this.payloads.sum = ObjectShortHashMapWithHashingStrategyTest::sum;
            this.payloads.max = ObjectShortHashMapWithHashingStrategyTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectShortHashMapWithHashingStrategyTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectShortHashMapWithHashingStrategyTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectShortHashMapWithHashingStrategyTest::minIfEmpty;
            this.payloads.average = ObjectShortHashMapWithHashingStrategyTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectShortHashMapWithHashingStrategyTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectShortHashMapWithHashingStrategyTest::toArray;
            this.payloads.toSortedArray = ObjectShortHashMapWithHashingStrategyTest::toSortedArray;
            this.payloads.containsAll = ObjectShortHashMapWithHashingStrategyTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectShortHashMapWithHashingStrategyTest::containsAll_Iterable;
            this.payloads.toList = ObjectShortHashMapWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ObjectShortHashMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSet = ObjectShortHashMapWithHashingStrategyTest::toSet;
            this.payloads.toBag = ObjectShortHashMapWithHashingStrategyTest::toBag;
            this.payloads.toImmutable = ObjectShortHashMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = ObjectShortHashMapWithHashingStrategyTest::clear;
            this.payloads.removeKey = ObjectShortHashMapWithHashingStrategyTest::removeKey;
            this.payloads.remove = ObjectShortHashMapWithHashingStrategyTest::remove;
            this.payloads.put = ObjectShortHashMapWithHashingStrategyTest::put;
            this.payloads.updateValues = ObjectShortHashMapWithHashingStrategyTest::updateValues;
            this.payloads.putPair = ObjectShortHashMapWithHashingStrategyTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectShortHashMapWithHashingStrategyTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectShortHashMapWithHashingStrategyTest::get;
            this.payloads.getOrThrow = ObjectShortHashMapWithHashingStrategyTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectShortHashMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectShortHashMapWithHashingStrategyTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectShortHashMapWithHashingStrategyTest::updateValue;
            this.payloads.addToValue = ObjectShortHashMapWithHashingStrategyTest::addToValue;
            this.payloads.containsKey = ObjectShortHashMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = ObjectShortHashMapWithHashingStrategyTest::containsValue;
            this.payloads.size = ObjectShortHashMapWithHashingStrategyTest::size;
            this.payloads.withKeysValues = ObjectShortHashMapWithHashingStrategyTest::withKeysValues;
            this.payloads.withoutKey = ObjectShortHashMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectShortHashMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectShortHashMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.contains = ObjectShortHashMapWithHashingStrategyTest::contains;
            this.payloads.asUnmodifiable = ObjectShortHashMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectShortHashMapWithHashingStrategyTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectShortHashMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectShortHashMapWithHashingStrategyTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectShortHashMapWithHashingStrategyTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectShortHashMapWithHashingStrategyTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectShortHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectShortHashMapWithHashingStrategyTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectShortHashMapWithHashingStrategyTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectShortHashMapWithHashingStrategyTest::putWithRehash;
            this.payloads.testPutAll = ObjectShortHashMapWithHashingStrategyTest::testPutAll;
            this.payloads.injectInto = ObjectShortHashMapWithHashingStrategyTest::injectInto;
            this.payloads.put_every_slot = ObjectShortHashMapWithHashingStrategyTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectShortHashMapWithHashingStrategyTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectShortHashMapWithHashingStrategyTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectShortHashMapWithHashingStrategyTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectShortHashMapWithHashingStrategyTest::classIsNonInstantiable;
            this.payloads.select = ObjectShortHashMapWithHashingStrategyTest::select;
            this.payloads.reject = ObjectShortHashMapWithHashingStrategyTest::reject;
            this.payloads.collect = ObjectShortHashMapWithHashingStrategyTest::collect;
            this.payloads.contains_with_hashing_strategy = ObjectShortHashMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = ObjectShortHashMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = ObjectShortHashMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put_get_with_hashing_strategy = ObjectShortHashMapWithHashingStrategyTest::put_get_with_hashing_strategy;
        }
    }
}
