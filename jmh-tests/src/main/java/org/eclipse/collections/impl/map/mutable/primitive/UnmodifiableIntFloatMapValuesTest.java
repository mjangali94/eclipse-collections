/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableFloatCollection;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntFloatMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableIntFloatMapValuesTest extends AbstractMutableFloatCollectionTestCase {

    @Override
    protected MutableFloatCollection classUnderTest() {
        return IntFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f).values().asUnmodifiable();
    }

    @Override
    protected MutableFloatCollection newWith(float... elements) {
        IntFloatHashMap map = new IntFloatHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableFloatCollection newMutableCollectionWith(float... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Float> newObjectCollectionWith(Float... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void floatIterator() {
        MutableFloatCollection bag = this.newWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatIterator iterator = bag.floatIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void floatIterator_with_remove() {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_remove_before_next() {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0f);
    }

    @Override
    @Test
    public void testEquals_NaN() {
        // Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(FloatPredicates.equal(0.0f));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableFloatCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.newWith().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.newWith().removeAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.newWith().retainAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        MutableFloatCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains() {
        MutableFloatCollection collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
        float[] numbers = { 14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f };
        for (float number : numbers) {
            Assert.assertTrue(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
    }

    @Override
    @Test
    public void reject() {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(1, iterable.reject(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void select() {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(2, iterable.select(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        FloatToObjectFunction<Float> function = (float parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), this.newWith(1.0f, 2.0f, 3.0f).collect(function).toBag());
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0f), this.newWith(3.0f).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1.0", this.newWith(1.0f).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0f).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0f).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        FloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        FloatIterable iterable4 = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0.0, 1.0") || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0.0/1.0]") || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0.0/1.0") || iterable5.makeString("/").equals("1.0/0.0"));
    }

    @Override
    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0f).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0f).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        FloatIterable iterable4 = this.newWith(32.0f, 33.0f);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString()) || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString()) || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString()) || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableFloatCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedFloatCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableFloatCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test
    public void chunk() {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f), FloatBags.mutable.with(2.0f), FloatBags.mutable.with(3.0f)).toSet(), iterable.chunk(1).toSet());
        MutableSet<FloatIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f), FloatBags.mutable.with(3.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatBags.mutable.with(2.0f, 3.0f), FloatBags.mutable.with(1.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatBags.mutable.with(1.0f, 3.0f), FloatBags.mutable.with(2.0f)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableIntFloatMapValuesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
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
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableIntFloatMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntFloatMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableIntFloatMapValuesTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableIntFloatMapValuesTest::newCollection;
            this.payloads.isEmpty = UnmodifiableIntFloatMapValuesTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableIntFloatMapValuesTest::notEmpty;
            this.payloads.tap = UnmodifiableIntFloatMapValuesTest::tap;
            this.payloads.contains_NaN = UnmodifiableIntFloatMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = UnmodifiableIntFloatMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = UnmodifiableIntFloatMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = UnmodifiableIntFloatMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = UnmodifiableIntFloatMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = UnmodifiableIntFloatMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableIntFloatMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableIntFloatMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableIntFloatMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableIntFloatMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableIntFloatMapValuesTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableIntFloatMapValuesTest::forEach;
            this.payloads.size = UnmodifiableIntFloatMapValuesTest::size;
            this.payloads.count = UnmodifiableIntFloatMapValuesTest::count;
            this.payloads.anySatisfy = UnmodifiableIntFloatMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableIntFloatMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableIntFloatMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = UnmodifiableIntFloatMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableIntFloatMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableIntFloatMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableIntFloatMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableIntFloatMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableIntFloatMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableIntFloatMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = UnmodifiableIntFloatMapValuesTest::detectIfNone;
            this.payloads.max = UnmodifiableIntFloatMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableIntFloatMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableIntFloatMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableIntFloatMapValuesTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableIntFloatMapValuesTest::sum;
            this.payloads.summaryStatistics = UnmodifiableIntFloatMapValuesTest::summaryStatistics;
            this.payloads.sumConsistentRounding = UnmodifiableIntFloatMapValuesTest::sumConsistentRounding;
            this.payloads.average = UnmodifiableIntFloatMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableIntFloatMapValuesTest::averageIfEmpty;
            this.payloads.median = UnmodifiableIntFloatMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableIntFloatMapValuesTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableIntFloatMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableIntFloatMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableIntFloatMapValuesTest::toSortedArray;
            this.payloads.testHashCode = UnmodifiableIntFloatMapValuesTest::testHashCode;
            this.payloads.testToString = UnmodifiableIntFloatMapValuesTest::testToString;
            this.payloads.toList = UnmodifiableIntFloatMapValuesTest::toList;
            this.payloads.toSortedList = UnmodifiableIntFloatMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableIntFloatMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableIntFloatMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableIntFloatMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableIntFloatMapValuesTest::toSet;
            this.payloads.toBag = UnmodifiableIntFloatMapValuesTest::toBag;
            this.payloads.asLazy = UnmodifiableIntFloatMapValuesTest::asLazy;
            this.payloads.injectInto = UnmodifiableIntFloatMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableIntFloatMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableIntFloatMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableIntFloatMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableIntFloatMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableIntFloatMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableIntFloatMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableIntFloatMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableIntFloatMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableIntFloatMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableIntFloatMapValuesTest::reduceIfEmpty;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.newEmpty = UnmodifiableIntFloatMapValuesTest::newEmpty;
            this.payloads.floatIterator = UnmodifiableIntFloatMapValuesTest::floatIterator;
            this.payloads.floatIterator_with_remove = UnmodifiableIntFloatMapValuesTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = UnmodifiableIntFloatMapValuesTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = UnmodifiableIntFloatMapValuesTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = UnmodifiableIntFloatMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableIntFloatMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntFloatMapValuesTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableIntFloatMapValuesTest::contains;
            this.payloads.reject = UnmodifiableIntFloatMapValuesTest::reject;
            this.payloads.select = UnmodifiableIntFloatMapValuesTest::select;
            this.payloads.collect = UnmodifiableIntFloatMapValuesTest::collect;
            this.payloads.makeString = UnmodifiableIntFloatMapValuesTest::makeString;
            this.payloads.appendString = UnmodifiableIntFloatMapValuesTest::appendString;
            this.payloads.asSynchronized = UnmodifiableIntFloatMapValuesTest::asSynchronized;
            this.payloads.testEquals = UnmodifiableIntFloatMapValuesTest::testEquals;
            this.payloads.chunk = UnmodifiableIntFloatMapValuesTest::chunk;
        }
    }
}
