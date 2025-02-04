/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.util.Collections;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.Function3;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ConcurrentMutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

/**
 * JUnit test for {@link ConcurrentHashMapUnsafe}.
 */
public class ConcurrentHashMapUnsafeTest extends ConcurrentHashMapTestCase {

    public static final MutableMap<Integer, MutableBag<Integer>> SMALL_BAG_MUTABLE_MAP = Interval.oneTo(100).groupBy(each -> each % 10).toMap(Bags.mutable::of);

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMap() {
        return ConcurrentHashMapUnsafe.newMap();
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return ConcurrentHashMapUnsafe.<K, V>newMap().withKeyValue(key, value);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return ConcurrentHashMapUnsafe.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return ConcurrentHashMapUnsafe.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return ConcurrentHashMapUnsafe.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Test
    public void doubleReverseTest() {
        FastList<String> source = FastList.newListWith("1", "2", "3");
        MutableList<String> expectedDoubleReverse = source.toReversed().collect(new Function<String, String>() {

            private String visited = "";

            public String valueOf(String object) {
                return this.visited += object;
            }
        }).toReversed();
        Assert.assertEquals(FastList.newListWith("321", "32", "3"), expectedDoubleReverse);
        MutableList<String> expectedNormal = source.collect(new Function<String, String>() {

            private String visited = "";

            public String valueOf(String object) {
                return this.visited += object;
            }
        });
        Assert.assertEquals(FastList.newListWith("1", "12", "123"), expectedNormal);
    }

    @Test
    public void putIfAbsent() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(Integer.valueOf(1), map.putIfAbsent(1, 1));
        Assert.assertNull(map.putIfAbsent(3, 3));
    }

