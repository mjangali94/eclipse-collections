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
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMapTestCase._Benchmark {

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

        private ObjectShortHashMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectShortHashMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ObjectShortHashMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
