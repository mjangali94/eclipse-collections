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

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractImmutableMultimapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBagMultimapTest extends AbstractImmutableMultimapTestCase {

    @Override
    protected <K, V> ImmutableBagMultimap<K, V> classUnderTest() {
        return HashBagMultimap.<K, V>newMultimap().toImmutable();
    }

    @Override
    protected MutableCollection<String> mutableCollection() {
        return Bags.mutable.of();
    }

    @Override
    public void noDuplicates() {
        // Bags allow duplicates
    }

    @Test
    public void forEachKeyMultiValue() {
        MutableBag<Pair<String, Iterable<Integer>>> collection = Bags.mutable.empty();
        HashBagMultimap<String, Integer> multimap = HashBagMultimap.newMultimap();
        multimap.put("Two", 2);
        multimap.put("Two", 1);
        multimap.put("Three", 3);
        multimap.put("Three", 3);
        multimap.toImmutable().forEachKeyMultiValues((key, values) -> collection.add(Tuples.pair(key, values)));
        MutableBag<Pair<String, MutableBag<Integer>>> expected = Bags.mutable.with(Tuples.pair("Two", Bags.mutable.with(2, 1)), Tuples.pair("Three", Bags.mutable.with(3, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Test
    public void forEachKeyImmutableBag() {
        MutableBag<Pair<String, ImmutableBag<Integer>>> collection = Bags.mutable.empty();
        HashBagMultimap<String, Integer> multimap = HashBagMultimap.newMultimap();
        multimap.put("Two", 2);
        multimap.put("Two", 1);
        multimap.put("Three", 3);
        multimap.put("Three", 3);
        multimap.toImmutable().forEachKeyImmutableBag((key, values) -> collection.add(Tuples.pair(key, values)));
        ImmutableBag<Pair<String, ImmutableBag<Integer>>> expected = Bags.immutable.with(Tuples.pair("Two", Bags.immutable.with(2, 1)), Tuples.pair("Three", Bags.immutable.with(3, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Override
    @Test
    public void flip() {
        ImmutableBagMultimap<String, Integer> multimap = this.<String, Integer>classUnderTest().newWith("Less than 2", 1).newWith("Less than 3", 1).newWith("Less than 3", 2).newWith("Less than 3", 2);
        ImmutableBagMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Bags.immutable.with("Less than 3", "Less than 3"), flipped.get(2));
        Assert.assertEquals(Bags.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void selectKeysValues() {
        MutableBagMultimap<String, Integer> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll("One", FastList.newListWith(1, 2, 3, 4, 2));
        mutableMultimap.putAll("Two", FastList.newListWith(2, 3, 4, 5, 2));
        ImmutableBagMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<String, Integer> selectedMultimap = immutableMap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableBagMultimap<String, Integer> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("Two", FastList.newListWith(2, 4, 2));
        ImmutableBagMultimap<String, Integer> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysValues() {
        HashBagMultimap<String, Integer> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll("One", FastList.newListWith(1, 2, 3, 4, 1));
        mutableMultimap.putAll("Two", FastList.newListWith(2, 3, 4, 5, 1));
        ImmutableBagMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<String, Integer> rejectedMultimap = immutableMap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableBagMultimap<String, Integer> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("One", FastList.newListWith(1, 3, 1));
        ImmutableBagMultimap<String, Integer> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        MutableBagMultimap<Integer, String> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll(1, FastList.newListWith("1", "3", "4"));
        mutableMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        mutableMultimap.putAll(3, FastList.newListWith("2", "3", "4", "5", "2"));
        mutableMultimap.putAll(4, FastList.newListWith("1", "3", "4"));
        ImmutableBagMultimap<Integer, String> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> selectedMultimap = immutableMap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        MutableBagMultimap<Integer, String> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll(1, FastList.newListWith("1", "2", "3", "4", "1"));
        mutableMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "1"));
        mutableMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        mutableMultimap.putAll(4, FastList.newListWith("1", "3", "4", "5"));
        ImmutableBagMultimap<Integer, String> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> rejectedMultimap = immutableMap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 4);
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void collectKeysValues() {
        MutableBagMultimap<String, Integer> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 1));
        mutableMultimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 2));
        ImmutableBagMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> collectedMultimap = immutableMap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "2Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap1 = expectedMultimap1.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap1, collectedMultimap);
        ImmutableBagMultimap<Integer, String> collectedMultimap2 = immutableMap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "2Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap2 = expectedMultimap2.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        super.collectKeyMultiValues();
        MutableBagMultimap<String, Integer> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 1));
        mutableMultimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 2));
        ImmutableBagMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> collectedMultimap = immutableMap.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap1 = HashBagMultimap.newMultimap();
        expectedMultimap1.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "1Value"));
        expectedMultimap1.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "2Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap1 = expectedMultimap1.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap1, collectedMultimap);
        ImmutableBagMultimap<Integer, String> collectedMultimap2 = immutableMap.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value", "1Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value", "2Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap2 = expectedMultimap2.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectValues() {
        MutableBagMultimap<String, Integer> mutableMultimap = HashBagMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(1, 2, 3, 4, 1));
        mutableMultimap.putAll("2", FastList.newListWith(2, 3, 4, 5, 2));
        ImmutableBagMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<String, String> collectedMultimap = immutableMap.collectValues(value -> value + "Value");
        MutableBagMultimap<String, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("1Value", "2Value", "3Value", "4Value", "1Value"));
        expectedMultimap.putAll("2", FastList.newListWith("2Value", "3Value", "4Value", "5Value", "2Value"));
        ImmutableBagMultimap<String, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, collectedMultimap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableBagMultimapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allowDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allowDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll_newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMultiValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMultiValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyImmutableBag);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBagMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> allowDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> noDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> newWithAll_newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> testSerialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> forEachKeyImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = ImmutableBagMultimapTest::size;
            this.payloads.allowDuplicates = ImmutableBagMultimapTest::allowDuplicates;
            this.payloads.noDuplicates = ImmutableBagMultimapTest::noDuplicates;
            this.payloads.isEmpty = ImmutableBagMultimapTest::isEmpty;
            this.payloads.keySet = ImmutableBagMultimapTest::keySet;
            this.payloads.get = ImmutableBagMultimapTest::get;
            this.payloads.toMap = ImmutableBagMultimapTest::toMap;
            this.payloads.newWithout = ImmutableBagMultimapTest::newWithout;
            this.payloads.newWithAll_newWithoutAll = ImmutableBagMultimapTest::newWithAll_newWithoutAll;
            this.payloads.toImmutable = ImmutableBagMultimapTest::toImmutable;
            this.payloads.testSerialization = ImmutableBagMultimapTest::testSerialization;
            this.payloads.forEachKeyMultiValue = ImmutableBagMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachKeyImmutableBag = ImmutableBagMultimapTest::forEachKeyImmutableBag;
            this.payloads.flip = ImmutableBagMultimapTest::flip;
            this.payloads.selectKeysValues = ImmutableBagMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = ImmutableBagMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = ImmutableBagMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = ImmutableBagMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = ImmutableBagMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = ImmutableBagMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = ImmutableBagMultimapTest::collectValues;
        }
    }
}
