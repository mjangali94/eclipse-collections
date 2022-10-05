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
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_with_hashing_strategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains_with_hashing_strategy, this.description("contains_with_hashing_strategy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashing_strategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove_with_hashing_strategy, this.description("remove_with_hashing_strategy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equals_with_hashing_strategy, this.description("equals_with_hashing_strategy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_get_with_hashing_strategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_get_with_hashing_strategy, this.description("put_get_with_hashing_strategy"));
        }

        private ObjectLongHashMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectLongHashMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ObjectLongHashMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
