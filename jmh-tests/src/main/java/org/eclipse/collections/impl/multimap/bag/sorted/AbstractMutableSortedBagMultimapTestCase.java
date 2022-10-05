/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag.sorted;

import java.util.Comparator;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.BagMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.multimap.sortedbag.MutableSortedBagMultimap;
import org.eclipse.collections.api.multimap.sortedbag.SortedBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractMutableMultimapTestCase;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link TreeBagMultimap}.
 *
 * @deprecated in 7.0
 */
@Deprecated
public abstract class AbstractMutableSortedBagMultimapTestCase extends AbstractMutableMultimapTestCase {

    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimap(Comparator<V> comparator);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimap();

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimap(Pair<K, V>... pairs);

    @Override
    protected abstract <K, V> MutableSortedBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable);

    @Override
    protected abstract <V> MutableSortedBag<V> createCollection(V... args);

    @Override
    @Test
    public void flip() {
        SortedBagMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("Less than 2", 1, "Less than 3", 1, "Less than 3", 2, "Less than 3", 2);
        BagMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Bags.immutable.with("Less than 3", "Less than 3"), flipped.get(2));
        Assert.assertEquals(Bags.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void serialization() {
        MutableSortedBagMultimap<Integer, Integer> map = this.newMultimap(Comparators.reverseNaturalOrder());
        map.putAll(1, FastList.newListWith(1, 2, 3, 4));
        map.putAll(2, FastList.newListWith(2, 3, 4, 5));
        Verify.assertPostSerializedEqualsAndHashCode(map);
        MutableSortedBagMultimap<Integer, Integer> deserialized = SerializeTestHelper.serializeDeserialize(map);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), deserialized.get(1));
        deserialized.putAll(3, FastList.newListWith(8, 9, 10));
        Verify.assertListsEqual(FastList.newListWith(10, 9, 8), deserialized.get(3).toList());
    }

    @Override
    @Test
    public void clear() {
        MutableMultimap<Integer, String> multimap = this.newMultimapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        multimap.clear();
        Verify.assertEmpty(multimap);
    }

    @Override
    @Test
    public void selectKeysValues() {
        MutableSortedBagMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("One", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("Two", FastList.newListWith(5, 4, 3, 2, 2));
        MutableSortedBagMultimap<String, Integer> selectedMultimap = multimap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableSortedBagMultimap<String, Integer> expectedMultimap = this.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll("Two", FastList.newListWith(4, 2, 2));
        Verify.assertSortedBagMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void rejectKeysValues() {
        MutableSortedBagMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("One", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("Two", FastList.newListWith(5, 4, 3, 2, 2));
        MutableSortedBagMultimap<String, Integer> rejectedMultimap = multimap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableSortedBagMultimap<String, Integer> expectedMultimap = this.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll("One", FastList.newListWith(3, 1, 1));
        Verify.assertSortedBagMultimapsEqual(expectedMultimap, rejectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), rejectedMultimap.comparator());
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        MutableSortedBagMultimap<Integer, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll(1, FastList.newListWith(4, 3, 1));
        multimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(3, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(4, FastList.newListWith(4, 3, 1));
        MutableSortedBagMultimap<Integer, Integer> selectedMultimap = multimap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableSortedBagMultimap<Integer, Integer> expectedMultimap = this.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        Verify.assertSortedBagMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        MutableSortedBagMultimap<Integer, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll(1, FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(3, FastList.newListWith(4, 3, 1, 1));
        multimap.putAll(4, FastList.newListWith(4, 3, 1));
        MutableSortedBagMultimap<Integer, Integer> selectedMultimap = multimap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 4);
        MutableSortedBagMultimap<Integer, Integer> expectedMultimap = this.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll(3, FastList.newListWith(4, 3, 1, 1));
        Verify.assertSortedBagMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void collectKeysValues() {
        MutableSortedBagMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("5Value", "4Value", "3Value", "2Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("5Value", "4Value", "3Value", "2Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        super.collectKeyMultiValues();
        MutableSortedBagMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("5Value", "4Value", "3Value", "2Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("5Value", "4Value", "3Value", "2Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectValues() {
        MutableSortedBagMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableListMultimap<String, String> collectedMultimap = multimap.collectValues(value -> value + "Value");
        MutableListMultimap<String, String> expectedMultimap = FastListMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("4Value", "3Value", "2Value", "1Value", "1Value"));
        expectedMultimap.putAll("2", FastList.newListWith("5Value", "4Value", "3Value", "2Value", "2Value"));
        Verify.assertListMultimapsEqual(expectedMultimap, collectedMultimap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableSortedBagMultimapTestCase instance;

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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableSortedBagMultimapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagMultimapTestCase> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = AbstractMutableSortedBagMultimapTestCase::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = AbstractMutableSortedBagMultimapTestCase::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = AbstractMutableSortedBagMultimapTestCase::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = AbstractMutableSortedBagMultimapTestCase::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = AbstractMutableSortedBagMultimapTestCase::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = AbstractMutableSortedBagMultimapTestCase::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = AbstractMutableSortedBagMultimapTestCase::newMultimapFromPairs;
            this.payloads.isEmpty = AbstractMutableSortedBagMultimapTestCase::isEmpty;
            this.payloads.forEachKeyValue = AbstractMutableSortedBagMultimapTestCase::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = AbstractMutableSortedBagMultimapTestCase::forEachKeyMultiValue;
            this.payloads.forEachValue = AbstractMutableSortedBagMultimapTestCase::forEachValue;
            this.payloads.valuesView = AbstractMutableSortedBagMultimapTestCase::valuesView;
            this.payloads.multiValuesView = AbstractMutableSortedBagMultimapTestCase::multiValuesView;
            this.payloads.notEmpty = AbstractMutableSortedBagMultimapTestCase::notEmpty;
            this.payloads.keysWithMultiValuesView = AbstractMutableSortedBagMultimapTestCase::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = AbstractMutableSortedBagMultimapTestCase::keyValuePairsView;
            this.payloads.keyBag = AbstractMutableSortedBagMultimapTestCase::keyBag;
            this.payloads.testEquals = AbstractMutableSortedBagMultimapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableSortedBagMultimapTestCase::testHashCode;
            this.payloads.newEmpty = AbstractMutableSortedBagMultimapTestCase::newEmpty;
            this.payloads.keysView = AbstractMutableSortedBagMultimapTestCase::keysView;
            this.payloads.keySet = AbstractMutableSortedBagMultimapTestCase::keySet;
            this.payloads.sizeDistinct = AbstractMutableSortedBagMultimapTestCase::sizeDistinct;
            this.payloads.putAndGrowMultimap = AbstractMutableSortedBagMultimapTestCase::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = AbstractMutableSortedBagMultimapTestCase::addAndGrowMultimap;
            this.payloads.removeObject = AbstractMutableSortedBagMultimapTestCase::removeObject;
            this.payloads.forEachKey = AbstractMutableSortedBagMultimapTestCase::forEachKey;
            this.payloads.withKeyMultiValues = AbstractMutableSortedBagMultimapTestCase::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagMultimapTestCase::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = AbstractMutableSortedBagMultimapTestCase::putAll;
            this.payloads.putAllPairs = AbstractMutableSortedBagMultimapTestCase::putAllPairs;
            this.payloads.putAllFromCollection = AbstractMutableSortedBagMultimapTestCase::putAllFromCollection;
            this.payloads.putAllFromIterable = AbstractMutableSortedBagMultimapTestCase::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = AbstractMutableSortedBagMultimapTestCase::getIfAbsentPutAll;
            this.payloads.removeKey = AbstractMutableSortedBagMultimapTestCase::removeKey;
            this.payloads.containsValue = AbstractMutableSortedBagMultimapTestCase::containsValue;
            this.payloads.put_createCollection = AbstractMutableSortedBagMultimapTestCase::put_createCollection;
            this.payloads.remove = AbstractMutableSortedBagMultimapTestCase::remove;
            this.payloads.replaceValues = AbstractMutableSortedBagMultimapTestCase::replaceValues;
            this.payloads.replaceValues_absent_key = AbstractMutableSortedBagMultimapTestCase::replaceValues_absent_key;
            this.payloads.toMap = AbstractMutableSortedBagMultimapTestCase::toMap;
            this.payloads.toImmutable = AbstractMutableSortedBagMultimapTestCase::toImmutable;
            this.payloads.toMapWithTarget = AbstractMutableSortedBagMultimapTestCase::toMapWithTarget;
            this.payloads.toMutable = AbstractMutableSortedBagMultimapTestCase::toMutable;
            this.payloads.testToString = AbstractMutableSortedBagMultimapTestCase::testToString;
            this.payloads.flip = AbstractMutableSortedBagMultimapTestCase::flip;
            this.payloads.serialization = AbstractMutableSortedBagMultimapTestCase::serialization;
            this.payloads.clear = AbstractMutableSortedBagMultimapTestCase::clear;
            this.payloads.selectKeysValues = AbstractMutableSortedBagMultimapTestCase::selectKeysValues;
            this.payloads.rejectKeysValues = AbstractMutableSortedBagMultimapTestCase::rejectKeysValues;
            this.payloads.selectKeysMultiValues = AbstractMutableSortedBagMultimapTestCase::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = AbstractMutableSortedBagMultimapTestCase::rejectKeysMultiValues;
            this.payloads.collectKeysValues = AbstractMutableSortedBagMultimapTestCase::collectKeysValues;
            this.payloads.collectKeyMultiValues = AbstractMutableSortedBagMultimapTestCase::collectKeyMultiValues;
            this.payloads.collectValues = AbstractMutableSortedBagMultimapTestCase::collectValues;
        }
    }
}
