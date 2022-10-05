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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase._Benchmark {

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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add_NaN, this.description("add_NaN"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add_POSITIVE_INFINITY, this.description("add_POSITIVE_INFINITY"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add_NEGATIVE_INFINITY, this.description("add_NEGATIVE_INFINITY"));
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator, this.description("doubleIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::doubleIterator_throws, this.description("doubleIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractDoubleSetTestCase implementation();
    }
}
