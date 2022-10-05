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
import org.eclipse.collections.api.map.primitive.CharLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;
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
 * Abstract JUnit test for {@link CharLongMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractCharLongMapKeyValuesViewTestCase {

    public abstract CharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3);

    public abstract CharLongMap newWithKeysValues(char key1, long value1, char key2, long value2);

    public abstract CharLongMap newWithKeysValues(char key1, long value1);

    public abstract CharLongMap newEmpty();

    public RichIterable<CharLongPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<CharLongPair> newWith(char key1, long value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<CharLongPair> newWith(char key1, long value1, char key2, long value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<CharLongPair> newWith(char key1, long value1, char key2, long value2, char key3, long value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 1, 5L))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<CharLongPair> result = Lists.mutable.of();
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L));
        MutableList<CharLongPair> result2 = Lists.mutable.of();
        RichIterable<CharLongPair> collection2 = this.newWith((char) 0, 2L, (char) 2, 3L, (char) 3, 4L);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((char) 0, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L));
    }

    @Test
    public void forEachWith() {
        MutableBag<CharLongPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 0L, (char) 2, 3L, (char) 3, 4L);
        collection.forEachWith((CharLongPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 0L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<CharLongPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<CharLongPair> collection2 = this.newWith((char) 2, 5L, (char) 6, 3L, (char) 3, 4L);
        collection2.forEachWith((CharLongPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 2, 5L), PrimitiveTuples.pair((char) 6, 3L), PrimitiveTuples.pair((char) 3, 4L)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<CharLongPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<CharLongPair> collection = this.newWith((char) 2, 2L, (char) 6, 3L, (char) 3, 4L);
        collection.forEachWithIndex((CharLongPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 2, 2L), PrimitiveTuples.pair((char) 6, 3L), PrimitiveTuples.pair((char) 3, 4L)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<CharLongPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<CharLongPair> collection2 = this.newWith((char) 0, 1L, (char) 2, 3L, (char) 3, 4L);
        collection2.forEachWithIndex((CharLongPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 0, 1L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).select(PrimitiveTuples.pair((char) 2, 3L)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4L), result);
    }

    @Test
    public void selectWith() {
        MutableList<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).selectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4L), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3L), HashBag.<CharLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 3, 4L)), result);
    }

    @Test
    public void reject() {
        MutableList<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).reject(Predicates.notEqual(PrimitiveTuples.pair((char) 2, 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4L), result);
    }

    @Test
    public void rejectWith() {
        MutableList<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4L), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).rejectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L), HashBag.<CharLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 3, 4L)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(CharLongPair.class), PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 3, 4L), PrimitiveTuples.pair((char) 2, 3L));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collect((CharLongPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collect((CharLongPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectBoolean((CharLongPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectByte((CharLongPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectChar((CharLongPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectDouble((CharLongPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectFloat((CharLongPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectInt((CharLongPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectLong((CharLongPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectShort((CharLongPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Function<CharLongPair, MutableList<String>> function = (CharLongPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("\u0001:2", "\u0002:3", "\u0003:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("\u0001:2", "\u0002:3", "\u0003:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detect(PrimitiveTuples.pair((char) 2, 3L)::equals));
        Assert.assertNull(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detect(PrimitiveTuples.pair((char) 2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).minBy((CharLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 4, 5L).maxBy((CharLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)));
        Assert.assertNull(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<CharLongPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6L));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectIfNone(PrimitiveTuples.pair((char) 2, 3L)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<CharLongPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6L));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, 3L), function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).allSatisfy(CharLongPair.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).allSatisfy(PrimitiveTuples.pair((char) 2, 3L)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).allSatisfyWith(Predicates2.instanceOf(), CharLongPair.class));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).allSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).noneSatisfy(PrimitiveTuples.pair((char) 2, 3L)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).anySatisfy(PrimitiveTuples.pair((char) 2, 3L)::equals));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).anySatisfy(PrimitiveTuples.pair((char) 2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)));
        Assert.assertFalse(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).count(CharLongPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).count(PrimitiveTuples.pair((char) 2, 3L)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).countWith(Predicates2.instanceOf(), CharLongPair.class));
        Assert.assertEquals(1, this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).countWith(Object::equals, PrimitiveTuples.pair((char) 2, 3L)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectIf(CharLongPair.class::isInstance, String::valueOf), "\u0001:2", "\u0002:3", "\u0003:4");
        Verify.assertContainsAll(this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectIf(CharLongPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "\u0001:2", "\u0002:3", "\u0003:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectWith((CharLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).collectWith((CharLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        CharLongPair first = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2L).equals(first) || PrimitiveTuples.pair((char) 2, 3L).equals(first) || PrimitiveTuples.pair((char) 3, 4L).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2L), this.newWith((char) 1, 2L).getFirst());
    }

    @Test
    public void getLast() {
        CharLongPair last = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2L).equals(last) || PrimitiveTuples.pair((char) 2, 3L).equals(last) || PrimitiveTuples.pair((char) 3, 4L).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2L), this.newWith((char) 1, 2L).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((char) 1, 2L));
        Assert.assertTrue(this.newWith((char) 1, 2L).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 0, 3L, (char) 3, 4L);
        MutableBag<CharLongPair> actual = Bags.mutable.of();
        Iterator<CharLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<CharLongPair> objects = this.newWith((char) 2, 3L, (char) 4, 3L, (char) 3, 4L);
        MutableBag<CharLongPair> actual = Bags.mutable.of();
        Iterator<CharLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Iterator<CharLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Iterator<CharLongPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Long result = objects.injectInto(1L, (Long argument1, CharLongPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        int result = objects.injectInto(1, (int intParameter, CharLongPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        long result = objects.injectInto(1L, (long parameter, CharLongPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        double result = objects.injectInto(1.0, (double parameter, CharLongPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        float result = objects.injectInto(1.0f, (float parameter, CharLongPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        double actual = objects.sumOfFloat((CharLongPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        double actual = objects.sumOfDouble((CharLongPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        long actual = objects.sumOfInt((CharLongPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        long actual = objects.sumOfLong((CharLongPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<CharLongPair> objects = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        CharLongPair[] array2 = objects.toArray(new CharLongPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<CharLongPair> result = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).partition(PrimitiveTuples.pair((char) 2, 3L)::equals);
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3L), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, 2L), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, 4L), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<CharLongPair> list = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L));
    }

    @Test
    public void toBag() {
        MutableBag<CharLongPair> bag = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableList<CharLongPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableList<CharLongPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 3, 4L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 1, 2L)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableList<CharLongPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedBag<CharLongPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedBag<CharLongPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 1, 2L)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedBag<CharLongPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedSet<CharLongPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedSet<CharLongPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 1, 2L)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 2, 3L, (char) 1, 2L, (char) 3, 4L);
        MutableSortedSet<CharLongPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L)), set);
    }

    @Test
    public void toSet() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MutableSet<CharLongPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((char) 1, 2L), PrimitiveTuples.pair((char) 2, 3L), PrimitiveTuples.pair((char) 3, 4L));
    }

    @Test
    public void toMap() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<CharLongPair> pairs = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L);
        Assert.assertTrue("[\u0001:2, \u0002:3]".equals(collection.toString()) || "[\u0002:3, \u0001:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Function<CharLongPair, Boolean> function = (CharLongPair object) -> PrimitiveTuples.pair((char) 1, 2L).equals(object);
        Multimap<Boolean, CharLongPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4L)));
    }

    @Test
    public void groupByEach() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Function<CharLongPair, MutableList<Boolean>> function = (CharLongPair object) -> Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2L).equals(object));
        Multimap<Boolean, CharLongPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4L)));
    }

    @Test
    public void zip() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L);
        RichIterable<Pair<CharLongPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2L), 1), Tuples.pair(PrimitiveTuples.pair((char) 2, 3L), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3L), 1), Tuples.pair(PrimitiveTuples.pair((char) 1, 2L), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L);
        RichIterable<Pair<CharLongPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2L), 0), Tuples.pair(PrimitiveTuples.pair((char) 2, 3L), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3L), 0), Tuples.pair(PrimitiveTuples.pair((char) 1, 2L), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2L)), FastList.newListWith(PrimitiveTuples.pair((char) 2, 3L)), FastList.newListWith(PrimitiveTuples.pair((char) 3, 4L))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
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
        RichIterable<CharLongPair> notEmpty = this.newWith((char) 1, 2L);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, CharLongPair> sumAggregator = (AtomicInteger aggregate, CharLongPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 2L, (char) 2, 3L, (char) 3, 4L);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("\u0003:4").intValue());
        Assert.assertEquals(2, aggregation.get("\u0002:3").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, CharLongPair, Integer> sumAggregator = (Integer aggregate, CharLongPair value) -> (int) (aggregate + value.getOne());
        RichIterable<CharLongPair> collection = this.newWith((char) 1, 1L, (char) 1, 2L, (char) 2, 3L);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("\u0002:3").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharLongMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharLongMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharLongMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractCharLongMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractCharLongMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractCharLongMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractCharLongMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCharLongMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractCharLongMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractCharLongMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCharLongMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractCharLongMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractCharLongMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCharLongMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCharLongMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCharLongMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractCharLongMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractCharLongMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractCharLongMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractCharLongMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractCharLongMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractCharLongMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractCharLongMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractCharLongMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractCharLongMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractCharLongMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharLongMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharLongMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharLongMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractCharLongMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractCharLongMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCharLongMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractCharLongMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractCharLongMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractCharLongMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractCharLongMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCharLongMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCharLongMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCharLongMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCharLongMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCharLongMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCharLongMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCharLongMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractCharLongMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractCharLongMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractCharLongMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractCharLongMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCharLongMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractCharLongMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractCharLongMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractCharLongMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractCharLongMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractCharLongMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharLongMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharLongMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractCharLongMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCharLongMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCharLongMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharLongMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCharLongMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCharLongMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractCharLongMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractCharLongMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractCharLongMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractCharLongMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractCharLongMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractCharLongMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractCharLongMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractCharLongMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCharLongMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractCharLongMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractCharLongMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCharLongMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractCharLongMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCharLongMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCharLongMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCharLongMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractCharLongMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractCharLongMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractCharLongMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCharLongMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCharLongMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractCharLongMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractCharLongMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCharLongMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCharLongMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractCharLongMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCharLongMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCharLongMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractCharLongMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractCharLongMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractCharLongMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractCharLongMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCharLongMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharLongMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCharLongMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractCharLongMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractCharLongMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCharLongMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCharLongMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
