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

import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.set.ImmutableSetMultimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.AbstractImmutableMultimapTestCase;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSetMultimapTest extends AbstractImmutableMultimapTestCase {

    @Override
    protected <K, V> ImmutableSetMultimap<K, V> classUnderTest() {
        return UnifiedSetMultimap.<K, V>newMultimap().toImmutable();
    }

    @Override
    protected MutableCollection<String> mutableCollection() {
        return UnifiedSet.newSet();
    }

    @Override
    public void allowDuplicates() {
        // Sets do not allow duplicates
    }

    @Test
    public void forEachKeyMultiValue() {
        MutableSet<Pair<String, Iterable<Integer>>> collection = UnifiedSet.newSet();
        MutableSetMultimap<String, Integer> multimap = UnifiedSetMultimap.newMultimap();
        multimap.put("Two", 2);
        multimap.put("Two", 1);
        multimap.put("Three", 3);
        multimap.put("Three", 3);
        ImmutableSetMultimap<String, Integer> immutableMultimap = multimap.toImmutable();
        immutableMultimap.forEachKeyMultiValues((key, values) -> collection.add(Tuples.pair(key, values)));
        MutableSet<Pair<String, MutableSet<Integer>>> expected = Sets.mutable.with(Tuples.pair("Two", Sets.mutable.with(2, 1)), Tuples.pair("Three", Sets.mutable.with(3, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Test
    public void forEachKeyImmutableSet() {
        MutableSet<Pair<String, ImmutableSet<Integer>>> collection = UnifiedSet.newSet();
        MutableSetMultimap<String, Integer> multimap = UnifiedSetMultimap.newMultimap();
        multimap.put("Two", 2);
        multimap.put("Two", 1);
        multimap.put("Three", 3);
        multimap.put("Three", 3);
        ImmutableSetMultimap<String, Integer> immutableMultimap = multimap.toImmutable();
        immutableMultimap.forEachKeyImmutableSet((key, values) -> collection.add(Tuples.pair(key, values)));
        MutableSet<Pair<String, MutableSet<Integer>>> expected = Sets.mutable.with(Tuples.pair("Two", Sets.mutable.with(2, 1)), Tuples.pair("Three", Sets.mutable.with(3, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Override
    @Test
    public void flip() {
        ImmutableSetMultimap<String, Integer> multimap = this.<String, Integer>classUnderTest().newWith("Less than 2", 1).newWith("Less than 3", 1).newWith("Less than 3", 2).newWith("Less than 3", 2);
        ImmutableSetMultimap<Integer, String> flipped = multimap.flip();
        Assert.assertEquals(Sets.immutable.with("Less than 3"), flipped.get(2));
        Assert.assertEquals(Sets.immutable.with("Less than 2", "Less than 3"), flipped.get(1));
    }

    @Override
    @Test
    public void selectKeysValues() {
        MutableSetMultimap<String, Integer> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll("One", FastList.newListWith(1, 1, 2, 3, 4));
        mutableMultimap.putAll("Two", FastList.newListWith(2, 2, 3, 4, 5));
        ImmutableSetMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableSetMultimap<String, Integer> selectedMultimap = immutableMap.selectKeysValues((key, value) -> "Two".equals(key) && (value % 2 == 0));
        MutableSetMultimap<String, Integer> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll("Two", FastList.newListWith(2, 4));
        ImmutableSetMultimap<String, Integer> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertSetMultimapsEqual(expectedImmutableMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysValues() {
        MutableSetMultimap<String, Integer> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll("One", FastList.newListWith(1, 1, 2, 3, 4));
        mutableMultimap.putAll("Two", FastList.newListWith(2, 2, 3, 4, 5));
        ImmutableSetMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableSetMultimap<String, Integer> rejectedMultimap = immutableMap.rejectKeysValues((key, value) -> "Two".equals(key) || (value % 2 == 0));
        MutableSetMultimap<String, Integer> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll("One", FastList.newListWith(1, 3));
        ImmutableSetMultimap<String, Integer> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertSetMultimapsEqual(expectedImmutableMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void selectKeysMultiValues() {
        MutableSetMultimap<Integer, String> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll(1, FastList.newListWith("1", "3", "4"));
        mutableMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        mutableMultimap.putAll(3, FastList.newListWith("2", "3", "4", "5", "2"));
        mutableMultimap.putAll(4, FastList.newListWith("1", "3", "4"));
        ImmutableSetMultimap<Integer, String> immutableMap = mutableMultimap.toImmutable();
        ImmutableSetMultimap<Integer, String> selectedMultimap = immutableMap.selectKeysMultiValues((key, values) -> key % 2 == 0 && Iterate.sizeOf(values) > 3);
        MutableSetMultimap<Integer, String> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "2"));
        ImmutableSetMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertSetMultimapsEqual(expectedImmutableMultimap, selectedMultimap);
    }

    @Override
    @Test
    public void rejectKeysMultiValues() {
        MutableSetMultimap<Integer, String> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll(1, FastList.newListWith("1", "2", "3", "4", "5", "1"));
        mutableMultimap.putAll(2, FastList.newListWith("2", "3", "4", "5", "1"));
        mutableMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        mutableMultimap.putAll(4, FastList.newListWith("1", "3", "4", "5"));
        ImmutableSetMultimap<Integer, String> immutableMap = mutableMultimap.toImmutable();
        ImmutableSetMultimap<Integer, String> rejectedMultimap = immutableMap.rejectKeysMultiValues((key, values) -> key % 2 == 0 || Iterate.sizeOf(values) > 4);
        MutableSetMultimap<Integer, String> expectedMultimap = UnifiedSetMultimap.newMultimap();
        expectedMultimap.putAll(3, FastList.newListWith("2", "3", "4", "2"));
        ImmutableSetMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertSetMultimapsEqual(expectedImmutableMultimap, rejectedMultimap);
    }

    @Override
    @Test
    public void collectKeysValues() {
        MutableSetMultimap<String, Integer> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(4, 3, 2, 1));
        mutableMultimap.putAll("2", FastList.newListWith(5, 4, 3, 2));
        ImmutableSetMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> collectedMultimap = immutableMap.collectKeysValues((key, value) -> Tuples.pair(Integer.valueOf(key), value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, collectedMultimap);
        ImmutableBagMultimap<Integer, String> collectedMultimap2 = immutableMap.collectKeysValues((key, value) -> Tuples.pair(1, value + "Value"));
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap2 = expectedMultimap2.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectKeyMultiValues() {
        super.collectKeyMultiValues();
        MutableSetMultimap<String, Integer> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(4, 3, 2, 1));
        mutableMultimap.putAll("2", FastList.newListWith(5, 4, 3, 2));
        ImmutableSetMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<Integer, String> collectedMultimap = immutableMap.collectKeyMultiValues(Integer::valueOf, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap.putAll(2, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, collectedMultimap);
        ImmutableBagMultimap<Integer, String> collectedMultimap2 = immutableMap.collectKeyMultiValues(key -> 1, value -> value + "Value");
        MutableBagMultimap<Integer, String> expectedMultimap2 = HashBagMultimap.newMultimap();
        expectedMultimap2.putAll(1, FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap2.putAll(1, FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        ImmutableBagMultimap<Integer, String> expectedImmutableMultimap2 = expectedMultimap2.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap2, collectedMultimap2);
    }

    @Override
    @Test
    public void collectValues() {
        MutableSetMultimap<String, Integer> mutableMultimap = UnifiedSetMultimap.newMultimap();
        mutableMultimap.putAll("1", FastList.newListWith(1, 2, 3, 4));
        mutableMultimap.putAll("2", FastList.newListWith(2, 3, 4, 5));
        ImmutableSetMultimap<String, Integer> immutableMap = mutableMultimap.toImmutable();
        ImmutableBagMultimap<String, String> collectedMultimap = immutableMap.collectValues(value -> value + "Value");
        MutableBagMultimap<String, String> expectedMultimap = HashBagMultimap.newMultimap();
        expectedMultimap.putAll("1", FastList.newListWith("1Value", "2Value", "3Value", "4Value"));
        expectedMultimap.putAll("2", FastList.newListWith("2Value", "3Value", "4Value", "5Value"));
        ImmutableBagMultimap<String, String> expectedImmutableMultimap = expectedMultimap.toImmutable();
        Verify.assertBagMultimapsEqual(expectedImmutableMultimap, collectedMultimap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableSetMultimapTest instance;

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
        public void benchmark_forEachKeyImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyImmutableSet);
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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSetMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> allowDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> noDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> newWithAll_newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> testSerialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> forEachKeyImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSetMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = ImmutableSetMultimapTest::size;
            this.payloads.allowDuplicates = ImmutableSetMultimapTest::allowDuplicates;
            this.payloads.noDuplicates = ImmutableSetMultimapTest::noDuplicates;
            this.payloads.isEmpty = ImmutableSetMultimapTest::isEmpty;
            this.payloads.keySet = ImmutableSetMultimapTest::keySet;
            this.payloads.get = ImmutableSetMultimapTest::get;
            this.payloads.toMap = ImmutableSetMultimapTest::toMap;
            this.payloads.newWithout = ImmutableSetMultimapTest::newWithout;
            this.payloads.newWithAll_newWithoutAll = ImmutableSetMultimapTest::newWithAll_newWithoutAll;
            this.payloads.toImmutable = ImmutableSetMultimapTest::toImmutable;
            this.payloads.testSerialization = ImmutableSetMultimapTest::testSerialization;
            this.payloads.forEachKeyMultiValue = ImmutableSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachKeyImmutableSet = ImmutableSetMultimapTest::forEachKeyImmutableSet;
            this.payloads.flip = ImmutableSetMultimapTest::flip;
            this.payloads.selectKeysValues = ImmutableSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = ImmutableSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = ImmutableSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = ImmutableSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = ImmutableSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = ImmutableSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = ImmutableSetMultimapTest::collectValues;
        }
    }
}
