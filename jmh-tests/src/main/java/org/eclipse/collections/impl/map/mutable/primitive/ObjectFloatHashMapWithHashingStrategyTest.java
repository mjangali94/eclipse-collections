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
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectFloatHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectFloatHashMapWithHashingStrategyTest extends ObjectFloatHashMapTestCase {

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

    private final ObjectFloatHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectFloatHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", 0.0f, "1", 1.0f, "2", 2.0f);
    }

    @Override
    protected <T> ObjectFloatHashMapWithHashingStrategy<T> newWithKeysValues(T key1, float value1) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectFloatHashMapWithHashingStrategy<T> newWithKeysValues(T key1, float value1, T key2, float value2) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectFloatHashMapWithHashingStrategy<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectFloatHashMapWithHashingStrategy<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectFloatHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectFloatHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectFloatMap newMapWithInitialCapacity(int size) {
        return new ObjectFloatHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectFloatHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectFloatHashMapWithHashingStrategy<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(JOHNDOE, 2.0f), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectFloatHashMapWithHashingStrategy<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(JOHNDOE, 2.0f), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectFloatHashMapWithHashingStrategy<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        FloatToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectFloatHashMapWithHashingStrategy<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue(2.0f));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue(4.0f));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue(1.0f));
        Assert.assertFalse(map.containsValue(3.0f));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectFloatHashMapWithHashingStrategy<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4.0f), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectFloatHashMapWithHashingStrategy<String> map2 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0.0f, collidingKeys.get(1), 1.0f, collidingKeys.get(2), 2.0f, collidingKeys.get(3), 3.0f);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0.0f, collidingKeys.get(1), 1.0f, collidingKeys.get(2), 2.0f), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), 1.0f, collidingKeys.get(2), 2.0f), map2);
        Verify.assertSize(2, map2);
        ObjectFloatHashMapWithHashingStrategy<Integer> map3 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1.0f, null, 2.0f, 3, 3.0f);
        map3.remove(null);
        Assert.assertEquals(ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1.0f, 3, 3.0f), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectFloatHashMapWithHashingStrategy<Person> map1 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 1.0f, JOHNSMITH, 1.0f, JANESMITH, 1.0f);
        ObjectFloatHashMapWithHashingStrategy<Person> map2 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 1.0f, JOHNSMITH, 1.0f, JANESMITH, 1.0f);
        ObjectFloatHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 1.0f, JOHNSMITH, 1.0f, JANESMITH, 1.0f);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectFloatHashMapWithHashingStrategy<Person> map3 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        ObjectFloatHashMapWithHashingStrategy<Person> map4 = ObjectFloatHashMapWithHashingStrategy.newMap(map3);
        ObjectFloatMap hashMap = ObjectFloatMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectFloatHashMap<Person> objectMap = ObjectFloatHashMap.newWithKeysValues(JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        ObjectFloatHashMapWithHashingStrategy<Person> map5 = ObjectFloatHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectFloatHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, 5.0f);
        // Testing getting values from no chains
        Assert.assertEquals(1.0f, map.get("1"), 0.0);
        Assert.assertEquals(2.0f, map.get("2"), 0.0);
        Assert.assertEquals(5.0f, map.get(null), 0.0);
        ObjectFloatHashMapWithHashingStrategy<Person> map2 = ObjectFloatHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, 1.0f);
        Assert.assertEquals(1.0f, map2.get(JOHNSMITH), 0.0);
        map2.put(JANESMITH, 2.0f);
        Assert.assertEquals(2.0f, map2.get(JOHNSMITH), 0.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatHashMapWithHashingStrategyTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_get_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_get_with_hashing_strategy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyTest> put_get_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectFloatHashMapWithHashingStrategyTest::keySet;
            this.payloads.values = ObjectFloatHashMapWithHashingStrategyTest::values;
            this.payloads.isEmpty = ObjectFloatHashMapWithHashingStrategyTest::isEmpty;
            this.payloads.notEmpty = ObjectFloatHashMapWithHashingStrategyTest::notEmpty;
            this.payloads.asLazy = ObjectFloatHashMapWithHashingStrategyTest::asLazy;
            this.payloads.testEquals = ObjectFloatHashMapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = ObjectFloatHashMapWithHashingStrategyTest::testHashCode;
            this.payloads.testToString = ObjectFloatHashMapWithHashingStrategyTest::testToString;
            this.payloads.floatIterator = ObjectFloatHashMapWithHashingStrategyTest::floatIterator;
            this.payloads.forEach = ObjectFloatHashMapWithHashingStrategyTest::forEach;
            this.payloads.forEachValue = ObjectFloatHashMapWithHashingStrategyTest::forEachValue;
            this.payloads.forEachKey = ObjectFloatHashMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectFloatHashMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectFloatHashMapWithHashingStrategyTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectFloatHashMapWithHashingStrategyTest::makeString;
            this.payloads.appendString = ObjectFloatHashMapWithHashingStrategyTest::appendString;
            this.payloads.tap = ObjectFloatHashMapWithHashingStrategyTest::tap;
            this.payloads.count = ObjectFloatHashMapWithHashingStrategyTest::count;
            this.payloads.anySatisfy = ObjectFloatHashMapWithHashingStrategyTest::anySatisfy;
            this.payloads.allSatisfy = ObjectFloatHashMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectFloatHashMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectFloatHashMapWithHashingStrategyTest::detectIfNone;
            this.payloads.sum = ObjectFloatHashMapWithHashingStrategyTest::sum;
            this.payloads.max = ObjectFloatHashMapWithHashingStrategyTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectFloatHashMapWithHashingStrategyTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectFloatHashMapWithHashingStrategyTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectFloatHashMapWithHashingStrategyTest::minIfEmpty;
            this.payloads.average = ObjectFloatHashMapWithHashingStrategyTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectFloatHashMapWithHashingStrategyTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectFloatHashMapWithHashingStrategyTest::toArray;
            this.payloads.toSortedArray = ObjectFloatHashMapWithHashingStrategyTest::toSortedArray;
            this.payloads.containsAll = ObjectFloatHashMapWithHashingStrategyTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectFloatHashMapWithHashingStrategyTest::containsAll_Iterable;
            this.payloads.toList = ObjectFloatHashMapWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ObjectFloatHashMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSet = ObjectFloatHashMapWithHashingStrategyTest::toSet;
            this.payloads.toBag = ObjectFloatHashMapWithHashingStrategyTest::toBag;
            this.payloads.toImmutable = ObjectFloatHashMapWithHashingStrategyTest::toImmutable;
            this.payloads.clear = ObjectFloatHashMapWithHashingStrategyTest::clear;
            this.payloads.removeKey = ObjectFloatHashMapWithHashingStrategyTest::removeKey;
            this.payloads.remove = ObjectFloatHashMapWithHashingStrategyTest::remove;
            this.payloads.put = ObjectFloatHashMapWithHashingStrategyTest::put;
            this.payloads.updateValues = ObjectFloatHashMapWithHashingStrategyTest::updateValues;
            this.payloads.putPair = ObjectFloatHashMapWithHashingStrategyTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectFloatHashMapWithHashingStrategyTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectFloatHashMapWithHashingStrategyTest::get;
            this.payloads.getOrThrow = ObjectFloatHashMapWithHashingStrategyTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectFloatHashMapWithHashingStrategyTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectFloatHashMapWithHashingStrategyTest::updateValue;
            this.payloads.addToValue = ObjectFloatHashMapWithHashingStrategyTest::addToValue;
            this.payloads.containsKey = ObjectFloatHashMapWithHashingStrategyTest::containsKey;
            this.payloads.containsValue = ObjectFloatHashMapWithHashingStrategyTest::containsValue;
            this.payloads.size = ObjectFloatHashMapWithHashingStrategyTest::size;
            this.payloads.withKeysValues = ObjectFloatHashMapWithHashingStrategyTest::withKeysValues;
            this.payloads.withoutKey = ObjectFloatHashMapWithHashingStrategyTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectFloatHashMapWithHashingStrategyTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectFloatHashMapWithHashingStrategyTest::withAllKeyValues;
            this.payloads.contains = ObjectFloatHashMapWithHashingStrategyTest::contains;
            this.payloads.asUnmodifiable = ObjectFloatHashMapWithHashingStrategyTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectFloatHashMapWithHashingStrategyTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectFloatHashMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectFloatHashMapWithHashingStrategyTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectFloatHashMapWithHashingStrategyTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectFloatHashMapWithHashingStrategyTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectFloatHashMapWithHashingStrategyTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectFloatHashMapWithHashingStrategyTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectFloatHashMapWithHashingStrategyTest::putWithRehash;
            this.payloads.testPutAll = ObjectFloatHashMapWithHashingStrategyTest::testPutAll;
            this.payloads.injectInto = ObjectFloatHashMapWithHashingStrategyTest::injectInto;
            this.payloads.put_every_slot = ObjectFloatHashMapWithHashingStrategyTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectFloatHashMapWithHashingStrategyTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectFloatHashMapWithHashingStrategyTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectFloatHashMapWithHashingStrategyTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectFloatHashMapWithHashingStrategyTest::classIsNonInstantiable;
            this.payloads.select = ObjectFloatHashMapWithHashingStrategyTest::select;
            this.payloads.reject = ObjectFloatHashMapWithHashingStrategyTest::reject;
            this.payloads.collect = ObjectFloatHashMapWithHashingStrategyTest::collect;
            this.payloads.contains_with_hashing_strategy = ObjectFloatHashMapWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = ObjectFloatHashMapWithHashingStrategyTest::remove_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = ObjectFloatHashMapWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.put_get_with_hashing_strategy = ObjectFloatHashMapWithHashingStrategyTest::put_get_with_hashing_strategy;
        }
    }
}
