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
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractShortSetTestCase extends AbstractMutableShortCollectionTestCase {

    protected static ShortArrayList generateCollisions1() {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((short) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static ShortArrayList generateNonCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask((short) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableShortSet classUnderTest();

    @Override
    protected abstract MutableShortSet newWith(short... elements);

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements) {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains((short) 0));
        Assert.assertFalse(set.contains((short) 31));
        Assert.assertFalse(set.contains((short) 1));
        Assert.assertFalse(set.contains(AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractShortSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableShortSet set = this.newWith();
        Assert.assertTrue(set.add((short) 14));
        Assert.assertFalse(set.add((short) 14));
        Assert.assertTrue(set.add((short) 2));
        Assert.assertFalse(set.add((short) 2));
        Assert.assertTrue(set.add((short) 35));
        Assert.assertFalse(set.add((short) 35));
        Assert.assertTrue(set.add((short) 31));
        Assert.assertFalse(set.add((short) 31));
        Assert.assertTrue(set.add((short) 32));
        Assert.assertFalse(set.add((short) 32));
        Assert.assertTrue(set.add((short) 0));
        Assert.assertFalse(set.add((short) 0));
        Assert.assertTrue(set.add((short) 1));
        Assert.assertFalse(set.add((short) 1));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new ShortArrayList()));
        Assert.assertFalse(set.addAll(ShortArrayList.newListWith((short) 31, AbstractShortSetTestCase.generateCollisions1().get(0), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 30, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith((short) 5)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith(AbstractShortSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(5)), set);
        ShortHashSet set1 = new ShortHashSet();
        Assert.assertTrue(set1.addAll((short) 2, (short) 35));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 2, (short) 35), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31), ShortSets.mutable.ofAll(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, (short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove((short) 15));
        Assert.assertFalse(set.remove((short) 15));
        Assert.assertTrue(set.remove((short) 0));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractShortSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31), set);
        Assert.assertTrue(set.remove((short) 31));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), set);
        Assert.assertTrue(set.remove((short) 1));
        Assert.assertEquals(ShortHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll((short) 15, AbstractShortSetTestCase.generateCollisions1().get(2), AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.removeAll((short) 1));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new ShortArrayList()));
        Assert.assertFalse(set.removeAll(ShortArrayList.newListWith((short) 15, AbstractShortSetTestCase.generateCollisions1().get(2), AbstractShortSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.removeAll(ShortHashSet.newSetWith((short) 1)));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.retainAll((short) 1));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.retainAll(ShortHashSet.newSetWith((short) 1)));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void shortIterator() {
        MutableSet<Short> expected = UnifiedSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        MutableSet<Short> actual = UnifiedSet.newSet();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        ShortIterator iterator = set.shortIterator();
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
    public void shortIterator_throws() {
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        ShortIterator iterator = set.shortIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableShortSet set = this.newWith((short) 0, (short) 2, (short) 31);
        Short sum = set.injectInto(Short.valueOf((short) 0), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 33), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        set.forEach((short each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractShortSetTestCase.generateCollisions1().getFirst() + AbstractShortSetTestCase.generateCollisions1().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(3L, set.count(ShortPredicates.lessThan((short) 32)));
        Assert.assertEquals(1L, set.count(ShortPredicates.greaterThan((short) 32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(ShortPredicates.lessThan((short) 32)));
        Verify.assertSize(4, set.select(ShortPredicates.greaterThan((short) 0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertSize(2, set.reject(ShortPredicates.lessThan((short) 32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals((short) 0, set.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 9));
        Assert.assertEquals(AbstractShortSetTestCase.generateCollisions1().get(1), set.detectIfNone(ShortPredicates.greaterThan(AbstractShortSetTestCase.generateCollisions1().getFirst()), (short) 9));
        Assert.assertEquals((short) 9, set.detectIfNone(ShortPredicates.greaterThan(AbstractShortSetTestCase.generateCollisions1().get(1)), (short) 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((short) -1, (short) 0, (short) 30, (short) (AbstractShortSetTestCase.generateCollisions1().getFirst() - 1), (short) (AbstractShortSetTestCase.generateCollisions1().get(1) - 1)), set.collect((short byteParameter) -> (short) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new short[] { (short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        MutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        MutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
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
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 1, (short) 31).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedShortSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedShortSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableShortSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3, (short) 6), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5, (short) 6), this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3, (short) 4, (short) 5));
        this.assertUnion(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertUnion(MutableShortSet set1, MutableShortSet set2, MutableShortSet expected) {
        MutableShortSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3));
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3, (short) 6), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3));
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5, (short) 6), this.newWith((short) 3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith());
        this.assertIntersect(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableShortSet set1, MutableShortSet set2, MutableShortSet expected) {
        MutableShortSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 1, (short) 2));
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith());
        this.assertDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertDifference(MutableShortSet set1, MutableShortSet set2, MutableShortSet expected) {
        MutableShortSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 2, (short) 3, (short) 4), this.newWith((short) 1, (short) 4));
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), this.newWith((short) 3, (short) 4, (short) 5));
        this.assertSymmetricDifference(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), this.newWith((short) 1, (short) 2, (short) 3));
    }

    private void assertSymmetricDifference(MutableShortSet set1, MutableShortSet set2, MutableShortSet expected) {
        MutableShortSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 4), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), true);
        this.assertIsSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableShortSet set1, MutableShortSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3), true);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 4), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith((short) 3, (short) 4, (short) 5), true);
        this.assertIsProperSubsetOf(this.newWith((short) 1, (short) 2, (short) 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableShortSet set1, MutableShortSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith((short) 3, (short) 4), Sets.mutable.with(PrimitiveTuples.pair((short) 1, (short) 3), PrimitiveTuples.pair((short) 1, (short) 4), PrimitiveTuples.pair((short) 2, (short) 3), PrimitiveTuples.pair((short) 2, (short) 4)));
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith((short) 1, (short) 2), Sets.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 1, (short) 2), PrimitiveTuples.pair((short) 2, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)));
        this.assertCartesianProduct(this.newWith((short) 1, (short) 2), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith((short) 1, (short) 2), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableShortSet set1, MutableShortSet set2, MutableSet<ShortShortPair> expected) {
        MutableSet<ShortShortPair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortSetTestCase instance;

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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractShortSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractShortSetTestCase::newCollection;
            this.payloads.tap = AbstractShortSetTestCase::tap;
            this.payloads.containsAllArray = AbstractShortSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractShortSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractShortSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractShortSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractShortSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractShortSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractShortSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractShortSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractShortSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractShortSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractShortSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractShortSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractShortSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractShortSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractShortSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractShortSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractShortSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractShortSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractShortSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractShortSetTestCase::summaryStatistics;
            this.payloads.average = AbstractShortSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractShortSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractShortSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractShortSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractShortSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractShortSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractShortSetTestCase::testToString;
            this.payloads.makeString = AbstractShortSetTestCase::makeString;
            this.payloads.appendString = AbstractShortSetTestCase::appendString;
            this.payloads.toList = AbstractShortSetTestCase::toList;
            this.payloads.toSortedList = AbstractShortSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractShortSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractShortSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractShortSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractShortSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractShortSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractShortSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractShortSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractShortSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractShortSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractShortSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractShortSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractShortSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractShortSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractShortSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractShortSetTestCase::chunk;
            this.payloads.contains = AbstractShortSetTestCase::contains;
            this.payloads.addAllArray = AbstractShortSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractShortSetTestCase::removeIf;
            this.payloads.with = AbstractShortSetTestCase::with;
            this.payloads.withAll = AbstractShortSetTestCase::withAll;
            this.payloads.without = AbstractShortSetTestCase::without;
            this.payloads.withoutAll = AbstractShortSetTestCase::withoutAll;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = AbstractShortSetTestCase::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = AbstractShortSetTestCase::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = AbstractShortSetTestCase::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractShortSetTestCase::newEmpty;
            this.payloads.size = AbstractShortSetTestCase::size;
            this.payloads.isEmpty = AbstractShortSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortSetTestCase::notEmpty;
            this.payloads.clear = AbstractShortSetTestCase::clear;
            this.payloads.add = AbstractShortSetTestCase::add;
            this.payloads.addAllIterable = AbstractShortSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractShortSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractShortSetTestCase::remove;
            this.payloads.removeAll = AbstractShortSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractShortSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractShortSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractShortSetTestCase::retainAll_iterable;
            this.payloads.shortIterator = AbstractShortSetTestCase::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortSetTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractShortSetTestCase::injectInto;
            this.payloads.forEach = AbstractShortSetTestCase::forEach;
            this.payloads.count = AbstractShortSetTestCase::count;
            this.payloads.select = AbstractShortSetTestCase::select;
            this.payloads.reject = AbstractShortSetTestCase::reject;
            this.payloads.detectIfNone = AbstractShortSetTestCase::detectIfNone;
            this.payloads.collect = AbstractShortSetTestCase::collect;
            this.payloads.toSortedArray = AbstractShortSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractShortSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractShortSetTestCase::testHashCode;
            this.payloads.toBag = AbstractShortSetTestCase::toBag;
            this.payloads.asLazy = AbstractShortSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractShortSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractShortSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractShortSetTestCase::union;
            this.payloads.intersect = AbstractShortSetTestCase::intersect;
            this.payloads.difference = AbstractShortSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractShortSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractShortSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractShortSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractShortSetTestCase::cartesianProduct;
        }
    }
*/
}
