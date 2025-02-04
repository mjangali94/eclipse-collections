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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongSetTestCase instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractLongSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractLongSetTestCase::newCollection;
            this.payloads.tap = AbstractLongSetTestCase::tap;
            this.payloads.containsAllArray = AbstractLongSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLongSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractLongSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractLongSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractLongSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractLongSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractLongSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLongSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLongSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractLongSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractLongSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractLongSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractLongSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractLongSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractLongSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractLongSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractLongSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractLongSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractLongSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLongSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractLongSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractLongSetTestCase::summaryStatistics;
            this.payloads.average = AbstractLongSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractLongSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractLongSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractLongSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractLongSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractLongSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractLongSetTestCase::testToString;
            this.payloads.makeString = AbstractLongSetTestCase::makeString;
            this.payloads.appendString = AbstractLongSetTestCase::appendString;
            this.payloads.toList = AbstractLongSetTestCase::toList;
            this.payloads.toSortedList = AbstractLongSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractLongSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractLongSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractLongSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractLongSetTestCase::toSet;
            this.payloads.injectIntoBoolean = AbstractLongSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractLongSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractLongSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractLongSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractLongSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractLongSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractLongSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractLongSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractLongSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractLongSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractLongSetTestCase::chunk;
            this.payloads.contains = AbstractLongSetTestCase::contains;
            this.payloads.addAllArray = AbstractLongSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractLongSetTestCase::removeIf;
            this.payloads.with = AbstractLongSetTestCase::with;
            this.payloads.withAll = AbstractLongSetTestCase::withAll;
            this.payloads.without = AbstractLongSetTestCase::without;
            this.payloads.withoutAll = AbstractLongSetTestCase::withoutAll;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = AbstractLongSetTestCase::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = AbstractLongSetTestCase::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = AbstractLongSetTestCase::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractLongSetTestCase::newEmpty;
            this.payloads.size = AbstractLongSetTestCase::size;
            this.payloads.isEmpty = AbstractLongSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLongSetTestCase::notEmpty;
            this.payloads.clear = AbstractLongSetTestCase::clear;
            this.payloads.add = AbstractLongSetTestCase::add;
            this.payloads.addAllIterable = AbstractLongSetTestCase::addAllIterable;
            this.payloads.testOfAllFactory = AbstractLongSetTestCase::testOfAllFactory;
            this.payloads.remove = AbstractLongSetTestCase::remove;
            this.payloads.removeAll = AbstractLongSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractLongSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractLongSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractLongSetTestCase::retainAll_iterable;
            this.payloads.longIterator = AbstractLongSetTestCase::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongSetTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractLongSetTestCase::injectInto;
            this.payloads.forEach = AbstractLongSetTestCase::forEach;
            this.payloads.count = AbstractLongSetTestCase::count;
            this.payloads.select = AbstractLongSetTestCase::select;
            this.payloads.reject = AbstractLongSetTestCase::reject;
            this.payloads.detectIfNone = AbstractLongSetTestCase::detectIfNone;
            this.payloads.collect = AbstractLongSetTestCase::collect;
            this.payloads.toSortedArray = AbstractLongSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractLongSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractLongSetTestCase::testHashCode;
            this.payloads.toBag = AbstractLongSetTestCase::toBag;
            this.payloads.asLazy = AbstractLongSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractLongSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractLongSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractLongSetTestCase::union;
            this.payloads.intersect = AbstractLongSetTestCase::intersect;
            this.payloads.difference = AbstractLongSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractLongSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractLongSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractLongSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractLongSetTestCase::cartesianProduct;
        }
    }
*/
}
