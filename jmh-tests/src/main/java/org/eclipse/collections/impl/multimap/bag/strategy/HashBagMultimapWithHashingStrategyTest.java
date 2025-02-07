/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag.strategy;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.map.strategy.mutable.UnifiedMapWithHashingStrategy;
import org.eclipse.collections.impl.multimap.bag.AbstractMutableBagMultimapTestCase;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link HashBagMultimap}.
 */
public class HashBagMultimapWithHashingStrategyTest extends AbstractMutableBagMultimapTestCase {

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimap() {
        return HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.defaultStrategy());
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Override
    protected final <K, V> MutableBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.defaultStrategy(), pairs);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.defaultStrategy(), inputIterable);
    }

    @Override
    protected final <V> MutableBag<V> createCollection(V... args) {
        return Bags.mutable.of(args);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        MutableBagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        ImmutableMultimap<String, Integer> actual = multimap.toImmutable();
        Assert.assertNotNull(actual);
        Assert.assertEquals(multimap, actual);
        // ideally this should go back to HashBagMultimapWithHashingStrategy
        Verify.assertInstanceOf(HashBagMultimap.class, actual.toMutable());
    }

    @Override
    @Test
    public void toMutable() {
        super.toMutable();
        MutableBagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        MutableMultimap<String, Integer> mutableCopy = multimap.toMutable();
        Assert.assertNotSame(multimap, mutableCopy);
        Assert.assertEquals(multimap, mutableCopy);
        Verify.assertInstanceOf(HashBagMultimapWithHashingStrategy.class, mutableCopy);
    }

    @Override
    @Test
    public void toMap() {
        super.toMap();
        MutableBagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        UnifiedMapWithHashingStrategy<String, RichIterable<Integer>> expected = UnifiedMapWithHashingStrategy.newMap(HashingStrategies.defaultStrategy());
        expected.put("One", this.createCollection(1));
        expected.put("Two", this.createCollection(2, 2));
        MutableMap<String, RichIterable<Integer>> actual = multimap.toMap();
        Assert.assertEquals(expected, actual);
        Verify.assertInstanceOf(UnifiedMapWithHashingStrategy.class, actual);
    }

    @Override
    @Test
    public void toMapWithTarget() {
        super.toMapWithTarget();
        MutableBagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        UnifiedMapWithHashingStrategy<String, RichIterable<Integer>> expected = UnifiedMapWithHashingStrategy.newMap(HashingStrategies.defaultStrategy());
        expected.put("One", UnifiedSet.newSetWith(1));
        expected.put("Two", UnifiedSet.newSetWith(2, 2));
        MutableMap<String, MutableSet<Integer>> actual = multimap.toMap(UnifiedSet::new);
        Assert.assertEquals(expected, actual);
        Verify.assertInstanceOf(UnifiedMapWithHashingStrategy.class, actual);
    }

    @Test
    public void testHashingStrategyConstructor() {
        HashBagMultimapWithHashingStrategy<Integer, Integer> multimapWithIdentity = HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.identityStrategy());
        multimapWithIdentity.put(new Integer(1), 1);
        multimapWithIdentity.putAll(new Integer(1), Lists.fixedSize.of(2, 20, 1));
        multimapWithIdentity.put(new Integer(1), 3);
        Assert.assertEquals(3, multimapWithIdentity.sizeDistinct());
        Verify.assertSize(5, multimapWithIdentity);
        HashBagMultimapWithHashingStrategy<Integer, Integer> multimapWithDefault = HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.defaultStrategy(), multimapWithIdentity);
        Assert.assertEquals(1, multimapWithDefault.sizeDistinct());
        Verify.assertSize(5, multimapWithDefault);
        Verify.assertIterablesEqual(multimapWithIdentity.valuesView().toBag(), multimapWithDefault.valuesView().toBag());
        HashBagMultimapWithHashingStrategy<Integer, Integer> copyOfMultimapWithDefault = HashBagMultimapWithHashingStrategy.newMultimap(multimapWithDefault);
        Verify.assertMapsEqual(multimapWithDefault.toMap(), copyOfMultimapWithDefault.toMap());
    }

    @Test
    public void testKeyHashingStrategy() {
        HashBagMultimapWithHashingStrategy<Integer, Integer> multimap = HashBagMultimapWithHashingStrategy.newMultimap(HashingStrategies.identityStrategy());
        Assert.assertEquals(HashingStrategies.identityStrategy(), multimap.getKeyHashingStrategy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBagMultimapWithHashingStrategyTest instance;

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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashingStrategyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashingStrategyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testKeyHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testKeyHashingStrategy);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new HashBagMultimapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> forEachKeyMutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> putOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testHashingStrategyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapWithHashingStrategyTest> testKeyHashingStrategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = HashBagMultimapWithHashingStrategyTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = HashBagMultimapWithHashingStrategyTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = HashBagMultimapWithHashingStrategyTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = HashBagMultimapWithHashingStrategyTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = HashBagMultimapWithHashingStrategyTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = HashBagMultimapWithHashingStrategyTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = HashBagMultimapWithHashingStrategyTest::newMultimapFromPairs;
            this.payloads.isEmpty = HashBagMultimapWithHashingStrategyTest::isEmpty;
            this.payloads.forEachKeyValue = HashBagMultimapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = HashBagMultimapWithHashingStrategyTest::forEachKeyMultiValue;
            this.payloads.forEachValue = HashBagMultimapWithHashingStrategyTest::forEachValue;
            this.payloads.valuesView = HashBagMultimapWithHashingStrategyTest::valuesView;
            this.payloads.multiValuesView = HashBagMultimapWithHashingStrategyTest::multiValuesView;
            this.payloads.notEmpty = HashBagMultimapWithHashingStrategyTest::notEmpty;
            this.payloads.keysWithMultiValuesView = HashBagMultimapWithHashingStrategyTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = HashBagMultimapWithHashingStrategyTest::keyValuePairsView;
            this.payloads.keyBag = HashBagMultimapWithHashingStrategyTest::keyBag;
            this.payloads.testEquals = HashBagMultimapWithHashingStrategyTest::testEquals;
            this.payloads.testHashCode = HashBagMultimapWithHashingStrategyTest::testHashCode;
            this.payloads.serialization = HashBagMultimapWithHashingStrategyTest::serialization;
            this.payloads.newEmpty = HashBagMultimapWithHashingStrategyTest::newEmpty;
            this.payloads.keysView = HashBagMultimapWithHashingStrategyTest::keysView;
            this.payloads.keySet = HashBagMultimapWithHashingStrategyTest::keySet;
            this.payloads.sizeDistinct = HashBagMultimapWithHashingStrategyTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = HashBagMultimapWithHashingStrategyTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = HashBagMultimapWithHashingStrategyTest::addAndGrowMultimap;
            this.payloads.clear = HashBagMultimapWithHashingStrategyTest::clear;
            this.payloads.removeObject = HashBagMultimapWithHashingStrategyTest::removeObject;
            this.payloads.forEachKey = HashBagMultimapWithHashingStrategyTest::forEachKey;
            this.payloads.withKeyMultiValues = HashBagMultimapWithHashingStrategyTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagMultimapWithHashingStrategyTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = HashBagMultimapWithHashingStrategyTest::putAll;
            this.payloads.putAllPairs = HashBagMultimapWithHashingStrategyTest::putAllPairs;
            this.payloads.putAllFromCollection = HashBagMultimapWithHashingStrategyTest::putAllFromCollection;
            this.payloads.putAllFromIterable = HashBagMultimapWithHashingStrategyTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = HashBagMultimapWithHashingStrategyTest::getIfAbsentPutAll;
            this.payloads.removeKey = HashBagMultimapWithHashingStrategyTest::removeKey;
            this.payloads.containsValue = HashBagMultimapWithHashingStrategyTest::containsValue;
            this.payloads.put_createCollection = HashBagMultimapWithHashingStrategyTest::put_createCollection;
            this.payloads.remove = HashBagMultimapWithHashingStrategyTest::remove;
            this.payloads.replaceValues = HashBagMultimapWithHashingStrategyTest::replaceValues;
            this.payloads.replaceValues_absent_key = HashBagMultimapWithHashingStrategyTest::replaceValues_absent_key;
            this.payloads.testToString = HashBagMultimapWithHashingStrategyTest::testToString;
            this.payloads.forEachKeyMutableBag = HashBagMultimapWithHashingStrategyTest::forEachKeyMutableBag;
            this.payloads.flip = HashBagMultimapWithHashingStrategyTest::flip;
            this.payloads.selectKeysValues = HashBagMultimapWithHashingStrategyTest::selectKeysValues;
            this.payloads.rejectKeysValues = HashBagMultimapWithHashingStrategyTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = HashBagMultimapWithHashingStrategyTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = HashBagMultimapWithHashingStrategyTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = HashBagMultimapWithHashingStrategyTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = HashBagMultimapWithHashingStrategyTest::collectKeyMultiValues;
            this.payloads.collectValues = HashBagMultimapWithHashingStrategyTest::collectValues;
            this.payloads.putOccurrences = HashBagMultimapWithHashingStrategyTest::putOccurrences;
            this.payloads.toImmutable = HashBagMultimapWithHashingStrategyTest::toImmutable;
            this.payloads.toMutable = HashBagMultimapWithHashingStrategyTest::toMutable;
            this.payloads.toMap = HashBagMultimapWithHashingStrategyTest::toMap;
            this.payloads.toMapWithTarget = HashBagMultimapWithHashingStrategyTest::toMapWithTarget;
            this.payloads.testHashingStrategyConstructor = HashBagMultimapWithHashingStrategyTest::testHashingStrategyConstructor;
            this.payloads.testKeyHashingStrategy = HashBagMultimapWithHashingStrategyTest::testKeyHashingStrategy;
        }
    }
}
