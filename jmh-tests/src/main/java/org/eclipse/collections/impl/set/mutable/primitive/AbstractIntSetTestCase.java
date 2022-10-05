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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractIntSetTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractIntSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractIntSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractIntSetTestCase::newCollection;
            this.payloads.tap = AbstractIntSetTestCase::tap;
            this.payloads.containsAllArray = AbstractIntSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractIntSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractIntSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractIntSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractIntSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractIntSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractIntSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractIntSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractIntSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractIntSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractIntSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractIntSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractIntSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractIntSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractIntSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractIntSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractIntSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractIntSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractIntSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractIntSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractIntSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractIntSetTestCase::summaryStatistics;
            this.payloads.average = AbstractIntSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractIntSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractIntSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractIntSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractIntSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractIntSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractIntSetTestCase::testToString;
            this.payloads.makeString = AbstractIntSetTestCase::makeString;
            this.payloads.appendString = AbstractIntSetTestCase::appendString;
            this.payloads.toList = AbstractIntSetTestCase::toList;
            this.payloads.toSortedList = AbstractIntSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractIntSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractIntSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractIntSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractIntSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractIntSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractIntSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractIntSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractIntSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractIntSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractIntSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractIntSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractIntSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractIntSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractIntSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractIntSetTestCase::chunk;
            this.payloads.contains = AbstractIntSetTestCase::contains;
            this.payloads.addAllArray = AbstractIntSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractIntSetTestCase::removeIf;
            this.payloads.with = AbstractIntSetTestCase::with;
            this.payloads.withAll = AbstractIntSetTestCase::withAll;
            this.payloads.without = AbstractIntSetTestCase::without;
            this.payloads.withoutAll = AbstractIntSetTestCase::withoutAll;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = AbstractIntSetTestCase::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = AbstractIntSetTestCase::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = AbstractIntSetTestCase::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractIntSetTestCase::newEmpty;
            this.payloads.size = AbstractIntSetTestCase::size;
            this.payloads.isEmpty = AbstractIntSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractIntSetTestCase::notEmpty;
            this.payloads.clear = AbstractIntSetTestCase::clear;
            this.payloads.add = AbstractIntSetTestCase::add;
            this.payloads.addAllIterable = AbstractIntSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractIntSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractIntSetTestCase::remove;
            this.payloads.removeAll = AbstractIntSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractIntSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractIntSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractIntSetTestCase::retainAll_iterable;
            this.payloads.intIterator = AbstractIntSetTestCase::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntSetTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractIntSetTestCase::injectInto;
            this.payloads.forEach = AbstractIntSetTestCase::forEach;
            this.payloads.count = AbstractIntSetTestCase::count;
            this.payloads.select = AbstractIntSetTestCase::select;
            this.payloads.reject = AbstractIntSetTestCase::reject;
            this.payloads.detectIfNone = AbstractIntSetTestCase::detectIfNone;
            this.payloads.collect = AbstractIntSetTestCase::collect;
            this.payloads.toSortedArray = AbstractIntSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractIntSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractIntSetTestCase::testHashCode;
            this.payloads.toBag = AbstractIntSetTestCase::toBag;
            this.payloads.asLazy = AbstractIntSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractIntSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractIntSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractIntSetTestCase::union;
            this.payloads.intersect = AbstractIntSetTestCase::intersect;
            this.payloads.difference = AbstractIntSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractIntSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractIntSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractIntSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractIntSetTestCase::cartesianProduct;
        }
    }
}
