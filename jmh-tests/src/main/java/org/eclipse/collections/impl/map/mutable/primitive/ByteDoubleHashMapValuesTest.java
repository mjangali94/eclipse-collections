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
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedDoubleCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableDoubleCollection;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteDoubleHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class ByteDoubleHashMapValuesTest extends AbstractMutableDoubleCollectionTestCase {

    @Override
    protected MutableDoubleCollection classUnderTest() {
        return ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0).values();
    }

    @Override
    protected MutableDoubleCollection newWith(double... elements) {
        ByteDoubleHashMap map = new ByteDoubleHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((byte) i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableDoubleCollection newMutableCollectionWith(double... elements) {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Double> newObjectCollectionWith(Double... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void doubleIterator() {
        MutableDoubleCollection bag = this.newWith(0.0, 1.0, 2.0, 3.0);
        DoubleArrayList list = DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0);
        DoubleIterator iterator = bag.doubleIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0);
    }

    @Override
    @Test
    public void testEquals_NaN() {
        // Testing equals() is not applicable for MutableDoubleCollection.
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new DoubleArrayList());
    }

    @Override
    @Test
    public void remove() {
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertTrue(collection.remove(3.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
    }

    @Override
    @Test
    public void removeIf() {
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(DoublePredicates.equal(3.0)));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertFalse(collection.removeIf(DoublePredicates.equal(3.0)));
    }

    @Override
    @Test
    public void sumConsistentRounding() {
        DoubleIterable iterable = this.newWith(Interval.fromTo(Byte.MIN_VALUE, Byte.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0).collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).toArray());
        Assert.assertEquals(2.1646461495114355, iterable.sum(), 1.0e-15);
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableDoubleCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedDoubleCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableDoubleCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0));
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(1.0, 5.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertTrue(collection.removeAll(3.0, 2.0));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
        map = ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 2, 2.0, (byte) 3, 3.0);
        collection = map.values();
        Assert.assertTrue(collection.removeAll(0.0, 5.0));
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new DoubleArrayList()));
        Assert.assertFalse(this.newWith().removeAll(DoubleArrayList.newListWith(1.0)));
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(DoubleArrayList.newListWith(1.0, 5.0)));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertTrue(collection.removeAll(DoubleArrayList.newListWith(3.0, 2.0)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1.0));
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(0.0, 1.0, 2.0, 3.0));
        Assert.assertTrue(collection.retainAll(0.0, 2.0, 3.0, 5.0));
        Assert.assertTrue(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertTrue(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(2.0, 3.0, 5.0));
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(3.0, 5.0));
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(0.0, 0.0, 1.0));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new DoubleArrayList()));
        Assert.assertFalse(this.newWith().retainAll(DoubleArrayList.newListWith(1.0)));
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0)));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(0.0, 2.0, 3.0, 5.0)));
        Assert.assertTrue(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertTrue(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(2.0, 3.0, 5.0)));
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(3.0, 5.0)));
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(0.0, 0.0, 1.0)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(collection.contains(5.0));
        Assert.assertFalse(map.contains(0.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertFalse(map.contains(5.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableDoubleCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        ByteDoubleHashMap map = ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        MutableDoubleCollection collection1 = this.newWith(0.0, 1.0, 31.0, 32.0);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0.0));
        Assert.assertFalse(collection1.contains(1.0));
        Assert.assertFalse(collection1.contains(31.0));
        Assert.assertFalse(collection1.contains(32.0));
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 2.0);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableDoubleCollection collection = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
        double[] numbers = { 14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0 };
        for (double number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
    }

    @Override
    @Test
    public void reject() {
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(1, iterable.reject(DoublePredicates.lessThan(3.0)));
    }

    @Override
    @Test
    public void select() {
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(2, iterable.select(DoublePredicates.lessThan(3.0)));
    }

    @Override
    @Test
    public void collect() {
        DoubleToObjectFunction<Double> function = (double parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 2.0).toBag(), this.newWith(1.0, 2.0, 3.0).collect(function).toBag());
        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 2.0).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0), this.newWith(3.0).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1.0", this.newWith(1.0).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        DoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        DoubleIterable iterable4 = this.newWith(1.0, 2.0);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
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
        this.newWith(1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        DoubleIterable iterable = this.newWith(1.0, 2.0);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        DoubleIterable iterable4 = this.newWith(32.0, 33.0);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
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
    public void testEquals() {
        // Testing equals() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableDoubleCollection.
    }

    @Override
    @Test
    public void chunk() {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0), DoubleBags.mutable.with(2.0), DoubleBags.mutable.with(3.0)).toSet(), iterable.chunk(1).toSet());
        MutableSet<DoubleIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0), DoubleBags.mutable.with(3.0)).toSet().equals(chunked) || Lists.mutable.with(DoubleBags.mutable.with(2.0, 3.0), DoubleBags.mutable.with(1.0)).toSet().equals(chunked) || Lists.mutable.with(DoubleBags.mutable.with(1.0, 3.0), DoubleBags.mutable.with(2.0)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteDoubleHashMapValuesTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ByteDoubleHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteDoubleHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = ByteDoubleHashMapValuesTest::newCollection;
            this.payloads.isEmpty = ByteDoubleHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = ByteDoubleHashMapValuesTest::notEmpty;
            this.payloads.tap = ByteDoubleHashMapValuesTest::tap;
            this.payloads.contains_NaN = ByteDoubleHashMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ByteDoubleHashMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ByteDoubleHashMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ByteDoubleHashMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = ByteDoubleHashMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = ByteDoubleHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ByteDoubleHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteDoubleHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteDoubleHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteDoubleHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteDoubleHashMapValuesTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteDoubleHashMapValuesTest::forEach;
            this.payloads.size = ByteDoubleHashMapValuesTest::size;
            this.payloads.count = ByteDoubleHashMapValuesTest::count;
            this.payloads.anySatisfy = ByteDoubleHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = ByteDoubleHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ByteDoubleHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ByteDoubleHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteDoubleHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteDoubleHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteDoubleHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteDoubleHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ByteDoubleHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ByteDoubleHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ByteDoubleHashMapValuesTest::detectIfNone;
            this.payloads.max = ByteDoubleHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteDoubleHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteDoubleHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteDoubleHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = ByteDoubleHashMapValuesTest::sum;
            this.payloads.summaryStatistics = ByteDoubleHashMapValuesTest::summaryStatistics;
            this.payloads.average = ByteDoubleHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteDoubleHashMapValuesTest::averageIfEmpty;
            this.payloads.median = ByteDoubleHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteDoubleHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = ByteDoubleHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteDoubleHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ByteDoubleHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = ByteDoubleHashMapValuesTest::testHashCode;
            this.payloads.testToString = ByteDoubleHashMapValuesTest::testToString;
            this.payloads.toList = ByteDoubleHashMapValuesTest::toList;
            this.payloads.toSortedList = ByteDoubleHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteDoubleHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteDoubleHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteDoubleHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteDoubleHashMapValuesTest::toSet;
            this.payloads.toBag = ByteDoubleHashMapValuesTest::toBag;
            this.payloads.asLazy = ByteDoubleHashMapValuesTest::asLazy;
            this.payloads.injectInto = ByteDoubleHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ByteDoubleHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteDoubleHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteDoubleHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteDoubleHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteDoubleHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteDoubleHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteDoubleHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteDoubleHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteDoubleHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = ByteDoubleHashMapValuesTest::reduceIfEmpty;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = ByteDoubleHashMapValuesTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = ByteDoubleHashMapValuesTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = ByteDoubleHashMapValuesTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteDoubleHashMapValuesTest::newEmpty;
            this.payloads.doubleIterator = ByteDoubleHashMapValuesTest::doubleIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = ByteDoubleHashMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ByteDoubleHashMapValuesTest::remove;
            this.payloads.removeIf = ByteDoubleHashMapValuesTest::removeIf;
            this.payloads.sumConsistentRounding = ByteDoubleHashMapValuesTest::sumConsistentRounding;
            this.payloads.asSynchronized = ByteDoubleHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteDoubleHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = ByteDoubleHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = ByteDoubleHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = ByteDoubleHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = ByteDoubleHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = ByteDoubleHashMapValuesTest::clear;
            this.payloads.contains = ByteDoubleHashMapValuesTest::contains;
            this.payloads.reject = ByteDoubleHashMapValuesTest::reject;
            this.payloads.select = ByteDoubleHashMapValuesTest::select;
            this.payloads.collect = ByteDoubleHashMapValuesTest::collect;
            this.payloads.makeString = ByteDoubleHashMapValuesTest::makeString;
            this.payloads.appendString = ByteDoubleHashMapValuesTest::appendString;
            this.payloads.testEquals = ByteDoubleHashMapValuesTest::testEquals;
            this.payloads.chunk = ByteDoubleHashMapValuesTest::chunk;
        }
    }
}
