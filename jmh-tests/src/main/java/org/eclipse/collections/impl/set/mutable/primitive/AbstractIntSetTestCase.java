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
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableIntSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractIntSetTestCase extends AbstractMutableIntCollectionTestCase {

    protected static IntArrayList generateCollisions1() {
        IntArrayList collisions = new IntArrayList();
        IntHashSet set = new IntHashSet();
        for (int i = 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static IntArrayList generateNonCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntHashSet set = new IntHashSet();
        for (int i = 32; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask(32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableIntSet classUnderTest();

    @Override
    protected abstract MutableIntSet newWith(int... elements);

    @Override
    protected MutableIntSet newMutableCollectionWith(int... elements) {
        return IntHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Integer> newObjectCollectionWith(Integer... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains(0));
        Assert.assertFalse(set.contains(31));
        Assert.assertFalse(set.contains(1));
        Assert.assertFalse(set.contains(AbstractIntSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractIntSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableIntSet set = this.newWith();
        Assert.assertTrue(set.add(14));
        Assert.assertFalse(set.add(14));
        Assert.assertTrue(set.add(2));
        Assert.assertFalse(set.add(2));
        Assert.assertTrue(set.add(35));
        Assert.assertFalse(set.add(35));
        Assert.assertTrue(set.add(31));
        Assert.assertFalse(set.add(31));
        Assert.assertTrue(set.add(32));
        Assert.assertFalse(set.add(32));
        Assert.assertTrue(set.add(0));
        Assert.assertFalse(set.add(0));
        Assert.assertTrue(set.add(1));
        Assert.assertFalse(set.add(1));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new IntArrayList()));
        Assert.assertFalse(set.addAll(IntArrayList.newListWith(31, AbstractIntSetTestCase.generateCollisions1().get(0), AbstractIntSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(IntHashSet.newSetWith(0, 1, 2, 30, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 30, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1), AbstractIntSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(IntHashSet.newSetWith(5)));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 5, 30, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1), AbstractIntSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(IntHashSet.newSetWith(AbstractIntSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 5, 30, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1), AbstractIntSetTestCase.generateCollisions1().get(4), AbstractIntSetTestCase.generateCollisions1().get(5)), set);
        IntHashSet set1 = new IntHashSet();
        Assert.assertTrue(set1.addAll(2, 35));
        Assert.assertEquals(IntHashSet.newSetWith(2, 35), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 5, 30, 31), IntSets.mutable.ofAll(IntHashBag.newBagWith(0, 1, 2, 5, 30, 31, 0, 1, 2, 5, 30, 31)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove(15));
        Assert.assertFalse(set.remove(15));
        Assert.assertTrue(set.remove(0));
        Assert.assertEquals(IntHashSet.newSetWith(1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractIntSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractIntSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractIntSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(IntHashSet.newSetWith(1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractIntSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(IntHashSet.newSetWith(1, 31), set);
        Assert.assertTrue(set.remove(31));
        Assert.assertEquals(IntHashSet.newSetWith(1), set);
        Assert.assertTrue(set.remove(1));
        Assert.assertEquals(IntHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll(15, AbstractIntSetTestCase.generateCollisions1().get(2), AbstractIntSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(0, 31, AbstractIntSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(IntHashSet.newSetWith(1, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(1, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new IntHashSet(), set);
        Assert.assertFalse(set.removeAll(1));
        Assert.assertEquals(new IntHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new IntArrayList()));
        Assert.assertFalse(set.removeAll(IntArrayList.newListWith(15, AbstractIntSetTestCase.generateCollisions1().get(2), AbstractIntSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(IntHashSet.newSetWith(0, 31, AbstractIntSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(IntHashSet.newSetWith(1, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(IntHashSet.newSetWith(1, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new IntHashSet(), set);
        Assert.assertFalse(set.removeAll(IntHashSet.newSetWith(1)));
        Assert.assertEquals(new IntHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(0, 31, AbstractIntSetTestCase.generateCollisions1().get(4), AbstractIntSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(IntHashSet.newSetWith(0, 31, AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(1, AbstractIntSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new IntHashSet(), set);
        Assert.assertFalse(set.retainAll(1));
        Assert.assertEquals(new IntHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(IntHashSet.newSetWith(0, 31, AbstractIntSetTestCase.generateCollisions1().get(4), AbstractIntSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(IntHashSet.newSetWith(0, 31, AbstractIntSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(IntHashSet.newSetWith(1, AbstractIntSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new IntHashSet(), set);
        Assert.assertFalse(set.retainAll(IntHashSet.newSetWith(1)));
        Assert.assertEquals(new IntHashSet(), set);
    }

    @Override
    @Test
    public void intIterator() {
        MutableSet<Integer> expected = UnifiedSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        MutableSet<Integer> actual = UnifiedSet.newSet();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        IntIterator iterator = set.intIterator();
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
    public void intIterator_throws() {
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        IntIterator iterator = set.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableIntSet set = this.newWith(0, 2, 31);
        Integer sum = set.injectInto(Integer.valueOf(0), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(33), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        set.forEach((int each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractIntSetTestCase.generateCollisions1().getFirst() + AbstractIntSetTestCase.generateCollisions1().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(IntPredicates.greaterThan(0)));
        Assert.assertEquals(3L, set.count(IntPredicates.lessThan(32)));
        Assert.assertEquals(1L, set.count(IntPredicates.greaterThan(32)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(IntPredicates.lessThan(32)));
        Verify.assertSize(4, set.select(IntPredicates.greaterThan(0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(IntPredicates.greaterThan(0)));
        Verify.assertSize(2, set.reject(IntPredicates.lessThan(32)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(0, set.detectIfNone(IntPredicates.lessThan(1), 9));
        Assert.assertEquals(AbstractIntSetTestCase.generateCollisions1().get(1), set.detectIfNone(IntPredicates.greaterThan(AbstractIntSetTestCase.generateCollisions1().getFirst()), 9));
        Assert.assertEquals(9, set.detectIfNone(IntPredicates.greaterThan(AbstractIntSetTestCase.generateCollisions1().get(1)), 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1, 0, 30, AbstractIntSetTestCase.generateCollisions1().getFirst() - 1, AbstractIntSetTestCase.generateCollisions1().get(1) - 1), set.collect((int byteParameter) -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new int[] { 0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableIntSet set1 = this.newWith(1, 31, 32);
        MutableIntSet set2 = this.newWith(32, 31, 1);
        MutableIntSet set3 = this.newWith(32, 32, 31, 1);
        MutableIntSet set4 = this.newWith(32, 32, 31, 1, 1);
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
        MutableIntSet set1 = this.newWith(1, 31, 32);
        MutableIntSet set2 = this.newWith(32, 31, 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.classUnderTest().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31), this.newWith(0, 1, 31).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedIntSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedIntSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableIntSet set = this.newWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableIntSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(1, 2, 3, 4, 5));
        this.assertUnion(this.newWith(1, 2, 3, 6), this.newWith(3, 4, 5), this.newWith(1, 2, 3, 4, 5, 6));
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(3, 4, 5, 6), this.newWith(1, 2, 3, 4, 5, 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3, 4, 5), this.newWith(3, 4, 5));
        this.assertUnion(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertUnion(MutableIntSet set1, MutableIntSet set2, MutableIntSet expected) {
        MutableIntSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(3));
        this.assertIntersect(this.newWith(1, 2, 3, 6), this.newWith(3, 4, 5), this.newWith(3));
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(3, 4, 5, 6), this.newWith(3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3, 4, 5), this.newWith());
        this.assertIntersect(this.newWith(1, 2, 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableIntSet set1, MutableIntSet set2, MutableIntSet expected) {
        MutableIntSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(3, 4, 5), this.newWith(1, 2));
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(1, 2, 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3, 4, 5), this.newWith());
        this.assertDifference(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertDifference(MutableIntSet set1, MutableIntSet set2, MutableIntSet expected) {
        MutableIntSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(2, 3, 4), this.newWith(1, 4));
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(1, 2, 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3, 4, 5), this.newWith(3, 4, 5));
        this.assertSymmetricDifference(this.newWith(1, 2, 3), this.newWith(), this.newWith(1, 2, 3));
    }

    private void assertSymmetricDifference(MutableIntSet set1, MutableIntSet set2, MutableIntSet expected) {
        MutableIntSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1, 2), this.newWith(1, 2, 3), true);
        this.assertIsSubsetOf(this.newWith(1, 4), this.newWith(1, 2, 3), false);
        this.assertIsSubsetOf(this.newWith(1, 2, 3), this.newWith(1, 2, 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3, 4, 5), true);
        this.assertIsSubsetOf(this.newWith(1, 2, 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableIntSet set1, MutableIntSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1, 2), this.newWith(1, 2, 3), true);
        this.assertIsProperSubsetOf(this.newWith(1, 4), this.newWith(1, 2, 3), false);
        this.assertIsProperSubsetOf(this.newWith(1, 2, 3), this.newWith(1, 2, 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3, 4, 5), true);
        this.assertIsProperSubsetOf(this.newWith(1, 2, 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableIntSet set1, MutableIntSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(3, 4), Sets.mutable.with(PrimitiveTuples.pair(1, 3), PrimitiveTuples.pair(1, 4), PrimitiveTuples.pair(2, 3), PrimitiveTuples.pair(2, 4)));
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(1, 2), Sets.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(1, 2), PrimitiveTuples.pair(2, 1), PrimitiveTuples.pair(2, 2)));
        this.assertCartesianProduct(this.newWith(1, 2), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1, 2), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableIntSet set1, MutableIntSet set2, MutableSet<IntIntPair> expected) {
        MutableSet<IntIntPair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase._Benchmark {

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator, this.description("intIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::intIterator_throws, this.description("intIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractIntSetTestCase implementation();
    }
}
