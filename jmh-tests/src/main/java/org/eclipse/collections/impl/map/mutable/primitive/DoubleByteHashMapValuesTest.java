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
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.iterator.ByteIterator;
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
 * JUnit test for {@link DoubleByteHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class DoubleByteHashMapValuesTest extends AbstractMutableByteCollectionTestCase {

    @Override
    protected MutableByteCollection classUnderTest() {
        return DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3).values();
    }

    @Override
    protected MutableByteCollection newWith(byte... elements) {
        DoubleByteHashMap map = new DoubleByteHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableByteCollection newMutableCollectionWith(byte... elements) {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Byte> newObjectCollectionWith(Byte... elements) {
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
    @Test
    public void remove() {
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertTrue(collection.remove((byte) 3));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertTrue(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
    }

    @Override
    @Test
    public void removeIf() {
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(BytePredicates.equal((byte) 3)));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertTrue(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertFalse(collection.removeIf(BytePredicates.equal((byte) 3)));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableByteCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedByteCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableByteCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableByteCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((byte) 1));
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll((byte) 1, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertTrue(collection.removeAll((byte) 3, (byte) 2));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.isEmpty());
        map = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 2.0, (byte) 2, 3.0, (byte) 3);
        collection = map.values();
        Assert.assertTrue(collection.removeAll((byte) 0, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new ByteArrayList()));
        Assert.assertFalse(this.newWith().removeAll(ByteArrayList.newListWith((byte) 1)));
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(ByteArrayList.newListWith((byte) 1, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertTrue(collection.removeAll(ByteArrayList.newListWith((byte) 3, (byte) 2)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll((byte) 1));
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((byte) 0, (byte) 1, (byte) 2, (byte) 3));
        Assert.assertTrue(collection.retainAll((byte) 0, (byte) 2, (byte) 3, (byte) 5));
        Assert.assertTrue(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertTrue(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll((byte) 2, (byte) 3, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll((byte) 3, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll((byte) 0, (byte) 0, (byte) 1));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new ByteArrayList()));
        Assert.assertFalse(this.newWith().retainAll(ByteArrayList.newListWith((byte) 1)));
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3)));
        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 2, (byte) 3, (byte) 5)));
        Assert.assertTrue(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertTrue(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 3, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 0, (byte) 1)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableByteCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        DoubleByteHashMap map = DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        MutableByteCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        MutableByteCollection collection1 = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((byte) 0));
        Assert.assertFalse(collection1.contains((byte) 1));
        Assert.assertFalse(collection1.contains((byte) 31));
        Assert.assertFalse(collection1.contains((byte) 32));
        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 2);
        collection2.clear();
        Verify.assertSize(0, collection2);
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
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
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

        private DoubleByteHashMapValuesTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleByteHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = DoubleByteHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = DoubleByteHashMapValuesTest::newCollection;
            this.payloads.isEmpty = DoubleByteHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = DoubleByteHashMapValuesTest::notEmpty;
            this.payloads.tap = DoubleByteHashMapValuesTest::tap;
            this.payloads.containsAllArray = DoubleByteHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleByteHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = DoubleByteHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = DoubleByteHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = DoubleByteHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = DoubleByteHashMapValuesTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = DoubleByteHashMapValuesTest::forEach;
            this.payloads.size = DoubleByteHashMapValuesTest::size;
            this.payloads.count = DoubleByteHashMapValuesTest::count;
            this.payloads.anySatisfy = DoubleByteHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = DoubleByteHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleByteHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = DoubleByteHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = DoubleByteHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = DoubleByteHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = DoubleByteHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = DoubleByteHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = DoubleByteHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = DoubleByteHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = DoubleByteHashMapValuesTest::detectIfNone;
            this.payloads.max = DoubleByteHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleByteHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleByteHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleByteHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = DoubleByteHashMapValuesTest::sum;
            this.payloads.summaryStatistics = DoubleByteHashMapValuesTest::summaryStatistics;
            this.payloads.average = DoubleByteHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = DoubleByteHashMapValuesTest::averageIfEmpty;
            this.payloads.median = DoubleByteHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = DoubleByteHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = DoubleByteHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = DoubleByteHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = DoubleByteHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = DoubleByteHashMapValuesTest::testHashCode;
            this.payloads.testToString = DoubleByteHashMapValuesTest::testToString;
            this.payloads.toList = DoubleByteHashMapValuesTest::toList;
            this.payloads.toSortedList = DoubleByteHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = DoubleByteHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = DoubleByteHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = DoubleByteHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = DoubleByteHashMapValuesTest::toSet;
            this.payloads.toBag = DoubleByteHashMapValuesTest::toBag;
            this.payloads.asLazy = DoubleByteHashMapValuesTest::asLazy;
            this.payloads.injectInto = DoubleByteHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = DoubleByteHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = DoubleByteHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = DoubleByteHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = DoubleByteHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = DoubleByteHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = DoubleByteHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = DoubleByteHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = DoubleByteHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = DoubleByteHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = DoubleByteHashMapValuesTest::reduceIfEmpty;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = DoubleByteHashMapValuesTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = DoubleByteHashMapValuesTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = DoubleByteHashMapValuesTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = DoubleByteHashMapValuesTest::newEmpty;
            this.payloads.byteIterator = DoubleByteHashMapValuesTest::byteIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleByteHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = DoubleByteHashMapValuesTest::remove;
            this.payloads.removeIf = DoubleByteHashMapValuesTest::removeIf;
            this.payloads.asSynchronized = DoubleByteHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleByteHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = DoubleByteHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = DoubleByteHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = DoubleByteHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = DoubleByteHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = DoubleByteHashMapValuesTest::clear;
            this.payloads.contains = DoubleByteHashMapValuesTest::contains;
            this.payloads.reject = DoubleByteHashMapValuesTest::reject;
            this.payloads.select = DoubleByteHashMapValuesTest::select;
            this.payloads.collect = DoubleByteHashMapValuesTest::collect;
            this.payloads.makeString = DoubleByteHashMapValuesTest::makeString;
            this.payloads.appendString = DoubleByteHashMapValuesTest::appendString;
            this.payloads.testEquals = DoubleByteHashMapValuesTest::testEquals;
            this.payloads.chunk = DoubleByteHashMapValuesTest::chunk;
        }
    }
}
