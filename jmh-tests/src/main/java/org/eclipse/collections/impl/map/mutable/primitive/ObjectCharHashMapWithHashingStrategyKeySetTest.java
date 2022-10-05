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

import java.util.Set;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyKeySetTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyKeySetTest extends ObjectCharHashMapKeySetTestCase {

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
    public MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3, String key4, char value4) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectCharMap<String> newEmptyMap() {
        return ObjectCharHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Set<Person> people = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4).keySet();
        Verify.assertSize(2, people);
        Verify.assertContains(JANEDOE, people);
        Verify.assertContains(JOHNDOE, people);
        Verify.assertContains(JANESMITH, people);
        Verify.assertContains(JOHNSMITH, people);
    }

    @Override
    @Test
    public void removeFromKeySet() {
        super.removeFromKeySet();
        MutableObjectCharMap<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (char) 4));
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        super.keySetEqualsAndHashCode();
        Set<Person> people1 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JOHNSMITH, (char) 3).keySet();
        Set<Person> people2 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JANEDOE, (char) 2, JANESMITH, (char) 4).keySet();
        Assert.assertTrue(people1.hashCode() == people2.hashCode());
    }

    @Override
    @Test
    public void keySetToArray() {
        super.keySetToArray();
        Set<Person> people = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4).keySet();
        Object[] keys1 = { JOHNDOE, JOHNSMITH };
        Assert.assertArrayEquals(people.toArray(), keys1);
        Person[] keys2 = new Person[2];
        Assert.assertArrayEquals(people.toArray(keys2), keys1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMapKeySetTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromKeySet, this.description("removeFromKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySetEqualsAndHashCode, this.description("keySetEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySetToArray, this.description("keySetToArray"));
        }

        private ObjectCharHashMapWithHashingStrategyKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectCharHashMapWithHashingStrategyKeySetTest();
        }

        @java.lang.Override
        public ObjectCharHashMapWithHashingStrategyKeySetTest implementation() {
            return this.implementation;
        }
    }
}
