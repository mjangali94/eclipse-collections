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
import org.eclipse.collections.api.map.primitive.CharShortMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.CharShortPair;
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
 * Abstract JUnit test for {@link CharShortMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractCharShortMapKeyValuesViewTestCase {

    public abstract CharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3);

    public abstract CharShortMap newWithKeysValues(char key1, short value1, char key2, short value2);

    public abstract CharShortMap newWithKeysValues(char key1, short value1);

    public abstract CharShortMap newEmpty();

    public RichIterable<CharShortPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<CharShortPair> newWith(char key1, short value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<CharShortPair> newWith(char key1, short value1, char key2, short value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<CharShortPair> newWith(char key1, short value1, char key2, short value2, char key3, short value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 1, (short) 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 1, (short) 5)));
    }

    @Test
    public void forEach() {
        MutableList<CharShortPair> result = Lists.mutable.of();
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4));
        MutableList<CharShortPair> result2 = Lists.mutable.of();
        RichIterable<CharShortPair> collection2 = this.newWith((char) 0, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((char) 0, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<CharShortPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 0, (char) 2, (short) 3, (char) 3, (short) 4);
        collection.forEachWith((CharShortPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, (short) 0), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<CharShortPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<CharShortPair> collection2 = this.newWith((char) 2, (short) 5, (char) 6, (short) 3, (char) 3, (short) 4);
        collection2.forEachWith((CharShortPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 2, (short) 5), PrimitiveTuples.pair((char) 6, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<CharShortPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<CharShortPair> collection = this.newWith((char) 2, (short) 2, (char) 6, (short) 3, (char) 3, (short) 4);
        collection.forEachWithIndex((CharShortPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 2, (short) 2), PrimitiveTuples.pair((char) 6, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<CharShortPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<CharShortPair> collection2 = this.newWith((char) 0, (short) 1, (char) 2, (short) 3, (char) 3, (short) 4);
        collection2.forEachWithIndex((CharShortPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 0, (short) 1), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).select(PrimitiveTuples.pair((char) 2, (short) 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, (short) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).selectWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, (short) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, (short) 3), HashBag.<CharShortPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 3, (short) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).reject(Predicates.notEqual(PrimitiveTuples.pair((char) 2, (short) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, (short) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, (short) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, (short) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, (short) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, (short) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).rejectWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3), HashBag.<CharShortPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 3, (short) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(CharShortPair.class), PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 3, (short) 4), PrimitiveTuples.pair((char) 2, (short) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collect((CharShortPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collect((CharShortPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectBoolean((CharShortPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectByte((CharShortPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectChar((CharShortPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectDouble((CharShortPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectFloat((CharShortPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectInt((CharShortPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectLong((CharShortPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectShort((CharShortPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Function<CharShortPair, MutableList<String>> function = (CharShortPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("\u0001:2", "\u0002:3", "\u0003:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("\u0001:2", "\u0002:3", "\u0003:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, (short) 3), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detect(PrimitiveTuples.pair((char) 2, (short) 3)::equals));
        Assert.assertNull(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detect(PrimitiveTuples.pair((char) 2, (short) 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, (short) 2), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, (short) 4), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, (short) 2), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, (short) 4), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, (short) 3), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).minBy((CharShortPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, (short) 2), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 4, (short) 5).maxBy((CharShortPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, (short) 3), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)));
        Assert.assertNull(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<CharShortPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, (short) 6));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, (short) 3), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectIfNone(PrimitiveTuples.pair((char) 2, (short) 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, (short) 6), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<CharShortPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, (short) 6));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, (short) 3), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, (short) 6), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).allSatisfy(CharShortPair.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).allSatisfy(PrimitiveTuples.pair((char) 2, (short) 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).allSatisfyWith(Predicates2.instanceOf(), CharShortPair.class));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).noneSatisfy(PrimitiveTuples.pair((char) 2, (short) 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).anySatisfy(PrimitiveTuples.pair((char) 2, (short) 3)::equals));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).anySatisfy(PrimitiveTuples.pair((char) 2, (short) 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)));
        Assert.assertFalse(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).count(CharShortPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).count(PrimitiveTuples.pair((char) 2, (short) 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).countWith(Predicates2.instanceOf(), CharShortPair.class));
        Assert.assertEquals(1, this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).countWith(Object::equals, PrimitiveTuples.pair((char) 2, (short) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectIf(CharShortPair.class::isInstance, String::valueOf), "\u0001:2", "\u0002:3", "\u0003:4");
        Verify.assertContainsAll(this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectIf(CharShortPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "\u0001:2", "\u0002:3", "\u0003:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectWith((CharShortPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).collectWith((CharShortPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        CharShortPair first = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, (short) 2).equals(first) || PrimitiveTuples.pair((char) 2, (short) 3).equals(first) || PrimitiveTuples.pair((char) 3, (short) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, (short) 2), this.newWith((char) 1, (short) 2).getFirst());
    }

    @Test
    public void getLast() {
        CharShortPair last = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, (short) 2).equals(last) || PrimitiveTuples.pair((char) 2, (short) 3).equals(last) || PrimitiveTuples.pair((char) 3, (short) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, (short) 2), this.newWith((char) 1, (short) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((char) 1, (short) 2));
        Assert.assertTrue(this.newWith((char) 1, (short) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 0, (short) 3, (char) 3, (short) 4);
        MutableBag<CharShortPair> actual = Bags.mutable.of();
        Iterator<CharShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<CharShortPair> objects = this.newWith((char) 2, (short) 3, (char) 4, (short) 3, (char) 3, (short) 4);
        MutableBag<CharShortPair> actual = Bags.mutable.of();
        Iterator<CharShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Iterator<CharShortPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Iterator<CharShortPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Long result = objects.injectInto(1L, (Long argument1, CharShortPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        int result = objects.injectInto(1, (int intParameter, CharShortPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        long result = objects.injectInto(1L, (long parameter, CharShortPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        double result = objects.injectInto(1.0, (double parameter, CharShortPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        float result = objects.injectInto(1.0f, (float parameter, CharShortPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        double actual = objects.sumOfFloat((CharShortPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        double actual = objects.sumOfDouble((CharShortPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        long actual = objects.sumOfInt((CharShortPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        long actual = objects.sumOfLong((CharShortPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<CharShortPair> objects = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        CharShortPair[] array2 = objects.toArray(new CharShortPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<CharShortPair> result = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).partition(PrimitiveTuples.pair((char) 2, (short) 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair((char) 2, (short) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, (short) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, (short) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<CharShortPair> list = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4));
    }

    @Test
    public void toBag() {
        MutableBag<CharShortPair> bag = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableList<CharShortPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableList<CharShortPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 3, (short) 4), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 1, (short) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableList<CharShortPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedBag<CharShortPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedBag<CharShortPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, (short) 4), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 1, (short) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedBag<CharShortPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedSet<CharShortPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedSet<CharShortPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, (short) 4), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 1, (short) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 2, (short) 3, (char) 1, (short) 2, (char) 3, (short) 4);
        MutableSortedSet<CharShortPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MutableSet<CharShortPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 2, (short) 3), PrimitiveTuples.pair((char) 3, (short) 4));
    }

    @Test
    public void toMap() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<CharShortPair> pairs = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "\u0001:2", "\u0001:2", "\u0002:3", "\u0002:3", "\u0003:4", "\u0003:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3);
        Assert.assertTrue("[\u0001:2, \u0002:3]".equals(collection.toString()) || "[\u0002:3, \u0001:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Function<CharShortPair, Boolean> function = (CharShortPair object) -> PrimitiveTuples.pair((char) 1, (short) 2).equals(object);
        Multimap<Boolean, CharShortPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, (short) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, (short) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, (short) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Function<CharShortPair, MutableList<Boolean>> function = (CharShortPair object) -> Lists.mutable.of(PrimitiveTuples.pair((char) 1, (short) 2).equals(object));
        Multimap<Boolean, CharShortPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, (short) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, (short) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, (short) 4)));
    }

    @Test
    public void zip() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3);
        RichIterable<Pair<CharShortPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, (short) 2), 1), Tuples.pair(PrimitiveTuples.pair((char) 2, (short) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, (short) 3), 1), Tuples.pair(PrimitiveTuples.pair((char) 1, (short) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3);
        RichIterable<Pair<CharShortPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, (short) 2), 0), Tuples.pair(PrimitiveTuples.pair((char) 2, (short) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, (short) 3), 0), Tuples.pair(PrimitiveTuples.pair((char) 1, (short) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((char) 1, (short) 2)), FastList.newListWith(PrimitiveTuples.pair((char) 2, (short) 3)), FastList.newListWith(PrimitiveTuples.pair((char) 3, (short) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
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
        RichIterable<CharShortPair> notEmpty = this.newWith((char) 1, (short) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, CharShortPair> sumAggregator = (AtomicInteger aggregate, CharShortPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("\u0003:4").intValue());
        Assert.assertEquals(2, aggregation.get("\u0002:3").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, CharShortPair, Integer> sumAggregator = (Integer aggregate, CharShortPair value) -> (int) (aggregate + value.getOne());
        RichIterable<CharShortPair> collection = this.newWith((char) 1, (short) 1, (char) 1, (short) 2, (char) 2, (short) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("\u0002:3").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharShortMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharShortMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharShortMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractCharShortMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractCharShortMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractCharShortMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractCharShortMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCharShortMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractCharShortMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractCharShortMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCharShortMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractCharShortMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractCharShortMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCharShortMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCharShortMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCharShortMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractCharShortMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractCharShortMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractCharShortMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractCharShortMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractCharShortMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractCharShortMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractCharShortMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractCharShortMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractCharShortMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractCharShortMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharShortMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharShortMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharShortMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractCharShortMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractCharShortMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCharShortMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractCharShortMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractCharShortMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractCharShortMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractCharShortMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCharShortMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCharShortMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCharShortMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCharShortMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCharShortMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCharShortMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCharShortMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractCharShortMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractCharShortMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractCharShortMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractCharShortMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCharShortMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractCharShortMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractCharShortMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractCharShortMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractCharShortMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractCharShortMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharShortMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharShortMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractCharShortMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCharShortMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCharShortMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharShortMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCharShortMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCharShortMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractCharShortMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractCharShortMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractCharShortMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractCharShortMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractCharShortMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractCharShortMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractCharShortMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractCharShortMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCharShortMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractCharShortMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractCharShortMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCharShortMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractCharShortMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCharShortMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCharShortMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCharShortMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractCharShortMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractCharShortMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractCharShortMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCharShortMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCharShortMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractCharShortMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractCharShortMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCharShortMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCharShortMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractCharShortMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCharShortMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCharShortMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractCharShortMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractCharShortMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractCharShortMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractCharShortMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCharShortMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharShortMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCharShortMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractCharShortMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractCharShortMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCharShortMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCharShortMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
