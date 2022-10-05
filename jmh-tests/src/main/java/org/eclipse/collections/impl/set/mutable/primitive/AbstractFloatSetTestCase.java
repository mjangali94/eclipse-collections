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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableFloatSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractFloatSetTestCase extends AbstractMutableFloatCollectionTestCase {

    protected static FloatArrayList generateCollisions1() {
        FloatArrayList collisions = new FloatArrayList();
        FloatHashSet set = new FloatHashSet();
        for (float i = 32.0f; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0f)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static FloatArrayList generateNonCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatHashSet set = new FloatHashSet();
        for (float i = 32.0f; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask(32.0f)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableFloatSet classUnderTest();

    @Override
    protected abstract MutableFloatSet newWith(float... elements);

    @Override
    protected MutableFloatSet newMutableCollectionWith(float... elements) {
        return FloatHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Float> newObjectCollectionWith(Float... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains(0.0f));
        Assert.assertFalse(set.contains(31.0f));
        Assert.assertFalse(set.contains(1.0f));
        Assert.assertFalse(set.contains(AbstractFloatSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractFloatSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableFloatSet set = this.newWith();
        Assert.assertTrue(set.add(14.0f));
        Assert.assertFalse(set.add(14.0f));
        Assert.assertTrue(set.add(2.0f));
        Assert.assertFalse(set.add(2.0f));
        Assert.assertTrue(set.add(35.0f));
        Assert.assertFalse(set.add(35.0f));
        Assert.assertTrue(set.add(31.0f));
        Assert.assertFalse(set.add(31.0f));
        Assert.assertTrue(set.add(32.0f));
        Assert.assertFalse(set.add(32.0f));
        Assert.assertTrue(set.add(0.0f));
        Assert.assertFalse(set.add(0.0f));
        Assert.assertTrue(set.add(1.0f));
        Assert.assertFalse(set.add(1.0f));
    }

    @Test
    public void add_NaN() {
        MutableFloatSet set = this.newWith(Float.NaN);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.NaN));
        Assert.assertFalse(hashSet.add(Float.NaN));
        Assert.assertFalse(set.add(Float.NaN));
        Verify.assertSize(hashSet.size(), set);
    }

    @Test
    public void add_POSITIVE_INFINITY() {
        MutableFloatSet set = this.newWith(Float.POSITIVE_INFINITY);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.POSITIVE_INFINITY));
        Assert.assertFalse(hashSet.add(Float.POSITIVE_INFINITY));
        Assert.assertFalse(set.add(Float.POSITIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Test
    public void add_NEGATIVE_INFINITY() {
        MutableFloatSet set = this.newWith(Float.NEGATIVE_INFINITY);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.NEGATIVE_INFINITY));
        Assert.assertFalse(hashSet.add(Float.NEGATIVE_INFINITY));
        Assert.assertFalse(set.add(Float.NEGATIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new FloatArrayList()));
        Assert.assertFalse(set.addAll(FloatArrayList.newListWith(31.0f, AbstractFloatSetTestCase.generateCollisions1().get(0), AbstractFloatSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 30.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 30.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1), AbstractFloatSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(FloatHashSet.newSetWith(5.0f)));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 5.0f, 30.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1), AbstractFloatSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(FloatHashSet.newSetWith(AbstractFloatSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 5.0f, 30.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1), AbstractFloatSetTestCase.generateCollisions1().get(4), AbstractFloatSetTestCase.generateCollisions1().get(5)), set);
        FloatHashSet set1 = new FloatHashSet();
        Assert.assertTrue(set1.addAll(2.0f, 35.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(2.0f, 35.0f), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 5.0f, 30.0f, 31.0f), FloatSets.mutable.ofAll(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f, 5.0f, 30.0f, 31.0f, 0.0f, 1.0f, 2.0f, 5.0f, 30.0f, 31.0f)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove(15.0f));
        Assert.assertFalse(set.remove(15.0f));
        Assert.assertTrue(set.remove(0.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractFloatSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractFloatSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractFloatSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractFloatSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 31.0f), set);
        Assert.assertTrue(set.remove(31.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), set);
        Assert.assertTrue(set.remove(1.0f));
        Assert.assertEquals(FloatHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll(15.0f, AbstractFloatSetTestCase.generateCollisions1().get(2), AbstractFloatSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new FloatHashSet(), set);
        Assert.assertFalse(set.removeAll(1.0f));
        Assert.assertEquals(new FloatHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new FloatArrayList()));
        Assert.assertFalse(set.removeAll(FloatArrayList.newListWith(15.0f, AbstractFloatSetTestCase.generateCollisions1().get(2), AbstractFloatSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(FloatHashSet.newSetWith(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(FloatHashSet.newSetWith(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new FloatHashSet(), set);
        Assert.assertFalse(set.removeAll(FloatHashSet.newSetWith(1.0f)));
        Assert.assertEquals(new FloatHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(4), AbstractFloatSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new FloatHashSet(), set);
        Assert.assertFalse(set.retainAll(1.0f));
        Assert.assertEquals(new FloatHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(FloatHashSet.newSetWith(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(4), AbstractFloatSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(FloatHashSet.newSetWith(1.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new FloatHashSet(), set);
        Assert.assertFalse(set.retainAll(FloatHashSet.newSetWith(1.0f)));
        Assert.assertEquals(new FloatHashSet(), set);
    }

    @Override
    @Test
    public void floatIterator() {
        MutableSet<Float> expected = UnifiedSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        MutableSet<Float> actual = UnifiedSet.newSet();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        FloatIterator iterator = set.floatIterator();
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
    public void floatIterator_throws() {
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        FloatIterator iterator = set.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableFloatSet set = this.newWith(0.0f, 2.0f, 31.0f);
        Float sum = set.injectInto(Float.valueOf(0.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(33.0f), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        double[] sum = new double[1];
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        set.forEach((float each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractFloatSetTestCase.generateCollisions1().getFirst() + AbstractFloatSetTestCase.generateCollisions1().get(1), sum[0], 0.0f);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(FloatPredicates.greaterThan(0.0f)));
        Assert.assertEquals(3L, set.count(FloatPredicates.lessThan(32.0f)));
        Assert.assertEquals(1L, set.count(FloatPredicates.greaterThan(32.0f)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(FloatPredicates.lessThan(32.0f)));
        Verify.assertSize(4, set.select(FloatPredicates.greaterThan(0.0f)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(FloatPredicates.greaterThan(0.0f)));
        Verify.assertSize(2, set.reject(FloatPredicates.lessThan(32.0f)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(0.0f, set.detectIfNone(FloatPredicates.lessThan(1.0f), 9.0f), 0.0f);
        Assert.assertEquals(AbstractFloatSetTestCase.generateCollisions1().get(1), set.detectIfNone(FloatPredicates.greaterThan(AbstractFloatSetTestCase.generateCollisions1().getFirst()), 9.0f), 0.0f);
        Assert.assertEquals(9.0f, set.detectIfNone(FloatPredicates.greaterThan(AbstractFloatSetTestCase.generateCollisions1().get(1)), 9.0f), 0.0f);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0f, 0.0f, 30.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst() - 1, AbstractFloatSetTestCase.generateCollisions1().get(1) - 1), set.collect((float byteParameter) -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new float[] { 0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1) }, set.toSortedArray(), 0.0f);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        MutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        MutableFloatSet set3 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f);
        MutableFloatSet set4 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f, 1.0f);
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
        MutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        MutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f), this.newWith(0.0f, 1.0f, 31.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedFloatSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedFloatSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableFloatSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f, 6.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f, 6.0f), this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f, 4.0f, 5.0f));
        this.assertUnion(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertUnion(MutableFloatSet set1, MutableFloatSet set2, MutableFloatSet expected) {
        MutableFloatSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f, 6.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f, 6.0f), this.newWith(3.0f));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith());
        this.assertIntersect(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableFloatSet set1, MutableFloatSet set2, MutableFloatSet expected) {
        MutableFloatSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(1.0f, 2.0f));
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith());
        this.assertDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertDifference(MutableFloatSet set1, MutableFloatSet set2, MutableFloatSet expected) {
        MutableFloatSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(2.0f, 3.0f, 4.0f), this.newWith(1.0f, 4.0f));
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), this.newWith(3.0f, 4.0f, 5.0f));
        this.assertSymmetricDifference(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), this.newWith(1.0f, 2.0f, 3.0f));
    }

    private void assertSymmetricDifference(MutableFloatSet set1, MutableFloatSet set2, MutableFloatSet expected) {
        MutableFloatSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsSubsetOf(this.newWith(1.0f, 4.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), true);
        this.assertIsSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableFloatSet set1, MutableFloatSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f), true);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 4.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3.0f, 4.0f, 5.0f), true);
        this.assertIsProperSubsetOf(this.newWith(1.0f, 2.0f, 3.0f), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableFloatSet set1, MutableFloatSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(3.0f, 4.0f), Sets.mutable.with(PrimitiveTuples.pair(1.0f, 3.0f), PrimitiveTuples.pair(1.0f, 4.0f), PrimitiveTuples.pair(2.0f, 3.0f), PrimitiveTuples.pair(2.0f, 4.0f)));
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(1.0f, 2.0f), Sets.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(1.0f, 2.0f), PrimitiveTuples.pair(2.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)));
        this.assertCartesianProduct(this.newWith(1.0f, 2.0f), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1.0f, 2.0f), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableFloatSet set1, MutableFloatSet set2, MutableSet<FloatFloatPair> expected) {
        MutableSet<FloatFloatPair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase._Benchmark {

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::floatIterator_throws, this.description("floatIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractFloatSetTestCase implementation();
    }
}
