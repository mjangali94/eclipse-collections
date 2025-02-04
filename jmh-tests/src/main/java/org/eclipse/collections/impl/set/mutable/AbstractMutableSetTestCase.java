/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.UnsortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.Counter;
import org.eclipse.collections.impl.IntegerWithCast;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;
import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * JUnit test for {@link AbstractMutableSet}.
 */
public abstract class AbstractMutableSetTestCase extends AbstractCollectionTestCase {

    protected static final Integer COLLISION_1 = 0;

    protected static final Integer COLLISION_2 = 17;

    protected static final Integer COLLISION_3 = 34;

    protected static final Integer COLLISION_4 = 51;

    protected static final Integer COLLISION_5 = 68;

    protected static final Integer COLLISION_6 = 85;

    protected static final Integer COLLISION_7 = 102;

    protected static final Integer COLLISION_8 = 119;

    protected static final Integer COLLISION_9 = 136;

    protected static final Integer COLLISION_10 = 152;

    protected static final MutableList<Integer> COLLISIONS = FastList.newListWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5);

    protected static final MutableList<Integer> MORE_COLLISIONS = FastList.newList(COLLISIONS).with(COLLISION_6, COLLISION_7, COLLISION_8, COLLISION_9);

    protected static final int SIZE = 8;

    protected static final String[] FREQUENT_COLLISIONS = { "\u9103\ufffe", "\u9104\uffdf", "\u9105\uffc0", "\u9106\uffa1", "\u9107\uff82", "\u9108\uff63", "\u9109\uff44", "\u910a\uff25", "\u910b\uff06", "\u910c\ufee7" };

    @Override
    protected abstract <T> MutableSet<T> newWith(T... littleElements);

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableSet.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        UnifiedSet<Integer> expected = UnifiedSet.newSetWith(1, 2, 3);
        MutableSet<Integer> collection = this.newWith();
        Assert.assertTrue(collection.addAll(FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(expected, collection);
        Assert.assertFalse(collection.addAll(FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        UnifiedSet<Integer> expected = UnifiedSet.newSetWith(1, 2, 3);
        MutableSet<Integer> collection = this.newWith();
        Assert.assertTrue(collection.addAllIterable(FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(expected, collection);
        Assert.assertFalse(collection.addAllIterable(FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(expected, collection);
    }

    @Test
    public void union() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> union = set.union(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.union(UnifiedSet.newSetWith("1")));
    }

    @Test
    public void unionInto() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> union = set.unionInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.unionInto(UnifiedSet.newSetWith("1"), UnifiedSet.newSet()));
    }

    @Test
    public void intersect() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> intersect = set.intersect(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersect(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void intersectInto() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> intersect = set.intersectInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersectInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void difference() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void differenceInto() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void symmetricDifference() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> difference = set.symmetricDifference(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"));
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void symmetricDifferenceInto() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<String> difference = set.symmetricDifferenceInto(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"), UnifiedSet.newSet());
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void isSubsetOf() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        Assert.assertTrue(set.isSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
    }

    @Test
    public void isProperSubsetOf() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        Assert.assertTrue(set.isProperSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
        Assert.assertFalse(set.isProperSubsetOf(set));
    }

    @Test
    public void powerSet() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        MutableSet<UnsortedSetIterable<String>> powerSet = set.powerSet();
        Verify.assertSize((int) StrictMath.pow(2, set.size()), powerSet);
        Verify.assertContains(UnifiedSet.<String>newSet(), powerSet);
        Verify.assertContains(set, powerSet);
    }

    @Test
    public void cartesianProduct() {
        MutableSet<String> set = this.newWith("1", "2", "3", "4");
        LazyIterable<Pair<String, String>> cartesianProduct = set.cartesianProduct(UnifiedSet.newSetWith("One", "Two"));
        Verify.assertIterableSize(set.size() * 2, cartesianProduct);
        Assert.assertEquals(set, cartesianProduct.select(Predicates.attributeEqual((Function<Pair<?, String>, String>) Pair::getTwo, "One")).collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableSet.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void select() {
        super.select();
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3)), 1, 2);
        Verify.assertContainsAll(this.newWith(-1, 2, 3, 4, 5).select(Predicates.lessThan(3), FastList.newList()), -1, 2);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3), FastList.newList()), 3, 4);
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Test
    public void unifiedSetKeySetToArrayDest() {
        MutableSet<Integer> set = this.newWith(1, 2, 3, 4);
        // deliberately to small to force the method to allocate one of the correct size
        Integer[] dest = new Integer[2];
        Integer[] result = set.toArray(dest);
        Verify.assertSize(4, result);
        Arrays.sort(result);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);
    }

    @Test
    public void unifiedSetToString() {
        MutableSet<Integer> set = this.newWith(1, 2);
        String s = set.toString();
        Assert.assertTrue("[1, 2]".equals(s) || "[2, 1]".equals(s));
    }

    @Test
    public void testClone() {
        MutableSet<String> set = this.newWith();
        MutableSet<String> clone = set.clone();
        Assert.assertNotSame(clone, set);
        Verify.assertEqualsAndHashCode(clone, set);
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        MutableSet<String> set = this.newWith();
        this.assertIsEmpty(true, set);
        set.add("stuff");
        this.assertIsEmpty(false, set);
        set.remove("stuff");
        this.assertIsEmpty(true, set);
        set.add("Bon");
        set.add("Jovi");
        this.assertIsEmpty(false, set);
        set.remove("Jovi");
        this.assertIsEmpty(false, set);
        set.clear();
        this.assertIsEmpty(true, set);
    }

    private void assertIsEmpty(boolean isEmpty, MutableSet<?> set) {
        Assert.assertEquals(isEmpty, set.isEmpty());
        Assert.assertEquals(!isEmpty, set.notEmpty());
    }

    @Test
    public void add() {
        MutableSet<IntegerWithCast> set = this.newWith();
        MutableList<IntegerWithCast> collisions = COLLISIONS.collect(IntegerWithCast::new);
        set.addAll(collisions);
        set.removeAll(collisions);
        for (Integer integer : COLLISIONS) {
            Assert.assertTrue(set.add(new IntegerWithCast(integer)));
            Assert.assertFalse(set.add(new IntegerWithCast(integer)));
        }
        Assert.assertEquals(collisions.toSet(), set);
    }

    @Override
    @Test
    public void removeIf() {
        super.removeIf();
        MutableSet<IntegerWithCast> set = this.newWith();
        MutableList<IntegerWithCast> collisions = COLLISIONS.collect(IntegerWithCast::new);
        set.addAll(collisions);
        collisions.reverseForEach(each -> {
            Assert.assertFalse(set.remove(null));
            Assert.assertTrue(set.remove(each));
            Assert.assertFalse(set.remove(each));
            Assert.assertFalse(set.remove(null));
            Assert.assertFalse(set.remove(new IntegerWithCast(COLLISION_10)));
        });
        Assert.assertEquals(UnifiedSet.<IntegerWithCast>newSet(), set);
        collisions.forEach(Procedures.cast(each -> {
            MutableSet<IntegerWithCast> set2 = this.newWith();
            set2.addAll(collisions);
            Assert.assertFalse(set2.remove(null));
            Assert.assertTrue(set2.remove(each));
            Assert.assertFalse(set2.remove(each));
            Assert.assertFalse(set2.remove(null));
            Assert.assertFalse(set2.remove(new IntegerWithCast(COLLISION_10)));
        }));
        // remove the second-to-last item in a fully populated single chain to cause the last item to move
        MutableSet<Integer> set3 = this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Assert.assertTrue(set3.remove(COLLISION_3));
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_4), set3);
        Assert.assertTrue(set3.remove(COLLISION_2));
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_4), set3);
        // search a chain for a non-existent element
        MutableSet<Integer> chain = this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Assert.assertFalse(chain.remove(COLLISION_5));
        // search a deep chain for a non-existent element
        MutableSet<Integer> deepChain = this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Assert.assertFalse(deepChain.remove(COLLISION_8));
        // search for a non-existent element
        MutableSet<Integer> empty = this.newWith();
        Assert.assertFalse(empty.remove(COLLISION_1));
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableList<Integer> collisions = MORE_COLLISIONS.clone();
        collisions.add(COLLISION_10);
        int size = MORE_COLLISIONS.size();
        for (int i = 0; i < size; i++) {
            MutableList<Integer> list = MORE_COLLISIONS.subList(0, i);
            MutableSet<Integer> set = this.<Integer>newWith().withAll(list);
            Assert.assertFalse(set.retainAll(collisions));
            Assert.assertEquals(list.toSet(), set);
        }
        for (Integer item : MORE_COLLISIONS) {
            MutableSet<Integer> integers = this.<Integer>newWith().withAll(MORE_COLLISIONS);
            @SuppressWarnings("BoxingBoxedValue")
            Integer keyCopy = new Integer(item);
            Assert.assertTrue(integers.retainAll(mList(keyCopy)));
            Assert.assertEquals(iSet(keyCopy), integers);
            Assert.assertNotSame(keyCopy, Iterate.getOnly(integers));
        }
        // retain all on a bucket with a single element
        MutableSet<Integer> singleCollisionBucket = this.newWith(COLLISION_1, COLLISION_2);
        singleCollisionBucket.remove(COLLISION_2);
        Assert.assertTrue(singleCollisionBucket.retainAll(FastList.newListWith(COLLISION_2)));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        UnifiedSet<Integer> expected = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Assert.assertNotEquals(expected, this.newWith(COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5));
        Assert.assertNotEquals(expected, this.newWith(COLLISION_1, COLLISION_3, COLLISION_4, COLLISION_5));
        Assert.assertNotEquals(expected, this.newWith(COLLISION_1, COLLISION_2, COLLISION_4, COLLISION_5));
        Assert.assertNotEquals(expected, this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_5));
        Assert.assertEquals(expected, this.newWith(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4));
    }

    @Override
    @Test
    public void tap() {
        super.tap();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableList<Integer> tapResult = Lists.mutable.of();
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertSame(set, set.tap(tapResult::add));
            Assert.assertEquals(set.toList(), tapResult);
        }
        // test iterating on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Counter counter = new Counter();
        Assert.assertSame(set, set.tap(x -> counter.increment()));
        Assert.assertEquals(1, counter.getCount());
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            MutableSet<Integer> result = UnifiedSet.newSet();
            set.forEach(CollectionAddProcedure.on(result));
            Assert.assertEquals(set, result);
        }
        // test iterating on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Counter counter = new Counter();
        set.forEach(Procedures.cast(each -> counter.increment()));
        Assert.assertEquals(1, counter.getCount());
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        Object sentinel = new Object();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            MutableSet<Integer> result = UnifiedSet.newSet();
            set.forEachWith((argument1, argument2) -> {
                Assert.assertSame(sentinel, argument2);
                result.add(argument1);
            }, sentinel);
            Assert.assertEquals(set, result);
        }
        // test iterating on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Counter counter = new Counter();
        set.forEachWith((argument1, argument2) -> argument2.increment(), counter);
        Assert.assertEquals(1, counter.getCount());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            MutableSet<Integer> result = UnifiedSet.newSet();
            MutableList<Integer> indexes = Lists.mutable.of();
            set.forEachWithIndex((each, index) -> {
                result.add(each);
                indexes.add(index);
            });
            Assert.assertEquals(set, result);
            Assert.assertEquals(Interval.zeroTo(i - 1), indexes);
        }
        // test iterating on a bucket with only one element
        UnifiedSet<Integer> set = UnifiedSet.newSetWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Counter counter = new Counter();
        set.forEachWithIndex((each, index) -> counter.increment());
        Assert.assertEquals(1, counter.getCount());
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.anySatisfy(MORE_COLLISIONS.subList(0, i).getLast()::equals));
            Assert.assertFalse(set.anySatisfy(Predicates.greaterThan(MORE_COLLISIONS.subList(0, i).getLast())));
        }
        // test anySatisfy on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertTrue(set.anySatisfy(COLLISION_1::equals));
        Assert.assertFalse(set.anySatisfy(COLLISION_2::equals));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.anySatisfy(COLLISION_2::equals));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        super.anySatisfyWith();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.anySatisfyWith(Object::equals, MORE_COLLISIONS.subList(0, i).getLast()));
            Assert.assertFalse(set.anySatisfyWith(Predicates2.greaterThan(), MORE_COLLISIONS.subList(0, i).getLast()));
        }
        // test anySatisfyWith on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertTrue(set.anySatisfyWith(Object::equals, COLLISION_1));
        Assert.assertFalse(set.anySatisfyWith(Object::equals, COLLISION_2));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.anySatisfyWith(Object::equals, COLLISION_2));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.allSatisfy(Predicates.greaterThanOrEqualTo(MORE_COLLISIONS.subList(0, i).getFirst())));
            Assert.assertFalse(set.allSatisfy(Predicates.lessThan(MORE_COLLISIONS.subList(0, i).get(i - 1))));
        }
        // test allSatisfy on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertTrue(set.allSatisfy(COLLISION_1::equals));
        Assert.assertFalse(set.allSatisfy(COLLISION_2::equals));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.allSatisfy(Predicates.lessThanOrEqualTo(COLLISION_2)));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        super.allSatisfyWith();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.allSatisfyWith(Predicates2.greaterThanOrEqualTo(), MORE_COLLISIONS.subList(0, i).getFirst()));
            Assert.assertFalse(set.allSatisfyWith(Predicates2.lessThan(), MORE_COLLISIONS.subList(0, i).get(i - 1)));
        }
        // test allSatisfyWith on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertTrue(set.allSatisfyWith(Object::equals, COLLISION_1));
        Assert.assertFalse(set.allSatisfyWith(Object::equals, COLLISION_2));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.allSatisfyWith(Predicates2.lessThanOrEqualTo(), COLLISION_2));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.noneSatisfy(Predicates.lessThan(MORE_COLLISIONS.subList(0, i).getFirst())));
            Assert.assertFalse(set.noneSatisfy(Predicates.greaterThanOrEqualTo(MORE_COLLISIONS.subList(0, i).get(i - 1))));
        }
        // test noneSatisfy on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertFalse(set.noneSatisfy(COLLISION_1::equals));
        Assert.assertTrue(set.noneSatisfy(COLLISION_2::equals));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.noneSatisfy(Predicates.greaterThan(COLLISION_2)));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        super.noneSatisfyWith();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertTrue(set.noneSatisfyWith(Predicates2.lessThan(), MORE_COLLISIONS.subList(0, i).getFirst()));
            Assert.assertFalse(set.noneSatisfyWith(Predicates2.greaterThanOrEqualTo(), MORE_COLLISIONS.subList(0, i).get(i - 1)));
        }
        // test noneSatisfyWith on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertFalse(set.noneSatisfyWith(Object::equals, COLLISION_1));
        Assert.assertTrue(set.noneSatisfyWith(Object::equals, COLLISION_2));
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element goes in the bucket
        // set up a chained bucket
        MutableSet<Integer> caseA = this.newWith(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        caseA.add(COLLISION_2);
        Assert.assertTrue(caseA.noneSatisfyWith(Predicates2.greaterThan(), COLLISION_2));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = this.newWith();
            set.addAll(MORE_COLLISIONS.subList(0, i));
            Verify.assertItemAtIndex(set.detect(MORE_COLLISIONS.get(i - 1)::equals), i - 1, MORE_COLLISIONS);
        }
        // test detect on a bucket with only one element
        MutableSet<Integer> set = this.newWith(COLLISION_1, COLLISION_2);
        set.remove(COLLISION_2);
        Assert.assertEquals(COLLISION_1, set.detect(COLLISION_1::equals));
        Assert.assertNull(set.detect(COLLISION_2::equals));
        for (int i = 0; i < COLLISIONS.size(); i++) {
            MutableSet<Integer> rehashingSet = this.newWith();
            rehashingSet.addAll(COLLISIONS.subList(0, i));
            Integer last = COLLISIONS.subList(0, i).getLast();
            rehashingSet.remove(last);
            int rehashingSetSize = rehashingSet.size();
            for (int j = 0; j < rehashingSetSize; j++) {
                rehashingSet.add(Integer.valueOf(j + 1));
            }
            rehashingSet.add(last);
            Assert.assertEquals(last, rehashingSet.detect(Predicates.equal(last)));
            Assert.assertNull(rehashingSet.detect(Integer.valueOf(5)::equals));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_increment_past_end() {
        MutableSet<Integer> set = this.newWith();
        Iterator<Integer> iterator = set.iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = IllegalStateException.class)
    public void iterator_remove_without_next() {
        Iterator<Integer> iterator = this.<Integer>newWith().iterator();
        iterator.remove();
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        MutableSet<Integer> integers = this.newWith(1);
        Integer[] target = new Integer[3];
        target[0] = 2;
        target[1] = 2;
        target[2] = 2;
        integers.toArray(target);
        Assert.assertArrayEquals(new Integer[] { 1, null, 2 }, target);
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(1, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 5), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test
    public void toImmutableSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(3, 4, null, 1, 2).toSortedBag();
    }

    @Override
    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @Test
    public void frequentCollisions() {
        String[] expected = ArrayAdapter.adapt(FREQUENT_COLLISIONS).subList(0, FREQUENT_COLLISIONS.length - 2).toArray(new String[FREQUENT_COLLISIONS.length - 2]);
        MutableSet<String> set1 = this.newWith();
        MutableSet<String> set2 = this.newWith();
        Collections.addAll(set1, FREQUENT_COLLISIONS);
        Collections.addAll(set2, expected);
        set1.retainAll(set2);
        Assert.assertArrayEquals(expected, set1.toArray());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
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
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetKeySetToArrayDest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetKeySetToArrayDest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_increment_past_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_increment_past_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_without_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_without_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollisions);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSetTestCase> frequentCollisions;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractMutableSetTestCase::testNewCollection;
            this.payloads.contains = AbstractMutableSetTestCase::contains;
            this.payloads.containsBy = AbstractMutableSetTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractMutableSetTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractMutableSetTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractMutableSetTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractMutableSetTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractMutableSetTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractMutableSetTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractMutableSetTestCase::containsAllCollection;
            this.payloads.selectWith = AbstractMutableSetTestCase::selectWith;
            this.payloads.selectWith_target = AbstractMutableSetTestCase::selectWith_target;
            this.payloads.rejectWith = AbstractMutableSetTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractMutableSetTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractMutableSetTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableSetTestCase::collect;
            this.payloads.collectTarget = AbstractMutableSetTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractMutableSetTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractMutableSetTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractMutableSetTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractMutableSetTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractMutableSetTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractMutableSetTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractMutableSetTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractMutableSetTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractMutableSetTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractMutableSetTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractMutableSetTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractMutableSetTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractMutableSetTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractMutableSetTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractMutableSetTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractMutableSetTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractMutableSetTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractMutableSetTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractMutableSetTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractMutableSetTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractMutableSetTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractMutableSetTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractMutableSetTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractMutableSetTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractMutableSetTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractMutableSetTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractMutableSetTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractMutableSetTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractMutableSetTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractMutableSetTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractMutableSetTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractMutableSetTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractMutableSetTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractMutableSetTestCase::flatCollectFloat;
            this.payloads.detectOptional = AbstractMutableSetTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractMutableSetTestCase::min;
            this.payloads.minOptional = AbstractMutableSetTestCase::minOptional;
            this.payloads.max = AbstractMutableSetTestCase::max;
            this.payloads.maxOptional = AbstractMutableSetTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractMutableSetTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractMutableSetTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractMutableSetTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractMutableSetTestCase::max_null_safe;
            this.payloads.minBy = AbstractMutableSetTestCase::minBy;
            this.payloads.minByOptional = AbstractMutableSetTestCase::minByOptional;
            this.payloads.maxBy = AbstractMutableSetTestCase::maxBy;
            this.payloads.maxByOptional = AbstractMutableSetTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractMutableSetTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractMutableSetTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableSetTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractMutableSetTestCase::detectWithIfNoneBlock;
            this.payloads.count = AbstractMutableSetTestCase::count;
            this.payloads.countWith = AbstractMutableSetTestCase::countWith;
            this.payloads.collectIf = AbstractMutableSetTestCase::collectIf;
            this.payloads.collectWith = AbstractMutableSetTestCase::collectWith;
            this.payloads.collectWith_target = AbstractMutableSetTestCase::collectWith_target;
            this.payloads.getAny = AbstractMutableSetTestCase::getAny;
            this.payloads.getOnly = AbstractMutableSetTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = AbstractMutableSetTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractMutableSetTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractMutableSetTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractMutableSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableSetTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractMutableSetTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractMutableSetTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractMutableSetTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractMutableSetTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractMutableSetTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractMutableSetTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractMutableSetTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractMutableSetTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractMutableSetTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractMutableSetTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractMutableSetTestCase::summarizeInt;
            this.payloads.sumLong = AbstractMutableSetTestCase::sumLong;
            this.payloads.summarizeLong = AbstractMutableSetTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractMutableSetTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableSetTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractMutableSetTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractMutableSetTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableSetTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractMutableSetTestCase::sumByDoubleConsistentRounding;
            this.payloads.partition = AbstractMutableSetTestCase::partition;
            this.payloads.partitionWith = AbstractMutableSetTestCase::partitionWith;
            this.payloads.toList = AbstractMutableSetTestCase::toList;
            this.payloads.toImmutableList = AbstractMutableSetTestCase::toImmutableList;
            this.payloads.toCollection = AbstractMutableSetTestCase::toCollection;
            this.payloads.toBag = AbstractMutableSetTestCase::toBag;
            this.payloads.toImmutableBag = AbstractMutableSetTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractMutableSetTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractMutableSetTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractMutableSetTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractMutableSetTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractMutableSetTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = AbstractMutableSetTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractMutableSetTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractMutableSetTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractMutableSetTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractMutableSetTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractMutableSetTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractMutableSetTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractMutableSetTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractMutableSetTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractMutableSetTestCase::toSet;
            this.payloads.toImmutableSet = AbstractMutableSetTestCase::toImmutableSet;
            this.payloads.toMap = AbstractMutableSetTestCase::toMap;
            this.payloads.toImmutableMap = AbstractMutableSetTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractMutableSetTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableSetTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractMutableSetTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractMutableSetTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractMutableSetTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractMutableSetTestCase::toImmutableBiMap;
            this.payloads.testToString = AbstractMutableSetTestCase::testToString;
            this.payloads.makeString = AbstractMutableSetTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractMutableSetTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractMutableSetTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractMutableSetTestCase::fusedCollectMakeString;
            this.payloads.appendString = AbstractMutableSetTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractMutableSetTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractMutableSetTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractMutableSetTestCase::appendStringThrows;
            this.payloads.countBy = AbstractMutableSetTestCase::countBy;
            this.payloads.countByWith = AbstractMutableSetTestCase::countByWith;
            this.payloads.countByEach = AbstractMutableSetTestCase::countByEach;
            this.payloads.groupBy = AbstractMutableSetTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableSetTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableSetTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableSetTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractMutableSetTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableSetTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableSetTestCase::chunk;
            this.payloads.chunk_empty = AbstractMutableSetTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractMutableSetTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractMutableSetTestCase::chunk_large_size;
            this.payloads.empty = AbstractMutableSetTestCase::empty;
            this.payloads.notEmpty = AbstractMutableSetTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractMutableSetTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractMutableSetTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractMutableSetTestCase::reduceOptional;
            this.payloads.newEmpty = AbstractMutableSetTestCase::newEmpty;
            this.payloads.toImmutable = AbstractMutableSetTestCase::toImmutable;
            this.payloads.testNewWith = AbstractMutableSetTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractMutableSetTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractMutableSetTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractMutableSetTestCase::testNewWithVarArgs;
            this.payloads.removeAll = AbstractMutableSetTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractMutableSetTestCase::removeAllIterable;
            this.payloads.retainAllIterable = AbstractMutableSetTestCase::retainAllIterable;
            this.payloads.clear = AbstractMutableSetTestCase::clear;
            this.payloads.injectIntoWith = AbstractMutableSetTestCase::injectIntoWith;
            this.payloads.removeObject = AbstractMutableSetTestCase::removeObject;
            this.payloads.selectAndRejectWith = AbstractMutableSetTestCase::selectAndRejectWith;
            this.payloads.removeIfWith = AbstractMutableSetTestCase::removeIfWith;
            this.payloads.with = AbstractMutableSetTestCase::with;
            this.payloads.withAll = AbstractMutableSetTestCase::withAll;
            this.payloads.without = AbstractMutableSetTestCase::without;
            this.payloads.withoutAll = AbstractMutableSetTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractMutableSetTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractMutableSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractMutableSetTestCase::asSynchronized;
            this.payloads.addAll = AbstractMutableSetTestCase::addAll;
            this.payloads.addAllIterable = AbstractMutableSetTestCase::addAllIterable;
            this.payloads.union = AbstractMutableSetTestCase::union;
            this.payloads.unionInto = AbstractMutableSetTestCase::unionInto;
            this.payloads.intersect = AbstractMutableSetTestCase::intersect;
            this.payloads.intersectInto = AbstractMutableSetTestCase::intersectInto;
            this.payloads.difference = AbstractMutableSetTestCase::difference;
            this.payloads.differenceInto = AbstractMutableSetTestCase::differenceInto;
            this.payloads.symmetricDifference = AbstractMutableSetTestCase::symmetricDifference;
            this.payloads.symmetricDifferenceInto = AbstractMutableSetTestCase::symmetricDifferenceInto;
            this.payloads.isSubsetOf = AbstractMutableSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractMutableSetTestCase::isProperSubsetOf;
            this.payloads.powerSet = AbstractMutableSetTestCase::powerSet;
            this.payloads.cartesianProduct = AbstractMutableSetTestCase::cartesianProduct;
            this.payloads.asUnmodifiable = AbstractMutableSetTestCase::asUnmodifiable;
            this.payloads.select = AbstractMutableSetTestCase::select;
            this.payloads.reject = AbstractMutableSetTestCase::reject;
            this.payloads.getFirst = AbstractMutableSetTestCase::getFirst;
            this.payloads.getLast = AbstractMutableSetTestCase::getLast;
            this.payloads.unifiedSetKeySetToArrayDest = AbstractMutableSetTestCase::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = AbstractMutableSetTestCase::unifiedSetToString;
            this.payloads.testClone = AbstractMutableSetTestCase::testClone;
            this.payloads.isEmpty = AbstractMutableSetTestCase::isEmpty;
            this.payloads.add = AbstractMutableSetTestCase::add;
            this.payloads.removeIf = AbstractMutableSetTestCase::removeIf;
            this.payloads.retainAll = AbstractMutableSetTestCase::retainAll;
            this.payloads.equalsAndHashCode = AbstractMutableSetTestCase::equalsAndHashCode;
            this.payloads.tap = AbstractMutableSetTestCase::tap;
            this.payloads.forEach = AbstractMutableSetTestCase::forEach;
            this.payloads.forEachWith = AbstractMutableSetTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractMutableSetTestCase::forEachWithIndex;
            this.payloads.anySatisfy = AbstractMutableSetTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableSetTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableSetTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableSetTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableSetTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableSetTestCase::noneSatisfyWith;
            this.payloads.detect = AbstractMutableSetTestCase::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toArray = AbstractMutableSetTestCase::toArray;
            this.payloads.toSortedBag_natural_ordering = AbstractMutableSetTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractMutableSetTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractMutableSetTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSetTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractMutableSetTestCase::toSortedBagBy;
            this.payloads.frequentCollisions = AbstractMutableSetTestCase::frequentCollisions;
        }
    }
}
