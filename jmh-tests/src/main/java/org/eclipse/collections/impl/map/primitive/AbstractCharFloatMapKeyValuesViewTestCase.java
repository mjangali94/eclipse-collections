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
import org.eclipse.collections.api.map.primitive.CharFloatMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;
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
 * Abstract JUnit test for {@link CharFloatMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractCharFloatMapKeyValuesViewTestCase {

    public abstract CharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3);

    public abstract CharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2);

    public abstract CharFloatMap newWithKeysValues(char key1, float value1);

    public abstract CharFloatMap newEmpty();

    public RichIterable<CharFloatPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<CharFloatPair> newWith(char key1, float value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<CharFloatPair> newWith(char key1, float value1, char key2, float value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<CharFloatPair> newWith(char key1, float value1, char key2, float value2, char key3, float value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 1, 5.0f))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 1, 5.0f)));
    }

    @Test
    public void forEach() {
        MutableList<CharFloatPair> result = Lists.mutable.of();
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f));
        MutableList<CharFloatPair> result2 = Lists.mutable.of();
        RichIterable<CharFloatPair> collection2 = this.newWith((char) 0, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((char) 0, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f));
    }

    @Test
    public void forEachWith() {
        MutableBag<CharFloatPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 0.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        collection.forEachWith((CharFloatPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 0.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<CharFloatPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<CharFloatPair> collection2 = this.newWith((char) 2, 5.0f, (char) 6, 3.0f, (char) 3, 4.0f);
        collection2.forEachWith((CharFloatPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 2, 5.0f), PrimitiveTuples.pair((char) 6, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<CharFloatPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<CharFloatPair> collection = this.newWith((char) 2, 2.0f, (char) 6, 3.0f, (char) 3, 4.0f);
        collection.forEachWithIndex((CharFloatPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 2, 2.0f), PrimitiveTuples.pair((char) 6, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<CharFloatPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<CharFloatPair> collection2 = this.newWith((char) 0, 1.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        collection2.forEachWithIndex((CharFloatPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 0, 1.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).select(PrimitiveTuples.pair((char) 2, 3.0f)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0f), result);
    }

    @Test
    public void selectWith() {
        MutableList<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).selectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0f), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3.0f), HashBag.<CharFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 3, 4.0f)), result);
    }

    @Test
    public void reject() {
        MutableList<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).reject(Predicates.notEqual(PrimitiveTuples.pair((char) 2, 3.0f))).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0f), result);
    }

    @Test
    public void rejectWith() {
        MutableList<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0f), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).rejectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f), HashBag.<CharFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 3, 4.0f)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(CharFloatPair.class), PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 3, 4.0f), PrimitiveTuples.pair((char) 2, 3.0f));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collect((CharFloatPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collect((CharFloatPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectBoolean((CharFloatPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectByte((CharFloatPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectChar((CharFloatPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectDouble((CharFloatPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectFloat((CharFloatPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectInt((CharFloatPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectLong((CharFloatPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectShort((CharFloatPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Function<CharFloatPair, MutableList<String>> function = (CharFloatPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("\u0001:2.0", "\u0002:3.0", "\u0003:4.0"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("\u0001:2.0", "\u0002:3.0", "\u0003:4.0"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detect(PrimitiveTuples.pair((char) 2, 3.0f)::equals));
        Assert.assertNull(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detect(PrimitiveTuples.pair((char) 2, 4.0f)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).minBy((CharFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 4, 5.0f).maxBy((CharFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)));
        Assert.assertNull(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<CharFloatPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectIfNone(PrimitiveTuples.pair((char) 2, 3.0f)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<CharFloatPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f), function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6.0f), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).allSatisfy(CharFloatPair.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).allSatisfy(PrimitiveTuples.pair((char) 2, 3.0f)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).allSatisfyWith(Predicates2.instanceOf(), CharFloatPair.class));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).allSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).noneSatisfy(PrimitiveTuples.pair((char) 2, 3.0f)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).anySatisfy(PrimitiveTuples.pair((char) 2, 3.0f)::equals));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).anySatisfy(PrimitiveTuples.pair((char) 2, 5.0f)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)));
        Assert.assertFalse(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 5.0f)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).count(CharFloatPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).count(PrimitiveTuples.pair((char) 2, 3.0f)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).countWith(Predicates2.instanceOf(), CharFloatPair.class));
        Assert.assertEquals(1, this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).countWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0f)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectIf(CharFloatPair.class::isInstance, String::valueOf), "\u0001:2.0", "\u0002:3.0", "\u0003:4.0");
        Verify.assertContainsAll(this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectIf(CharFloatPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "\u0001:2.0", "\u0002:3.0", "\u0003:4.0");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectWith((CharFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).collectWith((CharFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        CharFloatPair first = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2.0f).equals(first) || PrimitiveTuples.pair((char) 2, 3.0f).equals(first) || PrimitiveTuples.pair((char) 3, 4.0f).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0f), this.newWith((char) 1, 2.0f).getFirst());
    }

    @Test
    public void getLast() {
        CharFloatPair last = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2.0f).equals(last) || PrimitiveTuples.pair((char) 2, 3.0f).equals(last) || PrimitiveTuples.pair((char) 3, 4.0f).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0f), this.newWith((char) 1, 2.0f).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((char) 1, 2.0f));
        Assert.assertTrue(this.newWith((char) 1, 2.0f).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 0, 3.0f, (char) 3, 4.0f);
        MutableBag<CharFloatPair> actual = Bags.mutable.of();
        Iterator<CharFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 2, 3.0f, (char) 4, 3.0f, (char) 3, 4.0f);
        MutableBag<CharFloatPair> actual = Bags.mutable.of();
        Iterator<CharFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Iterator<CharFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Iterator<CharFloatPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Long result = objects.injectInto(1L, (Long argument1, CharFloatPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        int result = objects.injectInto(1, (int intParameter, CharFloatPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        long result = objects.injectInto(1L, (long parameter, CharFloatPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        double result = objects.injectInto(1.0, (double parameter, CharFloatPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        float result = objects.injectInto(1.0f, (float parameter, CharFloatPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        double actual = objects.sumOfFloat((CharFloatPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        double actual = objects.sumOfDouble((CharFloatPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        long actual = objects.sumOfInt((CharFloatPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        long actual = objects.sumOfLong((CharFloatPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<CharFloatPair> objects = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        CharFloatPair[] array2 = objects.toArray(new CharFloatPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<CharFloatPair> result = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).partition(PrimitiveTuples.pair((char) 2, 3.0f)::equals);
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0f), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, 2.0f), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, 4.0f), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<CharFloatPair> list = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f));
    }

    @Test
    public void toBag() {
        MutableBag<CharFloatPair> bag = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableList<CharFloatPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableList<CharFloatPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 3, 4.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 1, 2.0f)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableList<CharFloatPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedBag<CharFloatPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedBag<CharFloatPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 1, 2.0f)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedBag<CharFloatPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedSet<CharFloatPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedSet<CharFloatPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 1, 2.0f)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 2, 3.0f, (char) 1, 2.0f, (char) 3, 4.0f);
        MutableSortedSet<CharFloatPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f)), set);
    }

    @Test
    public void toSet() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MutableSet<CharFloatPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((char) 1, 2.0f), PrimitiveTuples.pair((char) 2, 3.0f), PrimitiveTuples.pair((char) 3, 4.0f));
    }

    @Test
    public void toMap() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<CharFloatPair> pairs = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void testToString() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f);
        Assert.assertTrue("[\u0001:2.0, \u0002:3.0]".equals(collection.toString()) || "[\u0002:3.0, \u0001:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Function<CharFloatPair, Boolean> function = (CharFloatPair object) -> PrimitiveTuples.pair((char) 1, 2.0f).equals(object);
        Multimap<Boolean, CharFloatPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4.0f)));
    }

    @Test
    public void groupByEach() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Function<CharFloatPair, MutableList<Boolean>> function = (CharFloatPair object) -> Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0f).equals(object));
        Multimap<Boolean, CharFloatPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4.0f)));
    }

    @Test
    public void zip() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f);
        RichIterable<Pair<CharFloatPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0f), 1), Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0f), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0f), 1), Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0f), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f);
        RichIterable<Pair<CharFloatPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0f), 0), Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0f), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0f), 0), Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0f), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0f)), FastList.newListWith(PrimitiveTuples.pair((char) 2, 3.0f)), FastList.newListWith(PrimitiveTuples.pair((char) 3, 4.0f))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
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
        RichIterable<CharFloatPair> notEmpty = this.newWith((char) 1, 2.0f);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, CharFloatPair> sumAggregator = (AtomicInteger aggregate, CharFloatPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("\u0003:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("\u0002:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, CharFloatPair, Integer> sumAggregator = (Integer aggregate, CharFloatPair value) -> (int) (aggregate + value.getOne());
        RichIterable<CharFloatPair> collection = this.newWith((char) 1, 1.0f, (char) 1, 2.0f, (char) 2, 3.0f);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("\u0002:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2.0").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharFloatMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharFloatMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractCharFloatMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractCharFloatMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractCharFloatMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractCharFloatMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCharFloatMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractCharFloatMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractCharFloatMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCharFloatMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractCharFloatMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractCharFloatMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCharFloatMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCharFloatMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCharFloatMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractCharFloatMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractCharFloatMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractCharFloatMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractCharFloatMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractCharFloatMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractCharFloatMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractCharFloatMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractCharFloatMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractCharFloatMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractCharFloatMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharFloatMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractCharFloatMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractCharFloatMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCharFloatMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractCharFloatMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractCharFloatMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractCharFloatMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractCharFloatMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCharFloatMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCharFloatMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCharFloatMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCharFloatMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCharFloatMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCharFloatMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCharFloatMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractCharFloatMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractCharFloatMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractCharFloatMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractCharFloatMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCharFloatMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractCharFloatMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractCharFloatMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractCharFloatMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractCharFloatMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractCharFloatMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractCharFloatMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCharFloatMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCharFloatMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharFloatMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCharFloatMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCharFloatMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractCharFloatMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractCharFloatMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractCharFloatMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractCharFloatMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractCharFloatMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractCharFloatMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractCharFloatMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractCharFloatMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCharFloatMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractCharFloatMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractCharFloatMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCharFloatMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractCharFloatMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCharFloatMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCharFloatMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCharFloatMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractCharFloatMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractCharFloatMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractCharFloatMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCharFloatMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCharFloatMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractCharFloatMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractCharFloatMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCharFloatMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCharFloatMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractCharFloatMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCharFloatMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCharFloatMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractCharFloatMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractCharFloatMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractCharFloatMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractCharFloatMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCharFloatMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCharFloatMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractCharFloatMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractCharFloatMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCharFloatMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCharFloatMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
