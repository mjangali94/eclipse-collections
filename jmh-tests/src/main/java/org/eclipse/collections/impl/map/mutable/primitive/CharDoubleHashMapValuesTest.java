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
 * JUnit test for {@link CharDoubleHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class CharDoubleHashMapValuesTest extends AbstractMutableDoubleCollectionTestCase {

    @Override
    protected MutableDoubleCollection classUnderTest() {
        return CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0).values();
    }

    @Override
    protected MutableDoubleCollection newWith(double... elements) {
        CharDoubleHashMap map = new CharDoubleHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((char) i, elements[i]);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        DoubleIterable iterable = this.newWith(Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0).collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).toArray());
        Assert.assertEquals(1.082323233711138, iterable.sum(), 1.0e-15);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        map = CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 2, 2.0, (char) 3, 3.0);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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
        CharDoubleHashMap map = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
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

        private CharDoubleHashMapValuesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new CharDoubleHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharDoubleHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = CharDoubleHashMapValuesTest::newCollection;
            this.payloads.isEmpty = CharDoubleHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = CharDoubleHashMapValuesTest::notEmpty;
            this.payloads.tap = CharDoubleHashMapValuesTest::tap;
            this.payloads.contains_NaN = CharDoubleHashMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = CharDoubleHashMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = CharDoubleHashMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = CharDoubleHashMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = CharDoubleHashMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = CharDoubleHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = CharDoubleHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = CharDoubleHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharDoubleHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharDoubleHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharDoubleHashMapValuesTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = CharDoubleHashMapValuesTest::forEach;
            this.payloads.size = CharDoubleHashMapValuesTest::size;
            this.payloads.count = CharDoubleHashMapValuesTest::count;
            this.payloads.anySatisfy = CharDoubleHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = CharDoubleHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = CharDoubleHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = CharDoubleHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharDoubleHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharDoubleHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharDoubleHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharDoubleHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = CharDoubleHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = CharDoubleHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = CharDoubleHashMapValuesTest::detectIfNone;
            this.payloads.max = CharDoubleHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharDoubleHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharDoubleHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharDoubleHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = CharDoubleHashMapValuesTest::sum;
            this.payloads.summaryStatistics = CharDoubleHashMapValuesTest::summaryStatistics;
            this.payloads.average = CharDoubleHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharDoubleHashMapValuesTest::averageIfEmpty;
            this.payloads.median = CharDoubleHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharDoubleHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = CharDoubleHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = CharDoubleHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CharDoubleHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = CharDoubleHashMapValuesTest::testHashCode;
            this.payloads.testToString = CharDoubleHashMapValuesTest::testToString;
            this.payloads.toList = CharDoubleHashMapValuesTest::toList;
            this.payloads.toSortedList = CharDoubleHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = CharDoubleHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharDoubleHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharDoubleHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharDoubleHashMapValuesTest::toSet;
            this.payloads.toBag = CharDoubleHashMapValuesTest::toBag;
            this.payloads.asLazy = CharDoubleHashMapValuesTest::asLazy;
            this.payloads.injectInto = CharDoubleHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = CharDoubleHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharDoubleHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = CharDoubleHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = CharDoubleHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = CharDoubleHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharDoubleHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharDoubleHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharDoubleHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharDoubleHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = CharDoubleHashMapValuesTest::reduceIfEmpty;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = CharDoubleHashMapValuesTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = CharDoubleHashMapValuesTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = CharDoubleHashMapValuesTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = CharDoubleHashMapValuesTest::newEmpty;
            this.payloads.doubleIterator = CharDoubleHashMapValuesTest::doubleIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = CharDoubleHashMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharDoubleHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = CharDoubleHashMapValuesTest::remove;
            this.payloads.removeIf = CharDoubleHashMapValuesTest::removeIf;
            this.payloads.sumConsistentRounding = CharDoubleHashMapValuesTest::sumConsistentRounding;
            this.payloads.asSynchronized = CharDoubleHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = CharDoubleHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = CharDoubleHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = CharDoubleHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = CharDoubleHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = CharDoubleHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = CharDoubleHashMapValuesTest::clear;
            this.payloads.contains = CharDoubleHashMapValuesTest::contains;
            this.payloads.reject = CharDoubleHashMapValuesTest::reject;
            this.payloads.select = CharDoubleHashMapValuesTest::select;
            this.payloads.collect = CharDoubleHashMapValuesTest::collect;
            this.payloads.makeString = CharDoubleHashMapValuesTest::makeString;
            this.payloads.appendString = CharDoubleHashMapValuesTest::appendString;
            this.payloads.testEquals = CharDoubleHashMapValuesTest::testEquals;
            this.payloads.chunk = CharDoubleHashMapValuesTest::chunk;
        }
    }
}
