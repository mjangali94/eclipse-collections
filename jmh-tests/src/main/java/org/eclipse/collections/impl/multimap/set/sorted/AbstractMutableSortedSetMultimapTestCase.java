/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set.sorted;

import java.util.Comparator;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.multimap.set.SetMultimap;
import org.eclipse.collections.api.multimap.sortedset.MutableSortedSetMultimap;
import org.eclipse.collections.api.multimap.sortedset.SortedSetMultimap;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractMutableMultimapTestCase;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractMutableSortedSetMultimapTestCase extends AbstractMutableMultimapTestCase {

    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimap(Comparator<? super V> comparator);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimap();

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs);

    @Override
    protected abstract <K, V> MutableSortedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable);

    @Override
    protected abstract <V> MutableSortedSet<V> createCollection(V... args);

    @Override
    @Test
    public void flip() {
        SortedSetMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("Less than 2", 1, "Less than 3", 1, "Less than 3", 2, "Less than 3", 2);
        SetMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Sets.immutable.with("Less than 3"), flipped.get(2));
        Assert.assertEquals(Sets.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void serialization() {
        MutableSortedSetMultimap<Integer, Integer> map = this.newMultimap(Comparators.reverseNaturalOrder());
        map.putAll(1, FastList.newListWith(4, 3, 2, 1));
        map.putAll(2, FastList.newListWith(5, 4, 3, 2));
        Verify.assertPostSerializedEqualsAndHashCode(map);
        MutableSortedSetMultimap<Integer, Integer> deserialized = SerializeTestHelper.serializeDeserialize(map);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 4, 3, 2, 1), deserialized.get(1));
        deserialized.putAll(3, FastList.newListWith(10, 9, 8));
        Verify.assertListsEqual(FastList.newListWith(10, 9, 8), deserialized.get(3).toList());
    }

    @Override
    @Test
    public void selectKeysValues() {
        MutableSortedSetMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("One", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("Two", FastList.newListWith(5, 4, 3, 2, 2));
        MutableSortedSetMultimap<String, Integer> selectedMultimap = multimap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableSortedSetMultimap<String, Integer> expectedMultimap = TreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll("Two", FastList.newListWith(4, 2));
        Verify.assertSortedSetMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void rejectKeysValues() {
        MutableSortedSetMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("One", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("Two", FastList.newListWith(5, 4, 3, 2, 2));
        MutableSortedSetMultimap<String, Integer> rejectedMultimap = multimap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableSortedSetMultimap<String, Integer> expectedMultimap = TreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll("One", FastList.newListWith(3, 1));
        Verify.assertSortedSetMultimapsEqual(expectedMultimap, rejectedMultimap);
        Assert.assertEquals(expectedMultimap.comparator(), rejectedMultimap.comparator());
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        MutableSortedSetMultimap<Integer, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll(1, FastList.newListWith(4, 3, 1));
        multimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(3, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(4, FastList.newListWith(4, 3, 1));
        MutableSortedSetMultimap<Integer, Integer> selectedMultimap = multimap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableSortedSetMultimap<Integer, Integer> expectedMultimap = TreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        Verify.assertSortedSetMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        MutableSortedSetMultimap<Integer, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll(1, FastList.newListWith(4, 3, 2, 1));
        multimap.putAll(2, FastList.newListWith(5, 4, 3, 2, 2));
        multimap.putAll(3, FastList.newListWith(4, 3, 1, 1));
        multimap.putAll(4, FastList.newListWith(4, 3, 1));
        MutableSortedSetMultimap<Integer, Integer> selectedMultimap = multimap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 3);
        MutableSortedSetMultimap<Integer, Integer> expectedMultimap = TreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
        expectedMultimap.putAll(3, FastList.newListWith(4, 3, 1, 1));
        Verify.assertSortedSetMultimapsEqual(expectedMultimap, selectedMultimap);
        Assert.assertSame(expectedMultimap.comparator(), selectedMultimap.comparator());
    }

    @Override
    @Test
    public void collectKeysValues() {
        MutableSortedSetMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("5Value", "4Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("5Value", "4Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        MutableSortedSetMultimap<String, Integer> multimap1 = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap1.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap1.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableBagMultimap<Integer, String> collectedMultimap1 = multimap1.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("5Value", "4Value", "3Value", "2Value"));
        Verify.assertBagMultimapsEqual(expectedMultimap1, collectedMultimap1);
        MutableBagMultimap<Integer, String> collectedMultimap2 = multimap1.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("4Value", "3Value", "2Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("5Value", "4Value", "3Value", "2Value"));
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
        MutableSortedSetMultimap<String, Integer> multimap = this.newMultimap(Comparators.reverseNaturalOrder());
        multimap.putAll("1", FastList.newListWith(4, 3, 2, 1, 1));
        multimap.putAll("2", FastList.newListWith(5, 4, 3, 2, 2));
        MutableListMultimap<String, String> collectedMultimap = multimap.collectValues(value -> value + "Value");
        MutableListMultimap<String, String> expectedMultimap = FastListMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("4Value", "3Value", "2Value", "1Value"));
        expectedMultimap.putAll("2", FastList.newListWith("5Value", "4Value", "3Value", "2Value"));
        Verify.assertListMultimapsEqual(expectedMultimap, collectedMultimap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableSortedSetMultimapTestCase instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableSortedSetMultimapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedSetMultimapTestCase> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = AbstractMutableSortedSetMultimapTestCase::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = AbstractMutableSortedSetMultimapTestCase::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = AbstractMutableSortedSetMultimapTestCase::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = AbstractMutableSortedSetMultimapTestCase::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = AbstractMutableSortedSetMultimapTestCase::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = AbstractMutableSortedSetMultimapTestCase::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = AbstractMutableSortedSetMultimapTestCase::newMultimapFromPairs;
            this.payloads.isEmpty = AbstractMutableSortedSetMultimapTestCase::isEmpty;
            this.payloads.forEachKeyValue = AbstractMutableSortedSetMultimapTestCase::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = AbstractMutableSortedSetMultimapTestCase::forEachKeyMultiValue;
            this.payloads.forEachValue = AbstractMutableSortedSetMultimapTestCase::forEachValue;
            this.payloads.valuesView = AbstractMutableSortedSetMultimapTestCase::valuesView;
            this.payloads.multiValuesView = AbstractMutableSortedSetMultimapTestCase::multiValuesView;
            this.payloads.notEmpty = AbstractMutableSortedSetMultimapTestCase::notEmpty;
            this.payloads.keysWithMultiValuesView = AbstractMutableSortedSetMultimapTestCase::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = AbstractMutableSortedSetMultimapTestCase::keyValuePairsView;
            this.payloads.keyBag = AbstractMutableSortedSetMultimapTestCase::keyBag;
            this.payloads.testEquals = AbstractMutableSortedSetMultimapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableSortedSetMultimapTestCase::testHashCode;
            this.payloads.newEmpty = AbstractMutableSortedSetMultimapTestCase::newEmpty;
            this.payloads.keysView = AbstractMutableSortedSetMultimapTestCase::keysView;
            this.payloads.keySet = AbstractMutableSortedSetMultimapTestCase::keySet;
            this.payloads.sizeDistinct = AbstractMutableSortedSetMultimapTestCase::sizeDistinct;
            this.payloads.putAndGrowMultimap = AbstractMutableSortedSetMultimapTestCase::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = AbstractMutableSortedSetMultimapTestCase::addAndGrowMultimap;
            this.payloads.clear = AbstractMutableSortedSetMultimapTestCase::clear;
            this.payloads.removeObject = AbstractMutableSortedSetMultimapTestCase::removeObject;
            this.payloads.forEachKey = AbstractMutableSortedSetMultimapTestCase::forEachKey;
            this.payloads.withKeyMultiValues = AbstractMutableSortedSetMultimapTestCase::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedSetMultimapTestCase::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = AbstractMutableSortedSetMultimapTestCase::putAll;
            this.payloads.putAllPairs = AbstractMutableSortedSetMultimapTestCase::putAllPairs;
            this.payloads.putAllFromCollection = AbstractMutableSortedSetMultimapTestCase::putAllFromCollection;
            this.payloads.putAllFromIterable = AbstractMutableSortedSetMultimapTestCase::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = AbstractMutableSortedSetMultimapTestCase::getIfAbsentPutAll;
            this.payloads.removeKey = AbstractMutableSortedSetMultimapTestCase::removeKey;
            this.payloads.containsValue = AbstractMutableSortedSetMultimapTestCase::containsValue;
            this.payloads.put_createCollection = AbstractMutableSortedSetMultimapTestCase::put_createCollection;
            this.payloads.remove = AbstractMutableSortedSetMultimapTestCase::remove;
            this.payloads.replaceValues = AbstractMutableSortedSetMultimapTestCase::replaceValues;
            this.payloads.replaceValues_absent_key = AbstractMutableSortedSetMultimapTestCase::replaceValues_absent_key;
            this.payloads.toMap = AbstractMutableSortedSetMultimapTestCase::toMap;
            this.payloads.toImmutable = AbstractMutableSortedSetMultimapTestCase::toImmutable;
            this.payloads.toMapWithTarget = AbstractMutableSortedSetMultimapTestCase::toMapWithTarget;
            this.payloads.toMutable = AbstractMutableSortedSetMultimapTestCase::toMutable;
            this.payloads.testToString = AbstractMutableSortedSetMultimapTestCase::testToString;
            this.payloads.flip = AbstractMutableSortedSetMultimapTestCase::flip;
            this.payloads.serialization = AbstractMutableSortedSetMultimapTestCase::serialization;
            this.payloads.selectKeysValues = AbstractMutableSortedSetMultimapTestCase::selectKeysValues;
            this.payloads.rejectKeysValues = AbstractMutableSortedSetMultimapTestCase::rejectKeysValues;
            this.payloads.selectKeysMultiValues = AbstractMutableSortedSetMultimapTestCase::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = AbstractMutableSortedSetMultimapTestCase::rejectKeysMultiValues;
            this.payloads.collectKeysValues = AbstractMutableSortedSetMultimapTestCase::collectKeysValues;
            this.payloads.collectKeyMultiValues = AbstractMutableSortedSetMultimapTestCase::collectKeyMultiValues;
            this.payloads.collectValues = AbstractMutableSortedSetMultimapTestCase::collectValues;
        }
    }
*/
}
