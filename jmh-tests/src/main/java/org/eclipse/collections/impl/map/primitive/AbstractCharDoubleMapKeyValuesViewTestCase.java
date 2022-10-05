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
import org.eclipse.collections.api.map.primitive.CharDoubleMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.CharDoublePair;
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
 * Abstract JUnit test for {@link CharDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractCharDoubleMapKeyValuesViewTestCase {

    public abstract CharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3);

    public abstract CharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2);

    public abstract CharDoubleMap newWithKeysValues(char key1, double value1);

    public abstract CharDoubleMap newEmpty();

    public RichIterable<CharDoublePair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<CharDoublePair> newWith(char key1, double value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<CharDoublePair> newWith(char key1, double value1, char key2, double value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<CharDoublePair> newWith(char key1, double value1, char key2, double value2, char key3, double value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 1, 5.0))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 1, 5.0)));
    }

    @Test
    public void forEach() {
        MutableList<CharDoublePair> result = Lists.mutable.of();
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0));
        MutableList<CharDoublePair> result2 = Lists.mutable.of();
        RichIterable<CharDoublePair> collection2 = this.newWith((char) 0, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((char) 0, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0));
    }

    @Test
    public void forEachWith() {
        MutableBag<CharDoublePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 0.0, (char) 2, 3.0, (char) 3, 4.0);
        collection.forEachWith((CharDoublePair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 0.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<CharDoublePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<CharDoublePair> collection2 = this.newWith((char) 2, 5.0, (char) 6, 3.0, (char) 3, 4.0);
        collection2.forEachWith((CharDoublePair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 2, 5.0), PrimitiveTuples.pair((char) 6, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<CharDoublePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<CharDoublePair> collection = this.newWith((char) 2, 2.0, (char) 6, 3.0, (char) 3, 4.0);
        collection.forEachWithIndex((CharDoublePair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 2, 2.0), PrimitiveTuples.pair((char) 6, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<CharDoublePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<CharDoublePair> collection2 = this.newWith((char) 0, 1.0, (char) 2, 3.0, (char) 3, 4.0);
        collection2.forEachWithIndex((CharDoublePair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 0, 1.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).select(PrimitiveTuples.pair((char) 2, 3.0)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0), result);
    }

    @Test
    public void selectWith() {
        MutableList<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).selectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3.0), HashBag.<CharDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 3, 4.0)), result);
    }

    @Test
    public void reject() {
        MutableList<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).reject(Predicates.notEqual(PrimitiveTuples.pair((char) 2, 3.0))).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0), result);
    }

    @Test
    public void rejectWith() {
        MutableList<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, 4.0), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).rejectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0), HashBag.<CharDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 3, 4.0)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(CharDoublePair.class), PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 3, 4.0), PrimitiveTuples.pair((char) 2, 3.0));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collect((CharDoublePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collect((CharDoublePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectBoolean((CharDoublePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectByte((CharDoublePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectChar((CharDoublePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectDouble((CharDoublePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectFloat((CharDoublePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectInt((CharDoublePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectLong((CharDoublePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectShort((CharDoublePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Function<CharDoublePair, MutableList<String>> function = (CharDoublePair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("\u0001:2.0", "\u0002:3.0", "\u0003:4.0"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("\u0001:2.0", "\u0002:3.0", "\u0003:4.0"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detect(PrimitiveTuples.pair((char) 2, 3.0)::equals));
        Assert.assertNull(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detect(PrimitiveTuples.pair((char) 2, 4.0)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, 4.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).minBy((CharDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 4, 5.0).maxBy((CharDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)));
        Assert.assertNull(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<CharDoublePair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectIfNone(PrimitiveTuples.pair((char) 2, 3.0)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<CharDoublePair> function = Functions0.value(PrimitiveTuples.pair((char) 5, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, 3.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, 3.0), function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, 6.0), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).allSatisfy(CharDoublePair.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).allSatisfy(PrimitiveTuples.pair((char) 2, 3.0)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).allSatisfyWith(Predicates2.instanceOf(), CharDoublePair.class));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).allSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).noneSatisfy(PrimitiveTuples.pair((char) 2, 3.0)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).anySatisfy(PrimitiveTuples.pair((char) 2, 3.0)::equals));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).anySatisfy(PrimitiveTuples.pair((char) 2, 5.0)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)));
        Assert.assertFalse(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, 5.0)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).count(CharDoublePair.class::isInstance));
        Assert.assertEquals(1, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).count(PrimitiveTuples.pair((char) 2, 3.0)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).countWith(Predicates2.instanceOf(), CharDoublePair.class));
        Assert.assertEquals(1, this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).countWith(Object::equals, PrimitiveTuples.pair((char) 2, 3.0)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectIf(CharDoublePair.class::isInstance, String::valueOf), "\u0001:2.0", "\u0002:3.0", "\u0003:4.0");
        Verify.assertContainsAll(this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectIf(CharDoublePair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "\u0001:2.0", "\u0002:3.0", "\u0003:4.0");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectWith((CharDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).collectWith((CharDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        CharDoublePair first = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2.0).equals(first) || PrimitiveTuples.pair((char) 2, 3.0).equals(first) || PrimitiveTuples.pair((char) 3, 4.0).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0), this.newWith((char) 1, 2.0).getFirst());
    }

    @Test
    public void getLast() {
        CharDoublePair last = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, 2.0).equals(last) || PrimitiveTuples.pair((char) 2, 3.0).equals(last) || PrimitiveTuples.pair((char) 3, 4.0).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, 2.0), this.newWith((char) 1, 2.0).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((char) 1, 2.0));
        Assert.assertTrue(this.newWith((char) 1, 2.0).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 0, 3.0, (char) 3, 4.0);
        MutableBag<CharDoublePair> actual = Bags.mutable.of();
        Iterator<CharDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 2, 3.0, (char) 4, 3.0, (char) 3, 4.0);
        MutableBag<CharDoublePair> actual = Bags.mutable.of();
        Iterator<CharDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Iterator<CharDoublePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Iterator<CharDoublePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Long result = objects.injectInto(1L, (Long argument1, CharDoublePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        int result = objects.injectInto(1, (int intParameter, CharDoublePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        long result = objects.injectInto(1L, (long parameter, CharDoublePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        double result = objects.injectInto(1.0, (double parameter, CharDoublePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        float result = objects.injectInto(1.0f, (float parameter, CharDoublePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        double actual = objects.sumOfFloat((CharDoublePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        double actual = objects.sumOfDouble((CharDoublePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        long actual = objects.sumOfInt((CharDoublePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        long actual = objects.sumOfLong((CharDoublePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<CharDoublePair> objects = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        CharDoublePair[] array2 = objects.toArray(new CharDoublePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<CharDoublePair> result = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).partition(PrimitiveTuples.pair((char) 2, 3.0)::equals);
        Verify.assertContains(PrimitiveTuples.pair((char) 2, 3.0), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, 2.0), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, 4.0), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<CharDoublePair> list = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0));
    }

    @Test
    public void toBag() {
        MutableBag<CharDoublePair> bag = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableList<CharDoublePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableList<CharDoublePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 3, 4.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 1, 2.0)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableList<CharDoublePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedBag<CharDoublePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedBag<CharDoublePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 1, 2.0)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedBag<CharDoublePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedSet<CharDoublePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedSet<CharDoublePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, 4.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 1, 2.0)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 2, 3.0, (char) 1, 2.0, (char) 3, 4.0);
        MutableSortedSet<CharDoublePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0)), set);
    }

    @Test
    public void toSet() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MutableSet<CharDoublePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((char) 1, 2.0), PrimitiveTuples.pair((char) 2, 3.0), PrimitiveTuples.pair((char) 3, 4.0));
    }

    @Test
    public void toMap() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<CharDoublePair> pairs = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "\u0001:2.0", "\u0001:2.0", "\u0002:3.0", "\u0002:3.0", "\u0003:4.0", "\u0003:4.0"), map);
    }

    @Test
    public void testToString() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0);
        Assert.assertTrue("[\u0001:2.0, \u0002:3.0]".equals(collection.toString()) || "[\u0002:3.0, \u0001:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Function<CharDoublePair, Boolean> function = (CharDoublePair object) -> PrimitiveTuples.pair((char) 1, 2.0).equals(object);
        Multimap<Boolean, CharDoublePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4.0)));
    }

    @Test
    public void groupByEach() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Function<CharDoublePair, MutableList<Boolean>> function = (CharDoublePair object) -> Lists.mutable.of(PrimitiveTuples.pair((char) 1, 2.0).equals(object));
        Multimap<Boolean, CharDoublePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, 4.0)));
    }

    @Test
    public void zip() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0);
        RichIterable<Pair<CharDoublePair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0), 1), Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0), 1), Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0);
        RichIterable<Pair<CharDoublePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0), 0), Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, 3.0), 0), Tuples.pair(PrimitiveTuples.pair((char) 1, 2.0), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((char) 1, 2.0)), FastList.newListWith(PrimitiveTuples.pair((char) 2, 3.0)), FastList.newListWith(PrimitiveTuples.pair((char) 3, 4.0))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
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
        RichIterable<CharDoublePair> notEmpty = this.newWith((char) 1, 2.0);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, CharDoublePair> sumAggregator = (AtomicInteger aggregate, CharDoublePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("\u0003:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("\u0002:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, CharDoublePair, Integer> sumAggregator = (Integer aggregate, CharDoublePair value) -> (int) (aggregate + value.getOne());
        RichIterable<CharDoublePair> collection = this.newWith((char) 1, 1.0, (char) 1, 2.0, (char) 2, 3.0);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("\u0002:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:2.0").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharDoubleMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharDoubleMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharDoubleMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractCharDoubleMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractCharDoubleMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractCharDoubleMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractCharDoubleMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCharDoubleMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractCharDoubleMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractCharDoubleMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCharDoubleMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractCharDoubleMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractCharDoubleMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCharDoubleMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCharDoubleMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCharDoubleMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractCharDoubleMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractCharDoubleMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractCharDoubleMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractCharDoubleMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractCharDoubleMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractCharDoubleMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractCharDoubleMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractCharDoubleMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractCharDoubleMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractCharDoubleMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharDoubleMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharDoubleMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharDoubleMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractCharDoubleMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractCharDoubleMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractCharDoubleMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractCharDoubleMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractCharDoubleMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCharDoubleMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCharDoubleMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCharDoubleMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCharDoubleMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCharDoubleMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCharDoubleMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCharDoubleMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractCharDoubleMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractCharDoubleMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractCharDoubleMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractCharDoubleMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCharDoubleMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractCharDoubleMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractCharDoubleMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractCharDoubleMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractCharDoubleMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractCharDoubleMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharDoubleMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharDoubleMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractCharDoubleMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCharDoubleMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCharDoubleMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharDoubleMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCharDoubleMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCharDoubleMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractCharDoubleMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractCharDoubleMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractCharDoubleMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractCharDoubleMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractCharDoubleMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractCharDoubleMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractCharDoubleMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractCharDoubleMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractCharDoubleMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCharDoubleMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractCharDoubleMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractCharDoubleMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCharDoubleMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCharDoubleMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractCharDoubleMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCharDoubleMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCharDoubleMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractCharDoubleMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractCharDoubleMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractCharDoubleMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractCharDoubleMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCharDoubleMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharDoubleMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCharDoubleMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractCharDoubleMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractCharDoubleMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCharDoubleMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCharDoubleMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
