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
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.ObjectByteMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectByteMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectByteHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectByteHashMapWithHashingStrategyTest extends ObjectByteHashMapTestCase {

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

    private final ObjectByteHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectByteHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", (byte) 0, "1", (byte) 1, "2", (byte) 2);
    }

    @Override
    protected <T> ObjectByteHashMapWithHashingStrategy<T> newWithKeysValues(T key1, byte value1) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectByteHashMapWithHashingStrategy<T> newWithKeysValues(T key1, byte value1, T key2, byte value2) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectByteHashMapWithHashingStrategy<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectByteHashMapWithHashingStrategy<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3, T key4, byte value4) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectByteHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectByteHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectByteMap newMapWithInitialCapacity(int size) {
        return new ObjectByteHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectByteHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectByteHashMapWithHashingStrategy<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(JOHNDOE, (byte) 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectByteHashMapWithHashingStrategy<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(JOHNDOE, (byte) 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectByteHashMapWithHashingStrategy<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        ByteToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectByteHashMapWithHashingStrategy<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue((byte) 2));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue((byte) 4));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue((byte) 1));
        Assert.assertFalse(map.containsValue((byte) 3));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectByteHashMapWithHashingStrategy<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (byte) 4), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectByteHashMapWithHashingStrategy<String> map2 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (byte) 0, collidingKeys.get(1), (byte) 1, collidingKeys.get(2), (byte) 2, collidingKeys.get(3), (byte) 3);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (byte) 0, collidingKeys.get(1), (byte) 1, collidingKeys.get(2), (byte) 2), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), (byte) 1, collidingKeys.get(2), (byte) 2), map2);
        Verify.assertSize(2, map2);
        ObjectByteHashMapWithHashingStrategy<Integer> map3 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (byte) 1, null, (byte) 2, 3, (byte) 3);
        map3.remove(null);
        Assert.assertEquals(ObjectByteHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (byte) 1, 3, (byte) 3), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectByteHashMapWithHashingStrategy<Person> map1 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 1, JOHNSMITH, (byte) 1, JANESMITH, (byte) 1);
        ObjectByteHashMapWithHashingStrategy<Person> map2 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 1, JOHNSMITH, (byte) 1, JANESMITH, (byte) 1);
        ObjectByteHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 1, JOHNSMITH, (byte) 1, JANESMITH, (byte) 1);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectByteHashMapWithHashingStrategy<Person> map3 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        ObjectByteHashMapWithHashingStrategy<Person> map4 = ObjectByteHashMapWithHashingStrategy.newMap(map3);
        ObjectByteMap hashMap = ObjectByteMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectByteHashMap<Person> objectMap = ObjectByteHashMap.newWithKeysValues(JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        ObjectByteHashMapWithHashingStrategy<Person> map5 = ObjectByteHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectByteHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, (byte) 5);
        // Testing getting values from no chains
        Assert.assertEquals((byte) 1, map.get("1"));
        Assert.assertEquals((byte) 2, map.get("2"));
        Assert.assertEquals((byte) 5, map.get(null));
        ObjectByteHashMapWithHashingStrategy<Person> map2 = ObjectByteHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, (byte) 1);
        Assert.assertEquals((byte) 1, map2.get(JOHNSMITH));
        map2.put(JANESMITH, (byte) 2);
        Assert.assertEquals((byte) 2, map2.get(JOHNSMITH));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMapTestCase._Benchmark {

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

        private ObjectByteHashMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectByteHashMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ObjectByteHashMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
