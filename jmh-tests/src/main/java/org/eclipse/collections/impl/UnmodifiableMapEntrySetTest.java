/*
 * Copyright (c) 2021 Goldman Sachs.
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
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMapEntrySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAppendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAppendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMapEntrySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMapEntrySetTest> collectShort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = UnmodifiableMapEntrySetTest::testMakeString;
            this.payloads.testAppendString = UnmodifiableMapEntrySetTest::testAppendString;
            this.payloads.select = UnmodifiableMapEntrySetTest::select;
            this.payloads.selectWith = UnmodifiableMapEntrySetTest::selectWith;
            this.payloads.reject = UnmodifiableMapEntrySetTest::reject;
            this.payloads.rejectWith = UnmodifiableMapEntrySetTest::rejectWith;
            this.payloads.partition = UnmodifiableMapEntrySetTest::partition;
            this.payloads.partitionWith = UnmodifiableMapEntrySetTest::partitionWith;
            this.payloads.collect = UnmodifiableMapEntrySetTest::collect;
            this.payloads.collectWith = UnmodifiableMapEntrySetTest::collectWith;
            this.payloads.collectIf = UnmodifiableMapEntrySetTest::collectIf;
            this.payloads.groupBy = UnmodifiableMapEntrySetTest::groupBy;
            this.payloads.zip = UnmodifiableMapEntrySetTest::zip;
            this.payloads.zipWithIndex = UnmodifiableMapEntrySetTest::zipWithIndex;
            this.payloads.flatCollect = UnmodifiableMapEntrySetTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = UnmodifiableMapEntrySetTest::tap;
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::removeIf, java.lang.NullPointerException.class);
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::removeIfWith, java.lang.NullPointerException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::addAll, java.lang.NullPointerException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::addAllIterable, java.lang.NullPointerException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::removeAll, java.lang.NullPointerException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::removeAllIterable, java.lang.NullPointerException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::retainAll, java.lang.NullPointerException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::retainAllIterable, java.lang.NullPointerException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::withAll, java.lang.NullPointerException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMapEntrySetTest::withoutAll, java.lang.NullPointerException.class);
            this.payloads.testNewCollection = UnmodifiableMapEntrySetTest::testNewCollection;
            this.payloads.equalsAndHashCode = UnmodifiableMapEntrySetTest::equalsAndHashCode;
            this.payloads.newEmpty = UnmodifiableMapEntrySetTest::newEmpty;
            this.payloads.toImmutable = UnmodifiableMapEntrySetTest::toImmutable;
            this.payloads.testNewWith = UnmodifiableMapEntrySetTest::testNewWith;
            this.payloads.testNewWithWith = UnmodifiableMapEntrySetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnmodifiableMapEntrySetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnmodifiableMapEntrySetTest::testNewWithVarArgs;
            this.payloads.containsAllIterable = UnmodifiableMapEntrySetTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableMapEntrySetTest::containsAllArray;
            this.payloads.forEach = UnmodifiableMapEntrySetTest::forEach;
            this.payloads.isEmpty = UnmodifiableMapEntrySetTest::isEmpty;
            this.payloads.iterator = UnmodifiableMapEntrySetTest::iterator;
            this.payloads.toArray = UnmodifiableMapEntrySetTest::toArray;
            this.payloads.collectBoolean = UnmodifiableMapEntrySetTest::collectBoolean;
            this.payloads.collectByte = UnmodifiableMapEntrySetTest::collectByte;
            this.payloads.collectChar = UnmodifiableMapEntrySetTest::collectChar;
            this.payloads.collectDouble = UnmodifiableMapEntrySetTest::collectDouble;
            this.payloads.collectFloat = UnmodifiableMapEntrySetTest::collectFloat;
            this.payloads.collectInt = UnmodifiableMapEntrySetTest::collectInt;
            this.payloads.collectLong = UnmodifiableMapEntrySetTest::collectLong;
            this.payloads.collectShort = UnmodifiableMapEntrySetTest::collectShort;
        }
    }

}
