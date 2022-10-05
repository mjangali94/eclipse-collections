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
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectDoubleHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectDoubleHashMapWithHashingStrategyTest extends ObjectDoubleHashMapTestCase {

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

    private final ObjectDoubleHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectDoubleHashMapWithHashingStrategy<String> classUnderTest() {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", 0.0, "1", 1.0, "2", 2.0);
    }

    @Override
    protected <T> ObjectDoubleHashMapWithHashingStrategy<T> newWithKeysValues(T key1, double value1) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectDoubleHashMapWithHashingStrategy<T> newWithKeysValues(T key1, double value1, T key2, double value2) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectDoubleHashMapWithHashingStrategy<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectDoubleHashMapWithHashingStrategy<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectDoubleHashMapWithHashingStrategy<T> getEmptyMap() {
        return new ObjectDoubleHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectDoubleMap newMapWithInitialCapacity(int size) {
        return new ObjectDoubleHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectDoubleHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select() {
        super.select();
        ObjectDoubleHashMapWithHashingStrategy<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(JOHNDOE, 2.0), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ObjectDoubleHashMapWithHashingStrategy<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(JOHNDOE, 2.0), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ObjectDoubleHashMapWithHashingStrategy<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        DoubleToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy() {
        ObjectDoubleHashMapWithHashingStrategy<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue(2.0));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue(4.0));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));
        Assert.assertFalse(map.containsValue(1.0));
        Assert.assertFalse(map.containsValue(3.0));
    }

    @Test
    public void remove_with_hashing_strategy() {
        ObjectDoubleHashMapWithHashingStrategy<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        map.remove(JANEDOE);
        Assert.assertEquals(ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4.0), map);
        map.remove(JOHNSMITH);
        Verify.assertEmpty(map);
        MutableList<String> collidingKeys = generateCollisions();
        ObjectDoubleHashMapWithHashingStrategy<String> map2 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0.0, collidingKeys.get(1), 1.0, collidingKeys.get(2), 2.0, collidingKeys.get(3), 3.0);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), 0.0, collidingKeys.get(1), 1.0, collidingKeys.get(2), 2.0), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), 1.0, collidingKeys.get(2), 2.0), map2);
        Verify.assertSize(2, map2);
        ObjectDoubleHashMapWithHashingStrategy<Integer> map3 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1.0, null, 2.0, 3, 3.0);
        map3.remove(null);
        Assert.assertEquals(ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, 1.0, 3, 3.0), map3);
    }

    @Test
    public void equals_with_hashing_strategy() {
        ObjectDoubleHashMapWithHashingStrategy<Person> map1 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 1.0, JOHNSMITH, 1.0, JANESMITH, 1.0);
        ObjectDoubleHashMapWithHashingStrategy<Person> map2 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 1.0, JOHNSMITH, 1.0, JANESMITH, 1.0);
        ObjectDoubleHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, 1.0, JANEDOE, 1.0, JOHNSMITH, 1.0, JANESMITH, 1.0);
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        ObjectDoubleHashMapWithHashingStrategy<Person> map3 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        ObjectDoubleHashMapWithHashingStrategy<Person> map4 = ObjectDoubleHashMapWithHashingStrategy.newMap(map3);
        ObjectDoubleMap hashMap = ObjectDoubleMaps.mutable.withAll(map3);
        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());
        ObjectDoubleHashMap<Person> objectMap = ObjectDoubleHashMap.newWithKeysValues(JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        ObjectDoubleHashMapWithHashingStrategy<Person> map5 = ObjectDoubleHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy() {
        ObjectDoubleHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, 5.0);
        // Testing getting values from no chains
        Assert.assertEquals(1.0, map.get("1"), 0.0);
        Assert.assertEquals(2.0, map.get("2"), 0.0);
        Assert.assertEquals(5.0, map.get(null), 0.0);
        ObjectDoubleHashMapWithHashingStrategy<Person> map2 = ObjectDoubleHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, 1.0);
        Assert.assertEquals(1.0, map2.get(JOHNSMITH), 0.0);
        map2.put(JANESMITH, 2.0);
        Assert.assertEquals(2.0, map2.get(JOHNSMITH), 0.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMapTestCase._Benchmark {

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

        private ObjectDoubleHashMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleHashMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ObjectDoubleHashMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
