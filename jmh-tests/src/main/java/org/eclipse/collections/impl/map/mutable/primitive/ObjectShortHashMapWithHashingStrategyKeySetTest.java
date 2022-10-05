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
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectShortHashMapWithHashingStrategy#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyKeySetTest.stg.
 */
public class ObjectShortHashMapWithHashingStrategyKeySetTest extends ObjectShortHashMapKeySetTestCase {

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
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectShortMap<String> newEmptyMap() {
        return ObjectShortHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Set<Person> people = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4).keySet();
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
        MutableObjectShortMap<Person> map = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (short) 4));
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        super.keySetEqualsAndHashCode();
        Set<Person> people1 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JOHNSMITH, (short) 3).keySet();
        Set<Person> people2 = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JANEDOE, (short) 2, JANESMITH, (short) 4).keySet();
        Assert.assertTrue(people1.hashCode() == people2.hashCode());
    }

    @Override
    @Test
    public void keySetToArray() {
        super.keySetToArray();
        Set<Person> people = ObjectShortHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (short) 1, JANEDOE, (short) 2, JOHNSMITH, (short) 3, JANESMITH, (short) 4).keySet();
        Object[] keys1 = { JOHNDOE, JOHNSMITH };
        Assert.assertArrayEquals(people.toArray(), keys1);
        Person[] keys2 = new Person[2];
        Assert.assertArrayEquals(people.toArray(keys2), keys1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapWithHashingStrategyKeySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapWithHashingStrategyKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ObjectShortHashMapWithHashingStrategyKeySetTest::containsAll;
            this.payloads.isEmpty = ObjectShortHashMapWithHashingStrategyKeySetTest::isEmpty;
            this.payloads.size = ObjectShortHashMapWithHashingStrategyKeySetTest::size;
            this.payloads.iterator = ObjectShortHashMapWithHashingStrategyKeySetTest::iterator;
            this.payloads.removeNullFromKeySet = ObjectShortHashMapWithHashingStrategyKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectShortHashMapWithHashingStrategyKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectShortHashMapWithHashingStrategyKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectShortHashMapWithHashingStrategyKeySetTest::clearKeySet;
            this.payloads.contains = ObjectShortHashMapWithHashingStrategyKeySetTest::contains;
            this.payloads.removeFromKeySet = ObjectShortHashMapWithHashingStrategyKeySetTest::removeFromKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectShortHashMapWithHashingStrategyKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectShortHashMapWithHashingStrategyKeySetTest::keySetToArray;
        }
    }
}
