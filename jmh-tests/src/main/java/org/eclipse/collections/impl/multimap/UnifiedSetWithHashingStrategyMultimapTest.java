/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.multimap.set.AbstractMutableSetMultimapTestCase;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.multimap.set.strategy.UnifiedSetWithHashingStrategyMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link UnifiedSetWithHashingStrategyMultimap}.
 */
public class UnifiedSetWithHashingStrategyMultimapTest extends AbstractMutableSetMultimapTestCase {

    private static final HashingStrategy<Person> LAST_NAME_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final HashingStrategy<Person> FIRST_NAME_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    private static final ImmutableList<Person> PEOPLE = Lists.immutable.of(JOHNSMITH, JANESMITH, JOHNDOE, JANEDOE);

    private static final ImmutableSet<Person> LAST_NAME_HASHED_SET = Sets.immutable.of(JOHNSMITH, JOHNDOE);

    @Override
    public <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimap() {
        return UnifiedSetWithHashingStrategyMultimap.newMultimap(HashingStrategies.defaultStrategy());
    }

    @Override
    public <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        UnifiedSetWithHashingStrategyMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        UnifiedSetWithHashingStrategyMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        UnifiedSetWithHashingStrategyMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        UnifiedSetWithHashingStrategyMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @Override
    protected final <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return UnifiedSetWithHashingStrategyMultimap.newMultimap(HashingStrategies.defaultStrategy(), pairs);
    }

    @Override
    protected <K, V> UnifiedSetWithHashingStrategyMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return UnifiedSetWithHashingStrategyMultimap.newMultimap(HashingStrategies.defaultStrategy(), inputIterable);
    }

    @Override
    protected final <V> MutableSet<V> createCollection(V... args) {
        return UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), args);
    }

    @Override
    @Test
    public void clear() {
        UnifiedSetWithHashingStrategyMultimap<Integer, String> map = this.newMultimapWithKeysValues(1, "1", 1, "One", 2, "2", 2, "Two");
        map.clear();
        Verify.assertEmpty(map);
    }

    @Test
    public void testHashingStrategyConstructors() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> peopleMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(HashingStrategies.defaultStrategy());
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> lastNameMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(LAST_NAME_STRATEGY);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> firstNameMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        peopleMap.putAll(1, PEOPLE);
        lastNameMap.putAll(1, PEOPLE);
        firstNameMap.putAll(1, PEOPLE);
        Verify.assertSetsEqual(PEOPLE.toSet(), peopleMap.get(1));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(JOHNSMITH, JANESMITH), firstNameMap.get(1));
        Verify.assertSetsEqual(LAST_NAME_HASHED_SET.castToSet(), lastNameMap.get(1));
    }

    @Test
    public void testMultimapConstructor() {
        MutableSetMultimap<Integer, Person> map = UnifiedSetMultimap.newMultimap();
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> map2 = UnifiedSetWithHashingStrategyMultimap.newMultimap(LAST_NAME_STRATEGY);
        for (Person person : PEOPLE) {
            map.put(1, person);
            map2.put(1, person);
        }
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> hashingMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(LAST_NAME_STRATEGY, map);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> hashingMap2 = UnifiedSetWithHashingStrategyMultimap.newMultimap(map2);
        Verify.assertSetsEqual(hashingMap.get(1), hashingMap2.get(1));
        Assert.assertSame(hashingMap.getValueHashingStrategy(), hashingMap2.getValueHashingStrategy());
    }

    @Test
    public void testNewEmpty() {
        UnifiedMap<Integer, MutableSet<Person>> expected = UnifiedMap.newMap();
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> lastNameMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(LAST_NAME_STRATEGY);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> newEmptyMap = lastNameMap.newEmpty();
        for (int i = 1; i < 4; ++i) {
            expected.put(i, LAST_NAME_HASHED_SET.toSet());
            lastNameMap.putAll(i, PEOPLE);
            newEmptyMap.putAll(i, PEOPLE);
        }
        Verify.assertMapsEqual(expected, lastNameMap.getMap());
        Verify.assertMapsEqual(expected, newEmptyMap.getMap());
        Assert.assertSame(LAST_NAME_STRATEGY, lastNameMap.getValueHashingStrategy());
        Assert.assertSame(LAST_NAME_STRATEGY, newEmptyMap.getValueHashingStrategy());
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        UnifiedSetWithHashingStrategyMultimap<Object, Person> lastNameMap = UnifiedSetWithHashingStrategyMultimap.newMultimap(LAST_NAME_STRATEGY);
        lastNameMap.putAll(1, PEOPLE);
        lastNameMap.putAll(2, PEOPLE.toList().reverseThis());
        Verify.assertPostSerializedEqualsAndHashCode(lastNameMap);
        UnifiedSetWithHashingStrategyMultimap<Object, Person> deserialized = SerializeTestHelper.serializeDeserialize(lastNameMap);
        Verify.assertSetsEqual(LAST_NAME_HASHED_SET.castToSet(), deserialized.get(1));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(JANEDOE, JANESMITH), deserialized.get(2));
        deserialized.putAll(3, PEOPLE);
        Verify.assertSetsEqual(LAST_NAME_HASHED_SET.castToSet(), deserialized.get(3));
    }

    @Override
    @Test
    public void selectKeysValues() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JOHNSMITH);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> selectedMultimap = multimap.selectKeysValues((key, value) -> (key % 2 == 0) && "Jane".equals(value.getFirstName()));
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> expectedMultimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        expectedMultimap.put(2, JANESMITH);
        expectedMultimap.put(2, JANEDOE);
        Assert.assertEquals(expectedMultimap, selectedMultimap);
        Verify.assertMapsEqual(expectedMultimap.getMap(), selectedMultimap.getMap());
        Assert.assertSame(expectedMultimap.getValueHashingStrategy(), selectedMultimap.getValueHashingStrategy());
    }

    @Override
    @Test
    public void rejectKeysValues() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JOHNSMITH);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> rejectedMultimap = multimap.rejectKeysValues((key, value) -> (key % 2 == 0) || "Jane".equals(value.getFirstName()));
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> expectedMultimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        expectedMultimap.put(1, JOHNSMITH);
        expectedMultimap.put(1, JOHNDOE);
        Assert.assertEquals(expectedMultimap, rejectedMultimap);
        Verify.assertMapsEqual(expectedMultimap.getMap(), rejectedMultimap.getMap());
        Assert.assertSame(expectedMultimap.getValueHashingStrategy(), rejectedMultimap.getValueHashingStrategy());
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JOHNSMITH);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        multimap.put(3, JANESMITH);
        multimap.put(3, JOHNDOE);
        multimap.put(3, JANEDOE);
        multimap.put(4, JOHNSMITH);
        multimap.put(4, JOHNDOE);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> selectedMultimap = multimap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.contains(values, JANEDOE));
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> expectedMultimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        expectedMultimap.put(2, JANESMITH);
        expectedMultimap.put(2, JANEDOE);
        expectedMultimap.put(2, JOHNDOE);
        Assert.assertEquals(expectedMultimap, selectedMultimap);
        Verify.assertMapsEqual(expectedMultimap.getMap(), selectedMultimap.getMap());
        Assert.assertSame(expectedMultimap.getValueHashingStrategy(), selectedMultimap.getValueHashingStrategy());
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        multimap.put(3, JOHNSMITH);
        multimap.put(3, JOHNDOE);
        multimap.put(4, JOHNSMITH);
        multimap.put(4, JOHNDOE);
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> rejectedMultimap = multimap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.contains(values, JANEDOE));
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> expectedMultimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        expectedMultimap.put(3, JOHNSMITH);
        expectedMultimap.put(3, JOHNDOE);
        Assert.assertEquals(expectedMultimap, rejectedMultimap);
        Verify.assertMapsEqual(expectedMultimap.getMap(), rejectedMultimap.getMap());
        Assert.assertSame(expectedMultimap.getValueHashingStrategy(), rejectedMultimap.getValueHashingStrategy());
    }

    @Override
    @Test
    public void collectKeysValues() {
        super.collectKeysValues();
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        MutableBagMultimap<String, Integer> collectedMultimap1 = multimap.collectKeysValues((key, value) -> Tuples.pair(key.toString(), key * value.getAge()));
        MutableBagMultimap<String, Integer> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.put("1", 100);
        expectedMultimap1.put("1", 100);
        expectedMultimap1.put("2", 200);
        expectedMultimap1.put("2", 200);
        Assert.assertEquals(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<String, Integer> collectedMultimap2 = multimap.collectKeysValues((key, value) -> Tuples.pair("1", key * value.getAge()));
        MutableBagMultimap<String, Integer> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.put("1", 100);
        expectedMultimap2.put("1", 100);
        expectedMultimap2.put("1", 200);
        expectedMultimap2.put("1", 200);
        Assert.assertEquals(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        super.collectKeyMultiValues();
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        MutableBagMultimap<String, Integer> collectedMultimap1 = multimap.collectKeyMultiValues(Object::toString, Person::getAge);
        MutableBagMultimap<String, Integer> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.put("1", 100);
        expectedMultimap1.put("2", 100);
        Assert.assertEquals(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<String, Integer> collectedMultimap2 = multimap.collectKeyMultiValues(key -> "1", Person::getAge);
        MutableBagMultimap<String, Integer> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.put("1", 100);
        expectedMultimap2.put("1", 100);
        Assert.assertEquals(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectValues() {
        UnifiedSetWithHashingStrategyMultimap<Integer, Person> multimap = UnifiedSetWithHashingStrategyMultimap.newMultimap(FIRST_NAME_STRATEGY);
        multimap.put(1, JANESMITH);
        multimap.put(1, JOHNDOE);
        multimap.put(1, JANEDOE);
        multimap.put(1, JANEDOE);
        multimap.put(2, JANESMITH);
        multimap.put(2, JOHNSMITH);
        multimap.put(2, JOHNDOE);
        multimap.put(2, JANEDOE);
        MutableBagMultimap<Integer, Integer> collectedMultimap = multimap.collectValues(Person::getAge);
        MutableBagMultimap<Integer, Integer> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.put(1, 100);
        expectedMultimap.put(2, 100);
        Assert.assertEquals(expectedMultimap, collectedMultimap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetWithHashingStrategyMultimapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMultimapFromPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMultimapFromPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMultiValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMultiValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_multiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.multiValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysWithMultiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysWithMultiValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuePairsView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuePairsView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAndGrowMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndGrowMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValuesNullValueHandling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValuesNullValueHandling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_createCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_createCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues_absent_key() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues_absent_key);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashingStrategyConstructors() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashingStrategyConstructors);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMultimapConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMultimapConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeyMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetWithHashingStrategyMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> forEachKeyMutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testHashingStrategyConstructors;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testMultimapConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = UnifiedSetWithHashingStrategyMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = UnifiedSetWithHashingStrategyMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = UnifiedSetWithHashingStrategyMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = UnifiedSetWithHashingStrategyMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = UnifiedSetWithHashingStrategyMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = UnifiedSetWithHashingStrategyMultimapTest::forEachValue;
            this.payloads.valuesView = UnifiedSetWithHashingStrategyMultimapTest::valuesView;
            this.payloads.multiValuesView = UnifiedSetWithHashingStrategyMultimapTest::multiValuesView;
            this.payloads.notEmpty = UnifiedSetWithHashingStrategyMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = UnifiedSetWithHashingStrategyMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = UnifiedSetWithHashingStrategyMultimapTest::keyValuePairsView;
            this.payloads.keyBag = UnifiedSetWithHashingStrategyMultimapTest::keyBag;
            this.payloads.testEquals = UnifiedSetWithHashingStrategyMultimapTest::testEquals;
            this.payloads.testHashCode = UnifiedSetWithHashingStrategyMultimapTest::testHashCode;
            this.payloads.newEmpty = UnifiedSetWithHashingStrategyMultimapTest::newEmpty;
            this.payloads.keysView = UnifiedSetWithHashingStrategyMultimapTest::keysView;
            this.payloads.keySet = UnifiedSetWithHashingStrategyMultimapTest::keySet;
            this.payloads.sizeDistinct = UnifiedSetWithHashingStrategyMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = UnifiedSetWithHashingStrategyMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = UnifiedSetWithHashingStrategyMultimapTest::addAndGrowMultimap;
            this.payloads.removeObject = UnifiedSetWithHashingStrategyMultimapTest::removeObject;
            this.payloads.forEachKey = UnifiedSetWithHashingStrategyMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = UnifiedSetWithHashingStrategyMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = UnifiedSetWithHashingStrategyMultimapTest::putAll;
            this.payloads.putAllFromCollection = UnifiedSetWithHashingStrategyMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = UnifiedSetWithHashingStrategyMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = UnifiedSetWithHashingStrategyMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = UnifiedSetWithHashingStrategyMultimapTest::removeKey;
            this.payloads.containsValue = UnifiedSetWithHashingStrategyMultimapTest::containsValue;
            this.payloads.put_createCollection = UnifiedSetWithHashingStrategyMultimapTest::put_createCollection;
            this.payloads.remove = UnifiedSetWithHashingStrategyMultimapTest::remove;
            this.payloads.replaceValues = UnifiedSetWithHashingStrategyMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = UnifiedSetWithHashingStrategyMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = UnifiedSetWithHashingStrategyMultimapTest::toMap;
            this.payloads.toImmutable = UnifiedSetWithHashingStrategyMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = UnifiedSetWithHashingStrategyMultimapTest::toMapWithTarget;
            this.payloads.toMutable = UnifiedSetWithHashingStrategyMultimapTest::toMutable;
            this.payloads.testToString = UnifiedSetWithHashingStrategyMultimapTest::testToString;
            this.payloads.forEachKeyMutableSet = UnifiedSetWithHashingStrategyMultimapTest::forEachKeyMutableSet;
            this.payloads.putAllPairs = UnifiedSetWithHashingStrategyMultimapTest::putAllPairs;
            this.payloads.flip = UnifiedSetWithHashingStrategyMultimapTest::flip;
            this.payloads.clear = UnifiedSetWithHashingStrategyMultimapTest::clear;
            this.payloads.testHashingStrategyConstructors = UnifiedSetWithHashingStrategyMultimapTest::testHashingStrategyConstructors;
            this.payloads.testMultimapConstructor = UnifiedSetWithHashingStrategyMultimapTest::testMultimapConstructor;
            this.payloads.testNewEmpty = UnifiedSetWithHashingStrategyMultimapTest::testNewEmpty;
            this.payloads.serialization = UnifiedSetWithHashingStrategyMultimapTest::serialization;
            this.payloads.selectKeysValues = UnifiedSetWithHashingStrategyMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = UnifiedSetWithHashingStrategyMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = UnifiedSetWithHashingStrategyMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = UnifiedSetWithHashingStrategyMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = UnifiedSetWithHashingStrategyMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = UnifiedSetWithHashingStrategyMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = UnifiedSetWithHashingStrategyMultimapTest::collectValues;
        }
    }
}
