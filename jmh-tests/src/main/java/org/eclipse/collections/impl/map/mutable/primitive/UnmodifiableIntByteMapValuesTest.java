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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedByteCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableByteCollection;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntByteMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableIntByteMapValuesTest extends AbstractMutableByteCollectionTestCase {

    @Override
    protected MutableByteCollection classUnderTest() {
        return IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3).values().asUnmodifiable();
    }

    @Override
    protected MutableByteCollection newWith(byte... elements) {
        IntByteHashMap map = new IntByteHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableByteCollection newMutableCollectionWith(byte... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Byte> newObjectCollectionWith(Byte... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void byteIterator() {
        MutableByteCollection bag = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list = ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteIterator iterator = bag.byteIterator();
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
    public void byteIterator_with_remove() {
        MutableByteCollection byteIterable = this.classUnderTest();
        MutableByteIterator iterator = byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_remove_before_next() {
        MutableByteCollection byteIterable = this.classUnderTest();
        MutableByteIterator iterator = byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((byte) 0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(BytePredicates.equal((byte) 0));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableByteCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableByteCollection.class, collection.asUnmodifiable());
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
        this.newWith().removeAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.newWith().retainAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        MutableByteCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains() {
        MutableByteCollection collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));
        byte[] numbers = { (byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1 };
        for (byte number : numbers) {
            Assert.assertTrue(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));
    }

    @Override
    @Test
    public void reject() {
        ByteIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(1, iterable.reject(BytePredicates.lessThan((byte) 3)));
    }

    @Override
    @Test
    public void select() {
        ByteIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(2, iterable.select(BytePredicates.lessThan((byte) 3)));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ByteToObjectFunction<Byte> function = (byte parameter) -> (byte) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 2).toBag(), this.newWith((byte) 1, (byte) 2, (byte) 3).collect(function).toBag());
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((byte) 2), this.newWith((byte) 3).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1", this.newWith((byte) 1).makeString("/"));
        Assert.assertEquals("31", this.newWith((byte) 31).makeString());
        Assert.assertEquals("32", this.newWith((byte) 32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        ByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        ByteIterable iterable4 = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
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
        this.newWith((byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((byte) 31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((byte) 32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        ByteIterable iterable4 = this.newWith((byte) 32, (byte) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0, 1".equals(appendable10.toString()) || "1, 0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0/1".equals(appendable11.toString()) || "1/0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0/1]".equals(appendable12.toString()) || "[1/0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableByteCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedByteCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable for MutableByteCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableByteCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableByteCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableByteCollection.
    }

    @Override
    @Test
    public void chunk() {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1), ByteBags.mutable.with((byte) 2), ByteBags.mutable.with((byte) 3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<ByteIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2), ByteBags.mutable.with((byte) 3)).toSet().equals(chunked) || Lists.mutable.with(ByteBags.mutable.with((byte) 2, (byte) 3), ByteBags.mutable.with((byte) 1)).toSet().equals(chunked) || Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 3), ByteBags.mutable.with((byte) 2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableIntByteMapValuesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableIntByteMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntByteMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableIntByteMapValuesTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableIntByteMapValuesTest::newCollection;
            this.payloads.isEmpty = UnmodifiableIntByteMapValuesTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableIntByteMapValuesTest::notEmpty;
            this.payloads.tap = UnmodifiableIntByteMapValuesTest::tap;
            this.payloads.containsAllArray = UnmodifiableIntByteMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableIntByteMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableIntByteMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableIntByteMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableIntByteMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableIntByteMapValuesTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableIntByteMapValuesTest::forEach;
            this.payloads.size = UnmodifiableIntByteMapValuesTest::size;
            this.payloads.count = UnmodifiableIntByteMapValuesTest::count;
            this.payloads.anySatisfy = UnmodifiableIntByteMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableIntByteMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableIntByteMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = UnmodifiableIntByteMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableIntByteMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableIntByteMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableIntByteMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableIntByteMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableIntByteMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableIntByteMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = UnmodifiableIntByteMapValuesTest::detectIfNone;
            this.payloads.max = UnmodifiableIntByteMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableIntByteMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableIntByteMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableIntByteMapValuesTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableIntByteMapValuesTest::sum;
            this.payloads.summaryStatistics = UnmodifiableIntByteMapValuesTest::summaryStatistics;
            this.payloads.average = UnmodifiableIntByteMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableIntByteMapValuesTest::averageIfEmpty;
            this.payloads.median = UnmodifiableIntByteMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableIntByteMapValuesTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableIntByteMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableIntByteMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableIntByteMapValuesTest::toSortedArray;
            this.payloads.testHashCode = UnmodifiableIntByteMapValuesTest::testHashCode;
            this.payloads.testToString = UnmodifiableIntByteMapValuesTest::testToString;
            this.payloads.toList = UnmodifiableIntByteMapValuesTest::toList;
            this.payloads.toSortedList = UnmodifiableIntByteMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableIntByteMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableIntByteMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableIntByteMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableIntByteMapValuesTest::toSet;
            this.payloads.toBag = UnmodifiableIntByteMapValuesTest::toBag;
            this.payloads.asLazy = UnmodifiableIntByteMapValuesTest::asLazy;
            this.payloads.injectInto = UnmodifiableIntByteMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableIntByteMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableIntByteMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableIntByteMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableIntByteMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableIntByteMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableIntByteMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableIntByteMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableIntByteMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableIntByteMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableIntByteMapValuesTest::reduceIfEmpty;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.newEmpty = UnmodifiableIntByteMapValuesTest::newEmpty;
            this.payloads.byteIterator = UnmodifiableIntByteMapValuesTest::byteIterator;
            this.payloads.byteIterator_with_remove = UnmodifiableIntByteMapValuesTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = UnmodifiableIntByteMapValuesTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = UnmodifiableIntByteMapValuesTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableIntByteMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntByteMapValuesTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableIntByteMapValuesTest::contains;
            this.payloads.reject = UnmodifiableIntByteMapValuesTest::reject;
            this.payloads.select = UnmodifiableIntByteMapValuesTest::select;
            this.payloads.collect = UnmodifiableIntByteMapValuesTest::collect;
            this.payloads.makeString = UnmodifiableIntByteMapValuesTest::makeString;
            this.payloads.appendString = UnmodifiableIntByteMapValuesTest::appendString;
            this.payloads.asSynchronized = UnmodifiableIntByteMapValuesTest::asSynchronized;
            this.payloads.testEquals = UnmodifiableIntByteMapValuesTest::testEquals;
            this.payloads.chunk = UnmodifiableIntByteMapValuesTest::chunk;
        }
    }
}
