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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableLongSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractLongSetTestCase extends AbstractMutableLongCollectionTestCase {

    protected static LongArrayList generateCollisions1() {
        LongArrayList collisions = new LongArrayList();
        LongHashSet set = new LongHashSet();
        for (long i = 32L; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask(32L)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static LongArrayList generateNonCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongHashSet set = new LongHashSet();
        for (long i = 32L; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) != set.spreadAndMask(32L)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableLongSet classUnderTest();

    @Override
    protected abstract MutableLongSet newWith(long... elements);

    @Override
    protected MutableLongSet newMutableCollectionWith(long... elements) {
        return LongHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Long> newObjectCollectionWith(Long... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains(0L));
        Assert.assertFalse(set.contains(31L));
        Assert.assertFalse(set.contains(1L));
        Assert.assertFalse(set.contains(AbstractLongSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractLongSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableLongSet set = this.newWith();
        Assert.assertTrue(set.add(14L));
        Assert.assertFalse(set.add(14L));
        Assert.assertTrue(set.add(2L));
        Assert.assertFalse(set.add(2L));
        Assert.assertTrue(set.add(35L));
        Assert.assertFalse(set.add(35L));
        Assert.assertTrue(set.add(31L));
        Assert.assertFalse(set.add(31L));
        Assert.assertTrue(set.add(32L));
        Assert.assertFalse(set.add(32L));
        Assert.assertTrue(set.add(0L));
        Assert.assertFalse(set.add(0L));
        Assert.assertTrue(set.add(1L));
        Assert.assertFalse(set.add(1L));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new LongArrayList()));
        Assert.assertFalse(set.addAll(LongArrayList.newListWith(31L, AbstractLongSetTestCase.generateCollisions1().get(0), AbstractLongSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.addAll(LongHashSet.newSetWith(0L, 1L, 2L, 30L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 30L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1), AbstractLongSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(LongHashSet.newSetWith(5L)));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 5L, 30L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1), AbstractLongSetTestCase.generateCollisions1().get(4)), set);
        Assert.assertTrue(set.addAll(LongHashSet.newSetWith(AbstractLongSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 5L, 30L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1), AbstractLongSetTestCase.generateCollisions1().get(4), AbstractLongSetTestCase.generateCollisions1().get(5)), set);
        LongHashSet set1 = new LongHashSet();
        Assert.assertTrue(set1.addAll(2L, 35L));
        Assert.assertEquals(LongHashSet.newSetWith(2L, 35L), set1);
    }

    @Test
    public void testOfAllFactory() {
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 5L, 30L, 31L), LongSets.mutable.ofAll(LongHashBag.newBagWith(0L, 1L, 2L, 5L, 30L, 31L, 0L, 1L, 2L, 5L, 30L, 31L)));
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove(15L));
        Assert.assertFalse(set.remove(15L));
        Assert.assertTrue(set.remove(0L));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractLongSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractLongSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractLongSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractLongSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(LongHashSet.newSetWith(1L, 31L), set);
        Assert.assertTrue(set.remove(31L));
        Assert.assertEquals(LongHashSet.newSetWith(1L), set);
        Assert.assertTrue(set.remove(1L));
        Assert.assertEquals(LongHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll(15L, AbstractLongSetTestCase.generateCollisions1().get(2), AbstractLongSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(LongHashSet.newSetWith(1L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(1L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new LongHashSet(), set);
        Assert.assertFalse(set.removeAll(1L));
        Assert.assertEquals(new LongHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new LongArrayList()));
        Assert.assertFalse(set.removeAll(LongArrayList.newListWith(15L, AbstractLongSetTestCase.generateCollisions1().get(2), AbstractLongSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(LongHashSet.newSetWith(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(LongHashSet.newSetWith(1L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(LongHashSet.newSetWith(1L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new LongHashSet(), set);
        Assert.assertFalse(set.removeAll(LongHashSet.newSetWith(1L)));
        Assert.assertEquals(new LongHashSet(), set);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(4), AbstractLongSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(1L, AbstractLongSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new LongHashSet(), set);
        Assert.assertFalse(set.retainAll(1L));
        Assert.assertEquals(new LongHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(LongHashSet.newSetWith(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(4), AbstractLongSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, AbstractLongSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(LongHashSet.newSetWith(1L, AbstractLongSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new LongHashSet(), set);
        Assert.assertFalse(set.retainAll(LongHashSet.newSetWith(1L)));
        Assert.assertEquals(new LongHashSet(), set);
    }

    @Override
    @Test
    public void longIterator() {
        MutableSet<Long> expected = UnifiedSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        MutableSet<Long> actual = UnifiedSet.newSet();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        LongIterator iterator = set.longIterator();
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
    public void longIterator_throws() {
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        LongIterator iterator = set.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableLongSet set = this.newWith(0L, 2L, 31L);
        Long sum = set.injectInto(Long.valueOf(0L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(33L), sum);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        set.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(32L + AbstractLongSetTestCase.generateCollisions1().getFirst() + AbstractLongSetTestCase.generateCollisions1().get(1), sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(LongPredicates.greaterThan(0L)));
        Assert.assertEquals(3L, set.count(LongPredicates.lessThan(32L)));
        Assert.assertEquals(1L, set.count(LongPredicates.greaterThan(32L)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(LongPredicates.lessThan(32L)));
        Verify.assertSize(4, set.select(LongPredicates.greaterThan(0L)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(LongPredicates.greaterThan(0L)));
        Verify.assertSize(2, set.reject(LongPredicates.lessThan(32L)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(0L, set.detectIfNone(LongPredicates.lessThan(1L), 9L));
        Assert.assertEquals(AbstractLongSetTestCase.generateCollisions1().get(1), set.detectIfNone(LongPredicates.greaterThan(AbstractLongSetTestCase.generateCollisions1().getFirst()), 9L));
        Assert.assertEquals(9L, set.detectIfNone(LongPredicates.greaterThan(AbstractLongSetTestCase.generateCollisions1().get(1)), 9L));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1L, 0L, 30L, AbstractLongSetTestCase.generateCollisions1().getFirst() - 1, AbstractLongSetTestCase.generateCollisions1().get(1) - 1), set.collect((long byteParameter) -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new long[] { 0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1) }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableLongSet set1 = this.newWith(1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L);
        MutableLongSet set3 = this.newWith(32L, 32L, 31L, 1L);
        MutableLongSet set4 = this.newWith(32L, 32L, 31L, 1L, 1L);
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
        MutableLongSet set1 = this.newWith(1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.classUnderTest().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L), this.newWith(0L, 1L, 31L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedLongSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedLongSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableLongSet set = this.newWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableLongSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongSet(set), set.asUnmodifiable());
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L, 3L, 4L, 5L));
        this.assertUnion(this.newWith(1L, 2L, 3L, 6L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L, 3L, 4L, 5L, 6L));
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L, 6L), this.newWith(1L, 2L, 3L, 4L, 5L, 6L));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith(3L, 4L, 5L));
        this.assertUnion(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertUnion(MutableLongSet set1, MutableLongSet set2, MutableLongSet expected) {
        MutableLongSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(3L));
        this.assertIntersect(this.newWith(1L, 2L, 3L, 6L), this.newWith(3L, 4L, 5L), this.newWith(3L));
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L, 6L), this.newWith(3L));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith());
        this.assertIntersect(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableLongSet set1, MutableLongSet set2, MutableLongSet expected) {
        MutableLongSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(3L, 4L, 5L), this.newWith(1L, 2L));
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith());
        this.assertDifference(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertDifference(MutableLongSet set1, MutableLongSet set2, MutableLongSet expected) {
        MutableLongSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(2L, 3L, 4L), this.newWith(1L, 4L));
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(3L, 4L, 5L), this.newWith(3L, 4L, 5L));
        this.assertSymmetricDifference(this.newWith(1L, 2L, 3L), this.newWith(), this.newWith(1L, 2L, 3L));
    }

    private void assertSymmetricDifference(MutableLongSet set1, MutableLongSet set2, MutableLongSet expected) {
        MutableLongSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith(1L, 2L), this.newWith(1L, 2L, 3L), true);
        this.assertIsSubsetOf(this.newWith(1L, 4L), this.newWith(1L, 2L, 3L), false);
        this.assertIsSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(3L, 4L, 5L), true);
        this.assertIsSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableLongSet set1, MutableLongSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith(1L, 2L), this.newWith(1L, 2L, 3L), true);
        this.assertIsProperSubsetOf(this.newWith(1L, 4L), this.newWith(1L, 2L, 3L), false);
        this.assertIsProperSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(3L, 4L, 5L), true);
        this.assertIsProperSubsetOf(this.newWith(1L, 2L, 3L), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableLongSet set1, MutableLongSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cartesianProduct() {
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(3L, 4L), Sets.mutable.with(PrimitiveTuples.pair(1L, 3L), PrimitiveTuples.pair(1L, 4L), PrimitiveTuples.pair(2L, 3L), PrimitiveTuples.pair(2L, 4L)));
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(1L, 2L), Sets.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(1L, 2L), PrimitiveTuples.pair(2L, 1L), PrimitiveTuples.pair(2L, 2L)));
        this.assertCartesianProduct(this.newWith(1L, 2L), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(1L, 2L), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableLongSet set1, MutableLongSet set2, MutableSet<LongLongPair> expected) {
        MutableSet<LongLongPair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase._Benchmark {

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::longIterator_throws, this.description("longIterator_throws"), java.util.NoSuchElementException.class);
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
        public abstract AbstractLongSetTestCase implementation();
    }
}
