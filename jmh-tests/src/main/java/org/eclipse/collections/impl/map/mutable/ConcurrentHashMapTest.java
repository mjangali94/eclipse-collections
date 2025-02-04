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
 * JUnit test for {@link ConcurrentHashMap}.
 */
public class ConcurrentHashMapTest extends ConcurrentHashMapTestCase {

    public static final MutableMap<Integer, MutableBag<Integer>> SMALL_BAG_MUTABLE_MAP = Interval.oneTo(100).groupBy(each -> each % 10).toMap(HashBag::new);

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMap() {
        return ConcurrentHashMap.newMap();
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return ConcurrentHashMap.<K, V>newMap().withKeyValue(key, value);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return ConcurrentHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return ConcurrentHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return ConcurrentHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
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
        Assert.assertNotEquals(ConcurrentHashMap.newMap().withKeyValue(1, 1), ConcurrentHashMap.newMap());
        Assert.assertNotEquals(ConcurrentHashMap.newMap().withKeyValue(1, 1), ConcurrentHashMap.newMap().withKeyValue(1, 1).withKeyValue(2, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInitialSize() {
        ConcurrentHashMap.newMap(-1);
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
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMap.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> actual.getIfAbsentPut(each % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(each), 10, this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void parallelForEachValue() {
        ConcurrentHashMap<Integer, Integer> source = ConcurrentHashMap.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMap.newMap();
        Procedure<Integer> procedure = each -> actual.getIfAbsentPut(each % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(each);
        source.parallelForEachValue(FastList.newList(Collections.nCopies(5, procedure)), this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void parallelForEachEntry() {
        ConcurrentHashMap<Integer, Integer> source = ConcurrentHashMap.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        MutableMap<Integer, MutableBag<Integer>> actual = ConcurrentHashMap.newMap();
        Procedure2<Integer, Integer> procedure2 = (key, value) -> actual.getIfAbsentPut(value % 10, () -> HashBag.<Integer>newBag().asSynchronized()).add(value);
        source.parallelForEachKeyValue(FastList.newList(Collections.nCopies(5, procedure2)), this.executor);
        Verify.assertEqualsAndHashCode(SMALL_BAG_MUTABLE_MAP, actual);
    }

    @Test
    public void putAllInParallelSmallMap() {
        ConcurrentHashMap<Integer, Integer> source = ConcurrentHashMap.newMap(Interval.oneTo(100).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        ConcurrentHashMap<Integer, Integer> target = ConcurrentHashMap.newMap();
        target.putAllInParallel(source, 100, this.executor);
        Verify.assertEqualsAndHashCode(source, target);
    }

    @Test
    public void putAllInParallelLargeMap() {
        ConcurrentHashMap<Integer, Integer> source = ConcurrentHashMap.newMap(Interval.oneTo(600).toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
        ConcurrentHashMap<Integer, Integer> target = ConcurrentHashMap.newMap();
        target.putAllInParallel(source, 100, this.executor);
        Verify.assertEqualsAndHashCode(source, target);
    }

    @Test
    public void concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest() {
        ConcurrentHashMap<Integer, Integer> map1 = ConcurrentHashMap.newMap();
        ConcurrentHashMap<Integer, Integer> map2 = ConcurrentHashMap.newMap();
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
        ConcurrentHashMap<Integer, Integer> map1 = ConcurrentHashMap.newMap();
        ConcurrentHashMap<Integer, Integer> map2 = ConcurrentHashMap.newMap();
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
        ConcurrentHashMap<Integer, Integer> map = ConcurrentHashMap.newMap();
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
        ConcurrentHashMap<Integer, Integer> map1 = ConcurrentHashMap.newMap();
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
        ConcurrentHashMap<?, ?> empty = ConcurrentHashMap.newMap(0);
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ConcurrentHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ConcurrentHashMapTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> doubleReverseTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> replace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> entrySetContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> entrySetRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> replaceWithOldValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> equalsEdgeCases;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> negativeInitialSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> parallelGroupByIntoConcurrentHashMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> parallelForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> parallelForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllInParallelSmallMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> putAllInParallelLargeMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> concurrentPutIfAbsentGetIfPresentPutTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> concurrentClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> concurrentRemoveAndPutIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTest> emptyToString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ConcurrentHashMapTest::stream;
            this.payloads.parallelStream = ConcurrentHashMapTest::parallelStream;
            this.payloads.equalsAndHashCode = ConcurrentHashMapTest::equalsAndHashCode;
            this.payloads.serialization = ConcurrentHashMapTest::serialization;
            this.payloads.isEmpty = ConcurrentHashMapTest::isEmpty;
            this.payloads.notEmpty = ConcurrentHashMapTest::notEmpty;
            this.payloads.ifPresentApply = ConcurrentHashMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = ConcurrentHashMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ConcurrentHashMapTest::getOrDefault;
            this.payloads.getIfAbsent = ConcurrentHashMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ConcurrentHashMapTest::getIfAbsentWith;
            this.payloads.tap = ConcurrentHashMapTest::tap;
            this.payloads.forEach = ConcurrentHashMapTest::forEach;
            this.payloads.forEachWith = ConcurrentHashMapTest::forEachWith;
            this.payloads.forEachWithIndex = ConcurrentHashMapTest::forEachWithIndex;
            this.payloads.forEachKey = ConcurrentHashMapTest::forEachKey;
            this.payloads.forEachValue = ConcurrentHashMapTest::forEachValue;
            this.payloads.forEachKeyValue = ConcurrentHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ConcurrentHashMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ConcurrentHashMapTest::flipUniqueValues;
            this.payloads.collectMap = ConcurrentHashMapTest::collectMap;
            this.payloads.collectBoolean = ConcurrentHashMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ConcurrentHashMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = ConcurrentHashMapTest::collectByte;
            this.payloads.collectByteWithTarget = ConcurrentHashMapTest::collectByteWithTarget;
            this.payloads.collectChar = ConcurrentHashMapTest::collectChar;
            this.payloads.collectCharWithTarget = ConcurrentHashMapTest::collectCharWithTarget;
            this.payloads.collectDouble = ConcurrentHashMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ConcurrentHashMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ConcurrentHashMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = ConcurrentHashMapTest::collectFloatWithTarget;
            this.payloads.collectInt = ConcurrentHashMapTest::collectInt;
            this.payloads.collectIntWithTarget = ConcurrentHashMapTest::collectIntWithTarget;
            this.payloads.collectLong = ConcurrentHashMapTest::collectLong;
            this.payloads.collectLongWithTarget = ConcurrentHashMapTest::collectLongWithTarget;
            this.payloads.collectShort = ConcurrentHashMapTest::collectShort;
            this.payloads.collectShortWithTarget = ConcurrentHashMapTest::collectShortWithTarget;
            this.payloads.collectValues = ConcurrentHashMapTest::collectValues;
            this.payloads.select = ConcurrentHashMapTest::select;
            this.payloads.selectWith = ConcurrentHashMapTest::selectWith;
            this.payloads.reject = ConcurrentHashMapTest::reject;
            this.payloads.rejectWith = ConcurrentHashMapTest::rejectWith;
            this.payloads.collect = ConcurrentHashMapTest::collect;
            this.payloads.flatCollect = ConcurrentHashMapTest::flatCollect;
            this.payloads.flatCollectWith = ConcurrentHashMapTest::flatCollectWith;
            this.payloads.selectMap = ConcurrentHashMapTest::selectMap;
            this.payloads.rejectMap = ConcurrentHashMapTest::rejectMap;
            this.payloads.flip = ConcurrentHashMapTest::flip;
            this.payloads.detect = ConcurrentHashMapTest::detect;
            this.payloads.detectOptional = ConcurrentHashMapTest::detectOptional;
            this.payloads.anySatisfy = ConcurrentHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ConcurrentHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ConcurrentHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ConcurrentHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ConcurrentHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ConcurrentHashMapTest::noneSatisfyWith;
            this.payloads.appendString = ConcurrentHashMapTest::appendString;
            this.payloads.toBag = ConcurrentHashMapTest::toBag;
            this.payloads.toSortedBag = ConcurrentHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ConcurrentHashMapTest::toSortedBagBy;
            this.payloads.asLazy = ConcurrentHashMapTest::asLazy;
            this.payloads.toList = ConcurrentHashMapTest::toList;
            this.payloads.toMap = ConcurrentHashMapTest::toMap;
            this.payloads.toSet = ConcurrentHashMapTest::toSet;
            this.payloads.toSortedList = ConcurrentHashMapTest::toSortedList;
            this.payloads.toSortedListBy = ConcurrentHashMapTest::toSortedListBy;
            this.payloads.toSortedSet = ConcurrentHashMapTest::toSortedSet;
            this.payloads.toSortedSetBy = ConcurrentHashMapTest::toSortedSetBy;
            this.payloads.toSortedMap = ConcurrentHashMapTest::toSortedMap;
            this.payloads.chunk = ConcurrentHashMapTest::chunk;
            this.payloads.collect_value = ConcurrentHashMapTest::collect_value;
            this.payloads.collectIf = ConcurrentHashMapTest::collectIf;
            this.payloads.collectWith = ConcurrentHashMapTest::collectWith;
            this.payloads.collectWithToTarget = ConcurrentHashMapTest::collectWithToTarget;
            this.payloads.contains = ConcurrentHashMapTest::contains;
            this.payloads.containsAnyIterable = ConcurrentHashMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ConcurrentHashMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ConcurrentHashMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ConcurrentHashMapTest::containsNoneCollection;
            this.payloads.containsAll = ConcurrentHashMapTest::containsAll;
            this.payloads.containsKey = ConcurrentHashMapTest::containsKey;
            this.payloads.containsValue = ConcurrentHashMapTest::containsValue;
            this.payloads.getFirst = ConcurrentHashMapTest::getFirst;
            this.payloads.getLast = ConcurrentHashMapTest::getLast;
            this.payloads.getOnly = ConcurrentHashMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ConcurrentHashMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ConcurrentHashMapTest::containsAllArguments;
            this.payloads.count = ConcurrentHashMapTest::count;
            this.payloads.countWith = ConcurrentHashMapTest::countWith;
            this.payloads.detect_value = ConcurrentHashMapTest::detect_value;
            this.payloads.detectOptional_value = ConcurrentHashMapTest::detectOptional_value;
            this.payloads.detectWith = ConcurrentHashMapTest::detectWith;
            this.payloads.detectWithOptional = ConcurrentHashMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = ConcurrentHashMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = ConcurrentHashMapTest::detectWithIfNone;
            this.payloads.flatten_value = ConcurrentHashMapTest::flatten_value;
            this.payloads.countBy = ConcurrentHashMapTest::countBy;
            this.payloads.countByWith = ConcurrentHashMapTest::countByWith;
            this.payloads.countByEach = ConcurrentHashMapTest::countByEach;
            this.payloads.groupBy = ConcurrentHashMapTest::groupBy;
            this.payloads.groupByEach = ConcurrentHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ConcurrentHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ConcurrentHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ConcurrentHashMapTest::injectInto;
            this.payloads.injectIntoInt = ConcurrentHashMapTest::injectIntoInt;
            this.payloads.injectIntoLong = ConcurrentHashMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = ConcurrentHashMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = ConcurrentHashMapTest::injectIntoDouble;
            this.payloads.sumOfInt = ConcurrentHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ConcurrentHashMapTest::sumOfLong;
            this.payloads.testAggregateBy = ConcurrentHashMapTest::testAggregateBy;
            this.payloads.sumOfFloat = ConcurrentHashMapTest::sumOfFloat;
            this.payloads.sumOfDouble = ConcurrentHashMapTest::sumOfDouble;
            this.payloads.sumByInt = ConcurrentHashMapTest::sumByInt;
            this.payloads.sumByFloat = ConcurrentHashMapTest::sumByFloat;
            this.payloads.sumByLong = ConcurrentHashMapTest::sumByLong;
            this.payloads.sumByDouble = ConcurrentHashMapTest::sumByDouble;
            this.payloads.makeString = ConcurrentHashMapTest::makeString;
            this.payloads.min = ConcurrentHashMapTest::min;
            this.payloads.max = ConcurrentHashMapTest::max;
            this.payloads.minBy = ConcurrentHashMapTest::minBy;
            this.payloads.maxBy = ConcurrentHashMapTest::maxBy;
            this.payloads.reject_value = ConcurrentHashMapTest::reject_value;
            this.payloads.rejectWith_value = ConcurrentHashMapTest::rejectWith_value;
            this.payloads.select_value = ConcurrentHashMapTest::select_value;
            this.payloads.selectWith_value = ConcurrentHashMapTest::selectWith_value;
            this.payloads.selectInstancesOf_value = ConcurrentHashMapTest::selectInstancesOf_value;
            this.payloads.toArray = ConcurrentHashMapTest::toArray;
            this.payloads.zip = ConcurrentHashMapTest::zip;
            this.payloads.zipWithIndex = ConcurrentHashMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = ConcurrentHashMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ConcurrentHashMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = ConcurrentHashMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ConcurrentHashMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ConcurrentHashMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = ConcurrentHashMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ConcurrentHashMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = ConcurrentHashMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ConcurrentHashMapTest::newMapWithWithWithWith;
            this.payloads.iterator = ConcurrentHashMapTest::iterator;
            this.payloads.keysView = ConcurrentHashMapTest::keysView;
            this.payloads.valuesView = ConcurrentHashMapTest::valuesView;
            this.payloads.test_toString = ConcurrentHashMapTest::test_toString;
            this.payloads.toImmutable = ConcurrentHashMapTest::toImmutable;
            this.payloads.clear = ConcurrentHashMapTest::clear;
            this.payloads.removeObject = ConcurrentHashMapTest::removeObject;
            this.payloads.retainAllFromEntrySet = ConcurrentHashMapTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = ConcurrentHashMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = ConcurrentHashMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = ConcurrentHashMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ConcurrentHashMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ConcurrentHashMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ConcurrentHashMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ConcurrentHashMapTest::clearKeySet;
            this.payloads.keySetToArray = ConcurrentHashMapTest::keySetToArray;
            this.payloads.removeFromValues = ConcurrentHashMapTest::removeFromValues;
            this.payloads.removeNullFromValues = ConcurrentHashMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = ConcurrentHashMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = ConcurrentHashMapTest::retainAllFromValues;
            this.payloads.put = ConcurrentHashMapTest::put;
            this.payloads.putAll = ConcurrentHashMapTest::putAll;
            this.payloads.removeKey = ConcurrentHashMapTest::removeKey;
            this.payloads.removeAllKeys = ConcurrentHashMapTest::removeAllKeys;
            this.payloads.removeIf = ConcurrentHashMapTest::removeIf;
            this.payloads.getIfAbsentPut = ConcurrentHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = ConcurrentHashMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = ConcurrentHashMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = ConcurrentHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = ConcurrentHashMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = ConcurrentHashMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = ConcurrentHashMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = ConcurrentHashMapTest::newEmpty;
            this.payloads.keysAndValues_toString = ConcurrentHashMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = ConcurrentHashMapTest::keyPreservation;
            this.payloads.asUnmodifiable = ConcurrentHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = ConcurrentHashMapTest::asSynchronized;
            this.payloads.add = ConcurrentHashMapTest::add;
            this.payloads.putPair = ConcurrentHashMapTest::putPair;
            this.payloads.withKeyValue = ConcurrentHashMapTest::withKeyValue;
            this.payloads.withMap = ConcurrentHashMapTest::withMap;
            this.payloads.withMapEmpty = ConcurrentHashMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = ConcurrentHashMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = ConcurrentHashMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = ConcurrentHashMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = ConcurrentHashMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = ConcurrentHashMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ConcurrentHashMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ConcurrentHashMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = ConcurrentHashMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = ConcurrentHashMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = ConcurrentHashMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = ConcurrentHashMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = ConcurrentHashMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = ConcurrentHashMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = ConcurrentHashMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = ConcurrentHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ConcurrentHashMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = ConcurrentHashMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = ConcurrentHashMapTest::rehash_null_collision;
            this.payloads.collectKeysAndValues = ConcurrentHashMapTest::collectKeysAndValues;
            this.payloads.testClone = ConcurrentHashMapTest::testClone;
            this.payloads.updateValue = ConcurrentHashMapTest::updateValue;
            this.payloads.updateValue_collisions = ConcurrentHashMapTest::updateValue_collisions;
            this.payloads.updateValueWith = ConcurrentHashMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = ConcurrentHashMapTest::updateValueWith_collisions;
            this.payloads.doubleReverseTest = ConcurrentHashMapTest::doubleReverseTest;
            this.payloads.putIfAbsent = ConcurrentHashMapTest::putIfAbsent;
            this.payloads.replace = ConcurrentHashMapTest::replace;
            this.payloads.entrySetContains = ConcurrentHashMapTest::entrySetContains;
            this.payloads.entrySetRemove = ConcurrentHashMapTest::entrySetRemove;
            this.payloads.replaceWithOldValue = ConcurrentHashMapTest::replaceWithOldValue;
            this.payloads.removeWithKeyValue = ConcurrentHashMapTest::removeWithKeyValue;
            this.payloads.removeFromEntrySet = ConcurrentHashMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = ConcurrentHashMapTest::removeAllFromEntrySet;
            this.payloads.keySetEqualsAndHashCode = ConcurrentHashMapTest::keySetEqualsAndHashCode;
            this.payloads.equalsEdgeCases = ConcurrentHashMapTest::equalsEdgeCases;
            this.payloads.negativeInitialSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTest::negativeInitialSize, java.lang.IllegalArgumentException.class);
            this.payloads.partition_value = ConcurrentHashMapTest::partition_value;
            this.payloads.partitionWith_value = ConcurrentHashMapTest::partitionWith_value;
            this.payloads.withMapNull = ConcurrentHashMapTest::withMapNull;
            this.payloads.parallelGroupByIntoConcurrentHashMap = ConcurrentHashMapTest::parallelGroupByIntoConcurrentHashMap;
            this.payloads.parallelForEachValue = ConcurrentHashMapTest::parallelForEachValue;
            this.payloads.parallelForEachEntry = ConcurrentHashMapTest::parallelForEachEntry;
            this.payloads.putAllInParallelSmallMap = ConcurrentHashMapTest::putAllInParallelSmallMap;
            this.payloads.putAllInParallelLargeMap = ConcurrentHashMapTest::putAllInParallelLargeMap;
            this.payloads.concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest = ConcurrentHashMapTest::concurrentPutGetPutAllRemoveContainsKeyContainsValueGetIfAbsentPutTest;
            this.payloads.concurrentPutIfAbsentGetIfPresentPutTest = ConcurrentHashMapTest::concurrentPutIfAbsentGetIfPresentPutTest;
            this.payloads.concurrentClear = ConcurrentHashMapTest::concurrentClear;
            this.payloads.concurrentRemoveAndPutIfAbsent = ConcurrentHashMapTest::concurrentRemoveAndPutIfAbsent;
            this.payloads.emptyToString = ConcurrentHashMapTest::emptyToString;
        }
    }
*/
}
