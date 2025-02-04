/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.IntBooleanMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.IntBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bimap.mutable.HashBiMap;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link IntBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveBooleanMapKeyValuesViewTest.stg.
 */
public abstract class AbstractIntBooleanMapKeyValuesViewTestCase {

    public abstract IntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3);

    public abstract IntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2);

    public abstract IntBooleanMap newWithKeysValues(int key1, boolean value1);

    public abstract IntBooleanMap newEmpty();

    public RichIterable<IntBooleanPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<IntBooleanPair> newWith(int key1, boolean value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<IntBooleanPair> newWith(int key1, boolean value1, int key2, boolean value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<IntBooleanPair> newWith(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(1, true))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<IntBooleanPair> result = Lists.mutable.of();
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        collection.forEach(Procedures.cast(result::add));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false));
        MutableList<IntBooleanPair> result2 = Lists.mutable.of();
        RichIterable<IntBooleanPair> collection2 = this.newWith(0, false, 2, true, 3, false);
        collection2.forEach(Procedures.cast(result2::add));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false));
    }

    @Test
    public void forEachWith() {
        MutableBag<IntBooleanPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        collection.forEachWith((IntBooleanPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<IntBooleanPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 0, true, 3, false);
        collection.forEachWithIndex((IntBooleanPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(0, true), PrimitiveTuples.pair(3, false)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).select(PrimitiveTuples.pair(2, true)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, false), result);
    }

    @Test
    public void selectWith() {
        MutableList<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).selectWith(Object::equals, PrimitiveTuples.pair(2, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, false), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, true), HashBag.<IntBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(3, false)), result);
    }

    @Test
    public void reject() {
        MutableList<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).reject(Predicates.notEqual(PrimitiveTuples.pair(2, true))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, false), result);
    }

    @Test
    public void rejectWith() {
        MutableList<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, false), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).rejectWith(Object::equals, PrimitiveTuples.pair(2, true), HashBag.<IntBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(3, false)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(IntBooleanPair.class), PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(3, false), PrimitiveTuples.pair(2, true));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1, false, 2, true, 3, false).collect((IntBooleanPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Boolean> result2 = this.newWith(1, false, 2, true, 3, false).collect(IntBooleanPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(false, true, false), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1, false, 2, true, 3, false).collectBoolean((IntBooleanPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1, false, 2, true, 3, false).collectByte((IntBooleanPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1, false, 2, true, 3, false).collectChar((IntBooleanPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1, false, 2, true, 3, false).collectDouble((IntBooleanPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1, false, 2, true, 3, false).collectFloat((IntBooleanPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1, false, 2, true, 3, false).collectInt((IntBooleanPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1, false, 2, true, 3, false).collectLong((IntBooleanPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1, false, 2, true, 3, false).collectShort((IntBooleanPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Function<IntBooleanPair, MutableList<String>> function = (IntBooleanPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:false", "2:true", "3:false"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:false", "2:true", "3:false"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2, true), this.newWith(1, false, 2, true, 3, false).detect(PrimitiveTuples.pair(2, true)::equals));
        Assert.assertNull(this.newWith(1, false, 2, true, 3, false).detect(PrimitiveTuples.pair(2, 4L)::equals));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws() {
        this.newWith().min(Comparators.naturalOrder());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws() {
        this.newWith().max(Comparators.naturalOrder());
    }

    @Test
    public void min() {
        Assert.assertEquals(PrimitiveTuples.pair(1, false), this.newWith(1, false, 2, true, 3, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3, false), this.newWith(1, false, 2, true, 3, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1, false), this.newWith(1, false, 2, true, 3, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3, false), this.newWith(1, false, 2, true, 3, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2, true), this.newWith(1, false, 2, true, 3, false).minBy((IntBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1, false), this.newWith(1, false, 2, true, 4, false).maxBy((IntBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2, true), this.newWith(1, false, 2, true, 3, false).detectWith(Object::equals, PrimitiveTuples.pair(2, true)));
        Assert.assertNull(this.newWith(1, false, 2, true, 3, false).detectWith(Object::equals, PrimitiveTuples.pair(2, false)));
    }

    @Test
    public void detectIfNone() {
        Function0<IntBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5, true));
        Assert.assertEquals(PrimitiveTuples.pair(2, true), this.newWith(1, false, 2, true, 3, false).detectIfNone(PrimitiveTuples.pair(2, true)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5, true), this.newWith(1, false, 2, true, 3, false).detectIfNone(PrimitiveTuples.pair(2, false)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<IntBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5, true));
        Assert.assertEquals(PrimitiveTuples.pair(2, true), this.newWith(1, false, 2, true, 3, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, true), function));
        Assert.assertEquals(PrimitiveTuples.pair(5, true), this.newWith(1, false, 2, true, 3, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, false), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).allSatisfy(IntBooleanPair.class::isInstance));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).allSatisfy(PrimitiveTuples.pair(2, true)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).allSatisfyWith(Predicates2.instanceOf(), IntBooleanPair.class));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2, true)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).noneSatisfy(PrimitiveTuples.pair(2, true)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2, true)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).anySatisfy(PrimitiveTuples.pair(2, true)::equals));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).anySatisfy(PrimitiveTuples.pair(2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1, false, 2, true, 3, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, true)));
        Assert.assertFalse(this.newWith(1, false, 2, true, 3, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1, false, 2, true, 3, false).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, false, 2, true, 3, false).count(IntBooleanPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, false, 2, true, 3, false).count(PrimitiveTuples.pair(2, true)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1, false, 2, true, 3, false).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, false, 2, true, 3, false).countWith(Predicates2.instanceOf(), IntBooleanPair.class));
        Assert.assertEquals(1, this.newWith(1, false, 2, true, 3, false).countWith(Object::equals, PrimitiveTuples.pair(2, true)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1, false, 2, true, 3, false).collectIf(IntBooleanPair.class::isInstance, String::valueOf), "1:false", "2:true", "3:false");
        Verify.assertContainsAll(this.newWith(1, false, 2, true, 3, false).collectIf(IntBooleanPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:false", "2:true", "3:false");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of("3:false-", "2:true-", "1:false-"), this.newWith(1, false, 2, true, 3, false).collectWith((IntBooleanPair argument1, String argument2) -> argument1 + argument2, "-").toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of("1:false-", "2:true-", "3:false-"), this.newWith(1, false, 2, true, 3, false).collectWith((IntBooleanPair argument1, String argument2) -> argument1 + argument2, "-", HashBag.<String>newBag()));
    }

    @Test
    public void getFirst() {
        IntBooleanPair first = this.newWith(1, false, 2, true, 3, false).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1, false).equals(first) || PrimitiveTuples.pair(2, true).equals(first) || PrimitiveTuples.pair(3, false).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1, false), this.newWith(1, false).getFirst());
    }

    @Test
    public void getLast() {
        IntBooleanPair last = this.newWith(1, false, 2, true, 3, false).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1, false).equals(last) || PrimitiveTuples.pair(2, true).equals(last) || PrimitiveTuples.pair(3, false).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1, false), this.newWith(1, false).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, false));
        Assert.assertTrue(this.newWith(1, false).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 0, true, 3, false);
        MutableBag<IntBooleanPair> actual = Bags.mutable.of();
        Iterator<IntBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        Iterator<IntBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        Iterator<IntBooleanPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        Long result = objects.injectInto(1L, (Long argument1, IntBooleanPair argument2) -> (long) (argument1 + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(Long.valueOf(9), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        int result = objects.injectInto(1, (int intParameter, IntBooleanPair argument2) -> (int) (intParameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        long result = objects.injectInto(1L, (long parameter, IntBooleanPair argument2) -> (long) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        double result = objects.injectInto(1.0, (double parameter, IntBooleanPair argument2) -> (double) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        float result = objects.injectInto(1.0f, (float parameter, IntBooleanPair argument2) -> (float) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        double actual = objects.sumOfFloat((IntBooleanPair each) -> (float) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        double actual = objects.sumOfDouble((IntBooleanPair each) -> (double) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        long actual = objects.sumOfInt((IntBooleanPair each) -> (int) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        long actual = objects.sumOfLong((IntBooleanPair each) -> (long) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void toArray() {
        RichIterable<IntBooleanPair> objects = this.newWith(1, false, 2, true, 3, false);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        IntBooleanPair[] array2 = objects.toArray(new IntBooleanPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).partition(PrimitiveTuples.pair(2, true)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionIterable<IntBooleanPair> result = this.newWith(1, false, 2, true, 3, false).partitionWith(Object::equals, PrimitiveTuples.pair(2, true));
        Verify.assertContains(PrimitiveTuples.pair(2, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<IntBooleanPair> list = this.newWith(1, false, 2, true, 3, false).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false));
    }

    @Test
    public void toBag() {
        MutableBag<IntBooleanPair> bag = this.newWith(1, false, 2, true, 3, false).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableList<IntBooleanPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableList<IntBooleanPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(1, false)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableList<IntBooleanPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedBag<IntBooleanPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedBag<IntBooleanPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(1, false)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedBag<IntBooleanPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedSet<IntBooleanPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedSet<IntBooleanPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(1, false)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<IntBooleanPair> pairs = this.newWith(2, true, 1, false, 3, false);
        MutableSortedSet<IntBooleanPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false)), set);
    }

    @Test
    public void toSet() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableSet<IntBooleanPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1, false), PrimitiveTuples.pair(2, true), PrimitiveTuples.pair(3, false));
    }

    @Test
    public void toMap() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<IntBooleanPair> pairs = this.newWith(1, false, 2, true, 3, false);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true);
        Assert.assertTrue("[1:false, 2:true]".equals(collection.toString()) || "[2:true, 1:false]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Function<IntBooleanPair, Boolean> function = (IntBooleanPair object) -> PrimitiveTuples.pair(1, false).equals(object);
        Multimap<Boolean, IntBooleanPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, false)));
    }

    @Test
    public void groupByEach() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Function<IntBooleanPair, MutableList<Boolean>> function = (IntBooleanPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1, false).equals(object));
        Multimap<Boolean, IntBooleanPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, false)));
    }

    @Test
    public void zip() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true);
        RichIterable<Pair<IntBooleanPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, false), 1), Tuples.pair(PrimitiveTuples.pair(2, true), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, true), 1), Tuples.pair(PrimitiveTuples.pair(1, false), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true);
        RichIterable<Pair<IntBooleanPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, false), 0), Tuples.pair(PrimitiveTuples.pair(2, true), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, true), 0), Tuples.pair(PrimitiveTuples.pair(1, false), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1, false)), FastList.newListWith(PrimitiveTuples.pair(2, true)), FastList.newListWith(PrimitiveTuples.pair(3, false))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        Verify.assertIterableSize(3, collection.chunk(10).getFirst());
    }

    @Test
    public void empty() {
        Verify.assertIterableEmpty(this.newWith());
        Assert.assertTrue(this.newWith().isEmpty());
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Test
    public void notEmpty() {
        RichIterable<IntBooleanPair> notEmpty = this.newWith(1, false);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, IntBooleanPair> sumAggregator = (AtomicInteger aggregate, IntBooleanPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 2, true, 3, false);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:false").intValue());
        Assert.assertEquals(2, aggregation.get("2:true").intValue());
        Assert.assertEquals(1, aggregation.get("1:false").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, IntBooleanPair, Integer> sumAggregator = (Integer aggregate, IntBooleanPair value) -> (int) (aggregate + value.getOne());
        RichIterable<IntBooleanPair> collection = this.newWith(1, false, 1, false, 2, true);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:true").intValue());
        Assert.assertEquals(1, aggregation.get("1:false").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractIntBooleanMapKeyValuesViewTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
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
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
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
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractIntBooleanMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntBooleanMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractIntBooleanMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractIntBooleanMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractIntBooleanMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractIntBooleanMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractIntBooleanMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractIntBooleanMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractIntBooleanMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractIntBooleanMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractIntBooleanMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractIntBooleanMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractIntBooleanMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractIntBooleanMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractIntBooleanMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractIntBooleanMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractIntBooleanMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractIntBooleanMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractIntBooleanMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractIntBooleanMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractIntBooleanMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractIntBooleanMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractIntBooleanMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractIntBooleanMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractIntBooleanMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntBooleanMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntBooleanMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractIntBooleanMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractIntBooleanMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractIntBooleanMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractIntBooleanMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractIntBooleanMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractIntBooleanMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractIntBooleanMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractIntBooleanMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractIntBooleanMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractIntBooleanMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractIntBooleanMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractIntBooleanMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractIntBooleanMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractIntBooleanMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractIntBooleanMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractIntBooleanMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractIntBooleanMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractIntBooleanMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractIntBooleanMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractIntBooleanMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractIntBooleanMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractIntBooleanMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntBooleanMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntBooleanMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractIntBooleanMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractIntBooleanMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractIntBooleanMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractIntBooleanMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractIntBooleanMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractIntBooleanMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractIntBooleanMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractIntBooleanMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractIntBooleanMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractIntBooleanMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractIntBooleanMapKeyValuesViewTestCase::partition;
            this.payloads.partitionWith = AbstractIntBooleanMapKeyValuesViewTestCase::partitionWith;
            this.payloads.toList = AbstractIntBooleanMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractIntBooleanMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractIntBooleanMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractIntBooleanMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractIntBooleanMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractIntBooleanMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractIntBooleanMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractIntBooleanMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractIntBooleanMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractIntBooleanMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractIntBooleanMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractIntBooleanMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractIntBooleanMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractIntBooleanMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractIntBooleanMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractIntBooleanMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractIntBooleanMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractIntBooleanMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntBooleanMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractIntBooleanMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractIntBooleanMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractIntBooleanMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractIntBooleanMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractIntBooleanMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
