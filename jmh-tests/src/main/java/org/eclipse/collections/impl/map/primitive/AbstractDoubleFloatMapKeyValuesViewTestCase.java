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
import org.eclipse.collections.api.map.primitive.DoubleFloatMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.DoubleFloatPair;
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
 * Abstract JUnit test for {@link DoubleFloatMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractDoubleFloatMapKeyValuesViewTestCase {

    public abstract DoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3);

    public abstract DoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2);

    public abstract DoubleFloatMap newWithKeysValues(double key1, float value1);

    public abstract DoubleFloatMap newEmpty();

    public RichIterable<DoubleFloatPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<DoubleFloatPair> newWith(double key1, float value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<DoubleFloatPair> newWith(double key1, float value1, double key2, float value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<DoubleFloatPair> newWith(double key1, float value1, double key2, float value2, double key3, float value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(1.0, 5.0f))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(1.0, 5.0f)));
    }

    @Test
    public void forEach() {
        MutableList<DoubleFloatPair> result = Lists.mutable.of();
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f));
        MutableList<DoubleFloatPair> result2 = Lists.mutable.of();
        RichIterable<DoubleFloatPair> collection2 = this.newWith(0.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f));
    }

    @Test
    public void forEachWith() {
        MutableBag<DoubleFloatPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 0.0f, 2.0, 3.0f, 3.0, 4.0f);
        collection.forEachWith((DoubleFloatPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, 0.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<DoubleFloatPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<DoubleFloatPair> collection2 = this.newWith(2.0, 5.0f, 6.0, 3.0f, 3.0, 4.0f);
        collection2.forEachWith((DoubleFloatPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2.0, 5.0f), PrimitiveTuples.pair(6.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<DoubleFloatPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<DoubleFloatPair> collection = this.newWith(2.0, 2.0f, 6.0, 3.0f, 3.0, 4.0f);
        collection.forEachWithIndex((DoubleFloatPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2.0, 2.0f), PrimitiveTuples.pair(6.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<DoubleFloatPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<DoubleFloatPair> collection2 = this.newWith(0.0, 1.0f, 2.0, 3.0f, 3.0, 4.0f);
        collection2.forEachWithIndex((DoubleFloatPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0.0, 1.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).select(PrimitiveTuples.pair(2.0, 3.0f)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, 4.0f), result);
    }

    @Test
    public void selectWith() {
        MutableList<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).selectWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, 4.0f), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, 3.0f), HashBag.<DoubleFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(3.0, 4.0f)), result);
    }

    @Test
    public void reject() {
        MutableList<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0, 3.0f))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, 4.0f), result);
    }

    @Test
    public void rejectWith() {
        MutableList<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, 4.0f), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).rejectWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f), HashBag.<DoubleFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(3.0, 4.0f)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(DoubleFloatPair.class), PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(3.0, 4.0f), PrimitiveTuples.pair(2.0, 3.0f));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collect((DoubleFloatPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collect((DoubleFloatPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectBoolean((DoubleFloatPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectByte((DoubleFloatPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectChar((DoubleFloatPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectDouble((DoubleFloatPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectFloat((DoubleFloatPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectInt((DoubleFloatPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectLong((DoubleFloatPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectShort((DoubleFloatPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Function<DoubleFloatPair, MutableList<String>> function = (DoubleFloatPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1.0:2.0", "2.0:3.0", "3.0:4.0"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1.0:2.0", "2.0:3.0", "3.0:4.0"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, 3.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detect(PrimitiveTuples.pair(2.0, 3.0f)::equals));
        Assert.assertNull(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detect(PrimitiveTuples.pair(2.0, 4.0f)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1.0, 2.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, 4.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, 2.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, 4.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, 3.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).minBy((DoubleFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, 2.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 4.0, 5.0f).maxBy((DoubleFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, 3.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)));
        Assert.assertNull(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<DoubleFloatPair> function = Functions0.value(PrimitiveTuples.pair(5.0, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, 3.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectIfNone(PrimitiveTuples.pair(2.0, 3.0f)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, 6.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<DoubleFloatPair> function = Functions0.value(PrimitiveTuples.pair(5.0, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, 3.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0, 3.0f), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, 6.0f), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).allSatisfy(DoubleFloatPair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).allSatisfy(PrimitiveTuples.pair(2.0, 3.0f)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).allSatisfyWith(Predicates2.instanceOf(), DoubleFloatPair.class));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).noneSatisfy(PrimitiveTuples.pair(2.0, 3.0f)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).anySatisfy(PrimitiveTuples.pair(2.0, 3.0f)::equals));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).anySatisfy(PrimitiveTuples.pair(2.0, 5.0f)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)));
        Assert.assertFalse(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, 5.0f)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).count(DoubleFloatPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).count(PrimitiveTuples.pair(2.0, 3.0f)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).countWith(Predicates2.instanceOf(), DoubleFloatPair.class));
        Assert.assertEquals(1, this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).countWith(Object::equals, PrimitiveTuples.pair(2.0, 3.0f)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectIf(DoubleFloatPair.class::isInstance, String::valueOf), "1.0:2.0", "2.0:3.0", "3.0:4.0");
        Verify.assertContainsAll(this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectIf(DoubleFloatPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1.0:2.0", "2.0:3.0", "3.0:4.0");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectWith((DoubleFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).collectWith((DoubleFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        DoubleFloatPair first = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, 2.0f).equals(first) || PrimitiveTuples.pair(2.0, 3.0f).equals(first) || PrimitiveTuples.pair(3.0, 4.0f).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, 2.0f), this.newWith(1.0, 2.0f).getFirst());
    }

    @Test
    public void getLast() {
        DoubleFloatPair last = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, 2.0f).equals(last) || PrimitiveTuples.pair(2.0, 3.0f).equals(last) || PrimitiveTuples.pair(3.0, 4.0f).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, 2.0f), this.newWith(1.0, 2.0f).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0, 2.0f));
        Assert.assertTrue(this.newWith(1.0, 2.0f).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 0.0, 3.0f, 3.0, 4.0f);
        MutableBag<DoubleFloatPair> actual = Bags.mutable.of();
        Iterator<DoubleFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<DoubleFloatPair> objects = this.newWith(2.0, 3.0f, 4.0, 3.0f, 3.0, 4.0f);
        MutableBag<DoubleFloatPair> actual = Bags.mutable.of();
        Iterator<DoubleFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Iterator<DoubleFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Iterator<DoubleFloatPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Long result = objects.injectInto(1L, (Long argument1, DoubleFloatPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        int result = objects.injectInto(1, (int intParameter, DoubleFloatPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        long result = objects.injectInto(1L, (long parameter, DoubleFloatPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        double result = objects.injectInto(1.0, (double parameter, DoubleFloatPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        float result = objects.injectInto(1.0f, (float parameter, DoubleFloatPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        double actual = objects.sumOfFloat((DoubleFloatPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        double actual = objects.sumOfDouble((DoubleFloatPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        long actual = objects.sumOfInt((DoubleFloatPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        long actual = objects.sumOfLong((DoubleFloatPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<DoubleFloatPair> objects = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        DoubleFloatPair[] array2 = objects.toArray(new DoubleFloatPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<DoubleFloatPair> result = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).partition(PrimitiveTuples.pair(2.0, 3.0f)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2.0, 3.0f), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0, 2.0f), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0, 4.0f), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<DoubleFloatPair> list = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f));
    }

    @Test
    public void toBag() {
        MutableBag<DoubleFloatPair> bag = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableList<DoubleFloatPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableList<DoubleFloatPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0, 4.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(1.0, 2.0f)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableList<DoubleFloatPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedBag<DoubleFloatPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedBag<DoubleFloatPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, 4.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(1.0, 2.0f)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedBag<DoubleFloatPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedSet<DoubleFloatPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedSet<DoubleFloatPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, 4.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(1.0, 2.0f)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(2.0, 3.0f, 1.0, 2.0f, 3.0, 4.0f);
        MutableSortedSet<DoubleFloatPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f)), set);
    }

    @Test
    public void toSet() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MutableSet<DoubleFloatPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0, 2.0f), PrimitiveTuples.pair(2.0, 3.0f), PrimitiveTuples.pair(3.0, 4.0f));
    }

    @Test
    public void toMap() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<DoubleFloatPair> pairs = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void testToString() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f);
        Assert.assertTrue("[1.0:2.0, 2.0:3.0]".equals(collection.toString()) || "[2.0:3.0, 1.0:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Function<DoubleFloatPair, Boolean> function = (DoubleFloatPair object) -> PrimitiveTuples.pair(1.0, 2.0f).equals(object);
        Multimap<Boolean, DoubleFloatPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, 4.0f)));
    }

    @Test
    public void groupByEach() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Function<DoubleFloatPair, MutableList<Boolean>> function = (DoubleFloatPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0, 2.0f).equals(object));
        Multimap<Boolean, DoubleFloatPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, 4.0f)));
    }

    @Test
    public void zip() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f);
        RichIterable<Pair<DoubleFloatPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, 2.0f), 1), Tuples.pair(PrimitiveTuples.pair(2.0, 3.0f), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, 3.0f), 1), Tuples.pair(PrimitiveTuples.pair(1.0, 2.0f), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f);
        RichIterable<Pair<DoubleFloatPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, 2.0f), 0), Tuples.pair(PrimitiveTuples.pair(2.0, 3.0f), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, 3.0f), 0), Tuples.pair(PrimitiveTuples.pair(1.0, 2.0f), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0, 2.0f)), FastList.newListWith(PrimitiveTuples.pair(2.0, 3.0f)), FastList.newListWith(PrimitiveTuples.pair(3.0, 4.0f))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
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
        RichIterable<DoubleFloatPair> notEmpty = this.newWith(1.0, 2.0f);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, DoubleFloatPair> sumAggregator = (AtomicInteger aggregate, DoubleFloatPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, DoubleFloatPair, Integer> sumAggregator = (Integer aggregate, DoubleFloatPair value) -> (int) (aggregate + value.getOne());
        RichIterable<DoubleFloatPair> collection = this.newWith(1.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2.0").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleFloatMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleFloatMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleFloatMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractDoubleFloatMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractDoubleFloatMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractDoubleFloatMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractDoubleFloatMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractDoubleFloatMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractDoubleFloatMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractDoubleFloatMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractDoubleFloatMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractDoubleFloatMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractDoubleFloatMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractDoubleFloatMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractDoubleFloatMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractDoubleFloatMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractDoubleFloatMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractDoubleFloatMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractDoubleFloatMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractDoubleFloatMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractDoubleFloatMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractDoubleFloatMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractDoubleFloatMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractDoubleFloatMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractDoubleFloatMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractDoubleFloatMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleFloatMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleFloatMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractDoubleFloatMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractDoubleFloatMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractDoubleFloatMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractDoubleFloatMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractDoubleFloatMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractDoubleFloatMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractDoubleFloatMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractDoubleFloatMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractDoubleFloatMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractDoubleFloatMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractDoubleFloatMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractDoubleFloatMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractDoubleFloatMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractDoubleFloatMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractDoubleFloatMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractDoubleFloatMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractDoubleFloatMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractDoubleFloatMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractDoubleFloatMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractDoubleFloatMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractDoubleFloatMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractDoubleFloatMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractDoubleFloatMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleFloatMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleFloatMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractDoubleFloatMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractDoubleFloatMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractDoubleFloatMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractDoubleFloatMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractDoubleFloatMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractDoubleFloatMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractDoubleFloatMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractDoubleFloatMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractDoubleFloatMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractDoubleFloatMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractDoubleFloatMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractDoubleFloatMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractDoubleFloatMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractDoubleFloatMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractDoubleFloatMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractDoubleFloatMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractDoubleFloatMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractDoubleFloatMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractDoubleFloatMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractDoubleFloatMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractDoubleFloatMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractDoubleFloatMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractDoubleFloatMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractDoubleFloatMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractDoubleFloatMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractDoubleFloatMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractDoubleFloatMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractDoubleFloatMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleFloatMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractDoubleFloatMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractDoubleFloatMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractDoubleFloatMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractDoubleFloatMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractDoubleFloatMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
