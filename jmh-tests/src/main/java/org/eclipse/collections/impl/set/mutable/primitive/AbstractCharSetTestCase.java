/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableCharSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractCharSetTestCase extends AbstractMutableCharCollectionTestCase {

    protected static CharArrayList generateCollisions1() {
        CharArrayList collisions = new CharArrayList();
        CharHashSet set = new CharHashSet();
        for (char i = (char) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((char) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static CharArrayList generateNonCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharHashSet set = new CharHashSet();
        for (char i = (char) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask((char) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableCharSet classUnderTest();

    @Override
    protected abstract MutableCharSet newWith(char... elements);

    @Override
    protected MutableCharSet newMutableCollectionWith(char... elements) {
        return CharHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Character> newObjectCollectionWith(Character... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains((char) 0));
        Assert.assertFalse(set.contains((char) 31));
        Assert.assertFalse(set.contains((char) 1));
        Assert.assertFalse(set.contains(AbstractCharSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractCharSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableCharSet set = this.newWith();
        Assert.assertTrue(set.add((char) 14));
        Assert.assertFalse(set.add((char) 14));
        Assert.assertTrue(set.add((char) 2));
        Assert.assertFalse(set.add((char) 2));
        Assert.assertTrue(set.add((char) 35));
        Assert.assertFalse(set.add((char) 35));
        Assert.assertTrue(set.add((char) 31));
        Assert.assertFalse(set.add((char) 31));
        Assert.assertTrue(set.add((char) 32));
        Assert.assertFalse(set.add((char) 32));
        Assert.assertTrue(set.add((char) 0));
        Assert.assertFalse(set.add((char) 0));
        Assert.assertTrue(set.add((char) 1));
        Assert.assertFalse(set.add((char) 1));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new CharArrayList()));
        Assert.assertFalse(set.addAll(CharArrayList.newListWith((char) 31, AbstractCharSetTestCase.generateCollisions1().get(0), AbstractCharSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 30, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 30, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1), AbstractCharSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(CharHashSet.newSetWith((char) 5)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 5, (char) 30, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1), AbstractCharSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(CharHashSet.newSetWith(AbstractCharSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 5, (char) 30, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1), AbstractCharSetTestCase.generateCollisions1().get(4), AbstractCharSetTestCase.generateCollisions1().get(5)), set);
        CharHashSet set1 = new CharHashSet();
        Assert.assertTrue(set1.addAll((char) 2, (char) 35));
        Assert.assertEquals(CharHashSet.newSetWith((char) 2, (char) 35), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 5, (char) 30, (char) 31), CharSets.mutable.ofAll(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2, (char) 5, (char) 30, (char) 31, (char) 0, (char) 1, (char) 2, (char) 5, (char) 30, (char) 31)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove((char) 15));
        Assert.assertFalse(set.remove((char) 15));
        Assert.assertTrue(set.remove((char) 0));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractCharSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractCharSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractCharSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractCharSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 31), set);
        Assert.assertTrue(set.remove((char) 31));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), set);
        Assert.assertTrue(set.remove((char) 1));
        Assert.assertEquals(CharHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll((char) 15, AbstractCharSetTestCase.generateCollisions1().get(2), AbstractCharSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new CharHashSet(), set);
        Assert.assertFalse(set.removeAll((char) 1));
        Assert.assertEquals(new CharHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new CharArrayList()));
        Assert.assertFalse(set.removeAll(CharArrayList.newListWith((char) 15, AbstractCharSetTestCase.generateCollisions1().get(2), AbstractCharSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(CharHashSet.newSetWith((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(CharHashSet.newSetWith((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new CharHashSet(), set);
        Assert.assertFalse(set.removeAll(CharHashSet.newSetWith((char) 1)));
        Assert.assertEquals(new CharHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(4), AbstractCharSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new CharHashSet(), set);
        Assert.assertFalse(set.retainAll((char) 1));
        Assert.assertEquals(new CharHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(CharHashSet.newSetWith((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(4), AbstractCharSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 31, AbstractCharSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(CharHashSet.newSetWith((char) 1, AbstractCharSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new CharHashSet(), set);
        Assert.assertFalse(set.retainAll(CharHashSet.newSetWith((char) 1)));
        Assert.assertEquals(new CharHashSet(), set);
    }

    @Override
    @Test
    public void charIterator() {
        MutableSet<Character> expected = UnifiedSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        MutableSet<Character> actual = UnifiedSet.newSet();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        CharIterator iterator = set.charIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws() {
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        CharIterator iterator = set.charIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableCharSet set = this.newWith((char) 0, (char) 2, (char) 31);
        Character sum = set.injectInto(Character.valueOf((char) 0), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 33), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        set.forEach((char each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractCharSetTestCase.generateCollisions1().getFirst() + AbstractCharSetTestCase.generateCollisions1().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(CharPredicates.greaterThan((char) 0)));
        Assert.assertEquals(3L, set.count(CharPredicates.lessThan((char) 32)));
        Assert.assertEquals(1L, set.count(CharPredicates.greaterThan((char) 32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(CharPredicates.lessThan((char) 32)));
        Verify.assertSize(4, set.select(CharPredicates.greaterThan((char) 0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(CharPredicates.greaterThan((char) 0)));
        Verify.assertSize(2, set.reject(CharPredicates.lessThan((char) 32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals((char) 0, set.detectIfNone(CharPredicates.lessThan((char) 1), (char) 9));
        Assert.assertEquals(AbstractCharSetTestCase.generateCollisions1().get(1), set.detectIfNone(CharPredicates.greaterThan(AbstractCharSetTestCase.generateCollisions1().getFirst()), (char) 9));
        Assert.assertEquals((char) 9, set.detectIfNone(CharPredicates.greaterThan(AbstractCharSetTestCase.generateCollisions1().get(1)), (char) 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((char) -1, (char) 0, (char) 30, (char) (AbstractCharSetTestCase.generateCollisions1().getFirst() - 1), (char) (AbstractCharSetTestCase.generateCollisions1().get(1) - 1)), set.collect((char byteParameter) -> (char) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new char[] { (char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        MutableCharSet set3 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1);
        MutableCharSet set4 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1, (char) 1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
    }

    @Override
    @Test
    public void testHashCode() {
        super.testEquals();
        MutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31), this.newWith((char) 0, (char) 1, (char) 31).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedCharSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedCharSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableCharSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3, (char) 6), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5, (char) 6), this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3, (char) 4, (char) 5));
        this.assertUnion(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertUnion(MutableCharSet set1, MutableCharSet set2, MutableCharSet expected) {
        MutableCharSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3));
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3, (char) 6), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3));
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5, (char) 6), this.newWith((char) 3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith());
        this.assertIntersect(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableCharSet set1, MutableCharSet set2, MutableCharSet expected) {
        MutableCharSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 1, (char) 2));
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith());
        this.assertDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertDifference(MutableCharSet set1, MutableCharSet set2, MutableCharSet expected) {
        MutableCharSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 2, (char) 3, (char) 4), this.newWith((char) 1, (char) 4));
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), this.newWith((char) 3, (char) 4, (char) 5));
        this.assertSymmetricDifference(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), this.newWith((char) 1, (char) 2, (char) 3));
    }

    private void assertSymmetricDifference(MutableCharSet set1, MutableCharSet set2, MutableCharSet expected) {
        MutableCharSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 4), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), true);
        this.assertIsSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableCharSet set1, MutableCharSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3), true);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 4), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith((char) 3, (char) 4, (char) 5), true);
        this.assertIsProperSubsetOf(this.newWith((char) 1, (char) 2, (char) 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableCharSet set1, MutableCharSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith((char) 3, (char) 4), Sets.mutable.with(PrimitiveTuples.pair((char) 1, (char) 3), PrimitiveTuples.pair((char) 1, (char) 4), PrimitiveTuples.pair((char) 2, (char) 3), PrimitiveTuples.pair((char) 2, (char) 4)));
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith((char) 1, (char) 2), Sets.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 1, (char) 2), PrimitiveTuples.pair((char) 2, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)));
        this.assertCartesianProduct(this.newWith((char) 1, (char) 2), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith((char) 1, (char) 2), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableCharSet set1, MutableCharSet set2, MutableSet<CharCharPair> expected) {
        MutableSet<CharCharPair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractCharSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractCharSetTestCase::newCollection;
            this.payloads.tap = AbstractCharSetTestCase::tap;
            this.payloads.containsAllArray = AbstractCharSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractCharSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractCharSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractCharSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractCharSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractCharSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractCharSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractCharSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractCharSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractCharSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractCharSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractCharSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractCharSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractCharSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractCharSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractCharSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractCharSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractCharSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractCharSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractCharSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractCharSetTestCase::summaryStatistics;
            this.payloads.average = AbstractCharSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractCharSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractCharSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractCharSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractCharSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractCharSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractCharSetTestCase::testToString;
            this.payloads.makeString = AbstractCharSetTestCase::makeString;
            this.payloads.appendString = AbstractCharSetTestCase::appendString;
            this.payloads.toList = AbstractCharSetTestCase::toList;
            this.payloads.toSortedList = AbstractCharSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractCharSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractCharSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractCharSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractCharSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractCharSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractCharSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractCharSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractCharSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractCharSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractCharSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractCharSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractCharSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractCharSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractCharSetTestCase::chunk;
            this.payloads.contains = AbstractCharSetTestCase::contains;
            this.payloads.addAllArray = AbstractCharSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractCharSetTestCase::removeIf;
            this.payloads.with = AbstractCharSetTestCase::with;
            this.payloads.withAll = AbstractCharSetTestCase::withAll;
            this.payloads.without = AbstractCharSetTestCase::without;
            this.payloads.withoutAll = AbstractCharSetTestCase::withoutAll;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = AbstractCharSetTestCase::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = AbstractCharSetTestCase::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = AbstractCharSetTestCase::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractCharSetTestCase::newEmpty;
            this.payloads.size = AbstractCharSetTestCase::size;
            this.payloads.isEmpty = AbstractCharSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractCharSetTestCase::notEmpty;
            this.payloads.clear = AbstractCharSetTestCase::clear;
            this.payloads.add = AbstractCharSetTestCase::add;
            this.payloads.addAllIterable = AbstractCharSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractCharSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractCharSetTestCase::remove;
            this.payloads.removeAll = AbstractCharSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractCharSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractCharSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractCharSetTestCase::retainAll_iterable;
            this.payloads.charIterator = AbstractCharSetTestCase::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharSetTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractCharSetTestCase::injectInto;
            this.payloads.forEach = AbstractCharSetTestCase::forEach;
            this.payloads.count = AbstractCharSetTestCase::count;
            this.payloads.select = AbstractCharSetTestCase::select;
            this.payloads.reject = AbstractCharSetTestCase::reject;
            this.payloads.detectIfNone = AbstractCharSetTestCase::detectIfNone;
            this.payloads.collect = AbstractCharSetTestCase::collect;
            this.payloads.toSortedArray = AbstractCharSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractCharSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractCharSetTestCase::testHashCode;
            this.payloads.toBag = AbstractCharSetTestCase::toBag;
            this.payloads.asLazy = AbstractCharSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractCharSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractCharSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractCharSetTestCase::union;
            this.payloads.intersect = AbstractCharSetTestCase::intersect;
            this.payloads.difference = AbstractCharSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractCharSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractCharSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractCharSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractCharSetTestCase::cartesianProduct;
        }
    }
}
