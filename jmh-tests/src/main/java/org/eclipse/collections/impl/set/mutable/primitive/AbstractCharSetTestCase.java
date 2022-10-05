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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testOfAllFactory, this.description("testOfAllFactory"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll, this.description("removeAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll_iterable, this.description("removeAll_iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll, this.description("retainAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll_iterable, this.description("retainAll_iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator, this.description("charIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::charIterator_throws, this.description("charIterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testHashCode, this.description("testHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::union, this.description("union"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersect, this.description("intersect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::difference, this.description("difference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifference, this.description("symmetricDifference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isSubsetOf, this.description("isSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isProperSubsetOf, this.description("isProperSubsetOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProduct, this.description("cartesianProduct"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractCharSetTestCase implementation();
    }
}
