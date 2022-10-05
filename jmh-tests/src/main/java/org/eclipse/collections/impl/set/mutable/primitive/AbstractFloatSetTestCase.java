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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatSetTestCase instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NEGATIVE_INFINITY);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractFloatSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractFloatSetTestCase::newCollection;
            this.payloads.tap = AbstractFloatSetTestCase::tap;
            this.payloads.contains_NaN = AbstractFloatSetTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractFloatSetTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractFloatSetTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractFloatSetTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractFloatSetTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractFloatSetTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractFloatSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractFloatSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractFloatSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractFloatSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractFloatSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractFloatSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractFloatSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractFloatSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractFloatSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractFloatSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractFloatSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractFloatSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractFloatSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractFloatSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractFloatSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractFloatSetTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractFloatSetTestCase::sumConsistentRounding;
            this.payloads.average = AbstractFloatSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractFloatSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractFloatSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractFloatSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractFloatSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractFloatSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractFloatSetTestCase::testToString;
            this.payloads.makeString = AbstractFloatSetTestCase::makeString;
            this.payloads.appendString = AbstractFloatSetTestCase::appendString;
            this.payloads.toList = AbstractFloatSetTestCase::toList;
            this.payloads.toSortedList = AbstractFloatSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractFloatSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractFloatSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractFloatSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractFloatSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractFloatSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractFloatSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractFloatSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractFloatSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractFloatSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractFloatSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractFloatSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractFloatSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractFloatSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractFloatSetTestCase::chunk;
            this.payloads.contains = AbstractFloatSetTestCase::contains;
            this.payloads.addAllArray = AbstractFloatSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractFloatSetTestCase::removeIf;
            this.payloads.with = AbstractFloatSetTestCase::with;
            this.payloads.withAll = AbstractFloatSetTestCase::withAll;
            this.payloads.without = AbstractFloatSetTestCase::without;
            this.payloads.withoutAll = AbstractFloatSetTestCase::withoutAll;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = AbstractFloatSetTestCase::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = AbstractFloatSetTestCase::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = AbstractFloatSetTestCase::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractFloatSetTestCase::newEmpty;
            this.payloads.size = AbstractFloatSetTestCase::size;
            this.payloads.isEmpty = AbstractFloatSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatSetTestCase::notEmpty;
            this.payloads.clear = AbstractFloatSetTestCase::clear;
            this.payloads.add = AbstractFloatSetTestCase::add;
            this.payloads.add_NaN = AbstractFloatSetTestCase::add_NaN;
            this.payloads.add_POSITIVE_INFINITY = AbstractFloatSetTestCase::add_POSITIVE_INFINITY;
            this.payloads.add_NEGATIVE_INFINITY = AbstractFloatSetTestCase::add_NEGATIVE_INFINITY;
            this.payloads.addAllIterable = AbstractFloatSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractFloatSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractFloatSetTestCase::remove;
            this.payloads.removeAll = AbstractFloatSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractFloatSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractFloatSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractFloatSetTestCase::retainAll_iterable;
            this.payloads.floatIterator = AbstractFloatSetTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatSetTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractFloatSetTestCase::injectInto;
            this.payloads.forEach = AbstractFloatSetTestCase::forEach;
            this.payloads.count = AbstractFloatSetTestCase::count;
            this.payloads.select = AbstractFloatSetTestCase::select;
            this.payloads.reject = AbstractFloatSetTestCase::reject;
            this.payloads.detectIfNone = AbstractFloatSetTestCase::detectIfNone;
            this.payloads.collect = AbstractFloatSetTestCase::collect;
            this.payloads.toSortedArray = AbstractFloatSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractFloatSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatSetTestCase::testHashCode;
            this.payloads.toBag = AbstractFloatSetTestCase::toBag;
            this.payloads.asLazy = AbstractFloatSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractFloatSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractFloatSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractFloatSetTestCase::union;
            this.payloads.intersect = AbstractFloatSetTestCase::intersect;
            this.payloads.difference = AbstractFloatSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractFloatSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractFloatSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractFloatSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractFloatSetTestCase::cartesianProduct;
        }
    }
}
