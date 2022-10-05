/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.multimap.bag.BagMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractMutableMultimapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractMutableBagMultimapTestCase extends AbstractMutableMultimapTestCase {

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimap();

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimap(Pair<K, V>... pairs);

    @Override
    protected abstract <K, V> MutableBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable);

    @Override
    protected abstract <V> MutableBag<V> createCollection(V... args);

    @Test
    public void forEachKeyMutableBag() {
        MutableBag<Pair<Integer, MutableBag<String>>> collection = Bags.mutable.empty();
        MutableBagMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(2, "2", 2, "1", 3, "3", 3, "3");
        multimap.forEachKeyMutableBag((key, values) -> collection.add(Tuples.pair(key, values)));
        MutableBag<Pair<Integer, MutableCollection<String>>> expected = Bags.mutable.with(Tuples.pair(2, this.createCollection("2", "1")), Tuples.pair(3, this.createCollection("3", "3")));
        Assert.assertEquals(expected, collection);
    }

    @Override
    @Test
    public void flip() {
        BagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("Less than 2", 1, "Less than 3", 1, "Less than 3", 2, "Less than 3", 2);
        BagMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Bags.immutable.with("Less than 3", "Less than 3"), flipped.get(2));
        Assert.assertEquals(Bags.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void selectKeysValues() {
        super.selectKeysValues();
        MutableBagMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("One", FastList.newListWith(1, 2, 3, 4, 4));
        multimap.putAll("Two", FastList.newListWith(2, 3, 4, 5, 3, 2));
        MutableBagMultimap<String, Integer> selectedMultimap = multimap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableBagMultimap<String, Integer> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("Two", FastList.newListWith(2, 4, 2));
        Verify.assertBagMultimapsEqual(expectedMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysValues() {
        super.rejectKeysValues();
        MutableBagMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("One", FastList.newListWith(1, 2, 3, 4, 1));
        multimap.putAll("Two", FastList.newListWith(2, 3, 4, 5));
        MutableBagMultimap<String, Integer> rejectedMultimap = multimap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableBagMultimap<String, Integer> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("One", FastList.newListWith(1, 3, 1));
        Verify.assertBagMultimapsEqual(expectedMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        super.selectKeysMultiValues();
        MutableBagMultimap<Integer, String> multimap = this.newMultimap();
        multimap.putAll(1, FastList.newListWith("1", "3", "4"));
        multimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        multimap.putAll(3, FastList.newListWith("2", "3", "4", "5", "2"));
        multimap.putAll(4, FastList.newListWith("1", "3", "4"));
        MutableBagMultimap<Integer, String> selectedMultimap = multimap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        Verify.assertBagMultimapsEqual(expectedMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        super.rejectKeysMultiValues();
        MutableBagMultimap<Integer, String> multimap = this.newMultimap();
        multimap.putAll(1, FastList.newListWith("1", "2", "3", "4", "1"));
        multimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "1"));
        multimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        multimap.putAll(4, FastList.newListWith("1", "3", "4", "5"));
        MutableBagMultimap<Integer, String> rejectedMultimap = multimap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 4);
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        Verify.assertBagMultimapsEqual(expectedMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void collectKeysValues() {
        super.collectKeysValues();
        MutableBagMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 4));
        multimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 3, 2));
        MutableBagMultimap<Integer, String> collectedMultimap = multimap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "4Value"));
        expectedMultimap.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap, collectedMultimap);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        super.collectKeyMultiValues();
        MutableBagMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 4));
        multimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 3, 2));
        MutableBagMultimap<Integer, String> collectedMultimap = multimap.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "4Value"));
        expectedMultimap.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap, collectedMultimap);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectValues() {
        super.collectValues();
        MutableBagMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 4));
        multimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 3, 2));
        MutableBagMultimap<String, String> collectedMultimap = multimap.collectValues(value -> value + "Value");
        MutableBagMultimap<String, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("1Value", "2Value", "3Value", "4Value", "4Value"));
        expectedMultimap.putAll("2", FastList.newListWith("2Value", "3Value", "4Value", "5Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap, collectedMultimap);
    }

    @Test
    public void putOccurrences() {
        MutableBagMultimap<String, String> multimap = this.newMultimap();
        Assert.assertThrows(IllegalArgumentException.class, () -> multimap.putOccurrences("1", "a", -1));
        multimap.putOccurrences("1", "a", 0);
        Verify.assertEmpty(multimap);
        multimap.putOccurrences("2", "b", 1);
        Verify.assertSize(1, multimap);
        Verify.assertBagsEqual(HashBag.newBagWith("b"), multimap.get("2"));
        multimap.putOccurrences("2", "b", 2);
        Verify.assertSize(3, multimap);
        Verify.assertBagsEqual(HashBag.newBagWith("b", "b", "b"), multimap.get("2"));
        multimap.putOccurrences("2", "b", 0);
        Verify.assertSize(3, multimap);
        Verify.assertBagsEqual(HashBag.newBagWith("b", "b", "b"), multimap.get("2"));
        Assert.assertThrows(IllegalArgumentException.class, () -> multimap.putOccurrences("2", "b", -1));
        multimap.putOccurrences("2", "c", 2);
        Verify.assertSize(5, multimap);
        Verify.assertBagsEqual(HashBag.newBagWith("b", "b", "b", "c", "c"), multimap.get("2"));
        multimap.putOccurrences("3", "d", 3);
        Verify.assertSize(8, multimap);
        Verify.assertBagsEqual(HashBag.newBagWith("b", "b", "b", "c", "c"), multimap.get("2"));
        Verify.assertBagsEqual(HashBag.newBagWith("d", "d", "d"), multimap.get("3"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableBagMultimapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableBagMultimapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> forEachKeyMutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBagMultimapTestCase> putOccurrences;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = AbstractMutableBagMultimapTestCase::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = AbstractMutableBagMultimapTestCase::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = AbstractMutableBagMultimapTestCase::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = AbstractMutableBagMultimapTestCase::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = AbstractMutableBagMultimapTestCase::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = AbstractMutableBagMultimapTestCase::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = AbstractMutableBagMultimapTestCase::newMultimapFromPairs;
            this.payloads.isEmpty = AbstractMutableBagMultimapTestCase::isEmpty;
            this.payloads.forEachKeyValue = AbstractMutableBagMultimapTestCase::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = AbstractMutableBagMultimapTestCase::forEachKeyMultiValue;
            this.payloads.forEachValue = AbstractMutableBagMultimapTestCase::forEachValue;
            this.payloads.valuesView = AbstractMutableBagMultimapTestCase::valuesView;
            this.payloads.multiValuesView = AbstractMutableBagMultimapTestCase::multiValuesView;
            this.payloads.notEmpty = AbstractMutableBagMultimapTestCase::notEmpty;
            this.payloads.keysWithMultiValuesView = AbstractMutableBagMultimapTestCase::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = AbstractMutableBagMultimapTestCase::keyValuePairsView;
            this.payloads.keyBag = AbstractMutableBagMultimapTestCase::keyBag;
            this.payloads.testEquals = AbstractMutableBagMultimapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableBagMultimapTestCase::testHashCode;
            this.payloads.serialization = AbstractMutableBagMultimapTestCase::serialization;
            this.payloads.newEmpty = AbstractMutableBagMultimapTestCase::newEmpty;
            this.payloads.keysView = AbstractMutableBagMultimapTestCase::keysView;
            this.payloads.keySet = AbstractMutableBagMultimapTestCase::keySet;
            this.payloads.sizeDistinct = AbstractMutableBagMultimapTestCase::sizeDistinct;
            this.payloads.putAndGrowMultimap = AbstractMutableBagMultimapTestCase::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = AbstractMutableBagMultimapTestCase::addAndGrowMultimap;
            this.payloads.clear = AbstractMutableBagMultimapTestCase::clear;
            this.payloads.removeObject = AbstractMutableBagMultimapTestCase::removeObject;
            this.payloads.forEachKey = AbstractMutableBagMultimapTestCase::forEachKey;
            this.payloads.withKeyMultiValues = AbstractMutableBagMultimapTestCase::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBagMultimapTestCase::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = AbstractMutableBagMultimapTestCase::putAll;
            this.payloads.putAllPairs = AbstractMutableBagMultimapTestCase::putAllPairs;
            this.payloads.putAllFromCollection = AbstractMutableBagMultimapTestCase::putAllFromCollection;
            this.payloads.putAllFromIterable = AbstractMutableBagMultimapTestCase::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = AbstractMutableBagMultimapTestCase::getIfAbsentPutAll;
            this.payloads.removeKey = AbstractMutableBagMultimapTestCase::removeKey;
            this.payloads.containsValue = AbstractMutableBagMultimapTestCase::containsValue;
            this.payloads.put_createCollection = AbstractMutableBagMultimapTestCase::put_createCollection;
            this.payloads.remove = AbstractMutableBagMultimapTestCase::remove;
            this.payloads.replaceValues = AbstractMutableBagMultimapTestCase::replaceValues;
            this.payloads.replaceValues_absent_key = AbstractMutableBagMultimapTestCase::replaceValues_absent_key;
            this.payloads.toMap = AbstractMutableBagMultimapTestCase::toMap;
            this.payloads.toImmutable = AbstractMutableBagMultimapTestCase::toImmutable;
            this.payloads.toMapWithTarget = AbstractMutableBagMultimapTestCase::toMapWithTarget;
            this.payloads.toMutable = AbstractMutableBagMultimapTestCase::toMutable;
            this.payloads.testToString = AbstractMutableBagMultimapTestCase::testToString;
            this.payloads.forEachKeyMutableBag = AbstractMutableBagMultimapTestCase::forEachKeyMutableBag;
            this.payloads.flip = AbstractMutableBagMultimapTestCase::flip;
            this.payloads.selectKeysValues = AbstractMutableBagMultimapTestCase::selectKeysValues;
            this.payloads.rejectKeysValues = AbstractMutableBagMultimapTestCase::rejectKeysValues;
            this.payloads.selectKeysMultiValues = AbstractMutableBagMultimapTestCase::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = AbstractMutableBagMultimapTestCase::rejectKeysMultiValues;
            this.payloads.collectKeysValues = AbstractMutableBagMultimapTestCase::collectKeysValues;
            this.payloads.collectKeyMultiValues = AbstractMutableBagMultimapTestCase::collectKeyMultiValues;
            this.payloads.collectValues = AbstractMutableBagMultimapTestCase::collectValues;
            this.payloads.putOccurrences = AbstractMutableBagMultimapTestCase::putOccurrences;
        }
    }
}
