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
import org.eclipse.collections.api.map.primitive.ByteDoubleMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;
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
 * Abstract JUnit test for {@link ByteDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractByteDoubleMapKeyValuesViewTestCase {

    public abstract ByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3);

    public abstract ByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2);

    public abstract ByteDoubleMap newWithKeysValues(byte key1, double value1);

    public abstract ByteDoubleMap newEmpty();

    public RichIterable<ByteDoublePair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ByteDoublePair> newWith(byte key1, double value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ByteDoublePair> newWith(byte key1, double value1, byte key2, double value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ByteDoublePair> newWith(byte key1, double value1, byte key2, double value2, byte key3, double value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 1, 5.0))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 1, 5.0)));
    }

    @Test
    public void forEach() {
        MutableList<ByteDoublePair> result = Lists.mutable.of();
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0));
        MutableList<ByteDoublePair> result2 = Lists.mutable.of();
        RichIterable<ByteDoublePair> collection2 = this.newWith((byte) 0, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((byte) 0, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0));
    }

    @Test
    public void forEachWith() {
        MutableBag<ByteDoublePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 0.0, (byte) 2, 3.0, (byte) 3, 4.0);
        collection.forEachWith((ByteDoublePair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 0.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ByteDoublePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ByteDoublePair> collection2 = this.newWith((byte) 2, 5.0, (byte) 6, 3.0, (byte) 3, 4.0);
        collection2.forEachWith((ByteDoublePair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 2, 5.0), PrimitiveTuples.pair((byte) 6, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ByteDoublePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 2, 2.0, (byte) 6, 3.0, (byte) 3, 4.0);
        collection.forEachWithIndex((ByteDoublePair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 2, 2.0), PrimitiveTuples.pair((byte) 6, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ByteDoublePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ByteDoublePair> collection2 = this.newWith((byte) 0, 1.0, (byte) 2, 3.0, (byte) 3, 4.0);
        collection2.forEachWithIndex((ByteDoublePair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 0, 1.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).select(PrimitiveTuples.pair((byte) 2, 3.0)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4.0), result);
    }

    @Test
    public void selectWith() {
        MutableList<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).selectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4.0), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3.0), HashBag.<ByteDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 3, 4.0)), result);
    }

    @Test
    public void reject() {
        MutableList<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).reject(Predicates.notEqual(PrimitiveTuples.pair((byte) 2, 3.0))).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4.0), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4.0), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).rejectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0), HashBag.<ByteDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 3, 4.0)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ByteDoublePair.class), PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 3, 4.0), PrimitiveTuples.pair((byte) 2, 3.0));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collect((ByteDoublePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collect((ByteDoublePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectBoolean((ByteDoublePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectByte((ByteDoublePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectChar((ByteDoublePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectDouble((ByteDoublePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectFloat((ByteDoublePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectInt((ByteDoublePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectLong((ByteDoublePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectShort((ByteDoublePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Function<ByteDoublePair, MutableList<String>> function = (ByteDoublePair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2.0", "2:3.0", "3:4.0"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2.0", "2:3.0", "3:4.0"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detect(PrimitiveTuples.pair((byte) 2, 3.0)::equals));
        Assert.assertNull(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detect(PrimitiveTuples.pair((byte) 2, 4.0)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).minBy((ByteDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 4, 5.0).maxBy((ByteDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)));
        Assert.assertNull(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<ByteDoublePair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectIfNone(PrimitiveTuples.pair((byte) 2, 3.0)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, 6.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ByteDoublePair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectWithIfNone(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0), function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, 6.0), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).allSatisfy(ByteDoublePair.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).allSatisfy(PrimitiveTuples.pair((byte) 2, 3.0)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).allSatisfyWith(Predicates2.instanceOf(), ByteDoublePair.class));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).allSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).noneSatisfy(PrimitiveTuples.pair((byte) 2, 3.0)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).anySatisfy(PrimitiveTuples.pair((byte) 2, 3.0)::equals));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).anySatisfy(PrimitiveTuples.pair((byte) 2, 5.0)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)));
        Assert.assertFalse(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 5.0)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).count(ByteDoublePair.class::isInstance));
        Assert.assertEquals(1, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).count(PrimitiveTuples.pair((byte) 2, 3.0)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).countWith(Predicates2.instanceOf(), ByteDoublePair.class));
        Assert.assertEquals(1, this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).countWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3.0)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectIf(ByteDoublePair.class::isInstance, String::valueOf), "1:2.0", "2:3.0", "3:4.0");
        Verify.assertContainsAll(this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectIf(ByteDoublePair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2.0", "2:3.0", "3:4.0");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectWith((ByteDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).collectWith((ByteDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ByteDoublePair first = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2.0).equals(first) || PrimitiveTuples.pair((byte) 2, 3.0).equals(first) || PrimitiveTuples.pair((byte) 3, 4.0).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2.0), this.newWith((byte) 1, 2.0).getFirst());
    }

    @Test
    public void getLast() {
        ByteDoublePair last = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2.0).equals(last) || PrimitiveTuples.pair((byte) 2, 3.0).equals(last) || PrimitiveTuples.pair((byte) 3, 4.0).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2.0), this.newWith((byte) 1, 2.0).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((byte) 1, 2.0));
        Assert.assertTrue(this.newWith((byte) 1, 2.0).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 0, 3.0, (byte) 3, 4.0);
        MutableBag<ByteDoublePair> actual = Bags.mutable.of();
        Iterator<ByteDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 2, 3.0, (byte) 4, 3.0, (byte) 3, 4.0);
        MutableBag<ByteDoublePair> actual = Bags.mutable.of();
        Iterator<ByteDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Iterator<ByteDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Iterator<ByteDoublePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Long result = objects.injectInto(1L, (Long argument1, ByteDoublePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        int result = objects.injectInto(1, (int intParameter, ByteDoublePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        long result = objects.injectInto(1L, (long parameter, ByteDoublePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        double result = objects.injectInto(1.0, (double parameter, ByteDoublePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        float result = objects.injectInto(1.0f, (float parameter, ByteDoublePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        double actual = objects.sumOfFloat((ByteDoublePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        double actual = objects.sumOfDouble((ByteDoublePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        long actual = objects.sumOfInt((ByteDoublePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        long actual = objects.sumOfLong((ByteDoublePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ByteDoublePair> objects = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ByteDoublePair[] array2 = objects.toArray(new ByteDoublePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ByteDoublePair> result = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).partition(PrimitiveTuples.pair((byte) 2, 3.0)::equals);
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3.0), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((byte) 1, 2.0), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((byte) 3, 4.0), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ByteDoublePair> list = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0));
    }

    @Test
    public void toBag() {
        MutableBag<ByteDoublePair> bag = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableList<ByteDoublePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableList<ByteDoublePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 3, 4.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 1, 2.0)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableList<ByteDoublePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedBag<ByteDoublePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedBag<ByteDoublePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, 4.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 1, 2.0)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedBag<ByteDoublePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedSet<ByteDoublePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedSet<ByteDoublePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, 4.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 1, 2.0)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 2, 3.0, (byte) 1, 2.0, (byte) 3, 4.0);
        MutableSortedSet<ByteDoublePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MutableSet<ByteDoublePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((byte) 1, 2.0), PrimitiveTuples.pair((byte) 2, 3.0), PrimitiveTuples.pair((byte) 3, 4.0));
    }

    @Test
    public void toMap() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ByteDoublePair> pairs = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0);
        Assert.assertTrue("[1:2.0, 2:3.0]".equals(collection.toString()) || "[2:3.0, 1:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Function<ByteDoublePair, Boolean> function = (ByteDoublePair object) -> PrimitiveTuples.pair((byte) 1, 2.0).equals(object);
        Multimap<Boolean, ByteDoublePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4.0)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Function<ByteDoublePair, MutableList<Boolean>> function = (ByteDoublePair object) -> Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2.0).equals(object));
        Multimap<Boolean, ByteDoublePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4.0)));
    }

    @Test
    public void zip() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0);
        RichIterable<Pair<ByteDoublePair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2.0), 1), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3.0), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3.0), 1), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2.0), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0);
        RichIterable<Pair<ByteDoublePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2.0), 0), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3.0), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3.0), 0), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2.0), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2.0)), FastList.newListWith(PrimitiveTuples.pair((byte) 2, 3.0)), FastList.newListWith(PrimitiveTuples.pair((byte) 3, 4.0))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
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
        RichIterable<ByteDoublePair> notEmpty = this.newWith((byte) 1, 2.0);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ByteDoublePair> sumAggregator = (AtomicInteger aggregate, ByteDoublePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ByteDoublePair, Integer> sumAggregator = (Integer aggregate, ByteDoublePair value) -> (int) (aggregate + value.getOne());
        RichIterable<ByteDoublePair> collection = this.newWith((byte) 1, 1.0, (byte) 1, 2.0, (byte) 2, 3.0);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteDoubleMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteDoubleMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractByteDoubleMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractByteDoubleMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractByteDoubleMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractByteDoubleMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractByteDoubleMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractByteDoubleMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractByteDoubleMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractByteDoubleMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractByteDoubleMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractByteDoubleMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractByteDoubleMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractByteDoubleMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractByteDoubleMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractByteDoubleMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractByteDoubleMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractByteDoubleMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractByteDoubleMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractByteDoubleMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractByteDoubleMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractByteDoubleMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractByteDoubleMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractByteDoubleMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractByteDoubleMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteDoubleMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractByteDoubleMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractByteDoubleMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractByteDoubleMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractByteDoubleMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractByteDoubleMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractByteDoubleMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractByteDoubleMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractByteDoubleMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractByteDoubleMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractByteDoubleMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractByteDoubleMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractByteDoubleMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractByteDoubleMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractByteDoubleMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractByteDoubleMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractByteDoubleMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractByteDoubleMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractByteDoubleMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractByteDoubleMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractByteDoubleMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractByteDoubleMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractByteDoubleMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractByteDoubleMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractByteDoubleMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractByteDoubleMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteDoubleMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractByteDoubleMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractByteDoubleMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractByteDoubleMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractByteDoubleMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractByteDoubleMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractByteDoubleMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractByteDoubleMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractByteDoubleMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractByteDoubleMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractByteDoubleMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractByteDoubleMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractByteDoubleMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractByteDoubleMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractByteDoubleMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractByteDoubleMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractByteDoubleMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractByteDoubleMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractByteDoubleMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractByteDoubleMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractByteDoubleMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractByteDoubleMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractByteDoubleMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractByteDoubleMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractByteDoubleMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractByteDoubleMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractByteDoubleMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractByteDoubleMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractByteDoubleMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractByteDoubleMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
