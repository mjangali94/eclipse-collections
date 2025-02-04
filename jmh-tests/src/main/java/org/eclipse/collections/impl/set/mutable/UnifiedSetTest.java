/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.Pool;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.test.ClassComparer;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test suite for {@link UnifiedSet}.
 */
public class UnifiedSetTest extends AbstractMutableSetTestCase {

    @Override
    protected <T> UnifiedSet<T> newWith(T... littleElements) {
        return UnifiedSet.newSetWith(littleElements);
    }

    @Override
    @Test
    public void with() {
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1"), UnifiedSet.newSet().with("1"));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1", "2"), UnifiedSet.newSet().with("1", "2"));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1", "2", "3"), UnifiedSet.newSet().with("1", "2", "3"));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1", "2", "3", "4"), UnifiedSet.newSet().with("1", "2", "3", "4"));
        MutableSet<String> list = UnifiedSet.<String>newSet().with("A").withAll(Lists.fixedSize.of("1", "2")).withAll(Lists.fixedSize.of()).withAll(Sets.fixedSize.of("3", "4"));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("A", "1", "2", "3", "4"), list);
    }

    @Test
    public void newSet_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSet<Integer>(-1, 0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSet<Integer>(1, -0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSet<Integer>(1, 0.0f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSet<Integer>(1, 1.5f));
    }

    @Test
    public void newSetWithIterable() {
        MutableSet<Integer> integers = UnifiedSet.newSet(Interval.oneTo(3));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), integers);
    }

    @Test
    public void unifiedSetProperSuperSetOfHashSet() {
        Assert.assertTrue(ClassComparer.isProperSupersetOf(UnifiedSet.class, HashSet.class));
    }

    @Override
    @Test
    public void add() {
        super.add();
        // force rehashing at each step of adding a new colliding entry
        for (int i = 0; i < COLLISIONS.size(); i++) {
            UnifiedSet<Integer> unifiedSet = UnifiedSet.<Integer>newSet(i, 0.75f).withAll(COLLISIONS.subList(0, i));
            if (i == 2) {
                unifiedSet.add(Integer.valueOf(1));
            }
            if (i == 4) {
                unifiedSet.add(Integer.valueOf(1));
                unifiedSet.add(Integer.valueOf(2));
            }
            Integer value = COLLISIONS.get(i);
            Assert.assertTrue(unifiedSet.add(value));
        }
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        UnifiedSet<Integer> caseA = UnifiedSet.<Integer>newSet(2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        Assert.assertTrue(caseA.add(COLLISION_2));
        // Rehashing Case B: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element is not in the chain
        // set up a chained bucket
        UnifiedSet<Integer> caseB = UnifiedSet.<Integer>newSet(2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseB.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseB.add(Integer.valueOf(1));
        caseB.add(Integer.valueOf(2));
        // add a new value and force the rehash
        Assert.assertTrue(caseB.add(3));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        // test adding a fully populated chained bucket
        MutableSet<Integer> expected = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Assert.assertTrue(UnifiedSet.<Integer>newSet().addAllIterable(expected));
        // add an odd-sized collection to a set with a small max to ensure that its capacity is maintained after the operation.
        UnifiedSet<Integer> tiny = UnifiedSet.newSet(0);
        Assert.assertTrue(tiny.addAllIterable(FastList.newListWith(COLLISION_1)));
    }

    @Test
    public void get() {
        UnifiedSet<Integer> set = UnifiedSet.<Integer>newSet(SIZE).withAll(COLLISIONS);
        set.removeAll(COLLISIONS);
        for (Integer integer : COLLISIONS) {
            Assert.assertNull(set.get(integer));
            Assert.assertNull(set.get(null));
            set.add(integer);
            // noinspection UnnecessaryBoxing,CachedNumberConstructorCall,BoxingBoxedValue
            Assert.assertSame(integer, set.get(new Integer(integer)));
        }
        Assert.assertEquals(COLLISIONS.toSet(), set);
        // the pool interface supports getting null keys
        UnifiedSet<Integer> chainedWithNull = UnifiedSet.newSetWith(null, COLLISION_1);
        Verify.assertContains(null, chainedWithNull);
        Assert.assertNull(chainedWithNull.get(null));
        // getting a non-existent from a chain with one slot should short-circuit to return null
        UnifiedSet<Integer> chainedWithOneSlot = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2);
        chainedWithOneSlot.remove(COLLISION_2);
        Assert.assertNull(chainedWithOneSlot.get(COLLISION_2));
    }

    @Test
    public void put() {
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size; i++) {
            Pool<Integer> unifiedSet = UnifiedSet.<Integer>newSet(1).withAll(MORE_COLLISIONS.subList(0, i - 1));
            Integer newValue = MORE_COLLISIONS.get(i - 1);
            Assert.assertSame(newValue, unifiedSet.put(newValue));
            // noinspection UnnecessaryBoxing,CachedNumberConstructorCall,BoxingBoxedValue
            Assert.assertSame(newValue, unifiedSet.put(new Integer(newValue)));
        }
        // assert that all redundant puts into each position of chain bucket return the original element added
        Pool<Integer> set = UnifiedSet.<Integer>newSet(4).with(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        for (int i = 0; i < set.size(); i++) {
            Integer value = COLLISIONS.get(i);
            Assert.assertSame(value, set.put(value));
        }
        // force rehashing at each step of putting a new colliding entry
        for (int i = 0; i < COLLISIONS.size(); i++) {
            Pool<Integer> pool = UnifiedSet.<Integer>newSet(i).withAll(COLLISIONS.subList(0, i));
            if (i == 2) {
                pool.put(Integer.valueOf(1));
            }
            if (i == 4) {
                pool.put(Integer.valueOf(1));
                pool.put(Integer.valueOf(2));
            }
            Integer value = COLLISIONS.get(i);
            Assert.assertSame(value, pool.put(value));
        }
        // cover one case not covered in the above: a bucket with only one entry and a low capacity forcing a rehash
        // set up a chained bucket
        Pool<Integer> pool = UnifiedSet.<Integer>newSet(2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        pool.removeFromPool(COLLISION_2);
        // increase the occupied count to the threshold
        pool.put(Integer.valueOf(1));
        pool.put(Integer.valueOf(2));
        // put the colliding value back and force the rehash
        Assert.assertSame(COLLISION_2, pool.put(COLLISION_2));
        // put chained items into a pool without causing a rehash
        Pool<Integer> olympicPool = UnifiedSet.newSet();
        Assert.assertSame(COLLISION_1, olympicPool.put(COLLISION_1));
        Assert.assertSame(COLLISION_2, olympicPool.put(COLLISION_2));
    }

    @Test
    public void removeFromPool() {
        Pool<Integer> unifiedSet = UnifiedSet.<Integer>newSet(8).withAll(COLLISIONS);
        COLLISIONS.reverseForEach(each -> {
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertSame(each, unifiedSet.removeFromPool(each));
            Assert.assertNull(unifiedSet.removeFromPool(each));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertNull(unifiedSet.removeFromPool(COLLISION_10));
        });
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), unifiedSet);
        COLLISIONS.forEach(Procedures.cast(each -> {
            Pool<Integer> unifiedSet2 = UnifiedSet.<Integer>newSet(8).withAll(COLLISIONS);
            Assert.assertNull(unifiedSet2.removeFromPool(null));
            Assert.assertSame(each, unifiedSet2.removeFromPool(each));
            Assert.assertNull(unifiedSet2.removeFromPool(each));
            Assert.assertNull(unifiedSet2.removeFromPool(null));
            Assert.assertNull(unifiedSet2.removeFromPool(COLLISION_10));
        }));
        // search a chain for a non-existent element
        Pool<Integer> chain = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Assert.assertNull(chain.removeFromPool(COLLISION_5));
        // search a deep chain for a non-existent element
        Pool<Integer> deepChain = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Assert.assertNull(deepChain.removeFromPool(COLLISION_8));
        // search for a non-existent element
        Pool<Integer> empty = UnifiedSet.newSetWith(COLLISION_1);
        Assert.assertNull(empty.removeFromPool(COLLISION_2));
    }

    @Test
    public void serialization() {
        int size = COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = UnifiedSet.<Integer>newSet(SIZE).withAll(COLLISIONS.subList(0, i));
            Verify.assertPostSerializedEqualsAndHashCode(set);
            set.add(null);
            Verify.assertPostSerializedEqualsAndHashCode(set);
        }
        UnifiedSet<Integer> nullBucketZero = UnifiedSet.newSetWith(null, COLLISION_1, COLLISION_2);
        Verify.assertPostSerializedEqualsAndHashCode(nullBucketZero);
        UnifiedSet<Integer> simpleSetWithNull = UnifiedSet.newSetWith(null, 1, 2);
        Verify.assertPostSerializedEqualsAndHashCode(simpleSetWithNull);
    }

    @Test
    public void null_behavior() {
        UnifiedSet<Integer> unifiedSet = UnifiedSet.<Integer>newSet(10).withAll(MORE_COLLISIONS);
        MORE_COLLISIONS.clone().reverseForEach(each -> {
            Assert.assertTrue(unifiedSet.add(null));
            Assert.assertFalse(unifiedSet.add(null));
            Verify.assertContains(null, unifiedSet);
            Verify.assertPostSerializedEqualsAndHashCode(unifiedSet);
            Assert.assertTrue(unifiedSet.remove(null));
            Assert.assertFalse(unifiedSet.remove(null));
            Verify.assertNotContains(null, unifiedSet);
            Verify.assertPostSerializedEqualsAndHashCode(unifiedSet);
            Assert.assertNull(unifiedSet.put(null));
            Assert.assertNull(unifiedSet.put(null));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Verify.assertContains(each, unifiedSet);
            Assert.assertTrue(unifiedSet.remove(each));
            Assert.assertFalse(unifiedSet.remove(each));
            Verify.assertNotContains(each, unifiedSet);
        });
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        UnifiedSet<Integer> singleCollisionBucket = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2);
        singleCollisionBucket.remove(COLLISION_2);
        Assert.assertEquals(singleCollisionBucket, UnifiedSet.newSetWith(COLLISION_1));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(null, COLLISION_1, COLLISION_2, COLLISION_3), UnifiedSet.newSetWith(null, COLLISION_1, COLLISION_2, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(COLLISION_1, null, COLLISION_2, COLLISION_3), UnifiedSet.newSetWith(COLLISION_1, null, COLLISION_2, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, null, COLLISION_3), UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, null, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, null), UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, null));
    }

    @Test
    public void constructor_from_UnifiedSet() {
        Verify.assertEqualsAndHashCode(new HashSet<>(MORE_COLLISIONS), UnifiedSet.newSet(MORE_COLLISIONS));
    }

    @Test
    public void copyConstructor() {
        // test copying a chained bucket
        MutableSet<Integer> set = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Verify.assertEqualsAndHashCode(set, UnifiedSet.newSet(set));
    }

    @Test
    public void newSet() {
        for (int i = 1; i < 17; i++) {
            this.assertPresizedSet(i, 0.75f);
        }
        this.assertPresizedSet(31, 0.75f);
        this.assertPresizedSet(32, 0.75f);
        this.assertPresizedSet(34, 0.75f);
        this.assertPresizedSet(60, 0.75f);
        this.assertPresizedSet(64, 0.70f);
        this.assertPresizedSet(68, 0.70f);
        this.assertPresizedSet(60, 0.70f);
        this.assertPresizedSet(1025, 0.80f);
        this.assertPresizedSet(1024, 0.80f);
        this.assertPresizedSet(1025, 0.80f);
        this.assertPresizedSet(1024, 0.805f);
    }

    private void assertPresizedSet(int initialCapacity, float loadFactor) {
        try {
            Field tableField = UnifiedSet.class.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(UnifiedSet.newSet(initialCapacity, loadFactor));
            int size = (int) Math.ceil(initialCapacity / loadFactor);
            int capacity = 1;
            while (capacity < size) {
                capacity <<= 1;
            }
            Assert.assertEquals(capacity, table.length, 0.00);
        } catch (SecurityException ignored) {
            Assert.fail("Unable to modify the visibility of the table on UnifiedSet");
        } catch (NoSuchFieldException ignored) {
            Assert.fail("No field named table UnifiedSet");
        } catch (IllegalAccessException ignored) {
            Assert.fail("No access the field table in UnifiedSet");
        }
    }

    @Test
    public void batchForEach() {
        // Testing batch size of 1 to 16 with no chains
        UnifiedSet<Integer> set = UnifiedSet.<Integer>newSet(10).with(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int sectionCount = 1; sectionCount <= 16; ++sectionCount) {
            Sum sum = new IntegerSum(0);
            for (int sectionIndex = 0; sectionIndex < sectionCount; ++sectionIndex) {
                set.batchForEach(new SumProcedure<>(sum), sectionIndex, sectionCount);
            }
            Assert.assertEquals(55, sum.getValue());
        }
        // Testing 1 batch with chains
        Sum sum2 = new IntegerSum(0);
        UnifiedSet<Integer> set2 = UnifiedSet.<Integer>newSet(3).with(COLLISION_1, COLLISION_2, COLLISION_3, 1, 2);
        int numBatches = set2.getBatchCount(100);
        for (int i = 0; i < numBatches; ++i) {
            set2.batchForEach(new SumProcedure<>(sum2), i, numBatches);
        }
        Assert.assertEquals(1, numBatches);
        Assert.assertEquals(54, sum2.getValue());
        // Testing batch size of 3 with chains and uneven last batch
        Sum sum3 = new IntegerSum(0);
        UnifiedSet<Integer> set3 = UnifiedSet.<Integer>newSet(4, 1.0F).with(COLLISION_1, COLLISION_2, 1, 2, 3, 4, 5);
        int numBatches2 = set3.getBatchCount(3);
        for (int i = 0; i < numBatches2; ++i) {
            set3.batchForEach(new SumProcedure<>(sum3), i, numBatches2);
        }
        Assert.assertEquals(32, sum3.getValue());
        // Test batchForEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum4 = new IntegerSum(0);
        UnifiedSet<Integer> set4 = UnifiedSet.newSet();
        set4.batchForEach(new SumProcedure<>(sum4), 0, set4.getBatchCount(1));
        Assert.assertEquals(0, sum4.getValue());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        int size = COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = UnifiedSet.<Integer>newSet(SIZE).withAll(COLLISIONS.subList(0, i));
            Object[] objects = set.toArray();
            Assert.assertEquals(set, UnifiedSet.newSetWith(objects));
        }
        MutableSet<Integer> deepChain = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6 }, deepChain.toArray());
        MutableSet<Integer> minimumChain = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2);
        minimumChain.remove(COLLISION_2);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1 }, minimumChain.toArray());
        MutableSet<Integer> set = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Integer[] target = { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) };
        Integer[] actual = set.toArray(target);
        ArrayIterate.sort(actual, actual.length, Comparators.safeNullsHigh(Integer::compareTo));
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, 1, COLLISION_2, COLLISION_3, COLLISION_4, null }, actual);
    }

    @Test
    public void iterator_remove() {
        int size = MORE_COLLISIONS.size();
        for (int i = 0; i < size; i++) {
            MutableSet<Integer> actual = UnifiedSet.<Integer>newSet(SIZE).withAll(MORE_COLLISIONS);
            Iterator<Integer> iterator = actual.iterator();
            for (int j = 0; j <= i; j++) {
                Assert.assertTrue(iterator.hasNext());
                iterator.next();
            }
            iterator.remove();
            MutableSet<Integer> expected = UnifiedSet.newSet(MORE_COLLISIONS);
            expected.remove(MORE_COLLISIONS.get(i));
            Assert.assertEquals(expected, actual);
        }
        // remove the last element from within a 2-level long chain that is fully populated
        MutableSet<Integer> set = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Iterator<Integer> iterator1 = set.iterator();
        for (int i = 0; i < 7; i++) {
            iterator1.next();
        }
        iterator1.remove();
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6), set);
        // remove the second-to-last element from a 2-level long chain that that has one empty slot
        Iterator<Integer> iterator2 = set.iterator();
        for (int i = 0; i < 6; i++) {
            iterator2.next();
        }
        iterator2.remove();
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5), set);
        // Testing removing the last element in a fully populated chained bucket
        MutableSet<Integer> set2 = this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Iterator<Integer> iterator3 = set2.iterator();
        for (int i = 0; i < 3; ++i) {
            iterator3.next();
        }
        iterator3.next();
        iterator3.remove();
        Verify.assertSetsEqual(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3), set2);
    }

    @Test
    public void setKeyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MutableSet<Key> set1 = UnifiedSet.<Key>newSet().with(key, duplicateKey1);
        Verify.assertSize(1, set1);
        Verify.assertContains(key, set1);
        Assert.assertSame(key, set1.getFirst());
        Key duplicateKey2 = new Key("key");
        MutableSet<Key> set2 = UnifiedSet.<Key>newSet().with(key, duplicateKey1, duplicateKey2);
        Verify.assertSize(1, set2);
        Verify.assertContains(key, set2);
        Assert.assertSame(key, set2.getFirst());
        Key duplicateKey3 = new Key("key");
        MutableSet<Key> set3 = UnifiedSet.<Key>newSet().with(key, new Key("not a dupe"), duplicateKey3);
        Verify.assertSize(2, set3);
        Verify.assertContainsAll(set3, key, new Key("not a dupe"));
        Assert.assertSame(key, set3.detect(key::equals));
    }

    @Test
    public void withSameIfNotModified() {
        UnifiedSet<Integer> integers = UnifiedSet.newSet();
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), integers.with(1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), integers.with(2, 3, 4));
        Assert.assertSame(integers, integers.with(5, 6, 7));
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableSet<Object> setWithNull = this.newWith((Object) null);
        Assert.assertFalse(setWithNull.retainAll(FastList.newListWith((Object) null)));
        Assert.assertEquals(UnifiedSet.newSetWith((Object) null), setWithNull);
    }

    @Test(expected = NullPointerException.class)
    public void asParallelNullExecutorService() {
        this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).asParallel(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallelLessThanOneBatchSize() {
        this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).asParallel(Executors.newFixedThreadPool(10), 0);
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size - 1; i++) {
            MutableSet<Integer> unifiedSet = UnifiedSet.<Integer>newSet(1).withAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertSame(MORE_COLLISIONS.get(0), unifiedSet.getFirst());
        }
    }

    @Override
    @Test
    public void getLast() {
        super.getLast();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size - 1; i++) {
            MutableSet<Integer> unifiedSet = UnifiedSet.<Integer>newSet(1).withAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertSame(MORE_COLLISIONS.get(i - 1), unifiedSet.getLast());
        }
        MutableSet<Integer> chainedWithOneSlot = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2);
        chainedWithOneSlot.remove(COLLISION_2);
        Assert.assertSame(COLLISION_1, chainedWithOneSlot.getLast());
    }

    @Test
    public void trimToSize() {
        UnifiedSet<String> set = UnifiedSet.newSet();
        MutableSet<String> expected = Sets.mutable.empty();
        Interval integers = Interval.fromTo(0, 250);
        integers.each(each -> {
            set.add(each.toString());
            expected.add(each.toString());
        });
        ArrayIterate.forEach(FREQUENT_COLLISIONS, each -> {
            set.add(each);
            expected.add(each);
        });
        Assert.assertEquals(expected, set);
        Assert.assertEquals(261, set.size());
        MutableList<Integer> toRemove = Lists.mutable.withAll(Interval.evensFromTo(0, 20));
        toRemove.addAll(Interval.oddsFromTo(35, 55));
        toRemove.each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        // First assertion to verify that trim does not happen since, the table is already at the smallest required power of 2.
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(239, set.size());
        Assert.assertEquals(expected, set);
        Interval.evensFromTo(0, 250).each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        // Second assertion to verify that trim happens since, the table length is less than smallest required power of 2.
        Assert.assertTrue(set.trimToSize());
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(expected, set);
        Assert.assertEquals(124, set.size());
        expected.each(each -> Assert.assertEquals(each, set.get(each)));
        integers.each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        Assert.assertTrue(set.trimToSize());
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(expected, set);
        expected.each(each -> Assert.assertEquals(each, set.get(each)));
        set.clear();
        Assert.assertTrue(set.trimToSize());
        Interval.oneTo(4).each(each -> set.add(each.toString()));
        // Assert that trim does not happen after puts
        Assert.assertFalse(set.trimToSize());
        set.remove("1");
        set.remove("2");
        Assert.assertTrue(set.trimToSize());
        set.add("1");
        // Assert that the resized table due to put is the required size and no need to trim that.
        Assert.assertFalse(set.trimToSize());
        Interval.zeroTo(4).each(each -> set.add(each.toString()));
        Interval.oneTo(3).each(each -> set.remove(each.toString()));
        Assert.assertTrue(set.trimToSize());
        Assert.assertEquals(2, set.size());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
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
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_unifiedSetKeySetToArrayDest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetKeySetToArrayDest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_increment_past_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_increment_past_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_without_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_without_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetProperSuperSetOfHashSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetProperSuperSetOfHashSet);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_behavior() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_behavior);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructor_from_UnifiedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructor_from_UnifiedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_copyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.copyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setKeyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setKeyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withSameIfNotModified() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withSameIfNotModified);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallelNullExecutorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallelNullExecutorService);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallelLessThanOneBatchSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallelLessThanOneBatchSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> newSet_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> newSetWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> unifiedSetProperSuperSetOfHashSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> removeFromPool;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> null_behavior;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> constructor_from_UnifiedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> copyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> newSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> setKeyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> withSameIfNotModified;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> asParallelNullExecutorService;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> asParallelLessThanOneBatchSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnifiedSetTest::testNewCollection;
            this.payloads.contains = UnifiedSetTest::contains;
            this.payloads.containsBy = UnifiedSetTest::containsBy;
            this.payloads.containsAllIterable = UnifiedSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnifiedSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedSetTest::containsNoneIterable;
            this.payloads.containsAllArray = UnifiedSetTest::containsAllArray;
            this.payloads.containsAnyCollection = UnifiedSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnifiedSetTest::containsAllCollection;
            this.payloads.selectWith = UnifiedSetTest::selectWith;
            this.payloads.selectWith_target = UnifiedSetTest::selectWith_target;
            this.payloads.rejectWith = UnifiedSetTest::rejectWith;
            this.payloads.rejectWith_target = UnifiedSetTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnifiedSetTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetTest::collect;
            this.payloads.collectTarget = UnifiedSetTest::collectTarget;
            this.payloads.collectBoolean = UnifiedSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnifiedSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnifiedSetTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnifiedSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnifiedSetTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnifiedSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnifiedSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnifiedSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnifiedSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnifiedSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnifiedSetTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnifiedSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnifiedSetTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnifiedSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnifiedSetTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnifiedSetTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnifiedSetTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnifiedSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnifiedSetTest::flatCollectByte;
            this.payloads.flatCollectShort = UnifiedSetTest::flatCollectShort;
            this.payloads.flatCollectInt = UnifiedSetTest::flatCollectInt;
            this.payloads.flatCollectChar = UnifiedSetTest::flatCollectChar;
            this.payloads.flatCollectLong = UnifiedSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnifiedSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnifiedSetTest::flatCollectFloat;
            this.payloads.detectOptional = UnifiedSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnifiedSetTest::min;
            this.payloads.minOptional = UnifiedSetTest::minOptional;
            this.payloads.max = UnifiedSetTest::max;
            this.payloads.maxOptional = UnifiedSetTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnifiedSetTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetTest::max_without_comparator;
            this.payloads.min_null_safe = UnifiedSetTest::min_null_safe;
            this.payloads.max_null_safe = UnifiedSetTest::max_null_safe;
            this.payloads.minBy = UnifiedSetTest::minBy;
            this.payloads.minByOptional = UnifiedSetTest::minByOptional;
            this.payloads.maxBy = UnifiedSetTest::maxBy;
            this.payloads.maxByOptional = UnifiedSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnifiedSetTest::detectWith;
            this.payloads.detectWithOptional = UnifiedSetTest::detectWithOptional;
            this.payloads.detectIfNone = UnifiedSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnifiedSetTest::detectWithIfNoneBlock;
            this.payloads.count = UnifiedSetTest::count;
            this.payloads.countWith = UnifiedSetTest::countWith;
            this.payloads.collectIf = UnifiedSetTest::collectIf;
            this.payloads.collectWith = UnifiedSetTest::collectWith;
            this.payloads.collectWith_target = UnifiedSetTest::collectWith_target;
            this.payloads.getAny = UnifiedSetTest::getAny;
            this.payloads.getOnly = UnifiedSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = UnifiedSetTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnifiedSetTest::injectInto;
            this.payloads.injectIntoInt = UnifiedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnifiedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnifiedSetTest::injectIntoFloat;
            this.payloads.sumFloat = UnifiedSetTest::sumFloat;
            this.payloads.summarizeFloat = UnifiedSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnifiedSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnifiedSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnifiedSetTest::sumDouble;
            this.payloads.summarizeDouble = UnifiedSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnifiedSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnifiedSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnifiedSetTest::sumInteger;
            this.payloads.summarizeInt = UnifiedSetTest::summarizeInt;
            this.payloads.sumLong = UnifiedSetTest::sumLong;
            this.payloads.summarizeLong = UnifiedSetTest::summarizeLong;
            this.payloads.sumByInt = UnifiedSetTest::sumByInt;
            this.payloads.sumByFloat = UnifiedSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnifiedSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnifiedSetTest::sumByLong;
            this.payloads.sumByDouble = UnifiedSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnifiedSetTest::sumByDoubleConsistentRounding;
            this.payloads.partition = UnifiedSetTest::partition;
            this.payloads.partitionWith = UnifiedSetTest::partitionWith;
            this.payloads.toList = UnifiedSetTest::toList;
            this.payloads.toImmutableList = UnifiedSetTest::toImmutableList;
            this.payloads.toCollection = UnifiedSetTest::toCollection;
            this.payloads.toBag = UnifiedSetTest::toBag;
            this.payloads.toImmutableBag = UnifiedSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnifiedSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnifiedSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnifiedSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnifiedSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnifiedSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnifiedSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnifiedSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnifiedSetTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnifiedSetTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnifiedSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnifiedSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnifiedSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnifiedSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnifiedSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnifiedSetTest::toSet;
            this.payloads.toImmutableSet = UnifiedSetTest::toImmutableSet;
            this.payloads.toMap = UnifiedSetTest::toMap;
            this.payloads.toImmutableMap = UnifiedSetTest::toImmutableMap;
            this.payloads.toMapTarget = UnifiedSetTest::toMapTarget;
            this.payloads.toSortedMap = UnifiedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnifiedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnifiedSetTest::toSortedMapBy;
            this.payloads.toBiMap = UnifiedSetTest::toBiMap;
            this.payloads.toImmutableBiMap = UnifiedSetTest::toImmutableBiMap;
            this.payloads.testToString = UnifiedSetTest::testToString;
            this.payloads.makeString = UnifiedSetTest::makeString;
            this.payloads.makeStringWithSeparator = UnifiedSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnifiedSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnifiedSetTest::fusedCollectMakeString;
            this.payloads.appendString = UnifiedSetTest::appendString;
            this.payloads.appendStringWithSeparator = UnifiedSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnifiedSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnifiedSetTest::appendStringThrows;
            this.payloads.countBy = UnifiedSetTest::countBy;
            this.payloads.countByWith = UnifiedSetTest::countByWith;
            this.payloads.countByEach = UnifiedSetTest::countByEach;
            this.payloads.groupBy = UnifiedSetTest::groupBy;
            this.payloads.groupByEach = UnifiedSetTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnifiedSetTest::zip;
            this.payloads.zipWithIndex = UnifiedSetTest::zipWithIndex;
            this.payloads.chunk = UnifiedSetTest::chunk;
            this.payloads.chunk_empty = UnifiedSetTest::chunk_empty;
            this.payloads.chunk_single = UnifiedSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnifiedSetTest::chunk_large_size;
            this.payloads.empty = UnifiedSetTest::empty;
            this.payloads.notEmpty = UnifiedSetTest::notEmpty;
            this.payloads.aggregateByMutating = UnifiedSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedSetTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnifiedSetTest::reduceOptional;
            this.payloads.newEmpty = UnifiedSetTest::newEmpty;
            this.payloads.toImmutable = UnifiedSetTest::toImmutable;
            this.payloads.testNewWith = UnifiedSetTest::testNewWith;
            this.payloads.testNewWithWith = UnifiedSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnifiedSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnifiedSetTest::testNewWithVarArgs;
            this.payloads.removeAll = UnifiedSetTest::removeAll;
            this.payloads.removeAllIterable = UnifiedSetTest::removeAllIterable;
            this.payloads.retainAllIterable = UnifiedSetTest::retainAllIterable;
            this.payloads.clear = UnifiedSetTest::clear;
            this.payloads.injectIntoWith = UnifiedSetTest::injectIntoWith;
            this.payloads.removeObject = UnifiedSetTest::removeObject;
            this.payloads.selectAndRejectWith = UnifiedSetTest::selectAndRejectWith;
            this.payloads.removeIfWith = UnifiedSetTest::removeIfWith;
            this.payloads.withAll = UnifiedSetTest::withAll;
            this.payloads.without = UnifiedSetTest::without;
            this.payloads.withoutAll = UnifiedSetTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = UnifiedSetTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnifiedSetTest::asLazy;
            this.payloads.asSynchronized = UnifiedSetTest::asSynchronized;
            this.payloads.addAll = UnifiedSetTest::addAll;
            this.payloads.union = UnifiedSetTest::union;
            this.payloads.unionInto = UnifiedSetTest::unionInto;
            this.payloads.intersect = UnifiedSetTest::intersect;
            this.payloads.intersectInto = UnifiedSetTest::intersectInto;
            this.payloads.difference = UnifiedSetTest::difference;
            this.payloads.differenceInto = UnifiedSetTest::differenceInto;
            this.payloads.symmetricDifference = UnifiedSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = UnifiedSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = UnifiedSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnifiedSetTest::isProperSubsetOf;
            this.payloads.powerSet = UnifiedSetTest::powerSet;
            this.payloads.cartesianProduct = UnifiedSetTest::cartesianProduct;
            this.payloads.asUnmodifiable = UnifiedSetTest::asUnmodifiable;
            this.payloads.select = UnifiedSetTest::select;
            this.payloads.reject = UnifiedSetTest::reject;
            this.payloads.unifiedSetKeySetToArrayDest = UnifiedSetTest::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = UnifiedSetTest::unifiedSetToString;
            this.payloads.testClone = UnifiedSetTest::testClone;
            this.payloads.isEmpty = UnifiedSetTest::isEmpty;
            this.payloads.removeIf = UnifiedSetTest::removeIf;
            this.payloads.tap = UnifiedSetTest::tap;
            this.payloads.forEach = UnifiedSetTest::forEach;
            this.payloads.forEachWith = UnifiedSetTest::forEachWith;
            this.payloads.forEachWithIndex = UnifiedSetTest::forEachWithIndex;
            this.payloads.anySatisfy = UnifiedSetTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetTest::noneSatisfyWith;
            this.payloads.detect = UnifiedSetTest::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toSortedBag_natural_ordering = UnifiedSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnifiedSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnifiedSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnifiedSetTest::toSortedBagBy;
            this.payloads.frequentCollisions = UnifiedSetTest::frequentCollisions;
            this.payloads.with = UnifiedSetTest::with;
            this.payloads.newSet_throws = UnifiedSetTest::newSet_throws;
            this.payloads.newSetWithIterable = UnifiedSetTest::newSetWithIterable;
            this.payloads.unifiedSetProperSuperSetOfHashSet = UnifiedSetTest::unifiedSetProperSuperSetOfHashSet;
            this.payloads.add = UnifiedSetTest::add;
            this.payloads.addAllIterable = UnifiedSetTest::addAllIterable;
            this.payloads.get = UnifiedSetTest::get;
            this.payloads.put = UnifiedSetTest::put;
            this.payloads.removeFromPool = UnifiedSetTest::removeFromPool;
            this.payloads.serialization = UnifiedSetTest::serialization;
            this.payloads.null_behavior = UnifiedSetTest::null_behavior;
            this.payloads.equalsAndHashCode = UnifiedSetTest::equalsAndHashCode;
            this.payloads.constructor_from_UnifiedSet = UnifiedSetTest::constructor_from_UnifiedSet;
            this.payloads.copyConstructor = UnifiedSetTest::copyConstructor;
            this.payloads.newSet = UnifiedSetTest::newSet;
            this.payloads.batchForEach = UnifiedSetTest::batchForEach;
            this.payloads.toArray = UnifiedSetTest::toArray;
            this.payloads.iterator_remove = UnifiedSetTest::iterator_remove;
            this.payloads.setKeyPreservation = UnifiedSetTest::setKeyPreservation;
            this.payloads.withSameIfNotModified = UnifiedSetTest::withSameIfNotModified;
            this.payloads.retainAll = UnifiedSetTest::retainAll;
            this.payloads.asParallelNullExecutorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::asParallelNullExecutorService, java.lang.NullPointerException.class);
            this.payloads.asParallelLessThanOneBatchSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetTest::asParallelLessThanOneBatchSize, java.lang.IllegalArgumentException.class);
            this.payloads.getFirst = UnifiedSetTest::getFirst;
            this.payloads.getLast = UnifiedSetTest::getLast;
            this.payloads.trimToSize = UnifiedSetTest::trimToSize;
        }
    }
*/
}
