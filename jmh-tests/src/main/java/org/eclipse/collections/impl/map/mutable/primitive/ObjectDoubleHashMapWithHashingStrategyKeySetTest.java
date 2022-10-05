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
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectDoubleHashMapWithHashingStrategy#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyKeySetTest.stg.
 */
public class ObjectDoubleHashMapWithHashingStrategyKeySetTest extends ObjectDoubleHashMapKeySetTestCase {

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
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectDoubleMap<String> newEmptyMap() {
        return ObjectDoubleHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Set<Person> people = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0).keySet();
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
        MutableObjectDoubleMap<Person> map = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4.0));
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        super.keySetEqualsAndHashCode();
        Set<Person> people1 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JOHNSMITH, 3.0).keySet();
        Set<Person> people2 = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JANEDOE, 2.0, JANESMITH, 4.0).keySet();
        Assert.assertTrue(people1.hashCode() == people2.hashCode());
    }

    @Override
    @Test
    public void keySetToArray() {
        super.keySetToArray();
        Set<Person> people = ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0, JANEDOE, 2.0, JOHNSMITH, 3.0, JANESMITH, 4.0).keySet();
        Object[] keys1 = { JOHNDOE, JOHNSMITH };
        Assert.assertArrayEquals(people.toArray(), keys1);
        Person[] keys2 = new Person[2];
        Assert.assertArrayEquals(people.toArray(keys2), keys1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMapKeySetTestCase._Benchmark {

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

        private ObjectDoubleHashMapWithHashingStrategyKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleHashMapWithHashingStrategyKeySetTest();
        }

        @java.lang.Override
        public ObjectDoubleHashMapWithHashingStrategyKeySetTest implementation() {
            return this.implementation;
        }
    }
}
