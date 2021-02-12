/*
 * Copyright (c) 2016 Goldman Sachs.
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_viewsEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::viewsEmpty, this.description("viewsEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testReadResolve() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testReadResolve, this.description("testReadResolve"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterations() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterations, this.description("iterations"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqualsAndHashCode, this.description("testEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max, this.description("max"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxBy, this.description("maxBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min, this.description("min"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minBy, this.description("minBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachValue, this.description("forEachValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKey, this.description("forEachKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValue, this.description("forEachKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazyKeys, this.description("asLazyKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazyValues, this.description("asLazyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent_function, this.description("getIfAbsent_function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrDefault, this.description("getOrDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentWith, this.description("getIfAbsentWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ifPresentApply, this.description("ifPresentApply"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySet, this.description("entrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::values, this.description("values"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::nonUniqueWithKeyValue, this.description("nonUniqueWithKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        private EmptyMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new EmptyMapTest();
        }

        @java.lang.Override
        public EmptyMapTest implementation() {
            return this.implementation;
        }
    }
}
