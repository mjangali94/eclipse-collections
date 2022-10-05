/*
 * Copyright (c) 2021 Goldman Sachs.
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
import org.eclipse.collections.api.map.primitive.MutableObjectBooleanMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectBooleanHashMapWithHashingStrategy#keySet()}.
 */
public class ObjectBooleanHashMapWithHashingStrategyKeySetTest extends ObjectBooleanHashMapKeySetTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    @Override
    public MutableObjectBooleanMap<String> newMapWithKeysValues(String key1, boolean value1) {
        return ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectBooleanMap<String> newMapWithKeysValues(String key1, boolean value1, String key2, boolean value2) {
        return ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectBooleanMap<String> newMapWithKeysValues(String key1, boolean value1, String key2, boolean value2, String key3, boolean value3) {
        return ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectBooleanMap<String> newMapWithKeysValues(String key1, boolean value1, String key2, boolean value2, String key3, boolean value3, String key4, boolean value4) {
        return ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectBooleanMap<String> newEmptyMap() {
        return ObjectBooleanHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Set<Person> people = ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, true, JANEDOE, false, JOHNSMITH, true, JANESMITH, false).keySet();
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
        ObjectBooleanHashMapWithHashingStrategy<Person> map = ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, true, JANEDOE, false, JOHNSMITH, true, JANESMITH, false);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, false));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectBooleanHashMapWithHashingStrategyKeySetTest instance;

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
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectBooleanHashMapWithHashingStrategyKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyKeySetTest> removeFromKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ObjectBooleanHashMapWithHashingStrategyKeySetTest::containsAll;
            this.payloads.isEmpty = ObjectBooleanHashMapWithHashingStrategyKeySetTest::isEmpty;
            this.payloads.size = ObjectBooleanHashMapWithHashingStrategyKeySetTest::size;
            this.payloads.iterator = ObjectBooleanHashMapWithHashingStrategyKeySetTest::iterator;
            this.payloads.removeNullFromKeySet = ObjectBooleanHashMapWithHashingStrategyKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectBooleanHashMapWithHashingStrategyKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectBooleanHashMapWithHashingStrategyKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectBooleanHashMapWithHashingStrategyKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectBooleanHashMapWithHashingStrategyKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectBooleanHashMapWithHashingStrategyKeySetTest::keySetToArray;
            this.payloads.contains = ObjectBooleanHashMapWithHashingStrategyKeySetTest::contains;
            this.payloads.removeFromKeySet = ObjectBooleanHashMapWithHashingStrategyKeySetTest::removeFromKeySet;
        }
    }
}
