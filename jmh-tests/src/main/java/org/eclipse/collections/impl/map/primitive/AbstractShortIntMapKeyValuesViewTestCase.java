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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ShortIntMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
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
 * Abstract JUnit test for {@link ShortIntMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractShortIntMapKeyValuesViewTestCase {

    public abstract ShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3);

    public abstract ShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2);

    public abstract ShortIntMap newWithKeysValues(short key1, int value1);

    public abstract ShortIntMap newEmpty();

    public RichIterable<ShortIntPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ShortIntPair> newWith(short key1, int value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ShortIntPair> newWith(short key1, int value1, short key2, int value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ShortIntPair> newWith(short key1, int value1, short key2, int value2, short key3, int value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 1, 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 1, 5)));
    }

    @Test
    public void forEach() {
        MutableList<ShortIntPair> result = Lists.mutable.of();
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4));
        MutableList<ShortIntPair> result2 = Lists.mutable.of();
        RichIterable<ShortIntPair> collection2 = this.newWith((short) 0, 2, (short) 2, 3, (short) 3, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((short) 0, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<ShortIntPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 0, (short) 2, 3, (short) 3, 4);
        collection.forEachWith((ShortIntPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 0), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ShortIntPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ShortIntPair> collection2 = this.newWith((short) 2, 5, (short) 6, 3, (short) 3, 4);
        collection2.forEachWith((ShortIntPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 2, 5), PrimitiveTuples.pair((short) 6, 3), PrimitiveTuples.pair((short) 3, 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ShortIntPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ShortIntPair> collection = this.newWith((short) 2, 2, (short) 6, 3, (short) 3, 4);
        collection.forEachWithIndex((ShortIntPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 2, 2), PrimitiveTuples.pair((short) 6, 3), PrimitiveTuples.pair((short) 3, 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ShortIntPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ShortIntPair> collection2 = this.newWith((short) 0, 1, (short) 2, 3, (short) 3, 4);
        collection2.forEachWithIndex((ShortIntPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 0, 1), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).select(PrimitiveTuples.pair((short) 2, 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).selectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, 3), HashBag.<ShortIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 3, 4)), result);
    }

    @Test
    public void reject() {
        MutableList<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).reject(Predicates.notEqual(PrimitiveTuples.pair((short) 2, 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).rejectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3), HashBag.<ShortIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 3, 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ShortIntPair.class), PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 3, 4), PrimitiveTuples.pair((short) 2, 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collect((ShortIntPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collect((ShortIntPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectBoolean((ShortIntPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectByte((ShortIntPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectChar((ShortIntPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectDouble((ShortIntPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectFloat((ShortIntPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectInt((ShortIntPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectLong((ShortIntPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectShort((ShortIntPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortIntPair, MutableList<String>> function = (ShortIntPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detect(PrimitiveTuples.pair((short) 2, 3)::equals));
        Assert.assertNull(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detect(PrimitiveTuples.pair((short) 2, 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, 4), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, 4), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).minBy((ShortIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2), this.newWith((short) 1, 2, (short) 2, 3, (short) 4, 5).maxBy((ShortIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)));
        Assert.assertNull(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<ShortIntPair> function = Functions0.value(PrimitiveTuples.pair((short) 5, 6));
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectIfNone(PrimitiveTuples.pair((short) 2, 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((short) 5, 6), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ShortIntPair> function = Functions0.value(PrimitiveTuples.pair((short) 5, 6));
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((short) 2, 3), function));
        Assert.assertEquals(PrimitiveTuples.pair((short) 5, 6), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfy(ShortIntPair.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfy(PrimitiveTuples.pair((short) 2, 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfyWith(Predicates2.instanceOf(), ShortIntPair.class));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfy(PrimitiveTuples.pair((short) 2, 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfy(PrimitiveTuples.pair((short) 2, 3)::equals));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfy(PrimitiveTuples.pair((short) 2, 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(ShortIntPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(PrimitiveTuples.pair((short) 2, 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Predicates2.instanceOf(), ShortIntPair.class));
        Assert.assertEquals(1, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Object::equals, PrimitiveTuples.pair((short) 2, 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectIf(ShortIntPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectIf(ShortIntPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectWith((ShortIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectWith((ShortIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ShortIntPair first = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, 2).equals(first) || PrimitiveTuples.pair((short) 2, 3).equals(first) || PrimitiveTuples.pair((short) 3, 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2), this.newWith((short) 1, 2).getFirst());
    }

    @Test
    public void getLast() {
        ShortIntPair last = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, 2).equals(last) || PrimitiveTuples.pair((short) 2, 3).equals(last) || PrimitiveTuples.pair((short) 3, 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2), this.newWith((short) 1, 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((short) 1, 2));
        Assert.assertTrue(this.newWith((short) 1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 0, 3, (short) 3, 4);
        MutableBag<ShortIntPair> actual = Bags.mutable.of();
        Iterator<ShortIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 2, 3, (short) 4, 3, (short) 3, 4);
        MutableBag<ShortIntPair> actual = Bags.mutable.of();
        Iterator<ShortIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Iterator<ShortIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Iterator<ShortIntPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Long result = objects.injectInto(1L, (Long argument1, ShortIntPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        int result = objects.injectInto(1, (int intParameter, ShortIntPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long result = objects.injectInto(1L, (long parameter, ShortIntPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double result = objects.injectInto(1.0, (double parameter, ShortIntPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        float result = objects.injectInto(1.0f, (float parameter, ShortIntPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double actual = objects.sumOfFloat((ShortIntPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double actual = objects.sumOfDouble((ShortIntPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long actual = objects.sumOfInt((ShortIntPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long actual = objects.sumOfLong((ShortIntPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ShortIntPair> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ShortIntPair[] array2 = objects.toArray(new ShortIntPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ShortIntPair> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).partition(PrimitiveTuples.pair((short) 2, 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((short) 1, 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((short) 3, 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ShortIntPair> list = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4));
    }

    @Test
    public void toBag() {
        MutableBag<ShortIntPair> bag = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortIntPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortIntPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 3, 4), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 1, 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortIntPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortIntPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortIntPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((short) 3, 4), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 1, 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortIntPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortIntPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortIntPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((short) 3, 4), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 1, 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortIntPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSet<ShortIntPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((short) 1, 2), PrimitiveTuples.pair((short) 2, 3), PrimitiveTuples.pair((short) 3, 4));
    }

    @Test
    public void toMap() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ShortIntPair> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortIntPair, Boolean> function = (ShortIntPair object) -> PrimitiveTuples.pair((short) 1, 2).equals(object);
        Multimap<Boolean, ShortIntPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortIntPair, MutableList<Boolean>> function = (ShortIntPair object) -> Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2).equals(object));
        Multimap<Boolean, ShortIntPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, 4)));
    }

    @Test
    public void zip() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3);
        RichIterable<Pair<ShortIntPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, 2), 1), Tuples.pair(PrimitiveTuples.pair((short) 2, 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, 3), 1), Tuples.pair(PrimitiveTuples.pair((short) 1, 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3);
        RichIterable<Pair<ShortIntPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, 2), 0), Tuples.pair(PrimitiveTuples.pair((short) 2, 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, 3), 0), Tuples.pair(PrimitiveTuples.pair((short) 1, 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2)), FastList.newListWith(PrimitiveTuples.pair((short) 2, 3)), FastList.newListWith(PrimitiveTuples.pair((short) 3, 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
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
        RichIterable<ShortIntPair> notEmpty = this.newWith((short) 1, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ShortIntPair> sumAggregator = (AtomicInteger aggregate, ShortIntPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ShortIntPair, Integer> sumAggregator = (Integer aggregate, ShortIntPair value) -> (int) (aggregate + value.getOne());
        RichIterable<ShortIntPair> collection = this.newWith((short) 1, 1, (short) 1, 2, (short) 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortIntMapKeyValuesViewTestCase instance;

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
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortIntMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractShortIntMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractShortIntMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractShortIntMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractShortIntMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractShortIntMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractShortIntMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractShortIntMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractShortIntMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractShortIntMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractShortIntMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractShortIntMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractShortIntMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractShortIntMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractShortIntMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractShortIntMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractShortIntMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractShortIntMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractShortIntMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractShortIntMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractShortIntMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractShortIntMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractShortIntMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractShortIntMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractShortIntMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractShortIntMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractShortIntMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractShortIntMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractShortIntMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractShortIntMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractShortIntMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractShortIntMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractShortIntMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractShortIntMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractShortIntMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractShortIntMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractShortIntMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractShortIntMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractShortIntMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractShortIntMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractShortIntMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractShortIntMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractShortIntMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractShortIntMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractShortIntMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractShortIntMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractShortIntMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractShortIntMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractShortIntMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractShortIntMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractShortIntMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractShortIntMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractShortIntMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractShortIntMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractShortIntMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractShortIntMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractShortIntMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractShortIntMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractShortIntMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractShortIntMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractShortIntMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractShortIntMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractShortIntMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractShortIntMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractShortIntMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractShortIntMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractShortIntMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractShortIntMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractShortIntMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractShortIntMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractShortIntMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractShortIntMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractShortIntMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractShortIntMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractShortIntMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractShortIntMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractShortIntMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractShortIntMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractShortIntMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractShortIntMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractShortIntMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractShortIntMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractShortIntMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractShortIntMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractShortIntMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractShortIntMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractShortIntMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractShortIntMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractShortIntMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractShortIntMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractShortIntMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractShortIntMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractShortIntMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
