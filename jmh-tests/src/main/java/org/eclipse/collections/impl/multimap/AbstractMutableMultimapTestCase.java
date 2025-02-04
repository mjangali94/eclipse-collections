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

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Helper class for testing {@link Multimap}s.
 */
public abstract class AbstractMutableMultimapTestCase extends AbstractMultimapTestCase {

    @Override
    protected abstract <K, V> MutableMultimap<K, V> newMultimap();

    @Override
    protected abstract <K, V> MutableMultimap<K, V> newMultimapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Test
    public void putAndGrowMultimap() {
        MutableMultimap<Integer, Integer> multimap = this.newMultimap();
        multimap.put(1, 1);
        multimap.put(2, 2);
        Verify.assertContainsEntry(1, 1, multimap);
        Verify.assertContainsEntry(2, 2, multimap);
    }

    @Test
    public void addAndGrowMultimap() {
        MutableMultimap<Integer, String> multimap = this.newMultimap();
        Pair<Integer, String> pair1 = Tuples.pair(1, "One");
        Pair<Integer, String> pair2 = Tuples.pair(2, "Two");
        Pair<Integer, String> pair3 = Tuples.pair(3, "Three");
        Pair<Integer, String> pair4 = Tuples.pair(4, "Four");
        Assert.assertTrue(multimap.add(pair1));
        Verify.assertContainsEntry(1, "One", multimap);
        Assert.assertTrue(multimap.add(pair2));
        Verify.assertContainsEntry(2, "Two", multimap);
        Assert.assertTrue(multimap.add(pair3));
        Verify.assertContainsEntry(3, "Three", multimap);
        Assert.assertTrue(multimap.add(pair4));
        Verify.assertContainsEntry(4, "Four", multimap);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(pair1, pair2, pair3, pair4), multimap.keyValuePairsView().toSet());
    }

    @Test
    public void clear() {
        MutableMultimap<Integer, Object> multimap = this.newMultimapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        Verify.assertNotEmpty(multimap);
        multimap.clear();
        Verify.assertEmpty(multimap);
    }

    @Test
    public void removeObject() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        multimap.removeAll("Two");
        Verify.assertContainsAllEntries(multimap, "One", 1, "Three", 3);
    }

    @Override
    @Test
    public void forEachKey() {
        MutableBag<Integer> collection = Bags.mutable.of();
        Multimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "1", 2, "2", 3, "3");
        multimap.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3), collection);
    }

    @Test
    public void withKeyMultiValues() {
        MutableMultimap<Integer, String> multimap = this.newMultimap();
        multimap = multimap.withKeyMultiValues(1);
        Verify.assertEmpty(multimap);
        multimap = multimap.withKeyMultiValues(1, "A", "B");
        Verify.assertSize(2, multimap);
        MutableMultimap<Integer, String> expected = this.newMultimap();
        expected.put(1, "A");
        expected.put(1, "B");
        Assert.assertEquals(expected, multimap);
        multimap.withKeyMultiValues(1, "C");
        Verify.assertSize(3, multimap);
        expected.put(1, "C");
        Verify.assertEquals(expected, multimap);
        multimap.withKeyMultiValues(2, "Z", "K", "Y");
        Verify.assertSize(6, multimap);
        expected = expected.withKeyValue(2, "Z").withKeyValue(2, "K").withKeyValue(2, "Y");
        Verify.assertEquals(expected, multimap);
    }

    @Test(expected = NullPointerException.class)
    public void withKeyMultiValuesNullValueHandling() {
        this.newMultimap().withKeyMultiValues(1, null);
    }

    @Test
    public void putAll() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "2");
        Multimap<Integer, String> toAdd = this.newMultimapWithKeysValues(2, "Two", 3, "Three");
        Multimap<Integer, String> toAddImmutable = this.newMultimapWithKeysValues(4, "Four", 5, "Five");
        Assert.assertTrue(multimap.putAll(toAdd));
        Assert.assertTrue(multimap.putAll(toAddImmutable));
        MutableMultimap<Integer, String> expected = this.newMultimapWithKeysValues(1, "One", 2, "2", 2, "Two", 3, "Three");
        expected.put(4, "Four");
        expected.put(5, "Five");
        Assert.assertEquals(expected, multimap);
    }

    @Test
    public void putAllPairs() {
        MutableMultimap<Integer, String> multimap1 = this.newMultimapWithKeysValues(1, "One", 2, "2");
        MutableList<Pair<Integer, String>> pairs1 = Lists.mutable.of(Tuples.pair(1, "One"), Tuples.pair(2, "Two"), Tuples.pair(3, "Three"));
        Assert.assertTrue(multimap1.putAllPairs(pairs1));
        MutableMultimap<Integer, String> expected1 = this.newMultimap();
        expected1.put(1, "One");
        expected1.put(1, "One");
        expected1.put(2, "2");
        expected1.put(2, "Two");
        expected1.put(3, "Three");
        Assert.assertEquals(expected1, multimap1);
        MutableMultimap<Integer, String> multimap2 = this.newMultimapWithKeysValues(1, "One", 2, "2");
        ImmutableList<Pair<Integer, String>> pairs2 = Lists.immutable.of(Tuples.pair(1, "One"), Tuples.pair(2, "Two"), Tuples.pair(3, "Three"));
        Assert.assertTrue(multimap2.putAllPairs(pairs2));
        MutableMultimap<Integer, String> expected2 = this.newMultimap();
        expected2.put(1, "One");
        expected2.put(1, "One");
        expected2.put(2, "2");
        expected2.put(2, "Two");
        expected2.put(3, "Three");
        Assert.assertEquals(expected2, multimap2);
        MutableMultimap<String, Integer> multimap3 = this.newMultimapWithKeysValues("One", 1, "Two", 2);
        MutableSet<Pair<String, Integer>> pairs3 = Sets.mutable.of(Tuples.pair("One", 1), Tuples.pair("Two", 2), Tuples.pair("Three", 3));
        Assert.assertTrue(multimap3.putAllPairs(pairs3));
        MutableMultimap<String, Integer> expected3 = this.newMultimap();
        expected3.put("One", 1);
        expected3.put("One", 1);
        expected3.put("Two", 2);
        expected3.put("Two", 2);
        expected3.put("Three", 3);
        Assert.assertEquals(expected3, multimap3);
        MutableMultimap<Number, String> multimap4 = this.newMultimap();
        MutableList<Pair<Integer, String>> intPairs4 = Lists.mutable.of(Tuples.pair(1, "Integer1"), Tuples.pair(2, "Integer2"));
        MutableList<Pair<Long, String>> longPairs4 = Lists.mutable.of(Tuples.pair(1L, "Long1"), Tuples.pair(2L, "Long2"));
        multimap4.putAllPairs(intPairs4);
        multimap4.putAllPairs(longPairs4);
        MutableMultimap<Number, String> expected4 = this.newMultimapWithKeysValues(1, "Integer1", 2, "Integer2", 1L, "Long1", 2L, "Long2");
        Assert.assertEquals(expected4, multimap4);
    }

    @Test
    public void putAllFromCollection() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "Two");
        Assert.assertTrue(multimap.putAll(1, Lists.fixedSize.of("Three", "Four")));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, "One", 2, "Two", 1, "Three", 1, "Four"), multimap);
        Assert.assertFalse(multimap.putAll(1, UnifiedSet.newSet()));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, "One", 2, "Two", 1, "Three", 1, "Four"), multimap);
    }

    @Test
    public void putAllFromIterable() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "Two");
        Assert.assertTrue(multimap.putAll(1, Lists.fixedSize.of("Three", "Four").asLazy()));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, "One", 2, "Two", 1, "Three", 1, "Four"), multimap);
    }

    @Test
    public void getIfAbsentPutAll() {
        MutableMultimap<Integer, Integer> multimap = this.newMultimap();
        Assert.assertFalse(multimap.containsKey(1));
        Assert.assertEquals(0, multimap.size());
        Assert.assertEquals(this.createCollection(), multimap.getIfAbsentPutAll(1, Lists.mutable.with()));
        Assert.assertFalse(multimap.containsKey(1));
        Assert.assertEquals(0, multimap.size());
        Assert.assertEquals(this.createCollection(1), multimap.getIfAbsentPutAll(1, Lists.mutable.with(1)));
        Assert.assertThrows(UnsupportedOperationException.class, () -> multimap.getIfAbsentPutAll(1, Lists.mutable.with(1)).add(1));
        multimap.putAll(2, Lists.mutable.with(2, 2));
        multimap.putAll(3, Lists.mutable.with(3, 3, 3));
        Assert.assertEquals(this.createCollection(1), multimap.getIfAbsentPutAll(1, Lists.mutable.empty()));
        Assert.assertEquals(this.createCollection(2, 2), multimap.getIfAbsentPutAll(2, Lists.mutable.empty()));
        Assert.assertEquals(this.createCollection(3, 3, 3), multimap.getIfAbsentPutAll(3, Lists.mutable.empty()));
        Assert.assertEquals(this.createCollection(4, 4, 4, 4), multimap.getIfAbsentPutAll(4, Lists.mutable.with(4, 4, 4, 4)));
        Assert.assertEquals(4, multimap.sizeDistinct());
        int multimapSize = this.createCollection(1).size() + this.createCollection(2, 2).size() + this.createCollection(3, 3, 3).size() + this.createCollection(4, 4, 4, 4).size();
        Assert.assertEquals(multimapSize, multimap.size());
        Assert.assertThrows(UnsupportedOperationException.class, () -> multimap.getIfAbsentPutAll(5, Lists.mutable.with(5)).add(5));
    }

    @Test
    public void removeKey() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "1", 2, "Two");
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1"), UnifiedSet.newSet(multimap.removeAll(1)));
        Verify.assertSize(1, multimap);
        Assert.assertFalse(multimap.containsKey(1));
        Verify.assertIterableEmpty(multimap.removeAll(42));
        Verify.assertSize(1, multimap);
        Verify.assertSetsEqual(UnifiedSet.newSetWith("Two"), UnifiedSet.newSet(multimap.removeAll(2)));
        Verify.assertEmpty(multimap);
    }

    @Test
    public void containsValue() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "Two");
        Assert.assertTrue(multimap.containsValue("Two"));
        Assert.assertFalse(multimap.containsValue("Three"));
    }

    @Test
    public void put_createCollection() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "1", 2, "2", 3, "3");
        Verify.assertIterableEmpty(multimap.get(4));
        Assert.assertTrue(multimap.put(4, "4"));
        Verify.assertContainsEntry(4, "4", multimap);
    }

    @Test
    public void remove() {
        MutableMultimap<Integer, Integer> map = this.newMultimapWithKeysValues(1, 1, 1, 2, 3, 3, 4, 5);
        Assert.assertFalse(map.remove(4, 4));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, 1, 1, 2, 3, 3, 4, 5), map);
        Assert.assertTrue(map.remove(4, 5));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, 1, 1, 2, 3, 3), map);
        Assert.assertTrue(map.remove(1, 2));
        Assert.assertEquals(this.newMultimapWithKeysValues(1, 1, 3, 3), map);
    }

    @Test
    public void replaceValues() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        RichIterable<Integer> oldValues2 = multimap.replaceValues("Two", UnifiedSet.newSetWith(4));
        Assert.assertEquals(Bags.mutable.of(2), oldValues2.toBag());
        Verify.assertEqualsAndHashCode(this.newMultimapWithKeysValues("One", 1, "Two", 4, "Three", 3), multimap);
        RichIterable<Integer> oldValues3 = multimap.replaceValues("Three", UnifiedSet.newSet());
        Assert.assertEquals(Bags.mutable.of(3), oldValues3.toBag());
        Verify.assertEqualsAndHashCode(this.newMultimapWithKeysValues("One", 1, "Two", 4), multimap);
    }

    @Test
    public void replaceValues_absent_key() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        RichIterable<Integer> oldValues = multimap.replaceValues("Four", UnifiedSet.newSetWith(4));
        Assert.assertEquals(HashBag.<Integer>newBag(), oldValues.toBag());
        Verify.assertEqualsAndHashCode(this.newMultimapWithKeysValues("One", 1, "Two", 2, "Three", 3, "Four", 4), multimap);
    }

    @Test
    public void toMap() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        UnifiedMap<String, RichIterable<Integer>> expected = UnifiedMap.newMap();
        expected.put("One", this.createCollection(1));
        expected.put("Two", this.createCollection(2, 2));
        MutableMap<String, RichIterable<Integer>> toMap = multimap.toMap();
        Assert.assertEquals(expected, toMap);
        MutableMap<String, RichIterable<Integer>> newToMap = multimap.toMap();
        Assert.assertEquals(toMap.get("One"), newToMap.get("One"));
        Assert.assertNotSame(toMap.get("One"), newToMap.get("One"));
    }

    @Test
    public void toImmutable() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        ImmutableMultimap<String, Integer> actual = multimap.toImmutable();
        Assert.assertNotNull(actual);
        Assert.assertEquals(multimap, actual);
    }

    @Test
    public void toMapWithTarget() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        MutableMap<String, RichIterable<Integer>> expected = UnifiedMap.newMap();
        expected.put("One", UnifiedSet.newSetWith(1));
        expected.put("Two", UnifiedSet.newSetWith(2, 2));
        MutableMap<String, MutableSet<Integer>> map = multimap.toMap(UnifiedSet::new);
        Assert.assertEquals(expected, map);
    }

    @Test
    public void toMutable() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2, "Two", 2);
        MutableMultimap<String, Integer> mutableCopy = multimap.toMutable();
        Assert.assertNotSame(multimap, mutableCopy);
        Assert.assertEquals(multimap, mutableCopy);
    }

    @Test
    public void testToString() {
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "Two", 2);
        Assert.assertTrue("{One=[1], Two=[2]}".equals(multimap.toString()) || "{Two=[2], One=[1]}".equals(multimap.toString()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableMultimapTestCase instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableMultimapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableMultimapTestCase> testToString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = AbstractMutableMultimapTestCase::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = AbstractMutableMultimapTestCase::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = AbstractMutableMultimapTestCase::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = AbstractMutableMultimapTestCase::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = AbstractMutableMultimapTestCase::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = AbstractMutableMultimapTestCase::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = AbstractMutableMultimapTestCase::newMultimapFromPairs;
            this.payloads.isEmpty = AbstractMutableMultimapTestCase::isEmpty;
            this.payloads.forEachKeyValue = AbstractMutableMultimapTestCase::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = AbstractMutableMultimapTestCase::forEachKeyMultiValue;
            this.payloads.forEachValue = AbstractMutableMultimapTestCase::forEachValue;
            this.payloads.valuesView = AbstractMutableMultimapTestCase::valuesView;
            this.payloads.multiValuesView = AbstractMutableMultimapTestCase::multiValuesView;
            this.payloads.notEmpty = AbstractMutableMultimapTestCase::notEmpty;
            this.payloads.keysWithMultiValuesView = AbstractMutableMultimapTestCase::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = AbstractMutableMultimapTestCase::keyValuePairsView;
            this.payloads.keyBag = AbstractMutableMultimapTestCase::keyBag;
            this.payloads.testEquals = AbstractMutableMultimapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableMultimapTestCase::testHashCode;
            this.payloads.serialization = AbstractMutableMultimapTestCase::serialization;
            this.payloads.newEmpty = AbstractMutableMultimapTestCase::newEmpty;
            this.payloads.keysView = AbstractMutableMultimapTestCase::keysView;
            this.payloads.keySet = AbstractMutableMultimapTestCase::keySet;
            this.payloads.sizeDistinct = AbstractMutableMultimapTestCase::sizeDistinct;
            this.payloads.selectKeysValues = AbstractMutableMultimapTestCase::selectKeysValues;
            this.payloads.rejectKeysValues = AbstractMutableMultimapTestCase::rejectKeysValues;
            this.payloads.selectKeysMultiValues = AbstractMutableMultimapTestCase::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = AbstractMutableMultimapTestCase::rejectKeysMultiValues;
            this.payloads.collectKeysValues = AbstractMutableMultimapTestCase::collectKeysValues;
            this.payloads.collectKeyMultiValues = AbstractMutableMultimapTestCase::collectKeyMultiValues;
            this.payloads.collectValues = AbstractMutableMultimapTestCase::collectValues;
            this.payloads.flip = AbstractMutableMultimapTestCase::flip;
            this.payloads.putAndGrowMultimap = AbstractMutableMultimapTestCase::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = AbstractMutableMultimapTestCase::addAndGrowMultimap;
            this.payloads.clear = AbstractMutableMultimapTestCase::clear;
            this.payloads.removeObject = AbstractMutableMultimapTestCase::removeObject;
            this.payloads.forEachKey = AbstractMutableMultimapTestCase::forEachKey;
            this.payloads.withKeyMultiValues = AbstractMutableMultimapTestCase::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableMultimapTestCase::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = AbstractMutableMultimapTestCase::putAll;
            this.payloads.putAllPairs = AbstractMutableMultimapTestCase::putAllPairs;
            this.payloads.putAllFromCollection = AbstractMutableMultimapTestCase::putAllFromCollection;
            this.payloads.putAllFromIterable = AbstractMutableMultimapTestCase::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = AbstractMutableMultimapTestCase::getIfAbsentPutAll;
            this.payloads.removeKey = AbstractMutableMultimapTestCase::removeKey;
            this.payloads.containsValue = AbstractMutableMultimapTestCase::containsValue;
            this.payloads.put_createCollection = AbstractMutableMultimapTestCase::put_createCollection;
            this.payloads.remove = AbstractMutableMultimapTestCase::remove;
            this.payloads.replaceValues = AbstractMutableMultimapTestCase::replaceValues;
            this.payloads.replaceValues_absent_key = AbstractMutableMultimapTestCase::replaceValues_absent_key;
            this.payloads.toMap = AbstractMutableMultimapTestCase::toMap;
            this.payloads.toImmutable = AbstractMutableMultimapTestCase::toImmutable;
            this.payloads.toMapWithTarget = AbstractMutableMultimapTestCase::toMapWithTarget;
            this.payloads.toMutable = AbstractMutableMultimapTestCase::toMutable;
            this.payloads.testToString = AbstractMutableMultimapTestCase::testToString;
        }
    }
}
