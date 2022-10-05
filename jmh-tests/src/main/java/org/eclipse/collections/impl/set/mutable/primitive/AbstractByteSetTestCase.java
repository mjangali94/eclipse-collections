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
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableByteSet}.
 */
public abstract class AbstractByteSetTestCase extends AbstractMutableByteCollectionTestCase {

    @Override
    protected abstract MutableByteSet classUnderTest();

    @Override
    protected abstract MutableByteSet newWith(byte... elements);

    @Override
    protected MutableByteSet newMutableCollectionWith(byte... elements) {
        return ByteHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Byte> newObjectCollectionWith(Byte... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(5, this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128).isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128).notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128);
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains((byte) 0));
        Assert.assertFalse(set.contains((byte) 31));
        Assert.assertFalse(set.contains((byte) 1));
        Assert.assertFalse(set.contains((byte) -1));
        Assert.assertFalse(set.contains((byte) -128));
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableByteSet set = this.newWith();
        Assert.assertTrue(set.add((byte) 14));
        Assert.assertFalse(set.add((byte) 14));
        Assert.assertTrue(set.add((byte) 2));
        Assert.assertFalse(set.add((byte) 2));
        Assert.assertTrue(set.add((byte) 35));
        Assert.assertFalse(set.add((byte) 35));
        Assert.assertTrue(set.add((byte) 31));
        Assert.assertFalse(set.add((byte) 31));
        Assert.assertTrue(set.add((byte) 32));
        Assert.assertFalse(set.add((byte) 32));
        Assert.assertTrue(set.add((byte) 0));
        Assert.assertFalse(set.add((byte) 0));
        Assert.assertTrue(set.add((byte) 1));
        Assert.assertFalse(set.add((byte) 1));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128);
        Assert.assertFalse(set.addAll(new ByteArrayList()));
        Assert.assertFalse(set.addAll(ByteArrayList.newListWith((byte) 31, (byte) -1, (byte) -128)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -128), set);
        Assert.assertTrue(set.addAll(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2, (byte) 30, (byte) -1, (byte) -128)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2, (byte) 30, (byte) 31, (byte) -1, (byte) -128), set);
        Assert.assertTrue(set.addAll(ByteHashSet.newSetWith((byte) 5)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2, (byte) 5, (byte) 30, (byte) 31, (byte) 31, (byte) -1, (byte) -128), set);
        MutableByteSet set1 = new ByteHashSet();
        Assert.assertTrue(set1.addAll((byte) 2, (byte) 35));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 2, (byte) 35), set1);
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -8);
        Assert.assertFalse(this.newWith().remove((byte) 15));
        Assert.assertFalse(set.remove((byte) 15));
        Assert.assertTrue(set.remove((byte) 0));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 31, (byte) -1, (byte) -8), set);
        Assert.assertFalse(set.remove((byte) -10));
        Assert.assertFalse(set.remove((byte) -7));
        Assert.assertTrue(set.remove((byte) -1));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 31, (byte) -8), set);
        Assert.assertTrue(set.remove((byte) -8));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 31), set);
        Assert.assertTrue(set.remove((byte) 31));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), set);
        Assert.assertTrue(set.remove((byte) 1));
        Assert.assertEquals(ByteHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128);
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll((byte) 15, (byte) -5, (byte) -32));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128), set);
        Assert.assertTrue(set.removeAll((byte) 0, (byte) 1, (byte) -1, (byte) -128));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -35, (byte) -64, (byte) -100), set);
        Assert.assertTrue(set.removeAll((byte) 31, (byte) 63, (byte) 14, (byte) -100));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 100, (byte) 127, (byte) -35, (byte) -64), set);
        Assert.assertFalse(set.removeAll((byte) -34, (byte) -36, (byte) -63, (byte) -65, (byte) 99, (byte) 101, (byte) 126, (byte) 128));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 100, (byte) 127, (byte) -35, (byte) -64), set);
        Assert.assertTrue(set.removeAll((byte) -35, (byte) -63, (byte) -64, (byte) 100, (byte) 127));
        Assert.assertEquals(new ByteHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128);
        Assert.assertFalse(set.removeAll(new ByteArrayList()));
        Assert.assertFalse(set.removeAll(ByteArrayList.newListWith((byte) 15, (byte) 98, (byte) -98, (byte) -127)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128), set);
        Assert.assertTrue(set.removeAll(ByteHashSet.newSetWith((byte) 0, (byte) 31, (byte) -128, (byte) -100)));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64), set);
        Assert.assertTrue(set.removeAll(ByteHashSet.newSetWith((byte) 1, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64)));
        Assert.assertEquals(new ByteHashSet(), set);
        Assert.assertFalse(set.removeAll(ByteHashSet.newSetWith((byte) 1)));
        Assert.assertEquals(new ByteHashSet(), set);
    }

    @Override
    @Test
    public void byteIterator() {
        MutableSet<Byte> expected = UnifiedSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128);
        MutableSet<Byte> actual = UnifiedSet.newSet();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 100, (byte) 127, (byte) -1, (byte) -35, (byte) -64, (byte) -100, (byte) -128);
        ByteIterator iterator = set.byteIterator();
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
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws() {
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -31);
        ByteIterator iterator = set.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 65, (byte) 100, (byte) 127, (byte) 12, (byte) -76, (byte) -1, (byte) -54, (byte) -64, (byte) -63, (byte) -95, (byte) -128, (byte) -127);
        set.forEach(each -> sum[0] += each);
        Assert.assertEquals(-209L, sum[0]);
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 65, (byte) 100, (byte) 127, (byte) 12, (byte) -76, (byte) -1, (byte) -54, (byte) -64, (byte) -63, (byte) -95, (byte) -128, (byte) -127);
        Assert.assertEquals(7L, set.count(BytePredicates.greaterThan((byte) 0)));
        Assert.assertEquals(12L, set.count(BytePredicates.lessThan((byte) 32)));
        Assert.assertEquals(4L, set.count(BytePredicates.greaterThan((byte) 32)));
        Assert.assertEquals(1L, set.count(BytePredicates.greaterThan((byte) 100)));
        Assert.assertEquals(14L, set.count(BytePredicates.lessThan((byte) 100)));
        Assert.assertEquals(7L, set.count(BytePredicates.lessThan((byte) -50)));
        Assert.assertEquals(6L, set.count(BytePredicates.lessThan((byte) -54)));
        Assert.assertEquals(15L, set.count(BytePredicates.greaterThan((byte) -128)));
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 63, (byte) 65, (byte) 100, (byte) 127, (byte) 12, (byte) -76, (byte) -1, (byte) -54, (byte) -64, (byte) -63, (byte) -95, (byte) -128, (byte) -127);
        Assert.assertEquals(this.newWith((byte) 63, (byte) 65, (byte) 100, (byte) 127), set.select(BytePredicates.greaterThan((byte) 32)));
        Assert.assertEquals(this.newWith((byte) -76, (byte) -1, (byte) -54, (byte) -64, (byte) -63, (byte) -95, (byte) -128, (byte) -127), set.select(BytePredicates.lessThan((byte) 0)));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -127, (byte) -63);
        Assert.assertEquals(this.newWith((byte) 0, (byte) -1, (byte) -127, (byte) -63), set.reject(BytePredicates.greaterThan((byte) 0)));
        Assert.assertEquals(this.newWith((byte) 0, (byte) 1, (byte) 31), set.reject(BytePredicates.lessThan((byte) 0)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 64, (byte) 127, (byte) -1, (byte) -67, (byte) -128, (byte) -63);
        Assert.assertEquals(127, set.detectIfNone(BytePredicates.greaterThan((byte) 126), (byte) 9));
        Assert.assertEquals(127, set.detectIfNone(BytePredicates.greaterThan((byte) 64), (byte) 9));
        Assert.assertEquals(-128, set.detectIfNone(BytePredicates.lessThan((byte) -68), (byte) 9));
        MutableByteSet set1 = this.newWith((byte) 0, (byte) -1, (byte) 12, (byte) 64);
        Assert.assertEquals(-1, set1.detectIfNone(BytePredicates.lessThan((byte) 0), (byte) 9));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -127, (byte) -63);
        Assert.assertEquals(UnifiedSet.newSetWith((byte) -1, (byte) 0, (byte) 30, (byte) -128, (byte) -64), set.collect(byteParameter -> (byte) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray() {
        super.toSortedArray();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -123, (byte) -53);
        Assert.assertArrayEquals(new byte[] { (byte) -123, (byte) -53, (byte) -1, (byte) 0, (byte) 1, (byte) 31 }, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableByteSet set1 = this.newWith((byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set3 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set4 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1, (byte) 1);
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
        MutableByteSet set1 = this.newWith((byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 31), this.newWith((byte) 0, (byte) 1, (byte) 31).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 31, (byte) 32), this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).toBag());
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -31, (byte) -24);
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -31, (byte) -24);
        Verify.assertInstanceOf(SynchronizedByteSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedByteSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableByteSet set = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -31, (byte) -24);
        Verify.assertInstanceOf(UnmodifiableByteSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteSet(set), set.asUnmodifiable());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteSets.class);
    }

    @Test
    public void union() {
        this.assertUnion(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        this.assertUnion(this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 6), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        this.assertUnion(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 3, (byte) 4, (byte) 5, (byte) 6), this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        this.assertUnion(this.newWith(), this.newWith(), this.newWith());
        this.assertUnion(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 3, (byte) 4, (byte) 5));
        this.assertUnion(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), this.newWith((byte) 1, (byte) 2, (byte) 3));
    }

    private void assertUnion(MutableByteSet set1, MutableByteSet set2, MutableByteSet expected) {
        MutableByteSet actual = set1.union(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void intersect() {
        this.assertIntersect(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 3));
        this.assertIntersect(this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 6), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 3));
        this.assertIntersect(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 3, (byte) 4, (byte) 5, (byte) 6), this.newWith((byte) 3));
        this.assertIntersect(this.newWith(), this.newWith(), this.newWith());
        this.assertIntersect(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith());
        this.assertIntersect(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), this.newWith());
    }

    private void assertIntersect(MutableByteSet set1, MutableByteSet set2, MutableByteSet expected) {
        MutableByteSet actual = set1.intersect(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void difference() {
        this.assertDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 1, (byte) 2));
        this.assertDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith());
        this.assertDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertDifference(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith());
        this.assertDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), this.newWith((byte) 1, (byte) 2, (byte) 3));
    }

    private void assertDifference(MutableByteSet set1, MutableByteSet set2, MutableByteSet expected) {
        MutableByteSet actual = set1.difference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void symmetricDifference() {
        this.assertSymmetricDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 2, (byte) 3, (byte) 4), this.newWith((byte) 1, (byte) 4));
        this.assertSymmetricDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith(), this.newWith());
        this.assertSymmetricDifference(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), this.newWith((byte) 3, (byte) 4, (byte) 5));
        this.assertSymmetricDifference(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), this.newWith((byte) 1, (byte) 2, (byte) 3));
    }

    private void assertSymmetricDifference(MutableByteSet set1, MutableByteSet set2, MutableByteSet expected) {
        MutableByteSet actual = set1.symmetricDifference(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSubsetOf() {
        this.assertIsSubsetOf(this.newWith((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3), true);
        this.assertIsSubsetOf(this.newWith((byte) 1, (byte) 4), this.newWith((byte) 1, (byte) 2, (byte) 3), false);
        this.assertIsSubsetOf(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith(), true);
        this.assertIsSubsetOf(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), true);
        this.assertIsSubsetOf(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), false);
    }

    private void assertIsSubsetOf(MutableByteSet set1, MutableByteSet set2, boolean expected) {
        boolean actual = set1.isSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isProperSubsetOf() {
        this.assertIsProperSubsetOf(this.newWith((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3), true);
        this.assertIsProperSubsetOf(this.newWith((byte) 1, (byte) 4), this.newWith((byte) 1, (byte) 2, (byte) 3), false);
        this.assertIsProperSubsetOf(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith(), false);
        this.assertIsProperSubsetOf(this.newWith(), this.newWith((byte) 3, (byte) 4, (byte) 5), true);
        this.assertIsProperSubsetOf(this.newWith((byte) 1, (byte) 2, (byte) 3), this.newWith(), false);
    }

    private void assertIsProperSubsetOf(MutableByteSet set1, MutableByteSet set2, boolean expected) {
        boolean actual = set1.isProperSubsetOf(set2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isCartesianProduct() {
        this.assertCartesianProduct(this.newWith((byte) 1, (byte) 2), this.newWith((byte) 3, (byte) 4), Sets.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 3), PrimitiveTuples.pair((byte) 1, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 2, (byte) 4)));
        this.assertCartesianProduct(this.newWith((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2), Sets.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2)));
        this.assertCartesianProduct(this.newWith((byte) 1, (byte) 2), this.newWith(), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith((byte) 1, (byte) 2), Sets.mutable.empty());
        this.assertCartesianProduct(this.newWith(), this.newWith(), Sets.mutable.empty());
    }

    private void assertCartesianProduct(MutableByteSet set1, MutableByteSet set2, MutableSet<ByteBytePair> expected) {
        MutableSet<ByteBytePair> actual = set1.cartesianProduct(set2).toSet();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteSetTestCase instance;

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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
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
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteSetTestCase> isCartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractByteSetTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractByteSetTestCase::newCollection;
            this.payloads.tap = AbstractByteSetTestCase::tap;
            this.payloads.containsAllArray = AbstractByteSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractByteSetTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractByteSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractByteSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractByteSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractByteSetTestCase::containsNoneIterable;
            this.payloads.anySatisfy = AbstractByteSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteSetTestCase::noneSatisfy;
            this.payloads.collectWithTarget = AbstractByteSetTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractByteSetTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractByteSetTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractByteSetTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractByteSetTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = AbstractByteSetTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = AbstractByteSetTestCase::rejectWithTarget;
            this.payloads.max = AbstractByteSetTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteSetTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteSetTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteSetTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteSetTestCase::sum;
            this.payloads.summaryStatistics = AbstractByteSetTestCase::summaryStatistics;
            this.payloads.average = AbstractByteSetTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractByteSetTestCase::averageIfEmpty;
            this.payloads.median = AbstractByteSetTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractByteSetTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractByteSetTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractByteSetTestCase::toArrayWithTargetArray;
            this.payloads.testToString = AbstractByteSetTestCase::testToString;
            this.payloads.makeString = AbstractByteSetTestCase::makeString;
            this.payloads.appendString = AbstractByteSetTestCase::appendString;
            this.payloads.toList = AbstractByteSetTestCase::toList;
            this.payloads.toSortedList = AbstractByteSetTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractByteSetTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractByteSetTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractByteSetTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractByteSetTestCase::toSet;
            this.payloads.injectInto = AbstractByteSetTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractByteSetTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractByteSetTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractByteSetTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractByteSetTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractByteSetTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractByteSetTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractByteSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteSetTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractByteSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractByteSetTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractByteSetTestCase::chunk;
            this.payloads.contains = AbstractByteSetTestCase::contains;
            this.payloads.addAllArray = AbstractByteSetTestCase::addAllArray;
            this.payloads.removeIf = AbstractByteSetTestCase::removeIf;
            this.payloads.retainAll = AbstractByteSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractByteSetTestCase::retainAll_iterable;
            this.payloads.with = AbstractByteSetTestCase::with;
            this.payloads.withAll = AbstractByteSetTestCase::withAll;
            this.payloads.without = AbstractByteSetTestCase::without;
            this.payloads.withoutAll = AbstractByteSetTestCase::withoutAll;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = AbstractByteSetTestCase::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = AbstractByteSetTestCase::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = AbstractByteSetTestCase::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractByteSetTestCase::newEmpty;
            this.payloads.size = AbstractByteSetTestCase::size;
            this.payloads.isEmpty = AbstractByteSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteSetTestCase::notEmpty;
            this.payloads.clear = AbstractByteSetTestCase::clear;
            this.payloads.add = AbstractByteSetTestCase::add;
            this.payloads.addAllIterable = AbstractByteSetTestCase::addAllIterable;
            this.payloads.remove = AbstractByteSetTestCase::remove;
            this.payloads.removeAll = AbstractByteSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractByteSetTestCase::removeAll_iterable;
            this.payloads.byteIterator = AbstractByteSetTestCase::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteSetTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractByteSetTestCase::forEach;
            this.payloads.count = AbstractByteSetTestCase::count;
            this.payloads.select = AbstractByteSetTestCase::select;
            this.payloads.reject = AbstractByteSetTestCase::reject;
            this.payloads.detectIfNone = AbstractByteSetTestCase::detectIfNone;
            this.payloads.collect = AbstractByteSetTestCase::collect;
            this.payloads.toSortedArray = AbstractByteSetTestCase::toSortedArray;
            this.payloads.testEquals = AbstractByteSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteSetTestCase::testHashCode;
            this.payloads.toBag = AbstractByteSetTestCase::toBag;
            this.payloads.asLazy = AbstractByteSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractByteSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractByteSetTestCase::asUnmodifiable;
            this.payloads.classIsNonInstantiable = AbstractByteSetTestCase::classIsNonInstantiable;
            this.payloads.union = AbstractByteSetTestCase::union;
            this.payloads.intersect = AbstractByteSetTestCase::intersect;
            this.payloads.difference = AbstractByteSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractByteSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractByteSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractByteSetTestCase::isProperSubsetOf;
            this.payloads.isCartesianProduct = AbstractByteSetTestCase::isCartesianProduct;
        }
    }
}
