/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.multimap.set.SetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractMutableMultimapTestCase;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractMutableSetMultimapTestCase extends AbstractMutableMultimapTestCase {

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimap();

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimap(Pair<K, V>... pairs);

    @Override
    protected abstract <K, V> MutableSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable);

    @Override
    protected abstract <V> MutableSet<V> createCollection(V... args);

    @Test
    public void forEachKeyMutableSet() {
        MutableSet<Pair<Integer, MutableSet<String>>> collection = UnifiedSet.newSet();
        MutableSetMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(2, "2", 2, "1", 3, "3", 3, "3");
        multimap.forEachKeyMutableSet((key, values) -> collection.add(Tuples.pair(key, values)));
        MutableSet<Pair<Integer, MutableSet<String>>> expected = Sets.mutable.with(Tuples.pair(2, this.createCollection("2", "1")), Tuples.pair(3, this.createCollection("3", "3")));
        Assert.assertEquals(expected, collection);
    }

    @Test
    @Override
    public void putAllPairs() {
        super.putAllPairs();
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "2");
        MutableList<Pair<Integer, String>> pairs = Lists.mutable.of(Tuples.pair(1, "One"));
        Assert.assertFalse(multimap.putAllPairs(pairs));
        MutableMultimap<Integer, String> expected = this.newMultimapWithKeysValues(1, "One", 2, "2");
        Assert.assertEquals(expected, multimap);
    }

    @Override
    @Test
    public void flip() {
        SetMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("Less than 2", 1, "Less than 3", 1, "Less than 3", 2, "Less than 3", 2);
        SetMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Sets.immutable.with("Less than 3"), flipped.get(2));
        Assert.assertEquals(Sets.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void selectKeysValues() {
        MutableSetMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("One", FastList.newListWith(1, 1, 2, 3, 4));
        multimap.putAll("Two", FastList.newListWith(2, 2, 3, 4, 5));
        MutableSetMultimap<String, Integer> selectedMultimap = multimap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableSetMultimap<String, Integer> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll("Two", FastList.newListWith(2, 4));
        Verify.assertSetMultimapsEqual(expectedMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysValues() {
        MutableSetMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("One", FastList.newListWith(1, 1, 2, 3, 4));
        multimap.putAll("Two", FastList.newListWith(2, 2, 3, 4, 5));
        MutableSetMultimap<String, Integer> rejectedMultimap = multimap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableSetMultimap<String, Integer> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll("One", FastList.newListWith(1, 3));
        Verify.assertSetMultimapsEqual(expectedMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        super.selectKeysMultiValues();
        MutableSetMultimap<Integer, String> multimap = this.newMultimap();
        multimap.putAll(1, FastList.newListWith("1", "3", "4"));
        multimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        multimap.putAll(3, FastList.newListWith("2", "3", "4", "5", "2"));
        multimap.putAll(4, FastList.newListWith("1", "3", "4"));
        MutableSetMultimap<Integer, String> selectedMultimap = multimap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableSetMultimap<Integer, String> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        Verify.assertSetMultimapsEqual(expectedMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        super.rejectKeysMultiValues();
        MutableSetMultimap<Integer, String> multimap = this.newMultimap();
        multimap.putAll(1, FastList.newListWith("1", "2", "3", "4", "5", "1"));
        multimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "1"));
        multimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        multimap.putAll(4, FastList.newListWith("1", "3", "4", "5"));
        MutableSetMultimap<Integer, String> rejectedMultimap = multimap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 4);
        MutableSetMultimap<Integer, String> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        Verify.assertSetMultimapsEqual(expectedMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void collectKeysValues() {
        MutableSetMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("1", FastList.newListWith(1, 2, 3, 4));
        multimap.putAll("2", FastList.newListWith(2, 3, 4, 5));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        MutableSetMultimap<String, Integer> multimap1 = this.newMultimap();
        multimap1.putAll("1", FastList.newListWith(1, 2, 3, 4));
        multimap1.putAll("2", FastList.newListWith(2, 3, 4, 5));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap1.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap1.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
        Multimap<String, Integer> multimap2 = this.newMultimap(Tuples.pair("1", 1), Tuples.pair("1", 1), Tuples.pair("1", 12), Tuples.pair("2", 2), Tuples.pair("2", 2), Tuples.pair("3", 3));
        Multimap<Integer, Integer> collectedMultimap3 = multimap2.collectKeyMultiValues(key -> 1, value -> value % 2 == 0 ? value + 1 : value, Multimaps.mutable.set.empty());
        SetMultimap<Integer, Integer> expectedMultimap3 = Multimaps.mutable.set.with(1, 1, 1, 13, 1, 3);
        Assert.assertEquals(expectedMultimap3, collectedMultimap3);
        Multimap<Integer, Integer> collectedMultimap4 = multimap2.collectKeyMultiValues(key -> 1, value -> value % 2 == 0 ? value + 1 : value, Multimaps.mutable.list.empty());
        MutableListMultimap<Integer, Integer> expectedMultimap4 = Multimaps.mutable.list.with(1, 1, 1, 3, 1, 13);
        expectedMultimap4.put(1, 3);
        Assert.assertEquals(expectedMultimap4.keySet(), collectedMultimap4.keySet());
        Assert.assertEquals(expectedMultimap4.get(1).toBag(), collectedMultimap4.get(1).toBag());
    }

    @Override
    @Test
    public void collectValues() {
        MutableSetMultimap<String, Integer> multimap = this.newMultimap();
        multimap.putAll("1", FastList.newListWith(1, 2, 3, 4));
        multimap.putAll("2", FastList.newListWith(2, 3, 4, 5));
        MutableBagMultimap<String, String> collectedMultimap = multimap.collectValues(value -> value + "Value");
        MutableBagMultimap<String, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap.putAll("2", FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap, collectedMultimap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableSetMultimapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMultimapFromPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMultimapFromPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMultiValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMultiValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_multiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.multiValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysWithMultiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysWithMultiValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuePairsView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuePairsView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAndGrowMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndGrowMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValuesNullValueHandling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValuesNullValueHandling);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_createCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_createCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues_absent_key() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues_absent_key);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysMultiValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysMultiValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeyMultiValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableSetMultimapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> forEachKeyMutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetMultimapTestCase> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = AbstractMutableSetMultimapTestCase::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = AbstractMutableSetMultimapTestCase::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = AbstractMutableSetMultimapTestCase::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = AbstractMutableSetMultimapTestCase::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = AbstractMutableSetMultimapTestCase::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = AbstractMutableSetMultimapTestCase::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = AbstractMutableSetMultimapTestCase::newMultimapFromPairs;
            this.payloads.isEmpty = AbstractMutableSetMultimapTestCase::isEmpty;
            this.payloads.forEachKeyValue = AbstractMutableSetMultimapTestCase::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = AbstractMutableSetMultimapTestCase::forEachKeyMultiValue;
            this.payloads.forEachValue = AbstractMutableSetMultimapTestCase::forEachValue;
            this.payloads.valuesView = AbstractMutableSetMultimapTestCase::valuesView;
            this.payloads.multiValuesView = AbstractMutableSetMultimapTestCase::multiValuesView;
            this.payloads.notEmpty = AbstractMutableSetMultimapTestCase::notEmpty;
            this.payloads.keysWithMultiValuesView = AbstractMutableSetMultimapTestCase::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = AbstractMutableSetMultimapTestCase::keyValuePairsView;
            this.payloads.keyBag = AbstractMutableSetMultimapTestCase::keyBag;
            this.payloads.testEquals = AbstractMutableSetMultimapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableSetMultimapTestCase::testHashCode;
            this.payloads.serialization = AbstractMutableSetMultimapTestCase::serialization;
            this.payloads.newEmpty = AbstractMutableSetMultimapTestCase::newEmpty;
            this.payloads.keysView = AbstractMutableSetMultimapTestCase::keysView;
            this.payloads.keySet = AbstractMutableSetMultimapTestCase::keySet;
            this.payloads.sizeDistinct = AbstractMutableSetMultimapTestCase::sizeDistinct;
            this.payloads.putAndGrowMultimap = AbstractMutableSetMultimapTestCase::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = AbstractMutableSetMultimapTestCase::addAndGrowMultimap;
            this.payloads.clear = AbstractMutableSetMultimapTestCase::clear;
            this.payloads.removeObject = AbstractMutableSetMultimapTestCase::removeObject;
            this.payloads.forEachKey = AbstractMutableSetMultimapTestCase::forEachKey;
            this.payloads.withKeyMultiValues = AbstractMutableSetMultimapTestCase::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetMultimapTestCase::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = AbstractMutableSetMultimapTestCase::putAll;
            this.payloads.putAllFromCollection = AbstractMutableSetMultimapTestCase::putAllFromCollection;
            this.payloads.putAllFromIterable = AbstractMutableSetMultimapTestCase::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = AbstractMutableSetMultimapTestCase::getIfAbsentPutAll;
            this.payloads.removeKey = AbstractMutableSetMultimapTestCase::removeKey;
            this.payloads.containsValue = AbstractMutableSetMultimapTestCase::containsValue;
            this.payloads.put_createCollection = AbstractMutableSetMultimapTestCase::put_createCollection;
            this.payloads.remove = AbstractMutableSetMultimapTestCase::remove;
            this.payloads.replaceValues = AbstractMutableSetMultimapTestCase::replaceValues;
            this.payloads.replaceValues_absent_key = AbstractMutableSetMultimapTestCase::replaceValues_absent_key;
            this.payloads.toMap = AbstractMutableSetMultimapTestCase::toMap;
            this.payloads.toImmutable = AbstractMutableSetMultimapTestCase::toImmutable;
            this.payloads.toMapWithTarget = AbstractMutableSetMultimapTestCase::toMapWithTarget;
            this.payloads.toMutable = AbstractMutableSetMultimapTestCase::toMutable;
            this.payloads.testToString = AbstractMutableSetMultimapTestCase::testToString;
            this.payloads.forEachKeyMutableSet = AbstractMutableSetMultimapTestCase::forEachKeyMutableSet;
            this.payloads.putAllPairs = AbstractMutableSetMultimapTestCase::putAllPairs;
            this.payloads.flip = AbstractMutableSetMultimapTestCase::flip;
            this.payloads.selectKeysValues = AbstractMutableSetMultimapTestCase::selectKeysValues;
            this.payloads.rejectKeysValues = AbstractMutableSetMultimapTestCase::rejectKeysValues;
            this.payloads.selectKeysMultiValues = AbstractMutableSetMultimapTestCase::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = AbstractMutableSetMultimapTestCase::rejectKeysMultiValues;
            this.payloads.collectKeysValues = AbstractMutableSetMultimapTestCase::collectKeysValues;
            this.payloads.collectKeyMultiValues = AbstractMutableSetMultimapTestCase::collectKeyMultiValues;
            this.payloads.collectValues = AbstractMutableSetMultimapTestCase::collectValues;
        }
    }
*/
}
