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
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectFloatHashMapWithHashingStrategy#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyKeySetTest.stg.
 */
public class ObjectFloatHashMapWithHashingStrategyKeySetTest extends ObjectFloatHashMapKeySetTestCase {

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
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectFloatMap<String> newEmptyMap() {
        return ObjectFloatHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Set<Person> people = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f).keySet();
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
        MutableObjectFloatMap<Person> map = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, 4.0f));
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        super.keySetEqualsAndHashCode();
        Set<Person> people1 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JOHNSMITH, 3.0f).keySet();
        Set<Person> people2 = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JANEDOE, 2.0f, JANESMITH, 4.0f).keySet();
        Assert.assertTrue(people1.hashCode() == people2.hashCode());
    }

    @Override
    @Test
    public void keySetToArray() {
        super.keySetToArray();
        Set<Person> people = ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, 1.0f, JANEDOE, 2.0f, JOHNSMITH, 3.0f, JANESMITH, 4.0f).keySet();
        Object[] keys1 = { JOHNDOE, JOHNSMITH };
        Assert.assertArrayEquals(people.toArray(), keys1);
        Person[] keys2 = new Person[2];
        Assert.assertArrayEquals(people.toArray(keys2), keys1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatHashMapWithHashingStrategyKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapWithHashingStrategyKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ObjectFloatHashMapWithHashingStrategyKeySetTest::containsAll;
            this.payloads.isEmpty = ObjectFloatHashMapWithHashingStrategyKeySetTest::isEmpty;
            this.payloads.size = ObjectFloatHashMapWithHashingStrategyKeySetTest::size;
            this.payloads.iterator = ObjectFloatHashMapWithHashingStrategyKeySetTest::iterator;
            this.payloads.removeNullFromKeySet = ObjectFloatHashMapWithHashingStrategyKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectFloatHashMapWithHashingStrategyKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectFloatHashMapWithHashingStrategyKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectFloatHashMapWithHashingStrategyKeySetTest::clearKeySet;
            this.payloads.contains = ObjectFloatHashMapWithHashingStrategyKeySetTest::contains;
            this.payloads.removeFromKeySet = ObjectFloatHashMapWithHashingStrategyKeySetTest::removeFromKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectFloatHashMapWithHashingStrategyKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectFloatHashMapWithHashingStrategyKeySetTest::keySetToArray;
        }
    }
}
