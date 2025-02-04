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
import org.eclipse.collections.api.map.primitive.FloatBooleanMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.FloatBooleanPair;
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
 * Abstract JUnit test for {@link FloatBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveBooleanMapKeyValuesViewTest.stg.
 */
public abstract class AbstractFloatBooleanMapKeyValuesViewTestCase {

    public abstract FloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3);

    public abstract FloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2);

    public abstract FloatBooleanMap newWithKeysValues(float key1, boolean value1);

    public abstract FloatBooleanMap newEmpty();

    public RichIterable<FloatBooleanPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<FloatBooleanPair> newWith(float key1, boolean value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<FloatBooleanPair> newWith(float key1, boolean value1, float key2, boolean value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<FloatBooleanPair> newWith(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(1.0f, true))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<FloatBooleanPair> result = Lists.mutable.of();
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        collection.forEach(Procedures.cast(result::add));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false));
        MutableList<FloatBooleanPair> result2 = Lists.mutable.of();
        RichIterable<FloatBooleanPair> collection2 = this.newWith(0.0f, false, 2.0f, true, 3.0f, false);
        collection2.forEach(Procedures.cast(result2::add));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false));
    }

    @Test
    public void forEachWith() {
        MutableBag<FloatBooleanPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        collection.forEachWith((FloatBooleanPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<FloatBooleanPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 0.0f, true, 3.0f, false);
        collection.forEachWithIndex((FloatBooleanPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(0.0f, true), PrimitiveTuples.pair(3.0f, false)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).select(PrimitiveTuples.pair(2.0f, true)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, false), result);
    }

    @Test
    public void selectWith() {
        MutableList<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).selectWith(Object::equals, PrimitiveTuples.pair(2.0f, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, false), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, true), HashBag.<FloatBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(3.0f, false)), result);
    }

    @Test
    public void reject() {
        MutableList<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0f, true))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, false), result);
    }

    @Test
    public void rejectWith() {
        MutableList<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, false), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).rejectWith(Object::equals, PrimitiveTuples.pair(2.0f, true), HashBag.<FloatBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(3.0f, false)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(FloatBooleanPair.class), PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(3.0f, false), PrimitiveTuples.pair(2.0f, true));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collect((FloatBooleanPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Boolean> result2 = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collect(FloatBooleanPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(false, true, false), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectBoolean((FloatBooleanPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectByte((FloatBooleanPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectChar((FloatBooleanPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectDouble((FloatBooleanPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectFloat((FloatBooleanPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectInt((FloatBooleanPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectLong((FloatBooleanPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectShort((FloatBooleanPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Function<FloatBooleanPair, MutableList<String>> function = (FloatBooleanPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1.0:false", "2.0:true", "3.0:false"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1.0:false", "2.0:true", "3.0:false"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detect(PrimitiveTuples.pair(2.0f, true)::equals));
        Assert.assertNull(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detect(PrimitiveTuples.pair(2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, false), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, false), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, false), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, false), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).minBy((FloatBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, false), this.newWith(1.0f, false, 2.0f, true, 4.0f, false).maxBy((FloatBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectWith(Object::equals, PrimitiveTuples.pair(2.0f, true)));
        Assert.assertNull(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectWith(Object::equals, PrimitiveTuples.pair(2.0f, false)));
    }

    @Test
    public void detectIfNone() {
        Function0<FloatBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5.0f, true));
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectIfNone(PrimitiveTuples.pair(2.0f, true)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectIfNone(PrimitiveTuples.pair(2.0f, false)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<FloatBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5.0f, true));
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0f, true), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0f, true), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0f, false), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).allSatisfy(FloatBooleanPair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).allSatisfy(PrimitiveTuples.pair(2.0f, true)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).allSatisfyWith(Predicates2.instanceOf(), FloatBooleanPair.class));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, true)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).noneSatisfy(PrimitiveTuples.pair(2.0f, true)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, true)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).anySatisfy(PrimitiveTuples.pair(2.0f, true)::equals));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).anySatisfy(PrimitiveTuples.pair(2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, true)));
        Assert.assertFalse(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).count(FloatBooleanPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).count(PrimitiveTuples.pair(2.0f, true)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).countWith(Predicates2.instanceOf(), FloatBooleanPair.class));
        Assert.assertEquals(1, this.newWith(1.0f, false, 2.0f, true, 3.0f, false).countWith(Object::equals, PrimitiveTuples.pair(2.0f, true)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectIf(FloatBooleanPair.class::isInstance, String::valueOf), "1.0:false", "2.0:true", "3.0:false");
        Verify.assertContainsAll(this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectIf(FloatBooleanPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1.0:false", "2.0:true", "3.0:false");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of("3.0:false-", "2.0:true-", "1.0:false-"), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectWith((FloatBooleanPair argument1, String argument2) -> argument1 + argument2, "-").toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of("1.0:false-", "2.0:true-", "3.0:false-"), this.newWith(1.0f, false, 2.0f, true, 3.0f, false).collectWith((FloatBooleanPair argument1, String argument2) -> argument1 + argument2, "-", HashBag.<String>newBag()));
    }

    @Test
    public void getFirst() {
        FloatBooleanPair first = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, false).equals(first) || PrimitiveTuples.pair(2.0f, true).equals(first) || PrimitiveTuples.pair(3.0f, false).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, false), this.newWith(1.0f, false).getFirst());
    }

    @Test
    public void getLast() {
        FloatBooleanPair last = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, false).equals(last) || PrimitiveTuples.pair(2.0f, true).equals(last) || PrimitiveTuples.pair(3.0f, false).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, false), this.newWith(1.0f, false).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0f, false));
        Assert.assertTrue(this.newWith(1.0f, false).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 0.0f, true, 3.0f, false);
        MutableBag<FloatBooleanPair> actual = Bags.mutable.of();
        Iterator<FloatBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Iterator<FloatBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Iterator<FloatBooleanPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Long result = objects.injectInto(1L, (Long argument1, FloatBooleanPair argument2) -> (long) (argument1 + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(Long.valueOf(9), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        int result = objects.injectInto(1, (int intParameter, FloatBooleanPair argument2) -> (int) (intParameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        long result = objects.injectInto(1L, (long parameter, FloatBooleanPair argument2) -> (long) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        double result = objects.injectInto(1.0, (double parameter, FloatBooleanPair argument2) -> (double) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        float result = objects.injectInto(1.0f, (float parameter, FloatBooleanPair argument2) -> (float) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        double actual = objects.sumOfFloat((FloatBooleanPair each) -> (float) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        double actual = objects.sumOfDouble((FloatBooleanPair each) -> (double) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        long actual = objects.sumOfInt((FloatBooleanPair each) -> (int) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        long actual = objects.sumOfLong((FloatBooleanPair each) -> (long) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void toArray() {
        RichIterable<FloatBooleanPair> objects = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        FloatBooleanPair[] array2 = objects.toArray(new FloatBooleanPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).partition(PrimitiveTuples.pair(2.0f, true)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0f, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0f, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionIterable<FloatBooleanPair> result = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).partitionWith(Object::equals, PrimitiveTuples.pair(2.0f, true));
        Verify.assertContains(PrimitiveTuples.pair(2.0f, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0f, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0f, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<FloatBooleanPair> list = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false));
    }

    @Test
    public void toBag() {
        MutableBag<FloatBooleanPair> bag = this.newWith(1.0f, false, 2.0f, true, 3.0f, false).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableList<FloatBooleanPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableList<FloatBooleanPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(1.0f, false)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableList<FloatBooleanPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedBag<FloatBooleanPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedBag<FloatBooleanPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(1.0f, false)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedBag<FloatBooleanPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedSet<FloatBooleanPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedSet<FloatBooleanPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(1.0f, false)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(2.0f, true, 1.0f, false, 3.0f, false);
        MutableSortedSet<FloatBooleanPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false)), set);
    }

    @Test
    public void toSet() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableSet<FloatBooleanPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(2.0f, true), PrimitiveTuples.pair(3.0f, false));
    }

    @Test
    public void toMap() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<FloatBooleanPair> pairs = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true);
        Assert.assertTrue("[1.0:false, 2.0:true]".equals(collection.toString()) || "[2.0:true, 1.0:false]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Function<FloatBooleanPair, Boolean> function = (FloatBooleanPair object) -> PrimitiveTuples.pair(1.0f, false).equals(object);
        Multimap<Boolean, FloatBooleanPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, false)));
    }

    @Test
    public void groupByEach() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Function<FloatBooleanPair, MutableList<Boolean>> function = (FloatBooleanPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0f, false).equals(object));
        Multimap<Boolean, FloatBooleanPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, false)));
    }

    @Test
    public void zip() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true);
        RichIterable<Pair<FloatBooleanPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, false), 1), Tuples.pair(PrimitiveTuples.pair(2.0f, true), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, true), 1), Tuples.pair(PrimitiveTuples.pair(1.0f, false), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true);
        RichIterable<Pair<FloatBooleanPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, false), 0), Tuples.pair(PrimitiveTuples.pair(2.0f, true), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, true), 0), Tuples.pair(PrimitiveTuples.pair(1.0f, false), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0f, false)), FastList.newListWith(PrimitiveTuples.pair(2.0f, true)), FastList.newListWith(PrimitiveTuples.pair(3.0f, false))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
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
        RichIterable<FloatBooleanPair> notEmpty = this.newWith(1.0f, false);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, FloatBooleanPair> sumAggregator = (AtomicInteger aggregate, FloatBooleanPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 2.0f, true, 3.0f, false);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:false").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:true").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:false").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, FloatBooleanPair, Integer> sumAggregator = (Integer aggregate, FloatBooleanPair value) -> (int) (aggregate + value.getOne());
        RichIterable<FloatBooleanPair> collection = this.newWith(1.0f, false, 1.0f, false, 2.0f, true);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:true").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:false").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatBooleanMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatBooleanMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatBooleanMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractFloatBooleanMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractFloatBooleanMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractFloatBooleanMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractFloatBooleanMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractFloatBooleanMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractFloatBooleanMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractFloatBooleanMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractFloatBooleanMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractFloatBooleanMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractFloatBooleanMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractFloatBooleanMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractFloatBooleanMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractFloatBooleanMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractFloatBooleanMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractFloatBooleanMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractFloatBooleanMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractFloatBooleanMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractFloatBooleanMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractFloatBooleanMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractFloatBooleanMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractFloatBooleanMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractFloatBooleanMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractFloatBooleanMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatBooleanMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatBooleanMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatBooleanMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractFloatBooleanMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractFloatBooleanMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractFloatBooleanMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractFloatBooleanMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractFloatBooleanMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractFloatBooleanMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractFloatBooleanMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractFloatBooleanMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractFloatBooleanMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractFloatBooleanMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractFloatBooleanMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractFloatBooleanMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractFloatBooleanMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractFloatBooleanMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractFloatBooleanMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractFloatBooleanMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractFloatBooleanMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractFloatBooleanMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractFloatBooleanMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractFloatBooleanMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractFloatBooleanMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatBooleanMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatBooleanMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractFloatBooleanMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractFloatBooleanMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractFloatBooleanMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatBooleanMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractFloatBooleanMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractFloatBooleanMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractFloatBooleanMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractFloatBooleanMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractFloatBooleanMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractFloatBooleanMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractFloatBooleanMapKeyValuesViewTestCase::partition;
            this.payloads.partitionWith = AbstractFloatBooleanMapKeyValuesViewTestCase::partitionWith;
            this.payloads.toList = AbstractFloatBooleanMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractFloatBooleanMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractFloatBooleanMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractFloatBooleanMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractFloatBooleanMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractFloatBooleanMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractFloatBooleanMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractFloatBooleanMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractFloatBooleanMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractFloatBooleanMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractFloatBooleanMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractFloatBooleanMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractFloatBooleanMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractFloatBooleanMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractFloatBooleanMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractFloatBooleanMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractFloatBooleanMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractFloatBooleanMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatBooleanMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractFloatBooleanMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractFloatBooleanMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractFloatBooleanMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractFloatBooleanMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractFloatBooleanMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
