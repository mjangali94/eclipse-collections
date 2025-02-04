/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.fixed;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.FixedSizeMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link EmptyMap}.
 */
public class EmptyMapTest extends AbstractMemoryEfficientMutableMapTest {

    @Override
    protected MutableMap<String, String> classUnderTest() {
        return new EmptyMap<>();
    }

    @Override
    protected MutableMap<String, Integer> mixedTypeClassUnderTest() {
        return new EmptyMap<>();
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(new EmptyMap<>().containsValue("One"));
    }

    @Test
    public void size() {
        Verify.assertEmpty(new EmptyMap<>());
    }

    @Test
    public void empty() {
        Verify.assertEmpty(new EmptyMap<>());
        Assert.assertFalse(new EmptyMap<>().notEmpty());
        Verify.assertEmpty(new EmptyMap<>());
        Assert.assertFalse(new EmptyMap<>().notEmpty());
        Verify.assertEmpty(Maps.fixedSize.of());
        Assert.assertFalse(Maps.fixedSize.of().notEmpty());
    }

    @Test
    public void viewsEmpty() {
        Verify.assertEmpty(new EmptyMap<>().entrySet());
        Verify.assertEmpty(new EmptyMap<>().values());
        Verify.assertEmpty(new EmptyMap<>().keySet());
    }

    @Test
    public void flipUniqueValues() {
        MutableMap<Object, Object> flip = new EmptyMap<>().flipUniqueValues();
        Verify.assertEmpty(flip);
        Verify.assertInstanceOf(EmptyMap.class, flip);
    }

    @Test
    public void testReadResolve() {
        Verify.assertInstanceOf(EmptyMap.class, Maps.fixedSize.of());
        Verify.assertPostSerializedIdentity(Maps.fixedSize.of());
    }

    @Override
    @Test
    public void testClone() {
        MutableMap<String, String> map = this.classUnderTest();
        Assert.assertSame(map, map.clone());
    }

    @Test
    public void iterations() {
        StubProcedure<Object> procedure = new StubProcedure<>();
        MutableMap<Object, Object> map = new EmptyMap<>();
        map.each(procedure);
        Assert.assertFalse(procedure.called);
        map.forEachKey(procedure);
        Assert.assertFalse(procedure.called);
        map.forEachValue(procedure);
        Assert.assertFalse(procedure.called);
        map.forEachKeyValue(procedure);
        Assert.assertFalse(procedure.called);
        map.forEachWith(procedure, new Object());
        Assert.assertFalse(procedure.called);
        map.forEachWithIndex(procedure);
        Assert.assertFalse(procedure.called);
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{}", new EmptyMap<Integer, String>().toString());
    }

