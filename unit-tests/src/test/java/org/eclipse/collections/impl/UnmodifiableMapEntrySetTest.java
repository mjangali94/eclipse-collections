/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.Iterator;
import java.util.Map;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.set.mutable.SetAdapter;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link UnmodifiableMap#entrySet()} .
 */
public class UnmodifiableMapEntrySetTest extends UnmodifiableMutableCollectionTestCase<Map.Entry<String, String>> {

    @Override
    protected MutableSet<Map.Entry<String, String>> getCollection() {
        return SetAdapter.adapt(new UnmodifiableMap<>(Maps.mutable.of("1", "1", "2", "2")).entrySet());
    }

    private MutableSet<Map.Entry<String, String>> newCollection() {
        return SetAdapter.adapt(new UnmodifiableMap<>(Maps.mutable.<String, String>of()).entrySet());
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void removeIf() {
        this.getCollection().removeIf(Predicates.cast(null));
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void removeIfWith() {
        this.getCollection().removeIfWith(null, null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void addAll() {
        this.getCollection().addAll(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void addAllIterable() {
        this.getCollection().addAllIterable(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void removeAll() {
        this.getCollection().removeAll(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void removeAllIterable() {
        this.getCollection().removeAllIterable(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void retainAll() {
        this.getCollection().retainAll(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void retainAllIterable() {
        this.getCollection().retainAllIterable(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void withAll() {
        this.getCollection().withAll(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void withoutAll() {
        this.getCollection().withAll(null);
    }

    @Test
    public void testNewCollection() {
        MutableSet<Map.Entry<String, String>> collection = this.newCollection();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.newWith(1, 2, 3), this.newWith(1, 2, 3));
        Assert.assertNotEquals(this.newWith(1, 2, 3), this.newWith(1, 2));
    }

    @Override
    @Test
    public void newEmpty() {
        MutableSet<Map.Entry<String, String>> collection = this.newCollection().newEmpty();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.notEmpty());
    }

    @Test
    public void toImmutable() {
        Verify.assertInstanceOf(ImmutableCollection.class, this.newCollection().toImmutable());
    }

    private <T> MutableSet<Map.Entry<T, T>> newWith(T one) {
        MutableMap<T, T> map = Maps.mutable.of(one, one);
        return SetAdapter.adapt(new UnmodifiableMap<>(map).entrySet());
    }

    private <T> MutableSet<Map.Entry<T, T>> newWith(T one, T two) {
        MutableMap<T, T> map = Maps.mutable.of(one, one, two, two);
        return SetAdapter.adapt(new UnmodifiableMap<>(map).entrySet());
    }

    private <T> MutableSet<Map.Entry<T, T>> newWith(T one, T two, T three) {
        MutableMap<T, T> map = Maps.mutable.of(one, one, two, two, three, three);
        return SetAdapter.adapt(new UnmodifiableMap<>(map).entrySet());
    }

    private <T> MutableSet<Map.Entry<T, T>> newWith(T... littleElements) {
        MutableMap<T, T> map = Maps.mutable.of();
        for (int i = 0; i < littleElements.length; i++) {
            map.put(littleElements[i], littleElements[i]);
        }
        return SetAdapter.adapt(new UnmodifiableMap<>(map).entrySet());
    }

    @Test
    public void testNewWith() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(1, collection);
        Verify.assertContains(this.entry(1), collection);
    }

    @Test
    public void testNewWithWith() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(2, collection);
        Verify.assertContainsAll(collection, this.entry(1), this.entry(2));
    }

    @Test
    public void testNewWithWithWith() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2, 3);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(3, collection);
        Verify.assertContainsAll(collection, this.entry(1), this.entry(2), this.entry(3));
    }

    @Test
    public void testNewWithVarArgs() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2, 3, 4);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(4, collection);
        Verify.assertContainsAll(collection, this.entry(1), this.entry(2), this.entry(3), this.entry(4));
    }

    @Test
    public void containsAllIterable() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAllIterable(Lists.immutable.of(this.entry(1), this.entry(2))));
        Assert.assertFalse(collection.containsAllIterable(Lists.immutable.of(this.entry(1), this.entry(5))));
    }

    @Test
    public void containsAllArray() {
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAllArguments(this.entry(1), this.entry(2)));
        Assert.assertFalse(collection.containsAllArguments(this.entry(1), this.entry(5)));
    }

    @Test
    public void forEach() {
        MutableList<Map.Entry<Integer, Integer>> result = Lists.mutable.of();
        MutableSet<Map.Entry<Integer, Integer>> collection = this.newWith(1, 2, 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, this.entry(1), this.entry(2), this.entry(3), this.entry(4));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newCollection());
        Verify.assertNotEmpty(this.newWith(1, 2));
        Assert.assertTrue(this.newWith(1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        MutableSet<Map.Entry<Integer, Integer>> objects = this.newWith(1, 2, 3);
        Iterator<Map.Entry<Integer, Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Assert.assertEquals(ImmutableEntry.of(3 - i, 3 - i), entry);
            Assert.assertThrows(UnsupportedOperationException.class, () -> entry.setValue(0));
        }
    }

    @Test
    public void toArray() {
        MutableSet<Map.Entry<Integer, Integer>> objects = this.newWith(1, 2, 3);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        Map.Entry<Integer, Integer>[] array2 = objects.toArray(new Map.Entry[3]);
        Verify.assertSize(3, array2);
    }

    private ImmutableEntry<Integer, Integer> entry(int i) {
        return ImmutableEntry.of(i, i);
    }

    @Override
    @Test
    public void collectBoolean() {
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.getCollection().collectBoolean(entry -> Boolean.parseBoolean(entry.getValue())));
    }

    @Override
    @Test
    public void collectByte() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), this.getCollection().collectByte(entry -> Byte.parseByte(entry.getValue())));
    }

    @Override
    @Test
    public void collectChar() {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), this.getCollection().collectChar(entry -> (char) Integer.parseInt(entry.getValue())));
    }

    @Override
    @Test
    public void collectDouble() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0d, 2.0d), this.getCollection().collectDouble(entry -> Double.parseDouble(entry.getValue())));
    }

    @Override
    @Test
    public void collectFloat() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), this.getCollection().collectFloat(entry -> Float.parseFloat(entry.getValue())));
    }

    @Override
    @Test
    public void collectInt() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2), this.getCollection().collectInt(entry -> Integer.parseInt(entry.getValue())));
    }

    @Override
    @Test
    public void collectLong() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), this.getCollection().collectLong(entry -> Long.parseLong(entry.getValue())));
    }

    @Override
    @Test
    public void collectShort() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), this.getCollection().collectShort(entry -> Short.parseShort(entry.getValue())));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIf, this.description("removeIf"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIfWith, this.description("removeIfWith"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAll, this.description("addAll"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAll, this.description("removeAll"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAllIterable, this.description("removeAllIterable"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAll, this.description("retainAll"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAllIterable, this.description("retainAllIterable"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withAll, this.description("withAll"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withoutAll, this.description("withoutAll"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewCollection, this.description("testNewCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWith, this.description("testNewWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithWith, this.description("testNewWithWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithWithWith, this.description("testNewWithWithWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithVarArgs, this.description("testNewWithVarArgs"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        private UnmodifiableMapEntrySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableMapEntrySetTest();
        }

        @java.lang.Override
        public UnmodifiableMapEntrySetTest implementation() {
            return this.implementation;
        }
    }
}
