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

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableDoubleSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractDoubleSetTestCase extends AbstractMutableDoubleCollectionTestCase {

    protected static DoubleArrayList generateCollisions1() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleHashSet set = new DoubleHashSet();
        for (double i = 32.0; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static DoubleArrayList generateNonCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleHashSet set = new DoubleHashSet();
        for (double i = 32.0; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask(32.0)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableDoubleSet classUnderTest();

    @Override
    protected abstract MutableDoubleSet newWith(double... elements);

    @Override
    protected MutableDoubleSet newMutableCollectionWith(double... elements) {
        return DoubleHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Double> newObjectCollectionWith(Double... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains(0.0));
        Assert.assertFalse(set.contains(31.0));
        Assert.assertFalse(set.contains(1.0));
        Assert.assertFalse(set.contains(AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractDoubleSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableDoubleSet set = this.newWith();
        Assert.assertTrue(set.add(14.0));
        Assert.assertFalse(set.add(14.0));
        Assert.assertTrue(set.add(2.0));
        Assert.assertFalse(set.add(2.0));
        Assert.assertTrue(set.add(35.0));
        Assert.assertFalse(set.add(35.0));
        Assert.assertTrue(set.add(31.0));
        Assert.assertFalse(set.add(31.0));
        Assert.assertTrue(set.add(32.0));
        Assert.assertFalse(set.add(32.0));
        Assert.assertTrue(set.add(0.0));
        Assert.assertFalse(set.add(0.0));
        Assert.assertTrue(set.add(1.0));
        Assert.assertFalse(set.add(1.0));
    }

    @Test
    public void add_NaN() {
        MutableDoubleSet set = this.newWith(Double.NaN);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.NaN));
        Assert.assertFalse(hashSet.add(Double.NaN));
        Assert.assertFalse(set.add(Double.NaN));
        Verify.assertSize(hashSet.size(), set);
    }

    @Test
    public void add_POSITIVE_INFINITY() {
        MutableDoubleSet set = this.newWith(Double.POSITIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.POSITIVE_INFINITY));
        Assert.assertFalse(hashSet.add(Double.POSITIVE_INFINITY));
        Assert.assertFalse(set.add(Double.POSITIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Test
    public void add_NEGATIVE_INFINITY() {
        MutableDoubleSet set = this.newWith(Double.NEGATIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(hashSet.add(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(set.add(Double.NEGATIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new DoubleArrayList()));
        Assert.assertFalse(set.addAll(DoubleArrayList.newListWith(31.0, AbstractDoubleSetTestCase.generateCollisions1().get(0), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 30.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(5.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(AbstractDoubleSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(5)), set);
        DoubleHashSet set1 = new DoubleHashSet();
        Assert.assertTrue(set1.addAll(2.0, 35.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(2.0, 35.0), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0), DoubleSets.mutable.ofAll(DoubleHashBag.newBagWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, 0.0, 1.0, 2.0, 5.0, 30.0, 31.0)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove(15.0));
        Assert.assertFalse(set.remove(15.0));
        Assert.assertTrue(set.remove(0.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractDoubleSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0), set);
        Assert.assertTrue(set.remove(31.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), set);
        Assert.assertTrue(set.remove(1.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll(15.0, AbstractDoubleSetTestCase.generateCollisions1().get(2), AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.removeAll(1.0));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new DoubleArrayList()));
        Assert.assertFalse(set.removeAll(DoubleArrayList.newListWith(15.0, AbstractDoubleSetTestCase.generateCollisions1().get(2), AbstractDoubleSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.removeAll(DoubleHashSet.newSetWith(1.0)));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.retainAll(1.0));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.retainAll(DoubleHashSet.newSetWith(1.0)));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void doubleIterator() {
        MutableSet<Double> expected = UnifiedSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        MutableSet<Double> actual = UnifiedSet.newSet();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        DoubleIterator iterator = set.doubleIterator();
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
    public void doubleIterator_throws() {
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        DoubleIterator iterator = set.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableDoubleSet set = this.newWith(0.0, 2.0, 31.0);
        Double sum = set.injectInto(Double.valueOf(0.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(33.0), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        double[] sum = new double[1];
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        set.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractDoubleSetTestCase.generateCollisions1().getFirst() + AbstractDoubleSetTestCase.generateCollisions1().get(1), sum[0], 0.0);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, set.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, set.count(DoublePredicates.greaterThan(32.0)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, set.select(DoublePredicates.greaterThan(0.0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, set.reject(DoublePredicates.lessThan(32.0)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(0.0, set.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(AbstractDoubleSetTestCase.generateCollisions1().get(1), set.detectIfNone(DoublePredicates.greaterThan(AbstractDoubleSetTestCase.generateCollisions1().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, set.detectIfNone(DoublePredicates.greaterThan(AbstractDoubleSetTestCase.generateCollisions1().get(1)), 9.0), 0.0);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0, 0.0, 30.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst() - 1, AbstractDoubleSetTestCase.generateCollisions1().get(1) - 1), set.collect((double byteParameter) -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new double[] { 0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1) }, set.toSortedArray(), 0.0);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        MutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        MutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
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
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.classUnderTest().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0), this.newWith(0.0, 1.0, 31.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedDoubleSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableDoubleSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0, 6.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0, 6.0), this.newWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0, 4.0, 5.0));
        this.assertUnion(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertUnion(MutableDoubleSet set1, MutableDoubleSet set2, MutableDoubleSet expected) {
        MutableDoubleSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0, 6.0), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0, 6.0), this.newWith(3.0));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith());
        this.assertIntersect(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableDoubleSet set1, MutableDoubleSet set2, MutableDoubleSet expected) {
        MutableDoubleSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(3.0, 4.0, 5.0), this.newWith(1.0, 2.0));
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith());
        this.assertDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertDifference(MutableDoubleSet set1, MutableDoubleSet set2, MutableDoubleSet expected) {
        MutableDoubleSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(2.0, 3.0, 4.0), this.newWith(1.0, 4.0));
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3.0, 4.0, 5.0), this.newWith(3.0, 4.0, 5.0));
        this.assertSymmetricDifference(this.newWith(1.0, 2.0, 3.0), this.newWith(), this.newWith(1.0, 2.0, 3.0));
    }

    private void assertSymmetricDifference(MutableDoubleSet set1, MutableDoubleSet set2, MutableDoubleSet expected) {
        MutableDoubleSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsSubsetOf(this.newWith(1.0, 4.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3.0, 4.0, 5.0), true);
        this.assertIsSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableDoubleSet set1, MutableDoubleSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0, 3.0), true);
        this.assertIsProperSubsetOf(this.newWith(1.0, 4.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3.0, 4.0, 5.0), true);
        this.assertIsProperSubsetOf(this.newWith(1.0, 2.0, 3.0), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableDoubleSet set1, MutableDoubleSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(3.0, 4.0), Sets.mutable.with(PrimitiveTuples.pair(1.0, 3.0), PrimitiveTuples.pair(1.0, 4.0), PrimitiveTuples.pair(2.0, 3.0), PrimitiveTuples.pair(2.0, 4.0)));
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(1.0, 2.0), Sets.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(1.0, 2.0), PrimitiveTuples.pair(2.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)));
        this.assertCartesianProduct(this.newWith(1.0, 2.0), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1.0, 2.0), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableDoubleSet set1, MutableDoubleSet set2, MutableSet<DoubleDoublePair> expected) {
        MutableSet<DoubleDoublePair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleSetTestCase instance;

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
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NEGATIVE_INFINITY);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractDoubleSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractDoubleSetTestCase::newCollection;
            this.payloads.tap = AbstractDoubleSetTestCase::tap;
            this.payloads.contains_NaN = AbstractDoubleSetTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractDoubleSetTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractDoubleSetTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractDoubleSetTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractDoubleSetTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractDoubleSetTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractDoubleSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractDoubleSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractDoubleSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractDoubleSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractDoubleSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractDoubleSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractDoubleSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractDoubleSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractDoubleSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractDoubleSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractDoubleSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractDoubleSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractDoubleSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractDoubleSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractDoubleSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractDoubleSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractDoubleSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractDoubleSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractDoubleSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractDoubleSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractDoubleSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractDoubleSetTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractDoubleSetTestCase::sumConsistentRounding;
            this.payloads.average = AbstractDoubleSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractDoubleSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractDoubleSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractDoubleSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractDoubleSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractDoubleSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractDoubleSetTestCase::testToString;
            this.payloads.makeString = AbstractDoubleSetTestCase::makeString;
            this.payloads.appendString = AbstractDoubleSetTestCase::appendString;
            this.payloads.toList = AbstractDoubleSetTestCase::toList;
            this.payloads.toSortedList = AbstractDoubleSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractDoubleSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractDoubleSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractDoubleSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractDoubleSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractDoubleSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractDoubleSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractDoubleSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractDoubleSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractDoubleSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractDoubleSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractDoubleSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractDoubleSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractDoubleSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractDoubleSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractDoubleSetTestCase::chunk;
            this.payloads.contains = AbstractDoubleSetTestCase::contains;
            this.payloads.addAllArray = AbstractDoubleSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractDoubleSetTestCase::removeIf;
            this.payloads.with = AbstractDoubleSetTestCase::with;
            this.payloads.withAll = AbstractDoubleSetTestCase::withAll;
            this.payloads.without = AbstractDoubleSetTestCase::without;
            this.payloads.withoutAll = AbstractDoubleSetTestCase::withoutAll;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = AbstractDoubleSetTestCase::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = AbstractDoubleSetTestCase::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = AbstractDoubleSetTestCase::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractDoubleSetTestCase::newEmpty;
            this.payloads.size = AbstractDoubleSetTestCase::size;
            this.payloads.isEmpty = AbstractDoubleSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractDoubleSetTestCase::notEmpty;
            this.payloads.clear = AbstractDoubleSetTestCase::clear;
            this.payloads.add = AbstractDoubleSetTestCase::add;
            this.payloads.add_NaN = AbstractDoubleSetTestCase::add_NaN;
            this.payloads.add_POSITIVE_INFINITY = AbstractDoubleSetTestCase::add_POSITIVE_INFINITY;
            this.payloads.add_NEGATIVE_INFINITY = AbstractDoubleSetTestCase::add_NEGATIVE_INFINITY;
            this.payloads.addAllIterable = AbstractDoubleSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractDoubleSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractDoubleSetTestCase::remove;
            this.payloads.removeAll = AbstractDoubleSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractDoubleSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractDoubleSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractDoubleSetTestCase::retainAll_iterable;
            this.payloads.doubleIterator = AbstractDoubleSetTestCase::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleSetTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractDoubleSetTestCase::injectInto;
            this.payloads.forEach = AbstractDoubleSetTestCase::forEach;
            this.payloads.count = AbstractDoubleSetTestCase::count;
            this.payloads.select = AbstractDoubleSetTestCase::select;
            this.payloads.reject = AbstractDoubleSetTestCase::reject;
            this.payloads.detectIfNone = AbstractDoubleSetTestCase::detectIfNone;
            this.payloads.collect = AbstractDoubleSetTestCase::collect;
            this.payloads.toSortedArray = AbstractDoubleSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractDoubleSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractDoubleSetTestCase::testHashCode;
            this.payloads.toBag = AbstractDoubleSetTestCase::toBag;
            this.payloads.asLazy = AbstractDoubleSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractDoubleSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractDoubleSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractDoubleSetTestCase::union;
            this.payloads.intersect = AbstractDoubleSetTestCase::intersect;
            this.payloads.difference = AbstractDoubleSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractDoubleSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractDoubleSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractDoubleSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractDoubleSetTestCase::cartesianProduct;
        }
    }
}
