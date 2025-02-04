/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.lazy.ReverseIterable;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.junit.Assert.fail;

/**
 * Abstract JUnit test for {@link MutableList}s.
 */
public abstract class AbstractListTestCase extends AbstractCollectionTestCase {

    @Override
    protected abstract <T> MutableList<T> newWith(T... littleElements);

    @Test
    public void randomAccess_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new ListAdapter<>(FastList.newListWith(1, 2, 3)));
    }

    @Test
    public void getFirstOptional() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getFirstOptional().get());
        Assert.assertTrue(this.newWith(1, 2, 3).getFirstOptional().isPresent());
        Assert.assertFalse(this.newWith().getFirstOptional().isPresent());
    }

    @Test
    public void getLastOptional() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getLastOptional().get());
        Assert.assertTrue(this.newWith(1, 2, 3).getLastOptional().isPresent());
        Assert.assertFalse(this.newWith().getLastOptional().isPresent());
    }

    @Test
    public void detectIndex() {
        Assert.assertEquals(1, this.newWith(1, 2, 3, 4).detectIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(0, this.newWith(1, 2, 3, 4).detectIndex(integer -> integer % 2 != 0));
        Assert.assertEquals(-1, this.newWith(1, 2, 3, 4).detectIndex(integer -> integer % 5 == 0));
        Assert.assertEquals(2, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectIndex(integer -> integer == 2));
        Assert.assertEquals(0, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectIndex(integer -> integer != 2));
        Assert.assertEquals(-1, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectIndex(integer -> integer == 5));
    }

    @Test
    public void detectLastIndex() {
        Assert.assertEquals(3, this.newWith(1, 2, 3, 4).detectLastIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(2, this.newWith(1, 2, 3, 4).detectLastIndex(integer -> integer % 2 != 0));
        Assert.assertEquals(-1, this.newWith(1, 2, 3, 4).detectLastIndex(integer -> integer % 5 == 0));
        Assert.assertEquals(8, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectLastIndex(integer -> integer == 2));
        Assert.assertEquals(7, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectLastIndex(integer -> integer != 2));
        Assert.assertEquals(-1, this.newWith(1, 1, 2, 2, 3, 3, 3, 4, 2).detectLastIndex(integer -> integer == 5));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(3, 2, 1, 0).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ObjectIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(3, 2, 1, 0), pairs.collect(ObjectIntPair::getOne, Lists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(3, 2, 1, 0).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ObjectIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(3, 2, 1, 0), pairs.collect(ObjectIntPair::getOne, Lists.mutable.empty()));
        RichIterable<ObjectIntPair<Integer>> setOfPairs = this.newWith(3, 2, 1, 0).collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), setOfPairs.collectInt(ObjectIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(Sets.mutable.with(3, 2, 1, 0), setOfPairs.collect(ObjectIntPair::getOne, Sets.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndex() {
        MutableList<Integer> integers = this.newWith(0, 1, 2, 3);
        MutableList<Integer> selected1 = integers.selectWithIndex((each, index) -> (each + index) % 2 == 0);
        MutableList<Integer> selected2 = integers.selectWithIndex((each, index) -> index % 2 == 0);
        Assert.assertEquals(this.newWith(0, 1, 2, 3), selected1);
        Assert.assertEquals(this.newWith(0, 2), selected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableList<Integer> integers = this.newWith(0, 1, 2, 3);
        MutableSet<Integer> selected1 = integers.selectWithIndex((each, index) -> (each + index) % 2 == 0, Sets.mutable.empty());
        MutableSet<Integer> selected2 = integers.selectWithIndex((each, index) -> index % 2 == 0, Sets.mutable.empty());
        Assert.assertEquals(Sets.mutable.with(0, 1, 2, 3), selected1);
        Assert.assertEquals(Sets.mutable.with(0, 2), selected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndex() {
        MutableList<Integer> integers = this.newWith(0, 1, 2, 3);
        MutableList<Integer> rejected1 = integers.rejectWithIndex((each, index) -> (each + index) % 2 == 0);
        MutableList<Integer> rejected2 = integers.rejectWithIndex((each, index) -> index % 2 == 0);
        Assert.assertEquals(this.newWith(), rejected1);
        Assert.assertEquals(this.newWith(1, 3), rejected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableList<Integer> integers = this.newWith(0, 1, 2, 3);
        MutableSet<Integer> rejected1 = integers.rejectWithIndex((each, index) -> (each + index) % 2 == 0, Sets.mutable.empty());
        MutableSet<Integer> rejected2 = integers.rejectWithIndex((each, index) -> index % 2 == 0, Sets.mutable.empty());
        Assert.assertEquals(Sets.mutable.empty(), rejected1);
        Assert.assertEquals(Sets.mutable.with(1, 3), rejected2);
    }

    @Override
    public void collectBoolean() {
        super.collectBoolean();
        MutableBooleanList result = this.newWith(-1, 0, 1, 4).collectBoolean(PrimitiveFunctions.integerIsPositive());
        Assert.assertEquals(BooleanLists.mutable.of(false, false, true, true), result);
    }

    @Override
    public void collectByte() {
        super.collectByte();
        MutableByteList result = this.newWith(1, 2, 3, 4).collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertEquals(ByteLists.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4), result);
    }

    @Override
    public void collectChar() {
        super.collectChar();
        MutableCharList result = this.newWith(1, 2, 3, 4).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertEquals(CharLists.mutable.of((char) 1, (char) 2, (char) 3, (char) 4), result);
    }

    @Override
    public void collectDouble() {
        super.collectDouble();
        MutableDoubleList result = this.newWith(1, 2, 3, 4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertEquals(DoubleLists.mutable.of(1.0d, 2.0d, 3.0d, 4.0d), result);
    }

    @Override
    public void collectFloat() {
        super.collectFloat();
        MutableFloatList result = this.newWith(1, 2, 3, 4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertEquals(FloatLists.mutable.of(1.0f, 2.0f, 3.0f, 4.0f), result);
    }

    @Override
    public void collectInt() {
        super.collectInt();
        MutableIntList result = this.newWith(1, 2, 3, 4).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertEquals(IntLists.mutable.of(1, 2, 3, 4), result);
    }

    @Override
    public void collectLong() {
        super.collectLong();
        MutableLongList result = this.newWith(1, 2, 3, 4).collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertEquals(LongLists.mutable.of(1L, 2L, 3L, 4L), result);
    }

    @Override
    public void collectShort() {
        super.collectShort();
        MutableShortList result = this.newWith(1, 2, 3, 4).collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertEquals(ShortLists.mutable.of((short) 1, (short) 2, (short) 3, (short) 4), result);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableList.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        Verify.assertInstanceOf(ImmutableList.class, this.newWith().toImmutable());
        Assert.assertSame(this.newWith().toImmutable(), this.newWith().toImmutable());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableList.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void testClone() {
        MutableList<Integer> list = this.newWith(1, 2, 3);
        MutableList<Integer> list2 = list.clone();
        Verify.assertListsEqual(list, list2);
        try {
            Verify.assertShallowClone(list);
        } catch (Exception e) {
            // Suppress if a Java 9 specific exception related to reflection is thrown.
            if (!e.getClass().getCanonicalName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
        }
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        MutableCollection<Integer> list1 = this.newWith(1, 2, 3);
        MutableCollection<Integer> list2 = this.newWith(1, 2, 3);
        MutableCollection<Integer> list3 = this.newWith(2, 3, 4);
        MutableCollection<Integer> list4 = this.newWith(1, 2, 3, 4);
        Assert.assertNotEquals(list1, null);
        Verify.assertEqualsAndHashCode(list1, list1);
        Verify.assertEqualsAndHashCode(list1, list2);
        Verify.assertEqualsAndHashCode(new LinkedList<>(Arrays.asList(1, 2, 3)), list1);
        Verify.assertEqualsAndHashCode(new ArrayList<>(Arrays.asList(1, 2, 3)), list1);
        Verify.assertEqualsAndHashCode(ArrayAdapter.newArrayWith(1, 2, 3), list1);
        Assert.assertNotEquals(list2, list3);
        Assert.assertNotEquals(list2, list4);
        Assert.assertNotEquals(new LinkedList<>(Arrays.asList(1, 2, 3)), list4);
        Assert.assertNotEquals(new LinkedList<>(Arrays.asList(1, 2, 3, 3)), list4);
        Assert.assertNotEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), list4);
        Assert.assertNotEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 3)), list4);
        Assert.assertNotEquals(list4, new LinkedList<>(Arrays.asList(1, 2, 3)));
        Assert.assertNotEquals(list4, new LinkedList<>(Arrays.asList(1, 2, 3, 3)));
        Assert.assertNotEquals(list4, new ArrayList<>(Arrays.asList(1, 2, 3)));
        Assert.assertNotEquals(list4, new ArrayList<>(Arrays.asList(1, 2, 3, 3)));
        Assert.assertNotEquals(new LinkedList<>(Arrays.asList(1, 2, 3, 4)), list1);
        Assert.assertNotEquals(new LinkedList<>(Arrays.asList(1, 2, null)), list1);
        Assert.assertNotEquals(new LinkedList<>(Arrays.asList(1, 2)), list1);
        Assert.assertNotEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), list1);
        Assert.assertNotEquals(new ArrayList<>(Arrays.asList(1, 2, null)), list1);
        Assert.assertNotEquals(new ArrayList<>(Arrays.asList(1, 2)), list1);
        Assert.assertNotEquals(ArrayAdapter.newArrayWith(1, 2, 3, 4), list1);
    }

    @Test
    public void newListWithSize() {
        MutableList<Integer> list = this.newWith(1, 2, 3);
        Verify.assertContainsAll(list, 1, 2, 3);
    }

    @Test
    public void serialization() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertContainsAll(deserializedCollection, 1, 2, 3, 4, 5);
        Assert.assertEquals(collection, deserializedCollection);
    }

    @Test
    public void corresponds() {
        MutableList<Integer> integers1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        MutableList<Integer> integers2 = this.newWith(1, 2, 3, 4);
        Assert.assertFalse(integers1.corresponds(integers2, Predicates2.alwaysTrue()));
        Assert.assertFalse(integers2.corresponds(integers1, Predicates2.alwaysTrue()));
        MutableList<Integer> integers3 = this.newWith(2, 3, 3, 4, 4, 4, 5, 5, 5, 5);
        Assert.assertTrue(integers1.corresponds(integers3, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(integers3, Predicates2.greaterThan()));
        MutableList<Integer> nonRandomAccess = ListAdapter.adapt(new LinkedList<>(integers3));
        Assert.assertTrue(integers1.corresponds(nonRandomAccess, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(nonRandomAccess, Predicates2.greaterThan()));
        Assert.assertTrue(nonRandomAccess.corresponds(integers1, Predicates2.greaterThan()));
        Assert.assertFalse(nonRandomAccess.corresponds(integers1, Predicates2.lessThan()));
        MutableList<String> nullBlanks = this.newWith(null, "", " ", null);
        Assert.assertTrue(nullBlanks.corresponds(FastList.newListWith(null, "", " ", null), Objects::equals));
        Assert.assertFalse(nullBlanks.corresponds(FastList.newListWith("", null, " ", ""), Objects::equals));
    }

    @Test
    public void forEachFromTo() {
        MutableList<Integer> result = FastList.newList();
        MutableList<Integer> collection = FastList.newListWith(1, 2, 3, 4);
        collection.forEach(2, 3, result::add);
        Assert.assertEquals(this.newWith(3, 4), result);
        MutableList<Integer> result2 = FastList.newList();
        collection.forEach(3, 2, CollectionAddProcedure.on(result2));
        Assert.assertEquals(this.newWith(4, 3), result2);
        MutableList<Integer> result3 = FastList.newList();
        collection.forEach(0, 3, CollectionAddProcedure.on(result3));
        Assert.assertEquals(this.newWith(1, 2, 3, 4), result3);
        MutableList<Integer> result4 = FastList.newList();
        collection.forEach(3, 0, CollectionAddProcedure.on(result4));
        Assert.assertEquals(this.newWith(4, 3, 2, 1), result4);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> collection.forEach(-1, 0, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> collection.forEach(0, -1, result::add));
    }

    @Test
    public void forEachFromToInReverse() {
        MutableList<Integer> result = Lists.mutable.empty();
        this.newWith(1, 2, 3, 4).forEach(3, 2, result::add);
        Assert.assertEquals(FastList.newListWith(4, 3), result);
    }

    @Test
    public void reverseForEach() {
        MutableList<Integer> result = Lists.mutable.empty();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.reverseForEach(result::add);
        Assert.assertEquals(FastList.newListWith(4, 3, 2, 1), result);
    }

    @Test
    public void reverseForEach_emptyList() {
        MutableList<Integer> integers = Lists.mutable.empty();
        MutableList<Integer> results = Lists.mutable.empty();
        integers.reverseForEach(results::add);
        Assert.assertEquals(integers, results);
    }

    @Test
    public void reverseForEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.empty();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.reverseForEachWithIndex((each, index) -> result.add(each + index));
        Assert.assertEquals(FastList.newListWith(7, 5, 3, 1), result);
    }

    @Test
    public void reverseForEachWithIndex_emptyList() {
        MutableList<Integer> list = Lists.mutable.empty();
        list.reverseForEachWithIndex((each, index) -> fail());
    }

    @Test
    public void reverseThis() {
        MutableList<Integer> original = this.newWith(1, 2, 3, 4);
        MutableList<Integer> reversed = original.reverseThis();
        Assert.assertEquals(FastList.newListWith(4, 3, 2, 1), reversed);
        Assert.assertSame(original, reversed);
    }

    @Test
    public void toReversed() {
        MutableList<Integer> original = this.newWith(1, 2, 3, 4);
        MutableList<Integer> actual = original.toReversed();
        MutableList<Integer> expected = this.newWith(4, 3, 2, 1);
        Assert.assertEquals(expected, actual);
        Assert.assertNotSame(original, actual);
    }

    @Test
    public void distinct() {
        ListIterable<Integer> list = this.newWith(1, 4, 3, 2, 1, 4, 1);
        ListIterable<Integer> actual = list.distinct();
        Assert.assertEquals(Lists.mutable.with(1, 4, 3, 2), actual);
    }

    @Test
    public void distinctWithHashingStrategy() {
        ListIterable<String> list = this.newWith("a", "A", "b", "C", "b", "D", "E", "e");
        ListIterable<String> actual = list.distinct(HashingStrategies.fromFunction(String::toLowerCase));
        Assert.assertEquals(Lists.mutable.with("a", "b", "C", "D", "E"), actual);
    }

    /**
     * @since 9.0.
     */
    @Test
    public void distinctBy() {
        ListIterable<String> list = this.newWith("a", "A", "b", "C", "b", "D", "E", "e");
        ListIterable<String> actual = list.distinctBy(String::toLowerCase);
        Assert.assertEquals(Lists.mutable.with("a", "b", "C", "D", "E"), actual);
    }

    @Override
    @Test
    public void removeIf() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3, null);
        objects.removeIf(Predicates.isNull());
        Assert.assertEquals(FastList.newListWith(1, 2, 3), objects);
    }

    @Test
    public void removeIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.remove(2);
        Assert.assertEquals(FastList.newListWith(1, 2), objects);
    }

    @Test
    public void indexOf() {
        MutableList<Integer> objects = this.newWith(1, 2, 2);
        Assert.assertEquals(1, objects.indexOf(2));
        Assert.assertEquals(0, objects.indexOf(1));
        Assert.assertEquals(-1, objects.indexOf(3));
    }

    @Test
    public void lastIndexOf() {
        MutableList<Integer> objects = this.newWith(2, 2, 3);
        Assert.assertEquals(1, objects.lastIndexOf(2));
        Assert.assertEquals(2, objects.lastIndexOf(3));
        Assert.assertEquals(-1, objects.lastIndexOf(1));
    }

    @Test
    public void set() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(2), objects.set(1, 4));
        Assert.assertEquals(FastList.newListWith(1, 4, 3), objects);
    }

    @Test
    public void addAtIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.add(0, 0);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3), objects);
    }

    @Test
    public void addAllAtIndex() {
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.addAll(0, Lists.fixedSize.of(0));
        Integer one = -1;
        objects.addAll(0, new ArrayList<>(Lists.fixedSize.of(one)));
        objects.addAll(0, FastList.newListWith(-2));
        objects.addAll(0, UnifiedSet.newSetWith(-3));
        Assert.assertEquals(FastList.newListWith(-3, -2, -1, 0, 1, 2, 3), objects);
    }

    @Test
    public void withMethods() {
        Verify.assertContainsAll(this.newWith().with(1), 1);
        Verify.assertContainsAll(this.newWith(1), 1);
        Verify.assertContainsAll(this.newWith(1).with(2), 1, 2);
    }

    @Test
    public void sortThis_with_null() {
        MutableList<Integer> integers = this.newWith(2, null, 3, 4, 1);
        Verify.assertStartsWith(integers.sortThis(Comparators.safeNullsLow(Integer::compareTo)), null, 1, 2, 3, 4);
    }

    @Test
    public void sortThis_small() {
        MutableList<Integer> actual = this.newWith(1, 2, 3).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis();
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(1, 2, 3), actual);
    }

    @Test
    public void sortThis() {
        MutableList<Integer> actual = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis();
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), actual);
    }

    @Test
    public void sortThis_large() {
        MutableList<Integer> actual = this.newWith(Interval.oneTo(1000).toArray()).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis();
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(Interval.oneTo(1000).toList(), actual);
    }

    @Test
    public void sortThis_with_comparator_small() {
        MutableList<Integer> actual = this.newWith(1, 2, 3).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis(Collections.reverseOrder());
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(3, 2, 1), actual);
    }

    @Test
    public void sortThis_with_comparator() {
        MutableList<Integer> actual = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis(Collections.reverseOrder());
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), actual);
    }

    @Test
    public void sortThis_with_comparator_large() {
        MutableList<Integer> actual = this.newWith(Interval.oneTo(1000).toArray()).shuffleThis();
        MutableList<Integer> sorted = actual.sortThis(Collections.reverseOrder());
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(Interval.fromToBy(1000, 1, -1).toList(), actual);
    }

    @Test
    public void sortThisBy() {
        MutableList<Integer> actual = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).shuffleThis();
        MutableList<Integer> sorted = actual.sortThisBy(String::valueOf);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(1, 10, 2, 3, 4, 5, 6, 7, 8, 9), actual);
    }

    @Test
    public void sortThisByBoolean() {
        MutableList<Integer> actual = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MutableList<Integer> sorted = actual.sortThisByBoolean(i -> i % 2 == 0);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith(1, 3, 5, 7, 9, 2, 4, 6, 8, 10), actual);
    }

    @Test
    public void sortThisByInt() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByInt(Integer::parseInt);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Test
    public void sortThisByChar() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9").shuffleThis();
        MutableList<String> sorted = actual.sortThisByChar(s -> s.charAt(0));
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9"), actual);
    }

    @Test
    public void sortThisByByte() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByByte(Byte::parseByte);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Test
    public void sortThisByShort() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByShort(Short::parseShort);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Test
    public void sortThisByFloat() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByFloat(Float::parseFloat);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Test
    public void sortThisByLong() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByLong(Long::parseLong);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Test
    public void sortThisByDouble() {
        MutableList<String> actual = this.newWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").shuffleThis();
        MutableList<String> sorted = actual.sortThisByDouble(Double::parseDouble);
        Assert.assertSame(actual, sorted);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), actual);
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(MutableList.class, this.newWith().newEmpty());
    }

    @Override
    @Test
    public void testToString() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        list.add(list);
        Assert.assertEquals("[1, 2, 3, (this " + list.getClass().getSimpleName() + ")]", list.toString());
    }

    @Override
    @Test
    public void makeString() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        list.add(list);
        Assert.assertEquals("1, 2, 3, (this " + list.getClass().getSimpleName() + ')', list.makeString());
    }

    @Override
    @Test
    public void makeStringWithSeparator() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        Assert.assertEquals("1/2/3", list.makeString("/"));
    }

    @Override
    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        Assert.assertEquals("[1/2/3]", list.makeString("[", "/", "]"));
    }

    @Override
    @Test
    public void appendString() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        list.add(list);
        Appendable builder = new StringBuilder();
        list.appendString(builder);
        Assert.assertEquals("1, 2, 3, (this " + list.getClass().getSimpleName() + ')', builder.toString());
    }

    @Override
    @Test
    public void appendStringWithSeparator() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        list.appendString(builder, "/");
        Assert.assertEquals("1/2/3", builder.toString());
    }

    @Override
    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        MutableList<Object> list = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        list.appendString(builder, "[", "/", "]");
        Assert.assertEquals("[1/2/3]", builder.toString());
    }

    @Test
    public void forEachWithIndexWithFromTo() {
        MutableList<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        StringBuilder builder = new StringBuilder();
        integers.forEachWithIndex(5, 7, (each, index) -> builder.append(each).append(index));
        Assert.assertEquals("353627", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        integers.forEachWithIndex(5, 5, (each, index) -> builder2.append(each).append(index));
        Assert.assertEquals("35", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        integers.forEachWithIndex(0, 9, (each, index) -> builder3.append(each).append(index));
        Assert.assertEquals("40414243343536272819", builder3.toString());
        StringBuilder builder4 = new StringBuilder();
        integers.forEachWithIndex(7, 5, (each, index) -> builder4.append(each).append(index));
        Assert.assertEquals("273635", builder4.toString());
        StringBuilder builder5 = new StringBuilder();
        integers.forEachWithIndex(9, 0, (each, index) -> builder5.append(each).append(index));
        Assert.assertEquals("19282736353443424140", builder5.toString());
        MutableList<Integer> result = Lists.mutable.empty();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(-1, 0, new AddToList(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(0, -1, new AddToList(result)));
    }

    @Test
    public void forEachWithIndexWithFromToInReverse() {
        MutableList<Integer> result = Lists.mutable.empty();
        this.newWith(1, 2, 3).forEachWithIndex(2, 1, new AddToList(result));
        Assert.assertEquals(FastList.newListWith(3, 2), result);
    }

    @Test(expected = NullPointerException.class)
    public void sortThisWithNullWithNoComparator() {
        MutableList<Integer> integers = this.newWith(2, null, 3, 4, 1);
        integers.sortThis();
    }

    @Test(expected = NullPointerException.class)
    public void sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements() {
        MutableList<Integer> integers = this.newWith(2, null, 3, 4, 1, 5, 6, 7, 8, 9, 10, 11);
        integers.sortThis();
    }

    @Test(expected = NullPointerException.class)
    public void toSortedListWithNullWithNoComparator() {
        MutableList<Integer> integers = this.newWith(2, null, 3, 4, 1);
        integers.toSortedList();
    }

    @Test(expected = NullPointerException.class)
    public void toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements() {
        MutableList<Integer> integers = this.newWith(2, null, 3, 4, 1, 5, 6, 7, 8, 9, 10, 11);
        integers.toSortedList();
    }

    @Test
    public void forEachOnRange() {
        MutableList<Integer> list = this.newWith();
        list.addAll(FastList.newListWith(0, 1, 2, 3));
        list.addAll(FastList.newListWith(4, 5, 6));
        list.addAll(FastList.newList());
        list.addAll(FastList.newListWith(7, 8, 9));
        this.validateForEachOnRange(list, 0, 0, FastList.newListWith(0));
        this.validateForEachOnRange(list, 3, 5, FastList.newListWith(3, 4, 5));
        this.validateForEachOnRange(list, 4, 6, FastList.newListWith(4, 5, 6));
        this.validateForEachOnRange(list, 9, 9, FastList.newListWith(9));
        this.validateForEachOnRange(list, 0, 9, FastList.newListWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.validateForEachOnRange(list, 10, 10, FastList.newList()));
    }

    protected void validateForEachOnRange(MutableList<Integer> list, int from, int to, List<Integer> expectedOutput) {
        List<Integer> outputList = Lists.mutable.empty();
        list.forEach(from, to, outputList::add);
        Assert.assertEquals(expectedOutput, outputList);
    }

    @Test
    public void forEachWithIndexOnRange() {
        MutableList<Integer> list = this.newWith();
        list.addAll(FastList.newListWith(0, 1, 2, 3));
        list.addAll(FastList.newListWith(4, 5, 6));
        list.addAll(FastList.newList());
        list.addAll(FastList.newListWith(7, 8, 9));
        this.validateForEachWithIndexOnRange(list, 0, 0, FastList.newListWith(0));
        this.validateForEachWithIndexOnRange(list, 3, 5, FastList.newListWith(3, 4, 5));
        this.validateForEachWithIndexOnRange(list, 4, 6, FastList.newListWith(4, 5, 6));
        this.validateForEachWithIndexOnRange(list, 9, 9, FastList.newListWith(9));
        this.validateForEachWithIndexOnRange(list, 0, 9, FastList.newListWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.validateForEachWithIndexOnRange(list, 10, 10, FastList.newList()));
    }

    protected void validateForEachWithIndexOnRange(MutableList<Integer> list, int from, int to, List<Integer> expectedOutput) {
        MutableList<Integer> outputList = Lists.mutable.empty();
        list.forEachWithIndex(from, to, (each, index) -> outputList.add(each));
        Assert.assertEquals(expectedOutput, outputList);
    }

    @Test
    public void subList() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertPostSerializedEqualsAndHashCode(sublist);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
        sublist.add("X");
        Verify.assertSize(3, sublist);
        Verify.assertContainsAll(sublist, "B", "C", "X");
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, "A", "B", "C", "X", "D");
        sublist.remove("X");
        Verify.assertContainsAll(sublist, "B", "C");
        Verify.assertContainsAll(list, "A", "B", "C", "D");
        Assert.assertEquals("C", sublist.set(1, "R"));
        Verify.assertContainsAll(sublist, "B", "R");
        Verify.assertContainsAll(list, "A", "B", "R", "D");
        sublist.addAll(Arrays.asList("W", "G"));
        Verify.assertContainsAll(sublist, "B", "R", "W", "G");
        Verify.assertContainsAll(list, "A", "B", "R", "W", "G", "D");
        sublist.clear();
        Verify.assertEmpty(sublist);
        Assert.assertFalse(sublist.remove("X"));
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subListFromOutOfBoundsException() {
        this.newWith(1).subList(-1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subListToGreaterThanSizeException() {
        this.newWith(1).subList(0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subListFromGreaterThanToException() {
        this.newWith(1).subList(1, 0);
    }

    @Test
    public void getWithIndexOutOfBoundsException() {
        Object item = new Object();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.newWith(item).get(1));
    }

    @Test
    public void getWithArrayIndexOutOfBoundsException() {
        Object item = new Object();
        try {
            this.newWith(item).get(-1);
            fail("Should not reach here! Exception should be thrown on previous line.");
        } catch (Exception e) {
            Assert.assertTrue((e instanceof ArrayIndexOutOfBoundsException) || (e instanceof IndexOutOfBoundsException));
        }
    }

    @Test
    public void listIterator() {
        int sum = 0;
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        for (Integer each : integers) {
            sum += each.intValue();
        }
        for (ListIterator<Integer> iterator = integers.listIterator(4); iterator.hasPrevious(); ) {
            Integer each = iterator.previous();
            sum += each.intValue();
        }
        Assert.assertEquals(20, sum);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void listIteratorIndexTooSmall() {
        this.newWith(1).listIterator(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void listIteratorIndexTooBig() {
        this.newWith(1).listIterator(2);
    }

    @Override
    @Test
    public void chunk() {
        super.chunk();
        MutableCollection<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        RichIterable<RichIterable<String>> groups = collection.chunk(2);
        Assert.assertEquals(FastList.<RichIterable<String>>newListWith(FastList.newListWith("1", "2"), FastList.newListWith("3", "4"), FastList.newListWith("5", "6"), FastList.newListWith("7")), groups);
    }

    @Test
    public void toStack() {
        MutableStack<Integer> stack = this.newWith(1, 2, 3, 4).toStack();
        Assert.assertEquals(Stacks.mutable.of(1, 2, 3, 4), stack);
    }

    @Test
    public void take() {
        MutableList<Integer> mutableList = this.newWith(1, 2, 3, 4, 5);
        Assert.assertEquals(iList(), mutableList.take(0));
        Assert.assertEquals(iList(1, 2, 3), mutableList.take(3));
        Assert.assertEquals(iList(1, 2, 3, 4), mutableList.take(mutableList.size() - 1));
        ImmutableList<Integer> expectedList = iList(1, 2, 3, 4, 5);
        Assert.assertEquals(expectedList, mutableList.take(mutableList.size()));
        Assert.assertEquals(expectedList, mutableList.take(10));
        Assert.assertEquals(expectedList, mutableList.take(Integer.MAX_VALUE));
        Assert.assertNotSame(mutableList, mutableList.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        this.newWith(1, 2, 3, 4, 5).take(-1);
    }

    @Test
    public void takeWhile() {
        Assert.assertEquals(iList(1, 2, 3), this.newWith(1, 2, 3, 4, 5).takeWhile(Predicates.lessThan(4)));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), this.newWith(1, 2, 3, 4, 5).takeWhile(Predicates.lessThan(10)));
        Assert.assertEquals(iList(), this.newWith(1, 2, 3, 4, 5).takeWhile(Predicates.lessThan(0)));
    }

    @Test
    public void drop() {
        MutableList<Integer> mutableList = this.newWith(1, 2, 3, 4, 5);
        Assert.assertEquals(iList(1, 2, 3, 4, 5), mutableList.drop(0));
        Assert.assertNotSame(mutableList, mutableList.drop(0));
        Assert.assertEquals(iList(4, 5), mutableList.drop(3));
        Assert.assertEquals(iList(5), mutableList.drop(mutableList.size() - 1));
        Assert.assertEquals(iList(), mutableList.drop(mutableList.size()));
        Assert.assertEquals(iList(), mutableList.drop(10));
        Assert.assertEquals(iList(), mutableList.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.newWith(1, 2, 3, 4, 5).drop(-1);
    }

    @Test
    public void dropWhile() {
        Assert.assertEquals(iList(4, 5), this.newWith(1, 2, 3, 4, 5).dropWhile(Predicates.lessThan(4)));
        Assert.assertEquals(iList(), this.newWith(1, 2, 3, 4, 5).dropWhile(Predicates.lessThan(10)));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), this.newWith(1, 2, 3, 4, 5).dropWhile(Predicates.lessThan(0)));
    }

    @Test
    public void partitionWhile() {
        PartitionMutableList<Integer> partition1 = this.newWith(1, 2, 3, 4, 5).partitionWhile(Predicates.lessThan(4));
        Assert.assertEquals(iList(1, 2, 3), partition1.getSelected());
        Assert.assertEquals(iList(4, 5), partition1.getRejected());
        PartitionMutableList<Integer> partition2 = this.newWith(1, 2, 3, 4, 5).partitionWhile(Predicates.lessThan(0));
        Assert.assertEquals(iList(), partition2.getSelected());
        Assert.assertEquals(iList(1, 2, 3, 4, 5), partition2.getRejected());
        PartitionMutableList<Integer> partition3 = this.newWith(1, 2, 3, 4, 5).partitionWhile(Predicates.lessThan(10));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), partition3.getSelected());
        Assert.assertEquals(iList(), partition3.getRejected());
    }

    @Test
    public void asReversed() {
        Verify.assertInstanceOf(ReverseIterable.class, this.newWith().asReversed());
        Verify.assertIterablesEqual(iList(4, 3, 2, 1), this.newWith(1, 2, 3, 4).asReversed());
    }

    @Test
    public void binarySearch() {
        MutableList<Integer> sortedList = this.newWith(1, 2, 3, 4, 5, 7);
        Assert.assertEquals(1, sortedList.binarySearch(2));
        Assert.assertEquals(-6, sortedList.binarySearch(6));
        for (Integer integer : sortedList) {
            Assert.assertEquals(Collections.binarySearch(sortedList, integer), sortedList.binarySearch(integer));
        }
    }

    @Test
    public void binarySearchWithComparator() {
        MutableList<Integer> sortedList = this.newWith(7, 5, 4, 3, 2, 1);
        Assert.assertEquals(4, sortedList.binarySearch(2, Comparators.reverseNaturalOrder()));
        Assert.assertEquals(-2, sortedList.binarySearch(6, Comparators.reverseNaturalOrder()));
        for (Integer integer : sortedList) {
            Assert.assertEquals(Collections.binarySearch(sortedList, integer, Comparators.reverseNaturalOrder()), sortedList.binarySearch(integer, Comparators.reverseNaturalOrder()));
        }
    }

    @Test
    @Override
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<Integer> elements = FastList.newList();
        MutableIntList indexes = new IntArrayList();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEachWithIndex((Integer object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), elements);
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 2, 3), indexes);
    }

    @Test
    public void forEachInBoth() {
        MutableList<Pair<Integer, String>> result = Lists.mutable.empty();
        ListIterable<Integer> integers = this.newWith(1, 2, 3);
        ImmutableList<String> strings = this.newWith("1", "2", "3").toImmutable();
        integers.forEachInBoth(strings, (integer, string) -> result.add(Tuples.pair(integer, string)));
        Assert.assertEquals(Lists.immutable.with(Tuples.pair(1, "1"), Tuples.pair(2, "2"), Tuples.pair(3, "3")), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachInBothThrowsOnDifferentListSizes() {
        MutableList<Pair<Integer, String>> result = Lists.mutable.empty();
        ListIterable<Integer> integers = this.newWith(1, 2, 3);
        ImmutableList<String> strings = this.newWith("1", "2").toImmutable();
        integers.forEachInBoth(strings, (integer, string) -> result.add(Tuples.pair(integer, string)));
    }

    @Test(expected = NullPointerException.class)
    public void forEachInBothThrowsOnNullList() {
        MutableList<Object> result = Lists.mutable.empty();
        ListIterable<Integer> integers = this.newWith(1, 2, 3);
        integers.forEachInBoth(null, (a, b) -> result.add(b));
    }

    @Test
    public void replaceAll() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.replaceAll(i -> i * 2);
        Assert.assertEquals(Lists.mutable.with(2, 4, 6, 8), integers);
    }

    @Test
    public void sort() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.sort(Comparator.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(4, 3, 2, 1), integers);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractListTestCase instance;

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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
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
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_randomAccess_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.randomAccess_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromToInReverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_small);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_large);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_small);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_large);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromToInReverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnRange);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromOutOfBoundsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSizeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSizeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanToException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanToException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithIndexOutOfBoundsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithArrayIndexOutOfBoundsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooSmall() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooSmall);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooBig() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooBig);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearchWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnDifferentListSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnDifferentListSizes);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnNullList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnNullList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractListTestCase> sort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractListTestCase::testNewCollection;
            this.payloads.contains = AbstractListTestCase::contains;
            this.payloads.containsBy = AbstractListTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractListTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractListTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractListTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractListTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractListTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractListTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractListTestCase::containsAllCollection;
            this.payloads.tap = AbstractListTestCase::tap;
            this.payloads.forEach = AbstractListTestCase::forEach;
            this.payloads.forEachWith = AbstractListTestCase::forEachWith;
            this.payloads.select = AbstractListTestCase::select;
            this.payloads.selectWith = AbstractListTestCase::selectWith;
            this.payloads.selectWith_target = AbstractListTestCase::selectWith_target;
            this.payloads.reject = AbstractListTestCase::reject;
            this.payloads.rejectWith = AbstractListTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractListTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractListTestCase::selectInstancesOf;
            this.payloads.collect = AbstractListTestCase::collect;
            this.payloads.collectTarget = AbstractListTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractListTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractListTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractListTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractListTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractListTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractListTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractListTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractListTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractListTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractListTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractListTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractListTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractListTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractListTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractListTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractListTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractListTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractListTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractListTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractListTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractListTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractListTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractListTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractListTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractListTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractListTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractListTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractListTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractListTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractListTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractListTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractListTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractListTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractListTestCase::flatCollectFloat;
            this.payloads.detect = AbstractListTestCase::detect;
            this.payloads.detectOptional = AbstractListTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractListTestCase::min;
            this.payloads.minOptional = AbstractListTestCase::minOptional;
            this.payloads.max = AbstractListTestCase::max;
            this.payloads.maxOptional = AbstractListTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractListTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractListTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractListTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractListTestCase::max_null_safe;
            this.payloads.minBy = AbstractListTestCase::minBy;
            this.payloads.minByOptional = AbstractListTestCase::minByOptional;
            this.payloads.maxBy = AbstractListTestCase::maxBy;
            this.payloads.maxByOptional = AbstractListTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractListTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractListTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractListTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractListTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractListTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractListTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractListTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractListTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractListTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractListTestCase::anySatisfyWith;
            this.payloads.count = AbstractListTestCase::count;
            this.payloads.countWith = AbstractListTestCase::countWith;
            this.payloads.collectIf = AbstractListTestCase::collectIf;
            this.payloads.collectWith = AbstractListTestCase::collectWith;
            this.payloads.collectWith_target = AbstractListTestCase::collectWith_target;
            this.payloads.getAny = AbstractListTestCase::getAny;
            this.payloads.getFirst = AbstractListTestCase::getFirst;
            this.payloads.getLast = AbstractListTestCase::getLast;
            this.payloads.getOnly = AbstractListTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractListTestCase::isEmpty;
            this.payloads.iterator = AbstractListTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractListTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractListTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractListTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractListTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractListTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractListTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractListTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractListTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractListTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractListTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractListTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractListTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractListTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractListTestCase::summarizeInt;
            this.payloads.sumLong = AbstractListTestCase::sumLong;
            this.payloads.summarizeLong = AbstractListTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractListTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractListTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractListTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractListTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractListTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractListTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = AbstractListTestCase::toArray;
            this.payloads.partition = AbstractListTestCase::partition;
            this.payloads.partitionWith = AbstractListTestCase::partitionWith;
            this.payloads.toList = AbstractListTestCase::toList;
            this.payloads.toImmutableList = AbstractListTestCase::toImmutableList;
            this.payloads.toCollection = AbstractListTestCase::toCollection;
            this.payloads.toBag = AbstractListTestCase::toBag;
            this.payloads.toImmutableBag = AbstractListTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractListTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractListTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractListTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractListTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = AbstractListTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractListTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractListTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractListTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractListTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = AbstractListTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractListTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractListTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractListTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractListTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractListTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractListTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractListTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractListTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractListTestCase::toSet;
            this.payloads.toImmutableSet = AbstractListTestCase::toImmutableSet;
            this.payloads.toMap = AbstractListTestCase::toMap;
            this.payloads.toImmutableMap = AbstractListTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractListTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractListTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractListTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractListTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractListTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractListTestCase::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = AbstractListTestCase::fusedCollectMakeString;
            this.payloads.appendStringThrows = AbstractListTestCase::appendStringThrows;
            this.payloads.countBy = AbstractListTestCase::countBy;
            this.payloads.countByWith = AbstractListTestCase::countByWith;
            this.payloads.countByEach = AbstractListTestCase::countByEach;
            this.payloads.groupBy = AbstractListTestCase::groupBy;
            this.payloads.groupByEach = AbstractListTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractListTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractListTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractListTestCase::zip;
            this.payloads.zipWithIndex = AbstractListTestCase::zipWithIndex;
            this.payloads.chunk_empty = AbstractListTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractListTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractListTestCase::chunk_large_size;
            this.payloads.empty = AbstractListTestCase::empty;
            this.payloads.notEmpty = AbstractListTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractListTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractListTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractListTestCase::reduceOptional;
            this.payloads.testNewWith = AbstractListTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractListTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractListTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractListTestCase::testNewWithVarArgs;
            this.payloads.addAll = AbstractListTestCase::addAll;
            this.payloads.addAllIterable = AbstractListTestCase::addAllIterable;
            this.payloads.removeAll = AbstractListTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractListTestCase::removeAllIterable;
            this.payloads.retainAll = AbstractListTestCase::retainAll;
            this.payloads.retainAllIterable = AbstractListTestCase::retainAllIterable;
            this.payloads.clear = AbstractListTestCase::clear;
            this.payloads.injectIntoWith = AbstractListTestCase::injectIntoWith;
            this.payloads.removeObject = AbstractListTestCase::removeObject;
            this.payloads.selectAndRejectWith = AbstractListTestCase::selectAndRejectWith;
            this.payloads.removeIfWith = AbstractListTestCase::removeIfWith;
            this.payloads.with = AbstractListTestCase::with;
            this.payloads.withAll = AbstractListTestCase::withAll;
            this.payloads.without = AbstractListTestCase::without;
            this.payloads.withoutAll = AbstractListTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractListTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractListTestCase::asLazy;
            this.payloads.randomAccess_throws = AbstractListTestCase::randomAccess_throws;
            this.payloads.getFirstOptional = AbstractListTestCase::getFirstOptional;
            this.payloads.getLastOptional = AbstractListTestCase::getLastOptional;
            this.payloads.detectIndex = AbstractListTestCase::detectIndex;
            this.payloads.detectLastIndex = AbstractListTestCase::detectLastIndex;
            this.payloads.collectWithIndex = AbstractListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractListTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = AbstractListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractListTestCase::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = AbstractListTestCase::asSynchronized;
            this.payloads.toImmutable = AbstractListTestCase::toImmutable;
            this.payloads.asUnmodifiable = AbstractListTestCase::asUnmodifiable;
            this.payloads.testClone = AbstractListTestCase::testClone;
            this.payloads.equalsAndHashCode = AbstractListTestCase::equalsAndHashCode;
            this.payloads.newListWithSize = AbstractListTestCase::newListWithSize;
            this.payloads.serialization = AbstractListTestCase::serialization;
            this.payloads.corresponds = AbstractListTestCase::corresponds;
            this.payloads.forEachFromTo = AbstractListTestCase::forEachFromTo;
            this.payloads.forEachFromToInReverse = AbstractListTestCase::forEachFromToInReverse;
            this.payloads.reverseForEach = AbstractListTestCase::reverseForEach;
            this.payloads.reverseForEach_emptyList = AbstractListTestCase::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = AbstractListTestCase::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = AbstractListTestCase::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = AbstractListTestCase::reverseThis;
            this.payloads.toReversed = AbstractListTestCase::toReversed;
            this.payloads.distinct = AbstractListTestCase::distinct;
            this.payloads.distinctWithHashingStrategy = AbstractListTestCase::distinctWithHashingStrategy;
            this.payloads.distinctBy = AbstractListTestCase::distinctBy;
            this.payloads.removeIf = AbstractListTestCase::removeIf;
            this.payloads.removeIndex = AbstractListTestCase::removeIndex;
            this.payloads.indexOf = AbstractListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractListTestCase::lastIndexOf;
            this.payloads.set = AbstractListTestCase::set;
            this.payloads.addAtIndex = AbstractListTestCase::addAtIndex;
            this.payloads.addAllAtIndex = AbstractListTestCase::addAllAtIndex;
            this.payloads.withMethods = AbstractListTestCase::withMethods;
            this.payloads.sortThis_with_null = AbstractListTestCase::sortThis_with_null;
            this.payloads.sortThis_small = AbstractListTestCase::sortThis_small;
            this.payloads.sortThis = AbstractListTestCase::sortThis;
            this.payloads.sortThis_large = AbstractListTestCase::sortThis_large;
            this.payloads.sortThis_with_comparator_small = AbstractListTestCase::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = AbstractListTestCase::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = AbstractListTestCase::sortThis_with_comparator_large;
            this.payloads.sortThisBy = AbstractListTestCase::sortThisBy;
            this.payloads.sortThisByBoolean = AbstractListTestCase::sortThisByBoolean;
            this.payloads.sortThisByInt = AbstractListTestCase::sortThisByInt;
            this.payloads.sortThisByChar = AbstractListTestCase::sortThisByChar;
            this.payloads.sortThisByByte = AbstractListTestCase::sortThisByByte;
            this.payloads.sortThisByShort = AbstractListTestCase::sortThisByShort;
            this.payloads.sortThisByFloat = AbstractListTestCase::sortThisByFloat;
            this.payloads.sortThisByLong = AbstractListTestCase::sortThisByLong;
            this.payloads.sortThisByDouble = AbstractListTestCase::sortThisByDouble;
            this.payloads.newEmpty = AbstractListTestCase::newEmpty;
            this.payloads.testToString = AbstractListTestCase::testToString;
            this.payloads.makeString = AbstractListTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractListTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractListTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractListTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractListTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractListTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = AbstractListTestCase::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = AbstractListTestCase::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = AbstractListTestCase::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = AbstractListTestCase::forEachWithIndexOnRange;
            this.payloads.subList = AbstractListTestCase::subList;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = AbstractListTestCase::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = AbstractListTestCase::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = AbstractListTestCase::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = AbstractListTestCase::chunk;
            this.payloads.toStack = AbstractListTestCase::toStack;
            this.payloads.take = AbstractListTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = AbstractListTestCase::takeWhile;
            this.payloads.drop = AbstractListTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = AbstractListTestCase::dropWhile;
            this.payloads.partitionWhile = AbstractListTestCase::partitionWhile;
            this.payloads.asReversed = AbstractListTestCase::asReversed;
            this.payloads.binarySearch = AbstractListTestCase::binarySearch;
            this.payloads.binarySearchWithComparator = AbstractListTestCase::binarySearchWithComparator;
            this.payloads.forEachWithIndex = AbstractListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractListTestCase::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractListTestCase::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = AbstractListTestCase::replaceAll;
            this.payloads.sort = AbstractListTestCase::sort;
        }
    }
}
