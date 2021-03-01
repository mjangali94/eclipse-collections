/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public class ImmutableUnifiedMap2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableMap<K, V> newMap() {
        return new ImmutableUnifiedMap<>(UnifiedMap.newMap());
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    @Test
    public void partition_value() {
        MapIterable<String, Integer> map = UnifiedMap.newWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    @Test
    public void partitionWith_value() {
        MapIterable<String, Integer> map = UnifiedMap.newWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition_value, this.description("partition_value"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith_value, this.description("partitionWith_value"));
        }

        private ImmutableUnifiedMap2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableUnifiedMap2Test();
        }

        @java.lang.Override
        public ImmutableUnifiedMap2Test implementation() {
            return this.implementation;
        }
    }
}
