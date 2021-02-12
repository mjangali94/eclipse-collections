/*
 * Copyright (c) 2019 Goldman Sachs.
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
        Assert.assertEquals(UnifiedSet.newSetWith(Tuples.pair("Two", UnifiedSet.newSetWith(2, 1)), Tuples.pair("Three", UnifiedSet.newSetWith(3, 3))), collection);
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
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMultiValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyMultiValue, this.description("forEachKeyMultiValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flip, this.description("flip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectKeysValues, this.description("selectKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectKeysValues, this.description("rejectKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysMultiValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectKeysMultiValues, this.description("selectKeysMultiValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysMultiValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectKeysMultiValues, this.description("rejectKeysMultiValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectKeysValues, this.description("collectKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeyMultiValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectKeyMultiValues, this.description("collectKeyMultiValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectValues, this.description("collectValues"));
        }

        private ImmutableSetMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableSetMultimapTest();
        }

        @java.lang.Override
        public ImmutableSetMultimapTest implementation() {
            return this.implementation;
        }
    }
}
