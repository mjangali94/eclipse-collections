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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase._Benchmark {

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator, this.description("shortIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::shortIterator_throws, this.description("shortIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractShortSetTestCase implementation();
    }
}