    @Override
    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(UnifiedMap.<String, String>newMap(), this.classUnderTest());
    }

    @Override
    @Test
    public void select() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> actual = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(EmptyMap.class, actual);
    }

    @Override
    @Test
    public void reject() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> actual = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(EmptyMap.class, actual);
    }

    @Override
    @Test
    public void detect() {
        MutableMap<String, String> map = this.classUnderTest();
        Assert.assertNull(map.detect((ignored1, ignored2) -> true));
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new EmptyMap<>();
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new EmptyMap<>();
    }

    @Override
    @Test
    public void allSatisfy() {
        MutableMap<String, String> map = this.classUnderTest();
        Assert.assertTrue(map.allSatisfy(ignored -> true));
    }

    @Override
    @Test
    public void anySatisfy() {
        MutableMap<String, String> map = this.classUnderTest();
        Assert.assertFalse(map.anySatisfy(ignored -> true));
    }

    @Override
    @Test
    public void noneSatisfy() {
        MutableMap<String, String> map = this.classUnderTest();
        Assert.assertTrue(map.noneSatisfy(ignored -> true));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(Functions.getStringPassThru());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(Functions.getStringPassThru());
    }

    private static class StubProcedure<T> implements Procedure<T>, Procedure2<T, T>, ObjectIntProcedure<T> {

        private static final long serialVersionUID = 1L;

        private boolean called;

        @Override
        public void value(T each) {
            this.called = true;
        }

        @Override
        public void value(T argument1, T argument2) {
            this.called = true;
        }

        @Override
        public void value(T each, int index) {
            this.called = true;
        }
    }

    @Override
    @Test
    public void forEachValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        map.forEachValue(CollectionAddProcedure.on(collection));
        Verify.assertEmpty(collection);
    }

    @Override
    @Test
    public void forEach() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        map.forEach(CollectionAddProcedure.on(collection));
        Verify.assertEmpty(collection);
    }

    @Override
    @Test
    public void forEachKey() {
        MutableList<Integer> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        map.forEachKey(CollectionAddProcedure.on(collection));
        Verify.assertEmpty(collection);
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, Integer> map = new EmptyMap<>();
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Verify.assertEmpty(result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Verify.assertEmpty(result);
    }

    @Override
    @Test
    public void forEachKeyValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        map.forEachKeyValue((key, value) -> collection.add(key + value));
        Verify.assertEmpty(collection);
    }

    @Override
    @Test
    public void asLazyKeys() {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void asLazyValues() {
        Verify.assertIterableEmpty(this.classUnderTest().valuesView());
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, new PassThruFunction0<>("4")));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWith(4, String::valueOf, 4));
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getOrDefault() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsent() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void ifPresentApply() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(new EmptyMap<Integer, String>().notEmpty());
    }

    @Override
    @Test
    public void entrySet() {
        Verify.assertEmpty(new EmptyMap<Integer, String>().entrySet());
    }

    @Override
    @Test
    public void values() {
        Verify.assertEmpty(new EmptyMap<Integer, String>().values());
    }

    @Override
    @Test
    public void keySet() {
        Verify.assertEmpty(new EmptyMap<Integer, String>().keySet());
    }

    @Override
    @Test
    public void nonUniqueWithKeyValue() {
        // Not applicable for EmptyMap
    }

    @Override
    public void withKeyValue() {
        MutableMap<Integer, String> map = new EmptyMap<Integer, String>().withKeyValue(1, "A");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A"), map);
        Verify.assertInstanceOf(SingletonMap.class, map);
    }

    @Override
    public void withAllKeyValueArguments() {
        MutableMap<Integer, String> map1 = new EmptyMap<Integer, String>().withAllKeyValueArguments(Tuples.pair(1, "A"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A"), map1);
        Verify.assertInstanceOf(SingletonMap.class, map1);
        MutableMap<Integer, String> map2 = new EmptyMap<Integer, String>().withAllKeyValueArguments(Tuples.pair(1, "A"), Tuples.pair(2, "B"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A", 2, "B"), map2);
        Verify.assertInstanceOf(DoubletonMap.class, map2);
    }

    @Override
    public void withoutKey() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        MutableMap<Integer, String> mapWithout = map.withoutKey(1);
        Assert.assertSame(map, mapWithout);
    }

    @Override
    public void withoutAllKeys() {
        MutableMap<Integer, String> map = new EmptyMap<>();
        MutableMap<Integer, String> mapWithout = map.withoutAllKeys(FastList.newListWith(1, 2));
        Assert.assertSame(map, mapWithout);
    }

    @Override
    @Test
    public void iterator() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new EmptyMap<>();
        for (String eachValue : map) {
            collection.add(eachValue);
        }
        Assert.assertEquals(FastList.newListWith(), collection);
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> new EmptyMap<>().getOnly());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private EmptyMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
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
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_viewsEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.viewsEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testReadResolve() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testReadResolve);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterations() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterations);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
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
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
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
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new EmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> put_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> putAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> removeKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> removeAllKeys_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collectKeysAndValues_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> testPostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> viewsEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> testReadResolve;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> iterations;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> nonUniqueWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptyMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.put_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::put_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::putAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::removeKey_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllKeys_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::removeAllKeys_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.collectKeysAndValues_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::collectKeysAndValues_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = EmptyMapTest::asUnmodifiable;
            this.payloads.asSynchronized = EmptyMapTest::asSynchronized;
            this.payloads.newEmpty = EmptyMapTest::newEmpty;
            this.payloads.toImmutable = EmptyMapTest::toImmutable;
            this.payloads.testPostSerializedEqualsAndHashCode = EmptyMapTest::testPostSerializedEqualsAndHashCode;
            this.payloads.collectValues = EmptyMapTest::collectValues;
            this.payloads.collect = EmptyMapTest::collect;
            this.payloads.appendString = EmptyMapTest::appendString;
            this.payloads.toBag = EmptyMapTest::toBag;
            this.payloads.flip = EmptyMapTest::flip;
            this.payloads.asLazy = EmptyMapTest::asLazy;
            this.payloads.toList = EmptyMapTest::toList;
            this.payloads.toMap = EmptyMapTest::toMap;
            this.payloads.toSet = EmptyMapTest::toSet;
            this.payloads.toSortedList = EmptyMapTest::toSortedList;
            this.payloads.toSortedListBy = EmptyMapTest::toSortedListBy;
            this.payloads.chunk = EmptyMapTest::chunk;
            this.payloads.collect_value = EmptyMapTest::collect_value;
            this.payloads.collectIf = EmptyMapTest::collectIf;
            this.payloads.collectWith = EmptyMapTest::collectWith;
            this.payloads.contains = EmptyMapTest::contains;
            this.payloads.getFirst = EmptyMapTest::getFirst;
            this.payloads.getLast = EmptyMapTest::getLast;
            this.payloads.containsAllIterable = EmptyMapTest::containsAllIterable;
            this.payloads.containsAllArguments = EmptyMapTest::containsAllArguments;
            this.payloads.count = EmptyMapTest::count;
            this.payloads.detect_value = EmptyMapTest::detect_value;
            this.payloads.detectIfNone_value = EmptyMapTest::detectIfNone_value;
            this.payloads.flatten_value = EmptyMapTest::flatten_value;
            this.payloads.groupBy = EmptyMapTest::groupBy;
            this.payloads.groupByEach = EmptyMapTest::groupByEach;
            this.payloads.injectInto = EmptyMapTest::injectInto;
            this.payloads.makeString = EmptyMapTest::makeString;
            this.payloads.reject_value = EmptyMapTest::reject_value;
            this.payloads.rejectWith_value = EmptyMapTest::rejectWith_value;
            this.payloads.select_value = EmptyMapTest::select_value;
            this.payloads.selectWith_value = EmptyMapTest::selectWith_value;
            this.payloads.partition_value = EmptyMapTest::partition_value;
            this.payloads.partitionWith_value = EmptyMapTest::partitionWith_value;
            this.payloads.toArray = EmptyMapTest::toArray;
            this.payloads.zip = EmptyMapTest::zip;
            this.payloads.zipWithIndex = EmptyMapTest::zipWithIndex;
            this.payloads.withKeyValue = EmptyMapTest::withKeyValue;
            this.payloads.withAllKeyValueArguments = EmptyMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = EmptyMapTest::withoutKey;
            this.payloads.withoutAllKeys = EmptyMapTest::withoutAllKeys;
            this.payloads.tap = EmptyMapTest::tap;
            this.payloads.containsValue = EmptyMapTest::containsValue;
            this.payloads.size = EmptyMapTest::size;
            this.payloads.empty = EmptyMapTest::empty;
            this.payloads.viewsEmpty = EmptyMapTest::viewsEmpty;
            this.payloads.flipUniqueValues = EmptyMapTest::flipUniqueValues;
            this.payloads.testReadResolve = EmptyMapTest::testReadResolve;
            this.payloads.testClone = EmptyMapTest::testClone;
            this.payloads.iterations = EmptyMapTest::iterations;
            this.payloads.testToString = EmptyMapTest::testToString;
            this.payloads.testEqualsAndHashCode = EmptyMapTest::testEqualsAndHashCode;
            this.payloads.select = EmptyMapTest::select;
            this.payloads.reject = EmptyMapTest::reject;
            this.payloads.detect = EmptyMapTest::detect;
            this.payloads.allSatisfy = EmptyMapTest::allSatisfy;
            this.payloads.anySatisfy = EmptyMapTest::anySatisfy;
            this.payloads.noneSatisfy = EmptyMapTest::noneSatisfy;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::max, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::min, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptyMapTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.forEachValue = EmptyMapTest::forEachValue;
            this.payloads.forEach = EmptyMapTest::forEach;
            this.payloads.forEachKey = EmptyMapTest::forEachKey;
            this.payloads.forEachWith = EmptyMapTest::forEachWith;
            this.payloads.forEachWithIndex = EmptyMapTest::forEachWithIndex;
            this.payloads.forEachKeyValue = EmptyMapTest::forEachKeyValue;
            this.payloads.asLazyKeys = EmptyMapTest::asLazyKeys;
            this.payloads.asLazyValues = EmptyMapTest::asLazyValues;
            this.payloads.getIfAbsentPut = EmptyMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutWith = EmptyMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsent_function = EmptyMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = EmptyMapTest::getOrDefault;
            this.payloads.getIfAbsent = EmptyMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = EmptyMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = EmptyMapTest::ifPresentApply;
            this.payloads.notEmpty = EmptyMapTest::notEmpty;
            this.payloads.entrySet = EmptyMapTest::entrySet;
            this.payloads.values = EmptyMapTest::values;
            this.payloads.keySet = EmptyMapTest::keySet;
            this.payloads.nonUniqueWithKeyValue = EmptyMapTest::nonUniqueWithKeyValue;
            this.payloads.iterator = EmptyMapTest::iterator;
            this.payloads.getOnly = EmptyMapTest::getOnly;
        }
    }
*/
}
