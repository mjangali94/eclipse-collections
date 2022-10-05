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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedCharCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableCharCollection;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleCharMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableDoubleCharMapValuesTest extends AbstractMutableCharCollectionTestCase {

    @Override
    protected MutableCharCollection classUnderTest() {
        return DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3).values().asUnmodifiable();
    }

    @Override
    protected MutableCharCollection newWith(char... elements) {
        DoubleCharHashMap map = new DoubleCharHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableCharCollection newMutableCollectionWith(char... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Character> newObjectCollectionWith(Character... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void charIterator() {
        MutableCharCollection bag = this.newWith((char) 0, (char) 1, (char) 2, (char) 3);
        CharArrayList list = CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3);
        CharIterator iterator = bag.charIterator();
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
    public void charIterator_with_remove() {
        MutableCharCollection charIterable = this.classUnderTest();
        MutableCharIterator iterator = charIterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_remove_before_next() {
        MutableCharCollection charIterable = this.classUnderTest();
        MutableCharIterator iterator = charIterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((char) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(CharPredicates.equal((char) 0));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableCharCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableCharCollection.class, collection.asUnmodifiable());
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
        this.newWith().removeAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.newWith().retainAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        MutableCharCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains() {
        MutableCharCollection collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
        char[] numbers = { (char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1 };
        for (char number : numbers) {
            Assert.assertTrue(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
    }

    @Override
    @Test
    public void reject() {
        CharIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(1, iterable.reject(CharPredicates.lessThan((char) 3)));
    }

    @Override
    @Test
    public void select() {
        CharIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(2, iterable.select(CharPredicates.lessThan((char) 3)));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        CharToObjectFunction<Character> function = (char parameter) -> (char) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 2).toBag(), this.newWith((char) 1, (char) 2, (char) 3).collect(function).toBag());
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((char) 2), this.newWith((char) 3).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("\u0001", this.newWith((char) 1).makeString("/"));
        Assert.assertEquals("\u001f", this.newWith((char) 31).makeString());
        Assert.assertEquals("\u0020", this.newWith((char) 32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("\u0000, \u001f") || iterable1.makeString().equals("\u001f, \u0000"));
        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[\u001f/\u0020]") || iterable2.makeString("[", "/", "]").equals("[\u0020/\u001f]"));
        CharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("\u0020/\u0021") || iterable3.makeString("/").equals("\u0021/\u0020"));
        CharIterable iterable4 = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("\u0001, \u0002".equals(iterable4.makeString()) || "\u0002, \u0001".equals(iterable4.makeString()));
        Assert.assertTrue("\u0001/\u0002".equals(iterable4.makeString("/")) || "\u0002/\u0001".equals(iterable4.makeString("/")));
        Assert.assertTrue("[\u0001/\u0002]".equals(iterable4.makeString("[", "/", "]")) || "[\u0002/\u0001]".equals(iterable4.makeString("[", "/", "]")));
        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("\u0000, \u0001") || iterable5.makeString().equals("\u0001, \u0000"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[\u0000/\u0001]") || iterable5.makeString("[", "/", "]").equals("[\u0001/\u0000]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("\u0000/\u0001") || iterable5.makeString("/").equals("\u0001/\u0000"));
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
        this.newWith((char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        CharIterable iterable = this.newWith((char) 1, (char) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("\u0001, \u0002".equals(appendable2.toString()) || "\u0002, \u0001".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("\u0001/\u0002".equals(appendable3.toString()) || "\u0002/\u0001".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((char) 31).appendString(appendable5);
        Assert.assertEquals("\u001f", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((char) 32).appendString(appendable6);
        Assert.assertEquals("\u0020", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "\u0000, \u001f".equals(appendable7.toString()) || "\u001f, \u0000".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "\u001f/\u0020".equals(appendable8.toString()) || "\u0020/\u001f".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        CharIterable iterable4 = this.newWith((char) 32, (char) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[\u0020/\u0021]".equals(appendable9.toString()) || "[\u0021/\u0020]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "\u0000, \u0001".equals(appendable10.toString()) || "\u0001, \u0000".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "\u0000/\u0001".equals(appendable11.toString()) || "\u0001/\u0000".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[\u0000/\u0001]".equals(appendable12.toString()) || "[\u0001/\u0000]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableCharCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedCharCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable for MutableCharCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableCharCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableCharCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableCharCollection.
    }

    @Override
    @Test
    public void chunk() {
        CharIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1), CharBags.mutable.with((char) 2), CharBags.mutable.with((char) 3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<CharIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2), CharBags.mutable.with((char) 3)).toSet().equals(chunked) || Lists.mutable.with(CharBags.mutable.with((char) 2, (char) 3), CharBags.mutable.with((char) 1)).toSet().equals(chunked) || Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 3), CharBags.mutable.with((char) 2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableDoubleCharMapValuesTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableDoubleCharMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleCharMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableDoubleCharMapValuesTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableDoubleCharMapValuesTest::newCollection;
            this.payloads.isEmpty = UnmodifiableDoubleCharMapValuesTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableDoubleCharMapValuesTest::notEmpty;
            this.payloads.tap = UnmodifiableDoubleCharMapValuesTest::tap;
            this.payloads.containsAllArray = UnmodifiableDoubleCharMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableDoubleCharMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableDoubleCharMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableDoubleCharMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableDoubleCharMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableDoubleCharMapValuesTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableDoubleCharMapValuesTest::forEach;
            this.payloads.size = UnmodifiableDoubleCharMapValuesTest::size;
            this.payloads.count = UnmodifiableDoubleCharMapValuesTest::count;
            this.payloads.anySatisfy = UnmodifiableDoubleCharMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableDoubleCharMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableDoubleCharMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = UnmodifiableDoubleCharMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableDoubleCharMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableDoubleCharMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableDoubleCharMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableDoubleCharMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableDoubleCharMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableDoubleCharMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = UnmodifiableDoubleCharMapValuesTest::detectIfNone;
            this.payloads.max = UnmodifiableDoubleCharMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableDoubleCharMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableDoubleCharMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableDoubleCharMapValuesTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableDoubleCharMapValuesTest::sum;
            this.payloads.summaryStatistics = UnmodifiableDoubleCharMapValuesTest::summaryStatistics;
            this.payloads.average = UnmodifiableDoubleCharMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableDoubleCharMapValuesTest::averageIfEmpty;
            this.payloads.median = UnmodifiableDoubleCharMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableDoubleCharMapValuesTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableDoubleCharMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableDoubleCharMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableDoubleCharMapValuesTest::toSortedArray;
            this.payloads.testHashCode = UnmodifiableDoubleCharMapValuesTest::testHashCode;
            this.payloads.testToString = UnmodifiableDoubleCharMapValuesTest::testToString;
            this.payloads.toList = UnmodifiableDoubleCharMapValuesTest::toList;
            this.payloads.toSortedList = UnmodifiableDoubleCharMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableDoubleCharMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableDoubleCharMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableDoubleCharMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableDoubleCharMapValuesTest::toSet;
            this.payloads.toBag = UnmodifiableDoubleCharMapValuesTest::toBag;
            this.payloads.asLazy = UnmodifiableDoubleCharMapValuesTest::asLazy;
            this.payloads.injectInto = UnmodifiableDoubleCharMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableDoubleCharMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableDoubleCharMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableDoubleCharMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableDoubleCharMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableDoubleCharMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableDoubleCharMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableDoubleCharMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableDoubleCharMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableDoubleCharMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableDoubleCharMapValuesTest::reduceIfEmpty;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.newEmpty = UnmodifiableDoubleCharMapValuesTest::newEmpty;
            this.payloads.charIterator = UnmodifiableDoubleCharMapValuesTest::charIterator;
            this.payloads.charIterator_with_remove = UnmodifiableDoubleCharMapValuesTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = UnmodifiableDoubleCharMapValuesTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = UnmodifiableDoubleCharMapValuesTest::charIterator_throws_for_consecutive_remove;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableDoubleCharMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleCharMapValuesTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableDoubleCharMapValuesTest::contains;
            this.payloads.reject = UnmodifiableDoubleCharMapValuesTest::reject;
            this.payloads.select = UnmodifiableDoubleCharMapValuesTest::select;
            this.payloads.collect = UnmodifiableDoubleCharMapValuesTest::collect;
            this.payloads.makeString = UnmodifiableDoubleCharMapValuesTest::makeString;
            this.payloads.appendString = UnmodifiableDoubleCharMapValuesTest::appendString;
            this.payloads.asSynchronized = UnmodifiableDoubleCharMapValuesTest::asSynchronized;
            this.payloads.testEquals = UnmodifiableDoubleCharMapValuesTest::testEquals;
            this.payloads.chunk = UnmodifiableDoubleCharMapValuesTest::chunk;
        }
    }
}
