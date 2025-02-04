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
import org.eclipse.collections.api.map.primitive.ByteShortMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ByteShortPair;
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
 * Abstract JUnit test for {@link ByteShortMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractByteShortMapKeyValuesViewTestCase {

    public abstract ByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3);

    public abstract ByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2);

    public abstract ByteShortMap newWithKeysValues(byte key1, short value1);

    public abstract ByteShortMap newEmpty();

    public RichIterable<ByteShortPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ByteShortPair> newWith(byte key1, short value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ByteShortPair> newWith(byte key1, short value1, byte key2, short value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ByteShortPair> newWith(byte key1, short value1, byte key2, short value2, byte key3, short value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 1, (short) 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 1, (short) 5)));
    }

    @Test
    public void forEach() {
        MutableList<ByteShortPair> result = Lists.mutable.of();
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4));
        MutableList<ByteShortPair> result2 = Lists.mutable.of();
        RichIterable<ByteShortPair> collection2 = this.newWith((byte) 0, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((byte) 0, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<ByteShortPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 0, (byte) 2, (short) 3, (byte) 3, (short) 4);
        collection.forEachWith((ByteShortPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (short) 0), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ByteShortPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ByteShortPair> collection2 = this.newWith((byte) 2, (short) 5, (byte) 6, (short) 3, (byte) 3, (short) 4);
        collection2.forEachWith((ByteShortPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 2, (short) 5), PrimitiveTuples.pair((byte) 6, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ByteShortPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ByteShortPair> collection = this.newWith((byte) 2, (short) 2, (byte) 6, (short) 3, (byte) 3, (short) 4);
        collection.forEachWithIndex((ByteShortPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 2, (short) 2), PrimitiveTuples.pair((byte) 6, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ByteShortPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ByteShortPair> collection2 = this.newWith((byte) 0, (short) 1, (byte) 2, (short) 3, (byte) 3, (short) 4);
        collection2.forEachWithIndex((ByteShortPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 0, (short) 1), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).select(PrimitiveTuples.pair((byte) 2, (short) 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (short) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).selectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (short) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, (short) 3), HashBag.<ByteShortPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 3, (short) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).reject(Predicates.notEqual(PrimitiveTuples.pair((byte) 2, (short) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (short) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, (short) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (short) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).rejectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3), HashBag.<ByteShortPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 3, (short) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ByteShortPair.class), PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 3, (short) 4), PrimitiveTuples.pair((byte) 2, (short) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collect((ByteShortPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collect((ByteShortPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectBoolean((ByteShortPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectByte((ByteShortPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectChar((ByteShortPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectDouble((ByteShortPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectFloat((ByteShortPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectInt((ByteShortPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectLong((ByteShortPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectShort((ByteShortPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Function<ByteShortPair, MutableList<String>> function = (ByteShortPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (short) 3), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detect(PrimitiveTuples.pair((byte) 2, (short) 3)::equals));
        Assert.assertNull(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detect(PrimitiveTuples.pair((byte) 2, (short) 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (short) 2), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, (short) 4), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (short) 2), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, (short) 4), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (short) 3), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).minBy((ByteShortPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (short) 2), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 4, (short) 5).maxBy((ByteShortPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (short) 3), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)));
        Assert.assertNull(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<ByteShortPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, (short) 6));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (short) 3), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectIfNone(PrimitiveTuples.pair((byte) 2, (short) 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, (short) 6), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ByteShortPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, (short) 6));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (short) 3), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, (short) 6), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).allSatisfy(ByteShortPair.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).allSatisfy(PrimitiveTuples.pair((byte) 2, (short) 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).allSatisfyWith(Predicates2.instanceOf(), ByteShortPair.class));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).noneSatisfy(PrimitiveTuples.pair((byte) 2, (short) 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).anySatisfy(PrimitiveTuples.pair((byte) 2, (short) 3)::equals));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).anySatisfy(PrimitiveTuples.pair((byte) 2, (short) 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)));
        Assert.assertFalse(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).count(ByteShortPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).count(PrimitiveTuples.pair((byte) 2, (short) 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).countWith(Predicates2.instanceOf(), ByteShortPair.class));
        Assert.assertEquals(1, this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).countWith(Object::equals, PrimitiveTuples.pair((byte) 2, (short) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectIf(ByteShortPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectIf(ByteShortPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectWith((ByteShortPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).collectWith((ByteShortPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ByteShortPair first = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, (short) 2).equals(first) || PrimitiveTuples.pair((byte) 2, (short) 3).equals(first) || PrimitiveTuples.pair((byte) 3, (short) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (short) 2), this.newWith((byte) 1, (short) 2).getFirst());
    }

    @Test
    public void getLast() {
        ByteShortPair last = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, (short) 2).equals(last) || PrimitiveTuples.pair((byte) 2, (short) 3).equals(last) || PrimitiveTuples.pair((byte) 3, (short) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (short) 2), this.newWith((byte) 1, (short) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((byte) 1, (short) 2));
        Assert.assertTrue(this.newWith((byte) 1, (short) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 0, (short) 3, (byte) 3, (short) 4);
        MutableBag<ByteShortPair> actual = Bags.mutable.of();
        Iterator<ByteShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 2, (short) 3, (byte) 4, (short) 3, (byte) 3, (short) 4);
        MutableBag<ByteShortPair> actual = Bags.mutable.of();
        Iterator<ByteShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Iterator<ByteShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Iterator<ByteShortPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Long result = objects.injectInto(1L, (Long argument1, ByteShortPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        int result = objects.injectInto(1, (int intParameter, ByteShortPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        long result = objects.injectInto(1L, (long parameter, ByteShortPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        double result = objects.injectInto(1.0, (double parameter, ByteShortPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        float result = objects.injectInto(1.0f, (float parameter, ByteShortPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        double actual = objects.sumOfFloat((ByteShortPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        double actual = objects.sumOfDouble((ByteShortPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        long actual = objects.sumOfInt((ByteShortPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        long actual = objects.sumOfLong((ByteShortPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ByteShortPair> objects = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ByteShortPair[] array2 = objects.toArray(new ByteShortPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ByteShortPair> result = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).partition(PrimitiveTuples.pair((byte) 2, (short) 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (short) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((byte) 1, (short) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((byte) 3, (short) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ByteShortPair> list = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4));
    }

    @Test
    public void toBag() {
        MutableBag<ByteShortPair> bag = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableList<ByteShortPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableList<ByteShortPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 3, (short) 4), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 1, (short) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableList<ByteShortPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedBag<ByteShortPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedBag<ByteShortPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, (short) 4), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 1, (short) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedBag<ByteShortPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedSet<ByteShortPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedSet<ByteShortPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, (short) 4), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 1, (short) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 2, (short) 3, (byte) 1, (short) 2, (byte) 3, (short) 4);
        MutableSortedSet<ByteShortPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MutableSet<ByteShortPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((byte) 1, (short) 2), PrimitiveTuples.pair((byte) 2, (short) 3), PrimitiveTuples.pair((byte) 3, (short) 4));
    }

    @Test
    public void toMap() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ByteShortPair> pairs = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Function<ByteShortPair, Boolean> function = (ByteShortPair object) -> PrimitiveTuples.pair((byte) 1, (short) 2).equals(object);
        Multimap<Boolean, ByteShortPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, (short) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, (short) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, (short) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Function<ByteShortPair, MutableList<Boolean>> function = (ByteShortPair object) -> Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (short) 2).equals(object));
        Multimap<Boolean, ByteShortPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, (short) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, (short) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, (short) 4)));
    }

    @Test
    public void zip() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3);
        RichIterable<Pair<ByteShortPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, (short) 2), 1), Tuples.pair(PrimitiveTuples.pair((byte) 2, (short) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, (short) 3), 1), Tuples.pair(PrimitiveTuples.pair((byte) 1, (short) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3);
        RichIterable<Pair<ByteShortPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, (short) 2), 0), Tuples.pair(PrimitiveTuples.pair((byte) 2, (short) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, (short) 3), 0), Tuples.pair(PrimitiveTuples.pair((byte) 1, (short) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (short) 2)), FastList.newListWith(PrimitiveTuples.pair((byte) 2, (short) 3)), FastList.newListWith(PrimitiveTuples.pair((byte) 3, (short) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
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
        RichIterable<ByteShortPair> notEmpty = this.newWith((byte) 1, (short) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ByteShortPair> sumAggregator = (AtomicInteger aggregate, ByteShortPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ByteShortPair, Integer> sumAggregator = (Integer aggregate, ByteShortPair value) -> (int) (aggregate + value.getOne());
        RichIterable<ByteShortPair> collection = this.newWith((byte) 1, (short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteShortMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteShortMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteShortMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractByteShortMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractByteShortMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractByteShortMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractByteShortMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractByteShortMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractByteShortMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractByteShortMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractByteShortMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractByteShortMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractByteShortMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractByteShortMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractByteShortMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractByteShortMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractByteShortMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractByteShortMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractByteShortMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractByteShortMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractByteShortMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractByteShortMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractByteShortMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractByteShortMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractByteShortMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractByteShortMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteShortMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteShortMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteShortMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractByteShortMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractByteShortMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractByteShortMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractByteShortMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractByteShortMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractByteShortMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractByteShortMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractByteShortMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractByteShortMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractByteShortMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractByteShortMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractByteShortMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractByteShortMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractByteShortMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractByteShortMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractByteShortMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractByteShortMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractByteShortMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractByteShortMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractByteShortMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractByteShortMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractByteShortMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractByteShortMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractByteShortMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteShortMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteShortMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractByteShortMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractByteShortMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractByteShortMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteShortMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractByteShortMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractByteShortMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractByteShortMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractByteShortMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractByteShortMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractByteShortMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractByteShortMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractByteShortMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractByteShortMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractByteShortMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractByteShortMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractByteShortMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractByteShortMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractByteShortMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractByteShortMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractByteShortMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractByteShortMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractByteShortMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractByteShortMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractByteShortMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractByteShortMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractByteShortMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractByteShortMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractByteShortMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractByteShortMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractByteShortMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractByteShortMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractByteShortMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractByteShortMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractByteShortMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractByteShortMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractByteShortMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractByteShortMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractByteShortMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractByteShortMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteShortMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractByteShortMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractByteShortMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractByteShortMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractByteShortMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractByteShortMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
