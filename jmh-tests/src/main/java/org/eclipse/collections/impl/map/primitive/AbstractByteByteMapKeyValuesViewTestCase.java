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
import org.eclipse.collections.api.map.primitive.ByteByteMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
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
 * Abstract JUnit test for {@link ByteByteMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractByteByteMapKeyValuesViewTestCase {

    public abstract ByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3);

    public abstract ByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2);

    public abstract ByteByteMap newWithKeysValues(byte key1, byte value1);

    public abstract ByteByteMap newEmpty();

    public RichIterable<ByteBytePair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ByteBytePair> newWith(byte key1, byte value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ByteBytePair> newWith(byte key1, byte value1, byte key2, byte value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ByteBytePair> newWith(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 1, (byte) 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 1, (byte) 5)));
    }

    @Test
    public void forEach() {
        MutableList<ByteBytePair> result = Lists.mutable.of();
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4));
        MutableList<ByteBytePair> result2 = Lists.mutable.of();
        RichIterable<ByteBytePair> collection2 = this.newWith((byte) 0, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((byte) 0, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<ByteBytePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 0, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        collection.forEachWith((ByteBytePair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (byte) 0), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ByteBytePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ByteBytePair> collection2 = this.newWith((byte) 2, (byte) 5, (byte) 6, (byte) 3, (byte) 3, (byte) 4);
        collection2.forEachWith((ByteBytePair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 2, (byte) 5), PrimitiveTuples.pair((byte) 6, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ByteBytePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ByteBytePair> collection = this.newWith((byte) 2, (byte) 2, (byte) 6, (byte) 3, (byte) 3, (byte) 4);
        collection.forEachWithIndex((ByteBytePair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 6, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ByteBytePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ByteBytePair> collection2 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        collection2.forEachWithIndex((ByteBytePair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 0, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).select(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (byte) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).selectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (byte) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, (byte) 3), HashBag.<ByteBytePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).reject(Predicates.notEqual(PrimitiveTuples.pair((byte) 2, (byte) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (byte) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, (byte) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, (byte) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).rejectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3), HashBag.<ByteBytePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ByteBytePair.class), PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collect((ByteBytePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collect((ByteBytePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectBoolean((ByteBytePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectByte((ByteBytePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectChar((ByteBytePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectDouble((ByteBytePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectFloat((ByteBytePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectInt((ByteBytePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectLong((ByteBytePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectShort((ByteBytePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Function<ByteBytePair, MutableList<String>> function = (ByteBytePair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detect(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals));
        Assert.assertNull(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detect(PrimitiveTuples.pair((byte) 2, (byte) 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, (byte) 4), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, (byte) 4), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).minBy((ByteBytePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 4, (byte) 5).maxBy((ByteBytePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)));
        Assert.assertNull(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<ByteBytePair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, (byte) 6));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectIfNone(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, (byte) 6), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ByteBytePair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, (byte) 6));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, (byte) 6), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).allSatisfy(ByteBytePair.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).allSatisfy(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).allSatisfyWith(Predicates2.instanceOf(), ByteBytePair.class));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).noneSatisfy(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).anySatisfy(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).anySatisfy(PrimitiveTuples.pair((byte) 2, (byte) 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).count(ByteBytePair.class::isInstance));
        Assert.assertEquals(1, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).count(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).countWith(Predicates2.instanceOf(), ByteBytePair.class));
        Assert.assertEquals(1, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).countWith(Object::equals, PrimitiveTuples.pair((byte) 2, (byte) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectIf(ByteBytePair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectIf(ByteBytePair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectWith((ByteBytePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).collectWith((ByteBytePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ByteBytePair first = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, (byte) 2).equals(first) || PrimitiveTuples.pair((byte) 2, (byte) 3).equals(first) || PrimitiveTuples.pair((byte) 3, (byte) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2).getFirst());
    }

    @Test
    public void getLast() {
        ByteBytePair last = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, (byte) 2).equals(last) || PrimitiveTuples.pair((byte) 2, (byte) 3).equals(last) || PrimitiveTuples.pair((byte) 3, (byte) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((byte) 1, (byte) 2));
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 0, (byte) 3, (byte) 3, (byte) 4);
        MutableBag<ByteBytePair> actual = Bags.mutable.of();
        Iterator<ByteBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 2, (byte) 3, (byte) 4, (byte) 3, (byte) 3, (byte) 4);
        MutableBag<ByteBytePair> actual = Bags.mutable.of();
        Iterator<ByteBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Iterator<ByteBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Iterator<ByteBytePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Long result = objects.injectInto(1L, (Long argument1, ByteBytePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        int result = objects.injectInto(1, (int intParameter, ByteBytePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        long result = objects.injectInto(1L, (long parameter, ByteBytePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        double result = objects.injectInto(1.0, (double parameter, ByteBytePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        float result = objects.injectInto(1.0f, (float parameter, ByteBytePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        double actual = objects.sumOfFloat((ByteBytePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        double actual = objects.sumOfDouble((ByteBytePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        long actual = objects.sumOfInt((ByteBytePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        long actual = objects.sumOfLong((ByteBytePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ByteBytePair> objects = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ByteBytePair[] array2 = objects.toArray(new ByteBytePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ByteBytePair> result = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).partition(PrimitiveTuples.pair((byte) 2, (byte) 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, (byte) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((byte) 1, (byte) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((byte) 3, (byte) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ByteBytePair> list = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4));
    }

    @Test
    public void toBag() {
        MutableBag<ByteBytePair> bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableList<ByteBytePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableList<ByteBytePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 3, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 1, (byte) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableList<ByteBytePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedBag<ByteBytePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedBag<ByteBytePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 1, (byte) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedBag<ByteBytePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedSet<ByteBytePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedSet<ByteBytePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, (byte) 4), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 1, (byte) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 2, (byte) 3, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableSortedSet<ByteBytePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MutableSet<ByteBytePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 2, (byte) 3), PrimitiveTuples.pair((byte) 3, (byte) 4));
    }

    @Test
    public void toMap() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ByteBytePair> pairs = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Function<ByteBytePair, Boolean> function = (ByteBytePair object) -> PrimitiveTuples.pair((byte) 1, (byte) 2).equals(object);
        Multimap<Boolean, ByteBytePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, (byte) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, (byte) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, (byte) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Function<ByteBytePair, MutableList<Boolean>> function = (ByteBytePair object) -> Lists.mutable.of(PrimitiveTuples.pair((byte) 1, (byte) 2).equals(object));
        Multimap<Boolean, ByteBytePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, (byte) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, (byte) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, (byte) 4)));
    }

    @Test
    public void zip() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3);
        RichIterable<Pair<ByteBytePair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, (byte) 2), 1), Tuples.pair(PrimitiveTuples.pair((byte) 2, (byte) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, (byte) 3), 1), Tuples.pair(PrimitiveTuples.pair((byte) 1, (byte) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3);
        RichIterable<Pair<ByteBytePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, (byte) 2), 0), Tuples.pair(PrimitiveTuples.pair((byte) 2, (byte) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, (byte) 3), 0), Tuples.pair(PrimitiveTuples.pair((byte) 1, (byte) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((byte) 1, (byte) 2)), FastList.newListWith(PrimitiveTuples.pair((byte) 2, (byte) 3)), FastList.newListWith(PrimitiveTuples.pair((byte) 3, (byte) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
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
        RichIterable<ByteBytePair> notEmpty = this.newWith((byte) 1, (byte) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ByteBytePair> sumAggregator = (AtomicInteger aggregate, ByteBytePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ByteBytePair, Integer> sumAggregator = (Integer aggregate, ByteBytePair value) -> (int) (aggregate + value.getOne());
        RichIterable<ByteBytePair> collection = this.newWith((byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteByteMapKeyValuesViewTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
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
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
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
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteByteMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractByteByteMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractByteByteMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractByteByteMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractByteByteMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractByteByteMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractByteByteMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractByteByteMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractByteByteMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractByteByteMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractByteByteMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractByteByteMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractByteByteMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractByteByteMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractByteByteMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractByteByteMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractByteByteMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractByteByteMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractByteByteMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractByteByteMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractByteByteMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractByteByteMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractByteByteMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractByteByteMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteByteMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractByteByteMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractByteByteMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractByteByteMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractByteByteMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractByteByteMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractByteByteMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractByteByteMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractByteByteMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractByteByteMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractByteByteMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractByteByteMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractByteByteMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractByteByteMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractByteByteMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractByteByteMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractByteByteMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractByteByteMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractByteByteMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractByteByteMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractByteByteMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractByteByteMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractByteByteMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractByteByteMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractByteByteMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractByteByteMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractByteByteMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractByteByteMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteByteMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractByteByteMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractByteByteMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractByteByteMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractByteByteMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractByteByteMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractByteByteMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractByteByteMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractByteByteMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractByteByteMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractByteByteMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractByteByteMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractByteByteMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractByteByteMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractByteByteMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractByteByteMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractByteByteMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractByteByteMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractByteByteMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractByteByteMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractByteByteMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractByteByteMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractByteByteMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractByteByteMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractByteByteMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractByteByteMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractByteByteMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractByteByteMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractByteByteMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractByteByteMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractByteByteMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractByteByteMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractByteByteMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractByteByteMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractByteByteMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractByteByteMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractByteByteMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractByteByteMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractByteByteMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractByteByteMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractByteByteMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