    @Test
    public void replace() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(Integer.valueOf(1), map.replace(1, 7));
        Assert.assertEquals(Integer.valueOf(7), map.get(1));
        Assert.assertNull(map.replace(3, 3));
    }

    @Test
    public void entrySetContains() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", Integer.valueOf(1), "Two", Integer.valueOf(2), "Three", Integer.valueOf(3));
        Assert.assertFalse(map.entrySet().contains(null));
        Assert.assertFalse(map.entrySet().contains(ImmutableEntry.of("Zero", Integer.valueOf(0))));
        Assert.assertTrue(map.entrySet().contains(ImmutableEntry.of("One", Integer.valueOf(1))));
    }

    @Test
    public void entrySetRemove() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", Integer.valueOf(1), "Two", Integer.valueOf(2), "Three", Integer.valueOf(3));
        Assert.assertFalse(map.entrySet().remove(null));
        Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of("Zero", Integer.valueOf(0))));
        Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of("One", Integer.valueOf(1))));
    }

    @Test
    public void replaceWithOldValue() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertTrue(map.replace(1, 1, 7));
        Assert.assertEquals(Integer.valueOf(7), map.get(1));
        Assert.assertFalse(map.replace(2, 3, 3));
    }

    @Test
    public void removeWithKeyValue() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertTrue(map.remove(1, 1));
        Assert.assertFalse(map.remove(2, 3));
    }

    @Override
    @Test
    public void removeFromEntrySet() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of("Two", 2)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of("Four", 4)));
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Override
    @Test
    public void removeAllFromEntrySet() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("Four", 4))));
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues("Two", 2), map);
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void equalsEdgeCases() {
        Assert.assertNotEquals(ConcurrentHashMapUnsafe.newMap().withKeyValue(1, 1), ConcurrentHashMapUnsafe.newMap());
        Assert.assertNotEquals(ConcurrentHashMapUnsafe.newMap().withKeyValue(1, 1), ConcurrentHashMapUnsafe.newMap().withKeyValue(1, 1).withKeyValue(2, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInitialSize() {
        ConcurrentHashMapUnsafe.newMap(-1);
    }

    @Override
    @Test
    public void partition_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    @Test
    public void partitionWith_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    @Test
    public void withMapNull() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newMap().withMap(null));
    }

    @Test
    public void parallelGroupByIntoConcurrentHashMap() {
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMapUnsafe.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> actual.getIfAbsentPut(each % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(each), 10, this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void parallelForEachValue() {
        ConcurrentHashMapUnsafe<Integer, Integer> source = ConcurrentHashMapUnsafe.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMapUnsafe.newMap();
        Procedure<Integer> procedure = each -> actual.getIfAbsentPut(each % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(each);
        source.parallelForEachValue(FastList.newList(Collections.nCopies(5, procedure)), this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void parallelForEachEntry() {
        ConcurrentHashMapUnsafe<Integer, Integer> source = ConcurrentHashMapUnsafe.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMapUnsafe.newMap();
        Procedure2<Integer, Integer> procedure2 = (key, value) -> actual.getIfAbsentPut(value % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(value);
        source.parallelForEachKeyValue(FastList.newList(Collections.nCopies(5, procedure2)), this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void putAllInParallelSmallMap() {
        ConcurrentHashMapUnsafe<Integer, Integer> source = ConcurrentHashMapUnsafe.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        ConcurrentHashMapUnsafe<Integer, Integer> target = ConcurrentHashMapUnsafe.newMap();
        target.putAllInParallel(source, 100, this.executor);
        Verify.assertEqualsAndHashCode(source, target);
    }

    @Test
    public void putAllInParallelLargeMap() {
        ConcurrentHashMapUnsafe<Integer, Integer> source = ConcurrentHashMapUnsafe.newMap(Interval.oneTo(600).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        ConcurrentHashMapUnsafe<Integer, Integer> target = ConcurrentHashMapUnsafe.newMap();
        target.putAllInParallel(source, 100, this.executor);
        Verify.assertEqualsAndHashCode(source, target);
    }

    @Test
    public void concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest() {
        ConcurrentHashMapUnsafe<Integer, Integer> map1 = ConcurrentHashMapUnsafe.newMap();
        ConcurrentHashMapUnsafe<Integer, Integer> map2 = ConcurrentHashMapUnsafe.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> {
            map1.put(each, each);
            Assert.assertEquals(each, map1.get(each));
            map2.putAll(Maps.mutable.of(each, each));
            map1.remove(each);
            map1.putAll(Maps.mutable.of(each, each));
            Assert.assertEquals(each, map2.get(each));
            map2.remove(each);
            Assert.assertNull(map2.get(each));
            Assert.assertFalse(map2.containsValue(each));
            Assert.assertFalse(map2.containsKey(each));
            Assert.assertEquals(each, map2.getIfAbsentPut(each, Functions.getIntegerPassThru()));
            Assert.assertTrue(map2.containsValue(each));
            Assert.assertTrue(map2.containsKey(each));
            Assert.assertEquals(each, map2.getIfAbsentPut(each, Functions.getIntegerPassThru()));
            map2.remove(each);
            Assert.assertEquals(each, map2.getIfAbsentPutWith(each, Functions.getIntegerPassThru(), each));
            Assert.assertEquals(each, map2.getIfAbsentPutWith(each, Functions.getIntegerPassThru(), each));
            Assert.assertEquals(each, map2.getIfAbsentPut(each, Functions.getIntegerPassThru()));
        }, 1, this.executor);
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Test
    public void concurrentPutIfAbsentGetIfPresentPutTest() {
        ConcurrentHashMapUnsafe<Integer, Integer> map1 = ConcurrentHashMapUnsafe.newMap();
        ConcurrentHashMapUnsafe<Integer, Integer> map2 = ConcurrentHashMapUnsafe.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> {
            map1.put(each, each);
            map1.put(each, each);
            Assert.assertEquals(each, map1.get(each));
            map2.putAll(Maps.mutable.of(each, each));
            map2.putAll(Maps.mutable.of(each, each));
            map1.remove(each);
            Assert.assertNull(map1.putIfAbsentGetIfPresent(each, new KeyTransformer(), new ValueFactory(), null, null));
            Assert.assertEquals(each, map1.putIfAbsentGetIfPresent(each, new KeyTransformer(), new ValueFactory(), null, null));
        }, 1, this.executor);
        Assert.assertEquals(map1, map2);
    }

    @Test
    public void concurrentClear() {
        ConcurrentHashMapUnsafe<Integer, Integer> map = ConcurrentHashMapUnsafe.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> {
            for (int i = 0; i < 10; i++) {
                map.put(each + i * 1000, each);
            }
            map.clear();
        }, 1, this.executor);
        Verify.assertEmpty(map);
    }

    @Test
    public void concurrentRemoveAndPutIfAbsent() {
        ConcurrentHashMapUnsafe<Integer, Integer> map1 = ConcurrentHashMapUnsafe.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> {
            Assert.assertNull(map1.put(each, each));
            map1.remove(each);
            Assert.assertNull(map1.get(each));
            Assert.assertEquals(each, map1.getIfAbsentPut(each, Functions.getIntegerPassThru()));
            map1.remove(each);
            Assert.assertNull(map1.get(each));
            Assert.assertEquals(each, map1.getIfAbsentPutWith(each, Functions.getIntegerPassThru(), each));
            map1.remove(each);
            Assert.assertNull(map1.get(each));
            for (int i = 0; i < 10; i++) {
                Assert.assertNull(map1.putIfAbsent(each + i * 1000, each));
            }
            for (int i = 0; i < 10; i++) {
                Assert.assertEquals(each, map1.putIfAbsent(each + i * 1000, each));
            }
            for (int i = 0; i < 10; i++) {
                Assert.assertEquals(each, map1.remove(each + i * 1000));
            }
        }, 1, this.executor);
    }

    @Test
    public void emptyToString() {
        ConcurrentHashMapUnsafe<?, ?> empty = ConcurrentHashMapUnsafe.newMap(0);
        Assert.assertEquals("{}", empty.toString());
    }

    private static class KeyTransformer implements Function2<Integer, Integer, Integer> {

        private static final long serialVersionUID = 1L;

        @Override
        public Integer value(Integer key, Integer value) {
            return key;
        }
    }

    private static class ValueFactory implements Function3<Object, Object, Integer, Integer> {

        private static final long serialVersionUID = 1L;

        @Override
        public Integer value(Object argument1, Object argument2, Integer key) {
            return key;
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ConcurrentHashMapUnsafeTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleReverseTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleReverseTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replace);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetContains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceWithOldValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceWithOldValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsEdgeCases() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsEdgeCases);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_negativeInitialSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.negativeInitialSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelGroupByIntoConcurrentHashMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelGroupByIntoConcurrentHashMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelForEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelForEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelForEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelForEachEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllInParallelSmallMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllInParallelSmallMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllInParallelLargeMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllInParallelLargeMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_concurrentPutIfAbsentGetIfPresentPutTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.concurrentPutIfAbsentGetIfPresentPutTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_concurrentClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.concurrentClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_concurrentRemoveAndPutIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.concurrentRemoveAndPutIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyToString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> payload) throws java.lang.Throwable {
            this.instance = new ConcurrentHashMapUnsafeTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> doubleReverseTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> replace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> entrySetContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> entrySetRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> replaceWithOldValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> equalsEdgeCases;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> negativeInitialSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> parallelGroupByIntoConcurrentHashMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> parallelForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> parallelForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllInParallelSmallMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> putAllInParallelLargeMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> concurrentPutIfAbsentGetIfPresentPutTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> concurrentClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> concurrentRemoveAndPutIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapUnsafeTest> emptyToString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ConcurrentHashMapUnsafeTest::stream;
            this.payloads.parallelStream = ConcurrentHashMapUnsafeTest::parallelStream;
            this.payloads.equalsAndHashCode = ConcurrentHashMapUnsafeTest::equalsAndHashCode;
            this.payloads.serialization = ConcurrentHashMapUnsafeTest::serialization;
            this.payloads.isEmpty = ConcurrentHashMapUnsafeTest::isEmpty;
            this.payloads.notEmpty = ConcurrentHashMapUnsafeTest::notEmpty;
            this.payloads.ifPresentApply = ConcurrentHashMapUnsafeTest::ifPresentApply;
            this.payloads.getIfAbsent_function = ConcurrentHashMapUnsafeTest::getIfAbsent_function;
            this.payloads.getOrDefault = ConcurrentHashMapUnsafeTest::getOrDefault;
            this.payloads.getIfAbsent = ConcurrentHashMapUnsafeTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ConcurrentHashMapUnsafeTest::getIfAbsentWith;
            this.payloads.tap = ConcurrentHashMapUnsafeTest::tap;
            this.payloads.forEach = ConcurrentHashMapUnsafeTest::forEach;
            this.payloads.forEachWith = ConcurrentHashMapUnsafeTest::forEachWith;
            this.payloads.forEachWithIndex = ConcurrentHashMapUnsafeTest::forEachWithIndex;
            this.payloads.forEachKey = ConcurrentHashMapUnsafeTest::forEachKey;
            this.payloads.forEachValue = ConcurrentHashMapUnsafeTest::forEachValue;
            this.payloads.forEachKeyValue = ConcurrentHashMapUnsafeTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ConcurrentHashMapUnsafeTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ConcurrentHashMapUnsafeTest::flipUniqueValues;
            this.payloads.collectMap = ConcurrentHashMapUnsafeTest::collectMap;
            this.payloads.collectBoolean = ConcurrentHashMapUnsafeTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ConcurrentHashMapUnsafeTest::collectBooleanWithTarget;
            this.payloads.collectByte = ConcurrentHashMapUnsafeTest::collectByte;
            this.payloads.collectByteWithTarget = ConcurrentHashMapUnsafeTest::collectByteWithTarget;
            this.payloads.collectChar = ConcurrentHashMapUnsafeTest::collectChar;
            this.payloads.collectCharWithTarget = ConcurrentHashMapUnsafeTest::collectCharWithTarget;
            this.payloads.collectDouble = ConcurrentHashMapUnsafeTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ConcurrentHashMapUnsafeTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ConcurrentHashMapUnsafeTest::collectFloat;
            this.payloads.collectFloatWithTarget = ConcurrentHashMapUnsafeTest::collectFloatWithTarget;
            this.payloads.collectInt = ConcurrentHashMapUnsafeTest::collectInt;
            this.payloads.collectIntWithTarget = ConcurrentHashMapUnsafeTest::collectIntWithTarget;
            this.payloads.collectLong = ConcurrentHashMapUnsafeTest::collectLong;
            this.payloads.collectLongWithTarget = ConcurrentHashMapUnsafeTest::collectLongWithTarget;
            this.payloads.collectShort = ConcurrentHashMapUnsafeTest::collectShort;
            this.payloads.collectShortWithTarget = ConcurrentHashMapUnsafeTest::collectShortWithTarget;
            this.payloads.collectValues = ConcurrentHashMapUnsafeTest::collectValues;
            this.payloads.select = ConcurrentHashMapUnsafeTest::select;
            this.payloads.selectWith = ConcurrentHashMapUnsafeTest::selectWith;
            this.payloads.reject = ConcurrentHashMapUnsafeTest::reject;
            this.payloads.rejectWith = ConcurrentHashMapUnsafeTest::rejectWith;
            this.payloads.collect = ConcurrentHashMapUnsafeTest::collect;
            this.payloads.flatCollect = ConcurrentHashMapUnsafeTest::flatCollect;
            this.payloads.flatCollectWith = ConcurrentHashMapUnsafeTest::flatCollectWith;
            this.payloads.selectMap = ConcurrentHashMapUnsafeTest::selectMap;
            this.payloads.rejectMap = ConcurrentHashMapUnsafeTest::rejectMap;
            this.payloads.flip = ConcurrentHashMapUnsafeTest::flip;
            this.payloads.detect = ConcurrentHashMapUnsafeTest::detect;
            this.payloads.detectOptional = ConcurrentHashMapUnsafeTest::detectOptional;
            this.payloads.anySatisfy = ConcurrentHashMapUnsafeTest::anySatisfy;
            this.payloads.anySatisfyWith = ConcurrentHashMapUnsafeTest::anySatisfyWith;
            this.payloads.allSatisfy = ConcurrentHashMapUnsafeTest::allSatisfy;
            this.payloads.allSatisfyWith = ConcurrentHashMapUnsafeTest::allSatisfyWith;
            this.payloads.noneSatisfy = ConcurrentHashMapUnsafeTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ConcurrentHashMapUnsafeTest::noneSatisfyWith;
            this.payloads.appendString = ConcurrentHashMapUnsafeTest::appendString;
            this.payloads.toBag = ConcurrentHashMapUnsafeTest::toBag;
            this.payloads.toSortedBag = ConcurrentHashMapUnsafeTest::toSortedBag;
            this.payloads.toSortedBagBy = ConcurrentHashMapUnsafeTest::toSortedBagBy;
            this.payloads.asLazy = ConcurrentHashMapUnsafeTest::asLazy;
            this.payloads.toList = ConcurrentHashMapUnsafeTest::toList;
            this.payloads.toMap = ConcurrentHashMapUnsafeTest::toMap;
            this.payloads.toSet = ConcurrentHashMapUnsafeTest::toSet;
            this.payloads.toSortedList = ConcurrentHashMapUnsafeTest::toSortedList;
            this.payloads.toSortedListBy = ConcurrentHashMapUnsafeTest::toSortedListBy;
            this.payloads.toSortedSet = ConcurrentHashMapUnsafeTest::toSortedSet;
            this.payloads.toSortedSetBy = ConcurrentHashMapUnsafeTest::toSortedSetBy;
            this.payloads.toSortedMap = ConcurrentHashMapUnsafeTest::toSortedMap;
            this.payloads.chunk = ConcurrentHashMapUnsafeTest::chunk;
            this.payloads.collect_value = ConcurrentHashMapUnsafeTest::collect_value;
            this.payloads.collectIf = ConcurrentHashMapUnsafeTest::collectIf;
            this.payloads.collectWith = ConcurrentHashMapUnsafeTest::collectWith;
            this.payloads.collectWithToTarget = ConcurrentHashMapUnsafeTest::collectWithToTarget;
            this.payloads.contains = ConcurrentHashMapUnsafeTest::contains;
            this.payloads.containsAnyIterable = ConcurrentHashMapUnsafeTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ConcurrentHashMapUnsafeTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ConcurrentHashMapUnsafeTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ConcurrentHashMapUnsafeTest::containsNoneCollection;
            this.payloads.containsAll = ConcurrentHashMapUnsafeTest::containsAll;
            this.payloads.containsKey = ConcurrentHashMapUnsafeTest::containsKey;
            this.payloads.containsValue = ConcurrentHashMapUnsafeTest::containsValue;
            this.payloads.getFirst = ConcurrentHashMapUnsafeTest::getFirst;
            this.payloads.getLast = ConcurrentHashMapUnsafeTest::getLast;
            this.payloads.getOnly = ConcurrentHashMapUnsafeTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapUnsafeTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapUnsafeTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ConcurrentHashMapUnsafeTest::containsAllIterable;
            this.payloads.containsAllArguments = ConcurrentHashMapUnsafeTest::containsAllArguments;
            this.payloads.count = ConcurrentHashMapUnsafeTest::count;
            this.payloads.countWith = ConcurrentHashMapUnsafeTest::countWith;
            this.payloads.detect_value = ConcurrentHashMapUnsafeTest::detect_value;
            this.payloads.detectOptional_value = ConcurrentHashMapUnsafeTest::detectOptional_value;
            this.payloads.detectWith = ConcurrentHashMapUnsafeTest::detectWith;
            this.payloads.detectWithOptional = ConcurrentHashMapUnsafeTest::detectWithOptional;
            this.payloads.detectIfNone_value = ConcurrentHashMapUnsafeTest::detectIfNone_value;
            this.payloads.detectWithIfNone = ConcurrentHashMapUnsafeTest::detectWithIfNone;
            this.payloads.flatten_value = ConcurrentHashMapUnsafeTest::flatten_value;
            this.payloads.countBy = ConcurrentHashMapUnsafeTest::countBy;
            this.payloads.countByWith = ConcurrentHashMapUnsafeTest::countByWith;
            this.payloads.countByEach = ConcurrentHashMapUnsafeTest::countByEach;
            this.payloads.groupBy = ConcurrentHashMapUnsafeTest::groupBy;
            this.payloads.groupByEach = ConcurrentHashMapUnsafeTest::groupByEach;
            this.payloads.groupByUniqueKey = ConcurrentHashMapUnsafeTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapUnsafeTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ConcurrentHashMapUnsafeTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapUnsafeTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ConcurrentHashMapUnsafeTest::injectInto;
            this.payloads.injectIntoInt = ConcurrentHashMapUnsafeTest::injectIntoInt;
            this.payloads.injectIntoLong = ConcurrentHashMapUnsafeTest::injectIntoLong;
            this.payloads.injectIntoFloat = ConcurrentHashMapUnsafeTest::injectIntoFloat;
            this.payloads.injectIntoDouble = ConcurrentHashMapUnsafeTest::injectIntoDouble;
            this.payloads.sumOfInt = ConcurrentHashMapUnsafeTest::sumOfInt;
            this.payloads.sumOfLong = ConcurrentHashMapUnsafeTest::sumOfLong;
            this.payloads.testAggregateBy = ConcurrentHashMapUnsafeTest::testAggregateBy;
            this.payloads.sumOfFloat = ConcurrentHashMapUnsafeTest::sumOfFloat;
            this.payloads.sumOfDouble = ConcurrentHashMapUnsafeTest::sumOfDouble;
            this.payloads.sumByInt = ConcurrentHashMapUnsafeTest::sumByInt;
            this.payloads.sumByFloat = ConcurrentHashMapUnsafeTest::sumByFloat;
            this.payloads.sumByLong = ConcurrentHashMapUnsafeTest::sumByLong;
            this.payloads.sumByDouble = ConcurrentHashMapUnsafeTest::sumByDouble;
            this.payloads.makeString = ConcurrentHashMapUnsafeTest::makeString;
            this.payloads.min = ConcurrentHashMapUnsafeTest::min;
            this.payloads.max = ConcurrentHashMapUnsafeTest::max;
            this.payloads.minBy = ConcurrentHashMapUnsafeTest::minBy;
            this.payloads.maxBy = ConcurrentHashMapUnsafeTest::maxBy;
            this.payloads.reject_value = ConcurrentHashMapUnsafeTest::reject_value;
            this.payloads.rejectWith_value = ConcurrentHashMapUnsafeTest::rejectWith_value;
            this.payloads.select_value = ConcurrentHashMapUnsafeTest::select_value;
            this.payloads.selectWith_value = ConcurrentHashMapUnsafeTest::selectWith_value;
            this.payloads.selectInstancesOf_value = ConcurrentHashMapUnsafeTest::selectInstancesOf_value;
            this.payloads.toArray = ConcurrentHashMapUnsafeTest::toArray;
            this.payloads.zip = ConcurrentHashMapUnsafeTest::zip;
            this.payloads.zipWithIndex = ConcurrentHashMapUnsafeTest::zipWithIndex;
            this.payloads.aggregateByMutating = ConcurrentHashMapUnsafeTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ConcurrentHashMapUnsafeTest::aggregateByNonMutating;
            this.payloads.keyValuesView = ConcurrentHashMapUnsafeTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ConcurrentHashMapUnsafeTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ConcurrentHashMapUnsafeTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = ConcurrentHashMapUnsafeTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ConcurrentHashMapUnsafeTest::newMapWithWith;
            this.payloads.newMapWithWithWith = ConcurrentHashMapUnsafeTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ConcurrentHashMapUnsafeTest::newMapWithWithWithWith;
            this.payloads.iterator = ConcurrentHashMapUnsafeTest::iterator;
            this.payloads.keysView = ConcurrentHashMapUnsafeTest::keysView;
            this.payloads.valuesView = ConcurrentHashMapUnsafeTest::valuesView;
            this.payloads.test_toString = ConcurrentHashMapUnsafeTest::test_toString;
            this.payloads.toImmutable = ConcurrentHashMapUnsafeTest::toImmutable;
            this.payloads.clear = ConcurrentHashMapUnsafeTest::clear;
            this.payloads.removeObject = ConcurrentHashMapUnsafeTest::removeObject;
            this.payloads.retainAllFromEntrySet = ConcurrentHashMapUnsafeTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = ConcurrentHashMapUnsafeTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = ConcurrentHashMapUnsafeTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = ConcurrentHashMapUnsafeTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ConcurrentHashMapUnsafeTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ConcurrentHashMapUnsafeTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ConcurrentHashMapUnsafeTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ConcurrentHashMapUnsafeTest::clearKeySet;
            this.payloads.keySetToArray = ConcurrentHashMapUnsafeTest::keySetToArray;
            this.payloads.removeFromValues = ConcurrentHashMapUnsafeTest::removeFromValues;
            this.payloads.removeNullFromValues = ConcurrentHashMapUnsafeTest::removeNullFromValues;
            this.payloads.removeAllFromValues = ConcurrentHashMapUnsafeTest::removeAllFromValues;
            this.payloads.retainAllFromValues = ConcurrentHashMapUnsafeTest::retainAllFromValues;
            this.payloads.put = ConcurrentHashMapUnsafeTest::put;
            this.payloads.putAll = ConcurrentHashMapUnsafeTest::putAll;
            this.payloads.removeKey = ConcurrentHashMapUnsafeTest::removeKey;
            this.payloads.removeAllKeys = ConcurrentHashMapUnsafeTest::removeAllKeys;
            this.payloads.removeIf = ConcurrentHashMapUnsafeTest::removeIf;
            this.payloads.getIfAbsentPut = ConcurrentHashMapUnsafeTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = ConcurrentHashMapUnsafeTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = ConcurrentHashMapUnsafeTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = ConcurrentHashMapUnsafeTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = ConcurrentHashMapUnsafeTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = ConcurrentHashMapUnsafeTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = ConcurrentHashMapUnsafeTest::getKeysAndGetValues;
            this.payloads.newEmpty = ConcurrentHashMapUnsafeTest::newEmpty;
            this.payloads.keysAndValues_toString = ConcurrentHashMapUnsafeTest::keysAndValues_toString;
            this.payloads.keyPreservation = ConcurrentHashMapUnsafeTest::keyPreservation;
            this.payloads.asUnmodifiable = ConcurrentHashMapUnsafeTest::asUnmodifiable;
            this.payloads.asSynchronized = ConcurrentHashMapUnsafeTest::asSynchronized;
            this.payloads.add = ConcurrentHashMapUnsafeTest::add;
            this.payloads.putPair = ConcurrentHashMapUnsafeTest::putPair;
            this.payloads.withKeyValue = ConcurrentHashMapUnsafeTest::withKeyValue;
            this.payloads.withMap = ConcurrentHashMapUnsafeTest::withMap;
            this.payloads.withMapEmpty = ConcurrentHashMapUnsafeTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = ConcurrentHashMapUnsafeTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = ConcurrentHashMapUnsafeTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = ConcurrentHashMapUnsafeTest::withMapIterable;
            this.payloads.withMapIterableEmpty = ConcurrentHashMapUnsafeTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = ConcurrentHashMapUnsafeTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ConcurrentHashMapUnsafeTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ConcurrentHashMapUnsafeTest::withMapIterableNull;
            this.payloads.putAllMapIterable = ConcurrentHashMapUnsafeTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = ConcurrentHashMapUnsafeTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = ConcurrentHashMapUnsafeTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = ConcurrentHashMapUnsafeTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = ConcurrentHashMapUnsafeTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = ConcurrentHashMapUnsafeTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = ConcurrentHashMapUnsafeTest::withAllKeyValueArguments;
            this.payloads.withoutKey = ConcurrentHashMapUnsafeTest::withoutKey;
            this.payloads.withoutAllKeys = ConcurrentHashMapUnsafeTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = ConcurrentHashMapUnsafeTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = ConcurrentHashMapUnsafeTest::rehash_null_collision;
            this.payloads.collectKeysAndValues = ConcurrentHashMapUnsafeTest::collectKeysAndValues;
            this.payloads.testClone = ConcurrentHashMapUnsafeTest::testClone;
            this.payloads.updateValue = ConcurrentHashMapUnsafeTest::updateValue;
            this.payloads.updateValue_collisions = ConcurrentHashMapUnsafeTest::updateValue_collisions;
            this.payloads.updateValueWith = ConcurrentHashMapUnsafeTest::updateValueWith;
            this.payloads.updateValueWith_collisions = ConcurrentHashMapUnsafeTest::updateValueWith_collisions;
            this.payloads.doubleReverseTest = ConcurrentHashMapUnsafeTest::doubleReverseTest;
            this.payloads.putIfAbsent = ConcurrentHashMapUnsafeTest::putIfAbsent;
            this.payloads.replace = ConcurrentHashMapUnsafeTest::replace;
            this.payloads.entrySetContains = ConcurrentHashMapUnsafeTest::entrySetContains;
            this.payloads.entrySetRemove = ConcurrentHashMapUnsafeTest::entrySetRemove;
            this.payloads.replaceWithOldValue = ConcurrentHashMapUnsafeTest::replaceWithOldValue;
            this.payloads.removeWithKeyValue = ConcurrentHashMapUnsafeTest::removeWithKeyValue;
            this.payloads.removeFromEntrySet = ConcurrentHashMapUnsafeTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = ConcurrentHashMapUnsafeTest::removeAllFromEntrySet;
            this.payloads.keySetEqualsAndHashCode = ConcurrentHashMapUnsafeTest::keySetEqualsAndHashCode;
            this.payloads.equalsEdgeCases = ConcurrentHashMapUnsafeTest::equalsEdgeCases;
            this.payloads.negativeInitialSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapUnsafeTest::negativeInitialSize, java.lang.IllegalArgumentException.class);
            this.payloads.partition_value = ConcurrentHashMapUnsafeTest::partition_value;
            this.payloads.partitionWith_value = ConcurrentHashMapUnsafeTest::partitionWith_value;
            this.payloads.withMapNull = ConcurrentHashMapUnsafeTest::withMapNull;
            this.payloads.parallelGroupByIntoConcurrentHashMap = ConcurrentHashMapUnsafeTest::parallelGroupByIntoConcurrentHashMap;
            this.payloads.parallelForEachValue = ConcurrentHashMapUnsafeTest::parallelForEachValue;
            this.payloads.parallelForEachEntry = ConcurrentHashMapUnsafeTest::parallelForEachEntry;
            this.payloads.putAllInParallelSmallMap = ConcurrentHashMapUnsafeTest::putAllInParallelSmallMap;
            this.payloads.putAllInParallelLargeMap = ConcurrentHashMapUnsafeTest::putAllInParallelLargeMap;
            this.payloads.concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest = ConcurrentHashMapUnsafeTest::concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest;
            this.payloads.concurrentPutIfAbsentGetIfPresentPutTest = ConcurrentHashMapUnsafeTest::concurrentPutIfAbsentGetIfPresentPutTest;
            this.payloads.concurrentClear = ConcurrentHashMapUnsafeTest::concurrentClear;
            this.payloads.concurrentRemoveAndPutIfAbsent = ConcurrentHashMapUnsafeTest::concurrentRemoveAndPutIfAbsent;
            this.payloads.emptyToString = ConcurrentHashMapUnsafeTest::emptyToString;
        }
    }
}
