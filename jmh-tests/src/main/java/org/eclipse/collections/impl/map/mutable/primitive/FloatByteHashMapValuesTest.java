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
 * JUnit test for {@link FloatByteHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class FloatByteHashMapValuesTest extends AbstractMutableByteCollectionTestCase {

    @Override
    protected MutableByteCollection classUnderTest() {
        return FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3).values();
    }

    @Override
    protected MutableByteCollection newWith(byte... elements) {
        FloatByteHashMap map = new FloatByteHashMap();
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        map = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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
        FloatByteHashMap map = FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3);
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

        private FloatByteHashMapValuesTest instance;

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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new FloatByteHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatByteHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FloatByteHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = FloatByteHashMapValuesTest::newCollection;
            this.payloads.isEmpty = FloatByteHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = FloatByteHashMapValuesTest::notEmpty;
            this.payloads.tap = FloatByteHashMapValuesTest::tap;
            this.payloads.containsAllArray = FloatByteHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = FloatByteHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = FloatByteHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = FloatByteHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = FloatByteHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = FloatByteHashMapValuesTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FloatByteHashMapValuesTest::forEach;
            this.payloads.size = FloatByteHashMapValuesTest::size;
            this.payloads.count = FloatByteHashMapValuesTest::count;
            this.payloads.anySatisfy = FloatByteHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = FloatByteHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = FloatByteHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = FloatByteHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FloatByteHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FloatByteHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FloatByteHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FloatByteHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FloatByteHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = FloatByteHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = FloatByteHashMapValuesTest::detectIfNone;
            this.payloads.max = FloatByteHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FloatByteHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatByteHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatByteHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = FloatByteHashMapValuesTest::sum;
            this.payloads.summaryStatistics = FloatByteHashMapValuesTest::summaryStatistics;
            this.payloads.average = FloatByteHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FloatByteHashMapValuesTest::averageIfEmpty;
            this.payloads.median = FloatByteHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FloatByteHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = FloatByteHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = FloatByteHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = FloatByteHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = FloatByteHashMapValuesTest::testHashCode;
            this.payloads.testToString = FloatByteHashMapValuesTest::testToString;
            this.payloads.toList = FloatByteHashMapValuesTest::toList;
            this.payloads.toSortedList = FloatByteHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = FloatByteHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FloatByteHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FloatByteHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FloatByteHashMapValuesTest::toSet;
            this.payloads.toBag = FloatByteHashMapValuesTest::toBag;
            this.payloads.asLazy = FloatByteHashMapValuesTest::asLazy;
            this.payloads.injectInto = FloatByteHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = FloatByteHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FloatByteHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = FloatByteHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = FloatByteHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = FloatByteHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = FloatByteHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = FloatByteHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = FloatByteHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FloatByteHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = FloatByteHashMapValuesTest::reduceIfEmpty;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = FloatByteHashMapValuesTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = FloatByteHashMapValuesTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = FloatByteHashMapValuesTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = FloatByteHashMapValuesTest::newEmpty;
            this.payloads.byteIterator = FloatByteHashMapValuesTest::byteIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatByteHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = FloatByteHashMapValuesTest::remove;
            this.payloads.removeIf = FloatByteHashMapValuesTest::removeIf;
            this.payloads.asSynchronized = FloatByteHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatByteHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = FloatByteHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = FloatByteHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = FloatByteHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = FloatByteHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = FloatByteHashMapValuesTest::clear;
            this.payloads.contains = FloatByteHashMapValuesTest::contains;
            this.payloads.reject = FloatByteHashMapValuesTest::reject;
            this.payloads.select = FloatByteHashMapValuesTest::select;
            this.payloads.collect = FloatByteHashMapValuesTest::collect;
            this.payloads.makeString = FloatByteHashMapValuesTest::makeString;
            this.payloads.appendString = FloatByteHashMapValuesTest::appendString;
            this.payloads.testEquals = FloatByteHashMapValuesTest::testEquals;
            this.payloads.chunk = FloatByteHashMapValuesTest::chunk;
        }
    }
}
